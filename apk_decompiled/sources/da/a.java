package da;

import android.os.Looper;
import ca.p1;
import java.util.List;
import kotlinx.coroutines.internal.q;

/* loaded from: classes3.dex */
public final class a implements q {
    @Override // kotlinx.coroutines.internal.q
    public String a() {
        return "For tests Dispatchers.setMain from kotlinx-coroutines-test module can be used";
    }

    @Override // kotlinx.coroutines.internal.q
    public p1 b(List list) {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper != null) {
            return new c(e.a(mainLooper, true), null, 2, null);
        }
        throw new IllegalStateException("The main looper is not available");
    }

    @Override // kotlinx.coroutines.internal.q
    public int c() {
        return 1073741823;
    }
}
