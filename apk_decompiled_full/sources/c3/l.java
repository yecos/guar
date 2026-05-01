package c3;

/* loaded from: classes.dex */
public abstract class l extends d {

    /* renamed from: a, reason: collision with root package name */
    public i f5482a;

    public l(String str, i iVar, Throwable th) {
        super(str, th);
        this.f5482a = iVar;
    }

    public i a() {
        return this.f5482a;
    }

    public String b() {
        return null;
    }

    public String c() {
        return super.getMessage();
    }

    public abstract Object d();

    @Override // java.lang.Throwable
    public String getMessage() {
        String message = super.getMessage();
        if (message == null) {
            message = "N/A";
        }
        i a10 = a();
        String b10 = b();
        if (a10 == null && b10 == null) {
            return message;
        }
        StringBuilder sb = new StringBuilder(100);
        sb.append(message);
        if (b10 != null) {
            sb.append(b10);
        }
        if (a10 != null) {
            sb.append('\n');
            sb.append(" at ");
            sb.append(a10.toString());
        }
        return sb.toString();
    }

    @Override // java.lang.Throwable
    public String toString() {
        return getClass().getName() + ": " + getMessage();
    }

    public l(String str) {
        super(str);
    }

    public l(String str, i iVar) {
        this(str, iVar, null);
    }

    public l(String str, Throwable th) {
        this(str, null, th);
    }
}
