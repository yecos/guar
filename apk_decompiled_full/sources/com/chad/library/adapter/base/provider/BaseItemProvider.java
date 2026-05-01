package com.chad.library.adapter.base.provider;

import android.content.Context;
import com.chad.library.adapter.base.BaseViewHolder;
import java.util.List;

/* loaded from: classes.dex */
public abstract class BaseItemProvider<T, V extends BaseViewHolder> {
    public Context mContext;
    public List<T> mData;

    public abstract void convert(V v10, T t10, int i10);

    public abstract int layout();

    public void onClick(V v10, T t10, int i10) {
    }

    public boolean onLongClick(V v10, T t10, int i10) {
        return false;
    }

    public abstract int viewType();
}
