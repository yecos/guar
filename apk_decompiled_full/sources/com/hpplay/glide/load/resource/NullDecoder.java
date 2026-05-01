package com.hpplay.glide.load.resource;

import com.hpplay.glide.load.ResourceDecoder;
import com.hpplay.glide.load.engine.Resource;

/* loaded from: classes2.dex */
public class NullDecoder<T, Z> implements ResourceDecoder<T, Z> {
    private static final NullDecoder<?, ?> NULL_DECODER = new NullDecoder<>();

    public static <T, Z> NullDecoder<T, Z> get() {
        return (NullDecoder<T, Z>) NULL_DECODER;
    }

    @Override // com.hpplay.glide.load.ResourceDecoder
    public Resource<Z> decode(T t10, int i10, int i11) {
        return null;
    }

    @Override // com.hpplay.glide.load.ResourceDecoder
    public String getId() {
        return "";
    }
}
