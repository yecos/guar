package com.mobile.brasiltv.view.dialog;

import android.content.Context;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.msandroid.mobile.R;

/* loaded from: classes3.dex */
public final class OkDialog extends ConfirmDialog {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OkDialog(Context context, String str) {
        super(context, str);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(str, "content");
    }

    @Override // com.mobile.brasiltv.view.dialog.ConfirmDialog, com.mobile.brasiltv.view.dialog.CommonDialog
    public void initView() {
        super.initView();
        ((TextView) findViewById(R$id.mTvConfirm)).setText(getContext().getResources().getString(R.string.common_ok));
    }
}
