package com.hpplay.component.protocol.connection;

import android.os.ParcelFileDescriptor;
import com.hpplay.component.common.SourceModule;
import com.hpplay.component.common.protocol.ProtocolListener;
import com.hpplay.component.common.utils.CLog;
import com.hpplay.component.protocol.ProtocolSender;

/* loaded from: classes2.dex */
public class DisconnectionMonitor extends Thread {
    private static final String TAG = "DisconnectionMonitor";
    private boolean isRunning;
    private ProtocolListener mProtocolListener;
    private ProtocolSender mProtocolSender;

    public DisconnectionMonitor(ProtocolSender protocolSender, ProtocolListener protocolListener) {
        this.mProtocolSender = protocolSender;
        this.mProtocolListener = protocolListener;
        setName(TAG);
    }

    public synchronized void onDisconnect() {
        try {
            if (this.isRunning && this.mProtocolListener != null) {
                CLog.i(TAG, "disconnect callback");
                this.mProtocolListener.onResult(11, SourceModule.RESULT_CONNECTION_DISCONNECT);
            }
            release();
        } catch (Exception e10) {
            CLog.w(TAG, e10);
        }
    }

    public synchronized void release() {
        CLog.i(TAG, "DisconnectionMonitor release");
        this.isRunning = false;
        ProtocolSender protocolSender = this.mProtocolSender;
        if (protocolSender != null) {
            protocolSender.release();
            this.mProtocolSender = null;
        }
        this.mProtocolListener = null;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        try {
            ParcelFileDescriptor.AutoCloseInputStream inputStream = this.mProtocolSender.getInputStream();
            byte[] bArr = new byte[128];
            if (inputStream != null) {
                this.isRunning = true;
            }
            CLog.i(TAG, "DisconnectionMonitor start running");
            while (this.isRunning) {
                int read = inputStream.read(bArr);
                CLog.i(TAG, "read keep alive data " + read);
                if (read == -1) {
                    onDisconnect();
                    return;
                }
                CLog.i(TAG, "read keep alive data " + read);
            }
        } catch (Exception e10) {
            onDisconnect();
            CLog.w(TAG, e10);
        }
    }
}
