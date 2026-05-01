package com.chad.library.adapter.base;

import android.util.SparseIntArray;
import android.view.ViewGroup;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.IExpandable;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.entity.SectionMultiEntity;
import java.util.List;

/* loaded from: classes.dex */
public abstract class BaseSectionMultiItemQuickAdapter<T extends SectionMultiEntity, K extends BaseViewHolder> extends BaseQuickAdapter<T, K> {
    private static final int DEFAULT_VIEW_TYPE = -255;
    protected static final int SECTION_HEADER_VIEW = 1092;
    public static final int TYPE_NOT_FOUND = -404;
    private SparseIntArray layouts;
    protected int mSectionHeadResId;

    public BaseSectionMultiItemQuickAdapter(int i10, List<T> list) {
        super(list);
        this.mSectionHeadResId = i10;
    }

    private int getLayoutId(int i10) {
        return this.layouts.get(i10, -404);
    }

    public void addItemType(int i10, int i11) {
        if (this.layouts == null) {
            this.layouts = new SparseIntArray();
        }
        this.layouts.put(i10, i11);
    }

    public abstract void convertHead(K k10, T t10);

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public int getDefItemViewType(int i10) {
        SectionMultiEntity sectionMultiEntity = (SectionMultiEntity) this.mData.get(i10);
        return sectionMultiEntity != null ? sectionMultiEntity.isHeader ? SECTION_HEADER_VIEW : sectionMultiEntity.getItemType() : DEFAULT_VIEW_TYPE;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public boolean isFixedViewType(int i10) {
        return super.isFixedViewType(i10) || i10 == SECTION_HEADER_VIEW;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public K onCreateDefViewHolder(ViewGroup viewGroup, int i10) {
        return i10 == SECTION_HEADER_VIEW ? createBaseViewHolder(getItemView(this.mSectionHeadResId, viewGroup)) : createBaseViewHolder(viewGroup, getLayoutId(i10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void remove(int i10) {
        List<T> list = this.mData;
        if (list == 0 || i10 < 0 || i10 >= list.size()) {
            return;
        }
        MultiItemEntity multiItemEntity = (SectionMultiEntity) this.mData.get(i10);
        if (multiItemEntity instanceof IExpandable) {
            removeAllChild((IExpandable) multiItemEntity, i10);
        }
        removeDataFromParent(multiItemEntity);
        super.remove(i10);
    }

    public void removeAllChild(IExpandable iExpandable, int i10) {
        List subItems;
        if (!iExpandable.isExpanded() || (subItems = iExpandable.getSubItems()) == null || subItems.size() == 0) {
            return;
        }
        int size = subItems.size();
        for (int i11 = 0; i11 < size; i11++) {
            remove(i10 + 1);
        }
    }

    public void removeDataFromParent(T t10) {
        int parentPosition = getParentPosition(t10);
        if (parentPosition >= 0) {
            ((IExpandable) this.mData.get(parentPosition)).getSubItems().remove(t10);
        }
    }

    public void setDefaultViewTypeLayout(int i10) {
        addItemType(DEFAULT_VIEW_TYPE, i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.g
    public void onBindViewHolder(K k10, int i10) {
        if (k10.getItemViewType() != SECTION_HEADER_VIEW) {
            super.onBindViewHolder((BaseSectionMultiItemQuickAdapter<T, K>) k10, i10);
        } else {
            setFullSpan(k10);
            convertHead(k10, (SectionMultiEntity) getItem(i10 - getHeaderLayoutCount()));
        }
    }
}
