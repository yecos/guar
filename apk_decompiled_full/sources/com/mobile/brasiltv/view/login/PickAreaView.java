package com.mobile.brasiltv.view.login;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.utils.i0;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoFrameLayout;
import com.zhy.autolayout.AutoLinearLayout;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class PickAreaView extends AutoLinearLayout {
    public Map<Integer, View> _$_findViewCache;
    private String mArea;
    private String mAreaCode;
    private IPickAreaCallback mPickAreaCallback;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PickAreaView(Context context) {
        this(context, null, 0, 6, null);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
    }

    private final void initListeners() {
        ((AutoFrameLayout) _$_findCachedViewById(R$id.mAflPickArea)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.login.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PickAreaView.initListeners$lambda$0(PickAreaView.this, view);
            }
        });
        int i10 = R$id.mEtInput;
        ((EditText) _$_findCachedViewById(i10)).setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.mobile.brasiltv.view.login.q
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z10) {
                PickAreaView.initListeners$lambda$1(PickAreaView.this, view, z10);
            }
        });
        ((EditText) _$_findCachedViewById(i10)).addTextChangedListener(new TextWatcher() { // from class: com.mobile.brasiltv.view.login.PickAreaView$initListeners$3
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                String str;
                IPickAreaCallback iPickAreaCallback;
                i0 i0Var = i0.f8719a;
                PickAreaView pickAreaView = PickAreaView.this;
                int i11 = R$id.mEtInput;
                EditText editText = (EditText) pickAreaView._$_findCachedViewById(i11);
                t9.i.f(editText, "mEtInput");
                str = PickAreaView.this.mArea;
                i0Var.a(editText, this, str);
                String obj = ba.t.W(((EditText) PickAreaView.this._$_findCachedViewById(i11)).getText().toString()).toString();
                if (TextUtils.isEmpty(obj)) {
                    ((ImageView) PickAreaView.this._$_findCachedViewById(R$id.mIvClear)).setVisibility(8);
                } else {
                    ((ImageView) PickAreaView.this._$_findCachedViewById(R$id.mIvClear)).setVisibility(0);
                }
                iPickAreaCallback = PickAreaView.this.mPickAreaCallback;
                if (iPickAreaCallback != null) {
                    iPickAreaCallback.onTextChanged(obj);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }
        });
        ((ImageView) _$_findCachedViewById(R$id.mIvClear)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.login.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PickAreaView.initListeners$lambda$2(PickAreaView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListeners$lambda$0(PickAreaView pickAreaView, View view) {
        t9.i.g(pickAreaView, "this$0");
        IPickAreaCallback iPickAreaCallback = pickAreaView.mPickAreaCallback;
        if (iPickAreaCallback != null) {
            iPickAreaCallback.onPickArea();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListeners$lambda$1(PickAreaView pickAreaView, View view, boolean z10) {
        t9.i.g(pickAreaView, "this$0");
        if (!z10) {
            ((ImageView) pickAreaView._$_findCachedViewById(R$id.mIvClear)).setVisibility(8);
        } else if (TextUtils.isEmpty(ba.t.W(((EditText) pickAreaView._$_findCachedViewById(R$id.mEtInput)).getText().toString()).toString())) {
            ((ImageView) pickAreaView._$_findCachedViewById(R$id.mIvClear)).setVisibility(8);
        } else {
            ((ImageView) pickAreaView._$_findCachedViewById(R$id.mIvClear)).setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListeners$lambda$2(PickAreaView pickAreaView, View view) {
        t9.i.g(pickAreaView, "this$0");
        ((EditText) pickAreaView._$_findCachedViewById(R$id.mEtInput)).setText("");
    }

    private final void initViews() {
        ((TextView) _$_findCachedViewById(R$id.mTvArea)).setText(this.mArea);
        ((TextView) _$_findCachedViewById(R$id.mTvAreaCode)).setText('+' + this.mAreaCode);
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

    public final void fillAreaInfo(String str, String str2) {
        t9.i.g(str, "area");
        t9.i.g(str2, "areaCode");
        setAreaInfo(str, str2);
        ((TextView) _$_findCachedViewById(R$id.mTvArea)).setText(this.mArea);
        ((TextView) _$_findCachedViewById(R$id.mTvAreaCode)).setText('+' + this.mAreaCode);
    }

    public final void fillMobile(String str) {
        t9.i.g(str, "mobile");
        ((EditText) _$_findCachedViewById(R$id.mEtInput)).setText(str);
    }

    public final String getArea() {
        return this.mArea;
    }

    public final String getAreaCode() {
        return this.mAreaCode;
    }

    public final String getAreaMobile() {
        i0 i0Var = i0.f8719a;
        EditText editText = (EditText) _$_findCachedViewById(R$id.mEtInput);
        t9.i.f(editText, "mEtInput");
        return i0Var.b(editText, this.mArea);
    }

    public final void setAreaInfo(String str, String str2) {
        t9.i.g(str, "area");
        t9.i.g(str2, "areaCode");
        this.mArea = str;
        this.mAreaCode = str2;
    }

    public final void setPickAreaCallback(IPickAreaCallback iPickAreaCallback) {
        t9.i.g(iPickAreaCallback, "callback");
        this.mPickAreaCallback = iPickAreaCallback;
    }

    public final void updateAreaInfo(String str, String str2) {
        t9.i.g(str, "area");
        t9.i.g(str2, "areaCode");
        setAreaInfo(str, str2);
        ((TextView) _$_findCachedViewById(R$id.mTvArea)).setText(this.mArea);
        ((TextView) _$_findCachedViewById(R$id.mTvAreaCode)).setText('+' + this.mAreaCode);
        ((EditText) _$_findCachedViewById(R$id.mEtInput)).setText("");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PickAreaView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PickAreaView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        this._$_findViewCache = new LinkedHashMap();
        this.mArea = "";
        this.mAreaCode = "";
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.layout_pick_area_view, (ViewGroup) this, true);
        initViews();
        initListeners();
    }

    public /* synthetic */ PickAreaView(Context context, AttributeSet attributeSet, int i10, int i11, t9.g gVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
