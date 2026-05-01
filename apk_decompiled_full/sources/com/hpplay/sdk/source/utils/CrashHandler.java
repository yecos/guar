package com.hpplay.sdk.source.utils;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.hpplay.sdk.source.business.cloud.SourceDataReport;
import com.hpplay.sdk.source.log.SourceLog;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.titans.entity.CdnType;
import com.umeng.analytics.pro.bt;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class CrashHandler implements Thread.UncaughtExceptionHandler {
    private static final String CRASH_JAVA = "209001";
    public static final String TAG = "CrashHandlerUtil";
    private static CrashHandler mCrashHandler;
    private Map<String, String> infos = new HashMap();
    private Context mContext;
    private Thread.UncaughtExceptionHandler mDefaultHandler;

    private HashMap<String, String> getDeviceInfos() {
        String value;
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("st", CdnType.DIGITAL_TYPE_PEERSTAR);
        hashMap.put("sn", "1");
        hashMap.put("et", CRASH_JAVA);
        hashMap.put("logt", "1");
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, String> entry : this.infos.entrySet()) {
            String key = entry.getKey();
            value = entry.getValue();
            stringBuffer.append(key + Operator.Operation.EQUALS + value + "\n");
            key.hashCode();
            switch (key) {
                case "ID":
                    hashMap.put(bt.aI, value);
                    break;
                case "BOARD":
                    hashMap.put("bo", value);
                    break;
                case "BRAND":
                    hashMap.put("br", value);
                    break;
                case "MODEL":
                    hashMap.put("m", value);
                    break;
                case "MANUFACTURER":
                    hashMap.put("mf", value);
                    break;
                case "PRODUCT":
                    hashMap.put(bt.aD, value);
                    break;
                case "versionName":
                    hashMap.put("vn", value);
                    break;
                case "CPU_ABI":
                    hashMap.put("ca", value);
                    break;
            }
        }
        return hashMap;
    }

    public static CrashHandler getInstance() {
        synchronized (CrashHandler.class) {
            if (mCrashHandler == null) {
                mCrashHandler = new CrashHandler();
            }
        }
        return mCrashHandler;
    }

    private boolean handleException(Throwable th) {
        if (th == null) {
            return false;
        }
        SourceLog.w(TAG, "handleException :  " + th.toString());
        collectDeviceInfo();
        uploadToServer(th);
        return true;
    }

    private void uploadToServer(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
            cause.printStackTrace(printWriter);
        }
        printWriter.close();
        String obj = stringWriter.toString();
        HashMap<String, String> deviceInfos = getDeviceInfos();
        SourceLog.i(TAG, "crashInfo  --- > " + obj);
        deviceInfos.put("cd", obj);
        SourceDataReport.getInstance().crashDataUpload(deviceInfos);
    }

    public void collectDeviceInfo() {
        try {
            this.infos.put("versionName", "4.12.14");
            for (Field field : Build.class.getDeclaredFields()) {
                field.setAccessible(true);
                this.infos.put(field.getName(), field.get(null).toString());
            }
        } catch (Exception e10) {
            SourceLog.w("an error occured when collect package info", e10);
        }
    }

    public void init(Context context) {
        this.mContext = context;
        this.mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        if (th != null) {
            SourceLog.i(TAG, "uncaughtException " + th.toString());
        } else {
            SourceLog.i(TAG, "uncaughtException ex is null");
        }
        if (!handleException(th) && (uncaughtExceptionHandler = this.mDefaultHandler) != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
            return;
        }
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e10) {
            SourceLog.w(TAG, "error : ", e10);
        }
        Process.killProcess(Process.myPid());
    }

    public void uploadExceptionToServer(String str) {
        HashMap<String, String> deviceInfos = getDeviceInfos();
        SourceLog.i(TAG, "crashInfo  --- > " + str);
        deviceInfos.put("cd", "Exception-----------> " + str);
        SourceDataReport.getInstance().crashDataUpload(deviceInfos);
    }
}
