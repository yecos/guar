package com.google.android.gms.cast.framework;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.cast.framework.Session;

/* loaded from: classes.dex */
public interface SessionManagerListener<T extends Session> {
    void onSessionEnded(@RecentlyNonNull T t10, int i10);

    void onSessionEnding(@RecentlyNonNull T t10);

    void onSessionResumeFailed(@RecentlyNonNull T t10, int i10);

    void onSessionResumed(@RecentlyNonNull T t10, boolean z10);

    void onSessionResuming(@RecentlyNonNull T t10, @RecentlyNonNull String str);

    void onSessionStartFailed(@RecentlyNonNull T t10, int i10);

    void onSessionStarted(@RecentlyNonNull T t10, @RecentlyNonNull String str);

    void onSessionStarting(@RecentlyNonNull T t10);

    void onSessionSuspended(@RecentlyNonNull T t10, int i10);
}
