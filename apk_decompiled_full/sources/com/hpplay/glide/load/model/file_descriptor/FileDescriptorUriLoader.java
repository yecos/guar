package com.hpplay.glide.load.model.file_descriptor;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.hpplay.glide.Glide;
import com.hpplay.glide.load.data.DataFetcher;
import com.hpplay.glide.load.data.FileDescriptorAssetPathFetcher;
import com.hpplay.glide.load.data.FileDescriptorLocalUriFetcher;
import com.hpplay.glide.load.model.GenericLoaderFactory;
import com.hpplay.glide.load.model.GlideUrl;
import com.hpplay.glide.load.model.ModelLoader;
import com.hpplay.glide.load.model.ModelLoaderFactory;
import com.hpplay.glide.load.model.UriLoader;

/* loaded from: classes2.dex */
public class FileDescriptorUriLoader extends UriLoader<ParcelFileDescriptor> implements FileDescriptorModelLoader<Uri> {

    public static class Factory implements ModelLoaderFactory<Uri, ParcelFileDescriptor> {
        @Override // com.hpplay.glide.load.model.ModelLoaderFactory
        public ModelLoader<Uri, ParcelFileDescriptor> build(Context context, GenericLoaderFactory genericLoaderFactory) {
            return new FileDescriptorUriLoader(context, genericLoaderFactory.buildModelLoader(GlideUrl.class, ParcelFileDescriptor.class));
        }

        @Override // com.hpplay.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public FileDescriptorUriLoader(Context context) {
        this(context, Glide.buildFileDescriptorModelLoader(GlideUrl.class, context));
    }

    @Override // com.hpplay.glide.load.model.UriLoader
    public DataFetcher<ParcelFileDescriptor> getAssetPathFetcher(Context context, String str) {
        return new FileDescriptorAssetPathFetcher(context.getApplicationContext().getAssets(), str);
    }

    @Override // com.hpplay.glide.load.model.UriLoader
    public DataFetcher<ParcelFileDescriptor> getLocalUriFetcher(Context context, Uri uri) {
        return new FileDescriptorLocalUriFetcher(context, uri);
    }

    public FileDescriptorUriLoader(Context context, ModelLoader<GlideUrl, ParcelFileDescriptor> modelLoader) {
        super(context, modelLoader);
    }
}
