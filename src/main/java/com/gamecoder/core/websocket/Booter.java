package com.gamecoder.core.websocket;

import com.gamecoder.util.ConfigEntry;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * Booter
 *
 * @author Cuizw
 * @date 2016/8/29 0029
 */
public class Booter {
    public void start(final ConfigEntry config, final WebSocketBootHandler param) throws Exception{
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .option(ChannelOption.SO_KEEPALIVE,true)
                    .option(ChannelOption.TCP_NODELAY,true)
                    .channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.ERROR))
                    .childHandler(new ServerInitializer(param));


            if(param.getInitor().isPresent()){
                param.getInitor().get().run();
            }

            String IP = config.getValue("IP");
            int PORT = config.getValue("PORT");

            Channel ch = b.bind(IP,PORT).sync().channel();

            System.out.println("WebSocket Server Listen on:" + PORT );
            ch.closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
