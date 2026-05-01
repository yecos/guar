package com.hpplay.glide;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import com.hpplay.glide.load.Key;
import com.hpplay.glide.load.engine.DiskCacheStrategy;
import com.hpplay.glide.load.model.ModelLoader;
import com.hpplay.glide.load.model.file_descriptor.FileDescriptorModelLoader;
import com.hpplay.glide.load.model.stream.MediaStoreStreamLoader;
import com.hpplay.glide.load.model.stream.StreamByteArrayLoader;
import com.hpplay.glide.load.model.stream.StreamModelLoader;
import com.hpplay.glide.manager.ConnectivityMonitor;
import com.hpplay.glide.manager.ConnectivityMonitorFactory;
import com.hpplay.glide.manager.Lifecycle;
import com.hpplay.glide.manager.LifecycleListener;
import com.hpplay.glide.manager.RequestManagerTreeNode;
import com.hpplay.glide.manager.RequestTracker;
import com.hpplay.glide.signature.ApplicationVersionSignature;
import com.hpplay.glide.signature.MediaStoreSignature;
import com.hpplay.glide.signature.StringSignature;
import com.hpplay.glide.util.Util;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.UUID;

/* loaded from: classes2.dex */
public class RequestManager implements LifecycleListener {
    private final Context context;
    private final Glide glide;
    private final Lifecycle lifecycle;
    private DefaultOptions options;
    private final OptionsApplier optionsApplier;
    private final RequestTracker requestTracker;
    private final RequestManagerTreeNode treeNode;

    public interface DefaultOptions {
        <T> void apply(GenericRequestBuilder<T, ?, ?, ?> genericRequestBuilder);
    }

    public final class ImageModelRequest<T> {
        private final ModelLoader<T, InputStream> loader;

        public ImageModelRequest(ModelLoader<T, InputStream> modelLoader) {
            this.loader = modelLoader;
        }

        public DrawableTypeRequest<T> from(Class<T> cls) {
            return (DrawableTypeRequest) RequestManager.this.optionsApplier.apply(new DrawableTypeRequest(cls, this.loader, null, RequestManager.this.context, RequestManager.this.glide, RequestManager.this.requestTracker, RequestManager.this.lifecycle, RequestManager.this.optionsApplier));
        }

        public DrawableTypeRequest<T> load(T t10) {
            return (DrawableTypeRequest) from(RequestManager.getSafeClass(t10)).load((DrawableTypeRequest<T>) t10);
        }
    }

    public class OptionsApplier {
        public OptionsApplier() {
        }

        public <A, X extends GenericRequestBuilder<A, ?, ?, ?>> X apply(X x10) {
            if (RequestManager.this.options != null) {
                RequestManager.this.options.apply(x10);
            }
            return x10;
        }
    }

    public static class RequestManagerConnectivityListener implements ConnectivityMonitor.ConnectivityListener {
        private final RequestTracker requestTracker;

        public RequestManagerConnectivityListener(RequestTracker requestTracker) {
            this.requestTracker = requestTracker;
        }

        @Override // com.hpplay.glide.manager.ConnectivityMonitor.ConnectivityListener
        public void onConnectivityChanged(boolean z10) {
            if (z10) {
                this.requestTracker.restartRequests();
            }
        }
    }

    public final class VideoModelRequest<T> {
        private final ModelLoader<T, ParcelFileDescriptor> loader;

        public VideoModelRequest(ModelLoader<T, ParcelFileDescriptor> modelLoader) {
            this.loader = modelLoader;
        }

        public DrawableTypeRequest<T> load(T t10) {
            return (DrawableTypeRequest) ((DrawableTypeRequest) RequestManager.this.optionsApplier.apply(new DrawableTypeRequest(RequestManager.getSafeClass(t10), null, this.loader, RequestManager.this.context, RequestManager.this.glide, RequestManager.this.requestTracker, RequestManager.this.lifecycle, RequestManager.this.optionsApplier))).load((DrawableTypeRequest) t10);
        }
    }

