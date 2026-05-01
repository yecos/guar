package com.hpplay.component.protocol.mirror;

import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.google.common.primitives.UnsignedBytes;
import com.hpplay.component.common.utils.CLog;
import com.hpplay.component.protocol.ProtocolCore;
import com.hpplay.component.protocol.ProtocolUtils;
import com.uc.crashsdk.export.LogType;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes2.dex */
public class AudioDataSender extends Thread {
    private static final int MAX_FRAME_SIZE = 60;
    private static final String TAG = "AudioDataSender";
    private static final int TIME_OUT = 5000;
    private boolean isQuit;
    private boolean isUdpChannel;
    private DatagramSocket mDatagramSocket;
    private DatagramPacket mPacket;
    private ProtocolCore mProtocolCore;
    private long mSn;
    private long mStartPts;
    private final BlockingQueue<byte[]> mVideoDataQueue = new LinkedBlockingQueue(10);
    private byte[] mHeader = new byte[12];
    private byte[] sendData = new byte[LogType.ANR];

    public AudioDataSender(String str, String str2, int i10) {
        setName(TAG);
        boolean equals = TextUtils.equals(str, "1");
        this.isUdpChannel = equals;
        if (!equals) {
            CLog.i(TAG, " audio use tcp channel ..." + str);
            ProtocolCore protocolCore = new ProtocolCore();
            this.mProtocolCore = protocolCore;
            protocolCore.mIP = str2;
            protocolCore.mPort = i10;
            return;
        }
        CLog.i(TAG, " audio use udp channel ..." + str);
        try {
            this.mDatagramSocket = new DatagramSocket((SocketAddress) null);
            this.mPacket = new DatagramPacket(new byte[]{0}, 1, InetAddress.getByName(str2), i10);
        } catch (Exception e10) {
            CLog.w(TAG, e10);
        }
    }

    public void putAudioData(byte[] bArr, int i10, int i11) {
        if (this.mVideoDataQueue.size() > 60) {
            this.mVideoDataQueue.poll();
        }
        byte[] bArr2 = new byte[i11];
        System.arraycopy(bArr, i10, bArr2, 0, i11);
        this.mVideoDataQueue.offer(bArr2);
    }

    public synchronized void release() {
        ProtocolCore protocolCore;
        CLog.i(TAG, " AudioDataSender release ...");
        if (this.isUdpChannel) {
            try {
                DatagramSocket datagramSocket = this.mDatagramSocket;
                if (datagramSocket != null) {
                    datagramSocket.close();
                    this.mVideoDataQueue.clear();
                }
            } catch (Exception e10) {
                CLog.w(TAG, e10);
            }
        } else {
            Socket socket = this.mProtocolCore.mSocket;
            if (socket != null) {
                try {
                    try {
                        socket.close();
                        protocolCore = this.mProtocolCore;
                        protocolCore.mSocket = null;
                        protocolCore.mLocalFileOutputStream = null;
                    } catch (IOException e11) {
                        CLog.w(TAG, e11);
                        protocolCore = this.mProtocolCore;
                        protocolCore.mSocket = null;
                        protocolCore.mLocalFileOutputStream = null;
                    }
                    protocolCore.mLocalAutoCloseInputStream = null;
                } catch (Throwable th) {
                    ProtocolCore protocolCore2 = this.mProtocolCore;
                    protocolCore2.mSocket = null;
                    protocolCore2.mLocalFileOutputStream = null;
                    protocolCore2.mLocalAutoCloseInputStream = null;
                    throw th;
                }
            }
            FileOutputStream fileOutputStream = this.mProtocolCore.mLocalFileOutputStream;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e12) {
                    CLog.w(TAG, e12);
                }
            }
            ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = this.mProtocolCore.mLocalAutoCloseInputStream;
            if (autoCloseInputStream != null) {
                try {
                    autoCloseInputStream.close();
                } catch (IOException e13) {
                    CLog.w(TAG, e13);
                }
            }
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        try {
        } catch (Exception e10) {
            CLog.w(TAG, e10);
        }
        if (!this.isUdpChannel && !this.mProtocolCore.connectServer(5000)) {
            CLog.i(TAG, "TCP Channel connect failed ...");
            return;
        }
        while (!isInterrupted()) {
            sendData(this.mVideoDataQueue.take());
        }
        release();
    }

    public void sendData(byte[] bArr) {
        try {
            byte[] intToBytes = ProtocolUtils.intToBytes(bArr.length);
            byte[] bArr2 = this.mHeader;
            bArr2[0] = UnsignedBytes.MAX_POWER_OF_TWO;
            bArr2[1] = 96;
            long j10 = this.mSn + 1;
            this.mSn = j10;
            bArr2[2] = (byte) (j10 >> 8);
            bArr2[3] = (byte) j10;
            long j11 = this.mStartPts + 480;
            this.mStartPts = j11;
            bArr2[4] = (byte) (j11 >> 24);
            bArr2[5] = (byte) (j11 >> 16);
            bArr2[6] = (byte) (j11 >> 8);
            bArr2[7] = (byte) j11;
            bArr2[8] = intToBytes[0];
            bArr2[9] = intToBytes[1];
            bArr2[10] = intToBytes[2];
            bArr2[11] = intToBytes[3];
            System.arraycopy(bArr2, 0, this.sendData, 0, bArr2.length);
            System.arraycopy(bArr, 0, this.sendData, this.mHeader.length, bArr.length);
            if (this.isUdpChannel) {
                this.mPacket.setData(this.sendData, 0, this.mHeader.length + bArr.length);
                this.mDatagramSocket.send(this.mPacket);
            } else {
                this.mProtocolCore.mLocalFileOutputStream.write(this.sendData, 0, this.mHeader.length + bArr.length);
                this.mProtocolCore.mLocalFileOutputStream.flush();
            }
        } catch (Exception e10) {
            CLog.w(TAG, e10);
        }
    }

    public void stopTask() {
        interrupt();
    }
}
