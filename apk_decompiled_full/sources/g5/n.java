package g5;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.util.List;
import mobile.com.requestframe.utils.response.ChildColumnList;

/* loaded from: classes3.dex */
public final class n implements MultiItemEntity {

    /* renamed from: a, reason: collision with root package name */
    public ChildColumnList f13790a;

    /* renamed from: b, reason: collision with root package name */
    public List f13791b;

    /* renamed from: c, reason: collision with root package name */
    public int f13792c;

    public n(ChildColumnList childColumnList, List list, int i10) {
        this.f13790a = childColumnList;
        this.f13791b = list;
        this.f13792c = i10;
    }

    public final ChildColumnList a() {
        return this.f13790a;
    }

    public final int b() {
        return this.f13792c;
    }

    public final List c() {
        return this.f13791b;
    }

    public final void d(List list) {
        this.f13791b = list;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return a6.d.f249a.c();
    }
}
