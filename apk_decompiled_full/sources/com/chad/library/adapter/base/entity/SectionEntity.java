package com.chad.library.adapter.base.entity;

import java.io.Serializable;

/* loaded from: classes.dex */
public abstract class SectionEntity<T> implements Serializable {
    public String header;
    public boolean isHeader;

    /* renamed from: t, reason: collision with root package name */
    public T f6043t;

    public SectionEntity(boolean z10, String str) {
        this.isHeader = z10;
        this.header = str;
        this.f6043t = null;
    }

    public SectionEntity(T t10) {
        this.isHeader = false;
        this.header = null;
        this.f6043t = t10;
    }
}
