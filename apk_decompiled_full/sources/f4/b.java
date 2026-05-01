package f4;

import android.util.Property;

/* loaded from: classes.dex */
public abstract class b extends Property {
    public b(String str) {
        super(Float.class, str);
    }

    @Override // android.util.Property
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void set(Object obj, Float f10) {
        b(obj, f10.floatValue());
    }

    public abstract void b(Object obj, float f10);
}
