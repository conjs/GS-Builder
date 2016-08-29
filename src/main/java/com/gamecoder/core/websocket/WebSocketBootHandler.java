package com.gamecoder.core.websocket;

import com.gamecoder.core.*;

import java.util.Optional;

/**
 * TcpBootHandler
 *
 * @author Cuizw
 * @date 2016/8/29 0029
 */
public class WebSocketBootHandler {
    private Optional<Initor> initor;
    private IConnect connect;
    private IDisconnect disconnect;
    private IWebSocketData webSocketData;
    private IHttpData httpData;

    public WebSocketBootHandler(Optional<Initor> initor, IConnect connect, IDisconnect disconnect, IWebSocketData webSocketData, IHttpData httpData) {
        this.initor = initor;
        this.connect = connect;
        this.disconnect = disconnect;
        this.webSocketData = webSocketData;
        this.httpData = httpData;
    }

    public Optional<Initor> getInitor() {
        return initor;
    }

    public void setInitor(Optional<Initor> initor) {
        this.initor = initor;
    }

    public IConnect getConnect() {
        return connect;
    }

    public void setConnect(IConnect connect) {
        this.connect = connect;
    }

    public IDisconnect getDisconnect() {
        return disconnect;
    }

    public void setDisconnect(IDisconnect disconnect) {
        this.disconnect = disconnect;
    }

    public IWebSocketData getWebSocketData() {
        return webSocketData;
    }

    public void setWebSocketData(IWebSocketData webSocketData) {
        this.webSocketData = webSocketData;
    }

    public IHttpData getHttpData() {
        return httpData;
    }

    public void setHttpData(IHttpData httpData) {
        this.httpData = httpData;
    }
}
