package com.mobile.brasiltv.mine.activity;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.WebViewAty;
import com.mobile.brasiltv.mine.activity.AboutAty;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.x;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoRelativeLayout;
import f5.d;
import h9.t;
import java.util.LinkedHashMap;
import java.util.Map;
import s9.l;
import t9.i;
import t9.j;

/* loaded from: classes3.dex */
public final class AboutAty extends d implements i6.b {

    /* renamed from: l, reason: collision with root package name */
    public k6.a f8274l;

    /* renamed from: m, reason: collision with root package name */
    public Map f8275m = new LinkedHashMap();

    public static final class a extends j implements l {
        public a() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return t.f14242a;
        }

        public final void invoke(String str) {
            if (str == null || str.length() == 0) {
                ((AutoRelativeLayout) AboutAty.this.V2(R$id.aboutAtyServiceLayout)).setVisibility(8);
                return;
            }
            ((AutoRelativeLayout) AboutAty.this.V2(R$id.aboutAtyServiceLayout)).setVisibility(0);
            if (str.length() < 24) {
                ((TextView) AboutAty.this.V2(R$id.tvEmail)).setText(str);
                return;
            }
            int x10 = ba.t.x(str, '@', 0, false, 6, null);
            if (x10 == -1) {
                ((TextView) AboutAty.this.V2(R$id.tvEmail)).setText(str);
                return;
            }
            StringBuilder sb = new StringBuilder();
            String substring = str.substring(0, x10);
            i.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            sb.append(substring);
            sb.append('\n');
            String substring2 = str.substring(x10);
            i.f(substring2, "this as java.lang.String).substring(startIndex)");
            sb.append(substring2);
            ((TextView) AboutAty.this.V2(R$id.tvEmail)).setText(sb.toString());
        }
    }

    public static final class b extends j implements l {
        public b() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return t.f14242a;
        }

        public final void invoke(String str) {
            if (str == null || str.length() == 0) {
                ((AutoRelativeLayout) AboutAty.this.V2(R$id.rlWebsite)).setVisibility(8);
            } else {
                ((AutoRelativeLayout) AboutAty.this.V2(R$id.rlWebsite)).setVisibility(0);
                ((TextView) AboutAty.this.V2(R$id.tvWebsite)).setText(str);
            }
        }
    }

    public static final class c extends j implements l {

        /* renamed from: a, reason: collision with root package name */
        public static final c f8278a = new c();

        public c() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Intent invoke(Intent intent) {
            i.g(intent, "it");
            WebViewAty.a aVar = WebViewAty.B;
            intent.putExtra(aVar.j(), a6.c.a());
            Intent putExtra = intent.putExtra(aVar.a(), false);
            i.f(putExtra, "it.putExtra(WebViewAty.BUNDLE_BACK_TO_MAIN, false)");
            return putExtra;
        }
    }

    public static final void W2(AboutAty aboutAty, View view) {
        i.g(aboutAty, "this$0");
        b0.d0(aboutAty, WebViewAty.class, c.f8278a);
    }

    @Override // i6.b
    public void J(String str) {
        i.g(str, "version");
        ((TextView) V2(R$id.aboutAtyVersion)).setText(str);
    }

    @Override // f5.d
    public void R2() {
        Y2(new k6.a(this, this));
        ((AutoRelativeLayout) V2(R$id.rlWebsite)).setVisibility(8);
        ((AutoRelativeLayout) V2(R$id.aboutAtyServiceLayout)).setVisibility(8);
        x.f8754a.x(Q1(), new a(), new b());
        int i10 = R$id.mTvPrivaryPolicy;
        ((TextView) V2(i10)).getPaint().setFlags(8);
        ((TextView) V2(i10)).getPaint().setAntiAlias(true);
        ((TextView) V2(i10)).setOnClickListener(new View.OnClickListener() { // from class: e6.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AboutAty.W2(AboutAty.this, view);
            }
        });
    }

    @Override // f5.d
    public int T2() {
        return R.layout.aty_about;
    }

    public View V2(int i10) {
        Map map = this.f8275m;
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

    @Override // f5.d
    /* renamed from: X2, reason: merged with bridge method [inline-methods] */
    public k6.a S2() {
        k6.a aVar = this.f8274l;
        if (aVar != null) {
            return aVar;
        }
        i.w("mPresenter");
        return null;
    }

    public void Y2(k6.a aVar) {
        i.g(aVar, "<set-?>");
        this.f8274l = aVar;
    }

    @Override // m5.a
    /* renamed from: Z2, reason: merged with bridge method [inline-methods] */
    public void Y0(i6.a aVar) {
        i.g(aVar, "presenter");
    }

    @Override // i5.a
    public void k2() {
        n2();
    }
}
