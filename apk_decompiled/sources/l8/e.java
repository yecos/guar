package l8;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.util.SparseArray;
import android.view.Surface;
import ba.s;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.google.android.gms.cast.MediaTrack;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.hpplay.sdk.source.common.global.Constant;
import com.taobao.accs.data.Message;
import com.titan.ranger.JniHandler;
import com.titan.ranger.NativeJni;
import com.titan.ranger.Status;
import com.titan.ranger.bean.Env;
import com.titan.ranger.bean.Program;
import com.titan.ranger.bean.report.PlayError;
import com.titan.ranger.bean.report.PlayFile;
import com.titan.ranger.bean.report.PlayMedia;
import com.titan.ranger.bean.report.PlayProgram;
import com.titan.ranger.bean.report.SwitchPlayer;
import com.titan.thumbnail.ThumbnailCallback;
import com.titan.thumbnail.ThumbnailUtil;
import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import m8.c;
import t9.v;
import t9.x;
import tv.danmaku.ijk.media.player.AndroidMediaPlayer;
import tv.danmaku.ijk.media.player.ExoMediaPlayer;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;
import tv.danmaku.ijk.media.player.MediaInfo;
import tv.danmaku.ijk.media.player.misc.IMediaFormat;
import tv.danmaku.ijk.media.player.misc.ITrackInfo;
import tv.danmaku.ijk.media.player.misc.IjkMediaFormat;
import tv.danmaku.ijk.media.player.widget.media.FileMediaDataSource;
import tv.danmaku.ijk.media.player.widget.media.MediaPlayerCompat;

/* loaded from: classes3.dex */
public final class e {
    public static final /* synthetic */ z9.g[] K = {x.e(new t9.r(x.a(e.class), "mPlayerContext", "getMPlayerContext()Lcom/titan/media/PlayerContext;"))};
    public final h9.g A;
    public final ReadWriteLock B;
    public final Lock C;
    public final Lock D;
    public HashMap E;
    public long F;
    public String G;
    public d H;
    public final ThumbnailCallback I;
    public final HandlerC0283e J;

    /* renamed from: a, reason: collision with root package name */
    public final String f16282a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f16283b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f16284c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f16285d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f16286e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f16287f;

    /* renamed from: g, reason: collision with root package name */
    public long f16288g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f16289h;

    /* renamed from: i, reason: collision with root package name */
    public int f16290i;

    /* renamed from: j, reason: collision with root package name */
    public int f16291j;

    /* renamed from: k, reason: collision with root package name */
    public String f16292k;

    /* renamed from: l, reason: collision with root package name */
    public j8.a f16293l;

    /* renamed from: m, reason: collision with root package name */
    public j8.b f16294m;

    /* renamed from: n, reason: collision with root package name */
    public IMediaPlayer f16295n;

    /* renamed from: o, reason: collision with root package name */
    public int f16296o;

    /* renamed from: p, reason: collision with root package name */
    public Context f16297p;

    /* renamed from: q, reason: collision with root package name */
    public m8.c f16298q;

    /* renamed from: r, reason: collision with root package name */
    public l8.g f16299r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f16300s;

    /* renamed from: t, reason: collision with root package name */
    public i8.b f16301t;

    /* renamed from: u, reason: collision with root package name */
    public i8.b f16302u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f16303v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f16304w;

    /* renamed from: x, reason: collision with root package name */
    public int f16305x;

    /* renamed from: y, reason: collision with root package name */
    public d8.c f16306y;

    /* renamed from: z, reason: collision with root package name */
    public l8.f f16307z;

    public static final class a implements IjkMediaPlayer.OnSelectTrackListener {
        public a() {
        }

        @Override // tv.danmaku.ijk.media.player.IjkMediaPlayer.OnSelectTrackListener
        public final void onSelectTrack(ArrayList arrayList) {
            String d10;
            ArrayList f10;
            ArrayList f11;
            ArrayList f12;
            ArrayList f13;
            String str = "";
            e.this.D.lock();
            try {
                if ((!t9.i.b(e.this.f16307z != null ? r2.d() : null, "")) && e.this.a0() != null) {
                    d8.c cVar = e.this.f16306y;
                    if (cVar != null) {
                        cVar.t(new ArrayList());
                    }
                    int size = arrayList.size();
                    for (int i10 = 0; i10 < size; i10++) {
                        SparseArray sparseArray = (SparseArray) arrayList.get(i10);
                        int keyAt = sparseArray.keyAt(0);
                        String str2 = (String) sparseArray.valueAt(0);
                        if (keyAt == i8.a.AVMEDIA_TYPE_VIDEO.a()) {
                            d8.b bVar = new d8.b(0, null, null, null, null, null, null, null, null, null, Message.EXT_HEADER_VALUE_MAX_LEN, null);
                            bVar.h(i10);
                            t9.i.c(str2, "stLang");
                            bVar.i(str2);
                            bVar.m("video");
                            d8.c cVar2 = e.this.f16306y;
                            if (cVar2 != null && (f13 = cVar2.f()) != null) {
                                f13.add(bVar);
                            }
                        } else if (keyAt == i8.a.AVMEDIA_TYPE_AUDIO.a()) {
                            d8.b bVar2 = new d8.b(0, null, null, null, null, null, null, null, null, null, Message.EXT_HEADER_VALUE_MAX_LEN, null);
                            bVar2.h(i10);
                            t9.i.c(str2, "stLang");
                            bVar2.i(str2);
                            bVar2.m("audio");
                            d8.c cVar3 = e.this.f16306y;
                            if (cVar3 != null && (f12 = cVar3.f()) != null) {
                                f12.add(bVar2);
                            }
                        } else if (keyAt == i8.a.AVMEDIA_TYPE_SUBTITLE.a()) {
                            d8.b bVar3 = new d8.b(0, null, null, null, null, null, null, null, null, null, Message.EXT_HEADER_VALUE_MAX_LEN, null);
                            bVar3.h(i10);
                            t9.i.c(str2, "stLang");
                            bVar3.i(str2);
                            bVar3.m(MediaTrack.ROLE_SUBTITLE);
                            d8.c cVar4 = e.this.f16306y;
                            if (cVar4 != null && (f11 = cVar4.f()) != null) {
                                f11.add(bVar3);
                            }
                        } else {
                            d8.b bVar4 = new d8.b(0, null, null, null, null, null, null, null, null, null, Message.EXT_HEADER_VALUE_MAX_LEN, null);
                            bVar4.h(i10);
                            t9.i.c(str2, "stLang");
                            bVar4.i(str2);
                            bVar4.m("unknown");
                            d8.c cVar5 = e.this.f16306y;
                            if (cVar5 != null && (f10 = cVar5.f()) != null) {
                                f10.add(bVar4);
                            }
                        }
                    }
                    e.this.f16303v = true;
                    d8.c cVar6 = e.this.f16306y;
                    if (cVar6 != null) {
                        j8.a a02 = e.this.a0();
                        if (a02 == null) {
                            t9.i.q();
                        }
                        l8.f fVar = e.this.f16307z;
                        if (fVar != null && (d10 = fVar.d()) != null) {
                            str = d10;
                        }
                        d8.d f14 = a02.f(cVar6, str);
                        if (f14 != null) {
                            e.this.D0(f14.a());
                        }
                    }
                }
                e.this.D.unlock();
                e.this.f16304w = true;
            } catch (Throwable th) {
                e.this.D.unlock();
                throw th;
            }
        }
    }

    public static final class b implements com.titan.ranger.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.titan.ranger.b f16309a;

        public b(com.titan.ranger.b bVar) {
            this.f16309a = bVar;
        }

