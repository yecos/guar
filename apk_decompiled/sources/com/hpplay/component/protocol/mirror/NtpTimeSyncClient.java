package com.hpplay.component.protocol.mirror;

import com.hpplay.component.common.utils.CLog;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class NtpTimeSyncClient implements Runnable {
    private static final int NTP_PORT = 27876;
    private static final String TAG = "NtpTimeSyncClient";
    private static NtpTimeSyncClient mNtpSyncClient;
    public DatagramSocket mBrowseServSocket;
    private String mIp;
    private int mPort;
    private Thread mThread;

    public static synchronized NtpTimeSyncClient getInstance() {
        NtpTimeSyncClient ntpTimeSyncClient;
        synchronized (NtpTimeSyncClient.class) {
            if (mNtpSyncClient == null) {
                mNtpSyncClient = new NtpTimeSyncClient();
            }
            ntpTimeSyncClient = mNtpSyncClient;
        }
        return ntpTimeSyncClient;
    }

    private ByteBuffer getNTPPacket() {
        ByteBuffer allocate = ByteBuffer.allocate(48);
        long nanoTime = System.nanoTime();
        allocate.put((byte) 0);
        allocate.put((byte) 0);
        allocate.put((byte) 0);
        allocate.put((byte) 0);
        allocate.put((byte) 0);
        allocate.putInt(0);
        allocate.putInt(0);
        allocate.putLong(0L);
        allocate.putLong(0L);
        allocate.putLong(0L);
        allocate.putLong(nanoTime);
        return allocate;
    }

    public static byte[] longToBytes(long j10) {
        return new byte[]{(byte) ((j10 >> 56) & 255), (byte) ((j10 >> 48) & 255), (byte) ((j10 >> 40) & 255), (byte) ((j10 >> 32) & 255), (byte) ((j10 >> 24) & 255), (byte) ((j10 >> 16) & 255), (byte) ((j10 >> 8) & 255), (byte) (j10 & 255)};
    }

    public boolean createUDPServer() {
        try {
            DatagramSocket datagramSocket = new DatagramSocket((SocketAddress) null);
            this.mBrowseServSocket = datagramSocket;
            datagramSocket.setReuseAddress(true);
            this.mBrowseServSocket.bind(new InetSocketAddress(NTP_PORT));
            return true;
        } catch (SocketException e10) {
            CLog.w(TAG, e10);
            return false;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean createUDPServer = createUDPServer();
        DatagramPacket datagramPacket = new DatagramPacket(new byte[128], 128);
        if (createUDPServer) {
            try {
                byte[] bArr = new byte[48];
                getNTPPacket().get(bArr);
                DatagramPacket datagramPacket2 = new DatagramPacket(bArr, 48);
                datagramPacket2.setPort(this.mPort);
                datagramPacket2.setAddress(InetAddress.getByName(this.mIp));
                this.mBrowseServSocket.send(datagramPacket2);
            } catch (Exception e10) {
                CLog.w(TAG, e10);
            }
        }
        while (createUDPServer) {
            try {
                this.mBrowseServSocket.receive(datagramPacket);
            } catch (Exception e11) {
                CLog.w(TAG, e11);
            }
        }
    }

    public void setServerInfo(String str, int i10) {
        this.mIp = str;
        this.mPort = i10;
    }

    public void startNtpSync() {
        if (this.mThread != null) {
            stopNTPSync();
        }
        if (this.mThread == null) {
            Thread thread = new Thread(this);
            this.mThread = thread;
            thread.start();
        }
    }

    public void stopNTPSync() {
        Thread thread = this.mThread;
        if (thread != null) {
            thread.interrupt();
        }
    }
}
