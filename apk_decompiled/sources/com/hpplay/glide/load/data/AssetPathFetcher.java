package com.hpplay.glide.load.data;

import android.content.res.AssetManager;
import android.util.Log;
import com.hpplay.glide.Priority;
import java.io.IOException;

/* loaded from: classes2.dex */
public abstract class AssetPathFetcher<T> implements DataFetcher<T> {
    private static final String TAG = "AssetUriFetcher";
    private final AssetManager assetManager;
    private final String assetPath;
    private T data;

    public AssetPathFetcher(AssetManager assetManager, String str) {
        this.assetManager = assetManager;
        this.assetPath = str;
    }

    @Override // com.hpplay.glide.load.data.DataFetcher
    public void cancel() {
    }

    @Override // com.hpplay.glide.load.data.DataFetcher
    public void cleanup() {
        T t10 = this.data;
        if (t10 == null) {
            return;
        }
        try {
            close(t10);
        } catch (IOException unused) {
            Log.isLoggable(TAG, 2);
        }
    }

    public abstract void close(T t10);

    @Override // com.hpplay.glide.load.data.DataFetcher
    public String getId() {
        return this.assetPath;
    }

    @Override // com.hpplay.glide.load.data.DataFetcher
    public T loadData(Priority priority) {
        T loadResource = loadResource(this.assetManager, this.assetPath);
        this.data = loadResource;
        return loadResource;
    }

    public abstract T loadResource(AssetManager assetManager, String str);
}
