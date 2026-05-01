package com.mobile.brasiltv.utils;

import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes3.dex */
public class o0 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f8736a = true;

    /* renamed from: b, reason: collision with root package name */
    public boolean f8737b = false;

    /* renamed from: c, reason: collision with root package name */
    public RecyclerView f8738c;

    /* renamed from: d, reason: collision with root package name */
    public b f8739d;

    public class a extends RecyclerView.t {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void onScrollStateChanged(RecyclerView recyclerView, int i10) {
            super.onScrollStateChanged(recyclerView, i10);
            if (o0.this.f8736a && i10 == 0) {
                o0 o0Var = o0.this;
                if (!o0Var.f(o0Var.f8738c) || o0.this.f8737b || o0.this.f8739d == null) {
                    return;
                }
                o0.this.f8739d.a();
            }
        }
    }

    public interface b {
        void a();
    }

    public o0(RecyclerView recyclerView) {
        this.f8738c = recyclerView;
    }

    public final boolean f(RecyclerView recyclerView) {
        return recyclerView != null && recyclerView.computeVerticalScrollExtent() + recyclerView.computeVerticalScrollOffset() >= recyclerView.computeVerticalScrollRange();
    }

    public void g(boolean z10) {
        this.f8737b = z10;
    }

    public void h(boolean z10) {
        this.f8736a = z10;
    }

    public void i(b bVar) {
        this.f8739d = bVar;
        this.f8738c.addOnScrollListener(new a());
    }
}
