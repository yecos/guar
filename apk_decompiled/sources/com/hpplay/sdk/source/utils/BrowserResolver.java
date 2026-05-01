package com.hpplay.sdk.source.utils;

import android.text.TextUtils;
import com.hpplay.common.utils.FieldUtil;
import com.hpplay.component.adjuster.DeviceAdjuster;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.sdk.source.bean.ServiceInfoParseBean;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.hpplay.sdk.source.common.store.Session;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.process.LelinkSdkManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class BrowserResolver {
    private static final String IP_REGEX = "([0-9]{1,3}[\\.]){3}[0-9]{1,3}:[0-9]*";
    private static final String TAG = "BrowserResolver";

    private static boolean isSameServiceInfo(LelinkServiceInfo lelinkServiceInfo, LelinkServiceInfo lelinkServiceInfo2) {
        if (lelinkServiceInfo == null || lelinkServiceInfo2 == null) {
            return false;
        }
        return lelinkServiceInfo.equals(lelinkServiceInfo2);
    }

    public static BrowserInfo resolveDevice(JSONObject jSONObject) {
        String optString = jSONObject.optString(DeviceAdjuster.KEY_DEVICE_NAME);
        String optString2 = jSONObject.optString("u");
        String optString3 = jSONObject.optString(DeviceAdjuster.KEY_DEVICE_IP);
        int optInt = jSONObject.optInt("port");
        String optString4 = jSONObject.optString("dlna_mode_desc");
        BrowserInfo browserInfo = new BrowserInfo(3, 1);
        browserInfo.setName(optString);
        browserInfo.setIp(optString3);
        browserInfo.setPort(optInt);
        browserInfo.setUid(optString2);
        browserInfo.setOnLine(true);
        browserInfo.setLocalWifi(true);
        HashMap hashMap = new HashMap();
        hashMap.put(BrowserInfo.KEY_DLNA_LOCATION, optString4);
        hashMap.put(BrowserInfo.KEY_MANUFACTURER, jSONObject.optString("dlna_manufacturer"));
        hashMap.put(BrowserInfo.KEY_DLNA_MODE_NAME, jSONObject.optString("dlna_model_name"));
        hashMap.put("dlna_mode_desc", jSONObject.optString("dlna_mode_desc"));
        hashMap.put(BrowserInfo.KEY_DLNA_UUID, jSONObject.optString("dlna_model_uuid"));
        hashMap.put(BrowserInfo.KEY_DLNA_UDN_UUID, jSONObject.optString("udn_uuid"));
        hashMap.put(BrowserInfo.KEY_DRAINAGE, jSONObject.optString(BrowserInfo.KEY_DRAINAGE));
        hashMap.put(BrowserInfo.KEY_SSDP_PACKET_DATA, jSONObject.optString(BrowserInfo.KEY_SSDP_PACKET_DATA));
        browserInfo.setExtras(hashMap);
        return browserInfo;
    }

    public static BrowserInfo resolveLelinkInfo(JSONObject jSONObject) {
        String optString = jSONObject.optString("vv");
        SourceLog.i(TAG, "resolveServiceInfo vv:" + optString + " isFilterNewLelinkV1:");
        boolean z10 = false;
        if (!TextUtils.isEmpty(optString) && !optString.equalsIgnoreCase("0") && !optString.equalsIgnoreCase("1")) {
            z10 = true;
        }
        BrowserInfo browserInfo = new BrowserInfo(1, 1);
        browserInfo.setName(jSONObject.optString(DeviceAdjuster.KEY_DEVICE_NAME));
        browserInfo.setIp(jSONObject.optString(DeviceAdjuster.KEY_DEVICE_IP));
        browserInfo.setOnLine(true);
        browserInfo.setLocalWifi(true);
        String optString2 = jSONObject.optString("u");
        if (!TextUtils.isEmpty(optString2)) {
            browserInfo.setUid(optString2);
        }
        String optString3 = jSONObject.optString("lelinkport");
        if (!TextUtils.isEmpty(optString3)) {
            try {
                browserInfo.setPort(Integer.parseInt(optString3));
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
            }
        }
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        StringBuilder sb = new StringBuilder();
        sb.append(jSONObject.optString(DeviceAdjuster.KEY_DEVICE_NAME));
        sb.append("  -- ");
        while (keys.hasNext()) {
            String next = keys.next();
            if (z10 || !next.equalsIgnoreCase("vv")) {
                String optString4 = jSONObject.optString(next);
                hashMap.put(next, optString4);
                if (next.equals(BrowserInfo.KEY_PKG_NAME)) {
                    hashMap.put(BrowserInfo.KEY_DEVICE_BRAND, Session.getInstance().getBrand(optString4));
                }
                sb.append(next);
                sb.append("  ");
                sb.append(optString4);
                sb.append(" ");
            } else {
                SourceLog.i(TAG, "filter new lelink field vv");
            }
        }
        SourceLog.debug(TAG, "resolveServiceInfo" + sb.toString());
        browserInfo.setExtras(hashMap);
        return browserInfo;
    }

    private static synchronized void sort(List<LelinkServiceInfo> list) {
        synchronized (BrowserResolver.class) {
            try {
                List asList = Arrays.asList(list.toArray(new LelinkServiceInfo[0]));
                Collections.sort(asList);
                list.clear();
                list.addAll(asList);
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
            }
        }
    }

    public static void updateParseServiceList(List<ServiceInfoParseBean> list) {
        if (list == null) {
            return;
        }
        Iterator<ServiceInfoParseBean> it = list.iterator();
        while (it.hasNext()) {
            updateServiceList(it.next().info);
        }
    }

    private static boolean updateServiceInfo(LelinkServiceInfo lelinkServiceInfo, LelinkServiceInfo lelinkServiceInfo2) {
        Map<Integer, BrowserInfo> browserInfos;
        Iterator<BrowserInfo> it;
        try {
            browserInfos = lelinkServiceInfo.getBrowserInfos();
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
        if (browserInfos == null || (it = browserInfos.values().iterator()) == null) {
            return false;
        }
        while (it.hasNext()) {
            lelinkServiceInfo2.updateByBrowseInfo(it.next());
        }
        if (TextUtils.equals(lelinkServiceInfo.getName(), lelinkServiceInfo2.getName()) && TextUtils.equals(lelinkServiceInfo.getUid(), lelinkServiceInfo2.getUid()) && TextUtils.equals(lelinkServiceInfo.getTypes(), lelinkServiceInfo2.getTypes()) && TextUtils.equals(lelinkServiceInfo.getIp(), lelinkServiceInfo2.getIp())) {
            return lelinkServiceInfo.getPort() != lelinkServiceInfo2.getPort();
        }
        return true;
    }

    public static void updateServiceList(List<LelinkServiceInfo> list) {
        try {
            Iterator<LelinkServiceInfo> it = list.iterator();
            while (it.hasNext()) {
                updateServiceList(it.next());
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            LelinkSdkManager.getInstance().notifyBrowserListIfNeeded(true);
        }
    }

    public static LelinkServiceInfo updateServiceList(LelinkServiceInfo lelinkServiceInfo) {
        if (lelinkServiceInfo == null) {
            return null;
        }
        List<LelinkServiceInfo> browserList = LelinkSdkManager.getInstance().getBrowserList();
        if (browserList == null) {
            browserList = new ArrayList<>();
        }
        try {
            for (LelinkServiceInfo lelinkServiceInfo2 : browserList) {
                if (isSameServiceInfo(lelinkServiceInfo, lelinkServiceInfo2)) {
                    LelinkSdkManager.getInstance().notifyBrowserListIfNeeded(updateServiceInfo(lelinkServiceInfo, lelinkServiceInfo2));
                    return lelinkServiceInfo2;
                }
            }
            browserList.add(lelinkServiceInfo);
            sort(browserList);
            LelinkSdkManager.getInstance().notifyBrowserListIfNeeded(true);
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
        return lelinkServiceInfo;
    }

    public static BrowserInfo resolveLelinkInfo(String str) {
        JSONObject jSONObject = new JSONObject(str);
        SourceLog.i(TAG, "resolveServiceInfo vv:" + jSONObject.optString("vv") + " isFilterNewLelinkV1:");
        BrowserInfo browserInfo = new BrowserInfo(1, 1);
        browserInfo.setIp(jSONObject.getString("ip"));
        browserInfo.setOnLine(true);
        browserInfo.setLocalWifi(true);
        String optString = jSONObject.optString(ParamsMap.DeviceParams.KEY_UID);
        if (!TextUtils.isEmpty(optString)) {
            browserInfo.setUid(optString);
        }
        String optString2 = jSONObject.optString(ParamsMap.DeviceParams.KEY_LELINK_PORT);
        if (!TextUtils.isEmpty(optString2)) {
            try {
                browserInfo.setPort(Integer.parseInt(optString2));
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
            }
        }
        HashMap hashMap = new HashMap();
        hashMap.put("mirror", jSONObject.optString(ParamsMap.DeviceParams.KEY_MIRROR_PORT));
        hashMap.put("airplay", jSONObject.optString(ParamsMap.DeviceParams.KEY_AIRPLAY_PORT));
        hashMap.put("channel", jSONObject.optString(ParamsMap.DeviceParams.KEY_CHANNEL_VERSION));
        hashMap.put("remote", jSONObject.optString("remote"));
        hashMap.put("port", jSONObject.optString("port"));
        hashMap.put("lelinkport", jSONObject.optString(ParamsMap.DeviceParams.KEY_LELINK_PORT));
        hashMap.put("raop", jSONObject.optString(ParamsMap.DeviceParams.KEY_RAOP_PORT));
        hashMap.put(BrowserInfo.KEY_M, jSONObject.optString(FieldUtil.getString(FieldUtil.f7332m)));
        hashMap.put("vv", jSONObject.optString("vv"));
        browserInfo.setExtras(hashMap);
        return browserInfo;
    }
}
