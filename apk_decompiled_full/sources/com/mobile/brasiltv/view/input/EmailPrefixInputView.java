package com.mobile.brasiltv.view.input;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.y1;
import ba.t;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.R$styleable;
import com.mobile.brasiltv.utils.b0;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoLinearLayout;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class EmailPrefixInputView extends AutoLinearLayout {
    public Map<Integer, View> _$_findViewCache;
    private IEmailPrefixInputCallback mEmailPrefixInputCallback;
    private ArrayList<String> mEmailSuffixList;
    private y1 mEmailSuffixPopupWindow;
    private int mEmailSuffixSelectedIndex;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EmailPrefixInputView(Context context) {
        this(context, null, 0, 6, null);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
    }

    private final ArrayAdapter<String> createEmailSuffixAdapter() {
        final Context context = getContext();
        final ArrayList<String> arrayList = this.mEmailSuffixList;
        return new ArrayAdapter<String>(context, arrayList) { // from class: com.mobile.brasiltv.view.input.EmailPrefixInputView$createEmailSuffixAdapter$1
            private LayoutInflater inflater = LayoutInflater.from(getContext());

            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            public View getView(int i10, View view, ViewGroup viewGroup) {
                int i11;
                t9.i.g(viewGroup, "parent");
                if (view == null) {
                    LayoutInflater layoutInflater = this.inflater;
                    view = layoutInflater != null ? layoutInflater.inflate(R.layout.item_popup_email_suffix, viewGroup, false) : null;
                }
                String str = (String) getItem(i10);
                if (str == null) {
                    str = "";
                }
                t9.i.d(view);
                View findViewById = view.findViewById(R.id.tv_email_suffix);
                t9.i.f(findViewById, "view!!.findViewById(R.id.tv_email_suffix)");
                TextView textView = (TextView) findViewById;
                textView.setText(str);
                View findViewById2 = view.findViewById(R.id.iv_selector);
                t9.i.f(findViewById2, "view.findViewById(R.id.iv_selector)");
                ImageView imageView = (ImageView) findViewById2;
                i11 = EmailPrefixInputView.this.mEmailSuffixSelectedIndex;
                if (i10 == i11) {
                    textView.setTextColor(getContext().getResources().getColor(R.color.color_important));
                    imageView.setImageResource(R.drawable.ic_green_gou);
                } else {
                    textView.setTextColor(getContext().getResources().getColor(R.color.color_ffffff));
                    imageView.setImageResource(0);
                }
                return view;
            }
        };
    }

    private final void hideEmailSuffixPopup() {
        ((ImageView) _$_findCachedViewById(R$id.mIvEmailSelector)).setSelected(false);
        y1 y1Var = this.mEmailSuffixPopupWindow;
        if (y1Var != null) {
            y1Var.dismiss();
        }
        this.mEmailSuffixPopupWindow = null;
    }

    private final void initListeners() {
        int i10 = R$id.mEtInput;
        ((EditText) _$_findCachedViewById(i10)).setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.mobile.brasiltv.view.input.e
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z10) {
                EmailPrefixInputView.initListeners$lambda$0(EmailPrefixInputView.this, view, z10);
            }
        });
        ((EditText) _$_findCachedViewById(i10)).addTextChangedListener(new TextWatcher() { // from class: com.mobile.brasiltv.view.input.EmailPrefixInputView$initListeners$2
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                IEmailPrefixInputCallback iEmailPrefixInputCallback;
                boolean K = b0.K(t.W(((EditText) EmailPrefixInputView.this._$_findCachedViewById(R$id.mEtInput)).getText().toString()).toString());
                ((ImageView) EmailPrefixInputView.this._$_findCachedViewById(R$id.mIvClearInput)).setVisibility(K ? 0 : 8);
                iEmailPrefixInputCallback = EmailPrefixInputView.this.mEmailPrefixInputCallback;
                if (iEmailPrefixInputCallback != null) {
                    iEmailPrefixInputCallback.onTextChanged(K);
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            }
        });
        ((ImageView) _$_findCachedViewById(R$id.mIvClearInput)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.input.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmailPrefixInputView.initListeners$lambda$1(EmailPrefixInputView.this, view);
            }
        });
        ((TextView) _$_findCachedViewById(R$id.mTvEmailSuffix)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.input.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EmailPrefixInputView.initListeners$lambda$2(EmailPrefixInputView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListeners$lambda$0(EmailPrefixInputView emailPrefixInputView, View view, boolean z10) {
        t9.i.g(emailPrefixInputView, "this$0");
        if (!z10) {
            ((ImageView) emailPrefixInputView._$_findCachedViewById(R$id.mIvClearInput)).setVisibility(8);
            return;
        }
        IEmailPrefixInputCallback iEmailPrefixInputCallback = emailPrefixInputView.mEmailPrefixInputCallback;
        if (iEmailPrefixInputCallback != null) {
            iEmailPrefixInputCallback.onInputFocused();
        }
        if (b0.J(t.W(((EditText) emailPrefixInputView._$_findCachedViewById(R$id.mEtInput)).getText().toString()).toString())) {
            ((ImageView) emailPrefixInputView._$_findCachedViewById(R$id.mIvClearInput)).setVisibility(8);
        } else {
            ((ImageView) emailPrefixInputView._$_findCachedViewById(R$id.mIvClearInput)).setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListeners$lambda$1(EmailPrefixInputView emailPrefixInputView, View view) {
        t9.i.g(emailPrefixInputView, "this$0");
        ((EditText) emailPrefixInputView._$_findCachedViewById(R$id.mEtInput)).setText("");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListeners$lambda$2(EmailPrefixInputView emailPrefixInputView, View view) {
        t9.i.g(emailPrefixInputView, "this$0");
        if (emailPrefixInputView.isShowingEmailSuffixPopup()) {
            emailPrefixInputView.hideEmailSuffixPopup();
        } else {
            emailPrefixInputView.showEmailSuffixPopup();
        }
    }

    private final boolean isShowingEmailSuffixPopup() {
        y1 y1Var = this.mEmailSuffixPopupWindow;
        if (y1Var != null) {
            return y1Var != null && y1Var.isShowing();
        }
        return false;
    }

    private final void showEmailSuffixPopup() {
        ((ImageView) _$_findCachedViewById(R$id.mIvEmailSelector)).setSelected(true);
        y1 y1Var = new y1(getContext());
        this.mEmailSuffixPopupWindow = y1Var;
        y1Var.setBackgroundDrawable(getContext().getResources().getDrawable(R.drawable.selector_bg_login_edit));
        y1 y1Var2 = this.mEmailSuffixPopupWindow;
        if (y1Var2 != null) {
            y1Var2.k(createEmailSuffixAdapter());
        }
        y1 y1Var3 = this.mEmailSuffixPopupWindow;
        if (y1Var3 != null) {
            y1Var3.w((TextView) _$_findCachedViewById(R$id.mTvEmailSuffix));
        }
        y1 y1Var4 = this.mEmailSuffixPopupWindow;
        if (y1Var4 != null) {
            y1Var4.C(true);
        }
        y1 y1Var5 = this.mEmailSuffixPopupWindow;
        if (y1Var5 != null) {
            y1Var5.D(new PopupWindow.OnDismissListener() { // from class: com.mobile.brasiltv.view.input.h
                @Override // android.widget.PopupWindow.OnDismissListener
                public final void onDismiss() {
                    EmailPrefixInputView.showEmailSuffixPopup$lambda$3(EmailPrefixInputView.this);
                }
            });
        }
        y1 y1Var6 = this.mEmailSuffixPopupWindow;
        if (y1Var6 != null) {
            y1Var6.E(new AdapterView.OnItemClickListener() { // from class: com.mobile.brasiltv.view.input.i
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                    EmailPrefixInputView.showEmailSuffixPopup$lambda$4(EmailPrefixInputView.this, adapterView, view, i10, j10);
                }
            });
        }
        y1 y1Var7 = this.mEmailSuffixPopupWindow;
        if (y1Var7 != null) {
            y1Var7.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showEmailSuffixPopup$lambda$3(EmailPrefixInputView emailPrefixInputView) {
        t9.i.g(emailPrefixInputView, "this$0");
        emailPrefixInputView.mEmailSuffixPopupWindow = null;
        ((ImageView) emailPrefixInputView._$_findCachedViewById(R$id.mIvEmailSelector)).setSelected(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showEmailSuffixPopup$lambda$4(EmailPrefixInputView emailPrefixInputView, AdapterView adapterView, View view, int i10, long j10) {
        t9.i.g(emailPrefixInputView, "this$0");
        emailPrefixInputView.mEmailSuffixSelectedIndex = i10;
        ((TextView) emailPrefixInputView._$_findCachedViewById(R$id.mTvEmailSuffix)).setText(emailPrefixInputView.mEmailSuffixList.get(emailPrefixInputView.mEmailSuffixSelectedIndex));
        y1 y1Var = emailPrefixInputView.mEmailSuffixPopupWindow;
        if (y1Var != null) {
            y1Var.dismiss();
        }
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

    public final String getFullEmailText() {
        int i10 = this.mEmailSuffixSelectedIndex;
        String str = i10 >= 0 ? this.mEmailSuffixList.get(i10) : "";
        t9.i.f(str, "if (mEmailSuffixSelected…\n            \"\"\n        }");
        return t.W(((EditText) _$_findCachedViewById(R$id.mEtInput)).getText().toString()).toString() + str;
    }

    public final String getInputText() {
        return t.W(((EditText) _$_findCachedViewById(R$id.mEtInput)).getText().toString()).toString();
    }

    public final void setEmailPrefixInputCallback(IEmailPrefixInputCallback iEmailPrefixInputCallback) {
        t9.i.g(iEmailPrefixInputCallback, "callback");
        this.mEmailPrefixInputCallback = iEmailPrefixInputCallback;
    }

    public final void setEmailSuffixList(List<String> list) {
        ListView m10;
        t9.i.g(list, "emailSuffixList");
        this.mEmailSuffixList.clear();
        this.mEmailSuffixSelectedIndex = 0;
        this.mEmailSuffixList.addAll(list);
        ((TextView) _$_findCachedViewById(R$id.mTvEmailSuffix)).setText(this.mEmailSuffixList.get(this.mEmailSuffixSelectedIndex));
        if (isShowingEmailSuffixPopup()) {
            y1 y1Var = this.mEmailSuffixPopupWindow;
            ListAdapter adapter = (y1Var == null || (m10 = y1Var.m()) == null) ? null : m10.getAdapter();
            t9.i.e(adapter, "null cannot be cast to non-null type android.widget.ArrayAdapter<kotlin.String>");
            ((ArrayAdapter) adapter).notifyDataSetChanged();
        }
    }

    public final void setHintSize(String str) {
        t9.i.g(str, "hintText");
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new AbsoluteSizeSpan(12, true), 0, spannableString.length(), 33);
        ((EditText) _$_findCachedViewById(R$id.mEtInput)).setHint(new SpannedString(spannableString));
    }

    public final void setInputFilter(InputFilter inputFilter) {
        t9.i.g(inputFilter, "inputFilter");
        ((EditText) _$_findCachedViewById(R$id.mEtInput)).setFilters(new InputFilter[]{inputFilter});
    }

    public final void setInputText(String str) {
        t9.i.g(str, "inputText");
        ((EditText) _$_findCachedViewById(R$id.mEtInput)).setText(str);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EmailPrefixInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmailPrefixInputView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        this._$_findViewCache = new LinkedHashMap();
        this.mEmailSuffixSelectedIndex = -1;
        this.mEmailSuffixList = new ArrayList<>();
        setOrientation(0);
        LayoutInflater.from(context).inflate(R.layout.layout_email_prefix_input, (ViewGroup) this, true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.f7785e, i10, 0);
        t9.i.f(obtainStyledAttributes, "context.obtainStyledAttr…putView, defStyleAttr, 0)");
        String string = obtainStyledAttributes.getString(1);
        setHintSize(string == null ? "" : string);
        ((EditText) _$_findCachedViewById(R$id.mEtInput)).setTextColor(obtainStyledAttributes.getColor(2, getResources().getColor(R.color.color_999999)));
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            ((ImageView) _$_findCachedViewById(R$id.mIvClearInput)).setImageResource(resourceId);
        }
        obtainStyledAttributes.recycle();
        initListeners();
    }

    public /* synthetic */ EmailPrefixInputView(Context context, AttributeSet attributeSet, int i10, int i11, t9.g gVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
