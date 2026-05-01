package com.hpplay.common.utils;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.hpplay.common.log.LeLog;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class ContextPath {
    public static final String APP_PATH = "app_path";
    public static final String CACHE_DATA_APK = "cache_data_apk";
    public static final String CACHE_DATA_AV = "cache_data_av";
    public static final String CACHE_DATA_COMMON = "cache_data_common";
    public static final String CACHE_DATA_FILE = "cache_data_file";
    public static final String CACHE_DATA_IMG = "cache_data_img";
    public static final String CACHE_HPPLAY = "cache_hpplay";
    public static final String DATA_APK = "data_apk";
    public static final String DATA_AV = "data_av";
    public static final String DATA_COMMON = "data_common";
    public static final String DATA_FILE = "data_file";
    public static final String DATA_HPPLAY = "data_hpplay";
    public static final String DATA_IMG = "data_img";
    public static final String DATA_UPDATE = "data_update";
    public static final String LIB = "lib";
    public static final String SDCARD_APK = "sdcard_apk";
    public static final String SDCARD_AV = "sdcard_av";
    public static final String SDCARD_COMMON = "sdcard_common";
    public static final String SDCARD_FILE = "sdcard_file";
    public static final String SDCARD_HPPLAY = "sdcard_hpplay";
    public static final String SDCARD_IMG = "sdcard_img";
    public static final String SDCARD_UPDATE = "sdcard_update";
    private static final String TAG = "ContextPath";
    public static final int TYPE_SOURCE_APP = 3;
    public static final int TYPE_SOURCE_SDK = 2;
    public static final int TYPE_THINK_APP = 1;
    public static final int TYPE_THINK_SDK = 0;
    private static Map<Integer, ContextPath> mPathMap = new HashMap();
    private Map<String, String> dirMap = new HashMap();

    private ContextPath(Context context, int i10, String str) {
        initDirs(context, i10, str);
    }

    public static ContextPath getInstance(Context context, int i10, String str) {
        ContextPath contextPath = mPathMap.get(Integer.valueOf(i10));
        if (contextPath != null) {
            return contextPath;
        }
        ContextPath contextPath2 = new ContextPath(context, i10, str);
        mPathMap.put(Integer.valueOf(i10), contextPath2);
        return contextPath2;
    }

    private void initDirs(Context context, int i10, String str) {
        String str2;
        if (context == null) {
            throw new NullPointerException("context con not null");
        }
        this.dirMap.clear();
        String absolutePath = context.getCacheDir().getAbsolutePath();
        makeDir(new String[]{CACHE_DATA_FILE, CACHE_DATA_IMG, CACHE_DATA_AV, CACHE_DATA_APK, CACHE_DATA_COMMON}, jointPath(jointPath(absolutePath, "hpplay")));
        this.dirMap.put(CACHE_HPPLAY, absolutePath);
        String absolutePath2 = context.getFilesDir().getAbsolutePath();
        makeDir(new String[]{DATA_FILE, DATA_IMG, DATA_AV, DATA_APK, DATA_COMMON, DATA_UPDATE}, jointPath(absolutePath2, "hpplay"));
        this.dirMap.put(DATA_HPPLAY, absolutePath2);
        this.dirMap.put(APP_PATH, new File(context.getPackageResourcePath()).getParent());
        String str3 = "";
        String str4 = i10 != 0 ? i10 != 1 ? i10 != 2 ? i10 != 3 ? "" : "source/app" : "source/sdk" : "sink/app" : "sink/sdk";
        try {
            if (Environment.getExternalStorageDirectory() != null) {
                str2 = Environment.getExternalStorageDirectory().getPath();
            } else {
                LeLog.w(TAG, "can not get sdcard path, use default");
                str2 = "/mnt/sdcard";
            }
            str3 = !TextUtils.isEmpty(str) ? jointPath(str2, str, str4) : jointPath(str2, context.getPackageName(), str4);
            makeDir(new String[]{SDCARD_FILE, SDCARD_IMG, SDCARD_AV, SDCARD_APK, SDCARD_COMMON, SDCARD_UPDATE}, str3);
        } catch (Exception e10) {
            LeLog.w(TAG, e10);
        }
        this.dirMap.put(SDCARD_HPPLAY, str3);
        this.dirMap.put(LIB, context.getFilesDir().getParent() + "/lib");
    }

    public static String jointPath(Object... objArr) {
        StringBuilder sb = new StringBuilder();
        for (int i10 = 0; i10 < objArr.length; i10++) {
            if (i10 == objArr.length - 1) {
                sb.append(objArr[i10]);
            } else {
                sb.append(objArr[i10]);
                sb.append(File.separator);
            }
        }
        return sb.toString();
    }

    private void makeDir(String[] strArr, String str) {
        String[] strArr2 = {"file", "image", "av", "apk", "common", "hpdata"};
        for (int i10 = 0; i10 < strArr.length; i10++) {
            if (i10 < 6) {
                String jointPath = jointPath(str, strArr2[i10]);
                mkdirs(jointPath);
                this.dirMap.put(strArr[i10], jointPath);
            }
        }
    }

    private void mkdirs(String str) {
        File file = new File(str);
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    public String getPath(String str) {
        String str2 = this.dirMap.get(str);
        return str2 == null ? "" : str2;
    }
}
