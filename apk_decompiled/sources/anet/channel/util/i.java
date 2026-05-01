package anet.channel.util;

import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private static AtomicInteger f4287a = new AtomicInteger();

    public static String a(String str) {
        if (f4287a.get() == Integer.MAX_VALUE) {
            f4287a.set(0);
        }
        return !TextUtils.isEmpty(str) ? StringUtils.concatString(str, ".AWCN", String.valueOf(f4287a.incrementAndGet())) : StringUtils.concatString("AWCN", String.valueOf(f4287a.incrementAndGet()));
    }
}
