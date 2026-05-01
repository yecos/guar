package com.umeng.message.inapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hpplay.component.protocol.mirror.AutoStrategy;
import com.umeng.message.entity.UInAppMessage;
import com.umeng.message.proguard.ae;
import com.umeng.message.proguard.ag;
import com.umeng.message.proguard.ai;
import com.umeng.message.proguard.aj;
import com.umeng.message.proguard.bo;
import java.util.Calendar;

/* loaded from: classes3.dex */
public class UmengSplashMessageActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    private static final String f11416a = "com.umeng.message.inapp.UmengSplashMessageActivity";

    /* renamed from: s, reason: collision with root package name */
    private static int f11417s = 2000;

    /* renamed from: t, reason: collision with root package name */
    private static int f11418t = 1000;

    /* renamed from: b, reason: collision with root package name */
    private Activity f11419b;

    /* renamed from: c, reason: collision with root package name */
    private ag f11420c;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f11421d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f11422e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f11423f;

    /* renamed from: i, reason: collision with root package name */
    private a f11426i;

    /* renamed from: j, reason: collision with root package name */
    private a f11427j;

    /* renamed from: k, reason: collision with root package name */
    private UInAppMessage f11428k;

    /* renamed from: l, reason: collision with root package name */
    private UInAppHandler f11429l;

    /* renamed from: q, reason: collision with root package name */
    private long f11434q;

    /* renamed from: r, reason: collision with root package name */
    private long f11435r;

    /* renamed from: g, reason: collision with root package name */
    private boolean f11424g = true;

    /* renamed from: h, reason: collision with root package name */
    private boolean f11425h = true;

    /* renamed from: m, reason: collision with root package name */
    private boolean f11430m = false;

    /* renamed from: n, reason: collision with root package name */
    private boolean f11431n = false;

    /* renamed from: o, reason: collision with root package name */
    private boolean f11432o = false;

    /* renamed from: p, reason: collision with root package name */
    private boolean f11433p = false;

    /* renamed from: u, reason: collision with root package name */
    private ag.a f11436u = new ag.a() { // from class: com.umeng.message.inapp.UmengSplashMessageActivity.1
        @Override // com.umeng.message.proguard.ag.a
        public final void a(Bitmap[] bitmapArr) {
            if (UmengSplashMessageActivity.this.c()) {
                return;
            }
            if (UmengSplashMessageActivity.this.f11426i != null) {
                UmengSplashMessageActivity.this.f11426i.a();
                UmengSplashMessageActivity.c(UmengSplashMessageActivity.this);
            }
            try {
                if (bitmapArr.length == 1) {
                    UmengSplashMessageActivity.this.f11421d.setOnClickListener(new View.OnClickListener() { // from class: com.umeng.message.inapp.UmengSplashMessageActivity.1.1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            UmengSplashMessageActivity.d(UmengSplashMessageActivity.this);
                            if (TextUtils.equals("none", UmengSplashMessageActivity.this.f11428k.action_type)) {
                                return;
                            }
                            UmengSplashMessageActivity.a(UmengSplashMessageActivity.this, SystemClock.elapsedRealtime() - UmengSplashMessageActivity.this.f11434q);
                            aj.a(UmengSplashMessageActivity.this.f11419b).a(UmengSplashMessageActivity.this.f11428k.msg_id, UmengSplashMessageActivity.this.f11428k.msg_type, 1, 1, 0, 0, 0, (int) UmengSplashMessageActivity.this.f11435r, 0);
                            UmengSplashMessageActivity.this.d();
                            UmengSplashMessageActivity.this.f11429l.handleInAppMessage(UmengSplashMessageActivity.this.f11419b, UmengSplashMessageActivity.this.f11428k, 16);
                            UmengSplashMessageActivity.this.finish();
                        }
                    });
                    UmengSplashMessageActivity.this.f11422e.setVisibility(8);
                    UmengSplashMessageActivity.this.f11421d.setImageBitmap(bitmapArr[0]);
                    UmengSplashMessageActivity.a(UmengSplashMessageActivity.this.f11421d);
                }
                if (bitmapArr.length == 2) {
                    UmengSplashMessageActivity.this.f11421d.setOnClickListener(new View.OnClickListener() { // from class: com.umeng.message.inapp.UmengSplashMessageActivity.1.2
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            UmengSplashMessageActivity.m(UmengSplashMessageActivity.this);
                            if (TextUtils.equals("none", UmengSplashMessageActivity.this.f11428k.action_type)) {
                                return;
                            }
                            UmengSplashMessageActivity.a(UmengSplashMessageActivity.this, SystemClock.elapsedRealtime() - UmengSplashMessageActivity.this.f11434q);
                            aj.a(UmengSplashMessageActivity.this.f11419b).a(UmengSplashMessageActivity.this.f11428k.msg_id, UmengSplashMessageActivity.this.f11428k.msg_type, 1, 0, 1, UmengSplashMessageActivity.a(UmengSplashMessageActivity.this.f11432o), 0, (int) UmengSplashMessageActivity.this.f11435r, 0);
                            UmengSplashMessageActivity.this.d();
                            UmengSplashMessageActivity.this.f11429l.handleInAppMessage(UmengSplashMessageActivity.this.f11419b, UmengSplashMessageActivity.this.f11428k, 16);
                            UmengSplashMessageActivity.this.finish();
                        }
                    });
                    UmengSplashMessageActivity.this.f11422e.setOnClickListener(new View.OnClickListener() { // from class: com.umeng.message.inapp.UmengSplashMessageActivity.1.3
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            UmengSplashMessageActivity.o(UmengSplashMessageActivity.this);
                            if (TextUtils.equals("none", UmengSplashMessageActivity.this.f11428k.bottom_action_type)) {
                                return;
                            }
                            UmengSplashMessageActivity.a(UmengSplashMessageActivity.this, SystemClock.elapsedRealtime() - UmengSplashMessageActivity.this.f11434q);
                            aj.a(UmengSplashMessageActivity.this.f11419b).a(UmengSplashMessageActivity.this.f11428k.msg_id, UmengSplashMessageActivity.this.f11428k.msg_type, 1, 0, UmengSplashMessageActivity.a(UmengSplashMessageActivity.this.f11431n), 1, 0, (int) UmengSplashMessageActivity.this.f11435r, 0);
                            UmengSplashMessageActivity.this.d();
                            UmengSplashMessageActivity.this.f11429l.handleInAppMessage(UmengSplashMessageActivity.this.f11419b, UmengSplashMessageActivity.this.f11428k, 17);
                            UmengSplashMessageActivity.this.finish();
                        }
                    });
                    UmengSplashMessageActivity.this.f11421d.setImageBitmap(bitmapArr[0]);
                    UmengSplashMessageActivity.this.f11422e.setImageBitmap(bitmapArr[1]);
                    UmengSplashMessageActivity.a(UmengSplashMessageActivity.this.f11421d);
                    UmengSplashMessageActivity.a(UmengSplashMessageActivity.this.f11422e);
                }
                UmengSplashMessageActivity.this.f11434q = SystemClock.elapsedRealtime();
                if (UmengSplashMessageActivity.this.f11428k.display_button) {
                    UmengSplashMessageActivity.this.f11423f.setVisibility(0);
                    UmengSplashMessageActivity.this.f11423f.setOnClickListener(new View.OnClickListener() { // from class: com.umeng.message.inapp.UmengSplashMessageActivity.1.4
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            UmengSplashMessageActivity.a(UmengSplashMessageActivity.this, SystemClock.elapsedRealtime() - UmengSplashMessageActivity.this.f11434q);
                            aj.a(UmengSplashMessageActivity.this.f11419b).a(UmengSplashMessageActivity.this.f11428k.msg_id, UmengSplashMessageActivity.this.f11428k.msg_type, 1, UmengSplashMessageActivity.a(UmengSplashMessageActivity.this.f11430m), UmengSplashMessageActivity.a(UmengSplashMessageActivity.this.f11431n), UmengSplashMessageActivity.a(UmengSplashMessageActivity.this.f11432o), 1, (int) UmengSplashMessageActivity.this.f11435r, 0);
                            UmengSplashMessageActivity.this.d();
                            UmengSplashMessageActivity.this.finish();
                        }
                    });
                } else {
                    UmengSplashMessageActivity.this.f11423f.setVisibility(8);
                }
                InAppMessageManager.getInstance(UmengSplashMessageActivity.this.f11419b).a(UmengSplashMessageActivity.this.f11428k);
                InAppMessageManager.getInstance(UmengSplashMessageActivity.this.f11419b).a(UmengSplashMessageActivity.this.f11428k.msg_id, 1);
                InAppMessageManager inAppMessageManager = InAppMessageManager.getInstance(UmengSplashMessageActivity.this.f11419b);
                StringBuilder sb = new StringBuilder();
                sb.append(System.currentTimeMillis());
                inAppMessageManager.b("KEY_LAST_SHOW_SPLASH_TS", sb.toString());
                UmengSplashMessageActivity.s(UmengSplashMessageActivity.this);
                UmengSplashMessageActivity umengSplashMessageActivity = UmengSplashMessageActivity.this;
                umengSplashMessageActivity.f11427j = umengSplashMessageActivity.new a(umengSplashMessageActivity.f11428k.display_time * 1000, UmengSplashMessageActivity.f11418t);
                UmengSplashMessageActivity.this.f11427j.b();
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    };

    /* renamed from: v, reason: collision with root package name */
    private final ae f11437v = new ae() { // from class: com.umeng.message.inapp.UmengSplashMessageActivity.2
        /* JADX WARN: Removed duplicated region for block: B:30:0x0056  */
        /* JADX WARN: Removed duplicated region for block: B:5:0x0026  */
        @Override // com.umeng.message.proguard.ae
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void a(com.umeng.message.entity.UInAppMessage r6) {
            /*
                Method dump skipped, instructions count: 349
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.inapp.UmengSplashMessageActivity.AnonymousClass2.a(com.umeng.message.entity.UInAppMessage):void");
        }

        @Override // com.umeng.message.proguard.ae
        public final void b(UInAppMessage uInAppMessage) {
        }
    };

    public class a extends ai {
        public a(long j10, long j11) {
            super(j10, j11);
        }

        @Override // com.umeng.message.proguard.ai
        public final void a(long j10) {
            if (UmengSplashMessageActivity.this.f11424g) {
                return;
            }
            UmengSplashMessageActivity.this.f11423f.setVisibility(0);
            TextView textView = UmengSplashMessageActivity.this.f11423f;
            StringBuilder sb = new StringBuilder();
            double d10 = j10;
            Double.isNaN(d10);
            double d11 = UmengSplashMessageActivity.f11418t;
            Double.isNaN(d11);
            sb.append((int) Math.ceil((d10 * 1.0d) / d11));
            sb.append(" ");
            sb.append(UmengSplashMessageActivity.this.f11428k.display_name);
            textView.setText(sb.toString());
        }

        @Override // com.umeng.message.proguard.ai
        public final void e() {
            if (UmengSplashMessageActivity.this.c() && UmengSplashMessageActivity.this.f11424g) {
                return;
            }
            if (!UmengSplashMessageActivity.this.f11424g) {
                aj.a(UmengSplashMessageActivity.this.f11419b).a(UmengSplashMessageActivity.this.f11428k.msg_id, UmengSplashMessageActivity.this.f11428k.msg_type, 1, UmengSplashMessageActivity.a(UmengSplashMessageActivity.this.f11430m), UmengSplashMessageActivity.a(UmengSplashMessageActivity.this.f11431n), UmengSplashMessageActivity.a(UmengSplashMessageActivity.this.f11432o), 0, UmengSplashMessageActivity.this.f11428k.display_time * 1000, 0);
            }
            UmengSplashMessageActivity.this.d();
            UmengSplashMessageActivity.this.finish();
        }
    }

    public static /* synthetic */ int a(boolean z10) {
        return z10 ? 1 : 0;
    }

    public static /* synthetic */ a c(UmengSplashMessageActivity umengSplashMessageActivity) {
        umengSplashMessageActivity.f11426i = null;
        return null;
    }

    public static /* synthetic */ boolean d(UmengSplashMessageActivity umengSplashMessageActivity) {
        umengSplashMessageActivity.f11430m = true;
        return true;
    }

    public static /* synthetic */ boolean m(UmengSplashMessageActivity umengSplashMessageActivity) {
        umengSplashMessageActivity.f11431n = true;
        return true;
    }

    public static /* synthetic */ boolean o(UmengSplashMessageActivity umengSplashMessageActivity) {
        umengSplashMessageActivity.f11432o = true;
        return true;
    }

    public static /* synthetic */ boolean s(UmengSplashMessageActivity umengSplashMessageActivity) {
        umengSplashMessageActivity.f11424g = false;
        return false;
    }

    public static /* synthetic */ boolean u(UmengSplashMessageActivity umengSplashMessageActivity) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(Long.parseLong(InAppMessageManager.getInstance(umengSplashMessageActivity.f11419b).a("KEY_LAST_SHOW_SPLASH_TS", "0")));
        Calendar calendar2 = Calendar.getInstance();
        return calendar.get(6) == calendar2.get(6) && calendar.get(1) == calendar2.get(1);
    }

    @Override // android.app.Activity
    public final void onBackPressed() {
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f11419b = this;
        if ((getIntent().getFlags() & AutoStrategy.BITRATE_LOW) > 0) {
            finish();
            return;
        }
        if (onCustomPretreatment()) {
            return;
        }
        setRequestedOrientation(1);
        FrameLayout frameLayout = new FrameLayout(this.f11419b);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        LinearLayout linearLayout = new LinearLayout(this.f11419b);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 13.0f);
        ImageView imageView = new ImageView(this.f11419b);
        this.f11421d = imageView;
        imageView.setLayoutParams(layoutParams);
        this.f11421d.setScaleType(ImageView.ScaleType.FIT_XY);
        linearLayout.addView(this.f11421d);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0, 3.0f);
        ImageView imageView2 = new ImageView(this.f11419b);
        this.f11422e = imageView2;
        imageView2.setLayoutParams(layoutParams2);
        this.f11422e.setScaleType(ImageView.ScaleType.FIT_XY);
        linearLayout.addView(this.f11422e);
        frameLayout.addView(linearLayout);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 5;
        layoutParams3.rightMargin = bo.a(30.0f);
        layoutParams3.topMargin = bo.a(20.0f);
        TextView textView = new TextView(this.f11419b);
        this.f11423f = textView;
        textView.setLayoutParams(layoutParams3);
        int a10 = bo.a(6.0f);
        int i10 = a10 / 3;
        this.f11423f.setPadding(a10, i10, a10, i10);
        this.f11423f.setTextSize(14.0f);
        this.f11423f.setBackgroundColor(Color.parseColor("#80000000"));
        this.f11423f.setTextColor(-1);
        this.f11423f.setVisibility(8);
        frameLayout.addView(this.f11423f);
        setContentView(frameLayout);
        if (InAppMessageManager.f11366a) {
            aj.a(this).a(this.f11437v);
        } else if (System.currentTimeMillis() - Long.parseLong(InAppMessageManager.getInstance(this.f11419b).a("KEY_SPLASH_TS", "0")) > InAppMessageManager.f11367d) {
            aj.a(this).a(this.f11437v);
        } else {
            this.f11437v.a(null);
        }
        this.f11429l = InAppMessageManager.getInstance(this.f11419b).getInAppHandler();
        a aVar = new a(f11417s, f11418t);
        this.f11426i = aVar;
        aVar.b();
    }

    public boolean onCustomPretreatment() {
        return false;
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        a aVar = this.f11426i;
        if (aVar != null) {
            aVar.a();
        }
        a aVar2 = this.f11427j;
        if (aVar2 != null) {
            aVar2.a();
        }
        ag agVar = this.f11420c;
        if (agVar != null) {
            agVar.f11468a = null;
        }
        this.f11433p = false;
        this.f11430m = false;
        this.f11431n = false;
        this.f11432o = false;
        super.onDestroy();
    }

    @Override // android.app.Activity
    public final void onPause() {
        super.onPause();
        a aVar = this.f11426i;
        if (aVar != null) {
            aVar.c();
        }
        if (this.f11427j != null) {
            this.f11435r += SystemClock.elapsedRealtime() - this.f11434q;
            this.f11427j.c();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        a aVar = this.f11426i;
        if (aVar != null) {
            aVar.d();
        }
        if (this.f11427j != null) {
            this.f11434q = SystemClock.elapsedRealtime();
            this.f11427j.d();
        }
    }

    @Override // android.app.Activity
    public final void onStart() {
        super.onStart();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean c() {
        boolean z10;
        z10 = this.f11433p;
        this.f11433p = true;
        return z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d() {
        if (this.f11425h) {
            this.f11425h = false;
            Intent intent = new Intent();
            intent.setClassName(this.f11419b, InAppMessageManager.getInstance(this).f11371c);
            intent.setFlags(536870912);
            try {
                this.f11419b.startActivity(intent);
            } catch (Exception unused) {
            }
        }
    }

    public static /* synthetic */ long a(UmengSplashMessageActivity umengSplashMessageActivity, long j10) {
        long j11 = umengSplashMessageActivity.f11435r + j10;
        umengSplashMessageActivity.f11435r = j11;
        return j11;
    }

    public static /* synthetic */ void a(View view) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.3f, 1.0f);
        alphaAnimation.setDuration(500L);
        view.startAnimation(alphaAnimation);
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle, PersistableBundle persistableBundle) {
        super.onCreate(bundle, persistableBundle);
    }
}
