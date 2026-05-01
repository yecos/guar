package com.umeng.analytics.pro;

import com.umeng.analytics.pro.ch;
import com.umeng.analytics.pro.co;
import java.io.Serializable;

/* loaded from: classes3.dex */
public interface ch<T extends ch<?, ?>, F extends co> extends Serializable {
    void clear();

    ch<T, F> deepCopy();

    F fieldForId(int i10);

    void read(dg dgVar);

    void write(dg dgVar);
}
