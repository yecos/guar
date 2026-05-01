package com.fasterxml.jackson.databind.ser.std;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.Collection;
import java.util.Currency;
import java.util.HashMap;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public abstract class e0 {

    public static class a extends h0 {
    }

    public static class b extends h0 {
    }

    public static class c extends h0 {
    }

    public static Collection a() {
        HashMap hashMap = new HashMap();
        hashMap.put(URL.class, new l0(URL.class));
        hashMap.put(URI.class, new l0(URI.class));
        hashMap.put(Currency.class, new l0(Currency.class));
        hashMap.put(UUID.class, new o0());
        hashMap.put(Pattern.class, new l0(Pattern.class));
        hashMap.put(Locale.class, new l0(Locale.class));
        hashMap.put(AtomicBoolean.class, a.class);
        hashMap.put(AtomicInteger.class, b.class);
        hashMap.put(AtomicLong.class, c.class);
        hashMap.put(File.class, o.class);
        hashMap.put(Class.class, i.class);
        u uVar = u.f6730a;
        hashMap.put(Void.class, uVar);
        hashMap.put(Void.TYPE, uVar);
        return hashMap.entrySet();
    }
}
