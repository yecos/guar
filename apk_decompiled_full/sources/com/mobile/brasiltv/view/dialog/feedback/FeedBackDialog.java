package com.mobile.brasiltv.view.dialog.feedback;

import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import ba.t;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.view.dialog.CommonDialog;
import com.msandroid.mobile.R;
import com.titans.entity.CdnType;
import com.zhy.autolayout.AutoFrameLayout;
import h9.h;
import java.util.ArrayList;
import java.util.List;
import mobile.com.requestframe.utils.response.GetEmailSuffix;
import mobile.com.requestframe.utils.response.GetEmailSuffixResult;
import t9.i;

/* loaded from: classes3.dex */
public final class FeedBackDialog extends CommonDialog implements View.OnClickListener, IFeedbackView {
    public static final int LIVE_TYPE = 2;
    public static final int VOD_TYPE = 1;
    private final h9.g contentHolder$delegate;
    private Context ctx;
    private final h9.g feedbackHodler$delegate;
    private final h9.g serviceHolder$delegate;
    private int type;
    public static final Companion Companion = new Companion(null);
    private static ArrayList<String> mEmailSuffixList = new ArrayList<>();

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(t9.g gVar) {
            this();
        }

        public final CommonDialog getFeedBackDialog(Context context, boolean z10, int i10, String str) {
            i.g(context, com.umeng.analytics.pro.f.X);
            i.g(str, "name");
            return z10 ? new FeedBackFullScreenDialog(context, z10, i10, str) : new FeedBackDialog(context, i10, str);
        }

        public final ArrayList<String> getMEmailSuffixList() {
            return FeedBackDialog.mEmailSuffixList;
        }

        public final void setMEmailSuffixList(ArrayList<String> arrayList) {
            i.g(arrayList, "<set-?>");
            FeedBackDialog.mEmailSuffixList = arrayList;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedBackDialog(Context context, int i10, String str) {
        super(context, 0, 2, null);
        i.g(context, "ctx");
        i.g(str, "name");
        this.ctx = context;
        this.type = i10;
        this.feedbackHodler$delegate = h.b(new FeedBackDialog$feedbackHodler$2(str, this));
        this.contentHolder$delegate = h.b(new FeedBackDialog$contentHolder$2(str, this));
        this.serviceHolder$delegate = h.b(new FeedBackDialog$serviceHolder$2(this));
    }

    private final void getEmailSuffixList(Context context) {
        w6.i.f19214g.b().q1().subscribe(new ha.a() { // from class: com.mobile.brasiltv.view.dialog.feedback.FeedBackDialog$getEmailSuffixList$1
            @Override // ha.a
            public void showErrorHint(String str) {
                i.g(str, "returnCode");
            }

            @Override // ha.a, io.reactivex.Observer
            public void onNext(GetEmailSuffixResult getEmailSuffixResult) {
                i.g(getEmailSuffixResult, "t");
                super.onNext((Object) getEmailSuffixResult);
                GetEmailSuffix data = getEmailSuffixResult.getData();
                if (b0.K(data != null ? data.getEmailSuffixStr() : null)) {
                    GetEmailSuffix data2 = getEmailSuffixResult.getData();
                    i.d(data2);
                    String emailSuffixStr = data2.getEmailSuffixStr();
                    i.d(emailSuffixStr);
                    FeedBackDialog.this.updateEmailSuffixList(t.M(emailSuffixStr, new String[]{","}, false, 0, 6, null));
                }
            }
        });
    }

    private final void hiedSoft() {
        Context context = getContext();
        Object systemService = context != null ? context.getSystemService("input_method") : null;
        i.e(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(((AutoFrameLayout) findViewById(R$id.flFeedback)).getWindowToken(), 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateEmailSuffixList(List<String> list) {
        mEmailSuffixList.clear();
        if (!list.isEmpty()) {
            mEmailSuffixList.addAll(list);
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

    @Override // com.mobile.brasiltv.view.dialog.feedback.IFeedbackView
    public void editActionDone() {
    }

    public final ContentHolder getContentHolder() {
        return (ContentHolder) this.contentHolder$delegate.getValue();
    }

    public final Context getCtx() {
        return this.ctx;
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public int getDialogHeight() {
        return 880;
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
        return 80;
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public int getLayoutId() {
        return R.layout.dialog_feedback;
    }

    public final ServiceHolder getServiceHolder() {
        return (ServiceHolder) this.serviceHolder$delegate.getValue();
    }

    public final int getType() {
        return this.type;
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public void initListener() {
        ((ImageView) findViewById(R$id.ivClose)).setOnClickListener(this);
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
        Context context = getContext();
        i.f(context, com.umeng.analytics.pro.f.X);
        getEmailSuffixList(context);
        swichItem(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        i.g(view, "v");
        int id = view.getId();
        if (id == R.id.ivClose) {
            dismiss();
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

    public final void setType(int i10) {
        this.type = i10;
    }

    @Override // com.mobile.brasiltv.view.dialog.feedback.IFeedbackView
    public void showLoading(boolean z10) {
        ((FrameLayout) findViewById(R$id.loading)).setVisibility(z10 ? 0 : 8);
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
        int i12 = R$id.flContent;
        ((AutoFrameLayout) findViewById(i12)).setSelected(i10 == 1);
        int i13 = R$id.flService;
        ((AutoFrameLayout) findViewById(i13)).setSelected(i10 == 2);
        showLoading(false);
        getFeedbackHodler().show(((AutoFrameLayout) findViewById(i11)).isSelected());
        getContentHolder().show(((AutoFrameLayout) findViewById(i12)).isSelected());
        getServiceHolder().show(((AutoFrameLayout) findViewById(i13)).isSelected());
    }

    @Override // com.mobile.brasiltv.view.dialog.feedback.IFeedbackView
    /* renamed from: getType, reason: collision with other method in class */
    public String mo65getType() {
        return this.type == 1 ? CdnType.DIGITAL_TYPE_PEERSTAR : "7";
    }
}
