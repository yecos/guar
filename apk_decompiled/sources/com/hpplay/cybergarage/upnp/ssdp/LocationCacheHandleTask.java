package com.hpplay.cybergarage.upnp.ssdp;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.hpplay.a.a.a.d;
import com.hpplay.component.common.utils.CLog;
import com.hpplay.component.modulelinker.api.ModuleLinker;
import com.hpplay.cybergarage.http.HTTP;
import com.hpplay.cybergarage.upnp.ControlPoint;
import com.hpplay.cybergarage.upnp.Device;
import com.hpplay.cybergarage.upnp.UPnP;
import com.hpplay.cybergarage.util.OnlineCheckUtil;
import com.hpplay.cybergarage.xml.Node;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* loaded from: classes2.dex */
public class LocationCacheHandleTask extends Thread {
    public static final String KEY_DLNA_LOCATION = "key_dlna_location";
    private static final String TAG = "LocationCacheHandleTasker";
    private ControlPoint mControlPoint;
    private List<String> mLocationList = new ArrayList();
    private SharedPreferences mPreferences;

    public LocationCacheHandleTask(ControlPoint controlPoint) {
        this.mControlPoint = controlPoint;
        try {
            SharedPreferences sharedPreferences = ModuleLinker.getInstance().getContext().getSharedPreferences(KEY_DLNA_LOCATION, 0);
            this.mPreferences = sharedPreferences;
            String string = sharedPreferences.getString(KEY_DLNA_LOCATION, null);
            if (TextUtils.isEmpty(string)) {
                return;
            }
            JSONArray jSONArray = new JSONArray(string);
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                this.mLocationList.add(jSONArray.optString(i10));
            }
            CLog.w(TAG, " LocationCacheHandleTasker : " + string.replace(".", Operator.Operation.MINUS));
        } catch (Exception e10) {
            CLog.w(TAG, e10);
        }
    }

    private void deleteToLocal(String str) {
        try {
            ArrayList arrayList = new ArrayList();
            String string = this.mPreferences.getString(KEY_DLNA_LOCATION, null);
            if (!TextUtils.isEmpty(string)) {
                CLog.w(TAG, " LocationCacheHandleTasker deleteToLocal : " + str.replace(".", ""));
                JSONArray jSONArray = new JSONArray(string);
                for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                    arrayList.add(jSONArray.optString(i10));
                }
            }
            if (!arrayList.remove(str) || this.mPreferences == null) {
                return;
            }
            JSONArray jSONArray2 = new JSONArray();
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                jSONArray2.put(i11, arrayList.get(i11));
            }
            this.mPreferences.edit().putString(KEY_DLNA_LOCATION, jSONArray2.toString()).apply();
        } catch (Exception e10) {
            CLog.w(TAG, e10);
        }
    }

    public void release() {
        this.mControlPoint = null;
        interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        super.run();
        CLog.w(TAG, " LocationCacheHandleTasker start");
        try {
            ArrayList arrayList = new ArrayList();
            int i10 = 0;
            while (i10 < this.mLocationList.size()) {
                String str = this.mLocationList.get(i10);
                try {
                    if (OnlineCheckUtil.tcpCheckTvState(HTTP.getHost(str), HTTP.getPort(str))) {
                        CLog.w(TAG, " start  load desc" + str.replace(".", Operator.Operation.MINUS));
                        Node parse = UPnP.getXMLParser().parse(str, d.SOCKET_READ_TIMEOUT);
                        if (this.mControlPoint == null || isInterrupted()) {
                            break;
                        }
                        Device device = this.mControlPoint.getDevice(parse);
                        if (device == null) {
                            arrayList.add(this.mLocationList.remove(i10));
                        } else {
                            device.setLocation(str);
                            CLog.w(TAG, " LocationCacheHandleTasker load new dev");
                            this.mControlPoint.addDevice(parse);
                            this.mControlPoint.performAddDeviceListener(device);
                            i10++;
                        }
                    } else {
                        arrayList.add(this.mLocationList.remove(i10));
                    }
                    i10--;
                    i10++;
                } catch (Exception e10) {
                    CLog.i(TAG, "LocationCacheHandleTasker addDevice parse exception  \r\n" + e10.toString());
                }
            }
        } catch (Exception e11) {
            CLog.w(TAG, e11);
        }
        CLog.i(TAG, "  LocationCacheHandleTasker exit");
    }
}
