package com.gamecoder.tcp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * ServerMessage
 *
 * @author Cuizw
 * @date 2016/8/29 0029
 */
public class ServerMessage {
    private short protocol;
    private byte[] data;


    public ServerMessage unpack (ByteBuf buf){
        this.protocol = buf.readShort();
        int len = buf.readableBytes();
        this.data = buf.readBytes(new byte[len]).array();
        return this;
    }

    /**
     *
     * @return
     */
    public byte[] pack(){
        ByteBuf buf = Unpooled.buffer();
        int dataLen = data.length;
        buf.writeInt(dataLen+2);
        buf.writeShort(protocol);
        buf.writeBytes(data);
        return buf.array();
    }


    public short getProtocol() {
        return protocol;
    }

    public void setProtocol(short protocol) {
        this.protocol = protocol;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }
}
