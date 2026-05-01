package com.mobile.brasiltv.db;

import java.io.Serializable;
import sa.a;
import sa.e;
import sa.f;

@e(name = "search_history")
/* loaded from: classes3.dex */
public final class SearchHistory implements Serializable {
    private String contentId;

    @a(column = "id")
    private int id;
    private String name;

    @f
    private final long serialVersionUID = -4613122994017294595L;
    private String type;

    public final String getContentId() {
        return this.contentId;
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final long getSerialVersionUID() {
        return this.serialVersionUID;
    }

    public final String getType() {
        return this.type;
    }

    public final void setContentId(String str) {
        this.contentId = str;
    }

    public final void setId(int i10) {
        this.id = i10;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setType(String str) {
        this.type = str;
    }
}
