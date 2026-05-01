package r6;

import android.content.Context;
import com.mobile.brasiltv.player.view.ProgramRecommendInfoView;
import g5.w;
import t9.j;

/* loaded from: classes3.dex */
public final class f extends j implements s9.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ProgramRecommendInfoView f18553a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(ProgramRecommendInfoView programRecommendInfoView) {
        super(0);
        this.f18553a = programRecommendInfoView;
    }

    @Override // s9.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final w invoke() {
        Context context = this.f18553a.getContext();
        t9.i.f(context, com.umeng.analytics.pro.f.X);
        return new w(context);
    }
}
