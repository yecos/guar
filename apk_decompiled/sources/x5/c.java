package x5;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.hpplay.sdk.source.common.global.Constant;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.business.message.inapp.bean.InAppMsg;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.msandroid.mobile.R;

/* loaded from: classes3.dex */
public final class c extends f {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(Context context, InAppMsg inAppMsg) {
        super(context, inAppMsg);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(inAppMsg, Constant.KEY_MSG);
    }

    public static final void h(c cVar, View view) {
        t9.i.g(cVar, "this$0");
        cVar.dismiss();
    }

    public static final void i(c cVar, View view) {
        t9.i.g(cVar, "this$0");
        String url = cVar.a().getUrl();
        if (!(url == null || url.length() == 0)) {
            b0.j0(cVar.getMContext(), cVar.a().getUrl(), false, true, false, false, 24, null);
        } else {
            if (d6.b.f12660a.y()) {
                f1.a.j(f1.f8649a, cVar.getContext(), R.string.vod_please_bind, 0, 4, null);
                return;
            }
            Context mContext = cVar.getMContext();
            t9.i.e(mContext, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
            b0.C((f5.c) mContext);
        }
    }

    @Override // x5.f, com.mobile.brasiltv.view.dialog.CommonDialog
    public void initListener() {
        ((TextView) findViewById(R$id.mTvCancel)).setOnClickListener(new View.OnClickListener() { // from class: x5.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.h(c.this, view);
            }
        });
        ((TextView) findViewById(R$id.mTvConfirm)).setOnClickListener(new View.OnClickListener() { // from class: x5.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.i(c.this, view);
            }
        });
    }
}
