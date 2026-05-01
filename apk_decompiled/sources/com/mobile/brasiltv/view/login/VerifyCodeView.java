package com.mobile.brasiltv.view.login;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.text.Editable;
import android.text.SpannableString;
import android.text.SpannedString;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.R$styleable;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoLinearLayout;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public final class VerifyCodeView extends AutoLinearLayout {
    private final long SMS_SEND_DELAY;
    private final long SMS_SEND_MAX_TIME;
    public Map<Integer, View> _$_findViewCache;
    private boolean mCountDowning;
    private boolean mFindMobile;
    private Handler mSmsSendHandler;
    private Runnable mSmsSendRunnable;
    private long mSmsSendTime;
    private IVerifyCodeCallback mVerifyCodeCallback;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VerifyCodeView(Context context) {
        this(context, null, 0, 6, null);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
    }

    private final void countdownSmsSend() {
        TextView textView = (TextView) _$_findCachedViewById(R$id.mTvSend);
        StringBuilder sb = new StringBuilder();
        sb.append(this.mSmsSendTime);
        sb.append('s');
        textView.setText(sb.toString());
        long j10 = this.mSmsSendTime - 1;
        this.mSmsSendTime = j10;
        if (j10 == 0) {
            cancelCountDown();
        } else {
            this.mSmsSendHandler.postDelayed(this.mSmsSendRunnable, this.SMS_SEND_DELAY);
        }
    }

    private final void initListeners() {
        ((EditText) _$_findCachedViewById(R$id.mEtVerifyCode)).addTextChangedListener(new TextWatcher() { // from class: com.mobile.brasiltv.view.login.VerifyCodeView$initListeners$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                IVerifyCodeCallback iVerifyCodeCallback;
                iVerifyCodeCallback = VerifyCodeView.this.mVerifyCodeCallback;
                if (iVerifyCodeCallback != null) {
                    iVerifyCodeCallback.onVerifyCodeChanged(ba.t.W(((EditText) VerifyCodeView.this._$_findCachedViewById(R$id.mEtVerifyCode)).getText().toString()).toString());
                }
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            }
        });
        ((TextView) _$_findCachedViewById(R$id.mTvSend)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.login.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VerifyCodeView.initListeners$lambda$1(VerifyCodeView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListeners$lambda$1(VerifyCodeView verifyCodeView, View view) {
        t9.i.g(verifyCodeView, "this$0");
        verifyCodeView.requestFocus();
        IVerifyCodeCallback iVerifyCodeCallback = verifyCodeView.mVerifyCodeCallback;
        if (iVerifyCodeCallback != null) {
            iVerifyCodeCallback.onSendSms();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mSmsSendRunnable$lambda$0(VerifyCodeView verifyCodeView) {
        t9.i.g(verifyCodeView, "this$0");
        verifyCodeView.countdownSmsSend();
    }

    public static /* synthetic */ void startCountDown$default(VerifyCodeView verifyCodeView, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = verifyCodeView.SMS_SEND_MAX_TIME;
        }
        verifyCodeView.startCountDown(j10);
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

    public final void cancelCountDown() {
        this.mSmsSendHandler.removeCallbacks(this.mSmsSendRunnable);
        int i10 = R$id.mTvSend;
        ((TextView) _$_findCachedViewById(i10)).setText(getResources().getString(R.string.be_send_sms));
        ((TextView) _$_findCachedViewById(i10)).setEnabled(this.mFindMobile);
        this.mCountDowning = false;
    }

    public final String getVerifyCode() {
        return ba.t.W(((EditText) _$_findCachedViewById(R$id.mEtVerifyCode)).getText().toString()).toString();
    }

    public final void setHintSize(String str) {
        t9.i.g(str, "hintText");
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new AbsoluteSizeSpan(12, true), 0, spannableString.length(), 33);
        ((EditText) _$_findCachedViewById(R$id.mEtVerifyCode)).setHint(new SpannedString(spannableString));
    }

    public final void setSendEnabled(boolean z10) {
        this.mFindMobile = z10;
        ((TextView) _$_findCachedViewById(R$id.mTvSend)).setEnabled(!this.mCountDowning && z10);
    }

    public final void setVerifyCodeCallback(IVerifyCodeCallback iVerifyCodeCallback) {
        t9.i.g(iVerifyCodeCallback, "callback");
        this.mVerifyCodeCallback = iVerifyCodeCallback;
    }

    public final void startCountDown(long j10) {
        this.mCountDowning = true;
        ((TextView) _$_findCachedViewById(R$id.mTvSend)).setEnabled(false);
        this.mSmsSendTime = j10;
        this.mSmsSendHandler.post(this.mSmsSendRunnable);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public VerifyCodeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VerifyCodeView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        this._$_findViewCache = new LinkedHashMap();
        this.SMS_SEND_DELAY = 1000L;
        this.SMS_SEND_MAX_TIME = 180L;
        this.mSmsSendHandler = new Handler();
        this.mSmsSendRunnable = new Runnable() { // from class: com.mobile.brasiltv.view.login.b0
            @Override // java.lang.Runnable
            public final void run() {
                VerifyCodeView.mSmsSendRunnable$lambda$0(VerifyCodeView.this);
            }
        };
        setOrientation(0);
        LayoutInflater.from(context).inflate(R.layout.layout_verify_code_view, (ViewGroup) this, true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.E, i10, 0);
        t9.i.f(obtainStyledAttributes, "context.obtainStyledAttr…odeView, defStyleAttr, 0)");
        String string = obtainStyledAttributes.getString(0);
        setHintSize(string == null ? "" : string);
        obtainStyledAttributes.recycle();
        initListeners();
    }

    public /* synthetic */ VerifyCodeView(Context context, AttributeSet attributeSet, int i10, int i11, t9.g gVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
