package com.hpplay.component.modulelinker.api;

import android.content.Context;

/* loaded from: classes2.dex */
public interface IModuleLinker {
    Object callMethod(String str, Object... objArr);

    String getClassName(String str);

    Context getContext();

    Object getModule(String str);

    Object getParameter(String str);

    boolean hotFix(String str);

    boolean hotFix(String str, String str2);

    void init(Context context, ClassLoader classLoader, String str, String[] strArr, String... strArr2);

    void init(Context context, ClassLoader classLoader, String[] strArr, String... strArr2);

    void init(Context context, String... strArr);

    void init(Context context, String[] strArr, String... strArr2);

    Object loadModule(String str);

    Object loadModule(String str, Object... objArr);

    void putLinkInfo(String str, String str2);

    void removeObjOfMemory(String str);

    boolean setParameter(String str, Object obj);
}
