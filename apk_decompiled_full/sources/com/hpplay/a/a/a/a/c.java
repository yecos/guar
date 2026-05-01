package com.hpplay.a.a.a.a;

import com.raizlabs.android.dbflow.sql.language.Operator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
public class c implements Iterable<String> {

    /* renamed from: a, reason: collision with root package name */
    private final HashMap<String, String> f7230a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private final ArrayList<b> f7231b = new ArrayList<>();

    public c(Map<String, String> map) {
        String str = map.get("cookie");
        if (str != null) {
            for (String str2 : str.split(";")) {
                String[] split = str2.trim().split(Operator.Operation.EQUALS);
                if (split.length == 2) {
                    this.f7230a.put(split[0], split[1]);
                }
            }
        }
    }

    public void a(String str) {
        a(str, "-delete-", -30);
    }

    public String b(String str) {
        return this.f7230a.get(str);
    }

    @Override // java.lang.Iterable
    public Iterator<String> iterator() {
        return this.f7230a.keySet().iterator();
    }

    public void a(b bVar) {
        this.f7231b.add(bVar);
    }

    public void a(String str, String str2, int i10) {
        this.f7231b.add(new b(str, str2, b.a(i10)));
    }

    public void a(com.hpplay.a.a.a.c.c cVar) {
        Iterator<b> it = this.f7231b.iterator();
        while (it.hasNext()) {
            cVar.a(it.next().a());
        }
    }
}
