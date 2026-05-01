package com.hpplay.glide.load.resource.transcode;

import com.hpplay.glide.load.engine.Resource;

/* loaded from: classes2.dex */
public interface ResourceTranscoder<Z, R> {
    String getId();

    Resource<R> transcode(Resource<Z> resource);
}
