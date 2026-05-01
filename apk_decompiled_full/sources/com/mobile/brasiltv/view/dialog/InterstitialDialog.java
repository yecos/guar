package com.mobile.brasiltv.view.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.advertlib.bean.AdInfo;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.app.App;
import com.mobile.brasiltv.view.AutoCardView;
import com.mobile.brasiltv.view.RoundedImageView;
import com.msandroid.mobile.R;
import com.titans.entity.CdnType;
import com.zhy.autolayout.utils.AutoUtils;
import io.reactivex.disposables.Disposable;

/* loaded from: classes3.dex */
public final class InterstitialDialog extends BaseDialog {
    private final AdInfo adInfo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InterstitialDialog(Context context, AdInfo adInfo) {
        super(context);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(adInfo, "adInfo");
        this.adInfo = adInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(InterstitialDialog interstitialDialog, View view) {
        t9.i.g(interstitialDialog, "this$0");
        com.mobile.brasiltv.utils.b0.j(interstitialDialog);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(InterstitialDialog interstitialDialog, View view) {
        t9.i.g(interstitialDialog, "this$0");
        AdInfo adInfo = interstitialDialog.adInfo;
        if (t9.i.b(adInfo != null ? adInfo.getAction_type() : null, "1")) {
            String action = interstitialDialog.adInfo.getAction();
            if (action != null && action.length() > 0) {
                s1.q qVar = s1.q.f18727a;
                Context context = interstitialDialog.getContext();
                t9.i.f(context, com.umeng.analytics.pro.f.X);
                d6.b bVar = d6.b.f12660a;
                Context context2 = interstitialDialog.getContext();
                t9.i.f(context2, com.umeng.analytics.pro.f.X);
                qVar.h(context, bVar.m(context2), a6.a.f228a.d(), interstitialDialog.adInfo);
                com.mobile.brasiltv.utils.i1.e(interstitialDialog.getContext(), "EVENT_AD_CLICK_INTERSTITIA");
                String c10 = com.mobile.brasiltv.utils.r0.c(com.mobile.brasiltv.utils.r0.f8743a, interstitialDialog.adInfo.getAction(), false, 2, null);
                Context context3 = interstitialDialog.getContext();
                t9.i.f(context3, com.umeng.analytics.pro.f.X);
                com.mobile.brasiltv.utils.b0.j0(context3, c10, false, true, false, false, 24, null);
                com.mobile.brasiltv.utils.b0.j(interstitialDialog);
                return;
            }
        }
        AdInfo adInfo2 = interstitialDialog.adInfo;
        if (t9.i.b(adInfo2 != null ? adInfo2.getAction_type() : null, CdnType.DIGITAL_TYPE_PCDN)) {
            Context context4 = interstitialDialog.getContext();
            t9.i.f(context4, com.umeng.analytics.pro.f.X);
            com.mobile.brasiltv.utils.b0.m(context4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(Disposable disposable, DialogInterface dialogInterface) {
        if (disposable.isDisposed()) {
            return;
        }
        disposable.dispose();
    }

    public final AdInfo getAdInfo() {
        return this.adInfo;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        com.mobile.brasiltv.utils.b0.j(this);
    }

    @Override // com.mobile.brasiltv.view.dialog.BaseDialog, androidx.appcompat.app.c, androidx.appcompat.app.j, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_interstitial);
        Window window = getWindow();
        if (window != null) {
            window.setDimAmount(0.3f);
        }
        setCanceledOnTouchOutside(false);
        ((AutoCardView) findViewById(R$id.mAcvWrapper)).setRadius(AutoUtils.getPercentWidthSize(20));
        if (this.adInfo.isShowFlag()) {
            ((TextView) findViewById(R$id.mTvFlag)).setVisibility(0);
        } else {
            ((TextView) findViewById(R$id.mTvFlag)).setVisibility(8);
        }
        ((ImageView) findViewById(R$id.ivClose)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.dialog.l0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InterstitialDialog.onCreate$lambda$0(InterstitialDialog.this, view);
            }
        });
        com.mobile.brasiltv.utils.c j10 = App.f8263e.a().j();
        String e10 = ma.m.e(this.adInfo.getUrl());
        t9.i.f(e10, "md5(adInfo.url)");
        j10.l(e10);
        s1.m mVar = s1.m.f18686a;
        Context context = getContext();
        t9.i.f(context, com.umeng.analytics.pro.f.X);
        int i10 = R$id.ivInterstitial;
        RoundedImageView roundedImageView = (RoundedImageView) findViewById(i10);
        t9.i.f(roundedImageView, "ivInterstitial");
        a6.a aVar = a6.a.f228a;
        mVar.g0(context, roundedImageView, aVar.d(), this.adInfo, (r23 & 16) != 0 ? null : null, (r23 & 32) != 0 ? null : null, (r23 & 64) != 0 ? null : null, (r23 & 128) != 0 ? false : false, (r23 & 256) != 0 ? -1 : 0);
        ((RoundedImageView) findViewById(i10)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.dialog.m0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                InterstitialDialog.onCreate$lambda$1(InterstitialDialog.this, view);
            }
        });
        s1.q qVar = s1.q.f18727a;
        Context context2 = getContext();
        t9.i.f(context2, com.umeng.analytics.pro.f.X);
        d6.b bVar = d6.b.f12660a;
        Context context3 = getContext();
        t9.i.f(context3, com.umeng.analytics.pro.f.X);
        qVar.j(context2, bVar.m(context3), aVar.d(), this.adInfo);
        Context context4 = getContext();
        t9.i.f(context4, com.umeng.analytics.pro.f.X);
        mVar.d0(context4, aVar.d(), this.adInfo.getAd_id());
        com.mobile.brasiltv.utils.i1.e(getContext(), "EVENT_AD_SHOW_INTERSTITIA");
        final Disposable p10 = com.mobile.brasiltv.utils.i1.p(getContext(), "EVENT_AD_LONG_SHOW_INTERSTITIA");
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.mobile.brasiltv.view.dialog.n0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                InterstitialDialog.onCreate$lambda$2(Disposable.this, dialogInterface);
            }
        });
    }
}
