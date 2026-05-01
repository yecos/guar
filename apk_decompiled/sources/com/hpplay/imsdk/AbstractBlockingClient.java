package com.hpplay.imsdk;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.hpplay.common.asyncmanager.AsyncManager;
import com.hpplay.common.log.LeLog;
import h3.b;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Observable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public abstract class AbstractBlockingClient extends Observable implements Runnable {
    private static short DEFAULT_MESSAGE_SIZE = 8192;
    private final String TAG;
    protected final String appid;
    protected String capability;
    private final int defaultBufferSize;
    private int defaultSocketTimeOut;
    private long heartBeatTimeOut;
    private final AtomicReference<DataInputStream> in;
    private Runnable mHeartRunnable;
    private AsyncTask mHeartTask;
    private OnConnectServerListener mListener;
    private final AtomicReference<DataOutputStream> out;
    protected final int port;
    protected final String server;
    private final AtomicReference<State> state;
    protected final String token;
    protected final String uid;

    public class HeartbeatTask implements Runnable {
        public HeartbeatTask() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (AbstractBlockingClient.this.state.get() == State.RUNNING) {
                try {
                    Thread.sleep(AbstractBlockingClient.this.heartBeatTimeOut);
                    try {
                        AbstractBlockingClient.this.heartBeatWrite();
                    } catch (Exception e10) {
                        LeLog.w("IM_AbstractBlockingClient", "heartBeatWrite Exception " + e10);
                        AbstractBlockingClient.this.state.set(State.STOPPED);
                    }
                } catch (Exception e11) {
                    LeLog.w("IM_AbstractBlockingClient", "HeartbeatTask Exception " + e11);
                }
            }
            LeLog.w("IM_AbstractBlockingClient", "heartBeatWrite end");
        }
    }

    public enum State {
        STOPPED,
        STOPPING,
        RUNNING
    }

    public AbstractBlockingClient(String str, int i10, String str2, String str3, String str4, String str5) {
        this(str, i10, str2, str3, str4, str5, DEFAULT_MESSAGE_SIZE);
    }

    private void dispatchMsg(String str) {
        if (TextUtils.isEmpty(str)) {
            LeLog.w("IM_AbstractBlockingClient", "dispatchMsg,values is invalid");
            return;
        }
        String[] split = str.split(",");
        try {
            long longValue = Long.valueOf(split[0], 16).longValue();
            LeLog.i("IM_AbstractBlockingClient", "run action: " + longValue);
            messageReceived(longValue, str.substring(split[0].length() + 1));
        } catch (Exception e10) {
            LeLog.w("IM_AbstractBlockingClient", "run analysis msg failed " + e10);
        }
    }

    private int getGameCode(String str) {
        int i10 = 0;
        for (byte b10 : str.getBytes()) {
            i10 += b10;
        }
        return i10;
    }

    private void handlePackageBody(byte[] bArr, int i10) {
        byte[] tail = BruteForceCoding.tail(bArr, 16, i10 - 16);
        long decodeIntBigEndian = BruteForceCoding.decodeIntBigEndian(bArr, 8, 4);
        if (3 == decodeIntBigEndian) {
            heartBeatReceived();
            updateHeartInterval(new String(tail));
            return;
        }
        if (8 == decodeIntBigEndian) {
            OnConnectServerListener onConnectServerListener = this.mListener;
            if (onConnectServerListener != null) {
                onConnectServerListener.onAuthCallback(new String(tail));
            }
            heartBeat();
            return;
        }
        if (16 == decodeIntBigEndian) {
            LeLog.i("IM_AbstractBlockingClient", "updateCapabilityWrite replay");
            return;
        }
        if (decodeIntBigEndian != 17) {
            if (decodeIntBigEndian != 19) {
                dispatchMsg(new String(tail));
                return;
            } else {
                LeLog.i("IM_AbstractBlockingClient", "ping msg");
                ackPingMsgWrite(20, BruteForceCoding.decodeIntBigEndian(bArr, 12, 4));
                return;
            }
        }
        String str = null;
        try {
            JSONObject jSONObject = new JSONObject(new String(tail));
            str = jSONObject.getString("msgid");
            dispatchMsg(jSONObject.getString("msgBody"));
        } catch (Exception e10) {
            LeLog.w("IM_AbstractBlockingClient", e10);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ackMsgWrite(18, str);
    }

    private void heartBeat() {
        stopHeartBeat();
        if (this.heartBeatTimeOut <= 0) {
            LeLog.w("IM_AbstractBlockingClient", "invalid heart interval " + this.heartBeatTimeOut + "  use default value instead");
            this.heartBeatTimeOut = TimeUnit.SECONDS.toMillis(50L);
        }
        LeLog.i("IM_AbstractBlockingClient", "heartBeat after " + this.heartBeatTimeOut);
        this.mHeartRunnable = new HeartbeatTask();
        this.mHeartTask = AsyncManager.getInstance().exeRunnable(this.mHeartRunnable, null);
    }

    private void restart() {
        super.setChanged();
        LeLog.i("IM_AbstractBlockingClient", "restart");
        stopHeartBeat();
        notifyObservers();
    }

    private void stopHeartBeat() {
        LeLog.i("IM_AbstractBlockingClient", "stopHeartBeat " + this.mHeartTask);
        AsyncTask asyncTask = this.mHeartTask;
        if (asyncTask != null) {
            try {
                asyncTask.cancel(true);
            } catch (Exception e10) {
                LeLog.w("IM_AbstractBlockingClient", e10);
            }
            this.mHeartTask = null;
        }
    }

    private void updateHeartInterval(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            int optInt = new JSONObject(str).optInt("h");
            if (optInt > 0) {
                long millis = TimeUnit.SECONDS.toMillis(optInt);
                if (this.heartBeatTimeOut != millis) {
                    LeLog.i("IM_AbstractBlockingClient", "updateHeartInterval unEqual interval,update heartBeat");
                    this.heartBeatTimeOut = millis;
                }
            } else {
                LeLog.i("IM_AbstractBlockingClient", "updateHeartInterval failed");
            }
        } catch (Exception e10) {
            LeLog.w("IM_AbstractBlockingClient", e10);
        }
    }

    public synchronized Boolean ackMsgWrite(int i10, String str) {
        LeLog.i("IM_AbstractBlockingClient", "ackMsgWrite,msgID " + str);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.putOpt("msgid", str);
            String jSONObject2 = jSONObject.toString();
            byte[] bArr = new byte[16];
            BruteForceCoding.encodeIntBigEndian(bArr, 1L, BruteForceCoding.encodeIntBigEndian(bArr, i10, BruteForceCoding.encodeIntBigEndian(bArr, 1L, BruteForceCoding.encodeIntBigEndian(bArr, 16L, BruteForceCoding.encodeIntBigEndian(bArr, jSONObject2.getBytes().length + 16, 0, 4), 2), 2), 4), 4);
            this.out.get().write(BruteForceCoding.add(bArr, jSONObject2.getBytes()));
            this.out.get().flush();
            LeLog.i("IM_AbstractBlockingClient", "ackMsgWrite,ok ");
        } catch (Exception e10) {
            LeLog.w("IM_AbstractBlockingClient", e10);
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public synchronized Boolean ackPingMsgWrite(int i10, long j10) {
        LeLog.i("IM_AbstractBlockingClient", "ackPingMsgWrite,msgID " + j10);
        try {
            byte[] bArr = new byte[16];
            BruteForceCoding.encodeIntBigEndian(bArr, j10, BruteForceCoding.encodeIntBigEndian(bArr, i10, BruteForceCoding.encodeIntBigEndian(bArr, 1L, BruteForceCoding.encodeIntBigEndian(bArr, 16L, BruteForceCoding.encodeIntBigEndian(bArr, 16, 0, 4), 2), 2), 4), 4);
            this.out.get().write(bArr);
            this.out.get().flush();
            LeLog.i("IM_AbstractBlockingClient", "ackPingMsgWrite,ok ");
        } catch (Exception e10) {
            LeLog.w("IM_AbstractBlockingClient", e10);
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public synchronized Boolean authWrite() {
        String str = this.uid + ";" + this.capability + ";" + this.appid + ";" + this.token;
        byte[] bArr = new byte[16];
        BruteForceCoding.encodeIntBigEndian(bArr, 1L, BruteForceCoding.encodeIntBigEndian(bArr, 7L, BruteForceCoding.encodeIntBigEndian(bArr, 1L, BruteForceCoding.encodeIntBigEndian(bArr, 16L, BruteForceCoding.encodeIntBigEndian(bArr, str.getBytes().length + 16, 0, 4), 2), 2), 4), 4);
        this.out.get().write(BruteForceCoding.add(bArr, str.getBytes()));
        this.out.get().flush();
        return Boolean.TRUE;
    }

    public abstract void connected(boolean z10);

    public abstract void disconnected();

    public int getPort() {
        return this.port;
    }

    public String getServer() {
        return this.server;
    }

    public abstract void heartBeatReceived();

    public synchronized Boolean heartBeatWrite() {
        String str = this.uid;
        byte[] bArr = new byte[16];
        BruteForceCoding.encodeIntBigEndian(bArr, 1L, BruteForceCoding.encodeIntBigEndian(bArr, 2L, BruteForceCoding.encodeIntBigEndian(bArr, 1L, BruteForceCoding.encodeIntBigEndian(bArr, 16L, BruteForceCoding.encodeIntBigEndian(bArr, str.getBytes().length + 16, 0, 4), 2), 2), 4), 4);
        this.out.get().write(BruteForceCoding.add(bArr, str.getBytes()));
        this.out.get().flush();
        return Boolean.TRUE;
    }

    public boolean isRunning() {
        return this.state.get() == State.RUNNING;
    }

    public boolean isStopped() {
        return this.state.get() == State.STOPPED;
    }

    public abstract void messageReceived(long j10, String str);

    public abstract void messageReceived(Long l10, Long l11, Long l12, Long l13, Long l14, String str);

    public abstract void messageReceived(String str);

    /* JADX WARN: Code restructure failed: missing block: B:43:0x012c, code lost:
    
        r5 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01d5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:109:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01b4 A[Catch: Exception -> 0x01ba, TRY_LEAVE, TryCatch #3 {Exception -> 0x01ba, blocks: (B:71:0x0186, B:75:0x01a7, B:78:0x01ae, B:79:0x01b4), top: B:70:0x0186 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:105:0x0183 -> B:59:0x0186). Please report as a decompilation issue!!! */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void run() {
        /*
            Method dump skipped, instructions count: 480
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.imsdk.AbstractBlockingClient.run():void");
    }

    public void setOnConnectListener(OnConnectServerListener onConnectServerListener) {
        this.mListener = onConnectServerListener;
    }

    public boolean stop() {
        boolean z10;
        if (!b.a(this.state, State.RUNNING, State.STOPPING)) {
            return false;
        }
        stopHeartBeat();
        try {
            this.in.get().close();
            z10 = true;
        } catch (Exception e10) {
            LeLog.w("IM_AbstractBlockingClient", e10);
            z10 = false;
        }
        try {
            this.out.get().close();
            return z10;
        } catch (Exception unused) {
            return false;
        }
    }

    public synchronized Boolean updateCapabilityWrite() {
        LeLog.i("IM_AbstractBlockingClient", "updateCapabilityWrite " + this.capability);
        String str = this.uid + ";" + this.capability + ";" + this.appid + ";" + this.token;
        byte[] bArr = new byte[16];
        BruteForceCoding.encodeIntBigEndian(bArr, 1L, BruteForceCoding.encodeIntBigEndian(bArr, 15L, BruteForceCoding.encodeIntBigEndian(bArr, 1L, BruteForceCoding.encodeIntBigEndian(bArr, 16L, BruteForceCoding.encodeIntBigEndian(bArr, str.getBytes().length + 16, 0, 4), 2), 2), 4), 4);
        this.out.get().write(BruteForceCoding.add(bArr, str.getBytes()));
        this.out.get().flush();
        return Boolean.TRUE;
    }

    public AbstractBlockingClient(String str, int i10, String str2, String str3, String str4, String str5, int i11) {
        this.TAG = "IM_AbstractBlockingClient";
        this.state = new AtomicReference<>(State.STOPPED);
        this.heartBeatTimeOut = TimeUnit.SECONDS.toMillis(50L);
        this.defaultSocketTimeOut = 180000;
        this.out = new AtomicReference<>();
        this.in = new AtomicReference<>();
        this.server = str;
        this.port = i10;
        this.uid = str2;
        this.capability = str3;
        this.appid = str4;
        this.token = str5;
        this.defaultBufferSize = i11;
    }
}
