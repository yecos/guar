package com.titan.ranger;

import android.text.TextUtils;
import com.titan.ranger.bean.RangerResult;

/* loaded from: classes3.dex */
public class JniHandler {

    /* renamed from: a, reason: collision with root package name */
    public static a[] f9455a = new a[2];

    public interface a {
        int getInstance();

        int m(String str, String str2, long j10);

        int n(int i10, String str, String str2, String str3);

        int o(String str, String str2, int i10);

        int p(int i10, String str, Object obj, long j10);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x003d, code lost:
    
        if (r14.equals("OnPrepareEvent") == false) goto L4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String Callback(java.lang.String r14, java.lang.String r15) {
        /*
            Method dump skipped, instructions count: 324
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.titan.ranger.JniHandler.Callback(java.lang.String, java.lang.String):java.lang.String");
    }

    public static void d(int i10, a aVar) {
        f9455a[i10] = aVar;
    }

    public final RangerResult a(String str, String str2, long j10) {
        RangerResult rangerResult = new RangerResult(0, "");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            rangerResult.setErr(22);
        } else {
            a aVar = f9455a[0];
            if (aVar != null) {
                rangerResult.setErr(aVar.m(str, str2, j10));
            }
        }
        return rangerResult;
    }

    public final RangerResult b(int i10, String str, Object obj, long j10) {
        RangerResult rangerResult = new RangerResult(0, "");
        if (obj instanceof Status) {
            a aVar = f9455a[i10];
            if (aVar != null && i10 == aVar.getInstance()) {
                rangerResult.setErr(aVar.p(i10, str, (Status) obj, j10));
            }
        } else {
            rangerResult.setErr(22);
        }
        return rangerResult;
    }

    public final RangerResult c(int i10, String str, String str2, String str3) {
        RangerResult rangerResult = new RangerResult(0, "");
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) {
            rangerResult.setErr(22);
        } else {
            a aVar = f9455a[i10];
            if (aVar != null && i10 == aVar.getInstance()) {
                rangerResult.setErr(aVar.n(i10, str, str2, str3));
            }
        }
        return rangerResult;
    }

    public final RangerResult e(int i10, String str, String str2, int i11) {
        RangerResult rangerResult = new RangerResult(0, "");
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            rangerResult.setErr(22);
        } else {
            a aVar = f9455a[i10];
            if (aVar != null && i10 == aVar.getInstance()) {
                rangerResult.setErr(aVar.o(str, str2, i11));
            }
        }
        return rangerResult;
    }
}
