package q;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public abstract class i {
    public static boolean a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i10, boolean z10) {
        return !j(xmlPullParser, str) ? z10 : typedArray.getBoolean(i10, z10);
    }

    public static int b(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i10, int i11) {
        return !j(xmlPullParser, str) ? i11 : typedArray.getColor(i10, i11);
    }

    public static ColorStateList c(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i10) {
        if (!j(xmlPullParser, str)) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i10, typedValue);
        int i11 = typedValue.type;
        if (i11 != 2) {
            return (i11 < 28 || i11 > 31) ? a.d(typedArray.getResources(), typedArray.getResourceId(i10, 0), theme) : d(typedValue);
        }
        throw new UnsupportedOperationException("Failed to resolve attribute at index " + i10 + ": " + typedValue);
    }

    public static ColorStateList d(TypedValue typedValue) {
        return ColorStateList.valueOf(typedValue.data);
    }

    public static b e(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i10, int i11) {
        if (j(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i10, typedValue);
            int i12 = typedValue.type;
            if (i12 >= 28 && i12 <= 31) {
                return b.b(typedValue.data);
            }
            b g10 = b.g(typedArray.getResources(), typedArray.getResourceId(i10, 0), theme);
            if (g10 != null) {
                return g10;
            }
        }
        return b.b(i11);
    }

    public static float f(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i10, float f10) {
        return !j(xmlPullParser, str) ? f10 : typedArray.getFloat(i10, f10);
    }

    public static int g(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i10, int i11) {
        return !j(xmlPullParser, str) ? i11 : typedArray.getInt(i10, i11);
    }

    public static int h(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i10, int i11) {
        return !j(xmlPullParser, str) ? i11 : typedArray.getResourceId(i10, i11);
    }

    public static String i(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i10) {
        if (j(xmlPullParser, str)) {
            return typedArray.getString(i10);
        }
        return null;
    }

    public static boolean j(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }

    public static TypedArray k(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public static TypedValue l(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i10) {
        if (j(xmlPullParser, str)) {
            return typedArray.peekValue(i10);
        }
        return null;
    }
}
