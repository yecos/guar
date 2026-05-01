package com.hpplay.sdk.source.browse.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.hpplay.sdk.source.browse.data.LelinkServiceInfoWrapper;
import com.hpplay.sdk.source.log.SourceLog;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class LelinkServiceInfo implements Parcelable, Cloneable, Comparable<LelinkServiceInfo> {
    public static final Parcelable.Creator<LelinkServiceInfo> CREATOR = new Parcelable.Creator<LelinkServiceInfo>() { // from class: com.hpplay.sdk.source.browse.api.LelinkServiceInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LelinkServiceInfo createFromParcel(Parcel parcel) {
            return new LelinkServiceInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LelinkServiceInfo[] newArray(int i10) {
            return new LelinkServiceInfo[i10];
        }
    };
    public static final int DRAINAGE_INDEX_BILI = 0;
    private static final String TAG = "LelinkServiceInfo";
    private LelinkServiceInfoWrapper mInstance;

    public LelinkServiceInfo() {
        this.mInstance = new LelinkServiceInfoWrapper();
    }

    public void decode(int i10, JSONObject jSONObject) {
        this.mInstance.decode(i10, jSONObject);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public JSONObject encode() {
        return this.mInstance.encode();
    }

    public boolean equals(Object obj) {
        LelinkServiceInfoWrapper lelinkServiceInfoWrapper = this.mInstance;
        if (lelinkServiceInfoWrapper != null) {
            return lelinkServiceInfoWrapper.equals(obj);
        }
        return false;
    }

    public int getAgentPort() {
        return this.mInstance.getAgentPort();
    }

    public String getAlias() {
        return this.mInstance.getAlias();
    }

    public int getAndroidRemotePort() {
        return this.mInstance.getAndroidRemotePort();
    }

    public int getAppId() {
        return this.mInstance.getAppId();
    }

    public Map<Integer, BrowserInfo> getBrowserInfos() {
        return this.mInstance.getBrowserInfos();
    }

    public String getChannel() {
        return this.mInstance.getChannel();
    }

    public String getDLNAModeDes() {
        return this.mInstance.getDLNAModeDes();
    }

    public String getDLNAModeName() {
        return this.mInstance.getDLNAModeName();
    }

    public String getDeviceBrand() {
        return this.mInstance.getDeviceBrand();
    }

    public int getDrainage(int i10) {
        return this.mInstance.getDrainage(i10);
    }

    public int getH() {
        return this.mInstance.getH();
    }

    public String getIp() {
        return this.mInstance.getIp();
    }

    public String getManufacturer() {
        return this.mInstance.getManufacturer();
    }

    public String getName() {
        return this.mInstance.getName();
    }

    public String getPackageName() {
        return this.mInstance.getPackageName();
    }

    public Map<String, String> getParams() {
        return this.mInstance.getParams();
    }

    public String getPinCode() {
        return this.mInstance.getPinCode();
    }

    public String getPlatform() {
        return this.mInstance.getPlatform();
    }

    public String getPol() {
        return this.mInstance.getPol();
    }

    public int getPort() {
        return this.mInstance.getPort();
    }

    public Integer[] getProtocols() {
        return this.mInstance.getProtocols();
    }

    public String getRcvPlf() {
        return this.mInstance.getRcvPlf();
    }

    public int getRemotePort() {
        return this.mInstance.getRemotePort();
    }

    public String getSSDPPacketData() {
        return this.mInstance.getSSDPPacketData();
    }

    public String getTypes() {
        return this.mInstance.getTypes();
    }

    public String getUdnUuid() {
        return this.mInstance.getUdnUuid();
    }

    public String getUid() {
        return this.mInstance.getUid();
    }

    public int getW() {
        return this.mInstance.getW();
    }

    public boolean hasNewVersion() {
        return this.mInstance.hasNewVersion();
    }

    public int hashCode() {
        return super.hashCode();
    }

    @Deprecated
    public boolean isConnect() {
        return this.mInstance.isConnect();
    }

    public boolean isLocalWifi() {
        return this.mInstance.isLocalWifi();
    }

    @Deprecated
    public boolean isOnLine() {
        return this.mInstance.isOnLine();
    }

    public boolean isSupportPassthrough() {
        return this.mInstance.isSupportPassthrough();
    }

    public void setAlias(String str) {
        this.mInstance.setAlias(str);
    }

    @Deprecated
    public void setConnect(boolean z10) {
        this.mInstance.setConnect(z10);
    }

    public void setIp(String str) {
        this.mInstance.setIp(str);
    }

    public void setManufacturer(String str) {
        this.mInstance.setManufacturer(str);
    }

    public void setName(String str) {
        this.mInstance.setName(str);
    }

    public void setPinCode(String str) {
        this.mInstance.setPinCode(str);
    }

    public void setPort(int i10) {
        this.mInstance.setPort(i10);
    }

    public void setUid(String str) {
        this.mInstance.setUid(str);
    }

    public void supplyIMBrowserInfo(int i10, BrowserInfo browserInfo) {
        this.mInstance.supplyIMBrowserInfo(i10, browserInfo);
    }

    public String toString() {
        return this.mInstance.toString();
    }

    public void updateByBrowseInfo(BrowserInfo browserInfo) {
        this.mInstance.updateByBrowseInfo(browserInfo);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.mInstance, i10);
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public LelinkServiceInfo m48clone() {
        try {
            LelinkServiceInfo lelinkServiceInfo = new LelinkServiceInfo();
            lelinkServiceInfo.mInstance = this.mInstance.m50clone();
            return lelinkServiceInfo;
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            return null;
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(LelinkServiceInfo lelinkServiceInfo) {
        return this.mInstance.compareTo(lelinkServiceInfo.mInstance);
    }

    public LelinkServiceInfo(String str, String str2) {
        this.mInstance = new LelinkServiceInfoWrapper(str, str2);
    }

    public LelinkServiceInfo(int i10, BrowserInfo browserInfo) {
        this.mInstance = new LelinkServiceInfoWrapper(i10, browserInfo);
    }

    public LelinkServiceInfo(String str, int i10) {
        this.mInstance = new LelinkServiceInfoWrapper(str, i10);
    }

    public LelinkServiceInfo(Parcel parcel) {
        try {
            this.mInstance = (LelinkServiceInfoWrapper) parcel.readParcelable(LelinkServiceInfo.class.getClassLoader());
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            this.mInstance = new LelinkServiceInfoWrapper();
        }
    }
}
