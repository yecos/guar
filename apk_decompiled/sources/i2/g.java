package i2;

import android.text.TextUtils;
import java.util.List;

/* loaded from: classes.dex */
public abstract class g {
    public static final boolean a(String str) {
        return str == null || TextUtils.isEmpty(str);
    }

    public static final boolean b(List list) {
        return list == null || list.isEmpty();
    }
}
