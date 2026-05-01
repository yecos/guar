package com.mobile.brasiltv.utils;

import android.app.Activity;
import android.content.Context;
import com.mobile.brasiltv.app.App;
import java.util.Stack;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static a f8606b;

    /* renamed from: a, reason: collision with root package name */
    public Stack f8607a;

    public static Context a() {
        Activity c10 = b().c();
        return c10 == null ? App.f8264f : c10;
    }

    public static a b() {
        if (f8606b == null) {
            f8606b = new a();
        }
        return f8606b;
    }

    public Activity c() {
        Stack stack = this.f8607a;
        if (stack == null || stack.empty()) {
            return null;
        }
        return (Activity) this.f8607a.lastElement();
    }

    public void d(Activity activity) {
        Stack stack = this.f8607a;
        if (stack == null || stack.size() <= 0 || activity == null) {
            return;
        }
        this.f8607a.remove(activity);
    }

    public void e() {
        Activity c10;
        Stack stack = this.f8607a;
        if (stack == null || stack.size() <= 0) {
            return;
        }
        while (this.f8607a.size() > 0 && (c10 = c()) != null) {
            c10.finish();
            this.f8607a.remove(c10);
        }
    }

    public void f(Activity activity) {
        if (this.f8607a == null) {
            this.f8607a = new Stack();
        }
        this.f8607a.add(activity);
    }
}
