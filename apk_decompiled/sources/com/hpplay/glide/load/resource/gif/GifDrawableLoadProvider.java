package com.hpplay.glide.load.resource.gif;

import android.content.Context;
import com.hpplay.glide.load.Encoder;
import com.hpplay.glide.load.ResourceDecoder;
import com.hpplay.glide.load.ResourceEncoder;
import com.hpplay.glide.load.engine.bitmap_recycle.BitmapPool;
import com.hpplay.glide.load.model.StreamEncoder;
import com.hpplay.glide.load.resource.file.FileToStreamDecoder;
import com.hpplay.glide.provider.DataLoadProvider;
import java.io.File;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class GifDrawableLoadProvider implements DataLoadProvider<InputStream, GifDrawable> {
    private final FileToStreamDecoder<GifDrawable> cacheDecoder;
    private final GifResourceDecoder decoder;
    private final GifResourceEncoder encoder;
    private final StreamEncoder sourceEncoder;

    public GifDrawableLoadProvider(Context context, BitmapPool bitmapPool) {
        GifResourceDecoder gifResourceDecoder = new GifResourceDecoder(context, bitmapPool);
        this.decoder = gifResourceDecoder;
        this.cacheDecoder = new FileToStreamDecoder<>(gifResourceDecoder);
        this.encoder = new GifResourceEncoder(bitmapPool);
        this.sourceEncoder = new StreamEncoder();
    }

    @Override // com.hpplay.glide.provider.DataLoadProvider
    public ResourceDecoder<File, GifDrawable> getCacheDecoder() {
        return this.cacheDecoder;
    }

    @Override // com.hpplay.glide.provider.DataLoadProvider
    public ResourceEncoder<GifDrawable> getEncoder() {
        return this.encoder;
    }

    @Override // com.hpplay.glide.provider.DataLoadProvider
    public ResourceDecoder<InputStream, GifDrawable> getSourceDecoder() {
        return this.decoder;
    }

    @Override // com.hpplay.glide.provider.DataLoadProvider
    public Encoder<InputStream> getSourceEncoder() {
        return this.sourceEncoder;
    }
}
