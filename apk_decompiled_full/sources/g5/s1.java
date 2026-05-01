package g5;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.util.List;

/* loaded from: classes3.dex */
public final class s1 implements MultiItemEntity {

    /* renamed from: a, reason: collision with root package name */
    public String f13889a;

    /* renamed from: b, reason: collision with root package name */
    public int f13890b;

    /* renamed from: c, reason: collision with root package name */
    public List f13891c;

    public s1(String str, int i10, List list) {
        t9.i.g(list, "recommendList");
        this.f13889a = str;
        this.f13890b = i10;
        this.f13891c = list;
    }

    public final String a() {
        return this.f13889a;
    }

    public final int b() {
        return this.f13890b;
    }

    public final List c() {
        return this.f13891c;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return a6.d.f249a.e();
    }
}
