package com.chad.library.adapter.base;

import android.util.SparseArray;
import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.util.MultiTypeDelegate;
import com.chad.library.adapter.base.util.ProviderDelegate;
import java.util.List;

/* loaded from: classes.dex */
public abstract class MultipleItemRvAdapter<T, V extends BaseViewHolder> extends BaseQuickAdapter<T, V> {
    private SparseArray<BaseItemProvider> mItemProviders;
    protected ProviderDelegate mProviderDelegate;

    public MultipleItemRvAdapter(List<T> list) {
        super(list);
    }

    private void bindClick(final V v10, final T t10, final int i10, final BaseItemProvider baseItemProvider) {
        BaseQuickAdapter.OnItemClickListener onItemClickListener = getOnItemClickListener();
        BaseQuickAdapter.OnItemLongClickListener onItemLongClickListener = getOnItemLongClickListener();
        if (onItemClickListener == null || onItemLongClickListener == null) {
            View view = v10.itemView;
            if (onItemClickListener == null) {
                view.setOnClickListener(new View.OnClickListener() { // from class: com.chad.library.adapter.base.MultipleItemRvAdapter.2
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        baseItemProvider.onClick(v10, t10, i10);
                    }
                });
            }
            if (onItemLongClickListener == null) {
                view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.chad.library.adapter.base.MultipleItemRvAdapter.3
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view2) {
                        return baseItemProvider.onLongClick(v10, t10, i10);
                    }
                });
            }
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(V v10, T t10) {
        BaseItemProvider baseItemProvider = this.mItemProviders.get(v10.getItemViewType());
        baseItemProvider.mContext = v10.itemView.getContext();
        int layoutPosition = v10.getLayoutPosition() - getHeaderLayoutCount();
        baseItemProvider.convert(v10, t10, layoutPosition);
        bindClick(v10, t10, layoutPosition, baseItemProvider);
    }

    public void finishInitialize() {
        this.mProviderDelegate = new ProviderDelegate();
        setMultiTypeDelegate(new MultiTypeDelegate<T>() { // from class: com.chad.library.adapter.base.MultipleItemRvAdapter.1
            @Override // com.chad.library.adapter.base.util.MultiTypeDelegate
            public int getItemType(T t10) {
                return MultipleItemRvAdapter.this.getViewType(t10);
            }
        });
        registerItemProvider();
        this.mItemProviders = this.mProviderDelegate.getItemProviders();
        for (int i10 = 0; i10 < this.mItemProviders.size(); i10++) {
            int keyAt = this.mItemProviders.keyAt(i10);
            BaseItemProvider baseItemProvider = this.mItemProviders.get(keyAt);
            baseItemProvider.mData = this.mData;
            getMultiTypeDelegate().registerItemType(keyAt, baseItemProvider.layout());
        }
    }

    public abstract int getViewType(T t10);

    public abstract void registerItemProvider();
}
