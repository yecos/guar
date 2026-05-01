package com.mobile.brasiltv.view.dialog.feedback;

import android.content.Context;

/* loaded from: classes3.dex */
public interface IFeedbackView {
    void editActionDone();

    Context getContext();

    /* renamed from: getType */
    String mo65getType();

    void showLoading(boolean z10);

    void submitBntEnable(boolean z10);

    void submitSuc();
}
