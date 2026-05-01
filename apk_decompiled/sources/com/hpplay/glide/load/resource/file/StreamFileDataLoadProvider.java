package com.hpplay.glide.load.resource.file;

import com.hpplay.glide.load.Encoder;
import com.hpplay.glide.load.ResourceDecoder;
import com.hpplay.glide.load.ResourceEncoder;
import com.hpplay.glide.load.engine.Resource;
import com.hpplay.glide.load.model.StreamEncoder;
import com.hpplay.glide.load.resource.NullResourceEncoder;
import com.hpplay.glide.provider.DataLoadProvider;
import java.io.File;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class StreamFileDataLoadProvider implements DataLoadProvider<InputStream, File> {
    private static final ErrorSourceDecoder ERROR_DECODER = new ErrorSourceDecoder();
    private final ResourceDecoder<File, File> cacheDecoder = new FileDecoder();
    private final Encoder<InputStream> encoder = new StreamEncoder();

    public static class ErrorSourceDecoder implements ResourceDecoder<InputStream, File> {
        private ErrorSourceDecoder() {
        }

        @Override // com.hpplay.glide.load.ResourceDecoder
        public String getId() {
            return "";
        }

        @Override // com.hpplay.glide.load.ResourceDecoder
        public Resource<File> decode(InputStream inputStream, int i10, int i11) {
            throw new Error("You cannot decode a File from an InputStream by default, try either #diskCacheStratey(DiskCacheStrategy.SOURCE) to avoid this call or #decoder(ResourceDecoder) to replace this Decoder");
        }
    }

    @Override // com.hpplay.glide.provider.DataLoadProvider
    public ResourceDecoder<File, File> getCacheDecoder() {
        return this.cacheDecoder;
    }

    @Override // com.hpplay.glide.provider.DataLoadProvider
    public ResourceEncoder<File> getEncoder() {
        return NullResourceEncoder.get();
    }

    @Override // com.hpplay.glide.provider.DataLoadProvider
    public ResourceDecoder<InputStream, File> getSourceDecoder() {
        return ERROR_DECODER;
    }

    @Override // com.hpplay.glide.provider.DataLoadProvider
    public Encoder<InputStream> getSourceEncoder() {
        return this.encoder;
    }
}
