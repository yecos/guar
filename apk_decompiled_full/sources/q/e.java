package q;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import androidx.core.R$styleable;
import com.hpplay.component.protocol.PlistBuilder;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public abstract class e {
    public static a a(a aVar, int i10, int i11, boolean z10, int i12) {
        return aVar != null ? aVar : z10 ? new a(i10, i12, i11) : new a(i10, i11);
    }

    public static Shader b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        String name = xmlPullParser.getName();
        if (!name.equals("gradient")) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid gradient color tag " + name);
        }
        TypedArray k10 = i.k(resources, theme, attributeSet, R$styleable.f2013e);
        float f10 = i.f(k10, xmlPullParser, "startX", R$styleable.GradientColor_android_startX, 0.0f);
        float f11 = i.f(k10, xmlPullParser, "startY", R$styleable.GradientColor_android_startY, 0.0f);
        float f12 = i.f(k10, xmlPullParser, "endX", R$styleable.GradientColor_android_endX, 0.0f);
        float f13 = i.f(k10, xmlPullParser, "endY", R$styleable.GradientColor_android_endY, 0.0f);
        float f14 = i.f(k10, xmlPullParser, "centerX", R$styleable.GradientColor_android_centerX, 0.0f);
        float f15 = i.f(k10, xmlPullParser, "centerY", R$styleable.GradientColor_android_centerY, 0.0f);
        int g10 = i.g(k10, xmlPullParser, "type", R$styleable.GradientColor_android_type, 0);
        int b10 = i.b(k10, xmlPullParser, "startColor", R$styleable.GradientColor_android_startColor, 0);
        boolean j10 = i.j(xmlPullParser, "centerColor");
        int b11 = i.b(k10, xmlPullParser, "centerColor", R$styleable.GradientColor_android_centerColor, 0);
        int b12 = i.b(k10, xmlPullParser, "endColor", R$styleable.GradientColor_android_endColor, 0);
        int g11 = i.g(k10, xmlPullParser, "tileMode", R$styleable.GradientColor_android_tileMode, 0);
        float f16 = i.f(k10, xmlPullParser, "gradientRadius", R$styleable.GradientColor_android_gradientRadius, 0.0f);
        k10.recycle();
        a a10 = a(c(resources, xmlPullParser, attributeSet, theme), b10, b12, j10, b11);
        if (g10 != 1) {
            return g10 != 2 ? new LinearGradient(f10, f11, f12, f13, a10.f18089a, a10.f18090b, d(g11)) : new SweepGradient(f14, f15, a10.f18089a, a10.f18090b);
        }
        if (f16 > 0.0f) {
            return new RadialGradient(f14, f15, f16, a10.f18089a, a10.f18090b, d(g11));
        }
        throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0080, code lost:
    
        throw new org.xmlpull.v1.XmlPullParserException(r10.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static a c(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int depth;
        int depth2 = xmlPullParser.getDepth() + 1;
        ArrayList arrayList = new ArrayList(20);
        ArrayList arrayList2 = new ArrayList(20);
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals(PlistBuilder.KEY_ITEM)) {
                TypedArray k10 = i.k(resources, theme, attributeSet, R$styleable.f2014f);
                int i10 = R$styleable.GradientColorItem_android_color;
                boolean hasValue = k10.hasValue(i10);
                int i11 = R$styleable.GradientColorItem_android_offset;
                boolean hasValue2 = k10.hasValue(i11);
                if (!hasValue || !hasValue2) {
                    break;
                }
                int color = k10.getColor(i10, 0);
                float f10 = k10.getFloat(i11, 0.0f);
                k10.recycle();
                arrayList2.add(Integer.valueOf(color));
                arrayList.add(Float.valueOf(f10));
            }
        }
        if (arrayList2.size() > 0) {
            return new a(arrayList2, arrayList);
        }
        return null;
    }

    public static Shader.TileMode d(int i10) {
        return i10 != 1 ? i10 != 2 ? Shader.TileMode.CLAMP : Shader.TileMode.MIRROR : Shader.TileMode.REPEAT;
    }

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int[] f18089a;

        /* renamed from: b, reason: collision with root package name */
        public final float[] f18090b;

        public a(List list, List list2) {
            int size = list.size();
            this.f18089a = new int[size];
            this.f18090b = new float[size];
            for (int i10 = 0; i10 < size; i10++) {
                this.f18089a[i10] = ((Integer) list.get(i10)).intValue();
                this.f18090b[i10] = ((Float) list2.get(i10)).floatValue();
            }
        }

        public a(int i10, int i11) {
            this.f18089a = new int[]{i10, i11};
            this.f18090b = new float[]{0.0f, 1.0f};
        }

        public a(int i10, int i11, int i12) {
            this.f18089a = new int[]{i10, i11, i12};
            this.f18090b = new float[]{0.0f, 0.5f, 1.0f};
        }
    }
}
