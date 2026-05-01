package z5;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaLoadRequestData;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.CastStateListener;
import com.google.android.gms.cast.framework.SessionManager;
import com.google.android.gms.cast.framework.SessionManagerListener;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.common.GoogleApiAvailability;
import com.mobile.brasiltv.app.App;
import com.mobile.brasiltv.utils.i1;
import t9.i;
import t9.w;
import z5.c;

/* loaded from: classes3.dex */
public final class c {

    /* renamed from: e, reason: collision with root package name */
    public static final a f20224e = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public CastStateListener f20225a;

    /* renamed from: b, reason: collision with root package name */
    public SessionManagerListener f20226b;

    /* renamed from: c, reason: collision with root package name */
    public RemoteMediaClient.ProgressListener f20227c;

    /* renamed from: d, reason: collision with root package name */
    public RemoteMediaClient.Callback f20228d;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(t9.g gVar) {
            this();
        }

        public final boolean a(Context context) {
            i.g(context, com.umeng.analytics.pro.f.X);
            boolean z10 = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context) == 0;
            try {
                CastContext.getSharedInstance(context);
                return z10;
            } catch (Exception unused) {
                return false;
            }
        }
    }

    public interface b {
        void P0();

        void g1();

        void l0();

        void r1();
    }

    /* renamed from: z5.c$c, reason: collision with other inner class name */
    public interface InterfaceC0353c {
        void D0(CastSession castSession, String str);

        void K0(CastSession castSession, int i10);

        void V0(CastSession castSession);

        void Z(CastSession castSession, boolean z10);

        void b1(CastSession castSession, int i10);

        void w1(CastSession castSession, int i10);
    }

    public interface d {
        void L0();

        void L1(int i10);

        void U();

        void b0();

        void c2();

        void e0();
    }

    public interface e {
        void N1(long j10, long j11);
    }

    public static final class f implements SessionManagerListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC0353c f20229a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f20230b;

        public f(InterfaceC0353c interfaceC0353c, Context context) {
            this.f20229a = interfaceC0353c;
            this.f20230b = context;
        }

        @Override // com.google.android.gms.cast.framework.SessionManagerListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSessionEnded(CastSession castSession, int i10) {
            StringBuilder sb = new StringBuilder();
            sb.append("Google onSessionEnded ");
            sb.append(castSession != null ? castSession.getCastDevice() : null);
            sb.append(", error: ");
            sb.append(i10);
            k7.f.c(sb.toString(), new Object[0]);
            InterfaceC0353c interfaceC0353c = this.f20229a;
            if (interfaceC0353c != null) {
                interfaceC0353c.w1(castSession, i10);
            }
        }

        @Override // com.google.android.gms.cast.framework.SessionManagerListener
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSessionEnding(CastSession castSession) {
            StringBuilder sb = new StringBuilder();
            sb.append("Google onSessionEnding ");
            sb.append(castSession != null ? castSession.getCastDevice() : null);
            k7.f.c(sb.toString(), new Object[0]);
        }

        @Override // com.google.android.gms.cast.framework.SessionManagerListener
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onSessionResumeFailed(CastSession castSession, int i10) {
            StringBuilder sb = new StringBuilder();
            sb.append("Google onSessionResumeFailed ");
            sb.append(castSession != null ? castSession.getCastDevice() : null);
            sb.append(", error: ");
            sb.append(i10);
            k7.f.c(sb.toString(), new Object[0]);
            InterfaceC0353c interfaceC0353c = this.f20229a;
            if (interfaceC0353c != null) {
                interfaceC0353c.K0(castSession, i10);
            }
        }

        @Override // com.google.android.gms.cast.framework.SessionManagerListener
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onSessionResumed(CastSession castSession, boolean z10) {
            StringBuilder sb = new StringBuilder();
            sb.append("Google onSessionResumed ");
            sb.append(castSession != null ? castSession.getCastDevice() : null);
            sb.append(", wasSuspended: ");
            sb.append(z10);
            k7.f.c(sb.toString(), new Object[0]);
            InterfaceC0353c interfaceC0353c = this.f20229a;
            if (interfaceC0353c != null) {
                interfaceC0353c.Z(castSession, z10);
            }
        }

        @Override // com.google.android.gms.cast.framework.SessionManagerListener
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void onSessionResuming(CastSession castSession, String str) {
            StringBuilder sb = new StringBuilder();
            sb.append("Google onSessionResuming ");
            sb.append(castSession != null ? castSession.getCastDevice() : null);
            sb.append(", sessionId: ");
            sb.append(str);
            k7.f.c(sb.toString(), new Object[0]);
        }

        @Override // com.google.android.gms.cast.framework.SessionManagerListener
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onSessionStartFailed(CastSession castSession, int i10) {
            CastDevice castDevice;
            StringBuilder sb = new StringBuilder();
            sb.append("Google onSessionStartFailed ");
            String str = null;
            sb.append(castSession != null ? castSession.getCastDevice() : null);
            sb.append(", error: ");
            sb.append(i10);
            k7.f.c(sb.toString(), new Object[0]);
            InterfaceC0353c interfaceC0353c = this.f20229a;
            if (interfaceC0353c != null) {
                interfaceC0353c.b1(castSession, i10);
            }
            App a10 = App.f8263e.a();
            String H = w6.i.f19214g.H();
            if (castSession != null && (castDevice = castSession.getCastDevice()) != null) {
                str = castDevice.getFriendlyName();
            }
            if (str == null) {
                str = "unknown";
            }
            i1.i(a10, H, "CHROME_CAST", str, false);
        }

        @Override // com.google.android.gms.cast.framework.SessionManagerListener
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public void onSessionStarted(CastSession castSession, String str) {
            CastDevice castDevice;
            StringBuilder sb = new StringBuilder();
            sb.append("Google onSessionStarted ");
            String str2 = null;
            sb.append(castSession != null ? castSession.getCastDevice() : null);
            sb.append(", sessionId: ");
            sb.append(str);
            k7.f.c(sb.toString(), new Object[0]);
            InterfaceC0353c interfaceC0353c = this.f20229a;
            if (interfaceC0353c != null) {
                interfaceC0353c.D0(castSession, str);
            }
            App a10 = App.f8263e.a();
            String H = w6.i.f19214g.H();
            if (castSession != null && (castDevice = castSession.getCastDevice()) != null) {
                str2 = castDevice.getFriendlyName();
            }
            if (str2 == null) {
                str2 = "unknown";
            }
            i1.i(a10, H, "CHROME_CAST", str2, true);
        }

        @Override // com.google.android.gms.cast.framework.SessionManagerListener
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void onSessionStarting(CastSession castSession) {
            CastDevice castDevice;
            StringBuilder sb = new StringBuilder();
            sb.append("Google onSessionStarting ");
            String str = null;
            sb.append(castSession != null ? castSession.getCastDevice() : null);
            k7.f.c(sb.toString(), new Object[0]);
            InterfaceC0353c interfaceC0353c = this.f20229a;
            if (interfaceC0353c != null) {
                interfaceC0353c.V0(castSession);
            }
            na.f.k(this.f20230b, "last_cast_mode", "CHROME_CAST");
            App a10 = App.f8263e.a();
            String H = w6.i.f19214g.H();
            if (castSession != null && (castDevice = castSession.getCastDevice()) != null) {
                str = castDevice.getFriendlyName();
            }
            if (str == null) {
                str = "unknown";
            }
            i1.f(a10, H, "CHROME_CAST", str);
        }

        @Override // com.google.android.gms.cast.framework.SessionManagerListener
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void onSessionSuspended(CastSession castSession, int i10) {
            StringBuilder sb = new StringBuilder();
            sb.append("Google onSessionSuspended ");
            sb.append(castSession != null ? castSession.getCastDevice() : null);
            sb.append(", reason: ");
            sb.append(i10);
            k7.f.c(sb.toString(), new Object[0]);
        }
    }

    public static final class g extends RemoteMediaClient.Callback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w f20231a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f20232b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ c f20233c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f20234d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f20235e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f20236f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f20237g;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ String f20238h;

        /* renamed from: i, reason: collision with root package name */
        public final /* synthetic */ String f20239i;

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ String f20240j;

        public g(w wVar, d dVar, c cVar, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
            this.f20231a = wVar;
            this.f20232b = dVar;
            this.f20233c = cVar;
            this.f20234d = str;
            this.f20235e = str2;
            this.f20236f = str3;
            this.f20237g = str4;
            this.f20238h = str5;
            this.f20239i = str6;
            this.f20240j = str7;
        }

        @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.Callback
        public void onStatusUpdated() {
            CastDevice castDevice;
            d dVar;
            int playerState = ((RemoteMediaClient) this.f20231a.f18961a).getPlayerState();
            if (playerState == 0) {
                d dVar2 = this.f20232b;
                if (dVar2 != null) {
                    dVar2.b0();
                    return;
                }
                return;
            }
            if (playerState == 1) {
                d dVar3 = this.f20232b;
                if (dVar3 != null) {
                    dVar3.L1(((RemoteMediaClient) this.f20231a.f18961a).getIdleReason());
                }
                if (((RemoteMediaClient) this.f20231a.f18961a).getIdleReason() == 4) {
                    App a10 = App.f8263e.a();
                    String H = w6.i.f19214g.H();
                    CastSession i10 = this.f20233c.i();
                    String friendlyName = (i10 == null || (castDevice = i10.getCastDevice()) == null) ? null : castDevice.getFriendlyName();
                    if (friendlyName == null) {
                        friendlyName = "unknown";
                    }
                    i1.h(a10, H, "CHROME_CAST", friendlyName, this.f20234d, "4", this.f20235e, this.f20236f, this.f20237g, this.f20238h, this.f20239i, this.f20240j);
                    return;
                }
                return;
            }
            if (playerState == 2) {
                d dVar4 = this.f20232b;
                if (dVar4 != null) {
                    dVar4.c2();
                    return;
                }
                return;
            }
            if (playerState == 3) {
                d dVar5 = this.f20232b;
                if (dVar5 != null) {
                    dVar5.U();
                    return;
                }
                return;
            }
            if (playerState != 4) {
                if (playerState == 5 && (dVar = this.f20232b) != null) {
                    dVar.L0();
                    return;
                }
                return;
            }
            d dVar6 = this.f20232b;
            if (dVar6 != null) {
                dVar6.e0();
            }
        }
    }

    public static final void d(b bVar, int i10) {
        if (i10 == 1) {
            if (bVar != null) {
                bVar.r1();
            }
        } else if (i10 == 2) {
            if (bVar != null) {
                bVar.l0();
            }
        } else if (i10 == 3) {
            if (bVar != null) {
                bVar.P0();
            }
        } else if (i10 == 4 && bVar != null) {
            bVar.g1();
        }
    }

    public static final void f(e eVar, long j10, long j11) {
        if (eVar != null) {
            eVar.N1(j10, j11);
        }
    }

    public final void c(Context context, final b bVar) {
        i.g(context, com.umeng.analytics.pro.f.X);
        if (this.f20225a == null) {
            this.f20225a = new CastStateListener() { // from class: z5.b
                @Override // com.google.android.gms.cast.framework.CastStateListener
                public final void onCastStateChanged(int i10) {
                    c.d(c.b.this, i10);
                }
            };
        }
        CastContext.getSharedInstance(context).addCastStateListener(this.f20225a);
    }

    public final void e(final e eVar) {
        RemoteMediaClient h10 = h();
        if (h10 != null) {
            RemoteMediaClient.ProgressListener progressListener = new RemoteMediaClient.ProgressListener() { // from class: z5.a
                @Override // com.google.android.gms.cast.framework.media.RemoteMediaClient.ProgressListener
                public final void onProgressUpdated(long j10, long j11) {
                    c.f(c.e.this, j10, j11);
                }
            };
            this.f20227c = progressListener;
            h10.addProgressListener(progressListener, 2000L);
        }
    }

    public final void g(Context context, InterfaceC0353c interfaceC0353c) {
        i.g(context, com.umeng.analytics.pro.f.X);
        if (this.f20226b == null) {
            this.f20226b = new f(interfaceC0353c, context);
        }
        CastContext.getSharedInstance(context).getSessionManager().addSessionManagerListener(this.f20226b, CastSession.class);
    }

    public final RemoteMediaClient h() {
        SessionManager sessionManager;
        CastSession currentCastSession;
        CastContext sharedInstance = CastContext.getSharedInstance();
        if (sharedInstance == null || (sessionManager = sharedInstance.getSessionManager()) == null || (currentCastSession = sessionManager.getCurrentCastSession()) == null) {
            return null;
        }
        return currentCastSession.getRemoteMediaClient();
    }

    public final CastSession i() {
        SessionManager sessionManager;
        CastContext sharedInstance = CastContext.getSharedInstance();
        if (sharedInstance == null || (sessionManager = sharedInstance.getSessionManager()) == null) {
            return null;
        }
        return sessionManager.getCurrentCastSession();
    }

    public final void j(String str, int i10, long j10, MediaMetadata mediaMetadata) {
        i.g(str, "url");
        i.g(mediaMetadata, "mediaMetadata");
        RemoteMediaClient h10 = h();
        if (h10 == null) {
            return;
        }
        h10.load(new MediaLoadRequestData.Builder().setMediaInfo(new MediaInfo.Builder(str).setStreamType(1).setContentType("videos/mp4").setMetadata(mediaMetadata).setStreamDuration(j10).build()).setAutoplay(Boolean.TRUE).setCurrentTime(i10 * 1000).build());
    }

    public final void k() {
        RemoteMediaClient h10 = h();
        if (h10 != null) {
            if (h10.isPaused()) {
                h10.play();
            } else if (h10.isPlaying() || h10.isBuffering()) {
                h10.pause();
            }
        }
    }

    public final void l(d dVar, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        CastDevice castDevice;
        i.g(str, "resourceId");
        i.g(str2, "title");
        i.g(str3, "mCode");
        i.g(str4, "bussType");
        i.g(str5, "cdnType");
        if (TextUtils.isDigitsOnly(str5)) {
            u6.a aVar = u6.a.f19062a;
            String str8 = str6 == null ? "" : str6;
            CastSession i10 = i();
            String friendlyName = (i10 == null || (castDevice = i10.getCastDevice()) == null) ? null : castDevice.getFriendlyName();
            if (friendlyName == null) {
                friendlyName = "unknown";
            }
            aVar.b(str3, str8, str4, str5, str2, "CHROME_CAST", friendlyName, "app_cast_start");
        }
        w wVar = new w();
        RemoteMediaClient h10 = h();
        wVar.f18961a = h10;
        if (h10 != null) {
            g gVar = new g(wVar, dVar, this, str, str2, str3, str4, str5, str6, str7);
            this.f20228d = gVar;
            RemoteMediaClient remoteMediaClient = (RemoteMediaClient) wVar.f18961a;
            if (remoteMediaClient != null) {
                remoteMediaClient.registerCallback(gVar);
            }
        }
    }

    public final void n(Context context) {
        i.g(context, com.umeng.analytics.pro.f.X);
        CastContext.getSharedInstance(context).removeCastStateListener(this.f20225a);
    }

    public final void o() {
        RemoteMediaClient.ProgressListener progressListener;
        RemoteMediaClient h10 = h();
        if (h10 == null || (progressListener = this.f20227c) == null) {
            return;
        }
        h10.removeProgressListener(progressListener);
    }

    public final void p(Context context) {
        i.g(context, com.umeng.analytics.pro.f.X);
        CastContext.getSharedInstance(context).getSessionManager().removeSessionManagerListener(this.f20226b, CastSession.class);
    }

    public final void q(long j10) {
        RemoteMediaClient h10 = h();
        if (h10 != null) {
            h10.seek(j10);
        }
    }

    public final void r() {
        SessionManager sessionManager;
        RemoteMediaClient h10 = h();
        if (h10 != null) {
            h10.stop();
        }
        CastContext sharedInstance = CastContext.getSharedInstance();
        if (sharedInstance == null || (sessionManager = sharedInstance.getSessionManager()) == null) {
            return;
        }
        sessionManager.endCurrentSession(true);
    }

    public final void s() {
        RemoteMediaClient.Callback callback;
        RemoteMediaClient h10 = h();
        if (h10 == null || (callback = this.f20228d) == null) {
            return;
        }
        h10.unregisterCallback(callback);
        this.f20228d = null;
    }
}
