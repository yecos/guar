package com.hpplay.glide.provider;

import com.hpplay.glide.load.model.ModelLoader;
import com.hpplay.glide.load.resource.transcode.ResourceTranscoder;

/* loaded from: classes2.dex */
public interface LoadProvider<A, T, Z, R> extends DataLoadProvider<T, Z> {
    ModelLoader<A, T> getModelLoader();

    ResourceTranscoder<Z, R> getTranscoder();
}
