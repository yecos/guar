package com.hpplay.glide.load.resource.gifbitmap;

import com.hpplay.glide.load.ResourceDecoder;
import com.hpplay.glide.load.engine.Resource;
import com.hpplay.glide.load.model.ImageVideoWrapper;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class GifBitmapWrapperStreamResourceDecoder implements ResourceDecoder<InputStream, GifBitmapWrapper> {
    private final ResourceDecoder<ImageVideoWrapper, GifBitmapWrapper> gifBitmapDecoder;

    public GifBitmapWrapperStreamResourceDecoder(ResourceDecoder<ImageVideoWrapper, GifBitmapWrapper> resourceDecoder) {
        this.gifBitmapDecoder = resourceDecoder;
    }

    @Override // com.hpplay.glide.load.ResourceDecoder
    public String getId() {
        return this.gifBitmapDecoder.getId();
    }

    @Override // com.hpplay.glide.load.ResourceDecoder
    public Resource<GifBitmapWrapper> decode(InputStream inputStream, int i10, int i11) {
        return this.gifBitmapDecoder.decode(new ImageVideoWrapper(inputStream, null), i10, i11);
    }
}
