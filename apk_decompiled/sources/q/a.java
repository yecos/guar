package q;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.core.R$attr;
import androidx.core.R$styleable;
import com.hpplay.component.protocol.PlistBuilder;
import com.hpplay.cybergarage.upnp.UPnP;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f18074a = new ThreadLocal();

    public static ColorStateList a(Resources resources, XmlPullParser xmlPullParser, Resources.Theme theme) {
        int next;
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return b(resources, xmlPullParser, asAttributeSet, theme);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static ColorStateList b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        String name = xmlPullParser.getName();
        if (name.equals("selector")) {
            return e(resources, xmlPullParser, attributeSet, theme);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
    }

    public static TypedValue c() {
        ThreadLocal threadLocal = f18074a;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    public static ColorStateList d(Resources resources, int i10, Resources.Theme theme) {
        try {
            return a(resources, resources.getXml(i10), theme);
        } catch (Exception e10) {
            Log.e("CSLCompat", "Failed to inflate ColorStateList.", e10);
            return null;
        }
    }

    public static ColorStateList e(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int depth;
        int color;
        int i10 = 1;
        int depth2 = xmlPullParser.getDepth() + 1;
        int[][] iArr = new int[20][];
        int[] iArr2 = new int[20];
        int i11 = 0;
        while (true) {
            int next = xmlPullParser.next();
            if (next == i10 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals(PlistBuilder.KEY_ITEM)) {
                TypedArray h10 = h(resources, theme, attributeSet, R$styleable.f2010b);
                int i12 = R$styleable.ColorStateListItem_android_color;
                int resourceId = h10.getResourceId(i12, -1);
                if (resourceId == -1 || f(resources, resourceId)) {
                    color = h10.getColor(i12, -65281);
                } else {
                    try {
                        color = a(resources, resources.getXml(resourceId), theme).getDefaultColor();
                    } catch (Exception unused) {
                        color = h10.getColor(R$styleable.ColorStateListItem_android_color, -65281);
                    }
                }
                int i13 = R$styleable.ColorStateListItem_android_alpha;
                float f10 = 1.0f;
                if (h10.hasValue(i13)) {
                    f10 = h10.getFloat(i13, 1.0f);
                } else {
                    int i14 = R$styleable.ColorStateListItem_alpha;
                    if (h10.hasValue(i14)) {
                        f10 = h10.getFloat(i14, 1.0f);
                    }
                }
                h10.recycle();
                int attributeCount = attributeSet.getAttributeCount();
                int[] iArr3 = new int[attributeCount];
                int i15 = 0;
                for (int i16 = 0; i16 < attributeCount; i16++) {
                    int attributeNameResource = attributeSet.getAttributeNameResource(i16);
                    if (attributeNameResource != 16843173 && attributeNameResource != 16843551 && attributeNameResource != R$attr.alpha) {
                        int i17 = i15 + 1;
                        if (!attributeSet.getAttributeBooleanValue(i16, false)) {
                            attributeNameResource = -attributeNameResource;
                        }
                        iArr3[i15] = attributeNameResource;
                        i15 = i17;
                    }
                }
                int[] trimStateSet = StateSet.trimStateSet(iArr3, i15);
                iArr2 = f.a(iArr2, i11, g(color, f10));
                iArr = (int[][]) f.b(iArr, i11, trimStateSet);
                i11++;
            }
            i10 = 1;
        }
        int[] iArr4 = new int[i11];
        int[][] iArr5 = new int[i11][];
        System.arraycopy(iArr2, 0, iArr4, 0, i11);
        System.arraycopy(iArr, 0, iArr5, 0, i11);
        return new ColorStateList(iArr5, iArr4);
    }

    public static boolean f(Resources resources, int i10) {
        TypedValue c10 = c();
        resources.getValue(i10, c10, true);
        int i11 = c10.type;
        return i11 >= 28 && i11 <= 31;
    }

    public static int g(int i10, float f10) {
        return (i10 & UPnP.CONFIGID_UPNP_ORG_MAX) | (Math.round(Color.alpha(i10) * f10) << 24);
    }

    public static TypedArray h(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }
}
