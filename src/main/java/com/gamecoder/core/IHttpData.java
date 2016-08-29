package com.gamecoder.core;

import io.netty.channel.Channel;
import io.netty.handler.codec.http.FullHttpRequest;

/**
 * IHttpData
 *
 * @author Cuizw
 * @date 2016/8/29 0029
 */
public interface IHttpData {
    void onData(FullHttpRequest request, Channel channel);
}
