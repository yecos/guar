package d7;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: f, reason: collision with root package name */
    public static final Pattern f12666f = Pattern.compile(",");

    /* renamed from: a, reason: collision with root package name */
    public final Context f12667a;

    /* renamed from: b, reason: collision with root package name */
    public Point f12668b;

    /* renamed from: c, reason: collision with root package name */
    public Point f12669c;

    /* renamed from: d, reason: collision with root package name */
    public int f12670d;

    /* renamed from: e, reason: collision with root package name */
    public String f12671e;

    public b(Context context) {
        this.f12667a = context;
    }

    public static int a(CharSequence charSequence, int i10) {
        int i11 = 0;
        for (String str : f12666f.split(charSequence)) {
            try {
                double parseDouble = Double.parseDouble(str.trim());
                int i12 = (int) (10.0d * parseDouble);
                double d10 = i10;
                Double.isNaN(d10);
                if (Math.abs(d10 - parseDouble) < Math.abs(i10 - i11)) {
                    i11 = i12;
                }
            } catch (NumberFormatException unused) {
                return i10;
            }
        }
        return i11;
    }

    public static Point b(CharSequence charSequence, Point point) {
        String[] split = f12666f.split(charSequence);
        int length = split.length;
        int i10 = Integer.MAX_VALUE;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (true) {
            if (i11 >= length) {
                break;
            }
            String trim = split[i11].trim();
            int indexOf = trim.indexOf(120);
            if (indexOf < 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("Bad preview-size: ");
                sb.append(trim);
            } else {
                try {
                    int parseInt = Integer.parseInt(trim.substring(0, indexOf));
                    int parseInt2 = Integer.parseInt(trim.substring(indexOf + 1));
                    int abs = Math.abs(parseInt - point.x) + Math.abs(parseInt2 - point.y);
                    if (abs == 0) {
                        i13 = parseInt2;
                        i12 = parseInt;
                        break;
                    }
                    if (abs < i10) {
                        i13 = parseInt2;
                        i10 = abs;
                        i12 = parseInt;
                    }
                } catch (NumberFormatException unused) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Bad preview-size: ");
                    sb2.append(trim);
                }
            }
            i11++;
        }
        if (i12 <= 0 || i13 <= 0) {
            return null;
        }
        return new Point(i12, i13);
    }

    public static Point d(Camera.Parameters parameters, Point point) {
        Point point2;
        String str = parameters.get("preview-size-values");
        if (str == null) {
            str = parameters.get("preview-size-value");
        }
        if (str != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("preview-size-values parameter: ");
            sb.append(str);
            point2 = b(str, point);
        } else {
            point2 = null;
        }
        return point2 == null ? new Point((point.x >> 3) << 3, (point.y >> 3) << 3) : point2;
    }

    public Point c() {
        return this.f12669c;
    }

    public int e() {
        return this.f12670d;
    }

    public String f() {
        return this.f12671e;
    }

    public Point g() {
        return this.f12668b;
    }

    public void h(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        this.f12670d = parameters.getPreviewFormat();
        this.f12671e = parameters.get("preview-format");
        StringBuilder sb = new StringBuilder();
        sb.append("Default preview format: ");
        sb.append(this.f12670d);
        sb.append('/');
        sb.append(this.f12671e);
        Display defaultDisplay = ((WindowManager) this.f12667a.getSystemService("window")).getDefaultDisplay();
        this.f12668b = new Point(defaultDisplay.getWidth(), defaultDisplay.getHeight());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Screen resolution: ");
        sb2.append(this.f12668b);
        Point point = new Point();
        Point point2 = this.f12668b;
        point.x = point2.x;
        point.y = point2.y;
        int i10 = point2.x;
        int i11 = point2.y;
        if (i10 < i11) {
            point.x = i11;
            point.y = point2.x;
        }
        this.f12669c = d(parameters, point);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Camera resolution: ");
        sb3.append(this.f12668b);
    }

    public void i(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        StringBuilder sb = new StringBuilder();
        sb.append("Setting preview size: ");
        sb.append(this.f12669c);
        Point point = this.f12669c;
        parameters.setPreviewSize(point.x, point.y);
        j(parameters);
        k(parameters);
        camera.setDisplayOrientation(90);
        camera.setParameters(parameters);
    }

    public final void j(Camera.Parameters parameters) {
        if (Build.MODEL.contains("Behold II") && c.f12673l == 3) {
            parameters.set("flash-value", 1);
        } else {
            parameters.set("flash-value", 2);
        }
        parameters.set("flash-mode", "off");
    }

    public final void k(Camera.Parameters parameters) {
        String str = parameters.get("zoom-supported");
        if (str == null || Boolean.parseBoolean(str)) {
            String str2 = parameters.get("max-zoom");
            int i10 = 27;
            if (str2 != null) {
                try {
                    int parseDouble = (int) (Double.parseDouble(str2) * 10.0d);
                    if (27 > parseDouble) {
                        i10 = parseDouble;
                    }
                } catch (NumberFormatException unused) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Bad max-zoom: ");
                    sb.append(str2);
                }
            }
            String str3 = parameters.get("taking-picture-zoom-max");
            if (str3 != null) {
                try {
                    int parseInt = Integer.parseInt(str3);
                    if (i10 > parseInt) {
                        i10 = parseInt;
                    }
                } catch (NumberFormatException unused2) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Bad taking-picture-zoom-max: ");
                    sb2.append(str3);
                }
            }
            String str4 = parameters.get("mot-zoom-values");
            if (str4 != null) {
                i10 = a(str4, i10);
            }
            String str5 = parameters.get("mot-zoom-step");
            if (str5 != null) {
                try {
                    int parseDouble2 = (int) (Double.parseDouble(str5.trim()) * 10.0d);
                    if (parseDouble2 > 1) {
                        i10 -= i10 % parseDouble2;
                    }
                } catch (NumberFormatException unused3) {
                }
            }
            if (str2 != null || str4 != null) {
                double d10 = i10;
                Double.isNaN(d10);
                parameters.set("zoom", String.valueOf(d10 / 10.0d));
            }
            if (str3 != null) {
                parameters.set("taking-picture-zoom", i10);
            }
        }
    }
}
