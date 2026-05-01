package org.simpleframework.xml.transform;

import java.util.Locale;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
class LocaleTransform implements Transform<Locale> {
    private final Pattern pattern = Pattern.compile("_");

    @Override // org.simpleframework.xml.transform.Transform
    public Locale read(String str) {
        String[] split = this.pattern.split(str);
        if (split.length >= 1) {
            return read(split);
        }
        throw new InvalidFormatException("Invalid locale %s", str);
    }

    @Override // org.simpleframework.xml.transform.Transform
    public String write(Locale locale) {
        return locale.toString();
    }

    private Locale read(String[] strArr) {
        String[] strArr2 = {"", "", ""};
        for (int i10 = 0; i10 < 3; i10++) {
            if (i10 < strArr.length) {
                strArr2[i10] = strArr[i10];
            }
        }
        return new Locale(strArr2[0], strArr2[1], strArr2[2]);
    }
}
