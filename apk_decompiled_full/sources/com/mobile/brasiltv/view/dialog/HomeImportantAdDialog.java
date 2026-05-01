package com.mobile.brasiltv.view.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import com.advertlib.bean.AdInfo;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.app.App;
import com.msandroid.mobile.R;
import com.titans.entity.CdnType;
import io.reactivex.disposables.Disposable;

/* loaded from: classes3.dex */
public final class HomeImportantAdDialog extends BaseDialog {
    private final AdInfo adInfo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomeImportantAdDialog(Context context, AdInfo adInfo) {
        super(context);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(adInfo, "adInfo");
        this.adInfo = adInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(HomeImportantAdDialog homeImportantAdDialog, View view) {
        t9.i.g(homeImportantAdDialog, "this$0");
        com.mobile.brasiltv.utils.b0.j(homeImportantAdDialog);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0028, code lost:
    
        if ((r14.length() > 0) == true) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void onCreate$lambda$2(HomeImportantAdDialog homeImportantAdDialog, View view) {
        boolean z10;
        t9.i.g(homeImportantAdDialog, "this$0");
        if (t9.i.b(homeImportantAdDialog.adInfo.getAction_type(), "1")) {
            String action = homeImportantAdDialog.adInfo.getAction();
            if (action != null) {
                z10 = true;
            }
            z10 = false;
            if (z10) {
                s1.q qVar = s1.q.f18727a;
                Context context = homeImportantAdDialog.getContext();
                t9.i.f(context, com.umeng.analytics.pro.f.X);
                d6.b bVar = d6.b.f12660a;
                Context context2 = homeImportantAdDialog.getContext();
                t9.i.f(context2, com.umeng.analytics.pro.f.X);
                qVar.h(context, bVar.m(context2), a6.a.f228a.i(), homeImportantAdDialog.adInfo);
                com.mobile.brasiltv.utils.i1.e(homeImportantAdDialog.getContext(), "EVENT_AD_CLICK_HOME_IMPORTANT");
                String c10 = com.mobile.brasiltv.utils.r0.c(com.mobile.brasiltv.utils.r0.f8743a, homeImportantAdDialog.adInfo.getAction(), false, 2, null);
                Context context3 = homeImportantAdDialog.getContext();
                t9.i.f(context3, com.umeng.analytics.pro.f.X);
                com.mobile.brasiltv.utils.b0.j0(context3, c10, false, true, false, false, 24, null);
                com.mobile.brasiltv.utils.b0.j(homeImportantAdDialog);
                return;
            }
        }
        if (t9.i.b(homeImportantAdDialog.adInfo.getAction_type(), CdnType.DIGITAL_TYPE_PCDN)) {
            Context context4 = homeImportantAdDialog.getContext();
            t9.i.f(context4, com.umeng.analytics.pro.f.X);
            com.mobile.brasiltv.utils.b0.m(context4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$3(Disposable disposable, DialogInterface dialogInterface) {
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
        setContentView(R.layout.dialog_home_important_ad);
        Window window = getWindow();
        if (window != null) {
            window.setDimAmount(0.3f);
        }
        Window window2 = getWindow();
        WindowManager.LayoutParams attributes = window2 != null ? window2.getAttributes() : null;
        if (attributes != null) {
            attributes.gravity = 17;
            attributes.width = -1;
            attributes.height = -1;
            Window window3 = getWindow();
            if (window3 != null) {
                window3.setAttributes(attributes);
            }
        }
        setCanceledOnTouchOutside(false);
        ((ImageView) findViewById(R$id.mIvClose)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.dialog.f0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeImportantAdDialog.onCreate$lambda$1(HomeImportantAdDialog.this, view);
            }
        });
        App.a aVar = App.f8263e;
        com.mobile.brasiltv.utils.c j10 = aVar.a().j();
        String e10 = ma.m.e(this.adInfo.getUrl());
        t9.i.f(e10, "md5(adInfo.url)");
        j10.i(e10);
        aVar.a().j().j(SystemClock.elapsedRealtime());
        s1.m mVar = s1.m.f18686a;
        Context context = getContext();
        t9.i.f(context, com.umeng.analytics.pro.f.X);
        int i10 = R$id.mIvAd;
        ImageView imageView = (ImageView) findViewById(i10);
        t9.i.f(imageView, "mIvAd");
        a6.a aVar2 = a6.a.f228a;
        mVar.g0(context, imageView, aVar2.i(), this.adInfo, (r23 & 16) != 0 ? null : null, (r23 & 32) != 0 ? null : null, (r23 & 64) != 0 ? null : null, (r23 & 128) != 0 ? false : false, (r23 & 256) != 0 ? -1 : 1);
        ((ImageView) findViewById(i10)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.dialog.g0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeImportantAdDialog.onCreate$lambda$2(HomeImportantAdDialog.this, view);
            }
        });
        s1.q qVar = s1.q.f18727a;
        Context context2 = getContext();
        t9.i.f(context2, com.umeng.analytics.pro.f.X);
        d6.b bVar = d6.b.f12660a;
        Context context3 = getContext();
        t9.i.f(context3, com.umeng.analytics.pro.f.X);
        qVar.j(context2, bVar.m(context3), aVar2.i(), this.adInfo);
        Context context4 = getContext();
        t9.i.f(context4, com.umeng.analytics.pro.f.X);
        mVar.d0(context4, aVar2.i(), this.adInfo.getAd_id());
        com.mobile.brasiltv.utils.i1.e(getContext(), "EVENT_AD_SHOW_HOME_IMPORTANT");
        final Disposable p10 = com.mobile.brasiltv.utils.i1.p(getContext(), "EVENT_AD_LONG_SHOW_HOME_IMPORTANT");
        setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.mobile.brasiltv.view.dialog.h0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                HomeImportantAdDialog.onCreate$lambda$3(Disposable.this, dialogInterface);
            }
        });
    }
}
