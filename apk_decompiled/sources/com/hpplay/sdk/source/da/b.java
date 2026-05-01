package com.hpplay.sdk.source.da;

import android.content.Context;
import com.hpplay.sdk.source.log.SourceLog;

/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final String f7627a = "DaClientLoader";

    /* renamed from: b, reason: collision with root package name */
    private static final String f7628b = "com.hpplay.sdk.source.da.DaClientImpl";

    public static j a(Context context) {
        try {
            j jVar = (j) DaClientImpl.class.getConstructor(Context.class).newInstance(context);
            SourceLog.i(f7627a, "com.hpplay.sdk.source.da.DaClientImpl initializ success");
            return jVar;
        } catch (Exception e10) {
            SourceLog.w(f7627a, e10);
            return null;
        }
    }
}
