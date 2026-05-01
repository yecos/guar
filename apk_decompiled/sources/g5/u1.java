package g5;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.util.List;
import mobile.com.requestframe.utils.response.ChildColumnList;

/* loaded from: classes3.dex */
public final class u1 implements MultiItemEntity {

    /* renamed from: a, reason: collision with root package name */
    public ChildColumnList f13910a;

    /* renamed from: b, reason: collision with root package name */
    public List f13911b;

    public u1(ChildColumnList childColumnList, List list) {
        this.f13910a = childColumnList;
        this.f13911b = list;
    }

    public final ChildColumnList a() {
        return this.f13910a;
    }

    public final List b() {
        return this.f13911b;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return a6.d.f249a.l();
    }
}
