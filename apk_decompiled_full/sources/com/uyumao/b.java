package com.uyumao;

import android.content.Context;
import android.text.TextUtils;
import com.uyumao.j;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f12384a;

    public b(Context context) {
        this.f12384a = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x006a  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        JSONArray jSONArray;
        Context context;
        try {
            String b10 = e.b(new File(this.f12384a.getCacheDir() + File.separator + "net_change"));
            if (!TextUtils.isEmpty(b10)) {
                String[] split = b10.split("\n");
                if (split.length > 0) {
                    jSONArray = new JSONArray();
                    for (String str : split) {
                        jSONArray.put(new JSONObject(str));
                    }
                    context = this.f12384a;
                    if (j.f12420a == null && context != null) {
                        j.f12420a = context.getApplicationContext();
                    }
                    c.a(this.f12384a, c.a(this.f12384a, j.a.f12421a.a(), jSONArray), jSONArray != null);
                }
            }
            jSONArray = null;
            context = this.f12384a;
            if (j.f12420a == null) {
                j.f12420a = context.getApplicationContext();
            }
            c.a(this.f12384a, c.a(this.f12384a, j.a.f12421a.a(), jSONArray), jSONArray != null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
