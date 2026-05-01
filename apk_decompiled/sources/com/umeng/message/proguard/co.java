package com.umeng.message.proguard;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.material.badge.BadgeDrawable;
import com.umeng.message.proguard.bx;
import com.umeng.message.proguard.ct;
import com.umeng.message.push.R;

/* loaded from: classes3.dex */
public final class co extends cn {

    /* renamed from: c, reason: collision with root package name */
    final cv f11765c;

    /* renamed from: d, reason: collision with root package name */
    ej f11766d;

    /* renamed from: e, reason: collision with root package name */
    final cg f11767e;

    /* renamed from: f, reason: collision with root package name */
    private final FrameLayout f11768f;

    /* renamed from: g, reason: collision with root package name */
    private bx.f f11769g;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f11770h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f11771i;

    public class a implements bx.f {

        /* renamed from: b, reason: collision with root package name */
        private final boolean f11778b;

        /* renamed from: c, reason: collision with root package name */
        private final bx.f f11779c;

        public a(boolean z10, bx.f fVar) {
            this.f11779c = fVar;
            this.f11778b = z10;
        }
    }

    public co(Context context, cl clVar) {
        super(context, clVar);
        this.f11767e = new cg();
        this.f11771i = true;
        this.f11765c = new cv();
        this.f11768f = new FrameLayout(context);
    }

    @Override // com.umeng.message.proguard.cn
    public final View a() {
        return this.f11768f;
    }

