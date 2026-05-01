package com.hpplay.glide.load.model;

import com.hpplay.glide.load.data.DataFetcher;

/* loaded from: classes2.dex */
public interface ModelLoader<T, Y> {
    DataFetcher<Y> getResourceFetcher(T t10, int i10, int i11);
}
