package com.hpplay.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.hpplay.glide.load.DecodeFormat;
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
public class StreamBitmapDataLoadProvider implements DataLoadProvider<InputStream, Bitmap> {
    private final FileToStreamDecoder<Bitmap> cacheDecoder;
    private final StreamBitmapDecoder decoder;
    private final BitmapEncoder encoder;
    private final StreamEncoder sourceEncoder = new StreamEncoder();

    public StreamBitmapDataLoadProvider(BitmapPool bitmapPool, DecodeFormat decodeFormat) {
        StreamBitmapDecoder streamBitmapDecoder = new StreamBitmapDecoder(bitmapPool, decodeFormat);
        this.decoder = streamBitmapDecoder;
        this.encoder = new BitmapEncoder();
        this.cacheDecoder = new FileToStreamDecoder<>(streamBitmapDecoder);
    }

    @Override // com.hpplay.glide.provider.DataLoadProvider
    public ResourceDecoder<File, Bitmap> getCacheDecoder() {
        return this.cacheDecoder;
    }

    @Override // com.hpplay.glide.provider.DataLoadProvider
    public ResourceEncoder<Bitmap> getEncoder() {
        return this.encoder;
    }

    @Override // com.hpplay.glide.provider.DataLoadProvider
    public ResourceDecoder<InputStream, Bitmap> getSourceDecoder() {
        return this.decoder;
    }

    @Override // com.hpplay.glide.provider.DataLoadProvider
    public Encoder<InputStream> getSourceEncoder() {
        return this.sourceEncoder;
    }
}
