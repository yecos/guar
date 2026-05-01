package com.umeng.pagesdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.Choreographer;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.protocol.record.EfsJSONLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    float f12281a;

    /* renamed from: b, reason: collision with root package name */
    long f12282b;

    /* renamed from: c, reason: collision with root package name */
    int f12283c;

    /* renamed from: d, reason: collision with root package name */
    int f12284d;

    /* renamed from: e, reason: collision with root package name */
    int f12285e;

    /* renamed from: g, reason: collision with root package name */
    boolean f12287g;

    /* renamed from: h, reason: collision with root package name */
    long f12288h;

    /* renamed from: i, reason: collision with root package name */
    long f12289i;

    /* renamed from: j, reason: collision with root package name */
    String f12290j;

    /* renamed from: k, reason: collision with root package name */
    private Context f12291k;

    /* renamed from: f, reason: collision with root package name */
    Map<String, Double> f12286f = new HashMap();

    /* renamed from: l, reason: collision with root package name */
    private Choreographer.FrameCallback f12292l = new Choreographer.FrameCallback() { // from class: com.umeng.pagesdk.c.1
        @Override // android.view.Choreographer.FrameCallback
        public final void doFrame(long j10) {
            String str = PageManger.TAG;
            c cVar = c.this;
            if (cVar.f12287g) {
                if (cVar.f12288h == 0) {
                    cVar.f12288h = System.currentTimeMillis();
                }
                long currentTimeMillis = System.currentTimeMillis();
                c cVar2 = c.this;
                if (currentTimeMillis - cVar2.f12288h > cVar2.f12289i) {
                    cVar2.b();
                    return;
                }
                if (cVar2.f12282b == 0) {
                    cVar2.f12282b = j10;
                }
                float f10 = (j10 - cVar2.f12282b) / 1000000.0f;
                if (f10 > cVar2.f12281a) {
                    double d10 = cVar2.f12283c * 1000;
                    double d11 = f10;
                    Double.isNaN(d10);
                    Double.isNaN(d11);
                    double d12 = d10 / d11;
                    cVar2.f12283c = 0;
                    cVar2.f12282b = 0L;
                    if (PageManger.isDebug) {
                        StringBuilder sb = new StringBuilder("doFrame: ");
                        sb.append(d12);
                        sb.append(", map size is ");
                        sb.append(c.this.f12286f.size());
                        sb.append(", page is ");
                        sb.append(c.this.f12290j);
                    }
                    Map<String, Double> map = c.this.f12286f;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(System.currentTimeMillis());
                    map.put(sb2.toString(), Double.valueOf(d12));
                    c cVar3 = c.this;
                    int i10 = cVar3.f12284d + 1;
                    cVar3.f12284d = i10;
                    if (i10 >= cVar3.f12285e) {
                        cVar3.c();
                        c cVar4 = c.this;
                        cVar4.f12284d = 0;
                        Map<String, Double> map2 = cVar4.f12286f;
                        if (map2 != null) {
                            map2.clear();
                        }
                    }
                } else {
                    cVar2.f12283c++;
                }
                Choreographer.getInstance().postFrameCallback(this);
            }
        }
    };

    public c(Context context) {
        SharedPreferences sharedPreferences;
        this.f12281a = 1000.0f;
        this.f12285e = 6;
        this.f12289i = 300000L;
        this.f12291k = context;
        if (context == null || (sharedPreferences = context.getSharedPreferences("efs_page", 0)) == null) {
            return;
        }
        this.f12281a = sharedPreferences.getFloat(PageConfigManger.APM_FPSPERF_COLLECT_INTERVAL, 1000.0f);
        this.f12285e = sharedPreferences.getInt(PageConfigManger.APM_FPSPERF_COLLECT_INTERVAL_TOGETHER, 6);
        this.f12289i = sharedPreferences.getLong(PageConfigManger.APM_FPSPERF_COLLECT_MAX_PERIOD_SEC, 300000L);
        if (PageManger.isDebug) {
            StringBuilder sb = new StringBuilder("init fps. diff is ");
            sb.append(this.f12281a);
            sb.append(", count diff is ");
            sb.append(this.f12285e);
            sb.append(", dlealt time is ");
            sb.append(this.f12289i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        a a10;
        Iterator<Map.Entry<String, Double>> it = this.f12286f.entrySet().iterator();
        if (it != null) {
            JSONArray jSONArray = null;
            boolean z10 = false;
            while (it.hasNext()) {
                Map.Entry<String, Double> next = it.next();
                if (next != null) {
                    if (jSONArray == null) {
                        jSONArray = new JSONArray();
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        if (PageManger.getRefreshRate() > 0.0f) {
                            double doubleValue = next.getValue().doubleValue();
                            double refreshRate = PageManger.getRefreshRate();
                            Double.isNaN(refreshRate);
                            if (doubleValue < refreshRate * 1.1d) {
                                jSONObject.put(next.getKey(), next.getValue());
                                if (next.getValue().doubleValue() < 40.0d) {
                                    z10 = true;
                                }
                            }
                        }
                    } catch (JSONException e10) {
                        e10.printStackTrace();
                    }
                    jSONArray.put(jSONObject);
                }
            }
            if (jSONArray != null) {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("pN", this.f12290j);
                    jSONObject2.put("pF", jSONArray);
                    if (z10 && (a10 = b.a(this.f12291k).a()) != null) {
                        jSONObject2.put("te", a10.f12271c);
                        jSONObject2.put("le", a10.f12269a);
                    }
                    EfsJSONLog efsJSONLog = new EfsJSONLog("fpsperf");
                    efsJSONLog.put("fps", jSONObject2);
                    EfsReporter reporter = PageManger.getReporter();
                    if (reporter != null) {
                        reporter.send(efsJSONLog);
                    }
                } catch (JSONException e11) {
                    e11.printStackTrace();
                }
            }
        }
    }

    public final void a() {
        if (this.f12287g) {
            String str = PageManger.TAG;
            return;
        }
        this.f12287g = true;
        if (PageManger.isDebug) {
            new StringBuilder("start, page is ").append(this.f12290j);
        }
        Choreographer.getInstance().removeFrameCallback(this.f12292l);
        Choreographer.getInstance().postFrameCallback(this.f12292l);
    }

    public final void b() {
        if (PageManger.isDebug) {
            new StringBuilder("stop, page is ").append(this.f12290j);
        }
        c();
        this.f12287g = false;
        this.f12288h = 0L;
        this.f12282b = 0L;
        this.f12283c = 0;
        Map<String, Double> map = this.f12286f;
        if (map != null) {
            map.clear();
        }
        this.f12284d = 0;
    }
}
