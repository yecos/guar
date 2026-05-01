package com.hpplay.glide.load.data;

import com.hpplay.glide.Priority;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class ByteArrayFetcher implements DataFetcher<InputStream> {
    private final byte[] bytes;
    private final String id;

    public ByteArrayFetcher(byte[] bArr, String str) {
        this.bytes = bArr;
        this.id = str;
    }

    @Override // com.hpplay.glide.load.data.DataFetcher
    public void cancel() {
    }

    @Override // com.hpplay.glide.load.data.DataFetcher
    public void cleanup() {
    }

    @Override // com.hpplay.glide.load.data.DataFetcher
    public String getId() {
        return this.id;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.hpplay.glide.load.data.DataFetcher
    public InputStream loadData(Priority priority) {
        return new ByteArrayInputStream(this.bytes);
    }
}
