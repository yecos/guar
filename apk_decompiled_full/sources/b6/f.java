package b6;

import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class f extends k5.a {

    /* renamed from: d, reason: collision with root package name */
    public Map f4704d = new LinkedHashMap();

    public void X2() {
        this.f4704d.clear();
    }

    @Override // u8.b, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        X2();
    }
}
