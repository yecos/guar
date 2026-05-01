package anet.channel.entity;

/* loaded from: classes.dex */
public enum ENV {
    ONLINE(0),
    PREPARE(1),
    TEST(2);

    private int envMode;

    ENV(int i10) {
        this.envMode = i10;
    }

    public int getEnvMode() {
        return this.envMode;
    }

    public void setEnvMode(int i10) {
        this.envMode = i10;
    }

    public static ENV valueOf(int i10) {
        return i10 != 1 ? i10 != 2 ? ONLINE : TEST : PREPARE;
    }
}
