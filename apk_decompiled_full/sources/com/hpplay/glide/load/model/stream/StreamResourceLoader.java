package com.hpplay.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import com.hpplay.glide.Glide;
import com.hpplay.glide.load.model.GenericLoaderFactory;
import com.hpplay.glide.load.model.ModelLoader;
import com.hpplay.glide.load.model.ModelLoaderFactory;
import com.hpplay.glide.load.model.ResourceLoader;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class StreamResourceLoader extends ResourceLoader<InputStream> implements StreamModelLoader<Integer> {

    public static class Factory implements ModelLoaderFactory<Integer, InputStream> {
        @Override // com.hpplay.glide.load.model.ModelLoaderFactory
        public ModelLoader<Integer, InputStream> build(Context context, GenericLoaderFactory genericLoaderFactory) {
            return new StreamResourceLoader(context, genericLoaderFactory.buildModelLoader(Uri.class, InputStream.class));
        }

        @Override // com.hpplay.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public StreamResourceLoader(Context context) {
        this(context, Glide.buildStreamModelLoader(Uri.class, context));
    }

    public StreamResourceLoader(Context context, ModelLoader<Uri, InputStream> modelLoader) {
        super(context, modelLoader);
    }
}
