package com.hpplay.glide.load.resource;

import com.hpplay.glide.load.ResourceEncoder;
import com.hpplay.glide.load.engine.Resource;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public class NullResourceEncoder<T> implements ResourceEncoder<T> {
    private static final NullResourceEncoder<?> NULL_ENCODER = new NullResourceEncoder<>();

    public static <T> NullResourceEncoder<T> get() {
        return (NullResourceEncoder<T>) NULL_ENCODER;
    }

    @Override // com.hpplay.glide.load.Encoder
    public boolean encode(Resource<T> resource, OutputStream outputStream) {
        return false;
    }

    @Override // com.hpplay.glide.load.Encoder
    public String getId() {
        return "";
    }
}
