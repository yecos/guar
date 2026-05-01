package com.umeng.ccg;

import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.pro.ab;
import com.umeng.analytics.pro.ac;
import com.umeng.analytics.pro.ad;
import com.umeng.analytics.pro.ae;
import com.umeng.analytics.pro.af;
import com.umeng.analytics.pro.ag;
import com.umeng.analytics.pro.ah;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.ak;
import com.umeng.analytics.pro.am;
import com.umeng.analytics.pro.ao;
import com.umeng.analytics.pro.aq;
import com.umeng.analytics.pro.ar;
import com.umeng.analytics.pro.as;
import com.umeng.analytics.pro.au;
import com.umeng.analytics.pro.av;
import com.umeng.analytics.pro.aw;
import com.umeng.analytics.pro.ax;
import com.umeng.analytics.pro.bd;
import com.umeng.analytics.pro.bt;
import com.umeng.ccg.c;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.android.agoo.common.AgooConstants;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class d implements c.a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f10696a = "iucc";

    /* renamed from: b, reason: collision with root package name */
    private static final String f10697b = bd.b().b(bd.C);

    /* renamed from: c, reason: collision with root package name */
    private static JSONObject f10698c = null;

    /* renamed from: d, reason: collision with root package name */
    private static final String[] f10699d = {com.umeng.ccg.a.f10646f, com.umeng.ccg.a.f10647g, com.umeng.ccg.a.f10648h};

    /* renamed from: e, reason: collision with root package name */
    private static final String[] f10700e = {com.umeng.ccg.a.f10646f, com.umeng.ccg.a.f10647g, com.umeng.ccg.a.f10648h, com.umeng.ccg.a.f10649i};

    /* renamed from: f, reason: collision with root package name */
    private static ArrayList<ac> f10701f = null;

    /* renamed from: g, reason: collision with root package name */
    private static ArrayList<ac> f10702g = null;

    /* renamed from: h, reason: collision with root package name */
    private static ArrayList<ac> f10703h = null;

    /* renamed from: i, reason: collision with root package name */
    private static ArrayList<ac> f10704i = null;

    /* renamed from: j, reason: collision with root package name */
    private static ab f10705j = null;

    /* renamed from: m, reason: collision with root package name */
    private static e f10706m = new e();

    /* renamed from: k, reason: collision with root package name */
    private volatile String f10707k = "";

    /* renamed from: l, reason: collision with root package name */
    private Map<String, b> f10708l = new HashMap();

    public static class a extends BroadcastReceiver {
        public long a(ArrayList<ac> arrayList) {
            if (arrayList != null && arrayList.size() > 0) {
                for (int i10 = 0; i10 < arrayList.size(); i10++) {
                    ac acVar = arrayList.get(i10);
                    if (acVar instanceof af) {
                        return ((af) acVar).c();
                    }
                }
            }
            return 0L;
        }

        public boolean b(ArrayList<ac> arrayList) {
            if (arrayList == null || arrayList.size() <= 0) {
                return false;
            }
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                if (arrayList.get(i10).b()) {
                    return false;
                }
            }
            return true;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                String action = intent.getAction();
                if (TextUtils.isEmpty(action)) {
                    return;
                }
                if (action.equals("android.intent.action.SCREEN_ON") && d.f10705j != null && (d.f10705j instanceof ae)) {
                    if (b(d.f10704i)) {
                        com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 304, d.a(), null, 1000 * a(d.f10704i));
                    } else {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "don't send INVOKE_APPACT_WHEN_SCREEN_ON msg.");
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public class b {

        /* renamed from: b, reason: collision with root package name */
        private JSONArray f10714b;

        /* renamed from: c, reason: collision with root package name */
        private String f10715c;

        public b(JSONArray jSONArray, String str) {
            this.f10714b = jSONArray;
            this.f10715c = str;
        }

        public JSONArray a() {
            return this.f10714b;
        }

        public String b() {
            return this.f10715c;
        }
    }

    public class c {

        /* renamed from: a, reason: collision with root package name */
        public String f10716a;

        /* renamed from: b, reason: collision with root package name */
        public int f10717b;

        /* renamed from: c, reason: collision with root package name */
        public int f10718c;

        public c(String str, int i10, int i11) {
            this.f10716a = str;
            this.f10717b = i10;
            this.f10718c = i11;
        }
    }

    /* renamed from: com.umeng.ccg.d$d, reason: collision with other inner class name */
    public static class C0175d {

        /* renamed from: a, reason: collision with root package name */
        private static final d f10720a = new d();

        private C0175d() {
        }
    }

    public static class e extends BroadcastReceiver {
        public long a(ArrayList<ac> arrayList) {
            if (arrayList != null && arrayList.size() > 0) {
                for (int i10 = 0; i10 < arrayList.size(); i10++) {
                    ac acVar = arrayList.get(i10);
                    if (acVar instanceof af) {
                        return ((af) acVar).c();
                    }
                }
            }
            return 0L;
        }

        public boolean b(ArrayList<ac> arrayList) {
            if (arrayList == null || arrayList.size() <= 0) {
                return false;
            }
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                if (arrayList.get(i10).b()) {
                    return false;
                }
            }
            return true;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                String action = intent.getAction();
                if (TextUtils.isEmpty(action)) {
                    return;
                }
                if (action.equals("android.intent.action.SCREEN_ON")) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "recv intent : ACTION_SCREEN_ON");
                    if (b(d.f10701f)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "report screen_on event.");
                        com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 301, d.a(), null, a(d.f10701f) * 1000);
                    } else {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "don't report screen_on event.");
                    }
                }
                if (action.equals("android.intent.action.SCREEN_OFF")) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "recv intent : ACTION_SCREEN_OFF");
                    if (b(d.f10702g)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "report screen_off event.");
                        com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 302, d.a(), null, a(d.f10702g) * 1000);
                    } else {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "don't report screen_off event.");
                    }
                }
                if (action.equals("android.intent.action.USER_PRESENT")) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "recv intent : ACTION_USER_PRESENT");
                    if (!b(d.f10703h)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "don't report screen_unlock event.");
                        return;
                    }
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "report screen_unlock event.");
                    com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 303, d.a(), null, a(d.f10703h) * 1000);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(Context context, String str, BroadcastReceiver broadcastReceiver) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(str);
        context.registerReceiver(broadcastReceiver, intentFilter);
    }

    private boolean g() {
        SharedPreferences a10 = au.a(UMGlobalContext.getAppContext());
        if (a10 != null) {
            String string = a10.getString(au.f9918f, "");
            if (TextUtils.isEmpty(string)) {
                h();
                return false;
            }
            try {
                if (!as.a().keySet().equals(as.a(new JSONObject(string)).keySet())) {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private void h() {
        try {
            SharedPreferences a10 = au.a(UMGlobalContext.getAppContext());
            if (a10 != null) {
                a10.edit().putString(au.f9918f, new JSONObject(as.a()).toString()).commit();
            }
        } catch (Throwable unused) {
        }
    }

    private boolean i() {
        try {
            SharedPreferences a10 = au.a(UMGlobalContext.getAppContext());
            if (a10 != null) {
                return !TextUtils.isEmpty(a10.getString(au.f9919g, ""));
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private JSONObject j() {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ax.b(UMUtils.genUmc(), byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            ax.a(byteArray, UMUtils.genSin());
            String str = new String(byteArray);
            byteArrayOutputStream.reset();
            return new JSONObject(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private long b(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.has("ts")) {
            try {
                return jSONObject.optLong("ts");
            } catch (Throwable unused) {
            }
        }
        return 0L;
    }

    private void c(Context context) {
        ImprintHandler.getImprintService(context).registImprintCallback(f10696a, new UMImprintChangeCallback() { // from class: com.umeng.ccg.d.1
            @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
            public void onImprintValueChanged(String str, String str2) {
                com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 107, d.a(), str2);
            }
        });
    }

    private Long d(Context context) {
        try {
            SharedPreferences a10 = au.a(context);
            if (a10 != null) {
                return Long.valueOf(a10.getLong(au.f9916d, 0L));
            }
            return 0L;
        } catch (Throwable unused) {
            return 0L;
        }
    }

    private String e(Context context) {
        try {
            SharedPreferences a10 = au.a(context);
            return a10 != null ? a10.getString(au.f9917e, "") : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    private void c(JSONObject jSONObject) {
        if (jSONObject == null || !jSONObject.has(com.umeng.ccg.a.f10641a)) {
            return;
        }
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject(com.umeng.ccg.a.f10641a);
            ab abVar = null;
            ab a10 = optJSONObject.has(com.umeng.ccg.a.f10642b) ? a(com.umeng.ccg.a.f10642b, optJSONObject.optJSONObject(com.umeng.ccg.a.f10642b)) : null;
            ab a11 = optJSONObject.has(com.umeng.ccg.a.f10643c) ? a(com.umeng.ccg.a.f10643c, optJSONObject.optJSONObject(com.umeng.ccg.a.f10643c)) : null;
            ab a12 = optJSONObject.has(com.umeng.ccg.a.f10644d) ? a(com.umeng.ccg.a.f10644d, optJSONObject.optJSONObject(com.umeng.ccg.a.f10644d)) : null;
            ab a13 = optJSONObject.has(com.umeng.ccg.a.f10645e) ? a(com.umeng.ccg.a.f10645e, optJSONObject.optJSONObject(com.umeng.ccg.a.f10645e)) : null;
            ab a14 = optJSONObject.has(com.umeng.ccg.a.f10646f) ? a(com.umeng.ccg.a.f10646f, optJSONObject.optJSONObject(com.umeng.ccg.a.f10646f)) : null;
            ab a15 = optJSONObject.has(com.umeng.ccg.a.f10647g) ? a(com.umeng.ccg.a.f10647g, optJSONObject.optJSONObject(com.umeng.ccg.a.f10647g)) : null;
            ab a16 = optJSONObject.has(com.umeng.ccg.a.f10648h) ? a(com.umeng.ccg.a.f10648h, optJSONObject.optJSONObject(com.umeng.ccg.a.f10648h)) : null;
            if (optJSONObject.has(com.umeng.ccg.a.f10649i)) {
                abVar = a(com.umeng.ccg.a.f10649i, optJSONObject.optJSONObject(com.umeng.ccg.a.f10649i));
                f10705j = abVar;
            }
            ArrayList arrayList = new ArrayList();
            if (a10 != null) {
                arrayList.add(a10);
            }
            if (a11 != null) {
                arrayList.add(a11);
            }
            if (a12 != null) {
                arrayList.add(a12);
            }
            if (a13 != null) {
                arrayList.add(a13);
            }
            if (a14 != null) {
                arrayList.add(a14);
            }
            if (a15 != null) {
                arrayList.add(a15);
            }
            if (a16 != null) {
                arrayList.add(a16);
            }
            if (abVar != null) {
                arrayList.add(abVar);
            }
            com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 202, a(), arrayList);
        } catch (Throwable unused) {
        }
    }

    public static d a() {
        return C0175d.f10720a;
    }

    public synchronized JSONObject b(Context context) {
        File filesDir;
        String str;
        FileInputStream fileInputStream;
        JSONObject jSONObject = null;
        try {
            filesDir = context.getFilesDir();
            str = f10697b;
        } catch (Throwable unused) {
        }
        if (!new File(filesDir, str).exists()) {
            return null;
        }
        try {
            fileInputStream = context.openFileInput(str);
        } catch (Throwable unused2) {
            fileInputStream = null;
        }
        try {
            JSONObject jSONObject2 = new JSONObject(new String(ax.a(HelperUtils.readStreamToByteArray(fileInputStream), UMConfigure.sAppkey.getBytes())));
            try {
                as.a(fileInputStream);
            } catch (Throwable unused3) {
            }
            jSONObject = jSONObject2;
        } catch (Throwable unused4) {
            as.a(fileInputStream);
            return jSONObject;
        }
        return jSONObject;
    }

    public void a(Context context) {
        com.umeng.ccg.c.a(context, 105, a(), null);
    }

    private boolean a(JSONObject jSONObject) {
        if (jSONObject == null || !jSONObject.has(Constants.KEY_HTTP_CODE)) {
            return false;
        }
        try {
            if (200 == Integer.valueOf(jSONObject.optInt(Constants.KEY_HTTP_CODE)).intValue() && jSONObject.has(com.umeng.ccg.a.f10641a)) {
                return jSONObject.has("ts");
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private synchronized void a(Context context, JSONObject jSONObject, String str) {
        long b10;
        byte[] a10;
        try {
            b10 = b(jSONObject);
            a10 = ax.a(jSONObject.toString().getBytes(), UMConfigure.sAppkey.getBytes());
        } catch (Throwable unused) {
        }
        if (a10 != null && a10.length > 1) {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(context.getFilesDir(), f10697b));
            try {
                fileOutputStream.write(a10);
                fileOutputStream.flush();
                as.a(fileOutputStream);
                a(context, str, b10);
                UMRTLog.i(UMRTLog.RTLOG_TAG, "saveConfigFile success.");
            } catch (Throwable th) {
                as.a(fileOutputStream);
                throw th;
            }
        }
    }

    private void b(String str) {
        String str2 = au.f9914b + str;
        SharedPreferences a10 = au.a(UMGlobalContext.getAppContext());
        if (a10 != null) {
            a10.edit().putLong(str2, System.currentTimeMillis()).commit();
        }
    }

    private void a(String str, ac acVar) {
        if (com.umeng.ccg.a.f10646f.equalsIgnoreCase(str)) {
            if (f10701f == null) {
                f10701f = new ArrayList<>();
            }
            f10701f.add(acVar);
        }
        if (com.umeng.ccg.a.f10647g.equalsIgnoreCase(str)) {
            if (f10702g == null) {
                f10702g = new ArrayList<>();
            }
            f10702g.add(acVar);
        }
        if (com.umeng.ccg.a.f10648h.equalsIgnoreCase(str)) {
            if (f10703h == null) {
                f10703h = new ArrayList<>();
            }
            f10703h.add(acVar);
        }
        if (com.umeng.ccg.a.f10649i.equalsIgnoreCase(str)) {
            if (f10704i == null) {
                f10704i = new ArrayList<>();
            }
            f10704i.add(acVar);
        }
    }

    private ab a(String str, JSONObject jSONObject) {
        JSONArray optJSONArray;
        String str2;
        ab abVar;
        JSONArray optJSONArray2;
        if (jSONObject != null) {
            try {
                if (jSONObject.has(com.umeng.ccg.a.f10652l) && (optJSONArray = jSONObject.optJSONArray(com.umeng.ccg.a.f10652l)) != null && optJSONArray.length() > 0) {
                    JSONObject jSONObject2 = (JSONObject) optJSONArray.get(0);
                    boolean has = jSONObject2.has(com.umeng.ccg.a.f10653m);
                    boolean has2 = jSONObject2.has(com.umeng.ccg.a.f10656p);
                    boolean has3 = jSONObject2.has(com.umeng.ccg.a.f10657q);
                    if (!has || !has2 || !has3) {
                        return null;
                    }
                    try {
                        int optInt = jSONObject2.optInt(com.umeng.ccg.a.f10653m);
                        long optLong = jSONObject2.optLong(com.umeng.ccg.a.f10656p);
                        long optLong2 = jSONObject2.optLong(com.umeng.ccg.a.f10657q);
                        String optString = jSONObject2.optString(com.umeng.ccg.a.f10658r);
                        ArrayList arrayList = new ArrayList();
                        if (jSONObject2.has(com.umeng.ccg.a.f10654n)) {
                            JSONArray optJSONArray3 = jSONObject2.optJSONArray(com.umeng.ccg.a.f10654n);
                            HashSet hashSet = new HashSet();
                            if (optJSONArray3 != null) {
                                str2 = com.umeng.ccg.a.f10661u;
                                int i10 = 0;
                                for (int length = optJSONArray3.length(); i10 < length; length = length) {
                                    hashSet.add(Integer.valueOf(optJSONArray3.getInt(i10)));
                                    i10++;
                                }
                            } else {
                                str2 = com.umeng.ccg.a.f10661u;
                            }
                            if (hashSet.size() > 0) {
                                am amVar = new am(hashSet);
                                if (Arrays.asList(f10699d).contains(str)) {
                                    a(str, amVar);
                                } else {
                                    arrayList.add(amVar);
                                    if (com.umeng.ccg.a.f10649i.equalsIgnoreCase(str)) {
                                        a(str, amVar);
                                    }
                                }
                            }
                        } else {
                            str2 = com.umeng.ccg.a.f10661u;
                        }
                        if (jSONObject2.has(com.umeng.ccg.a.f10655o)) {
                            String optString2 = jSONObject2.optString(com.umeng.ccg.a.f10655o);
                            if (!TextUtils.isEmpty(optString2)) {
                                ak akVar = new ak(optString2);
                                HashSet hashSet2 = new HashSet();
                                for (int i11 = 1; i11 <= 24; i11++) {
                                    if (akVar.a(i11)) {
                                        hashSet2.add(Integer.valueOf(i11));
                                    }
                                }
                                if (hashSet2.size() > 0) {
                                    ag agVar = new ag(hashSet2);
                                    if (Arrays.asList(f10699d).contains(str)) {
                                        a(str, agVar);
                                    } else {
                                        arrayList.add(agVar);
                                    }
                                    if (com.umeng.ccg.a.f10649i.equalsIgnoreCase(str)) {
                                        a(str, agVar);
                                    }
                                }
                            }
                        }
                        arrayList.add(new ai(optInt));
                        ah ahVar = new ah(str, optLong);
                        String[] strArr = f10699d;
                        if (Arrays.asList(strArr).contains(str)) {
                            a(str, ahVar);
                        } else {
                            arrayList.add(ahVar);
                        }
                        if (com.umeng.ccg.a.f10649i.equalsIgnoreCase(str)) {
                            a(str, ahVar);
                        }
                        af afVar = new af(optLong2);
                        if (Arrays.asList(strArr).contains(str)) {
                            a(str, afVar);
                            arrayList.add(afVar);
                        } else {
                            arrayList.add(afVar);
                        }
                        if (com.umeng.ccg.a.f10649i.equalsIgnoreCase(str)) {
                            a(str, afVar);
                        }
                        if (com.umeng.ccg.a.f10645e.equals(str)) {
                            abVar = new ad(str, arrayList);
                        } else if (com.umeng.ccg.a.f10649i.equals(str)) {
                            abVar = new ae(str, arrayList);
                        } else {
                            abVar = new ab(str, arrayList);
                        }
                        try {
                            abVar.b(str, jSONObject2);
                            abVar.a(optString);
                            String str3 = "";
                            String str4 = str2;
                            if (jSONObject.has(str4) && (optJSONArray2 = jSONObject.optJSONArray(str4)) != null) {
                                Map<String, b> map = this.f10708l;
                                if (map != null && !map.containsKey(str)) {
                                    this.f10708l.put(str, new b(new JSONArray(optJSONArray2.toString()), optString));
                                }
                                int length2 = optJSONArray2.length();
                                for (int i12 = 0; i12 < optJSONArray2.length(); i12++) {
                                    str3 = str3 + optJSONArray2.getString(i12);
                                    if (i12 < length2 - 1) {
                                        str3 = str3 + ",";
                                    }
                                }
                            }
                            abVar.b(str3);
                        } catch (Throwable unused) {
                        }
                        return abVar;
                    } catch (Throwable unused2) {
                        return null;
                    }
                }
            } catch (Throwable unused3) {
            }
        }
        return null;
    }

    private void a(Context context, String str, long j10) {
        SharedPreferences a10;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String[] split = str.split("@");
            if (split.length != 4 || (a10 = au.a(context)) == null) {
                return;
            }
            long parseLong = Long.parseLong(split[0]);
            String str2 = split[1];
            SharedPreferences.Editor edit = a10.edit();
            edit.putLong(au.f9915c, j10);
            edit.putLong(au.f9916d, parseLong);
            edit.putString(au.f9917e, str2).commit();
            UMRTLog.i(UMRTLog.RTLOG_TAG, "updateTsS1S2 : ts = " + j10 + "; s1 = " + parseLong + "; s2 = " + str2);
        } catch (Throwable unused) {
        }
    }

    private void a(String str) {
        try {
            String[] split = str.split("@");
            if (split.length != 4) {
                return;
            }
            long parseLong = Long.parseLong(split[0]);
            String str2 = split[1];
            if (!TextUtils.isEmpty(this.f10707k)) {
                String[] split2 = this.f10707k.split("@");
                if (split2.length == 2) {
                    long parseLong2 = Long.parseLong(split2[0]);
                    String str3 = split2[1];
                    if (parseLong2 == parseLong && str3.equalsIgnoreCase(str2)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "重复的iucc S1 and S2, 忽略本次更新，不发起fetch。");
                        return;
                    }
                }
            }
            SharedPreferences a10 = au.a(UMGlobalContext.getAppContext());
            if (a10 != null) {
                if (a10.getLong(au.f9915c, 0L) != parseLong) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "local config ts != iuccS1, send FETCH_NEW_CONFIG msg.");
                    this.f10707k = String.valueOf(parseLong) + "@" + str2;
                    com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 101, a(), str);
                    return;
                }
                d(UMGlobalContext.getAppContext());
                if (e(UMGlobalContext.getAppContext()).equalsIgnoreCase(str2)) {
                    return;
                }
                UMRTLog.i(UMRTLog.RTLOG_TAG, "local S2 != iuccS2, send FETCH_NEW_CONFIG msg.");
                this.f10707k = String.valueOf(parseLong) + "@" + str2;
                com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 101, a(), str);
            }
        } catch (Throwable unused) {
        }
    }

    private void a(boolean z10) {
        try {
            SharedPreferences a10 = au.a(UMGlobalContext.getAppContext());
            if (a10 != null) {
                SharedPreferences.Editor edit = a10.edit();
                if (z10) {
                    edit.putString(au.f9919g, "1").commit();
                } else {
                    edit.putString(au.f9919g, "").commit();
                }
            }
        } catch (Throwable unused) {
        }
    }

    private JSONObject a(String str, int i10, int i11) {
        b bVar;
        JSONObject jSONObject = new JSONObject();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            jSONObject.put("id", "$$_umc_ev1");
            jSONObject.put("ts", currentTimeMillis);
            jSONObject.put("tt", str);
            jSONObject.put(com.umeng.ccg.a.B, i10);
            jSONObject.put("result", i11);
            if (!this.f10708l.containsKey(com.umeng.ccg.a.f10649i) || (bVar = this.f10708l.get(com.umeng.ccg.a.f10649i)) == null) {
                return null;
            }
            JSONObject a10 = ao.a(UMGlobalContext.getAppContext(), bVar.a(), bVar.b());
            JSONObject a11 = ao.a(UMGlobalContext.getAppContext(), jSONObject);
            if (a10 == null || a11 == null) {
                return null;
            }
            return ao.a(a10, a11);
        } catch (Throwable unused) {
            return null;
        }
    }

    public JSONObject a(String str, String str2, String str3, long j10, boolean z10) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", "$$_umc_ev2");
            jSONObject.put("ts", j10);
            jSONObject.put("tt", str);
            jSONObject.put(AgooConstants.MESSAGE_FLAG, str2);
            jSONObject.put("ss", str3);
            if (z10) {
                jSONObject.put("cd", 1);
            } else {
                jSONObject.put("cd", 0);
            }
            JSONObject a10 = ao.a(UMGlobalContext.getAppContext(), new JSONArray(), "");
            JSONObject a11 = ao.a(UMGlobalContext.getAppContext(), jSONObject);
            if (a10 == null || a11 == null) {
                return null;
            }
            return ao.a(a10, a11);
        } catch (Throwable unused) {
            return null;
        }
    }

    private void a(Context context, String str, JSONObject jSONObject) {
        JSONObject a10;
        Object a11;
        try {
            b(com.umeng.ccg.a.f10649i);
            final String optString = jSONObject.has("target") ? jSONObject.optString("target") : "";
            if (TextUtils.isEmpty(optString)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> target is empty, ignore umc_cfg process");
                return;
            }
            final int optInt = jSONObject.has(com.umeng.ccg.a.B) ? jSONObject.optInt(com.umeng.ccg.a.B) : 0;
            if (optInt == 0) {
                JSONObject j10 = j();
                if (j10 == null || (a11 = aw.a(j10.optString(bt.aL), j10.optString("s"), new Class[]{String.class}, context, new Object[]{j10.optString("a")})) == null || Build.VERSION.SDK_INT < 23) {
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putString("ss", Base64.encodeToString(ax.a(DeviceConfig.getPackageName(context).getBytes(), UMUtils.genSin()), 0).trim());
                aw.a(j10.optString("m"), j10.optString("x"), new Class[]{String.class, String.class, String[].class, Bundle.class, Activity.class, aw.a(j10.optString(bt.aJ)), Handler.class}, a11, new Object[]{optString, com.umeng.ccg.a.f10651k, null, bundle, null, new AccountManagerCallback<Bundle>() { // from class: com.umeng.ccg.d.2
                    @Override // android.accounts.AccountManagerCallback
                    public void run(AccountManagerFuture<Bundle> accountManagerFuture) {
                        int i10 = 1;
                        try {
                            accountManagerFuture.getResult();
                            i10 = 0;
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> umc_cfg p s!");
                        } catch (Throwable unused) {
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> umc_cfg p f!");
                        }
                        com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), com.umeng.ccg.c.f10692s, d.a(), d.this.new c(optString, optInt, i10));
                    }
                }, null});
                return;
            }
            if (Build.VERSION.SDK_INT < 23 || (a10 = a(optString, optInt, 0)) == null) {
                return;
            }
            av.a(new aq(aq.f9893b, a10), 0L, TimeUnit.SECONDS);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:193:0x0490, code lost:
    
        if (r6 != null) goto L161;
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x049d, code lost:
    
        r3.put("config", r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:203:0x049b, code lost:
    
        if (0 == 0) goto L162;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11, types: [int] */
    /* JADX WARN: Type inference failed for: r3v12, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r3v15, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v19, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r3v48 */
    /* JADX WARN: Type inference failed for: r3v49 */
    /* JADX WARN: Type inference failed for: r3v50 */
    @Override // com.umeng.ccg.c.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Object obj, int i10) {
        ?? r32;
        Integer valueOf;
        ArrayList arrayList;
        int size;
        b bVar;
        b bVar2;
        b bVar3;
        JSONObject jSONObject = null;
        try {
            switch (i10) {
                case 101:
                    if (obj != null && (obj instanceof String)) {
                        String str = (String) obj;
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "[workEvent]: recv FETCH_NEW_CONFIG msg. source iucc is: " + str);
                        JSONObject a10 = ao.a(UMGlobalContext.getAppContext(), str);
                        if (a10 != null) {
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "[imprint] send request. body: " + a10.toString());
                            av.a(new ar(ar.f9898a, a10, str), 0L, TimeUnit.SECONDS);
                        }
                        if (i()) {
                            c(UMGlobalContext.getAppContext());
                            String imprintProperty = UMEnvelopeBuild.imprintProperty(UMGlobalContext.getAppContext(), f10696a, "");
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "manual check iucc value: " + imprintProperty);
                            a(imprintProperty);
                            break;
                        }
                    }
                    break;
                case 102:
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "[workEvent]: recv FETCH_RESPONSE msg.");
                    this.f10707k = "";
                    if (obj != null && (obj instanceof JSONObject)) {
                        JSONObject jSONObject2 = (JSONObject) obj;
                        if (a(jSONObject2.optJSONObject("config"))) {
                            com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 103, a(), jSONObject2);
                            break;
                        } else {
                            com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 104, a(), null);
                            break;
                        }
                    } else {
                        com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 104, a(), null);
                        break;
                    }
                    break;
                case 103:
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "[workEvent]: recv FETCH_SUCCESS msg.");
                    Context appContext = UMGlobalContext.getAppContext();
                    if (obj != null && (obj instanceof JSONObject)) {
                        JSONObject jSONObject3 = (JSONObject) obj;
                        JSONObject optJSONObject = jSONObject3.optJSONObject("config");
                        String optString = jSONObject3.optString("sourceIucc");
                        if (optJSONObject != null) {
                            if (i()) {
                                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> 成功拉取云配参数后，检测到should fetch标志，清除此标志。更新SDK类型集缓存值");
                                h();
                                a(false);
                            }
                            a(appContext, optJSONObject, optString);
                            CcgAgent.notifyConfigChanged(optJSONObject);
                            break;
                        }
                    }
                    break;
                case 104:
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "[workEvent]: recv FETCH_FAILED msg.");
                    break;
                case 105:
                    String[] collectItemList = CcgAgent.getCollectItemList();
                    int length = collectItemList.length;
                    r32 = 0;
                    while (r32 < length) {
                        String str2 = collectItemList[r32];
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "[forbid_sdk] 采集项: " + str2 + "; 值: " + CcgAgent.getForbidSdkArray(str2).toString());
                        r32++;
                    }
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "[workEvent]: recv LOAD_CONFIG msg.");
                    Integer num = 0;
                    try {
                        try {
                            jSONObject = b(UMGlobalContext.getAppContext());
                            if (jSONObject != null) {
                                if (a(jSONObject)) {
                                    valueOf = Integer.valueOf(num.intValue() | 1);
                                } else {
                                    valueOf = Integer.valueOf(num.intValue() | 0);
                                }
                            } else {
                                valueOf = Integer.valueOf(num.intValue() | 0);
                            }
                            r32 = new JSONObject();
                            r32.put("result", valueOf);
                            r32 = r32;
                            break;
                        } catch (Throwable unused) {
                            r32 = new JSONObject();
                            r32.put("result", num);
                            r32 = r32;
                            break;
                        }
                    } catch (Throwable unused2) {
                        break;
                    }
                case 106:
                    if (obj != null && (obj instanceof JSONObject)) {
                        JSONObject jSONObject4 = (JSONObject) obj;
                        if (jSONObject4.has("result")) {
                            if ((jSONObject4.optInt("result") & 1) != 0 && jSONObject4.has("config")) {
                                JSONObject optJSONObject2 = jSONObject4.optJSONObject("config");
                                f10698c = optJSONObject2;
                                if (optJSONObject2 != null) {
                                    CcgAgent.notifyConfigReady(optJSONObject2);
                                    r10 = 1;
                                }
                            }
                            if (r10 == 0) {
                                CcgAgent.notifyConfigReady(null);
                            }
                        }
                        if (g()) {
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> 检测到集成的SDK类型集合发生变化，发起云配参数拉取请求(设置本地should fetch标志).");
                            String imprintProperty2 = UMEnvelopeBuild.imprintProperty(UMGlobalContext.getAppContext(), f10696a, "");
                            a(true);
                            com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 101, a(), imprintProperty2);
                            break;
                        } else {
                            c(UMGlobalContext.getAppContext());
                            String imprintProperty3 = UMEnvelopeBuild.imprintProperty(UMGlobalContext.getAppContext(), f10696a, "");
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "manual check iucc value: " + imprintProperty3);
                            a(imprintProperty3);
                            break;
                        }
                    }
                    break;
                case 107:
                    if (obj != null) {
                        try {
                            if (obj instanceof String) {
                                String str3 = (String) obj;
                                UMRTLog.i(UMRTLog.RTLOG_TAG, "[IMPRINT_IUCC_CHANGED] iucc : " + str3);
                                a(str3);
                                break;
                            }
                        } catch (Throwable th) {
                            UMRTLog.e(UMRTLog.RTLOG_TAG, "[imprint] process error " + th.getMessage());
                            return;
                        }
                    }
                    break;
                default:
                    switch (i10) {
                        case 201:
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "recv PARSE_CONFIG msg.");
                            if (obj != null && (obj instanceof JSONObject)) {
                                c((JSONObject) obj);
                                break;
                            }
                            break;
                        case 202:
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "recv COLLECTION_JUDGMENT msg.");
                            if (obj != null && (obj instanceof ArrayList) && (size = (arrayList = (ArrayList) obj).size()) > 0) {
                                while (r10 < size) {
                                    ab abVar = (ab) arrayList.get(r10);
                                    String a11 = abVar.a();
                                    if (com.umeng.ccg.a.f10649i.equalsIgnoreCase(a11)) {
                                        jSONObject = new JSONObject();
                                        jSONObject.put(com.umeng.ccg.a.f10650j, 202);
                                    }
                                    JSONObject a12 = abVar.a(a11, jSONObject);
                                    if (a12 != null) {
                                        long optLong = !Arrays.asList(f10699d).contains(abVar.a()) ? a12.optLong("delay") * 1000 : 0L;
                                        if (com.umeng.ccg.a.f10649i.equalsIgnoreCase(abVar.a()) && a12.optInt(com.umeng.ccg.a.f10666z) == 0) {
                                            optLong = a12.optLong("delay") * 1000;
                                        }
                                        long j10 = optLong;
                                        a12.remove("delay");
                                        UMRTLog.i(UMRTLog.RTLOG_TAG, "send START_COLLECT msg, delayTs = " + j10);
                                        com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 203, a(), a12, j10);
                                    }
                                    r10++;
                                }
                                break;
                            }
                            break;
                        case 203:
                            if (obj != null && (obj instanceof JSONObject)) {
                                JSONObject jSONObject5 = (JSONObject) obj;
                                String optString2 = jSONObject5.optString("actionName");
                                UMRTLog.i(UMRTLog.RTLOG_TAG, "recv START_COLLECT msg. name is : " + optString2);
                                if (!com.umeng.ccg.b.a(optString2)) {
                                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Local switch of [" + optString2 + "] is off, ignore this command.");
                                    break;
                                } else {
                                    String jSONObject6 = jSONObject5.toString();
                                    if (Arrays.asList(f10700e).contains(optString2)) {
                                        if (com.umeng.ccg.a.f10646f.equalsIgnoreCase(optString2)) {
                                            UMRTLog.i(UMRTLog.RTLOG_TAG, "register Intent.ACTION_SCREEN_ON");
                                            a(UMGlobalContext.getAppContext(), "android.intent.action.SCREEN_ON", f10706m);
                                        }
                                        if (com.umeng.ccg.a.f10647g.equalsIgnoreCase(optString2)) {
                                            UMRTLog.i(UMRTLog.RTLOG_TAG, "register Intent.ACTION_SCREEN_OFF");
                                            a(UMGlobalContext.getAppContext(), "android.intent.action.SCREEN_OFF", f10706m);
                                        }
                                        if (com.umeng.ccg.a.f10648h.equalsIgnoreCase(optString2)) {
                                            UMRTLog.i(UMRTLog.RTLOG_TAG, "register Intent.ACTION_USER_PRESENT");
                                            a(UMGlobalContext.getAppContext(), "android.intent.action.USER_PRESENT", f10706m);
                                        }
                                        if (com.umeng.ccg.a.f10649i.equalsIgnoreCase(optString2)) {
                                            int actUpFlag = CcgAgent.getActUpFlag();
                                            UMRTLog.i(UMRTLog.RTLOG_TAG, "act up flag: " + actUpFlag);
                                            if (actUpFlag <= 0 && jSONObject5.has(com.umeng.ccg.a.f10666z)) {
                                                int optInt = jSONObject5.optInt(com.umeng.ccg.a.f10666z);
                                                if (optInt != 0) {
                                                    if (optInt == 1) {
                                                        a(UMGlobalContext.getAppContext(), "android.intent.action.SCREEN_ON", new a());
                                                        break;
                                                    }
                                                } else {
                                                    a(UMGlobalContext.getAppContext(), optString2, jSONObject5);
                                                    break;
                                                }
                                            }
                                        }
                                    } else {
                                        b(optString2);
                                        if (CcgAgent.hasRegistedActionInfo()) {
                                            r10 = CcgAgent.getActionInfo("anti") != null ? 1 : 0;
                                            String optString3 = jSONObject5.optString(com.umeng.ccg.a.f10659s);
                                            if (!TextUtils.isEmpty(optString3)) {
                                                ActionInfo actionInfo = CcgAgent.getActionInfo(optString3);
                                                if (actionInfo != null) {
                                                    UMRTLog.i(UMRTLog.RTLOG_TAG, "调用[" + optString3 + "] onCommand接口方法, 参数: " + jSONObject5.toString());
                                                    actionInfo.onCommand(UMGlobalContext.getAppContext(), optString2, jSONObject5);
                                                }
                                            } else {
                                                UMRTLog.i(UMRTLog.RTLOG_TAG, "忽略 本次采集项[" + optString2 + "]采集请求.");
                                            }
                                            if (r10 == 0) {
                                                as.a(UMGlobalContext.getAppContext(), jSONObject6);
                                                break;
                                            }
                                        } else {
                                            as.a(UMGlobalContext.getAppContext(), jSONObject6);
                                            break;
                                        }
                                    }
                                }
                            }
                            break;
                        default:
                            switch (i10) {
                                case 301:
                                    UMRTLog.i(UMRTLog.RTLOG_TAG, "recv REPORT_SCREEN_ON msg.");
                                    b(com.umeng.ccg.a.f10646f);
                                    if (this.f10708l.containsKey(com.umeng.ccg.a.f10646f) && (bVar = this.f10708l.get(com.umeng.ccg.a.f10646f)) != null) {
                                        JSONObject a13 = ao.a(UMGlobalContext.getAppContext(), 1, bVar.a(), bVar.b());
                                        UMRTLog.i(UMRTLog.RTLOG_TAG, "screen_on event param: " + a13.toString());
                                        av.a(new aq(aq.f9892a, a13), 0L, TimeUnit.SECONDS);
                                        break;
                                    }
                                    break;
                                case 302:
                                    UMRTLog.i(UMRTLog.RTLOG_TAG, "recv REPORT_SCREEN_OFF msg.");
                                    b(com.umeng.ccg.a.f10647g);
                                    if (this.f10708l.containsKey(com.umeng.ccg.a.f10647g) && (bVar2 = this.f10708l.get(com.umeng.ccg.a.f10647g)) != null) {
                                        JSONObject a14 = ao.a(UMGlobalContext.getAppContext(), 3, bVar2.a(), bVar2.b());
                                        UMRTLog.i(UMRTLog.RTLOG_TAG, "screen_off event param: " + a14.toString());
                                        av.a(new aq(aq.f9892a, a14), 0L, TimeUnit.SECONDS);
                                        break;
                                    }
                                    break;
                                case 303:
                                    UMRTLog.i(UMRTLog.RTLOG_TAG, "recv REPORT_SCREEN_UNLOCK msg.");
                                    b(com.umeng.ccg.a.f10648h);
                                    if (this.f10708l.containsKey(com.umeng.ccg.a.f10648h) && (bVar3 = this.f10708l.get(com.umeng.ccg.a.f10648h)) != null) {
                                        JSONObject a15 = ao.a(UMGlobalContext.getAppContext(), 2, bVar3.a(), bVar3.b());
                                        UMRTLog.i(UMRTLog.RTLOG_TAG, "screen_unlock event param: " + a15.toString());
                                        av.a(new aq(aq.f9892a, a15), 0L, TimeUnit.SECONDS);
                                        break;
                                    }
                                    break;
                                case 304:
                                    UMRTLog.i(UMRTLog.RTLOG_TAG, "recv INVOKE_APPACT_WHEN_SC_ON msg.");
                                    if (!com.umeng.ccg.b.a(com.umeng.ccg.a.f10649i)) {
                                        UMRTLog.i(UMRTLog.RTLOG_TAG, "Local switch of [umc_cfg] is off, ignore this command.");
                                        break;
                                    } else {
                                        JSONObject jSONObject7 = new JSONObject();
                                        jSONObject7.put(com.umeng.ccg.a.f10650j, 304);
                                        ab abVar2 = f10705j;
                                        JSONObject a16 = abVar2.a(abVar2.a(), jSONObject7);
                                        if (a16 != null) {
                                            a(UMGlobalContext.getAppContext(), com.umeng.ccg.a.f10649i, a16);
                                            break;
                                        } else {
                                            UMRTLog.i(UMRTLog.RTLOG_TAG, "appActAction.process return null !");
                                            break;
                                        }
                                    }
                                case com.umeng.ccg.c.f10692s /* 305 */:
                                    c cVar = (c) obj;
                                    JSONObject a17 = a(cVar.f10716a, cVar.f10717b, cVar.f10718c);
                                    if (a17 != null) {
                                        av.a(new aq(aq.f9893b, a17), 0L, TimeUnit.SECONDS);
                                        break;
                                    }
                                    break;
                            }
                    }
            }
            return;
            com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 106, a(), r32);
        } catch (Throwable unused3) {
        }
    }
}
