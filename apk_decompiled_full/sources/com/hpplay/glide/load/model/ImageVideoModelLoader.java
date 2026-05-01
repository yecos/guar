package com.hpplay.glide.load.model;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.hpplay.glide.Priority;
import com.hpplay.glide.load.data.DataFetcher;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class ImageVideoModelLoader<A> implements ModelLoader<A, ImageVideoWrapper> {
    private static final String TAG = "IVML";
    private final ModelLoader<A, ParcelFileDescriptor> fileDescriptorLoader;
    private final ModelLoader<A, InputStream> streamLoader;

    public static class ImageVideoFetcher implements DataFetcher<ImageVideoWrapper> {
        private final DataFetcher<ParcelFileDescriptor> fileDescriptorFetcher;
        private final DataFetcher<InputStream> streamFetcher;

        public ImageVideoFetcher(DataFetcher<InputStream> dataFetcher, DataFetcher<ParcelFileDescriptor> dataFetcher2) {
            this.streamFetcher = dataFetcher;
            this.fileDescriptorFetcher = dataFetcher2;
        }

        @Override // com.hpplay.glide.load.data.DataFetcher
        public void cancel() {
            DataFetcher<InputStream> dataFetcher = this.streamFetcher;
            if (dataFetcher != null) {
                dataFetcher.cancel();
            }
            DataFetcher<ParcelFileDescriptor> dataFetcher2 = this.fileDescriptorFetcher;
            if (dataFetcher2 != null) {
                dataFetcher2.cancel();
            }
        }

        @Override // com.hpplay.glide.load.data.DataFetcher
        public void cleanup() {
            DataFetcher<InputStream> dataFetcher = this.streamFetcher;
            if (dataFetcher != null) {
                dataFetcher.cleanup();
            }
            DataFetcher<ParcelFileDescriptor> dataFetcher2 = this.fileDescriptorFetcher;
            if (dataFetcher2 != null) {
                dataFetcher2.cleanup();
            }
        }

        @Override // com.hpplay.glide.load.data.DataFetcher
        public String getId() {
            DataFetcher<InputStream> dataFetcher = this.streamFetcher;
            return dataFetcher != null ? dataFetcher.getId() : this.fileDescriptorFetcher.getId();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Removed duplicated region for block: B:9:0x001e A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // com.hpplay.glide.load.data.DataFetcher
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public ImageVideoWrapper loadData(Priority priority) {
            InputStream loadData;
            DataFetcher<ParcelFileDescriptor> dataFetcher;
            DataFetcher<InputStream> dataFetcher2 = this.streamFetcher;
            ParcelFileDescriptor parcelFileDescriptor = null;
            if (dataFetcher2 != null) {
                try {
                    loadData = dataFetcher2.loadData(priority);
                } catch (Exception e10) {
                    Log.isLoggable(ImageVideoModelLoader.TAG, 2);
                    if (this.fileDescriptorFetcher == null) {
                        throw e10;
                    }
                }
                dataFetcher = this.fileDescriptorFetcher;
                if (dataFetcher != null) {
                    try {
                        parcelFileDescriptor = dataFetcher.loadData(priority);
                    } catch (Exception e11) {
                        Log.isLoggable(ImageVideoModelLoader.TAG, 2);
                        if (loadData == null) {
                            throw e11;
                        }
                    }
                }
                return new ImageVideoWrapper(loadData, parcelFileDescriptor);
            }
            loadData = null;
            dataFetcher = this.fileDescriptorFetcher;
            if (dataFetcher != null) {
            }
            return new ImageVideoWrapper(loadData, parcelFileDescriptor);
        }
    }

    public ImageVideoModelLoader(ModelLoader<A, InputStream> modelLoader, ModelLoader<A, ParcelFileDescriptor> modelLoader2) {
        if (modelLoader == null && modelLoader2 == null) {
            throw new NullPointerException("At least one of streamLoader and fileDescriptorLoader must be non null");
        }
        this.streamLoader = modelLoader;
        this.fileDescriptorLoader = modelLoader2;
    }

    @Override // com.hpplay.glide.load.model.ModelLoader
    public DataFetcher<ImageVideoWrapper> getResourceFetcher(A a10, int i10, int i11) {
        ModelLoader<A, InputStream> modelLoader = this.streamLoader;
        DataFetcher<InputStream> resourceFetcher = modelLoader != null ? modelLoader.getResourceFetcher(a10, i10, i11) : null;
        ModelLoader<A, ParcelFileDescriptor> modelLoader2 = this.fileDescriptorLoader;
        DataFetcher<ParcelFileDescriptor> resourceFetcher2 = modelLoader2 != null ? modelLoader2.getResourceFetcher(a10, i10, i11) : null;
        if (resourceFetcher == null && resourceFetcher2 == null) {
            return null;
        }
        return new ImageVideoFetcher(resourceFetcher, resourceFetcher2);
    }
}
