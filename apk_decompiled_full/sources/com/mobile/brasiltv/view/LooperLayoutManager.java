package com.mobile.brasiltv.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes3.dex */
public class LooperLayoutManager extends LinearLayoutManager {
    boolean looperEnable;
    int marginLeft;

    public LooperLayoutManager(Context context) {
        super(context);
        this.looperEnable = true;
        this.marginLeft = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0094 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0095  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int fill(int i10, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        View o10;
        View view;
        View o11;
        View view2;
        if (i10 > 0) {
            View childAt = getChildAt(getChildCount() - 1);
            if (childAt == null) {
                return 0;
            }
            int position = getPosition(childAt);
            if (childAt.getRight() < getWidth() + this.marginLeft) {
                if (position != getItemCount() - 1) {
                    o11 = vVar.o(position + 1);
                } else {
                    if (!this.looperEnable) {
                        view2 = null;
                        i10 = 0;
                        if (view2 != null) {
                            return i10;
                        }
                        addView(view2);
                        measureChildWithMargins(view2, 0, 0);
                        int decoratedRightWithMargins = getDecoratedRightWithMargins(childAt);
                        layoutDecorated(view2, decoratedRightWithMargins, getPaddingTop(), decoratedRightWithMargins + view2.getMeasuredWidth(), getPaddingTop() + view2.getMeasuredHeight());
                        return i10;
                    }
                    o11 = vVar.o(0);
                }
                view2 = o11;
                if (view2 != null) {
                }
            }
        } else {
            View childAt2 = getChildAt(0);
            if (childAt2 == null) {
                return 0;
            }
            int position2 = getPosition(childAt2);
            if (childAt2.getLeft() >= this.marginLeft + 0) {
                if (position2 != 0) {
                    o10 = vVar.o(position2 - 1);
                } else if (this.looperEnable) {
                    o10 = vVar.o(getItemCount() - 1);
                } else {
                    view = null;
                    i10 = 0;
                    if (view != null) {
                        return 0;
                    }
                    addView(view, 0);
                    measureChildWithMargins(view, 0, 0);
                    int decoratedLeftWithMargins = getDecoratedLeftWithMargins(childAt2);
                    layoutDecorated(view, decoratedLeftWithMargins - view.getMeasuredWidth(), getPaddingTop(), decoratedLeftWithMargins, getPaddingTop() + view.getMeasuredHeight());
                }
                view = o10;
                if (view != null) {
                }
            }
        }
        return i10;
    }

    private int getDecoratedBottomWithMargins(View view) {
        return getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).bottomMargin;
    }

    private int getDecoratedLeftWithMargins(View view) {
        return getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).leftMargin;
    }

    private int getDecoratedMeasuredHeightWithMargins(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return getDecoratedMeasuredHeight(view) + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    private int getDecoratedMeasuredWidthWithMargins(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return getDecoratedMeasuredWidth(view) + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
    }

    private int getDecoratedRightWithMargins(View view) {
        return getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).rightMargin;
    }

    private int getDecoratedTopWithMargins(View view) {
        return getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).topMargin;
    }

    private int getVerticalSpace() {
        return (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    private void recyclerHideView(int i10, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            View childAt = getChildAt(i11);
            if (childAt != null) {
                if (i10 > 0) {
                    if (childAt.getRight() < this.marginLeft + 0) {
                        removeAndRecycleView(childAt, vVar);
                    }
                } else if (childAt.getLeft() > getWidth() + this.marginLeft) {
                    removeAndRecycleView(childAt, vVar);
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p generateDefaultLayoutParams() {
        return new RecyclerView.p(-2, -2);
    }

    public int getBottom() {
        return getHeight() - getPaddingBottom();
    }

    public int getEnd() {
        return getWidth() - getPaddingLeft();
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0083 A[LOOP:0: B:20:0x004d->B:22:0x0083, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0082 A[SYNTHETIC] */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onLayoutChildren(RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        int paddingLeft;
        int i10;
        if (getItemCount() == 0) {
            detachAndScrapAttachedViews(vVar);
            return;
        }
        if (getChildCount() == 0 && a0Var.e()) {
            return;
        }
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (childAt != null) {
                i10 = getPosition(childAt);
                if (i10 > getItemCount() - 1) {
                    paddingLeft = getPaddingLeft();
                } else {
                    paddingLeft = getDecoratedLeftWithMargins(childAt);
                    if (paddingLeft > 0) {
                        paddingLeft = getPaddingLeft();
                    }
                    detachAndScrapAttachedViews(vVar);
                    while (true) {
                        View o10 = vVar.o(i10 % getItemCount());
                        measureChildWithMargins(o10, 0, 0);
                        addView(o10);
                        layoutDecoratedWithMargins(o10, paddingLeft, getPaddingTop(), paddingLeft + o10.getMeasuredWidth(), getPaddingTop() + o10.getMeasuredHeight());
                        paddingLeft += getDecoratedMeasuredWidthWithMargins(o10);
                        if (paddingLeft < getEnd()) {
                            return;
                        } else {
                            i10++;
                        }
                    }
                }
            } else {
                paddingLeft = getPaddingLeft();
            }
        } else {
            paddingLeft = getPaddingLeft();
        }
        i10 = 0;
        detachAndScrapAttachedViews(vVar);
        while (true) {
            View o102 = vVar.o(i10 % getItemCount());
            measureChildWithMargins(o102, 0, 0);
            addView(o102);
            layoutDecoratedWithMargins(o102, paddingLeft, getPaddingTop(), paddingLeft + o102.getMeasuredWidth(), getPaddingTop() + o102.getMeasuredHeight());
            paddingLeft += getDecoratedMeasuredWidthWithMargins(o102);
            if (paddingLeft < getEnd()) {
            }
            i10++;
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int scrollHorizontallyBy(int i10, RecyclerView.v vVar, RecyclerView.a0 a0Var) {
        int fill = fill(i10, vVar, a0Var);
        if (fill == 0) {
            return 0;
        }
        offsetChildrenHorizontal(-fill);
        recyclerHideView(i10, vVar, a0Var);
        return fill;
    }

    public LooperLayoutManager(Context context, int i10, boolean z10, int i11) {
        super(context, i10, z10);
        this.looperEnable = true;
        this.marginLeft = i11;
    }

    public LooperLayoutManager(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.looperEnable = true;
        this.marginLeft = 0;
    }
}
