package i9;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class f extends e {
    public static final List a(Object[] objArr) {
        t9.i.g(objArr, "<this>");
        List a10 = h.a(objArr);
        t9.i.f(a10, "asList(this)");
        return a10;
    }

    public static final Object[] b(Object[] objArr, Object[] objArr2, int i10, int i11, int i12) {
        t9.i.g(objArr, "<this>");
        t9.i.g(objArr2, FirebaseAnalytics.Param.DESTINATION);
        System.arraycopy(objArr, i11, objArr2, i10, i12 - i11);
        return objArr2;
    }

    public static /* synthetic */ Object[] c(Object[] objArr, Object[] objArr2, int i10, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        if ((i13 & 8) != 0) {
            i12 = objArr.length;
        }
        return b(objArr, objArr2, i10, i11, i12);
    }

    public static final void d(Object[] objArr, Comparator comparator) {
        t9.i.g(objArr, "<this>");
        t9.i.g(comparator, "comparator");
        if (objArr.length > 1) {
            Arrays.sort(objArr, comparator);
        }
    }
}
