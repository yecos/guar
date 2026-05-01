package com.hpplay.glide.request;

import com.hpplay.glide.request.target.Target;
import java.util.concurrent.Future;

/* loaded from: classes2.dex */
public interface FutureTarget<R> extends Target<R>, Future<R> {
    void clear();
}
