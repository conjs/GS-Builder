import com.gamecoder.boot.Booter;
import com.gamecoder.boot.ServerMessage;
import com.gamecoder.core.*;
import com.gamecoder.util.ConfigEntry;
import io.netty.channel.Channel;

import java.util.Optional;

/**
 * Tester
 *
 * @author Cuizw
 * @date 2016/8/29 0029
 */
public class Tester {
    public void start() throws Exception{
        //Boot Param
        ConfigEntry conf = new ConfigEntry().builder("IP","127.0.0.1").builder("PORT",8888);

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

        //Start
        new Booter().start(conf,new BootHandler(Optional.empty(),connecter,disconnect,onData));

    }

    //log
    public void log(Object data){
        System.out.println(data);
    }

    //main
    public static void main(String[] args) throws Exception{
        new Tester().start();
    }
}
