package n6;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hpplay.component.protocol.PlistBuilder;
import com.msandroid.mobile.R;

/* loaded from: classes3.dex */
public final class c extends BaseQuickAdapter {

    /* renamed from: a, reason: collision with root package name */
    public boolean f17276a;

    /* renamed from: b, reason: collision with root package name */
    public int f17277b;

    public c(boolean z10) {
        super(R.layout.item_landscape_quality);
        this.f17276a = z10;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, o6.b bVar) {
        t9.i.g(baseViewHolder, "helper");
        t9.i.g(bVar, PlistBuilder.KEY_ITEM);
        int adapterPosition = baseViewHolder.getAdapterPosition();
        baseViewHolder.setGone(R.id.ivState, this.f17277b == adapterPosition).setText(R.id.tvName, bVar.a());
        baseViewHolder.setTextColor(R.id.tvName, this.f17277b == adapterPosition ? this.mContext.getResources().getColor(R.color.color_important) : this.mContext.getResources().getColor(R.color.color_ffffff));
    }

    public final void b(int i10) {
        this.f17277b = i10;
        notifyDataSetChanged();
    }
}
