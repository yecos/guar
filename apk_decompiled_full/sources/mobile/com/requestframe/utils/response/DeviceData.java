package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class DeviceData {
    private final String deviceName;
    private String deviceType;
    private boolean isSelected;
    private final String loginCountry;
    private final String loginTime;
    private final String loginType;
    private final String sn;

    public DeviceData(String str, String str2, String str3, String str4, String str5, String str6) {
        i.g(str5, "sn");
        this.deviceName = str;
        this.loginCountry = str2;
        this.loginTime = str3;
        this.loginType = str4;
        this.sn = str5;
        this.deviceType = str6;
    }

    public static /* synthetic */ DeviceData copy$default(DeviceData deviceData, String str, String str2, String str3, String str4, String str5, String str6, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = deviceData.deviceName;
        }
        if ((i10 & 2) != 0) {
            str2 = deviceData.loginCountry;
        }
        String str7 = str2;
        if ((i10 & 4) != 0) {
            str3 = deviceData.loginTime;
        }
        String str8 = str3;
        if ((i10 & 8) != 0) {
            str4 = deviceData.loginType;
        }
        String str9 = str4;
        if ((i10 & 16) != 0) {
            str5 = deviceData.sn;
        }
        String str10 = str5;
        if ((i10 & 32) != 0) {
            str6 = deviceData.deviceType;
        }
        return deviceData.copy(str, str7, str8, str9, str10, str6);
    }

    public final String component1() {
        return this.deviceName;
    }

    public final String component2() {
        return this.loginCountry;
    }

    public final String component3() {
        return this.loginTime;
    }

    public final String component4() {
        return this.loginType;
    }

    public final String component5() {
        return this.sn;
    }

    public final String component6() {
        return this.deviceType;
    }

    public final DeviceData copy(String str, String str2, String str3, String str4, String str5, String str6) {
        i.g(str5, "sn");
        return new DeviceData(str, str2, str3, str4, str5, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceData)) {
            return false;
        }
        DeviceData deviceData = (DeviceData) obj;
        return i.b(this.deviceName, deviceData.deviceName) && i.b(this.loginCountry, deviceData.loginCountry) && i.b(this.loginTime, deviceData.loginTime) && i.b(this.loginType, deviceData.loginType) && i.b(this.sn, deviceData.sn) && i.b(this.deviceType, deviceData.deviceType);
    }

    public final String getDeviceName() {
        return this.deviceName;
    }

    public final String getDeviceType() {
        return this.deviceType;
    }

    public final String getLoginCountry() {
        return this.loginCountry;
    }

    public final String getLoginTime() {
        return this.loginTime;
    }

    public final String getLoginType() {
        return this.loginType;
    }

    public final String getSn() {
        return this.sn;
    }

    public int hashCode() {
        String str = this.deviceName;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.loginCountry;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.loginTime;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.loginType;
        int hashCode4 = (((hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.sn.hashCode()) * 31;
        String str5 = this.deviceType;
        return hashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setDeviceType(String str) {
        this.deviceType = str;
    }

    public final void setSelected(boolean z10) {
        this.isSelected = z10;
    }

    public String toString() {
        return "DeviceData(deviceName=" + this.deviceName + ", loginCountry=" + this.loginCountry + ", loginTime=" + this.loginTime + ", loginType=" + this.loginType + ", sn=" + this.sn + ", deviceType=" + this.deviceType + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
