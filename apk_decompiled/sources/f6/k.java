package f6;

import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ba.s;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hpplay.component.protocol.PlistBuilder;
import com.msandroid.mobile.R;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.zhy.autolayout.utils.AutoUtils;
import java.util.Arrays;
import mobile.com.requestframe.utils.response.GetExchangeOrderData;
import t9.z;

/* loaded from: classes3.dex */
public final class k extends BaseQuickAdapter {
    public k() {
        super(R.layout.adapter_redemption);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, GetExchangeOrderData getExchangeOrderData) {
        String j10;
        t9.i.g(baseViewHolder, "helper");
        t9.i.g(getExchangeOrderData, PlistBuilder.KEY_ITEM);
        z zVar = z.f18964a;
        String string = this.mContext.getResources().getString(R.string.order_exchange_code);
        t9.i.f(string, "mContext.resources.getSt…ring.order_exchange_code)");
        String format = String.format(string, Arrays.copyOf(new Object[]{getExchangeOrderData.getExchangeCode()}, 1));
        t9.i.f(format, "format(format, *args)");
        baseViewHolder.setText(R.id.tvExchangeCode, format);
        if (TextUtils.isEmpty(getExchangeOrderData.getUsingTime()) || getExchangeOrderData.getUsingTime().length() < 16) {
            String c10 = y6.b.c();
            t9.i.f(c10, "getLocalUTCTime()");
            j10 = s.j(c10, Operator.Operation.MINUS, ".", false, 4, null);
        } else {
            j10 = y6.b.e(getExchangeOrderData.getUsingTime(), "yyyy-MM-dd HH:mm:SS", "yyyy.MM.dd HH:mm");
        }
        String string2 = this.mContext.getResources().getString(R.string.order_time_of_use);
        t9.i.f(string2, "mContext.resources.getSt…string.order_time_of_use)");
        String format2 = String.format(string2, Arrays.copyOf(new Object[]{j10}, 1));
        t9.i.f(format2, "format(format, *args)");
        baseViewHolder.setText(R.id.tvTimeOfUse, format2);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void bindToRecyclerView(RecyclerView recyclerView) {
        if (getRecyclerView() != null) {
            getRecyclerView().setAdapter(this);
        } else {
            super.bindToRecyclerView(recyclerView);
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.g
    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        t9.i.g(viewGroup, "parent");
        BaseViewHolder onCreateViewHolder = super.onCreateViewHolder(viewGroup, i10);
        t9.i.f(onCreateViewHolder, "super.onCreateViewHolder(parent, viewType)");
        AutoUtils.autoSize(onCreateViewHolder.itemView);
        return onCreateViewHolder;
    }
}
