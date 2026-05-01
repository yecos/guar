package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.hpplay.cybergarage.upnp.DeviceList;
import java.util.List;
import t9.i;

/* loaded from: classes3.dex */
public final class DevicesListData {
    private final List<DeviceData> deviceList;

    public DevicesListData(List<DeviceData> list) {
        i.g(list, DeviceList.ELEM_NAME);
        this.deviceList = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DevicesListData copy$default(DevicesListData devicesListData, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = devicesListData.deviceList;
        }
        return devicesListData.copy(list);
    }

    public final List<DeviceData> component1() {
        return this.deviceList;
    }

    public final DevicesListData copy(List<DeviceData> list) {
        i.g(list, DeviceList.ELEM_NAME);
        return new DevicesListData(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DevicesListData) && i.b(this.deviceList, ((DevicesListData) obj).deviceList);
    }

    public final List<DeviceData> getDeviceList() {
        return this.deviceList;
    }

    public int hashCode() {
        return this.deviceList.hashCode();
    }

    public String toString() {
        return "DevicesListData(deviceList=" + this.deviceList + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
