package f6;

import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.msandroid.mobile.R;
import com.zhy.autolayout.utils.AutoUtils;
import java.text.DecimalFormat;
import java.util.Map;
import mobile.com.requestframe.utils.response.CouponCodeList;
import s9.l;

/* loaded from: classes3.dex */
public final class b extends BaseQuickAdapter {

    /* renamed from: a, reason: collision with root package name */
    public l f13304a;

    public b() {
        super(R.layout.itme_coupons);
    }

    public static final void c(b bVar, CouponCodeList couponCodeList, View view) {
        t9.i.g(bVar, "this$0");
        t9.i.g(couponCodeList, "$item");
        l lVar = bVar.f13304a;
        if (lVar != null) {
            lVar.invoke(couponCodeList);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002d, code lost:
    
        if (r0.equals("1") == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0026, code lost:
    
        if (r0.equals("2") == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0030, code lost:
    
        r0 = r8.setGone(com.msandroid.mobile.R.id.tvRedeem, false).setGone(com.msandroid.mobile.R.id.ivState, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0040, code lost:
    
        if ("1".equals(r9.getStatus()) == false) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0042, code lost:
    
        r1 = com.msandroid.mobile.R.drawable.icon_coupons_used;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0049, code lost:
    
        r0.setImageResource(com.msandroid.mobile.R.id.ivState, r1);
        r8.itemView.setSelected(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0046, code lost:
    
        r1 = com.msandroid.mobile.R.drawable.icon_coupons_expired;
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
    public void convert(com.chad.library.adapter.base.BaseViewHolder r8, final mobile.com.requestframe.utils.response.CouponCodeList r9) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f6.b.convert(com.chad.library.adapter.base.BaseViewHolder, mobile.com.requestframe.utils.response.CouponCodeList):void");
    }

    public final String d(float f10) {
        String format = new DecimalFormat(IdManager.DEFAULT_VERSION_NAME).format(f10);
        t9.i.f(format, "format.format(number.toDouble())");
        return format;
    }

    public final void e(l lVar) {
        this.f13304a = lVar;
    }

    public final void f(TextView textView, CouponCodeList couponCodeList) {
        Float f10;
        String couponCurrency = couponCodeList.getCouponCurrency();
        if (couponCurrency == null) {
            couponCurrency = "";
        }
        Map<String, Float> couponAmount = couponCodeList.getCouponAmount();
        String d10 = d((couponAmount == null || (f10 = couponAmount.get(couponCurrency)) == null) ? 0.0f : f10.floatValue());
        String str = d10 + couponCurrency;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(AutoUtils.getPercentWidthSize(24)), d10.length(), str.length(), 34);
        textView.setText(spannableStringBuilder);
    }
}
