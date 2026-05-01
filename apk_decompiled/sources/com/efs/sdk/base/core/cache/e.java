package com.efs.sdk.base.core.cache;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.efs.sdk.base.Constants;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.d.f;
import com.efs.sdk.base.core.model.LogDto;
import com.efs.sdk.base.core.util.FileUtil;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.secure.EncodeUtil;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class e extends Handler implements d {

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, a> f6114a;

    /* renamed from: b, reason: collision with root package name */
    private com.efs.sdk.base.core.c.a.d f6115b;

    /* renamed from: c, reason: collision with root package name */
    private com.efs.sdk.base.core.c.a.c f6116c;

    public static class a extends FileOutputStream {

        /* renamed from: a, reason: collision with root package name */
        long f6117a;

        /* renamed from: b, reason: collision with root package name */
        File f6118b;

        public a(File file) {
            super(file);
            this.f6118b = file;
            this.f6117a = System.currentTimeMillis();
        }
    }

    public e() {
        super(com.efs.sdk.base.core.util.concurrent.a.f6239a.getLooper());
        this.f6114a = new ConcurrentHashMap<>();
        this.f6115b = new com.efs.sdk.base.core.c.a.d();
        this.f6116c = new com.efs.sdk.base.core.c.a.c();
    }

    private static long b(String str) {
        Map<String, String> c10 = com.efs.sdk.base.core.config.remote.b.a().c();
        String concat = "record_accumulation_time_".concat(String.valueOf(str));
        if (!c10.containsKey(concat)) {
            return 60000L;
        }
        String str2 = c10.get(concat);
        if (TextUtils.isEmpty(str2)) {
            return 60000L;
        }
        try {
            return Math.max(Long.parseLong(str2) * 1000, 1000L);
        } catch (Throwable th) {
            Log.e("efs.cache", "get cache interval error", th);
            return 60000L;
        }
    }

    private void c(String str) {
        a aVar;
        com.efs.sdk.base.core.d.f fVar;
        com.efs.sdk.base.core.d.f fVar2;
        if (this.f6114a.containsKey(str) && (aVar = this.f6114a.get(str)) != null) {
            try {
                aVar.flush();
                FileUtil.safeClose(aVar);
                Log.i("RecordLogCacheProcessor", "save file, type is ".concat(String.valueOf(str)));
                a(aVar.f6118b);
            } catch (Throwable th) {
                try {
                    th.printStackTrace();
                    this.f6114a.remove(str);
                    if ("wa".equalsIgnoreCase(str)) {
                        return;
                    }
                    fVar2 = f.a.f6196a;
                    fVar2.f6194c.c();
                } finally {
                    this.f6114a.remove(str);
                    if (!"wa".equalsIgnoreCase(str)) {
                        fVar = f.a.f6196a;
                        fVar.f6194c.c();
                    }
                }
            }
        }
    }

    @Override // com.efs.sdk.base.core.cache.d
    public final void a(LogDto logDto) {
        Message obtain = Message.obtain();
        obtain.obj = logDto;
        obtain.what = 0;
        sendMessage(obtain);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i10 = message.what;
        if (i10 != 0) {
            if (i10 != 1) {
                return;
            }
            Object obj = message.obj;
            if (obj instanceof String) {
                c(obj.toString());
                return;
            }
            return;
        }
        LogDto logDto = (LogDto) message.obj;
        for (int i11 = 0; i11 < 3; i11++) {
            try {
                a b10 = b(logDto);
                if (b10 == null) {
                    Log.w("efs.cache", "writer is null for type " + logDto.getLogType());
                    return;
                }
                if (b10.getChannel().position() + logDto.getData().length > 819200) {
                    c(logDto.getLogType());
                    b10 = b(logDto);
                    if (b10 == null) {
                        Log.w("efs.cache", "writer is null for type " + logDto.getLogType());
                        return;
                    }
                }
                b10.write(EncodeUtil.base64Encode(logDto.getData()));
                b10.write("\n".getBytes());
                return;
            } catch (Throwable th) {
                Log.e("efs.cache", "cache file error", th);
            }
        }
    }

    @Override // com.efs.sdk.base.core.cache.d
    public final boolean a(File file, LogDto logDto) {
        if (!logDto.isCp()) {
            a(file);
            return false;
        }
        if (!file.exists()) {
            return false;
        }
        logDto.setFile(file);
        logDto.setSendImediately(true);
        logDto.setLogBodyType(1);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.efs.sdk.base.core.cache.e.a b(com.efs.sdk.base.core.model.LogDto r6) {
        /*
            r5 = this;
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.efs.sdk.base.core.cache.e$a> r0 = r5.f6114a
            java.lang.String r1 = r6.getLogType()
            boolean r0 = r0.containsKey(r1)
            if (r0 == 0) goto L19
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.efs.sdk.base.core.cache.e$a> r0 = r5.f6114a
            java.lang.String r6 = r6.getLogType()
            java.lang.Object r6 = r0.get(r6)
            com.efs.sdk.base.core.cache.e$a r6 = (com.efs.sdk.base.core.cache.e.a) r6
            return r6
        L19:
            java.lang.String r0 = r6.getLogType()
            java.lang.String r1 = "codelogperf"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L41
            java.lang.String r0 = com.efs.sdk.base.core.util.FileUtil.getCodelogFileName(r6)
            java.io.File r2 = new java.io.File
            com.efs.sdk.base.core.config.GlobalEnvStruct r3 = com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct()
            android.content.Context r3 = r3.mAppContext
            com.efs.sdk.base.core.config.GlobalEnvStruct r4 = com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct()
            java.lang.String r4 = r4.getAppid()
            java.io.File r3 = com.efs.sdk.base.core.util.a.g(r3, r4)
            r2.<init>(r3, r0)
            goto L5c
        L41:
            java.lang.String r0 = com.efs.sdk.base.core.util.FileUtil.getFileName(r6)
            java.io.File r2 = new java.io.File
            com.efs.sdk.base.core.config.GlobalEnvStruct r3 = com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct()
            android.content.Context r3 = r3.mAppContext
            com.efs.sdk.base.core.config.GlobalEnvStruct r4 = com.efs.sdk.base.core.controller.ControllerCenter.getGlobalEnvStruct()
            java.lang.String r4 = r4.getAppid()
            java.io.File r3 = com.efs.sdk.base.core.util.a.f(r3, r4)
            r2.<init>(r3, r0)
        L5c:
            r0 = 0
            com.efs.sdk.base.core.cache.e$a r3 = new com.efs.sdk.base.core.cache.e$a     // Catch: java.lang.Throwable -> Lac
            r3.<init>(r2)     // Catch: java.lang.Throwable -> Lac
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.efs.sdk.base.core.cache.e$a> r0 = r5.f6114a     // Catch: java.lang.Throwable -> Laa
            java.lang.String r4 = r6.getLogType()     // Catch: java.lang.Throwable -> Laa
            java.lang.Object r0 = r0.putIfAbsent(r4, r3)     // Catch: java.lang.Throwable -> Laa
            com.efs.sdk.base.core.cache.e$a r0 = (com.efs.sdk.base.core.cache.e.a) r0     // Catch: java.lang.Throwable -> Laa
            if (r0 == 0) goto L77
            com.efs.sdk.base.core.util.FileUtil.safeClose(r3)     // Catch: java.lang.Throwable -> Laa
            com.efs.sdk.base.core.util.FileUtil.delete(r2)     // Catch: java.lang.Throwable -> Laa
            return r0
        L77:
            java.lang.String r0 = r6.getLogType()     // Catch: java.lang.Throwable -> Laa
            boolean r0 = r1.equals(r0)     // Catch: java.lang.Throwable -> Laa
            r1 = 1
            if (r0 == 0) goto L92
            android.os.Message r0 = android.os.Message.obtain()     // Catch: java.lang.Throwable -> Laa
            java.lang.String r2 = r6.getLogType()     // Catch: java.lang.Throwable -> Laa
            r0.obj = r2     // Catch: java.lang.Throwable -> Laa
            r0.what = r1     // Catch: java.lang.Throwable -> Laa
            r5.sendMessage(r0)     // Catch: java.lang.Throwable -> Laa
            goto Lb2
        L92:
            android.os.Message r0 = android.os.Message.obtain()     // Catch: java.lang.Throwable -> Laa
            java.lang.String r2 = r6.getLogType()     // Catch: java.lang.Throwable -> Laa
            r0.obj = r2     // Catch: java.lang.Throwable -> Laa
            r0.what = r1     // Catch: java.lang.Throwable -> Laa
            java.lang.String r1 = r6.getLogType()     // Catch: java.lang.Throwable -> Laa
            long r1 = b(r1)     // Catch: java.lang.Throwable -> Laa
            r5.sendMessageDelayed(r0, r1)     // Catch: java.lang.Throwable -> Laa
            goto Lb2
        Laa:
            r0 = move-exception
            goto Laf
        Lac:
            r1 = move-exception
            r3 = r0
            r0 = r1
        Laf:
            r0.printStackTrace()
        Lb2:
            java.lang.String r0 = "wa"
            java.lang.String r6 = r6.getLogType()
            boolean r6 = r0.equalsIgnoreCase(r6)
            if (r6 != 0) goto Lc7
            com.efs.sdk.base.core.d.f r6 = com.efs.sdk.base.core.d.f.a.a()
            com.efs.sdk.base.core.d.d r6 = r6.f6194c
            r6.b()
        Lc7:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.efs.sdk.base.core.cache.e.b(com.efs.sdk.base.core.model.LogDto):com.efs.sdk.base.core.cache.e$a");
    }

    @Override // com.efs.sdk.base.core.cache.d
    public final void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Message obtain = Message.obtain();
        obtain.obj = str;
        obtain.what = 1;
        sendMessage(obtain);
    }

    @Override // com.efs.sdk.base.core.cache.d
    public final void a(File file) {
        LogDto createLogDtoByName;
        String fileName;
        File h10;
        String name = file.getName();
        if (!TextUtils.isEmpty(name) && name.startsWith(Constants.LOG_TYPE_CODELOGPERF)) {
            createLogDtoByName = FileUtil.createCodeLogDtoByName(name);
        } else {
            createLogDtoByName = FileUtil.createLogDtoByName(name);
        }
        if (createLogDtoByName == null) {
            CacheManager.getInstance().onChangeDtoError(file);
            return;
        }
        if (a(createLogDtoByName, file) && createLogDtoByName.getData() != null && createLogDtoByName.getData().length > 0) {
            if (Constants.LOG_TYPE_CODELOGPERF.equals(createLogDtoByName.getLogType())) {
                fileName = FileUtil.getCodelogFileName(createLogDtoByName);
                h10 = com.efs.sdk.base.core.util.a.i(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid());
            } else {
                fileName = FileUtil.getFileName(createLogDtoByName);
                h10 = com.efs.sdk.base.core.util.a.h(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid());
            }
            File file2 = new File(h10, fileName);
            Log.i("RecordLogCacheProcessor", "upload file, name is ".concat(String.valueOf(name)));
            FileUtil.write(file2, createLogDtoByName.getData());
            FileUtil.delete(file);
            return;
        }
        CacheManager.getInstance().onChangeDtoError(file);
    }

    private boolean a(LogDto logDto, File file) {
        BufferedReader bufferedReader;
        FileReader fileReader;
        StringBuilder sb = new StringBuilder();
        FileReader fileReader2 = null;
        try {
            fileReader = new FileReader(file);
            try {
                bufferedReader = new BufferedReader(fileReader);
            } catch (Throwable th) {
                th = th;
                bufferedReader = null;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
        try {
            for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                String base64DecodeToStr = EncodeUtil.base64DecodeToStr(readLine.getBytes());
                if (!TextUtils.isEmpty(base64DecodeToStr)) {
                    sb.append(base64DecodeToStr);
                    sb.append("\n");
                }
            }
            logDto.setData(sb.toString().getBytes());
            logDto.setSendImediately(true);
            this.f6116c.a(logDto);
            logDto.setFile(file);
            FileUtil.safeClose(bufferedReader);
            FileUtil.safeClose(fileReader);
            return true;
        } catch (Throwable th3) {
            th = th3;
            fileReader2 = fileReader;
            try {
                Log.e("efs.cache", "local decode error", th);
                FileUtil.safeClose(bufferedReader);
                FileUtil.safeClose(fileReader2);
                return false;
            } catch (Throwable th4) {
                FileUtil.safeClose(bufferedReader);
                FileUtil.safeClose(fileReader2);
                throw th4;
            }
        }
    }
}
