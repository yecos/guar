package com.mobile.brasiltv.view.dialog.feedback;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.view.dialog.CommonDialog;
import com.msandroid.mobile.R;
import com.titans.entity.CdnType;
import com.zhy.autolayout.AutoFrameLayout;
import h9.h;
import t9.i;

/* loaded from: classes3.dex */
public final class FeedBackFullScreenDialog extends CommonDialog implements View.OnClickListener, IFeedbackView {
    public static final Companion Companion = new Companion(null);
    public static final int LIVE_TYPE = 2;
    public static final int VOD_TYPE = 1;
    private final h9.g contentHolder$delegate;
    private Context ctx;
    private final h9.g feedbackHodler$delegate;
    private boolean isFullScreen;
    private final h9.g serviceHolder$delegate;
    private int type;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(t9.g gVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedBackFullScreenDialog(Context context, boolean z10, int i10, String str) {
        super(context, 0, 2, null);
        i.g(context, "ctx");
        i.g(str, "name");
        this.ctx = context;
        this.isFullScreen = z10;
        this.type = i10;
        this.feedbackHodler$delegate = h.b(new FeedBackFullScreenDialog$feedbackHodler$2(str, this));
        this.contentHolder$delegate = h.b(new FeedBackFullScreenDialog$contentHolder$2(str, this));
        this.serviceHolder$delegate = h.b(new FeedBackFullScreenDialog$serviceHolder$2(this));
    }

    private final void hiedSoft() {
        Context context = getContext();
        Object systemService = context != null ? context.getSystemService("input_method") : null;
        i.e(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(((AutoFrameLayout) findViewById(R$id.flFeedback)).getWindowToken(), 2);
        Window window = getWindow();
        fullScreenImmersive(window != null ? window.getDecorView() : null);
        Context context2 = this.ctx;
        if (context2 instanceof Activity) {
            i.e(context2, "null cannot be cast to non-null type android.app.Activity");
            hideBottomUI((Activity) context2);
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        super.cancel();
        hiedSoft();
        getFeedbackHodler().dialogCancel();
        getContentHolder().dialogCancel();
        getServiceHolder().dialogCancel();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        Context context = this.ctx;
        if (context instanceof Activity) {
            i.e(context, "null cannot be cast to non-null type android.app.Activity");
            hideBottomUI((Activity) context);
        }
    }

    @Override // com.mobile.brasiltv.view.dialog.feedback.IFeedbackView
    public void editActionDone() {
        Window window = getWindow();
        fullScreenImmersive(window != null ? window.getDecorView() : null);
        Context context = this.ctx;
        if (context instanceof Activity) {
            i.e(context, "null cannot be cast to non-null type android.app.Activity");
            hideBottomUI((Activity) context);
        }
    }

    public final ContentHolder getContentHolder() {
        return (ContentHolder) this.contentHolder$delegate.getValue();
    }

    public final Context getCtx() {
        return this.ctx;
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public int getDialogHeight() {
        return -1;
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public int getDialogWidth() {
        return -1;
    }

    public final FeedbackHolder getFeedbackHodler() {
        return (FeedbackHolder) this.feedbackHodler$delegate.getValue();
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public int getGravity() {
        return 17;
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public int getLayoutId() {
        return R.layout.dialog_feedback_full_screen;
    }

    public final ServiceHolder getServiceHolder() {
        return (ServiceHolder) this.serviceHolder$delegate.getValue();
    }

    public final int getType() {
        return this.type;
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public void initListener() {
        ((TextView) findViewById(R$id.tvClose)).setOnClickListener(this);
        ((TextView) findViewById(R$id.tvSubmit)).setOnClickListener(this);
        ((AutoFrameLayout) findViewById(R$id.flFeedback)).setOnClickListener(this);
        ((AutoFrameLayout) findViewById(R$id.flContent)).setOnClickListener(this);
        ((AutoFrameLayout) findViewById(R$id.flService)).setOnClickListener(this);
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public void initView() {
        Window window = getWindow();
        if (window != null) {
            window.setDimAmount(0.0f);
        }
        Window window2 = getWindow();
        if (window2 != null) {
            window2.addFlags(1024);
        }
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        swichItem(0);
    }

    public final boolean isFullScreen() {
        return this.isFullScreen;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        super.onBackPressed();
        Window window = getWindow();
        fullScreenImmersive(window != null ? window.getDecorView() : null);
        Context context = this.ctx;
        if (context instanceof Activity) {
            i.e(context, "null cannot be cast to non-null type android.app.Activity");
            hideBottomUI((Activity) context);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        i.g(view, "v");
        int id = view.getId();
        if (id == R.id.tvClose) {
            dismiss();
        }
        if (id == R.id.tvSubmit) {
            getContentHolder().clickSubmit();
            getFeedbackHodler().clickSubmit();
            return;
        }
        switch (id) {
            case R.id.flContent /* 2131362070 */:
                swichItem(1);
                hiedSoft();
                break;
            case R.id.flFeedback /* 2131362071 */:
                hiedSoft();
                swichItem(0);
                break;
            case R.id.flService /* 2131362072 */:
                swichItem(2);
                hiedSoft();
                break;
        }
    }

    public final void setCtx(Context context) {
        i.g(context, "<set-?>");
        this.ctx = context;
    }

    public final void setFullScreen(boolean z10) {
        this.isFullScreen = z10;
    }

    public final void setType(int i10) {
        this.type = i10;
    }

    @Override // com.mobile.brasiltv.view.dialog.feedback.IFeedbackView
    public void showLoading(boolean z10) {
        ((FrameLayout) findViewById(R$id.loading)).setVisibility(z10 ? 0 : 8);
    }

    @Override // com.mobile.brasiltv.view.dialog.feedback.IFeedbackView
    public void submitBntEnable(boolean z10) {
        ((TextView) findViewById(R$id.tvSubmit)).setEnabled(z10);
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

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public boolean supportFSImmersive() {
        return true;
    }

    public final void swichItem(int i10) {
        int i11 = R$id.flFeedback;
        ((AutoFrameLayout) findViewById(i11)).setSelected(i10 == 0);
        int i12 = R$id.flContent;
        ((AutoFrameLayout) findViewById(i12)).setSelected(i10 == 1);
        int i13 = R$id.flService;
        ((AutoFrameLayout) findViewById(i13)).setSelected(i10 == 2);
        showLoading(false);
        getFeedbackHodler().show(((AutoFrameLayout) findViewById(i11)).isSelected());
        getContentHolder().show(((AutoFrameLayout) findViewById(i12)).isSelected());
        getServiceHolder().show(((AutoFrameLayout) findViewById(i13)).isSelected());
        if (i10 == 2) {
            ((TextView) findViewById(R$id.tvSubmit)).setVisibility(8);
        } else {
            ((TextView) findViewById(R$id.tvSubmit)).setVisibility(0);
        }
    }

    @Override // com.mobile.brasiltv.view.dialog.feedback.IFeedbackView
    /* renamed from: getType */
    public String mo65getType() {
        return this.type == 1 ? CdnType.DIGITAL_TYPE_PEERSTAR : "7";
    }
}
