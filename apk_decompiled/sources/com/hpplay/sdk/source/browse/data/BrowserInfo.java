package com.hpplay.sdk.source.browse.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.hpplay.common.utils.FieldUtil;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.hpplay.cybergarage.upnp.Device;
import com.hpplay.sdk.source.log.SourceLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class BrowserInfo implements Parcelable, Cloneable {
    public static final int CONNECT_TYPE_HTTP = 1;
    public static final int CONNECT_TYPE_TCP = 0;
    public static final int CREATE_TYPE_BLUETOOTH_PIN = 10;
    public static final int CREATE_TYPE_BROADCAST = 1;
    public static final int CREATE_TYPE_CONFERENCE = 6;
    public static final int CREATE_TYPE_DEV_CLOUD = 11;
    public static final int CREATE_TYPE_HISTORY_PIN = 11;
    public static final int CREATE_TYPE_IP_PORT = 8;
    public static final int CREATE_TYPE_LOCAL_CACHE = 3;
    public static final int CREATE_TYPE_NFC = 7;
    public static final int CREATE_TYPE_PIN_CODE = 5;
    public static final int CREATE_TYPE_QRCODE = 2;
    public static final int CREATE_TYPE_REMOTE_CACHE = 4;
    public static final int CREATE_TYPE_SONIC_PIN = 9;
    public static final String KEY_AGENT_PORT = "agentPort";
    public static final String KEY_AIRPLAY = "airplay";
    public static final String KEY_APP_ID = "a";
    public static final String KEY_APP_INFO = "appInfo";
    public static final String KEY_ATV = "atv";
    public static final String KEY_CHANNEL = "channel";
    public static final String KEY_CNAME = "cname";
    public static final String KEY_CREATE_TIME = "createTime";
    public static final String KEY_DEVICE_BRAND = "deviceBrand";
    public static final String KEY_DEVICE_NAME = "deviceName";
    public static final String KEY_DLNA_LOCATION = "dlna_location";
    public static final String KEY_DLNA_MODE_DESC = "dlna_mode_desc";
    public static final String KEY_DLNA_MODE_NAME = "dlna_mode_name";
    public static final String KEY_DLNA_UDN_UUID = "dlna_udn_uuid";
    public static final String KEY_DLNA_UUID = "dln_UUID";
    public static final String KEY_DOMAIN = "domain";
    public static final String KEY_DRAINAGE = "drainage";
    public static final String KEY_ETV = "etv";
    private static final String KEY_EXTRA = "extras";
    public static final String KEY_FE = "fe";
    public static final String KEY_FEATURE = "feature";
    public static final String KEY_HEIGHT = "h";
    public static final String KEY_HMD = "hmd";
    public static final String KEY_HSTV = "hstv";
    public static final String KEY_HTV = "htv";
    public static final String KEY_IP = "ip";
    public static final String KEY_ISCONFERENCE = "isconference";
    public static final String KEY_LANGUAGE = "language";
    public static final String KEY_LEBO_FEATURE = "lebofeature";
    public static final String KEY_LELINK_PORT = "lelinkport";
    public static final String KEY_MANUFACTURER = "manufacturer";
    public static final String KEY_MIRROR = "mirror";
    public static final String KEY_NAME = "name";
    public static final String KEY_OMD = "omd";
    public static final String KEY_PHONE = "phone";
    public static final String KEY_PING_CODE = "pincode";
    public static final String KEY_PKG_NAME = "packagename";
    public static final String KEY_POL = "pol";
    public static final String KEY_PORT = "port";
    public static final String KEY_PT = "pt";
    public static final String KEY_RAOP = "raop";
    public static final String KEY_REMOTE = "remote";
    public static final String KEY_REMOTEPORT = "remotePort";
    public static final String KEY_SDK_VERSION = "sdVer";
    public static final String KEY_SSDP_PACKET_DATA = "ssdp_packet_data";
    public static final String KEY_SSID = "ssid";
    public static final String KEY_TUNNELS = "tunnels";
    public static final String KEY_TYPE = "type";
    public static final String KEY_UID = "u";
    public static final String KEY_VER = "ver";
    public static final String KEY_VERSION = "version";
    public static final String KEY_VV = "vv";
    public static final String KEY_WIDTH = "w";
    public static final String KEY_WIFI_MAC = "bssid";
    private static final String TAG = "BrowserInfo";
    public static final int TYPE_DLNA = 3;
    public static final int TYPE_IM = 4;
    public static final int TYPE_LELINK = 1;
    private int createType;
    private Map<String, String> extras;
    private String ip;
    private boolean isLocalWifi;
    private boolean isOnLine;
    private String name;
    private int port;
    private int type;
    private String uid;
    public static final String KEY_M = Device.ELEM_NAME + FieldUtil.getString(FieldUtil.f7332m);
    public static final Parcelable.Creator<BrowserInfo> CREATOR = new Parcelable.Creator<BrowserInfo>() { // from class: com.hpplay.sdk.source.browse.data.BrowserInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BrowserInfo createFromParcel(Parcel parcel) {
            return new BrowserInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BrowserInfo[] newArray(int i10) {
            return new BrowserInfo[i10];
        }
    };

    public BrowserInfo() {
        this.isOnLine = false;
    }

    public void decode(int i10, JSONObject jSONObject) {
        if (jSONObject != null) {
            this.uid = jSONObject.optString("u");
            this.name = jSONObject.optString("name");
            this.ip = jSONObject.optString("ip");
            this.port = jSONObject.optInt("port");
            this.type = jSONObject.optInt("type");
            this.createType = i10;
            JSONObject optJSONObject = jSONObject.optJSONObject(KEY_EXTRA);
            if (optJSONObject == null || optJSONObject.length() <= 0) {
                return;
            }
            HashMap hashMap = new HashMap();
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, optJSONObject.optString(next));
            }
            this.extras = hashMap;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public JSONObject encode() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("u", this.uid);
            jSONObject.put("name", this.name);
            jSONObject.put("ip", this.ip);
            jSONObject.put("port", this.port);
            jSONObject.put("type", this.type);
            JSONObject jSONObject2 = new JSONObject();
            Map<String, String> map = this.extras;
            if (map != null && !map.isEmpty()) {
                for (String str : this.extras.keySet()) {
                    jSONObject2.put(str, this.extras.get(str));
                }
                jSONObject.put(KEY_EXTRA, jSONObject2);
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
        return jSONObject;
    }

    public int getConnectionType() {
        return 4 == this.type ? 1 : 0;
    }

    public int getCreateType() {
        return this.createType;
    }

    public Map<String, String> getExtras() {
        return this.extras;
    }

    public String getIp() {
        return this.ip;
    }

    public String getName() {
        return this.name;
    }

    public int getPort() {
        return this.port;
    }

    public int getType() {
        return this.type;
    }

    public String getUid() {
        return this.uid;
    }

    public boolean isLocalWifi() {
        return this.isLocalWifi;
    }

    @Deprecated
    public boolean isOnLine() {
        return this.isOnLine;
    }

    public void setExtras(Map<String, String> map) {
        this.extras = map;
    }

    public void setIp(String str) {
        this.ip = str;
    }

    public void setLocalWifi(boolean z10) {
        this.isLocalWifi = z10;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOnLine(boolean z10) {
        this.isOnLine = z10;
    }

    public void setPort(int i10) {
        this.port = i10;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public String toString() {
        return "BrowserInfo{uid='" + this.uid + "', name='" + this.name + "', ip='" + this.ip + "', type=" + this.type + ", createType=" + this.createType + ", port=" + this.port + ", isOnLine=" + this.isOnLine + ", isLocalWifi=" + this.isLocalWifi + ", extras=" + this.extras + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.uid);
        parcel.writeString(this.name);
        parcel.writeString(this.ip);
        parcel.writeInt(this.type);
        parcel.writeInt(this.port);
        parcel.writeInt(this.createType);
        parcel.writeByte(this.isOnLine ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.isLocalWifi ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.extras.size());
        for (Map.Entry<String, String> entry : this.extras.entrySet()) {
            parcel.writeString(entry.getKey());
            parcel.writeString(entry.getValue());
        }
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public BrowserInfo m49clone() {
        try {
            BrowserInfo browserInfo = new BrowserInfo();
            browserInfo.uid = this.uid;
            browserInfo.name = this.name;
            browserInfo.ip = this.ip;
            browserInfo.type = this.type;
            browserInfo.createType = this.createType;
            browserInfo.port = this.port;
            browserInfo.isOnLine = this.isOnLine;
            browserInfo.isLocalWifi = this.isLocalWifi;
            if (this.extras != null) {
                HashMap hashMap = new HashMap();
                for (String str : this.extras.keySet()) {
                    hashMap.put(str, this.extras.get(str));
                }
                browserInfo.extras = hashMap;
            }
            return browserInfo;
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            return null;
        }
    }

    public BrowserInfo(int i10, int i11) {
        this.isOnLine = false;
        this.type = i10;
        this.createType = i11;
    }

    public BrowserInfo(int i10, JSONObject jSONObject) {
        this.isOnLine = false;
        decode(i10, jSONObject);
    }

    public BrowserInfo(Parcel parcel) {
        this.isOnLine = false;
        this.uid = parcel.readString();
        this.name = parcel.readString();
        this.ip = parcel.readString();
        this.type = parcel.readInt();
        this.port = parcel.readInt();
        this.createType = parcel.readInt();
        this.isOnLine = parcel.readByte() != 0;
        this.isLocalWifi = parcel.readByte() != 0;
        int readInt = parcel.readInt();
        this.extras = new HashMap(readInt);
        for (int i10 = 0; i10 < readInt; i10++) {
            this.extras.put(parcel.readString(), parcel.readString());
        }
    }
}
