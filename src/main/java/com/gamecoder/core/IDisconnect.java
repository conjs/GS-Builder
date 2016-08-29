package com.gamecoder.core;

import io.netty.channel.Channel;

/**
 * 断开连接时触发
 *
 * @author Cuizw
 * @date 2016/8/29 0029
 */
public interface IDisconnect {
    void onDisconnect(Channel channel);
}
