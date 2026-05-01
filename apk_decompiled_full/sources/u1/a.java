package u1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.advertlib.bean.AdReportBean;
import com.advertlib.bean.AdReportBeanWrapper;
import com.hpplay.component.protocol.PlistBuilder;
import com.umeng.analytics.pro.f;
import h9.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import t9.g;
import t9.i;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    public static final C0327a f19002c = new C0327a(null);

    /* renamed from: d, reason: collision with root package name */
    public static final String f19003d = "adtable";

    /* renamed from: e, reason: collision with root package name */
    public static final String f19004e = "id";

    /* renamed from: f, reason: collision with root package name */
    public static final String f19005f = "ad_id";

    /* renamed from: g, reason: collision with root package name */
    public static final String f19006g = "ad_name";

    /* renamed from: h, reason: collision with root package name */
    public static final String f19007h = "display_times";

    /* renamed from: i, reason: collision with root package name */
    public static final String f19008i = "click_times";

    /* renamed from: j, reason: collision with root package name */
    public static final String f19009j = "user_name";

    /* renamed from: k, reason: collision with root package name */
    public static final String f19010k = "apk_version";

    /* renamed from: l, reason: collision with root package name */
    public static final String f19011l = "media_type";

    /* renamed from: m, reason: collision with root package name */
    public static final String f19012m = "ad_type";

    /* renamed from: n, reason: collision with root package name */
    public static final String f19013n = "last_update_timestamp";

    /* renamed from: o, reason: collision with root package name */
    public static final String f19014o = "game_stay_time";

    /* renamed from: a, reason: collision with root package name */
    public b f19015a;

    /* renamed from: b, reason: collision with root package name */
    public SQLiteDatabase f19016b;

    /* renamed from: u1.a$a, reason: collision with other inner class name */
    public static final class C0327a {
        public C0327a() {
        }

        public /* synthetic */ C0327a(g gVar) {
            this();
        }

        public final String a() {
            return a.f19005f;
        }

        public final String b() {
            return a.f19006g;
        }

        public final String c() {
            return a.f19012m;
        }

        public final String d() {
            return a.f19010k;
        }

        public final String e() {
            return a.f19008i;
        }

        public final String f() {
            return a.f19007h;
        }

        public final String g() {
            return a.f19014o;
        }

        public final String h() {
            return a.f19004e;
        }

        public final String i() {
            return a.f19013n;
        }

        public final String j() {
            return a.f19011l;
        }

        public final String k() {
            return a.f19009j;
        }

        public final String l() {
            return a.f19003d;
        }
    }

    public a(Context context) {
        i.g(context, f.X);
        b bVar = new b(context);
        this.f19015a = bVar;
        SQLiteDatabase writableDatabase = bVar.getWritableDatabase();
        i.f(writableDatabase, "adHelper.writableDatabase");
        this.f19016b = writableDatabase;
    }

    public final void m(List list) {
        i.g(list, "ids");
        synchronized (this) {
            String[] strArr = {""};
            this.f19016b.beginTransaction();
            try {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    strArr[0] = String.valueOf(((Number) it.next()).intValue());
                    this.f19016b.delete(f19003d, f19004e + "=?", strArr);
                }
                this.f19016b.setTransactionSuccessful();
                this.f19016b.endTransaction();
                t tVar = t.f14242a;
            } catch (Throwable th) {
                this.f19016b.endTransaction();
                throw th;
            }
        }
    }

    public final List n() {
        ArrayList arrayList = new ArrayList();
        try {
            synchronized (this) {
                Cursor rawQuery = this.f19016b.rawQuery("SELECT * FROM " + f19003d, null);
                while (rawQuery.moveToNext()) {
                    i.f(rawQuery, "cursor");
                    arrayList.add(o(rawQuery));
                }
                rawQuery.close();
                t tVar = t.f14242a;
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return arrayList;
    }

    public final AdReportBeanWrapper o(Cursor cursor) {
        int i10 = cursor.getInt(cursor.getColumnIndex(f19004e));
        String string = cursor.getString(cursor.getColumnIndex(f19005f));
        i.f(string, "cursor.getString(cursor.…ColumnIndex(FIELD_AD_ID))");
        String string2 = cursor.getString(cursor.getColumnIndex(f19006g));
        i.f(string2, "cursor.getString(cursor.…lumnIndex(FIELD_AD_NAME))");
        int i11 = cursor.getInt(cursor.getColumnIndex(f19007h));
        int i12 = cursor.getInt(cursor.getColumnIndex(f19008i));
        String string3 = cursor.getString(cursor.getColumnIndex(f19009j));
        i.f(string3, "cursor.getString(cursor.…mnIndex(FIELD_USER_NAME))");
        int i13 = cursor.getInt(cursor.getColumnIndex(f19010k));
        String string4 = cursor.getString(cursor.getColumnIndex(f19011l));
        i.f(string4, "cursor.getString(cursor.…nIndex(FIELD_MEDIA_TYPE))");
        String string5 = cursor.getString(cursor.getColumnIndex(f19012m));
        i.f(string5, "cursor.getString(cursor.…lumnIndex(FIELD_AD_TYPE))");
        return new AdReportBeanWrapper(i10, new AdReportBean(string, string2, i11, i12, "unknown", "unknown", string3, i13, "unknown", string4, string5, cursor.getLong(cursor.getColumnIndex(f19013n)), cursor.getLong(cursor.getColumnIndex(f19014o))));
    }

    public final void p(ContentValues contentValues, AdReportBean adReportBean) {
        contentValues.put(f19005f, adReportBean.getAd_id());
        String str = f19006g;
        String ad_name = adReportBean.getAd_name();
        if (ad_name == null) {
            ad_name = "";
        }
        contentValues.put(str, ad_name);
        contentValues.put(f19007h, Integer.valueOf(adReportBean.getDisplay_times()));
        contentValues.put(f19008i, Integer.valueOf(adReportBean.getClick_times()));
        contentValues.put(f19009j, adReportBean.getUser_name());
        contentValues.put(f19010k, Integer.valueOf(adReportBean.getApk_version()));
        contentValues.put(f19011l, adReportBean.getMedia_type());
        contentValues.put(f19012m, adReportBean.getAd_type());
        contentValues.put(f19013n, Long.valueOf(adReportBean.getLast_update_timestamp()));
        contentValues.put(f19014o, Long.valueOf(adReportBean.getGame_stay_time()));
    }

    public final void q(AdReportBean adReportBean) {
        i.g(adReportBean, PlistBuilder.KEY_ITEM);
        ContentValues contentValues = new ContentValues();
        p(contentValues, adReportBean);
        synchronized (this) {
            this.f19016b.insert(f19003d, null, contentValues);
        }
    }
}
