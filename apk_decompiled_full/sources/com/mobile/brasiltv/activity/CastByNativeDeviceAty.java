package com.mobile.brasiltv.activity;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.CastByNativeDeviceAty;
import com.mobile.brasiltv.bean.event.CastToPlayEvent;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f0;
import com.mobile.brasiltv.utils.g;
import com.mobile.brasiltv.utils.h;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.view.TitleView;
import com.mobile.brasiltv.view.VerticalItemDecoration;
import com.msandroid.mobile.R;
import com.titan.cast.bean.Device;
import f5.c;
import g5.t;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import s9.l;
import t9.i;
import t9.j;
import t9.z;
import w6.i;

/* loaded from: classes3.dex */
public final class CastByNativeDeviceAty extends c implements g.a {

    /* renamed from: m, reason: collision with root package name */
    public Map f7822m = new LinkedHashMap();

    /* renamed from: k, reason: collision with root package name */
    public String f7820k = "";

    /* renamed from: l, reason: collision with root package name */
    public t f7821l = new t(this, new ArrayList());

    public static final class a implements t.a {
        @Override // g5.t.a
        public void a(Device device, int i10) {
            i.g(device, "serviceInfo");
            g.f8651a.t(device);
            h.f8694a.x(true);
        }
    }

    public static final class b extends j implements l {
        public b() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return h9.t.f14242a;
        }

