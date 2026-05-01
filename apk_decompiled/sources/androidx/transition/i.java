package androidx.transition;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

/* loaded from: classes.dex */
public class i extends Property {

    /* renamed from: a, reason: collision with root package name */
    public final Property f3474a;

    /* renamed from: b, reason: collision with root package name */
    public final PathMeasure f3475b;

    /* renamed from: c, reason: collision with root package name */
    public final float f3476c;

    /* renamed from: d, reason: collision with root package name */
    public final float[] f3477d;

    /* renamed from: e, reason: collision with root package name */
    public final PointF f3478e;

    /* renamed from: f, reason: collision with root package name */
    public float f3479f;

    public i(Property property, Path path) {
        super(Float.class, property.getName());
        this.f3477d = new float[2];
        this.f3478e = new PointF();
        this.f3474a = property;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        this.f3475b = pathMeasure;
        this.f3476c = pathMeasure.getLength();
    }

    @Override // android.util.Property
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Float get(Object obj) {
        return Float.valueOf(this.f3479f);
    }

    @Override // android.util.Property
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void set(Object obj, Float f10) {
        this.f3479f = f10.floatValue();
        this.f3475b.getPosTan(this.f3476c * f10.floatValue(), this.f3477d, null);
        PointF pointF = this.f3478e;
        float[] fArr = this.f3477d;
        pointF.x = fArr[0];
        pointF.y = fArr[1];
        this.f3474a.set(obj, pointF);
    }
}
