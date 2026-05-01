package f5;

import android.os.Bundle;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class d extends c {

    /* renamed from: k, reason: collision with root package name */
    public Map f13129k = new LinkedHashMap();

    public abstract void R2();

    public abstract l5.a S2();

    public abstract int T2();

    @Override // f5.c, i5.a, u8.a, androidx.appcompat.app.d, androidx.fragment.app.e, androidx.activity.ComponentActivity, o.p, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(T2());
        R2();
        S2().e();
    }

    @Override // f5.c, u8.a, androidx.appcompat.app.d, androidx.fragment.app.e, android.app.Activity
    public void onDestroy() {
        S2().g();
        super.onDestroy();
    }
}
