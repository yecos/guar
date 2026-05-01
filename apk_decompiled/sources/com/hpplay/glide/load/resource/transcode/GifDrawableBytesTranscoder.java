package com.hpplay.glide.load.resource.transcode;

import com.hpplay.glide.load.engine.Resource;
import com.hpplay.glide.load.resource.bytes.BytesResource;
import com.hpplay.glide.load.resource.gif.GifDrawable;

/* loaded from: classes2.dex */
public class GifDrawableBytesTranscoder implements ResourceTranscoder<GifDrawable, byte[]> {
    @Override // com.hpplay.glide.load.resource.transcode.ResourceTranscoder
    public String getId() {
        return "GifDrawableBytesTranscoder.com.bumptech.glide.load.resource.transcode";
    }

    @Override // com.hpplay.glide.load.resource.transcode.ResourceTranscoder
    public Resource<byte[]> transcode(Resource<GifDrawable> resource) {
        return new BytesResource(resource.get().getData());
    }
}
