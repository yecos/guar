package com.mobile.brasiltv.view.dialog;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.msandroid.mobile.R;

/* loaded from: classes3.dex */
public final class CommTipsDialog extends BaseDialog {
    private final boolean isCancelable;
    private final s9.l mBottomBntListener;
    private final String mBottomBntStr;
    private final String mContent;
    private final String mTipStr;
    private final String mTitle;
    private final String mTopBntStr;
    private final s9.l mTopListener;

    public /* synthetic */ CommTipsDialog(Context context, String str, String str2, String str3, String str4, String str5, s9.l lVar, s9.l lVar2, boolean z10, int i10, t9.g gVar) {
        this(context, str, (i10 & 4) != 0 ? null : str2, (i10 & 8) != 0 ? null : str3, (i10 & 16) != 0 ? null : str4, (i10 & 32) != 0 ? null : str5, (i10 & 64) != 0 ? null : lVar, (i10 & 128) != 0 ? null : lVar2, (i10 & 256) != 0 ? true : z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(CommTipsDialog commTipsDialog, View view) {
        t9.i.g(commTipsDialog, "this$0");
        commTipsDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(CommTipsDialog commTipsDialog, View view) {
        t9.i.g(commTipsDialog, "this$0");
        commTipsDialog.dismiss();
        s9.l lVar = commTipsDialog.mTopListener;
        if (lVar != null) {
            lVar.invoke(commTipsDialog);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(CommTipsDialog commTipsDialog, View view) {
        t9.i.g(commTipsDialog, "this$0");
        commTipsDialog.dismiss();
        s9.l lVar = commTipsDialog.mBottomBntListener;
        if (lVar != null) {
            lVar.invoke(commTipsDialog);
        }
    }

    private final void setTextView(TextView textView, String str) {
        if (TextUtils.isEmpty(str)) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        textView.setText(str);
        textView.setSelected(true);
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

    public final String getMTipStr() {
        return this.mTipStr;
    }

    public final String getMTitle() {
        return this.mTitle;
    }

    public final String getMTopBntStr() {
        return this.mTopBntStr;
    }

    public final s9.l getMTopListener() {
        return this.mTopListener;
    }

    public final boolean isCancelable() {
        return this.isCancelable;
    }

    @Override // com.mobile.brasiltv.view.dialog.BaseDialog, androidx.appcompat.app.c, androidx.appcompat.app.j, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_comm_tips);
        Window window = getWindow();
        if (window != null) {
            window.setDimAmount(0.3f);
        }
        setCancelable(this.isCancelable);
        ((ImageView) findViewById(R$id.ivClose)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.dialog.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommTipsDialog.onCreate$lambda$0(CommTipsDialog.this, view);
            }
        });
        ((TextView) findViewById(R$id.ivContent)).setText(this.mContent);
        TextView textView = (TextView) findViewById(R$id.tvTitle);
        t9.i.f(textView, "tvTitle");
        setTextView(textView, this.mTitle);
        int i10 = R$id.tvTop;
        TextView textView2 = (TextView) findViewById(i10);
        t9.i.f(textView2, "tvTop");
        setTextView(textView2, this.mTopBntStr);
        int i11 = R$id.tvBottom;
        TextView textView3 = (TextView) findViewById(i11);
        t9.i.f(textView3, "tvBottom");
        setTextView(textView3, this.mBottomBntStr);
        TextView textView4 = (TextView) findViewById(R$id.mtvTips);
        t9.i.f(textView4, "mtvTips");
        setTextView(textView4, this.mTipStr);
        ((TextView) findViewById(i10)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.dialog.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommTipsDialog.onCreate$lambda$1(CommTipsDialog.this, view);
            }
        });
        ((TextView) findViewById(i11)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.dialog.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CommTipsDialog.onCreate$lambda$2(CommTipsDialog.this, view);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommTipsDialog(Context context, String str, String str2, String str3, String str4, String str5, s9.l lVar, s9.l lVar2, boolean z10) {
        super(context);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(str, "mContent");
        this.mContent = str;
        this.mTitle = str2;
        this.mTopBntStr = str3;
        this.mBottomBntStr = str4;
        this.mTipStr = str5;
        this.mTopListener = lVar;
        this.mBottomBntListener = lVar2;
        this.isCancelable = z10;
    }
}
