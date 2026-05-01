package com.hpplay.sdk.source.log;

import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.hpplay.common.utils.ContextPath;
import com.hpplay.sdk.source.common.store.Preference;
import com.hpplay.sdk.source.common.store.Session;
import com.hpplay.sdk.source.utils.FileUtils;
import java.io.File;

/* loaded from: classes3.dex */
public class LogCache {
    private static final long MIN_LOG_CACHE_SIZE = 31457280;
    private static final String TAG = "LogCache";

    public static String checkSdFileDir(String str) {
        try {
            if (!new File(str).exists()) {
                File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), Session.getInstance().getContext().getPackageName());
                if (Build.VERSION.SDK_INT >= 29) {
                    file = Session.getInstance().getContext().getExternalFilesDir(null);
                    SourceLog.i(TAG, "checkSdFileDir getExternalFilesDir: " + file);
                }
                SourceLog.i(TAG, "checkSdFileDir path: " + file.getAbsolutePath());
                if (file.exists()) {
                    return file.getAbsolutePath();
                }
                boolean mkdir = file.mkdir();
                SourceLog.i(TAG, "checkSdFileDir path.mkdir Success: " + mkdir);
                if (mkdir && !TextUtils.isEmpty(file.getAbsolutePath())) {
                    return file.getAbsolutePath();
                }
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, "checkSdFileDir " + e10);
        }
        return str;
    }

    public static String getErrorLogFilePath() {
        String jointPath = ContextPath.jointPath(Session.getInstance().getContextPath().getPath(ContextPath.DATA_FILE), "source/a/log/error");
        File file = new File(jointPath);
        if (!file.exists()) {
            boolean mkdirs = file.mkdirs();
            SourceLog.i(TAG, "getErrorLogFilePath " + jointPath + " isFileMakeSuccess   " + mkdirs);
            if (!mkdirs) {
                jointPath = "";
            }
        }
        SourceLog.i(TAG, "getErrorLogFilePath logZipPath:" + jointPath);
        return jointPath;
    }

    public static String getLogDir() {
        if (FileUtils.getRomAvailableSize() < 62914560) {
            SourceLog.i(TAG, "getLogDir getRomAvailableSize  " + FileUtils.getRomAvailableSize() + ", MIN_LOG_CACHE_SIZE:" + MIN_LOG_CACHE_SIZE);
            return null;
        }
        String str = Preference.getInstance().get(Preference.KEY_LOG_DIR);
        if (!TextUtils.isEmpty(str) && !str.contains(Session.getInstance().getContextPath().getPath(ContextPath.SDCARD_FILE))) {
            SourceLog.i(TAG, "getLogDir cache " + str);
            return str;
        }
        String jointPath = ContextPath.jointPath(Session.getInstance().getContextPath().getPath(ContextPath.DATA_FILE), "source/a/log");
        File file = new File(jointPath);
        if (!file.exists()) {
            SourceLog.i(TAG, "getLogDir DATA_FILE isFileMakeDirSuccess  " + file.mkdirs());
        }
        Preference.getInstance().put(Preference.KEY_LOG_DIR, jointPath);
        SourceLog.i(TAG, "getLogDir cache data " + jointPath);
        return jointPath;
    }

    public static String getLogOutputFilePath() {
        String jointPath = ContextPath.jointPath(Session.getInstance().getContextPath().getPath(ContextPath.DATA_FILE), "source/a/log.zip");
        File file = new File(jointPath);
        if (file.exists()) {
            file.delete();
        }
        try {
            SourceLog.i(TAG, "getLogOutputFilePath DATA_FILE isFileCreateSuccess  " + file.createNewFile());
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
        SourceLog.i(TAG, "getLogOutputFilePath data");
        return jointPath;
    }
}
