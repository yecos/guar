package com.hpplay.glide.load;

import java.io.OutputStream;

/* loaded from: classes2.dex */
public interface Encoder<T> {
    boolean encode(T t10, OutputStream outputStream);

    String getId();
}
