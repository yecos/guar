package com.mobile.brasiltv.view.login;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import com.hpplay.component.common.ParamsMap;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.R$styleable;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoLinearLayout;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class AccountEditView extends AutoLinearLayout {
    public Map<Integer, View> _$_findViewCache;
    private IAccountEditCallback mAccountEditCallback;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AccountEditView(Context context) {
        this(context, null, 0, 6, null);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
    }

    private final void initListeners() {
        int i10 = R$id.mEtInput;
        ((EditText) _$_findCachedViewById(i10)).setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.mobile.brasiltv.view.login.a
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z10) {
                AccountEditView.initListeners$lambda$0(AccountEditView.this, view, z10);
            }
        });
        ((EditText) _$_findCachedViewById(i10)).addTextChangedListener(new TextWatcher() { // from class: com.mobile.brasiltv.view.login.AccountEditView$initListeners$2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                IAccountEditCallback iAccountEditCallback;
                String obj = ba.t.W(((EditText) AccountEditView.this._$_findCachedViewById(R$id.mEtInput)).getText().toString()).toString();
                if (TextUtils.isEmpty(obj)) {
                    ((ImageView) AccountEditView.this._$_findCachedViewById(R$id.mIvClear)).setVisibility(8);
                } else {
                    ((ImageView) AccountEditView.this._$_findCachedViewById(R$id.mIvClear)).setVisibility(0);
                }
                iAccountEditCallback = AccountEditView.this.mAccountEditCallback;
                if (iAccountEditCallback != null) {
                    iAccountEditCallback.onTextChanged(obj);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }
        });
        ((ImageView) _$_findCachedViewById(R$id.mIvClear)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.login.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountEditView.initListeners$lambda$1(AccountEditView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListeners$lambda$0(AccountEditView accountEditView, View view, boolean z10) {
        t9.i.g(accountEditView, "this$0");
        if (!z10) {
            ((ImageView) accountEditView._$_findCachedViewById(R$id.mIvClear)).setVisibility(8);
        } else if (TextUtils.isEmpty(ba.t.W(((EditText) accountEditView._$_findCachedViewById(R$id.mEtInput)).getText().toString()).toString())) {
            ((ImageView) accountEditView._$_findCachedViewById(R$id.mIvClear)).setVisibility(8);
        } else {
            ((ImageView) accountEditView._$_findCachedViewById(R$id.mIvClear)).setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListeners$lambda$1(AccountEditView accountEditView, View view) {
        t9.i.g(accountEditView, "this$0");
        ((EditText) accountEditView._$_findCachedViewById(R$id.mEtInput)).setText("");
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

    public final String getAccount() {
        return ba.t.W(((EditText) _$_findCachedViewById(R$id.mEtInput)).getText().toString()).toString();
    }

    public final void setAccountEditCallback(IAccountEditCallback iAccountEditCallback) {
        t9.i.g(iAccountEditCallback, "callback");
        this.mAccountEditCallback = iAccountEditCallback;
    }

    public final void setHint(String str) {
        t9.i.g(str, "hint");
        ((EditText) _$_findCachedViewById(R$id.mEtInput)).setHint(str);
    }

    public final void setText(String str) {
        t9.i.g(str, ParamsMap.MirrorParams.MIRROR_DOC_MODE);
        ((EditText) _$_findCachedViewById(R$id.mEtInput)).setText(str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AccountEditView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountEditView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        this._$_findViewCache = new LinkedHashMap();
        setOrientation(0);
        LayoutInflater.from(context).inflate(R.layout.layout_account_edit_view, (ViewGroup) this, true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f7781a, i10, 0);
        t9.i.f(obtainStyledAttributes, "context.obtainStyledAttr…ditView, defStyleAttr, 0)");
        int resourceId = obtainStyledAttributes.getResourceId(2, 0);
        if (resourceId != 0) {
            ((ImageView) _$_findCachedViewById(R$id.mIvType)).setImageResource(resourceId);
        }
        String string = obtainStyledAttributes.getString(1);
        ((EditText) _$_findCachedViewById(R$id.mEtInput)).setHint(string == null ? "" : string);
        int resourceId2 = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId2 != 0) {
            ((ImageView) _$_findCachedViewById(R$id.mIvClear)).setImageResource(resourceId2);
        }
        obtainStyledAttributes.recycle();
        initListeners();
    }

    public /* synthetic */ AccountEditView(Context context, AttributeSet attributeSet, int i10, int i11, t9.g gVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
