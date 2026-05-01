package g5;

import java.util.List;
import mobile.com.requestframe.utils.response.ChildColumnList;

/* loaded from: classes3.dex */
public abstract class f1 {

    /* renamed from: a, reason: collision with root package name */
    public ChildColumnList f13692a;

    /* renamed from: b, reason: collision with root package name */
    public List f13693b;

    /* renamed from: c, reason: collision with root package name */
    public int f13694c;

    public f1(ChildColumnList childColumnList, List list, int i10) {
        this.f13692a = childColumnList;
        this.f13693b = list;
        this.f13694c = i10;
    }

    public final ChildColumnList a() {
        return this.f13692a;
    }

    public final List b() {
        return this.f13693b;
    }

    public final void c(List list) {
        this.f13693b = list;
    }
}
