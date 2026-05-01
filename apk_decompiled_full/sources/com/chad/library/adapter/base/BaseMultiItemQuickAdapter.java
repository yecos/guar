package com.chad.library.adapter.base;

import android.util.SparseIntArray;
import android.view.ViewGroup;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.IExpandable;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.util.List;

/* loaded from: classes.dex */
public abstract class BaseMultiItemQuickAdapter<T extends MultiItemEntity, K extends BaseViewHolder> extends BaseQuickAdapter<T, K> {
    private static final int DEFAULT_VIEW_TYPE = -255;
    public static final int TYPE_NOT_FOUND = -404;
    private SparseIntArray layouts;

    public BaseMultiItemQuickAdapter(List<T> list) {
        super(list);
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

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public int getDefItemViewType(int i10) {
        MultiItemEntity multiItemEntity = (MultiItemEntity) this.mData.get(i10);
        return multiItemEntity != null ? multiItemEntity.getItemType() : DEFAULT_VIEW_TYPE;
    }

    public int getParentPositionInAll(int i10) {
        List<T> data = getData();
        MultiItemEntity multiItemEntity = (MultiItemEntity) getItem(i10);
        if (!isExpandable(multiItemEntity)) {
            for (int i11 = i10 - 1; i11 >= 0; i11--) {
                if (isExpandable((MultiItemEntity) data.get(i11))) {
                    return i11;
                }
            }
            return -1;
        }
        IExpandable iExpandable = (IExpandable) multiItemEntity;
        for (int i12 = i10 - 1; i12 >= 0; i12--) {
            MultiItemEntity multiItemEntity2 = (MultiItemEntity) data.get(i12);
            if (isExpandable(multiItemEntity2) && iExpandable.getLevel() > ((IExpandable) multiItemEntity2).getLevel()) {
                return i12;
            }
        }
        return -1;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public K onCreateDefViewHolder(ViewGroup viewGroup, int i10) {
        return createBaseViewHolder(viewGroup, getLayoutId(i10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void remove(int i10) {
        List<T> list = this.mData;
        if (list == 0 || i10 < 0 || i10 >= list.size()) {
            return;
        }
        MultiItemEntity multiItemEntity = (MultiItemEntity) this.mData.get(i10);
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

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public boolean isExpandable(MultiItemEntity multiItemEntity) {
        return multiItemEntity != null && (multiItemEntity instanceof IExpandable);
    }
}
