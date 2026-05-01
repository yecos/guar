package g5;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.util.List;

/* loaded from: classes3.dex */
public final class l implements MultiItemEntity {

    /* renamed from: a, reason: collision with root package name */
    public String f13765a;

    /* renamed from: b, reason: collision with root package name */
    public int f13766b;

    /* renamed from: c, reason: collision with root package name */
    public List f13767c;

    public l(String str, int i10, List list) {
        t9.i.g(list, "recommendList");
        this.f13765a = str;
        this.f13766b = i10;
        this.f13767c = list;
    }

    public final String a() {
        return this.f13765a;
    }

    public final int b() {
        return this.f13766b;
    }

    public final List c() {
        return this.f13767c;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return a6.d.f249a.a();
    }
}
