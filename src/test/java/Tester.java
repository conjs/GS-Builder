
import com.gamecoder.rpc.RpcBootHandler;
import com.gamecoder.rpc.RpcHandler;
import com.gamecoder.tcp.ServerMessage;
import com.gamecoder.core.*;
import com.gamecoder.tcp.TcpBootHandler;
import com.gamecoder.util.ConfigEntry;
import com.gamecoder.websocket.WebSocketBootHandler;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

import java.util.Optional;

/**
 * Tester
 *
 * @author Cuizw
 * @date 2016/8/29 0029
 */
public class Tester {
    public void startTcp() throws Exception{
        //Boot Param
        ConfigEntry conf = ConfigEntry.build().builder("IP","127.0.0.1").builder("PORT",7777);

        //onConnect
        IConnect connecter = new IConnect() {
            @Override
            public void onConnect(Channel channel) {
                log(":: onConnect ::");
            }
        };

        //onDisconnect
        IDisconnect disconnect = new IDisconnect() {
            @Override
            public void onDisconnect(Channel channel) {
                log(":: onDisConnect ::");
            }
        };


        //onMessageReceived
        IData onData = new IData() {
            @Override
            public void onData(ServerMessage message, Channel channel) {
                log(":: onMessageRecive ::");
            }
        };

        //Start Tcp Server
        new com.gamecoder.tcp.Booter().start(conf,new TcpBootHandler(Optional.empty(),connecter,disconnect,onData));
    }

    public void startWebSocket() throws Exception{
        //Boot Param
        ConfigEntry conf = ConfigEntry.build().builder("IP","127.0.0.1").builder("PORT",8888);

        //onConnect
        IConnect connecter = new IConnect() {
            @Override
            public void onConnect(Channel channel) {
                log(":: onConnect ::");
            }
        };

        //onDisconnect
        IDisconnect disconnect = new IDisconnect() {
            @Override
            public void onDisconnect(Channel channel) {
                log(":: onDisConnect ::");
            }
        };

        //on Http MessageReceived
        IHttpData httpData = new IHttpData() {
            @Override
            public void onData(FullHttpRequest request, Channel channel) {
                log(":: onHttpMessageReceived ::");
            }
        };

        //on Websocket MessageReceived
        IWebSocketData webSocketData = new IWebSocketData() {
            @Override
            public void onData(ChannelHandlerContext ctx, String data) {
                log(":: onWebSocketMessageReceived ::");
            }
        };

        //Start WebSocket Server
        new com.gamecoder.websocket.Booter().start(conf,new WebSocketBootHandler(Optional.empty(),connecter,disconnect,webSocketData,httpData));
    }


    public void startRpc() throws Exception{
        //Boot Param
        ConfigEntry conf = ConfigEntry.build().builder("IP","127.0.0.1").builder("PORT",9999);

        //on Http MessageReceived
        IHttpData httpData = new IHttpData() {
            @Override
            public void onData(FullHttpRequest request, Channel channel) {
                log(":: onHttpMessageReceived ::");
            }
        };

        //Start Rpc Server
        new com.gamecoder.rpc.Booter().start(conf,new RpcBootHandler(Optional.empty(),httpData));
    }


    //log
    public void log(Object data){
        System.out.println(data);
    }

    //main
    public static void main(String[] args) throws Exception{
        Tester test = new Tester();
        test.startTcp();//start tcp server
        test.startWebSocket();//start websocket server
        test.startRpc(); //start rpc server
    }
}
