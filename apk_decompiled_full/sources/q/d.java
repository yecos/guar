package q;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.Base64;
import android.util.TypedValue;
import android.util.Xml;
import androidx.core.R$styleable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public abstract class d {

    public interface a {
    }

    public static final class b implements a {

        /* renamed from: a, reason: collision with root package name */
        public final c[] f18078a;

        public b(c[] cVarArr) {
            this.f18078a = cVarArr;
        }

        public c[] a() {
            return this.f18078a;
        }
    }

    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final String f18079a;

        /* renamed from: b, reason: collision with root package name */
        public int f18080b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f18081c;

        /* renamed from: d, reason: collision with root package name */
        public String f18082d;

        /* renamed from: e, reason: collision with root package name */
        public int f18083e;

        /* renamed from: f, reason: collision with root package name */
        public int f18084f;

        public c(String str, int i10, boolean z10, String str2, int i11, int i12) {
            this.f18079a = str;
            this.f18080b = i10;
            this.f18081c = z10;
            this.f18082d = str2;
            this.f18083e = i11;
            this.f18084f = i12;
        }

        public String a() {
            return this.f18079a;
        }

        public int b() {
            return this.f18084f;
        }

        public int c() {
            return this.f18083e;
        }

        public String d() {
            return this.f18082d;
        }

        public int e() {
            return this.f18080b;
        }

        public boolean f() {
            return this.f18081c;
        }
    }

    /* renamed from: q.d$d, reason: collision with other inner class name */
    public static final class C0311d implements a {

        /* renamed from: a, reason: collision with root package name */
        public final y.d f18085a;

        /* renamed from: b, reason: collision with root package name */
        public final int f18086b;

        /* renamed from: c, reason: collision with root package name */
        public final int f18087c;

        /* renamed from: d, reason: collision with root package name */
        public final String f18088d;

        public C0311d(y.d dVar, int i10, int i11, String str) {
            this.f18085a = dVar;
            this.f18087c = i10;
            this.f18086b = i11;
            this.f18088d = str;
        }

        public int a() {
            return this.f18087c;
        }

        public y.d b() {
            return this.f18085a;
        }

        public String c() {
            return this.f18088d;
        }

        public int d() {
            return this.f18086b;
        }
    }

    public static int a(TypedArray typedArray, int i10) {
        int type;
        if (Build.VERSION.SDK_INT >= 21) {
            type = typedArray.getType(i10);
            return type;
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i10, typedValue);
        return typedValue.type;
    }

    public static a b(XmlPullParser xmlPullParser, Resources resources) {
        int next;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return d(xmlPullParser, resources);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static List c(Resources resources, int i10) {
        if (i10 == 0) {
            return Collections.emptyList();
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i10);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (a(obtainTypedArray, 0) == 1) {
                for (int i11 = 0; i11 < obtainTypedArray.length(); i11++) {
                    int resourceId = obtainTypedArray.getResourceId(i11, 0);
                    if (resourceId != 0) {
                        arrayList.add(h(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(h(resources.getStringArray(i10)));
            }
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }

    public static a d(XmlPullParser xmlPullParser, Resources resources) {
        xmlPullParser.require(2, null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return e(xmlPullParser, resources);
        }
        g(xmlPullParser);
        return null;
    }

    public static a e(XmlPullParser xmlPullParser, Resources resources) {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.f2011c);
        String string = obtainAttributes.getString(R$styleable.FontFamily_fontProviderAuthority);
        String string2 = obtainAttributes.getString(R$styleable.FontFamily_fontProviderPackage);
        String string3 = obtainAttributes.getString(R$styleable.FontFamily_fontProviderQuery);
        int resourceId = obtainAttributes.getResourceId(R$styleable.FontFamily_fontProviderCerts, 0);
        int integer = obtainAttributes.getInteger(R$styleable.FontFamily_fontProviderFetchStrategy, 1);
        int integer2 = obtainAttributes.getInteger(R$styleable.FontFamily_fontProviderFetchTimeout, 500);
        String string4 = obtainAttributes.getString(R$styleable.FontFamily_fontProviderSystemFontFamily);
        obtainAttributes.recycle();
        if (string != null && string2 != null && string3 != null) {
            while (xmlPullParser.next() != 3) {
                g(xmlPullParser);
            }
            return new C0311d(new y.d(string, string2, string3, c(resources, resourceId)), integer, integer2, string4);
        }
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != 3) {
            if (xmlPullParser.getEventType() == 2) {
                if (xmlPullParser.getName().equals("font")) {
                    arrayList.add(f(xmlPullParser, resources));
                } else {
                    g(xmlPullParser);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new b((c[]) arrayList.toArray(new c[arrayList.size()]));
    }

    public static c f(XmlPullParser xmlPullParser, Resources resources) {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), R$styleable.f2012d);
        int i10 = R$styleable.FontFamilyFont_fontWeight;
        if (!obtainAttributes.hasValue(i10)) {
            i10 = R$styleable.FontFamilyFont_android_fontWeight;
        }
        int i11 = obtainAttributes.getInt(i10, 400);
        int i12 = R$styleable.FontFamilyFont_fontStyle;
        if (!obtainAttributes.hasValue(i12)) {
            i12 = R$styleable.FontFamilyFont_android_fontStyle;
        }
        boolean z10 = 1 == obtainAttributes.getInt(i12, 0);
        int i13 = R$styleable.FontFamilyFont_ttcIndex;
        if (!obtainAttributes.hasValue(i13)) {
            i13 = R$styleable.FontFamilyFont_android_ttcIndex;
        }
        int i14 = R$styleable.FontFamilyFont_fontVariationSettings;
        if (!obtainAttributes.hasValue(i14)) {
            i14 = R$styleable.FontFamilyFont_android_fontVariationSettings;
        }
        String string = obtainAttributes.getString(i14);
        int i15 = obtainAttributes.getInt(i13, 0);
        int i16 = R$styleable.FontFamilyFont_font;
        if (!obtainAttributes.hasValue(i16)) {
            i16 = R$styleable.FontFamilyFont_android_font;
        }
        int resourceId = obtainAttributes.getResourceId(i16, 0);
        String string2 = obtainAttributes.getString(i16);
        obtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            g(xmlPullParser);
        }
        return new c(string2, i11, z10, string, i15, resourceId);
    }

    public static void g(XmlPullParser xmlPullParser) {
        int i10 = 1;
        while (i10 > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i10++;
            } else if (next == 3) {
                i10--;
            }
        }
    }

    public static List h(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }
}
