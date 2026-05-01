package i5;

import android.content.Context;
import android.os.Bundle;
import com.mobile.brasiltv.base.R$color;
import h9.g;
import h9.h;
import t9.j;

/* loaded from: classes3.dex */
public abstract class a extends u8.a {

    /* renamed from: b, reason: collision with root package name */
    public final g f14311b = h.b(new C0230a());

    /* renamed from: i5.a$a, reason: collision with other inner class name */
    public static final class C0230a extends j implements s9.a {
        public C0230a() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final a invoke() {
            return a.this;
        }
    }

    public final Context Q1() {
        return (Context) this.f14311b.getValue();
    }

    public void k2() {
        m2(getResources().getColor(R$color.statusBarColor));
    }

    public final void m2(int i10) {
        n5.a.f(n5.a.f17268a, this, i10, 0, 4, null);
    }

    public final void n2() {
        n5.a.f17268a.h(this);
    }

    @Override // u8.a, androidx.appcompat.app.d, androidx.fragment.app.e, androidx.activity.ComponentActivity, o.p, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        k2();
    }
}
