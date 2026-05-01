package y8;

import com.google.common.base.Preconditions;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes3.dex */
public final class i0 {

    /* renamed from: d, reason: collision with root package name */
    public static final AtomicLong f19865d = new AtomicLong();

    /* renamed from: a, reason: collision with root package name */
    public final String f19866a;

    /* renamed from: b, reason: collision with root package name */
    public final String f19867b;

    /* renamed from: c, reason: collision with root package name */
    public final long f19868c;

    public i0(String str, String str2, long j10) {
        Preconditions.checkNotNull(str, "typeName");
        Preconditions.checkArgument(!str.isEmpty(), "empty type");
        this.f19866a = str;
        this.f19867b = str2;
        this.f19868c = j10;
    }

    public static i0 a(Class cls, String str) {
        return b(c(cls), str);
    }

    public static i0 b(String str, String str2) {
        return new i0(str, str2, e());
    }

    public static String c(Class cls) {
        String simpleName = ((Class) Preconditions.checkNotNull(cls, "type")).getSimpleName();
        return !simpleName.isEmpty() ? simpleName : cls.getName().substring(cls.getPackage().getName().length() + 1);
    }

    public static long e() {
        return f19865d.incrementAndGet();
    }

    public long d() {
        return this.f19868c;
    }

    public String f() {
        return this.f19866a + Operator.Operation.LESS_THAN + this.f19868c + Operator.Operation.GREATER_THAN;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(f());
        if (this.f19867b != null) {
            sb.append(": (");
            sb.append(this.f19867b);
            sb.append(ASCIIPropertyListParser.ARRAY_END_TOKEN);
        }
        return sb.toString();
    }
}
