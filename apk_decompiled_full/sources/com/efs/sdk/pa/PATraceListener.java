package com.efs.sdk.pa;

/* loaded from: classes.dex */
public interface PATraceListener {
    void onAnrTrace();

    void onCheck(boolean z10);

    void onUnexcept(Object obj);
}
