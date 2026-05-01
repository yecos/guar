package n7;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes3.dex */
public abstract class a {
    public static void a(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("DomainCache", 0).edit();
        edit.clear();
        edit.apply();
    }

    public static Object b(Context context, String str, Object obj) {
        String simpleName = obj.getClass().getSimpleName();
        SharedPreferences sharedPreferences = context.getSharedPreferences("DomainCache", 0);
        if ("Integer".equals(simpleName)) {
            return Integer.valueOf(sharedPreferences.getInt(str, ((Integer) obj).intValue()));
        }
        if ("Boolean".equals(simpleName)) {
            return Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) obj).booleanValue()));
        }
        if ("String".equals(simpleName)) {
            return sharedPreferences.getString(str, (String) obj);
        }
        if ("Float".equals(simpleName)) {
            return Float.valueOf(sharedPreferences.getFloat(str, ((Float) obj).floatValue()));
        }
        if ("Long".equals(simpleName)) {
            return Long.valueOf(sharedPreferences.getLong(str, ((Long) obj).longValue()));
        }
        return null;
    }

    public static int c(Context context) {
        return context.getSharedPreferences("UMPushConfig", 0).getInt("versionCode", 0);
    }

    public static String d(Context context, String str) {
        return context.getSharedPreferences("DomainCache", 0).getString(str, "");
    }

    public static void e(Context context, String str, Object obj) {
        String simpleName = obj.getClass().getSimpleName();
        SharedPreferences.Editor edit = context.getSharedPreferences("DomainCache", 0).edit();
        if ("Integer".equals(simpleName)) {
            edit.putInt(str, ((Integer) obj).intValue());
        } else if ("Boolean".equals(simpleName)) {
            edit.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if ("String".equals(simpleName)) {
            edit.putString(str, (String) obj);
        } else if ("Float".equals(simpleName)) {
            edit.putFloat(str, ((Float) obj).floatValue());
        } else if ("Long".equals(simpleName)) {
            edit.putLong(str, ((Long) obj).longValue());
        }
        edit.apply();
    }

    public static void f(Context context, int i10) {
        SharedPreferences.Editor edit = context.getSharedPreferences("UMPushConfig", 0).edit();
        edit.putInt("versionCode", i10);
        edit.apply();
    }
}
