package com.umeng.analytics.pro;

import android.text.TextUtils;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class ak {

    /* renamed from: a, reason: collision with root package name */
    private String f9856a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList<al> f9857b = new ArrayList<>();

    public ak(String str) {
        this.f9856a = "";
        this.f9856a = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a();
    }

    private void a() {
        try {
            if (!this.f9856a.contains(",")) {
                String str = this.f9856a;
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                String trim = str.trim();
                if (this.f9857b != null) {
                    this.f9857b.add(new al(trim));
                    return;
                }
                return;
            }
            for (String str2 : this.f9856a.split(",")) {
                if (!TextUtils.isEmpty(str2)) {
                    String trim2 = str2.trim();
                    if (this.f9857b != null) {
                        this.f9857b.add(new al(trim2));
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public boolean a(int i10) {
        try {
            ArrayList<al> arrayList = this.f9857b;
            if (arrayList == null) {
                return false;
            }
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                al alVar = this.f9857b.get(i11);
                if (alVar != null && alVar.a(i10)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }
}
