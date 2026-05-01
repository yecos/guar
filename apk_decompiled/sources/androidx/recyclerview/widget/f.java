package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.recyclerview.R$dimen;
import androidx.recyclerview.widget.RecyclerView;
import b0.c1;
import java.util.List;

/* loaded from: classes.dex */
public abstract class f extends RecyclerView.n implements RecyclerView.q {

    public static abstract class a {
        private static final int ABS_HORIZONTAL_DIR_FLAGS = 789516;
        public static final int DEFAULT_DRAG_ANIMATION_DURATION = 200;
        public static final int DEFAULT_SWIPE_ANIMATION_DURATION = 250;
        private static final long DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS = 2000;
        static final int RELATIVE_DIR_FLAGS = 3158064;
        private static final Interpolator sDragScrollInterpolator = new InterpolatorC0047a();
        private static final Interpolator sDragViewScrollCapInterpolator = new b();
        private int mCachedMaxScrollSpeed = -1;

        /* renamed from: androidx.recyclerview.widget.f$a$a, reason: collision with other inner class name */
        public static class InterpolatorC0047a implements Interpolator {
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f10) {
                return f10 * f10 * f10 * f10 * f10;
            }
        }

        public static class b implements Interpolator {
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f10) {
                float f11 = f10 - 1.0f;
                return (f11 * f11 * f11 * f11 * f11) + 1.0f;
            }
        }

        public static int convertToRelativeDirection(int i10, int i11) {
            int i12;
            int i13 = i10 & ABS_HORIZONTAL_DIR_FLAGS;
            if (i13 == 0) {
                return i10;
            }
            int i14 = i10 & (i13 ^ (-1));
            if (i11 == 0) {
                i12 = i13 << 2;
            } else {
                int i15 = i13 << 1;
                i14 |= (-789517) & i15;
                i12 = (i15 & ABS_HORIZONTAL_DIR_FLAGS) << 2;
            }
            return i14 | i12;
        }

        public static g getDefaultUIUtil() {
            return h.f3249a;
        }

        public static int makeFlag(int i10, int i11) {
            return i11 << (i10 * 8);
        }

        public static int makeMovementFlags(int i10, int i11) {
            return makeFlag(2, i10) | makeFlag(1, i11) | makeFlag(0, i11 | i10);
        }

        public final int a(RecyclerView recyclerView) {
            if (this.mCachedMaxScrollSpeed == -1) {
                this.mCachedMaxScrollSpeed = recyclerView.getResources().getDimensionPixelSize(R$dimen.item_touch_helper_max_drag_scroll_per_frame);
            }
            return this.mCachedMaxScrollSpeed;
        }

        public boolean canDropOver(RecyclerView recyclerView, RecyclerView.d0 d0Var, RecyclerView.d0 d0Var2) {
            return true;
        }

        public RecyclerView.d0 chooseDropTarget(RecyclerView.d0 d0Var, List<RecyclerView.d0> list, int i10, int i11) {
            int bottom;
            int abs;
            int top;
            int abs2;
            int left;
            int abs3;
            int right;
            int abs4;
            int width = i10 + d0Var.itemView.getWidth();
            int height = i11 + d0Var.itemView.getHeight();
            int left2 = i10 - d0Var.itemView.getLeft();
            int top2 = i11 - d0Var.itemView.getTop();
            int size = list.size();
            RecyclerView.d0 d0Var2 = null;
            int i12 = -1;
            for (int i13 = 0; i13 < size; i13++) {
                RecyclerView.d0 d0Var3 = list.get(i13);
                if (left2 > 0 && (right = d0Var3.itemView.getRight() - width) < 0 && d0Var3.itemView.getRight() > d0Var.itemView.getRight() && (abs4 = Math.abs(right)) > i12) {
                    d0Var2 = d0Var3;
                    i12 = abs4;
                }
                if (left2 < 0 && (left = d0Var3.itemView.getLeft() - i10) > 0 && d0Var3.itemView.getLeft() < d0Var.itemView.getLeft() && (abs3 = Math.abs(left)) > i12) {
                    d0Var2 = d0Var3;
                    i12 = abs3;
                }
                if (top2 < 0 && (top = d0Var3.itemView.getTop() - i11) > 0 && d0Var3.itemView.getTop() < d0Var.itemView.getTop() && (abs2 = Math.abs(top)) > i12) {
                    d0Var2 = d0Var3;
                    i12 = abs2;
                }
                if (top2 > 0 && (bottom = d0Var3.itemView.getBottom() - height) < 0 && d0Var3.itemView.getBottom() > d0Var.itemView.getBottom() && (abs = Math.abs(bottom)) > i12) {
                    d0Var2 = d0Var3;
                    i12 = abs;
                }
            }
            return d0Var2;
        }

        public void clearView(RecyclerView recyclerView, RecyclerView.d0 d0Var) {
            h.f3249a.a(d0Var.itemView);
        }

        public int convertToAbsoluteDirection(int i10, int i11) {
            int i12;
            int i13 = i10 & RELATIVE_DIR_FLAGS;
            if (i13 == 0) {
                return i10;
            }
            int i14 = i10 & (i13 ^ (-1));
            if (i11 == 0) {
                i12 = i13 >> 2;
            } else {
                int i15 = i13 >> 1;
                i14 |= (-3158065) & i15;
                i12 = (i15 & RELATIVE_DIR_FLAGS) >> 2;
            }
            return i14 | i12;
        }

        public final int getAbsoluteMovementFlags(RecyclerView recyclerView, RecyclerView.d0 d0Var) {
            return convertToAbsoluteDirection(getMovementFlags(recyclerView, d0Var), c1.z(recyclerView));
        }

        public long getAnimationDuration(RecyclerView recyclerView, int i10, float f10, float f11) {
            RecyclerView.l itemAnimator = recyclerView.getItemAnimator();
            return itemAnimator == null ? i10 == 8 ? 200L : 250L : i10 == 8 ? itemAnimator.n() : itemAnimator.o();
        }

        public int getBoundingBoxMargin() {
            return 0;
        }

        public abstract int getMovementFlags(RecyclerView recyclerView, RecyclerView.d0 d0Var);

        public float getSwipeEscapeVelocity(float f10) {
            return f10;
        }

        public float getSwipeVelocityThreshold(float f10) {
            return f10;
        }

        public boolean hasDragFlag(RecyclerView recyclerView, RecyclerView.d0 d0Var) {
            return (getAbsoluteMovementFlags(recyclerView, d0Var) & 16711680) != 0;
        }

        public boolean hasSwipeFlag(RecyclerView recyclerView, RecyclerView.d0 d0Var) {
            return (getAbsoluteMovementFlags(recyclerView, d0Var) & 65280) != 0;
        }

        public int interpolateOutOfBoundsScroll(RecyclerView recyclerView, int i10, int i11, int i12, long j10) {
            int signum = (int) (((int) (((int) Math.signum(i11)) * a(recyclerView) * sDragViewScrollCapInterpolator.getInterpolation(Math.min(1.0f, (Math.abs(i11) * 1.0f) / i10)))) * sDragScrollInterpolator.getInterpolation(j10 <= DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS ? j10 / 2000.0f : 1.0f));
            return signum == 0 ? i11 > 0 ? 1 : -1 : signum;
        }

        public void onChildDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.d0 d0Var, float f10, float f11, int i10, boolean z10) {
            h.f3249a.c(canvas, recyclerView, d0Var.itemView, f10, f11, i10, z10);
        }

        public void onChildDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.d0 d0Var, float f10, float f11, int i10, boolean z10) {
            h.f3249a.d(canvas, recyclerView, d0Var.itemView, f10, f11, i10, z10);
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.d0 d0Var, List<Object> list, int i10, float f10, float f11) {
            if (list.size() > 0) {
                androidx.appcompat.app.m.a(list.get(0));
                throw null;
            }
            if (d0Var != null) {
                int save = canvas.save();
                onChildDraw(canvas, recyclerView, d0Var, f10, f11, i10, true);
                canvas.restoreToCount(save);
            }
        }

        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.d0 d0Var, List<Object> list, int i10, float f10, float f11) {
            int size = list.size();
            if (size > 0) {
                androidx.appcompat.app.m.a(list.get(0));
                canvas.save();
                throw null;
            }
            if (d0Var != null) {
                int save = canvas.save();
                onChildDrawOver(canvas, recyclerView, d0Var, f10, f11, i10, true);
                canvas.restoreToCount(save);
            }
            int i11 = size - 1;
            if (i11 < 0) {
                return;
            }
            androidx.appcompat.app.m.a(list.get(i11));
            throw null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void onMoved(RecyclerView recyclerView, RecyclerView.d0 d0Var, int i10, RecyclerView.d0 d0Var2, int i11, int i12, int i13) {
            RecyclerView.o layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof b) {
                ((b) layoutManager).prepareForDrop(d0Var.itemView, d0Var2.itemView, i12, i13);
                return;
            }
            if (layoutManager.canScrollHorizontally()) {
                if (layoutManager.getDecoratedLeft(d0Var2.itemView) <= recyclerView.getPaddingLeft()) {
                    recyclerView.scrollToPosition(i11);
                }
                if (layoutManager.getDecoratedRight(d0Var2.itemView) >= recyclerView.getWidth() - recyclerView.getPaddingRight()) {
                    recyclerView.scrollToPosition(i11);
                }
            }
            if (layoutManager.canScrollVertically()) {
                if (layoutManager.getDecoratedTop(d0Var2.itemView) <= recyclerView.getPaddingTop()) {
                    recyclerView.scrollToPosition(i11);
                }
                if (layoutManager.getDecoratedBottom(d0Var2.itemView) >= recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                    recyclerView.scrollToPosition(i11);
                }
            }
        }

        public void onSelectedChanged(RecyclerView.d0 d0Var, int i10) {
            if (d0Var != null) {
                h.f3249a.b(d0Var.itemView);
            }
        }
    }

    public interface b {
        void prepareForDrop(View view, View view2, int i10, int i11);
    }
}
