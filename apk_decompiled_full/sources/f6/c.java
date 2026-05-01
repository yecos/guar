package f6;

import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.hpplay.component.protocol.PlistBuilder;
import com.msandroid.mobile.R;
import com.zhy.autolayout.utils.AutoUtils;
import java.text.DecimalFormat;
import java.util.Map;
import mobile.com.requestframe.utils.response.AvailableCouponCodeList;

/* loaded from: classes3.dex */
public final class c extends BaseQuickAdapter {
    public c() {
        super(R.layout.itme_coupons_available);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, AvailableCouponCodeList availableCouponCodeList) {
        t9.i.g(baseViewHolder, "helper");
        t9.i.g(availableCouponCodeList, PlistBuilder.KEY_ITEM);
        View view = baseViewHolder.getView(R.id.tvPrice);
        t9.i.f(view, "helper.getView(R.id.tvPrice)");
        c((TextView) view, availableCouponCodeList);
        String string = this.mContext.getString(R.string.coupons_use_on, availableCouponCodeList.getPackageLabel(), availableCouponCodeList.getPackageName());
        t9.i.f(string, "mContext.getString(R.str…eLabel, item.packageName)");
        baseViewHolder.setText(R.id.tvCouponsTitle, availableCouponCodeList.getCouponTitle()).setText(R.id.tvUseOn, string);
    }

    public final String b(float f10) {
        String format = new DecimalFormat(IdManager.DEFAULT_VERSION_NAME).format(f10);
        t9.i.f(format, "format.format(number.toDouble())");
        return format;
    }

    public final void c(TextView textView, AvailableCouponCodeList availableCouponCodeList) {
        Float f10;
        String couponCurrency = availableCouponCodeList.getCouponCurrency();
        if (couponCurrency == null) {
            couponCurrency = "";
        }
        Map<String, Float> couponAmount = availableCouponCodeList.getCouponAmount();
        String b10 = b((couponAmount == null || (f10 = couponAmount.get(couponCurrency)) == null) ? 0.0f : f10.floatValue());
        String str = b10 + couponCurrency;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(AutoUtils.getPercentWidthSize(24)), b10.length(), str.length(), 34);
        textView.setText(spannableStringBuilder);
    }
}
