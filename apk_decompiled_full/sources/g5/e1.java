package g5;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.mobile.brasiltv.view.adView.CommAdShowControl;
import com.mobile.brasiltv.view.adView.IAdShowControl;

/* loaded from: classes3.dex */
public final class e1 implements MultiItemEntity {

    /* renamed from: a, reason: collision with root package name */
    public String f13678a;

    /* renamed from: b, reason: collision with root package name */
    public final String f13679b;

    /* renamed from: c, reason: collision with root package name */
    public final IAdShowControl f13680c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f13681d;

    public e1(String str, String str2, IAdShowControl iAdShowControl, boolean z10) {
        t9.i.g(str, "adUnitId");
        t9.i.g(iAdShowControl, "adControl");
        this.f13678a = str;
        this.f13679b = str2;
        this.f13680c = iAdShowControl;
        this.f13681d = z10;
    }

    public final IAdShowControl a() {
        return this.f13680c;
    }

    public final String b() {
        return this.f13679b;
    }

    public final String c() {
        return this.f13678a;
    }

    public final boolean d() {
        return this.f13681d;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return a6.d.f249a.h();
    }

    public /* synthetic */ e1(String str, String str2, IAdShowControl iAdShowControl, boolean z10, int i10, t9.g gVar) {
        this(str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? new CommAdShowControl() : iAdShowControl, (i10 & 8) != 0 ? false : z10);
    }
}
