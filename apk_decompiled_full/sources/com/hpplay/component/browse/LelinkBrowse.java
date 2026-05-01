package com.hpplay.component.browse;

import com.hpplay.component.common.browse.IBrowseResultListener;
import com.hpplay.component.common.utils.CLog;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class LelinkBrowse extends LelinkBrowseCore implements Runnable {
    private static final String LELINK_HEADER = "LBTP";
    private static final String TAG = "LelinkBrowse";
    private boolean isStart;
    private IBrowseResultListener mBrowseListener;
    private LelinkBrowseTask mBrowseRunnable;
    private LelinkBrowseThread mLelinkBrowseThread;
    private LelinkBrowseThread mThread;

    private void stopBrowseTask() {
        this.isStart = false;
        LelinkBrowseThread lelinkBrowseThread = this.mLelinkBrowseThread;
        if (lelinkBrowseThread != null) {
            lelinkBrowseThread.interrupt();
        }
        LelinkBrowseTask lelinkBrowseTask = this.mBrowseRunnable;
        if (lelinkBrowseTask != null) {
            lelinkBrowseTask.releae();
        }
    }

    public void release() {
        this.isStart = false;
        CLog.i("LelinkBrowseTask", " LelinkBrowse release  ");
        DatagramSocket datagramSocket = this.mBrowseServSocket;
        if (datagramSocket != null) {
            datagramSocket.close();
        }
        LelinkBrowseThread lelinkBrowseThread = this.mThread;
        if (lelinkBrowseThread != null) {
            lelinkBrowseThread.interrupt();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean createUDPServer = createUDPServer();
        this.isStart = createUDPServer;
        if (createUDPServer) {
            this.mBrowseRunnable = new LelinkBrowseTask();
            LelinkBrowseThread lelinkBrowseThread = new LelinkBrowseThread(this.mBrowseRunnable, "LelinkBrowseReceiver");
            this.mLelinkBrowseThread = lelinkBrowseThread;
            lelinkBrowseThread.start();
        }
        while (this.isStart) {
            try {
                this.mBrowseServSocket.receive(this.mReceiverPacket);
                DatagramPacket datagramPacket = this.mReceiverPacket;
                if (datagramPacket != null) {
                    int length = datagramPacket.getLength();
                    byte[] bArr = new byte[length];
                    System.arraycopy(this.mReceiverPacket.getData(), 0, bArr, 0, length);
                    String str = new String(bArr);
                    try {
                        if (str.contains(LELINK_HEADER)) {
                            JSONObject jSONObject = new JSONObject(str.split("\r\n")[2]);
                            IBrowseResultListener iBrowseResultListener = this.mBrowseListener;
                            if (iBrowseResultListener != null) {
                                iBrowseResultListener.onBrowseResultCallback(2, jSONObject);
                            }
                        }
                    } catch (Exception unused) {
                        CLog.w(TAG, "lelink scan paser error ..");
                    }
                }
            } catch (Exception unused2) {
                CLog.w(TAG, "lelink scan stop ..");
            }
        }
        stopBrowseTask();
    }

    public void startBrowse(IBrowseResultListener iBrowseResultListener) {
        LelinkBrowseThread lelinkBrowseThread = this.mLelinkBrowseThread;
        if (lelinkBrowseThread != null) {
            lelinkBrowseThread.interrupt();
        }
        this.mBrowseListener = iBrowseResultListener;
        LelinkBrowseThread lelinkBrowseThread2 = new LelinkBrowseThread(this, "LelinkBrowseSender");
        this.mThread = lelinkBrowseThread2;
        lelinkBrowseThread2.start();
    }
}
