package anet.channel.util;

import android.util.Base64;
import com.hpplay.cybergarage.soap.SOAP;
import java.net.InetSocketAddress;
import java.net.Proxy;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public static g f4282a;

    /* renamed from: b, reason: collision with root package name */
    private final Proxy f4283b;

    /* renamed from: c, reason: collision with root package name */
    private final String f4284c;

    /* renamed from: d, reason: collision with root package name */
    private final String f4285d;

    public g(String str, int i10, String str2, String str3) {
        this.f4283b = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(str, i10));
        this.f4284c = str2;
        this.f4285d = str3;
    }

    public static g a() {
        return f4282a;
    }

    public Proxy b() {
        return this.f4283b;
    }

    public String c() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.f4284c);
        sb.append(SOAP.DELIM);
        sb.append(this.f4285d);
        String encodeToString = Base64.encodeToString(sb.toString().getBytes(), 0);
        StringBuilder sb2 = new StringBuilder(64);
        sb2.append("Basic ");
        sb2.append(encodeToString);
        return sb2.toString();
    }
}
