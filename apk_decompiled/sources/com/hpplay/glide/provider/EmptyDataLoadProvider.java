package com.hpplay.glide.provider;

import com.hpplay.glide.load.Encoder;
import com.hpplay.glide.load.ResourceDecoder;
import com.hpplay.glide.load.ResourceEncoder;
import java.io.File;

/* loaded from: classes2.dex */
public class EmptyDataLoadProvider<T, Z> implements DataLoadProvider<T, Z> {
    private static final DataLoadProvider<?, ?> EMPTY_DATA_LOAD_PROVIDER = new EmptyDataLoadProvider();

    public static <T, Z> DataLoadProvider<T, Z> get() {
        return (DataLoadProvider<T, Z>) EMPTY_DATA_LOAD_PROVIDER;
    }

    @Override // com.hpplay.glide.provider.DataLoadProvider
    public ResourceDecoder<File, Z> getCacheDecoder() {
        return null;
    }

    @Override // com.hpplay.glide.provider.DataLoadProvider
    public ResourceEncoder<Z> getEncoder() {
        return null;
    }

    @Override // com.hpplay.glide.provider.DataLoadProvider
    public ResourceDecoder<T, Z> getSourceDecoder() {
        return null;
    }

    @Override // com.hpplay.glide.provider.DataLoadProvider
    public Encoder<T> getSourceEncoder() {
        return null;
    }
}
