package m7;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.push.R$string;

/* loaded from: classes3.dex */
public abstract class c {
    public static Pair a() {
        return d(d.AD_MAIN, d.AD_BACKUP, R$string.ad_main, R$string.ad_backup);
    }

    public static Pair b() {
        return d(d.BIGBEE_MAIN, d.BIGBEE_BACKUP, R$string.bigbee_main, R$string.bigbee_backup);
    }

    public static String c(int i10) {
        String string = f.f16829b.getResources().getString(i10);
        return "false".equals(f.f16829b.getResources().getString(R$string.domain_is_security)) ? string : n7.b.a(string, "*&@!6d5d-c483-4720-bb29-785b8f321c^%");
    }

    public static Pair d(d dVar, d dVar2, int i10, int i11) {
        if (!k(f.f16829b)) {
            return null;
        }
        String d10 = n7.a.d(f.f16829b, dVar.b());
        if (TextUtils.isEmpty(d10)) {
            d10 = c(i10);
        }
        String d11 = n7.a.d(f.f16829b, dVar2.b());
        if (TextUtils.isEmpty(d11)) {
            d11 = c(i11);
        }
        return new Pair(d10, d11);
    }

    public static String e(d dVar, int i10) {
        if (!k(f.f16829b)) {
            return null;
        }
        String d10 = n7.a.d(f.f16829b, dVar.b());
        return TextUtils.isEmpty(d10) ? c(i10) : d10;
    }

    public static Pair f() {
        return d(d.EPG_MAIN, d.EPG_BACKUP, R$string.epg_main, R$string.epg_backup);
    }

    public static String g() {
        return e(d.H5_MAIN, R$string.h5_main);
    }

    public static Pair h() {
        return d(d.NOTICE_MAIN, d.NOTICE_BACKUP, R$string.notice_main, R$string.notice_backup);
    }

    public static Pair i() {
        return d(d.PORTAL_MAIN, d.PORTAL_BACKUP, R$string.portal_main, R$string.portal_backup);
    }

    public static Pair j() {
        return d(d.UPGRADE_MAIN, d.UPGRADE_BACKUP, R$string.upgrade_main, R$string.upgrade_backup);
    }

    public static boolean k(Context context) {
        return context != null;
    }
}
