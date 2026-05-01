package com.umeng.ccg;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.umeng.analytics.pro.aq;
import com.umeng.analytics.pro.av;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.MLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.android.agoo.common.AgooConstants;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class CcgAgent {
    private static Object lock = new Object();
    private static Object configUpdateLock = new Object();
    private static ArrayList<ConfigListener> callbacks = new ArrayList<>();
    private static ArrayList<ConfigUpdateListener> updateCallbacks = new ArrayList<>();
    private static Object actionInfoLock = new Object();
    private static Map<String, ActionInfo> actionInfoTable = new HashMap();
    private static Map<String, ArrayList<String>> forbidSdkTable = new HashMap();
    private static volatile int actUpFlag = 0;
    private static volatile long actUpTs = 0;

    static {
        forbidSdkTable.put(a.f10645e, new ArrayList<>());
        forbidSdkTable.put(a.f10644d, new ArrayList<>());
        forbidSdkTable.put(a.f10642b, new ArrayList<>());
        forbidSdkTable.put(a.f10643c, new ArrayList<>());
    }

    public static int getActUpFlag() {
        return actUpFlag;
    }

    public static Map<String, String> getActUpInfo() {
        HashMap hashMap = new HashMap();
        hashMap.put(AgooConstants.MESSAGE_FLAG, String.valueOf(actUpFlag));
        hashMap.put("ts", String.valueOf(actUpTs));
        return hashMap;
    }

    public static ActionInfo getActionInfo(String str) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (actionInfoLock) {
                r1 = actionInfoTable.containsKey(str) ? actionInfoTable.get(str) : null;
            }
        }
        return r1;
    }

    public static String[] getCollectItemList() {
        return new String[]{a.f10645e, a.f10644d, a.f10642b, a.f10643c};
    }

    public static void getConfigInfo(ConfigResult configResult) {
        if (configResult != null) {
            configResult.onConfigInfo(d.a().b(UMGlobalContext.getAppContext()));
        }
    }

    public static ArrayList<String> getForbidSdkArray(String str) {
        if (forbidSdkTable.containsKey(str)) {
            return forbidSdkTable.get(str);
        }
        return null;
    }

    public static ArrayList<String> getRegistedModuleList() {
        ArrayList<String> arrayList;
        synchronized (actionInfoLock) {
            arrayList = new ArrayList<>(actionInfoTable.keySet());
        }
        return arrayList;
    }

    public static boolean hasRegistedActionInfo() {
        boolean z10;
        synchronized (actionInfoLock) {
            z10 = actionInfoTable.size() > 0;
        }
        return z10;
    }

    public static void init(Context context) {
        d.a().a(context);
    }

    public static void notifyConfigChanged(JSONObject jSONObject) {
        synchronized (configUpdateLock) {
            int size = updateCallbacks.size();
            if (size > 0) {
                for (int i10 = 0; i10 < size; i10++) {
                    updateCallbacks.get(i10).onConfigUpdate(jSONObject);
                }
            }
        }
    }

    public static void notifyConfigReady(JSONObject jSONObject) {
        synchronized (lock) {
            int size = callbacks.size();
            if (size > 0) {
                for (int i10 = 0; i10 < size; i10++) {
                    callbacks.get(i10).onConfigReady(jSONObject);
                }
            }
        }
    }

    public static void onActUpEvent(String str, String str2, Bundle bundle) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "onActUpEvent: type or token agument is empty string, pls check!");
            MLog.e("onActUpEvent: type、token参数不能为null或者空字符串！");
            return;
        }
        String str3 = "";
        if (bundle != null) {
            try {
                str3 = bundle.getString("ss");
            } catch (Throwable unused) {
                return;
            }
        }
        String str4 = str3;
        actUpFlag = 1;
        actUpTs = System.currentTimeMillis();
        UMRTLog.i(UMRTLog.RTLOG_TAG, " set act up flag.");
        JSONObject a10 = d.a().a(str, str2, str4, actUpTs, System.currentTimeMillis() - UMConfigure.getInitCompleteTs() <= 3000);
        if (a10 != null) {
            av.a(new aq(aq.f9893b, a10), 0L, TimeUnit.SECONDS);
            Thread.sleep(2000L);
        }
    }

    public static void registerActionInfo(ActionInfo actionInfo) {
        Context appContext = UMGlobalContext.getAppContext();
        if (actionInfo != null) {
            synchronized (actionInfoLock) {
                try {
                    String module = actionInfo.getModule(UMGlobalContext.getAppContext());
                    if (!TextUtils.isEmpty(module) && !actionInfoTable.containsKey(module)) {
                        String[] supportAction = actionInfo.getSupportAction(appContext);
                        if (supportAction != null) {
                            for (String str : supportAction) {
                                boolean switchState = actionInfo.getSwitchState(appContext, str);
                                if (forbidSdkTable.containsKey(str)) {
                                    ArrayList<String> arrayList = forbidSdkTable.get(str);
                                    if (!switchState) {
                                        arrayList.add(module);
                                    }
                                }
                            }
                        }
                        actionInfoTable.put(module, actionInfo);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static void registerConfigListener(ConfigListener configListener) {
        if (configListener != null) {
            synchronized (lock) {
                callbacks.add(configListener);
            }
        }
    }

    public static void registerConfigUpdateListener(ConfigUpdateListener configUpdateListener) {
        if (configUpdateListener != null) {
            synchronized (configUpdateLock) {
                updateCallbacks.add(configUpdateListener);
            }
        }
    }
}
