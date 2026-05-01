package f6;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hpplay.component.protocol.PlistBuilder;
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
    */
    public void convert(BaseViewHolder baseViewHolder, final ExchangeCodeItem exchangeCodeItem) {
        t9.i.g(baseViewHolder, "helper");
        t9.i.g(exchangeCodeItem, PlistBuilder.KEY_ITEM);
        String status = exchangeCodeItem.getStatus();
        switch (status.hashCode()) {
        }
        baseViewHolder.setText(R.id.tvExchangeCode, d(exchangeCodeItem.getExchangeCode())).setText(R.id.tvDate, this.mContext.getString(R.string.exchange_code_date, y6.b.d(exchangeCodeItem.getRecordDate(), "dd-MM-yyyy")));
        String invalidTime = exchangeCodeItem.getInvalidTime();
        if (invalidTime == null || invalidTime.length() == 0) {
            baseViewHolder.setVisible(R.id.tvValid, false);
        } else {
            baseViewHolder.setVisible(R.id.tvValid, true).setText(R.id.tvValid, this.mContext.getString(R.string.benefits_valid_until, y6.b.d(exchangeCodeItem.getInvalidTime(), "dd-MM-yyyy")));
        }
        View view = baseViewHolder.getView(R.id.tvDay);
        t9.i.f(view, "helper.getView(R.id.tvDay)");
        e((TextView) view, String.valueOf(exchangeCodeItem.getAuthDay()));
        baseViewHolder.getView(R.id.tvCopy).setOnClickListener(new View.OnClickListener() { // from class: f6.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                e.c(e.this, exchangeCodeItem, view2);
            }
        });
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
