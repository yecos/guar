package com.mobile.brasiltv.view.login;

/* loaded from: classes3.dex */
public final class ScrollableImageView$registerScheduleScroll$1 extends t9.j implements s9.a {
    final /* synthetic */ ScrollableImageView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollableImageView$registerScheduleScroll$1(ScrollableImageView scrollableImageView) {
        super(0);
        this.this$0 = scrollableImageView;
    }

    @Override // s9.a
    public /* bridge */ /* synthetic */ Object invoke() {
        m67invoke();
        return h9.t.f14242a;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m67invoke() {
        this.this$0.scheduleScroll();
        this.this$0.mMeasureListener = null;
    }
}
