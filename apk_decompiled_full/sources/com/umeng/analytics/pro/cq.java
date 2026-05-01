package com.umeng.analytics.pro;

import com.umeng.analytics.pro.da;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

/* loaded from: classes3.dex */
public class cq {

    /* renamed from: a, reason: collision with root package name */
    private final ByteArrayOutputStream f10188a;

    /* renamed from: b, reason: collision with root package name */
    private final ds f10189b;

    /* renamed from: c, reason: collision with root package name */
    private dg f10190c;

    public cq() {
        this(new da.a());
    }

    public byte[] a(ch chVar) {
        this.f10188a.reset();
        chVar.write(this.f10190c);
        return this.f10188a.toByteArray();
    }

    public String b(ch chVar) {
        return new String(a(chVar));
    }

    public cq(di diVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f10188a = byteArrayOutputStream;
        ds dsVar = new ds(byteArrayOutputStream);
        this.f10189b = dsVar;
        this.f10190c = diVar.a(dsVar);
    }

    public String a(ch chVar, String str) {
        try {
            return new String(a(chVar), str);
        } catch (UnsupportedEncodingException unused) {
            throw new cn("JVM DOES NOT SUPPORT ENCODING: " + str);
        }
    }
}
