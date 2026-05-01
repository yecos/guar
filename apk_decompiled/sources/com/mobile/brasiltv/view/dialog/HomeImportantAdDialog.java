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
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void onCreate$lambda$2(com.mobile.brasiltv.view.dialog.HomeImportantAdDialog r13, android.view.View r14) {
        /*
            java.lang.String r14 = "this$0"
            t9.i.g(r13, r14)
            com.advertlib.bean.AdInfo r14 = r13.adInfo
            java.lang.String r14 = r14.getAction_type()
            java.lang.String r0 = "1"
            boolean r14 = t9.i.b(r14, r0)
            java.lang.String r0 = "context"
            if (r14 == 0) goto L7b
            com.advertlib.bean.AdInfo r14 = r13.adInfo
            java.lang.String r14 = r14.getAction()
            r1 = 0
            if (r14 == 0) goto L2b
            int r14 = r14.length()
            r2 = 1
            if (r14 <= 0) goto L27
            r14 = 1
            goto L28
        L27:
            r14 = 0
        L28:
            if (r14 != r2) goto L2b
            goto L2c
        L2b:
            r2 = 0
        L2c:
            if (r2 == 0) goto L7b
            s1.q r14 = s1.q.f18727a
            android.content.Context r2 = r13.getContext()
            t9.i.f(r2, r0)
            d6.b r3 = d6.b.f12660a
            android.content.Context r4 = r13.getContext()
            t9.i.f(r4, r0)
            java.lang.String r3 = r3.m(r4)
            a6.a r4 = a6.a.f228a
            java.lang.String r4 = r4.i()
            com.advertlib.bean.AdInfo r5 = r13.adInfo
            r14.h(r2, r3, r4, r5)
            android.content.Context r14 = r13.getContext()
            java.lang.String r2 = "EVENT_AD_CLICK_HOME_IMPORTANT"
            com.mobile.brasiltv.utils.i1.e(r14, r2)
            com.mobile.brasiltv.utils.r0 r14 = com.mobile.brasiltv.utils.r0.f8743a
            com.advertlib.bean.AdInfo r2 = r13.adInfo
            java.lang.String r2 = r2.getAction()
            r3 = 2
            r4 = 0
            java.lang.String r6 = com.mobile.brasiltv.utils.r0.c(r14, r2, r1, r3, r4)
            android.content.Context r5 = r13.getContext()
            t9.i.f(r5, r0)
            r7 = 0
            r8 = 1
            r9 = 0
            r10 = 0
            r11 = 24
            r12 = 0
            com.mobile.brasiltv.utils.b0.j0(r5, r6, r7, r8, r9, r10, r11, r12)
            com.mobile.brasiltv.utils.b0.j(r13)
            goto L93
        L7b:
            com.advertlib.bean.AdInfo r14 = r13.adInfo
            java.lang.String r14 = r14.getAction_type()
            java.lang.String r1 = "5"
            boolean r14 = t9.i.b(r14, r1)
            if (r14 == 0) goto L93
            android.content.Context r13 = r13.getContext()
            t9.i.f(r13, r0)
            com.mobile.brasiltv.utils.b0.m(r13)
        L93:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.view.dialog.HomeImportantAdDialog.onCreate$lambda$2(com.mobile.brasiltv.view.dialog.HomeImportantAdDialog, android.view.View):void");
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
