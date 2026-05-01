package com.hpplay.component.modulelinker;

import android.content.Context;
import android.text.TextUtils;
import com.hpplay.component.modulelinker.api.IModuleLinker;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONArray;

/* loaded from: classes2.dex */
public class c implements IModuleLinker {

    /* renamed from: a, reason: collision with root package name */
    public static final String f7354a = "ModuleLinkerImp";

    /* renamed from: b, reason: collision with root package name */
    public static final String f7355b = "com.hpplay.component.common.utils";

    /* renamed from: c, reason: collision with root package name */
    private String f7356c;

    /* renamed from: d, reason: collision with root package name */
    private LinkedList<String> f7357d = new LinkedList<>();

    public c(boolean z10) {
        this.f7356c = "";
        if (z10) {
            this.f7356c = String.valueOf(System.currentTimeMillis());
        }
    }

    private void a(String str, Object obj) {
        b.a().a(this.f7356c + str, obj);
    }

    private Object b(String str) {
        return b.a().b(this.f7356c + str);
    }

    private JSONArray c() {
        return b.a().f();
    }

    private JSONArray d() {
        return b.a().g();
    }

    @Override // com.hpplay.component.modulelinker.api.IModuleLinker
    public synchronized Object callMethod(String str, Object... objArr) {
        String str2;
        String str3;
        String str4;
        if (b().length() == 0 || TextUtils.isEmpty(str)) {
            throw new Exception(" no marked functions !!!");
        }
        int i10 = 0;
        while (true) {
            if (i10 >= c().length()) {
                str2 = null;
                str3 = null;
                str4 = null;
                break;
            }
            JSONArray jSONArray = new JSONArray(c().get(i10).toString());
            if (jSONArray.optString(0).equals(str)) {
                str2 = jSONArray.optString(1);
                str3 = jSONArray.optString(2);
                str4 = jSONArray.optString(3);
                break;
            }
            i10++;
        }
        if (TextUtils.isEmpty(str4)) {
            throw new Exception(" the function does not exist  !!!");
        }
        if (!TextUtils.isEmpty(str3) && str3.equals("static")) {
            return d.a(a().get(str4), str2, objArr);
        }
        Object loadModule = loadModule(str4);
        if (loadModule == null) {
            throw new Exception("failed to get module interface");
        }
        return d.a(loadModule, str2, objArr);
    }

    @Override // com.hpplay.component.modulelinker.api.IModuleLinker
    public String getClassName(String str) {
        return b.a().c(str);
    }

    @Override // com.hpplay.component.modulelinker.api.IModuleLinker
    public Context getContext() {
        return b.a().c();
    }

    @Override // com.hpplay.component.modulelinker.api.IModuleLinker
    public Object getModule(String str) {
        return b.a().b().get(str);
    }

    @Override // com.hpplay.component.modulelinker.api.IModuleLinker
    public Object getParameter(String str) {
        String str2;
        String[] c10 = c(str);
        String str3 = c10[0];
        if (str3 == null || (str2 = c10[1]) == null) {
            return Boolean.FALSE;
        }
        String str4 = c10[2];
        if (str3.equals("static")) {
            return d.a(a().get(str4), str2);
        }
        Object loadModule = loadModule(str4);
        if (loadModule != null) {
            return d.a(loadModule, str2);
        }
        throw new Exception("failed to get module interface");
    }

    @Override // com.hpplay.component.modulelinker.api.IModuleLinker
    public boolean hotFix(String str) {
        return false;
    }

    @Override // com.hpplay.component.modulelinker.api.IModuleLinker
    public synchronized void init(Context context, String... strArr) {
        init(context, null, null, null, strArr);
    }

    @Override // com.hpplay.component.modulelinker.api.IModuleLinker
    public synchronized Object loadModule(String str) {
        return loadModule(str, null);
    }

    @Override // com.hpplay.component.modulelinker.api.IModuleLinker
    public void putLinkInfo(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        b.a().a(str, str2);
    }

    @Override // com.hpplay.component.modulelinker.api.IModuleLinker
    public void removeObjOfMemory(String str) {
        b(str);
    }

    @Override // com.hpplay.component.modulelinker.api.IModuleLinker
    public boolean setParameter(String str, Object obj) {
        String str2;
        String[] c10 = c(str);
        String str3 = c10[0];
        if (str3 == null || (str2 = c10[1]) == null) {
            return false;
        }
        String str4 = c10[2];
        if (str3.equals("static")) {
            d.a(a().get(str4), str2, obj);
            return true;
        }
        Object loadModule = loadModule(str4);
        if (loadModule == null) {
            throw new Exception("failed to get module interface");
        }
        d.a(loadModule, str2, obj);
        return true;
    }

