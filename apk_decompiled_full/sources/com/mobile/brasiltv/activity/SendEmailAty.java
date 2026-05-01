package com.mobile.brasiltv.activity;

import android.os.Handler;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import ba.t;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.SendEmailAty;
import com.mobile.brasiltv.bean.event.ClosePageEvent;
import com.mobile.brasiltv.view.TitleView;
import com.msandroid.mobile.R;
import f5.d;
import i6.r0;
import java.util.LinkedHashMap;
import java.util.Map;
import k6.u3;
import t9.g;
import t9.i;
import w6.i;
import xa.c;

/* loaded from: classes3.dex */
public final class SendEmailAty extends d implements r0 {

    /* renamed from: s, reason: collision with root package name */
    public static final a f8113s = new a(null);

    /* renamed from: l, reason: collision with root package name */
    public long f8114l;

    /* renamed from: q, reason: collision with root package name */
    public u3 f8119q;

    /* renamed from: r, reason: collision with root package name */
    public Map f8120r = new LinkedHashMap();

    /* renamed from: m, reason: collision with root package name */
    public String f8115m = "";

    /* renamed from: n, reason: collision with root package name */
    public Handler f8116n = new Handler();

    /* renamed from: o, reason: collision with root package name */
    public Runnable f8117o = new Runnable() { // from class: f5.f4
        @Override // java.lang.Runnable
        public final void run() {
            SendEmailAty.h3(SendEmailAty.this);
        }
    };

