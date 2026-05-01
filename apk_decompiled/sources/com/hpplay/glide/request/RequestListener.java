package com.hpplay.glide.request;

import com.hpplay.glide.request.target.Target;

/* loaded from: classes2.dex */
public interface RequestListener<T, R> {
    boolean onException(Exception exc, T t10, Target<R> target, boolean z10);

    boolean onResourceReady(R r10, T t10, Target<R> target, boolean z10, boolean z11);
}
