package z8;

import com.raizlabs.android.dbflow.sql.language.Operator;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class w0 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f20968a = new ArrayList();

    public w0 a(Object obj) {
        this.f20968a.add(String.valueOf(obj));
        return this;
    }

    public w0 b(String str, Object obj) {
        this.f20968a.add(str + Operator.Operation.EQUALS + obj);
        return this;
    }

    public String toString() {
        return this.f20968a.toString();
    }
}
