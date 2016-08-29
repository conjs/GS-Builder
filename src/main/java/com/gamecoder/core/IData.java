package com.gamecoder.core;

import com.gamecoder.tcp.ServerMessage;
import io.netty.channel.Channel;

/**
 * 收到消息时触发
 *
 * @author Cuizw
 * @date 2016/8/29 0029
 */
public interface IData {
    void onData(ServerMessage message, Channel channel);
}
