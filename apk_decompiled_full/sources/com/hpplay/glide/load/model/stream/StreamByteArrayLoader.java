package com.hpplay.glide.load.model.stream;

import android.content.Context;
import com.hpplay.glide.load.data.ByteArrayFetcher;
import com.hpplay.glide.load.data.DataFetcher;
import com.hpplay.glide.load.model.GenericLoaderFactory;
import com.hpplay.glide.load.model.ModelLoader;
import com.hpplay.glide.load.model.ModelLoaderFactory;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class StreamByteArrayLoader implements StreamModelLoader<byte[]> {
    private final String id;

    public static class Factory implements ModelLoaderFactory<byte[], InputStream> {
        @Override // com.hpplay.glide.load.model.ModelLoaderFactory
        public ModelLoader<byte[], InputStream> build(Context context, GenericLoaderFactory genericLoaderFactory) {
            return new StreamByteArrayLoader();
        }

        @Override // com.hpplay.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public StreamByteArrayLoader() {
        this("");
    }

    @Deprecated
    public StreamByteArrayLoader(String str) {
        this.id = str;
    }

    @Override // com.hpplay.glide.load.model.ModelLoader
    public DataFetcher<InputStream> getResourceFetcher(byte[] bArr, int i10, int i11) {
        return new ByteArrayFetcher(bArr, this.id);
    }
}
