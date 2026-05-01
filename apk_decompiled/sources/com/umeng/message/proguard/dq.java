package com.umeng.message.proguard;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.google.android.gms.cast.CastStatusCodes;
import com.hpplay.sdk.source.api.IConferenceMirrorListener;
import com.umeng.message.proguard.bx;
import com.umeng.message.proguard.cq;
import com.umeng.message.proguard.ct;
import com.umeng.message.proguard.eh;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public final class dq extends dc {

    /* renamed from: h, reason: collision with root package name */
    static WeakReference<dr> f11967h;

    /* renamed from: com.umeng.message.proguard.dq$3, reason: invalid class name */
    public class AnonymousClass3 extends eh.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ dr f11980a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ck f11981b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ da f11982c;

        public AnonymousClass3(dr drVar, ck ckVar, da daVar) {
            this.f11980a = drVar;
            this.f11981b = ckVar;
            this.f11982c = daVar;
        }

        @Override // com.umeng.message.proguard.eh.a
        public final void a(Configuration configuration) {
            int i10;
            dr drVar = this.f11980a;
            int i11 = drVar.f12006e;
            if (i11 == -1 || (i10 = configuration.orientation) == i11) {
                return;
            }
            drVar.f12006e = i10;
            try {
                drVar.f12004c.b();
                drVar.f12005d.getLayoutParams().width = drVar.f12004c.a().getLayoutParams().width;
                drVar.f12005d.requestLayout();
                drVar.f12005d.invalidate();
            } catch (Throwable th) {
                ce.d("Interstitial", "onConfigurationChanged:", th.getMessage());
            }
        }

        @Override // com.umeng.message.proguard.eh.a
        public final void c() {
            eh ehVar = this.f11980a.f12002a;
            if (ehVar != null) {
                ehVar.post(new Runnable() { // from class: com.umeng.message.proguard.dq.3.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            cr.a().a(AnonymousClass3.this.f11981b, new cq.a() { // from class: com.umeng.message.proguard.dq.3.1.1
                                @Override // com.umeng.message.proguard.cq.a
                                public final void a() {
                                    cf cfVar = AnonymousClass3.this.f11982c.f11861a;
                                    if (cfVar != null) {
                                        cfVar.a();
                                    }
                                }

                                @Override // com.umeng.message.proguard.cq.a
                                public final void a(String str) {
                                    cf cfVar = AnonymousClass3.this.f11982c.f11861a;
                                    if (cfVar != null) {
                                        cfVar.a(2010, str);
                                    }
                                }
                            });
                            if (AnonymousClass3.this.f11981b.f11740b.optBoolean("expose_verify", false)) {
                                return;
                            }
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            eh ehVar2 = anonymousClass3.f11980a.f12002a;
                            anonymousClass3.f11981b.f11745g = ehVar2.getWidth();
                            AnonymousClass3.this.f11981b.f11746h = ehVar2.getHeight();
                            List<Integer> a10 = dw.a(ehVar2);
                            if (!a10.isEmpty()) {
                                Iterator<Integer> it = a10.iterator();
                                while (it.hasNext()) {
                                    cr.a().c(AnonymousClass3.this.f11981b, it.next().intValue());
                                }
                            }
                            AnonymousClass3.this.f11981b.f11740b.put("expose_verify", true);
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

    public dq(cz czVar) {
        super(czVar);
    }

    public static /* synthetic */ void a(dq dqVar, Activity activity, final ck ckVar, final da daVar, final cl clVar) {
        if (activity.isFinishing()) {
            ce.b("Interstitial", "activity has finished skip.");
            cr.a().b(ckVar, 2013);
            return;
        }
        if (ed.a(activity)) {
            ce.b("Interstitial", "activity window not match skipped.");
            cr.a().b(ckVar, 2011);
            return;
        }
        final dr drVar = new dr(activity, clVar);
        final AnonymousClass3 anonymousClass3 = dqVar.new AnonymousClass3(drVar, ckVar, daVar);
        eh ehVar = drVar.f12002a;
        if (ehVar != null) {
            ehVar.setOnStatusListener(anonymousClass3);
        }
        drVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.umeng.message.proguard.dq.4
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                daVar.b();
                cn cnVar = clVar.f11760b;
                if (cnVar != null) {
                    cnVar.d();
                }
            }
        });
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.umeng.message.proguard.dq.5
            @Override // android.view.View.OnClickListener
            public final void onClick(final View view) {
                try {
                    ckVar.f11740b.put("clicked", true);
                    ckVar.f11740b.put("exposed_duration", anonymousClass3.e());
                    cn cnVar = clVar.f11760b;
                    if (cnVar != null) {
                        cnVar.e();
                    }
                    cn cnVar2 = clVar.f11760b;
                    if (cnVar2 != null) {
                        cnVar2.f();
                    }
                    ck ckVar2 = ckVar;
                    eh.a aVar = anonymousClass3;
                    ckVar2.f11751m = aVar.f12039g;
                    ckVar2.f11752n = aVar.f12041i;
                    ckVar2.f11753o = aVar.f12040h;
                    ckVar2.f11754p = aVar.f12042j;
                    ckVar2.f11755q = aVar.f12043k;
                    ckVar2.f11756r = aVar.f12044l;
                    ckVar2.f11757s = aVar.f12045m;
                    ckVar2.f11758t = aVar.f12046n;
                    dy.a(de.a(), ckVar, new cq.a() { // from class: com.umeng.message.proguard.dq.5.1
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
                    dq.f11967h = null;
                    drVar.dismiss();
                } catch (Throwable unused) {
                }
            }
        };
        LinearLayout linearLayout = drVar.f12005d;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(onClickListener);
        }
        View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: com.umeng.message.proguard.dq.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                try {
                    dq.f11967h = null;
                    drVar.dismiss();
                    ckVar.f11740b.put("exposed_duration", anonymousClass3.e());
                    cr.a().a(ckVar, 2210);
                    cf cfVar = daVar.f11861a;
                    if (cfVar != null) {
                        cfVar.b();
                    }
                } catch (Throwable unused) {
                }
            }
        };
        ImageView imageView = drVar.f12003b;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener2);
        }
        drVar.f12007f = onClickListener2;
        if (f11967h != null) {
            ce.b("Interstitial", "sDialogRef not null");
            dr drVar2 = f11967h.get();
            if (drVar2 != null && drVar2.isShowing()) {
                ce.b("Interstitial", "dismiss last");
                View.OnClickListener onClickListener3 = drVar2.f12007f;
                if (onClickListener3 != null) {
                    onClickListener3.onClick(null);
                }
            }
        }
        drVar.show();
        f11967h = new WeakReference<>(drVar);
    }

    @Override // com.umeng.message.proguard.dc
    public final ck b() {
        ck a10 = ci.a(this.f11864b).a(this.f11863a);
        if (a10 == null) {
            ce.b("Interstitial", "type:", this.f11864b, " request failed.");
            throw new cd("request failed. code:2000");
        }
        if (a10.f11742d != 0) {
            throw new cd(a10.f11741c);
        }
        if (!a10.f11743e || bs.a(a10.a()) == bs.f11671f) {
            return a10;
        }
        throw new cd("interstitial style error:" + a10.a());
    }

    @Override // com.umeng.message.proguard.dc
    public final bx.a b(final ck ckVar) {
        Bitmap a10;
        Context a11 = de.a();
        if (ckVar.f11743e) {
            String l10 = ckVar.l();
            final AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            ct.a(true, l10, new ct.a() { // from class: com.umeng.message.proguard.dq.1
                @Override // com.umeng.message.proguard.ct.a
                public final void a(String str) {
                }

                @Override // com.umeng.message.proguard.ct.a
                public final void a() {
                    atomicBoolean.set(false);
                }
            });
            if (!atomicBoolean.get()) {
                ce.b("Interstitial", "video download failed. sid:" + ckVar.c());
                cr.a().b(ckVar, CastStatusCodes.INVALID_REQUEST);
                throw new cd("video download failed.");
            }
            a10 = null;
        } else {
            a10 = cc.a(a11, ckVar.b());
            if (a10 == null) {
                ce.b("Interstitial", "image download failed. sid:" + ckVar.c());
                cr.a().b(ckVar, CastStatusCodes.INVALID_REQUEST);
                throw new cd("image download failed.");
            }
        }
        final cl clVar = new cl(ckVar);
        if (ckVar.f11743e) {
            clVar.f11760b = new co(a11, clVar);
        } else {
            clVar.f11760b = new cm(a11, clVar);
        }
        cn cnVar = clVar.f11760b;
        if (cnVar != null) {
            cnVar.a(a10);
        }
        cn cnVar2 = clVar.f11760b;
        if (cnVar2 != null) {
            cnVar2.b();
        }
        return new da() { // from class: com.umeng.message.proguard.dq.2

            /* renamed from: e, reason: collision with root package name */
            private boolean f11973e = false;

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.umeng.message.proguard.da
            public final void a(final Activity activity) {
                if (this.f11973e) {
                    ce.d("Interstitial", "already called show.");
                    cf cfVar = this.f11861a;
                    if (cfVar != null) {
                        cfVar.a(2010, "already called show.");
                        return;
                    }
                    return;
                }
                try {
                    if (dq.this.f11863a.f11852c) {
                        if (!bz.a().f11686a) {
                            cr.a().b(ckVar, 2014);
                            return;
                        }
                        activity = bz.a().b();
                        if (activity != null && !activity.isFinishing()) {
                            if (dt.a().a((Class<? extends Activity>) activity.getClass())) {
                                cr.a().b(ckVar, 2015);
                                ce.a("Interstitial", "current activity not allow show ad:", activity.getClass().getName());
                                return;
                            }
                        }
                        cr.a().b(ckVar, 2013);
                        return;
                    }
                    if (dq.this.a(ckVar)) {
                        try {
                            ckVar.f11740b.put("exposed_timeout", true);
                        } catch (Exception unused) {
                        }
                        cr.a().b(ckVar, 2012);
                        String str = "expose invalid! timeout config:" + ckVar.h();
                        ce.d("Interstitial", str);
                        cf cfVar2 = this.f11861a;
                        if (cfVar2 != null) {
                            cfVar2.a(2010, str);
                        }
                        return;
                    }
                    WeakReference<Activity> weakReference = dq.this.f11866d;
                    final Activity activity2 = weakReference != null ? weakReference.get() : null;
                    if (activity != null) {
                        if (!activity.isFinishing()) {
                            activity.getWindow().getDecorView().post(new Runnable() { // from class: com.umeng.message.proguard.dq.2.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    try {
                                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                        dq.a(dq.this, activity, ckVar, this, clVar);
                                    } catch (Throwable th) {
                                        ce.a("Interstitial", "show interstitial dialog failed:", th.getMessage());
                                    }
                                }
                            });
                            return;
                        } else {
                            ce.b("Interstitial", "activity has finished skip.");
                            cr.a().b(ckVar, 2013);
                            return;
                        }
                    }
                    if (activity2 != null && !activity2.isFinishing()) {
                        activity2.getWindow().getDecorView().post(new Runnable() { // from class: com.umeng.message.proguard.dq.2.2
                            @Override // java.lang.Runnable
                            public final void run() {
                                try {
                                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                    dq.a(dq.this, activity2, ckVar, this, clVar);
                                } catch (Throwable th) {
                                    ce.a("Interstitial", "show interstitial dialog failed:", th.getMessage());
                                }
                            }
                        });
                        return;
                    }
                    ce.b("Interstitial", "activity has finished skip.");
                    cr.a().b(ckVar, 2013);
                } catch (Throwable th) {
                    try {
                        ce.a("Interstitial", "show error:", th.getMessage());
                    } finally {
                        this.f11973e = true;
                    }
                }
            }
        };
    }
}
