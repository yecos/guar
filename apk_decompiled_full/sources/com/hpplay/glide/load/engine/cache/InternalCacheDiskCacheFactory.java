package com.hpplay.glide.load.engine.cache;

import android.content.Context;
import com.hpplay.glide.load.engine.cache.DiskLruCacheFactory;
import java.io.File;

/* loaded from: classes2.dex */
public final class InternalCacheDiskCacheFactory extends DiskLruCacheFactory {
    public InternalCacheDiskCacheFactory(Context context) {
        this(context, "image_manager_disk_cache", 262144000);
    }

    public InternalCacheDiskCacheFactory(Context context, int i10) {
        this(context, "image_manager_disk_cache", i10);
    }

    public InternalCacheDiskCacheFactory(final Context context, final String str, int i10) {
        super(new DiskLruCacheFactory.CacheDirectoryGetter() { // from class: com.hpplay.glide.load.engine.cache.InternalCacheDiskCacheFactory.1
            @Override // com.hpplay.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter
            public File getCacheDirectory() {
                File cacheDir = context.getCacheDir();
                if (cacheDir == null) {
                    return null;
                }
                return str != null ? new File(cacheDir, str) : cacheDir;
            }
        }, i10);
    }
}
