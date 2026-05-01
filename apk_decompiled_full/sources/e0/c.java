package e0;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public abstract class c extends a {

    /* renamed from: i, reason: collision with root package name */
    public int f12842i;

    /* renamed from: j, reason: collision with root package name */
    public int f12843j;

    /* renamed from: k, reason: collision with root package name */
    public LayoutInflater f12844k;

    public c(Context context, int i10, Cursor cursor, boolean z10) {
        super(context, cursor, z10);
        this.f12843j = i10;
        this.f12842i = i10;
        this.f12844k = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // e0.a
    public View g(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f12844k.inflate(this.f12843j, viewGroup, false);
    }

    @Override // e0.a
    public View h(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f12844k.inflate(this.f12842i, viewGroup, false);
    }
}
