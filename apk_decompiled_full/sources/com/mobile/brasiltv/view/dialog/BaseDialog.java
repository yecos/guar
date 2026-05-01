package com.mobile.brasiltv.view.dialog;

import android.content.Context;
import android.os.Bundle;
import com.msandroid.mobile.R;

/* loaded from: classes3.dex */
public abstract class BaseDialog extends androidx.appcompat.app.c {
    public BaseDialog(Context context) {
        super(context, R.style.loadDialogTheme);
    }

    @Override // androidx.appcompat.app.c, androidx.appcompat.app.j, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }
}
