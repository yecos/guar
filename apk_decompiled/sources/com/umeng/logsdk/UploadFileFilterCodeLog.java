package com.umeng.logsdk;

import android.text.TextUtils;
import com.efs.sdk.base.Constants;
import com.efs.sdk.base.core.cache.CacheManager;
import com.efs.sdk.base.core.cache.IFileFilter;
import com.efs.sdk.base.core.model.LogDto;
import com.efs.sdk.base.core.util.FileUtil;
import com.efs.sdk.base.core.util.Log;
import java.io.File;
import java.util.List;

/* loaded from: classes3.dex */
public class UploadFileFilterCodeLog implements IFileFilter {

    /* renamed from: a, reason: collision with root package name */
    private ULogConfigManager f11311a;

    /* renamed from: b, reason: collision with root package name */
    private b f11312b;

    /* renamed from: c, reason: collision with root package name */
    private String f11313c;

    /* renamed from: e, reason: collision with root package name */
    private String f11315e;

    /* renamed from: g, reason: collision with root package name */
    private long f11317g;

    /* renamed from: h, reason: collision with root package name */
    private long f11318h;

    /* renamed from: d, reason: collision with root package name */
    private int f11314d = -1;

    /* renamed from: f, reason: collision with root package name */
    private int f11316f = -1;

    private void a() {
        Log.i("UploadFileFilterCodeLog", "reset task.");
        this.f11312b = null;
        this.f11313c = null;
        this.f11314d = -1;
        this.f11315e = null;
        this.f11316f = -1;
        this.f11317g = 0L;
        this.f11318h = 0L;
    }

    @Override // com.efs.sdk.base.core.cache.IFileFilter
    public boolean filter(File file) {
        StringBuilder sb;
        String sb2;
        StringBuilder sb3;
        List<b> taskList;
        if (this.f11312b == null) {
            ULogConfigManager uLogConfigManager = ULogManager.getULogConfigManager();
            this.f11311a = uLogConfigManager;
            if (uLogConfigManager != null && (taskList = uLogConfigManager.getTaskList()) != null && !taskList.isEmpty()) {
                int i10 = 0;
                while (true) {
                    if (i10 >= taskList.size()) {
                        break;
                    }
                    b bVar = taskList.get(i10);
                    this.f11312b = bVar;
                    if (bVar != null) {
                        int i11 = bVar.f11337b;
                        this.f11314d = i11;
                        if (i11 == 0) {
                            this.f11313c = bVar.f11336a;
                            this.f11315e = bVar.f11339d;
                            this.f11316f = bVar.f11338c;
                            this.f11317g = bVar.f11340e;
                            this.f11318h = bVar.f11341f;
                            break;
                        }
                        a();
                    }
                    i10++;
                }
            }
        }
        if (this.f11312b != null && this.f11314d == 0) {
            Log.i("UploadFileFilterCodeLog", this.f11313c + ", " + this.f11315e + ", " + this.f11316f + ", " + this.f11317g + ", " + this.f11318h);
            String name = file.getName();
            LogDto createLogDtoByName = (TextUtils.isEmpty(name) || !name.startsWith(Constants.LOG_TYPE_CODELOGPERF)) ? FileUtil.createLogDtoByName(name) : FileUtil.createCodeLogDtoByName(name);
            if (createLogDtoByName == null) {
                CacheManager.getInstance().onChangeDtoError(file);
                return true;
            }
            long beginTime = createLogDtoByName.getBeginTime();
            createLogDtoByName.getEndTime();
            String did = createLogDtoByName.getDid();
            String uid = createLogDtoByName.getUid();
            if (beginTime >= this.f11317g && beginTime <= this.f11318h) {
                Log.i("UploadFileFilterCodeLog", "task target type is " + this.f11316f);
                int i12 = this.f11316f;
                if (i12 == 1) {
                    if (TextUtils.isEmpty(this.f11315e) || TextUtils.isEmpty(did) || !this.f11315e.equals(did)) {
                        sb2 = "taskTarget is " + this.f11315e + ", did is " + did;
                        Log.i("UploadFileFilterCodeLog", sb2);
                    } else {
                        sb3 = new StringBuilder("task is ");
                    }
                } else if (i12 == 0) {
                    if (TextUtils.isEmpty(this.f11315e) || TextUtils.isEmpty(uid) || !this.f11315e.equals(uid)) {
                        sb = new StringBuilder("taskTarget is ");
                        sb.append(this.f11315e);
                        sb.append(", uid is ");
                        sb.append(uid);
                    } else {
                        sb3 = new StringBuilder("task is ");
                    }
                }
                sb3.append(this.f11313c);
                sb3.append(", target is ");
                sb3.append(this.f11315e);
                sb3.append(", file time is ");
                sb3.append(beginTime);
                Log.i("UploadFileFilterCodeLog", sb3.toString());
                return false;
            }
            sb = new StringBuilder("time is ");
            sb.append(beginTime >= this.f11317g);
            sb.append(", is ");
            sb.append(beginTime <= this.f11318h);
            sb2 = sb.toString();
            Log.i("UploadFileFilterCodeLog", sb2);
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0033, code lost:
    
        if (r0 != null) goto L10;
     */
    @Override // com.efs.sdk.base.core.cache.IFileFilter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void finish() {
        /*
            r6 = this;
            java.lang.String r0 = "clear task."
            java.lang.String r1 = "UploadFileFilterCodeLog"
            com.efs.sdk.base.core.util.Log.i(r1, r0)
            long r2 = java.lang.System.currentTimeMillis()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r4 = "taskEndTime is "
            r0.<init>(r4)
            long r4 = r6.f11318h
            r0.append(r4)
            java.lang.String r4 = ", current time is "
            r0.append(r4)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.efs.sdk.base.core.util.Log.i(r1, r0)
            long r4 = r6.f11318h
            int r0 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r0 <= 0) goto L36
            java.lang.String r0 = "future task. not remove."
            com.efs.sdk.base.core.util.Log.i(r1, r0)
            com.umeng.logsdk.ULogConfigManager r0 = r6.f11311a
            if (r0 == 0) goto L46
            goto L41
        L36:
            com.umeng.logsdk.ULogConfigManager r0 = r6.f11311a
            if (r0 == 0) goto L46
            java.lang.String r1 = r6.f11313c
            r0.reMoveTaskFroSP(r1)
            com.umeng.logsdk.ULogConfigManager r0 = r6.f11311a
        L41:
            com.umeng.logsdk.b r1 = r6.f11312b
            r0.removeTask(r1)
        L46:
            r6.a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.logsdk.UploadFileFilterCodeLog.finish():void");
    }

    @Override // com.efs.sdk.base.core.cache.IFileFilter
    public boolean hasTask() {
        List<b> taskList;
        ULogConfigManager uLogConfigManager = ULogManager.getULogConfigManager();
        if (uLogConfigManager == null || (taskList = uLogConfigManager.getTaskList()) == null || taskList.isEmpty()) {
            return false;
        }
        for (int i10 = 0; i10 < taskList.size(); i10++) {
            b bVar = taskList.get(i10);
            if (bVar != null && bVar.f11337b == 0) {
                return true;
            }
        }
        return false;
    }

    @Override // com.efs.sdk.base.core.cache.IFileFilter
    public void finish(boolean z10, boolean z11) {
    }
}
