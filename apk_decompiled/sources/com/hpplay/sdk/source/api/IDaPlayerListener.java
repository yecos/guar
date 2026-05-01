package com.hpplay.sdk.source.api;

import com.hpplay.sdk.source.bean.DaCastBean;

/* loaded from: classes3.dex */
public interface IDaPlayerListener {
    void onLoading(DaCastBean daCastBean);

    void onResult(DaCastBean daCastBean, boolean z10);

    void onStart(DaCastBean daCastBean);

    void onStop(DaCastBean daCastBean);
}