    /* renamed from: p, reason: collision with root package name */
    public Runnable f8118p = new Runnable() { // from class: f5.g4
        @Override // java.lang.Runnable
        public final void run() {
            SendEmailAty.g3(SendEmailAty.this);
        }
    };

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    public static final class b extends ClickableSpan {
        public b() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            i.g(view, "widget");
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            i.g(textPaint, "ds");
            super.updateDrawState(textPaint);
            textPaint.setColor(SendEmailAty.this.getResources().getColor(R.color.color_important));
            textPaint.setUnderlineText(true);
        }
    }

    public static final void Z2(SendEmailAty sendEmailAty, boolean z10, View view) {
        i.g(sendEmailAty, "this$0");
        if (System.currentTimeMillis() - sendEmailAty.f8114l < 60000) {
            c3(sendEmailAty, 0, 1, null);
            return;
        }
        sendEmailAty.f8114l = System.currentTimeMillis();
        if (z10) {
            sendEmailAty.j3();
        } else {
            sendEmailAty.i3();
        }
    }

    public static /* synthetic */ void c3(SendEmailAty sendEmailAty, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = R.string.frequent_operation;
        }
        sendEmailAty.b3(i10);
    }

    public static final void f3(SendEmailAty sendEmailAty, View view) {
        i.g(sendEmailAty, "this$0");
        c.c().j(new ClosePageEvent());
        sendEmailAty.finish();
    }

    public static final void g3(SendEmailAty sendEmailAty) {
        i.g(sendEmailAty, "this$0");
        ((TextView) sendEmailAty.Y2(R$id.resendEmail)).setVisibility(4);
    }

    public static final void h3(SendEmailAty sendEmailAty) {
        i.g(sendEmailAty, "this$0");
        ((TextView) sendEmailAty.Y2(R$id.tryAgain)).setVisibility(4);
    }

    @Override // f5.d
    public void R2() {
        k3(new u3(this, this));
        e3();
        final boolean booleanExtra = getIntent().getBooleanExtra("reset_pwd", false);
        String stringExtra = getIntent().getStringExtra("send_email");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.f8115m = stringExtra;
        if (booleanExtra) {
            ((TextView) Y2(R$id.content)).setText(getResources().getString(R.string.forget_email_send, this.f8115m));
            TitleView titleView = (TitleView) Y2(R$id.titleView);
            String string = getString(R.string.forget_pwd_title);
            i.f(string, "getString(R.string.forget_pwd_title)");
            titleView.setTvTitleText(string);
        } else {
            i.c cVar = w6.i.f19214g;
            if (cVar.h().equals("1") || cVar.s().equals("1")) {
                ((TextView) Y2(R$id.content)).setText(getResources().getString(R.string.email_change_send_success));
                TitleView titleView2 = (TitleView) Y2(R$id.titleView);
                String string2 = getString(R.string.mailbox_binding);
                t9.i.f(string2, "getString(R.string.mailbox_binding)");
                titleView2.setTvTitleText(string2);
            } else {
                ((TextView) Y2(R$id.content)).setText(getResources().getString(R.string.email_send_success));
                TitleView titleView3 = (TitleView) Y2(R$id.titleView);
                String string3 = getString(R.string.mailbox_binding);
                t9.i.f(string3, "getString(R.string.mailbox_binding)");
                titleView3.setTvTitleText(string3);
            }
        }
        String string4 = getResources().getString(R.string.do_not_receive);
        t9.i.f(string4, "resources.getString(R.string.do_not_receive)");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(string4);
        spannableStringBuilder.setSpan(new b(), t.y(string4, ",", 0, false, 6, null) + 1, string4.length(), 33);
        int i10 = R$id.sendMsgBt;
        ((TextView) Y2(i10)).setText(spannableStringBuilder);
        ((TextView) Y2(i10)).setOnClickListener(new View.OnClickListener() { // from class: f5.h4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SendEmailAty.Z2(SendEmailAty.this, booleanExtra, view);
            }
        });
        this.f8114l = System.currentTimeMillis();
    }

    @Override // f5.d
    public int T2() {
        return R.layout.activity_sendemile;
    }

    public View Y2(int i10) {
        Map map = this.f8120r;
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

    public final void a3() {
        ((TextView) Y2(R$id.resendEmail)).setVisibility(0);
        this.f8116n.removeCallbacks(this.f8118p);
        this.f8116n.postDelayed(this.f8118p, 5000L);
    }

    public final void b3(int i10) {
        int i11 = R$id.tryAgain;
        ((TextView) Y2(i11)).setText(getResources().getString(i10));
        ((TextView) Y2(i11)).setVisibility(0);
        this.f8116n.removeCallbacks(this.f8117o);
        this.f8116n.postDelayed(this.f8117o, 5000L);
    }

    @Override // f5.d
    /* renamed from: d3, reason: merged with bridge method [inline-methods] */
    public u3 S2() {
        u3 u3Var = this.f8119q;
        if (u3Var != null) {
            return u3Var;
        }
        t9.i.w("mPresenter");
        return null;
    }

    public final void e3() {
        int i10 = R$id.titleView;
        ((TitleView) Y2(i10)).setLayoutBackground(R.color.color_191a23);
        ((TitleView) Y2(i10)).getSettingView().setVisibility(8);
        ((TitleView) Y2(i10)).getIvMenuView().setVisibility(8);
        ((TitleView) Y2(i10)).setIvMenuSrc(0);
        ((TitleView) Y2(i10)).getTvMenuView().setVisibility(8);
        ((TitleView) Y2(i10)).setTvMenuText("");
        ((TitleView) Y2(i10)).setXVisible(0);
        ((TitleView) Y2(i10)).setXClickListener(new View.OnClickListener() { // from class: f5.i4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SendEmailAty.f3(SendEmailAty.this, view);
            }
        });
    }

    @Override // i6.r0
    public void g2() {
        a3();
    }

    public final void i3() {
        S2().h(this.f8115m, w6.i.f19214g.h().equals("1") ? 2 : 1);
    }

    @Override // i6.r0
    public void j() {
        b3(R.string.email_been_linked);
    }

    public final void j3() {
        S2().k(this.f8115m);
    }

    @Override // i5.a
    public void k2() {
        n2();
    }

    public void k3(u3 u3Var) {
        t9.i.g(u3Var, "<set-?>");
        this.f8119q = u3Var;
    }

    @Override // f5.d, f5.c, u8.a, androidx.appcompat.app.d, androidx.fragment.app.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f8116n.removeCallbacks(this.f8117o);
        this.f8116n.removeCallbacks(this.f8118p);
    }

    @Override // i6.r0
    public void showLoading(boolean z10) {
        if (z10) {
            ((ProgressBar) Y2(R$id.mLoadingPbar)).setVisibility(0);
        } else {
            ((ProgressBar) Y2(R$id.mLoadingPbar)).setVisibility(8);
        }
    }
}
