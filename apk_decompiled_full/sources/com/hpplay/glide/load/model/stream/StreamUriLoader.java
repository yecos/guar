package com.hpplay.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import com.hpplay.glide.Glide;
import com.hpplay.glide.load.data.DataFetcher;
import com.hpplay.glide.load.data.StreamAssetPathFetcher;
import com.hpplay.glide.load.data.StreamLocalUriFetcher;
import com.hpplay.glide.load.model.GenericLoaderFactory;
import com.hpplay.glide.load.model.GlideUrl;
import com.hpplay.glide.load.model.ModelLoader;
import com.hpplay.glide.load.model.ModelLoaderFactory;
import com.hpplay.glide.load.model.UriLoader;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class StreamUriLoader extends UriLoader<InputStream> implements StreamModelLoader<Uri> {

    public static class Factory implements ModelLoaderFactory<Uri, InputStream> {
        @Override // com.hpplay.glide.load.model.ModelLoaderFactory
        public ModelLoader<Uri, InputStream> build(Context context, GenericLoaderFactory genericLoaderFactory) {
            return new StreamUriLoader(context, genericLoaderFactory.buildModelLoader(GlideUrl.class, InputStream.class));
        }

        @Override // com.hpplay.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public StreamUriLoader(Context context) {
        this(context, Glide.buildStreamModelLoader(GlideUrl.class, context));
    }

    @Override // com.hpplay.glide.load.model.UriLoader
    public DataFetcher<InputStream> getAssetPathFetcher(Context context, String str) {
        return new StreamAssetPathFetcher(context.getApplicationContext().getAssets(), str);
    }

    @Override // com.hpplay.glide.load.model.UriLoader
    public DataFetcher<InputStream> getLocalUriFetcher(Context context, Uri uri) {
        return new StreamLocalUriFetcher(context, uri);
    }

    public StreamUriLoader(Context context, ModelLoader<GlideUrl, InputStream> modelLoader) {
        super(context, modelLoader);
    }
}
