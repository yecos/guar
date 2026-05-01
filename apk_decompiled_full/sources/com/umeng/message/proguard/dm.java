package com.umeng.message.proguard;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.google.android.gms.cast.CastStatusCodes;
import com.umeng.message.proguard.bx;
import java.lang.ref.WeakReference;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: classes3.dex */
public final class dm extends dc {
    public dm(cz czVar) {
        super(czVar);
    }

    @Override // com.umeng.message.proguard.dc
    public final ck b() {
        ck a10 = ci.a(this.f11864b).a(this.f11863a);
        if (a10 == null) {
            ce.b("Banner", "type:", this.f11864b, " request ad failed.");
            throw new cd("request ad failed.");
        }
        if (a10.f11742d == 0) {
            return a10;
        }
        throw new cd(a10.f11741c);
    }

    @Override // com.umeng.message.proguard.dc
    public final bx.a b(final ck ckVar) {
        Bitmap bitmap;
        if (ckVar.f11739a != this.f11864b) {
            return null;
        }
        final boolean z10 = this.f11863a.f11852c;
        final WeakReference<Activity> weakReference = this.f11866d;
        Context a10 = de.a();
        int a11 = ckVar.a();
        int a12 = bs.a(a11);
        if (a12 == 0) {
            ce.b("Banner", "type:" + bx.c.BANNER + " style:" + a11);
            return null;
        }
        if (a12 != bs.f11667b) {
            bitmap = (a12 == bs.f11666a || a12 == bs.f11669d) ? cc.a(a10, ckVar.b()) : null;
            if (bitmap == null) {
                ce.b("Banner", "material download failed. sid:" + ckVar.c());
                cr.a().b(ckVar, CastStatusCodes.INVALID_REQUEST);
                throw new cd("material download failed.");
            }
        } else {
            bitmap = null;
        }
        if (a12 != bs.f11666a && (TextUtils.isEmpty(ckVar.d()) || TextUtils.isEmpty(ckVar.e()))) {
            ce.b("Banner", "banner title or content not match.");
            return null;
        }
        final long max = Math.max(ckVar.f11740b.optLong(IjkMediaPlayer.OnNativeInvokeListener.ARG_FD), 3000L);
        final Bitmap bitmap2 = bitmap;
        return new da() { // from class: com.umeng.message.proguard.dm.1

            /* renamed from: h, reason: collision with root package name */
            private boolean f11935h = false;

            @Override // com.umeng.message.proguard.da
            public final void a(Activity activity) {
                if (this.f11935h) {
                    ce.d("Banner", "already called show.");
                    cf cfVar = this.f11861a;
                    if (cfVar != null) {
                        cfVar.a(2010, "already called show.");
                        return;
                    }
                    return;
                }
                try {
                    if (z10) {
                        dh.a(new dk(ckVar, bitmap2), max, this);
                        return;
                    }
                    if (!dc.this.a(ckVar)) {
                        WeakReference weakReference2 = weakReference;
                        Activity activity2 = weakReference2 != null ? (Activity) weakReference2.get() : null;
                        if (activity2 != null && !activity2.isFinishing()) {
                            dh.a(activity2, new dk(ckVar, bitmap2), max, this);
                            return;
                        }
                        ce.b("Banner", "activity has finished skip.");
                        cr.a().b(ckVar, CastStatusCodes.APPLICATION_NOT_RUNNING);
                        return;
                    }
                    try {
                        ckVar.f11740b.put("exposed_timeout", true);
                    } catch (Exception unused) {
                    }
                    cr.a().b(ckVar, 2009);
                    String str = "expose invalid! timeout config:" + ckVar.h();
                    ce.d("Banner", str);
                    cf cfVar2 = this.f11861a;
                    if (cfVar2 != null) {
                        cfVar2.a(2010, str);
                    }
                } catch (Throwable th) {
                    try {
                        ce.a("Banner", "ad show error:", th.getMessage());
                    } finally {
                        this.f11935h = true;
                    }
                }
            }

            @Override // com.umeng.message.proguard.da
            public final void b() {
                dc dcVar = dc.this;
                dcVar.f11865c = null;
                dcVar.f11866d = null;
                a((bx.d) null);
            }
        };
    }
}
