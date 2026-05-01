package n0;

import android.os.Build;
import android.os.Bundle;

/* loaded from: classes.dex */
public class o1 {

    /* renamed from: a, reason: collision with root package name */
    public final int f16919a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f16920b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f16921c;

    /* renamed from: d, reason: collision with root package name */
    public final Bundle f16922d;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public int f16923a = 1;

        /* renamed from: b, reason: collision with root package name */
        public boolean f16924b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f16925c;

        /* renamed from: d, reason: collision with root package name */
        public Bundle f16926d;

        public o1 a() {
            return new o1(this);
        }

        public a b(boolean z10) {
            if (Build.VERSION.SDK_INT >= 30) {
                this.f16924b = z10;
            }
            return this;
        }

        public a c(boolean z10) {
            if (Build.VERSION.SDK_INT >= 30) {
                this.f16925c = z10;
            }
            return this;
        }
    }

    public o1(a aVar) {
        this.f16919a = aVar.f16923a;
        this.f16920b = aVar.f16924b;
        this.f16921c = aVar.f16925c;
        Bundle bundle = aVar.f16926d;
        this.f16922d = bundle == null ? Bundle.EMPTY : new Bundle(bundle);
    }

    public int a() {
        return this.f16919a;
    }

    public Bundle b() {
        return this.f16922d;
    }

    public boolean c() {
        return this.f16920b;
    }

    public boolean d() {
        return this.f16921c;
    }
}
