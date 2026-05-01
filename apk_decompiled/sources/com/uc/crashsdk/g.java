package com.uc.crashsdk;

import android.os.Build;
import android.os.Bundle;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.uc.crashsdk.a.h;
import com.uc.crashsdk.export.CustomInfo;
import com.uc.crashsdk.export.VersionInfo;
import java.io.File;
import java.lang.reflect.Field;

/* loaded from: classes3.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public static RuntimeException f9744a = null;

    /* renamed from: b, reason: collision with root package name */
    public static RuntimeException f9745b = null;

    /* renamed from: c, reason: collision with root package name */
    static final /* synthetic */ boolean f9746c = true;

    /* renamed from: d, reason: collision with root package name */
    private static CustomInfo f9747d;

    /* renamed from: e, reason: collision with root package name */
    private static VersionInfo f9748e;

    /* renamed from: g, reason: collision with root package name */
    private static String f9750g;

    /* renamed from: h, reason: collision with root package name */
    private static String f9751h;

    /* renamed from: i, reason: collision with root package name */
    private static String f9752i;

    /* renamed from: j, reason: collision with root package name */
    private static String f9753j;

    /* renamed from: f, reason: collision with root package name */
    private static final Object f9749f = new Object();

    /* renamed from: k, reason: collision with root package name */
    private static final Object f9754k = new Object();

    public static String A() {
        return f9747d.mCrashRateUploadUrl;
    }

    public static int B() {
        return f9747d.mLogMaxBytesLimit;
    }

    public static int C() {
        return f9747d.mLogMaxUploadBytesLimit;
    }

    public static long D() {
        return f9747d.mMaxUploadBytesPerDay;
    }

    public static int E() {
        return f9747d.mMaxUploadBuiltinLogCountPerDay;
    }

    public static int F() {
        return f9747d.mMaxUploadCustomLogCountPerDay;
    }

    public static int G() {
        return f9747d.mMaxCustomLogCountPerTypePerDay;
    }

    public static int H() {
        return f9747d.mInfoUpdateInterval;
    }

    public static int I() {
        return f9747d.mInfoSaveFrequency;
    }

    public static int J() {
        return f9747d.mReservedJavaFileHandleCount;
    }

    public static int K() {
        return f9747d.mFdDumpMinLimit;
    }

    public static int L() {
        return f9747d.mThreadsDumpMinLimit;
    }

    public static boolean M() {
        return f9747d.mAutoDetectLifeCycle;
    }

    public static boolean N() {
        return f9747d.mMonitorBattery;
    }

    public static int O() {
        return f9747d.mAnrTraceStrategy;
    }

    public static boolean P() {
        CustomInfo customInfo = f9747d;
        return customInfo == null || customInfo.mDebug;
    }

    public static boolean Q() {
        CustomInfo customInfo = f9747d;
        return customInfo == null || customInfo.mPrintStackInfos;
    }

    public static boolean R() {
        return f9747d.mEnableStatReport;
    }

    public static boolean S() {
        return f9747d.mIsInternational;
    }

    public static boolean T() {
        return f9747d.mAddPvForNewDay;
    }

    public static String U() {
        return com.uc.crashsdk.a.g.a(f9748e.mVersion) ? a.a() : a(f9748e.mVersion);
    }

    public static String V() {
        return com.uc.crashsdk.a.g.a(f9748e.mSubVersion) ? "release" : f9748e.mSubVersion;
    }

    public static String W() {
        return com.uc.crashsdk.a.g.a(f9748e.mBuildId) ? ae() : a(f9748e.mBuildId);
    }

    public static String X() {
        if (f9751h == null) {
            f9751h = com.uc.crashsdk.a.g.b() + File.separatorChar + f9747d.mTagFilesFolderName + File.separatorChar;
        }
        return f9751h;
    }

    public static String Y() {
        if (f9752i == null) {
            f9752i = com.uc.crashsdk.a.g.b() + File.separatorChar + f9747d.mCrashLogsFolderName + File.separatorChar;
        }
        return f9752i;
    }

    public static String Z() {
        if (f9753j == null) {
            if (com.uc.crashsdk.a.g.a(f9747d.mLogsBackupPathName)) {
                f9753j = (com.uc.crashsdk.a.g.b() + File.separatorChar + "msdb" + File.separatorChar) + File.separatorChar + f9747d.mCrashLogsFolderName + File.separatorChar;
            } else {
                String trim = f9747d.mLogsBackupPathName.trim();
                String str = File.separator;
                if (!trim.endsWith(str)) {
                    trim = trim + str;
                }
                f9753j = trim;
            }
        }
        return f9753j;
    }

    public static void a(CustomInfo customInfo, VersionInfo versionInfo) {
        CustomInfo customInfo2 = new CustomInfo(customInfo);
        f9747d = customInfo2;
        c(customInfo2);
        if (!f9747d.mZipLog) {
            f9744a = new RuntimeException("initialize set mZipLog to false, info.mZipLog: " + customInfo.mZipLog);
        }
        if (f9747d.mEncryptLog) {
            f9745b = new RuntimeException("initialize set mEncryptLog to true, info.mEncryptLog: " + customInfo.mEncryptLog);
        }
        f9748e = new VersionInfo(versionInfo);
        if (b.L()) {
            return;
        }
        try {
            a();
        } catch (Throwable th) {
            com.uc.crashsdk.a.g.a(th);
        }
    }

    public static boolean aa() {
        return f9747d.mEnableCrpStat;
    }

    public static boolean ab() {
        return f9747d.mEnableStatToWPKDirect;
    }

    public static String ac() {
        return f9747d.mUserId;
    }

    public static String ad() {
        return f9747d.mChannel;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0045, code lost:
    
        if (r1 == null) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.lang.String ae() {
        /*
            java.lang.String r0 = com.uc.crashsdk.g.f9750g
            if (r0 == 0) goto L5
            return r0
        L5:
            r0 = 0
            java.util.zip.ZipFile r1 = new java.util.zip.ZipFile     // Catch: java.lang.Throwable -> L3a
            java.lang.String r2 = com.uc.crashsdk.a.g.c()     // Catch: java.lang.Throwable -> L3a
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L3a
            java.lang.String r0 = "classes.dex"
            java.util.zip.ZipEntry r0 = r1.getEntry(r0)     // Catch: java.lang.Throwable -> L38
            long r2 = r0.getCrc()     // Catch: java.lang.Throwable -> L38
            java.lang.String r0 = java.lang.Long.toHexString(r2)     // Catch: java.lang.Throwable -> L38
            com.uc.crashsdk.g.f9750g = r0     // Catch: java.lang.Throwable -> L38
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L38
            java.lang.String r2 = "version unique build id: "
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L38
            java.lang.String r2 = com.uc.crashsdk.g.f9750g     // Catch: java.lang.Throwable -> L38
            r0.append(r2)     // Catch: java.lang.Throwable -> L38
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L38
            java.lang.String r2 = "crashsdk"
            com.uc.crashsdk.a.a.a(r2, r0)     // Catch: java.lang.Throwable -> L38
        L34:
            r1.close()     // Catch: java.lang.Throwable -> L48
            goto L48
        L38:
            r0 = move-exception
            goto L3e
        L3a:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L3e:
            java.lang.String r2 = ""
            com.uc.crashsdk.g.f9750g = r2     // Catch: java.lang.Throwable -> L4b
            com.uc.crashsdk.a.g.a(r0)     // Catch: java.lang.Throwable -> L4b
            if (r1 == 0) goto L48
            goto L34
        L48:
            java.lang.String r0 = com.uc.crashsdk.g.f9750g
            return r0
        L4b:
            r0 = move-exception
            if (r1 == 0) goto L51
            r1.close()     // Catch: java.lang.Throwable -> L51
        L51:
            goto L53
        L52:
            throw r0
        L53:
            goto L52
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uc.crashsdk.g.ae():java.lang.String");
    }

    private static void af() {
        if (b.f9663d) {
            JNIBridge.nativeSet(24, 1L, a.f9579b, null);
        }
    }

    public static void b() {
        JNIBridge.set(103, com.uc.crashsdk.a.g.b());
        JNIBridge.set(104, f9747d.mTagFilesFolderName);
        JNIBridge.set(105, f9747d.mCrashLogsFolderName);
        JNIBridge.set(106, Z());
        JNIBridge.set(107, e.h());
        JNIBridge.set(108, b.a());
        JNIBridge.set(109, U());
        JNIBridge.set(110, V());
        JNIBridge.set(111, W());
        JNIBridge.set(112, "240515102041");
        JNIBridge.set(116, Build.MODEL);
        JNIBridge.set(117, Build.VERSION.RELEASE);
        JNIBridge.set(118, e.q());
        JNIBridge.set(5, f9747d.mCallNativeDefaultHandler);
        JNIBridge.set(6, f9747d.mDumpUserSolibBuildId);
        JNIBridge.set(7, f9747d.mReservedNativeMemoryBytes);
        JNIBridge.set(100, f9747d.mNativeCrashLogFileName);
        JNIBridge.set(101, f9747d.mUnexpCrashLogFileName);
        JNIBridge.set(35, f9747d.mEnableMemoryGroup);
        JNIBridge.set(36, f9747d.mEnableLibcMallocDetail);
        JNIBridge.set(131, f9747d.mLibcMallocDetailConfig);
        JNIBridge.set(102, f9747d.mAppId);
        JNIBridge.set(38, f9747d.mCrashRateUploadUrl);
        JNIBridge.set(39, f9747d.mCrashSDKAuthUrl);
    }

    private static void c(CustomInfo customInfo) {
        if (customInfo.mZippedLogExtension == null) {
            customInfo.mZippedLogExtension = "";
        }
        if (customInfo.mZippedLogExtension.equals(".tmp")) {
            throw new IllegalArgumentException("mZippedLogExtension can not be '.tmp'!");
        }
        if (customInfo.mOmitJavaCrash) {
            customInfo.mCallJavaDefaultHandler = false;
        }
        if (customInfo.mOmitNativeCrash) {
            customInfo.mCallNativeDefaultHandler = false;
        }
        long b10 = e.b();
        if (b10 >= 1) {
            customInfo.mMaxBuiltinLogFilesCount = 200;
            customInfo.mMaxCustomLogFilesCount = 100;
            customInfo.mMaxUploadBytesPerDay = 268435456L;
            customInfo.mMaxUploadBuiltinLogCountPerDay = 2000;
            customInfo.mMaxUploadCustomLogCountPerDay = 2000;
            customInfo.mMaxCustomLogCountPerTypePerDay = 100;
            customInfo.mMaxAnrLogCountPerProcess = 100;
            customInfo.mAnrTraceStrategy = 2;
            if (b10 >= 2) {
                customInfo.mSyncUploadSetupCrashLogs = true;
                customInfo.mSyncUploadLogs = true;
                if (b10 >= 3) {
                    customInfo.mBackupLogs = true;
                    customInfo.mPrintStackInfos = true;
                    customInfo.mDebug = true;
                }
            }
        }
    }

    public static void d() {
        JNIBridge.set(23, f9747d.mIsInternational);
        if (b.H()) {
            JNIBridge.set(34, true);
        }
        if (e.i()) {
            JNIBridge.set(1, true);
        }
        JNIBridge.set(10, f9747d.mFdDumpMinLimit);
        JNIBridge.nativeCmd(3, f9747d.mReservedNativeFileHandleCount, null, null);
        JNIBridge.nativeSetForeground(b.B());
        JNIBridge.set(2, b.F());
        a.e();
        a.g();
        a.i();
        a.k();
        JNIBridge.set(113, a.f9578a);
        JNIBridge.cmd(1);
        JNIBridge.set(22, f9747d.mThreadsDumpMinLimit);
        JNIBridge.set(122, a.a());
        JNIBridge.set(33, a.c());
        af();
        b.K();
        b.D();
        com.uc.crashsdk.a.g.k();
    }

    public static String e() {
        return f9747d.mAppId;
    }

    public static boolean f() {
        if (com.uc.crashsdk.a.g.b(f9747d.mJavaCrashLogFileName) || com.uc.crashsdk.a.g.b(f9747d.mNativeCrashLogFileName)) {
            return true;
        }
        return com.uc.crashsdk.a.g.b(f9747d.mUnexpCrashLogFileName);
    }

    public static String g() {
        return f9747d.mJavaCrashLogFileName;
    }

    public static int h() {
        return f9747d.mCrashRestartInterval;
    }

    public static boolean i() {
        return f9747d.mCallJavaDefaultHandler;
    }

    public static boolean j() {
        return f9747d.mEnableKillProcessAfterCrash;
    }

    public static boolean k() {
        return f9747d.mDumpHprofDataForJavaOOM;
    }

    public static boolean l() {
        return f9747d.mRenameFileToDefaultName;
    }

    public static int m() {
        return f9747d.mMaxBuiltinLogFilesCount;
    }

    public static int n() {
        return f9747d.mMaxCustomLogFilesCount;
    }

    public static int o() {
        return f9747d.mMaxJavaLogcatLineCount;
    }

    public static int p() {
        return f9747d.mUnexpDelayMillSeconds;
    }

    public static int q() {
        return f9747d.mUnexpSubTypes;
    }

    public static boolean r() {
        return f9747d.mBackupLogs;
    }

    public static boolean s() {
        return f9747d.mSyncUploadSetupCrashLogs;
    }

    public static boolean t() {
        return f9747d.mSyncUploadLogs;
    }

    public static boolean u() {
        return f9747d.mOmitJavaCrash;
    }

    public static boolean v() {
        return f9747d.mAutoDeleteOldVersionStats;
    }

    public static boolean w() {
        return f9747d.mZipLog;
    }

    public static String x() {
        return f9747d.mZippedLogExtension;
    }

    public static boolean y() {
        return f9747d.mEncryptLog;
    }

    public static String z() {
        return f9747d.mCrashLogUploadUrl;
    }

    public static void a(CustomInfo customInfo) {
        boolean z10 = f9746c;
        if (!z10 && customInfo.mTagFilesFolderName == null) {
            throw new AssertionError();
        }
        if (!z10 && customInfo.mCrashLogsFolderName == null) {
            throw new AssertionError();
        }
        if (customInfo.mTagFilesFolderName.equals(customInfo.mCrashLogsFolderName)) {
            throw new IllegalArgumentException("mTagFilesFolderName and mCrashLogsFolderName can not be set to the same!");
        }
    }

    public static void a(VersionInfo versionInfo) {
        synchronized (f9749f) {
            f9748e = new VersionInfo(versionInfo);
            e.c();
            if (b.f9663d) {
                JNIBridge.set(109, U());
                JNIBridge.set(110, V());
                JNIBridge.set(111, W());
                JNIBridge.set(112, "240515102041");
                JNIBridge.cmd(2);
            }
        }
    }

    public static void a() {
        b.y();
        b.x();
        if (f9747d.mBackupLogs) {
            File file = new File(Z());
            if (file.exists()) {
                return;
            }
            file.mkdirs();
        }
    }

    public static void c() {
        JNIBridge.set(11, Q());
        JNIBridge.set(12, f9747d.mBackupLogs);
        JNIBridge.set(13, f9747d.mCrashRestartInterval);
        JNIBridge.set(14, f9747d.mMaxBuiltinLogFilesCount);
        JNIBridge.set(15, f9747d.mMaxNativeLogcatLineCount);
        JNIBridge.set(16, f9747d.mMaxUnexpLogcatLineCount);
        JNIBridge.set(31, f9747d.mMaxAnrLogcatLineCount);
        JNIBridge.set(18, P());
        JNIBridge.set(20, Build.VERSION.SDK_INT);
        JNIBridge.set(21, f9747d.mOmitNativeCrash);
        JNIBridge.set(32, f9747d.mMaxAnrLogCountPerProcess);
        JNIBridge.set(8, f9747d.mDisableSignals);
        JNIBridge.set(9, f9747d.mDisableBackgroundSignals);
        CustomInfo customInfo = f9747d;
        JNIBridge.nativeSet(3, customInfo.mZipLog ? 1L : 0L, customInfo.mZippedLogExtension, null);
        JNIBridge.set(4, f9747d.mLogMaxBytesLimit);
        JNIBridge.set(119, Build.FINGERPRINT);
    }

    private static String a(String str) {
        return (str == null || !str.contains("_")) ? str : str.replaceAll("_", Operator.Operation.MINUS);
    }

    public static int b(CustomInfo customInfo) {
        int i10;
        int i11;
        boolean z10;
        boolean z11;
        synchronized (f9754k) {
            i10 = 0;
            if (customInfo != null) {
                c(customInfo);
                if (f9747d == null) {
                    f9747d = new CustomInfo();
                }
                CustomInfo customInfo2 = f9747d;
                boolean z12 = true;
                if (a(customInfo.mAppId, customInfo2.mAppId)) {
                    i11 = 0;
                    z10 = false;
                } else {
                    String str = customInfo.mAppId;
                    customInfo2.mAppId = str;
                    if (b.f9663d) {
                        JNIBridge.set(102, str);
                    }
                    i11 = 1;
                    z10 = true;
                }
                if (!a(customInfo.mJavaCrashLogFileName, customInfo2.mJavaCrashLogFileName)) {
                    customInfo2.mJavaCrashLogFileName = customInfo.mJavaCrashLogFileName;
                    i11++;
                }
                if (!a(customInfo.mNativeCrashLogFileName, customInfo2.mNativeCrashLogFileName)) {
                    String str2 = customInfo.mNativeCrashLogFileName;
                    customInfo2.mNativeCrashLogFileName = str2;
                    if (b.f9663d) {
                        JNIBridge.set(100, str2);
                    }
                    i11++;
                    z10 = true;
                }
                if (!a(customInfo.mUnexpCrashLogFileName, customInfo2.mUnexpCrashLogFileName)) {
                    String str3 = customInfo.mUnexpCrashLogFileName;
                    customInfo2.mUnexpCrashLogFileName = str3;
                    if (b.f9663d) {
                        JNIBridge.set(101, str3);
                    }
                    i11++;
                    z10 = true;
                }
                if (z10) {
                    e.c();
                    if (b.f9663d) {
                        JNIBridge.cmd(2);
                    }
                }
                boolean z13 = customInfo2.mPrintStackInfos;
                boolean z14 = customInfo.mPrintStackInfos;
                if (z13 != z14) {
                    customInfo2.mPrintStackInfos = z14;
                    if (b.f9663d) {
                        JNIBridge.set(11, z14);
                    }
                    i11++;
                }
                boolean z15 = customInfo2.mDebug;
                boolean z16 = customInfo.mDebug;
                if (z15 != z16) {
                    customInfo2.mDebug = z16;
                    if (b.f9663d) {
                        JNIBridge.set(18, z16);
                    }
                    i11++;
                }
                boolean z17 = customInfo2.mBackupLogs;
                boolean z18 = customInfo.mBackupLogs;
                if (z17 != z18) {
                    customInfo2.mBackupLogs = z18;
                    if (b.f9663d) {
                        JNIBridge.set(12, z18);
                    }
                    i11++;
                }
                boolean z19 = customInfo2.mOmitNativeCrash;
                boolean z20 = customInfo.mOmitNativeCrash;
                if (z19 != z20) {
                    customInfo2.mOmitNativeCrash = z20;
                    if (b.f9663d) {
                        JNIBridge.set(21, z20);
                    }
                    i11++;
                }
                int i12 = customInfo2.mCrashRestartInterval;
                int i13 = customInfo.mCrashRestartInterval;
                if (i12 != i13) {
                    customInfo2.mCrashRestartInterval = i13;
                    if (b.f9663d) {
                        JNIBridge.set(13, i13);
                    }
                    if (customInfo2.mCrashRestartInterval >= 0) {
                        b.M();
                    }
                    i11++;
                }
                int i14 = customInfo2.mMaxBuiltinLogFilesCount;
                int i15 = customInfo.mMaxBuiltinLogFilesCount;
                if (i14 != i15) {
                    customInfo2.mMaxBuiltinLogFilesCount = i15;
                    if (b.f9663d) {
                        JNIBridge.set(14, i15);
                    }
                    i11++;
                }
                int i16 = customInfo2.mMaxNativeLogcatLineCount;
                int i17 = customInfo.mMaxNativeLogcatLineCount;
                if (i16 != i17) {
                    customInfo2.mMaxNativeLogcatLineCount = i17;
                    if (b.f9663d) {
                        JNIBridge.set(15, i17);
                    }
                    i11++;
                }
                int i18 = customInfo2.mMaxJavaLogcatLineCount;
                int i19 = customInfo.mMaxJavaLogcatLineCount;
                if (i18 != i19) {
                    customInfo2.mMaxJavaLogcatLineCount = i19;
                    i11++;
                }
                int i20 = customInfo2.mMaxUnexpLogcatLineCount;
                int i21 = customInfo.mMaxUnexpLogcatLineCount;
                if (i20 != i21) {
                    customInfo2.mMaxUnexpLogcatLineCount = i21;
                    if (b.f9663d) {
                        JNIBridge.set(16, i21);
                    }
                    i11++;
                }
                int i22 = customInfo2.mMaxAnrLogcatLineCount;
                int i23 = customInfo.mMaxAnrLogcatLineCount;
                if (i22 != i23) {
                    customInfo2.mMaxAnrLogcatLineCount = i23;
                    if (b.f9663d) {
                        JNIBridge.set(31, i23);
                    }
                    i11++;
                }
                boolean z21 = customInfo2.mZipLog;
                boolean z22 = customInfo.mZipLog;
                if (z21 != z22) {
                    customInfo2.mZipLog = z22;
                    if (!z22) {
                        com.uc.crashsdk.a.a.d("DEBUG", "updateCustomInfoImpl set mZipLog to false");
                        f9744a = new RuntimeException("updateCustomInfoImpl set mZipLog to false");
                    }
                    i11++;
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (a(customInfo.mZippedLogExtension, customInfo2.mZippedLogExtension)) {
                    z12 = z11;
                } else {
                    customInfo2.mZippedLogExtension = customInfo.mZippedLogExtension;
                    i11++;
                }
                if (z12 && b.f9663d) {
                    JNIBridge.nativeSet(3, customInfo2.mZipLog ? 1L : 0L, customInfo2.mZippedLogExtension, null);
                }
                int i24 = customInfo2.mLogMaxBytesLimit;
                int i25 = customInfo.mLogMaxBytesLimit;
                if (i24 != i25) {
                    customInfo2.mLogMaxBytesLimit = i25;
                    if (b.f9663d) {
                        JNIBridge.set(4, i25);
                    }
                    i11++;
                }
                boolean z23 = customInfo2.mEncryptLog;
                boolean z24 = customInfo.mEncryptLog;
                if (z23 != z24) {
                    customInfo2.mEncryptLog = z24;
                    if (z24) {
                        com.uc.crashsdk.a.a.d("DEBUG", "updateCustomInfoImpl set mEncryptLog to true");
                        f9745b = new RuntimeException("updateCustomInfoImpl set mEncryptLog to true");
                    }
                    i11++;
                }
                boolean z25 = customInfo2.mSyncUploadSetupCrashLogs;
                boolean z26 = customInfo.mSyncUploadSetupCrashLogs;
                if (z25 != z26) {
                    customInfo2.mSyncUploadSetupCrashLogs = z26;
                    i11++;
                }
                boolean z27 = customInfo2.mSyncUploadLogs;
                boolean z28 = customInfo.mSyncUploadLogs;
                if (z27 != z28) {
                    customInfo2.mSyncUploadLogs = z28;
                    i11++;
                }
                int i26 = customInfo2.mMaxCustomLogFilesCount;
                int i27 = customInfo.mMaxCustomLogFilesCount;
                if (i26 != i27) {
                    customInfo2.mMaxCustomLogFilesCount = i27;
                    i11++;
                }
                boolean z29 = customInfo2.mOmitJavaCrash;
                boolean z30 = customInfo.mOmitJavaCrash;
                if (z29 != z30) {
                    customInfo2.mOmitJavaCrash = z30;
                    i11++;
                }
                int i28 = customInfo2.mLogMaxUploadBytesLimit;
                int i29 = customInfo.mLogMaxUploadBytesLimit;
                if (i28 != i29) {
                    customInfo2.mLogMaxUploadBytesLimit = i29;
                    i11++;
                }
                long j10 = customInfo2.mMaxUploadBytesPerDay;
                long j11 = customInfo.mMaxUploadBytesPerDay;
                if (j10 != j11) {
                    customInfo2.mMaxUploadBytesPerDay = j11;
                    i11++;
                }
                int i30 = customInfo2.mMaxUploadBuiltinLogCountPerDay;
                int i31 = customInfo.mMaxUploadBuiltinLogCountPerDay;
                if (i30 != i31) {
                    customInfo2.mMaxUploadBuiltinLogCountPerDay = i31;
                    i11++;
                }
                int i32 = customInfo2.mMaxUploadCustomLogCountPerDay;
                int i33 = customInfo.mMaxUploadCustomLogCountPerDay;
                if (i32 != i33) {
                    customInfo2.mMaxUploadCustomLogCountPerDay = i33;
                    i11++;
                }
                int i34 = customInfo2.mMaxCustomLogCountPerTypePerDay;
                int i35 = customInfo.mMaxCustomLogCountPerTypePerDay;
                if (i34 != i35) {
                    customInfo2.mMaxCustomLogCountPerTypePerDay = i35;
                    i11++;
                }
                int i36 = customInfo2.mMaxAnrLogCountPerProcess;
                int i37 = customInfo.mMaxAnrLogCountPerProcess;
                if (i36 != i37) {
                    customInfo2.mMaxAnrLogCountPerProcess = i37;
                    if (b.f9663d) {
                        JNIBridge.set(32, f9747d.mMaxAnrLogCountPerProcess);
                    }
                    i11++;
                }
                boolean z31 = customInfo2.mCallJavaDefaultHandler;
                boolean z32 = customInfo.mCallJavaDefaultHandler;
                if (z31 != z32) {
                    customInfo2.mCallJavaDefaultHandler = z32;
                    i11++;
                }
                boolean z33 = customInfo2.mEnableKillProcessAfterCrash;
                boolean z34 = customInfo.mEnableKillProcessAfterCrash;
                if (z33 != z34) {
                    customInfo2.mEnableKillProcessAfterCrash = z34;
                    i11++;
                }
                boolean z35 = customInfo2.mCallNativeDefaultHandler;
                boolean z36 = customInfo.mCallNativeDefaultHandler;
                if (z35 != z36) {
                    customInfo2.mCallNativeDefaultHandler = z36;
                    i11++;
                    if (b.f9663d) {
                        JNIBridge.set(5, f9747d.mCallNativeDefaultHandler);
                    }
                }
                boolean z37 = customInfo2.mDumpUserSolibBuildId;
                boolean z38 = customInfo.mDumpUserSolibBuildId;
                if (z37 != z38) {
                    customInfo2.mDumpUserSolibBuildId = z38;
                    i11++;
                    if (b.f9663d) {
                        JNIBridge.set(6, f9747d.mDumpUserSolibBuildId);
                    }
                }
                boolean z39 = customInfo2.mDumpHprofDataForJavaOOM;
                boolean z40 = customInfo.mDumpHprofDataForJavaOOM;
                if (z39 != z40) {
                    customInfo2.mDumpHprofDataForJavaOOM = z40;
                    i11++;
                }
                boolean z41 = customInfo2.mRenameFileToDefaultName;
                boolean z42 = customInfo.mRenameFileToDefaultName;
                if (z41 != z42) {
                    customInfo2.mRenameFileToDefaultName = z42;
                    i11++;
                }
                boolean z43 = customInfo2.mAutoDeleteOldVersionStats;
                boolean z44 = customInfo.mAutoDeleteOldVersionStats;
                if (z43 != z44) {
                    customInfo2.mAutoDeleteOldVersionStats = z44;
                    i11++;
                }
                int i38 = customInfo2.mFdDumpMinLimit;
                int i39 = customInfo.mFdDumpMinLimit;
                if (i38 != i39) {
                    customInfo2.mFdDumpMinLimit = i39;
                    if (b.f9663d) {
                        JNIBridge.set(10, i39);
                    }
                    i11++;
                }
                int i40 = customInfo2.mThreadsDumpMinLimit;
                int i41 = customInfo.mThreadsDumpMinLimit;
                if (i40 != i41) {
                    customInfo2.mThreadsDumpMinLimit = i41;
                    if (b.f9663d) {
                        JNIBridge.set(22, i41);
                    }
                    i11++;
                }
                int i42 = customInfo2.mInfoUpdateInterval;
                int i43 = customInfo.mInfoUpdateInterval;
                if (i42 != i43) {
                    if (i42 <= 0 && i43 > 0) {
                        a.a(false);
                    }
                    customInfo2.mInfoUpdateInterval = customInfo.mInfoUpdateInterval;
                    i11++;
                }
                int i44 = customInfo2.mInfoSaveFrequency;
                int i45 = customInfo.mInfoSaveFrequency;
                if (i44 != i45) {
                    customInfo2.mInfoSaveFrequency = i45;
                    i11++;
                }
                long j12 = customInfo2.mDisableBackgroundSignals;
                long j13 = customInfo.mDisableBackgroundSignals;
                if (j12 != j13) {
                    customInfo2.mDisableBackgroundSignals = j13;
                    if (b.f9663d) {
                        JNIBridge.set(9, j13);
                    }
                    i11++;
                }
                boolean z45 = customInfo2.mEnableStatReport;
                boolean z46 = customInfo.mEnableStatReport;
                if (z45 != z46) {
                    customInfo2.mEnableStatReport = z46;
                    if (z46) {
                        e.B();
                    }
                    i11++;
                }
                boolean z47 = customInfo2.mEnableCrpStat;
                boolean z48 = customInfo.mEnableCrpStat;
                if (z47 != z48) {
                    customInfo2.mEnableCrpStat = z48;
                    i11++;
                }
                boolean z49 = customInfo2.mEnableStatToWPKDirect;
                boolean z50 = customInfo.mEnableStatToWPKDirect;
                if (z49 != z50) {
                    customInfo2.mEnableStatToWPKDirect = z50;
                    i11++;
                }
                boolean z51 = customInfo2.mIsInternational;
                boolean z52 = customInfo.mIsInternational;
                if (z51 != z52) {
                    customInfo2.mIsInternational = z52;
                    if (b.f9663d) {
                        JNIBridge.set(23, z52);
                    }
                    e.l();
                    com.uc.crashsdk.a.d.c();
                    h.k();
                    i11++;
                }
                boolean z53 = customInfo2.mAutoDetectLifeCycle;
                boolean z54 = customInfo.mAutoDetectLifeCycle;
                if (z53 != z54) {
                    customInfo2.mAutoDetectLifeCycle = z54;
                    if (z54) {
                        b.C();
                    }
                    i11++;
                }
                boolean z55 = customInfo2.mMonitorBattery;
                boolean z56 = customInfo.mMonitorBattery;
                if (z55 != z56) {
                    customInfo2.mMonitorBattery = z56;
                    e.c(b.B());
                    i11++;
                }
                int i46 = customInfo2.mUnexpSubTypes;
                int i47 = customInfo.mUnexpSubTypes;
                if (i46 != i47) {
                    customInfo2.mUnexpSubTypes = i47;
                    i11++;
                }
                boolean z57 = customInfo2.mEnableMemoryGroup;
                boolean z58 = customInfo.mEnableMemoryGroup;
                if (z57 != z58) {
                    customInfo2.mEnableMemoryGroup = z58;
                    if (b.f9663d) {
                        JNIBridge.set(35, z58);
                    }
                    i11++;
                }
                boolean z59 = customInfo2.mEnableLibcMallocDetail;
                boolean z60 = customInfo.mEnableLibcMallocDetail;
                if (z59 != z60) {
                    customInfo2.mEnableLibcMallocDetail = z60;
                    if (b.f9663d) {
                        JNIBridge.set(36, z60);
                    }
                    i11++;
                }
                String str4 = customInfo2.mLibcMallocDetailConfig;
                String str5 = customInfo.mLibcMallocDetailConfig;
                if (str4 != str5) {
                    customInfo2.mLibcMallocDetailConfig = str5;
                    if (b.f9663d) {
                        JNIBridge.set(131, str5);
                    }
                    i11++;
                }
                if (!a(customInfo.mUserId, customInfo2.mUserId)) {
                    customInfo2.mUserId = customInfo.mUserId;
                    i11++;
                }
                if (!a(customInfo.mChannel, customInfo2.mChannel)) {
                    customInfo2.mChannel = customInfo.mChannel;
                    i11++;
                }
                if (!a(customInfo2.mCrashLogUploadUrl, customInfo.mCrashLogUploadUrl)) {
                    customInfo2.mCrashLogUploadUrl = customInfo.mCrashLogUploadUrl;
                    i11++;
                }
                if (!a(customInfo2.mCrashRateUploadUrl, customInfo.mCrashRateUploadUrl)) {
                    String str6 = customInfo.mCrashRateUploadUrl;
                    customInfo2.mCrashRateUploadUrl = str6;
                    i11++;
                    if (b.f9663d) {
                        JNIBridge.set(38, str6);
                    }
                }
                if (!a(customInfo2.mCrashSDKAuthUrl, customInfo.mCrashSDKAuthUrl)) {
                    String str7 = customInfo.mCrashSDKAuthUrl;
                    customInfo2.mCrashSDKAuthUrl = str7;
                    i11++;
                    if (b.f9663d) {
                        JNIBridge.set(39, str7);
                    }
                }
                i10 = i11;
            }
        }
        return i10;
    }

    public static CustomInfo a(CustomInfo customInfo, Bundle bundle) {
        if (customInfo == null) {
            CustomInfo customInfo2 = f9747d;
            if (customInfo2 == null) {
                customInfo = new CustomInfo();
            } else {
                customInfo = new CustomInfo(customInfo2);
            }
        }
        Field[] fields = customInfo.getClass().getFields();
        for (String str : bundle.keySet()) {
            for (Field field : fields) {
                if (field.getName().equals(str)) {
                    Object obj = bundle.get(str);
                    try {
                        field.set(customInfo, obj);
                    } catch (Exception e10) {
                        com.uc.crashsdk.a.g.a(e10);
                        StringBuilder sb = new StringBuilder("Field ");
                        sb.append(str);
                        sb.append(" must be a ");
                        sb.append(field.getType().getName());
                        sb.append(", but give a ");
                        sb.append(obj != null ? obj.getClass().getName() : "(null)");
                        throw new IllegalArgumentException(sb.toString());
                    }
                }
            }
        }
        return customInfo;
    }

    public static VersionInfo a(Bundle bundle) {
        VersionInfo versionInfo;
        VersionInfo versionInfo2 = f9748e;
        if (versionInfo2 == null) {
            versionInfo = new VersionInfo();
        } else {
            versionInfo = new VersionInfo(versionInfo2);
        }
        String string = bundle.getString("mVersion");
        if (!com.uc.crashsdk.a.g.a(string)) {
            versionInfo.mVersion = string;
        }
        String string2 = bundle.getString("mSubVersion");
        if (!com.uc.crashsdk.a.g.a(string2)) {
            versionInfo.mSubVersion = string2;
        }
        String string3 = bundle.getString("mBuildId");
        if (!com.uc.crashsdk.a.g.a(string3)) {
            versionInfo.mBuildId = string3;
        }
        String string4 = bundle.getString("crver");
        if (!com.uc.crashsdk.a.g.a(string4)) {
            a.f9579b = string4;
            af();
        }
        return versionInfo;
    }

    private static boolean a(String str, String str2) {
        if (str == str2) {
            return true;
        }
        if (str == null || str2 == null) {
            return false;
        }
        return str.equals(str2);
    }
}
