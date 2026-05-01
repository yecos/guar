package com.mobile.brasiltv.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Calendar;
import java.util.HashMap;
import javax.crypto.spec.SecretKeySpec;
import w6.i;

/* loaded from: classes3.dex */
public final class r0 {

    /* renamed from: a, reason: collision with root package name */
    public static final r0 f8743a = new r0();

    /* renamed from: b, reason: collision with root package name */
    public static String f8744b = "8nSjighe4534yY15371QUkgnuiekd6r4trf3";

    public static /* synthetic */ String c(r0 r0Var, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return r0Var.b(str, z10);
    }

    public final String a(String str) {
        t9.i.g(str, "encryptStr");
        long currentTimeMillis = System.currentTimeMillis();
        Calendar calendar = Calendar.getInstance();
        t9.i.f(calendar, "getInstance()");
        calendar.setTimeInMillis(currentTimeMillis);
        calendar.add(6, 7);
        long j10 = 1000;
        long timeInMillis = calendar.getTimeInMillis() / j10;
        HashMap hashMap = new HashMap();
        hashMap.put("account", str);
        hashMap.put("account_type", "0");
        hashMap.put("name", str);
        hashMap.put("avatar", null);
        hashMap.put("age", null);
        hashMap.put("gender", null);
        long j11 = currentTimeMillis / j10;
        hashMap.put(Claims.ISSUED_AT, String.valueOf(j11));
        hashMap.put(Claims.NOT_BEFORE, String.valueOf(j11));
        hashMap.put("exp", String.valueOf(timeInMillis));
        byte[] bytes = f8744b.getBytes(ba.c.f5214b);
        t9.i.f(bytes, "this as java.lang.String).getBytes(charset)");
        String compact = Jwts.builder().setHeaderParam(Header.TYPE, Header.JWT_TYPE).setHeaderParam("alg", "HS256").claims(hashMap).signWith(new SecretKeySpec(bytes, SignatureAlgorithm.HS256.getJcaName())).compact();
        t9.i.f(compact, "tokenStr");
        return compact;
    }

    public final String b(String str, boolean z10) {
        String str2 = "ACMPNY37Q2";
        String str3 = "";
        i.c cVar = w6.i.f19214g;
        String H = cVar.H();
        try {
            String b10 = l.b(H == null || H.length() == 0 ? cVar.l() : cVar.H());
            r0 r0Var = f8743a;
            t9.i.f(b10, "encryptStr");
            str3 = r0Var.a(b10);
            if (z10) {
                str2 = "ROMANC84WZ";
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return str + "?channel_id=" + str2 + "&jwt_token=" + str3;
    }
}
