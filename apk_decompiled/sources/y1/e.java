package y1;

import android.content.Context;
import android.content.SharedPreferences;
import t9.i;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f19725a = new e();

    public final Object a(Context context, String str, Object obj) {
        i.g(context, com.umeng.analytics.pro.f.X);
        i.g(str, "key");
        SharedPreferences sharedPreferences = context.getSharedPreferences("advert", 0);
        if (obj instanceof Integer) {
            return Integer.valueOf(sharedPreferences.getInt(str, ((Number) obj).intValue()));
        }
        if (obj instanceof String) {
            return sharedPreferences.getString(str, (String) obj);
        }
        if (obj instanceof Float) {
            return Float.valueOf(sharedPreferences.getFloat(str, ((Number) obj).floatValue()));
        }
        if (obj instanceof Boolean) {
            return Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) obj).booleanValue()));
        }
        if (obj instanceof Long) {
            return Long.valueOf(sharedPreferences.getLong(str, ((Number) obj).longValue()));
        }
        throw new IllegalArgumentException("不支持该类型的数据");
    }

    public final Object b(Context context, String str, String str2, Object obj) {
        i.g(context, com.umeng.analytics.pro.f.X);
        i.g(str, "fileName");
        i.g(str2, "key");
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        if (obj instanceof Integer) {
            return Integer.valueOf(sharedPreferences.getInt(str2, ((Number) obj).intValue()));
        }
        if (obj instanceof String) {
            return sharedPreferences.getString(str2, (String) obj);
        }
        if (obj instanceof Float) {
            return Float.valueOf(sharedPreferences.getFloat(str2, ((Number) obj).floatValue()));
        }
        if (obj instanceof Boolean) {
            return Boolean.valueOf(sharedPreferences.getBoolean(str2, ((Boolean) obj).booleanValue()));
        }
        if (obj instanceof Long) {
            return Long.valueOf(sharedPreferences.getLong(str2, ((Number) obj).longValue()));
        }
        throw new IllegalArgumentException("不支持该类型的数据");
    }

    public final void c(Context context, String str, Object obj) {
        i.g(context, com.umeng.analytics.pro.f.X);
        i.g(str, "key");
        SharedPreferences.Editor edit = context.getSharedPreferences("advert", 0).edit();
        if (obj instanceof Integer) {
            edit.putInt(str, ((Number) obj).intValue());
        } else if (obj instanceof String) {
            edit.putString(str, (String) obj);
        } else if (obj instanceof Float) {
            edit.putFloat(str, ((Number) obj).floatValue());
        } else if (obj instanceof Boolean) {
            edit.putBoolean(str, ((Boolean) obj).booleanValue());
        } else {
            if (!(obj instanceof Long)) {
                throw new IllegalArgumentException("不支持该类型的数据");
            }
            edit.putLong(str, ((Number) obj).longValue());
        }
        edit.apply();
    }

    public final void d(Context context, String str, String str2, Object obj) {
        i.g(context, com.umeng.analytics.pro.f.X);
        i.g(str, "fileName");
        i.g(str2, "key");
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        if (obj instanceof Integer) {
            edit.putInt(str2, ((Number) obj).intValue());
        } else if (obj instanceof String) {
            edit.putString(str2, (String) obj);
        } else if (obj instanceof Float) {
            edit.putFloat(str2, ((Number) obj).floatValue());
        } else if (obj instanceof Boolean) {
            edit.putBoolean(str2, ((Boolean) obj).booleanValue());
        } else {
            if (!(obj instanceof Long)) {
                throw new IllegalArgumentException("不支持该类型的数据");
            }
            edit.putLong(str2, ((Number) obj).longValue());
        }
        edit.apply();
    }
}
