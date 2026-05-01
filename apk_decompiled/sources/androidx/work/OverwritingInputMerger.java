package androidx.work;

import a1.h;
import androidx.work.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class OverwritingInputMerger extends h {
    @Override // a1.h
    public b b(List list) {
        b.a aVar = new b.a();
        HashMap hashMap = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            hashMap.putAll(((b) it.next()).h());
        }
        aVar.d(hashMap);
        return aVar.a();
    }
}
