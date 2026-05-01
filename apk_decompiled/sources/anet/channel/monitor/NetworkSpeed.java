package anet.channel.monitor;

/* loaded from: classes.dex */
public enum NetworkSpeed {
    Slow("弱网络", 1),
    Fast("强网络", 5);


    /* renamed from: a, reason: collision with root package name */
    private final String f4005a;

    /* renamed from: b, reason: collision with root package name */
    private final int f4006b;

    NetworkSpeed(String str, int i10) {
        this.f4005a = str;
        this.f4006b = i10;
    }

    public static NetworkSpeed valueOfCode(int i10) {
        return i10 == 1 ? Slow : Fast;
    }

    public int getCode() {
        return this.f4006b;
    }

    public String getDesc() {
        return this.f4005a;
    }
}
