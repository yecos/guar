package com.hpplay.glide.load.model.stream;

import android.content.Context;
import android.text.TextUtils;
import com.hpplay.glide.Glide;
import com.hpplay.glide.load.data.DataFetcher;
import com.hpplay.glide.load.model.GlideUrl;
import com.hpplay.glide.load.model.Headers;
import com.hpplay.glide.load.model.ModelCache;
import com.hpplay.glide.load.model.ModelLoader;
import java.io.InputStream;

/* loaded from: classes2.dex */
public abstract class BaseGlideUrlLoader<T> implements StreamModelLoader<T> {
    private final ModelLoader<GlideUrl, InputStream> concreteLoader;
    private final ModelCache<T, GlideUrl> modelCache;

    public BaseGlideUrlLoader(Context context) {
        this(context, (ModelCache) null);
    }

    public Headers getHeaders(T t10, int i10, int i11) {
        return Headers.DEFAULT;
    }

    @Override // com.hpplay.glide.load.model.ModelLoader
    public DataFetcher<InputStream> getResourceFetcher(T t10, int i10, int i11) {
        ModelCache<T, GlideUrl> modelCache = this.modelCache;
        GlideUrl glideUrl = modelCache != null ? modelCache.get(t10, i10, i11) : null;
        if (glideUrl == null) {
            String url = getUrl(t10, i10, i11);
            if (TextUtils.isEmpty(url)) {
                return null;
            }
            GlideUrl glideUrl2 = new GlideUrl(url, getHeaders(t10, i10, i11));
            ModelCache<T, GlideUrl> modelCache2 = this.modelCache;
            if (modelCache2 != null) {
                modelCache2.put(t10, i10, i11, glideUrl2);
            }
            glideUrl = glideUrl2;
        }
        return this.concreteLoader.getResourceFetcher(glideUrl, i10, i11);
    }

    public abstract String getUrl(T t10, int i10, int i11);

    public BaseGlideUrlLoader(Context context, ModelCache<T, GlideUrl> modelCache) {
        this((ModelLoader<GlideUrl, InputStream>) Glide.buildModelLoader(GlideUrl.class, InputStream.class, context), modelCache);
    }

    public BaseGlideUrlLoader(ModelLoader<GlideUrl, InputStream> modelLoader) {
        this(modelLoader, (ModelCache) null);
    }

    public BaseGlideUrlLoader(ModelLoader<GlideUrl, InputStream> modelLoader, ModelCache<T, GlideUrl> modelCache) {
        this.concreteLoader = modelLoader;
        this.modelCache = modelCache;
    }
}
