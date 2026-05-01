package anet.channel.security;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static volatile ISecurityFactory f4091a;

    public static ISecurityFactory a() {
        if (f4091a == null) {
            f4091a = new d();
        }
        return f4091a;
    }
}
