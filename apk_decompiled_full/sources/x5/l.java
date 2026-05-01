package x5;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.hpplay.sdk.source.common.global.Constant;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.business.message.inapp.bean.InAppMsg;
import com.mobile.brasiltv.mine.activity.OrderAty;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.view.AutoCardView;
import com.msandroid.mobile.R;
import com.zhy.autolayout.utils.AutoUtils;

/* loaded from: classes3.dex */
public final class l extends g {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(Context context, InAppMsg inAppMsg) {
        super(context, inAppMsg);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(inAppMsg, Constant.KEY_MSG);
    }

    public static final void c(l lVar, View view) {
        t9.i.g(lVar, "this$0");
        Context mContext = lVar.getMContext();
        t9.i.e(mContext, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
        b0.c0((f5.c) mContext, OrderAty.class);
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public int getDialogHeight() {
        return -2;
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public int getDialogWidth() {
        return 600;
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public int getLayoutId() {
        return R.layout.dialog_inapp_msg_service_effect;
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public void initListener() {
        ((TextView) findViewById(R$id.mTvConfirm)).setOnClickListener(new View.OnClickListener() { // from class: x5.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                l.c(l.this, view);
            }
        });
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public void initView() {
        ((AutoCardView) findViewById(R$id.mAcvRoot)).setRadius(AutoUtils.getPercentWidthSize(28));
        ((TextView) findViewById(R$id.mTvTitle)).setText(a().getTitle());
        ((TextView) findViewById(R$id.mTvContent)).setText(a().getText());
        ((TextView) findViewById(R$id.mTvConfirm)).setText(getContext().getString(R.string.msg_inapp_go_check));
    }
}
