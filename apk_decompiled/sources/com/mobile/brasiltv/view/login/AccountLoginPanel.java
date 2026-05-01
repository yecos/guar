package com.mobile.brasiltv.view.login;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.view.TitleBarView;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoLinearLayout;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class AccountLoginPanel extends AutoLinearLayout implements ILoginPanel {
    public Map<Integer, View> _$_findViewCache;
    private IAccountLoginCallback mAccountLoginCallback;
    private boolean mFindAccount;
    private boolean mFindPassword;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AccountLoginPanel(Context context) {
        this(context, null, 0, 6, null);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
    }

    private final void initListeners() {
        setFocusable(true);
        setFocusableInTouchMode(true);
        int i10 = R$id.mTvForgetPwd;
        ((TextView) _$_findCachedViewById(i10)).getPaint().setFlags(8);
        ((TextView) _$_findCachedViewById(i10)).getPaint().setAntiAlias(true);
        setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.login.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountLoginPanel.initListeners$lambda$0(view);
            }
        });
        ((TitleBarView) _$_findCachedViewById(R$id.mTbvTitle)).setOnBackClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.login.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountLoginPanel.initListeners$lambda$1(AccountLoginPanel.this, view);
            }
        });
        ((AccountEditView) _$_findCachedViewById(R$id.mAevAccount)).setAccountEditCallback(new IAccountEditCallback() { // from class: com.mobile.brasiltv.view.login.AccountLoginPanel$initListeners$3
            @Override // com.mobile.brasiltv.view.login.IAccountEditCallback
            public void onTextChanged(String str) {
                t9.i.g(str, "content");
                AccountLoginPanel.this.mFindAccount = !TextUtils.isEmpty(str);
                AccountLoginPanel.this.updateLoginBtnEnable();
            }
        });
        ((PasswordEditView) _$_findCachedViewById(R$id.mPevPassword)).setPwdEditCallback(new IPwdEditCallback() { // from class: com.mobile.brasiltv.view.login.AccountLoginPanel$initListeners$4
            @Override // com.mobile.brasiltv.view.login.IPwdEditCallback
            public void onTextChanged(String str) {
                t9.i.g(str, "content");
                AccountLoginPanel.this.mFindPassword = !TextUtils.isEmpty(str);
                AccountLoginPanel.this.updateLoginBtnEnable();
            }
        });
        ((TextView) _$_findCachedViewById(i10)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.login.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountLoginPanel.initListeners$lambda$2(AccountLoginPanel.this, view);
            }
        });
        ((TextView) _$_findCachedViewById(R$id.mTvLogin)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.login.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountLoginPanel.initListeners$lambda$3(AccountLoginPanel.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListeners$lambda$0(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListeners$lambda$1(AccountLoginPanel accountLoginPanel, View view) {
        t9.i.g(accountLoginPanel, "this$0");
        IAccountLoginCallback iAccountLoginCallback = accountLoginPanel.mAccountLoginCallback;
        if (iAccountLoginCallback != null) {
            iAccountLoginCallback.onClosePanel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListeners$lambda$2(AccountLoginPanel accountLoginPanel, View view) {
        t9.i.g(accountLoginPanel, "this$0");
        IAccountLoginCallback iAccountLoginCallback = accountLoginPanel.mAccountLoginCallback;
        if (iAccountLoginCallback != null) {
            iAccountLoginCallback.onForgetPwd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListeners$lambda$3(AccountLoginPanel accountLoginPanel, View view) {
        t9.i.g(accountLoginPanel, "this$0");
        accountLoginPanel.requestFocus();
        IAccountLoginCallback iAccountLoginCallback = accountLoginPanel.mAccountLoginCallback;
        if (iAccountLoginCallback != null) {
            iAccountLoginCallback.onAccountLogin(((AccountEditView) accountLoginPanel._$_findCachedViewById(R$id.mAevAccount)).getAccount(), ((PasswordEditView) accountLoginPanel._$_findCachedViewById(R$id.mPevPassword)).getPassword());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateLoginBtnEnable() {
        ((TextView) _$_findCachedViewById(R$id.mTvLogin)).setEnabled(this.mFindAccount && this.mFindPassword);
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

    @Override // com.mobile.brasiltv.view.login.ILoginPanel
    public void cancelSmsCountDown() {
    }

    @Override // com.mobile.brasiltv.view.login.ILoginPanel
    public void closeLoginPanel() {
        IAccountLoginCallback iAccountLoginCallback = this.mAccountLoginCallback;
        if (iAccountLoginCallback != null) {
            iAccountLoginCallback.onClosePanel();
        }
    }

    @Override // com.mobile.brasiltv.view.login.ILoginPanel
    public void fillAccount(String str) {
        t9.i.g(str, "account");
        if (str.length() > 0) {
            ((AccountEditView) _$_findCachedViewById(R$id.mAevAccount)).setText(str);
        }
    }

    @Override // com.mobile.brasiltv.view.login.ILoginPanel
    public String getMobile() {
        return "";
    }

    @Override // com.mobile.brasiltv.view.login.ILoginPanel
    public void hideErrorHint(long j10) {
    }

    public final void isEmailLogin(boolean z10) {
        AccountEditView accountEditView = (AccountEditView) _$_findCachedViewById(R$id.mAevAccount);
        String string = getContext().getString(z10 ? R.string.enter_email_hint : R.string.enter_account_hint);
        t9.i.f(string, "context.getString(if (is…tring.enter_account_hint)");
        accountEditView.setHint(string);
    }

    public final void setAccountLoginCallback(IAccountLoginCallback iAccountLoginCallback) {
        t9.i.g(iAccountLoginCallback, "callback");
        this.mAccountLoginCallback = iAccountLoginCallback;
    }

    public final void setDeviceId(String str) {
        t9.i.g(str, "deviceId");
        ((TextView) _$_findCachedViewById(R$id.mTvDeviceId)).setText(str);
    }

    @Override // com.mobile.brasiltv.view.login.ILoginPanel
    public void showErrorHint(String str) {
        t9.i.g(str, "errorHint");
    }

    @Override // com.mobile.brasiltv.view.login.ILoginPanel
    public void startSmsCountDown() {
    }

    @Override // com.mobile.brasiltv.view.login.ILoginPanel
    public void updateAreaInfo(String str, String str2) {
        t9.i.g(str, "area");
        t9.i.g(str2, "areaCode");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AccountLoginPanel(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountLoginPanel(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        this._$_findViewCache = new LinkedHashMap();
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.layout_account_login_panel, (ViewGroup) this, true);
        initListeners();
    }

    public /* synthetic */ AccountLoginPanel(Context context, AttributeSet attributeSet, int i10, int i11, t9.g gVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
