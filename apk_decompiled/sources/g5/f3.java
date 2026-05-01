package g5;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/* loaded from: classes3.dex */
public final class f3 implements MultiItemEntity {

    /* renamed from: a, reason: collision with root package name */
    public String f13696a;

    /* renamed from: b, reason: collision with root package name */
    public final String f13697b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f13698c;

    public f3(String str, String str2, boolean z10) {
        t9.i.g(str, "adUnitId");
        this.f13696a = str;
        this.f13697b = str2;
        this.f13698c = z10;
    }

    public final String a() {
        return this.f13697b;
    }

    public final String b() {
        return this.f13696a;
    }

    public final boolean c() {
        return this.f13698c;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return a6.d.f249a.k();
    }
}
