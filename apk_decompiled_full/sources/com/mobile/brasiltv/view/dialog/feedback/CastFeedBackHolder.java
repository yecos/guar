package com.mobile.brasiltv.view.dialog.feedback;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import ba.t;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.j1;
import com.msandroid.mobile.R;
import h9.h;
import mobile.com.requestframe.utils.response.BaseResult;
import t9.i;

/* loaded from: classes3.dex */
public final class CastFeedBackHolder extends BaseFeedbackHodler implements View.OnClickListener, TextWatcher {
    private final h9.g etDes$delegate;
    private final h9.g etEmail$delegate;
    private final h9.g mTvSubmit$delegate;
    private final h9.g tvError$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CastFeedBackHolder(View view, IFeedbackView iFeedbackView) {
        super(view, iFeedbackView);
        i.g(view, "content");
        i.g(iFeedbackView, "dialog");
        this.tvError$delegate = h.b(new CastFeedBackHolder$tvError$2(this));
        this.mTvSubmit$delegate = h.b(new CastFeedBackHolder$mTvSubmit$2(this));
        this.etDes$delegate = h.b(new CastFeedBackHolder$etDes$2(this));
        this.etEmail$delegate = h.b(new CastFeedBackHolder$etEmail$2(this));
        getMTvSubmit().setOnClickListener(this);
        getEtDes().addTextChangedListener(this);
        getEtEmail().addTextChangedListener(this);
        d6.b bVar = d6.b.f12660a;
        if (bVar.b()) {
            getEtEmail().setText(w6.i.f19214g.m());
            return;
        }
        String i10 = bVar.i(getHost().getContext());
        if (i10 != null) {
            getEtEmail().setText(i10);
        }
    }

    private final EditText getEtDes() {
        return (EditText) this.etDes$delegate.getValue();
    }

    private final EditText getEtEmail() {
        return (EditText) this.etEmail$delegate.getValue();
    }

    private final TextView getMTvSubmit() {
        return (TextView) this.mTvSubmit$delegate.getValue();
    }

    private final TextView getTvError() {
        return (TextView) this.tvError$delegate.getValue();
    }

    private final void submitFeedback(String str, String str2) {
        d6.b.f12660a.z(getHost().getContext(), str);
        w6.i.f19214g.b().r2(getHost().mo65getType(), "", str, null, null, str2).subscribe(new ha.a() { // from class: com.mobile.brasiltv.view.dialog.feedback.CastFeedBackHolder$submitFeedback$1
            @Override // ha.a, io.reactivex.Observer
            public void onNext(BaseResult baseResult) {
                i.g(baseResult, "t");
            }

            @Override // ha.a
            public void showErrorHint(String str3) {
                i.g(str3, "returnCode");
            }
        });
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }

    @Override // com.mobile.brasiltv.view.dialog.feedback.BaseFeedbackHodler
    public void clickSubmit() {
    }

    @Override // com.mobile.brasiltv.view.dialog.feedback.BaseFeedbackHodler
    public void dialogCancel() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String string;
        String string2;
        i.g(view, "v");
        if (i.b(view, getMTvSubmit())) {
            String obj = t.W(getEtEmail().getText().toString()).toString();
            String str = "";
            if (obj.length() == 0) {
                getTvError().setVisibility(0);
                TextView tvError = getTvError();
                Context context = getHost().getContext();
                if (context != null && (string2 = context.getString(R.string.email_empty)) != null) {
                    str = string2;
                }
                tvError.setText(str);
                return;
            }
            if (j1.i(obj)) {
                submitFeedback(obj, t.W(getEtDes().getText().toString()).toString());
                getHost().submitSuc();
                return;
            }
            getTvError().setVisibility(0);
            TextView tvError2 = getTvError();
            Context context2 = getHost().getContext();
            if (context2 != null && (string = context2.getString(R.string.email_incorrect)) != null) {
                str = string;
            }
            tvError2.setText(str);
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        getTvError().setVisibility(4);
        getMTvSubmit().setEnabled(b0.K(getEtDes().getText()) && b0.K(getEtEmail().getText()));
    }

    @Override // com.mobile.brasiltv.view.dialog.feedback.BaseFeedbackHodler
    public void show(boolean z10) {
        super.show(z10);
    }
}
