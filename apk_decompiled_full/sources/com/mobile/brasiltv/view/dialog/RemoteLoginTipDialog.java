package com.mobile.brasiltv.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import com.hpplay.cybergarage.soap.SOAP;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.ResetAty;
import com.mobile.brasiltv.bean.event.LoginSuccessEvent;
import com.mobile.brasiltv.db.UmengMessage;
import com.mobile.brasiltv.mine.activity.LoginAty;
import com.mobile.brasiltv.view.KoocanButton;
import com.msandroid.mobile.R;
import com.taobao.accs.common.Constants;
import com.zhy.autolayout.utils.AutoUtils;

/* loaded from: classes.dex */
public final class RemoteLoginTipDialog extends Dialog {
    private boolean mIsPushMsg;
    private boolean mNeedManager;
    private UmengMessage msg;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RemoteLoginTipDialog(Context context) {
        super(context, R.style.OptionDialog);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
    }

    private final int attachColor(SpannableString spannableString, String str, String str2, int i10, int i11) {
        int y10 = ba.t.y(str, SOAP.DELIM, i10, false, 4, null) + 1;
        int length = str2.length() + y10 + 1;
        spannableString.setSpan(new ForegroundColorSpan(i11), y10, length, 33);
        return length;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initData$lambda$2(RemoteLoginTipDialog remoteLoginTipDialog, View view) {
        t9.i.g(remoteLoginTipDialog, "this$0");
        ResetAty.a aVar = ResetAty.A;
        Context context = remoteLoginTipDialog.getContext();
        t9.i.f(context, com.umeng.analytics.pro.f.X);
        aVar.a(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initData$lambda$3(RemoteLoginTipDialog remoteLoginTipDialog, View view) {
        t9.i.g(remoteLoginTipDialog, "this$0");
        Intent intent = new Intent(remoteLoginTipDialog.getContext(), (Class<?>) LoginAty.class);
        intent.putExtra("can_back", true);
        remoteLoginTipDialog.getContext().startActivity(intent);
    }

    private final String tranCountryAndCity() {
        String str;
        String loginCity;
        UmengMessage umengMessage = this.msg;
        String str2 = "";
        if (umengMessage == null || (str = umengMessage.getLoginCountry()) == null) {
            str = "";
        }
        UmengMessage umengMessage2 = this.msg;
        if (umengMessage2 != null && (loginCity = umengMessage2.getLoginCity()) != null) {
            str2 = loginCity;
        }
        if (!(str.length() == 0) && !t9.i.b(str, "unknown")) {
            if (!(str2.length() == 0) && !t9.i.b(str, "unknown")) {
                return str + ", " + str2;
            }
        }
        return "unknown";
    }

    private final String tranLoginIp() {
        UmengMessage umengMessage = this.msg;
        if (TextUtils.isEmpty(umengMessage != null ? umengMessage.getLoginIp() : null)) {
            return "unknown";
        }
        UmengMessage umengMessage2 = this.msg;
        if (TextUtils.equals(umengMessage2 != null ? umengMessage2.getLoginIp() : null, "unknow")) {
            return "unknown";
        }
        UmengMessage umengMessage3 = this.msg;
        String loginIp = umengMessage3 != null ? umengMessage3.getLoginIp() : null;
        t9.i.d(loginIp);
        return loginIp;
    }

    private final String tranLoginTime() {
        long currentTimeMillis;
        UmengMessage umengMessage = this.msg;
        if (!TextUtils.isEmpty(umengMessage != null ? umengMessage.getLoginTime() : null)) {
            UmengMessage umengMessage2 = this.msg;
            if (!TextUtils.equals(umengMessage2 != null ? umengMessage2.getLoginTime() : null, "unknow")) {
                UmengMessage umengMessage3 = this.msg;
                String loginTime = umengMessage3 != null ? umengMessage3.getLoginTime() : null;
                t9.i.d(loginTime);
                currentTimeMillis = Long.parseLong(loginTime);
                String i10 = y6.a.i(currentTimeMillis, "MM/dd HH:mm");
                t9.i.f(i10, "getPatternDate(loginTime, \"MM/dd HH:mm\")");
                return i10;
            }
        }
        currentTimeMillis = System.currentTimeMillis();
        String i102 = y6.a.i(currentTimeMillis, "MM/dd HH:mm");
        t9.i.f(i102, "getPatternDate(loginTime, \"MM/dd HH:mm\")");
        return i102;
    }

    public final boolean getMIsPushMsg() {
        return this.mIsPushMsg;
    }

    public final boolean getMNeedManager() {
        return this.mNeedManager;
    }

    public final UmengMessage getMsg() {
        return this.msg;
    }

    public final void initData() {
        if (this.msg != null) {
            if (this.mIsPushMsg) {
                TextView textView = (TextView) findViewById(R$id.mTextDetail);
                UmengMessage umengMessage = this.msg;
                t9.i.d(umengMessage);
                textView.setText(umengMessage.getText());
            } else {
                String tranLoginIp = tranLoginIp();
                String tranLoginTime = tranLoginTime();
                String tranCountryAndCity = tranCountryAndCity();
                String string = getContext().getString(R.string.remote_login_info, tranLoginIp, tranLoginTime, tranCountryAndCity);
                t9.i.f(string, "context.getString(R.stri…Ip, loginTime, loginArea)");
                int color = getContext().getResources().getColor(R.color.color_ff3333);
                SpannableString spannableString = new SpannableString(string);
                attachColor(spannableString, string, tranCountryAndCity, attachColor(spannableString, string, tranLoginTime, attachColor(spannableString, string, tranLoginIp, 0, color), color), color);
                ((TextView) findViewById(R$id.mTextDetail)).setText(spannableString);
            }
        }
        ((KoocanButton) findViewById(R$id.mButtonChangePwd)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.dialog.w0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RemoteLoginTipDialog.initData$lambda$2(RemoteLoginTipDialog.this, view);
            }
        });
        ((KoocanButton) findViewById(R$id.mButtonLoginOther)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.dialog.x0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RemoteLoginTipDialog.initData$lambda$3(RemoteLoginTipDialog.this, view);
            }
        });
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_remote_login_tips);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window != null ? window.getAttributes() : null;
        if (attributes != null) {
            attributes.gravity = 17;
            attributes.width = AutoUtils.getPercentWidthSize(520);
            Window window2 = getWindow();
            if (window2 != null) {
                window2.setAttributes(attributes);
            }
        }
        xa.c.c().o(this);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        initData();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        xa.c.c().r(this);
        super.onDetachedFromWindow();
    }

    public final void setMIsPushMsg(boolean z10) {
        this.mIsPushMsg = z10;
    }

    public final void setMNeedManager(boolean z10) {
        this.mNeedManager = z10;
    }

    public final void setMsg(UmengMessage umengMessage) {
        this.msg = umengMessage;
    }

    public final void show(UmengMessage umengMessage, boolean z10) {
        t9.i.g(umengMessage, Constants.SHARED_MESSAGE_ID_FILE);
        this.msg = umengMessage;
        this.mIsPushMsg = true;
        this.mNeedManager = z10;
        if (z10) {
            com.mobile.brasiltv.utils.b0.S(this, DialogManager.DIALOG_REMOTE_LOGIN);
        } else {
            super.show();
        }
    }

    @xa.j
    public final void toClose(LoginSuccessEvent loginSuccessEvent) {
        t9.i.g(loginSuccessEvent, "event");
        if (isShowing()) {
            if (this.mNeedManager) {
                com.mobile.brasiltv.utils.b0.j(this);
            } else {
                dismiss();
            }
        }
    }

    public final void show(String str, String str2, String str3, String str4, boolean z10) {
        UmengMessage umengMessage = new UmengMessage();
        umengMessage.setLoginCountry(str);
        umengMessage.setLoginCity(str2);
        umengMessage.setLoginIp(str3);
        umengMessage.setLoginTime(str4);
        this.msg = umengMessage;
        this.mIsPushMsg = false;
        this.mNeedManager = z10;
        if (z10) {
            com.mobile.brasiltv.utils.b0.S(this, DialogManager.DIALOG_REMOTE_LOGIN);
        } else {
            super.show();
        }
    }
}
