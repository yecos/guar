package com.hpplay.glide.load.model;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;
import com.hpplay.glide.load.data.DataFetcher;

/* loaded from: classes2.dex */
public class ResourceLoader<T> implements ModelLoader<Integer, T> {
    private static final String TAG = "ResourceLoader";
    private final Resources resources;
    private final ModelLoader<Uri, T> uriLoader;

    public ResourceLoader(Context context, ModelLoader<Uri, T> modelLoader) {
        this(context.getResources(), modelLoader);
    }

    public ResourceLoader(Resources resources, ModelLoader<Uri, T> modelLoader) {
        this.resources = resources;
        this.uriLoader = modelLoader;
    }

    @Override // com.hpplay.glide.load.model.ModelLoader
    public DataFetcher<T> getResourceFetcher(Integer num, int i10, int i11) {
        Uri uri;
        try {
            uri = Uri.parse("android.resource://" + this.resources.getResourcePackageName(num.intValue()) + '/' + this.resources.getResourceTypeName(num.intValue()) + '/' + this.resources.getResourceEntryName(num.intValue()));
        } catch (Resources.NotFoundException unused) {
            if (Log.isLoggable(TAG, 5)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Received invalid resource id: ");
                sb.append(num);
            }
            uri = null;
        }
        if (uri != null) {
            return this.uriLoader.getResourceFetcher(uri, i10, i11);
        }
        return null;
    }
}
