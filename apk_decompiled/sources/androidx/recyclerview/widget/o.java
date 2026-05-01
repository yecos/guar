package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import b0.c1;
import c0.g0;
import c0.j0;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class o extends b0.a {
    private final a mItemDelegate;
    final RecyclerView mRecyclerView;

    public static class a extends b0.a {

        /* renamed from: a, reason: collision with root package name */
        public final o f3265a;

        /* renamed from: b, reason: collision with root package name */
        public Map f3266b = new WeakHashMap();

        public a(o oVar) {
            this.f3265a = oVar;
        }

        public b0.a c(View view) {
            return (b0.a) this.f3266b.remove(view);
        }

        public void d(View view) {
            b0.a k10 = c1.k(view);
            if (k10 == null || k10 == this) {
                return;
            }
            this.f3266b.put(view, k10);
        }

        @Override // b0.a
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            b0.a aVar = (b0.a) this.f3266b.get(view);
            return aVar != null ? aVar.dispatchPopulateAccessibilityEvent(view, accessibilityEvent) : super.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // b0.a
        public j0 getAccessibilityNodeProvider(View view) {
            b0.a aVar = (b0.a) this.f3266b.get(view);
            return aVar != null ? aVar.getAccessibilityNodeProvider(view) : super.getAccessibilityNodeProvider(view);
        }

        @Override // b0.a
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            b0.a aVar = (b0.a) this.f3266b.get(view);
            if (aVar != null) {
                aVar.onInitializeAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            }
        }

        @Override // b0.a
        public void onInitializeAccessibilityNodeInfo(View view, g0 g0Var) {
            if (this.f3265a.shouldIgnore() || this.f3265a.mRecyclerView.getLayoutManager() == null) {
                super.onInitializeAccessibilityNodeInfo(view, g0Var);
                return;
            }
            this.f3265a.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfoForItem(view, g0Var);
            b0.a aVar = (b0.a) this.f3266b.get(view);
            if (aVar != null) {
                aVar.onInitializeAccessibilityNodeInfo(view, g0Var);
            } else {
                super.onInitializeAccessibilityNodeInfo(view, g0Var);
            }
        }

        @Override // b0.a
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            b0.a aVar = (b0.a) this.f3266b.get(view);
            if (aVar != null) {
                aVar.onPopulateAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            }
        }

        @Override // b0.a
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            b0.a aVar = (b0.a) this.f3266b.get(viewGroup);
            return aVar != null ? aVar.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent) : super.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        @Override // b0.a
        public boolean performAccessibilityAction(View view, int i10, Bundle bundle) {
            if (this.f3265a.shouldIgnore() || this.f3265a.mRecyclerView.getLayoutManager() == null) {
                return super.performAccessibilityAction(view, i10, bundle);
            }
            b0.a aVar = (b0.a) this.f3266b.get(view);
            if (aVar != null) {
                if (aVar.performAccessibilityAction(view, i10, bundle)) {
                    return true;
                }
            } else if (super.performAccessibilityAction(view, i10, bundle)) {
                return true;
            }
            return this.f3265a.mRecyclerView.getLayoutManager().performAccessibilityActionForItem(view, i10, bundle);
        }

        @Override // b0.a
        public void sendAccessibilityEvent(View view, int i10) {
            b0.a aVar = (b0.a) this.f3266b.get(view);
            if (aVar != null) {
                aVar.sendAccessibilityEvent(view, i10);
            } else {
                super.sendAccessibilityEvent(view, i10);
            }
        }

        @Override // b0.a
        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            b0.a aVar = (b0.a) this.f3266b.get(view);
            if (aVar != null) {
                aVar.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            } else {
                super.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            }
        }
    }

    public o(RecyclerView recyclerView) {
        this.mRecyclerView = recyclerView;
        b0.a itemDelegate = getItemDelegate();
        if (itemDelegate == null || !(itemDelegate instanceof a)) {
            this.mItemDelegate = new a(this);
        } else {
            this.mItemDelegate = (a) itemDelegate;
        }
    }

    public b0.a getItemDelegate() {
        return this.mItemDelegate;
    }

    @Override // b0.a
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        if (!(view instanceof RecyclerView) || shouldIgnore()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().onInitializeAccessibilityEvent(accessibilityEvent);
        }
    }

    @Override // b0.a
    public void onInitializeAccessibilityNodeInfo(View view, g0 g0Var) {
        super.onInitializeAccessibilityNodeInfo(view, g0Var);
        if (shouldIgnore() || this.mRecyclerView.getLayoutManager() == null) {
            return;
        }
        this.mRecyclerView.getLayoutManager().onInitializeAccessibilityNodeInfo(g0Var);
    }

    @Override // b0.a
    public boolean performAccessibilityAction(View view, int i10, Bundle bundle) {
        if (super.performAccessibilityAction(view, i10, bundle)) {
            return true;
        }
        if (shouldIgnore() || this.mRecyclerView.getLayoutManager() == null) {
            return false;
        }
        return this.mRecyclerView.getLayoutManager().performAccessibilityAction(i10, bundle);
    }

    public boolean shouldIgnore() {
        return this.mRecyclerView.hasPendingAdapterUpdates();
    }
}
