package com.hpplay.glide.load.resource.gif;

import com.hpplay.glide.Priority;
import com.hpplay.glide.gifdecoder.GifDecoder;
import com.hpplay.glide.load.data.DataFetcher;
import com.hpplay.glide.load.model.ModelLoader;

/* loaded from: classes2.dex */
class GifFrameModelLoader implements ModelLoader<GifDecoder, GifDecoder> {

    public static class GifFrameDataFetcher implements DataFetcher<GifDecoder> {
        private final GifDecoder decoder;

        public GifFrameDataFetcher(GifDecoder gifDecoder) {
            this.decoder = gifDecoder;
        }

        @Override // com.hpplay.glide.load.data.DataFetcher
        public void cancel() {
        }

        @Override // com.hpplay.glide.load.data.DataFetcher
        public void cleanup() {
        }

        @Override // com.hpplay.glide.load.data.DataFetcher
        public String getId() {
            return String.valueOf(this.decoder.getCurrentFrameIndex());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.hpplay.glide.load.data.DataFetcher
        public GifDecoder loadData(Priority priority) {
            return this.decoder;
        }
    }

    @Override // com.hpplay.glide.load.model.ModelLoader
    public DataFetcher<GifDecoder> getResourceFetcher(GifDecoder gifDecoder, int i10, int i11) {
        return new GifFrameDataFetcher(gifDecoder);
    }
}
