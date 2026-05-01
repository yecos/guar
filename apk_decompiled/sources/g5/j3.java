package g5;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.List;
import mobile.com.requestframe.utils.response.ChildColumnList;

/* loaded from: classes3.dex */
public final class j3 {

    /* renamed from: a, reason: collision with root package name */
    public ChildColumnList f13731a;

    /* renamed from: b, reason: collision with root package name */
    public List f13732b;

    public j3(ChildColumnList childColumnList, List list) {
        t9.i.g(childColumnList, "columnData");
        t9.i.g(list, "shelveAssetList");
        this.f13731a = childColumnList;
        this.f13732b = list;
    }

    public final ChildColumnList a() {
        return this.f13731a;
    }

    public final List b() {
        return this.f13732b;
    }

    public final void c(List list) {
        t9.i.g(list, "<set-?>");
        this.f13732b = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j3)) {
            return false;
        }
        j3 j3Var = (j3) obj;
        return t9.i.b(this.f13731a, j3Var.f13731a) && t9.i.b(this.f13732b, j3Var.f13732b);
    }

    public int hashCode() {
        return (this.f13731a.hashCode() * 31) + this.f13732b.hashCode();
    }

    public String toString() {
        return "SpecialItem(columnData=" + this.f13731a + ", shelveAssetList=" + this.f13732b + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
