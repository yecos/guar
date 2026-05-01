package com.chad.library.adapter.base;

import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.f;
import b0.u;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.chad.library.adapter.base.listener.OnItemSwipeListener;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public abstract class BaseItemDraggableAdapter<T, K extends BaseViewHolder> extends BaseQuickAdapter<T, K> {
    private static final String ERROR_NOT_SAME_ITEMTOUCHHELPER = "Item drag and item swipe should pass the same ItemTouchHelper";
    private static final int NO_TOGGLE_VIEW = 0;
    protected boolean itemDragEnabled;
    protected boolean itemSwipeEnabled;
    protected boolean mDragOnLongPress;
    protected f mItemTouchHelper;
    protected OnItemDragListener mOnItemDragListener;
    protected OnItemSwipeListener mOnItemSwipeListener;
    protected View.OnLongClickListener mOnToggleViewLongClickListener;
    protected View.OnTouchListener mOnToggleViewTouchListener;
    protected int mToggleViewId;

    public BaseItemDraggableAdapter(List<T> list) {
        super(list);
        this.mToggleViewId = 0;
        this.itemDragEnabled = false;
        this.itemSwipeEnabled = false;
        this.mDragOnLongPress = true;
    }

    private boolean inRange(int i10) {
        return i10 >= 0 && i10 < this.mData.size();
    }

    public void disableDragItem() {
        this.itemDragEnabled = false;
    }

    public void disableSwipeItem() {
        this.itemSwipeEnabled = false;
    }

    public void enableDragItem(f fVar) {
        enableDragItem(fVar, 0, true);
    }

    public void enableSwipeItem() {
        this.itemSwipeEnabled = true;
    }

    public int getViewHolderPosition(RecyclerView.d0 d0Var) {
        return d0Var.getAdapterPosition() - getHeaderLayoutCount();
    }

    public boolean isItemDraggable() {
        return this.itemDragEnabled;
    }

    public boolean isItemSwipeEnable() {
        return this.itemSwipeEnabled;
    }

    public void onItemDragEnd(RecyclerView.d0 d0Var) {
        OnItemDragListener onItemDragListener = this.mOnItemDragListener;
        if (onItemDragListener == null || !this.itemDragEnabled) {
            return;
        }
        onItemDragListener.onItemDragEnd(d0Var, getViewHolderPosition(d0Var));
    }

    public void onItemDragMoving(RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2) {
        int viewHolderPosition = getViewHolderPosition(d0Var);
        int viewHolderPosition2 = getViewHolderPosition(d0Var2);
        if (inRange(viewHolderPosition) && inRange(viewHolderPosition2)) {
            if (viewHolderPosition < viewHolderPosition2) {
                int i10 = viewHolderPosition;
                while (i10 < viewHolderPosition2) {
                    int i11 = i10 + 1;
                    Collections.swap(this.mData, i10, i11);
                    i10 = i11;
                }
            } else {
                for (int i12 = viewHolderPosition; i12 > viewHolderPosition2; i12--) {
                    Collections.swap(this.mData, i12, i12 - 1);
                }
            }
            notifyItemMoved(d0Var.getAdapterPosition(), d0Var2.getAdapterPosition());
        }
        OnItemDragListener onItemDragListener = this.mOnItemDragListener;
        if (onItemDragListener == null || !this.itemDragEnabled) {
            return;
        }
        onItemDragListener.onItemDragMoving(d0Var, viewHolderPosition, d0Var2, viewHolderPosition2);
    }

    public void onItemDragStart(RecyclerView.d0 d0Var) {
        OnItemDragListener onItemDragListener = this.mOnItemDragListener;
        if (onItemDragListener == null || !this.itemDragEnabled) {
            return;
        }
        onItemDragListener.onItemDragStart(d0Var, getViewHolderPosition(d0Var));
    }

    public void onItemSwipeClear(RecyclerView.d0 d0Var) {
        OnItemSwipeListener onItemSwipeListener = this.mOnItemSwipeListener;
        if (onItemSwipeListener == null || !this.itemSwipeEnabled) {
            return;
        }
        onItemSwipeListener.clearView(d0Var, getViewHolderPosition(d0Var));
    }

    public void onItemSwipeStart(RecyclerView.d0 d0Var) {
        OnItemSwipeListener onItemSwipeListener = this.mOnItemSwipeListener;
        if (onItemSwipeListener == null || !this.itemSwipeEnabled) {
            return;
        }
        onItemSwipeListener.onItemSwipeStart(d0Var, getViewHolderPosition(d0Var));
    }

    public void onItemSwiped(RecyclerView.d0 d0Var) {
        int viewHolderPosition = getViewHolderPosition(d0Var);
        if (inRange(viewHolderPosition)) {
            this.mData.remove(viewHolderPosition);
            notifyItemRemoved(d0Var.getAdapterPosition());
        }
        OnItemSwipeListener onItemSwipeListener = this.mOnItemSwipeListener;
        if (onItemSwipeListener == null || !this.itemSwipeEnabled) {
            return;
        }
        onItemSwipeListener.onItemSwiped(d0Var, getViewHolderPosition(d0Var));
    }

    public void onItemSwiping(Canvas canvas, RecyclerView.d0 d0Var, float f10, float f11, boolean z10) {
        OnItemSwipeListener onItemSwipeListener = this.mOnItemSwipeListener;
        if (onItemSwipeListener == null || !this.itemSwipeEnabled) {
            return;
        }
        onItemSwipeListener.onItemSwipeMoving(canvas, d0Var, f10, f11, z10);
    }

    public void setOnItemDragListener(OnItemDragListener onItemDragListener) {
        this.mOnItemDragListener = onItemDragListener;
    }

    public void setOnItemSwipeListener(OnItemSwipeListener onItemSwipeListener) {
        this.mOnItemSwipeListener = onItemSwipeListener;
    }

    public void setToggleDragOnLongPress(boolean z10) {
        this.mDragOnLongPress = z10;
        if (z10) {
            this.mOnToggleViewTouchListener = null;
            this.mOnToggleViewLongClickListener = new View.OnLongClickListener() { // from class: com.chad.library.adapter.base.BaseItemDraggableAdapter.1
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    BaseItemDraggableAdapter.this.getClass();
                    return true;
                }
            };
        } else {
            this.mOnToggleViewTouchListener = new View.OnTouchListener() { // from class: com.chad.library.adapter.base.BaseItemDraggableAdapter.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (u.c(motionEvent) != 0) {
                        return false;
                    }
                    BaseItemDraggableAdapter baseItemDraggableAdapter = BaseItemDraggableAdapter.this;
                    if (baseItemDraggableAdapter.mDragOnLongPress) {
                        return false;
                    }
                    baseItemDraggableAdapter.getClass();
                    return true;
                }
            };
            this.mOnToggleViewLongClickListener = null;
        }
    }

    public void setToggleViewId(int i10) {
        this.mToggleViewId = i10;
    }

    public void enableDragItem(f fVar, int i10, boolean z10) {
        this.itemDragEnabled = true;
        setToggleViewId(i10);
        setToggleDragOnLongPress(z10);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.g
    public void onBindViewHolder(K k10, int i10) {
        super.onBindViewHolder((BaseItemDraggableAdapter<T, K>) k10, i10);
        k10.getItemViewType();
    }

    public BaseItemDraggableAdapter(int i10, List<T> list) {
        super(i10, list);
        this.mToggleViewId = 0;
        this.itemDragEnabled = false;
        this.itemSwipeEnabled = false;
        this.mDragOnLongPress = true;
    }
}
