package org.android.spdy;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.concurrent.atomic.AtomicBoolean;
import org.android.spdy.ProtectedPointer;

/* loaded from: classes.dex */
public final class SpdySession {
    private static volatile int count;
    private SpdyAgent agent;
    private String authority;
    private String domain;
    private Handler handler;
    Intenalcb intenalcb;
    private int mode;
    private ProtectedPointer pptr4sessionNativePtr;
    private int pubkey_seqnum;
    SessionCb sessionCallBack;
    private volatile long sessionNativePtr;
    private NetSparseArray<SpdyStreamContext> spdyStream;
    private HandlerThread thread;
    private Object userData;
    private AtomicBoolean closed = new AtomicBoolean();
    private boolean sessionClearedFromSessionMgr = false;
    private Object lock = new Object();
    private int streamcount = 1;
    volatile int refcount = 1;

    public SpdySession(long j10, SpdyAgent spdyAgent, String str, String str2, SessionCb sessionCb, int i10, int i11, Object obj) {
        this.spdyStream = null;
        this.sessionCallBack = null;
        this.pubkey_seqnum = 0;
        this.userData = null;
        this.sessionNativePtr = j10;
        ProtectedPointer protectedPointer = new ProtectedPointer(this);
        this.pptr4sessionNativePtr = protectedPointer;
        protectedPointer.setHow2close(new ProtectedPointer.ProtectedPointerOnClose() { // from class: org.android.spdy.SpdySession.1
            @Override // org.android.spdy.ProtectedPointer.ProtectedPointerOnClose
            public void close(Object obj2) {
                SpdySession spdySession = (SpdySession) obj2;
                spdySession.NotifyNotInvokeAnyMoreN(spdySession.sessionNativePtr);
                spdySession.setSessionNativePtr(0L);
            }
        });
        this.agent = spdyAgent;
        this.authority = str;
        this.intenalcb = new SpdySessionCallBack();
        this.domain = str2;
        this.spdyStream = new NetSparseArray<>(5);
        this.sessionCallBack = sessionCb;
        this.pubkey_seqnum = i11;
        this.mode = i10;
        this.userData = obj;
        this.closed.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public native int NotifyNotInvokeAnyMoreN(long j10);

    private int closeprivate() {
        synchronized (this.lock) {
            if (!this.sessionClearedFromSessionMgr) {
                this.agent.clearSpdySession(this.authority, this.domain, this.mode);
                this.sessionClearedFromSessionMgr = true;
            }
        }
        synchronized (this.lock) {
            SpdyStreamContext[] allStreamCb = getAllStreamCb();
            if (allStreamCb != null) {
                for (SpdyStreamContext spdyStreamContext : allStreamCb) {
                    spduLog.Logi("tnet-jni", "[SpdySessionCallBack.spdyStreamCloseCallback] unfinished stm=" + spdyStreamContext.streamId);
                    spdyStreamContext.callBack.spdyStreamCloseCallback(this, (long) spdyStreamContext.streamId, TnetStatusCode.EASY_REASON_CONN_NOT_EXISTS, spdyStreamContext.streamContext, null);
                }
            }
            this.spdyStream.clear();
        }
        return 0;
    }

    private String getAuthority() {
        return this.authority;
    }

    private native int sendCustomControlFrameN(long j10, int i10, int i11, int i12, int i13, byte[] bArr);

    private native int sendHeadersN(long j10, int i10, String[] strArr, boolean z10);

    private native int setOptionN(long j10, int i10, int i11);

    private native int streamCloseN(long j10, int i10, int i11);

    private native int streamSendDataN(long j10, int i10, byte[] bArr, int i11, int i12, boolean z10);

    private native int submitBioPingN(long j10);

    private native int submitPingN(long j10);

    private native int submitRequestN(long j10, String str, byte b10, String[] strArr, byte[] bArr, boolean z10, int i10, int i11, int i12);

    public int cleanUp() {
        spduLog.Logd("tnet-jni", "[SpdySession.cleanUp] - ");
        if (this.closed.getAndSet(true)) {
            return 0;
        }
        this.agent.removeSession(this);
        return closeprivate();
    }

    public void clearAllStreamCb() {
        spduLog.Logd("tnet-jni", "[SpdySession.clearAllStreamCb] - ");
        synchronized (this.lock) {
            this.spdyStream.clear();
        }
    }

    public int closeInternal() {
        if (this.closed.getAndSet(true)) {
            return 0;
        }
        return closeprivate();
    }

    public int closeSession() {
        int i10;
        spduLog.Logd("tnet-jni", "[SpdySession.closeSession] - ");
        synchronized (this.lock) {
            i10 = 0;
            if (!this.sessionClearedFromSessionMgr) {
                spduLog.Logd("tnet-jni", "[SpdySession.closeSession] - " + this.authority);
                this.agent.clearSpdySession(this.authority, this.domain, this.mode);
                this.sessionClearedFromSessionMgr = true;
                if (this.pptr4sessionNativePtr.enter()) {
                    try {
                        try {
                            i10 = this.agent.closeSession(this.sessionNativePtr);
                        } catch (UnsatisfiedLinkError e10) {
                            e10.printStackTrace();
                            this.pptr4sessionNativePtr.exit();
                        }
                    } finally {
                        this.pptr4sessionNativePtr.exit();
                    }
                } else {
                    i10 = TnetStatusCode.EASY_REASON_CONN_NOT_EXISTS;
                }
            }
        }
        return i10;
    }

    public SpdyStreamContext[] getAllStreamCb() {
        SpdyStreamContext[] spdyStreamContextArr;
        synchronized (this.lock) {
            int size = this.spdyStream.size();
            if (size > 0) {
                spdyStreamContextArr = new SpdyStreamContext[size];
                this.spdyStream.toArray(spdyStreamContextArr);
            } else {
                spdyStreamContextArr = null;
            }
        }
        return spdyStreamContextArr;
    }

    public String getDomain() {
        return this.domain;
    }

    public Handler getMsgHandler() {
        return this.handler;
    }

    public int getRefCount() {
        return this.refcount;
    }

    public long getSessionNativePtr() {
        return this.sessionNativePtr;
    }

    public SpdyAgent getSpdyAgent() {
        return this.agent;
    }

    public SpdyStreamContext getSpdyStream(int i10) {
        SpdyStreamContext spdyStreamContext;
        if (i10 <= 0) {
            return null;
        }
        synchronized (this.lock) {
            spdyStreamContext = this.spdyStream.get(i10);
        }
        return spdyStreamContext;
    }

    public Object getUserData() {
        return this.userData;
    }

    public void increRefCount() {
        this.refcount++;
    }

    public int putSpdyStreamCtx(SpdyStreamContext spdyStreamContext) {
        int i10;
        synchronized (this.lock) {
            i10 = this.streamcount;
            this.streamcount = i10 + 1;
            this.spdyStream.put(i10, spdyStreamContext);
        }
        return i10;
    }

    public void releasePptr() {
        this.pptr4sessionNativePtr.release();
    }

    public void removeSpdyStream(int i10) {
        if (i10 > 0) {
            synchronized (this.lock) {
                this.spdyStream.remove(i10);
            }
        }
    }

    public int sendCustomControlFrame(int i10, int i11, int i12, int i13, byte[] bArr) {
        int i14;
        sessionIsOpen();
        if (bArr != null && bArr.length <= 0) {
            bArr = null;
        }
        byte[] bArr2 = bArr;
        spduLog.Logi("tnet-jni", "[sendCustomControlFrame] - type: " + i11);
        if (this.pptr4sessionNativePtr.enter()) {
            i14 = sendCustomControlFrameN(this.sessionNativePtr, i10, i11, i12, i13, bArr2);
            this.pptr4sessionNativePtr.exit();
        } else {
            i14 = TnetStatusCode.EASY_REASON_CONN_NOT_EXISTS;
        }
        if (i14 == 0) {
            return i14;
        }
        throw new SpdyErrorException("sendCustomControlFrame error: " + i14, i14);
    }

    public void sessionIsOpen() {
        if (this.closed.get()) {
            throw new SpdyErrorException("session is already closed: -1104", TnetStatusCode.TNET_JNI_ERR_ASYNC_CLOSE);
        }
    }

    public int setOption(int i10, int i11) {
        int i12;
        sessionIsOpen();
        if (this.pptr4sessionNativePtr.enter()) {
            i12 = setOptionN(this.sessionNativePtr, i10, i11);
            this.pptr4sessionNativePtr.exit();
        } else {
            i12 = TnetStatusCode.EASY_REASON_CONN_NOT_EXISTS;
        }
        if (i12 == 0) {
            return i12;
        }
        throw new SpdyErrorException("setOption error: " + i12, i12);
    }

    public void setSessionNativePtr(long j10) {
        this.sessionNativePtr = j10;
    }

    public int streamReset(long j10, int i10) {
        int i11;
        sessionIsOpen();
        spduLog.Logd("tnet-jni", "[SpdySession.streamReset] - ");
        if (this.pptr4sessionNativePtr.enter()) {
            i11 = streamCloseN(this.sessionNativePtr, (int) j10, i10);
            this.pptr4sessionNativePtr.exit();
        } else {
            i11 = TnetStatusCode.EASY_REASON_CONN_NOT_EXISTS;
        }
        if (i11 == 0) {
            return i11;
        }
        throw new SpdyErrorException("streamReset error: " + i11, i11);
    }

    @Deprecated
    public int submitBioPing() {
        int i10;
        sessionIsOpen();
        if (this.pptr4sessionNativePtr.enter()) {
            i10 = submitBioPingN(this.sessionNativePtr);
            this.pptr4sessionNativePtr.exit();
        } else {
            i10 = TnetStatusCode.EASY_REASON_CONN_NOT_EXISTS;
        }
        if (i10 == 0) {
            return i10;
        }
        throw new SpdyErrorException("submitBioPing error: " + i10, i10);
    }

    public int submitPing() {
        int i10;
        sessionIsOpen();
        if (this.pptr4sessionNativePtr.enter()) {
            i10 = submitPingN(this.sessionNativePtr);
            this.pptr4sessionNativePtr.exit();
        } else {
            i10 = TnetStatusCode.EASY_REASON_CONN_NOT_EXISTS;
        }
        if (i10 == 0) {
            return i10;
        }
        throw new SpdyErrorException("submitPing error: " + i10, i10);
    }

    public int submitRequest(SpdyRequest spdyRequest, SpdyDataProvider spdyDataProvider, Object obj, Spdycb spdycb) {
        SpdyStreamContext spdyStreamContext;
        String str;
        int i10;
        if (spdyRequest == null || obj == null || spdyRequest.getAuthority() == null) {
            throw new SpdyErrorException("submitRequest error: -1102", TnetStatusCode.TNET_JNI_ERR_INVLID_PARAM);
        }
        sessionIsOpen();
        byte[] dataproviderToByteArray = SpdyAgent.dataproviderToByteArray(spdyRequest, spdyDataProvider);
        if (dataproviderToByteArray != null && dataproviderToByteArray.length <= 0) {
            dataproviderToByteArray = null;
        }
        byte[] bArr = dataproviderToByteArray;
        boolean z10 = spdyDataProvider != null ? spdyDataProvider.finished : true;
        SpdyStreamContext spdyStreamContext2 = new SpdyStreamContext(obj, spdycb);
        int putSpdyStreamCtx = putSpdyStreamCtx(spdyStreamContext2);
        String[] mapToByteArray = SpdyAgent.mapToByteArray(spdyRequest.getHeaders());
        spduLog.Logi("tnet-jni", "index=" + putSpdyStreamCtx + "  starttime=" + System.currentTimeMillis());
        if (this.pptr4sessionNativePtr.enter()) {
            spdyStreamContext = spdyStreamContext2;
            str = "tnet-jni";
            i10 = submitRequestN(this.sessionNativePtr, spdyRequest.getUrlPath(), (byte) spdyRequest.getPriority(), mapToByteArray, bArr, z10, putSpdyStreamCtx, spdyRequest.getRequestTimeoutMs(), spdyRequest.getRequestRdTimeoutMs());
            this.pptr4sessionNativePtr.exit();
        } else {
            spdyStreamContext = spdyStreamContext2;
            str = "tnet-jni";
            i10 = TnetStatusCode.EASY_REASON_CONN_NOT_EXISTS;
        }
        spduLog.Logi(str, "index=" + putSpdyStreamCtx + "   calltime=" + System.currentTimeMillis());
        if (i10 >= 0) {
            spdyStreamContext.streamId = i10;
            return i10;
        }
        removeSpdyStream(putSpdyStreamCtx);
        throw new SpdyErrorException("submitRequest error: " + i10, i10);
    }
}
