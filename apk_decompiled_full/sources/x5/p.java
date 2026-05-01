package x5;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.hpplay.sdk.source.common.global.Constant;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.app.App;
import com.mobile.brasiltv.business.message.inapp.bean.InAppMsg;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.view.AutoCardView;
import com.msandroid.mobile.R;
import com.zhy.autolayout.utils.AutoUtils;

/* loaded from: classes3.dex */
public final class p extends f {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(Context context, InAppMsg inAppMsg) {
        super(context, inAppMsg);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(inAppMsg, Constant.KEY_MSG);
    }

    public static final void i(p pVar, View view) {
        t9.i.g(pVar, "this$0");
        pVar.dismiss();
    }

    public static final void j(p pVar, View view) {
        t9.i.g(pVar, "this$0");
        Context mContext = pVar.getMContext();
        t9.i.e(mContext, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
        b0.E((f5.c) mContext);
    }

    public static final void k(p pVar, View view) {
        t9.i.g(pVar, "this$0");
        u5.a.f19061a.b(App.f8263e.a(), "dont_remind", Boolean.TRUE);
        w5.m.f19178a.n();
        pVar.dismiss();
    }

    @Override // x5.f, com.mobile.brasiltv.view.dialog.CommonDialog
    public int getLayoutId() {
        return R.layout.dialog_inapp_msg_withdraw;
    }

    @Override // x5.f, com.mobile.brasiltv.view.dialog.CommonDialog
    public void initListener() {
        ((TextView) findViewById(R$id.mTvCancel)).setOnClickListener(new View.OnClickListener() { // from class: x5.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                p.i(p.this, view);
            }
        });
        ((TextView) findViewById(R$id.mTvConfirm)).setOnClickListener(new View.OnClickListener() { // from class: x5.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                p.j(p.this, view);
            }
        });
        ((TextView) findViewById(R$id.mTvDontRemind)).setOnClickListener(new View.OnClickListener() { // from class: x5.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                p.k(p.this, view);
            }
        });
    }

    @Override // x5.f, com.mobile.brasiltv.view.dialog.CommonDialog
    public void initView() {
        ((AutoCardView) findViewById(R$id.mAcvRoot)).setRadius(AutoUtils.getPercentWidthSize(28));
        ((TextView) findViewById(R$id.mTvTitle)).setText(getContext().getString(R.string.msg_inapp_withdraw_title));
        ((TextView) findViewById(R$id.mTvContent)).setText(getContext().getString(R.string.msg_inapp_withdraw_content, String.valueOf(b0.X(a().getAvaliableCoin()))));
        ((TextView) findViewById(R$id.mTvCancel)).setText(getContext().getString(R.string.msg_inapp_cancal));
        ((TextView) findViewById(R$id.mTvConfirm)).setText(getContext().getString(R.string.msg_inapp_go_withdraw));
        int i10 = R$id.mTvDontRemind;
        ((TextView) findViewById(i10)).setText(getContext().getString(R.string.msg_inapp_dont_remind));
        ((TextView) findViewById(i10)).getPaint().setFlags(8);
        ((TextView) findViewById(i10)).getPaint().setAntiAlias(true);
    }

    @Override // x5.g, com.mobile.brasiltv.view.dialog.CommonDialog, android.app.Dialog
    public void show() {
        super.show();
        w5.m mVar = w5.m.f19178a;
        mVar.Y(true);
        mVar.n();
    }
}
