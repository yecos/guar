package q8;

import android.content.SharedPreferences;
import android.os.Build;
import com.titans.entity.RangerPlayTag;
import java.util.HashMap;
import t9.i;

/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f18248a = new c();

    /* renamed from: b, reason: collision with root package name */
    public static final String f18249b = "MediaPlayerSwitchUtils";

    /* renamed from: c, reason: collision with root package name */
    public static int f18250c = -1;

    /* renamed from: d, reason: collision with root package name */
    public static int f18251d = -1;

    /* renamed from: e, reason: collision with root package name */
    public static HashMap f18252e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    public static i8.b f18253f;

    /* renamed from: g, reason: collision with root package name */
    public static SharedPreferences f18254g;

    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18255a;

        static {
            int[] iArr = new int[i8.b.values().length];
            try {
                iArr[i8.b.NATIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[i8.b.IJK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[i8.b.EXO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f18255a = iArr;
        }
    }

    public final i8.b a(String str) {
        i.g(str, "channelCode");
        Integer num = (Integer) f18252e.get(str);
        if (num == null) {
            SharedPreferences sharedPreferences = f18254g;
            if (sharedPreferences == null) {
                i.w("mSp");
                sharedPreferences = null;
            }
            num = Integer.valueOf(sharedPreferences.getInt("MediaPlayerTypeKey" + str, -1));
            if (num.intValue() == -1) {
                num = Build.VERSION.SDK_INT > 22 ? 2 : 1;
            }
            f18252e.put(str, num);
        }
        return i(num.intValue());
    }

    public final i8.b b() {
        return f18253f;
    }

    public final i8.b c(String str, String str2) {
        i.g(str, "buss");
        i.g(str2, "programCode");
        return i.b(str, RangerPlayTag.VOD.getValue()) ? e() : i.b(str, RangerPlayTag.RECORD.getValue()) ? d() : a(str2);
    }

    public final i8.b d() {
        if (f18251d == -1) {
            SharedPreferences sharedPreferences = f18254g;
            if (sharedPreferences == null) {
                i.w("mSp");
                sharedPreferences = null;
            }
            int i10 = sharedPreferences.getInt("MediaPlayerTypeKey" + RangerPlayTag.RECORD.getValue(), -1);
            f18251d = i10;
            if (i10 == -1) {
                f18251d = Build.VERSION.SDK_INT > 22 ? 2 : 1;
            }
        }
        return i(f18251d);
    }

    public final i8.b e() {
        if (f18250c == -1) {
            SharedPreferences sharedPreferences = f18254g;
            if (sharedPreferences == null) {
                i.w("mSp");
                sharedPreferences = null;
            }
            int i10 = sharedPreferences.getInt("MediaPlayerTypeKey" + RangerPlayTag.VOD.getValue(), -1);
            f18250c = i10;
            if (i10 == -1) {
                f18250c = Build.VERSION.SDK_INT > 22 ? 2 : 1;
            }
        }
        return i(f18250c);
    }

    public final void f(String str, String str2) {
        i.g(str, "buss");
        i.g(str2, "programCode");
        RangerPlayTag rangerPlayTag = RangerPlayTag.VOD;
        SharedPreferences sharedPreferences = null;
        if (i.b(str, rangerPlayTag.getValue())) {
            SharedPreferences sharedPreferences2 = f18254g;
            if (sharedPreferences2 == null) {
                i.w("mSp");
            } else {
                sharedPreferences = sharedPreferences2;
            }
            sharedPreferences.edit().putInt("MediaPlayerTypeKey" + rangerPlayTag.getValue(), f18250c).apply();
            return;
        }
        RangerPlayTag rangerPlayTag2 = RangerPlayTag.RECORD;
        if (i.b(str, rangerPlayTag2.getValue())) {
            SharedPreferences sharedPreferences3 = f18254g;
            if (sharedPreferences3 == null) {
                i.w("mSp");
            } else {
                sharedPreferences = sharedPreferences3;
            }
            sharedPreferences.edit().putInt("MediaPlayerTypeKey" + rangerPlayTag2.getValue(), f18251d).apply();
            return;
        }
        SharedPreferences sharedPreferences4 = f18254g;
        if (sharedPreferences4 == null) {
            i.w("mSp");
        } else {
            sharedPreferences = sharedPreferences4;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        String str3 = "MediaPlayerTypeKey" + str2;
        Integer num = (Integer) f18252e.get(str2);
        if (num == null) {
            num = -1;
        }
        edit.putInt(str3, num.intValue()).apply();
    }

    public final void g(i8.b bVar) {
        f18253f = bVar;
    }

    public final void h(String str, String str2, i8.b bVar) {
        i.g(str, "buss");
        i.g(str2, "programCode");
        i.g(bVar, "playerType");
        if (i.b(str, RangerPlayTag.VOD.getValue())) {
            f18250c = j(bVar);
        } else if (i.b(str, RangerPlayTag.RECORD.getValue())) {
            f18251d = j(bVar);
        } else {
            f18252e.put(str2, Integer.valueOf(j(bVar)));
        }
    }

    public final i8.b i(int i10) {
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? i8.b.IJK : i8.b.EXO : i8.b.IJK : i8.b.NATIVE;
    }

    public final int j(i8.b bVar) {
        int i10 = a.f18255a[bVar.ordinal()];
        if (i10 != 1) {
            return (i10 == 2 || i10 != 3) ? 2 : 3;
        }
        return 1;
    }
}
