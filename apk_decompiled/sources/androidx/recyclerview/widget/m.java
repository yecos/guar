package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public abstract class m {

    /* renamed from: a, reason: collision with root package name */
    public final RecyclerView.o f3262a;

    /* renamed from: b, reason: collision with root package name */
    public int f3263b;

    /* renamed from: c, reason: collision with root package name */
    public final Rect f3264c;

    public static class a extends m {
        public a(RecyclerView.o oVar) {
            super(oVar, null);
        }

        @Override // androidx.recyclerview.widget.m
        public int d(View view) {
            return this.f3262a.getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).rightMargin;
        }

        @Override // androidx.recyclerview.widget.m
        public int e(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f3262a.getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin;
        }

        @Override // androidx.recyclerview.widget.m
        public int f(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f3262a.getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.m
        public int g(View view) {
            return this.f3262a.getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).leftMargin;
        }

        @Override // androidx.recyclerview.widget.m
        public int h() {
            return this.f3262a.getWidth();
        }

        @Override // androidx.recyclerview.widget.m
        public int i() {
            return this.f3262a.getWidth() - this.f3262a.getPaddingRight();
        }

        @Override // androidx.recyclerview.widget.m
        public int j() {
            return this.f3262a.getPaddingRight();
        }

        @Override // androidx.recyclerview.widget.m
        public int k() {
            return this.f3262a.getWidthMode();
        }

        @Override // androidx.recyclerview.widget.m
        public int l() {
            return this.f3262a.getHeightMode();
        }

        @Override // androidx.recyclerview.widget.m
        public int m() {
            return this.f3262a.getPaddingLeft();
        }

        @Override // androidx.recyclerview.widget.m
        public int n() {
            return (this.f3262a.getWidth() - this.f3262a.getPaddingLeft()) - this.f3262a.getPaddingRight();
        }

        @Override // androidx.recyclerview.widget.m
        public int p(View view) {
            this.f3262a.getTransformedBoundingBox(view, true, this.f3264c);
            return this.f3264c.right;
        }

        @Override // androidx.recyclerview.widget.m
        public int q(View view) {
            this.f3262a.getTransformedBoundingBox(view, true, this.f3264c);
            return this.f3264c.left;
        }

        @Override // androidx.recyclerview.widget.m
        public void r(int i10) {
            this.f3262a.offsetChildrenHorizontal(i10);
        }
    }

    public static class b extends m {
        public b(RecyclerView.o oVar) {
            super(oVar, null);
        }

        @Override // androidx.recyclerview.widget.m
        public int d(View view) {
            return this.f3262a.getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.m
        public int e(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f3262a.getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin;
        }

        @Override // androidx.recyclerview.widget.m
        public int f(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f3262a.getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin;
        }

        @Override // androidx.recyclerview.widget.m
        public int g(View view) {
            return this.f3262a.getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).topMargin;
        }

        @Override // androidx.recyclerview.widget.m
        public int h() {
            return this.f3262a.getHeight();
        }

        @Override // androidx.recyclerview.widget.m
        public int i() {
            return this.f3262a.getHeight() - this.f3262a.getPaddingBottom();
        }

        @Override // androidx.recyclerview.widget.m
        public int j() {
            return this.f3262a.getPaddingBottom();
        }

        @Override // androidx.recyclerview.widget.m
        public int k() {
            return this.f3262a.getHeightMode();
        }

        @Override // androidx.recyclerview.widget.m
        public int l() {
            return this.f3262a.getWidthMode();
        }

        @Override // androidx.recyclerview.widget.m
        public int m() {
            return this.f3262a.getPaddingTop();
        }

        @Override // androidx.recyclerview.widget.m
        public int n() {
            return (this.f3262a.getHeight() - this.f3262a.getPaddingTop()) - this.f3262a.getPaddingBottom();
        }

        @Override // androidx.recyclerview.widget.m
        public int p(View view) {
            this.f3262a.getTransformedBoundingBox(view, true, this.f3264c);
            return this.f3264c.bottom;
        }

        @Override // androidx.recyclerview.widget.m
        public int q(View view) {
            this.f3262a.getTransformedBoundingBox(view, true, this.f3264c);
            return this.f3264c.top;
        }

        @Override // androidx.recyclerview.widget.m
        public void r(int i10) {
            this.f3262a.offsetChildrenVertical(i10);
        }
    }

    public /* synthetic */ m(RecyclerView.o oVar, a aVar) {
        this(oVar);
    }

    public static m a(RecyclerView.o oVar) {
        return new a(oVar);
    }

    public static m b(RecyclerView.o oVar, int i10) {
        if (i10 == 0) {
            return a(oVar);
        }
        if (i10 == 1) {
            return c(oVar);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public static m c(RecyclerView.o oVar) {
        return new b(oVar);
    }

    public abstract int d(View view);

    public abstract int e(View view);

    public abstract int f(View view);

    public abstract int g(View view);

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract int k();

    public abstract int l();

    public abstract int m();

    public abstract int n();

    public int o() {
        if (Integer.MIN_VALUE == this.f3263b) {
            return 0;
        }
        return n() - this.f3263b;
    }

    public abstract int p(View view);

    public abstract int q(View view);

    public abstract void r(int i10);

    public void s() {
        this.f3263b = n();
    }

    public m(RecyclerView.o oVar) {
        this.f3263b = Integer.MIN_VALUE;
        this.f3264c = new Rect();
        this.f3262a = oVar;
    }
}
