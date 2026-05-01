package z;

import android.os.Build;
import android.os.LocaleList;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;

/* loaded from: classes.dex */
public abstract class o implements Spannable {

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final TextPaint f20124a;

        /* renamed from: b, reason: collision with root package name */
        public final TextDirectionHeuristic f20125b;

        /* renamed from: c, reason: collision with root package name */
        public final int f20126c;

        /* renamed from: d, reason: collision with root package name */
        public final int f20127d;

        /* renamed from: e, reason: collision with root package name */
        public final PrecomputedText.Params f20128e;

        /* renamed from: z.o$a$a, reason: collision with other inner class name */
        public static class C0349a {

            /* renamed from: a, reason: collision with root package name */
            public final TextPaint f20129a;

            /* renamed from: b, reason: collision with root package name */
            public TextDirectionHeuristic f20130b;

            /* renamed from: c, reason: collision with root package name */
            public int f20131c;

            /* renamed from: d, reason: collision with root package name */
            public int f20132d;

            public C0349a(TextPaint textPaint) {
                this.f20129a = textPaint;
                if (Build.VERSION.SDK_INT >= 23) {
                    this.f20131c = 1;
                    this.f20132d = 1;
                } else {
                    this.f20132d = 0;
                    this.f20131c = 0;
                }
                this.f20130b = TextDirectionHeuristics.FIRSTSTRONG_LTR;
            }

            public a a() {
                return new a(this.f20129a, this.f20130b, this.f20131c, this.f20132d);
            }

            public C0349a b(int i10) {
                this.f20131c = i10;
                return this;
            }

            public C0349a c(int i10) {
                this.f20132d = i10;
                return this;
            }

            public C0349a d(TextDirectionHeuristic textDirectionHeuristic) {
                this.f20130b = textDirectionHeuristic;
                return this;
            }
        }

