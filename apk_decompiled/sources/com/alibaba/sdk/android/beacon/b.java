package com.alibaba.sdk.android.beacon;

import com.alibaba.sdk.android.beacon.Beacon;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    private final List<Beacon.Config> f5836a = new ArrayList();

    public b(Beacon beacon) {
    }

    public List<Beacon.Config> a() {
        return Collections.unmodifiableList(this.f5836a);
    }
}
