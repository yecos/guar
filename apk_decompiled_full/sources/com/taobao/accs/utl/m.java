package com.taobao.accs.utl;

import android.app.Application;
import com.taobao.accs.utl.l;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
class m implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ l f9375a;

    public m(l lVar) {
        this.f9375a = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ArrayList arrayList;
        arrayList = l.f9365d;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            l.b bVar = (l.b) it.next();
            if (bVar != null) {
                Application unused = l.f9366e;
                bVar.a();
            }
        }
    }
}
