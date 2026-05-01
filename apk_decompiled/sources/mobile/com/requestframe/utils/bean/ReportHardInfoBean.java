package mobile.com.requestframe.utils.bean;

import com.google.firebase.messaging.Constants;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.hpplay.cybergarage.upnp.Device;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import t9.i;

/* loaded from: classes3.dex */
public final class ReportHardInfoBean {
    private String androidId;
    private String board;
    private String brand;
    private String cpuAbi;
    private String cpuId;
    private String device;
    private String diskInfo;
    private String display;
    private String etheMac;
    private String fingerprint;
    private String gatewayMac;
    private String hardware;
    private String host;
    private String manufacturer;
    private String ramSize;
    private String romSize;
    private String serialNumber;
    private String tags;
    private String verId;
    private String wifiMac;

    public ReportHardInfoBean(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20) {
        i.g(str, "androidId");
        i.g(str2, "wifiMac");
        i.g(str3, "etheMac");
        i.g(str4, "serialNumber");
        i.g(str5, "diskInfo");
        i.g(str6, "ramSize");
        i.g(str7, "romSize");
        i.g(str8, "gatewayMac");
        i.g(str9, "cpuId");
        i.g(str10, Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION);
        i.g(str11, com.taobao.accs.common.Constants.KEY_BRAND);
        i.g(str12, "verId");
        i.g(str13, "cpuAbi");
        i.g(str14, "hardware");
        i.g(str15, BrowserInfo.KEY_MANUFACTURER);
        i.g(str16, "fingerprint");
        i.g(str17, com.taobao.accs.common.Constants.KEY_HOST);
        i.g(str18, Device.ELEM_NAME);
        i.g(str19, "board");
        i.g(str20, "tags");
        this.androidId = str;
        this.wifiMac = str2;
        this.etheMac = str3;
        this.serialNumber = str4;
        this.diskInfo = str5;
        this.ramSize = str6;
        this.romSize = str7;
        this.gatewayMac = str8;
        this.cpuId = str9;
        this.display = str10;
        this.brand = str11;
        this.verId = str12;
        this.cpuAbi = str13;
        this.hardware = str14;
        this.manufacturer = str15;
        this.fingerprint = str16;
        this.host = str17;
        this.device = str18;
        this.board = str19;
        this.tags = str20;
    }

    public final String component1() {
        return this.androidId;
    }

    public final String component10() {
        return this.display;
    }

    public final String component11() {
        return this.brand;
    }

    public final String component12() {
        return this.verId;
    }

    public final String component13() {
        return this.cpuAbi;
    }

    public final String component14() {
        return this.hardware;
    }

    public final String component15() {
        return this.manufacturer;
    }

    public final String component16() {
        return this.fingerprint;
    }

    public final String component17() {
        return this.host;
    }

    public final String component18() {
        return this.device;
    }

    public final String component19() {
        return this.board;
    }

    public final String component2() {
        return this.wifiMac;
    }

    public final String component20() {
        return this.tags;
    }

    public final String component3() {
        return this.etheMac;
    }

    public final String component4() {
        return this.serialNumber;
    }

    public final String component5() {
        return this.diskInfo;
    }

    public final String component6() {
        return this.ramSize;
    }

    public final String component7() {
        return this.romSize;
    }

    public final String component8() {
        return this.gatewayMac;
    }

    public final String component9() {
        return this.cpuId;
    }

