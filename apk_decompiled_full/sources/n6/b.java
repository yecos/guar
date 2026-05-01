package n6;

import android.widget.RelativeLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hpplay.component.protocol.PlistBuilder;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoRelativeLayout;
import com.zhy.autolayout.utils.AutoUtils;

/* loaded from: classes3.dex */
public final class b extends BaseQuickAdapter {

    /* renamed from: a, reason: collision with root package name */
    public boolean f17274a;

    /* renamed from: b, reason: collision with root package name */
    public int f17275b;

    public b(boolean z10) {
        super(R.layout.itme_cast_articulation);
        this.f17274a = z10;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, o6.b bVar) {
        t9.i.g(baseViewHolder, "helper");
        t9.i.g(bVar, PlistBuilder.KEY_ITEM);
        int adapterPosition = baseViewHolder.getAdapterPosition();
        baseViewHolder.setGone(R.id.ivState, this.f17275b == adapterPosition).setText(R.id.tvName, bVar.a());
        AutoRelativeLayout.LayoutParams layoutParams = new AutoRelativeLayout.LayoutParams(-1, AutoUtils.getPercentHeightSize(1));
        if (adapterPosition == 0) {
            ((RelativeLayout.LayoutParams) layoutParams).leftMargin = 0;
            ((RelativeLayout.LayoutParams) layoutParams).rightMargin = 0;
        } else {
            ((RelativeLayout.LayoutParams) layoutParams).leftMargin = AutoUtils.getPercentWidthSize(24);
            ((RelativeLayout.LayoutParams) layoutParams).rightMargin = AutoUtils.getPercentWidthSize(24);
        }
        baseViewHolder.getView(R.id.mVLine).setLayoutParams(layoutParams);
        baseViewHolder.setTextColor(R.id.tvName, this.f17275b == adapterPosition ? this.mContext.getResources().getColor(R.color.color_important) : this.mContext.getResources().getColor(R.color.color_important_white));
    }

    public final int b() {
        return this.f17275b;
    }

    public final void c(int i10) {
        this.f17275b = i10;
        notifyDataSetChanged();
    }

    public /* synthetic */ b(boolean z10, int i10, t9.g gVar) {
        this((i10 & 1) != 0 ? true : z10);
    }
}
