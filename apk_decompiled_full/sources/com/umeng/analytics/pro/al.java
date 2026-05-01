package com.umeng.analytics.pro;

import android.text.TextUtils;
import com.raizlabs.android.dbflow.sql.language.Operator;

/* loaded from: classes3.dex */
public class al {

    /* renamed from: a, reason: collision with root package name */
    private String f9858a;

    /* renamed from: e, reason: collision with root package name */
    private boolean f9862e = false;

    /* renamed from: d, reason: collision with root package name */
    private int f9861d = -1;

    /* renamed from: c, reason: collision with root package name */
    private int f9860c = -1;

    /* renamed from: b, reason: collision with root package name */
    private int f9859b = -1;

    public al(String str) {
        this.f9858a = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a();
    }

    private void a() {
        try {
            if (!this.f9858a.contains(Operator.Operation.MINUS)) {
                this.f9861d = Integer.valueOf(this.f9858a).intValue();
                this.f9862e = false;
                return;
            }
            String[] split = this.f9858a.split(Operator.Operation.MINUS);
            if (split.length == 2) {
                this.f9859b = Integer.valueOf(split[0]).intValue();
                int intValue = Integer.valueOf(split[1]).intValue();
                this.f9860c = intValue;
                if (this.f9859b < 1) {
                    this.f9859b = 1;
                }
                if (intValue > 24) {
                    this.f9860c = 24;
                }
            }
            this.f9862e = true;
        } catch (Throwable unused) {
        }
    }

    public boolean a(int i10) {
        int i11;
        if (this.f9862e) {
            int i12 = this.f9859b;
            if (i12 != -1 && (i11 = this.f9860c) != -1 && i10 >= i12 && i10 <= i11) {
                return true;
            }
        } else {
            int i13 = this.f9861d;
            if (i13 != -1 && i10 == i13) {
                return true;
            }
        }
        return false;
    }
}
