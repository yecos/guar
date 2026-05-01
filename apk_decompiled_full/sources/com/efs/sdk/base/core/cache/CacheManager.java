package com.efs.sdk.base.core.cache;

import android.text.TextUtils;
import com.efs.sdk.base.Constants;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.d.f;
import com.efs.sdk.base.core.model.LogDto;
import com.efs.sdk.base.core.util.FileUtil;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.ProcessUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes.dex */
public class CacheManager {

    /* renamed from: a, reason: collision with root package name */
    private boolean f6104a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f6105b;

    /* renamed from: c, reason: collision with root package name */
    private com.efs.sdk.base.core.cache.a f6106c;

    /* renamed from: d, reason: collision with root package name */
    private a f6107d;

    /* renamed from: e, reason: collision with root package name */
    private List<File> f6108e;

    public static class a implements Comparator<File> {
        @Override // java.util.Comparator
        public final /* synthetic */ int compare(File file, File file2) {
            long lastModified = file.lastModified() - file2.lastModified();
            if (lastModified > 0) {
                return 1;
            }
            return lastModified == 0 ? 0 : -1;
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final CacheManager f6109a = new CacheManager(0);
    }

    public /* synthetic */ CacheManager(byte b10) {
        this();
    }

    private void a() {
        String[] list;
        File d10 = com.efs.sdk.base.core.util.a.d(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid());
        if (!d10.exists() || !d10.isDirectory() || (list = d10.list()) == null || list.length <= 0) {
            return;
        }
        for (String str : list) {
            if (!ProcessUtil.isProcessExist(ControllerCenter.getGlobalEnvStruct().mAppContext, str)) {
                File file = new File(d10, str);
                List<File> listFiles = FileUtil.listFiles(file);
                if (!listFiles.isEmpty()) {
                    for (File file2 : listFiles) {
                        if (a(file2.getName())) {
                            a(file2);
                        } else {
                            String name = file2.getName();
                            LogDto createLogDtoByName = (TextUtils.isEmpty(name) || !name.startsWith(Constants.LOG_TYPE_CODELOGPERF)) ? FileUtil.createLogDtoByName(name) : FileUtil.createCodeLogDtoByName(name);
                            if (createLogDtoByName == null) {
                                onChangeDtoError(file2);
                            } else {
                                d a10 = this.f6106c.a(createLogDtoByName.getLogProtocol());
                                if (a10 == null) {
                                    onChangeDtoError(file2);
                                } else {
                                    a10.a(file2);
                                }
                            }
                        }
                    }
                }
                FileUtil.delete(file);
            }
        }
    }

    private void b() {
        String[] list;
        File e10 = com.efs.sdk.base.core.util.a.e(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid());
        if (!e10.exists() || !e10.isDirectory() || (list = e10.list()) == null || list.length <= 0) {
            return;
        }
        for (String str : list) {
            if (!ProcessUtil.isProcessExist(ControllerCenter.getGlobalEnvStruct().mAppContext, str)) {
                File file = new File(e10, str);
                List<File> listFiles = FileUtil.listFiles(file);
                if (!listFiles.isEmpty()) {
                    for (File file2 : listFiles) {
                        if (a(file2.getName())) {
                            a(file2);
                        } else {
                            String name = file2.getName();
                            LogDto createLogDtoByName = (TextUtils.isEmpty(name) || !name.startsWith(Constants.LOG_TYPE_CODELOGPERF)) ? FileUtil.createLogDtoByName(name) : FileUtil.createCodeLogDtoByName(name);
                            if (createLogDtoByName == null) {
                                onChangeDtoError(file2);
                            } else {
                                d a10 = this.f6106c.a(createLogDtoByName.getLogProtocol());
                                if (a10 == null) {
                                    onChangeDtoError(file2);
                                } else {
                                    a10.a(file2);
                                }
                            }
                        }
                    }
                }
                FileUtil.delete(file);
            }
        }
    }

    public static CacheManager getInstance() {
        return b.f6109a;
    }

    public LogDto changeLogDto(File file) {
        try {
            if (!file.exists()) {
                return null;
            }
            if (a(file.getName())) {
                a(file);
                return null;
            }
            String name = file.getName();
            LogDto createLogDtoByName = (TextUtils.isEmpty(name) || !name.startsWith(Constants.LOG_TYPE_CODELOGPERF)) ? FileUtil.createLogDtoByName(name) : FileUtil.createCodeLogDtoByName(name);
            if (createLogDtoByName == null) {
                onChangeDtoError(file);
                return null;
            }
            d a10 = this.f6106c.a(createLogDtoByName.getLogProtocol());
            if (a10 == null) {
                onChangeDtoError(file);
                return null;
            }
            if (a10.a(file, createLogDtoByName)) {
                return createLogDtoByName;
            }
            onChangeDtoError(file);
            return null;
        } catch (Throwable th) {
            Log.w("efs.cache", th);
            onChangeDtoError(file);
            return null;
        }
    }

    public void flushImmediately(byte b10, String str) {
        d a10 = this.f6106c.a(b10);
        if (a10 == null) {
            return;
        }
        a10.a(str);
    }

    public List<File> getCodeLogList() {
        return this.f6108e;
    }

