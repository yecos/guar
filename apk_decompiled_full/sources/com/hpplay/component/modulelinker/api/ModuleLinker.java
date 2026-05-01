package com.hpplay.component.modulelinker.api;

import android.content.Context;
import com.hpplay.component.modulelinker.c;
import com.hpplay.component.modulelinker.patch.LelinkPatch;

/* loaded from: classes2.dex */
public class ModuleLinker {
    private static final String ABI_ARM_32_V5 = "armeabi";
    private static final String ABI_ARM_32_V7 = "armeabi-v7a";
    private static final String ABI_ARM_64 = "arm64-v8a";
    private static final String ABI_X86 = "x86";
    private static volatile ModuleLinker moduleLinker;
    private IModuleLinker mModuleLinkerImp;

    public ModuleLinker(boolean z10) {
        this.mModuleLinkerImp = new c(z10);
    }

    public static ModuleLinker getInstance() {
        if (moduleLinker == null) {
            synchronized (ModuleLinker.class) {
                if (moduleLinker == null) {
                    moduleLinker = new ModuleLinker(false);
                }
            }
        }
        return moduleLinker;
    }

    public static ModuleLinker getNewInstance() {
        return new ModuleLinker(true);
    }

    public synchronized Object callMethod(String str, Object... objArr) {
        IModuleLinker iModuleLinker = this.mModuleLinkerImp;
        if (iModuleLinker == null) {
            return null;
        }
        return iModuleLinker.callMethod(str, objArr);
    }

    public void fileMerge(String str, String str2, String str3) {
        LelinkPatch.mergePatch(str, str2, str3);
    }

    public void genPatch(String str, String str2, String str3) {
        LelinkPatch.genPatch(str, str2, str3);
    }

    public String getClassName(String str) {
        IModuleLinker iModuleLinker = this.mModuleLinkerImp;
        return iModuleLinker != null ? iModuleLinker.getClassName(str) : "";
    }

    public Context getContext() {
        IModuleLinker iModuleLinker = this.mModuleLinkerImp;
        if (iModuleLinker != null) {
            return iModuleLinker.getContext();
        }
        return null;
    }

    public Object getModule(String str) {
        IModuleLinker iModuleLinker = this.mModuleLinkerImp;
        if (iModuleLinker != null) {
            return iModuleLinker.getModule(str);
        }
        return null;
    }

    public Object getParameter(String str) {
        IModuleLinker iModuleLinker = this.mModuleLinkerImp;
        return iModuleLinker != null ? iModuleLinker.getParameter(str) : Boolean.FALSE;
    }

    public boolean hotFix(String str) {
        return this.mModuleLinkerImp.hotFix(str);
    }

    public void init(Context context, String... strArr) {
        IModuleLinker iModuleLinker = this.mModuleLinkerImp;
        if (iModuleLinker != null) {
            iModuleLinker.init(context, strArr);
        }
    }

    public synchronized Object loadModule(String str) {
        IModuleLinker iModuleLinker = this.mModuleLinkerImp;
        if (iModuleLinker == null) {
            return null;
        }
        return iModuleLinker.loadModule(str);
    }

    public void putLinkInfo(String str, String str2) {
        IModuleLinker iModuleLinker = this.mModuleLinkerImp;
        if (iModuleLinker != null) {
            iModuleLinker.putLinkInfo(str, str2);
        }
    }

    public void removeObjOfMemory(String str) {
        IModuleLinker iModuleLinker = this.mModuleLinkerImp;
        if (iModuleLinker != null) {
            iModuleLinker.removeObjOfMemory(str);
        }
    }

    public boolean setParameter(String str, Object obj) {
        IModuleLinker iModuleLinker = this.mModuleLinkerImp;
        if (iModuleLinker != null) {
            return iModuleLinker.setParameter(str, obj);
        }
        return false;
    }

    public boolean hotFix(String str, String str2) {
        return this.mModuleLinkerImp.hotFix(str, str2);
    }

    public void init(Context context, String[] strArr, String... strArr2) {
        IModuleLinker iModuleLinker = this.mModuleLinkerImp;
        if (iModuleLinker != null) {
            iModuleLinker.init(context, strArr, strArr2);
        }
    }

    public synchronized Object loadModule(String str, Object... objArr) {
        IModuleLinker iModuleLinker = this.mModuleLinkerImp;
        if (iModuleLinker == null) {
            return null;
        }
        return iModuleLinker.loadModule(str, objArr);
    }

    public void init(Context context, ClassLoader classLoader, String[] strArr, String... strArr2) {
        IModuleLinker iModuleLinker = this.mModuleLinkerImp;
        if (iModuleLinker != null) {
            iModuleLinker.init(context, classLoader, strArr, strArr2);
        }
    }

    public void init(Context context, ClassLoader classLoader, String str, String[] strArr, String... strArr2) {
        IModuleLinker iModuleLinker = this.mModuleLinkerImp;
        if (iModuleLinker != null) {
            iModuleLinker.init(context, classLoader, str, strArr, strArr2);
        }
    }
}
