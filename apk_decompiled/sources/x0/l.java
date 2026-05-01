package x0;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public class l implements Interpolator {

    /* renamed from: a, reason: collision with root package name */
    public float[] f19317a;

    /* renamed from: b, reason: collision with root package name */
    public float[] f19318b;

    public l(Context context, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        this(context.getResources(), context.getTheme(), attributeSet, xmlPullParser);
    }

    public final void a(float f10, float f11, float f12, float f13) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f10, f11, f12, f13, 1.0f, 1.0f);
        b(path);
    }

    public final void b(Path path) {
        int i10 = 0;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int min = Math.min(3000, ((int) (length / 0.002f)) + 1);
        if (min <= 0) {
            throw new IllegalArgumentException("The Path has a invalid length " + length);
        }
        this.f19317a = new float[min];
        this.f19318b = new float[min];
        float[] fArr = new float[2];
        for (int i11 = 0; i11 < min; i11++) {
            pathMeasure.getPosTan((i11 * length) / (min - 1), fArr, null);
            this.f19317a[i11] = fArr[0];
            this.f19318b[i11] = fArr[1];
        }
        if (Math.abs(this.f19317a[0]) <= 1.0E-5d && Math.abs(this.f19318b[0]) <= 1.0E-5d) {
            int i12 = min - 1;
            if (Math.abs(this.f19317a[i12] - 1.0f) <= 1.0E-5d && Math.abs(this.f19318b[i12] - 1.0f) <= 1.0E-5d) {
                float f10 = 0.0f;
                int i13 = 0;
                while (i10 < min) {
                    float[] fArr2 = this.f19317a;
                    int i14 = i13 + 1;
                    float f11 = fArr2[i13];
                    if (f11 < f10) {
                        throw new IllegalArgumentException("The Path cannot loop back on itself, x :" + f11);
                    }
                    fArr2[i10] = f11;
                    i10++;
                    f10 = f11;
                    i13 = i14;
                }
                if (pathMeasure.nextContour()) {
                    throw new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
                }
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("The Path must start at (0,0) and end at (1,1) start: ");
        sb.append(this.f19317a[0]);
        sb.append(",");
        sb.append(this.f19318b[0]);
        sb.append(" end:");
        int i15 = min - 1;
        sb.append(this.f19317a[i15]);
        sb.append(",");
        sb.append(this.f19318b[i15]);
        throw new IllegalArgumentException(sb.toString());
    }

    public final void c(float f10, float f11) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f10, f11, 1.0f, 1.0f);
        b(path);
    }

    public final void d(TypedArray typedArray, XmlPullParser xmlPullParser) {
        if (q.i.j(xmlPullParser, "pathData")) {
            String i10 = q.i.i(typedArray, xmlPullParser, "pathData", 4);
            Path e10 = r.d.e(i10);
            if (e10 != null) {
                b(e10);
                return;
            }
            throw new InflateException("The path is null, which is created from " + i10);
        }
        if (!q.i.j(xmlPullParser, "controlX1")) {
            throw new InflateException("pathInterpolator requires the controlX1 attribute");
        }
        if (!q.i.j(xmlPullParser, "controlY1")) {
            throw new InflateException("pathInterpolator requires the controlY1 attribute");
        }
        float f10 = q.i.f(typedArray, xmlPullParser, "controlX1", 0, 0.0f);
        float f11 = q.i.f(typedArray, xmlPullParser, "controlY1", 1, 0.0f);
        boolean j10 = q.i.j(xmlPullParser, "controlX2");
        if (j10 != q.i.j(xmlPullParser, "controlY2")) {
            throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
        }
        if (j10) {
            a(f10, f11, q.i.f(typedArray, xmlPullParser, "controlX2", 2, 0.0f), q.i.f(typedArray, xmlPullParser, "controlY2", 3, 0.0f));
        } else {
            c(f10, f11);
        }
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f10) {
        if (f10 <= 0.0f) {
            return 0.0f;
        }
        if (f10 >= 1.0f) {
            return 1.0f;
        }
        int length = this.f19317a.length - 1;
        int i10 = 0;
        while (length - i10 > 1) {
            int i11 = (i10 + length) / 2;
            if (f10 < this.f19317a[i11]) {
                length = i11;
            } else {
                i10 = i11;
            }
        }
        float[] fArr = this.f19317a;
        float f11 = fArr[length];
        float f12 = fArr[i10];
        float f13 = f11 - f12;
        if (f13 == 0.0f) {
            return this.f19318b[i10];
        }
        float f14 = (f10 - f12) / f13;
        float[] fArr2 = this.f19318b;
        float f15 = fArr2[i10];
        return f15 + (f14 * (fArr2[length] - f15));
    }

    public l(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray k10 = q.i.k(resources, theme, attributeSet, a.f19301l);
        d(k10, xmlPullParser);
        k10.recycle();
    }
}
