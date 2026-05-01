package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;

/* loaded from: classes.dex */
public class i {

    /* renamed from: b, reason: collision with root package name */
    public int f3251b;

    /* renamed from: c, reason: collision with root package name */
    public int f3252c;

    /* renamed from: d, reason: collision with root package name */
    public int f3253d;

    /* renamed from: e, reason: collision with root package name */
    public int f3254e;

    /* renamed from: h, reason: collision with root package name */
    public boolean f3257h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f3258i;

    /* renamed from: a, reason: collision with root package name */
    public boolean f3250a = true;

    /* renamed from: f, reason: collision with root package name */
    public int f3255f = 0;

    /* renamed from: g, reason: collision with root package name */
    public int f3256g = 0;

    public boolean a(RecyclerView.a0 a0Var) {
        int i10 = this.f3252c;
        return i10 >= 0 && i10 < a0Var.b();
    }

    public View b(RecyclerView.v vVar) {
        View o10 = vVar.o(this.f3252c);
        this.f3252c += this.f3253d;
        return o10;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f3251b + ", mCurrentPosition=" + this.f3252c + ", mItemDirection=" + this.f3253d + ", mLayoutDirection=" + this.f3254e + ", mStartLine=" + this.f3255f + ", mEndLine=" + this.f3256g + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
    }
}
