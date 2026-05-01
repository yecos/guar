package com.mobile.brasiltv.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.SystemClock;
import com.bigbee.bean.request.CastAction;
import com.bigbee.bean.request.CastDeviceDiscovery;
import com.bigbee.bean.request.CastPlay;
import com.hpplay.component.common.ParamsMap;
import com.mobile.brasiltv.app.App;
import com.taobao.accs.common.Constants;
import com.titan.cast.JniHandler;
import com.titan.cast.bean.CastBean;
import com.titan.cast.bean.CastMedia;
import com.titan.cast.bean.Device;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import mobile.com.requestframe.utils.response.GetSlbInfoBeanResultData;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaMeta;
import w6.i;

/* loaded from: classes3.dex */
public final class g implements f8.a {

    /* renamed from: a, reason: collision with root package name */
    public static final g f8651a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f8652b;

    /* renamed from: c, reason: collision with root package name */
    public static ArrayList f8653c;

    /* renamed from: d, reason: collision with root package name */
    public static Device f8654d;

    /* renamed from: e, reason: collision with root package name */
    public static Device f8655e;

    /* renamed from: f, reason: collision with root package name */
    public static b f8656f;

    /* renamed from: g, reason: collision with root package name */
    public static a f8657g;

    /* renamed from: h, reason: collision with root package name */
    public static final int f8658h;

    /* renamed from: i, reason: collision with root package name */
    public static String f8659i;

    /* renamed from: j, reason: collision with root package name */
    public static int f8660j;

    /* renamed from: k, reason: collision with root package name */
    public static boolean f8661k;

    /* renamed from: l, reason: collision with root package name */
    public static boolean f8662l;

    /* renamed from: m, reason: collision with root package name */
    public static boolean f8663m;

    /* renamed from: n, reason: collision with root package name */
    public static boolean f8664n;

    /* renamed from: o, reason: collision with root package name */
    public static boolean f8665o;

    /* renamed from: p, reason: collision with root package name */
    public static boolean f8666p;

    /* renamed from: q, reason: collision with root package name */
    public static String f8667q;

    /* renamed from: r, reason: collision with root package name */
    public static String f8668r;

    /* renamed from: s, reason: collision with root package name */
    public static h8.b f8669s;

    public interface a {
        void G0(boolean z10);

        void d1(List list);
    }

    public interface b {
        void a();

        void b(int i10, String str, String str2);

        void d();

        void onLoading();

        void onPositionUpdate(long j10, long j11);

        void onStop();
    }

    static {
        g gVar = new g();
        f8651a = gVar;
        f8652b = "CastEventUtils";
        f8653c = new ArrayList();
        f8658h = 1001;
        f8659i = "";
        f8660j = -1;
        f8664n = true;
        f8667q = "";
        f8668r = "";
        f8669s = gVar.f();
    }

    public final void A(boolean z10) {
        f8661k = z10;
    }

    public final void B(boolean z10) {
        f8663m = z10;
    }

    public final void C(boolean z10) {
        f8662l = z10;
    }

    public final void D(String str, CastMedia castMedia, String str2) {
        t9.i.g(str, "session");
        t9.i.g(castMedia, "media");
        t9.i.g(str2, "extra");
        Integer j10 = new h8.a().j(str, castMedia, str2);
        if (j10 != null && j10.intValue() == 0) {
            h.f8694a.v(true);
        }
        h.f8694a.H(true);
    }

    public final void E(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, long j10, String str12, boolean z10) {
        t9.i.g(str, "url");
        t9.i.g(str2, "name");
        t9.i.g(str3, "program");
        t9.i.g(str4, "title");
        t9.i.g(str5, "episode");
        t9.i.g(str6, "buss");
        t9.i.g(str7, IjkMediaMeta.IJKM_KEY_FORMAT);
        t9.i.g(str8, "encode");
        t9.i.g(str9, "quality");
        t9.i.g(str10, "lang");
        t9.i.g(str11, "extra");
        t9.i.g(str12, Constants.KEY_HOST);
        if (f8655e == null) {
            return;
        }
        if (str.length() == 0) {
            return;
        }
        if (h.f8694a.t()) {
            G();
        }
        CastMedia castMedia = new CastMedia(str2, str3, str4, str5, str6, str7, str8, str9, str10, str, j10, str12, z10);
        String uuid = UUID.randomUUID().toString();
        t9.i.f(uuid, "randomUUID().toString()");
        f8668r = uuid;
        D(uuid, castMedia, str11);
    }

    public final void F() {
        f8653c.clear();
        h8.b bVar = f8669s;
        if (bVar != null) {
            bVar.f();
        }
    }

    public final void G() {
        h8.b bVar = f8669s;
        if (bVar != null) {
            bVar.e(f8668r);
        }
        h hVar = h.f8694a;
        hVar.v(false);
        hVar.H(false);
    }

    public final void H() {
        h8.b bVar = f8669s;
        if (bVar != null) {
            bVar.b();
        }
    }

