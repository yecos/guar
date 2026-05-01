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
        To view partially-correct add '--show-bad-code' argument
    */
    private int fill(int r9, androidx.recyclerview.widget.RecyclerView.v r10, androidx.recyclerview.widget.RecyclerView.a0 r11) {
        /*
            r8 = this;
            r11 = 0
            r0 = 0
            if (r9 <= 0) goto L63
            int r1 = r8.getChildCount()
            int r1 = r1 + (-1)
            android.view.View r1 = r8.getChildAt(r1)
            if (r1 != 0) goto L11
            return r0
        L11:
            int r2 = r8.getPosition(r1)
            int r3 = r1.getRight()
            int r4 = r8.getWidth()
            int r5 = r8.marginLeft
            int r4 = r4 + r5
            if (r3 >= r4) goto Lb7
            int r3 = r8.getItemCount()
            int r3 = r3 + (-1)
            if (r2 != r3) goto L36
            boolean r2 = r8.looperEnable
            if (r2 == 0) goto L33
            android.view.View r11 = r10.o(r0)
            goto L3c
        L33:
            r3 = r11
            r9 = 0
            goto L3d
        L36:
            int r2 = r2 + 1
            android.view.View r11 = r10.o(r2)
        L3c:
            r3 = r11
        L3d:
            if (r3 != 0) goto L40
            return r9
        L40:
            r8.addView(r3)
            r8.measureChildWithMargins(r3, r0, r0)
            int r4 = r8.getDecoratedRightWithMargins(r1)
            int r5 = r8.getPaddingTop()
            int r10 = r3.getMeasuredWidth()
            int r6 = r4 + r10
            int r10 = r8.getPaddingTop()
            int r11 = r3.getMeasuredHeight()
            int r7 = r10 + r11
            r2 = r8
            r2.layoutDecorated(r3, r4, r5, r6, r7)
            return r9
        L63:
            android.view.View r1 = r8.getChildAt(r0)
            if (r1 != 0) goto L6a
            return r0
        L6a:
            int r2 = r8.getPosition(r1)
            int r3 = r1.getLeft()
            int r4 = r8.marginLeft
            int r4 = r4 + r0
            if (r3 < r4) goto Lb7
            if (r2 != 0) goto L8b
            boolean r2 = r8.looperEnable
            if (r2 == 0) goto L88
            int r11 = r8.getItemCount()
            int r11 = r11 + (-1)
            android.view.View r11 = r10.o(r11)
            goto L91
        L88:
            r3 = r11
            r9 = 0
            goto L92
        L8b:
            int r2 = r2 + (-1)
            android.view.View r11 = r10.o(r2)
        L91:
            r3 = r11
        L92:
            if (r3 != 0) goto L95
            return r0
        L95:
            r8.addView(r3, r0)
            r8.measureChildWithMargins(r3, r0, r0)
            int r6 = r8.getDecoratedLeftWithMargins(r1)
            int r10 = r3.getMeasuredWidth()
            int r4 = r6 - r10
            int r5 = r8.getPaddingTop()
            int r10 = r8.getPaddingTop()
            int r11 = r3.getMeasuredHeight()
            int r7 = r10 + r11
            r2 = r8
            r2.layoutDecorated(r3, r4, r5, r6, r7)
        Lb7:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.view.LooperLayoutManager.fill(int, androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.RecyclerView$a0):int");
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
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayoutChildren(androidx.recyclerview.widget.RecyclerView.v r10, androidx.recyclerview.widget.RecyclerView.a0 r11) {
        /*
            r9 = this;
            int r0 = r9.getItemCount()
            if (r0 != 0) goto La
            r9.detachAndScrapAttachedViews(r10)
            return
        La:
            int r0 = r9.getChildCount()
            if (r0 != 0) goto L17
            boolean r11 = r11.e()
            if (r11 == 0) goto L17
            return
        L17:
            int r11 = r9.getChildCount()
            r0 = 0
            if (r11 <= 0) goto L45
            android.view.View r11 = r9.getChildAt(r0)
            if (r11 == 0) goto L40
            int r1 = r9.getPosition(r11)
            int r2 = r9.getItemCount()
            int r2 = r2 + (-1)
            if (r1 <= r2) goto L35
            int r11 = r9.getPaddingLeft()
            goto L49
        L35:
            int r11 = r9.getDecoratedLeftWithMargins(r11)
            if (r11 <= 0) goto L4a
            int r11 = r9.getPaddingLeft()
            goto L4a
        L40:
            int r11 = r9.getPaddingLeft()
            goto L49
        L45:
            int r11 = r9.getPaddingLeft()
        L49:
            r1 = 0
        L4a:
            r9.detachAndScrapAttachedViews(r10)
        L4d:
            int r2 = r9.getItemCount()
            int r2 = r1 % r2
            android.view.View r8 = r10.o(r2)
            r9.measureChildWithMargins(r8, r0, r0)
            r9.addView(r8)
            int r5 = r9.getPaddingTop()
            int r2 = r8.getMeasuredWidth()
            int r6 = r11 + r2
            int r2 = r9.getPaddingTop()
            int r3 = r8.getMeasuredHeight()
            int r7 = r2 + r3
            r2 = r9
            r3 = r8
            r4 = r11
            r2.layoutDecoratedWithMargins(r3, r4, r5, r6, r7)
            int r2 = r9.getDecoratedMeasuredWidthWithMargins(r8)
            int r11 = r11 + r2
            int r2 = r9.getEnd()
            if (r11 < r2) goto L83
            return
        L83:
            int r1 = r1 + 1
            goto L4d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.view.LooperLayoutManager.onLayoutChildren(androidx.recyclerview.widget.RecyclerView$v, androidx.recyclerview.widget.RecyclerView$a0):void");
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
