package com.mobile.brasiltv.db;

import java.io.Serializable;
import sa.a;
import sa.e;
import t9.i;

@e(name = "search_live_history")
/* loaded from: classes3.dex */
public final class SearchLiveHistory implements Serializable {
    private String alias;

    @a(column = "id")
    private int id;
    private String channelCode = "";
    private String name = "";

    public final String getAlias() {
        return this.alias;
    }

    public final String getChannelCode() {
        return this.channelCode;
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final void setAlias(String str) {
        this.alias = str;
    }

    public final void setChannelCode(String str) {
        i.g(str, "<set-?>");
        this.channelCode = str;
    }

    public final void setId(int i10) {
        this.id = i10;
    }

    public final void setName(String str) {
        i.g(str, "<set-?>");
        this.name = str;
    }
}
