package com.hpplay.glide.load.model.file_descriptor;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.hpplay.glide.Glide;
import com.hpplay.glide.load.model.GenericLoaderFactory;
import com.hpplay.glide.load.model.ModelLoader;
import com.hpplay.glide.load.model.ModelLoaderFactory;
import com.hpplay.glide.load.model.ResourceLoader;

/* loaded from: classes2.dex */
public class FileDescriptorResourceLoader extends ResourceLoader<ParcelFileDescriptor> implements FileDescriptorModelLoader<Integer> {

    public static class Factory implements ModelLoaderFactory<Integer, ParcelFileDescriptor> {
        @Override // com.hpplay.glide.load.model.ModelLoaderFactory
        public ModelLoader<Integer, ParcelFileDescriptor> build(Context context, GenericLoaderFactory genericLoaderFactory) {
            return new FileDescriptorResourceLoader(context, genericLoaderFactory.buildModelLoader(Uri.class, ParcelFileDescriptor.class));
        }

        @Override // com.hpplay.glide.load.model.ModelLoaderFactory
        public void teardown() {
        }
    }

    public FileDescriptorResourceLoader(Context context) {
        this(context, Glide.buildFileDescriptorModelLoader(Uri.class, context));
    }

    public FileDescriptorResourceLoader(Context context, ModelLoader<Uri, ParcelFileDescriptor> modelLoader) {
        super(context, modelLoader);
    }
}
