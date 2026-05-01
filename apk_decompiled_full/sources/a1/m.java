package a1;

import a1.u;
import android.os.Build;
import androidx.work.OverwritingInputMerger;

/* loaded from: classes.dex */
public final class m extends u {

    public static final class a extends u.a {
        public a(Class cls) {
            super(cls);
            this.f142c.f14586d = OverwritingInputMerger.class.getName();
        }

        @Override // a1.u.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public m c() {
            if (this.f140a && Build.VERSION.SDK_INT >= 23 && this.f142c.f14592j.h()) {
                throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
            }
            return new m(this);
        }

        @Override // a1.u.a
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public a d() {
            return this;
        }
    }

    public m(a aVar) {
        super(aVar.f141b, aVar.f142c, aVar.f143d);
    }

    public static m d(Class cls) {
        return (m) new a(cls).b();
    }
}
