package com.mobile.brasiltv.view.login;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.R$styleable;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoLinearLayout;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class PasswordEditView extends AutoLinearLayout {
    public Map<Integer, View> _$_findViewCache;
    private int mCloseEyeResId;
    private int mOpenEyeResId;
    private IPwdEditCallback mPwdEditCallback;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PasswordEditView(Context context) {
        this(context, null, 0, 6, null);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
    }

    private final void initListeners() {
        int i10 = R$id.mEtInput;
        ((EditText) _$_findCachedViewById(i10)).setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.mobile.brasiltv.view.login.m
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z10) {
                PasswordEditView.initListeners$lambda$0(PasswordEditView.this, view, z10);
            }
        });
        ((EditText) _$_findCachedViewById(i10)).addTextChangedListener(new TextWatcher() { // from class: com.mobile.brasiltv.view.login.PasswordEditView$initListeners$2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                IPwdEditCallback iPwdEditCallback;
                PasswordEditView passwordEditView = PasswordEditView.this;
                int i11 = R$id.mEtInput;
                String obj = ba.t.W(((EditText) passwordEditView._$_findCachedViewById(i11)).getText().toString()).toString();
                if (TextUtils.isEmpty(obj)) {
                    ((ImageView) PasswordEditView.this._$_findCachedViewById(R$id.mIvClear)).setVisibility(8);
                } else if (((EditText) PasswordEditView.this._$_findCachedViewById(i11)).isFocused()) {
                    ((ImageView) PasswordEditView.this._$_findCachedViewById(R$id.mIvClear)).setVisibility(0);
                } else {
                    ((ImageView) PasswordEditView.this._$_findCachedViewById(R$id.mIvClear)).setVisibility(8);
                }
                iPwdEditCallback = PasswordEditView.this.mPwdEditCallback;
                if (iPwdEditCallback != null) {
                    iPwdEditCallback.onTextChanged(obj);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }
        });
        ((ImageView) _$_findCachedViewById(R$id.mIvClear)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.login.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PasswordEditView.initListeners$lambda$1(PasswordEditView.this, view);
            }
        });
        ((ImageView) _$_findCachedViewById(R$id.mIvEye)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.login.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PasswordEditView.initListeners$lambda$2(PasswordEditView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListeners$lambda$0(PasswordEditView passwordEditView, View view, boolean z10) {
        t9.i.g(passwordEditView, "this$0");
        if (!z10) {
            ((ImageView) passwordEditView._$_findCachedViewById(R$id.mIvClear)).setVisibility(8);
        } else if (TextUtils.isEmpty(ba.t.W(((EditText) passwordEditView._$_findCachedViewById(R$id.mEtInput)).getText().toString()).toString())) {
            ((ImageView) passwordEditView._$_findCachedViewById(R$id.mIvClear)).setVisibility(8);
        } else {
            ((ImageView) passwordEditView._$_findCachedViewById(R$id.mIvClear)).setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListeners$lambda$1(PasswordEditView passwordEditView, View view) {
        t9.i.g(passwordEditView, "this$0");
        ((EditText) passwordEditView._$_findCachedViewById(R$id.mEtInput)).setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListeners$lambda$2(PasswordEditView passwordEditView, View view) {
        t9.i.g(passwordEditView, "this$0");
        int i10 = R$id.mEtInput;
        if (t9.i.b(((EditText) passwordEditView._$_findCachedViewById(i10)).getTransformationMethod(), PasswordTransformationMethod.getInstance())) {
            ((ImageView) passwordEditView._$_findCachedViewById(R$id.mIvEye)).setImageResource(passwordEditView.mOpenEyeResId);
            ((EditText) passwordEditView._$_findCachedViewById(i10)).setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        } else {
            ((ImageView) passwordEditView._$_findCachedViewById(R$id.mIvEye)).setImageResource(passwordEditView.mCloseEyeResId);
            ((EditText) passwordEditView._$_findCachedViewById(i10)).setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
        ((EditText) passwordEditView._$_findCachedViewById(i10)).setSelection(ba.t.W(((EditText) passwordEditView._$_findCachedViewById(i10)).getText().toString()).toString().length());
    }

    private final void initViews() {
        ((EditText) _$_findCachedViewById(R$id.mEtInput)).setTransformationMethod(PasswordTransformationMethod.getInstance());
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

    public final String getPassword() {
        return ba.t.W(((EditText) _$_findCachedViewById(R$id.mEtInput)).getText().toString()).toString();
    }

    public final void setPwdEditCallback(IPwdEditCallback iPwdEditCallback) {
        t9.i.g(iPwdEditCallback, "callback");
        this.mPwdEditCallback = iPwdEditCallback;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PasswordEditView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PasswordEditView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        this._$_findViewCache = new LinkedHashMap();
        setOrientation(0);
        LayoutInflater.from(context).inflate(R.layout.layout_password_edit_view, (ViewGroup) this, true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f7799s, i10, 0);
        t9.i.f(obtainStyledAttributes, "context.obtainStyledAttr…ditView, defStyleAttr, 0)");
        int resourceId = obtainStyledAttributes.getResourceId(4, 0);
        if (resourceId != 0) {
            ((ImageView) _$_findCachedViewById(R$id.mIvType)).setImageResource(resourceId);
        }
        String string = obtainStyledAttributes.getString(3);
        ((EditText) _$_findCachedViewById(R$id.mEtInput)).setHint(string == null ? "" : string);
        int resourceId2 = obtainStyledAttributes.getResourceId(2, 0);
        if (resourceId2 != 0) {
            ((ImageView) _$_findCachedViewById(R$id.mIvClear)).setImageResource(resourceId2);
        }
        this.mCloseEyeResId = obtainStyledAttributes.getResourceId(0, 0);
        this.mOpenEyeResId = obtainStyledAttributes.getResourceId(1, 0);
        if (this.mCloseEyeResId != 0) {
            ((ImageView) _$_findCachedViewById(R$id.mIvEye)).setImageResource(this.mCloseEyeResId);
        }
        obtainStyledAttributes.recycle();
        initViews();
        initListeners();
    }

    public /* synthetic */ PasswordEditView(Context context, AttributeSet attributeSet, int i10, int i11, t9.g gVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
