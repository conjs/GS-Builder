package com.gamecoder.core.tcp;

import com.gamecoder.core.IConnect;
import com.gamecoder.core.IData;
import com.gamecoder.core.IDisconnect;
import com.gamecoder.core.Initor;

import java.util.Optional;

/**
 * TcpBootHandler
 *
 * @author Cuizw
 * @date 2016/8/29 0029
 */
public class TcpBootHandler {
    private Optional<Initor> initor;
    private IConnect connect;
    private IDisconnect disconnect;
    private IData data;

    public TcpBootHandler(Optional<Initor> initor, IConnect connect, IDisconnect disconnect, IData data) {
        this.initor = initor;
        this.connect = connect;
        this.disconnect = disconnect;
        this.data = data;
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

    public IData getData() {
        return data;
    }

    public void setData(IData data) {
        this.data = data;
    }
}
