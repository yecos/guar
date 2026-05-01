package pa;

/* loaded from: classes3.dex */
public abstract /* synthetic */ class a {
    public static /* synthetic */ int a(double d10) {
        long doubleToLongBits = Double.doubleToLongBits(d10);
        return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
    }
}
