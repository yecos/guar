package com.efs.sdk.pa;

import android.content.Context;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.pa.config.ConfigManager;
import com.efs.sdk.pa.config.IEfsReporter;
import com.efs.sdk.pa.config.PackageLevel;
import java.util.HashMap;

/* loaded from: classes.dex */
public class PAFactory {
    private static final long DEFAULT_TIME_OUT_TIME = 2000;
    private static final long INVALID_TIME_OUT_TIME = 0;
    private static final long MAX_TIME_OUT_TIME = 4000;
    private static final String TAG = "pafactory";
    static final ThreadLocal<PA> sThreadLocal = new ThreadLocal<>();
    private ConfigManager mConfigManager;
    private Context mContext;
    private HashMap<String, String> mExtend;
    private IPaClient mPaClient;
    private EfsReporter mReporter;
    private IEfsReporter mReporterFactory;
    private String mSerial;
    private String mSver;
    private long mTimeOutTime;
    private PATraceListener mTraceListener;

    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private PackageLevel f6430a;

        /* renamed from: b, reason: collision with root package name */
        private IEfsReporter f6431b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f6432c;

        /* renamed from: d, reason: collision with root package name */
        private Context f6433d;

        /* renamed from: e, reason: collision with root package name */
        private String f6434e;

        /* renamed from: f, reason: collision with root package name */
        private HashMap<String, String> f6435f;

        /* renamed from: g, reason: collision with root package name */
        private String f6436g;

        /* renamed from: h, reason: collision with root package name */
        private long f6437h = PAFactory.DEFAULT_TIME_OUT_TIME;

        /* renamed from: i, reason: collision with root package name */
        private PATraceListener f6438i;

        /* renamed from: j, reason: collision with root package name */
        private IPaClient f6439j;

        public Builder(Context context, IEfsReporter iEfsReporter) {
            if (context == null) {
                throw new RuntimeException("context Should Not null");
            }
            if (iEfsReporter == null) {
                throw new RuntimeException("reporter Should Not Empty");
            }
            this.f6431b = iEfsReporter;
            this.f6433d = context;
        }

        public PAFactory build() {
            if (this.f6430a != null) {
                return new PAFactory(this.f6433d, this.f6430a, this.f6431b, this.f6432c, this.f6434e, this.f6435f, this.f6436g, this.f6437h, this.f6438i, this.f6439j);
            }
            throw new RuntimeException(String.format("%s Should Not Null", ""));
        }

        public Builder extendLogInfo(HashMap<String, String> hashMap) {
            this.f6435f = hashMap;
            return this;
        }

        public Builder isNewInstall(boolean z10) {
            this.f6432c = z10;
            return this;
        }

        public Builder packageLevel(PackageLevel packageLevel) {
            this.f6430a = packageLevel;
            return this;
        }

        public Builder serial(String str) {
            this.f6434e = str;
            return this;
        }

        public Builder setPaClient(IPaClient iPaClient) {
            this.f6439j = iPaClient;
            return this;
        }

        public Builder sver(String str) {
            this.f6436g = str;
            return this;
        }

        public Builder timeoutTime(long j10) {
            if (j10 <= 0) {
                this.f6437h = PAFactory.DEFAULT_TIME_OUT_TIME;
            } else {
                if (j10 > PAFactory.MAX_TIME_OUT_TIME) {
                    this.f6437h = PAFactory.DEFAULT_TIME_OUT_TIME;
                    return this;
                }
                this.f6437h = j10;
            }
            return this;
        }

        public Builder traceListener(PATraceListener pATraceListener) {
            this.f6438i = pATraceListener;
            return this;
        }
    }

    public ConfigManager getConfigManager() {
        return this.mConfigManager;
    }

    public Context getContext() {
        return this.mContext;
    }

    public HashMap<String, String> getExtend() {
        return this.mExtend;
    }

    public IPaClient getPaClient() {
        return this.mPaClient;
    }

    public synchronized PA getPaInstance() {
        PA pa2;
        ThreadLocal<PA> threadLocal = sThreadLocal;
        pa2 = threadLocal.get();
        if (pa2 == null) {
            pa2 = new com.efs.sdk.pa.a.c(this.mConfigManager.enableTracer());
            pa2.registerPAANRListener(this.mContext, new a(this), this.mTimeOutTime);
            threadLocal.set(pa2);
        }
        return pa2;
    }

    public EfsReporter getReporter() {
        if (this.mReporter == null) {
            IEfsReporter iEfsReporter = this.mReporterFactory;
            this.mReporter = iEfsReporter != null ? iEfsReporter.getReporter() : null;
        }
        return this.mReporter;
    }

    public String getSerial() {
        return this.mSerial;
    }

    public String getSver() {
        return this.mSver;
    }

    public PATraceListener getTraceListener() {
        return this.mTraceListener;
    }

    private PAFactory(Context context, PackageLevel packageLevel, IEfsReporter iEfsReporter, boolean z10, String str, HashMap<String, String> hashMap, String str2, long j10, PATraceListener pATraceListener, IPaClient iPaClient) {
        this.mReporterFactory = iEfsReporter;
        this.mSerial = str;
        this.mExtend = hashMap;
        this.mSver = str2;
        this.mContext = context;
        this.mTraceListener = pATraceListener;
        this.mPaClient = iPaClient;
        this.mTimeOutTime = j10;
        this.mConfigManager = new ConfigManager(context, packageLevel, iEfsReporter, z10);
    }
}