    public final void I(Device device) {
        App.a aVar = App.f8263e;
        na.f.k(aVar.a(), "last_dlna_uid", device.getUdn());
        na.f.k(aVar.a(), "last_dlna_name", device.getFriendly_name());
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // f8.a
    public void a(String str) {
        b bVar;
        if (str != null) {
            switch (str.hashCode()) {
                case -1911454386:
                    if (str.equals("Paused") && (bVar = f8656f) != null) {
                        bVar.a();
                        break;
                    }
                    break;
                case -219666003:
                    if (str.equals("Stopped")) {
                        if (!f8666p) {
                            h.f8694a.v(false);
                            b bVar2 = f8656f;
                            if (bVar2 != null) {
                                bVar2.b(-1, "", h(f8668r));
                                break;
                            }
                        } else {
                            b bVar3 = f8656f;
                            if (bVar3 != null) {
                                bVar3.onStop();
                                break;
                            }
                        }
                    }
                    break;
                case 953020041:
                    if (str.equals("LG_TRANSITIONING")) {
                        h.f8694a.v(false);
                        b bVar4 = f8656f;
                        if (bVar4 != null) {
                            bVar4.b(IMediaPlayer.MEDIA_INFO_BUFFERING_START, "", h(f8668r));
                            break;
                        }
                    }
                    break;
                case 1171089422:
                    if (str.equals("Playing")) {
                        f8666p = true;
                        h.f8694a.v(true);
                        b bVar5 = f8656f;
                        if (bVar5 != null) {
                            bVar5.d();
                            break;
                        }
                    }
                    break;
                case 2001303836:
                    if (str.equals("Loading")) {
                        f8666p = false;
                        b bVar6 = f8656f;
                        if (bVar6 != null) {
                            bVar6.onLoading();
                            break;
                        }
                    }
                    break;
            }
        }
    }

    @Override // f8.a
    public void b(String str, String str2, int i10) {
        if (!t9.i.b(str2, "StartPlay")) {
            t9.i.b(str2, "StopPlay");
        } else if (ba.s.g(str, f8668r, false, 2, null)) {
            h.f8694a.v(i10 == 0);
            if (i10 != 0) {
                String h10 = h(str);
                b bVar = f8656f;
                if (bVar != null) {
                    bVar.b(i10, "", h10);
                }
            }
        }
        if (i10 == 0) {
            f8660j = 0;
        }
    }

    @Override // f8.a
    public void c(String str, String str2, String str3) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode == 497724214) {
                if (str.equals("cast_action")) {
                    CastAction castAction = str2 != null ? (CastAction) g8.b.f14068a.a(str2, CastAction.class) : null;
                    if (castAction != null) {
                        castAction.setCast_ver(f8667q);
                    }
                    if (castAction != null) {
                        c2.a.f5307a.a(castAction, elapsedRealtime, elapsedRealtime);
                        return;
                    }
                    return;
                }
                return;
            }
            if (hashCode == 1100412980) {
                if (str.equals("cast_play")) {
                    CastPlay castPlay = str2 != null ? (CastPlay) g8.b.f14068a.a(str2, CastPlay.class) : null;
                    if (castPlay != null) {
                        castPlay.setCast_ver(f8667q);
                    }
                    Long valueOf = castPlay != null ? Long.valueOf(castPlay.getDuration()) : null;
                    t9.i.d(valueOf);
                    long longValue = elapsedRealtime - valueOf.longValue();
                    c2.a.f5307a.c(castPlay, longValue > 0 ? longValue : elapsedRealtime, elapsedRealtime);
                    return;
                }
                return;
            }
            if (hashCode == 1155545264 && str.equals("cast_discovery")) {
                CastDeviceDiscovery castDeviceDiscovery = str2 != null ? (CastDeviceDiscovery) g8.b.f14068a.a(str2, CastDeviceDiscovery.class) : null;
                if (castDeviceDiscovery != null) {
                    castDeviceDiscovery.setCast_ver(f8667q);
                }
                if (castDeviceDiscovery != null) {
                    Context baseContext = App.f8263e.a().getBaseContext();
                    t9.i.f(baseContext, "App.instance.baseContext");
                    castDeviceDiscovery.setConnectToWifi(n(baseContext));
                }
                if (castDeviceDiscovery != null) {
                    long duration = elapsedRealtime - castDeviceDiscovery.getDuration();
                    c2.a.f5307a.b(castDeviceDiscovery, duration > 0 ? duration : elapsedRealtime, elapsedRealtime);
                }
            }
        }
    }

    @Override // f8.a
    public void d(Device device) {
        t9.i.g(device, com.hpplay.cybergarage.upnp.Device.ELEM_NAME);
        if (!device.getAlive()) {
            int size = f8653c.size();
            int i10 = 0;
            while (true) {
                if (i10 >= size) {
                    break;
                }
                if (t9.i.b(device.getUdn(), ((Device) f8653c.get(i10)).getUdn())) {
                    ArrayList arrayList = f8653c;
                    arrayList.remove(arrayList.get(i10));
                    break;
                }
                i10++;
            }
        } else if (!h.f8694a.o() || !t9.i.b(device, f8655e)) {
            f8653c.add(device);
        }
        a aVar = f8657g;
        if (aVar != null) {
            aVar.d1(f8653c);
        }
    }

    @Override // f8.a
    public void e(long j10, long j11) {
        long j12 = 1000;
        long j13 = j10 / j12;
        long j14 = j11 / j12;
        b bVar = f8656f;
        if (bVar != null) {
            bVar.onPositionUpdate(j13, j14);
        }
    }

    public final h8.b f() {
        return new h8.a();
    }

    public final Device g() {
        return f8655e;
    }

    public final String h(String str) {
        if (b0.K(str)) {
            Integer valueOf = str != null ? Integer.valueOf(str.length()) : null;
            t9.i.d(valueOf);
            if (valueOf.intValue() > 5) {
                String substring = str.substring(str.length() - 5, str.length());
                t9.i.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                return substring;
            }
        }
        return null;
    }

    public final void i() {
        u();
        f8667q = String.valueOf(new h8.a().d());
        h8.b bVar = f8669s;
        if (bVar != null) {
            bVar.d();
        }
        CastBean o10 = o();
        h8.b bVar2 = f8669s;
        if (bVar2 != null) {
            bVar2.g(g8.b.f14068a.c(o10));
        }
        q();
    }

    public final boolean j() {
        return f8665o;
    }

    public final boolean k(Device device) {
        t9.i.g(device, "compareServiceInfo");
        Device device2 = f8654d;
        if (device2 == null) {
            return false;
        }
        t9.i.d(device2);
        if (b0.H(device2.getUdn())) {
            Device device3 = f8654d;
            t9.i.d(device3);
            return t9.i.b(device3.getUdn(), device.getUdn());
        }
        Device device4 = f8654d;
        t9.i.d(device4);
        if (b0.H(device4.getFriendly_name())) {
            Device device5 = f8654d;
            t9.i.d(device5);
            if (t9.i.b(device5.getFriendly_name(), device.getFriendly_name())) {
                Device device6 = f8654d;
                t9.i.d(device6);
                if (t9.i.b(device6.getServer_product(), device.getServer_product())) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean l() {
        return f8663m;
    }

    public final boolean m() {
        return f8662l;
    }

    public final boolean n(Context context) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        Object systemService = context.getSystemService("connectivity");
        t9.i.e(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        NetworkInfo networkInfo = ((ConnectivityManager) systemService).getNetworkInfo(1);
        if (networkInfo != null) {
            return networkInfo.isConnected();
        }
        return false;
    }

    public final CastBean o() {
        String str;
        i.c cVar = w6.i.f19214g;
        String H = cVar.H();
        String E = cVar.E();
        GetSlbInfoBeanResultData A = r5.i.f18523a.A();
        if (A == null || (str = A.getPlay_params()) == null) {
            str = "";
        }
        return new CastBean("com.msandroid.mobile", "60201", H, E, str);
    }

    public final void p() {
        f8662l = true;
        h8.b bVar = f8669s;
        if (bVar != null) {
            bVar.h(f8668r);
        }
    }

    public final void q() {
        App.a aVar = App.f8263e;
        String f10 = na.f.f(aVar.a(), "last_dlna_name", "");
        if (f10 == null || f10.length() == 0) {
            return;
        }
        String f11 = na.f.f(aVar.a(), "last_dlna_uid", "");
        t9.i.f(f10, "name");
        t9.i.f(f11, ParamsMap.DeviceParams.KEY_UID);
        f8654d = new Device(f10, "", "", f11, "", "", false);
    }

    public final void r() {
        f8663m = false;
        h8.b bVar = f8669s;
        if (bVar != null) {
            bVar.a(f8668r);
        }
    }

    public final void s(long j10) {
        h8.b bVar = f8669s;
        if (bVar != null) {
            bVar.c(f8668r, j10);
        }
    }

    public final void t(Device device) {
        t9.i.g(device, com.hpplay.cybergarage.upnp.Device.ELEM_NAME);
        Integer i10 = new h8.a().i(device);
        if (i10 == null || i10.intValue() != 0) {
            a aVar = f8657g;
            if (aVar != null) {
                aVar.G0(false);
                return;
            }
            return;
        }
        f8655e = device;
        f8654d = device;
        a aVar2 = f8657g;
        if (aVar2 != null) {
            aVar2.G0(true);
        }
        I(device);
        na.f.k(App.f8263e.a(), "last_cast_mode", "DLNA_CAST");
    }

    public final void u() {
        new JniHandler().setOnCastCallBack(this);
    }

    public final void v(a aVar) {
        f8657g = aVar;
    }

    public final void w(b bVar) {
        f8656f = bVar;
    }

    public final void x(String str) {
        t9.i.g(str, "<set-?>");
        f8659i = str;
    }

    public final void y(boolean z10) {
        f8665o = z10;
    }

    public final void z(boolean z10) {
        f8666p = z10;
    }
}
