package com.efs.sdk.base.core.cache;

import java.io.File;

/* loaded from: classes.dex */
public interface IFileFilter {
    boolean filter(File file);

    void finish();

    void finish(boolean z10, boolean z11);

    boolean hasTask();
}
