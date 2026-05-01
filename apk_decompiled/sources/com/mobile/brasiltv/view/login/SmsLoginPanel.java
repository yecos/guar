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
public final class SmsLoginPanel extends AutoLinearLayout implements ILoginPanel, IPickAreaCallback {
    private long DELAY_ERROR_HINT;
    public Map<Integer, View> _$_findViewCache;
    private Runnable mErrorHintRunnable;
    private boolean mFindMobile;
    private boolean mFindVerifyCode;
    private ISmsLoginCallback mSmsLoginCallback;
    private Handler mSmsLoginHandler;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SmsLoginPanel(Context context) {
        this(context, null, 0, 6, null);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
    }

    private final void initListeners() {
        setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.login.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SmsLoginPanel.initListeners$lambda$1(view);
            }
        });
        ((TitleBarView) _$_findCachedViewById(R$id.mTbvTitle)).setOnBackClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.login.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SmsLoginPanel.initListeners$lambda$2(SmsLoginPanel.this, view);
            }
        });
        ((PickAreaView) _$_findCachedViewById(R$id.mPavArea)).setPickAreaCallback(this);
        ((VerifyCodeView) _$_findCachedViewById(R$id.mVcvVerifyCode)).setVerifyCodeCallback(new IVerifyCodeCallback() { // from class: com.mobile.brasiltv.view.login.SmsLoginPanel$initListeners$3
            @Override // com.mobile.brasiltv.view.login.IVerifyCodeCallback
            public void onSendSms() {
                ISmsLoginCallback iSmsLoginCallback;
                SmsLoginPanel.this.requestFocus();
                iSmsLoginCallback = SmsLoginPanel.this.mSmsLoginCallback;
                if (iSmsLoginCallback != null) {
                    String mobile2 = SmsLoginPanel.this.getMobile();
                    SmsLoginPanel smsLoginPanel = SmsLoginPanel.this;
                    int i10 = R$id.mPavArea;
                    iSmsLoginCallback.onSendSms(mobile2, ((PickAreaView) smsLoginPanel._$_findCachedViewById(i10)).getArea(), ((PickAreaView) SmsLoginPanel.this._$_findCachedViewById(i10)).getAreaCode());
                }
            }

            @Override // com.mobile.brasiltv.view.login.IVerifyCodeCallback
            public void onVerifyCodeChanged(String str) {
                t9.i.g(str, "content");
                SmsLoginPanel.this.mFindVerifyCode = !TextUtils.isEmpty(str);
                SmsLoginPanel.this.updateLoginBtnEnable();
            }
        });
        ((TextView) _$_findCachedViewById(R$id.mTvLogin)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.login.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SmsLoginPanel.initListeners$lambda$3(SmsLoginPanel.this, view);
            }
        });
        ((TextView) _$_findCachedViewById(R$id.mTvUseMobileLogin)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.login.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SmsLoginPanel.initListeners$lambda$4(SmsLoginPanel.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListeners$lambda$1(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListeners$lambda$2(SmsLoginPanel smsLoginPanel, View view) {
        t9.i.g(smsLoginPanel, "this$0");
        ISmsLoginCallback iSmsLoginCallback = smsLoginPanel.mSmsLoginCallback;
        if (iSmsLoginCallback != null) {
            iSmsLoginCallback.onClosePanel();
        }
        ((VerifyCodeView) smsLoginPanel._$_findCachedViewById(R$id.mVcvVerifyCode)).cancelCountDown();
        smsLoginPanel.mSmsLoginHandler.removeCallbacks(smsLoginPanel.mErrorHintRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListeners$lambda$3(SmsLoginPanel smsLoginPanel, View view) {
        t9.i.g(smsLoginPanel, "this$0");
        smsLoginPanel.requestFocus();
        ISmsLoginCallback iSmsLoginCallback = smsLoginPanel.mSmsLoginCallback;
        if (iSmsLoginCallback != null) {
            int i10 = R$id.mPavArea;
            iSmsLoginCallback.onSmsLogin(((PickAreaView) smsLoginPanel._$_findCachedViewById(i10)).getArea(), ((PickAreaView) smsLoginPanel._$_findCachedViewById(i10)).getAreaCode(), ((PickAreaView) smsLoginPanel._$_findCachedViewById(i10)).getAreaMobile(), ((VerifyCodeView) smsLoginPanel._$_findCachedViewById(R$id.mVcvVerifyCode)).getVerifyCode());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListeners$lambda$4(SmsLoginPanel smsLoginPanel, View view) {
        t9.i.g(smsLoginPanel, "this$0");
        ISmsLoginCallback iSmsLoginCallback = smsLoginPanel.mSmsLoginCallback;
        if (iSmsLoginCallback != null) {
            iSmsLoginCallback.onUseMobileLogin();
        }
    }

    private final void initViews() {
        setFocusable(true);
        setFocusableInTouchMode(true);
        int i10 = R$id.mTvUseMobileLogin;
        ((TextView) _$_findCachedViewById(i10)).getPaint().setFlags(8);
        ((TextView) _$_findCachedViewById(i10)).getPaint().setAntiAlias(true);
        showContinueCountdown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mErrorHintRunnable$lambda$0(SmsLoginPanel smsLoginPanel) {
        t9.i.g(smsLoginPanel, "this$0");
        smsLoginPanel.hideErrorHint();
    }

    private final void showContinueCountdown() {
        long currentTimeMillis = 180 - ((System.currentTimeMillis() - com.mobile.brasiltv.utils.k.f8726a.b("key_verifycode_bind_time")) / 1000);
        if (currentTimeMillis > 0) {
            ((VerifyCodeView) _$_findCachedViewById(R$id.mVcvVerifyCode)).startCountDown(currentTimeMillis);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateLoginBtnEnable() {
        ((TextView) _$_findCachedViewById(R$id.mTvLogin)).setEnabled(this.mFindMobile && this.mFindVerifyCode);
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
        ((VerifyCodeView) _$_findCachedViewById(R$id.mVcvVerifyCode)).cancelCountDown();
    }

    @Override // com.mobile.brasiltv.view.login.ILoginPanel
    public void closeLoginPanel() {
        ISmsLoginCallback iSmsLoginCallback = this.mSmsLoginCallback;
        if (iSmsLoginCallback != null) {
            iSmsLoginCallback.onClosePanel();
        }
        ((VerifyCodeView) _$_findCachedViewById(R$id.mVcvVerifyCode)).cancelCountDown();
        this.mSmsLoginHandler.removeCallbacks(this.mErrorHintRunnable);
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
        this.mSmsLoginHandler.removeCallbacks(this.mErrorHintRunnable);
    }

    @Override // com.mobile.brasiltv.view.login.IPickAreaCallback
    public void onPickArea() {
        ISmsLoginCallback iSmsLoginCallback = this.mSmsLoginCallback;
        if (iSmsLoginCallback != null) {
            iSmsLoginCallback.onPickArea();
        }
    }

    @Override // com.mobile.brasiltv.view.login.IPickAreaCallback
    public void onTextChanged(String str) {
        t9.i.g(str, "content");
        this.mFindMobile = !TextUtils.isEmpty(str);
        ((VerifyCodeView) _$_findCachedViewById(R$id.mVcvVerifyCode)).setSendEnabled(this.mFindMobile);
        updateLoginBtnEnable();
    }

    public final void setSmsLoginCallback(ISmsLoginCallback iSmsLoginCallback) {
        t9.i.g(iSmsLoginCallback, "callback");
        this.mSmsLoginCallback = iSmsLoginCallback;
    }

    @Override // com.mobile.brasiltv.view.login.ILoginPanel
    public void showErrorHint(String str) {
        t9.i.g(str, "errorHint");
        int i10 = R$id.mTvErrorHint;
        ((TextView) _$_findCachedViewById(i10)).setVisibility(0);
        ((TextView) _$_findCachedViewById(i10)).setText(str);
        this.mSmsLoginHandler.removeCallbacks(this.mErrorHintRunnable);
        this.mSmsLoginHandler.postDelayed(this.mErrorHintRunnable, this.DELAY_ERROR_HINT);
    }

    @Override // com.mobile.brasiltv.view.login.ILoginPanel
    public void startSmsCountDown() {
        com.mobile.brasiltv.utils.k.f8726a.c("key_verifycode_bind_time", System.currentTimeMillis());
        VerifyCodeView verifyCodeView = (VerifyCodeView) _$_findCachedViewById(R$id.mVcvVerifyCode);
        t9.i.f(verifyCodeView, "mVcvVerifyCode");
        VerifyCodeView.startCountDown$default(verifyCodeView, 0L, 1, null);
    }

    @Override // com.mobile.brasiltv.view.login.ILoginPanel
    public void updateAreaInfo(String str, String str2) {
        t9.i.g(str, "area");
        t9.i.g(str2, "areaCode");
        ((PickAreaView) _$_findCachedViewById(R$id.mPavArea)).updateAreaInfo(str, str2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SmsLoginPanel(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmsLoginPanel(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        this._$_findViewCache = new LinkedHashMap();
        this.DELAY_ERROR_HINT = 5000L;
        this.mSmsLoginHandler = new Handler();
        this.mErrorHintRunnable = new Runnable() { // from class: com.mobile.brasiltv.view.login.v
            @Override // java.lang.Runnable
            public final void run() {
                SmsLoginPanel.mErrorHintRunnable$lambda$0(SmsLoginPanel.this);
            }
        };
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.layout_sms_login_panel, (ViewGroup) this, true);
        initViews();
        initListeners();
    }

    private final void hideErrorHint() {
        int i10 = R$id.mTvErrorHint;
        ((TextView) _$_findCachedViewById(i10)).setVisibility(4);
        ((TextView) _$_findCachedViewById(i10)).setText("");
    }

    public /* synthetic */ SmsLoginPanel(Context context, AttributeSet attributeSet, int i10, int i11, t9.g gVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
