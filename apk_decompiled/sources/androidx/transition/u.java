package androidx.transition;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class u {

    /* renamed from: b, reason: collision with root package name */
    public View f3535b;

    /* renamed from: a, reason: collision with root package name */
    public final Map f3534a = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f3536c = new ArrayList();

    public u(View view) {
        this.f3535b = view;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return this.f3535b == uVar.f3535b && this.f3534a.equals(uVar.f3534a);
    }

    public int hashCode() {
        return (this.f3535b.hashCode() * 31) + this.f3534a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f3535b + "\n") + "    values:";
        for (String str2 : this.f3534a.keySet()) {
            str = str + "    " + str2 + ": " + this.f3534a.get(str2) + "\n";
        }
        return str;
    }
}
