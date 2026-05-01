package g5;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import java.util.List;

/* loaded from: classes3.dex */
public class w0 extends t0 {
    public w0(androidx.fragment.app.o oVar, List list) {
        super(oVar, list);
    }

    @Override // g5.t0
    public Fragment a(int i10) {
        Bundle bundle = new Bundle();
        bundle.putInt("fragment_live_index", i10);
        b6.r0 r0Var = new b6.r0();
        r0Var.setArguments(bundle);
        return r0Var;
    }

    @Override // g5.t0
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public CharSequence b(String str) {
        return str;
    }
}
