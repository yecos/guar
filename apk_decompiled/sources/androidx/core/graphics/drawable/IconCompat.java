package androidx.core.graphics.drawable;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import com.hpplay.cybergarage.soap.SOAP;
import com.mobile.brasiltv.view.RoundedDrawable;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import s.h;
import s.i;

/* loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* renamed from: k, reason: collision with root package name */
    public static final PorterDuff.Mode f2027k = PorterDuff.Mode.SRC_IN;

    /* renamed from: a, reason: collision with root package name */
    public int f2028a;

    /* renamed from: b, reason: collision with root package name */
    public Object f2029b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f2030c;

    /* renamed from: d, reason: collision with root package name */
    public Parcelable f2031d;

    /* renamed from: e, reason: collision with root package name */
    public int f2032e;

    /* renamed from: f, reason: collision with root package name */
    public int f2033f;

    /* renamed from: g, reason: collision with root package name */
    public ColorStateList f2034g;

    /* renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f2035h;

    /* renamed from: i, reason: collision with root package name */
    public String f2036i;

    /* renamed from: j, reason: collision with root package name */
    public String f2037j;

    public IconCompat() {
        this.f2028a = -1;
        this.f2030c = null;
        this.f2031d = null;
        this.f2032e = 0;
        this.f2033f = 0;
        this.f2034g = null;
        this.f2035h = f2027k;
        this.f2036i = null;
    }

    public static Bitmap b(Bitmap bitmap, boolean z10) {
        int min = (int) (Math.min(bitmap.getWidth(), bitmap.getHeight()) * 0.6666667f);
        Bitmap createBitmap = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(3);
        float f10 = min;
        float f11 = 0.5f * f10;
        float f12 = 0.9166667f * f11;
        if (z10) {
            float f13 = 0.010416667f * f10;
            paint.setColor(0);
            paint.setShadowLayer(f13, 0.0f, f10 * 0.020833334f, 1023410176);
            canvas.drawCircle(f11, f11, f12, paint);
            paint.setShadowLayer(f13, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f11, f11, f12, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(RoundedDrawable.DEFAULT_BORDER_COLOR);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate((-(bitmap.getWidth() - min)) / 2, (-(bitmap.getHeight() - min)) / 2);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f11, f11, f12, paint);
        canvas.setBitmap(null);
        return createBitmap;
    }

    public static IconCompat c(Bitmap bitmap) {
        if (bitmap == null) {
            throw new IllegalArgumentException("Bitmap must not be null.");
        }
        IconCompat iconCompat = new IconCompat(1);
        iconCompat.f2029b = bitmap;
        return iconCompat;
    }

    public static IconCompat d(Context context, int i10) {
        if (context != null) {
            return e(context.getResources(), context.getPackageName(), i10);
        }
        throw new IllegalArgumentException("Context must not be null.");
    }

    public static IconCompat e(Resources resources, String str, int i10) {
        if (str == null) {
            throw new IllegalArgumentException("Package must not be null.");
        }
        if (i10 == 0) {
            throw new IllegalArgumentException("Drawable resource ID must not be 0");
        }
        IconCompat iconCompat = new IconCompat(2);
        iconCompat.f2032e = i10;
        if (resources != null) {
            try {
                iconCompat.f2029b = resources.getResourceName(i10);
            } catch (Resources.NotFoundException unused) {
                throw new IllegalArgumentException("Icon resource cannot be found");
            }
        } else {
            iconCompat.f2029b = str;
        }
        iconCompat.f2037j = str;
        return iconCompat;
    }

    public static int h(Icon icon) {
        int resId;
        if (Build.VERSION.SDK_INT >= 28) {
            resId = icon.getResId();
            return resId;
        }
        try {
            return ((Integer) icon.getClass().getMethod("getResId", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException e10) {
            Log.e("IconCompat", "Unable to get icon resource", e10);
            return 0;
        } catch (NoSuchMethodException e11) {
            Log.e("IconCompat", "Unable to get icon resource", e11);
            return 0;
        } catch (InvocationTargetException e12) {
            Log.e("IconCompat", "Unable to get icon resource", e12);
            return 0;
        }
    }

    public static String j(Icon icon) {
        String resPackage;
        if (Build.VERSION.SDK_INT >= 28) {
            resPackage = icon.getResPackage();
            return resPackage;
        }
        try {
            return (String) icon.getClass().getMethod("getResPackage", new Class[0]).invoke(icon, new Object[0]);
        } catch (IllegalAccessException e10) {
            Log.e("IconCompat", "Unable to get icon package", e10);
            return null;
        } catch (NoSuchMethodException e11) {
            Log.e("IconCompat", "Unable to get icon package", e11);
            return null;
        } catch (InvocationTargetException e12) {
            Log.e("IconCompat", "Unable to get icon package", e12);
            return null;
        }
    }

    public static Resources k(Context context, String str) {
        if ("android".equals(str)) {
            return Resources.getSystem();
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 8192);
            if (applicationInfo != null) {
                return packageManager.getResourcesForApplication(applicationInfo);
            }
            return null;
        } catch (PackageManager.NameNotFoundException e10) {
            Log.e("IconCompat", String.format("Unable to find pkg=%s for icon", str), e10);
            return null;
        }
    }

    public static int m(Icon icon) {
        int type;
        if (Build.VERSION.SDK_INT >= 28) {
            type = icon.getType();
            return type;
        }
        try {
            return ((Integer) icon.getClass().getMethod("getType", new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException e10) {
            Log.e("IconCompat", "Unable to get icon type " + icon, e10);
            return -1;
        } catch (NoSuchMethodException e11) {
            Log.e("IconCompat", "Unable to get icon type " + icon, e11);
            return -1;
        } catch (InvocationTargetException e12) {
            Log.e("IconCompat", "Unable to get icon type " + icon, e12);
            return -1;
        }
    }

    public static Uri o(Icon icon) {
        Uri uri;
        if (Build.VERSION.SDK_INT >= 28) {
            uri = icon.getUri();
            return uri;
        }
        try {
            return (Uri) icon.getClass().getMethod("getUri", new Class[0]).invoke(icon, new Object[0]);
        } catch (IllegalAccessException e10) {
            Log.e("IconCompat", "Unable to get icon uri", e10);
            return null;
        } catch (NoSuchMethodException e11) {
            Log.e("IconCompat", "Unable to get icon uri", e11);
            return null;
        } catch (InvocationTargetException e12) {
            Log.e("IconCompat", "Unable to get icon uri", e12);
            return null;
        }
    }

    public static String w(int i10) {
        switch (i10) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return "DATA";
            case 4:
                return "URI";
            case 5:
                return "BITMAP_MASKABLE";
            case 6:
                return "URI_MASKABLE";
            default:
                return "UNKNOWN";
        }
    }

    public void a(Context context) {
        Object obj;
        if (this.f2028a != 2 || (obj = this.f2029b) == null) {
            return;
        }
        String str = (String) obj;
        if (str.contains(SOAP.DELIM)) {
            String str2 = str.split(SOAP.DELIM, -1)[1];
            String str3 = str2.split(Operator.Operation.DIVISION, -1)[0];
            String str4 = str2.split(Operator.Operation.DIVISION, -1)[1];
            String str5 = str.split(SOAP.DELIM, -1)[0];
            if ("0_resource_name_obfuscated".equals(str4)) {
                return;
            }
            String i10 = i();
            int identifier = k(context, i10).getIdentifier(str4, str3, str5);
            if (this.f2032e != identifier) {
                StringBuilder sb = new StringBuilder();
                sb.append("Id has changed for ");
                sb.append(i10);
                sb.append(" ");
                sb.append(str);
                this.f2032e = identifier;
            }
        }
    }

    public Bitmap f() {
        int i10 = this.f2028a;
        if (i10 == -1 && Build.VERSION.SDK_INT >= 23) {
            Object obj = this.f2029b;
            if (obj instanceof Bitmap) {
                return (Bitmap) obj;
            }
            return null;
        }
        if (i10 == 1) {
            return (Bitmap) this.f2029b;
        }
        if (i10 == 5) {
            return b((Bitmap) this.f2029b, true);
        }
        throw new IllegalStateException("called getBitmap() on " + this);
    }

    public int g() {
        int i10 = this.f2028a;
        if (i10 == -1 && Build.VERSION.SDK_INT >= 23) {
            return h(i.a(this.f2029b));
        }
        if (i10 == 2) {
            return this.f2032e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    public String i() {
        int i10 = this.f2028a;
        if (i10 == -1 && Build.VERSION.SDK_INT >= 23) {
            return j(i.a(this.f2029b));
        }
        if (i10 == 2) {
            return TextUtils.isEmpty(this.f2037j) ? ((String) this.f2029b).split(SOAP.DELIM, -1)[0] : this.f2037j;
        }
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    public int l() {
        int i10 = this.f2028a;
        return (i10 != -1 || Build.VERSION.SDK_INT < 23) ? i10 : m(i.a(this.f2029b));
    }

    public Uri n() {
        int i10 = this.f2028a;
        if (i10 == -1 && Build.VERSION.SDK_INT >= 23) {
            return o(i.a(this.f2029b));
        }
        if (i10 == 4 || i10 == 6) {
            return Uri.parse((String) this.f2029b);
        }
        throw new IllegalStateException("called getUri() on " + this);
    }

    public InputStream p(Context context) {
        Uri n10 = n();
        String scheme = n10.getScheme();
        if ("content".equals(scheme) || "file".equals(scheme)) {
            try {
                return context.getContentResolver().openInputStream(n10);
            } catch (Exception unused) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unable to load image from URI: ");
                sb.append(n10);
                return null;
            }
        }
        try {
            return new FileInputStream(new File((String) this.f2029b));
        } catch (FileNotFoundException unused2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unable to load image from path: ");
            sb2.append(n10);
            return null;
        }
    }

    public Drawable q(Context context) {
        Drawable loadDrawable;
        a(context);
        if (Build.VERSION.SDK_INT >= 23) {
            loadDrawable = v(context).loadDrawable(context);
            return loadDrawable;
        }
        Drawable r10 = r(context);
        if (r10 != null && (this.f2034g != null || this.f2035h != f2027k)) {
            r10.mutate();
            h.o(r10, this.f2034g);
            h.p(r10, this.f2035h);
        }
        return r10;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final Drawable r(Context context) {
        switch (this.f2028a) {
            case 1:
                return new BitmapDrawable(context.getResources(), (Bitmap) this.f2029b);
            case 2:
                String i10 = i();
                if (TextUtils.isEmpty(i10)) {
                    i10 = context.getPackageName();
                }
                try {
                    return q.h.d(k(context, i10), this.f2032e, context.getTheme());
                } catch (RuntimeException e10) {
                    Log.e("IconCompat", String.format("Unable to load resource 0x%08x from pkg=%s", Integer.valueOf(this.f2032e), this.f2029b), e10);
                    break;
                }
            case 3:
                return new BitmapDrawable(context.getResources(), BitmapFactory.decodeByteArray((byte[]) this.f2029b, this.f2032e, this.f2033f));
            case 4:
                InputStream p10 = p(context);
                if (p10 != null) {
                    return new BitmapDrawable(context.getResources(), BitmapFactory.decodeStream(p10));
                }
                return null;
            case 5:
                return new BitmapDrawable(context.getResources(), b((Bitmap) this.f2029b, false));
            case 6:
                InputStream p11 = p(context);
                if (p11 != null) {
                    return Build.VERSION.SDK_INT >= 26 ? new AdaptiveIconDrawable(null, new BitmapDrawable(context.getResources(), BitmapFactory.decodeStream(p11))) : new BitmapDrawable(context.getResources(), b(BitmapFactory.decodeStream(p11), false));
                }
                return null;
            default:
                return null;
        }
    }

    public void s() {
        this.f2035h = PorterDuff.Mode.valueOf(this.f2036i);
        switch (this.f2028a) {
            case -1:
                Parcelable parcelable = this.f2031d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                this.f2029b = parcelable;
                return;
            case 0:
            default:
                return;
            case 1:
            case 5:
                Parcelable parcelable2 = this.f2031d;
                if (parcelable2 != null) {
                    this.f2029b = parcelable2;
                    return;
                }
                byte[] bArr = this.f2030c;
                this.f2029b = bArr;
                this.f2028a = 3;
                this.f2032e = 0;
                this.f2033f = bArr.length;
                return;
            case 2:
            case 4:
            case 6:
                String str = new String(this.f2030c, Charset.forName("UTF-16"));
                this.f2029b = str;
                if (this.f2028a == 2 && this.f2037j == null) {
                    this.f2037j = str.split(SOAP.DELIM, -1)[0];
                    return;
                }
                return;
            case 3:
                this.f2029b = this.f2030c;
                return;
        }
    }

    public void t(boolean z10) {
        this.f2036i = this.f2035h.name();
        switch (this.f2028a) {
            case -1:
                if (z10) {
                    throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
                }
                this.f2031d = (Parcelable) this.f2029b;
                return;
            case 0:
            default:
                return;
            case 1:
            case 5:
                if (!z10) {
                    this.f2031d = (Parcelable) this.f2029b;
                    return;
                }
                Bitmap bitmap = (Bitmap) this.f2029b;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                this.f2030c = byteArrayOutputStream.toByteArray();
                return;
            case 2:
                this.f2030c = ((String) this.f2029b).getBytes(Charset.forName("UTF-16"));
                return;
            case 3:
                this.f2030c = (byte[]) this.f2029b;
                return;
            case 4:
            case 6:
                this.f2030c = this.f2029b.toString().getBytes(Charset.forName("UTF-16"));
                return;
        }
    }

    public String toString() {
        if (this.f2028a == -1) {
            return String.valueOf(this.f2029b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        sb.append(w(this.f2028a));
        switch (this.f2028a) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.f2029b).getWidth());
                sb.append("x");
                sb.append(((Bitmap) this.f2029b).getHeight());
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.f2037j);
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(g())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.f2032e);
                if (this.f2033f != 0) {
                    sb.append(" off=");
                    sb.append(this.f2033f);
                    break;
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.f2029b);
                break;
        }
        if (this.f2034g != null) {
            sb.append(" tint=");
            sb.append(this.f2034g);
        }
        if (this.f2035h != f2027k) {
            sb.append(" mode=");
            sb.append(this.f2035h);
        }
        sb.append(")");
        return sb.toString();
    }

    public Icon u() {
        return v(null);
    }

    public Icon v(Context context) {
        Icon createWithBitmap;
        switch (this.f2028a) {
            case -1:
                return i.a(this.f2029b);
            case 0:
            default:
                throw new IllegalArgumentException("Unknown type");
            case 1:
                createWithBitmap = Icon.createWithBitmap((Bitmap) this.f2029b);
                break;
            case 2:
                createWithBitmap = Icon.createWithResource(i(), this.f2032e);
                break;
            case 3:
                createWithBitmap = Icon.createWithData((byte[]) this.f2029b, this.f2032e, this.f2033f);
                break;
            case 4:
                createWithBitmap = Icon.createWithContentUri((String) this.f2029b);
                break;
            case 5:
                if (Build.VERSION.SDK_INT < 26) {
                    createWithBitmap = Icon.createWithBitmap(b((Bitmap) this.f2029b, false));
                    break;
                } else {
                    createWithBitmap = Icon.createWithAdaptiveBitmap((Bitmap) this.f2029b);
                    break;
                }
            case 6:
                int i10 = Build.VERSION.SDK_INT;
                if (i10 >= 30) {
                    createWithBitmap = Icon.createWithAdaptiveBitmapContentUri(n());
                    break;
                } else {
                    if (context == null) {
                        throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + n());
                    }
                    InputStream p10 = p(context);
                    if (p10 == null) {
                        throw new IllegalStateException("Cannot load adaptive icon from uri: " + n());
                    }
                    if (i10 < 26) {
                        createWithBitmap = Icon.createWithBitmap(b(BitmapFactory.decodeStream(p10), false));
                        break;
                    } else {
                        createWithBitmap = Icon.createWithAdaptiveBitmap(BitmapFactory.decodeStream(p10));
                        break;
                    }
                }
        }
        ColorStateList colorStateList = this.f2034g;
        if (colorStateList != null) {
            createWithBitmap.setTintList(colorStateList);
        }
        PorterDuff.Mode mode = this.f2035h;
        if (mode != f2027k) {
            createWithBitmap.setTintMode(mode);
        }
        return createWithBitmap;
    }

    public IconCompat(int i10) {
        this.f2030c = null;
        this.f2031d = null;
        this.f2032e = 0;
        this.f2033f = 0;
        this.f2034g = null;
        this.f2035h = f2027k;
        this.f2036i = null;
        this.f2028a = i10;
    }
}
