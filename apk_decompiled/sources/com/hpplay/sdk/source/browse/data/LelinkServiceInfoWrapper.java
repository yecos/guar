package com.hpplay.sdk.source.browse.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.utils.Feature;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class LelinkServiceInfoWrapper implements Parcelable, Cloneable, Comparable<LelinkServiceInfoWrapper> {
    public static final Parcelable.Creator<LelinkServiceInfoWrapper> CREATOR = new Parcelable.Creator<LelinkServiceInfoWrapper>() { // from class: com.hpplay.sdk.source.browse.data.LelinkServiceInfoWrapper.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LelinkServiceInfoWrapper createFromParcel(Parcel parcel) {
            LelinkServiceInfoWrapper lelinkServiceInfoWrapper = new LelinkServiceInfoWrapper(parcel);
            try {
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                int readInt = parcel.readInt();
                for (int i10 = 0; i10 < readInt; i10++) {
                    int readInt2 = parcel.readInt();
                    concurrentHashMap.put(Integer.valueOf(readInt2), (BrowserInfo) parcel.readParcelable(BrowserInfo.class.getClassLoader()));
                }
                lelinkServiceInfoWrapper.mBrowserInfos = concurrentHashMap;
            } catch (Exception e10) {
                SourceLog.w(LelinkServiceInfoWrapper.TAG, e10);
            }
            return lelinkServiceInfoWrapper;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LelinkServiceInfoWrapper[] newArray(int i10) {
            return new LelinkServiceInfoWrapper[i10];
        }
    };
    private static final String IP_PREFIX_REGEX = "(?<!\\d)\\d{1,3}\\.\\d{1,3}(?=\\.\\d)";
    private static final String KEY_INFOS = "info";
    private static final String TAG = "LelinkServiceInfoWrapper";
    private String alias;
    private String ip;
    private boolean isConnect;
    private Map<Integer, BrowserInfo> mBrowserInfos;
    private String manufacturer;
    private String name;
    private String pinCode;
    private int port;
    private String uid;

    public LelinkServiceInfoWrapper() {
        this.mBrowserInfos = new ConcurrentHashMap();
    }

    public void decode(int i10, JSONObject jSONObject) {
        if (jSONObject != null) {
            this.name = jSONObject.optString("name");
            this.ip = jSONObject.optString("ip");
            this.uid = jSONObject.optString("u");
            JSONArray optJSONArray = jSONObject.optJSONArray(KEY_INFOS);
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i11 = 0; i11 < length; i11++) {
                    supplyIMBrowserInfo(i10, new BrowserInfo(i10, optJSONArray.optJSONObject(i11)));
                }
            }
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
            Map<Integer, BrowserInfo> map = this.mBrowserInfos;
            if (map != null && map.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                Iterator<Integer> it = this.mBrowserInfos.keySet().iterator();
                while (it.hasNext()) {
                    jSONArray.put(this.mBrowserInfos.get(it.next()).encode());
                }
                jSONObject.put(KEY_INFOS, jSONArray);
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
        return jSONObject;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        LelinkServiceInfo lelinkServiceInfo = (LelinkServiceInfo) obj;
        return (TextUtils.isEmpty(getUid()) || TextUtils.isEmpty(lelinkServiceInfo.getUid())) ? (TextUtils.isEmpty(getIp()) || TextUtils.isEmpty(lelinkServiceInfo.getIp())) ? super.equals(obj) : getIp().equalsIgnoreCase(lelinkServiceInfo.getIp()) && TextUtils.equals(getName(), lelinkServiceInfo.getName()) : getUid().equalsIgnoreCase(lelinkServiceInfo.getUid());
    }

    public int getAgentPort() {
        BrowserInfo browserInfo;
        Map<String, String> extras;
        try {
            Map<Integer, BrowserInfo> map = this.mBrowserInfos;
            if (map == null || map.isEmpty() || (browserInfo = this.mBrowserInfos.get(1)) == null || (extras = browserInfo.getExtras()) == null || extras.isEmpty()) {
                return 0;
            }
            String str = extras.get(BrowserInfo.KEY_AGENT_PORT);
            if (TextUtils.isEmpty(str) || !TextUtils.isDigitsOnly(str)) {
                return 0;
            }
            return Integer.parseInt(str);
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            return 0;
        }
    }

    public String getAlias() {
        return this.alias;
    }

    public int getAndroidRemotePort() {
        BrowserInfo browserInfo;
        try {
            Map<Integer, BrowserInfo> map = this.mBrowserInfos;
            if (map == null || map.size() <= 0 || (browserInfo = this.mBrowserInfos.get(1)) == null) {
                return 0;
            }
            String str = browserInfo.getExtras().get("port");
            if (TextUtils.isEmpty(str) || !TextUtils.isDigitsOnly(str)) {
                return 0;
            }
            return Integer.parseInt(str);
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            return 0;
        }
    }

    public int getAppId() {
        Map<Integer, BrowserInfo> map = this.mBrowserInfos;
        if (map == null || map.size() <= 0) {
            return 0;
        }
        try {
            BrowserInfo browserInfo = this.mBrowserInfos.get(1);
            if (browserInfo != null && browserInfo.getExtras() != null) {
                String str = browserInfo.getExtras().get("a");
                if (!TextUtils.isEmpty(str) && TextUtils.isDigitsOnly(str)) {
                    return Integer.parseInt(str);
                }
            }
            BrowserInfo browserInfo2 = this.mBrowserInfos.get(4);
            if (browserInfo2 == null || browserInfo2.getExtras() == null) {
                return 0;
            }
            String str2 = browserInfo2.getExtras().get("a");
            if (TextUtils.isEmpty(str2) || !TextUtils.isDigitsOnly(str2)) {
                return 0;
            }
            return Integer.parseInt(str2);
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            return 0;
        }
    }

    public Map<Integer, BrowserInfo> getBrowserInfos() {
        return this.mBrowserInfos;
    }

    public String getChannel() {
        BrowserInfo browserInfo;
        Map<String, String> extras;
        Map<Integer, BrowserInfo> map = this.mBrowserInfos;
        if (map == null || map.isEmpty() || (browserInfo = this.mBrowserInfos.get(1)) == null || (extras = browserInfo.getExtras()) == null || extras.isEmpty()) {
            return null;
        }
        return extras.get("channel");
    }

    public String getDLNAModeDes() {
        BrowserInfo browserInfo;
        Map<String, String> extras;
        Map<Integer, BrowserInfo> map = this.mBrowserInfos;
        if (map == null || map.size() == 0 || (browserInfo = this.mBrowserInfos.get(3)) == null || (extras = browserInfo.getExtras()) == null || extras.isEmpty()) {
            return null;
        }
        return extras.get("dlna_mode_desc");
    }

    public String getDLNAModeName() {
        BrowserInfo browserInfo;
        Map<String, String> extras;
        Map<Integer, BrowserInfo> map = this.mBrowserInfos;
        if (map == null || map.size() == 0 || (browserInfo = this.mBrowserInfos.get(3)) == null || (extras = browserInfo.getExtras()) == null || extras.isEmpty()) {
            return null;
        }
        return extras.get(BrowserInfo.KEY_DLNA_MODE_NAME);
    }

    public String getDeviceBrand() {
        BrowserInfo browserInfo;
        Map<String, String> extras;
        Map<Integer, BrowserInfo> map = this.mBrowserInfos;
        return (map == null || map.isEmpty() || (browserInfo = this.mBrowserInfos.get(1)) == null || (extras = browserInfo.getExtras()) == null || extras.isEmpty()) ? "unknown" : extras.get(BrowserInfo.KEY_DEVICE_BRAND);
    }

    public int getDrainage(int i10) {
        int parseInt;
        if (i10 < 0) {
            SourceLog.w(TAG, "getDrainage,value is invalid");
            return 0;
        }
        Map<Integer, BrowserInfo> map = this.mBrowserInfos;
        if (map != null && map.size() > 0) {
            Iterator<Map.Entry<Integer, BrowserInfo>> it = this.mBrowserInfos.entrySet().iterator();
            while (it.hasNext()) {
                BrowserInfo value = it.next().getValue();
                if (value != null && value.getExtras() != null && value.getExtras().get(BrowserInfo.KEY_DRAINAGE) != null) {
                    String str = value.getExtras().get(BrowserInfo.KEY_DRAINAGE);
                    if (!TextUtils.isEmpty(str) && TextUtils.isDigitsOnly(str.trim()) && (parseInt = Integer.parseInt(str.trim())) > 0) {
                        String sb = new StringBuilder(Integer.toBinaryString(parseInt)).reverse().toString();
                        if (!TextUtils.isEmpty(sb) && sb.length() > i10) {
                            return Integer.parseInt(sb.substring(i10, i10 + 1));
                        }
                    }
                }
            }
        }
        return 0;
    }

    public int getH() {
        Map<Integer, BrowserInfo> map = this.mBrowserInfos;
        if (map == null || map.size() <= 0) {
            return 0;
        }
        try {
            String str = this.mBrowserInfos.get(1).getExtras().get("h");
            if (TextUtils.isEmpty(str) || !TextUtils.isDigitsOnly(str)) {
                return 0;
            }
            return Integer.parseInt(str);
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            return 0;
        }
    }

    public String getIp() {
        return this.ip;
    }

    public String getManufacturer() {
        return !TextUtils.isEmpty(this.manufacturer) ? this.manufacturer : "unknow";
    }

    public String getName() {
        return this.name;
    }

    public String getPackageName() {
        BrowserInfo browserInfo;
        Map<String, String> extras;
        Map<Integer, BrowserInfo> map = this.mBrowserInfos;
        if (map == null || map.isEmpty() || (browserInfo = this.mBrowserInfos.get(1)) == null || (extras = browserInfo.getExtras()) == null || extras.isEmpty()) {
            return null;
        }
        return extras.get(BrowserInfo.KEY_PKG_NAME);
    }

    public Map<String, String> getParams() {
        BrowserInfo browserInfo;
        Map<Integer, BrowserInfo> map = this.mBrowserInfos;
        if (map == null || map.isEmpty() || (browserInfo = this.mBrowserInfos.get(1)) == null) {
            return null;
        }
        return browserInfo.getExtras();
    }

    public String getPinCode() {
        return this.pinCode;
    }

    public String getPlatform() {
        BrowserInfo browserInfo;
        Map<Integer, BrowserInfo> map = this.mBrowserInfos;
        return (map == null || map.size() <= 0 || (browserInfo = this.mBrowserInfos.get(4)) == null) ? "uk" : browserInfo.getExtras().get("pt");
    }

    public String getPol() {
        BrowserInfo browserInfo;
        Map<Integer, BrowserInfo> map = this.mBrowserInfos;
        return (map == null || map.size() <= 0 || (browserInfo = this.mBrowserInfos.get(4)) == null) ? "0" : browserInfo.getExtras().get(BrowserInfo.KEY_POL);
    }

    public int getPort() {
        return this.port;
    }

    public Integer[] getProtocols() {
        Map<Integer, BrowserInfo> map = this.mBrowserInfos;
        if (map == null || map.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<Integer, BrowserInfo>> it = this.mBrowserInfos.entrySet().iterator();
        while (it.hasNext()) {
            BrowserInfo value = it.next().getValue();
            if (value != null) {
                int type = value.getType();
                if (type == 1) {
                    arrayList.add(1);
                } else if (type == 3) {
                    arrayList.add(3);
                } else if (type == 4) {
                    arrayList.add(4);
                }
            }
        }
        return (Integer[]) arrayList.toArray(new Integer[3]);
    }

    public String getRcvPlf() {
        BrowserInfo browserInfo = this.mBrowserInfos.get(1);
        return browserInfo != null ? browserInfo.getExtras().get("pt") : "tv";
    }

    public int getRemotePort() {
        BrowserInfo browserInfo;
        try {
            Map<Integer, BrowserInfo> map = this.mBrowserInfos;
            if (map == null || map.size() <= 0 || (browserInfo = this.mBrowserInfos.get(1)) == null) {
                return 0;
            }
            String str = browserInfo.getExtras().get("remote");
            if (TextUtils.isEmpty(str) || !TextUtils.isDigitsOnly(str)) {
                return 0;
            }
            return Integer.parseInt(str);
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            return 0;
        }
    }

    public String getSSDPPacketData() {
        Map<Integer, BrowserInfo> map = this.mBrowserInfos;
        if (map == null || map.size() <= 0) {
            return null;
        }
        Iterator<Map.Entry<Integer, BrowserInfo>> it = this.mBrowserInfos.entrySet().iterator();
        while (it.hasNext()) {
            BrowserInfo value = it.next().getValue();
            if (value != null && value.getExtras() != null && value.getExtras().get(BrowserInfo.KEY_SSDP_PACKET_DATA) != null) {
                String str = value.getExtras().get(BrowserInfo.KEY_SSDP_PACKET_DATA);
                if (!TextUtils.isEmpty(str)) {
                    return str;
                }
            }
        }
        return null;
    }

    public String getTypes() {
        Map<Integer, BrowserInfo> map = this.mBrowserInfos;
        if (map == null || map.size() <= 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<Map.Entry<Integer, BrowserInfo>> it = this.mBrowserInfos.entrySet().iterator();
        while (it.hasNext()) {
            BrowserInfo value = it.next().getValue();
            if (value != null) {
                int type = value.getType();
                if (type == 1) {
                    sb.append("Lelink");
                } else if (type == 3) {
                    sb.append("DLNA");
                    sb.append("(");
                    sb.append(value.getExtras().get(BrowserInfo.KEY_MANUFACTURER));
                    sb.append(",");
                    sb.append(value.getExtras().get(BrowserInfo.KEY_DLNA_MODE_NAME));
                    sb.append(")");
                } else if (type == 4) {
                    sb.append("IM");
                }
            }
            if (it.hasNext()) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public String getUdnUuid() {
        BrowserInfo browserInfo;
        Map<String, String> extras;
        Map<Integer, BrowserInfo> map = this.mBrowserInfos;
        if (map == null || map.size() == 0 || (browserInfo = this.mBrowserInfos.get(3)) == null || (extras = browserInfo.getExtras()) == null || extras.isEmpty()) {
            return null;
        }
        return extras.get(BrowserInfo.KEY_DLNA_UDN_UUID);
    }

    public String getUid() {
        return this.uid;
    }

    public int getW() {
        try {
            Map<Integer, BrowserInfo> map = this.mBrowserInfos;
            if (map == null || map.size() <= 0) {
                return 0;
            }
            String str = this.mBrowserInfos.get(1).getExtras().get(BrowserInfo.KEY_WIDTH);
            if (TextUtils.isEmpty(str) || !TextUtils.isDigitsOnly(str)) {
                return 0;
            }
            return Integer.parseInt(str);
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            return 0;
        }
    }

    public boolean hasNewVersion() {
        BrowserInfo browserInfo;
        Map<Integer, BrowserInfo> map = this.mBrowserInfos;
        if (map != null && !map.isEmpty() && (browserInfo = this.mBrowserInfos.get(1)) != null) {
            String str = browserInfo.getExtras().get(BrowserInfo.KEY_APP_INFO);
            if (TextUtils.isEmpty(str) || "1".equalsIgnoreCase(str.split(",")[0])) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }

    @Deprecated
    public boolean isConnect() {
        return this.isConnect;
    }

    public boolean isDangle(BrowserInfo browserInfo) {
        try {
            String str = browserInfo.getExtras().get("channel");
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.contains("dongle");
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            return false;
        }
    }

    public boolean isLocalWifi() {
        Map<Integer, BrowserInfo> map = this.mBrowserInfos;
        if (map == null || map.size() <= 0) {
            return false;
        }
        BrowserInfo browserInfo = this.mBrowserInfos.get(1);
        if (browserInfo != null && browserInfo.isLocalWifi()) {
            return true;
        }
        BrowserInfo browserInfo2 = this.mBrowserInfos.get(3);
        return browserInfo2 != null && browserInfo2.isLocalWifi();
    }

    @Deprecated
    public boolean isOnLine() {
        Map<Integer, BrowserInfo> map = this.mBrowserInfos;
        if (map == null) {
            return false;
        }
        Iterator<Integer> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (this.mBrowserInfos.get(it.next()).isOnLine()) {
                return true;
            }
        }
        return false;
    }

    public boolean isSupportPassthrough() {
        if (TextUtils.isEmpty(this.uid)) {
            return false;
        }
        try {
            Map<Integer, BrowserInfo> map = this.mBrowserInfos;
            if (map != null && map.size() > 0) {
                if (this.mBrowserInfos.size() == 1 && this.mBrowserInfos.get(4) != null) {
                    return true;
                }
                Iterator<Map.Entry<Integer, BrowserInfo>> it = this.mBrowserInfos.entrySet().iterator();
                while (it.hasNext()) {
                    BrowserInfo value = it.next().getValue();
                    if (value != null) {
                        Map<String, String> extras = value.getExtras();
                        String str = extras != null ? extras.get("vv") : null;
                        if ((!TextUtils.isEmpty(str) && TextUtils.equals(str, "2")) || value.getType() == 4) {
                            return true;
                        }
                    }
                }
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
        return false;
    }

    public void setAlias(String str) {
        this.alias = str;
    }

    @Deprecated
    public void setConnect(boolean z10) {
        this.isConnect = z10;
    }

    public void setIp(String str) {
        this.ip = str;
    }

    public void setManufacturer(String str) {
        this.manufacturer = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPinCode(String str) {
        this.pinCode = str;
    }

    public void setPort(int i10) {
        this.port = i10;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void supplyIMBrowserInfo(int i10, BrowserInfo browserInfo) {
        if (TextUtils.isEmpty(this.uid) && !TextUtils.isEmpty(browserInfo.getUid())) {
            this.uid = browserInfo.getUid();
        }
        this.name = browserInfo.getName();
        this.ip = browserInfo.getIp();
        this.mBrowserInfos.put(Integer.valueOf(browserInfo.getType()), browserInfo);
        if (Feature.isDisableIM() || TextUtils.isEmpty(this.uid) || browserInfo.getType() != 1) {
            return;
        }
        BrowserInfo browserInfo2 = this.mBrowserInfos.get(4);
        if (browserInfo2 != null) {
            browserInfo2.setName(browserInfo.getName());
            browserInfo2.setIp(browserInfo.getIp());
            Map<String, String> extras = browserInfo2.getExtras();
            if (extras == null) {
                extras = new HashMap<>();
            }
            if (TextUtils.isEmpty(extras.get("u"))) {
                extras.put("u", String.valueOf(browserInfo.getUid()));
            }
            if (TextUtils.isEmpty(extras.get("a")) && browserInfo.getExtras() != null) {
                extras.put("a", browserInfo.getExtras().get("a"));
            }
            browserInfo2.setExtras(extras);
            return;
        }
        BrowserInfo browserInfo3 = new BrowserInfo(4, i10);
        browserInfo3.setUid(browserInfo.getUid());
        browserInfo3.setIp(browserInfo.getIp());
        browserInfo3.setName(browserInfo.getName());
        HashMap hashMap = new HashMap();
        hashMap.put("u", String.valueOf(browserInfo.getUid()));
        if (browserInfo.getExtras() != null) {
            hashMap.put("a", browserInfo.getExtras().get("a"));
            hashMap.put(BrowserInfo.KEY_TUNNELS, browserInfo.getExtras().get(BrowserInfo.KEY_TUNNELS));
            hashMap.put(BrowserInfo.KEY_DRAINAGE, browserInfo.getExtras().get(BrowserInfo.KEY_DRAINAGE));
        }
        browserInfo3.setExtras(hashMap);
        this.mBrowserInfos.put(4, browserInfo3);
    }

    public String toString() {
        return "LelinkServiceInfo{, name='" + this.name + "', ip='" + this.ip + "', uid='" + this.uid + "', mBrowserInfos=" + this.mBrowserInfos + ", alias=" + this.alias + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
    }

    public void updateByBrowseInfo(BrowserInfo browserInfo) {
        if (this.mBrowserInfos == null) {
            this.mBrowserInfos = new ConcurrentHashMap();
        }
        BrowserInfo browserInfo2 = this.mBrowserInfos.get(Integer.valueOf(browserInfo.getType()));
        if (browserInfo2 == null) {
            this.mBrowserInfos.put(Integer.valueOf(browserInfo.getType()), browserInfo);
            return;
        }
        supplyIMBrowserInfo(browserInfo2.getType(), browserInfo2);
        browserInfo2.setLocalWifi(browserInfo.isLocalWifi());
        browserInfo2.setOnLine(browserInfo.isOnLine());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.name);
        parcel.writeString(this.alias);
        parcel.writeString(this.ip);
        parcel.writeInt(this.port);
        parcel.writeString(this.uid);
        parcel.writeByte(this.isConnect ? (byte) 1 : (byte) 0);
        parcel.writeString(this.pinCode);
        parcel.writeString(this.manufacturer);
        Map<Integer, BrowserInfo> map = this.mBrowserInfos;
        if (map != null) {
            int size = map.size();
            parcel.writeInt(size);
            if (size > 0) {
                for (Map.Entry<Integer, BrowserInfo> entry : this.mBrowserInfos.entrySet()) {
                    parcel.writeInt(entry.getKey().intValue());
                    parcel.writeParcelable(entry.getValue(), i10);
                }
            }
        }
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public LelinkServiceInfoWrapper m50clone() {
        try {
            LelinkServiceInfoWrapper lelinkServiceInfoWrapper = new LelinkServiceInfoWrapper();
            lelinkServiceInfoWrapper.name = this.name;
            lelinkServiceInfoWrapper.alias = this.alias;
            lelinkServiceInfoWrapper.ip = this.ip;
            lelinkServiceInfoWrapper.port = this.port;
            lelinkServiceInfoWrapper.uid = this.uid;
            lelinkServiceInfoWrapper.isConnect = this.isConnect;
            lelinkServiceInfoWrapper.pinCode = this.pinCode;
            lelinkServiceInfoWrapper.manufacturer = this.manufacturer;
            if (this.mBrowserInfos != null) {
                HashMap hashMap = new HashMap();
                for (Integer num : this.mBrowserInfos.keySet()) {
                    hashMap.put(num, this.mBrowserInfos.get(num).m49clone());
                }
                lelinkServiceInfoWrapper.mBrowserInfos = hashMap;
            }
            return lelinkServiceInfoWrapper;
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            return null;
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(LelinkServiceInfoWrapper lelinkServiceInfoWrapper) {
        if (this == lelinkServiceInfoWrapper) {
            return 0;
        }
        if (!TextUtils.isEmpty(this.uid) && !TextUtils.isEmpty(lelinkServiceInfoWrapper.uid)) {
            return 0;
        }
        if (TextUtils.isEmpty(this.uid) && TextUtils.isEmpty(lelinkServiceInfoWrapper.uid)) {
            return 0;
        }
        return !TextUtils.isEmpty(this.uid) ? -1 : 1;
    }

    public LelinkServiceInfoWrapper(int i10, BrowserInfo browserInfo) {
        this.uid = browserInfo.getUid();
        this.name = browserInfo.getName();
        this.ip = browserInfo.getIp();
        this.port = browserInfo.getPort();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.mBrowserInfos = concurrentHashMap;
        concurrentHashMap.put(Integer.valueOf(browserInfo.getType()), browserInfo);
        supplyIMBrowserInfo(i10, browserInfo);
    }

    public LelinkServiceInfoWrapper(String str, String str2) {
        this.uid = str;
        this.name = str2;
        this.mBrowserInfos = new ConcurrentHashMap();
        BrowserInfo browserInfo = new BrowserInfo(4, 4);
        browserInfo.setUid(str);
        browserInfo.setName(str2);
        HashMap hashMap = new HashMap();
        hashMap.put("u", str);
        browserInfo.setExtras(hashMap);
        this.mBrowserInfos.put(4, browserInfo);
    }

    public LelinkServiceInfoWrapper(String str, int i10) {
        this.ip = str;
        this.port = i10;
        this.mBrowserInfos = new ConcurrentHashMap();
        BrowserInfo browserInfo = new BrowserInfo(1, 8);
        browserInfo.setIp(str);
        browserInfo.setName(this.name);
        HashMap hashMap = new HashMap();
        hashMap.put("ip", str);
        String valueOf = String.valueOf(i10);
        hashMap.put("lelinkport", valueOf);
        hashMap.put("airplay", valueOf);
        hashMap.put("raop", valueOf);
        hashMap.put("vv", "2");
        browserInfo.setExtras(hashMap);
        this.mBrowserInfos.put(1, browserInfo);
    }

    public LelinkServiceInfoWrapper(Parcel parcel) {
        this.name = parcel.readString();
        this.alias = parcel.readString();
        this.ip = parcel.readString();
        this.port = parcel.readInt();
        this.uid = parcel.readString();
        this.isConnect = parcel.readByte() != 0;
        this.pinCode = parcel.readString();
        this.manufacturer = parcel.readString();
    }
}
