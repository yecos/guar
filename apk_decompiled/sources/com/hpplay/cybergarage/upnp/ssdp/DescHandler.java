package com.hpplay.cybergarage.upnp.ssdp;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.hpplay.component.common.utils.CLog;
import com.hpplay.component.modulelinker.api.ModuleLinker;
import com.hpplay.cybergarage.http.HTTP;
import com.hpplay.cybergarage.upnp.ControlPoint;
import com.hpplay.cybergarage.upnp.Device;
import com.hpplay.cybergarage.upnp.UPnP;
import com.hpplay.cybergarage.upnp.device.USN;
import com.hpplay.cybergarage.util.OnlineCheckUtil;
import com.hpplay.cybergarage.xml.Node;
import java.util.ArrayList;
import org.json.JSONArray;

/* loaded from: classes2.dex */
public class DescHandler implements Runnable {
    private static final String TAG = "DescRunnable";
    private ControlPoint mControlPoint;
    private SSDPPacket mSsdpPacket;

    public DescHandler(SSDPPacket sSDPPacket, ControlPoint controlPoint) {
        this.mSsdpPacket = sSDPPacket;
        this.mControlPoint = controlPoint;
    }

    private void saveToLocal(String str) {
        synchronized (this.mControlPoint) {
            SharedPreferences sharedPreferences = ModuleLinker.getInstance().getContext().getSharedPreferences(LocationCacheHandleTask.KEY_DLNA_LOCATION, 0);
            ArrayList arrayList = new ArrayList();
            String string = sharedPreferences.getString(LocationCacheHandleTask.KEY_DLNA_LOCATION, null);
            CLog.w(TAG, " LocationCacheHandleTasker : " + str.replace(".", ""));
            if (!TextUtils.isEmpty(string)) {
                JSONArray jSONArray = new JSONArray(string);
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    arrayList.add(jSONArray.optString(i10));
                }
            }
            if (!arrayList.contains(str)) {
                arrayList.add(str);
                while (arrayList.size() > 5) {
                    arrayList.remove(0);
                }
                JSONArray jSONArray2 = new JSONArray();
                for (int i11 = 0; i11 < arrayList.size(); i11++) {
                    jSONArray2.put(i11, arrayList.get(i11));
                }
                sharedPreferences.edit().putString(LocationCacheHandleTask.KEY_DLNA_LOCATION, jSONArray2.toString()).commit();
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        String udn = USN.getUDN(this.mSsdpPacket.getUSN());
        Device device = this.mControlPoint.getDevice(udn);
        if (device != null) {
            String location = device.getLocation();
            if (OnlineCheckUtil.tcpCheckTvState(HTTP.getHost(location), HTTP.getPort(location))) {
                device.setSSDPPacket(this.mSsdpPacket);
                this.mControlPoint.performAddDeviceListener(device);
                return;
            }
            this.mControlPoint.removeDevice(udn);
        }
        String location2 = this.mSsdpPacket.getLocation();
        try {
            CLog.w(TAG, " start  load desc" + location2.replace(".", "") + "\r\n   " + new String(this.mSsdpPacket.getData()));
            Node parseUrl = UPnP.getXMLParser().parseUrl(location2);
            Device device2 = this.mControlPoint.getDevice(parseUrl);
            if (device2 == null) {
                return;
            }
            device2.setSSDPPacket(this.mSsdpPacket);
            this.mControlPoint.addDevice(parseUrl);
            this.mControlPoint.performAddDeviceListener(device2);
            saveToLocal(location2);
        } catch (Exception e10) {
            CLog.i(TAG, "addDevice parse exception  \r\n" + e10.toString());
        }
    }
}
