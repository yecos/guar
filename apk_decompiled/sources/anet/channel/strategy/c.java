package anet.channel.strategy;

import anet.channel.util.HttpConstant;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, String> f4179a = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private boolean f4180b = true;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static c f4181a = new c();

        private a() {
        }
    }

    public void a(boolean z10) {
        this.f4180b = z10;
    }

    public void b(String str) {
        this.f4179a.put(str, HttpConstant.HTTP);
    }

    public String a(String str) {
        if (!this.f4180b) {
            return null;
        }
        String str2 = this.f4179a.get(str);
        if (str2 != null) {
            return str2;
        }
        this.f4179a.put(str, "https");
        return "https";
    }
}