    public RequestManager(Context context, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode) {
        this(context, lifecycle, requestManagerTreeNode, new RequestTracker(), new ConnectivityMonitorFactory());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> Class<T> getSafeClass(T t10) {
        if (t10 != null) {
            return (Class<T>) t10.getClass();
        }
        return null;
    }

    private <T> DrawableTypeRequest<T> loadGeneric(Class<T> cls) {
        ModelLoader buildStreamModelLoader = Glide.buildStreamModelLoader((Class) cls, this.context);
        ModelLoader buildFileDescriptorModelLoader = Glide.buildFileDescriptorModelLoader((Class) cls, this.context);
        if (cls == null || buildStreamModelLoader != null || buildFileDescriptorModelLoader != null) {
            OptionsApplier optionsApplier = this.optionsApplier;
            return (DrawableTypeRequest) optionsApplier.apply(new DrawableTypeRequest(cls, buildStreamModelLoader, buildFileDescriptorModelLoader, this.context, this.glide, this.requestTracker, this.lifecycle, optionsApplier));
        }
        throw new IllegalArgumentException("Unknown type " + cls + ". You must provide a Model of a type for which there is a registered ModelLoader, if you are using a custom model, you must first call Glide#register with a ModelLoaderFactory for your custom model class");
    }

    public <T> DrawableTypeRequest<T> from(Class<T> cls) {
        return loadGeneric(cls);
    }

    public DrawableTypeRequest<byte[]> fromBytes() {
        return (DrawableTypeRequest) loadGeneric(byte[].class).signature((Key) new StringSignature(UUID.randomUUID().toString())).diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true);
    }

    public DrawableTypeRequest<File> fromFile() {
        return loadGeneric(File.class);
    }

    public DrawableTypeRequest<Uri> fromMediaStore() {
        MediaStoreStreamLoader mediaStoreStreamLoader = new MediaStoreStreamLoader(this.context, Glide.buildStreamModelLoader(Uri.class, this.context));
        ModelLoader buildFileDescriptorModelLoader = Glide.buildFileDescriptorModelLoader(Uri.class, this.context);
        OptionsApplier optionsApplier = this.optionsApplier;
        return (DrawableTypeRequest) optionsApplier.apply(new DrawableTypeRequest(Uri.class, mediaStoreStreamLoader, buildFileDescriptorModelLoader, this.context, this.glide, this.requestTracker, this.lifecycle, optionsApplier));
    }

    public DrawableTypeRequest<Integer> fromResource() {
        return (DrawableTypeRequest) loadGeneric(Integer.class).signature(ApplicationVersionSignature.obtain(this.context));
    }

    public DrawableTypeRequest<String> fromString() {
        return loadGeneric(String.class);
    }

    public DrawableTypeRequest<Uri> fromUri() {
        return loadGeneric(Uri.class);
    }

    @Deprecated
    public DrawableTypeRequest<URL> fromUrl() {
        return loadGeneric(URL.class);
    }

    public boolean isPaused() {
        Util.assertMainThread();
        return this.requestTracker.isPaused();
    }

    public DrawableTypeRequest<String> load(String str) {
        return (DrawableTypeRequest) fromString().load((DrawableTypeRequest<String>) str);
    }

    @Deprecated
    public DrawableTypeRequest<Uri> loadFromMediaStore(Uri uri, String str, long j10, int i10) {
        return (DrawableTypeRequest) loadFromMediaStore(uri).signature((Key) new MediaStoreSignature(str, j10, i10));
    }

    @Override // com.hpplay.glide.manager.LifecycleListener
    public void onDestroy() {
        this.requestTracker.clearRequests();
    }

    public void onLowMemory() {
        this.glide.clearMemory();
    }

    @Override // com.hpplay.glide.manager.LifecycleListener
    public void onStart() {
        resumeRequests();
    }

    @Override // com.hpplay.glide.manager.LifecycleListener
    public void onStop() {
        pauseRequests();
    }

    public void onTrimMemory(int i10) {
        this.glide.trimMemory(i10);
    }

    public void pauseRequests() {
        Util.assertMainThread();
        this.requestTracker.pauseRequests();
    }

    public void pauseRequestsRecursive() {
        Util.assertMainThread();
        pauseRequests();
        Iterator<RequestManager> it = this.treeNode.getDescendants().iterator();
        while (it.hasNext()) {
            it.next().pauseRequests();
        }
    }

    public void resumeRequests() {
        Util.assertMainThread();
        this.requestTracker.resumeRequests();
    }

    public void resumeRequestsRecursive() {
        Util.assertMainThread();
        resumeRequests();
        Iterator<RequestManager> it = this.treeNode.getDescendants().iterator();
        while (it.hasNext()) {
            it.next().resumeRequests();
        }
    }

    public void setDefaultOptions(DefaultOptions defaultOptions) {
        this.options = defaultOptions;
    }

    public <A, T> GenericModelRequest<A, T> using(ModelLoader<A, T> modelLoader, Class<T> cls) {
        return new GenericModelRequest<>(modelLoader, cls);
    }

