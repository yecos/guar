package com.uyumao;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import java.io.File;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class h extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public long f12411a = 0;

    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f12412a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f12413b;

        public a(h hVar, Context context, JSONObject jSONObject) {
            this.f12412a = context;
            this.f12413b = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            File file = new File(this.f12412a.getCacheDir().getPath() + File.separator + "net_change");
            StringBuilder sb = new StringBuilder();
            sb.append(this.f12413b.toString());
            sb.append("\n");
            e.a(file, sb.toString().getBytes(), true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x010e A[Catch: all -> 0x0126, TRY_LEAVE, TryCatch #2 {all -> 0x0126, blocks: (B:3:0x0002, B:5:0x000c, B:9:0x0015, B:11:0x0032, B:13:0x0038, B:15:0x003e, B:18:0x004a, B:20:0x0054, B:21:0x005f, B:38:0x010e, B:44:0x0123, B:51:0x0108, B:55:0x006e, B:57:0x0074, B:59:0x007a, B:60:0x0087, B:62:0x008d, B:64:0x0093, B:66:0x0099, B:69:0x00a5, B:71:0x00af, B:40:0x0111), top: B:2:0x0002, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onReceive(Context context, Intent intent) {
        String str;
        String str2;
        String str3;
        String str4;
        JSONObject jSONObject;
        String str5;
        String str6;
        try {
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()) && e.a(context, "android.permission.ACCESS_NETWORK_STATE")) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                int i10 = 1;
                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
                NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
                JSONObject jSONObject2 = null;
                if (networkInfo.isConnected() && networkInfo2.isConnected()) {
                    if (this.f12411a >= 0 && System.currentTimeMillis() - this.f12411a <= 500) {
                        return;
                    }
                    this.f12411a = System.currentTimeMillis();
                    if (d.f12389c) {
                        String[] g10 = e.g(context);
                        str6 = g10[0];
                        str5 = g10[1];
                    } else {
                        str5 = null;
                        str6 = null;
                    }
                    str = e.a(networkInfo2);
                    str4 = str6;
                    str3 = e.d(context);
                    str2 = str5;
                    i10 = 3;
                } else if (!networkInfo.isConnected() && networkInfo2.isConnected()) {
                    str = e.a(networkInfo2);
                    i10 = 2;
                    str3 = e.d(context);
                    str2 = null;
                    str4 = null;
                } else if (!networkInfo.isConnected() || networkInfo2.isConnected()) {
                    str = null;
                    str2 = null;
                    str3 = null;
                    str4 = null;
                    i10 = 0;
                } else {
                    if (this.f12411a >= 0 && System.currentTimeMillis() - this.f12411a <= 500) {
                        return;
                    }
                    this.f12411a = System.currentTimeMillis();
                    if (d.f12389c) {
                        String[] g11 = e.g(context);
                        str4 = g11[0];
                        str2 = g11[1];
                        str = null;
                        str3 = null;
                    } else {
                        str = null;
                        str2 = null;
                        str3 = null;
                        str4 = null;
                    }
                }
                try {
                    jSONObject = new JSONObject();
                    try {
                        jSONObject.put("type", i10);
                        if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str2)) {
                            jSONObject.put("wifi_ssid", str4);
                            jSONObject.put("wifi_bssid", str2);
                        }
                        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
                            jSONObject.put("mobile_type", str);
                            jSONObject.put("mobile_carrier", str3);
                        }
                        jSONObject.put("systemtime", System.currentTimeMillis());
                    } catch (Throwable th) {
                        th = th;
                        jSONObject2 = jSONObject;
                        th.printStackTrace();
                        jSONObject = jSONObject2;
                        if (jSONObject == null) {
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
                if (jSONObject == null) {
                    jSONObject.toString();
                    try {
                        l.a().b().execute(new a(this, context, jSONObject));
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }
}
