package b9;

import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f5211a = new String[0];

    /* renamed from: b, reason: collision with root package name */
    public static final Charset f5212b = Charset.forName("UTF-8");

    public static List a(Object[] objArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) objArr.clone()));
    }

    public static List b(Object[] objArr, Object[] objArr2) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            int length = objArr2.length;
            int i10 = 0;
            while (true) {
                if (i10 < length) {
                    Object obj2 = objArr2[i10];
                    if (obj.equals(obj2)) {
                        arrayList.add(obj2);
                        break;
                    }
                    i10++;
                }
            }
        }
        return arrayList;
    }

    public static Object[] c(Class cls, Object[] objArr, Object[] objArr2) {
        List b10 = b(objArr, objArr2);
        return b10.toArray((Object[]) Array.newInstance((Class<?>) cls, b10.size()));
    }
}
