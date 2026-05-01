package com.mobile.brasiltv.view.dialog.feedback;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ba.s;
import ba.t;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.j1;
import com.mobile.brasiltv.view.LinearLayoutManagerWrapper;
import com.mobile.brasiltv.view.dialog.feedback.FeedBackDialog;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoLinearLayout;
import g5.c;
import h9.h;
import java.util.ArrayList;
import mobile.com.requestframe.utils.response.BaseResult;
import t9.i;

/* loaded from: classes3.dex */
public final class ContentHolder extends BaseFeedbackHodler implements View.OnClickListener, TextWatcher {
    private final h9.g etContentTitle$delegate;
    private final h9.g etDes$delegate;
    private final h9.g etEmail$delegate;
    private final h9.g ivTitleEdit$delegate;
    private final h9.g mEmailAdapter$delegate;
    private boolean mIsShow;
    private final h9.g mIvContentClear$delegate;
    private final h9.g mLlRecyclerEmail$delegate;
    private final h9.g mRvCompleteList$delegate;
    private final h9.g mTvSubmit$delegate;
    private String name;
    private final h9.g tvContentTitle$delegate;
    private final h9.g tvError$delegate;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentHolder(String str, View view, IFeedbackView iFeedbackView) {
        super(view, iFeedbackView);
        i.g(str, "name");
        i.g(view, "content");
        i.g(iFeedbackView, "dialog");
        this.name = str;
        this.tvContentTitle$delegate = h.b(new ContentHolder$tvContentTitle$2(this));
        this.tvError$delegate = h.b(new ContentHolder$tvError$2(this));
        this.mTvSubmit$delegate = h.b(new ContentHolder$mTvSubmit$2(this));
        this.ivTitleEdit$delegate = h.b(new ContentHolder$ivTitleEdit$2(this));
        this.etContentTitle$delegate = h.b(new ContentHolder$etContentTitle$2(this));
        this.etDes$delegate = h.b(new ContentHolder$etDes$2(this));
        this.etEmail$delegate = h.b(new ContentHolder$etEmail$2(this));
        this.mIvContentClear$delegate = h.b(new ContentHolder$mIvContentClear$2(this));
        this.mRvCompleteList$delegate = h.b(new ContentHolder$mRvCompleteList$2(this));
        this.mLlRecyclerEmail$delegate = h.b(new ContentHolder$mLlRecyclerEmail$2(this));
        this.mEmailAdapter$delegate = h.b(new ContentHolder$mEmailAdapter$2(view));
        getMRvCompleteList().setLayoutManager(new LinearLayoutManagerWrapper(view.getContext()));
        getMRvCompleteList().setAdapter(getMEmailAdapter());
        getIvTitleEdit().setOnClickListener(this);
        TextView mTvSubmit = getMTvSubmit();
        if (mTvSubmit != null) {
            mTvSubmit.setOnClickListener(this);
        }
        getEtContentTitle().addTextChangedListener(new TextWatcher() { // from class: com.mobile.brasiltv.view.dialog.feedback.ContentHolder.1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                ContentHolder.this.getTvError().setVisibility(4);
                ContentHolder.this.checkSubmitBnt();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            }
        });
        getEtDes().addTextChangedListener(new TextWatcher() { // from class: com.mobile.brasiltv.view.dialog.feedback.ContentHolder.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                ContentHolder.this.getTvError().setVisibility(4);
                ContentHolder.this.checkSubmitBnt();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            }
        });
        getEtEmail().addTextChangedListener(this);
        getEtEmail().setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.mobile.brasiltv.view.dialog.feedback.a
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i10, KeyEvent keyEvent) {
                boolean _init_$lambda$0;
                _init_$lambda$0 = ContentHolder._init_$lambda$0(ContentHolder.this, textView, i10, keyEvent);
                return _init_$lambda$0;
            }
        });
        getTvContentTitle().setText(this.name);
        d6.b bVar = d6.b.f12660a;
        if (bVar.b()) {
            getEtEmail().setText(w6.i.f19214g.m());
        } else {
            String i10 = bVar.i(getHost().getContext());
            if (i10 != null) {
                getEtEmail().setText(i10);
            }
        }
        getMEmailAdapter().f(new c.a() { // from class: com.mobile.brasiltv.view.dialog.feedback.ContentHolder.5
            @Override // g5.c.a
            public void onClick(String str2) {
                i.g(str2, "mEmailString");
                ContentHolder.this.getEtEmail().setText(str2);
                ContentHolder.this.getEtEmail().setSelection(str2.length());
                ContentHolder.this.getMRvCompleteList().setVisibility(8);
                ContentHolder.this.getMLlRecyclerEmail().setVisibility(8);
            }
        });
        getEtEmail().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.mobile.brasiltv.view.dialog.feedback.b
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view2, boolean z10) {
                ContentHolder._init_$lambda$2(ContentHolder.this, view2, z10);
            }
        });
        getMIvContentClear().setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.dialog.feedback.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                ContentHolder._init_$lambda$3(ContentHolder.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$0(ContentHolder contentHolder, TextView textView, int i10, KeyEvent keyEvent) {
        i.g(contentHolder, "this$0");
        if (i10 != 6) {
            return false;
        }
        contentHolder.getHost().editActionDone();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$2(ContentHolder contentHolder, View view, boolean z10) {
        i.g(contentHolder, "this$0");
        if (z10) {
            return;
        }
        contentHolder.getMRvCompleteList().setVisibility(8);
        contentHolder.getMLlRecyclerEmail().setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$3(ContentHolder contentHolder, View view) {
        i.g(contentHolder, "this$0");
        contentHolder.getEtEmail().setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkSubmitBnt() {
        boolean z10 = b0.K(getEtDes().getText()) && b0.K(getEtEmail().getText()) && (getEtContentTitle().getVisibility() != 0 || b0.K(getEtContentTitle().getText()));
        TextView mTvSubmit = getMTvSubmit();
        if (mTvSubmit != null) {
            mTvSubmit.setEnabled(z10);
        }
        if (this.mIsShow) {
            getHost().submitBntEnable(z10);
        }
    }

    private final EditText getEtContentTitle() {
        return (EditText) this.etContentTitle$delegate.getValue();
    }

    private final EditText getEtDes() {
        return (EditText) this.etDes$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EditText getEtEmail() {
        return (EditText) this.etEmail$delegate.getValue();
    }

    private final ImageView getIvTitleEdit() {
        return (ImageView) this.ivTitleEdit$delegate.getValue();
    }

    private final g5.c getMEmailAdapter() {
        return (g5.c) this.mEmailAdapter$delegate.getValue();
    }

    private final ImageView getMIvContentClear() {
        return (ImageView) this.mIvContentClear$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AutoLinearLayout getMLlRecyclerEmail() {
        return (AutoLinearLayout) this.mLlRecyclerEmail$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final RecyclerView getMRvCompleteList() {
        return (RecyclerView) this.mRvCompleteList$delegate.getValue();
    }

    private final TextView getMTvSubmit() {
        return (TextView) this.mTvSubmit$delegate.getValue();
    }

    private final TextView getTvContentTitle() {
        return (TextView) this.tvContentTitle$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView getTvError() {
        return (TextView) this.tvError$delegate.getValue();
    }

    private final void performFiltering(String str) {
        if (TextUtils.isEmpty(str) || !t.o(str, "@", false, 2, null) || t.y(str, "@", 0, false, 6, null) != t.D(str, "@", 0, false, 6, null)) {
            getMRvCompleteList().setVisibility(8);
            getMLlRecyclerEmail().setVisibility(8);
            return;
        }
        FeedBackDialog.Companion companion = FeedBackDialog.Companion;
        if (companion.getMEmailSuffixList().size() == 0) {
            companion.getMEmailSuffixList().add("@gmail.com");
        }
        if (s.e(str, "@", false, 2, null)) {
            g5.c mEmailAdapter = getMEmailAdapter();
            String substring = str.substring(0, str.length() - 1);
            i.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            mEmailAdapter.g(substring);
            getMEmailAdapter().e(companion.getMEmailSuffixList());
            getMRvCompleteList().setVisibility(0);
            getMLlRecyclerEmail().setVisibility(0);
            return;
        }
        String lowerCase = str.toLowerCase();
        i.f(lowerCase, "this as java.lang.String).toLowerCase()");
        String[] strArr = (String[]) t.M(lowerCase, new String[]{"@"}, false, 0, 6, null).toArray(new String[0]);
        String str2 = '@' + strArr[1];
        int size = companion.getMEmailSuffixList().size();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < size; i10++) {
            String str3 = FeedBackDialog.Companion.getMEmailSuffixList().get(i10);
            i.f(str3, "mEmailSuffixList[i]");
            String str4 = str3;
            String lowerCase2 = str4.toLowerCase();
            i.f(lowerCase2, "this as java.lang.String).toLowerCase()");
            if (s.l(lowerCase2, str2, false, 2, null)) {
                arrayList.add(str4);
            }
        }
        if (arrayList.isEmpty()) {
            getMRvCompleteList().setVisibility(8);
            getMLlRecyclerEmail().setVisibility(8);
            return;
        }
        getMEmailAdapter().g(strArr[0]);
        getMEmailAdapter().e(arrayList);
        getMRvCompleteList().setBackgroundDrawable(getContentView().getContext().getResources().getDrawable(R.drawable.bg_associate_email));
        getMRvCompleteList().setVisibility(0);
        getMLlRecyclerEmail().setVisibility(0);
    }

    private final void submit() {
        String obj;
        String string;
        String string2;
        String string3;
        if (getEtContentTitle().getVisibility() == 0) {
            Editable text = getEtContentTitle().getText();
            i.f(text, "etContentTitle.text");
            obj = t.W(text).toString();
        } else {
            CharSequence text2 = getTvContentTitle().getText();
            i.f(text2, "tvContentTitle.text");
            obj = t.W(text2).toString();
        }
        String str = "";
        if (obj.length() == 0) {
            getTvError().setVisibility(0);
            TextView tvError = getTvError();
            Context context = getHost().getContext();
            if (context != null && (string3 = context.getString(R.string.content_title_empty)) != null) {
                str = string3;
            }
            tvError.setText(str);
            return;
        }
        String obj2 = t.W(getEtEmail().getText().toString()).toString();
        if (obj2.length() == 0) {
            getTvError().setVisibility(0);
            TextView tvError2 = getTvError();
            Context context2 = getHost().getContext();
            if (context2 != null && (string2 = context2.getString(R.string.email_empty)) != null) {
                str = string2;
            }
            tvError2.setText(str);
            return;
        }
        if (j1.i(obj2)) {
            submitFeedback(obj2, t.W(getEtDes().getText().toString()).toString());
            getHost().submitSuc();
            return;
        }
        getTvError().setVisibility(0);
        TextView tvError3 = getTvError();
        Context context3 = getHost().getContext();
        if (context3 != null && (string = context3.getString(R.string.email_incorrect)) != null) {
            str = string;
        }
        tvError3.setText(str);
    }

    private final void submitFeedback(String str, String str2) {
        d6.b.f12660a.z(getHost().getContext(), str);
        w6.i.f19214g.b().r2("4", this.name, str, null, null, str2).subscribe(new ha.a() { // from class: com.mobile.brasiltv.view.dialog.feedback.ContentHolder$submitFeedback$1
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
        String obj = t.W(getEtEmail().getText().toString()).toString();
        if (TextUtils.isEmpty(obj)) {
            getMIvContentClear().setVisibility(8);
        } else {
            getMIvContentClear().setVisibility(0);
        }
        performFiltering(obj);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }

    @Override // com.mobile.brasiltv.view.dialog.feedback.BaseFeedbackHodler
    public void clickSubmit() {
        if (this.mIsShow) {
            submit();
        }
    }

    @Override // com.mobile.brasiltv.view.dialog.feedback.BaseFeedbackHodler
    public void dialogCancel() {
    }

    public final String getName() {
        return this.name;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        i.g(view, "v");
        if (!i.b(view, getIvTitleEdit())) {
            if (i.b(view, getMTvSubmit())) {
                submit();
                return;
            }
            return;
        }
        getTvContentTitle().setVisibility(8);
        getIvTitleEdit().setVisibility(8);
        getEtContentTitle().setVisibility(0);
        getEtContentTitle().setText(getTvContentTitle().getText().toString());
        getEtContentTitle().setSelection(getEtContentTitle().getText().toString().length());
        getEtContentTitle().requestFocus();
        Context context = getHost().getContext();
        Object systemService = context != null ? context.getSystemService("input_method") : null;
        i.e(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(getEtContentTitle(), 1);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        getTvError().setVisibility(4);
        checkSubmitBnt();
    }

    public final void setName(String str) {
        i.g(str, "<set-?>");
        this.name = str;
    }

    @Override // com.mobile.brasiltv.view.dialog.feedback.BaseFeedbackHodler
    public void show(boolean z10) {
        this.mIsShow = z10;
        if (z10) {
            checkSubmitBnt();
        }
        super.show(z10);
    }
}
