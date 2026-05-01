package x5;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.hpplay.sdk.source.common.global.Constant;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.business.message.inapp.bean.InAppMsg;
import com.mobile.brasiltv.mine.activity.OrderAty;
import com.mobile.brasiltv.utils.b0;

/* loaded from: classes3.dex */
public final class j extends f {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(Context context, InAppMsg inAppMsg) {
        super(context, inAppMsg);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(inAppMsg, Constant.KEY_MSG);
    }

    public static final void h(j jVar, View view) {
        t9.i.g(jVar, "this$0");
        jVar.dismiss();
    }

    public static final void i(j jVar, View view) {
        t9.i.g(jVar, "this$0");
        Context mContext = jVar.getMContext();
        t9.i.e(mContext, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
        b0.c0((f5.c) mContext, OrderAty.class);
    }

    @Override // x5.f, com.mobile.brasiltv.view.dialog.CommonDialog
    public void initListener() {
        ((TextView) findViewById(R$id.mTvCancel)).setOnClickListener(new View.OnClickListener() { // from class: x5.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                j.h(j.this, view);
            }
        });
        ((TextView) findViewById(R$id.mTvConfirm)).setOnClickListener(new View.OnClickListener() { // from class: x5.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                j.i(j.this, view);
            }
        });
    }
}
