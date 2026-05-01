package a9;

import com.uc.crashsdk.export.LogType;
import okio.Buffer;
import z8.n2;
import z8.o2;

/* loaded from: classes3.dex */
public class p implements o2 {
    @Override // z8.o2
    public n2 a(int i10) {
        return new o(new Buffer(), Math.min(LogType.ANR, Math.max(4096, i10)));
    }
}
