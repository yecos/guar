package com.efs.sdk.base.core.util.concurrent;

import com.efs.sdk.base.core.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class d<T> implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private List<b<T>> f6240a = new ArrayList(5);

    /* renamed from: b, reason: collision with root package name */
    private c<T> f6241b;

    public d(c<T> cVar) {
        this.f6241b = cVar;
    }

    public final void a(List<b<T>> list) {
        this.f6240a.addAll(list);
    }

    @Override // java.lang.Runnable
    public void run() {
        a();
    }

    public final T a() {
        T t10 = null;
        try {
            Iterator<b<T>> it = this.f6240a.iterator();
            while (it.hasNext()) {
                it.next();
            }
            t10 = this.f6241b.a();
            Iterator<b<T>> it2 = this.f6240a.iterator();
            while (it2.hasNext()) {
                it2.next().a(this.f6241b, t10);
            }
            Iterator<b<T>> it3 = this.f6240a.iterator();
            while (it3.hasNext()) {
                it3.next().result(t10);
            }
        } catch (Throwable th) {
            Log.w("efs.util.concurrent", th);
            Iterator<b<T>> it4 = this.f6240a.iterator();
            while (it4.hasNext()) {
                it4.next();
            }
        }
        return t10;
    }
}
