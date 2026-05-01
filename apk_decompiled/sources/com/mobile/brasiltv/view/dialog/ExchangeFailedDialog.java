package com.mobile.brasiltv.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.hpplay.sdk.source.common.global.Constant;
import com.mobile.brasiltv.R$id;
import com.msandroid.mobile.R;
import com.taobao.accs.common.Constants;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class ExchangeFailedDialog extends Dialog {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExchangeFailedDialog(Context context) {
        super(context, R.style.SimpleDialog);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        setContentView(R.layout.dialog_exchange_failed);
        ((TextView) findViewById(R$id.mButtonOK)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.dialog.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExchangeFailedDialog._init_$lambda$0(ExchangeFailedDialog.this, view);
            }
        });
        ((ImageView) findViewById(R$id.mIvClose)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.dialog.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExchangeFailedDialog._init_$lambda$1(ExchangeFailedDialog.this, view);
            }
        });
        setCancelable(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(ExchangeFailedDialog exchangeFailedDialog, View view) {
        t9.i.g(exchangeFailedDialog, "this$0");
        exchangeFailedDialog.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(ExchangeFailedDialog exchangeFailedDialog, View view) {
        t9.i.g(exchangeFailedDialog, "this$0");
        exchangeFailedDialog.cancel();
    }

    public final void setErrorHint(String str) {
        t9.i.g(str, "errorHint");
        int i10 = R$id.mTvErrorHint;
        ((TextView) findViewById(i10)).setVisibility(0);
        ((TextView) findViewById(i10)).setText(str);
    }

    public final void setRedeemCode(String str) {
        t9.i.g(str, Constants.KEY_HTTP_CODE);
        TextView textView = (TextView) findViewById(R$id.mTvRedeemCode);
        t9.z zVar = t9.z.f18964a;
        String string = getContext().getResources().getString(R.string.exchange_redeem_code);
        t9.i.f(string, "context.resources.getStr…ing.exchange_redeem_code)");
        String format = String.format(string, Arrays.copyOf(new Object[]{str}, 1));
        t9.i.f(format, "format(format, *args)");
        textView.setText(Html.fromHtml(format));
    }

    public final void setServiceDays(String str) {
        t9.i.g(str, "serviceDays");
        int i10 = R$id.mTvServiceDays;
        ((TextView) findViewById(i10)).setVisibility(0);
        TextView textView = (TextView) findViewById(i10);
        t9.z zVar = t9.z.f18964a;
        String string = getContext().getResources().getString(R.string.exchange_service_days);
        t9.i.f(string, "context.resources.getStr…ng.exchange_service_days)");
        String format = String.format(string, Arrays.copyOf(new Object[]{str}, 1));
        t9.i.f(format, "format(format, *args)");
        textView.setText(Html.fromHtml(format));
    }

    public final void setStatus(String str) {
        t9.i.g(str, Constant.KEY_STATUS);
        TextView textView = (TextView) findViewById(R$id.mTvRedeemCodeStatus);
        t9.z zVar = t9.z.f18964a;
        String string = getContext().getResources().getString(R.string.exchange_redeem_code_status);
        t9.i.f(string, "context.resources.getStr…hange_redeem_code_status)");
        String format = String.format(string, Arrays.copyOf(new Object[]{str}, 1));
        t9.i.f(format, "format(format, *args)");
        textView.setText(Html.fromHtml(format));
    }

    public final void setTimeOfUsed(String str) {
        t9.i.g(str, "usedDay");
        int i10 = R$id.mTvTimeOfUsed;
        ((TextView) findViewById(i10)).setVisibility(0);
        TextView textView = (TextView) findViewById(i10);
        t9.z zVar = t9.z.f18964a;
        String string = getContext().getResources().getString(R.string.exchange_time_of_use);
        t9.i.f(string, "context.resources.getStr…ing.exchange_time_of_use)");
        String format = String.format(string, Arrays.copyOf(new Object[]{str}, 1));
        t9.i.f(format, "format(format, *args)");
        textView.setText(Html.fromHtml(format));
    }

    public final void setValidUntil(String str) {
        t9.i.g(str, "validDay");
        int i10 = R$id.mTvValidUntil;
        ((TextView) findViewById(i10)).setVisibility(0);
        TextView textView = (TextView) findViewById(i10);
        t9.z zVar = t9.z.f18964a;
        String string = getContext().getResources().getString(R.string.exchange_valid_until);
        t9.i.f(string, "context.resources.getStr…ing.exchange_valid_until)");
        String format = String.format(string, Arrays.copyOf(new Object[]{str}, 1));
        t9.i.f(format, "format(format, *args)");
        textView.setText(Html.fromHtml(format));
    }
}
