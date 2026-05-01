package com.mobile.brasiltv.view.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.msandroid.mobile.R;

/* loaded from: classes3.dex */
public final class AdRewardedDialog extends BaseDialog {
    private final s9.l mBottomBntListener;
    private final String mBottomBntStr;
    private final String mContent;
    private final String mTopBntStr;
    private final s9.l mTopListener;

    public /* synthetic */ AdRewardedDialog(Context context, String str, String str2, String str3, s9.l lVar, s9.l lVar2, int i10, t9.g gVar) {
        this(context, str, str2, str3, (i10 & 16) != 0 ? null : lVar, (i10 & 32) != 0 ? null : lVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(AdRewardedDialog adRewardedDialog, View view) {
        t9.i.g(adRewardedDialog, "this$0");
        adRewardedDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(AdRewardedDialog adRewardedDialog, View view) {
        t9.i.g(adRewardedDialog, "this$0");
        adRewardedDialog.dismiss();
        s9.l lVar = adRewardedDialog.mTopListener;
        if (lVar != null) {
            lVar.invoke(adRewardedDialog);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(AdRewardedDialog adRewardedDialog, View view) {
        t9.i.g(adRewardedDialog, "this$0");
        adRewardedDialog.dismiss();
        s9.l lVar = adRewardedDialog.mBottomBntListener;
        if (lVar != null) {
            lVar.invoke(adRewardedDialog);
        }
    }

    public final s9.l getMBottomBntListener() {
        return this.mBottomBntListener;
    }

    public final String getMBottomBntStr() {
        return this.mBottomBntStr;
    }

    public final String getMContent() {
        return this.mContent;
    }

    public final String getMTopBntStr() {
        return this.mTopBntStr;
    }

    public final s9.l getMTopListener() {
        return this.mTopListener;
    }

    @Override // com.mobile.brasiltv.view.dialog.BaseDialog, androidx.appcompat.app.c, androidx.appcompat.app.j, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_ad_rewarded);
        Window window = getWindow();
        if (window != null) {
            window.setDimAmount(0.3f);
        }
        ((ImageView) findViewById(R$id.ivClose)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.dialog.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AdRewardedDialog.onCreate$lambda$0(AdRewardedDialog.this, view);
            }
        });
        ((TextView) findViewById(R$id.ivContent)).setText(this.mContent);
        int i10 = R$id.tvTop;
        ((TextView) findViewById(i10)).setText(this.mTopBntStr);
        int i11 = R$id.tvBottom;
        ((TextView) findViewById(i11)).setText(this.mBottomBntStr);
        ((TextView) findViewById(i10)).setSelected(true);
        ((TextView) findViewById(i11)).setSelected(true);
        ((TextView) findViewById(i10)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.dialog.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AdRewardedDialog.onCreate$lambda$1(AdRewardedDialog.this, view);
            }
        });
        ((TextView) findViewById(i11)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.dialog.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AdRewardedDialog.onCreate$lambda$2(AdRewardedDialog.this, view);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdRewardedDialog(Context context, String str, String str2, String str3, s9.l lVar, s9.l lVar2) {
        super(context);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(str, "mContent");
        t9.i.g(str2, "mTopBntStr");
        t9.i.g(str3, "mBottomBntStr");
        this.mContent = str;
        this.mTopBntStr = str2;
        this.mBottomBntStr = str3;
        this.mTopListener = lVar;
        this.mBottomBntListener = lVar2;
    }
}
