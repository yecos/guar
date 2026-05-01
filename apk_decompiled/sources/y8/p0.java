package y8;

import com.google.common.base.MoreObjects;
import com.umeng.analytics.pro.bt;
import java.util.Map;
import y8.o0;
import y8.y0;

/* loaded from: classes3.dex */
public abstract class p0 extends o0.c {

    /* renamed from: a, reason: collision with root package name */
    public static final y0.b f19991a = y0.b.a(new a());

    public static final class a {
        public String toString() {
            return "service config is unused";
        }
    }

    public abstract String b();

    public abstract int c();

    public abstract boolean d();

    public abstract y0.b e(Map map);

    public final boolean equals(Object obj) {
        return this == obj;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final String toString() {
        return MoreObjects.toStringHelper(this).add(bt.by, b()).add("priority", c()).add("available", d()).toString();
    }
}
