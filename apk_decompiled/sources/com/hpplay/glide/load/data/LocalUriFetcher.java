package com.hpplay.glide.load.data;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.hpplay.glide.Priority;
import java.io.IOException;

/* loaded from: classes2.dex */
public abstract class LocalUriFetcher<T> implements DataFetcher<T> {
    private static final String TAG = "LocalUriFetcher";
    private final Context context;
    private T data;
    private final Uri uri;

    public LocalUriFetcher(Context context, Uri uri) {
        this.context = context.getApplicationContext();
        this.uri = uri;
    }

    @Override // com.hpplay.glide.load.data.DataFetcher
    public void cancel() {
    }

    @Override // com.hpplay.glide.load.data.DataFetcher
    public void cleanup() {
        T t10 = this.data;
        if (t10 != null) {
            try {
                close(t10);
            } catch (IOException unused) {
                Log.isLoggable(TAG, 2);
            }
        }
    }

    public abstract void close(T t10);

    @Override // com.hpplay.glide.load.data.DataFetcher
    public String getId() {
        return this.uri.toString();
    }

    @Override // com.hpplay.glide.load.data.DataFetcher
    public final T loadData(Priority priority) {
        T loadResource = loadResource(this.uri, this.context.getContentResolver());
        this.data = loadResource;
        return loadResource;
    }

    public abstract T loadResource(Uri uri, ContentResolver contentResolver);
}
