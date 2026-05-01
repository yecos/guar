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
    */
    private a b(LogDto logDto) {
        File file;
        a aVar;
        Throwable th;
        com.efs.sdk.base.core.d.f fVar;
        a putIfAbsent;
        if (this.f6114a.containsKey(logDto.getLogType())) {
            return this.f6114a.get(logDto.getLogType());
        }
        if (Constants.LOG_TYPE_CODELOGPERF.equals(logDto.getLogType())) {
            file = new File(com.efs.sdk.base.core.util.a.g(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid()), FileUtil.getCodelogFileName(logDto));
        } else {
            file = new File(com.efs.sdk.base.core.util.a.f(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid()), FileUtil.getFileName(logDto));
        }
        try {
            aVar = new a(file);
            try {
                putIfAbsent = this.f6114a.putIfAbsent(logDto.getLogType(), aVar);
            } catch (Throwable th2) {
                th = th2;
                th.printStackTrace();
                if (!"wa".equalsIgnoreCase(logDto.getLogType())) {
                }
                return aVar;
            }
        } catch (Throwable th3) {
            aVar = null;
            th = th3;
        }
        if (putIfAbsent != null) {
            FileUtil.safeClose(aVar);
            FileUtil.delete(file);
            return putIfAbsent;
        }
        if (Constants.LOG_TYPE_CODELOGPERF.equals(logDto.getLogType())) {
            Message obtain = Message.obtain();
            obtain.obj = logDto.getLogType();
            obtain.what = 1;
            sendMessage(obtain);
        } else {
            Message obtain2 = Message.obtain();
            obtain2.obj = logDto.getLogType();
            obtain2.what = 1;
            sendMessageDelayed(obtain2, b(logDto.getLogType()));
        }
        if (!"wa".equalsIgnoreCase(logDto.getLogType())) {
            fVar = f.a.f6196a;
            fVar.f6194c.b();
        }
        return aVar;
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
