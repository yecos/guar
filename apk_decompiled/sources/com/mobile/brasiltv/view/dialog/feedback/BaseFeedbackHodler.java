package com.mobile.brasiltv.view.dialog.feedback;

import android.view.View;
import com.taobao.accs.common.Constants;
import t9.i;

/* loaded from: classes3.dex */
public abstract class BaseFeedbackHodler {
    private final View contentView;
    private final IFeedbackView host;

    public BaseFeedbackHodler(View view, IFeedbackView iFeedbackView) {
        i.g(view, "contentView");
        i.g(iFeedbackView, Constants.KEY_HOST);
        this.contentView = view;
        this.host = iFeedbackView;
    }

    public abstract void clickSubmit();

    public abstract void dialogCancel();

    public final <T extends View> T findViewById(int i10) {
        T t10 = (T) this.contentView.findViewById(i10);
        i.f(t10, "contentView.findViewById(id)");
        return t10;
    }

    public final View getContentView() {
        return this.contentView;
    }

    public final IFeedbackView getHost() {
        return this.host;
    }

    public void show(boolean z10) {
        this.contentView.setVisibility(z10 ? 0 : 8);
    }
}
