package com.bumptech.glide.load;

import com.bumptech.glide.load.engine.Resource;

/* loaded from: classes.dex */
public interface ResourceDecoder<T, Z> {
    Resource<Z> decode(T t10, int i10, int i11, Options options);

    boolean handles(T t10, Options options);
}
