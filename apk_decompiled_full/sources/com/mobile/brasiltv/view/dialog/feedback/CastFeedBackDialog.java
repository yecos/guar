package com.mobile.brasiltv.view.dialog.feedback;

import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.view.dialog.CommonDialog;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoFrameLayout;
import h9.h;
import org.android.agoo.message.MessageService;
import t9.i;

/* loaded from: classes3.dex */
public final class CastFeedBackDialog extends CommonDialog implements View.OnClickListener, IFeedbackView {
    private final h9.g feedbackHodler$delegate;
    private final h9.g serviceHolder$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CastFeedBackDialog(Context context) {
        super(context, 0, 2, null);
        i.g(context, com.umeng.analytics.pro.f.X);
        this.feedbackHodler$delegate = h.b(new CastFeedBackDialog$feedbackHodler$2(this));
        this.serviceHolder$delegate = h.b(new CastFeedBackDialog$serviceHolder$2(this));
    }

    private final void hiedSoft() {
        Context context = getContext();
        Object systemService = context != null ? context.getSystemService("input_method") : null;
        i.e(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(((AutoFrameLayout) findViewById(R$id.flFeedback)).getWindowToken(), 2);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        super.cancel();
        hiedSoft();
        getFeedbackHodler().dialogCancel();
        getServiceHolder().dialogCancel();
    }

    @Override // com.mobile.brasiltv.view.dialog.feedback.IFeedbackView
    public void editActionDone() {
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public int getDialogHeight() {
        return 820;
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public int getDialogWidth() {
        return -1;
    }

    public final CastFeedBackHolder getFeedbackHodler() {
        return (CastFeedBackHolder) this.feedbackHodler$delegate.getValue();
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public int getGravity() {
        return 80;
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public int getLayoutId() {
        return R.layout.dialog_cast_feedback;
    }

    public final ServiceHolder getServiceHolder() {
        return (ServiceHolder) this.serviceHolder$delegate.getValue();
    }

    @Override // com.mobile.brasiltv.view.dialog.feedback.IFeedbackView
    /* renamed from: getType */
    public String mo65getType() {
        return MessageService.MSG_ACCS_NOTIFY_CLICK;
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public void initListener() {
        ((AutoFrameLayout) findViewById(R$id.flFeedback)).setOnClickListener(this);
        ((AutoFrameLayout) findViewById(R$id.flService)).setOnClickListener(this);
        ((ImageView) findViewById(R$id.ivClose)).setOnClickListener(this);
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public void initView() {
        Window window = getWindow();
        if (window != null) {
            window.setDimAmount(0.0f);
        }
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        swichItem(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        i.g(view, "v");
        switch (view.getId()) {
            case R.id.flFeedback /* 2131362071 */:
                swichItem(0);
                break;
            case R.id.flService /* 2131362072 */:
                hiedSoft();
                swichItem(1);
                break;
            case R.id.ivClose /* 2131362126 */:
                dismiss();
                break;
        }
    }

    @Override // com.mobile.brasiltv.view.dialog.feedback.IFeedbackView
    public void showLoading(boolean z10) {
    }

    @Override // com.mobile.brasiltv.view.dialog.feedback.IFeedbackView
    public void submitBntEnable(boolean z10) {
    }

    @Override // com.mobile.brasiltv.view.dialog.feedback.IFeedbackView
    public void submitSuc() {
        String str;
        dismiss();
        f1.a aVar = f1.f8649a;
        Context context = getContext();
        Context context2 = getContext();
        if (context2 == null || (str = context2.getString(R.string.thanks_feedback)) == null) {
            str = "";
        }
        aVar.k(context, str, 1);
    }

    public final void swichItem(int i10) {
        int i11 = R$id.flFeedback;
        ((AutoFrameLayout) findViewById(i11)).setSelected(i10 == 0);
        int i12 = R$id.flService;
        ((AutoFrameLayout) findViewById(i12)).setSelected(i10 == 1);
        showLoading(false);
        getFeedbackHodler().show(((AutoFrameLayout) findViewById(i11)).isSelected());
        getServiceHolder().show(((AutoFrameLayout) findViewById(i12)).isSelected());
    }
}
