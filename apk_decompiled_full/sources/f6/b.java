package f6;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.hpplay.component.protocol.PlistBuilder;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
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
    */
    public void convert(BaseViewHolder baseViewHolder, final CouponCodeList couponCodeList) {
        String string;
        t9.i.g(baseViewHolder, "helper");
        t9.i.g(couponCodeList, PlistBuilder.KEY_ITEM);
        String status = couponCodeList.getStatus();
        switch (status.hashCode()) {
            case 48:
                if (status.equals("0")) {
                    baseViewHolder.setGone(R.id.tvRedeem, true).setGone(R.id.ivState, false);
                    baseViewHolder.itemView.setSelected(true);
                    break;
                }
                break;
        }
        View view = baseViewHolder.getView(R.id.tvPrice);
        t9.i.f(view, "helper.getView(R.id.tvPrice)");
        f((TextView) view, couponCodeList);
        if (!"1".equals(couponCodeList.getCouponEffectType()) || TextUtils.isEmpty(couponCodeList.getEffectTime())) {
            string = this.mContext.getString(R.string.benefits_valid_until, y6.b.d(couponCodeList.getInvalidTime(), "dd-MM-yyyy"));
            t9.i.f(string, "{\n            mContext.g…,\"dd-MM-yyyy\"))\n        }");
        } else {
            string = y6.b.d(couponCodeList.getEffectTime(), "dd-MM-yyyy") + " to " + y6.b.d(couponCodeList.getInvalidTime(), "dd-MM-yyyy") + ASCIIPropertyListParser.ARRAY_BEGIN_TOKEN + this.mContext.getString(R.string.date_format) + ASCIIPropertyListParser.ARRAY_END_TOKEN;
        }
        String string2 = this.mContext.getString(R.string.coupons_use_on, couponCodeList.getPackageLabel(), couponCodeList.getPackageName());
        t9.i.f(string2, "mContext.getString(R.str…eLabel, item.packageName)");
        baseViewHolder.setText(R.id.tvCouponsTitle, couponCodeList.getCouponTitle()).setText(R.id.tvDate, string).setText(R.id.tvUseOn, string2);
        baseViewHolder.getView(R.id.tvRedeem).setOnClickListener(new View.OnClickListener() { // from class: f6.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                b.c(b.this, couponCodeList, view2);
            }
        });
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
