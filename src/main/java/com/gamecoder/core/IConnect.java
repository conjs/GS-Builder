package com.gamecoder.core;

import io.netty.channel.Channel;

/**
 * 连接时触发
 *
 * @author Cuizw
 * @date 2016/8/29 0029
 */
public interface IConnect {
    void onConnect(Channel channel);
}
