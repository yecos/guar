package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.transition.Transition;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class d2 extends y1 implements z1 {
    public static Method L;
    public z1 K;

    public static class a extends r1 {

        /* renamed from: o, reason: collision with root package name */
        public final int f1464o;

        /* renamed from: p, reason: collision with root package name */
        public final int f1465p;

        /* renamed from: q, reason: collision with root package name */
        public z1 f1466q;

        /* renamed from: r, reason: collision with root package name */
        public MenuItem f1467r;

        public a(Context context, boolean z10) {
            super(context, z10);
            if (1 == context.getResources().getConfiguration().getLayoutDirection()) {
                this.f1464o = 21;
                this.f1465p = 22;
            } else {
                this.f1464o = 22;
                this.f1465p = 21;
            }
        }

        @Override // androidx.appcompat.widget.r1
        public /* bridge */ /* synthetic */ int d(int i10, int i11, int i12, int i13, int i14) {
            return super.d(i10, i11, i12, i13, i14);
        }

        @Override // androidx.appcompat.widget.r1
        public /* bridge */ /* synthetic */ boolean e(MotionEvent motionEvent, int i10) {
            return super.e(motionEvent, i10);
        }

        @Override // androidx.appcompat.widget.r1, android.view.ViewGroup, android.view.View
        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        @Override // androidx.appcompat.widget.r1, android.view.View
        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        @Override // androidx.appcompat.widget.r1, android.view.View
        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        @Override // androidx.appcompat.widget.r1, android.view.View
        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        @Override // androidx.appcompat.widget.r1, android.view.View
        public boolean onHoverEvent(MotionEvent motionEvent) {
            androidx.appcompat.view.menu.f fVar;
            int i10;
            int pointToPosition;
            int i11;
            if (this.f1466q != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    i10 = headerViewListAdapter.getHeadersCount();
                    fVar = (androidx.appcompat.view.menu.f) headerViewListAdapter.getWrappedAdapter();
                } else {
                    fVar = (androidx.appcompat.view.menu.f) adapter;
                    i10 = 0;
                }
                androidx.appcompat.view.menu.i item = (motionEvent.getAction() == 10 || (pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) == -1 || (i11 = pointToPosition - i10) < 0 || i11 >= fVar.getCount()) ? null : fVar.getItem(i11);
                MenuItem menuItem = this.f1467r;
                if (menuItem != item) {
                    androidx.appcompat.view.menu.g b10 = fVar.b();
                    if (menuItem != null) {
                        this.f1466q.l(b10, menuItem);
                    }
                    this.f1467r = item;
                    if (item != null) {
                        this.f1466q.b(b10, item);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int i10, KeyEvent keyEvent) {
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i10 == this.f1464o) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            }
            if (listMenuItemView == null || i10 != this.f1465p) {
                return super.onKeyDown(i10, keyEvent);
            }
            setSelection(-1);
            ((androidx.appcompat.view.menu.f) getAdapter()).b().close(false);
            return true;
        }

        @Override // androidx.appcompat.widget.r1, android.widget.AbsListView, android.view.View
        public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
            return super.onTouchEvent(motionEvent);
        }

        public void setHoverListener(z1 z1Var) {
            this.f1466q = z1Var;
        }

        @Override // androidx.appcompat.widget.r1, android.widget.AbsListView
        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }
    }

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                L = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        } catch (NoSuchMethodException unused) {
        }
    }

    public d2(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
    }

    public void K(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.G.setEnterTransition((Transition) obj);
        }
    }

    public void L(Object obj) {
        if (Build.VERSION.SDK_INT >= 23) {
            this.G.setExitTransition((Transition) obj);
        }
    }

    public void M(z1 z1Var) {
        this.K = z1Var;
    }

    public void N(boolean z10) {
        if (Build.VERSION.SDK_INT > 28) {
            this.G.setTouchModal(z10);
            return;
        }
        Method method = L;
        if (method != null) {
            try {
                method.invoke(this.G, Boolean.valueOf(z10));
            } catch (Exception unused) {
            }
        }
    }

    @Override // androidx.appcompat.widget.z1
    public void b(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
        z1 z1Var = this.K;
        if (z1Var != null) {
            z1Var.b(gVar, menuItem);
        }
    }

    @Override // androidx.appcompat.widget.z1
    public void l(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
        z1 z1Var = this.K;
        if (z1Var != null) {
            z1Var.l(gVar, menuItem);
        }
    }

    @Override // androidx.appcompat.widget.y1
    public r1 p(Context context, boolean z10) {
        a aVar = new a(context, z10);
        aVar.setHoverListener(this);
        return aVar;
    }
}
