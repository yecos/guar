package ta;

import java.util.LinkedList;

/* loaded from: classes3.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public String f18979a;

    /* renamed from: b, reason: collision with root package name */
    public LinkedList f18980b;

    public void a(Object obj) {
        if (this.f18980b == null) {
            this.f18980b = new LinkedList();
        }
        this.f18980b.add(obj);
    }

    public Object[] b() {
        LinkedList linkedList = this.f18980b;
        if (linkedList != null) {
            return linkedList.toArray();
        }
        return null;
    }

    public String[] c() {
        LinkedList linkedList = this.f18980b;
        if (linkedList == null) {
            return null;
        }
        String[] strArr = new String[linkedList.size()];
        for (int i10 = 0; i10 < this.f18980b.size(); i10++) {
            strArr[i10] = this.f18980b.get(i10).toString();
        }
        return strArr;
    }

    public String d() {
        return this.f18979a;
    }

    public void e(String str) {
        this.f18979a = str;
    }
}
