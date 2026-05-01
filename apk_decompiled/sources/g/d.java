package g;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
import androidx.appcompat.R$style;

/* loaded from: classes.dex */
public class d extends ContextWrapper {

    /* renamed from: a, reason: collision with root package name */
    public int f13422a;

    /* renamed from: b, reason: collision with root package name */
    public Resources.Theme f13423b;

    /* renamed from: c, reason: collision with root package name */
    public LayoutInflater f13424c;

    /* renamed from: d, reason: collision with root package name */
    public Configuration f13425d;

    /* renamed from: e, reason: collision with root package name */
    public Resources f13426e;

    public d(Context context, int i10) {
        super(context);
        this.f13422a = i10;
    }

    public void a(Configuration configuration) {
        if (this.f13426e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        }
        if (this.f13425d != null) {
            throw new IllegalStateException("Override configuration has already been set");
        }
        this.f13425d = new Configuration(configuration);
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public final Resources b() {
        if (this.f13426e == null) {
            Configuration configuration = this.f13425d;
            if (configuration == null) {
                this.f13426e = super.getResources();
            } else {
                this.f13426e = createConfigurationContext(configuration).getResources();
            }
        }
        return this.f13426e;
    }

    public int c() {
        return this.f13422a;
    }

    public final void d() {
        boolean z10 = this.f13423b == null;
        if (z10) {
            this.f13423b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f13423b.setTo(theme);
            }
        }
        e(this.f13423b, this.f13422a, z10);
    }

    public void e(Resources.Theme theme, int i10, boolean z10) {
        theme.applyStyle(i10, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return b();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f13424c == null) {
            this.f13424c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f13424c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f13423b;
        if (theme != null) {
            return theme;
        }
        if (this.f13422a == 0) {
            this.f13422a = R$style.Theme_AppCompat_Light;
        }
        d();
        return this.f13423b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i10) {
        if (this.f13422a != i10) {
            this.f13422a = i10;
            d();
        }
    }

    public d(Context context, Resources.Theme theme) {
        super(context);
        this.f13423b = theme;
    }
}
