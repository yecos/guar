package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import com.uc.crashsdk.export.LogType;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class e1 {

    /* renamed from: k, reason: collision with root package name */
    public static final RectF f1471k = new RectF();

    /* renamed from: l, reason: collision with root package name */
    public static ConcurrentHashMap f1472l = new ConcurrentHashMap();

    /* renamed from: m, reason: collision with root package name */
    public static ConcurrentHashMap f1473m = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    public int f1474a = 0;

    /* renamed from: b, reason: collision with root package name */
    public boolean f1475b = false;

    /* renamed from: c, reason: collision with root package name */
    public float f1476c = -1.0f;

    /* renamed from: d, reason: collision with root package name */
    public float f1477d = -1.0f;

    /* renamed from: e, reason: collision with root package name */
    public float f1478e = -1.0f;

    /* renamed from: f, reason: collision with root package name */
    public int[] f1479f = new int[0];

    /* renamed from: g, reason: collision with root package name */
    public boolean f1480g = false;

    /* renamed from: h, reason: collision with root package name */
    public TextPaint f1481h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f1482i;

    /* renamed from: j, reason: collision with root package name */
    public final Context f1483j;

    public e1(TextView textView) {
        this.f1482i = textView;
        this.f1483j = textView.getContext();
    }

    public static Method m(String str) {
        try {
            Method method = (Method) f1472l.get(str);
            if (method == null && (method = TextView.class.getDeclaredMethod(str, new Class[0])) != null) {
                method.setAccessible(true);
                f1472l.put(str, method);
            }
            return method;
        } catch (Exception unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to retrieve TextView#");
            sb.append(str);
            sb.append("() method");
            return null;
        }
    }

    public static Object o(Object obj, String str, Object obj2) {
        try {
            return m(str).invoke(obj, new Object[0]);
        } catch (Exception unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("Failed to invoke TextView#");
            sb.append(str);
            sb.append("() method");
            return obj2;
        }
    }

    public final boolean A() {
        return !(this.f1482i instanceof l);
    }

    public final void B(float f10, float f11, float f12) {
        if (f10 <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f10 + "px) is less or equal to (0px)");
        }
        if (f11 <= f10) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f11 + "px) is less or equal to minimum auto-size text size (" + f10 + "px)");
        }
        if (f12 <= 0.0f) {
            throw new IllegalArgumentException("The auto-size step granularity (" + f12 + "px) is less or equal to (0px)");
        }
        this.f1474a = 1;
        this.f1477d = f10;
        this.f1478e = f11;
        this.f1476c = f12;
        this.f1480g = false;
    }

    public void a() {
        if (p()) {
            if (this.f1475b) {
                if (this.f1482i.getMeasuredHeight() <= 0 || this.f1482i.getMeasuredWidth() <= 0) {
                    return;
                }
                int measuredWidth = Build.VERSION.SDK_INT >= 29 ? this.f1482i.isHorizontallyScrollable() : ((Boolean) o(this.f1482i, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue() ? LogType.ANR : (this.f1482i.getMeasuredWidth() - this.f1482i.getTotalPaddingLeft()) - this.f1482i.getTotalPaddingRight();
                int height = (this.f1482i.getHeight() - this.f1482i.getCompoundPaddingBottom()) - this.f1482i.getCompoundPaddingTop();
                if (measuredWidth <= 0 || height <= 0) {
                    return;
                }
                RectF rectF = f1471k;
                synchronized (rectF) {
                    rectF.setEmpty();
                    rectF.right = measuredWidth;
                    rectF.bottom = height;
                    float g10 = g(rectF);
                    if (g10 != this.f1482i.getTextSize()) {
                        v(0, g10);
                    }
                }
            }
            this.f1475b = true;
        }
    }

    public final int[] b(int[] iArr) {
        int length = iArr.length;
        if (length == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i10 : iArr) {
            if (i10 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i10)) < 0) {
                arrayList.add(Integer.valueOf(i10));
            }
        }
        if (length == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i11 = 0; i11 < size; i11++) {
            iArr2[i11] = ((Integer) arrayList.get(i11)).intValue();
        }
        return iArr2;
    }

    public final void c() {
        this.f1474a = 0;
        this.f1477d = -1.0f;
        this.f1478e = -1.0f;
        this.f1476c = -1.0f;
        this.f1479f = new int[0];
        this.f1475b = false;
    }

    public StaticLayout d(CharSequence charSequence, Layout.Alignment alignment, int i10, int i11) {
        return Build.VERSION.SDK_INT >= 23 ? e(charSequence, alignment, i10, i11) : f(charSequence, alignment, i10);
    }

    public final StaticLayout e(CharSequence charSequence, Layout.Alignment alignment, int i10, int i11) {
        StaticLayout.Builder obtain;
        StaticLayout.Builder alignment2;
        StaticLayout.Builder lineSpacing;
        StaticLayout.Builder includePad;
        int breakStrategy;
        StaticLayout.Builder breakStrategy2;
        int hyphenationFrequency;
        StaticLayout.Builder hyphenationFrequency2;
        StaticLayout build;
        obtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), this.f1481h, i10);
        alignment2 = obtain.setAlignment(alignment);
        lineSpacing = alignment2.setLineSpacing(this.f1482i.getLineSpacingExtra(), this.f1482i.getLineSpacingMultiplier());
        includePad = lineSpacing.setIncludePad(this.f1482i.getIncludeFontPadding());
        breakStrategy = this.f1482i.getBreakStrategy();
        breakStrategy2 = includePad.setBreakStrategy(breakStrategy);
        hyphenationFrequency = this.f1482i.getHyphenationFrequency();
        hyphenationFrequency2 = breakStrategy2.setHyphenationFrequency(hyphenationFrequency);
        if (i11 == -1) {
            i11 = Integer.MAX_VALUE;
        }
        hyphenationFrequency2.setMaxLines(i11);
        try {
            obtain.setTextDirection(Build.VERSION.SDK_INT >= 29 ? this.f1482i.getTextDirectionHeuristic() : (TextDirectionHeuristic) o(this.f1482i, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
        } catch (ClassCastException unused) {
        }
        build = obtain.build();
        return build;
    }

    public final StaticLayout f(CharSequence charSequence, Layout.Alignment alignment, int i10) {
        return new StaticLayout(charSequence, this.f1481h, i10, alignment, this.f1482i.getLineSpacingMultiplier(), this.f1482i.getLineSpacingExtra(), this.f1482i.getIncludeFontPadding());
    }

    public final int g(RectF rectF) {
        int length = this.f1479f.length;
        if (length == 0) {
            throw new IllegalStateException("No available text sizes to choose from.");
        }
        int i10 = 1;
        int i11 = length - 1;
        int i12 = 0;
        while (i10 <= i11) {
            int i13 = (i10 + i11) / 2;
            if (z(this.f1479f[i13], rectF)) {
                int i14 = i13 + 1;
                i12 = i10;
                i10 = i14;
            } else {
                i12 = i13 - 1;
                i11 = i12;
            }
        }
        return this.f1479f[i12];
    }

    public int h() {
        return Math.round(this.f1478e);
    }

    public int i() {
        return Math.round(this.f1477d);
    }

    public int j() {
        return Math.round(this.f1476c);
    }

    public int[] k() {
        return this.f1479f;
    }

    public int l() {
        return this.f1474a;
    }

    public void n(int i10) {
        TextPaint textPaint = this.f1481h;
        if (textPaint == null) {
            this.f1481h = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.f1481h.set(this.f1482i.getPaint());
        this.f1481h.setTextSize(i10);
    }

    public boolean p() {
        return A() && this.f1474a != 0;
    }

    public void q(AttributeSet attributeSet, int i10) {
        int resourceId;
        TypedArray obtainStyledAttributes = this.f1483j.obtainStyledAttributes(attributeSet, R$styleable.f816n, i10, 0);
        int i11 = R$styleable.AppCompatTextView_autoSizeTextType;
        if (obtainStyledAttributes.hasValue(i11)) {
            this.f1474a = obtainStyledAttributes.getInt(i11, 0);
        }
        int i12 = R$styleable.AppCompatTextView_autoSizeStepGranularity;
        float dimension = obtainStyledAttributes.hasValue(i12) ? obtainStyledAttributes.getDimension(i12, -1.0f) : -1.0f;
        int i13 = R$styleable.AppCompatTextView_autoSizeMinTextSize;
        float dimension2 = obtainStyledAttributes.hasValue(i13) ? obtainStyledAttributes.getDimension(i13, -1.0f) : -1.0f;
        int i14 = R$styleable.AppCompatTextView_autoSizeMaxTextSize;
        float dimension3 = obtainStyledAttributes.hasValue(i14) ? obtainStyledAttributes.getDimension(i14, -1.0f) : -1.0f;
        int i15 = R$styleable.AppCompatTextView_autoSizePresetSizes;
        if (obtainStyledAttributes.hasValue(i15) && (resourceId = obtainStyledAttributes.getResourceId(i15, 0)) > 0) {
            TypedArray obtainTypedArray = obtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            x(obtainTypedArray);
            obtainTypedArray.recycle();
        }
        obtainStyledAttributes.recycle();
        if (!A()) {
            this.f1474a = 0;
            return;
        }
        if (this.f1474a == 1) {
            if (!this.f1480g) {
                DisplayMetrics displayMetrics = this.f1483j.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                B(dimension2, dimension3, dimension);
            }
            w();
        }
    }

    public void r(int i10, int i11, int i12, int i13) {
        if (A()) {
            DisplayMetrics displayMetrics = this.f1483j.getResources().getDisplayMetrics();
            B(TypedValue.applyDimension(i13, i10, displayMetrics), TypedValue.applyDimension(i13, i11, displayMetrics), TypedValue.applyDimension(i13, i12, displayMetrics));
            if (w()) {
                a();
            }
        }
    }

    public void s(int[] iArr, int i10) {
        if (A()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i10 == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.f1483j.getResources().getDisplayMetrics();
                    for (int i11 = 0; i11 < length; i11++) {
                        iArr2[i11] = Math.round(TypedValue.applyDimension(i10, iArr[i11], displayMetrics));
                    }
                }
                this.f1479f = b(iArr2);
                if (!y()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.f1480g = false;
            }
            if (w()) {
                a();
            }
        }
    }

    public void t(int i10) {
        if (A()) {
            if (i10 == 0) {
                c();
                return;
            }
            if (i10 != 1) {
                throw new IllegalArgumentException("Unknown auto-size text type: " + i10);
            }
            DisplayMetrics displayMetrics = this.f1483j.getResources().getDisplayMetrics();
            B(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
            if (w()) {
                a();
            }
        }
    }

    public final void u(float f10) {
        if (f10 != this.f1482i.getPaint().getTextSize()) {
            this.f1482i.getPaint().setTextSize(f10);
            boolean isInLayout = this.f1482i.isInLayout();
            if (this.f1482i.getLayout() != null) {
                this.f1475b = false;
                try {
                    Method m10 = m("nullLayouts");
                    if (m10 != null) {
                        m10.invoke(this.f1482i, new Object[0]);
                    }
                } catch (Exception unused) {
                }
                if (isInLayout) {
                    this.f1482i.forceLayout();
                } else {
                    this.f1482i.requestLayout();
                }
                this.f1482i.invalidate();
            }
        }
    }

    public void v(int i10, float f10) {
        Context context = this.f1483j;
        u(TypedValue.applyDimension(i10, f10, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics()));
    }

    public final boolean w() {
        if (A() && this.f1474a == 1) {
            if (!this.f1480g || this.f1479f.length == 0) {
                int floor = ((int) Math.floor((this.f1478e - this.f1477d) / this.f1476c)) + 1;
                int[] iArr = new int[floor];
                for (int i10 = 0; i10 < floor; i10++) {
                    iArr[i10] = Math.round(this.f1477d + (i10 * this.f1476c));
                }
                this.f1479f = b(iArr);
            }
            this.f1475b = true;
        } else {
            this.f1475b = false;
        }
        return this.f1475b;
    }

    public final void x(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i10 = 0; i10 < length; i10++) {
                iArr[i10] = typedArray.getDimensionPixelSize(i10, -1);
            }
            this.f1479f = b(iArr);
            y();
        }
    }

    public final boolean y() {
        boolean z10 = this.f1479f.length > 0;
        this.f1480g = z10;
        if (z10) {
            this.f1474a = 1;
            this.f1477d = r0[0];
            this.f1478e = r0[r1 - 1];
            this.f1476c = -1.0f;
        }
        return z10;
    }

    public final boolean z(int i10, RectF rectF) {
        CharSequence transformation;
        CharSequence text = this.f1482i.getText();
        TransformationMethod transformationMethod = this.f1482i.getTransformationMethod();
        if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, this.f1482i)) != null) {
            text = transformation;
        }
        int maxLines = this.f1482i.getMaxLines();
        n(i10);
        StaticLayout d10 = d(text, (Layout.Alignment) o(this.f1482i, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), maxLines);
        return (maxLines == -1 || (d10.getLineCount() <= maxLines && d10.getLineEnd(d10.getLineCount() - 1) == text.length())) && ((float) d10.getHeight()) <= rectF.bottom;
    }
}
