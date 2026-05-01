package com.mobile.brasiltv.view.dialog.feedback;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ba.s;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.j1;
import com.mobile.brasiltv.view.LinearLayoutManagerWrapper;
import com.mobile.brasiltv.view.dialog.feedback.FeedBackDialog;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoLinearLayout;
import g5.c;
import g5.z;
import h9.t;
import java.util.ArrayList;
import java.util.List;
import mobile.com.requestframe.utils.response.BaseResult;
import mobile.com.requestframe.utils.response.QuestionBean;
import mobile.com.requestframe.utils.response.TypeQuestionData;
import mobile.com.requestframe.utils.response.TypeQuestionResult;
import s9.l;
import t9.i;
import t9.j;

/* loaded from: classes3.dex */
public final class FeedbackHolder extends BaseFeedbackHodler implements TextWatcher {
    private EditText etDes;
    private EditText etFeedbackEmail;
    private View footerView;
    private View headView;
    private boolean isRequest;
    private z mAdapter;
    private g5.c mEmailSuffixListAdapter;
    private boolean mIsShow;
    private ImageView mIvFeedBackClear;
    private AutoLinearLayout mLlDes;
    private AutoLinearLayout mLlFeedBackEmail;
    private RecyclerView mRvFeedBackList;
    private TextView mTvFeedbackSbumit;
    private String name;
    private TextView tvError;
    private TextView tvName;

    /* renamed from: com.mobile.brasiltv.view.dialog.feedback.FeedbackHolder$1, reason: invalid class name */
    public static final class AnonymousClass1 extends j implements l {
        public AnonymousClass1() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke(((Boolean) obj).booleanValue());
            return t.f14242a;
        }