    public List<File> getFileList(int i10, IFileFilter iFileFilter) {
        com.efs.sdk.base.core.d.f fVar;
        a();
        File h10 = com.efs.sdk.base.core.util.a.h(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid());
        if (!h10.exists()) {
            return Collections.emptyList();
        }
        List<File> listFiles = FileUtil.listFiles(h10);
        if (this.f6105b) {
            fVar = f.a.f6196a;
            int size = listFiles.size();
            if (fVar.f6193b != null && ControllerCenter.getGlobalEnvStruct().isEnableWaStat()) {
                com.efs.sdk.base.core.d.b bVar = new com.efs.sdk.base.core.d.b("efs_core", "log_lag", fVar.f6192a.f6186c);
                bVar.put("cnt", Integer.valueOf(size));
                fVar.f6193b.send(bVar);
            }
            this.f6105b = false;
        }
        Collections.sort(listFiles, this.f6107d);
        ArrayList arrayList = new ArrayList(i10);
        for (int size2 = listFiles.size() - 1; size2 >= 0 && arrayList.size() < i10; size2--) {
            File file = listFiles.get(size2);
            if (file.exists() && (iFileFilter == null || !iFileFilter.filter(file))) {
                arrayList.add(file);
            }
        }
        return arrayList;
    }

    public List<File> getFileListCodeLog(int i10, IFileFilter iFileFilter) {
        b();
        List<File> list = this.f6108e;
        if (list == null || list.isEmpty()) {
            File i11 = com.efs.sdk.base.core.util.a.i(ControllerCenter.getGlobalEnvStruct().mAppContext, ControllerCenter.getGlobalEnvStruct().getAppid());
            if (!i11.exists()) {
                return Collections.emptyList();
            }
            List<File> listFiles = FileUtil.listFiles(i11);
            this.f6108e = listFiles;
            Collections.sort(listFiles, this.f6107d);
        }
        ArrayList arrayList = new ArrayList(i10);
        for (int size = this.f6108e.size() - 1; size >= 0 && arrayList.size() < i10; size--) {
            File file = this.f6108e.get(size);
            if (file.exists()) {
                if (iFileFilter == null || !iFileFilter.filter(file)) {
                    Log.i("efs.cache", "[-->>] add file is " + file.getName());
                    arrayList.add(file);
                } else {
                    Log.i("efs.cache", "[--xx] filter file is " + file.getName());
                }
            }
        }
        return arrayList;
    }

    public List<LogDto> getLogDto(int i10, IFileFilter iFileFilter) {
        a();
        List<File> fileList = getFileList(i10, iFileFilter);
        ArrayList arrayList = new ArrayList(i10);
        for (File file : fileList) {
            LogDto changeLogDto = changeLogDto(file);
            if (changeLogDto == null) {
                Log.w("efs.cache", "file upload error, name is " + file.getName());
            } else {
                arrayList.add(changeLogDto);
            }
        }
        return arrayList;
    }

    public List<LogDto> getLogDtoCodeLog(int i10, IFileFilter iFileFilter) {
        b();
        List<File> fileListCodeLog = getFileListCodeLog(i10, iFileFilter);
        ArrayList arrayList = new ArrayList(i10);
        for (File file : fileListCodeLog) {
            LogDto changeLogDto = changeLogDto(file);
            if (changeLogDto == null) {
                Log.w("efs.cache", "file upload error, name is " + file.getName());
            } else {
                arrayList.add(changeLogDto);
            }
        }
        return arrayList;
    }

    public void onChangeDtoError(File file) {
        com.efs.sdk.base.core.d.f fVar;
        if (!file.getName().startsWith("wa_")) {
            fVar = f.a.f6196a;
            fVar.f6194c.f6188c.incrementAndGet();
        }
        FileUtil.delete(file);
    }

    public void put(LogDto logDto) {
        d a10;
        com.efs.sdk.base.core.d.f fVar;
        if (!"wa".equals(logDto.getLogType()) && !Constants.LOG_TYPE_CODELOGPERF.equals(logDto.getLogType()) && !com.efs.sdk.base.core.cache.b.a().f6111a) {
            if (!this.f6104a) {
                fVar = f.a.f6196a;
                int i10 = com.efs.sdk.base.core.config.remote.b.a().f6151d.mConfigVersion;
                if (fVar.f6193b != null || ControllerCenter.getGlobalEnvStruct().isEnableWaStat()) {
                    fVar.f6193b.send(fVar.a("disk_limit", i10));
                }
            }
            this.f6104a = true;
            return;
        }
        if (!Constants.LOG_TYPE_CODELOGPERF.equals(logDto.getLogType()) || com.efs.sdk.base.core.cache.b.a().f6112b) {
            if ((logDto.getLogBodyType() == 0 && (logDto.getData() == null || logDto.getData().length == 0)) || (a10 = this.f6106c.a(logDto.getLogProtocol())) == null) {
                return;
            }
            a10.a(logDto);
        }
    }

    private CacheManager() {
        this.f6104a = false;
        this.f6105b = true;
        this.f6106c = new com.efs.sdk.base.core.cache.a();
        this.f6107d = new a();
    }

    public static boolean a(String str) {
        long parseLong;
        try {
            if (str.startsWith(Constants.LOG_TYPE_CODELOGPERF)) {
                parseLong = Long.parseLong(str.substring(str.lastIndexOf("_") + 1));
            } else {
                parseLong = Long.parseLong(str.substring(str.lastIndexOf("_") + 1));
            }
            com.efs.sdk.base.core.a.a.a();
            return Math.abs(com.efs.sdk.base.core.a.a.b() - parseLong) >= 604800000;
        } catch (Throwable unused) {
            return true;
        }
    }

    public static void a(File file) {
        com.efs.sdk.base.core.d.f fVar;
        StringBuilder sb = new StringBuilder("file is expire: ");
        sb.append(file.getName());
        sb.append(", now is ");
        com.efs.sdk.base.core.a.a.a();
        sb.append(com.efs.sdk.base.core.a.a.b());
        Log.i("efs.cache", sb.toString());
        if (!file.getName().startsWith("wa_")) {
            fVar = f.a.f6196a;
            fVar.f6194c.d();
        }
        FileUtil.delete(file);
    }
}
