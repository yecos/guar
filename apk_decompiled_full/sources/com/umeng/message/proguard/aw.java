package com.umeng.message.proguard;

import android.app.Activity;
import android.content.Intent;
import com.umeng.message.api.UPushMessageNotifyApi;
import com.umeng.message.common.UPLog;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class aw implements UPushMessageNotifyApi {

    /* renamed from: d, reason: collision with root package name */
    private static final aw f11597d = new aw();

    /* renamed from: b, reason: collision with root package name */
    public volatile boolean f11599b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f11600c = true;

    /* renamed from: a, reason: collision with root package name */
    public final ax f11598a = new ax();

    private aw() {
    }

    public static aw a() {
        return f11597d;
    }

    public final void b() {
        if (this.f11599b) {
            return;
        }
        this.f11599b = true;
        this.f11598a.a();
    }

    @Override // com.umeng.message.api.UPushMessageNotifyApi
    public final boolean isEnabled() {
        return this.f11598a.f11602b.a();
    }

    @Override // com.umeng.message.api.UPushMessageNotifyApi
    public final void setCallback(UPushMessageNotifyApi.Callback callback) {
        ax axVar = this.f11598a;
        axVar.f11601a = callback;
        if (callback == null || !axVar.f11603c) {
            return;
        }
        try {
            callback.onNotified();
            axVar.f11603c = false;
        } catch (Throwable unused) {
        }
    }

    @Override // com.umeng.message.api.UPushMessageNotifyApi
    public final void setEnable(final boolean z10) {
        this.f11600c = z10;
        final ax axVar = this.f11598a;
        if (axVar.f11602b.a() != z10) {
            axVar.f11602b.f11613a.a("e_u", z10);
            b.b(new Runnable() { // from class: com.umeng.message.proguard.ax.4
                @Override // java.lang.Runnable
                public final void run() {
                    ax.this.f11602b.b(true);
                    boolean z11 = false;
                    try {
                        if (d.h(y.a())) {
                            z11 = ax.a(z10);
                        }
                    } catch (Throwable th) {
                        UPLog.e("Notify", th);
                    }
                    ax.this.f11602b.b(!z11);
                }
            });
        }
    }

    public final void a(JSONObject jSONObject) {
        this.f11598a.a(jSONObject);
    }

    public final void a(Activity activity, Intent intent) {
        this.f11598a.a(activity, intent);
    }
}
