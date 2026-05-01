package com.efs.sdk.pa.a;

import android.util.Log;
import com.efs.sdk.pa.PAMsgListener;
import com.hpplay.cybergarage.soap.SOAP;
import java.io.BufferedOutputStream;

/* loaded from: classes.dex */
final class f implements d {

    /* renamed from: a, reason: collision with root package name */
    PAMsgListener f6482a;

    /* renamed from: b, reason: collision with root package name */
    boolean f6483b;

    /* renamed from: c, reason: collision with root package name */
    String f6484c;

    /* renamed from: d, reason: collision with root package name */
    BufferedOutputStream f6485d;

    /* JADX WARN: Removed duplicated region for block: B:28:0x0089 A[Catch: Exception -> 0x00ac, TryCatch #0 {Exception -> 0x00ac, blocks: (B:7:0x000f, B:11:0x001c, B:13:0x0022, B:14:0x002c, B:17:0x0036, B:19:0x003c, B:22:0x0048, B:25:0x0052, B:26:0x007f, B:28:0x0089, B:30:0x008f, B:32:0x0095, B:34:0x009d, B:35:0x00a5, B:40:0x0057, B:42:0x005d, B:44:0x0063, B:47:0x006f, B:50:0x0079), top: B:6:0x000f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static com.efs.sdk.pa.b b(String str, long j10, long j11) {
        String str2;
        int indexOf;
        int indexOf2;
        int i10;
        String substring;
        int lastIndexOf;
        int i11;
        int i12;
        if (str == null) {
            return null;
        }
        com.efs.sdk.pa.b bVar = new com.efs.sdk.pa.b();
        try {
            int indexOf3 = str.indexOf(SOAP.DELIM);
            String str3 = "";
            if (indexOf3 != -1) {
                int i13 = indexOf3 + 2;
                if (i13 < str.length()) {
                    str2 = str.substring(i13, str.length());
                    bVar.f6489a = str2;
                    if (!str.contains("(") && str.contains(")")) {
                        int indexOf4 = str.indexOf("(");
                        int indexOf5 = str.indexOf(")");
                        if (indexOf4 != -1 && indexOf5 != -1 && (i12 = indexOf4 + 1) < str.length() && indexOf5 > i12) {
                            substring = str.substring(i12, indexOf5);
                            bVar.f6490b = substring;
                            if (!str.contains("null")) {
                            }
                            bVar.f6491c = str3;
                            bVar.f6492d = j10;
                            bVar.f6493e = j11;
                            return bVar;
                        }
                        substring = "";
                        bVar.f6490b = substring;
                        if (!str.contains("null")) {
                        }
                        bVar.f6491c = str3;
                        bVar.f6492d = j10;
                        bVar.f6493e = j11;
                        return bVar;
                    }
                    if (str.contains("{") && str.contains("}")) {
                        indexOf = str.indexOf("{");
                        indexOf2 = str.indexOf("}");
                        if (indexOf != -1 && indexOf2 != -1 && (i10 = indexOf + 1) < str.length() && indexOf2 > i10) {
                            substring = str.substring(i10, indexOf2);
                            bVar.f6490b = substring;
                            if (!str.contains("null") && str.contains("}") && (lastIndexOf = str.lastIndexOf("}")) != -1 && (i11 = lastIndexOf + 1) < str.length()) {
                                str3 = str.substring(i11, str.length());
                            }
                            bVar.f6491c = str3;
                            bVar.f6492d = j10;
                            bVar.f6493e = j11;
                            return bVar;
                        }
                    }
                    substring = "";
                    bVar.f6490b = substring;
                    if (!str.contains("null")) {
                        str3 = str.substring(i11, str.length());
                    }
                    bVar.f6491c = str3;
                    bVar.f6492d = j10;
                    bVar.f6493e = j11;
                    return bVar;
                }
            }
            str2 = "";
            bVar.f6489a = str2;
            if (!str.contains("(")) {
            }
            if (str.contains("{")) {
                indexOf = str.indexOf("{");
                indexOf2 = str.indexOf("}");
                if (indexOf != -1) {
                    substring = str.substring(i10, indexOf2);
                    bVar.f6490b = substring;
                    if (!str.contains("null")) {
                    }
                    bVar.f6491c = str3;
                    bVar.f6492d = j10;
                    bVar.f6493e = j11;
                    return bVar;
                }
            }
            substring = "";
            bVar.f6490b = substring;
            if (!str.contains("null")) {
            }
            bVar.f6491c = str3;
            bVar.f6492d = j10;
            bVar.f6493e = j11;
            return bVar;
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    @Override // com.efs.sdk.pa.a.d
    public final void a(String str, long j10, long j11) {
        com.efs.sdk.pa.b b10 = b(str, j10, j11);
        if (b10 != null) {
            if (this.f6483b) {
                Log.e("PerformanceAnalyze", b10.toString());
            }
            if (this.f6484c != null) {
                try {
                    this.f6485d.write((b10.toString() + "\n").getBytes());
                } catch (Exception unused) {
                }
            }
            this.f6482a.msg(b10);
        }
    }
}
