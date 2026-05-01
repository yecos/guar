package w1;

import android.content.Context;
import com.advertlib.bean.AdInfo;
import java.io.File;
import s1.m;
import t9.i;
import t9.t;

/* loaded from: classes.dex */
public final class c implements a {
    public static final void d(v1.b bVar, String str, t tVar) {
        i.g(str, "$adType");
        i.g(tVar, "$isSuccess");
        if (bVar != null) {
            bVar.a(str, tVar.f18958a);
        }
    }

    @Override // w1.a
    public void a(Context context, final String str, AdInfo adInfo, final v1.b bVar) {
        i.g(context, com.umeng.analytics.pro.f.X);
        i.g(str, "adType");
        i.g(adInfo, "adInfo");
        final t tVar = new t();
        r1.a aVar = r1.a.f18290a;
        String url = adInfo.getUrl();
        if (url == null) {
            url = "";
        }
        tVar.f18958a = aVar.f(context, url);
        m.f18686a.P().post(new Runnable() { // from class: w1.b
            @Override // java.lang.Runnable
            public final void run() {
                c.d(v1.b.this, str, tVar);
            }
        });
    }

    @Override // w1.a
    public File b(Context context, String str, AdInfo adInfo) {
        i.g(context, com.umeng.analytics.pro.f.X);
        i.g(str, "adType");
        i.g(adInfo, "adInfo");
        r1.a aVar = r1.a.f18290a;
        String url = adInfo.getUrl();
        if (url == null) {
            url = "";
        }
        return aVar.c(context, url);
    }
}
