package com.umeng.message.proguard;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import com.google.android.gms.cast.CastStatusCodes;
import com.hpplay.sdk.source.api.IConferenceMirrorListener;
import com.umeng.message.proguard.Cdo;
import com.umeng.message.proguard.bx;
import com.umeng.message.proguard.cq;
import com.umeng.message.proguard.eh;
import com.umeng.message.push.R;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class dn extends dc {

    /* renamed from: com.umeng.message.proguard.dn$2, reason: invalid class name */
    public class AnonymousClass2 extends eh.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Cdo f11945a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ck f11946b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ da f11947c;

        public AnonymousClass2(Cdo cdo, ck ckVar, da daVar) {
            this.f11945a = cdo;
            this.f11946b = ckVar;
            this.f11947c = daVar;
        }

        @Override // com.umeng.message.proguard.eh.a
        public final void c() {
            eg egVar = this.f11945a.f11959a;
            if (egVar != null) {
                egVar.post(new Runnable() { // from class: com.umeng.message.proguard.dn.2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            cr.a().a(AnonymousClass2.this.f11946b, new cq.a() { // from class: com.umeng.message.proguard.dn.2.1.1
                                @Override // com.umeng.message.proguard.cq.a
                                public final void a() {
                                    cf cfVar = AnonymousClass2.this.f11947c.f11861a;
                                    if (cfVar != null) {
                                        cfVar.a();
                                    }
                                }

                                @Override // com.umeng.message.proguard.cq.a
                                public final void a(String str) {
                                    cf cfVar = AnonymousClass2.this.f11947c.f11861a;
                                    if (cfVar != null) {
                                        cfVar.a(2010, str);
                                    }
                                }
                            });
                            if (AnonymousClass2.this.f11946b.f11740b.optBoolean("expose_verify", false)) {
                                return;
                            }
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            eg egVar2 = anonymousClass2.f11945a.f11959a;
                            anonymousClass2.f11946b.f11745g = egVar2.getWidth();
                            AnonymousClass2.this.f11946b.f11746h = egVar2.getHeight();
                            List<Integer> a10 = dw.a(egVar2);
                            if (!a10.isEmpty()) {
                                Iterator<Integer> it = a10.iterator();
                                while (it.hasNext()) {
                                    cr.a().c(AnonymousClass2.this.f11946b, it.next().intValue());
                                }
                            }
                            AnonymousClass2.this.f11946b.f11740b.put("expose_verify", true);
                        } catch (Throwable unused) {
                        }
                    }
                });
            }
        }

        @Override // com.umeng.message.proguard.eh.a
        public final void d() {
        }
    }

    public dn(cz czVar) {
        super(czVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void a(dn dnVar, Activity activity, final ck ckVar, final Bitmap bitmap, final da daVar) {
        if (activity.isFinishing()) {
            ce.b("FloatingIcon", "activity has finished skip.");
            cr.a().b(ckVar, IConferenceMirrorListener.CONFERENCE_GUESTMODE_SETGEUSTMODE_FAILED);
            return;
        }
        if (ed.a(activity)) {
            ce.a("FloatingIcon", "activity window not match skipped.");
            cr.a().b(ckVar, 2024);
            return;
        }
        if (dt.a().a((Class<? extends Activity>) activity.getClass())) {
            cr.a().b(ckVar, IConferenceMirrorListener.CONFERENCE_GUESTMODE_RESETGUESTMODE_OK);
            ce.a("FloatingIcon", "current activity not allow show ad:", activity.getClass().getName());
            return;
        }
        final Cdo cdo = new Cdo();
        final AnonymousClass2 anonymousClass2 = dnVar.new AnonymousClass2(cdo, ckVar, daVar);
        View findViewById = activity.findViewById(R.id.umeng_fi_close);
        if (findViewById != null) {
            Object tag = findViewById.getTag();
            if (tag instanceof View.OnClickListener) {
                ((View.OnClickListener) tag).onClick(findViewById);
            }
        }
        if (bitmap != null && ckVar != null) {
            if (cdo.f11959a == null) {
                cdo.f11959a = new eg(de.a());
            }
            cdo.f11959a.setAdImage(bitmap);
            cdo.f11959a.setIconClickListener(new View.OnClickListener() { // from class: com.umeng.message.proguard.do.1
                public AnonymousClass1() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    a aVar = Cdo.this.f11960b;
                    if (aVar != null) {
                        aVar.a(view);
                    }
                }
            });
            cdo.f11959a.setCloseClickListener(new View.OnClickListener() { // from class: com.umeng.message.proguard.do.2
                public AnonymousClass2() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    a aVar = Cdo.this.f11960b;
                    if (aVar != null) {
                        aVar.a();
                    }
                }
            });
            cdo.f11959a.setAdMarkVisibility(ckVar.f());
            cdo.a(activity);
            if (cdo.f11961c == null) {
                cdo.f11961c = new dp(cdo);
                bz.a().a(cdo.f11961c);
            }
        }
        eg egVar = cdo.f11959a;
        if (egVar != null) {
            egVar.setOnStatusListener(anonymousClass2);
        }
        cdo.f11960b = new Cdo.a() { // from class: com.umeng.message.proguard.dn.3
            @Override // com.umeng.message.proguard.Cdo.a
            public final void a() {
                try {
                    cdo.b();
                    ckVar.f11740b.put("exposed_duration", anonymousClass2.e());
                    cr.a().a(ckVar, 2220);
                    cf cfVar = daVar.f11861a;
                    if (cfVar != null) {
                        cfVar.b();
                    }
                    if (bitmap.isRecycled()) {
                        return;
                    }
                    bitmap.recycle();
                } catch (Throwable unused) {
                }
            }

            @Override // com.umeng.message.proguard.Cdo.a
            public final void a(final View view) {
                try {
                    ckVar.f11740b.put("clicked", true);
                    ckVar.f11740b.put("exposed_duration", anonymousClass2.e());
                    ck ckVar2 = ckVar;
                    eh.a aVar = anonymousClass2;
                    ckVar2.f11751m = aVar.f12039g;
                    ckVar2.f11752n = aVar.f12041i;
                    ckVar2.f11753o = aVar.f12040h;
                    ckVar2.f11754p = aVar.f12042j;
                    ckVar2.f11755q = aVar.f12043k;
                    ckVar2.f11756r = aVar.f12044l;
                    ckVar2.f11757s = aVar.f12045m;
                    ckVar2.f11758t = aVar.f12046n;
                    dy.a(de.a(), ckVar, new cq.a() { // from class: com.umeng.message.proguard.dn.3.1
                        @Override // com.umeng.message.proguard.cq.a
                        public final void a() {
                            cf cfVar = daVar.f11861a;
                            if (cfVar != null) {
                                cfVar.a(view);
                            }
                        }

                        @Override // com.umeng.message.proguard.cq.a
                        public final void a(String str) {
                            cf cfVar = daVar.f11861a;
                            if (cfVar != null) {
                                cfVar.a(IConferenceMirrorListener.CONFERENCE_GUESTMODE_SETGEUSTMODE_OK, str);
                            }
                        }
                    });
                    cdo.b();
                    if (bitmap.isRecycled()) {
                        return;
                    }
                    bitmap.recycle();
                } catch (Throwable unused) {
                }
            }
        };
    }

    @Override // com.umeng.message.proguard.dc
    public final ck b() {
        ck a10 = ci.a(this.f11864b).a(this.f11863a);
        if (a10 == null) {
            ce.b("FloatingIcon", "type:", this.f11864b, " request ad failed.");
            throw new cd("request ad failed. code:2000");
        }
        if (a10.f11742d == 0) {
            return a10;
        }
        throw new cd(a10.f11741c);
    }

    @Override // com.umeng.message.proguard.dc
    public final bx.a b(final ck ckVar) {
        final Bitmap a10 = cc.a(de.a(), ckVar.b());
        if (a10 != null) {
            final AtomicReference atomicReference = new AtomicReference();
            da daVar = new da() { // from class: com.umeng.message.proguard.dn.1

                /* renamed from: f, reason: collision with root package name */
                private boolean f11940f = false;

                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.umeng.message.proguard.da
                public final void a(final Activity activity) {
                    if (this.f11940f) {
                        ce.d("FloatingIcon", "already called show.");
                        cf cfVar = this.f11861a;
                        if (cfVar != null) {
                            cfVar.a(2010, "already called show.");
                            return;
                        }
                        return;
                    }
                    try {
                        if (dn.this.f11863a.f11852c) {
                            if (!bz.a().f11686a) {
                                cr.a().b(ckVar, IConferenceMirrorListener.CONFERENCE_GUESTMODE_SETGEUSTMODE_OK);
                                return;
                            }
                            activity = bz.a().b();
                            if (activity != null && !activity.isFinishing()) {
                                if (dt.a().a((Class<? extends Activity>) activity.getClass())) {
                                    cr.a().b(ckVar, IConferenceMirrorListener.CONFERENCE_GUESTMODE_RESETGUESTMODE_OK);
                                    ce.a("FloatingIcon", "current activity not allow show ad:", activity.getClass().getName());
                                    return;
                                }
                            }
                            cr.a().b(ckVar, IConferenceMirrorListener.CONFERENCE_GUESTMODE_SETGEUSTMODE_FAILED);
                            return;
                        }
                        if (dn.this.a(ckVar)) {
                            try {
                                ckVar.f11740b.put("exposed_timeout", true);
                            } catch (Exception unused) {
                            }
                            cr.a().b(ckVar, IConferenceMirrorListener.CONFERENCE_GUESTMODE_RESETGUESTMODE_FAILED);
                            String str = "expose invalid timeout config:" + ckVar.h();
                            ce.d("FloatingIcon", str);
                            cf cfVar2 = this.f11861a;
                            if (cfVar2 != null) {
                                cfVar2.a(2010, str);
                            }
                            return;
                        }
                        WeakReference<Activity> weakReference = dn.this.f11866d;
                        final Activity activity2 = weakReference != null ? weakReference.get() : null;
                        if (activity == null) {
                            if (activity2 != null && !activity2.isFinishing()) {
                                activity2.getWindow().getDecorView().post(new Runnable() { // from class: com.umeng.message.proguard.dn.1.2
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        try {
                                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                            dn.a(dn.this, activity2, ckVar, a10, (da) atomicReference.get());
                                        } catch (Throwable th) {
                                            ce.a("FloatingIcon", "show float action ad failed:", th.getMessage());
                                        }
                                    }
                                });
                                return;
                            }
                            ce.b("FloatingIcon", "activity has finished skip.");
                            cr.a().b(ckVar, IConferenceMirrorListener.CONFERENCE_GUESTMODE_SETGEUSTMODE_FAILED);
                            return;
                        }
                        if (activity.isFinishing()) {
                            ce.b("FloatingIcon", "activity has finished skip.");
                            cr.a().b(ckVar, IConferenceMirrorListener.CONFERENCE_GUESTMODE_SETGEUSTMODE_FAILED);
                        } else {
                            if (activity != activity2) {
                                ce.a("FloatingIcon", "current activity not match request activity.");
                            }
                            activity.getWindow().getDecorView().post(new Runnable() { // from class: com.umeng.message.proguard.dn.1.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    try {
                                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                        dn.a(dn.this, activity, ckVar, a10, (da) atomicReference.get());
                                    } catch (Throwable th) {
                                        ce.a("FloatingIcon", "show float action ad failed:", th.getMessage());
                                    }
                                }
                            });
                        }
                    } catch (Throwable th) {
                        try {
                            ce.a("FloatingIcon", "ad show error:", th.getMessage());
                        } finally {
                            this.f11940f = true;
                        }
                    }
                }
            };
            atomicReference.set(daVar);
            return daVar;
        }
        ce.b("FloatingIcon", "material download failed. sid:" + ckVar.c());
        cr.a().b(ckVar, CastStatusCodes.INVALID_REQUEST);
        throw new cd("material download failed.");
    }
}
