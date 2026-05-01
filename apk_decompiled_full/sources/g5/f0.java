package g5;

import android.content.Context;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hpplay.component.protocol.PlistBuilder;
import com.mobile.brasiltv.view.AutoCardView;
import com.msandroid.mobile.R;
import mobile.com.requestframe.utils.response.ShelveAsset;

/* loaded from: classes3.dex */
public final class f0 extends BaseQuickAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final Context f13690a;

    /* renamed from: b, reason: collision with root package name */
    public int f13691b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(Context context) {
        super(R.layout.adapter_hot_search);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        this.f13690a = context;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, ShelveAsset shelveAsset) {
        t9.i.g(baseViewHolder, "helper");
        t9.i.g(shelveAsset, PlistBuilder.KEY_ITEM);
        int adapterPosition = this.f13691b + baseViewHolder.getAdapterPosition();
        if (adapterPosition == 0) {
            ((AutoCardView) baseViewHolder.getView(R.id.mAcvNum)).setCardBackgroundColor(this.f13690a.getResources().getColor(R.color.color_e61739));
        } else if (adapterPosition == 1) {
            ((AutoCardView) baseViewHolder.getView(R.id.mAcvNum)).setCardBackgroundColor(this.f13690a.getResources().getColor(R.color.color_e63917));
        } else if (adapterPosition != 2) {
            ((AutoCardView) baseViewHolder.getView(R.id.mAcvNum)).setCardBackgroundColor(this.f13690a.getResources().getColor(R.color.color_808080));
        } else {
            ((AutoCardView) baseViewHolder.getView(R.id.mAcvNum)).setCardBackgroundColor(this.f13690a.getResources().getColor(R.color.color_e67e17));
        }
        ((TextView) baseViewHolder.getView(R.id.mTvNum)).setText(String.valueOf(this.f13691b + baseViewHolder.getAdapterPosition() + 1));
        ((TextView) baseViewHolder.getView(R.id.mTitle)).setText(com.mobile.brasiltv.utils.b0.e(shelveAsset.getAlias(), shelveAsset.getName()));
    }

    public final void b(int i10) {
        this.f13691b = i10;
    }
}
