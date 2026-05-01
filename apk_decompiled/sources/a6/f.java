package a6;

import com.mobile.brasiltv.utils.b0;
import i9.j;
import java.util.ArrayList;
import t9.i;

/* loaded from: classes3.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f268a = new f();

    /* renamed from: b, reason: collision with root package name */
    public static final String f269b = "google";

    /* renamed from: c, reason: collision with root package name */
    public static final String f270c = "facebook";

    /* renamed from: d, reason: collision with root package name */
    public static final ArrayList f271d = j.c("google");

    public final boolean a() {
        return f271d.contains(f269b);
    }

    public final void b(ArrayList arrayList) {
        ArrayList arrayList2 = f271d;
        arrayList2.clear();
        if (b0.G(arrayList)) {
            return;
        }
        i.d(arrayList);
        arrayList2.addAll(arrayList);
    }
}