        public a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i10, int i11) {
            PrecomputedText.Params.Builder breakStrategy;
            PrecomputedText.Params.Builder hyphenationFrequency;
            PrecomputedText.Params.Builder textDirection;
            PrecomputedText.Params build;
            if (Build.VERSION.SDK_INT >= 29) {
                breakStrategy = new PrecomputedText.Params.Builder(textPaint).setBreakStrategy(i10);
                hyphenationFrequency = breakStrategy.setHyphenationFrequency(i11);
                textDirection = hyphenationFrequency.setTextDirection(textDirectionHeuristic);
                build = textDirection.build();
                this.f20128e = build;
            } else {
                this.f20128e = null;
            }
            this.f20124a = textPaint;
            this.f20125b = textDirectionHeuristic;
            this.f20126c = i10;
            this.f20127d = i11;
        }

        public boolean a(a aVar) {
            LocaleList textLocales;
            LocaleList textLocales2;
            boolean equals;
            float letterSpacing;
            float letterSpacing2;
            String fontFeatureSettings;
            String fontFeatureSettings2;
            int i10 = Build.VERSION.SDK_INT;
            if ((i10 >= 23 && (this.f20126c != aVar.b() || this.f20127d != aVar.c())) || this.f20124a.getTextSize() != aVar.e().getTextSize() || this.f20124a.getTextScaleX() != aVar.e().getTextScaleX() || this.f20124a.getTextSkewX() != aVar.e().getTextSkewX()) {
                return false;
            }
            if (i10 >= 21) {
                letterSpacing = this.f20124a.getLetterSpacing();
                letterSpacing2 = aVar.e().getLetterSpacing();
                if (letterSpacing != letterSpacing2) {
                    return false;
                }
                fontFeatureSettings = this.f20124a.getFontFeatureSettings();
                fontFeatureSettings2 = aVar.e().getFontFeatureSettings();
                if (!TextUtils.equals(fontFeatureSettings, fontFeatureSettings2)) {
                    return false;
                }
            }
            if (this.f20124a.getFlags() != aVar.e().getFlags()) {
                return false;
            }
            if (i10 >= 24) {
                textLocales = this.f20124a.getTextLocales();
                textLocales2 = aVar.e().getTextLocales();
                equals = textLocales.equals(textLocales2);
                if (!equals) {
                    return false;
                }
            } else if (!this.f20124a.getTextLocale().equals(aVar.e().getTextLocale())) {
                return false;
            }
            return this.f20124a.getTypeface() == null ? aVar.e().getTypeface() == null : this.f20124a.getTypeface().equals(aVar.e().getTypeface());
        }

        public int b() {
            return this.f20126c;
        }

        public int c() {
            return this.f20127d;
        }

        public TextDirectionHeuristic d() {
            return this.f20125b;
        }

        public TextPaint e() {
            return this.f20124a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return a(aVar) && this.f20125b == aVar.d();
        }

        public int hashCode() {
            float letterSpacing;
            boolean isElegantTextHeight;
            float letterSpacing2;
            LocaleList textLocales;
            boolean isElegantTextHeight2;
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 24) {
                letterSpacing2 = this.f20124a.getLetterSpacing();
                textLocales = this.f20124a.getTextLocales();
                isElegantTextHeight2 = this.f20124a.isElegantTextHeight();
                return a0.c.b(Float.valueOf(this.f20124a.getTextSize()), Float.valueOf(this.f20124a.getTextScaleX()), Float.valueOf(this.f20124a.getTextSkewX()), Float.valueOf(letterSpacing2), Integer.valueOf(this.f20124a.getFlags()), textLocales, this.f20124a.getTypeface(), Boolean.valueOf(isElegantTextHeight2), this.f20125b, Integer.valueOf(this.f20126c), Integer.valueOf(this.f20127d));
            }
            if (i10 < 21) {
                return a0.c.b(Float.valueOf(this.f20124a.getTextSize()), Float.valueOf(this.f20124a.getTextScaleX()), Float.valueOf(this.f20124a.getTextSkewX()), Integer.valueOf(this.f20124a.getFlags()), this.f20124a.getTextLocale(), this.f20124a.getTypeface(), this.f20125b, Integer.valueOf(this.f20126c), Integer.valueOf(this.f20127d));
            }
            letterSpacing = this.f20124a.getLetterSpacing();
            isElegantTextHeight = this.f20124a.isElegantTextHeight();
            return a0.c.b(Float.valueOf(this.f20124a.getTextSize()), Float.valueOf(this.f20124a.getTextScaleX()), Float.valueOf(this.f20124a.getTextSkewX()), Float.valueOf(letterSpacing), Integer.valueOf(this.f20124a.getFlags()), this.f20124a.getTextLocale(), this.f20124a.getTypeface(), Boolean.valueOf(isElegantTextHeight), this.f20125b, Integer.valueOf(this.f20126c), Integer.valueOf(this.f20127d));
        }

        public String toString() {
            String fontVariationSettings;
            LocaleList textLocales;
            float letterSpacing;
            boolean isElegantTextHeight;
            StringBuilder sb = new StringBuilder("{");
            sb.append("textSize=" + this.f20124a.getTextSize());
            sb.append(", textScaleX=" + this.f20124a.getTextScaleX());
            sb.append(", textSkewX=" + this.f20124a.getTextSkewX());
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 21) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(", letterSpacing=");
                letterSpacing = this.f20124a.getLetterSpacing();
                sb2.append(letterSpacing);
                sb.append(sb2.toString());
                StringBuilder sb3 = new StringBuilder();
                sb3.append(", elegantTextHeight=");
                isElegantTextHeight = this.f20124a.isElegantTextHeight();
                sb3.append(isElegantTextHeight);
                sb.append(sb3.toString());
            }
            if (i10 >= 24) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append(", textLocale=");
                textLocales = this.f20124a.getTextLocales();
                sb4.append(textLocales);
                sb.append(sb4.toString());
            } else {
                sb.append(", textLocale=" + this.f20124a.getTextLocale());
            }
            sb.append(", typeface=" + this.f20124a.getTypeface());
            if (i10 >= 26) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(", variationSettings=");
                fontVariationSettings = this.f20124a.getFontVariationSettings();
                sb5.append(fontVariationSettings);
                sb.append(sb5.toString());
            }
            sb.append(", textDir=" + this.f20125b);
            sb.append(", breakStrategy=" + this.f20126c);
            sb.append(", hyphenationFrequency=" + this.f20127d);
            sb.append("}");
            return sb.toString();
        }

        public a(PrecomputedText.Params params) {
            TextPaint textPaint;
            TextDirectionHeuristic textDirection;
            int breakStrategy;
            int hyphenationFrequency;
            textPaint = params.getTextPaint();
            this.f20124a = textPaint;
            textDirection = params.getTextDirection();
            this.f20125b = textDirection;
            breakStrategy = params.getBreakStrategy();
            this.f20126c = breakStrategy;
            hyphenationFrequency = params.getHyphenationFrequency();
            this.f20127d = hyphenationFrequency;
            this.f20128e = Build.VERSION.SDK_INT < 29 ? null : params;
        }
    }
}
