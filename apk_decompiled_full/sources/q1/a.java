package q1;

import android.content.Context;
import anet.channel.entity.ENV;
import java.io.Serializable;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public abstract class a implements Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static Context f18189c;

    /* renamed from: a, reason: collision with root package name */
    public static ENV f18187a = ENV.ONLINE;

    /* renamed from: b, reason: collision with root package name */
    public static AtomicBoolean f18188b = new AtomicBoolean(false);

    /* renamed from: d, reason: collision with root package name */
    public static HashMap f18190d = null;

    public static Context a() {
        return f18189c;
    }
}
