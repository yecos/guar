package com.umeng.commonsdk.stateless;

import android.content.Context;
import android.text.TextUtils;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.umeng.analytics.pro.by;
import com.umeng.analytics.pro.cc;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.common.DataHelper;

/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private String f11000a = "10.0.0.172";

    /* renamed from: b, reason: collision with root package name */
    private int f11001b = 80;

    /* renamed from: c, reason: collision with root package name */
    private Context f11002c;

    public c(Context context) {
        this.f11002c = context;
    }

    public void a() {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(this.f11002c, "sl_domain_p", "");
        if (TextUtils.isEmpty(imprintProperty)) {
            return;
        }
        a.f10984h = DataHelper.assembleStatelessURL(imprintProperty);
    }

    public void b() {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(this.f11002c, "sl_domain_p", "");
        String imprintProperty2 = UMEnvelopeBuild.imprintProperty(this.f11002c, "oversea_sl_domain_p", "");
        if (!TextUtils.isEmpty(imprintProperty)) {
            a.f10983g = DataHelper.assembleStatelessURL(imprintProperty);
        }
        if (!TextUtils.isEmpty(imprintProperty2)) {
            a.f10986j = DataHelper.assembleStatelessURL(imprintProperty2);
        }
        a.f10984h = a.f10986j;
        if (TextUtils.isEmpty(com.umeng.commonsdk.statistics.b.f11010b)) {
            return;
        }
        if (com.umeng.commonsdk.statistics.b.f11010b.startsWith("460") || com.umeng.commonsdk.statistics.b.f11010b.startsWith("461")) {
            a.f10984h = a.f10983g;
        }
    }

    public boolean a(byte[] bArr, String str, String str2, String str3) {
        String str4 = str2 + Operator.Operation.DIVISION + str;
        if (SdkVersion.SDK_TYPE == 1) {
            return a(bArr, str4, str3);
        }
        if (by.a().b()) {
            String replace = str4.replace("ulogs", "cnlogs");
            String c10 = cc.b().c();
            if (!TextUtils.isEmpty(c10)) {
                replace = by.a(c10, str);
            }
            boolean a10 = a(bArr, replace, str3);
            if (!a10) {
                String a11 = by.a().a(str);
                if (!TextUtils.isEmpty(a11) && !replace.equalsIgnoreCase(a11)) {
                    return a(bArr, a11, str3);
                }
            }
            return a10;
        }
        return a(bArr, str4, str3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0119, code lost:
    
        if (r5 == null) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0129 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0122 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean a(byte[] r10, java.lang.String r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 316
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.stateless.c.a(byte[], java.lang.String, java.lang.String):boolean");
    }
}
