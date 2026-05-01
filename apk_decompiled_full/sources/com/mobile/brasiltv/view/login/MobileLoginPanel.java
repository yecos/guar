package com.mobile.brasiltv.view.login;

import android.content.Context;
import android.os.Handler;
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
public final class MobileLoginPanel extends AutoLinearLayout implements ILoginPanel, IPickAreaCallback {
    private long DELAY_ERROR_HINT;
    public Map<Integer, View> _$_findViewCache;
    private Runnable mErrorHintRunnable;
    private boolean mFindMobile;
    private boolean mFindPassword;
    private IMobileLoginCallback mMobileLoginCallback;
    private Handler mMobileLoginHandler;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MobileLoginPanel(Context context) {
        this(context, null, 0, 6, null);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
    }

    private final void initListeners() {
        setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.login.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MobileLoginPanel.initListeners$lambda$1(view);
            }
        });
        int i10 = R$id.mTvForgetPwd;
        ((TextView) _$_findCachedViewById(i10)).getPaint().setFlags(8);
        ((TextView) _$_findCachedViewById(i10)).getPaint().setAntiAlias(true);
        ((TitleBarView) _$_findCachedViewById(R$id.mTbvTitle)).setOnBackClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.login.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MobileLoginPanel.initListeners$lambda$2(MobileLoginPanel.this, view);
            }
        });
        ((PickAreaView) _$_findCachedViewById(R$id.mPavArea)).setPickAreaCallback(this);
        ((PasswordEditView) _$_findCachedViewById(R$id.mPevPassword)).setPwdEditCallback(new IPwdEditCallback() { // from class: com.mobile.brasiltv.view.login.MobileLoginPanel$initListeners$3
            @Override // com.mobile.brasiltv.view.login.IPwdEditCallback
            public void onTextChanged(String str) {
                t9.i.g(str, "content");
                MobileLoginPanel.this.mFindPassword = !TextUtils.isEmpty(str);
                MobileLoginPanel.this.updateLoginBtnEnable();
            }
        });
        ((TextView) _$_findCachedViewById(i10)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.login.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MobileLoginPanel.initListeners$lambda$3(MobileLoginPanel.this, view);
            }
        });
        ((TextView) _$_findCachedViewById(R$id.mTvLogin)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.login.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MobileLoginPanel.initListeners$lambda$4(MobileLoginPanel.this, view);
            }
        });
        ((TextView) _$_findCachedViewById(R$id.mTvUseSmsLogin)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.login.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MobileLoginPanel.initListeners$lambda$5(MobileLoginPanel.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListeners$lambda$1(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListeners$lambda$2(MobileLoginPanel mobileLoginPanel, View view) {
        t9.i.g(mobileLoginPanel, "this$0");
        IMobileLoginCallback iMobileLoginCallback = mobileLoginPanel.mMobileLoginCallback;
        if (iMobileLoginCallback != null) {
            iMobileLoginCallback.onClosePanel();
        }
        mobileLoginPanel.mMobileLoginHandler.removeCallbacks(mobileLoginPanel.mErrorHintRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListeners$lambda$3(MobileLoginPanel mobileLoginPanel, View view) {
        t9.i.g(mobileLoginPanel, "this$0");
        IMobileLoginCallback iMobileLoginCallback = mobileLoginPanel.mMobileLoginCallback;
        if (iMobileLoginCallback != null) {
            iMobileLoginCallback.onForgetPwd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListeners$lambda$4(MobileLoginPanel mobileLoginPanel, View view) {
        t9.i.g(mobileLoginPanel, "this$0");
        mobileLoginPanel.requestFocus();
        IMobileLoginCallback iMobileLoginCallback = mobileLoginPanel.mMobileLoginCallback;
        if (iMobileLoginCallback != null) {
            int i10 = R$id.mPavArea;
            iMobileLoginCallback.onMobileLogin(((PickAreaView) mobileLoginPanel._$_findCachedViewById(i10)).getArea(), ((PickAreaView) mobileLoginPanel._$_findCachedViewById(i10)).getAreaCode(), ((PickAreaView) mobileLoginPanel._$_findCachedViewById(i10)).getAreaMobile(), ((PasswordEditView) mobileLoginPanel._$_findCachedViewById(R$id.mPevPassword)).getPassword());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListeners$lambda$5(MobileLoginPanel mobileLoginPanel, View view) {
        t9.i.g(mobileLoginPanel, "this$0");
        IMobileLoginCallback iMobileLoginCallback = mobileLoginPanel.mMobileLoginCallback;
        if (iMobileLoginCallback != null) {
            iMobileLoginCallback.onUseSmsLogin();
        }
    }

    private final void initViews() {
        setFocusable(true);
        setFocusableInTouchMode(true);
        int i10 = R$id.mTvUseSmsLogin;
        ((TextView) _$_findCachedViewById(i10)).getPaint().setFlags(8);
        ((TextView) _$_findCachedViewById(i10)).getPaint().setAntiAlias(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mErrorHintRunnable$lambda$0(MobileLoginPanel mobileLoginPanel) {
        t9.i.g(mobileLoginPanel, "this$0");
        mobileLoginPanel.hideErrorHint();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateLoginBtnEnable() {
        ((TextView) _$_findCachedViewById(R$id.mTvLogin)).setEnabled(this.mFindMobile && this.mFindPassword);
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
        IMobileLoginCallback iMobileLoginCallback = this.mMobileLoginCallback;
        if (iMobileLoginCallback != null) {
            iMobileLoginCallback.onClosePanel();
        }
        this.mMobileLoginHandler.removeCallbacks(this.mErrorHintRunnable);
    }

    @Override // com.mobile.brasiltv.view.login.ILoginPanel
    public void fillAccount(String str) {
        t9.i.g(str, "account");
        if (str.length() > 0) {
            ((PickAreaView) _$_findCachedViewById(R$id.mPavArea)).fillMobile(str);
        }
    }

    public final void fillArea(String str) {
        String str2;
        t9.i.g(str, "areaCode");
        int i10 = 0;
        if (str.length() > 0) {
            String[] stringArray = getResources().getStringArray(R.array.nation);
            t9.i.f(stringArray, "resources.getStringArray(R.array.nation)");
            String[] stringArray2 = getResources().getStringArray(R.array.code);
            t9.i.f(stringArray2, "resources.getStringArray(R.array.code)");
            int length = stringArray2.length;
            while (true) {
                if (i10 >= length) {
                    str2 = "";
                    break;
                } else {
                    if (t9.i.b(stringArray2[i10], str)) {
                        str2 = stringArray[i10];
                        t9.i.f(str2, "nationData[i]");
                        break;
                    }
                    i10++;
                }
            }
            ((PickAreaView) _$_findCachedViewById(R$id.mPavArea)).fillAreaInfo(str2, str);
        }
    }

    @Override // com.mobile.brasiltv.view.login.ILoginPanel
    public String getMobile() {
        return ((PickAreaView) _$_findCachedViewById(R$id.mPavArea)).getAreaMobile();
    }

    @Override // com.mobile.brasiltv.view.login.ILoginPanel
    public void hideErrorHint(long j10) {
        hideErrorHint();
        this.mMobileLoginHandler.removeCallbacks(this.mErrorHintRunnable);
    }

    @Override // com.mobile.brasiltv.view.login.IPickAreaCallback
    public void onPickArea() {
        IMobileLoginCallback iMobileLoginCallback = this.mMobileLoginCallback;
        if (iMobileLoginCallback != null) {
            iMobileLoginCallback.onPickArea();
        }
    }

    @Override // com.mobile.brasiltv.view.login.IPickAreaCallback
    public void onTextChanged(String str) {
        t9.i.g(str, "content");
        this.mFindMobile = !TextUtils.isEmpty(str);
        updateLoginBtnEnable();
    }

    public final void setMobileLoginCallback(IMobileLoginCallback iMobileLoginCallback) {
        t9.i.g(iMobileLoginCallback, "callback");
        this.mMobileLoginCallback = iMobileLoginCallback;
    }

    @Override // com.mobile.brasiltv.view.login.ILoginPanel
    public void showErrorHint(String str) {
        t9.i.g(str, "errorHint");
        int i10 = R$id.mTvErrorHint;
        ((TextView) _$_findCachedViewById(i10)).setVisibility(0);
        ((TextView) _$_findCachedViewById(i10)).setText(str);
        this.mMobileLoginHandler.removeCallbacks(this.mErrorHintRunnable);
        this.mMobileLoginHandler.postDelayed(this.mErrorHintRunnable, this.DELAY_ERROR_HINT);
    }

    @Override // com.mobile.brasiltv.view.login.ILoginPanel
    public void startSmsCountDown() {
    }

    @Override // com.mobile.brasiltv.view.login.ILoginPanel
    public void updateAreaInfo(String str, String str2) {
        t9.i.g(str, "area");
        t9.i.g(str2, "areaCode");
        ((PickAreaView) _$_findCachedViewById(R$id.mPavArea)).updateAreaInfo(str, str2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MobileLoginPanel(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MobileLoginPanel(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        this._$_findViewCache = new LinkedHashMap();
        this.DELAY_ERROR_HINT = 5000L;
        this.mMobileLoginHandler = new Handler();
        this.mErrorHintRunnable = new Runnable() { // from class: com.mobile.brasiltv.view.login.l
            @Override // java.lang.Runnable
            public final void run() {
                MobileLoginPanel.mErrorHintRunnable$lambda$0(MobileLoginPanel.this);
            }
        };
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.layout_mobile_login_panel, (ViewGroup) this, true);
        initViews();
        initListeners();
    }

    private final void hideErrorHint() {
        int i10 = R$id.mTvErrorHint;
        ((TextView) _$_findCachedViewById(i10)).setVisibility(4);
        ((TextView) _$_findCachedViewById(i10)).setText("");
    }

    public /* synthetic */ MobileLoginPanel(Context context, AttributeSet attributeSet, int i10, int i11, t9.g gVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
