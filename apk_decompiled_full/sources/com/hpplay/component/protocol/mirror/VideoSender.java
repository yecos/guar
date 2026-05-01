package com.hpplay.component.protocol.mirror;

import android.os.ParcelFileDescriptor;
import com.hpplay.component.common.protocol.IMirrorStateListener;
import com.hpplay.component.common.utils.CLog;
import com.hpplay.component.netcore.LelinkNetCore;
import com.hpplay.component.protocol.ProtocolCore;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class VideoSender extends ProtocolCore {
    private static final String TAG = "VideoSender";
    public static final int TIME_OUT = 3000;
    private int len;
    private LelinkNetCore mRudpDataSender;
    private long printType;
    private int sendLen;
    private int mType = 0;
    private byte[] videoData = new byte[AutoStrategy.BITRATE_LOW4];
    private long mTimeout = 0;

    public boolean connect(String str, int i10, int i11) {
        this.mType = i11;
        release();
        if (i11 == 2) {
            return createMirrorSocket(str, i10);
        }
        if (this.mRudpDataSender == null) {
            CLog.i(TAG, "......rudp create......");
            LelinkNetCore lelinkNetCore = new LelinkNetCore();
            this.mRudpDataSender = lelinkNetCore;
            lelinkNetCore.init();
        }
        return this.mRudpDataSender.connect(str, i10) == 0;
    }

    public int getInitBitrate() {
        LelinkNetCore lelinkNetCore = this.mRudpDataSender;
        if (lelinkNetCore != null) {
            return lelinkNetCore.getInitBitrate();
        }
        return 9000000;
    }

    public int getSendType() {
        return this.mType;
    }

    public synchronized void release() {
        CLog.i(TAG, "==============release ==" + this.mType);
        Socket socket = this.mSocket;
        if (socket != null) {
            try {
                try {
                    socket.close();
                    this.mSocket = null;
                    this.mLocalFileOutputStream = null;
                } catch (IOException e10) {
                    CLog.w(TAG, e10);
                    this.mSocket = null;
                    this.mLocalFileOutputStream = null;
                }
                this.mLocalAutoCloseInputStream = null;
            } catch (Throwable th) {
                this.mSocket = null;
                this.mLocalFileOutputStream = null;
                this.mLocalAutoCloseInputStream = null;
                throw th;
            }
        }
        FileOutputStream fileOutputStream = this.mLocalFileOutputStream;
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException e11) {
                CLog.w(TAG, e11);
            }
        }
        ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = this.mLocalAutoCloseInputStream;
        if (autoCloseInputStream != null) {
            try {
                autoCloseInputStream.close();
            } catch (IOException e12) {
                CLog.w(TAG, e12);
            }
        }
        if (this.mRudpDataSender != null) {
            CLog.i(TAG, "......rudp close......");
            this.mRudpDataSender.close();
            this.mRudpDataSender.unInit();
            this.mRudpDataSender = null;
        }
    }

    public void sendData(ByteBuffer byteBuffer) {
        if (System.currentTimeMillis() - this.printType > 3000) {
            StringBuilder sb = new StringBuilder();
            sb.append("==============sendData ==");
            sb.append(this.mType == 2 ? "TCP" : "UDP");
            CLog.i(TAG, sb.toString());
            this.printType = System.currentTimeMillis();
        }
        if (this.mType == 2) {
            this.mLocalFileOutputStream.getChannel().write(byteBuffer);
            this.mLocalFileOutputStream.flush();
            return;
        }
        int remaining = byteBuffer.remaining();
        this.len = remaining;
        byteBuffer.get(this.videoData, 0, remaining);
        int send = this.mRudpDataSender.send(this.videoData, this.len);
        this.sendLen = send;
        if (send == 0 && this.mTimeout == 0) {
            this.mTimeout = System.currentTimeMillis();
        } else if (send > 0) {
            this.mTimeout = System.currentTimeMillis();
        }
        if (System.currentTimeMillis() - this.mTimeout > 3000) {
            throw new Exception("RUDP send data error ...");
        }
    }

    public void setMirrorStateListener(IMirrorStateListener iMirrorStateListener) {
        LelinkNetCore lelinkNetCore = this.mRudpDataSender;
        if (lelinkNetCore != null) {
            lelinkNetCore.setMirrorStateListener(iMirrorStateListener);
        }
    }
}
