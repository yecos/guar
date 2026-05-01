package com.mobile.brasiltv.view.dialog;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.mobile.brasiltv.R$id;
import com.msandroid.mobile.R;
import java.util.Arrays;
import java.util.Date;
import w6.i;

/* loaded from: classes3.dex */
public final class PriorityVipDialog extends CommonDialog {
    private int authDays;
    private s9.l onReceiveCallback;
    private Type type;

    public enum Type {
        QUALIFICATIONS,
        RECEIVE
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PriorityVipDialog(Context context, Type type, int i10, s9.l lVar) {
        super(context, 0, 2, null);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(type, "type");
        this.type = type;
        this.authDays = i10;
        this.onReceiveCallback = lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListener$lambda$0(PriorityVipDialog priorityVipDialog, View view) {
        t9.i.g(priorityVipDialog, "this$0");
        if (priorityVipDialog.type != Type.QUALIFICATIONS) {
            priorityVipDialog.dismiss();
            return;
        }
        com.mobile.brasiltv.utils.i1.w(priorityVipDialog.getContext(), "Use");
        s9.l lVar = priorityVipDialog.onReceiveCallback;
        if (lVar != null) {
            lVar.invoke(priorityVipDialog);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initListener$lambda$1(PriorityVipDialog priorityVipDialog, View view) {
        t9.i.g(priorityVipDialog, "this$0");
        com.mobile.brasiltv.utils.i1.w(priorityVipDialog.getContext(), "Next time");
        priorityVipDialog.dismiss();
    }

    public final int getAuthDays() {
        return this.authDays;
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public int getDialogHeight() {
        return -2;
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public int getDialogWidth() {
        return 600;
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public int getLayoutId() {
        return R.layout.dialog_priority_vip;
    }

    public final s9.l getOnReceiveCallback() {
        return this.onReceiveCallback;
    }

    public final Type getType() {
        return this.type;
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public void initListener() {
        ((Button) findViewById(R$id.mBtnConfirm)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.dialog.u0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PriorityVipDialog.initListener$lambda$0(PriorityVipDialog.this, view);
            }
        });
        ((Button) findViewById(R$id.mBtnCancel)).setOnClickListener(new View.OnClickListener() { // from class: com.mobile.brasiltv.view.dialog.v0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PriorityVipDialog.initListener$lambda$1(PriorityVipDialog.this, view);
            }
        });
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog
    public void initView() {
        if (this.type == Type.QUALIFICATIONS) {
            t9.z zVar = t9.z.f18964a;
            String string = getContext().getString(R.string.advance_enjoy_vip_basic_content);
            t9.i.f(string, "context.getString(R.stri…_enjoy_vip_basic_content)");
            String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(this.authDays)}, 1));
            t9.i.f(format, "format(format, *args)");
            SpannableString spannableString = new SpannableString(format);
            spannableString.setSpan(new UnderlineSpan(), ba.t.y(spannableString, ".", 0, false, 6, null) + 2, spannableString.length(), 17);
            ((TextView) findViewById(R$id.mTvContentFirst)).setText(spannableString);
            ((Button) findViewById(R$id.mBtnConfirm)).setText(getContext().getString(R.string.advance_enjoy_vip_use));
            ((Button) findViewById(R$id.mBtnCancel)).setVisibility(0);
        } else {
            t9.z zVar2 = t9.z.f18964a;
            String string2 = getContext().getString(R.string.advance_enjoy_vip_obtained_content);
            t9.i.f(string2, "context.getString(R.stri…joy_vip_obtained_content)");
            String format2 = String.format(string2, Arrays.copyOf(new Object[]{Integer.valueOf(this.authDays)}, 1));
            t9.i.f(format2, "format(format, *args)");
            SpannableString spannableString2 = new SpannableString(format2);
            spannableString2.setSpan(new UnderlineSpan(), ba.t.y(spannableString2, ".", 0, false, 6, null) + 2, spannableString2.length(), 17);
            ((TextView) findViewById(R$id.mTvContentFirst)).setText(spannableString2);
            ((Button) findViewById(R$id.mBtnConfirm)).setText(getContext().getString(R.string.common_ok));
            ((Button) findViewById(R$id.mBtnCancel)).setVisibility(8);
        }
        int i10 = R$id.mTvContentSecond;
        ((TextView) findViewById(i10)).setText(getContext().getString(R.string.advance_enjoy_vip_standard_content));
        SpannableString spannableString3 = new SpannableString(getContext().getString(R.string.advance_enjoy_vip_help));
        spannableString3.setSpan(new ClickableSpan() { // from class: com.mobile.brasiltv.view.dialog.PriorityVipDialog$initView$1
            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                t9.i.g(view, "widget");
                com.mobile.brasiltv.utils.i1.w(PriorityVipDialog.this.getContext(), "Help");
                i.c cVar = w6.i.f19214g;
                boolean b10 = t9.i.b(cVar.e(), "0");
                Context context = PriorityVipDialog.this.getContext();
                t9.i.f(context, com.umeng.analytics.pro.f.X);
                com.mobile.brasiltv.utils.b0.j0(context, com.mobile.brasiltv.utils.b0.x(m7.c.g()) + "/#/app-help?isFree=" + b10 + "&appId=" + na.a.g() + "&userId=" + cVar.H() + "&lang=" + com.mobile.brasiltv.utils.f0.a() + "&appVersion=" + na.a.b() + "&timestamp=" + new Date().getTime() + "&portalCode=" + cVar.v(), false, true, false, false, 24, null);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                t9.i.g(textPaint, "ds");
                super.updateDrawState(textPaint);
                textPaint.setColor(PriorityVipDialog.this.getContext().getResources().getColor(R.color.color_important));
            }
        }, 0, spannableString3.length(), 33);
        ((TextView) findViewById(i10)).append(spannableString3);
        ((TextView) findViewById(i10)).setMovementMethod(LinkMovementMethod.getInstance());
    }

    public final void setAuthDays(int i10) {
        this.authDays = i10;
    }

    public final void setOnReceiveCallback(s9.l lVar) {
        this.onReceiveCallback = lVar;
    }

    public final void setType(Type type) {
        t9.i.g(type, "<set-?>");
        this.type = type;
    }

    public /* synthetic */ PriorityVipDialog(Context context, Type type, int i10, s9.l lVar, int i11, t9.g gVar) {
        this(context, type, i10, (i11 & 8) != 0 ? null : lVar);
    }
}
