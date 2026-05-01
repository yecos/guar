package o8;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.hpplay.sdk.source.common.global.Constant;
import com.titan.ranger.Status;
import com.titan.ranger.bean.report.PlayError;
import com.titan.ranger.bean.report.PlayFile;
import com.titan.ranger.bean.report.PlayMedia;
import com.titan.ranger.bean.report.PlayProgram;
import com.titan.ranger.bean.report.SwitchPlayer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import o8.k;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public static final k f17660a = new k();

    /* renamed from: b, reason: collision with root package name */
    public static final String f17661b = "TitanCallback";

    /* renamed from: c, reason: collision with root package name */
    public static final List f17662c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public static final List f17663d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public static Handler f17664e = new Handler(Looper.getMainLooper());

    /* renamed from: f, reason: collision with root package name */
    public static j8.a f17665f = new a();

    /* renamed from: g, reason: collision with root package name */
    public static j8.b f17666g = new b();

    /* loaded from: classes3.dex */
    public static final class a implements j8.a {
        public static final void A(int i10, String str) {
            t9.i.g(str, "$name");
            Iterator it = k.f17662c.iterator();
            while (it.hasNext()) {
                ((j8.a) it.next()).k(i10, str);
            }
        }

        public static final void B(int i10, String str, String str2, int i11, String str3) {
            t9.i.g(str, "$obj");
            t9.i.g(str2, "$action");
            t9.i.g(str3, "$name");
            Iterator it = k.f17662c.iterator();
            while (it.hasNext()) {
                ((j8.a) it.next()).c(i10, str, str2, i11, str3);
            }
        }

        public static final void t(boolean z10, Bitmap bitmap, String str) {
            t9.i.g(str, "$name");
            Iterator it = k.f17662c.iterator();
            while (it.hasNext()) {
                ((j8.a) it.next()).e(z10, bitmap, str);
            }
        }

        public static final void u(int i10, long j10, String str) {
            t9.i.g(str, "$name");
            Iterator it = k.f17662c.iterator();
            while (it.hasNext()) {
                ((j8.a) it.next()).d(i10, j10, str);
            }
        }

        public static final void v(int i10, String str, String str2) {
            t9.i.g(str, "$type");
            t9.i.g(str2, "$name");
            Iterator it = k.f17662c.iterator();
            while (it.hasNext()) {
                ((j8.a) it.next()).a(i10, str, str2);
            }
        }

        public static final void w(boolean z10, String str) {
            t9.i.g(str, "$name");
            Iterator it = k.f17662c.iterator();
            while (it.hasNext()) {
                ((j8.a) it.next()).g(z10, str);
            }
        }

        public static final void x(int i10, int i11, String str, String str2) {
            t9.i.g(str, "$player");
            t9.i.g(str2, "$name");
            Iterator it = k.f17662c.iterator();
            while (it.hasNext()) {
                ((j8.a) it.next()).l(i10, i11, str, str2);
            }
        }

        public static final void y(int i10, int i11, int i12, String str, String str2) {
            t9.i.g(str, "$type");
            t9.i.g(str2, "$name");
            Iterator it = k.f17662c.iterator();
            while (it.hasNext()) {
                ((j8.a) it.next()).h(i10, i11, i12, str, str2);
            }
        }

        public static final void z(int i10, long j10, String str) {
            t9.i.g(str, "$name");
            Iterator it = k.f17662c.iterator();
            while (it.hasNext()) {
                ((j8.a) it.next()).b(i10, j10, str);
            }
        }

        @Override // j8.a
        public void a(final int i10, final String str, final String str2) {
            t9.i.g(str, "type");
            t9.i.g(str2, "name");
            String unused = k.f17661b;
            StringBuilder sb = new StringBuilder();
            sb.append("onCompletion ----> 当前callBack集合size为");
            sb.append(k.f17662c.size());
            k.f17664e.post(new Runnable() { // from class: o8.g
                @Override // java.lang.Runnable
                public final void run() {
                    k.a.v(i10, str, str2);
                }
            });
        }

        @Override // j8.a
        public void b(final int i10, final long j10, final String str) {
            t9.i.g(str, "name");
            String unused = k.f17661b;
            StringBuilder sb = new StringBuilder();
            sb.append("onProgress ----> 当前callBack集合size为");
            sb.append(k.f17662c.size());
            k.f17664e.post(new Runnable() { // from class: o8.f
                @Override // java.lang.Runnable
                public final void run() {
                    k.a.z(i10, j10, str);
                }
            });
        }

        @Override // j8.a
        public void c(final int i10, final String str, final String str2, final int i11, final String str3) {
            t9.i.g(str, "obj");
            t9.i.g(str2, "action");
            t9.i.g(str3, "name");
            String unused = k.f17661b;
            StringBuilder sb = new StringBuilder();
            sb.append("setPlayerUI ----> 当前callBack集合size为");
            sb.append(k.f17662c.size());
            k.f17664e.post(new Runnable() { // from class: o8.h
                @Override // java.lang.Runnable
                public final void run() {
                    k.a.B(i10, str, str2, i11, str3);
                }
            });
        }

        @Override // j8.a
        public void d(final int i10, final long j10, final String str) {
            t9.i.g(str, "name");
            String unused = k.f17661b;
            StringBuilder sb = new StringBuilder();
            sb.append("onBuffering ----> 当前callBack集合size为");
            sb.append(k.f17662c.size());
            k.f17664e.post(new Runnable() { // from class: o8.b
                @Override // java.lang.Runnable
                public final void run() {
                    k.a.u(i10, j10, str);
                }
            });
        }

        @Override // j8.a
        public void e(final boolean z10, final Bitmap bitmap, final String str) {
            t9.i.g(str, "name");
            String unused = k.f17661b;
            StringBuilder sb = new StringBuilder();
            sb.append("onBitmapPrepared ----> 当前callBack集合size为");
            sb.append(k.f17662c.size());
            k.f17664e.post(new Runnable() { // from class: o8.j
                @Override // java.lang.Runnable
                public final void run() {
                    k.a.t(z10, bitmap, str);
                }
            });
        }

        @Override // j8.a
        public d8.d f(d8.c cVar, String str) {
            t9.i.g(cVar, "playStatus");
            t9.i.g(str, "name");
            String unused = k.f17661b;
            StringBuilder sb = new StringBuilder();
            sb.append("onMediaInfo ----> 当前callBack集合size为");
            sb.append(k.f17662c.size());
            Iterator it = k.f17662c.iterator();
            d8.d dVar = null;
            while (it.hasNext()) {
                d8.d f10 = ((j8.a) it.next()).f(cVar, str);
                if (f10 != null) {
                    dVar = f10;
                }
            }
            return dVar;
        }

        @Override // j8.a
        public void g(final boolean z10, final String str) {
            t9.i.g(str, "name");
            String unused = k.f17661b;
            StringBuilder sb = new StringBuilder();
            sb.append("onGetThumbnail ----> 当前callBack集合size为");
            sb.append(k.f17662c.size());
            k.f17664e.post(new Runnable() { // from class: o8.i
                @Override // java.lang.Runnable
                public final void run() {
                    k.a.w(z10, str);
                }
            });
        }

        @Override // j8.a
        public void h(final int i10, final int i11, final int i12, final String str, final String str2) {
            t9.i.g(str, "type");
            t9.i.g(str2, "name");
            String unused = k.f17661b;
            StringBuilder sb = new StringBuilder();
            sb.append("onPrepared ----> 当前callBack集合size为");
            sb.append(k.f17662c.size());
            k.f17664e.post(new Runnable() { // from class: o8.c
                @Override // java.lang.Runnable
                public final void run() {
                    k.a.y(i10, i11, i12, str, str2);
                }
            });
        }

        @Override // j8.a
        public void k(final int i10, final String str) {
            t9.i.g(str, "name");
            String unused = k.f17661b;
            StringBuilder sb = new StringBuilder();
            sb.append("onSeekComplete ----> 当前callBack集合size为");
            sb.append(k.f17662c.size());
            k.f17664e.post(new Runnable() { // from class: o8.d
                @Override // java.lang.Runnable
                public final void run() {
                    k.a.A(i10, str);
                }
            });
        }

        @Override // j8.a
        public void l(final int i10, final int i11, final String str, final String str2) {
            t9.i.g(str, "player");
            t9.i.g(str2, "name");
            String unused = k.f17661b;
            StringBuilder sb = new StringBuilder();
            sb.append("onPlayerError ----> 当前callBack集合size为");
            sb.append(k.f17662c.size());
            k.f17664e.post(new Runnable() { // from class: o8.e
                @Override // java.lang.Runnable
                public final void run() {
                    k.a.x(i10, i11, str, str2);
                }
            });
        }
    }

    /* loaded from: classes3.dex */
    public static final class b implements j8.b {
        @Override // j8.b
        public void i(int i10, String str, Status status, long j10) {
            t9.i.g(str, "event");
            t9.i.g(status, Constant.KEY_STATUS);
            String unused = k.f17661b;
            StringBuilder sb = new StringBuilder();
            sb.append("onPrepareEvent ----> 当前callBack集合size为");
            sb.append(k.f17663d.size());
            Iterator it = k.f17663d.iterator();
            while (it.hasNext()) {
                ((j8.b) it.next()).i(i10, str, status, j10);
            }
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @Override // j8.b
        public void j(int i10, String str, Object obj, String str2) {
            t9.i.g(str, "event");
            t9.i.g(obj, "data");
            t9.i.g(str2, "app_ctx");
            String unused = k.f17661b;
            StringBuilder sb = new StringBuilder();
            sb.append("onReport ----> 当前callBack集合size为");
            sb.append(k.f17663d.size());
            long elapsedRealtime = SystemClock.elapsedRealtime();
            switch (str.hashCode()) {
                case -1877933145:
                    if (str.equals("play_file")) {
                        if (obj instanceof PlayFile) {
                            long duration = elapsedRealtime - ((PlayFile) obj).getDuration();
                            long j10 = duration > 0 ? duration : elapsedRealtime;
                            com.bigbee.bean.request.PlayFile playFile = (com.bigbee.bean.request.PlayFile) m8.a.a().fromJson(m8.a.a().toJson(obj), com.bigbee.bean.request.PlayFile.class);
                            c2.f fVar = c2.f.f5347a;
                            t9.i.f(playFile, "playFile");
                            fVar.b(playFile, j10, elapsedRealtime);
                            break;
                        } else {
                            return;
                        }
                    }
                    break;
                case 1283382393:
                    if (str.equals("play_program")) {
                        if (obj instanceof PlayProgram) {
                            long duration2 = elapsedRealtime - ((PlayProgram) obj).getDuration();
                            long j11 = duration2 > 0 ? duration2 : elapsedRealtime;
                            com.bigbee.bean.request.PlayProgram playProgram = (com.bigbee.bean.request.PlayProgram) m8.a.a().fromJson(m8.a.a().toJson(obj), com.bigbee.bean.request.PlayProgram.class);
                            c2.f fVar2 = c2.f.f5347a;
                            t9.i.f(playProgram, "playProgram");
                            fVar2.d(playProgram, j11, elapsedRealtime);
                            break;
                        } else {
                            return;
                        }
                    }
                    break;
                case 1814306380:
                    if (str.equals("switch_player")) {
                        if (obj instanceof SwitchPlayer) {
                            com.bigbee.bean.request.SwitchPlayer switchPlayer = (com.bigbee.bean.request.SwitchPlayer) m8.a.a().fromJson(m8.a.a().toJson(obj), com.bigbee.bean.request.SwitchPlayer.class);
                            c2.f fVar3 = c2.f.f5347a;
                            t9.i.f(switchPlayer, "switchPlayer");
                            fVar3.e(switchPlayer, elapsedRealtime, elapsedRealtime);
                            break;
                        } else {
                            return;
                        }
                    }
                    break;
                case 1912965437:
                    if (str.equals("play_error")) {
                        if (obj instanceof PlayError) {
                            com.bigbee.bean.request.PlayError playError = (com.bigbee.bean.request.PlayError) m8.a.a().fromJson(m8.a.a().toJson(obj), com.bigbee.bean.request.PlayError.class);
                            c2.f fVar4 = c2.f.f5347a;
                            t9.i.f(playError, "playError");
                            fVar4.a(playError, elapsedRealtime, elapsedRealtime);
                            break;
                        } else {
                            return;
                        }
                    }
                    break;
                case 1919952665:
                    if (str.equals("play_media")) {
                        if (obj instanceof PlayMedia) {
                            long duration3 = elapsedRealtime - ((PlayMedia) obj).getDuration();
                            long j12 = duration3 > 0 ? duration3 : elapsedRealtime;
                            com.bigbee.bean.request.PlayMedia playMedia = (com.bigbee.bean.request.PlayMedia) m8.a.a().fromJson(m8.a.a().toJson(obj), com.bigbee.bean.request.PlayMedia.class);
                            c2.f fVar5 = c2.f.f5347a;
                            t9.i.f(playMedia, "playMedia");
                            fVar5.c(playMedia, j12, elapsedRealtime);
                            break;
                        } else {
                            return;
                        }
                    }
                    break;
            }
            Iterator it = k.f17663d.iterator();
            while (it.hasNext()) {
                ((j8.b) it.next()).j(i10, str, obj, str2);
            }
        }

        @Override // j8.b
        public void m(String str, String str2, long j10) {
            t9.i.g(str, "adName");
            t9.i.g(str2, "path");
            String unused = k.f17661b;
            StringBuilder sb = new StringBuilder();
            sb.append("onPrefetchAd ----> 当前callBack集合size为");
            sb.append(k.f17663d.size());
            Iterator it = k.f17663d.iterator();
            while (it.hasNext()) {
                ((j8.b) it.next()).m(str, str2, j10);
            }
        }
    }

    public final void e(j8.a aVar, j8.b bVar) {
        t9.i.g(aVar, "playerCallback");
        t9.i.g(bVar, "rangerCallback");
        List list = f17662c;
        if (!list.contains(aVar)) {
            list.add(aVar);
        }
        List list2 = f17663d;
        if (list2.contains(bVar)) {
            return;
        }
        list2.add(bVar);
    }

    public final j8.a f() {
        return f17665f;
    }

    public final j8.b g() {
        return f17666g;
    }

    public final void h(j8.a aVar, j8.b bVar) {
        t9.i.g(aVar, "playerCallback");
        t9.i.g(bVar, "rangerCallback");
        List list = f17662c;
        if (list.contains(aVar)) {
            list.remove(aVar);
        }
        List list2 = f17663d;
        if (list2.contains(bVar)) {
            list2.remove(bVar);
        }
    }
}
