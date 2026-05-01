package com.hpplay.sdk.source.api;

import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import java.util.List;

/* loaded from: classes3.dex */
public interface IFavoriteDeviceListener extends DeviceListenerConstant {
    void onAddDevice(int i10, int i11);

    void onGetDeviceList(int i10, int i11, List<LelinkServiceInfo> list);

    void onRemoveDevice(int i10, int i11);

    void onSetDeviceAlias(int i10, int i11);
}
