package com.hpplay.glide.load.data;

import android.content.res.AssetManager;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class StreamAssetPathFetcher extends AssetPathFetcher<InputStream> {
    public StreamAssetPathFetcher(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    @Override // com.hpplay.glide.load.data.AssetPathFetcher
    public void close(InputStream inputStream) {
        inputStream.close();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.hpplay.glide.load.data.AssetPathFetcher
    public InputStream loadResource(AssetManager assetManager, String str) {
        return assetManager.open(str);
    }
}