        public final void invoke(String str) {
            TextView textView = (TextView) CastByNativeDeviceAty.this.Z2(R$id.mTvSearchDeviceTips);
            z zVar = z.f18964a;
            String string = CastByNativeDeviceAty.this.Q1().getString(R.string.cast_dlna_trial);
            i.f(string, "context.getString(R.string.cast_dlna_trial)");
            String format = String.format(string, Arrays.copyOf(new Object[]{str}, 1));
            i.f(format, "format(format, *args)");
            textView.setText(format);
        }
    }

    public static final void a3(CastByNativeDeviceAty castByNativeDeviceAty) {
        i.g(castByNativeDeviceAty, "this$0");
        castByNativeDeviceAty.o3();
    }

    public static final void b3(CastByNativeDeviceAty castByNativeDeviceAty) {
        i.g(castByNativeDeviceAty, "this$0");
        int i10 = R$id.mTvErrorHint;
        ((TextView) castByNativeDeviceAty.Z2(i10)).setVisibility(0);
        ((TextView) castByNativeDeviceAty.Z2(i10)).setText(castByNativeDeviceAty.getString(R.string.cast_connection_failed));
    }

    public static final void c3(CastByNativeDeviceAty castByNativeDeviceAty, List list) {
        i.g(castByNativeDeviceAty, "this$0");
        castByNativeDeviceAty.l3(list);
    }

    public static final void e3(CastByNativeDeviceAty castByNativeDeviceAty, View view) {
        i.g(castByNativeDeviceAty, "this$0");
        Context Q1 = castByNativeDeviceAty.Q1();
        StringBuilder sb = new StringBuilder();
        sb.append(b0.x(m7.c.g()));
        sb.append("/#/app-help?isFree=false&appId=");
        sb.append(na.a.g());
        sb.append("&userId=");
        i.c cVar = w6.i.f19214g;
        sb.append(cVar.H());
        sb.append("&lang=");
        sb.append(f0.a());
        sb.append("&appVersion=");
        sb.append(na.a.b());
        sb.append("&timestamp=");
        sb.append(new Date().getTime());
        sb.append("&portalCode=");
        sb.append(cVar.v());
        b0.j0(Q1, sb.toString(), false, true, false, false, 24, null);
    }

    public static final void g3(CastByNativeDeviceAty castByNativeDeviceAty, View view) {
        t9.i.g(castByNativeDeviceAty, "this$0");
        castByNativeDeviceAty.finish();
    }

    public static final void h3(View view) {
    }

    public static final void j3(CastByNativeDeviceAty castByNativeDeviceAty) {
        t9.i.g(castByNativeDeviceAty, "this$0");
        castByNativeDeviceAty.o3();
    }

    public static final void k3(CastByNativeDeviceAty castByNativeDeviceAty) {
        t9.i.g(castByNativeDeviceAty, "this$0");
        castByNativeDeviceAty.n3();
    }

    @Override // com.mobile.brasiltv.utils.g.a
    public void G0(boolean z10) {
        if (!z10) {
            runOnUiThread(new Runnable() { // from class: f5.q
                @Override // java.lang.Runnable
                public final void run() {
                    CastByNativeDeviceAty.b3(CastByNativeDeviceAty.this);
                }
            });
            return;
        }
        h hVar = h.f8694a;
        hVar.w(hVar.k());
        if (t9.i.b(this.f7820k, "LIVE") || t9.i.b(this.f7820k, "VOD")) {
            xa.c.c().j(new CastToPlayEvent(this.f7820k));
        }
        runOnUiThread(new Runnable() { // from class: f5.p
            @Override // java.lang.Runnable
            public final void run() {
                CastByNativeDeviceAty.a3(CastByNativeDeviceAty.this);
            }
        });
        finish();
    }

    public View Z2(int i10) {
        Map map = this.f7822m;
        View view = (View) map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    @Override // com.mobile.brasiltv.utils.g.a
    public void d1(final List list) {
        if (list != null) {
            runOnUiThread(new Runnable() { // from class: f5.l
                @Override // java.lang.Runnable
                public final void run() {
                    CastByNativeDeviceAty.c3(CastByNativeDeviceAty.this, list);
                }
            });
        }
    }

    public final void d3() {
        this.f7821l.f(new a());
        ((TextView) Z2(R$id.mTvHelp)).setOnClickListener(new View.OnClickListener() { // from class: f5.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CastByNativeDeviceAty.e3(CastByNativeDeviceAty.this, view);
            }
        });
    }

    @Override // f5.c, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        t9.i.g(motionEvent, "ev");
        int i10 = R$id.mTvErrorHint;
        if (((TextView) Z2(i10)).getVisibility() != 0) {
            return super.dispatchTouchEvent(motionEvent);
        }
        ((TextView) Z2(i10)).setVisibility(8);
        return true;
    }

    public final void f3() {
        int i10 = R$id.title_view;
        ((TitleView) Z2(i10)).setLayoutBackground(R.color.color_191a23);
        ((TitleView) Z2(i10)).setAtyBackVisible(8);
        ((TitleView) Z2(i10)).setXVisible(0);
        ((TitleView) Z2(i10)).getSettingView().setVisibility(8);
        ((TitleView) Z2(i10)).getIvMenuView().setVisibility(0);
        ((TitleView) Z2(i10)).setIvMenuSrc(R.drawable.anim_cast_refresh);
        ((TitleView) Z2(i10)).getTvMenuView().setVisibility(8);
        x.f8754a.w(Q1(), new b());
        ((TitleView) Z2(i10)).setXClickListener(new View.OnClickListener() { // from class: f5.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CastByNativeDeviceAty.g3(CastByNativeDeviceAty.this, view);
            }
        });
        ((TitleView) Z2(i10)).setIvMenuClickListener(new View.OnClickListener() { // from class: f5.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CastByNativeDeviceAty.h3(view);
            }
        });
    }

    public final void i3() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, 1, false);
        int i10 = R$id.mRvDevice;
        ((RecyclerView) Z2(i10)).setLayoutManager(linearLayoutManager);
        ((RecyclerView) Z2(i10)).setAdapter(this.f7821l);
        ((RecyclerView) Z2(i10)).addItemDecoration(new VerticalItemDecoration(this, 0, 65));
        ((RecyclerView) Z2(i10)).setScrollbarFadingEnabled(false);
    }

    @Override // i5.a
    public void k2() {
        n2();
    }

    public final void l3(List list) {
        ((RecyclerView) Z2(R$id.mRvDevice)).setVisibility(0);
        int i10 = R$id.mTvNotFoundDLNA;
        ((TextView) Z2(i10)).setVisibility(8);
        ((TextView) Z2(i10)).setOnClickListener(null);
        this.f7821l.b(list);
    }

    public final void m3() {
        g.f8651a.F();
    }

    public final void n3() {
        Drawable drawable = ((TitleView) Z2(R$id.title_view)).getIvMenuView().getDrawable();
        t9.i.e(drawable, "null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
        ((AnimationDrawable) drawable).start();
    }

    public final void o3() {
        Drawable drawable = ((TitleView) Z2(R$id.title_view)).getIvMenuView().getDrawable();
        t9.i.e(drawable, "null cannot be cast to non-null type android.graphics.drawable.AnimationDrawable");
        ((AnimationDrawable) drawable).stop();
    }

    @Override // f5.c, i5.a, u8.a, androidx.appcompat.app.d, androidx.fragment.app.e, androidx.activity.ComponentActivity, o.p, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.aty_cast_device);
        String stringExtra = getIntent().getStringExtra("from_type");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.f7820k = stringExtra;
        f3();
        i3();
        d3();
        h.f8694a.x(false);
        g.f8651a.i();
    }

    @Override // f5.c, u8.a, androidx.appcompat.app.d, androidx.fragment.app.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // f5.c, u8.a, androidx.fragment.app.e, android.app.Activity
    public void onPause() {
        super.onPause();
        runOnUiThread(new Runnable() { // from class: f5.m
            @Override // java.lang.Runnable
            public final void run() {
                CastByNativeDeviceAty.j3(CastByNativeDeviceAty.this);
            }
        });
        g gVar = g.f8651a;
        gVar.H();
        gVar.v(null);
    }

    @Override // f5.c, u8.a, androidx.fragment.app.e, android.app.Activity
    public void onResume() {
        super.onResume();
        runOnUiThread(new Runnable() { // from class: f5.n
            @Override // java.lang.Runnable
            public final void run() {
                CastByNativeDeviceAty.k3(CastByNativeDeviceAty.this);
            }
        });
        m3();
        g.f8651a.v(this);
    }
}
