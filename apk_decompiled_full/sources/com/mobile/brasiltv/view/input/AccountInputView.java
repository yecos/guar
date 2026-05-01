package com.mobile.brasiltv.view.input;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import ba.t;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.R$styleable;
import com.mobile.brasiltv.utils.b0;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoFrameLayout;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class AccountInputView extends AutoFrameLayout {
    public Map<Integer, View> _$_findViewCache;
    private IAccountInputCallback mAccountInputCallback;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AccountInputView(Context context) {
        this(context, null, 0, 6, null);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
    }

    private final void initListeners() {
        int i10 = R$id.mEtInput;
        ((EditText) _$_findCachedViewById(i10)).setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.mobile.brasiltv.view.input.a
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z10) {
                AccountInputView.initListeners$lambda$0(AccountInputView.this, view, z10);
            }
        });
        ((EditText) _$_findCachedViewById(i10)).addTextChangedListener(new TextWatcher() { // from class: com.mobile.brasiltv.view.input.AccountInputView$initListeners$2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                IAccountInputCallback iAccountInputCallback;
                boolean K = b0.K(t.W(((EditText) AccountInputView.this._$_findCachedViewById(R$id.mEtInput)).getText().toString()).toString());
                ((ImageView) AccountInputView.this._$_findCachedViewById(R$id.mIvClearInput)).setVisibility(K ? 0 : 8);
                iAccountInputCallback = AccountInputView.this.mAccountInputCallback;
                if (iAccountInputCallback != null) {
                    iAccountInputCallback.onTextChanged(K);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }
        });
        ((ImageView) _$_findCachedViewById(R$id.mIvClearInput)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.input.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountInputView.initListeners$lambda$1(AccountInputView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListeners$lambda$0(AccountInputView accountInputView, View view, boolean z10) {
        t9.i.g(accountInputView, "this$0");
        if (!z10) {
            ((ImageView) accountInputView._$_findCachedViewById(R$id.mIvClearInput)).setVisibility(8);
            return;
        }
        IAccountInputCallback iAccountInputCallback = accountInputView.mAccountInputCallback;
        if (iAccountInputCallback != null) {
            iAccountInputCallback.onInputFocused();
        }
        if (b0.J(t.W(((EditText) accountInputView._$_findCachedViewById(R$id.mEtInput)).getText().toString()).toString())) {
            ((ImageView) accountInputView._$_findCachedViewById(R$id.mIvClearInput)).setVisibility(8);
        } else {
            ((ImageView) accountInputView._$_findCachedViewById(R$id.mIvClearInput)).setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListeners$lambda$1(AccountInputView accountInputView, View view) {
        t9.i.g(accountInputView, "this$0");
        ((EditText) accountInputView._$_findCachedViewById(R$id.mEtInput)).setText("");
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i10) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public final String getInputText() {
        return t.W(((EditText) _$_findCachedViewById(R$id.mEtInput)).getText().toString()).toString();
    }

    public final void setAccountInputCallback(IAccountInputCallback iAccountInputCallback) {
        t9.i.g(iAccountInputCallback, "callback");
        this.mAccountInputCallback = iAccountInputCallback;
    }

    public final void setInputFilter(InputFilter inputFilter) {
        t9.i.g(inputFilter, "inputFilter");
        ((EditText) _$_findCachedViewById(R$id.mEtInput)).setFilters(new InputFilter[]{inputFilter});
    }

    public final void setInputText(String str) {
        t9.i.g(str, "inputText");
        ((EditText) _$_findCachedViewById(R$id.mEtInput)).setText(str);
    }

    public final void setTransformationMethod(TransformationMethod transformationMethod) {
        t9.i.g(transformationMethod, FirebaseAnalytics.Param.METHOD);
        ((EditText) _$_findCachedViewById(R$id.mEtInput)).setTransformationMethod(transformationMethod);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AccountInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountInputView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        this._$_findViewCache = new LinkedHashMap();
        LayoutInflater.from(context).inflate(R.layout.layout_account_input_view, (ViewGroup) this, true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f7782b, i10, 0);
        t9.i.f(obtainStyledAttributes, "context.obtainStyledAttr…putView, defStyleAttr, 0)");
        String string = obtainStyledAttributes.getString(1);
        string = string == null ? "" : string;
        int i11 = R$id.mEtInput;
        ((EditText) _$_findCachedViewById(i11)).setHint(string);
        ((EditText) _$_findCachedViewById(i11)).setTextColor(obtainStyledAttributes.getColor(2, getResources().getColor(R.color.color_999999)));
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            ((ImageView) _$_findCachedViewById(R$id.mIvClearInput)).setImageResource(resourceId);
        }
        obtainStyledAttributes.recycle();
        initListeners();
    }

    public /* synthetic */ AccountInputView(Context context, AttributeSet attributeSet, int i10, int i11, t9.g gVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
