package com.hpplay.component.protocol.mirror;

import android.text.TextUtils;
import com.hpplay.component.common.protocol.IMirrorStateListener;
import com.hpplay.component.common.utils.CLog;
import com.hpplay.component.modulelinker.api.ModuleLinker;
import com.hpplay.component.protocol.ProtocolCore;
import com.hpplay.component.protocol.ProtocolUtils;
import com.hpplay.component.protocol.server.IRequstManager;
import com.hpplay.component.protocol.server.RequestHandler;
import com.hpplay.component.protocol.server.RequestManagerImp;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/* loaded from: classes2.dex */
public class MirrorEventReceiver extends ProtocolCore implements Runnable {
    private static final String TAG = "MirrorEventReceiver";
    private boolean isSpacialChannel;
    private boolean isStart;
    private String mIp;
    private IMirrorStateListener mMirrorStateListener;
    private int mPort;
    private MirrorServStartListener mStartListener;
    private Thread serverThread;
    private byte[] local = {49, 50, 55, 46, 48, 46, 48, 46, 49};
    public int mSpacailPort = 51119;
    private int mEventPort = 10356;
    private IRequstManager mRequstManager = new RequestManagerImp();

    public interface MirrorServStartListener {
        void onStart(MirrorEventReceiver mirrorEventReceiver);
    }

    public MirrorEventReceiver(IMirrorStateListener iMirrorStateListener, boolean z10) {
        this.mMirrorStateListener = iMirrorStateListener;
        this.isSpacialChannel = z10;
    }

    public void closeAllChannel() {
        IRequstManager iRequstManager = this.mRequstManager;
        if (iRequstManager != null) {
            iRequstManager.closeAll();
        }
    }

    public int genMirrorEventPort() {
        if (ProtocolUtils.checkLoaclPort(this.mEventPort)) {
            this.mEventPort += new Random().nextInt(100);
        }
        return this.mEventPort;
    }

    public IMirrorStateListener genMirrorStateListener() {
        return this.mMirrorStateListener;
    }

    public String getIP() {
        if (TextUtils.isEmpty(this.mIp)) {
            this.mIp = new String(this.local);
        }
        return this.mIp;
    }

    public String getMirrorEnventIP() {
        String loaclIp;
        if (ProtocolUtils.isNetworkConnected(ModuleLinker.getInstance().getContext())) {
            loaclIp = ProtocolUtils.getWifiIp();
            CLog.i(TAG, "wifi   ip  " + loaclIp.replace(".", "") + "    LoaclIp  ");
            if (TextUtils.isEmpty(loaclIp)) {
                loaclIp = ProtocolUtils.getLoaclIp();
            }
        } else {
            CLog.i(TAG, "use moble host ip  ");
            loaclIp = ProtocolUtils.getLoaclIp();
        }
        CLog.i(TAG, "use realIp " + loaclIp);
        return loaclIp;
    }

    public int getMirrorEventPort() {
        return this.mEventPort;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean createMirrorEventServer = createMirrorEventServer(null, genMirrorEventPort());
        this.isStart = createMirrorEventServer;
        if (!createMirrorEventServer) {
            for (int i10 = 0; i10 < 5; i10++) {
                int nextInt = this.mEventPort + new Random().nextInt(10000);
                this.mEventPort = nextInt;
                boolean createMirrorEventServer2 = createMirrorEventServer(null, nextInt);
                this.isStart = createMirrorEventServer2;
                if (createMirrorEventServer2) {
                    break;
                }
            }
        }
        CLog.i(TAG, "start state  " + this.isStart + " " + this.mEventPort);
        MirrorServStartListener mirrorServStartListener = this.mStartListener;
        if (mirrorServStartListener != null) {
            mirrorServStartListener.onStart(this);
        }
        while (this.isStart) {
            try {
                Socket accept = this.mMirrorEventServer.accept();
                InputStream inputStream = accept.getInputStream();
                CLog.i(TAG, "new connection");
                if (this.isSpacialChannel) {
                    this.mRequstManager.closeAll();
                } else {
                    IRequstManager iRequstManager = this.mRequstManager;
                    iRequstManager.exec(new RequestHandler(iRequstManager, this.mMirrorStateListener, inputStream, accept));
                }
            } catch (IOException e10) {
                CLog.w(TAG, e10);
            }
        }
        CLog.i(TAG, "mirror event server stopped ...");
    }

    public void setMirrorServStartListener(MirrorServStartListener mirrorServStartListener) {
        this.mStartListener = mirrorServStartListener;
    }

    public void startServer() {
        Thread thread = new Thread(this);
        this.serverThread = thread;
        thread.setDaemon(true);
        this.serverThread.setName("EventServer");
        this.serverThread.start();
    }

    public void stopServer() {
        CLog.i(TAG, "stop mirror event server ...");
        IRequstManager iRequstManager = this.mRequstManager;
        if (iRequstManager != null) {
            iRequstManager.closeAll();
        }
        ServerSocket serverSocket = this.mMirrorEventServer;
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (IOException e10) {
                CLog.w(TAG, e10);
            }
        }
        this.mMirrorStateListener = null;
        this.isStart = false;
        IRequstManager iRequstManager2 = this.mRequstManager;
        if (iRequstManager2 != null) {
            iRequstManager2.closeAll();
        }
        Thread thread = this.serverThread;
        if (thread != null) {
            thread.interrupt();
        }
    }
}