        public final void invoke(boolean z10) {
            FeedbackHolder.this.tvError.setVisibility(4);
            FeedbackHolder.this.mLlDes.setVisibility(z10 ? 0 : 8);
            FeedbackHolder.this.etDes.setVisibility(z10 ? 0 : 8);
            FeedbackHolder.this.checkSubmitBnt();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedbackHolder(String str, RecyclerView recyclerView, IFeedbackView iFeedbackView) {
        super(recyclerView, iFeedbackView);
        i.g(str, "name");
        i.g(recyclerView, "recyclerView");
        i.g(iFeedbackView, "dialog");
        this.name = str;
        View inflate = LayoutInflater.from(getHost().getContext()).inflate(R.layout.item_feedback_item_head, (ViewGroup) null);
        i.f(inflate, "from(host.getContext()).…_feedback_item_head,null)");
        this.headView = inflate;
        View inflate2 = LayoutInflater.from(getHost().getContext()).inflate(R.layout.item_feedback_item_footer, (ViewGroup) null);
        i.f(inflate2, "from(host.getContext()).…eedback_item_footer,null)");
        this.footerView = inflate2;
        z zVar = new z();
        this.mAdapter = zVar;
        zVar.addHeaderView(this.headView);
        this.mAdapter.addFooterView(this.footerView);
        recyclerView.setLayoutManager(new LinearLayoutManagerWrapper(getHost().getContext()));
        recyclerView.setAdapter(this.mAdapter);
        View findViewById = this.headView.findViewById(R.id.tvName);
        i.f(findViewById, "headView.findViewById(R.id.tvName)");
        TextView textView = (TextView) findViewById;
        this.tvName = textView;
        textView.setText(this.name);
        View findViewById2 = this.footerView.findViewById(R.id.tvError);
        i.f(findViewById2, "footerView.findViewById(R.id.tvError)");
        this.tvError = (TextView) findViewById2;
        View findViewById3 = this.footerView.findViewById(R.id.etFeedbackDes);
        i.f(findViewById3, "footerView.findViewById(R.id.etFeedbackDes)");
        this.etDes = (EditText) findViewById3;
        View findViewById4 = this.footerView.findViewById(R.id.etFeedbackEmail);
        i.f(findViewById4, "footerView.findViewById(R.id.etFeedbackEmail)");
        this.etFeedbackEmail = (EditText) findViewById4;
        View findViewById5 = this.footerView.findViewById(R.id.mIvFeedBackClear);
        i.f(findViewById5, "footerView.findViewById(R.id.mIvFeedBackClear)");
        this.mIvFeedBackClear = (ImageView) findViewById5;
        this.mTvFeedbackSbumit = (TextView) this.footerView.findViewById(R.id.mTvFeedbackSbumit);
        View findViewById6 = this.footerView.findViewById(R.id.llDes);
        i.f(findViewById6, "footerView.findViewById(R.id.llDes)");
        this.mLlDes = (AutoLinearLayout) findViewById6;
        this.mAdapter.e(new AnonymousClass1());
        this.mEmailSuffixListAdapter = new g5.c(getHost().getContext());
        View findViewById7 = this.footerView.findViewById(R.id.mLlFeedBackEmail);
        i.f(findViewById7, "footerView.findViewById(R.id.mLlFeedBackEmail)");
        this.mLlFeedBackEmail = (AutoLinearLayout) findViewById7;
        View findViewById8 = this.footerView.findViewById(R.id.mRvFeedBackList);
        i.f(findViewById8, "footerView.findViewById(R.id.mRvFeedBackList)");
        RecyclerView recyclerView2 = (RecyclerView) findViewById8;
        this.mRvFeedBackList = recyclerView2;
        recyclerView2.setLayoutManager(new LinearLayoutManagerWrapper(getHost().getContext()));
        this.mRvFeedBackList.setAdapter(this.mEmailSuffixListAdapter);
        this.etDes.addTextChangedListener(new TextWatcher() { // from class: com.mobile.brasiltv.view.dialog.feedback.FeedbackHolder.2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                FeedbackHolder.this.checkSubmitBnt();
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            }
        });
        this.etFeedbackEmail.addTextChangedListener(this);
        this.etFeedbackEmail.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.mobile.brasiltv.view.dialog.feedback.d
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView2, int i10, KeyEvent keyEvent) {
                boolean _init_$lambda$0;
                _init_$lambda$0 = FeedbackHolder._init_$lambda$0(FeedbackHolder.this, textView2, i10, keyEvent);
                return _init_$lambda$0;
            }
        });
        d6.b bVar = d6.b.f12660a;
        if (bVar.b()) {
            this.etFeedbackEmail.setText(w6.i.f19214g.m());
        } else {
            String i10 = bVar.i(getHost().getContext());
            if (i10 != null) {
                this.etFeedbackEmail.setText(i10);
            }
        }
        TextView textView2 = this.mTvFeedbackSbumit;
        if (textView2 != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.dialog.feedback.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    FeedbackHolder._init_$lambda$2(FeedbackHolder.this, view);
                }
            });
        }
        this.mEmailSuffixListAdapter.f(new c.a() { // from class: com.mobile.brasiltv.view.dialog.feedback.FeedbackHolder.6
            @Override // g5.c.a
            public void onClick(String str2) {
                i.g(str2, "mEmailString");
                FeedbackHolder.this.etFeedbackEmail.setText(str2);
                FeedbackHolder.this.etFeedbackEmail.setSelection(str2.length());
                FeedbackHolder.this.mRvFeedBackList.setVisibility(8);
                FeedbackHolder.this.mLlFeedBackEmail.setVisibility(8);
            }
        });
        this.etFeedbackEmail.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.mobile.brasiltv.view.dialog.feedback.f
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z10) {
                FeedbackHolder._init_$lambda$3(FeedbackHolder.this, view, z10);
            }
        });
        this.mIvFeedBackClear.setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.dialog.feedback.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FeedbackHolder._init_$lambda$4(FeedbackHolder.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean _init_$lambda$0(FeedbackHolder feedbackHolder, TextView textView, int i10, KeyEvent keyEvent) {
        i.g(feedbackHolder, "this$0");
        if (i10 != 6) {
            return false;
        }
        feedbackHolder.getHost().editActionDone();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$2(FeedbackHolder feedbackHolder, View view) {
        i.g(feedbackHolder, "this$0");
        feedbackHolder.submit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$3(FeedbackHolder feedbackHolder, View view, boolean z10) {
        i.g(feedbackHolder, "this$0");
        if (z10) {
            return;
        }
        feedbackHolder.mRvFeedBackList.setVisibility(8);
        feedbackHolder.mLlFeedBackEmail.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$4(FeedbackHolder feedbackHolder, View view) {
        i.g(feedbackHolder, "this$0");
        feedbackHolder.etFeedbackEmail.setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0042, code lost:
    
        if ((ba.t.W(r3.etDes.getText().toString()).toString().length() > 0) != false) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void checkSubmitBnt() {
        /*
            r3 = this;
            android.widget.EditText r0 = r3.etFeedbackEmail
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            java.lang.CharSequence r0 = ba.t.W(r0)
            java.lang.String r0 = r0.toString()
            int r0 = r0.length()
            r1 = 1
            r2 = 0
            if (r0 <= 0) goto L1c
            r0 = 1
            goto L1d
        L1c:
            r0 = 0
        L1d:
            if (r0 == 0) goto L45
            android.widget.EditText r0 = r3.etDes
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L46
            android.widget.EditText r0 = r3.etDes
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            java.lang.CharSequence r0 = ba.t.W(r0)
            java.lang.String r0 = r0.toString()
            int r0 = r0.length()
            if (r0 <= 0) goto L41
            r0 = 1
            goto L42
        L41:
            r0 = 0
        L42:
            if (r0 == 0) goto L45
            goto L46
        L45:
            r1 = 0
        L46:
            android.widget.TextView r0 = r3.mTvFeedbackSbumit
            if (r0 != 0) goto L4b
            goto L4e
        L4b:
            r0.setEnabled(r1)
        L4e:
            boolean r0 = r3.mIsShow
            if (r0 == 0) goto L59
            com.mobile.brasiltv.view.dialog.feedback.IFeedbackView r0 = r3.getHost()
            r0.submitBntEnable(r1)
        L59:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.view.dialog.feedback.FeedbackHolder.checkSubmitBnt():void");
    }

    private final void performFiltering(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("performFiltering : ");
        sb.append(str);
        if (TextUtils.isEmpty(str) || !ba.t.o(str, "@", false, 2, null) || ba.t.y(str, "@", 0, false, 6, null) != ba.t.D(str, "@", 0, false, 6, null)) {
            this.mRvFeedBackList.setVisibility(8);
            this.mLlFeedBackEmail.setVisibility(8);
            return;
        }
        FeedBackDialog.Companion companion = FeedBackDialog.Companion;
        if (companion.getMEmailSuffixList().size() == 0) {
            companion.getMEmailSuffixList().add("@gmail.com");
        }
        if (s.e(str, "@", false, 2, null)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("prefix.endsWith : ");
            sb2.append(str);
            sb2.append(" ;");
            sb2.append(companion.getMEmailSuffixList());
            sb2.append(";mRvFeedBackList:");
            sb2.append(this.mRvFeedBackList.getVisibility());
            g5.c cVar = this.mEmailSuffixListAdapter;
            String substring = str.substring(0, str.length() - 1);
            i.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            cVar.g(substring);
            this.mEmailSuffixListAdapter.e(companion.getMEmailSuffixList());
            this.mRvFeedBackList.setVisibility(0);
            this.mLlFeedBackEmail.setVisibility(0);
            return;
        }
        String lowerCase = str.toLowerCase();
        i.f(lowerCase, "this as java.lang.String).toLowerCase()");
        String[] strArr = (String[]) ba.t.M(lowerCase, new String[]{"@"}, false, 0, 6, null).toArray(new String[0]);
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
            this.mRvFeedBackList.setVisibility(8);
            this.mLlFeedBackEmail.setVisibility(8);
            return;
        }
        this.mEmailSuffixListAdapter.g(strArr[0]);
        this.mEmailSuffixListAdapter.e(arrayList);
        this.mRvFeedBackList.setBackgroundDrawable(getContentView().getContext().getResources().getDrawable(R.drawable.bg_associate_email));
        this.mRvFeedBackList.setVisibility(0);
        this.mLlFeedBackEmail.setVisibility(0);
    }

    private final void showHint(int i10) {
        String str;
        this.tvError.setVisibility(0);
        TextView textView = this.tvError;
        Context context = getHost().getContext();
        if (context == null || (str = context.getString(i10)) == null) {
            str = "";
        }
        textView.setText(str);
    }

    private final void submit() {
        String str;
        if (this.etDes.getVisibility() == 0) {
            str = ba.t.W(this.etDes.getText().toString()).toString();
            if (str.length() > 2000) {
                showHint(R.string.text_too_long);
                return;
            }
        } else {
            str = "";
        }
        String obj = ba.t.W(this.etFeedbackEmail.getText().toString()).toString();
        if (b0.J(obj)) {
            showHint(R.string.email_empty);
            return;
        }
        if (!j1.i(obj)) {
            showHint(R.string.email_incorrect);
            return;
        }
        QuestionBean d10 = this.mAdapter.d();
        if (d10 != null) {
            submitFeedback(obj, d10, str);
        }
        getHost().submitSuc();
    }

    private final void submitFeedback(String str, QuestionBean questionBean, String str2) {
        d6.b.f12660a.z(getHost().getContext(), str);
        w6.i b10 = w6.i.f19214g.b();
        String mo65getType = getHost().mo65getType();
        String str3 = this.name;
        Integer typeId = questionBean.getTypeId();
        b10.r2(mo65getType, str3, str, typeId != null ? typeId.toString() : null, String.valueOf(questionBean.getQuestionId()), str2).subscribe(new ha.a() { // from class: com.mobile.brasiltv.view.dialog.feedback.FeedbackHolder$submitFeedback$1
            @Override // ha.a, io.reactivex.Observer
            public void onNext(BaseResult baseResult) {
                i.g(baseResult, "t");
            }

            @Override // ha.a
            public void showErrorHint(String str4) {
                i.g(str4, "returnCode");
            }
        });
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        String obj = ba.t.W(this.etFeedbackEmail.getText().toString()).toString();
        if (TextUtils.isEmpty(obj)) {
            this.mIvFeedBackClear.setVisibility(8);
        } else {
            this.mIvFeedBackClear.setVisibility(0);
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
        this.mIsShow = false;
    }

    public final String getName() {
        return this.name;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
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
        if (this.mAdapter.getData().size() > 0) {
            super.show(z10);
            return;
        }
        if (!z10) {
            super.show(z10);
            return;
        }
        getHost().showLoading(true);
        if (this.isRequest) {
            return;
        }
        this.isRequest = true;
        w6.i.f19214g.b().T1(getHost().mo65getType()).subscribe(new ha.a() { // from class: com.mobile.brasiltv.view.dialog.feedback.FeedbackHolder$show$1
            @Override // ha.a
            public void showErrorHint(String str) {
                boolean z11;
                i.g(str, "returnCode");
                FeedbackHolder.this.isRequest = false;
                z11 = FeedbackHolder.this.mIsShow;
                if (z11) {
                    FeedbackHolder.this.getHost().showLoading(false);
                    f1.f8649a.u(str);
                }
            }

            @Override // ha.a, io.reactivex.Observer
            public void onNext(TypeQuestionResult typeQuestionResult) {
                boolean z11;
                String str;
                z zVar;
                i.g(typeQuestionResult, "t");
                super.onNext((Object) typeQuestionResult);
                FeedbackHolder.this.isRequest = false;
                z11 = FeedbackHolder.this.mIsShow;
                if (z11) {
                    FeedbackHolder.this.getHost().showLoading(false);
                    if (!i.b(typeQuestionResult.getReturnCode(), "0") || !b0.I(typeQuestionResult.getData())) {
                        f1.f8649a.w(R.string.order_system_busy);
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    List<TypeQuestionData> data = typeQuestionResult.getData();
                    i.d(data);
                    for (TypeQuestionData typeQuestionData : data) {
                        if (b0.I(typeQuestionData.getQuestionList())) {
                            List<QuestionBean> questionList = typeQuestionData.getQuestionList();
                            i.d(questionList);
                            for (QuestionBean questionBean : questionList) {
                                questionBean.setTypeId(Integer.valueOf(typeQuestionData.getTypeId()));
                                arrayList.add(questionBean);
                            }
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        Context context = FeedbackHolder.this.getHost().getContext();
                        if (context == null || (str = context.getString(R.string.others)) == null) {
                            str = "";
                        }
                        QuestionBean questionBean2 = new QuestionBean(-1, str);
                        questionBean2.setTypeId(((QuestionBean) arrayList.get(0)).getTypeId());
                        arrayList.add(questionBean2);
                        zVar = FeedbackHolder.this.mAdapter;
                        zVar.replaceData(arrayList);
                    }
                    super/*com.mobile.brasiltv.view.dialog.feedback.BaseFeedbackHodler*/.show(true);
                }
            }
        });
    }
}
