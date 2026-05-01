package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
import y0.b;

/* loaded from: classes.dex */
public class IconCompatParcelizer {
    public static IconCompat read(b bVar) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f2028a = bVar.p(iconCompat.f2028a, 1);
        iconCompat.f2030c = bVar.j(iconCompat.f2030c, 2);
        iconCompat.f2031d = bVar.r(iconCompat.f2031d, 3);
        iconCompat.f2032e = bVar.p(iconCompat.f2032e, 4);
        iconCompat.f2033f = bVar.p(iconCompat.f2033f, 5);
        iconCompat.f2034g = (ColorStateList) bVar.r(iconCompat.f2034g, 6);
        iconCompat.f2036i = bVar.t(iconCompat.f2036i, 7);
        iconCompat.f2037j = bVar.t(iconCompat.f2037j, 8);
        iconCompat.s();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, b bVar) {
        bVar.x(true, true);
        iconCompat.t(bVar.f());
        int i10 = iconCompat.f2028a;
        if (-1 != i10) {
            bVar.F(i10, 1);
        }
        byte[] bArr = iconCompat.f2030c;
        if (bArr != null) {
            bVar.B(bArr, 2);
        }
        Parcelable parcelable = iconCompat.f2031d;
        if (parcelable != null) {
            bVar.H(parcelable, 3);
        }
        int i11 = iconCompat.f2032e;
        if (i11 != 0) {
            bVar.F(i11, 4);
        }
        int i12 = iconCompat.f2033f;
        if (i12 != 0) {
            bVar.F(i12, 5);
        }
        ColorStateList colorStateList = iconCompat.f2034g;
        if (colorStateList != null) {
            bVar.H(colorStateList, 6);
        }
        String str = iconCompat.f2036i;
        if (str != null) {
            bVar.J(str, 7);
        }
        String str2 = iconCompat.f2037j;
        if (str2 != null) {
            bVar.J(str2, 8);
        }
    }
}