        @Override // com.titan.ranger.b
        public void a(Status status) {
            com.titan.ranger.b bVar;
            if (status == null || (bVar = this.f16309a) == null) {
                return;
            }
            bVar.a(status);
        }
    }

    public static final class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            e.this.r0();
        }
    }

    public static final class d implements JniHandler.a {

        public static final class a implements Runnable {

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Object f16313b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ long f16314c;

            public a(Object obj, long j10) {
                this.f16313b = obj;
                this.f16314c = j10;
            }

            @Override // java.lang.Runnable
            public final void run() {
                l8.f fVar;
                l8.f fVar2;
                l8.f fVar3;
                l8.f fVar4 = e.this.f16307z;
                if (fVar4 != null && fVar4.r()) {
                    l8.f fVar5 = e.this.f16307z;
                    if (fVar5 != null) {
                        fVar5.E((Status) this.f16313b);
                    }
                    if (this.f16314c != 1000 || (fVar3 = e.this.f16307z) == null) {
                        return;
                    }
                    fVar3.F(true);
                    return;
                }
                l8.f fVar6 = e.this.f16307z;
                if (fVar6 == null || !fVar6.s()) {
                    e.this.w0((Status) this.f16313b);
                    if (this.f16314c == 1000 && (fVar = e.this.f16307z) != null) {
                        fVar.F(true);
                    }
                    e.R0(e.this, "", false, 2, null);
                    return;
                }
                e.this.w0((Status) this.f16313b);
                if (this.f16314c == 1000 && (fVar2 = e.this.f16307z) != null) {
                    fVar2.F(true);
                }
                e.this.l0();
            }
        }

        public d() {
        }

        @Override // com.titan.ranger.JniHandler.a
        public int getInstance() {
            return e.this.f16296o;
        }

        @Override // com.titan.ranger.JniHandler.a
        public int m(String str, String str2, long j10) {
            t9.i.h(str, "name");
            t9.i.h(str2, "path");
            j8.b b02 = e.this.b0();
            if (b02 != null) {
                b02.m(str, str2, j10);
            }
            if (!m8.d.b(str2)) {
                return 0;
            }
            e.this.E.put(str, str2);
            return 0;
        }

        @Override // com.titan.ranger.JniHandler.a
        public int n(int i10, String str, String str2, String str3) {
            t9.i.h(str, "event");
            t9.i.h(str2, "data");
            t9.i.h(str3, "app_ctx");
            try {
                switch (str.hashCode()) {
                    case -1877933145:
                        if (!str.equals("play_file")) {
                            return 22;
                        }
                        PlayFile playFile = (PlayFile) m8.a.a().fromJson(str2, PlayFile.class);
                        t9.i.c(playFile, "playFile");
                        playFile.setTitan_ver(l8.h.f16357m.c() + "-[" + NativeJni.f9456d + ']');
                        j8.b b02 = e.this.b0();
                        if (b02 != null) {
                            b02.j(i10, str, playFile, str3);
                            break;
                        }
                        break;
                    case 1283382393:
                        if (!str.equals("play_program")) {
                            return 22;
                        }
                        PlayProgram playProgram = (PlayProgram) m8.a.a().fromJson(str2, PlayProgram.class);
                        t9.i.c(playProgram, "playProgram");
                        playProgram.setTitan_ver(l8.h.f16357m.c() + "-[" + NativeJni.f9456d + ']');
                        j8.b b03 = e.this.b0();
                        if (b03 != null) {
                            b03.j(i10, str, playProgram, str3);
                            break;
                        }
                        break;
                    case 1814306380:
                        if (!str.equals("switch_player")) {
                            return 22;
                        }
                        SwitchPlayer switchPlayer = (SwitchPlayer) m8.a.a().fromJson(str2, SwitchPlayer.class);
                        t9.i.c(switchPlayer, "swPlayer");
                        switchPlayer.setTitan_ver(l8.h.f16357m.c() + "-[" + NativeJni.f9456d + ']');
                        j8.b b04 = e.this.b0();
                        if (b04 != null) {
                            b04.j(i10, str, switchPlayer, str3);
                            break;
                        }
                        break;
                    case 1912965437:
                        if (!str.equals("play_error")) {
                            return 22;
                        }
                        PlayError playError = (PlayError) m8.a.a().fromJson(str2, PlayError.class);
                        t9.i.c(playError, "playError");
                        playError.setTitan_ver(l8.h.f16357m.c() + "-[" + NativeJni.f9456d + ']');
                        j8.b b05 = e.this.b0();
                        if (b05 != null) {
                            b05.j(i10, str, playError, str3);
                            break;
                        }
                        break;
                    case 1919952665:
                        if (!str.equals("play_media")) {
                            return 22;
                        }
                        PlayMedia playMedia = (PlayMedia) m8.a.a().fromJson(str2, PlayMedia.class);
                        t9.i.c(playMedia, "playMedia");
                        playMedia.setTitan_ver(l8.h.f16357m.c() + "-[" + NativeJni.f9456d + ']');
                        j8.b b06 = e.this.b0();
                        if (b06 != null) {
                            b06.j(i10, str, playMedia, str3);
                            break;
                        }
                        break;
                    default:
                        return 22;
                }
                return 0;
            } catch (Exception e10) {
                e10.printStackTrace();
                return 0;
            }
        }

        @Override // com.titan.ranger.JniHandler.a
        public int o(String str, String str2, int i10) {
            String str3;
            t9.i.h(str, "obj");
            t9.i.h(str2, "action");
            j8.a a02 = e.this.a0();
            if (a02 == null) {
                return 0;
            }
            int i11 = e.this.f16296o;
            l8.f fVar = e.this.f16307z;
            if (fVar == null || (str3 = fVar.d()) == null) {
                str3 = "";
            }
            a02.c(i11, str, str2, i10, str3);
            return 0;
        }

        @Override // com.titan.ranger.JniHandler.a
        public int p(int i10, String str, Object obj, long j10) {
            if (m8.d.a(str) || obj == null || !(obj instanceof Status)) {
                return 22;
            }
            if (str != null) {
                int hashCode = str.hashCode();
                if (hashCode != -1589184968) {
                    if (hashCode == 1948221757 && str.equals("cast_prepared")) {
                        Status status = (Status) obj;
                        e.this.w0(status);
                        j8.b b02 = e.this.b0();
                        if (b02 == null) {
                            return 0;
                        }
                        b02.i(i10, "cast_prepared", status, j10);
                        return 0;
                    }
                } else if (str.equals("media_prepared")) {
                    e.this.J.post(new a(obj, j10));
                    return 0;
                }
            }
            j8.b b03 = e.this.b0();
            if (b03 == null) {
                return 0;
            }
            if (str == null) {
                t9.i.q();
            }
            b03.i(i10, str, (Status) obj, j10);
            return 0;
        }
    }

    /* renamed from: l8.e$e, reason: collision with other inner class name */
    public static final class HandlerC0283e extends Handler {
        public HandlerC0283e() {
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            j8.a a02;
            String d10;
            t9.i.h(message, Constant.KEY_MSG);
            int i10 = message.what;
            if (i10 != 61699) {
                if (i10 != 61703) {
                    return;
                }
                e.this.U0();
                e.this.F0(0);
                e.this.O0(0);
                e.this.l0();
                NativeJni.c().k(e.this.f16296o, "onReplay", 0, 0, 0L, "");
                return;
            }
            if ((!t9.i.b(e.this.f16307z != null ? r9.d() : null, "")) && (a02 = e.this.a0()) != null) {
                int i11 = e.this.f16296o;
                l8.f fVar = e.this.f16307z;
                a02.c(i11, "buffering", "none", 0, (fVar == null || (d10 = fVar.d()) == null) ? "" : d10);
            }
            l8.f fVar2 = e.this.f16307z;
            if (fVar2 != null) {
                fVar2.v(false);
            }
        }
    }

    public static final class f extends t9.j implements s9.a {

        /* renamed from: a, reason: collision with root package name */
        public static final f f16316a = new f();

        public f() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final l8.b invoke() {
            return new l8.b();
        }
    }

    public static final class g implements com.titan.ranger.c {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f16318b;

        public static final class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                g gVar = g.this;
                e.this.B0(gVar.f16318b);
            }
        }

        public g(long j10) {
            this.f16318b = j10;
        }

        @Override // com.titan.ranger.c
        public final void a(String str) {
            e.this.J.post(new a());
        }
    }

    public static final class h implements IMediaPlayer.OnPreparedListener {
        public h() {
        }

        /* JADX WARN: Removed duplicated region for block: B:114:0x02e4  */
        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void onPrepared(tv.danmaku.ijk.media.player.IMediaPlayer r14) {
            /*
                Method dump skipped, instructions count: 1055
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: l8.e.h.onPrepared(tv.danmaku.ijk.media.player.IMediaPlayer):void");
        }
    }

    public static final class i implements IMediaPlayer.OnCompletionListener {
        public i() {
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x006b  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x008e  */
        /* JADX WARN: Removed duplicated region for block: B:93:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void onCompletion(tv.danmaku.ijk.media.player.IMediaPlayer r12) {
            /*
                Method dump skipped, instructions count: 392
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: l8.e.i.onCompletion(tv.danmaku.ijk.media.player.IMediaPlayer):void");
        }
    }

    public static final class j implements IMediaPlayer.OnErrorListener {
        public j() {
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnErrorListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final boolean onError(IMediaPlayer iMediaPlayer, int i10, int i11) {
            l8.f fVar;
            j8.a a02;
            String d10;
            if (i10 != -38 && e.this.f16290i != 5) {
                if (e.this.Z() instanceof AndroidMediaPlayer) {
                    e.this.f16284c = false;
                }
                if (i10 != -10000 && i10 != -1004 && i10 != -110 && Build.VERSION.SDK_INT <= 22) {
                    NativeJni.c().k(e.this.f16296o, "onError", 0, 1103, 0L, "");
                    String str = "";
                    if ((!t9.i.b(e.this.f16307z != null ? r11.d() : null, "")) && (a02 = e.this.a0()) != null) {
                        int i12 = e.this.f16296o;
                        String a10 = e.this.f16301t.a();
                        l8.f fVar2 = e.this.f16307z;
                        if (fVar2 != null && (d10 = fVar2.d()) != null) {
                            str = d10;
                        }
                        a02.l(i12, 1103, a10, str);
                    }
                }
                if (i11 == 1100 && (e.this.Z() instanceof IjkMediaPlayer)) {
                    if (t9.i.b(Build.MODEL, "AFTSS") && (fVar = e.this.f16307z) != null) {
                        fVar.K(true);
                    }
                    NativeJni c10 = NativeJni.c();
                    int i13 = e.this.f16296o;
                    IMediaPlayer Z = e.this.Z();
                    if (Z == null) {
                        throw new h9.q("null cannot be cast to non-null type tv.danmaku.ijk.media.player.IjkMediaPlayer");
                    }
                    c10.h(i13, "codec_list", ((IjkMediaPlayer) Z).getCandidateCodecList());
                }
                int X = e.this.X(i10, i11);
                NativeJni.c().k(e.this.f16296o, "onError", i10, X, 0L, "");
                if (i11 != 1104 && i11 != 1100 && i11 != 1201 && i11 != 1105 && i11 != 1106) {
                    e.this.F0(-1);
                }
                e.this.f16292k = ";mediaPlayError:(" + i10 + ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN + X + ASCIIPropertyListParser.ARRAY_END_TOKEN;
            }
            return true;
        }
    }

    public static final class k implements IMediaPlayer.OnInfoListener {
        public k() {
        }

        /* JADX WARN: Removed duplicated region for block: B:59:0x01db  */
        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final boolean onInfo(tv.danmaku.ijk.media.player.IMediaPlayer r11, int r12, int r13) {
            /*
                Method dump skipped, instructions count: 512
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: l8.e.k.onInfo(tv.danmaku.ijk.media.player.IMediaPlayer, int, int):boolean");
        }
    }

    public static final class l implements IMediaPlayer.OnSeekCompleteListener {
        public l() {
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener
        public final void onSeekComplete(IMediaPlayer iMediaPlayer) {
            l8.f fVar;
            j8.a a02;
            String d10;
            String str;
            String d11;
            e.this.f16284c = false;
            l8.f fVar2 = e.this.f16307z;
            long e10 = fVar2 != null ? fVar2.e() : -1L;
            String str2 = "";
            if (e10 > 0 && e.this.f16301t == i8.b.NATIVE && e.this.n0()) {
                e eVar = e.this;
                l8.f fVar3 = eVar.f16307z;
                if (fVar3 != null && (d11 = fVar3.d()) != null) {
                    str2 = d11;
                }
                l8.f fVar4 = e.this.f16307z;
                eVar.C0(str2, fVar4 != null ? fVar4.e() : -1L);
                l8.f fVar5 = e.this.f16307z;
                if (fVar5 != null) {
                    fVar5.A(-1L);
                    return;
                }
                return;
            }
            NativeJni.c().k(e.this.f16296o, "onSeekComplete", 0, 0, 0L, "");
            e.this.F0(2);
            if (e.this.f16296o != 1 && e.this.f16298q == null) {
                e.this.S0();
            }
            if (!t9.i.b(e.this.f16307z != null ? r1.d() : null, "")) {
                j8.a a03 = e.this.a0();
                if (a03 != null) {
                    int i10 = e.this.f16296o;
                    l8.f fVar6 = e.this.f16307z;
                    if (fVar6 == null || (str = fVar6.d()) == null) {
                        str = "";
                    }
                    a03.k(i10, str);
                }
                if (e.this.f16301t == i8.b.NATIVE && (fVar = e.this.f16307z) != null && !fVar.n() && (a02 = e.this.a0()) != null) {
                    int i11 = e.this.f16296o;
                    l8.f fVar7 = e.this.f16307z;
                    a02.c(i11, "buffering", "none", 0, (fVar7 == null || (d10 = fVar7.d()) == null) ? "" : d10);
                }
            }
            if (e.this.f16285d) {
                i8.b bVar = e.this.f16302u;
                i8.b bVar2 = i8.b.NONE;
                if (bVar != bVar2) {
                    e eVar2 = e.this;
                    eVar2.W0(eVar2.f16302u.a(), 0);
                    e.this.f16302u = bVar2;
                }
            }
        }
    }

    public static final class m implements IMediaPlayer.OnBufferingUpdateListener {

        public static final class a implements com.titan.ranger.b {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ v f16326a;

            public a(v vVar) {
                this.f16326a = vVar;
            }

            @Override // com.titan.ranger.b
            public void a(Status status) {
                v vVar = this.f16326a;
                if (status == null) {
                    t9.i.q();
                }
                vVar.f18960a = status.getBuffer();
            }
        }

        public m() {
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener
        public final void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i10, long j10) {
            j8.a a02;
            String d10;
            l8.f fVar;
            l8.f fVar2;
            Program g10;
            l8.f fVar3 = e.this.f16307z;
            if (t9.i.b((fVar3 == null || (g10 = fVar3.g()) == null) ? null : g10.getBuss(), "live") && (fVar2 = e.this.f16307z) != null && fVar2.r()) {
                return;
            }
            boolean z10 = e.this.f16296o != 1 && ((fVar = e.this.f16307z) == null || fVar.q() != 0) && e.this.f16301t == i8.b.IJK;
            v vVar = new v();
            vVar.f18960a = 0L;
            if (z10) {
                e.this.g0(new a(vVar));
            }
            if (j10 <= 0 && i10 > 0) {
                d8.c cVar = e.this.f16306y;
                if ((cVar != null ? cVar.c() : 0L) > 0) {
                    d8.c cVar2 = e.this.f16306y;
                    j10 = (cVar2 != null ? cVar2.c() / 100 : 0L) * i10;
                }
            }
            if (e.this.Z() instanceof AndroidMediaPlayer) {
                e.this.F = j10;
            }
            long j11 = j10 + vVar.f18960a;
            l8.f fVar4 = e.this.f16307z;
            String d11 = fVar4 != null ? fVar4.d() : null;
            String str = "";
            if (!(!t9.i.b(d11, "")) || (a02 = e.this.a0()) == null) {
                return;
            }
            int i11 = e.this.f16296o;
            l8.f fVar5 = e.this.f16307z;
            if (fVar5 != null && (d10 = fVar5.d()) != null) {
                str = d10;
            }
            a02.d(i11, j11, str);
        }
    }

    public static final class n implements IMediaPlayer.OnReplayListener {
        public n() {
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnReplayListener
        public final void onReplay(IMediaPlayer iMediaPlayer) {
            e.this.J.removeMessages(61703);
            e.this.J.sendEmptyMessageDelayed(61703, 1500L);
        }
    }

    public static final class o implements IMediaPlayer.OnSeekListener {

        public static final class a implements com.titan.ranger.c {

            /* renamed from: a, reason: collision with root package name */
            public static final a f16329a = new a();

            @Override // com.titan.ranger.c
            public final void a(String str) {
            }
        }

        public o() {
        }

        @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekListener
        public final void onSeek(IMediaPlayer iMediaPlayer, long j10) {
            if (e.this.Z() == null || e.this.f16290i == 0 || e.this.f16290i == -1) {
                return;
            }
            e.this.q0();
            NativeJni c10 = NativeJni.c();
            int i10 = e.this.f16296o;
            l8.f fVar = e.this.f16307z;
            c10.r(i10, fVar != null ? fVar.d() : null, -1L, j10, a.f16329a);
        }
    }

    public static final class p extends t9.j implements s9.a {
        public p() {
            super(0);
        }

        @Override // s9.a
        public final String invoke() {
            e eVar = e.this;
            eVar.f16288g = eVar.V();
            e eVar2 = e.this;
            eVar2.f16289h = eVar2.o0();
            return e.this.G;
        }
    }

    public static final class q implements c.a {
        public q() {
        }

        @Override // m8.c.a
        public void a(String str) {
            j8.a a02;
            String d10;
            t9.i.h(str, "programData");
            l8.f fVar = e.this.f16307z;
            if (!m8.d.b(fVar != null ? fVar.f() : null) || e.this.Z() == null) {
                return;
            }
            e.this.q0();
            l8.f fVar2 = e.this.f16307z;
            String d11 = fVar2 != null ? fVar2.d() : null;
            String str2 = "";
            if (!(!t9.i.b(d11, "")) || (a02 = e.this.a0()) == null) {
                return;
            }
            int i10 = e.this.f16296o;
            long j10 = e.this.f16288g;
            l8.f fVar3 = e.this.f16307z;
            if (fVar3 != null && (d10 = fVar3.d()) != null) {
                str2 = d10;
            }
            a02.b(i10, j10, str2);
        }
    }

    public static final class r implements ThumbnailCallback {
        public r() {
        }

        @Override // com.titan.thumbnail.ThumbnailCallback
        public void onBitmapPrepared(boolean z10, Bitmap bitmap) {
            j8.a a02;
            String d10;
            String str = "";
            e.this.C.lock();
            try {
                if ((!t9.i.b(e.this.f16307z != null ? r1.d() : null, "")) && (a02 = e.this.a0()) != null) {
                    l8.f fVar = e.this.f16307z;
                    if (fVar != null && (d10 = fVar.d()) != null) {
                        str = d10;
                    }
                    a02.e(z10, bitmap, str);
                }
            } finally {
                e.this.C.unlock();
            }
        }

        @Override // com.titan.thumbnail.ThumbnailCallback
        public void onGetThumbnail(boolean z10) {
            j8.a a02;
            String d10;
            String str = "";
            e.this.C.lock();
            try {
                if ((!t9.i.b(e.this.f16307z != null ? r1.d() : null, "")) && (a02 = e.this.a0()) != null) {
                    l8.f fVar = e.this.f16307z;
                    if (fVar != null && (d10 = fVar.d()) != null) {
                        str = d10;
                    }
                    a02.g(z10, str);
                }
            } finally {
                e.this.C.unlock();
            }
        }
    }

    public e(int i10) {
        String simpleName = e.class.getSimpleName();
        t9.i.c(simpleName, "javaClass.simpleName");
        this.f16282a = simpleName;
        this.f16292k = "";
        this.f16296o = i10;
        this.f16301t = i8.b.NATIVE;
        this.f16302u = i8.b.NONE;
        this.f16305x = -1;
        this.A = h9.h.b(f.f16316a);
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.B = reentrantReadWriteLock;
        this.C = reentrantReadWriteLock.readLock();
        this.D = reentrantReadWriteLock.writeLock();
        this.E = new HashMap();
        this.G = "";
        this.H = new d();
        this.I = new r();
        this.J = new HandlerC0283e();
    }

    public static /* synthetic */ void R0(e eVar, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        eVar.Q0(str, z10);
    }

    public final int A0(String str) {
        t9.i.h(str, "name");
        l8.f fVar = this.f16307z;
        if (fVar != null && fVar.o()) {
            C0(str, 0L);
        }
        this.f16283b = false;
        this.f16286e = false;
        O0(3);
        if (!n0()) {
            return -1;
        }
        l8.f fVar2 = this.f16307z;
        if (fVar2 != null && !fVar2.p()) {
            NativeJni.c().q(this.f16296o, str);
        }
        IMediaPlayer iMediaPlayer = this.f16295n;
        if (iMediaPlayer != null && !iMediaPlayer.isPlaying()) {
            try {
                IMediaPlayer iMediaPlayer2 = this.f16295n;
                if (iMediaPlayer2 != null) {
                    iMediaPlayer2.start();
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            NativeJni.c().l(this.f16296o, "start", "", 0);
            this.f16284c = false;
            l8.f fVar3 = this.f16307z;
            if (fVar3 != null) {
                fVar3.w(false);
            }
            F0(3);
            S0();
        }
        return 0;
    }

    public final void B0(long j10) {
        j8.a aVar;
        String d10;
        if (n0()) {
            try {
                IMediaPlayer iMediaPlayer = this.f16295n;
                if (iMediaPlayer != null) {
                    iMediaPlayer.seekTo(j10);
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            this.f16284c = true;
            NativeJni.c().l(this.f16296o, "seekTo", "", 0);
            l8.f fVar = this.f16307z;
            if ((true ^ t9.i.b(fVar != null ? fVar.d() : null, "")) && (aVar = this.f16293l) != null) {
                int i10 = this.f16296o;
                l8.f fVar2 = this.f16307z;
                aVar.c(i10, "buffering", "show", 0, (fVar2 == null || (d10 = fVar2.d()) == null) ? "" : d10);
            }
            l8.f fVar3 = this.f16307z;
            if (fVar3 != null) {
                fVar3.I(j10);
            }
        }
    }

    public final int C0(String str, long j10) {
        l8.f fVar;
        l8.f fVar2;
        t9.i.h(str, "name");
        if (!n0()) {
            return -1;
        }
        if (this.f16290i == 5) {
            F0(4);
        }
        l8.f fVar3 = this.f16307z;
        if (fVar3 != null) {
            fVar3.w(false);
        }
        l8.f fVar4 = this.f16307z;
        if (fVar4 != null) {
            fVar4.H(j10);
        }
        if (this.f16284c && this.f16301t == i8.b.NATIVE) {
            l8.f fVar5 = this.f16307z;
            if (fVar5 != null) {
                fVar5.A(j10);
            }
            return -1;
        }
        NativeJni.c().h(this.f16296o, "seek_count", "");
        if ((this.f16296o != 1 && ((fVar2 = this.f16307z) == null || fVar2.q() != 0) && this.f16301t == i8.b.IJK) || ((fVar = this.f16307z) != null && fVar.p())) {
            B0(j10);
        } else {
            NativeJni.c().r(this.f16296o, str, j10, -1L, new g(j10));
        }
        return 0;
    }

    public final int D0(int i10) {
        ExoMediaPlayer exoMediaPlayer;
        MediaPlayer internalMediaPlayer;
        ExoMediaPlayer exoMediaPlayer2;
        MediaPlayer internalMediaPlayer2;
        d8.a a10;
        String str;
        MediaInfo mediaInfo;
        if (!n0()) {
            boolean z10 = this.f16303v;
            if (!z10 || this.f16304w) {
                if (!z10) {
                    return -1;
                }
                this.f16305x = i10;
                return 0;
            }
            IMediaPlayer iMediaPlayer = this.f16295n;
            if (iMediaPlayer instanceof IjkMediaPlayer) {
                IjkMediaPlayer ijkMediaPlayer = (IjkMediaPlayer) iMediaPlayer;
                if (ijkMediaPlayer != null) {
                    ijkMediaPlayer.selectTrack(i10);
                }
            } else if (iMediaPlayer instanceof AndroidMediaPlayer) {
                AndroidMediaPlayer androidMediaPlayer = (AndroidMediaPlayer) iMediaPlayer;
                if (androidMediaPlayer != null && (internalMediaPlayer = androidMediaPlayer.getInternalMediaPlayer()) != null) {
                    internalMediaPlayer.selectTrack(i10);
                }
            } else if ((iMediaPlayer instanceof ExoMediaPlayer) && (exoMediaPlayer = (ExoMediaPlayer) iMediaPlayer) != null) {
                exoMediaPlayer.selectAudioTrack(i10);
            }
            return 0;
        }
        IMediaPlayer iMediaPlayer2 = this.f16295n;
        if (iMediaPlayer2 instanceof IjkMediaPlayer) {
            IjkMediaPlayer ijkMediaPlayer2 = (IjkMediaPlayer) iMediaPlayer2;
            if (ijkMediaPlayer2 != null) {
                ijkMediaPlayer2.selectTrack(i10);
            }
        } else if (iMediaPlayer2 instanceof AndroidMediaPlayer) {
            AndroidMediaPlayer androidMediaPlayer2 = (AndroidMediaPlayer) iMediaPlayer2;
            if (androidMediaPlayer2 != null && (internalMediaPlayer2 = androidMediaPlayer2.getInternalMediaPlayer()) != null) {
                internalMediaPlayer2.selectTrack(i10);
            }
        } else if ((iMediaPlayer2 instanceof ExoMediaPlayer) && (exoMediaPlayer2 = (ExoMediaPlayer) iMediaPlayer2) != null) {
            exoMediaPlayer2.selectAudioTrack(i10);
        }
        NativeJni.c().h(this.f16296o, "switch_count", "");
        int e02 = e0(2);
        d8.c cVar = this.f16306y;
        ArrayList f10 = cVar != null ? cVar.f() : null;
        if (f10 != null) {
            Iterator it = f10.iterator();
            while (it.hasNext()) {
                d8.b bVar = (d8.b) it.next();
                if (e02 == bVar.b()) {
                    d8.c cVar2 = this.f16306y;
                    if (cVar2 != null && (a10 = cVar2.a()) != null) {
                        a10.g(bVar.b());
                        a10.h(bVar.c());
                        a10.d(bVar.a());
                        IMediaPlayer iMediaPlayer3 = this.f16295n;
                        if (iMediaPlayer3 == null || (mediaInfo = iMediaPlayer3.getMediaInfo()) == null || (str = mediaInfo.mAudioDecoderImpl) == null) {
                            str = "";
                        }
                        a10.e(str);
                    }
                    NativeJni.c().h(this.f16296o, "acodec", bVar.a());
                }
            }
        }
        return 0;
    }

    public final void E0(j8.a aVar, j8.b bVar) {
        t9.i.h(aVar, "playerCallback");
        t9.i.h(bVar, "rangerCallback");
        this.f16293l = aVar;
        this.f16294m = bVar;
        JniHandler.d(this.f16296o, this.H);
    }

    public final void F0(int i10) {
        this.f16290i = i10;
    }

    public final void G0(int i10) {
        Y().h(i10);
    }

    public final void H0(int i10) {
        Y().i(i10);
    }

    public final void I0(Context context) {
        this.f16297p = context;
    }

    public final int J0(String str, String str2) {
        Program g10;
        t9.i.h(str, "name");
        t9.i.h(str2, "media");
        l8.f fVar = this.f16307z;
        if (fVar != null && (g10 = fVar.g()) != null) {
            g10.setMedia(str2);
        }
        l8.f fVar2 = this.f16307z;
        if (fVar2 != null) {
            fVar2.F(false);
        }
        l8.f fVar3 = this.f16307z;
        if (fVar3 != null) {
            fVar3.H(-1L);
        }
        l8.f fVar4 = this.f16307z;
        if (fVar4 != null) {
            fVar4.G(0L);
        }
        this.f16306y = null;
        p0("end");
        NativeJni.c().t(this.f16296o, str, str2);
        return 0;
    }

    public final void K0() {
        IMediaPlayer iMediaPlayer = this.f16295n;
        if (iMediaPlayer != null) {
            iMediaPlayer.setOnPreparedListener(new h());
        }
        IMediaPlayer iMediaPlayer2 = this.f16295n;
        if (iMediaPlayer2 != null) {
            iMediaPlayer2.setOnCompletionListener(new i());
        }
        IMediaPlayer iMediaPlayer3 = this.f16295n;
        if (iMediaPlayer3 != null) {
            iMediaPlayer3.setOnErrorListener(new j());
        }
        IMediaPlayer iMediaPlayer4 = this.f16295n;
        if (iMediaPlayer4 != null) {
            iMediaPlayer4.setOnInfoListener(new k());
        }
        IMediaPlayer iMediaPlayer5 = this.f16295n;
        if (iMediaPlayer5 != null) {
            iMediaPlayer5.setOnSeekCompleteListener(new l());
        }
        IMediaPlayer iMediaPlayer6 = this.f16295n;
        if (iMediaPlayer6 != null) {
            iMediaPlayer6.setOnBufferingUpdateListener(new m());
        }
        IMediaPlayer iMediaPlayer7 = this.f16295n;
        if (iMediaPlayer7 != null) {
            iMediaPlayer7.setOnReplayListener(new n());
        }
        IMediaPlayer iMediaPlayer8 = this.f16295n;
        if (iMediaPlayer8 != null) {
            iMediaPlayer8.setOnSeekListener(new o());
        }
    }

    public final void L0(int i10) {
        Y().g(i10);
    }

    public final int M0(int i10) {
        n0();
        return 0;
    }

    public final void N0(Surface surface, String str) {
        t9.i.h(str, "surfaceId");
        if (surface == null) {
            l8.g gVar = this.f16299r;
            if (t9.i.b(str, gVar != null ? gVar.a() : null)) {
                IMediaPlayer iMediaPlayer = this.f16295n;
                if (iMediaPlayer != null) {
                    iMediaPlayer.setSurface(null);
                }
                this.f16299r = null;
                this.f16300s = false;
                return;
            }
            return;
        }
        l8.g gVar2 = new l8.g(str, surface);
        this.f16299r = gVar2;
        if (!this.f16300s) {
            IMediaPlayer iMediaPlayer2 = this.f16295n;
            if (iMediaPlayer2 != null) {
                iMediaPlayer2.setSurface(gVar2.b());
            }
            this.f16300s = true;
        }
        l8.f fVar = this.f16307z;
        if (m8.d.b(fVar != null ? fVar.f() : null) && this.f16295n == null) {
            l0();
        }
    }

    public final void O0(int i10) {
        this.f16291j = i10;
    }

    public final int P0(int i10) {
        float f10 = i10 / 100;
        if (!n0()) {
            Y().j(f10);
            Y().k(true);
            return 0;
        }
        Y().j(f10);
        IMediaPlayer iMediaPlayer = this.f16295n;
        if (iMediaPlayer == null) {
            return 0;
        }
        iMediaPlayer.setVolume(f10, f10);
        return 0;
    }

    public final void Q0(String str, boolean z10) {
        String l10;
        Program g10;
        d8.c cVar;
        t9.i.h(str, "realPlayUrl");
        l8.f fVar = this.f16307z;
        if (fVar != null) {
            fVar.B(z10);
        }
        l8.f fVar2 = this.f16307z;
        if (fVar2 != null) {
            fVar2.I(0L);
        }
        l8.f fVar3 = this.f16307z;
        String str2 = "";
        if (fVar3 != null) {
            if (m8.d.a(str) && ((cVar = this.f16306y) == null || (str = cVar.e()) == null)) {
                str = "";
            }
            fVar3.C(str);
        }
        l8.f fVar4 = this.f16307z;
        if (t9.i.b((fVar4 == null || (g10 = fVar4.g()) == null) ? null : g10.getBuss(), "vod") && !z10) {
            ThumbnailUtil thumbnailUtil = ThumbnailUtil.INSTANCE;
            l8.f fVar5 = this.f16307z;
            if (fVar5 != null && (l10 = fVar5.l()) != null) {
                str2 = l10;
            }
            thumbnailUtil.setSnapInfoUrl(str2);
        }
        l0();
    }

    public final void S() {
        if (this.f16296o != 1) {
            m8.c cVar = this.f16298q;
            if (cVar != null) {
                cVar.c();
            }
            this.f16298q = null;
        }
    }

    public final void S0() {
        S();
        if (this.f16296o != 1) {
            l8.f fVar = this.f16307z;
            if (!m8.d.b(fVar != null ? fVar.f() : null) || this.f16295n == null) {
                return;
            }
            if (this.f16298q == null) {
                this.f16298q = new m8.c();
            }
            m8.c cVar = this.f16298q;
            if (cVar == null) {
                t9.i.q();
            }
            cVar.d(Y().a(), new p(), new q());
        }
    }

    public final void T() {
        IMediaPlayer iMediaPlayer;
        try {
            x0();
            this.f16295n = U();
            if (Y().e()) {
                IMediaPlayer iMediaPlayer2 = this.f16295n;
                if (iMediaPlayer2 != null) {
                    iMediaPlayer2.setVolume(Y().d(), Y().d());
                }
                if (Y().d() == 1.0f) {
                    Y().k(false);
                }
            }
            K0();
            l8.g gVar = this.f16299r;
            if (gVar != null && (iMediaPlayer = this.f16295n) != null) {
                iMediaPlayer.setSurface(gVar.b());
            }
            IMediaPlayer iMediaPlayer3 = this.f16295n;
            if (iMediaPlayer3 != null) {
                iMediaPlayer3.setScreenOnWhilePlaying(true);
            }
        } catch (AssertionError unused) {
            NativeJni.c().k(this.f16296o, "onError", 0, 1202, 0L, "");
        } catch (Exception unused2) {
        }
    }

    public final int T0(String str) {
        t9.i.h(str, "name");
        NativeJni.c().v(this.f16296o, str);
        this.f16306y = null;
        this.f16307z = null;
        return 0;
    }

    public final IMediaPlayer U() {
        l8.f fVar;
        Program g10;
        l8.f fVar2;
        l8.f fVar3 = this.f16307z;
        if (!m8.d.b(fVar3 != null ? fVar3.f() : null)) {
            return null;
        }
        int i10 = l8.d.f16281a[this.f16301t.ordinal()];
        if (i10 == 1) {
            Context context = this.f16297p;
            if (context != null) {
                return new ExoMediaPlayer(context);
            }
            throw new IllegalStateException("ExoMediaPlayer need context!".toString());
        }
        if (i10 == 2) {
            return new AndroidMediaPlayer();
        }
        if (this.f16296o != 1 && ((fVar2 = this.f16307z) == null || fVar2.q() != 0)) {
            r2 = true;
        }
        l8.a aVar = l8.a.f16274a;
        String b10 = Y().b();
        l8.f fVar4 = this.f16307z;
        boolean b11 = t9.i.b((fVar4 == null || (g10 = fVar4.g()) == null) ? null : g10.getBuss(), "live");
        int f10 = Y().f();
        l8.f fVar5 = this.f16307z;
        IMediaPlayer a10 = aVar.a(b10, b11, f10, r2, fVar5 != null ? fVar5.b() : null);
        if (a10 == null) {
            throw new h9.q("null cannot be cast to non-null type tv.danmaku.ijk.media.player.IjkMediaPlayer");
        }
        IjkMediaPlayer ijkMediaPlayer = (IjkMediaPlayer) a10;
        if (r2 && (fVar = this.f16307z) != null) {
            ijkMediaPlayer.setSharedBuffer(fVar.a());
        }
        ijkMediaPlayer.setOnSelectTrackListener(new a());
        return ijkMediaPlayer;
    }

    public final void U0() {
        try {
            IMediaPlayer iMediaPlayer = this.f16295n;
            if (iMediaPlayer != null) {
                iMediaPlayer.stop();
            }
        } catch (Exception unused) {
        }
        NativeJni.c().l(this.f16296o, "stop", "", 0);
        y0();
        S();
    }

    public final long V() {
        if (!n0()) {
            return -1L;
        }
        IMediaPlayer iMediaPlayer = this.f16295n;
        Long valueOf = iMediaPlayer != null ? Long.valueOf(iMediaPlayer.getCurrentPosition()) : null;
        if (valueOf == null) {
            t9.i.q();
        }
        return valueOf.longValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0070, code lost:
    
        if (t9.i.b((r11 == null || (r11 = r11.g()) == null) ? null : r11.getBuss(), "record") != false) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int V0(java.lang.String r11) {
        /*
            r10 = this;
            java.lang.String r0 = "name"
            t9.i.h(r11, r0)
            r0 = 0
            r10.f16306y = r0
            r10.S()
            java.lang.String r1 = "end"
            r10.p0(r1)
            r10.x0()     // Catch: java.lang.AssertionError -> L14 java.lang.Exception -> L27
            goto L28
        L14:
            com.titan.ranger.NativeJni r2 = com.titan.ranger.NativeJni.c()
            int r3 = r10.f16296o
            java.lang.String r4 = "onError"
            r5 = 0
            r6 = 1202(0x4b2, float:1.684E-42)
            r7 = 0
            java.lang.String r9 = ""
            r2.k(r3, r4, r5, r6, r7, r9)
            goto L28
        L27:
        L28:
            r1 = 0
            r10.F0(r1)
            r10.O0(r1)
            l8.f r2 = r10.f16307z
            if (r2 == 0) goto L42
            boolean r2 = r2.p()
            if (r2 != 0) goto L42
            com.titan.ranger.NativeJni r2 = com.titan.ranger.NativeJni.c()
            int r3 = r10.f16296o
            r2.w(r3, r11)
        L42:
            l8.f r11 = r10.f16307z
            if (r11 == 0) goto L51
            com.titan.ranger.bean.Program r11 = r11.g()
            if (r11 == 0) goto L51
            java.lang.String r11 = r11.getBuss()
            goto L52
        L51:
            r11 = r0
        L52:
            java.lang.String r2 = "vod"
            boolean r11 = t9.i.b(r11, r2)
            if (r11 != 0) goto L72
            l8.f r11 = r10.f16307z
            if (r11 == 0) goto L69
            com.titan.ranger.bean.Program r11 = r11.g()
            if (r11 == 0) goto L69
            java.lang.String r11 = r11.getBuss()
            goto L6a
        L69:
            r11 = r0
        L6a:
            java.lang.String r2 = "record"
            boolean r11 = t9.i.b(r11, r2)
            if (r11 == 0) goto L81
        L72:
            com.titan.thumbnail.ThumbnailUtil r11 = com.titan.thumbnail.ThumbnailUtil.INSTANCE
            r11.reset()
            com.titan.thumbnail.PreviewUtil r11 = com.titan.thumbnail.PreviewUtil.INSTANCE
            r11.recycle()
            com.titan.thumbnail.ThumbnailRequest r11 = com.titan.thumbnail.ThumbnailRequest.INSTANCE
            r11.cancel()
        L81:
            java.util.concurrent.locks.Lock r11 = r10.D
            r11.lock()
            l8.f r11 = r10.f16307z     // Catch: java.lang.Throwable -> L97
            if (r11 == 0) goto L8f
            java.lang.String r2 = ""
            r11.z(r2)     // Catch: java.lang.Throwable -> L97
        L8f:
            r10.f16307z = r0     // Catch: java.lang.Throwable -> L97
            java.util.concurrent.locks.Lock r11 = r10.D
            r11.unlock()
            return r1
        L97:
            r11 = move-exception
            java.util.concurrent.locks.Lock r0 = r10.D
            r0.unlock()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: l8.e.V0(java.lang.String):int");
    }

    public final long W() {
        if (!n0()) {
            return -1L;
        }
        IMediaPlayer iMediaPlayer = this.f16295n;
        Long valueOf = iMediaPlayer != null ? Long.valueOf(iMediaPlayer.getDuration()) : null;
        if (valueOf == null) {
            t9.i.q();
        }
        return valueOf.longValue();
    }

    public final int W0(String str, int i10) {
        l8.f fVar;
        l8.f fVar2;
        Program g10;
        t9.i.h(str, "playerType");
        l8.f fVar3 = this.f16307z;
        if (!m8.d.b(fVar3 != null ? fVar3.f() : null) || this.f16295n == null) {
            if (!t9.i.b(str, this.f16301t.a())) {
                i8.b a10 = i8.b.f14358g.a(str);
                if (a10 == null) {
                    t9.i.q();
                }
                this.f16301t = a10;
                NativeJni.c().g(this.f16296o, this.f16301t.a(), -1);
            }
        } else if (!t9.i.b(str, this.f16301t.a())) {
            boolean z10 = this.f16301t == i8.b.NATIVE;
            i8.b a11 = i8.b.f14358g.a(str);
            if (a11 == null) {
                t9.i.q();
            }
            if (this.f16284c && z10) {
                this.f16285d = true;
                this.f16302u = a11;
                return 0;
            }
            this.f16301t = a11;
            l8.f fVar4 = this.f16307z;
            if (!t9.i.b((fVar4 == null || (g10 = fVar4.g()) == null) ? null : g10.getBuss(), "live")) {
                long V = V();
                if (V > 1 && (fVar = this.f16307z) != null && fVar.i() == 0 && (fVar2 = this.f16307z) != null) {
                    fVar2.G(V);
                }
            }
            z0();
            l8.f fVar5 = this.f16307z;
            if (fVar5 != null) {
                fVar5.H(-1L);
            }
            d8.c cVar = this.f16306y;
            if (cVar != null) {
                cVar.p(this.f16301t.a());
            }
            d8.c cVar2 = this.f16306y;
            if (cVar2 != null) {
                cVar2.u(null);
            }
            d8.c cVar3 = this.f16306y;
            if (cVar3 != null) {
                cVar3.h(null);
            }
            d8.c cVar4 = this.f16306y;
            if (cVar4 != null) {
                cVar4.r(null);
            }
            d8.c cVar5 = this.f16306y;
            if (cVar5 != null) {
                cVar5.t(null);
            }
            l8.f fVar6 = this.f16307z;
            if (fVar6 == null || !fVar6.p()) {
                NativeJni.c().g(this.f16296o, this.f16301t.a(), i10);
            } else {
                l0();
            }
        }
        return 0;
    }

    public final int X(int i10, int i11) {
        if (i10 == -10000) {
            return i11;
        }
        if (-1004 == i11) {
            return 3000;
        }
        return -1007 == i11 ? AuthApiStatusCodes.AUTH_API_ACCESS_FORBIDDEN : -1010 == i11 ? AuthApiStatusCodes.AUTH_API_CLIENT_ERROR : -110 == i11 ? AuthApiStatusCodes.AUTH_API_SERVER_ERROR : AuthApiStatusCodes.AUTH_TOKEN_ERROR;
    }

    public final void X0(String str, Program program) {
        this.D.lock();
        try {
            l8.f fVar = new l8.f();
            this.f16307z = fVar;
            fVar.z(str);
            this.D.unlock();
            l8.f fVar2 = this.f16307z;
            if (fVar2 != null) {
                fVar2.D(program);
            }
        } catch (Throwable th) {
            this.D.unlock();
            throw th;
        }
    }

    public final l8.b Y() {
        h9.g gVar = this.A;
        z9.g gVar2 = K[0];
        return (l8.b) gVar.getValue();
    }

    public final IMediaPlayer Z() {
        return this.f16295n;
    }

    public final j8.a a0() {
        return this.f16293l;
    }

    public final j8.b b0() {
        return this.f16294m;
    }

    public final String c0() {
        IMediaPlayer iMediaPlayer = this.f16295n;
        if (!(iMediaPlayer instanceof IjkMediaPlayer)) {
            return "none";
        }
        if (iMediaPlayer == null) {
            throw new h9.q("null cannot be cast to non-null type tv.danmaku.ijk.media.player.IjkMediaPlayer");
        }
        String dumpPlayInfo = ((IjkMediaPlayer) iMediaPlayer).dumpPlayInfo();
        t9.i.c(dumpPlayInfo, "(mediaPlayer as IjkMediaPlayer).dumpPlayInfo()");
        return dumpPlayInfo;
    }

    public final int d0(int i10) {
        return MediaPlayerCompat.getSelectedTrack(this.f16295n, i10);
    }

    public final int e0(int i10) {
        MediaPlayer internalMediaPlayer;
        int selectedTrack;
        if (!n0()) {
            return -1;
        }
        IMediaPlayer iMediaPlayer = this.f16295n;
        if (!(iMediaPlayer instanceof AndroidMediaPlayer)) {
            return d0(i10);
        }
        if (Build.VERSION.SDK_INT < 21) {
            return -1;
        }
        try {
            AndroidMediaPlayer androidMediaPlayer = (AndroidMediaPlayer) iMediaPlayer;
            if (androidMediaPlayer == null || (internalMediaPlayer = androidMediaPlayer.getInternalMediaPlayer()) == null) {
                return -1;
            }
            selectedTrack = internalMediaPlayer.getSelectedTrack(i10);
            return selectedTrack;
        } catch (Exception e10) {
            e10.printStackTrace();
            return -1;
        }
    }

    public final d8.c f0() {
        d8.a a10;
        d8.a a11;
        d8.a a12;
        d8.f g10;
        d8.f g11;
        d8.f g12;
        IMediaPlayer iMediaPlayer = this.f16295n;
        if (!(iMediaPlayer instanceof IjkMediaPlayer)) {
            iMediaPlayer = null;
        }
        IjkMediaPlayer ijkMediaPlayer = (IjkMediaPlayer) iMediaPlayer;
        if (ijkMediaPlayer != null) {
            d8.c cVar = this.f16306y;
            if (cVar != null && (g12 = cVar.g()) != null) {
                g12.c(ijkMediaPlayer.getVideoCachedDuration());
            }
            d8.c cVar2 = this.f16306y;
            if (cVar2 != null && (g11 = cVar2.g()) != null) {
                g11.b(ijkMediaPlayer.getVideoCachedBytes());
            }
            d8.c cVar3 = this.f16306y;
            if (cVar3 != null && (g10 = cVar3.g()) != null) {
                g10.f(ijkMediaPlayer.getVideoDecodeFramesPerSecond());
            }
            d8.c cVar4 = this.f16306y;
            if (cVar4 != null && (a12 = cVar4.a()) != null) {
                a12.c(ijkMediaPlayer.getAudioCachedDuration());
            }
            d8.c cVar5 = this.f16306y;
            if (cVar5 != null && (a11 = cVar5.a()) != null) {
                a11.b(ijkMediaPlayer.getAudioCachedBytes());
            }
            d8.c cVar6 = this.f16306y;
            if (cVar6 != null && (a10 = cVar6.a()) != null) {
                a10.f(ijkMediaPlayer.getAVDiff());
            }
        }
        d8.c cVar7 = this.f16306y;
        if (cVar7 != null) {
            cVar7.p(this.f16301t.a());
        }
        return this.f16306y;
    }

    public final void g0(com.titan.ranger.b bVar) {
        l8.f fVar = this.f16307z;
        if (m8.d.b(fVar != null ? fVar.d() : null)) {
            NativeJni c10 = NativeJni.c();
            int i10 = this.f16296o;
            l8.f fVar2 = this.f16307z;
            c10.e(i10, fVar2 != null ? fVar2.d() : null, new b(bVar));
        }
    }

    public final ThumbnailCallback h0() {
        return this.I;
    }

    public final void i0() {
        MediaInfo mediaInfo;
        String str;
        MediaInfo mediaInfo2;
        String str2;
        d8.c cVar;
        int e02 = e0(1);
        int e03 = e0(2);
        int e04 = e0(3);
        ArrayList j02 = j0();
        d8.c cVar2 = this.f16306y;
        if (cVar2 != null) {
            cVar2.t(j02);
        }
        Iterator it = j02.iterator();
        while (it.hasNext()) {
            d8.b bVar = (d8.b) it.next();
            int b10 = bVar.b();
            String str3 = "";
            if (b10 == e02) {
                d8.c cVar3 = this.f16306y;
                if (cVar3 != null) {
                    d8.f fVar = new d8.f(0, null, null, 0.0f, 0L, 0L, 63, null);
                    fVar.g(bVar.b());
                    fVar.d(bVar.a());
                    IMediaPlayer iMediaPlayer = this.f16295n;
                    if (iMediaPlayer != null && (mediaInfo = iMediaPlayer.getMediaInfo()) != null && (str = mediaInfo.mVideoDecoderImpl) != null) {
                        str3 = str;
                    }
                    fVar.e(str3);
                    NativeJni.c().h(this.f16296o, "vdecoder", fVar.a());
                    cVar3.u(fVar);
                }
                NativeJni.c().h(this.f16296o, "vcodec", bVar.a());
            } else if (b10 == e03) {
                d8.c cVar4 = this.f16306y;
                if (cVar4 != null) {
                    d8.a aVar = new d8.a(0, null, null, null, 0.0f, 0L, 0L, 127, null);
                    aVar.g(bVar.b());
                    aVar.h(bVar.c());
                    aVar.d(bVar.a());
                    IMediaPlayer iMediaPlayer2 = this.f16295n;
                    if (iMediaPlayer2 != null && (mediaInfo2 = iMediaPlayer2.getMediaInfo()) != null && (str2 = mediaInfo2.mAudioDecoderImpl) != null) {
                        str3 = str2;
                    }
                    aVar.e(str3);
                    cVar4.h(aVar);
                }
                NativeJni.c().h(this.f16296o, "acodec", bVar.a());
            } else if (b10 == e04 && (cVar = this.f16306y) != null) {
                d8.e eVar = new d8.e(0, null, null, 0.0f, 15, null);
                eVar.b(bVar.b());
                eVar.a(bVar.a());
                eVar.c(bVar.c());
                cVar.r(eVar);
            }
        }
    }

    public final ArrayList j0() {
        ArrayList f10;
        ArrayList arrayList = new ArrayList();
        try {
            IMediaPlayer iMediaPlayer = this.f16295n;
            ITrackInfo[] trackInfo = iMediaPlayer != null ? iMediaPlayer.getTrackInfo() : null;
            if (trackInfo != null) {
                if (!(trackInfo.length == 0)) {
                    int length = trackInfo.length;
                    for (int i10 = 0; i10 < length; i10++) {
                        ITrackInfo iTrackInfo = trackInfo[i10];
                        t9.i.c(iTrackInfo, "info");
                        if (iTrackInfo.getTrackType() == 2) {
                            d8.b bVar = new d8.b(0, null, null, null, null, null, null, null, null, null, Message.EXT_HEADER_VALUE_MAX_LEN, null);
                            IMediaFormat format = iTrackInfo.getFormat();
                            if (!(format instanceof IjkMediaFormat)) {
                                format = null;
                            }
                            IjkMediaFormat ijkMediaFormat = (IjkMediaFormat) format;
                            if (ijkMediaFormat != null) {
                                String string = ijkMediaFormat.getString(IjkMediaFormat.KEY_IJK_CODEC_NAME_UI);
                                t9.i.c(string, "it.getString(IjkMediaFormat.KEY_IJK_CODEC_NAME_UI)");
                                bVar.f(string);
                                String string2 = ijkMediaFormat.getString(IjkMediaFormat.KEY_IJK_CHANNELS_UI);
                                t9.i.c(string2, "it.getString(IjkMediaFormat.KEY_IJK_CHANNELS_UI)");
                                bVar.e(string2);
                                String string3 = ijkMediaFormat.getString(IjkMediaFormat.KEY_IJK_SAMPLE_RATE_UI);
                                t9.i.c(string3, "it.getString(IjkMediaFor…t.KEY_IJK_SAMPLE_RATE_UI)");
                                bVar.l(string3);
                            }
                            bVar.h(i10);
                            String language = iTrackInfo.getLanguage();
                            t9.i.c(language, "info.language");
                            bVar.i(language);
                            bVar.m("audio");
                            arrayList.add(bVar);
                        } else if (iTrackInfo.getTrackType() == 1) {
                            d8.b bVar2 = new d8.b(0, null, null, null, null, null, null, null, null, null, Message.EXT_HEADER_VALUE_MAX_LEN, null);
                            IMediaFormat format2 = iTrackInfo.getFormat();
                            if (!(format2 instanceof IjkMediaFormat)) {
                                format2 = null;
                            }
                            IjkMediaFormat ijkMediaFormat2 = (IjkMediaFormat) format2;
                            if (ijkMediaFormat2 != null) {
                                String string4 = ijkMediaFormat2.getString(IjkMediaFormat.KEY_IJK_CODEC_PIXEL_FORMAT_UI);
                                t9.i.c(string4, "it.getString(IjkMediaFor…JK_CODEC_PIXEL_FORMAT_UI)");
                                bVar2.j(string4);
                                String string5 = ijkMediaFormat2.getString(IjkMediaFormat.KEY_IJK_CODEC_NAME_UI);
                                t9.i.c(string5, "it.getString(IjkMediaFormat.KEY_IJK_CODEC_NAME_UI)");
                                bVar2.f(string5);
                                String string6 = ijkMediaFormat2.getString(IjkMediaFormat.KEY_IJK_FRAME_RATE_UI);
                                t9.i.c(string6, "it.getString(IjkMediaFormat.KEY_IJK_FRAME_RATE_UI)");
                                bVar2.g(string6);
                            }
                            bVar2.h(i10);
                            bVar2.m("video");
                            StringBuilder sb = new StringBuilder();
                            IMediaPlayer iMediaPlayer2 = this.f16295n;
                            sb.append(iMediaPlayer2 != null ? Integer.valueOf(iMediaPlayer2.getVideoWidth()) : "0");
                            sb.append(" x ");
                            IMediaPlayer iMediaPlayer3 = this.f16295n;
                            sb.append(iMediaPlayer3 != null ? Integer.valueOf(iMediaPlayer3.getVideoHeight()) : "0");
                            bVar2.k(sb.toString());
                            arrayList.add(bVar2);
                        } else if (iTrackInfo.getTrackType() == 3) {
                            d8.b bVar3 = new d8.b(0, null, null, null, null, null, null, null, null, null, Message.EXT_HEADER_VALUE_MAX_LEN, null);
                            IMediaFormat format3 = iTrackInfo.getFormat();
                            if (!(format3 instanceof IjkMediaFormat)) {
                                format3 = null;
                            }
                            IjkMediaFormat ijkMediaFormat3 = (IjkMediaFormat) format3;
                            if (ijkMediaFormat3 != null) {
                                String string7 = ijkMediaFormat3.getString(IjkMediaFormat.KEY_IJK_CODEC_NAME_UI);
                                t9.i.c(string7, "it.getString(IjkMediaFormat.KEY_IJK_CODEC_NAME_UI)");
                                bVar3.f(string7);
                            }
                            bVar3.h(i10);
                            String language2 = iTrackInfo.getLanguage();
                            t9.i.c(language2, "info.language");
                            bVar3.i(language2);
                            bVar3.m(MediaTrack.ROLE_SUBTITLE);
                            arrayList.add(bVar3);
                        } else {
                            d8.b bVar4 = new d8.b(0, null, null, null, null, null, null, null, null, null, Message.EXT_HEADER_VALUE_MAX_LEN, null);
                            IMediaFormat format4 = iTrackInfo.getFormat();
                            if (!(format4 instanceof IjkMediaFormat)) {
                                format4 = null;
                            }
                            IjkMediaFormat ijkMediaFormat4 = (IjkMediaFormat) format4;
                            if (ijkMediaFormat4 != null) {
                                String string8 = ijkMediaFormat4.getString(IjkMediaFormat.KEY_IJK_CODEC_NAME_UI);
                                t9.i.c(string8, "it.getString(IjkMediaFormat.KEY_IJK_CODEC_NAME_UI)");
                                bVar4.f(string8);
                            }
                            bVar4.h(i10);
                            String language3 = iTrackInfo.getLanguage();
                            t9.i.c(language3, "info.language");
                            bVar4.i(language3);
                            bVar4.m("unknown");
                            d8.c cVar = this.f16306y;
                            if (cVar != null && (f10 = cVar.f()) != null) {
                                f10.add(bVar4);
                            }
                        }
                    }
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0054, code lost:
    
        if (ba.s.f(r0, "Obox", true) == false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String k0(java.lang.String r12) {
        /*
            r11 = this;
            l8.f r0 = r11.f16307z
            r1 = 1
            if (r0 == 0) goto Lb
            boolean r0 = r0.s()
            if (r0 == r1) goto Lc3
        Lb:
            if (r12 == 0) goto Lc3
            l8.f r0 = r11.f16307z
            if (r0 == 0) goto L19
            boolean r0 = r0.r()
            if (r0 != r1) goto L19
            goto Lc3
        L19:
            tv.danmaku.ijk.media.player.IMediaPlayer r0 = r11.f16295n
            r2 = 0
            if (r0 == 0) goto L68
            boolean r0 = r0 instanceof tv.danmaku.ijk.media.player.AndroidMediaPlayer
            if (r0 == 0) goto L68
            l8.h$b r0 = l8.h.f16357m
            l8.h r0 = r0.a()
            com.titan.ranger.bean.Env r0 = r0.m()
            if (r0 == 0) goto L33
            java.lang.String r0 = r0.getDev_id()
            goto L34
        L33:
            r0 = r2
        L34:
            boolean r0 = m8.d.b(r0)
            if (r0 == 0) goto L68
            int r0 = android.os.Build.VERSION.SDK_INT
            r3 = 21
            if (r3 > r0) goto L44
            r3 = 23
            if (r3 >= r0) goto L56
        L44:
            java.lang.String r0 = android.os.Build.MODEL
            java.lang.String r3 = "Ebox"
            boolean r3 = ba.s.f(r0, r3, r1)
            if (r3 != 0) goto L56
            java.lang.String r3 = "Obox"
            boolean r0 = ba.s.f(r0, r3, r1)
            if (r0 == 0) goto L68
        L56:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r1 = 115(0x73, float:1.61E-43)
            r0.append(r1)
            r0.append(r12)
            java.lang.String r12 = r0.toString()
            return r12
        L68:
            java.lang.String r0 = "s"
            r3 = 2
            r4 = 0
            boolean r0 = ba.s.l(r12, r0, r4, r3, r2)
            if (r0 == 0) goto L7b
            java.lang.String r12 = r12.substring(r1)
            java.lang.String r0 = "(this as java.lang.String).substring(startIndex)"
            t9.i.c(r12, r0)
        L7b:
            tv.danmaku.ijk.media.player.IMediaPlayer r0 = r11.f16295n
            boolean r2 = r0 instanceof tv.danmaku.ijk.media.player.AndroidMediaPlayer
            if (r2 != 0) goto Lc3
            boolean r0 = r0 instanceof tv.danmaku.ijk.media.player.ExoMediaPlayer
            if (r0 == 0) goto L86
            goto Lc3
        L86:
            java.lang.String r6 = "?"
            r7 = 0
            r8 = 0
            r9 = 6
            r10 = 0
            r5 = r12
            int r0 = ba.t.y(r5, r6, r7, r8, r9, r10)
            r2 = -1
            if (r0 == r2) goto La8
            if (r12 == 0) goto La0
            java.lang.String r0 = r12.substring(r4, r0)
            java.lang.String r2 = "(this as java.lang.Strin…ing(startIndex, endIndex)"
            t9.i.c(r0, r2)
            goto La9
        La0:
            h9.q r12 = new h9.q
            java.lang.String r0 = "null cannot be cast to non-null type java.lang.String"
            r12.<init>(r0)
            throw r12
        La8:
            r0 = r12
        La9:
            java.lang.String r2 = ".m3u8"
            boolean r0 = ba.s.d(r0, r2, r1)
            if (r0 == 0) goto Lb2
            return r12
        Lb2:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "ijkhttphook:"
            r0.append(r1)
            r0.append(r12)
            java.lang.String r12 = r0.toString()
        Lc3:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: l8.e.k0(java.lang.String):java.lang.String");
    }

    public final void l0() {
        l8.f fVar = this.f16307z;
        if (m8.d.a(fVar != null ? fVar.f() : null) || this.f16299r == null) {
            return;
        }
        T();
        y0();
        this.J.post(new c());
    }

    public final boolean m0() {
        if (Build.VERSION.SDK_INT == 28) {
            Env m10 = l8.h.f16357m.a().m();
            if (m8.d.b(m10 != null ? m10.getDev_id() : null)) {
                return true;
            }
        }
        return false;
    }

    public final boolean n0() {
        int i10;
        return (this.f16295n == null || (i10 = this.f16290i) == -1 || i10 == 0 || i10 == 1) ? false : true;
    }

    public final boolean o0() {
        String f10;
        IMediaPlayer iMediaPlayer;
        l8.f fVar = this.f16307z;
        if (fVar == null || (f10 = fVar.f()) == null) {
            return false;
        }
        return !(f10.length() == 0) && n0() && (iMediaPlayer = this.f16295n) != null && iMediaPlayer.isPlaying();
    }

    public final void p0(String str) {
        l8.f fVar = this.f16307z;
        NativeJni.c().i(this.f16296o, str, (fVar == null || !fVar.r()) ? "media" : "ad");
    }

    public final void q0() {
        long j10;
        long V = V();
        IMediaPlayer iMediaPlayer = this.f16295n;
        if (!(iMediaPlayer instanceof IjkMediaPlayer)) {
            j10 = this.F - V;
        } else {
            if (iMediaPlayer == null) {
                throw new h9.q("null cannot be cast to non-null type tv.danmaku.ijk.media.player.IjkMediaPlayer");
            }
            j10 = ((IjkMediaPlayer) iMediaPlayer).getAudioCachedDuration();
        }
        NativeJni.c().j(this.f16296o, V, j10);
    }

    public final void r0() {
        String str;
        try {
            if (this.f16295n == null) {
                if (this.f16299r != null) {
                    l0();
                    return;
                }
                return;
            }
            l8.f fVar = this.f16307z;
            String k02 = k0(fVar != null ? fVar.f() : null);
            Uri parse = Uri.parse(k02);
            t9.i.c(parse, "mUri");
            String scheme = parse.getScheme();
            if (scheme == null) {
                scheme = "";
            }
            int i10 = Build.VERSION.SDK_INT;
            if (i10 < 23 || !((m8.d.a(scheme) || s.f(scheme, "file", true) || s.f(scheme, "efile", true)) && (this.f16295n instanceof IjkMediaPlayer))) {
                IMediaPlayer iMediaPlayer = this.f16295n;
                if (iMediaPlayer == null) {
                    t9.i.q();
                }
                iMediaPlayer.setDataSource(k02);
            } else {
                l8.f fVar2 = this.f16307z;
                if ((fVar2 != null ? fVar2.c() : null) != null) {
                    IMediaPlayer iMediaPlayer2 = this.f16295n;
                    if (iMediaPlayer2 != null) {
                        l8.f fVar3 = this.f16307z;
                        iMediaPlayer2.setDataSource(fVar3 != null ? fVar3.c() : null);
                    }
                } else {
                    FileMediaDataSource fileMediaDataSource = new FileMediaDataSource(new File(parse.toString()));
                    IMediaPlayer iMediaPlayer3 = this.f16295n;
                    if (iMediaPlayer3 == null) {
                        t9.i.q();
                    }
                    iMediaPlayer3.setDataSource(fileMediaDataSource);
                }
            }
            NativeJni c10 = NativeJni.c();
            int i11 = this.f16296o;
            l8.f fVar4 = this.f16307z;
            if (fVar4 == null || (str = fVar4.f()) == null) {
                str = "";
            }
            c10.l(i11, "setDataSource", str, 0);
            if (i10 == 19 && (this.f16295n instanceof AndroidMediaPlayer)) {
                v0();
            }
            IMediaPlayer iMediaPlayer4 = this.f16295n;
            if (iMediaPlayer4 != null) {
                iMediaPlayer4.setLooping(false);
            }
            IMediaPlayer iMediaPlayer5 = this.f16295n;
            if (iMediaPlayer5 != null) {
                iMediaPlayer5.prepareAsync();
            }
            F0(1);
            NativeJni.c().l(this.f16296o, "prepare(Async)", "", 0);
        } catch (AssertionError unused) {
            F0(-1);
            NativeJni.c().k(this.f16296o, "onError", 0, 1202, 0L, "");
        } catch (Exception unused2) {
            F0(-1);
        }
    }

    public final int s0(String str) {
        int i10;
        t9.i.h(str, "name");
        this.f16283b = true;
        O0(4);
        if (n0()) {
            l8.f fVar = this.f16307z;
            if (fVar != null && !fVar.p()) {
                NativeJni.c().n(this.f16296o, str);
            }
            try {
                IMediaPlayer iMediaPlayer = this.f16295n;
                if (iMediaPlayer != null) {
                    iMediaPlayer.pause();
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            i10 = 0;
            NativeJni.c().l(this.f16296o, "pause", "", 0);
            F0(4);
        } else {
            i10 = -1;
        }
        this.f16286e = true;
        return i10;
    }

    public final int t0(String str, Program program, String str2) {
        t9.i.h(str, "name");
        t9.i.h(program, "program");
        t9.i.h(str2, "extra");
        this.D.lock();
        try {
            l8.f fVar = new l8.f();
            this.f16307z = fVar;
            fVar.z(str);
            this.D.unlock();
            this.f16306y = new d8.c(0L, null, null, null, null, null, null, 0L, null, null, null, null, null, null, 16383, null);
            NativeJni.c().o(this.f16296o, str, m8.a.a().toJson(program), str2);
            return 0;
        } catch (Throwable th) {
            this.D.unlock();
            throw th;
        }
    }

    public final void u0(String str, Program program, String str2) {
        t9.i.h(str, "name");
        t9.i.h(program, "program");
        t9.i.h(str2, "extra");
        X0(str, program);
        this.f16306y = new d8.c(0L, null, null, null, null, null, null, 0L, null, null, null, null, null, null, 16383, null);
        this.f16283b = false;
        NativeJni.c().p(this.f16296o, str, m8.a.a().toJson(program), str2);
    }

    public final void v0() {
        try {
            IMediaPlayer iMediaPlayer = this.f16295n;
            if (iMediaPlayer != null) {
                Field declaredField = iMediaPlayer != null ? iMediaPlayer.getClass().getDeclaredField("subTitleService") : null;
                if (declaredField != null) {
                    declaredField.setAccessible(true);
                }
                if (declaredField != null) {
                    declaredField.set(this.f16295n, null);
                }
            }
        } catch (Exception unused) {
        }
    }

    public final void w0(Status status) {
        t9.i.h(status, Constant.KEY_STATUS);
        if (this.f16306y == null) {
            this.f16306y = new d8.c(0L, null, null, null, null, null, null, 0L, null, null, null, null, null, null, 16383, null);
        }
        d8.c cVar = this.f16306y;
        if (cVar != null) {
            String program = status.getProgram();
            t9.i.c(program, "status.program");
            cVar.q(program);
        }
        d8.c cVar2 = this.f16306y;
        if (cVar2 != null) {
            String title = status.getTitle();
            t9.i.c(title, "status.title");
            cVar2.s(title);
        }
        d8.c cVar3 = this.f16306y;
        if (cVar3 != null) {
            String buss = status.getBuss();
            t9.i.c(buss, "status.buss");
            cVar3.i(buss);
        }
        d8.c cVar4 = this.f16306y;
        if (cVar4 != null) {
            String media = status.getMedia();
            t9.i.c(media, "status.media");
            cVar4.n(media);
        }
        d8.c cVar5 = this.f16306y;
        if (cVar5 != null) {
            String play_url = status.getPlay_url();
            t9.i.c(play_url, "status.play_url");
            cVar5.o(play_url);
        }
        d8.c cVar6 = this.f16306y;
        if (cVar6 != null) {
            cVar6.m(status.getLinks());
        }
        d8.c cVar7 = this.f16306y;
        if (cVar7 != null) {
            cVar7.l(status.getLatency());
        }
        l8.f fVar = this.f16307z;
        if (fVar != null) {
            String snapinfo_url = status.getSnapinfo_url();
            t9.i.c(snapinfo_url, "status.snapinfo_url");
            fVar.J(snapinfo_url);
        }
        l8.f fVar2 = this.f16307z;
        if (fVar2 != null) {
            String play_url2 = status.getPlay_url();
            t9.i.c(play_url2, "status.play_url");
            fVar2.C(play_url2);
        }
        l8.f fVar3 = this.f16307z;
        if (fVar3 != null) {
            String format = status.getFormat();
            t9.i.c(format, "status.format");
            fVar3.x(format);
        }
        l8.f fVar4 = this.f16307z;
        if (fVar4 != null) {
            fVar4.u(status.getMedia_buffer());
        }
        String play_url3 = status.getPlay_url();
        t9.i.c(play_url3, "status.play_url");
        if (s.k(play_url3, "mem://", true)) {
            l8.f fVar5 = this.f16307z;
            if (fVar5 != null) {
                fVar5.y(1);
                return;
            }
            return;
        }
        l8.f fVar6 = this.f16307z;
        if (fVar6 != null) {
            fVar6.y(0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void x0() {
        /*
            r5 = this;
            l8.e$e r0 = r5.J
            r1 = 0
            r0.removeCallbacksAndMessages(r1)
            r0 = 0
            r5.F0(r0)
            r5.O0(r0)
            r5.y0()
            r5.S()
            tv.danmaku.ijk.media.player.IMediaPlayer r2 = r5.f16295n
            if (r2 == 0) goto L5a
            boolean r2 = r5.m0()
            if (r2 == 0) goto L29
            tv.danmaku.ijk.media.player.IMediaPlayer r2 = r5.f16295n
            boolean r3 = r2 instanceof tv.danmaku.ijk.media.player.AndroidMediaPlayer
            if (r3 == 0) goto L29
            if (r2 == 0) goto L30
            r2.reset()
            goto L30
        L29:
            tv.danmaku.ijk.media.player.IMediaPlayer r2 = r5.f16295n
            if (r2 == 0) goto L30
            r2.stop()
        L30:
            com.titan.ranger.NativeJni r2 = com.titan.ranger.NativeJni.c()
            int r3 = r5.f16296o
            java.lang.String r4 = "stop"
            r2.l(r3, r4, r4, r0)
            tv.danmaku.ijk.media.player.IMediaPlayer r2 = r5.f16295n
            if (r2 == 0) goto L42
            r2.release()
        L42:
            com.titan.ranger.NativeJni r2 = com.titan.ranger.NativeJni.c()
            int r3 = r5.f16296o
            java.lang.String r4 = "release"
            r2.l(r3, r4, r4, r0)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "mediaPlayer has release;"
            r2.append(r3)
            r2.append(r5)
        L5a:
            r5.f16300s = r0
            r5.f16295n = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: l8.e.x0():void");
    }

    public final void y0() {
        this.f16284c = false;
        this.f16286e = false;
        this.f16287f = false;
        this.f16292k = "";
        this.f16303v = false;
        this.f16304w = false;
        this.f16305x = -1;
        this.G = "";
        this.f16285d = false;
        this.f16302u = i8.b.NONE;
        l8.f fVar = this.f16307z;
        if (fVar != null) {
            fVar.v(false);
        }
        l8.f fVar2 = this.f16307z;
        if (fVar2 != null) {
            fVar2.A(-1L);
        }
        l8.f fVar3 = this.f16307z;
        if (fVar3 != null) {
            fVar3.w(false);
        }
        l8.f fVar4 = this.f16307z;
        if (fVar4 != null) {
            fVar4.K(false);
        }
    }

    public final void z0() {
        this.J.removeCallbacksAndMessages(null);
        y0();
        F0(0);
    }
}
