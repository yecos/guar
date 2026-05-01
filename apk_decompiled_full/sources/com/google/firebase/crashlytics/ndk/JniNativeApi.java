package com.google.firebase.crashlytics.ndk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.os.Build;
import android.text.TextUtils;
import com.google.firebase.crashlytics.internal.Logger;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
class JniNativeApi implements NativeApi {
    private static final FilenameFilter APK_FILTER = new FilenameFilter() { // from class: com.google.firebase.crashlytics.ndk.e
        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String str) {
            boolean lambda$static$0;
            lambda$static$0 = JniNativeApi.lambda$static$0(file, str);
            return lambda$static$0;
        }
    };
    private static final boolean LIB_CRASHLYTICS_LOADED;
    private final Context context;

    static {
        boolean z10;
        try {
            System.loadLibrary("crashlytics");
            z10 = true;
        } catch (UnsatisfiedLinkError e10) {
            Logger.getLogger().e("libcrashlytics could not be loaded. This APK may not have been compiled for this device's architecture. NDK crashes will not be reported to Crashlytics:\n" + e10.getLocalizedMessage());
            z10 = false;
        }
        LIB_CRASHLYTICS_LOADED = z10;
    }

    public JniNativeApi(Context context) {
        this.context = context;
    }

    public static void addSplitSourceDirs(List<String> list, PackageInfo packageInfo) {
        String[] strArr;
        String[] strArr2;
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        strArr = applicationInfo.splitSourceDirs;
        if (strArr != null) {
            strArr2 = applicationInfo.splitSourceDirs;
            Collections.addAll(list, strArr2);
        }
        File file = new File(applicationInfo.dataDir, String.format("files/splitcompat/%s/verified-splits", getVersionCodeAsString(packageInfo)));
        if (!file.exists()) {
            Logger.getLogger().d("No dynamic features found at " + file.getAbsolutePath());
            return;
        }
        File[] listFiles = file.listFiles(APK_FILTER);
        if (listFiles == null) {
            listFiles = new File[0];
        }
        Logger.getLogger().d("Found " + listFiles.length + " APKs in " + file.getAbsolutePath());
        for (File file2 : listFiles) {
            Logger.getLogger().d("Adding " + file2.getName() + " to classpath.");
            list.add(file2.getAbsolutePath());
        }
    }

    private static int getPackageInfoFlags() {
        return Build.VERSION.SDK_INT >= 24 ? 9216 : 1024;
    }

    private static String getVersionCodeAsString(PackageInfo packageInfo) {
        long longVersionCode;
        if (Build.VERSION.SDK_INT < 28) {
            return Integer.toString(packageInfo.versionCode);
        }
        longVersionCode = packageInfo.getLongVersionCode();
        return Long.toString(longVersionCode);
    }

    public static boolean isAtLeastLollipop() {
        return Build.VERSION.SDK_INT >= 21;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$static$0(File file, String str) {
        return str.toLowerCase().endsWith(".apk");
    }

    private native boolean nativeInit(String[] strArr, Object obj);

    @Override // com.google.firebase.crashlytics.ndk.NativeApi
    public boolean initialize(String str, AssetManager assetManager) {
        String[] makePackagePaths = makePackagePaths(Build.CPU_ABI);
        if (makePackagePaths.length < 2) {
            return false;
        }
        return LIB_CRASHLYTICS_LOADED && nativeInit(new String[]{makePackagePaths[0], makePackagePaths[1], str}, assetManager);
    }

    public String[] makePackagePaths(String str) {
        try {
            PackageInfo packageInfo = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), getPackageInfoFlags());
            ArrayList<String> arrayList = new ArrayList(10);
            arrayList.add(packageInfo.applicationInfo.sourceDir);
            if (isAtLeastLollipop()) {
                addSplitSourceDirs(arrayList, packageInfo);
            }
            String[] strArr = packageInfo.applicationInfo.sharedLibraryFiles;
            if (strArr != null) {
                Collections.addAll(arrayList, strArr);
            }
            ArrayList arrayList2 = new ArrayList(10);
            File parentFile = new File(packageInfo.applicationInfo.nativeLibraryDir).getParentFile();
            if (parentFile != null) {
                arrayList2.add(new File(parentFile, str).getPath());
                if (str.startsWith("arm64")) {
                    arrayList2.add(new File(parentFile, "arm64").getPath());
                } else if (str.startsWith("arm")) {
                    arrayList2.add(new File(parentFile, "arm").getPath());
                }
            }
            for (String str2 : arrayList) {
                if (str2.endsWith(".apk")) {
                    arrayList2.add(str2 + "!/lib/" + str);
                }
            }
            arrayList2.add(System.getProperty("java.library.path"));
            arrayList2.add(packageInfo.applicationInfo.nativeLibraryDir);
            String str3 = File.pathSeparator;
            return new String[]{TextUtils.join(str3, arrayList), TextUtils.join(str3, arrayList2)};
        } catch (PackageManager.NameNotFoundException e10) {
            Logger.getLogger().e("Unable to compose package paths", e10);
            throw new RuntimeException(e10);
        }
    }
}
