package g5;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.util.List;

/* loaded from: classes3.dex */
public final class m implements MultiItemEntity {

    /* renamed from: a, reason: collision with root package name */
    public List f13781a;

    public m(List list) {
        t9.i.g(list, "columnList");
        this.f13781a = list;
    }

    public final List a() {
        return this.f13781a;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return a6.d.f249a.b();
    }
}
