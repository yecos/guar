package com.hpplay.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import com.hpplay.glide.Glide;
import com.hpplay.glide.load.model.GenericLoaderFactory;
import com.hpplay.glide.load.model.ModelLoader;
import com.hpplay.glide.load.model.ModelLoaderFactory;
import com.hpplay.glide.load.model.StringLoader;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class StreamStringLoader extends StringLoader<InputStream> implements StreamModelLoader<String> {

    public static class Factory implements ModelLoaderFactory<String, InputStream> {
        @Override // com.hpplay.glide.load.model.ModelLoaderFactory
        public ModelLoader<String, InputStream> build(Context context, GenericLoaderFactory genericLoaderFactory) {
            return new StreamStringLoader((ModelLoader<Uri, InputStream>) genericLoaderFactory.buildModelLoader(Uri.class, InputStream.class));
        }

        @Override // com.hpplay.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public StreamStringLoader(Context context) {
        this((ModelLoader<Uri, InputStream>) Glide.buildStreamModelLoader(Uri.class, context));
    }

    public StreamStringLoader(ModelLoader<Uri, InputStream> modelLoader) {
        super(modelLoader);
    }
}
