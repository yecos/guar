package com.hpplay.a.a.a.e;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;

/* loaded from: classes2.dex */
public class b implements e {

    /* renamed from: a, reason: collision with root package name */
    private final File f7326a;

    /* renamed from: b, reason: collision with root package name */
    private final List<d> f7327b;

    public b() {
        File file = new File(System.getProperty("java.io.tmpdir"));
        this.f7326a = file;
        if (!file.exists()) {
            file.mkdirs();
        }
        this.f7327b = new ArrayList();
    }

    @Override // com.hpplay.a.a.a.e.e
    public void a() {
        Iterator<d> it = this.f7327b.iterator();
        while (it.hasNext()) {
            try {
                it.next().a();
            } catch (Exception e10) {
                com.hpplay.a.a.a.d.LOG.log(Level.WARNING, "could not delete file ", (Throwable) e10);
            }
        }
        this.f7327b.clear();
    }

    @Override // com.hpplay.a.a.a.e.e
    public d a(String str) {
        a aVar = new a(this.f7326a);
        this.f7327b.add(aVar);
        return aVar;
    }
}
