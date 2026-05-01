package u5;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.analytics.pro.f;
import t9.i;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f19061a = new a();

    public final Object a(Context context, String str, Object obj) {
        i.g(context, f.X);
        i.g(str, "key");
        SharedPreferences sharedPreferences = context.getSharedPreferences("cs_msg", 0);
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

    public final void b(Context context, String str, Object obj) {
        i.g(context, f.X);
        i.g(str, "key");
        SharedPreferences.Editor edit = context.getSharedPreferences("cs_msg", 0).edit();
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
}
