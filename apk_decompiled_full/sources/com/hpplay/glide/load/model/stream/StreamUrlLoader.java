package com.hpplay.glide.load.model.stream;

import android.content.Context;
import com.hpplay.glide.load.model.GenericLoaderFactory;
import com.hpplay.glide.load.model.GlideUrl;
import com.hpplay.glide.load.model.ModelLoader;
import com.hpplay.glide.load.model.ModelLoaderFactory;
import com.hpplay.glide.load.model.UrlLoader;
import java.io.InputStream;
import java.net.URL;

/* loaded from: classes2.dex */
public class StreamUrlLoader extends UrlLoader<InputStream> {

    public static class Factory implements ModelLoaderFactory<URL, InputStream> {
        @Override // com.hpplay.glide.load.model.ModelLoaderFactory
        public ModelLoader<URL, InputStream> build(Context context, GenericLoaderFactory genericLoaderFactory) {
            return new StreamUrlLoader(genericLoaderFactory.buildModelLoader(GlideUrl.class, InputStream.class));
        }

        @Override // com.hpplay.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public StreamUrlLoader(ModelLoader<GlideUrl, InputStream> modelLoader) {
        super(modelLoader);
    }
}
