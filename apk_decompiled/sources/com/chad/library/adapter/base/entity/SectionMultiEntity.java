package com.chad.library.adapter.base.entity;

import java.io.Serializable;

/* loaded from: classes.dex */
public abstract class SectionMultiEntity<T> implements Serializable, MultiItemEntity {
    public String header;
    public boolean isHeader;

    /* renamed from: t, reason: collision with root package name */
    public T f6044t;

    public SectionMultiEntity(boolean z10, String str) {
        this.isHeader = z10;
        this.header = str;
        this.f6044t = null;
    }

    public SectionMultiEntity(T t10) {
        this.isHeader = false;
        this.header = null;
        this.f6044t = t10;
    }
}
