package f4;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.util.Property;
import android.view.animation.Interpolator;
import h4.e;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public e f13090a;

    /* renamed from: c, reason: collision with root package name */
    public Interpolator f13092c;

    /* renamed from: b, reason: collision with root package name */
    public List f13091b = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public int f13093d = -1;

    /* renamed from: e, reason: collision with root package name */
    public long f13094e = 2000;

    public d(e eVar) {
        this.f13090a = eVar;
    }

    public d a(float[] fArr, int... iArr) {
        g(fArr, e.D, iArr);
        return this;
    }

    public ObjectAnimator b() {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f13090a, (PropertyValuesHolder[]) this.f13091b.toArray(new PropertyValuesHolder[this.f13091b.size()]));
        ofPropertyValuesHolder.setDuration(this.f13094e);
        ofPropertyValuesHolder.setRepeatCount(this.f13093d);
        ofPropertyValuesHolder.setInterpolator(this.f13092c);
        return ofPropertyValuesHolder;
    }

    public d c(long j10) {
        this.f13094e = j10;
        return this;
    }

    public d d(float... fArr) {
        h(g4.b.a(fArr));
        return this;
    }

    public final void e(int i10, int i11) {
        if (i10 != i11) {
            throw new IllegalStateException(String.format(Locale.getDefault(), "The fractions.length must equal values.length, fraction.length[%d], values.length[%d]", Integer.valueOf(i10), Integer.valueOf(i11)));
        }
    }

    public PropertyValuesHolder f(float[] fArr, Property property, float[] fArr2) {
        e(fArr.length, fArr2.length);
        Keyframe[] keyframeArr = new Keyframe[fArr.length];
        for (int i10 = 0; i10 < fArr2.length; i10++) {
            keyframeArr[i10] = Keyframe.ofFloat(fArr[i10], fArr2[i10]);
        }
        PropertyValuesHolder ofKeyframe = PropertyValuesHolder.ofKeyframe(property, keyframeArr);
        this.f13091b.add(ofKeyframe);
        return ofKeyframe;
    }

    public PropertyValuesHolder g(float[] fArr, Property property, int[] iArr) {
        e(fArr.length, iArr.length);
        Keyframe[] keyframeArr = new Keyframe[fArr.length];
        for (int i10 = 0; i10 < iArr.length; i10++) {
            keyframeArr[i10] = Keyframe.ofInt(fArr[i10], iArr[i10]);
        }
        PropertyValuesHolder ofKeyframe = PropertyValuesHolder.ofKeyframe(property, keyframeArr);
        this.f13091b.add(ofKeyframe);
        return ofKeyframe;
    }

    public d h(Interpolator interpolator) {
        this.f13092c = interpolator;
        return this;
    }

    public d i(float[] fArr, int... iArr) {
        g(fArr, e.f14165u, iArr);
        return this;
    }

    public d j(float[] fArr, int... iArr) {
        g(fArr, e.f14164t, iArr);
        return this;
    }

    public d k(float[] fArr, int... iArr) {
        g(fArr, e.f14166v, iArr);
        return this;
    }

    public d l(float[] fArr, float... fArr2) {
        f(fArr, e.C, fArr2);
        return this;
    }

    public d m(float[] fArr, float... fArr2) {
        f(fArr, e.f14169y, fArr2);
        return this;
    }

    public d n(float[] fArr, float... fArr2) {
        f(fArr, e.f14170z, fArr2);
        return this;
    }
}
