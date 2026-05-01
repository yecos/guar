package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Build;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class o2 extends ContextWrapper {

    /* renamed from: c, reason: collision with root package name */
    public static final Object f1563c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public static ArrayList f1564d;

    /* renamed from: a, reason: collision with root package name */
    public final Resources f1565a;

    /* renamed from: b, reason: collision with root package name */
    public final Resources.Theme f1566b;

    public o2(Context context) {
        super(context);
        if (!x2.b()) {
            this.f1565a = new q2(this, context.getResources());
            this.f1566b = null;
            return;
        }
        x2 x2Var = new x2(this, context.getResources());
        this.f1565a = x2Var;
        Resources.Theme newTheme = x2Var.newTheme();
        this.f1566b = newTheme;
        newTheme.setTo(context.getTheme());
    }

    public static boolean a(Context context) {
        if ((context instanceof o2) || (context.getResources() instanceof q2) || (context.getResources() instanceof x2)) {
            return false;
        }
        return Build.VERSION.SDK_INT < 21 || x2.b();
    }

    public static Context b(Context context) {
        if (!a(context)) {
            return context;
        }
        synchronized (f1563c) {
            ArrayList arrayList = f1564d;
            if (arrayList == null) {
                f1564d = new ArrayList();
            } else {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    WeakReference weakReference = (WeakReference) f1564d.get(size);
                    if (weakReference == null || weakReference.get() == null) {
                        f1564d.remove(size);
                    }
                }
                for (int size2 = f1564d.size() - 1; size2 >= 0; size2--) {
                    WeakReference weakReference2 = (WeakReference) f1564d.get(size2);
                    o2 o2Var = weakReference2 != null ? (o2) weakReference2.get() : null;
                    if (o2Var != null && o2Var.getBaseContext() == context) {
                        return o2Var;
                    }
                }
            }
            o2 o2Var2 = new o2(context);
            f1564d.add(new WeakReference(o2Var2));
            return o2Var2;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.f1565a.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.f1565a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f1566b;
        return theme == null ? super.getTheme() : theme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i10) {
        Resources.Theme theme = this.f1566b;
        if (theme == null) {
            super.setTheme(i10);
        } else {
            theme.applyStyle(i10, true);
        }
    }
}