    public final ReportHardInfoBean copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20) {
        i.g(str, "androidId");
        i.g(str2, "wifiMac");
        i.g(str3, "etheMac");
        i.g(str4, "serialNumber");
        i.g(str5, "diskInfo");
        i.g(str6, "ramSize");
        i.g(str7, "romSize");
        i.g(str8, "gatewayMac");
        i.g(str9, "cpuId");
        i.g(str10, Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION);
        i.g(str11, com.taobao.accs.common.Constants.KEY_BRAND);
        i.g(str12, "verId");
        i.g(str13, "cpuAbi");
        i.g(str14, "hardware");
        i.g(str15, BrowserInfo.KEY_MANUFACTURER);
        i.g(str16, "fingerprint");
        i.g(str17, com.taobao.accs.common.Constants.KEY_HOST);
        i.g(str18, Device.ELEM_NAME);
        i.g(str19, "board");
        i.g(str20, "tags");
        return new ReportHardInfoBean(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReportHardInfoBean)) {
            return false;
        }
        ReportHardInfoBean reportHardInfoBean = (ReportHardInfoBean) obj;
        return i.b(this.androidId, reportHardInfoBean.androidId) && i.b(this.wifiMac, reportHardInfoBean.wifiMac) && i.b(this.etheMac, reportHardInfoBean.etheMac) && i.b(this.serialNumber, reportHardInfoBean.serialNumber) && i.b(this.diskInfo, reportHardInfoBean.diskInfo) && i.b(this.ramSize, reportHardInfoBean.ramSize) && i.b(this.romSize, reportHardInfoBean.romSize) && i.b(this.gatewayMac, reportHardInfoBean.gatewayMac) && i.b(this.cpuId, reportHardInfoBean.cpuId) && i.b(this.display, reportHardInfoBean.display) && i.b(this.brand, reportHardInfoBean.brand) && i.b(this.verId, reportHardInfoBean.verId) && i.b(this.cpuAbi, reportHardInfoBean.cpuAbi) && i.b(this.hardware, reportHardInfoBean.hardware) && i.b(this.manufacturer, reportHardInfoBean.manufacturer) && i.b(this.fingerprint, reportHardInfoBean.fingerprint) && i.b(this.host, reportHardInfoBean.host) && i.b(this.device, reportHardInfoBean.device) && i.b(this.board, reportHardInfoBean.board) && i.b(this.tags, reportHardInfoBean.tags);
    }

    public final String getAndroidId() {
        return this.androidId;
    }

    public final String getBoard() {
        return this.board;
    }

    public final String getBrand() {
        return this.brand;
    }

    public final String getCpuAbi() {
        return this.cpuAbi;
    }

    public final String getCpuId() {
        return this.cpuId;
    }

    public final String getDevice() {
        return this.device;
    }

    public final String getDiskInfo() {
        return this.diskInfo;
    }

    public final String getDisplay() {
        return this.display;
    }

    public final String getEtheMac() {
        return this.etheMac;
    }

    public final String getFingerprint() {
        return this.fingerprint;
    }

    public final String getGatewayMac() {
        return this.gatewayMac;
    }

    public final String getHardware() {
        return this.hardware;
    }

    public final String getHost() {
        return this.host;
    }

    public final String getManufacturer() {
        return this.manufacturer;
    }

    public final String getRamSize() {
        return this.ramSize;
    }

    public final String getRomSize() {
        return this.romSize;
    }

    public final String getSerialNumber() {
        return this.serialNumber;
    }

    public final String getTags() {
        return this.tags;
    }

    public final String getVerId() {
        return this.verId;
    }

    public final String getWifiMac() {
        return this.wifiMac;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((this.androidId.hashCode() * 31) + this.wifiMac.hashCode()) * 31) + this.etheMac.hashCode()) * 31) + this.serialNumber.hashCode()) * 31) + this.diskInfo.hashCode()) * 31) + this.ramSize.hashCode()) * 31) + this.romSize.hashCode()) * 31) + this.gatewayMac.hashCode()) * 31) + this.cpuId.hashCode()) * 31) + this.display.hashCode()) * 31) + this.brand.hashCode()) * 31) + this.verId.hashCode()) * 31) + this.cpuAbi.hashCode()) * 31) + this.hardware.hashCode()) * 31) + this.manufacturer.hashCode()) * 31) + this.fingerprint.hashCode()) * 31) + this.host.hashCode()) * 31) + this.device.hashCode()) * 31) + this.board.hashCode()) * 31) + this.tags.hashCode();
    }

    public final void setAndroidId(String str) {
        i.g(str, "<set-?>");
        this.androidId = str;
    }

    public final void setBoard(String str) {
        i.g(str, "<set-?>");
        this.board = str;
    }

    public final void setBrand(String str) {
        i.g(str, "<set-?>");
        this.brand = str;
    }

    public final void setCpuAbi(String str) {
        i.g(str, "<set-?>");
        this.cpuAbi = str;
    }

    public final void setCpuId(String str) {
        i.g(str, "<set-?>");
        this.cpuId = str;
    }

    public final void setDevice(String str) {
        i.g(str, "<set-?>");
        this.device = str;
    }

    public final void setDiskInfo(String str) {
        i.g(str, "<set-?>");
        this.diskInfo = str;
    }

    public final void setDisplay(String str) {
        i.g(str, "<set-?>");
        this.display = str;
    }

    public final void setEtheMac(String str) {
        i.g(str, "<set-?>");
        this.etheMac = str;
    }

    public final void setFingerprint(String str) {
        i.g(str, "<set-?>");
        this.fingerprint = str;
    }

    public final void setGatewayMac(String str) {
        i.g(str, "<set-?>");
        this.gatewayMac = str;
    }

    public final void setHardware(String str) {
        i.g(str, "<set-?>");
        this.hardware = str;
    }

    public final void setHost(String str) {
        i.g(str, "<set-?>");
        this.host = str;
    }

    public final void setManufacturer(String str) {
        i.g(str, "<set-?>");
        this.manufacturer = str;
    }

    public final void setRamSize(String str) {
        i.g(str, "<set-?>");
        this.ramSize = str;
    }

    public final void setRomSize(String str) {
        i.g(str, "<set-?>");
        this.romSize = str;
    }

    public final void setSerialNumber(String str) {
        i.g(str, "<set-?>");
        this.serialNumber = str;
    }

    public final void setTags(String str) {
        i.g(str, "<set-?>");
        this.tags = str;
    }

    public final void setVerId(String str) {
        i.g(str, "<set-?>");
        this.verId = str;
    }

    public final void setWifiMac(String str) {
        i.g(str, "<set-?>");
        this.wifiMac = str;
    }

    public String toString() {
        return "ReportHardInfoBean(androidId=" + this.androidId + ", wifiMac=" + this.wifiMac + ", etheMac=" + this.etheMac + ", serialNumber=" + this.serialNumber + ", diskInfo=" + this.diskInfo + ", ramSize=" + this.ramSize + ", romSize=" + this.romSize + ", gatewayMac=" + this.gatewayMac + ", cpuId=" + this.cpuId + ", display=" + this.display + ", brand=" + this.brand + ", verId=" + this.verId + ", cpuAbi=" + this.cpuAbi + ", hardware=" + this.hardware + ", manufacturer=" + this.manufacturer + ", fingerprint=" + this.fingerprint + ", host=" + this.host + ", device=" + this.device + ", board=" + this.board + ", tags=" + this.tags + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ ReportHardInfoBean(java.lang.String r25, java.lang.String r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, java.lang.String r36, java.lang.String r37, java.lang.String r38, java.lang.String r39, java.lang.String r40, java.lang.String r41, java.lang.String r42, java.lang.String r43, java.lang.String r44, int r45, t9.g r46) {
        /*
            Method dump skipped, instructions count: 185
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: mobile.com.requestframe.utils.bean.ReportHardInfoBean.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, t9.g):void");
    }
}
