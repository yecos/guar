package com.efs.sdk.base.core.cache;

import android.os.Handler;
import android.os.Message;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.FileUtil;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.concurrent.WorkThreadUtil;
import com.titans.entity.CdnType;
import java.io.File;

/* loaded from: classes.dex */
public final class b extends Handler implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    boolean f6111a;

    /* renamed from: b, reason: collision with root package name */
    boolean f6112b;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final b f6113a = new b(0);
    }

    public /* synthetic */ b(byte b10) {
        this();
    }

    public static b a() {
        return a.f6113a;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (message.what == 2) {
            WorkThreadUtil.submit(this);
            return;
        }
        Log.w("efs.cache", "disk listener not support command: " + message.what);
    }

    @Override // java.lang.Runnable
    public final void run() {
        CacheManager.getInstance();
        File h10 = com.efs.sdk.base.core.util.a.h(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid());
        if (h10.exists()) {
            for (File file : FileUtil.listFiles(h10)) {
                if (CacheManager.a(file.getName())) {
                    CacheManager.a(file);
                }
            }
        }
        CacheManager.getInstance();
        File i10 = com.efs.sdk.base.core.util.a.i(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid());
        if (i10.exists()) {
            for (File file2 : FileUtil.listFiles(i10)) {
                if (CacheManager.a(file2.getName())) {
                    CacheManager.a(file2);
                }
            }
        }
        long parseLong = Long.parseLong(com.efs.sdk.base.core.config.remote.b.a().a("disk_bytes", "4194304"));
        long folderSize = FileUtil.getFolderSize(com.efs.sdk.base.core.util.a.h(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid())) + FileUtil.getFolderSize(com.efs.sdk.base.core.util.a.d(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid()));
        boolean z10 = folderSize < parseLong;
        this.f6111a = z10;
        if (!z10) {
            Log.w("efs.cache", "Cache Limited! curr " + folderSize + "byte, max " + parseLong + " byte.");
        }
        long parseLong2 = Long.parseLong(com.efs.sdk.base.core.config.remote.b.a().a("apm_codelog_store_max", CdnType.DIGITAL_TYPE_PCDN)) * 1024 * 1024;
        long folderSize2 = FileUtil.getFolderSize(com.efs.sdk.base.core.util.a.i(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid())) + FileUtil.getFolderSize(com.efs.sdk.base.core.util.a.e(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid()));
        boolean z11 = folderSize2 < parseLong2;
        this.f6112b = z11;
        if (!z11) {
            Log.w("efs.cache", "code log. Cache Limited! curr " + folderSize2 + "byte, max " + parseLong2 + " byte.");
        }
        sendEmptyMessageDelayed(2, 600000L);
    }

    private b() {
        super(com.efs.sdk.base.core.util.concurrent.a.f6239a.getLooper());
        this.f6111a = true;
        this.f6112b = true;
        sendEmptyMessageDelayed(2, 60000L);
    }
}
