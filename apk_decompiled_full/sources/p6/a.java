package p6;

import android.content.Context;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.mobile.brasiltv.utils.x;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.f;
import t9.i;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f18068a = new a();

    public final String a(Context context, int i10) {
        i.g(context, f.X);
        if (i10 == 11) {
            return "EC11-" + x.f8754a.y(context, R.string.failed_cast_play);
        }
        if (i10 == 12) {
            return "EC12-" + x.f8754a.y(context, R.string.failed_cast_play);
        }
        return i10 + ASCIIPropertyListParser.DATE_DATE_FIELD_DELIMITER + x.f8754a.y(context, R.string.failed_cast_play);
    }
}
