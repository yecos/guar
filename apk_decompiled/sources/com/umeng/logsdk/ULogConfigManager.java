package com.umeng.logsdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.observer.IConfigCallback;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ULogConfigManager {

    /* renamed from: b, reason: collision with root package name */
    private Context f11296b;

    /* renamed from: c, reason: collision with root package name */
    private EfsReporter f11297c;

    /* renamed from: a, reason: collision with root package name */
    private final String f11295a = "ULogConfigManager";

    /* renamed from: d, reason: collision with root package name */
    private Vector<b> f11298d = new Vector<>();

    public ULogConfigManager(Context context, EfsReporter efsReporter) {
        this.f11296b = context.getApplicationContext();
        this.f11297c = efsReporter;
        if (efsReporter != null) {
            Log.i("ULogConfigManager", "[log register] begin.");
            this.f11297c.getAllSdkConfig(new String[]{a.f11322d, a.f11321c, a.f11325g}, new IConfigCallback() { // from class: com.umeng.logsdk.ULogConfigManager.1
                @Override // com.efs.sdk.base.observer.IConfigCallback
                public final void onChange(Map<String, Object> map) {
                    SharedPreferences.Editor edit;
                    String str;
                    String str2;
                    StringBuilder sb;
                    if (map != null) {
                        try {
                            Log.i("ULogConfigManager", "[log register] call back config.");
                            SharedPreferences sharedPreferences = ULogConfigManager.this.f11296b.getSharedPreferences("efs_ulog", 0);
                            if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
                                return;
                            }
                            Object obj = map.get(a.f11322d);
                            String str3 = "";
                            if (obj != null) {
                                str = obj.toString();
                                edit.putString(a.f11322d, str);
                                Log.i("ULogConfigManager", "[log register] save did is ".concat(String.valueOf(str)));
                            } else {
                                str = "";
                            }
                            Object obj2 = map.get(a.f11321c);
                            if (obj2 != null) {
                                String obj3 = obj2.toString();
                                Log.i("ULogConfigManager", "[log register] save uid before base64 is ".concat(String.valueOf(obj3)));
                                str2 = c.a(obj3.getBytes());
                                edit.putString(a.f11321c, str2);
                                Log.i("ULogConfigManager", "[log register] save uid after base64 is ".concat(String.valueOf(str2)));
                            } else {
                                str2 = "";
                            }
                            Object obj4 = map.get(a.f11325g);
                            if (obj4 != null && str2.equals(ULogManager.getUserID()) && str.equals(ULogManager.getDeviceID())) {
                                String obj5 = obj4.toString();
                                if (!TextUtils.isEmpty(obj5)) {
                                    JSONArray jSONArray = new JSONArray(obj5);
                                    for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                                        JSONObject jSONObject = jSONArray.getJSONObject(i10);
                                        if (jSONObject != null) {
                                            String optString = jSONObject.optString(a.f11326h, a.f11334p);
                                            if (!TextUtils.isEmpty(optString)) {
                                                if (TextUtils.isEmpty(str3)) {
                                                    sb = new StringBuilder();
                                                    sb.append(str3);
                                                    sb.append(optString);
                                                } else {
                                                    sb = new StringBuilder();
                                                    sb.append(str3);
                                                    sb.append("_");
                                                    sb.append(optString);
                                                }
                                                str3 = sb.toString();
                                                edit.putString(optString, jSONObject.toString());
                                                Log.i("ULogConfigManager", "[log register] save task id is " + optString + ", task is " + jSONObject.toString());
                                                b bVar = new b();
                                                int optInt = jSONObject.optInt(a.f11327i, -1);
                                                int optInt2 = jSONObject.optInt(a.f11328j, -1);
                                                if (optInt == 0) {
                                                    String str4 = optInt2 == 0 ? str2 : optInt2 == 1 ? str : null;
                                                    if (!TextUtils.isEmpty(str4)) {
                                                        bVar.f11336a = optString;
                                                        bVar.f11337b = optInt;
                                                        bVar.f11338c = optInt2;
                                                        bVar.f11339d = str4;
                                                        bVar.f11340e = jSONObject.optLong(a.f11330l, 0L);
                                                        bVar.f11341f = jSONObject.optLong(a.f11331m, 0L);
                                                        Log.i("ULogConfigManager", "[log register] add mem task id is ".concat(String.valueOf(optString)));
                                                        ULogConfigManager.this.f11298d.add(bVar);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            if (!TextUtils.isEmpty(str3)) {
                                edit.putString(a.f11323e, str3);
                                Log.i("ULogConfigManager", "[log register] save task id set is ".concat(String.valueOf(str3)));
                            }
                            edit.commit();
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    public List<b> getTaskList() {
        return this.f11298d;
    }

    public void reMoveTaskFroSP(String str) {
        String[] split;
        try {
            Log.i("ULogConfigManager", "[log remove] remove sp. delete task id is ".concat(String.valueOf(str)));
            if (TextUtils.isEmpty(str)) {
                return;
            }
            SharedPreferences sharedPreferences = this.f11296b.getSharedPreferences("efs_ulog", 0);
            if (sharedPreferences == null || sharedPreferences.edit() == null) {
                return;
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            String string = sharedPreferences.getString(a.f11322d, "");
            String string2 = sharedPreferences.getString(a.f11321c, "");
            String string3 = sharedPreferences.getString(a.f11323e, "");
            if (!string2.equals(ULogManager.getUserID()) || !string.equals(ULogManager.getDeviceID()) || TextUtils.isEmpty(string3) || (split = string3.split("_")) == null) {
                return;
            }
            for (int i10 = 0; i10 < split.length; i10++) {
                String str2 = split[i10];
                if (!TextUtils.isEmpty(str2) && str2.equals(str)) {
                    Log.i("ULogConfigManager", "[log remove] taskId is ".concat(str2));
                    if (string3.equals(str2)) {
                        string3 = "";
                    } else {
                        string3 = string3.replaceFirst(i10 == split.length - 1 ? "_".concat(str2) : str2 + "_", "");
                    }
                    Log.i("ULogConfigManager", "[log remove] put id set is ".concat(String.valueOf(string3)));
                    edit.putString(a.f11323e, string3);
                    edit.remove(str2);
                    edit.commit();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void removeTask(b bVar) {
        Vector<b> vector = this.f11298d;
        if (vector == null || !vector.contains(bVar)) {
            return;
        }
        Log.i("ULogConfigManager", "[log remove] remove mem. task id is " + bVar.f11336a);
        this.f11298d.remove(bVar);
    }
}
