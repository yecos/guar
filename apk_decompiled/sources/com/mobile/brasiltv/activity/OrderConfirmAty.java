package com.mobile.brasiltv.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.OrderConfirmAty;
import com.mobile.brasiltv.mine.activity.OrderAty;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f0;
import com.mobile.brasiltv.utils.i1;
import com.mobile.brasiltv.view.TitleView;
import com.msandroid.mobile.R;
import f5.c;
import h9.g;
import h9.h;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import t9.i;
import t9.j;
import t9.z;
import w6.i;

/* loaded from: classes3.dex */
public final class OrderConfirmAty extends c {

    /* renamed from: m, reason: collision with root package name */
    public static final a f7966m = new a(null);

    /* renamed from: n, reason: collision with root package name */
    public static final String f7967n = "bundlePaymentType";

    /* renamed from: l, reason: collision with root package name */
    public Map f7969l = new LinkedHashMap();

    /* renamed from: k, reason: collision with root package name */
    public final g f7968k = h.b(new b());

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(t9.g gVar) {
            this();
        }

        public final String a() {
            return OrderConfirmAty.f7967n;
        }
    }

    public static final class b extends j implements s9.a {
        public b() {
            super(0);
        }

        @Override // s9.a
        public final String invoke() {
            return OrderConfirmAty.this.getIntent().getStringExtra(OrderConfirmAty.f7966m.a());
        }
    }

    public static final void X2(OrderConfirmAty orderConfirmAty, View view) {
        i.g(orderConfirmAty, "this$0");
        b0.c0(orderConfirmAty, OrderAty.class);
        orderConfirmAty.finish();
    }

    public static final void Y2(OrderConfirmAty orderConfirmAty, View view) {
        i.g(orderConfirmAty, "this$0");
        b0.c0(orderConfirmAty, OrderAty.class);
        orderConfirmAty.finish();
    }

    public View T2(int i10) {
        Map map = this.f7969l;
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

    public final String V2() {
        return (String) this.f7968k.getValue();
    }

    public final void W2() {
        int i10 = R$id.mTitleView;
        ((TitleView) T2(i10)).setXVisible(0);
        TextView textView = (TextView) T2(R$id.mTvPaymentTip);
        z zVar = z.f18964a;
        String string = Q1().getString(R.string.order_confirm_title);
        i.f(string, "context.getString(R.string.order_confirm_title)");
        String format = String.format(string, Arrays.copyOf(new Object[]{V2()}, 1));
        i.f(format, "format(format, *args)");
        textView.setText(format);
        int i11 = R$id.mTvHelp;
        ((TextView) T2(i11)).setPaintFlags(8);
        ((TextView) T2(i11)).getPaint().setAntiAlias(true);
        ((TitleView) T2(i10)).setXClickListener(new View.OnClickListener() { // from class: f5.k2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OrderConfirmAty.X2(OrderConfirmAty.this, view);
            }
        });
        ((TitleView) T2(i10)).setOnBackClickListener(new View.OnClickListener() { // from class: f5.l2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OrderConfirmAty.Y2(OrderConfirmAty.this, view);
            }
        });
        ((TextView) T2(i11)).setOnClickListener(this);
        ((Button) T2(R$id.mBtnPaid)).setOnClickListener(this);
        ((Button) T2(R$id.mBtnPreparing)).setOnClickListener(this);
        ((Button) T2(R$id.mBtnRepay)).setOnClickListener(this);
        ((Button) T2(R$id.mBtnCancel)).setOnClickListener(this);
    }

    @Override // f5.c, android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        i.g(view, "view");
        int id = view.getId();
        if (id == R.id.mBtnCancel) {
            b0.c0(this, MainAty.class);
            finish();
            str = "Cancel";
        } else if (id != R.id.mTvHelp) {
            switch (id) {
                case R.id.mBtnPaid /* 2131362237 */:
                    b0.c0(this, OrderAty.class);
                    finish();
                    str = "Paid";
                    break;
                case R.id.mBtnPreparing /* 2131362238 */:
                    b0.c0(this, OrderAty.class);
                    finish();
                    str = "Preparing";
                    break;
                case R.id.mBtnRepay /* 2131362239 */:
                    i.c cVar = w6.i.f19214g;
                    if (cVar.g().length() > 0) {
                        b0.j0(Q1(), cVar.g(), false, true, false, false, 24, null);
                    }
                    b0.U(this, "beVipUrl:" + cVar.g());
                    finish();
                    str = "Unpaid";
                    break;
                default:
                    str = "";
                    break;
            }
        } else {
            i.c cVar2 = w6.i.f19214g;
            boolean b10 = t9.i.b(cVar2.e(), "0");
            b0.j0(Q1(), b0.x(m7.c.g()) + "/#/app-help?isFree=" + b10 + "&appId=" + na.a.g() + "&userId=" + cVar2.H() + "&lang=" + f0.a() + "&appVersion=" + na.a.b() + "&timestamp=" + new Date().getTime() + "&portalCode=" + cVar2.v(), false, true, false, false, 24, null);
            str = "Help";
        }
        i1.C(this, str);
    }

    @Override // f5.c, i5.a, u8.a, androidx.appcompat.app.d, androidx.fragment.app.e, androidx.activity.ComponentActivity, o.p, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.aty_order_comfirm);
        W2();
    }
}
