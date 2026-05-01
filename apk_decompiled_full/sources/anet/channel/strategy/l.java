package anet.channel.strategy;

import anet.channel.strategy.dispatch.DispatchConstants;
import anet.channel.util.ALog;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.BaseMonitor;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class l {

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f4214a;

        /* renamed from: b, reason: collision with root package name */
        public final String f4215b;

        /* renamed from: c, reason: collision with root package name */
        public final int f4216c;

        /* renamed from: d, reason: collision with root package name */
        public final int f4217d;

        /* renamed from: e, reason: collision with root package name */
        public final int f4218e;

        /* renamed from: f, reason: collision with root package name */
        public final int f4219f;

        /* renamed from: g, reason: collision with root package name */
        public final String f4220g;

        /* renamed from: h, reason: collision with root package name */
        public final String f4221h;

        public a(JSONObject jSONObject) {
            this.f4214a = jSONObject.optInt("port");
            this.f4215b = jSONObject.optString("protocol");
            this.f4216c = jSONObject.optInt("cto");
            this.f4217d = jSONObject.optInt("rto");
            this.f4218e = jSONObject.optInt("retry");
            this.f4219f = jSONObject.optInt("heartbeat");
            this.f4220g = jSONObject.optString("rtt", "");
            this.f4221h = jSONObject.optString("publickey");
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f4222a;

        /* renamed from: b, reason: collision with root package name */
        public final int f4223b;

        /* renamed from: c, reason: collision with root package name */
        public final String f4224c;

        /* renamed from: d, reason: collision with root package name */
        public final String f4225d;

        /* renamed from: e, reason: collision with root package name */
        public final String f4226e;

        /* renamed from: f, reason: collision with root package name */
        public final String[] f4227f;

        /* renamed from: g, reason: collision with root package name */
        public final String[] f4228g;

        /* renamed from: h, reason: collision with root package name */
        public final a[] f4229h;

        /* renamed from: i, reason: collision with root package name */
        public final e[] f4230i;

        /* renamed from: j, reason: collision with root package name */
        public final boolean f4231j;

        /* renamed from: k, reason: collision with root package name */
        public final boolean f4232k;

        /* renamed from: l, reason: collision with root package name */
        public final int f4233l;

        public b(JSONObject jSONObject) {
            this.f4222a = jSONObject.optString(Constants.KEY_HOST);
            this.f4223b = jSONObject.optInt("ttl");
            this.f4224c = jSONObject.optString("safeAisles");
            this.f4225d = jSONObject.optString(BrowserInfo.KEY_CNAME, null);
            this.f4226e = jSONObject.optString("unit", null);
            this.f4231j = jSONObject.optInt("clear") == 1;
            this.f4232k = jSONObject.optBoolean("effectNow");
            this.f4233l = jSONObject.optInt("version");
            JSONArray optJSONArray = jSONObject.optJSONArray("ips");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                this.f4227f = new String[length];
                for (int i10 = 0; i10 < length; i10++) {
                    this.f4227f[i10] = optJSONArray.optString(i10);
                }
            } else {
                this.f4227f = null;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("sips");
            if (optJSONArray2 == null || optJSONArray2.length() <= 0) {
                this.f4228g = null;
            } else {
                int length2 = optJSONArray2.length();
                this.f4228g = new String[length2];
                for (int i11 = 0; i11 < length2; i11++) {
                    this.f4228g[i11] = optJSONArray2.optString(i11);
                }
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("aisles");
            if (optJSONArray3 != null) {
                int length3 = optJSONArray3.length();
                this.f4229h = new a[length3];
                for (int i12 = 0; i12 < length3; i12++) {
                    this.f4229h[i12] = new a(optJSONArray3.optJSONObject(i12));
                }
            } else {
                this.f4229h = null;
            }
            JSONArray optJSONArray4 = jSONObject.optJSONArray("strategies");
            if (optJSONArray4 == null || optJSONArray4.length() <= 0) {
                this.f4230i = null;
                return;
            }
            int length4 = optJSONArray4.length();
            this.f4230i = new e[length4];
            for (int i13 = 0; i13 < length4; i13++) {
                this.f4230i[i13] = new e(optJSONArray4.optJSONObject(i13));
            }
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final String f4234a;

        /* renamed from: b, reason: collision with root package name */
        public final e[] f4235b;

        public c(JSONObject jSONObject) {
            this.f4234a = jSONObject.optString(Constants.KEY_HOST);
            JSONArray optJSONArray = jSONObject.optJSONArray("strategies");
            if (optJSONArray == null) {
                this.f4235b = null;
                return;
            }
            int length = optJSONArray.length();
            this.f4235b = new e[length];
            for (int i10 = 0; i10 < length; i10++) {
                this.f4235b[i10] = new e(optJSONArray.optJSONObject(i10));
            }
        }
    }

    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public final String f4236a;

        /* renamed from: b, reason: collision with root package name */
        public final b[] f4237b;

        /* renamed from: c, reason: collision with root package name */
        public final c[] f4238c;

        /* renamed from: d, reason: collision with root package name */
        public final String f4239d;

        /* renamed from: e, reason: collision with root package name */
        public final String f4240e;

        /* renamed from: f, reason: collision with root package name */
        public final int f4241f;

        /* renamed from: g, reason: collision with root package name */
        public final int f4242g;

        /* renamed from: h, reason: collision with root package name */
        public final int f4243h;

        public d(JSONObject jSONObject) {
            this.f4236a = jSONObject.optString("ip");
            this.f4239d = jSONObject.optString(ParamsMap.DeviceParams.KEY_UID, null);
            this.f4240e = jSONObject.optString("utdid", null);
            this.f4241f = jSONObject.optInt(DispatchConstants.CONFIG_VERSION);
            this.f4242g = jSONObject.optInt("fcl");
            this.f4243h = jSONObject.optInt("fct");
            JSONArray optJSONArray = jSONObject.optJSONArray(BaseMonitor.COUNT_POINT_DNS);
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                this.f4237b = new b[length];
                for (int i10 = 0; i10 < length; i10++) {
                    this.f4237b[i10] = new b(optJSONArray.optJSONObject(i10));
                }
            } else {
                this.f4237b = null;
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("hrTask");
            if (optJSONArray2 == null) {
                this.f4238c = null;
                return;
            }
            int length2 = optJSONArray2.length();
            this.f4238c = new c[length2];
            for (int i11 = 0; i11 < length2; i11++) {
                this.f4238c[i11] = new c(optJSONArray2.optJSONObject(i11));
            }
        }
    }

    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public final String f4244a;

        /* renamed from: b, reason: collision with root package name */
        public final a f4245b;

        /* renamed from: c, reason: collision with root package name */
        public final String f4246c;

        public e(JSONObject jSONObject) {
            this.f4244a = jSONObject.optString("ip");
            this.f4246c = jSONObject.optString("path");
            this.f4245b = new a(jSONObject);
        }
    }

    public static d a(JSONObject jSONObject) {
        try {
            return new d(jSONObject);
        } catch (Exception e10) {
            ALog.e("StrategyResultParser", "Parse HttpDns response failed.", null, e10, "JSON Content", jSONObject.toString());
            return null;
        }
    }
}
