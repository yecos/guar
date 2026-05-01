package c0;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* loaded from: classes.dex */
public final class a extends ClickableSpan {

    /* renamed from: a, reason: collision with root package name */
    public final int f5254a;

    /* renamed from: b, reason: collision with root package name */
    public final g0 f5255b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5256c;

    public a(int i10, g0 g0Var, int i11) {
        this.f5254a = i10;
        this.f5255b = g0Var;
        this.f5256c = i11;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f5254a);
        this.f5255b.N(this.f5256c, bundle);
    }
}
