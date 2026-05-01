package com.mobile.brasiltv.bean.event;

import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import java.util.List;

/* loaded from: classes3.dex */
public final class CastSearchResultEvent {
    private List<LelinkServiceInfo> list;
    private int resultCode;

    public CastSearchResultEvent(int i10, List<LelinkServiceInfo> list) {
        this.resultCode = i10;
        this.list = list;
    }

    public final List<LelinkServiceInfo> getList() {
        return this.list;
    }

    public final int getResultCode() {
        return this.resultCode;
    }

    public final void setList(List<LelinkServiceInfo> list) {
        this.list = list;
    }

    public final void setResultCode(int i10) {
        this.resultCode = i10;
    }
}
