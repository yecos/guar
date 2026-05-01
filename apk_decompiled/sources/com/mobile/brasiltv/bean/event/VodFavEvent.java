package com.mobile.brasiltv.bean.event;

import mobile.com.requestframe.utils.response.AssetData;
import t9.i;

/* loaded from: classes3.dex */
public final class VodFavEvent {
    private AssetData data;

    public VodFavEvent(AssetData assetData) {
        i.g(assetData, "data");
        this.data = assetData;
    }

    public final AssetData getData() {
        return this.data;
    }

    public final void setData(AssetData assetData) {
        i.g(assetData, "<set-?>");
        this.data = assetData;
    }
}
