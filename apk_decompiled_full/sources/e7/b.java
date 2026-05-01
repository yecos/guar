package e7;

import com.google.zxing.BarcodeFormat;
import java.util.Vector;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final Pattern f12942a = Pattern.compile(",");

    /* renamed from: b, reason: collision with root package name */
    public static final Vector f12943b;

    /* renamed from: c, reason: collision with root package name */
    public static final Vector f12944c;

    /* renamed from: d, reason: collision with root package name */
    public static final Vector f12945d;

    /* renamed from: e, reason: collision with root package name */
    public static final Vector f12946e;

    static {
        Vector vector = new Vector(5);
        f12943b = vector;
        vector.add(BarcodeFormat.UPC_A);
        vector.add(BarcodeFormat.UPC_E);
        vector.add(BarcodeFormat.EAN_13);
        vector.add(BarcodeFormat.EAN_8);
        Vector vector2 = new Vector(vector.size() + 4);
        f12944c = vector2;
        vector2.addAll(vector);
        vector2.add(BarcodeFormat.CODE_39);
        vector2.add(BarcodeFormat.CODE_93);
        vector2.add(BarcodeFormat.CODE_128);
        vector2.add(BarcodeFormat.ITF);
        Vector vector3 = new Vector(1);
        f12945d = vector3;
        vector3.add(BarcodeFormat.QR_CODE);
        Vector vector4 = new Vector(1);
        f12946e = vector4;
        vector4.add(BarcodeFormat.DATA_MATRIX);
    }
}
