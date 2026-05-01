package com.uyumao;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.bt;

/* loaded from: classes3.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    public static volatile o f12430a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f12431b;

    /* renamed from: c, reason: collision with root package name */
    public final a f12432c = new a(this, "AZX");

    public o(Context context) {
        this.f12431b = context.getApplicationContext();
    }

    public void a(long j10) {
        this.f12432c.b("smart_" + bt.f10040ba, j10);
        this.f12432c.b("smart_ts", System.currentTimeMillis());
    }

    public final boolean a(String str) {
        long a10 = this.f12432c.a(str + bt.f10040ba, 0L);
        if (a10 <= 0) {
            return true;
        }
        a aVar = this.f12432c;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("ts");
        return Math.abs(System.currentTimeMillis() - aVar.a(sb.toString(), 0L)) / 1000 >= a10;
    }

    public long a() {
        return this.f12432c.a("smart_lc", 0L);
    }

    public class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f12433a;

        public a(o oVar, String str) {
            if (!TextUtils.isEmpty(str)) {
                str = str + "_";
            }
            this.f12433a = str;
        }

        public final void a(String str, String str2) {
            try {
                if (n.c(e.f12405a)) {
                    m a10 = m.a();
                    a10.getClass();
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    a10.f12425b.edit().putString(str, str2).apply();
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }

        public void b(String str, long j10) {
            a(this.f12433a + str, String.valueOf(j10));
        }

        public long a(String str, long j10) {
            String str2 = this.f12433a + str;
            String valueOf = String.valueOf(j10);
            try {
                if (n.c(e.f12405a)) {
                    valueOf = m.a().f12425b.getString(str2, valueOf);
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
            try {
                return Long.parseLong(valueOf);
            } catch (Exception unused) {
                return j10;
            }
        }
    }
}
