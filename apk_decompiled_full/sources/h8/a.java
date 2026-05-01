package h8;

import com.titan.cast.NativeJni;
import com.titan.cast.bean.CastMedia;
import com.titan.cast.bean.Device;
import t9.i;

/* loaded from: classes3.dex */
public final class a implements b {
    @Override // h8.b
    public void a(String str) {
        i.g(str, "session");
        NativeJni a10 = NativeJni.f9451b.a();
        if (a10 != null) {
            a10.g(str);
        }
    }

    @Override // h8.b
    public void b() {
        NativeJni a10 = NativeJni.f9451b.a();
        if (a10 != null) {
            a10.n();
        }
    }

    @Override // h8.b
    public void c(String str, long j10) {
        i.g(str, "session");
        NativeJni a10 = NativeJni.f9451b.a();
        if (a10 != null) {
            a10.i(str, j10);
        }
    }

    @Override // h8.b
    public String d() {
        NativeJni a10 = NativeJni.f9451b.a();
        if (a10 != null) {
            return a10.d();
        }
        return null;
    }

    @Override // h8.b
    public Integer e(String str) {
        i.g(str, "session");
        NativeJni a10 = NativeJni.f9451b.a();
        if (a10 != null) {
            return a10.m(str);
        }
        return null;
    }

    @Override // h8.b
    public void f() {
        NativeJni a10 = NativeJni.f9451b.a();
        if (a10 != null) {
            a10.h();
        }
    }

    @Override // h8.b
    public void g(String str) {
        i.g(str, "envJson");
        NativeJni a10 = NativeJni.f9451b.a();
        if (a10 != null) {
            a10.k(str);
        }
    }

    @Override // h8.b
    public void h(String str) {
        i.g(str, "session");
        NativeJni a10 = NativeJni.f9451b.a();
        if (a10 != null) {
            a10.f(str);
        }
    }

    public Integer i(Device device) {
        i.g(device, "deviceInfo");
        NativeJni a10 = NativeJni.f9451b.a();
        if (a10 != null) {
            return a10.j(device);
        }
        return null;
    }

    public Integer j(String str, CastMedia castMedia, String str2) {
        i.g(str, "session");
        i.g(castMedia, "media");
        i.g(str2, "extra");
        NativeJni a10 = NativeJni.f9451b.a();
        if (a10 != null) {
            return a10.l(str, castMedia, str2);
        }
        return null;
    }
}
