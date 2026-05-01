package com.uyumao;

import android.content.Context;
import com.uyumao.j;
import org.json.JSONArray;

/* loaded from: classes3.dex */
public final class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f12383a;

    public a(Context context) {
        this.f12383a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Context context = this.f12383a;
            if (j.f12420a == null && context != null) {
                j.f12420a = context.getApplicationContext();
            }
            c.a(this.f12383a, c.a(this.f12383a, j.a.f12421a.a(), (JSONArray) null), false);
        } catch (Throwable unused) {
        }
    }
}
