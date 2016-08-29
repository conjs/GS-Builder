package com.gamecoder.boot;

import com.gamecoder.core.BootHandler;
import com.gamecoder.util.ConfigEntry;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * ServerInitializer
 *
 * @author Cuizw
 * @date 2016/8/29 0029
 */
public class ServerInitializer extends ChannelInitializer<SocketChannel> {
    private final BootHandler param;
    private final ConfigEntry config;
    public ServerInitializer(ConfigEntry config, BootHandler param){
        this.param = param;
        this.config = config;
    }


    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new MessageCodec());
        pipeline.addLast(new ServerHandler(param.getConnect(),param.getDisconnect(),param.getData()));
    }
}
