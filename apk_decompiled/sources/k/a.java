package k;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;
import o.o;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final Intent f14719a;

    /* renamed from: b, reason: collision with root package name */
    public final Bundle f14720b;

    /* renamed from: k.a$a, reason: collision with other inner class name */
    public static final class C0242a {

        /* renamed from: a, reason: collision with root package name */
        public final Intent f14721a;

        /* renamed from: b, reason: collision with root package name */
        public ArrayList f14722b;

        /* renamed from: c, reason: collision with root package name */
        public Bundle f14723c;

        /* renamed from: d, reason: collision with root package name */
        public ArrayList f14724d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f14725e;

        public C0242a() {
            this(null);
        }

        public a a() {
            ArrayList<? extends Parcelable> arrayList = this.f14722b;
            if (arrayList != null) {
                this.f14721a.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", arrayList);
            }
            ArrayList<? extends Parcelable> arrayList2 = this.f14724d;
            if (arrayList2 != null) {
                this.f14721a.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", arrayList2);
            }
            this.f14721a.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.f14725e);
            return new a(this.f14721a, this.f14723c);
        }

        public C0242a(b bVar) {
            Intent intent = new Intent("android.intent.action.VIEW");
            this.f14721a = intent;
            this.f14722b = null;
            this.f14723c = null;
            this.f14724d = null;
            this.f14725e = true;
            Bundle bundle = new Bundle();
            o.b(bundle, "android.support.customtabs.extra.SESSION", null);
            intent.putExtras(bundle);
        }
    }

    public a(Intent intent, Bundle bundle) {
        this.f14719a = intent;
        this.f14720b = bundle;
    }

    public void a(Context context, Uri uri) {
        this.f14719a.setData(uri);
        p.a.startActivity(context, this.f14719a, this.f14720b);
    }
}
