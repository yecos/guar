package i2;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: b, reason: collision with root package name */
    public static final b f14282b = new b(null);

    /* renamed from: c, reason: collision with root package name */
    public static final h9.g f14283c = h9.h.b(a.f14285a);

    /* renamed from: a, reason: collision with root package name */
    public final SharedPreferences f14284a;

    public static final class a extends t9.j implements s9.a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f14285a = new a();

        public a() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final e invoke() {
            return new e("bbconfig", null);
        }
    }

    public static final class b {
        public b() {
        }

        public /* synthetic */ b(t9.g gVar) {
            this();
        }

        public final e a() {
            return (e) e.f14283c.getValue();
        }
    }

    public /* synthetic */ e(String str, t9.g gVar) {
        this(str);
    }

    public final Object b(String str, Object obj) {
        t9.i.g(str, "key");
        if (obj instanceof Integer) {
            return Integer.valueOf(this.f14284a.getInt(str, ((Number) obj).intValue()));
        }
        if (obj instanceof String) {
            return this.f14284a.getString(str, (String) obj);
        }
        if (obj instanceof Float) {
            return Float.valueOf(this.f14284a.getFloat(str, ((Number) obj).floatValue()));
        }
        if (obj instanceof Boolean) {
            return Boolean.valueOf(this.f14284a.getBoolean(str, ((Boolean) obj).booleanValue()));
        }
        if (obj instanceof Long) {
            return Long.valueOf(this.f14284a.getLong(str, ((Number) obj).longValue()));
        }
        throw new IllegalArgumentException("不支持该类型的数据");
    }

    public final void c(String str, Object obj) {
        t9.i.g(str, "key");
        SharedPreferences.Editor edit = this.f14284a.edit();
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

    public e(String str) {
        Context j10 = c2.i.f5350q.a().j();
        t9.i.d(j10);
        SharedPreferences sharedPreferences = j10.getSharedPreferences(str, 0);
        t9.i.f(sharedPreferences, "BigBee.mInstance.mContex…me, Context.MODE_PRIVATE)");
        this.f14284a = sharedPreferences;
    }
}
