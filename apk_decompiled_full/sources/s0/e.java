package s0;

import com.raizlabs.android.dbflow.sql.language.Operator;

/* loaded from: classes.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f18630a = new String[0];

    public static void a(StringBuilder sb, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            sb.append(Operator.Operation.EMPTY_PARAM);
            if (i11 < i10 - 1) {
                sb.append(",");
            }
        }
    }

    public static StringBuilder b() {
        return new StringBuilder();
    }
}
