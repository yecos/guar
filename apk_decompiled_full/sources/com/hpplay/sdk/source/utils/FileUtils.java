package com.hpplay.sdk.source.utils;

import android.os.Environment;
import android.os.StatFs;
import com.hpplay.sdk.source.log.SourceLog;

/* loaded from: classes3.dex */
public class FileUtils {
    private static final String TAG = "FileUtils";

    public static long getRomAvailableSize() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong();
    }

    public static long getSDAvailableSize() {
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return statFs.getBlockSizeLong() * statFs.getAvailableBlocksLong();
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            return 0L;
        }
    }
}
