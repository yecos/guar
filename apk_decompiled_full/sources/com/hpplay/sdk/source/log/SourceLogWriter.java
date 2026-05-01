package com.hpplay.sdk.source.log;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.hpplay.common.log.ILogCallback;
import com.hpplay.common.log.LeLog;
import com.hpplay.component.common.utils.CLog;
import com.hpplay.logwriter.f;
import com.hpplay.sdk.source.common.store.Session;
import com.hpplay.sdk.source.config.LelinkConfig;
import com.hpplay.sdk.source.utils.LogcatLogCollect;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes3.dex */
public class SourceLogWriter implements ISourceLog {
    private static final String TAG = "hpplay-java:SWR";
    private static final int WHAT_WRITE_LOG = 1;
    private static f sLogWriter;
    private static LogcatLogCollect sLogcat;
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    private ILogCallback sLogCallback = new ILogCallback() { // from class: com.hpplay.sdk.source.log.SourceLogWriter.1
        @Override // com.hpplay.common.log.ILogCallback
        public void onLogCallback(Object... objArr) {
            try {
                SourceLogWriter.this.mHandler.sendMessage(SourceLogWriter.this.mHandler.obtainMessage(1, objArr[0]));
            } catch (Exception unused) {
            }
        }
    };
    private CLog.IComponentLogCallback sClogCallback = new CLog.IComponentLogCallback() { // from class: com.hpplay.sdk.source.log.SourceLogWriter.2
        @Override // com.hpplay.component.common.utils.CLog.IComponentLogCallback
        public void onCastLog(int i10, String str) {
            try {
                SourceLogWriter.this.mHandler.sendMessage(SourceLogWriter.this.mHandler.obtainMessage(1, str));
            } catch (Exception unused) {
            }
        }
    };
    private SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.getDefault());
    private Date sDate = new Date();
    private String mLogDir = null;

    public SourceLogWriter() {
        this.mHandlerThread = null;
        this.mHandler = null;
        HandlerThread handlerThread = new HandlerThread("bu log writer");
        this.mHandlerThread = handlerThread;
        handlerThread.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper()) { // from class: com.hpplay.sdk.source.log.SourceLogWriter.3
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what != 1) {
                    return;
                }
                try {
                    SourceLogWriter.this.writeLogImpl(message.obj.toString());
                } catch (Exception unused) {
                }
            }
        };
    }

    private static void callbackLog(int i10, String str) {
        com.hpplay.sdk.source.api.ILogCallback logCallback;
        if (Session.getInstance() == null || (logCallback = Session.getInstance().getLogCallback()) == null) {
            return;
        }
        logCallback.onCastLog(i10, str);
    }

    private void checkLogWrite(Context context, int i10) {
        try {
            f a10 = f.a();
            sLogWriter = a10;
            if (a10.e()) {
                return;
            }
            this.mLogDir = LogCache.getLogDir();
            StringBuilder sb = new StringBuilder();
            sb.append("enableLog ");
            sb.append(this.mLogDir);
            if (sLogcat == null && !LelinkConfig.isMultiProgress()) {
                sLogcat = new LogcatLogCollect();
            }
            sLogWriter.a(sLogcat);
            sLogWriter.a(context, this.mLogDir, i10);
        } catch (Exception unused) {
        }
    }

    private String getDate() {
        try {
            this.sDate.setTime(System.currentTimeMillis());
            return this.sDateFormat.format(this.sDate);
        } catch (Exception unused) {
            return "";
        }
    }

    public static void testLog() {
        new Thread(new Runnable() { // from class: com.hpplay.sdk.source.log.SourceLogWriter.4
            @Override // java.lang.Runnable
            public void run() {
                int i10 = 0;
                while (SourceLogWriter.sLogWriter != null) {
                    try {
                        Thread.sleep(10L);
                    } catch (Exception unused) {
                    }
                    SourceLogWriter.sLogWriter.a("testLog *****************  " + i10);
                    i10++;
                }
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeLogImpl(String str) {
        try {
            f fVar = sLogWriter;
            if (fVar == null) {
                return;
            }
            fVar.a(getDate() + str);
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
    }

    @Override // com.hpplay.sdk.source.log.ISourceLog
    public void D(String str, String str2) {
        callbackLog(3, LeLog.D(str, str2));
    }

    @Override // com.hpplay.sdk.source.log.ISourceLog
    public void E(String str, String str2) {
        callbackLog(6, LeLog.E(str, str2));
    }

    @Override // com.hpplay.sdk.source.log.ISourceLog
    public void I(String str, String str2) {
        callbackLog(4, LeLog.I(str, str2));
    }

    @Override // com.hpplay.sdk.source.log.ISourceLog
    public void V(String str, String str2) {
        callbackLog(2, LeLog.V(str, str2));
    }

    @Override // com.hpplay.sdk.source.log.ISourceLog
    public void W(String str, String str2) {
        callbackLog(5, LeLog.W(str, str2));
    }

    @Override // com.hpplay.sdk.source.log.ISourceLog
    public void d(String str, String str2) {
        callbackLog(3, LeLog.d(str, str2));
    }

    public void disableLogAndWriter() {
        f fVar;
        try {
            fVar = sLogWriter;
        } catch (Exception unused) {
        }
        if (fVar == null) {
            return;
        }
        fVar.c();
        sLogWriter = null;
        try {
            LeLog.disableTrace();
            CLog.setLogCallback(null);
        } catch (Exception unused2) {
        }
    }

    public void disableLogButWriter(Context context, int i10) {
        LeLog.disableTrace(this.sLogCallback);
        CLog.setLogCallback(this.sClogCallback);
        checkLogWrite(context, i10);
    }

    @Override // com.hpplay.sdk.source.log.ISourceLog
    public void e(String str, String str2) {
        callbackLog(6, LeLog.e(str, str2));
    }

    public void enableLogAndWriter(Context context, int i10) {
        LeLog.enableTrace(this.sLogCallback);
        CLog.setLogCallback(this.sClogCallback);
        checkLogWrite(context, i10);
    }

    public void enableLogNotWriter() {
        try {
            LeLog.enableTrace(null);
            CLog.setLogCallback(null);
        } catch (Exception unused) {
        }
    }

    public void flushLogWriter() {
        try {
            f fVar = sLogWriter;
            if (fVar == null) {
                return;
            }
            fVar.b();
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
    }

    public String getLogDir() {
        return this.mLogDir;
    }

    @Override // com.hpplay.sdk.source.log.ISourceLog
    public void i(String str, String str2) {
        callbackLog(4, LeLog.i(str, str2));
    }

    @Override // com.hpplay.sdk.source.log.ISourceLog
    public void v(String str, String str2) {
        callbackLog(2, LeLog.v(str, str2));
    }

    @Override // com.hpplay.sdk.source.log.ISourceLog
    public void w(String str, String str2) {
        callbackLog(5, LeLog.w(str, str2));
    }

    public void writeLog(String str) {
        try {
            Handler handler = this.mHandler;
            handler.sendMessage(handler.obtainMessage(1, str));
        } catch (Exception unused) {
        }
    }

    @Override // com.hpplay.sdk.source.log.ISourceLog
    public void D(String str, String str2, Throwable th) {
        callbackLog(3, LeLog.D(str, str2, th));
    }

    @Override // com.hpplay.sdk.source.log.ISourceLog
    public void E(String str, String str2, Throwable th) {
        callbackLog(6, LeLog.E(str, str2, th));
    }

    @Override // com.hpplay.sdk.source.log.ISourceLog
    public void I(String str, String str2, Throwable th) {
        callbackLog(4, LeLog.I(str, str2, th));
    }

    @Override // com.hpplay.sdk.source.log.ISourceLog
    public void V(String str, String str2, Throwable th) {
        callbackLog(2, LeLog.V(str, str2, th));
    }

    @Override // com.hpplay.sdk.source.log.ISourceLog
    public void W(String str, String str2, Throwable th) {
        callbackLog(5, LeLog.W(str, str2, th));
    }

    @Override // com.hpplay.sdk.source.log.ISourceLog
    public void d(String str, String str2, Throwable th) {
        callbackLog(3, LeLog.d(str, str2, th));
    }

    @Override // com.hpplay.sdk.source.log.ISourceLog
    public void e(String str, String str2, Throwable th) {
        callbackLog(6, LeLog.e(str, str2, th));
    }

    @Override // com.hpplay.sdk.source.log.ISourceLog
    public void i(String str, String str2, Throwable th) {
        callbackLog(4, LeLog.i(str, str2, th));
    }

    @Override // com.hpplay.sdk.source.log.ISourceLog
    public void v(String str, String str2, Throwable th) {
        callbackLog(2, LeLog.v(str, str2, th));
    }

    @Override // com.hpplay.sdk.source.log.ISourceLog
    public void w(String str, String str2, Throwable th) {
        callbackLog(5, LeLog.w(str, str2, th));
    }

    @Override // com.hpplay.sdk.source.log.ISourceLog
    public void W(String str, Throwable th) {
        callbackLog(5, LeLog.W(str, th));
    }

    @Override // com.hpplay.sdk.source.log.ISourceLog
    public void w(String str, Throwable th) {
        callbackLog(5, LeLog.w(str, th));
    }
}