    public RequestManager(Context context, final Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, RequestTracker requestTracker, ConnectivityMonitorFactory connectivityMonitorFactory) {
        this.context = context.getApplicationContext();
        this.lifecycle = lifecycle;
        this.treeNode = requestManagerTreeNode;
        this.requestTracker = requestTracker;
        this.glide = Glide.get(context);
        this.optionsApplier = new OptionsApplier();
        ConnectivityMonitor build = connectivityMonitorFactory.build(context, new RequestManagerConnectivityListener(requestTracker));
        if (Util.isOnBackgroundThread()) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.hpplay.glide.RequestManager.1
                @Override // java.lang.Runnable
                public void run() {
                    lifecycle.addListener(RequestManager.this);
                }
            });
        } else {
            lifecycle.addListener(this);
        }
        lifecycle.addListener(build);
    }

    public DrawableTypeRequest<Uri> load(Uri uri) {
        return (DrawableTypeRequest) fromUri().load((DrawableTypeRequest<Uri>) uri);
    }

    public <T> ImageModelRequest<T> using(StreamModelLoader<T> streamModelLoader) {
        return new ImageModelRequest<>(streamModelLoader);
    }

    public final class GenericModelRequest<A, T> {
        private final Class<T> dataClass;
        private final ModelLoader<A, T> modelLoader;

        public GenericModelRequest(ModelLoader<A, T> modelLoader, Class<T> cls) {
            this.modelLoader = modelLoader;
            this.dataClass = cls;
        }

        public GenericModelRequest<A, T>.GenericTypeRequest from(Class<A> cls) {
            return new GenericTypeRequest((Class) cls);
        }

        public GenericModelRequest<A, T>.GenericTypeRequest load(A a10) {
            return new GenericTypeRequest(a10);
        }

        public final class GenericTypeRequest {
            private final A model;
            private final Class<A> modelClass;
            private final boolean providedModel;

            public GenericTypeRequest(A a10) {
                this.providedModel = true;
                this.model = a10;
                this.modelClass = RequestManager.getSafeClass(a10);
            }

            public <Z> GenericTranscodeRequest<A, T, Z> as(Class<Z> cls) {
                GenericTranscodeRequest<A, T, Z> genericTranscodeRequest = (GenericTranscodeRequest) RequestManager.this.optionsApplier.apply(new GenericTranscodeRequest(RequestManager.this.context, RequestManager.this.glide, this.modelClass, GenericModelRequest.this.modelLoader, GenericModelRequest.this.dataClass, cls, RequestManager.this.requestTracker, RequestManager.this.lifecycle, RequestManager.this.optionsApplier));
                if (this.providedModel) {
                    genericTranscodeRequest.load(this.model);
                }
                return genericTranscodeRequest;
            }

            public GenericTypeRequest(Class<A> cls) {
                this.providedModel = false;
                this.model = null;
                this.modelClass = cls;
            }
        }
    }

    public DrawableTypeRequest<File> load(File file) {
        return (DrawableTypeRequest) fromFile().load((DrawableTypeRequest<File>) file);
    }

    public DrawableTypeRequest<Uri> loadFromMediaStore(Uri uri) {
        return (DrawableTypeRequest) fromMediaStore().load((DrawableTypeRequest<Uri>) uri);
    }

    public ImageModelRequest<byte[]> using(StreamByteArrayLoader streamByteArrayLoader) {
        return new ImageModelRequest<>(streamByteArrayLoader);
    }

    public DrawableTypeRequest<Integer> load(Integer num) {
        return (DrawableTypeRequest) fromResource().load((DrawableTypeRequest<Integer>) num);
    }

    public <T> VideoModelRequest<T> using(FileDescriptorModelLoader<T> fileDescriptorModelLoader) {
        return new VideoModelRequest<>(fileDescriptorModelLoader);
    }

    @Deprecated
    public DrawableTypeRequest<URL> load(URL url) {
        return (DrawableTypeRequest) fromUrl().load((DrawableTypeRequest<URL>) url);
    }

    @Deprecated
    public DrawableTypeRequest<byte[]> load(byte[] bArr, String str) {
        return (DrawableTypeRequest) load(bArr).signature((Key) new StringSignature(str));
    }

    public DrawableTypeRequest<byte[]> load(byte[] bArr) {
        return (DrawableTypeRequest) fromBytes().load((DrawableTypeRequest<byte[]>) bArr);
    }

    public <T> DrawableTypeRequest<T> load(T t10) {
        return (DrawableTypeRequest) loadGeneric(getSafeClass(t10)).load((DrawableTypeRequest<T>) t10);
    }
}
