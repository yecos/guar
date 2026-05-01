package q;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final Shader f18075a;

    /* renamed from: b, reason: collision with root package name */
    public final ColorStateList f18076b;

    /* renamed from: c, reason: collision with root package name */
    public int f18077c;

    public b(Shader shader, ColorStateList colorStateList, int i10) {
        this.f18075a = shader;
        this.f18076b = colorStateList;
        this.f18077c = i10;
    }

    public static b a(Resources resources, int i10, Resources.Theme theme) {
        int next;
        XmlResourceParser xml = resources.getXml(i10);
        AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
        do {
            next = xml.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        String name = xml.getName();
        name.hashCode();
        if (name.equals("gradient")) {
            return d(e.b(resources, xml, asAttributeSet, theme));
        }
        if (name.equals("selector")) {
            return c(a.b(resources, xml, asAttributeSet, theme));
        }
        throw new XmlPullParserException(xml.getPositionDescription() + ": unsupported complex color tag " + name);
    }

    public static b b(int i10) {
        return new b(null, null, i10);
    }

    public static b c(ColorStateList colorStateList) {
        return new b(null, colorStateList, colorStateList.getDefaultColor());
    }

    public static b d(Shader shader) {
        return new b(shader, null, 0);
    }

    public static b g(Resources resources, int i10, Resources.Theme theme) {
        try {
            return a(resources, i10, theme);
        } catch (Exception e10) {
            Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", e10);
            return null;
        }
    }

    public int e() {
        return this.f18077c;
    }

    public Shader f() {
        return this.f18075a;
    }

    public boolean h() {
        return this.f18075a != null;
    }

    public boolean i() {
        ColorStateList colorStateList;
        return this.f18075a == null && (colorStateList = this.f18076b) != null && colorStateList.isStateful();
    }

    public boolean j(int[] iArr) {
        if (i()) {
            ColorStateList colorStateList = this.f18076b;
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (colorForState != this.f18077c) {
                this.f18077c = colorForState;
                return true;
            }
        }
        return false;
    }

    public void k(int i10) {
        this.f18077c = i10;
    }

    public boolean l() {
        return h() || this.f18077c != 0;
    }
}
