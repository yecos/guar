package w7;

import a8.d;
import android.app.Activity;
import t9.i;
import z7.b;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f19265a = new a();

    public final b a(Activity activity, int i10, String str) {
        i.g(activity, "activity");
        i.g(str, "clientId");
        return i10 == 1 ? new d(activity, str) : new a8.a();
    }
}
