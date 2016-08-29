package com.gamecoder.core.rpc;

import com.gamecoder.core.*;

import java.util.Optional;

/**
 * TcpBootHandler
 *
 * @author Cuizw
 * @date 2016/8/29 0029
 */
public class RpcBootHandler {
    private Optional<Initor> initor;
    private IHttpData httpData;

    public RpcBootHandler(Optional<Initor> initor, IHttpData httpData) {
        this.initor = initor;
        this.httpData = httpData;
    }

    public Optional<Initor> getInitor() {
        return initor;
    }

    public void setInitor(Optional<Initor> initor) {
        this.initor = initor;
    }

    public IHttpData getHttpData() {
        return httpData;
    }

    public void setHttpData(IHttpData httpData) {
        this.httpData = httpData;
    }
}