    private Object a(String str) {
        return b.a().a(this.f7356c + str);
    }

    private JSONArray b() {
        return b.a().e();
    }

    private String[] c(String str) {
        String str2;
        String str3;
        String str4;
        if (b().length() == 0 || TextUtils.isEmpty(str)) {
            throw new Exception(" no marked functions !!!");
        }
        int i10 = 0;
        while (true) {
            if (i10 >= d().length()) {
                str2 = null;
                str3 = null;
                str4 = null;
                break;
            }
            JSONArray jSONArray = new JSONArray(d().get(i10).toString());
            if (jSONArray.optString(0).equals(str)) {
                str2 = jSONArray.optString(1);
                str3 = jSONArray.optString(2);
                str4 = jSONArray.optString(3);
                break;
            }
            i10++;
        }
        if (TextUtils.isEmpty(str4)) {
            throw new Exception(" the function does not exist  !!!");
        }
        return new String[]{str3, str2, str4};
    }

    @Override // com.hpplay.component.modulelinker.api.IModuleLinker
    public boolean hotFix(String str, String str2) {
        return false;
    }

    @Override // com.hpplay.component.modulelinker.api.IModuleLinker
    public synchronized Object loadModule(String str, Object... objArr) {
        Class[] clsArr;
        Object[] objArr2;
        if (a().size() == 0) {
            if (d.c() != null) {
                init(d.c(), new String[0]);
            }
            if (a().size() == 0) {
                throw new Exception(" Modulelinker init failed !!!");
            }
        }
        if (TextUtils.isEmpty(a().get(str))) {
            throw new Exception("This module is not loaded !!!");
        }
        if (objArr == null || objArr.length <= 1) {
            clsArr = null;
            objArr2 = null;
        } else {
            clsArr = new Class[objArr.length / 2];
            objArr2 = new Object[objArr.length / 2];
            for (int i10 = 0; i10 < objArr.length; i10++) {
                if (i10 % 2 == 0) {
                    if (i10 == 0) {
                        objArr2[0] = objArr[0];
                    } else {
                        objArr2[i10] = objArr[i10 - 1];
                    }
                } else if (i10 == 1) {
                    clsArr[0] = (Class) objArr[i10];
                } else {
                    clsArr[i10] = (Class) objArr[i10 - 2];
                }
            }
        }
        if (a(str) == null) {
            String str2 = "";
            for (int i11 = 0; i11 < b().length(); i11++) {
                JSONArray jSONArray = new JSONArray(b().get(i11).toString());
                if (jSONArray.optString(0).equals(str)) {
                    str2 = jSONArray.optString(1);
                }
            }
            Object a10 = !str2.equals("new") ? d.a(a().get(str), str2, clsArr, objArr2) : d.a(a().get(str), (Class<?>[]) clsArr, objArr2);
            if (a10 == null) {
                throw new Exception(" the class does not exist !!!");
            }
            a(str, a10);
        }
        return a(str);
    }

    private Map<String, String> a() {
        return b.a().d();
    }

    @Override // com.hpplay.component.modulelinker.api.IModuleLinker
    public void init(Context context, String[] strArr, String... strArr2) {
        init(context, null, null, strArr, strArr2);
    }

    @Override // com.hpplay.component.modulelinker.api.IModuleLinker
    public void init(Context context, ClassLoader classLoader, String[] strArr, String... strArr2) {
        init(context, classLoader, null, strArr, strArr2);
    }

    @Override // com.hpplay.component.modulelinker.api.IModuleLinker
    public void init(Context context, ClassLoader classLoader, String str, String[] strArr, String... strArr2) {
        if (strArr2 != null && strArr2.length > 0) {
            this.f7357d.addAll(Arrays.asList(strArr2));
        }
        if (!this.f7357d.contains(f7355b)) {
            this.f7357d.add(f7355b);
        }
        if (b.a().b() == null || b.a().b().size() == 0) {
            long currentTimeMillis = System.currentTimeMillis();
            if (classLoader != null) {
                d.a(classLoader);
            }
            b.a().a(context.getApplicationContext(), str, this.f7357d, 0);
            StringBuilder sb = new StringBuilder();
            sb.append(" init time  ");
            sb.append(System.currentTimeMillis() - currentTimeMillis);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(" =====> ");
            sb2.append(a().size());
        }
    }
}
