package g5;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.msandroid.mobile.R;

/* loaded from: classes3.dex */
public final class o0 extends BaseQuickAdapter {

    /* renamed from: a, reason: collision with root package name */
    public int f13815a;

    public o0() {
        super(R.layout.adapter_live_sort_item);
        this.f13815a = -1;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, String str) {
        t9.i.g(baseViewHolder, "helper");
        t9.i.g(str, "name");
        baseViewHolder.setText(R.id.mTextSortName, str);
        if (this.f13815a == baseViewHolder.getLayoutPosition()) {
            baseViewHolder.setBackgroundColor(R.id.mLayoutSort, this.mContext.getResources().getColor(R.color.color_important));
        } else {
            baseViewHolder.setBackgroundColor(R.id.mLayoutSort, this.mContext.getResources().getColor(R.color.color_99000000));
        }
    }

    public final void b(int i10) {
        this.f13815a = i10;
        notifyDataSetChanged();
    }
}
