package com.chad.library.adapter.base;

import android.view.ViewGroup;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.SectionEntity;
import java.util.List;

/* loaded from: classes.dex */
public abstract class BaseSectionQuickAdapter<T extends SectionEntity, K extends BaseViewHolder> extends BaseQuickAdapter<T, K> {
    protected static final int SECTION_HEADER_VIEW = 1092;
    protected int mSectionHeadResId;

    public BaseSectionQuickAdapter(int i10, int i11, List<T> list) {
        super(i10, list);
        this.mSectionHeadResId = i11;
    }

    public abstract void convertHead(K k10, T t10);

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public int getDefItemViewType(int i10) {
        if (((SectionEntity) this.mData.get(i10)).isHeader) {
            return SECTION_HEADER_VIEW;
        }
        return 0;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public boolean isFixedViewType(int i10) {
        return super.isFixedViewType(i10) || i10 == SECTION_HEADER_VIEW;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public K onCreateDefViewHolder(ViewGroup viewGroup, int i10) {
        return i10 == SECTION_HEADER_VIEW ? createBaseViewHolder(getItemView(this.mSectionHeadResId, viewGroup)) : (K) super.onCreateDefViewHolder(viewGroup, i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.g
    public void onBindViewHolder(K k10, int i10) {
        if (k10.getItemViewType() != SECTION_HEADER_VIEW) {
            super.onBindViewHolder((BaseSectionQuickAdapter<T, K>) k10, i10);
        } else {
            setFullSpan(k10);
            convertHead(k10, (SectionEntity) getItem(i10 - getHeaderLayoutCount()));
        }
    }
}
