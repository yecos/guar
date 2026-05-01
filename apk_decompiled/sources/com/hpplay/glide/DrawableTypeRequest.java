package com.hpplay.glide;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import com.hpplay.glide.RequestManager;
import com.hpplay.glide.load.model.ImageVideoModelLoader;
import com.hpplay.glide.load.model.ImageVideoWrapper;
import com.hpplay.glide.load.model.ModelLoader;
import com.hpplay.glide.load.resource.drawable.GlideDrawable;
import com.hpplay.glide.load.resource.gifbitmap.GifBitmapWrapper;
import com.hpplay.glide.load.resource.transcode.ResourceTranscoder;
import com.hpplay.glide.manager.Lifecycle;
import com.hpplay.glide.manager.RequestTracker;
import com.hpplay.glide.provider.FixedLoadProvider;
import com.hpplay.glide.request.FutureTarget;
import com.hpplay.glide.request.target.Target;
import java.io.File;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class DrawableTypeRequest<ModelType> extends DrawableRequestBuilder<ModelType> implements DownloadOptions {
    private final ModelLoader<ModelType, ParcelFileDescriptor> fileDescriptorModelLoader;
    private final RequestManager.OptionsApplier optionsApplier;
    private final ModelLoader<ModelType, InputStream> streamModelLoader;

    public DrawableTypeRequest(Class<ModelType> cls, ModelLoader<ModelType, InputStream> modelLoader, ModelLoader<ModelType, ParcelFileDescriptor> modelLoader2, Context context, Glide glide, RequestTracker requestTracker, Lifecycle lifecycle, RequestManager.OptionsApplier optionsApplier) {
        super(context, cls, buildProvider(glide, modelLoader, modelLoader2, GifBitmapWrapper.class, GlideDrawable.class, null), glide, requestTracker, lifecycle);
        this.streamModelLoader = modelLoader;
        this.fileDescriptorModelLoader = modelLoader2;
        this.optionsApplier = optionsApplier;
    }

    private static <A, Z, R> FixedLoadProvider<A, ImageVideoWrapper, Z, R> buildProvider(Glide glide, ModelLoader<A, InputStream> modelLoader, ModelLoader<A, ParcelFileDescriptor> modelLoader2, Class<Z> cls, Class<R> cls2, ResourceTranscoder<Z, R> resourceTranscoder) {
        if (modelLoader == null && modelLoader2 == null) {
            return null;
        }
        if (resourceTranscoder == null) {
            resourceTranscoder = glide.buildTranscoder(cls, cls2);
        }
        return new FixedLoadProvider<>(new ImageVideoModelLoader(modelLoader, modelLoader2), resourceTranscoder, glide.buildDataProvider(ImageVideoWrapper.class, cls));
    }

    private GenericTranscodeRequest<ModelType, InputStream, File> getDownloadOnlyRequest() {
        RequestManager.OptionsApplier optionsApplier = this.optionsApplier;
        return (GenericTranscodeRequest) optionsApplier.apply(new GenericTranscodeRequest(File.class, this, this.streamModelLoader, InputStream.class, File.class, optionsApplier));
    }

    public BitmapTypeRequest<ModelType> asBitmap() {
        RequestManager.OptionsApplier optionsApplier = this.optionsApplier;
        return (BitmapTypeRequest) optionsApplier.apply(new BitmapTypeRequest(this, this.streamModelLoader, this.fileDescriptorModelLoader, optionsApplier));
    }

    public GifTypeRequest<ModelType> asGif() {
        RequestManager.OptionsApplier optionsApplier = this.optionsApplier;
        return (GifTypeRequest) optionsApplier.apply(new GifTypeRequest(this, this.streamModelLoader, optionsApplier));
    }

    @Override // com.hpplay.glide.DownloadOptions
    public <Y extends Target<File>> Y downloadOnly(Y y10) {
        return (Y) getDownloadOnlyRequest().downloadOnly(y10);
    }

    @Override // com.hpplay.glide.DownloadOptions
    public FutureTarget<File> downloadOnly(int i10, int i11) {
        return getDownloadOnlyRequest().downloadOnly(i10, i11);
    }
}
