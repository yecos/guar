package com.titan.cast;

import android.content.Context;
import com.core.sysopt.so.SoOptimizer;
import com.google.gson.Gson;
import com.hpplay.component.common.dlna.IDLNAController;
import com.titan.cast.bean.CastMedia;
import com.titan.cast.bean.CastResult;
import com.titan.cast.bean.Device;
import h9.t;
import java.util.HashMap;
import t9.g;
import t9.i;

/* loaded from: classes3.dex */
public final class NativeJni {

    /* renamed from: b, reason: collision with root package name */
    public static final a f9451b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    public static NativeJni f9452c;

    /* renamed from: d, reason: collision with root package name */
    public static Gson f9453d;

    /* renamed from: a, reason: collision with root package name */
    public final String f9454a = "CastNativeJni";

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final NativeJni a() {
            if (NativeJni.f9452c == null) {
                synchronized (NativeJni.class) {
                    if (NativeJni.f9452c == null) {
                        NativeJni.f9452c = new NativeJni();
                        NativeJni.f9453d = new Gson();
                        NativeJni nativeJni = NativeJni.f9452c;
                        i.d(nativeJni);
                        nativeJni.e();
                    }
                    t tVar = t.f14242a;
                }
            }
            return NativeJni.f9452c;
        }
    }

    static {
        try {
            System.loadLibrary("cast-jni");
        } catch (UnsatisfiedLinkError e10) {
            e10.printStackTrace();
            try {
                SoOptimizer.class.getDeclaredMethod("reloadLibrary", new Class[0]).invoke(null, "cast-jni");
            } catch (Exception e11) {
                throw new RuntimeException(e11);
            }
        }
    }

    private final native String Call(String str, String str2);

    public final String d() {
        CastResult castResult;
        String Call = Call("GetVersion", "{}");
        Gson gson = f9453d;
        if (gson == null || (castResult = (CastResult) gson.fromJson(Call, CastResult.class)) == null) {
            return null;
        }
        return castResult.getRes();
    }

    public final void e() {
        CastResult castResult;
        Context a10 = g8.a.f14066a.a();
        i.d(a10);
        String absolutePath = a10.getDir("cast-dlna", 0).getAbsolutePath();
        HashMap hashMap = new HashMap();
        i.f(absolutePath, "castPath");
        hashMap.put("work_path", absolutePath);
        Gson gson = f9453d;
        String json = gson != null ? gson.toJson(hashMap) : null;
        String Call = json != null ? Call("Init", json) : null;
        Gson gson2 = f9453d;
        if (gson2 == null || (castResult = (CastResult) gson2.fromJson(Call, CastResult.class)) == null) {
            return;
        }
        castResult.getErr();
    }

    public final Integer f(String str) {
        CastResult castResult;
        i.g(str, "session");
        String Call = Call(IDLNAController.PAUSE, e8.a.f12958a.e(str));
        Gson gson = f9453d;
        if (gson == null || (castResult = (CastResult) gson.fromJson(Call, CastResult.class)) == null) {
            return null;
        }
        return Integer.valueOf(castResult.getErr());
    }

    public final Integer g(String str) {
        CastResult castResult;
        i.g(str, "session");
        String Call = Call(IDLNAController.RESUME, e8.a.f12958a.e(str));
        Gson gson = f9453d;
        if (gson == null || (castResult = (CastResult) gson.fromJson(Call, CastResult.class)) == null) {
            return null;
        }
        return Integer.valueOf(castResult.getErr());
    }

    public final Integer h() {
        CastResult castResult;
        String Call = Call("StartDiscovery", "{}");
        Gson gson = f9453d;
        if (gson == null || (castResult = (CastResult) gson.fromJson(Call, CastResult.class)) == null) {
            return null;
        }
        return Integer.valueOf(castResult.getErr());
    }

    public final Integer i(String str, long j10) {
        CastResult castResult;
        i.g(str, "session");
        String Call = Call("SeekTo", e8.a.f12958a.b(str, j10));
        Gson gson = f9453d;
        if (gson == null || (castResult = (CastResult) gson.fromJson(Call, CastResult.class)) == null) {
            return null;
        }
        return Integer.valueOf(castResult.getErr());
    }

    public final Integer j(Device device) {
        CastResult castResult;
        i.g(device, "deviceInfo");
        Gson gson = f9453d;
        String Call = Call("SelectDevice", e8.a.f12958a.c(gson != null ? gson.toJson(device) : null));
        Gson gson2 = f9453d;
        if (gson2 == null || (castResult = (CastResult) gson2.fromJson(Call, CastResult.class)) == null) {
            return null;
        }
        return Integer.valueOf(castResult.getErr());
    }

    public final Integer k(String str) {
        CastResult castResult;
        i.g(str, "envJson");
        String Call = Call("SetEnv", e8.a.f12958a.a(str));
        Gson gson = f9453d;
        if (gson == null || (castResult = (CastResult) gson.fromJson(Call, CastResult.class)) == null) {
            return null;
        }
        return Integer.valueOf(castResult.getErr());
    }

    public final Integer l(String str, CastMedia castMedia, String str2) {
        CastResult castResult;
        i.g(str, "session");
        i.g(castMedia, "media");
        i.g(str2, "extra");
        Gson gson = f9453d;
        String Call = Call("StartPlay", e8.a.f12958a.d(str, gson != null ? gson.toJson(castMedia) : null, str2));
        Gson gson2 = f9453d;
        if (gson2 == null || (castResult = (CastResult) gson2.fromJson(Call, CastResult.class)) == null) {
            return null;
        }
        return Integer.valueOf(castResult.getErr());
    }

    public final Integer m(String str) {
        CastResult castResult;
        i.g(str, "session");
        String Call = Call("StopPlay", e8.a.f12958a.e(str));
        Gson gson = f9453d;
        if (gson == null || (castResult = (CastResult) gson.fromJson(Call, CastResult.class)) == null) {
            return null;
        }
        return Integer.valueOf(castResult.getErr());
    }

    public final Integer n() {
        CastResult castResult;
        String Call = Call("StopDiscovery", "{}");
        Gson gson = f9453d;
        if (gson == null || (castResult = (CastResult) gson.fromJson(Call, CastResult.class)) == null) {
            return null;
        }
        return Integer.valueOf(castResult.getErr());
    }
}
