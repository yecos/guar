package f4;

import android.util.Property;

/* loaded from: classes.dex */
public abstract class c extends Property {
    public c(String str) {
        super(Integer.class, str);
    }

    @Override // android.util.Property
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void set(Object obj, Integer num) {
        b(obj, num.intValue());
    }

    public abstract void b(Object obj, int i10);
}
