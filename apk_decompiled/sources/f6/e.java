package f6;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.msandroid.mobile.R;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.zhy.autolayout.utils.AutoUtils;
import h9.t;
import java.util.ArrayList;
import mobile.com.requestframe.utils.response.ExchangeCodeItem;

/* loaded from: classes3.dex */
public final class e extends BaseQuickAdapter {
    public e() {
        super(R.layout.itme_exchange_record);
    }

    public static final void c(e eVar, ExchangeCodeItem exchangeCodeItem, View view) {
        t9.i.g(eVar, "this$0");
        t9.i.g(exchangeCodeItem, "$item");
        Context context = eVar.mContext;
        t9.i.f(context, "mContext");
        b0.i(context, exchangeCodeItem.getExchangeCode());
        f1.f8649a.w(R.string.copy_success);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0060, code lost:
    
        r0 = r7.mContext;
        r1 = com.msandroid.mobile.R.string.exchange_used;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x006b, code lost:
    
        r8.setText(com.msandroid.mobile.R.id.tvState, r0.getString(r1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0066, code lost:
    
        r0 = r7.mContext;
        r1 = com.msandroid.mobile.R.string.exchange_expired;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0035, code lost:
    
        if (r0.equals("1") == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004e, code lost:
    
        if (r0.equals("0") == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0023, code lost:
    
        if (r0.equals("3") != false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0038, code lost:
    
        r8.itemView.setSelected(true);
        r8.setText(com.msandroid.mobile.R.id.tvState, r7.mContext.getString(com.msandroid.mobile.R.string.exchange_unused));
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x002c, code lost:
    
        if (r0.equals("2") == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0051, code lost:
    
        r8.itemView.setSelected(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x005e, code lost:
    
        if (t9.i.b("0", r9.getStatus()) == false) goto L21;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:31)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:60)
     */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void convert(com.chad.library.adapter.base.BaseViewHolder r8, final mobile.com.requestframe.utils.response.ExchangeCodeItem r9) {
        /*
            r7 = this;
            java.lang.String r0 = "helper"
            t9.i.g(r8, r0)
            java.lang.String r0 = "item"
            t9.i.g(r9, r0)
            java.lang.String r0 = r9.getStatus()
            int r1 = r0.hashCode()
            r2 = 2131363276(0x7f0a05cc, float:1.8346356E38)
            java.lang.String r3 = "0"
            r4 = 0
            r5 = 1
            switch(r1) {
                case 48: goto L4a;
                case 49: goto L2f;
                case 50: goto L26;
                case 51: goto L1d;
                default: goto L1c;
            }
        L1c:
            goto L72
        L1d:
            java.lang.String r1 = "3"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L72
            goto L38
        L26:
            java.lang.String r1 = "2"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L51
            goto L72
        L2f:
            java.lang.String r1 = "1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L38
            goto L72
        L38:
            android.view.View r0 = r8.itemView
            r0.setSelected(r5)
            android.content.Context r0 = r7.mContext
            r1 = 2131820964(0x7f1101a4, float:1.9274658E38)
            java.lang.String r0 = r0.getString(r1)
            r8.setText(r2, r0)
            goto L72
        L4a:
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L51
            goto L72
        L51:
            android.view.View r0 = r8.itemView
            r0.setSelected(r4)
            java.lang.String r0 = r9.getStatus()
            boolean r0 = t9.i.b(r3, r0)
            if (r0 == 0) goto L66
            android.content.Context r0 = r7.mContext
            r1 = 2131820965(0x7f1101a5, float:1.927466E38)
            goto L6b
        L66:
            android.content.Context r0 = r7.mContext
            r1 = 2131820947(0x7f110193, float:1.9274623E38)
        L6b:
            java.lang.String r0 = r0.getString(r1)
            r8.setText(r2, r0)
        L72:
            java.lang.String r0 = r9.getExchangeCode()
            java.lang.String r0 = r7.d(r0)
            r1 = 2131363264(0x7f0a05c0, float:1.8346332E38)
            com.chad.library.adapter.base.BaseViewHolder r0 = r8.setText(r1, r0)
            android.content.Context r1 = r7.mContext
            java.lang.Object[] r2 = new java.lang.Object[r5]
            java.lang.String r3 = r9.getRecordDate()
            java.lang.String r6 = "dd-MM-yyyy"
            java.lang.String r3 = y6.b.d(r3, r6)
            r2[r4] = r3
            r3 = 2131820943(0x7f11018f, float:1.9274615E38)
            java.lang.String r1 = r1.getString(r3, r2)
            r2 = 2131363258(0x7f0a05ba, float:1.834632E38)
            r0.setText(r2, r1)
            java.lang.String r0 = r9.getInvalidTime()
            if (r0 == 0) goto Lad
            int r0 = r0.length()
            if (r0 != 0) goto Lab
            goto Lad
        Lab:
            r0 = 0
            goto Lae
        Lad:
            r0 = 1
        Lae:
            r1 = 2131363286(0x7f0a05d6, float:1.8346377E38)
            if (r0 == 0) goto Lb7
            r8.setVisible(r1, r4)
            goto Ld3
        Lb7:
            com.chad.library.adapter.base.BaseViewHolder r0 = r8.setVisible(r1, r5)
            android.content.Context r2 = r7.mContext
            java.lang.Object[] r3 = new java.lang.Object[r5]
            java.lang.String r5 = r9.getInvalidTime()
            java.lang.String r5 = y6.b.d(r5, r6)
            r3[r4] = r5
            r4 = 2131820659(0x7f110073, float:1.927404E38)
            java.lang.String r2 = r2.getString(r4, r3)
            r0.setText(r1, r2)
        Ld3:
            r0 = 2131363259(0x7f0a05bb, float:1.8346322E38)
            android.view.View r0 = r8.getView(r0)
            java.lang.String r1 = "helper.getView(R.id.tvDay)"
            t9.i.f(r0, r1)
            android.widget.TextView r0 = (android.widget.TextView) r0
            int r1 = r9.getAuthDay()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r7.e(r0, r1)
            r0 = 2131363255(0x7f0a05b7, float:1.8346314E38)
            android.view.View r8 = r8.getView(r0)
            f6.d r0 = new f6.d
            r0.<init>()
            r8.setOnClickListener(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: f6.e.convert(com.chad.library.adapter.base.BaseViewHolder, mobile.com.requestframe.utils.response.ExchangeCodeItem):void");
    }

    public final String d(String str) {
        char[] charArray = str.toCharArray();
        t9.i.f(charArray, "this as java.lang.String).toCharArray()");
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList(charArray.length);
        int length = charArray.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int i12 = i11 + 1;
            sb.append(charArray[i10]);
            if (i12 % 4 == 0 && i11 != charArray.length - 1) {
                sb.append(Operator.Operation.MINUS);
            }
            arrayList.add(t.f14242a);
            i10++;
            i11 = i12;
        }
        String sb2 = sb.toString();
        t9.i.f(sb2, "sbu.toString()");
        return sb2;
    }

    public final void e(TextView textView, String str) {
        String string = this.mContext.getString(R.string.exchange_days);
        t9.i.f(string, "mContext.getString(R.string.exchange_days)");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str + string);
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(AutoUtils.getPercentWidthSize(30)), str.length(), spannableStringBuilder.length(), 34);
        textView.setText(spannableStringBuilder);
    }
}