    @Override // com.umeng.message.proguard.cn
    public final void b() {
        if (this.f11769g == null) {
            this.f11769g = new a(a(this.f11764b.f11759a), this.f11765c);
        }
        this.f11765c.f11838l = new bx.e() { // from class: com.umeng.message.proguard.co.1
            /* JADX WARN: Removed duplicated region for block: B:10:0x003b  */
            @Override // com.umeng.message.proguard.bx.e
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void a() {
                /*
                    r5 = this;
                    com.umeng.message.proguard.co r0 = com.umeng.message.proguard.co.this
                    com.umeng.message.proguard.cv r1 = r0.f11765c
                    com.umeng.message.proguard.cl r0 = r0.f11764b
                    com.umeng.message.proguard.ck r0 = r0.f11759a
                    boolean r0 = com.umeng.message.proguard.co.a(r0)
                    r2 = 0
                    r3 = 1
                    if (r0 != 0) goto L28
                    com.umeng.message.proguard.co r0 = com.umeng.message.proguard.co.this
                    com.umeng.message.proguard.cl r0 = r0.f11764b
                    com.umeng.message.proguard.ck r0 = r0.f11759a
                    org.json.JSONObject r0 = r0.f11740b
                    java.lang.String r4 = "video_loop"
                    int r0 = r0.optInt(r4, r3)
                    if (r0 != r3) goto L22
                    r0 = 1
                    goto L23
                L22:
                    r0 = 0
                L23:
                    if (r0 == 0) goto L26
                    goto L28
                L26:
                    r0 = 0
                    goto L29
                L28:
                    r0 = 1
                L29:
                    r1.f11831e = r0
                    com.umeng.message.proguard.co r0 = com.umeng.message.proguard.co.this
                    com.umeng.message.proguard.cl r0 = r0.f11764b
                    com.umeng.message.proguard.ck r0 = r0.f11759a
                    org.json.JSONObject r0 = r0.f11740b
                    java.lang.String r1 = "video_sound"
                    int r0 = r0.optInt(r1, r2)
                    if (r0 != 0) goto L3c
                    r2 = 1
                L3c:
                    com.umeng.message.proguard.co r0 = com.umeng.message.proguard.co.this
                    com.umeng.message.proguard.cv r0 = r0.f11765c
                    r0.b(r2)
                    com.umeng.message.proguard.co r0 = com.umeng.message.proguard.co.this
                    r0.a(r2)
                    com.umeng.message.proguard.co r0 = com.umeng.message.proguard.co.this
                    com.umeng.message.proguard.cg r0 = r0.f11767e
                    r0.a()
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.co.AnonymousClass1.a():void");
            }

            @Override // com.umeng.message.proguard.bx.e
            public final void b() {
                co.this.f11767e.b();
            }

            @Override // com.umeng.message.proguard.bx.e
            public final void c() {
                co.this.f11767e.c();
            }

            @Override // com.umeng.message.proguard.bx.e
            public final void d() {
                co.this.f11767e.d();
            }

            @Override // com.umeng.message.proguard.bx.e
            public final void a(String str) {
                co.this.f11767e.a(str);
            }
        };
        ct.a(true, this.f11764b.f11759a.l(), new ct.a() { // from class: com.umeng.message.proguard.co.2
            @Override // com.umeng.message.proguard.ct.a
            public final void a() {
            }

            /* JADX WARN: Can't wrap try/catch for region: R(17:3|4|5|6|7|8|9|(2:10|11)|12|(2:15|16)|(2:20|21)|24|25|(2:27|(2:29|30)(1:33))|34|35|36) */
            /* JADX WARN: Code restructure failed: missing block: B:41:0x0098, code lost:
            
                r2 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:42:0x0099, code lost:
            
                com.umeng.message.proguard.ce.d("VideoPlayer", "prepare mmr ready error:", r2.getMessage());
             */
            /* JADX WARN: Removed duplicated region for block: B:14:0x0072 A[ADDED_TO_REGION] */
            /* JADX WARN: Removed duplicated region for block: B:20:0x0084 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:27:0x008e A[Catch: all -> 0x0098, TryCatch #4 {all -> 0x0098, blocks: (B:25:0x008a, B:27:0x008e, B:29:0x0094), top: B:24:0x008a }] */
            @Override // com.umeng.message.proguard.ct.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void a(java.lang.String r13) {
                /*
                    Method dump skipped, instructions count: 209
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.proguard.co.AnonymousClass2.a(java.lang.String):void");
            }
        });
    }

    @Override // com.umeng.message.proguard.cn
    public final void c() {
        int i10;
        int i11;
        int i12;
        boolean a10 = a(this.f11764b.f11759a);
        if (this.f11766d == null) {
            ej ejVar = new ej(this.f11763a);
            this.f11766d = ejVar;
            ejVar.setVideoPlayer(this.f11765c);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            this.f11766d.setLayoutParams(layoutParams);
        }
        ViewParent parent = this.f11766d.getParent();
        if (parent != null) {
            ((ViewGroup) parent).removeView(this.f11766d);
        }
        this.f11768f.addView(this.f11766d);
        if (this.f11771i && a10) {
            if (this.f11770h == null) {
                this.f11770h = new ImageView(this.f11763a);
                int a11 = ed.a(4.0f);
                int i13 = a11 * 10;
                int i14 = a11 * 3;
                int i15 = a11 * 2;
                this.f11770h.setPadding(i14, i14, i15, i15);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i13, i13);
                layoutParams2.gravity = BadgeDrawable.TOP_START;
                this.f11770h.setLayoutParams(layoutParams2);
                this.f11770h.setOnClickListener(new View.OnClickListener() { // from class: com.umeng.message.proguard.co.3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        co.this.f11765c.b(!r2.f11830d);
                        co coVar = co.this;
                        coVar.a(coVar.f11765c.f11830d);
                    }
                });
            }
            a(this.f11765c.f11830d);
            ViewParent parent2 = this.f11770h.getParent();
            if (parent2 != null) {
                ((ViewGroup) parent2).removeView(this.f11770h);
            }
            this.f11768f.addView(this.f11770h);
        }
        bx.c a12 = bt.a(this.f11764b.f11759a);
        bx.c cVar = bx.c.INTERSTITIAL;
        boolean z10 = true;
        if (a12 == cVar) {
            DisplayMetrics displayMetrics = this.f11763a.getResources().getDisplayMetrics();
            boolean z11 = displayMetrics.widthPixels < displayMetrics.heightPixels;
            cv cvVar = this.f11765c;
            int i16 = cvVar.f11836j;
            int i17 = cvVar.f11837k;
            float f10 = (i16 <= 0 || i17 <= 0) ? 0.5625f : (i16 * 1.0f) / i17;
            int a13 = ed.a(72.0f);
            int a14 = ed.a(144.0f);
            if (z11) {
                i12 = displayMetrics.widthPixels - a13;
                i11 = (int) (i12 / f10);
                int i18 = displayMetrics.heightPixels;
                if (i11 > i18 - a14) {
                    i11 = i18 - a14;
                    i12 = (int) (i11 * f10);
                }
                i10 = i12;
            } else {
                int i19 = displayMetrics.heightPixels - a14;
                int i20 = (int) (i19 * f10);
                int i21 = displayMetrics.widthPixels;
                if (i20 > i21 - a13) {
                    i10 = i21 - a13;
                    i11 = i19;
                } else if (i20 > i19) {
                    i11 = i19;
                    i10 = i20;
                } else {
                    i10 = i19;
                    i11 = i10;
                    i12 = i20;
                }
                i12 = i10;
            }
            FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.f11766d.getLayoutParams();
            layoutParams3.width = i12;
            layoutParams3.height = i11;
            this.f11766d.setLayoutParams(layoutParams3);
            this.f11768f.setLayoutParams(new FrameLayout.LayoutParams(i10, i11));
        }
        if (a12 != cVar) {
            if (!(this.f11764b.f11759a.f11740b.optInt("auto_play", 1) == 1)) {
                z10 = false;
            }
        }
        if (z10) {
            ct.a(false, this.f11764b.f11759a.l(), new ct.a() { // from class: com.umeng.message.proguard.co.4
                @Override // com.umeng.message.proguard.ct.a
                public final void a() {
                }

                @Override // com.umeng.message.proguard.ct.a
                public final void a(String str) {
                    ej ejVar2 = co.this.f11766d;
                    if (ejVar2 == null) {
                        return;
                    }
                    ejVar2.post(new Runnable() { // from class: com.umeng.message.proguard.co.4.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            cv cvVar2;
                            ej ejVar3 = co.this.f11766d;
                            if (ejVar3 == null || (cvVar2 = ejVar3.f12057a) == null) {
                                return;
                            }
                            ejVar3.f12058b = cvVar2.b();
                        }
                    });
                }
            });
        }
    }

    @Override // com.umeng.message.proguard.cn
    public final void d() {
        ck ckVar = this.f11764b.f11759a;
        int e10 = this.f11765c.e();
        ckVar.f11744f = e10;
        this.f11765c.a(e10);
        cv cvVar = this.f11765c;
        cr.a().a(true, ckVar, cvVar.f11834h, e10, cvVar.f11833g, cvVar.f11835i);
    }

    @Override // com.umeng.message.proguard.cn
    public final void e() {
        this.f11765c.b(true);
        a(true);
    }

    @Override // com.umeng.message.proguard.cn
    public final void f() {
        ck ckVar = this.f11764b.f11759a;
        int e10 = this.f11765c.e();
        this.f11765c.a(e10);
        cv cvVar = this.f11765c;
        boolean z10 = cvVar.f11834h;
        int i10 = cvVar.f11833g;
        long j10 = cvVar.f11835i;
        ckVar.f11744f = e10;
        cr.a().a(false, ckVar, z10, e10, i10, j10);
    }

    public static boolean a(ck ckVar) {
        bx.c a10 = bt.a(ckVar);
        return a10 != null && a10 == bx.c.INTERSTITIAL;
    }

    public final void a(boolean z10) {
        ImageView imageView = this.f11770h;
        if (imageView == null) {
            return;
        }
        imageView.setImageResource(z10 ? R.drawable.umeng_union_sound_off : R.drawable.umeng_union_sound_on);
    }
}
