package com.mobile.brasiltv.bean;

import android.content.Context;
import android.view.View;
import com.mobile.brasiltv.view.dialog.GuideDialog;
import com.mobile.brasiltv.view.dialog.VodGestureGuideDialog;
import com.umeng.analytics.pro.f;
import t9.i;

/* loaded from: classes3.dex */
public final class VodGestureGuideManager extends BaseGuideManager {
    public VodGestureGuideManager(Context context) {
        super(context, null, "keyFirstPlayVOD", "", GuideDialog.Direction.TOP_RIGHT, null, false, false, null, 480, null);
    }

    @Override // com.mobile.brasiltv.bean.BaseGuideManager
    public void showGuideInner(Context context, View view) {
        i.g(context, f.X);
        VodGestureGuideDialog vodGestureGuideDialog = new VodGestureGuideDialog(context);
        vodGestureGuideDialog.setOnButtonClickListener(new VodGestureGuideManager$showGuideInner$1(this));
        vodGestureGuideDialog.show();
    }
}
