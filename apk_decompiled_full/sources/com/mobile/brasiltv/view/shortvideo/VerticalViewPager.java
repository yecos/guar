package com.mobile.brasiltv.view.shortvideo;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import androidx.core.widget.i;
import androidx.viewpager.widget.ViewPager;
import b0.c1;
import b0.h0;
import b0.p1;
import b0.u;
import c0.g0;
import c0.k0;
import com.google.common.primitives.Ints;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import x.o;
import x.p;

/* loaded from: classes3.dex */
public class VerticalViewPager extends ViewGroup {
    private static final int CLOSE_ENOUGH = 2;
    private static final boolean DEBUG = false;
    private static final int DEFAULT_GUTTER_SIZE = 16;
    private static final int DEFAULT_OFFSCREEN_PAGES = 1;
    private static final int DRAW_ORDER_DEFAULT = 0;
    private static final int DRAW_ORDER_FORWARD = 1;
    private static final int DRAW_ORDER_REVERSE = 2;
    private static final int INVALID_POINTER = -1;
    private static final int MAX_SETTLE_DURATION = 600;
    private static final int MIN_DISTANCE_FOR_FLING = 25;
    private static final int MIN_FLING_VELOCITY = 400;
    public static final int SCROLL_STATE_DRAGGING = 1;
    public static final int SCROLL_STATE_IDLE = 0;
    public static final int SCROLL_STATE_SETTLING = 2;
    private static final String TAG = "ViewPager";
    private static final boolean USE_CACHE = false;
    private final int TYPE_VIEW_SCROLLED;
    private int mActivePointerId;
    private androidx.viewpager.widget.a mAdapter;
    private OnAdapterChangeListener mAdapterChangeListener;
    private i mBottomEdge;
    private boolean mCalledSuper;
    private int mChildHeightMeasureSpec;
    private int mChildWidthMeasureSpec;
    private int mCloseEnough;
    private int mCurItem;
    private int mDecorChildCount;
    private int mDefaultGutterSize;
    private int mDrawingOrder;
    private ArrayList<View> mDrawingOrderedChildren;
    private final Runnable mEndScrollRunnable;
    private int mExpectedAdapterCount;
    private long mFakeDragBeginTime;
    private boolean mFakeDragging;
    private boolean mFirstLayout;
    private float mFirstOffset;
    private int mFlingDistance;
    private int mGutterSize;
    private boolean mIgnoreGutter;
    private boolean mInLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private ViewPager.j mInternalPageChangeListener;
    private boolean mIsBeingDragged;
    private boolean mIsUnableToDrag;
    private final ArrayList<ItemInfo> mItems;
    private float mLastMotionX;
    private float mLastMotionY;
    private float mLastOffset;
    private int mLeftPageBounds;
    private Drawable mMarginDrawable;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private boolean mNeedCalculatePageOffsets;
    private PagerObserver mObserver;
    private int mOffscreenPageLimit;
    private ViewPager.j mOnPageChangeListener;
    private int mPageMargin;
    private ViewPager.k mPageTransformer;
    private boolean mPopulatePending;
    private Parcelable mRestoredAdapterState;
    private ClassLoader mRestoredClassLoader;
    private int mRestoredCurItem;
    private int mRightPageBounds;
    private int mScrollState;
    private Scroller mScroller;
    private boolean mScrollingCacheEnabled;
    private Method mSetChildrenDrawingOrderEnabled;
    private final ItemInfo mTempItem;
    private final Rect mTempRect;
    private i mTopEdge;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private static final int[] LAYOUT_ATTRS = {R.attr.layout_gravity};
    private static final Comparator<ItemInfo> COMPARATOR = new Comparator<ItemInfo>() { // from class: com.mobile.brasiltv.view.shortvideo.VerticalViewPager.1
        @Override // java.util.Comparator
        public int compare(ItemInfo itemInfo, ItemInfo itemInfo2) {
            return itemInfo.position - itemInfo2.position;
        }
    };
    private static final Interpolator sInterpolator = new Interpolator() { // from class: com.mobile.brasiltv.view.shortvideo.VerticalViewPager.2
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f10) {
            float f11 = f10 - 1.0f;
            return (f11 * f11 * f11 * f11 * f11) + 1.0f;
        }
    };
    private static final ViewPositionComparator sPositionComparator = new ViewPositionComparator();

    public interface Decor {
    }

    public static class ItemInfo {
        float heightFactor;
        Object object;
        float offset;
        int position;
        boolean scrolling;
    }

    public class MyAccessibilityDelegate extends b0.a {
        public MyAccessibilityDelegate() {
        }

        private boolean canScroll() {
            return VerticalViewPager.this.mAdapter != null && VerticalViewPager.this.mAdapter.getCount() > 1;
        }

        @Override // b0.a
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            k0 a10 = k0.a();
            a10.f(canScroll());
            if (accessibilityEvent.getEventType() != 4096 || VerticalViewPager.this.mAdapter == null) {
                return;
            }
            a10.c(VerticalViewPager.this.mAdapter.getCount());
            a10.b(VerticalViewPager.this.mCurItem);
            a10.h(VerticalViewPager.this.mCurItem);
        }

        @Override // b0.a
        public void onInitializeAccessibilityNodeInfo(View view, g0 g0Var) {
            super.onInitializeAccessibilityNodeInfo(view, g0Var);
            g0Var.W(ViewPager.class.getName());
            g0Var.o0(canScroll());
            if (VerticalViewPager.this.internalCanScrollVertically(1)) {
                g0Var.a(4096);
            }
            if (VerticalViewPager.this.internalCanScrollVertically(-1)) {
                g0Var.a(8192);
            }
        }

        @Override // b0.a
        public boolean performAccessibilityAction(View view, int i10, Bundle bundle) {
            if (super.performAccessibilityAction(view, i10, bundle)) {
                return true;
            }
            if (i10 == 4096) {
                if (!VerticalViewPager.this.internalCanScrollVertically(1)) {
                    return false;
                }
                VerticalViewPager verticalViewPager = VerticalViewPager.this;
                verticalViewPager.setCurrentItem(verticalViewPager.mCurItem + 1);
                return true;
            }
            if (i10 != 8192 || !VerticalViewPager.this.internalCanScrollVertically(-1)) {
                return false;
            }
            VerticalViewPager verticalViewPager2 = VerticalViewPager.this;
            verticalViewPager2.setCurrentItem(verticalViewPager2.mCurItem - 1);
            return true;
        }
    }

    public interface OnAdapterChangeListener {
        void onAdapterChanged(androidx.viewpager.widget.a aVar, androidx.viewpager.widget.a aVar2);
    }

    public class PagerObserver extends DataSetObserver {
        @Override // android.database.DataSetObserver
        public void onChanged() {
            VerticalViewPager.this.dataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            VerticalViewPager.this.dataSetChanged();
        }

        private PagerObserver() {
        }
    }

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = o.a(new p() { // from class: com.mobile.brasiltv.view.shortvideo.VerticalViewPager.SavedState.1
            @Override // x.p
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // x.p
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        });
        Parcelable adapterState;
        ClassLoader loader;
        int position;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.position + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.position);
            parcel.writeParcelable(this.adapterState, i10);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            classLoader = classLoader == null ? getClass().getClassLoader() : classLoader;
            this.position = parcel.readInt();
            this.adapterState = parcel.readParcelable(classLoader);
            this.loader = classLoader;
        }
    }

    public static class ViewPositionComparator implements Comparator<View> {
        @Override // java.util.Comparator
        public int compare(View view, View view2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
            boolean z10 = layoutParams.isDecor;
            return z10 != layoutParams2.isDecor ? z10 ? 1 : -1 : layoutParams.position - layoutParams2.position;
        }
    }

    public VerticalViewPager(Context context) {
        super(context);
        this.TYPE_VIEW_SCROLLED = 4096;
        this.mItems = new ArrayList<>();
        this.mTempItem = new ItemInfo();
        this.mTempRect = new Rect();
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        this.mFirstOffset = -3.4028235E38f;
        this.mLastOffset = Float.MAX_VALUE;
        this.mOffscreenPageLimit = 1;
        this.mActivePointerId = -1;
        this.mFirstLayout = true;
        this.mNeedCalculatePageOffsets = false;
        this.mEndScrollRunnable = new Runnable() { // from class: com.mobile.brasiltv.view.shortvideo.VerticalViewPager.3
            @Override // java.lang.Runnable
            public void run() {
                VerticalViewPager.this.setScrollState(0);
                VerticalViewPager.this.populate();
            }
        };
        this.mScrollState = 0;
        initViewPager();
    }

    private void calculatePageOffsets(ItemInfo itemInfo, int i10, ItemInfo itemInfo2) {
        int i11;
        int i12;
        ItemInfo itemInfo3;
        ItemInfo itemInfo4;
        int count = this.mAdapter.getCount();
        int clientHeight = getClientHeight();
        float f10 = clientHeight > 0 ? this.mPageMargin / clientHeight : 0.0f;
        if (itemInfo2 != null) {
            int i13 = itemInfo2.position;
            int i14 = itemInfo.position;
            if (i13 < i14) {
                float f11 = itemInfo2.offset + itemInfo2.heightFactor + f10;
                int i15 = i13 + 1;
                int i16 = 0;
                while (i15 <= itemInfo.position && i16 < this.mItems.size()) {
                    ItemInfo itemInfo5 = this.mItems.get(i16);
                    while (true) {
                        itemInfo4 = itemInfo5;
                        if (i15 <= itemInfo4.position || i16 >= this.mItems.size() - 1) {
                            break;
                        }
                        i16++;
                        itemInfo5 = this.mItems.get(i16);
                    }
                    while (i15 < itemInfo4.position) {
                        f11 += this.mAdapter.getPageWidth(i15) + f10;
                        i15++;
                    }
                    itemInfo4.offset = f11;
                    f11 += itemInfo4.heightFactor + f10;
                    i15++;
                }
            } else if (i13 > i14) {
                int size = this.mItems.size() - 1;
                float f12 = itemInfo2.offset;
                while (true) {
                    i13--;
                    if (i13 < itemInfo.position || size < 0) {
                        break;
                    }
                    ItemInfo itemInfo6 = this.mItems.get(size);
                    while (true) {
                        itemInfo3 = itemInfo6;
                        if (i13 >= itemInfo3.position || size <= 0) {
                            break;
                        }
                        size--;
                        itemInfo6 = this.mItems.get(size);
                    }
                    while (i13 > itemInfo3.position) {
                        f12 -= this.mAdapter.getPageWidth(i13) + f10;
                        i13--;
                    }
                    f12 -= itemInfo3.heightFactor + f10;
                    itemInfo3.offset = f12;
                }
            }
        }
        int size2 = this.mItems.size();
        float f13 = itemInfo.offset;
        int i17 = itemInfo.position;
        int i18 = i17 - 1;
        this.mFirstOffset = i17 == 0 ? f13 : -3.4028235E38f;
        int i19 = count - 1;
        this.mLastOffset = i17 == i19 ? (itemInfo.heightFactor + f13) - 1.0f : Float.MAX_VALUE;
        int i20 = i10 - 1;
        while (i20 >= 0) {
            ItemInfo itemInfo7 = this.mItems.get(i20);
            while (true) {
                i12 = itemInfo7.position;
                if (i18 <= i12) {
                    break;
                }
                f13 -= this.mAdapter.getPageWidth(i18) + f10;
                i18--;
            }
            f13 -= itemInfo7.heightFactor + f10;
            itemInfo7.offset = f13;
            if (i12 == 0) {
                this.mFirstOffset = f13;
            }
            i20--;
            i18--;
        }
        float f14 = itemInfo.offset + itemInfo.heightFactor + f10;
        int i21 = itemInfo.position + 1;
        int i22 = i10 + 1;
        while (i22 < size2) {
            ItemInfo itemInfo8 = this.mItems.get(i22);
            while (true) {
                i11 = itemInfo8.position;
                if (i21 >= i11) {
                    break;
                }
                f14 += this.mAdapter.getPageWidth(i21) + f10;
                i21++;
            }
            if (i11 == i19) {
                this.mLastOffset = (itemInfo8.heightFactor + f14) - 1.0f;
            }
            itemInfo8.offset = f14;
            f14 += itemInfo8.heightFactor + f10;
            i22++;
            i21++;
        }
        this.mNeedCalculatePageOffsets = false;
    }

    private void completeScroll(boolean z10) {
        boolean z11 = this.mScrollState == 2;
        if (z11) {
            setScrollingCacheEnabled(false);
            this.mScroller.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                scrollTo(currX, currY);
            }
        }
        this.mPopulatePending = false;
        for (int i10 = 0; i10 < this.mItems.size(); i10++) {
            ItemInfo itemInfo = this.mItems.get(i10);
            if (itemInfo.scrolling) {
                itemInfo.scrolling = false;
                z11 = true;
            }
        }
        if (z11) {
            if (z10) {
                c1.c0(this, this.mEndScrollRunnable);
            } else {
                this.mEndScrollRunnable.run();
            }
        }
    }

    private int determineTargetPage(int i10, float f10, int i11, int i12) {
        if (Math.abs(i12) <= this.mFlingDistance || Math.abs(i11) <= this.mMinimumVelocity) {
            i10 = (int) (i10 + f10 + (i10 >= this.mCurItem ? 0.4f : 0.6f));
        } else if (i11 <= 0) {
            i10++;
        }
        if (this.mItems.size() <= 0) {
            return i10;
        }
        return Math.max(this.mItems.get(0).position, Math.min(i10, this.mItems.get(r4.size() - 1).position));
    }

    private void enableLayers(boolean z10) {
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            c1.x0(getChildAt(i10), z10 ? 2 : 0, null);
        }
    }

    private void endDrag() {
        this.mIsBeingDragged = false;
        this.mIsUnableToDrag = false;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private Rect getChildRectInPagerCoordinates(Rect rect, View view) {
        if (rect == null) {
            rect = new Rect();
        }
        if (view == null) {
            rect.set(0, 0, 0, 0);
            return rect;
        }
        rect.left = view.getLeft();
        rect.right = view.getRight();
        rect.top = view.getTop();
        rect.bottom = view.getBottom();
        ViewParent parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = (ViewGroup) parent;
            rect.left += viewGroup.getLeft();
            rect.right += viewGroup.getRight();
            rect.top += viewGroup.getTop();
            rect.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect;
    }

    private int getClientHeight() {
        return (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
    }

    private ItemInfo infoForCurrentScrollPosition() {
        int i10;
        int clientHeight = getClientHeight();
        float f10 = 0.0f;
        float scrollY = clientHeight > 0 ? getScrollY() / clientHeight : 0.0f;
        float f11 = clientHeight > 0 ? this.mPageMargin / clientHeight : 0.0f;
        ItemInfo itemInfo = null;
        float f12 = 0.0f;
        int i11 = -1;
        int i12 = 0;
        boolean z10 = true;
        while (i12 < this.mItems.size()) {
            ItemInfo itemInfo2 = this.mItems.get(i12);
            if (!z10 && itemInfo2.position != (i10 = i11 + 1)) {
                itemInfo2 = this.mTempItem;
                itemInfo2.offset = f10 + f12 + f11;
                itemInfo2.position = i10;
                itemInfo2.heightFactor = this.mAdapter.getPageWidth(i10);
                i12--;
            }
            ItemInfo itemInfo3 = itemInfo2;
            f10 = itemInfo3.offset;
            float f13 = itemInfo3.heightFactor + f10 + f11;
            if (!z10 && scrollY < f10) {
                return itemInfo;
            }
            if (scrollY < f13 || i12 == this.mItems.size() - 1) {
                return itemInfo3;
            }
            int i13 = itemInfo3.position;
            float f14 = itemInfo3.heightFactor;
            i12++;
            z10 = false;
            i11 = i13;
            f12 = f14;
            itemInfo = itemInfo3;
        }
        return itemInfo;
    }

    private boolean isGutterDrag(float f10, float f11) {
        return (f10 < ((float) this.mGutterSize) && f11 > 0.0f) || (f10 > ((float) (getHeight() - this.mGutterSize)) && f11 < 0.0f);
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int b10 = u.b(motionEvent);
        if (u.d(motionEvent, b10) == this.mActivePointerId) {
            int i10 = b10 == 0 ? 1 : 0;
            this.mLastMotionY = u.f(motionEvent, i10);
            this.mActivePointerId = u.d(motionEvent, i10);
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private boolean pageScrolled(int i10) {
        if (this.mItems.size() == 0) {
            this.mCalledSuper = false;
            onPageScrolled(0, 0.0f, 0);
            if (this.mCalledSuper) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
        ItemInfo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
        int clientHeight = getClientHeight();
        int i11 = this.mPageMargin;
        int i12 = clientHeight + i11;
        float f10 = clientHeight;
        int i13 = infoForCurrentScrollPosition.position;
        float f11 = ((i10 / f10) - infoForCurrentScrollPosition.offset) / (infoForCurrentScrollPosition.heightFactor + (i11 / f10));
        this.mCalledSuper = false;
        onPageScrolled(i13, f11, (int) (i12 * f11));
        if (this.mCalledSuper) {
            return true;
        }
        throw new IllegalStateException("onPageScrolled did not call superclass implementation");
    }

    private boolean performDrag(float f10) {
        boolean z10;
        float f11 = this.mLastMotionY - f10;
        this.mLastMotionY = f10;
        float scrollY = getScrollY() + f11;
        float clientHeight = getClientHeight();
        float f12 = this.mFirstOffset * clientHeight;
        float f13 = this.mLastOffset * clientHeight;
        ItemInfo itemInfo = this.mItems.get(0);
        ArrayList<ItemInfo> arrayList = this.mItems;
        boolean z11 = true;
        ItemInfo itemInfo2 = arrayList.get(arrayList.size() - 1);
        if (itemInfo.position != 0) {
            f12 = itemInfo.offset * clientHeight;
            z10 = false;
        } else {
            z10 = true;
        }
        if (itemInfo2.position != this.mAdapter.getCount() - 1) {
            f13 = itemInfo2.offset * clientHeight;
            z11 = false;
        }
        if (scrollY < f12) {
            r4 = z10 ? this.mTopEdge.e(Math.abs(f12 - scrollY) / clientHeight) : false;
            scrollY = f12;
        } else if (scrollY > f13) {
            r4 = z11 ? this.mBottomEdge.e(Math.abs(scrollY - f13) / clientHeight) : false;
            scrollY = f13;
        }
        int i10 = (int) scrollY;
        this.mLastMotionX += scrollY - i10;
        scrollTo(getScrollX(), i10);
        pageScrolled(i10);
        return r4;
    }

    private void recomputeScrollPosition(int i10, int i11, int i12, int i13) {
        if (i11 <= 0 || this.mItems.isEmpty()) {
            ItemInfo infoForPosition = infoForPosition(this.mCurItem);
            int min = (int) ((infoForPosition != null ? Math.min(infoForPosition.offset, this.mLastOffset) : 0.0f) * ((i10 - getPaddingTop()) - getPaddingBottom()));
            if (min != getScrollY()) {
                completeScroll(false);
                scrollTo(getScrollX(), min);
                return;
            }
            return;
        }
        int scrollY = (int) ((getScrollY() / (((i11 - getPaddingTop()) - getPaddingBottom()) + i13)) * (((i10 - getPaddingTop()) - getPaddingBottom()) + i12));
        scrollTo(getScrollX(), scrollY);
        if (this.mScroller.isFinished()) {
            return;
        }
        this.mScroller.startScroll(0, scrollY, 0, (int) (infoForPosition(this.mCurItem).offset * i10), this.mScroller.getDuration() - this.mScroller.timePassed());
    }

    private void removeNonDecorViews() {
        int i10 = 0;
        while (i10 < getChildCount()) {
            if (!((LayoutParams) getChildAt(i10).getLayoutParams()).isDecor) {
                removeViewAt(i10);
                i10--;
            }
            i10++;
        }
    }

    private void requestParentDisallowInterceptTouchEvent(boolean z10) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z10);
        }
    }

    private void scrollToItem(int i10, boolean z10, int i11, boolean z11) {
        ViewPager.j jVar;
        ViewPager.j jVar2;
        ViewPager.j jVar3;
        ViewPager.j jVar4;
        ItemInfo infoForPosition = infoForPosition(i10);
        int clientHeight = infoForPosition != null ? (int) (getClientHeight() * Math.max(this.mFirstOffset, Math.min(infoForPosition.offset, this.mLastOffset))) : 0;
        if (z10) {
            smoothScrollTo(0, clientHeight, i11);
            if (z11 && (jVar4 = this.mOnPageChangeListener) != null) {
                jVar4.onPageSelected(i10);
            }
            if (!z11 || (jVar3 = this.mInternalPageChangeListener) == null) {
                return;
            }
            jVar3.onPageSelected(i10);
            return;
        }
        if (z11 && (jVar2 = this.mOnPageChangeListener) != null) {
            jVar2.onPageSelected(i10);
        }
        if (z11 && (jVar = this.mInternalPageChangeListener) != null) {
            jVar.onPageSelected(i10);
        }
        completeScroll(false);
        scrollTo(0, clientHeight);
        pageScrolled(clientHeight);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScrollState(int i10) {
        if (this.mScrollState == i10) {
            return;
        }
        this.mScrollState = i10;
        if (this.mPageTransformer != null) {
            enableLayers(i10 != 0);
        }
        ViewPager.j jVar = this.mOnPageChangeListener;
        if (jVar != null) {
            jVar.onPageScrollStateChanged(i10);
        }
    }

    private void setScrollingCacheEnabled(boolean z10) {
        if (this.mScrollingCacheEnabled != z10) {
            this.mScrollingCacheEnabled = z10;
        }
    }

    private void sortChildDrawingOrder() {
        if (this.mDrawingOrder != 0) {
            ArrayList<View> arrayList = this.mDrawingOrderedChildren;
            if (arrayList == null) {
                this.mDrawingOrderedChildren = new ArrayList<>();
            } else {
                arrayList.clear();
            }
            int childCount = getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                this.mDrawingOrderedChildren.add(getChildAt(i10));
            }
            Collections.sort(this.mDrawingOrderedChildren, sPositionComparator);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i10, int i11) {
        ItemInfo infoForChild;
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i12 = 0; i12 < getChildCount(); i12++) {
                View childAt = getChildAt(i12);
                if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.position == this.mCurItem) {
                    childAt.addFocusables(arrayList, i10, i11);
                }
            }
        }
        if ((descendantFocusability != 262144 || size == arrayList.size()) && isFocusable()) {
            if ((i11 & 1) == 1 && isInTouchMode() && !isFocusableInTouchMode()) {
                return;
            }
            arrayList.add(this);
        }
    }

    public ItemInfo addNewItem(int i10, int i11) {
        ItemInfo itemInfo = new ItemInfo();
        itemInfo.position = i10;
        itemInfo.object = this.mAdapter.instantiateItem((ViewGroup) this, i10);
        itemInfo.heightFactor = this.mAdapter.getPageWidth(i10);
        if (i11 < 0 || i11 >= this.mItems.size()) {
            this.mItems.add(itemInfo);
        } else {
            this.mItems.add(i11, itemInfo);
        }
        return itemInfo;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addTouchables(ArrayList<View> arrayList) {
        ItemInfo infoForChild;
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.position == this.mCurItem) {
                childAt.addTouchables(arrayList);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i10, ViewGroup.LayoutParams layoutParams) {
        if (!checkLayoutParams(layoutParams)) {
            layoutParams = generateLayoutParams(layoutParams);
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        boolean z10 = layoutParams2.isDecor | (view instanceof Decor);
        layoutParams2.isDecor = z10;
        if (!this.mInLayout) {
            super.addView(view, i10, layoutParams);
        } else {
            if (z10) {
                throw new IllegalStateException("Cannot add pager decor view during layout");
            }
            layoutParams2.needsMeasure = true;
            addViewInLayout(view, i10, layoutParams);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean arrowScroll(int i10) {
        boolean z10;
        View findNextFocus;
        boolean requestFocus;
        View findFocus = findFocus();
        boolean z11 = false;
        if (findFocus != this) {
            if (findFocus != null) {
                ViewParent parent = findFocus.getParent();
                while (true) {
                    if (!(parent instanceof ViewGroup)) {
                        z10 = false;
                        break;
                    }
                    if (parent == this) {
                        z10 = true;
                        break;
                    }
                    parent = parent.getParent();
                }
                if (!z10) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(findFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        sb.append(" => ");
                        sb.append(parent2.getClass().getSimpleName());
                    }
                    Log.e(TAG, "arrowScroll tried to find focus based on non-child current focused view " + sb.toString());
                }
            }
            findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i10);
            if (findNextFocus == null && findNextFocus != findFocus) {
                if (i10 == 33) {
                    requestFocus = (findFocus == null || getChildRectInPagerCoordinates(this.mTempRect, findNextFocus).top < getChildRectInPagerCoordinates(this.mTempRect, findFocus).top) ? findNextFocus.requestFocus() : pageUp();
                } else if (i10 == 130) {
                    requestFocus = (findFocus == null || getChildRectInPagerCoordinates(this.mTempRect, findNextFocus).bottom > getChildRectInPagerCoordinates(this.mTempRect, findFocus).bottom) ? findNextFocus.requestFocus() : pageDown();
                }
                z11 = requestFocus;
            } else if (i10 != 33 || i10 == 1) {
                z11 = pageUp();
            } else if (i10 == 130 || i10 == 2) {
                z11 = pageDown();
            }
            if (z11) {
                playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i10));
            }
            return z11;
        }
        findFocus = null;
        findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i10);
        if (findNextFocus == null) {
        }
        if (i10 != 33) {
        }
        z11 = pageUp();
        if (z11) {
        }
        return z11;
    }

    public boolean beginFakeDrag() {
        if (this.mIsBeingDragged) {
            return false;
        }
        this.mFakeDragging = true;
        setScrollState(1);
        this.mLastMotionY = 0.0f;
        this.mInitialMotionY = 0.0f;
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, 0.0f, 0.0f, 0);
        this.mVelocityTracker.addMovement(obtain);
        obtain.recycle();
        this.mFakeDragBeginTime = uptimeMillis;
        return true;
    }

    public boolean canScroll(View view, boolean z10, int i10, int i11, int i12) {
        int i13;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                int i14 = i12 + scrollY;
                if (i14 >= childAt.getTop() && i14 < childAt.getBottom() && (i13 = i11 + scrollX) >= childAt.getLeft() && i13 < childAt.getRight() && canScroll(childAt, true, i10, i13 - childAt.getLeft(), i14 - childAt.getTop())) {
                    return true;
                }
            }
        }
        return z10 && c1.d(view, -i10);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.isFinished() || !this.mScroller.computeScrollOffset()) {
            completeScroll(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.mScroller.getCurrX();
        int currY = this.mScroller.getCurrY();
        if (scrollX != currX || scrollY != currY) {
            scrollTo(currX, currY);
            if (!pageScrolled(currY)) {
                this.mScroller.abortAnimation();
                scrollTo(currX, 0);
            }
        }
        c1.b0(this);
    }

    void dataSetChanged() {
        int count = this.mAdapter.getCount();
        this.mExpectedAdapterCount = count;
        boolean z10 = this.mItems.size() < (this.mOffscreenPageLimit * 2) + 1 && this.mItems.size() < count;
        int i10 = this.mCurItem;
        int i11 = 0;
        boolean z11 = false;
        while (i11 < this.mItems.size()) {
            ItemInfo itemInfo = this.mItems.get(i11);
            int itemPosition = this.mAdapter.getItemPosition(itemInfo.object);
            if (itemPosition != -1) {
                if (itemPosition == -2) {
                    this.mItems.remove(i11);
                    i11--;
                    if (!z11) {
                        this.mAdapter.startUpdate((ViewGroup) this);
                        z11 = true;
                    }
                    this.mAdapter.destroyItem((ViewGroup) this, itemInfo.position, itemInfo.object);
                    int i12 = this.mCurItem;
                    if (i12 == itemInfo.position) {
                        i10 = Math.max(0, Math.min(i12, count - 1));
                    }
                } else {
                    int i13 = itemInfo.position;
                    if (i13 != itemPosition) {
                        if (i13 == this.mCurItem) {
                            i10 = itemPosition;
                        }
                        itemInfo.position = itemPosition;
                    }
                }
                z10 = true;
            }
            i11++;
        }
        if (z11) {
            this.mAdapter.finishUpdate((ViewGroup) this);
        }
        Collections.sort(this.mItems, COMPARATOR);
        if (z10) {
            int childCount = getChildCount();
            for (int i14 = 0; i14 < childCount; i14++) {
                LayoutParams layoutParams = (LayoutParams) getChildAt(i14).getLayoutParams();
                if (!layoutParams.isDecor) {
                    layoutParams.heightFactor = 0.0f;
                }
            }
            setCurrentItemInternal(i10, false, true);
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        ItemInfo infoForChild;
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.position == this.mCurItem && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                return true;
            }
        }
        return false;
    }

    float distanceInfluenceForSnapDuration(float f10) {
        Double.isNaN(f10 - 0.5f);
        return (float) Math.sin((float) (r0 * 0.4712389167638204d));
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        androidx.viewpager.widget.a aVar;
        super.draw(canvas);
        int D = c1.D(this);
        boolean z10 = false;
        if (D == 0 || (D == 1 && (aVar = this.mAdapter) != null && aVar.getCount() > 1)) {
            if (!this.mTopEdge.c()) {
                int save = canvas.save();
                int height = getHeight();
                int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                canvas.translate(getPaddingLeft(), this.mFirstOffset * height);
                this.mTopEdge.g(width, height);
                z10 = false | this.mTopEdge.a(canvas);
                canvas.restoreToCount(save);
            }
            if (!this.mBottomEdge.c()) {
                int save2 = canvas.save();
                int height2 = getHeight();
                int width2 = (getWidth() - getPaddingLeft()) - getPaddingRight();
                canvas.rotate(180.0f);
                canvas.translate((-width2) - getPaddingLeft(), (-(this.mLastOffset + 1.0f)) * height2);
                this.mBottomEdge.g(width2, height2);
                z10 |= this.mBottomEdge.a(canvas);
                canvas.restoreToCount(save2);
            }
        } else {
            this.mTopEdge.b();
            this.mBottomEdge.b();
        }
        if (z10) {
            c1.b0(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.mMarginDrawable;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(getDrawableState());
    }

    public void endFakeDrag() {
        if (!this.mFakeDragging) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }
        VelocityTracker velocityTracker = this.mVelocityTracker;
        velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
        int b10 = (int) h0.b(velocityTracker, this.mActivePointerId);
        this.mPopulatePending = true;
        int clientHeight = getClientHeight();
        int scrollY = getScrollY();
        ItemInfo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
        setCurrentItemInternal(determineTargetPage(infoForCurrentScrollPosition.position, ((scrollY / clientHeight) - infoForCurrentScrollPosition.offset) / infoForCurrentScrollPosition.heightFactor, b10, (int) (this.mLastMotionY - this.mInitialMotionY)), true, true, b10);
        endDrag();
        this.mFakeDragging = false;
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 21) {
                return arrowScroll(17);
            }
            if (keyCode == 22) {
                return arrowScroll(66);
            }
            if (keyCode == 61) {
                if (keyEvent.hasNoModifiers()) {
                    return arrowScroll(2);
                }
                if (keyEvent.hasModifiers(1)) {
                    return arrowScroll(1);
                }
            }
        }
        return false;
    }

    public void fakeDragBy(float f10) {
        if (!this.mFakeDragging) {
            throw new IllegalStateException("No fake drag in progress. Call beginFakeDrag first.");
        }
        this.mLastMotionY += f10;
        float scrollY = getScrollY() - f10;
        float clientHeight = getClientHeight();
        float f11 = this.mFirstOffset * clientHeight;
        float f12 = this.mLastOffset * clientHeight;
        ItemInfo itemInfo = this.mItems.get(0);
        ItemInfo itemInfo2 = this.mItems.get(r4.size() - 1);
        if (itemInfo.position != 0) {
            f11 = itemInfo.offset * clientHeight;
        }
        if (itemInfo2.position != this.mAdapter.getCount() - 1) {
            f12 = itemInfo2.offset * clientHeight;
        }
        if (scrollY < f11) {
            scrollY = f11;
        } else if (scrollY > f12) {
            scrollY = f12;
        }
        int i10 = (int) scrollY;
        this.mLastMotionY += scrollY - i10;
        scrollTo(getScrollX(), i10);
        pageScrolled(i10);
        MotionEvent obtain = MotionEvent.obtain(this.mFakeDragBeginTime, SystemClock.uptimeMillis(), 2, 0.0f, this.mLastMotionY, 0);
        this.mVelocityTracker.addMovement(obtain);
        obtain.recycle();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    public androidx.viewpager.widget.a getAdapter() {
        return this.mAdapter;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i10, int i11) {
        if (this.mDrawingOrder == 2) {
            i11 = (i10 - 1) - i11;
        }
        return ((LayoutParams) this.mDrawingOrderedChildren.get(i11).getLayoutParams()).childIndex;
    }

    public int getCurrentItem() {
        return this.mCurItem;
    }

    public int getOffscreenPageLimit() {
        return this.mOffscreenPageLimit;
    }

    public int getPageMargin() {
        return this.mPageMargin;
    }

    public ItemInfo infoForAnyChild(View view) {
        while (true) {
            Object parent = view.getParent();
            if (parent == this) {
                return infoForChild(view);
            }
            if (parent == null || !(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
    }

    public ItemInfo infoForChild(View view) {
        for (int i10 = 0; i10 < this.mItems.size(); i10++) {
            ItemInfo itemInfo = this.mItems.get(i10);
            if (this.mAdapter.isViewFromObject(view, itemInfo.object)) {
                return itemInfo;
            }
        }
        return null;
    }

    public ItemInfo infoForPosition(int i10) {
        for (int i11 = 0; i11 < this.mItems.size(); i11++) {
            ItemInfo itemInfo = this.mItems.get(i11);
            if (itemInfo.position == i10) {
                return itemInfo;
            }
        }
        return null;
    }

    void initViewPager() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.mScroller = new Scroller(context, sInterpolator);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f10 = context.getResources().getDisplayMetrics().density;
        this.mTouchSlop = p1.d(viewConfiguration);
        this.mMinimumVelocity = (int) (400.0f * f10);
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mTopEdge = new i(context);
        this.mBottomEdge = new i(context);
        this.mFlingDistance = (int) (25.0f * f10);
        this.mCloseEnough = (int) (2.0f * f10);
        this.mDefaultGutterSize = (int) (f10 * 16.0f);
        c1.k0(this, new MyAccessibilityDelegate());
        if (c1.x(this) == 0) {
            c1.v0(this, 1);
        }
    }

    public boolean internalCanScrollVertically(int i10) {
        if (this.mAdapter == null) {
            return false;
        }
        int clientHeight = getClientHeight();
        int scrollY = getScrollY();
        return i10 < 0 ? scrollY > ((int) (((float) clientHeight) * this.mFirstOffset)) : i10 > 0 && scrollY < ((int) (((float) clientHeight) * this.mLastOffset));
    }

    public boolean isFakeDragging() {
        return this.mFakeDragging;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mFirstLayout = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.mEndScrollRunnable);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i10;
        float f10;
        float f11;
        super.onDraw(canvas);
        if (this.mPageMargin <= 0 || this.mMarginDrawable == null || this.mItems.size() <= 0 || this.mAdapter == null) {
            return;
        }
        int scrollY = getScrollY();
        float height = getHeight();
        float f12 = this.mPageMargin / height;
        int i11 = 0;
        ItemInfo itemInfo = this.mItems.get(0);
        float f13 = itemInfo.offset;
        int size = this.mItems.size();
        int i12 = itemInfo.position;
        int i13 = this.mItems.get(size - 1).position;
        while (i12 < i13) {
            while (true) {
                i10 = itemInfo.position;
                if (i12 <= i10 || i11 >= size) {
                    break;
                }
                i11++;
                itemInfo = this.mItems.get(i11);
            }
            if (i12 == i10) {
                float f14 = itemInfo.offset;
                float f15 = itemInfo.heightFactor;
                f10 = (f14 + f15) * height;
                f13 = f14 + f15 + f12;
            } else {
                float pageWidth = this.mAdapter.getPageWidth(i12);
                f10 = (f13 + pageWidth) * height;
                f13 += pageWidth + f12;
            }
            int i14 = this.mPageMargin;
            if (i14 + f10 > scrollY) {
                f11 = f12;
                this.mMarginDrawable.setBounds(this.mLeftPageBounds, (int) f10, this.mRightPageBounds, (int) (i14 + f10 + 0.5f));
                this.mMarginDrawable.draw(canvas);
            } else {
                f11 = f12;
            }
            if (f10 > scrollY + r2) {
                return;
            }
            i12++;
            f12 = f11;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            this.mIsBeingDragged = false;
            this.mIsUnableToDrag = false;
            this.mActivePointerId = -1;
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.mVelocityTracker = null;
            }
            return false;
        }
        if (action != 0) {
            if (this.mIsBeingDragged) {
                return true;
            }
            if (this.mIsUnableToDrag) {
                return false;
            }
        }
        if (action == 0) {
            float x10 = motionEvent.getX();
            this.mInitialMotionX = x10;
            this.mLastMotionX = x10;
            float y10 = motionEvent.getY();
            this.mInitialMotionY = y10;
            this.mLastMotionY = y10;
            this.mActivePointerId = u.d(motionEvent, 0);
            this.mIsUnableToDrag = false;
            this.mScroller.computeScrollOffset();
            if (this.mScrollState != 2 || Math.abs(this.mScroller.getFinalY() - this.mScroller.getCurrY()) <= this.mCloseEnough) {
                completeScroll(false);
                this.mIsBeingDragged = false;
            } else {
                this.mScroller.abortAnimation();
                this.mPopulatePending = false;
                populate();
                this.mIsBeingDragged = true;
                requestParentDisallowInterceptTouchEvent(true);
                setScrollState(1);
            }
        } else if (action == 2) {
            int i10 = this.mActivePointerId;
            if (i10 != -1) {
                int a10 = u.a(motionEvent, i10);
                float f10 = u.f(motionEvent, a10);
                float f11 = f10 - this.mLastMotionY;
                float abs = Math.abs(f11);
                float e10 = u.e(motionEvent, a10);
                float abs2 = Math.abs(e10 - this.mInitialMotionX);
                if (f11 != 0.0f && !isGutterDrag(this.mLastMotionY, f11) && canScroll(this, false, (int) f11, (int) e10, (int) f10)) {
                    this.mLastMotionX = e10;
                    this.mLastMotionY = f10;
                    this.mIsUnableToDrag = true;
                    return false;
                }
                int i11 = this.mTouchSlop;
                if (abs > i11 && abs * 0.5f > abs2) {
                    this.mIsBeingDragged = true;
                    requestParentDisallowInterceptTouchEvent(true);
                    setScrollState(1);
                    this.mLastMotionY = f11 > 0.0f ? this.mInitialMotionY + this.mTouchSlop : this.mInitialMotionY - this.mTouchSlop;
                    this.mLastMotionX = e10;
                    setScrollingCacheEnabled(true);
                } else if (abs2 > i11) {
                    this.mIsUnableToDrag = true;
                }
                if (this.mIsBeingDragged && performDrag(f10)) {
                    c1.b0(this);
                }
            }
        } else if (action == 6) {
            onSecondaryPointerUp(motionEvent);
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        return this.mIsBeingDragged;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x008e  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        boolean z11;
        ItemInfo infoForChild;
        int max;
        int i14;
        int max2;
        int i15;
        int childCount = getChildCount();
        int i16 = i12 - i10;
        int i17 = i13 - i11;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollY = getScrollY();
        int i18 = 0;
        for (int i19 = 0; i19 < childCount; i19++) {
            View childAt = getChildAt(i19);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isDecor) {
                    int i20 = layoutParams.gravity;
                    int i21 = i20 & 7;
                    int i22 = i20 & 112;
                    if (i21 != 1) {
                        if (i21 == 3) {
                            i14 = childAt.getMeasuredWidth() + paddingLeft;
                        } else if (i21 != 5) {
                            i14 = paddingLeft;
                        } else {
                            max = (i16 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                        }
                        if (i22 == 16) {
                            if (i22 == 48) {
                                i15 = childAt.getMeasuredHeight() + paddingTop;
                            } else if (i22 != 80) {
                                i15 = paddingTop;
                            } else {
                                max2 = (i17 - paddingBottom) - childAt.getMeasuredHeight();
                                paddingBottom += childAt.getMeasuredHeight();
                            }
                            int i23 = paddingTop + scrollY;
                            childAt.layout(paddingLeft, i23, childAt.getMeasuredWidth() + paddingLeft, i23 + childAt.getMeasuredHeight());
                            i18++;
                            paddingTop = i15;
                            paddingLeft = i14;
                        } else {
                            max2 = Math.max((i17 - childAt.getMeasuredHeight()) / 2, paddingTop);
                        }
                        int i24 = max2;
                        i15 = paddingTop;
                        paddingTop = i24;
                        int i232 = paddingTop + scrollY;
                        childAt.layout(paddingLeft, i232, childAt.getMeasuredWidth() + paddingLeft, i232 + childAt.getMeasuredHeight());
                        i18++;
                        paddingTop = i15;
                        paddingLeft = i14;
                    } else {
                        max = Math.max((i16 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                    }
                    int i25 = max;
                    i14 = paddingLeft;
                    paddingLeft = i25;
                    if (i22 == 16) {
                    }
                    int i242 = max2;
                    i15 = paddingTop;
                    paddingTop = i242;
                    int i2322 = paddingTop + scrollY;
                    childAt.layout(paddingLeft, i2322, childAt.getMeasuredWidth() + paddingLeft, i2322 + childAt.getMeasuredHeight());
                    i18++;
                    paddingTop = i15;
                    paddingLeft = i14;
                }
            }
        }
        int i26 = (i17 - paddingTop) - paddingBottom;
        for (int i27 = 0; i27 < childCount; i27++) {
            View childAt2 = getChildAt(i27);
            if (childAt2.getVisibility() != 8) {
                LayoutParams layoutParams2 = (LayoutParams) childAt2.getLayoutParams();
                if (!layoutParams2.isDecor && (infoForChild = infoForChild(childAt2)) != null) {
                    float f10 = i26;
                    int i28 = ((int) (infoForChild.offset * f10)) + paddingTop;
                    if (layoutParams2.needsMeasure) {
                        layoutParams2.needsMeasure = false;
                        childAt2.measure(View.MeasureSpec.makeMeasureSpec((i16 - paddingLeft) - paddingRight, Ints.MAX_POWER_OF_TWO), View.MeasureSpec.makeMeasureSpec((int) (f10 * layoutParams2.heightFactor), Ints.MAX_POWER_OF_TWO));
                    }
                    childAt2.layout(paddingLeft, i28, childAt2.getMeasuredWidth() + paddingLeft, childAt2.getMeasuredHeight() + i28);
                }
            }
        }
        this.mLeftPageBounds = paddingLeft;
        this.mRightPageBounds = i16 - paddingRight;
        this.mDecorChildCount = i18;
        if (this.mFirstLayout) {
            z11 = false;
            scrollToItem(this.mCurItem, false, 0, false);
        } else {
            z11 = false;
        }
        this.mFirstLayout = z11;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0089  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMeasure(int i10, int i11) {
        LayoutParams layoutParams;
        LayoutParams layoutParams2;
        int i12;
        int i13;
        int i14;
        setMeasuredDimension(View.getDefaultSize(0, i10), View.getDefaultSize(0, i11));
        int measuredHeight = getMeasuredHeight();
        this.mGutterSize = Math.min(measuredHeight / 10, this.mDefaultGutterSize);
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        int paddingTop = (measuredHeight - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i15 = 0;
        while (true) {
            boolean z10 = true;
            int i16 = Ints.MAX_POWER_OF_TWO;
            if (i15 >= childCount) {
                break;
            }
            View childAt = getChildAt(i15);
            if (childAt.getVisibility() != 8 && (layoutParams2 = (LayoutParams) childAt.getLayoutParams()) != null && layoutParams2.isDecor) {
                int i17 = layoutParams2.gravity;
                int i18 = i17 & 7;
                int i19 = i17 & 112;
                boolean z11 = i19 == 48 || i19 == 80;
                if (i18 != 3 && i18 != 5) {
                    z10 = false;
                }
                int i20 = Integer.MIN_VALUE;
                if (z11) {
                    i20 = Ints.MAX_POWER_OF_TWO;
                } else if (z10) {
                    i12 = Ints.MAX_POWER_OF_TWO;
                    i13 = ((ViewGroup.LayoutParams) layoutParams2).width;
                    if (i13 == -2) {
                        if (i13 == -1) {
                            i13 = measuredWidth;
                        }
                        i20 = Ints.MAX_POWER_OF_TWO;
                    } else {
                        i13 = measuredWidth;
                    }
                    i14 = ((ViewGroup.LayoutParams) layoutParams2).height;
                    if (i14 != -2) {
                        i14 = paddingTop;
                        i16 = i12;
                    } else if (i14 == -1) {
                        i14 = paddingTop;
                    }
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(i13, i20), View.MeasureSpec.makeMeasureSpec(i14, i16));
                    if (!z11) {
                        paddingTop -= childAt.getMeasuredHeight();
                    } else if (z10) {
                        measuredWidth -= childAt.getMeasuredWidth();
                    }
                }
                i12 = Integer.MIN_VALUE;
                i13 = ((ViewGroup.LayoutParams) layoutParams2).width;
                if (i13 == -2) {
                }
                i14 = ((ViewGroup.LayoutParams) layoutParams2).height;
                if (i14 != -2) {
                }
                childAt.measure(View.MeasureSpec.makeMeasureSpec(i13, i20), View.MeasureSpec.makeMeasureSpec(i14, i16));
                if (!z11) {
                }
            }
            i15++;
        }
        this.mChildWidthMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, Ints.MAX_POWER_OF_TWO);
        this.mChildHeightMeasureSpec = View.MeasureSpec.makeMeasureSpec(paddingTop, Ints.MAX_POWER_OF_TWO);
        this.mInLayout = true;
        populate();
        this.mInLayout = false;
        int childCount2 = getChildCount();
        for (int i21 = 0; i21 < childCount2; i21++) {
            View childAt2 = getChildAt(i21);
            if (childAt2.getVisibility() != 8 && ((layoutParams = (LayoutParams) childAt2.getLayoutParams()) != null || !layoutParams.isDecor)) {
                childAt2.measure(this.mChildWidthMeasureSpec, View.MeasureSpec.makeMeasureSpec((int) (paddingTop * layoutParams.heightFactor), Ints.MAX_POWER_OF_TWO));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onPageScrolled(int i10, float f10, int i11) {
        int max;
        int i12;
        int top;
        if (this.mDecorChildCount > 0) {
            int scrollY = getScrollY();
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int height = getHeight();
            int childCount = getChildCount();
            for (int i13 = 0; i13 < childCount; i13++) {
                View childAt = getChildAt(i13);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.isDecor) {
                    int i14 = layoutParams.gravity & 112;
                    if (i14 != 16) {
                        if (i14 == 48) {
                            i12 = childAt.getHeight() + paddingTop;
                        } else if (i14 != 80) {
                            i12 = paddingTop;
                        } else {
                            max = (height - paddingBottom) - childAt.getMeasuredHeight();
                            paddingBottom += childAt.getMeasuredHeight();
                        }
                        top = (paddingTop + scrollY) - childAt.getTop();
                        if (top != 0) {
                            childAt.offsetTopAndBottom(top);
                        }
                        paddingTop = i12;
                    } else {
                        max = Math.max((height - childAt.getMeasuredHeight()) / 2, paddingTop);
                    }
                    int i15 = max;
                    i12 = paddingTop;
                    paddingTop = i15;
                    top = (paddingTop + scrollY) - childAt.getTop();
                    if (top != 0) {
                    }
                    paddingTop = i12;
                }
            }
        }
        ViewPager.j jVar = this.mOnPageChangeListener;
        if (jVar != null) {
            jVar.onPageScrolled(i10, f10, i11);
        }
        ViewPager.j jVar2 = this.mInternalPageChangeListener;
        if (jVar2 != null) {
            jVar2.onPageScrolled(i10, f10, i11);
        }
        if (this.mPageTransformer != null) {
            int scrollY2 = getScrollY();
            int childCount2 = getChildCount();
            for (int i16 = 0; i16 < childCount2; i16++) {
                View childAt2 = getChildAt(i16);
                if (!((LayoutParams) childAt2.getLayoutParams()).isDecor) {
                    this.mPageTransformer.transformPage(childAt2, (childAt2.getTop() - scrollY2) / getClientHeight());
                }
            }
        }
        this.mCalledSuper = true;
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i10, Rect rect) {
        int i11;
        int i12;
        int i13;
        ItemInfo infoForChild;
        int childCount = getChildCount();
        if ((i10 & 2) != 0) {
            i12 = childCount;
            i11 = 0;
            i13 = 1;
        } else {
            i11 = childCount - 1;
            i12 = -1;
            i13 = -1;
        }
        while (i11 != i12) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() == 0 && (infoForChild = infoForChild(childAt)) != null && infoForChild.position == this.mCurItem && childAt.requestFocus(i10, rect)) {
                return true;
            }
            i11 += i13;
        }
        return false;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        androidx.viewpager.widget.a aVar = this.mAdapter;
        if (aVar != null) {
            aVar.restoreState(savedState.adapterState, savedState.loader);
            setCurrentItemInternal(savedState.position, false, true);
        } else {
            this.mRestoredCurItem = savedState.position;
            this.mRestoredAdapterState = savedState.adapterState;
            this.mRestoredClassLoader = savedState.loader;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.position = this.mCurItem;
        androidx.viewpager.widget.a aVar = this.mAdapter;
        if (aVar != null) {
            savedState.adapterState = aVar.saveState();
        }
        return savedState;
    }

    @Override // android.view.View
    public void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        if (i11 != i13) {
            int i14 = this.mPageMargin;
            recomputeScrollPosition(i11, i13, i14, i14);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        androidx.viewpager.widget.a aVar;
        boolean f10;
        boolean f11;
        if (this.mFakeDragging) {
            return true;
        }
        boolean z10 = false;
        if ((motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) || (aVar = this.mAdapter) == null || aVar.getCount() == 0) {
            return false;
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.mScroller.abortAnimation();
            this.mPopulatePending = false;
            populate();
            float x10 = motionEvent.getX();
            this.mInitialMotionX = x10;
            this.mLastMotionX = x10;
            float y10 = motionEvent.getY();
            this.mInitialMotionY = y10;
            this.mLastMotionY = y10;
            this.mActivePointerId = u.d(motionEvent, 0);
        } else if (action != 1) {
            if (action == 2) {
                if (!this.mIsBeingDragged) {
                    int a10 = u.a(motionEvent, this.mActivePointerId);
                    float f12 = u.f(motionEvent, a10);
                    float abs = Math.abs(f12 - this.mLastMotionY);
                    float e10 = u.e(motionEvent, a10);
                    float abs2 = Math.abs(e10 - this.mLastMotionX);
                    if (abs > this.mTouchSlop && abs > abs2) {
                        this.mIsBeingDragged = true;
                        requestParentDisallowInterceptTouchEvent(true);
                        float f13 = this.mInitialMotionY;
                        this.mLastMotionY = f12 - f13 > 0.0f ? f13 + this.mTouchSlop : f13 - this.mTouchSlop;
                        this.mLastMotionX = e10;
                        setScrollState(1);
                        setScrollingCacheEnabled(true);
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }
                if (this.mIsBeingDragged) {
                    z10 = false | performDrag(u.f(motionEvent, u.a(motionEvent, this.mActivePointerId)));
                }
            } else if (action != 3) {
                if (action == 5) {
                    int b10 = u.b(motionEvent);
                    this.mLastMotionY = u.f(motionEvent, b10);
                    this.mActivePointerId = u.d(motionEvent, b10);
                } else if (action == 6) {
                    onSecondaryPointerUp(motionEvent);
                    this.mLastMotionY = u.f(motionEvent, u.a(motionEvent, this.mActivePointerId));
                }
            } else if (this.mIsBeingDragged) {
                scrollToItem(this.mCurItem, true, 0, false);
                this.mActivePointerId = -1;
                endDrag();
                f10 = this.mTopEdge.f();
                f11 = this.mBottomEdge.f();
                z10 = f10 | f11;
            }
        } else if (this.mIsBeingDragged) {
            VelocityTracker velocityTracker = this.mVelocityTracker;
            velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
            int b11 = (int) h0.b(velocityTracker, this.mActivePointerId);
            this.mPopulatePending = true;
            int clientHeight = getClientHeight();
            int scrollY = getScrollY();
            ItemInfo infoForCurrentScrollPosition = infoForCurrentScrollPosition();
            setCurrentItemInternal(determineTargetPage(infoForCurrentScrollPosition.position, ((scrollY / clientHeight) - infoForCurrentScrollPosition.offset) / infoForCurrentScrollPosition.heightFactor, b11, (int) (u.f(motionEvent, u.a(motionEvent, this.mActivePointerId)) - this.mInitialMotionY)), true, true, b11);
            this.mActivePointerId = -1;
            endDrag();
            f10 = this.mTopEdge.f();
            f11 = this.mBottomEdge.f();
            z10 = f10 | f11;
        }
        if (z10) {
            c1.b0(this);
        }
        return true;
    }

    public boolean pageDown() {
        androidx.viewpager.widget.a aVar = this.mAdapter;
        if (aVar == null || this.mCurItem >= aVar.getCount() - 1) {
            return false;
        }
        setCurrentItem(this.mCurItem + 1, true);
        return true;
    }

    public boolean pageUp() {
        int i10 = this.mCurItem;
        if (i10 <= 0) {
            return false;
        }
        setCurrentItem(i10 - 1, true);
        return true;
    }

    void populate() {
        populate(this.mCurItem);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.mInLayout) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    public void setAdapter(androidx.viewpager.widget.a aVar) {
        androidx.viewpager.widget.a aVar2 = this.mAdapter;
        if (aVar2 != null) {
            aVar2.unregisterDataSetObserver(this.mObserver);
            this.mAdapter.startUpdate((ViewGroup) this);
            for (int i10 = 0; i10 < this.mItems.size(); i10++) {
                ItemInfo itemInfo = this.mItems.get(i10);
                this.mAdapter.destroyItem((ViewGroup) this, itemInfo.position, itemInfo.object);
            }
            this.mAdapter.finishUpdate((ViewGroup) this);
            this.mItems.clear();
            removeNonDecorViews();
            this.mCurItem = 0;
            scrollTo(0, 0);
        }
        androidx.viewpager.widget.a aVar3 = this.mAdapter;
        this.mAdapter = aVar;
        this.mExpectedAdapterCount = 0;
        if (aVar != null) {
            if (this.mObserver == null) {
                this.mObserver = new PagerObserver();
            }
            this.mAdapter.registerDataSetObserver(this.mObserver);
            this.mPopulatePending = false;
            boolean z10 = this.mFirstLayout;
            this.mFirstLayout = true;
            this.mExpectedAdapterCount = this.mAdapter.getCount();
            if (this.mRestoredCurItem >= 0) {
                this.mAdapter.restoreState(this.mRestoredAdapterState, this.mRestoredClassLoader);
                setCurrentItemInternal(this.mRestoredCurItem, false, true);
                this.mRestoredCurItem = -1;
                this.mRestoredAdapterState = null;
                this.mRestoredClassLoader = null;
            } else if (z10) {
                requestLayout();
            } else {
                populate();
            }
        }
        OnAdapterChangeListener onAdapterChangeListener = this.mAdapterChangeListener;
        if (onAdapterChangeListener == null || aVar3 == aVar) {
            return;
        }
        onAdapterChangeListener.onAdapterChanged(aVar3, aVar);
    }

    public void setChildrenDrawingOrderEnabledCompat(boolean z10) {
        if (this.mSetChildrenDrawingOrderEnabled == null) {
            try {
                this.mSetChildrenDrawingOrderEnabled = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException e10) {
                Log.e(TAG, "Can't find setChildrenDrawingOrderEnabled", e10);
            }
        }
        try {
            this.mSetChildrenDrawingOrderEnabled.invoke(this, Boolean.valueOf(z10));
        } catch (Exception e11) {
            Log.e(TAG, "Error changing children drawing order", e11);
        }
    }

    public void setCurrentItem(int i10) {
        this.mPopulatePending = false;
        setCurrentItemInternal(i10, !this.mFirstLayout, false);
    }

    void setCurrentItemInternal(int i10, boolean z10, boolean z11) {
        setCurrentItemInternal(i10, z10, z11, 0);
    }

    ViewPager.j setInternalPageChangeListener(ViewPager.j jVar) {
        ViewPager.j jVar2 = this.mInternalPageChangeListener;
        this.mInternalPageChangeListener = jVar;
        return jVar2;
    }

    public void setOffscreenPageLimit(int i10) {
        if (i10 < 1) {
            StringBuilder sb = new StringBuilder();
            sb.append("Requested offscreen page limit ");
            sb.append(i10);
            sb.append(" too small; defaulting to ");
            sb.append(1);
            i10 = 1;
        }
        if (i10 != this.mOffscreenPageLimit) {
            this.mOffscreenPageLimit = i10;
            populate();
        }
    }

    public void setOnAdapterChangeListener(OnAdapterChangeListener onAdapterChangeListener) {
        this.mAdapterChangeListener = onAdapterChangeListener;
    }

    public void setOnPageChangeListener(ViewPager.j jVar) {
        this.mOnPageChangeListener = jVar;
    }

    public void setPageMargin(int i10) {
        int i11 = this.mPageMargin;
        this.mPageMargin = i10;
        int height = getHeight();
        recomputeScrollPosition(height, height, i10, i11);
        requestLayout();
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.mMarginDrawable = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageTransformer(boolean z10, ViewPager.k kVar) {
        boolean z11 = kVar != null;
        boolean z12 = z11 != (this.mPageTransformer != null);
        this.mPageTransformer = kVar;
        setChildrenDrawingOrderEnabledCompat(z11);
        if (z11) {
            this.mDrawingOrder = z10 ? 2 : 1;
        } else {
            this.mDrawingOrder = 0;
        }
        if (z12) {
            populate();
        }
    }

    void smoothScrollTo(int i10, int i11) {
        smoothScrollTo(i10, i11, 0);
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.mMarginDrawable;
    }

    public static class LayoutParams extends ViewGroup.LayoutParams {
        int childIndex;
        public int gravity;
        float heightFactor;
        public boolean isDecor;
        boolean needsMeasure;
        int position;

        public LayoutParams() {
            super(-1, -1);
            this.heightFactor = 0.0f;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.heightFactor = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, VerticalViewPager.LAYOUT_ATTRS);
            this.gravity = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0068, code lost:
    
        if (r10 == r11) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void populate(int i10) {
        int i11;
        ItemInfo itemInfo;
        String hexString;
        ItemInfo itemInfo2;
        ItemInfo infoForChild;
        ItemInfo itemInfo3;
        int i12 = this.mCurItem;
        if (i12 != i10) {
            i11 = i12 < i10 ? 130 : 33;
            itemInfo = infoForPosition(i12);
            this.mCurItem = i10;
        } else {
            i11 = 2;
            itemInfo = null;
        }
        if (this.mAdapter == null) {
            sortChildDrawingOrder();
            return;
        }
        if (this.mPopulatePending) {
            sortChildDrawingOrder();
            return;
        }
        if (getWindowToken() == null) {
            return;
        }
        this.mAdapter.startUpdate((ViewGroup) this);
        int i13 = this.mOffscreenPageLimit;
        int max = Math.max(0, this.mCurItem - i13);
        int count = this.mAdapter.getCount();
        int min = Math.min(count - 1, this.mCurItem + i13);
        if (count != this.mExpectedAdapterCount) {
            try {
                hexString = getResources().getResourceName(getId());
            } catch (Resources.NotFoundException unused) {
                hexString = Integer.toHexString(getId());
            }
            throw new IllegalStateException("The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: " + this.mExpectedAdapterCount + ", found: " + count + " Pager id: " + hexString + " Pager class: " + getClass() + " Problematic adapter: " + this.mAdapter.getClass());
        }
        int i14 = 0;
        while (true) {
            if (i14 >= this.mItems.size()) {
                break;
            }
            itemInfo2 = this.mItems.get(i14);
            int i15 = itemInfo2.position;
            int i16 = this.mCurItem;
            if (i15 < i16) {
                i14++;
            }
        }
        itemInfo2 = null;
        if (itemInfo2 == null && count > 0) {
            itemInfo2 = addNewItem(this.mCurItem, i14);
        }
        if (itemInfo2 != null) {
            int i17 = i14 - 1;
            ItemInfo itemInfo4 = i17 >= 0 ? this.mItems.get(i17) : null;
            int clientHeight = getClientHeight();
            float paddingLeft = clientHeight <= 0 ? 0.0f : (2.0f - itemInfo2.heightFactor) + (getPaddingLeft() / clientHeight);
            float f10 = 0.0f;
            for (int i18 = this.mCurItem - 1; i18 >= 0; i18--) {
                if (f10 >= paddingLeft && i18 < max) {
                    if (itemInfo4 == null) {
                        break;
                    }
                    if (i18 == itemInfo4.position && !itemInfo4.scrolling) {
                        this.mItems.remove(i17);
                        this.mAdapter.destroyItem((ViewGroup) this, i18, itemInfo4.object);
                        i17--;
                        i14--;
                        if (i17 >= 0) {
                            itemInfo3 = this.mItems.get(i17);
                            itemInfo4 = itemInfo3;
                        }
                        itemInfo3 = null;
                        itemInfo4 = itemInfo3;
                    }
                } else if (itemInfo4 == null || i18 != itemInfo4.position) {
                    f10 += addNewItem(i18, i17 + 1).heightFactor;
                    i14++;
                    if (i17 >= 0) {
                        itemInfo3 = this.mItems.get(i17);
                        itemInfo4 = itemInfo3;
                    }
                    itemInfo3 = null;
                    itemInfo4 = itemInfo3;
                } else {
                    f10 += itemInfo4.heightFactor;
                    i17--;
                    if (i17 >= 0) {
                        itemInfo3 = this.mItems.get(i17);
                        itemInfo4 = itemInfo3;
                    }
                    itemInfo3 = null;
                    itemInfo4 = itemInfo3;
                }
            }
            float f11 = itemInfo2.heightFactor;
            int i19 = i14 + 1;
            if (f11 < 2.0f) {
                ItemInfo itemInfo5 = i19 < this.mItems.size() ? this.mItems.get(i19) : null;
                float paddingRight = clientHeight <= 0 ? 0.0f : (getPaddingRight() / clientHeight) + 2.0f;
                int i20 = this.mCurItem;
                while (true) {
                    i20++;
                    if (i20 >= count) {
                        break;
                    }
                    if (f11 >= paddingRight && i20 > min) {
                        if (itemInfo5 == null) {
                            break;
                        }
                        if (i20 == itemInfo5.position && !itemInfo5.scrolling) {
                            this.mItems.remove(i19);
                            this.mAdapter.destroyItem((ViewGroup) this, i20, itemInfo5.object);
                            if (i19 < this.mItems.size()) {
                                itemInfo5 = this.mItems.get(i19);
                            }
                        }
                    } else if (itemInfo5 == null || i20 != itemInfo5.position) {
                        ItemInfo addNewItem = addNewItem(i20, i19);
                        i19++;
                        f11 += addNewItem.heightFactor;
                        itemInfo5 = i19 < this.mItems.size() ? this.mItems.get(i19) : null;
                    } else {
                        f11 += itemInfo5.heightFactor;
                        i19++;
                        if (i19 < this.mItems.size()) {
                            itemInfo5 = this.mItems.get(i19);
                        }
                    }
                }
            }
            calculatePageOffsets(itemInfo2, i14, itemInfo);
        }
        this.mAdapter.setPrimaryItem((ViewGroup) this, this.mCurItem, itemInfo2 != null ? itemInfo2.object : null);
        this.mAdapter.finishUpdate((ViewGroup) this);
        int childCount = getChildCount();
        for (int i21 = 0; i21 < childCount; i21++) {
            View childAt = getChildAt(i21);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            layoutParams.childIndex = i21;
            if (!layoutParams.isDecor && layoutParams.heightFactor == 0.0f && (infoForChild = infoForChild(childAt)) != null) {
                layoutParams.heightFactor = infoForChild.heightFactor;
                layoutParams.position = infoForChild.position;
            }
        }
        sortChildDrawingOrder();
        if (hasFocus()) {
            View findFocus = findFocus();
            ItemInfo infoForAnyChild = findFocus != null ? infoForAnyChild(findFocus) : null;
            if (infoForAnyChild == null || infoForAnyChild.position != this.mCurItem) {
                for (int i22 = 0; i22 < getChildCount(); i22++) {
                    View childAt2 = getChildAt(i22);
                    ItemInfo infoForChild2 = infoForChild(childAt2);
                    if (infoForChild2 != null && infoForChild2.position == this.mCurItem && childAt2.requestFocus(i11)) {
                        return;
                    }
                }
            }
        }
    }

    void setCurrentItemInternal(int i10, boolean z10, boolean z11, int i11) {
        ViewPager.j jVar;
        ViewPager.j jVar2;
        androidx.viewpager.widget.a aVar = this.mAdapter;
        if (aVar == null || aVar.getCount() <= 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (!z11 && this.mCurItem == i10 && this.mItems.size() != 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        if (i10 < 0) {
            i10 = 0;
        } else if (i10 >= this.mAdapter.getCount()) {
            i10 = this.mAdapter.getCount() - 1;
        }
        int i12 = this.mOffscreenPageLimit;
        int i13 = this.mCurItem;
        if (i10 > i13 + i12 || i10 < i13 - i12) {
            for (int i14 = 0; i14 < this.mItems.size(); i14++) {
                this.mItems.get(i14).scrolling = true;
            }
        }
        boolean z12 = this.mCurItem != i10;
        if (!this.mFirstLayout) {
            populate(i10);
            scrollToItem(i10, z10, i11, z12);
            return;
        }
        this.mCurItem = i10;
        if (z12 && (jVar2 = this.mOnPageChangeListener) != null) {
            jVar2.onPageSelected(i10);
        }
        if (z12 && (jVar = this.mInternalPageChangeListener) != null) {
            jVar.onPageSelected(i10);
        }
        requestLayout();
    }

    void smoothScrollTo(int i10, int i11, int i12) {
        int abs;
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int i13 = i10 - scrollX;
        int i14 = i11 - scrollY;
        if (i13 == 0 && i14 == 0) {
            completeScroll(false);
            populate();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        int clientHeight = getClientHeight();
        int i15 = clientHeight / 2;
        float f10 = clientHeight;
        float f11 = i15;
        float distanceInfluenceForSnapDuration = f11 + (distanceInfluenceForSnapDuration(Math.min(1.0f, (Math.abs(i13) * 1.0f) / f10)) * f11);
        int abs2 = Math.abs(i12);
        if (abs2 > 0) {
            abs = Math.round(Math.abs(distanceInfluenceForSnapDuration / abs2) * 1000.0f) * 4;
        } else {
            abs = (int) (((Math.abs(i13) / ((f10 * this.mAdapter.getPageWidth(this.mCurItem)) + this.mPageMargin)) + 1.0f) * 100.0f);
        }
        this.mScroller.startScroll(scrollX, scrollY, i13, i14, Math.min(abs, 600));
        c1.b0(this);
    }

    public void setCurrentItem(int i10, boolean z10) {
        this.mPopulatePending = false;
        setCurrentItemInternal(i10, z10, false);
    }

    public void setPageMarginDrawable(int i10) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i10));
    }

    public VerticalViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TYPE_VIEW_SCROLLED = 4096;
        this.mItems = new ArrayList<>();
        this.mTempItem = new ItemInfo();
        this.mTempRect = new Rect();
        this.mRestoredCurItem = -1;
        this.mRestoredAdapterState = null;
        this.mRestoredClassLoader = null;
        this.mFirstOffset = -3.4028235E38f;
        this.mLastOffset = Float.MAX_VALUE;
        this.mOffscreenPageLimit = 1;
        this.mActivePointerId = -1;
        this.mFirstLayout = true;
        this.mNeedCalculatePageOffsets = false;
        this.mEndScrollRunnable = new Runnable() { // from class: com.mobile.brasiltv.view.shortvideo.VerticalViewPager.3
            @Override // java.lang.Runnable
            public void run() {
                VerticalViewPager.this.setScrollState(0);
                VerticalViewPager.this.populate();
            }
        };
        this.mScrollState = 0;
        initViewPager();
    }
}
