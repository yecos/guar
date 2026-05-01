package com.hpplay.glide.load.engine;

import android.util.Log;
import com.hpplay.glide.Priority;
import com.hpplay.glide.load.engine.executor.Prioritized;
import com.hpplay.glide.request.ResourceCallback;

/* loaded from: classes2.dex */
class EngineRunnable implements Prioritized, Runnable {
    private static final String TAG = "EngineRunnable";
    private final DecodeJob<?, ?, ?> decodeJob;
    private volatile boolean isCancelled;
    private final EngineRunnableManager manager;
    private final Priority priority;
    private Stage stage = Stage.CACHE;

    public interface EngineRunnableManager extends ResourceCallback {
        void submitForSource(EngineRunnable engineRunnable);
    }

    public enum Stage {
        CACHE,
        SOURCE
    }

    public EngineRunnable(EngineRunnableManager engineRunnableManager, DecodeJob<?, ?, ?> decodeJob, Priority priority) {
        this.manager = engineRunnableManager;
        this.decodeJob = decodeJob;
        this.priority = priority;
    }

    private Resource<?> decode() {
        return isDecodingFromCache() ? decodeFromCache() : decodeFromSource();
    }

    private Resource<?> decodeFromCache() {
        Resource<?> resource;
        try {
            resource = this.decodeJob.decodeResultFromCache();
        } catch (Exception e10) {
            if (Log.isLoggable(TAG, 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Exception decoding result from cache: ");
                sb.append(e10);
            }
            resource = null;
        }
        return resource == null ? this.decodeJob.decodeSourceFromCache() : resource;
    }

    private Resource<?> decodeFromSource() {
        return this.decodeJob.decodeFromSource();
    }

    private boolean isDecodingFromCache() {
        return this.stage == Stage.CACHE;
    }

    private void onLoadComplete(Resource resource) {
        this.manager.onResourceReady(resource);
    }

    private void onLoadFailed(Exception exc) {
        if (!isDecodingFromCache()) {
            this.manager.onException(exc);
        } else {
            this.stage = Stage.SOURCE;
            this.manager.submitForSource(this);
        }
    }

    public void cancel() {
        this.isCancelled = true;
        this.decodeJob.cancel();
    }

    @Override // com.hpplay.glide.load.engine.executor.Prioritized
    public int getPriority() {
        return this.priority.ordinal();
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.isCancelled) {
            return;
        }
        Resource<?> resource = null;
        try {
            e = null;
            resource = decode();
        } catch (Exception e10) {
            e = e10;
            Log.isLoggable(TAG, 2);
        }
        if (this.isCancelled) {
            if (resource != null) {
                resource.recycle();
            }
        } else if (resource == null) {
            onLoadFailed(e);
        } else {
            onLoadComplete(resource);
        }
    }
}
