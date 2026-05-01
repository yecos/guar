package com.hpplay.component.modulelinker;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import android.util.LruCache;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final String f7340a = "LinkerInfosManager";

    /* renamed from: e, reason: collision with root package name */
    private static final String f7341e = "putLinkInfo";

    /* renamed from: f, reason: collision with root package name */
    private static final String f7342f = "ModuleInfos";

    /* renamed from: g, reason: collision with root package name */
    private static final String f7343g = "CLAZZS";

    /* renamed from: h, reason: collision with root package name */
    private static final String f7344h = "METHODS";

    /* renamed from: i, reason: collision with root package name */
    private static final String f7345i = "FIELDS";

    /* renamed from: j, reason: collision with root package name */
    private static volatile b f7346j;

    /* renamed from: k, reason: collision with root package name */
    private LruCache<String, Object> f7350k;

    /* renamed from: m, reason: collision with root package name */
    private Context f7352m;

    /* renamed from: b, reason: collision with root package name */
    private JSONArray f7347b = new JSONArray();

    /* renamed from: c, reason: collision with root package name */
    private JSONArray f7348c = new JSONArray();

    /* renamed from: d, reason: collision with root package name */
    private JSONArray f7349d = new JSONArray();

    /* renamed from: l, reason: collision with root package name */
    private Map<String, String> f7351l = new HashMap();

    public static b a() {
        if (f7346j == null) {
            synchronized (b.class) {
                if (f7346j == null) {
                    f7346j = new b();
                }
            }
        }
        return f7346j;
    }

    public LruCache b() {
        return this.f7350k;
    }

    public Context c() {
        return this.f7352m;
    }

    public Map<String, String> d() {
        return this.f7351l;
    }

    public JSONArray e() {
        return this.f7347b;
    }

    public JSONArray f() {
        return this.f7348c;
    }

    public JSONArray g() {
        return this.f7349d;
    }

    public Object b(String str) {
        LruCache<String, Object> lruCache = this.f7350k;
        if (lruCache == null) {
            return null;
        }
        return lruCache.remove(str);
    }

    public String c(String str) {
        return this.f7351l.get(str);
    }

    public void a(Context context, String str, List<String> list, int i10) {
        this.f7352m = context;
        this.f7350k = new LruCache<String, Object>(1000) { // from class: com.hpplay.component.modulelinker.b.1
            @Override // android.util.LruCache
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void entryRemoved(boolean z10, String str2, Object obj, Object obj2) {
                super.entryRemoved(z10, str2, obj, obj2);
            }
        };
        a(context, list, str);
    }

    private void a(Context context, List<String> list, String str) {
        ArrayList arrayList = new ArrayList();
        try {
            if (list.size() > 0) {
                for (int i10 = 0; i10 < list.size(); i10++) {
                    String str2 = list.get(i10) + "." + f7342f;
                    if (!arrayList.contains(str2)) {
                        arrayList.add(str2);
                    }
                }
            } else {
                arrayList.add("com.hpplay.component.common.utils.ModuleInfos");
            }
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                StringBuilder sb = new StringBuilder();
                sb.append(" =================  ");
                sb.append((String) arrayList.get(i11));
                Object a10 = d.a((String) arrayList.get(i11), (Class<?>[]) null, (Object[]) null);
                if (a10 != null) {
                    try {
                        d.a(a10, f7341e, new Object[0]);
                        a((String) d.a(a10, f7343g), this.f7347b);
                        a((String) d.a(a10, f7344h), this.f7348c);
                        a((String) d.a(a10, f7345i), this.f7349d);
                    } catch (Exception unused) {
                    }
                }
            }
        } catch (Exception unused2) {
        }
    }

    private void a(String str, JSONArray jSONArray) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        for (String str2 : str.split("#")) {
            jSONArray.put(new String(Base64.decode(str2, 0)));
        }
    }

    public void a(String str, Object obj) {
        this.f7350k.put(str, obj);
    }

    public Object a(String str) {
        return this.f7350k.get(str);
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.f7351l.put(str, str2);
    }
}
