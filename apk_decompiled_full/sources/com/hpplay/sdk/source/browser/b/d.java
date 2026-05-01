package com.hpplay.sdk.source.browser.b;

import android.os.Build;
import android.os.Process;
import com.hpplay.common.log.LeLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static final String f7470a = "WebViewUtils";

    public static void a() {
        Method declaredMethod;
        int myUid = Process.myUid();
        LeLog.i(f7470a, "init process uid:" + myUid);
        if (myUid != 1000) {
            LeLog.i(f7470a, "hookWebView, app is not system app");
            return;
        }
        int i10 = Build.VERSION.SDK_INT;
        try {
            Class<?> cls = Class.forName("android.webkit.WebViewFactory");
            Field declaredField = cls.getDeclaredField("sProviderInstance");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            if (obj != null) {
                LeLog.i(f7470a, "sProviderInstance isn't null");
                return;
            }
            if (i10 > 22) {
                declaredMethod = cls.getDeclaredMethod("getProviderClass", new Class[0]);
            } else {
                if (i10 != 22) {
                    LeLog.i(f7470a, "Don't need to Hook WebView");
                    return;
                }
                declaredMethod = cls.getDeclaredMethod("getFactoryClass", new Class[0]);
            }
            declaredMethod.setAccessible(true);
            Class cls2 = (Class) declaredMethod.invoke(cls, new Object[0]);
            Class<?> cls3 = Class.forName("android.webkit.WebViewDelegate");
            Constructor<?> declaredConstructor = cls3.getDeclaredConstructor(new Class[0]);
            declaredConstructor.setAccessible(true);
            if (i10 < 26) {
                Constructor constructor = cls2.getConstructor(cls3);
                if (constructor != null) {
                    constructor.setAccessible(true);
                    obj = constructor.newInstance(declaredConstructor.newInstance(new Object[0]));
                }
            } else {
                Field declaredField2 = cls.getDeclaredField("CHROMIUM_WEBVIEW_FACTORY_METHOD");
                declaredField2.setAccessible(true);
                String str = (String) declaredField2.get(null);
                if (str == null) {
                    str = "create";
                }
                Method method = cls2.getMethod(str, cls3);
                if (method != null) {
                    obj = method.invoke(null, declaredConstructor.newInstance(new Object[0]));
                }
            }
            if (obj == null) {
                LeLog.i(f7470a, "Hook failed!");
            } else {
                declaredField.set("sProviderInstance", obj);
                LeLog.i(f7470a, "Hook success!");
            }
        } catch (Exception e10) {
            LeLog.w(f7470a, "hookWebView exception: " + e10);
        }
    }
}
