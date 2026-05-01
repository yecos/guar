package k0;

import android.media.VolumeProvider;
import android.os.Build;
import android.support.v4.media.session.a0;

/* loaded from: classes.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    public final int f14731a;

    /* renamed from: b, reason: collision with root package name */
    public final int f14732b;

    /* renamed from: c, reason: collision with root package name */
    public final String f14733c;

    /* renamed from: d, reason: collision with root package name */
    public int f14734d;

    /* renamed from: e, reason: collision with root package name */
    public c f14735e;

    /* renamed from: f, reason: collision with root package name */
    public VolumeProvider f14736f;

    public class a extends VolumeProvider {
        public a(int i10, int i11, int i12, String str) {
            super(i10, i11, i12, str);
        }

        @Override // android.media.VolumeProvider
        public void onAdjustVolume(int i10) {
            l.this.e(i10);
        }

        @Override // android.media.VolumeProvider
        public void onSetVolumeTo(int i10) {
            l.this.f(i10);
        }
    }

    public class b extends VolumeProvider {
        public b(int i10, int i11, int i12) {
            super(i10, i11, i12);
        }

        @Override // android.media.VolumeProvider
        public void onAdjustVolume(int i10) {
            l.this.e(i10);
        }

        @Override // android.media.VolumeProvider
        public void onSetVolumeTo(int i10) {
            l.this.f(i10);
        }
    }

    public static abstract class c {
        public abstract void a(l lVar);
    }

    public l(int i10, int i11, int i12, String str) {
        this.f14731a = i10;
        this.f14732b = i11;
        this.f14734d = i12;
        this.f14733c = str;
    }

    public final int a() {
        return this.f14734d;
    }

    public final int b() {
        return this.f14732b;
    }

    public final int c() {
        return this.f14731a;
    }

    public Object d() {
        if (this.f14736f == null) {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 30) {
                this.f14736f = new a(this.f14731a, this.f14732b, this.f14734d, this.f14733c);
            } else if (i10 >= 21) {
                this.f14736f = new b(this.f14731a, this.f14732b, this.f14734d);
            }
        }
        return this.f14736f;
    }

    public abstract void e(int i10);

    public abstract void f(int i10);

    public void g(c cVar) {
        this.f14735e = cVar;
    }

    public final void h(int i10) {
        this.f14734d = i10;
        if (Build.VERSION.SDK_INT >= 21) {
            a0.a(d()).setCurrentVolume(i10);
        }
        c cVar = this.f14735e;
        if (cVar != null) {
            cVar.a(this);
        }
    }
}
