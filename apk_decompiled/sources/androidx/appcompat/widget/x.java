package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.R$attr;
import androidx.appcompat.app.c;

/* loaded from: classes.dex */
public class x extends Spinner implements b0.g0 {

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f1684i = {R.attr.spinnerMode};

    /* renamed from: a, reason: collision with root package name */
    public final androidx.appcompat.widget.f f1685a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f1686b;

    /* renamed from: c, reason: collision with root package name */
    public t1 f1687c;

    /* renamed from: d, reason: collision with root package name */
    public SpinnerAdapter f1688d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f1689e;

    /* renamed from: f, reason: collision with root package name */
    public g f1690f;

    /* renamed from: g, reason: collision with root package name */
    public int f1691g;

    /* renamed from: h, reason: collision with root package name */
    public final Rect f1692h;

    public class a extends t1 {

        /* renamed from: j, reason: collision with root package name */
        public final /* synthetic */ e f1693j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view, e eVar) {
            super(view);
            this.f1693j = eVar;
        }

        @Override // androidx.appcompat.widget.t1
        public androidx.appcompat.view.menu.p b() {
            return this.f1693j;
        }

        @Override // androidx.appcompat.widget.t1
        public boolean c() {
            if (x.this.getInternalPopup().isShowing()) {
                return true;
            }
            x.this.b();
            return true;
        }
    }

    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!x.this.getInternalPopup().isShowing()) {
                x.this.b();
            }
            ViewTreeObserver viewTreeObserver = x.this.getViewTreeObserver();
            if (viewTreeObserver != null) {
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
        }
    }

    public class c implements g, DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public androidx.appcompat.app.c f1696a;

        /* renamed from: b, reason: collision with root package name */
        public ListAdapter f1697b;

        /* renamed from: c, reason: collision with root package name */
        public CharSequence f1698c;

        public c() {
        }

        @Override // androidx.appcompat.widget.x.g
        public int a() {
            return 0;
        }

        @Override // androidx.appcompat.widget.x.g
        public void c(int i10) {
            Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.x.g
        public CharSequence d() {
            return this.f1698c;
        }

        @Override // androidx.appcompat.widget.x.g
        public void dismiss() {
            androidx.appcompat.app.c cVar = this.f1696a;
            if (cVar != null) {
                cVar.dismiss();
                this.f1696a = null;
            }
        }

        @Override // androidx.appcompat.widget.x.g
        public Drawable e() {
            return null;
        }

        @Override // androidx.appcompat.widget.x.g
        public void f(CharSequence charSequence) {
            this.f1698c = charSequence;
        }

        @Override // androidx.appcompat.widget.x.g
        public void g(int i10) {
            Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.x.g
        public void h(int i10) {
            Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }

        @Override // androidx.appcompat.widget.x.g
        public void i(int i10, int i11) {
            if (this.f1697b == null) {
                return;
            }
            c.a aVar = new c.a(x.this.getPopupContext());
            CharSequence charSequence = this.f1698c;
            if (charSequence != null) {
                aVar.setTitle(charSequence);
            }
            androidx.appcompat.app.c create = aVar.setSingleChoiceItems(this.f1697b, x.this.getSelectedItemPosition(), this).create();
            this.f1696a = create;
            ListView listView = create.getListView();
            listView.setTextDirection(i10);
            listView.setTextAlignment(i11);
            this.f1696a.show();
        }

        @Override // androidx.appcompat.widget.x.g
        public boolean isShowing() {
            androidx.appcompat.app.c cVar = this.f1696a;
            if (cVar != null) {
                return cVar.isShowing();
            }
            return false;
        }

        @Override // androidx.appcompat.widget.x.g
        public int j() {
            return 0;
        }

        @Override // androidx.appcompat.widget.x.g
        public void k(ListAdapter listAdapter) {
            this.f1697b = listAdapter;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            x.this.setSelection(i10);
            if (x.this.getOnItemClickListener() != null) {
                x.this.performItemClick(null, i10, this.f1697b.getItemId(i10));
            }
            dismiss();
        }

        @Override // androidx.appcompat.widget.x.g
        public void setBackgroundDrawable(Drawable drawable) {
            Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
        }
    }

    public static class d implements ListAdapter, SpinnerAdapter {

        /* renamed from: a, reason: collision with root package name */
        public SpinnerAdapter f1700a;

        /* renamed from: b, reason: collision with root package name */
        public ListAdapter f1701b;

        public d(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            Resources.Theme dropDownViewTheme;
            this.f1700a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f1701b = (ListAdapter) spinnerAdapter;
            }
            if (theme == null || Build.VERSION.SDK_INT < 23 || !y.a(spinnerAdapter)) {
                return;
            }
            ThemedSpinnerAdapter a10 = z.a(spinnerAdapter);
            dropDownViewTheme = a10.getDropDownViewTheme();
            if (dropDownViewTheme != theme) {
                a10.setDropDownViewTheme(theme);
            }
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f1701b;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.f1700a;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        @Override // android.widget.SpinnerAdapter
        public View getDropDownView(int i10, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.f1700a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i10, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public Object getItem(int i10) {
            SpinnerAdapter spinnerAdapter = this.f1700a;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i10);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i10) {
            SpinnerAdapter spinnerAdapter = this.f1700a;
            if (spinnerAdapter == null) {
                return -1L;
            }
            return spinnerAdapter.getItemId(i10);
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int i10) {
            return 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i10, View view, ViewGroup viewGroup) {
            return getDropDownView(i10, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.f1700a;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            return getCount() == 0;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i10) {
            ListAdapter listAdapter = this.f1701b;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i10);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f1700a;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.f1700a;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    public class e extends y1 implements g {
        public CharSequence K;
        public ListAdapter L;
        public final Rect M;
        public int N;

        public class a implements AdapterView.OnItemClickListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ x f1702a;

            public a(x xVar) {
                this.f1702a = xVar;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                x.this.setSelection(i10);
                if (x.this.getOnItemClickListener() != null) {
                    e eVar = e.this;
                    x.this.performItemClick(view, i10, eVar.L.getItemId(i10));
                }
                e.this.dismiss();
            }
        }

        public class b implements ViewTreeObserver.OnGlobalLayoutListener {
            public b() {
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                e eVar = e.this;
                if (!eVar.N(x.this)) {
                    e.this.dismiss();
                } else {
                    e.this.L();
                    e.super.show();
                }
            }
        }

        public class c implements PopupWindow.OnDismissListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener f1705a;

            public c(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
                this.f1705a = onGlobalLayoutListener;
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                ViewTreeObserver viewTreeObserver = x.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this.f1705a);
                }
            }
        }

        public e(Context context, AttributeSet attributeSet, int i10) {
            super(context, attributeSet, i10);
            this.M = new Rect();
            w(x.this);
            C(true);
            H(0);
            E(new a(x.this));
        }

        public void L() {
            int i10;
            Drawable e10 = e();
            if (e10 != null) {
                e10.getPadding(x.this.f1692h);
                i10 = y2.b(x.this) ? x.this.f1692h.right : -x.this.f1692h.left;
            } else {
                Rect rect = x.this.f1692h;
                rect.right = 0;
                rect.left = 0;
                i10 = 0;
            }
            int paddingLeft = x.this.getPaddingLeft();
            int paddingRight = x.this.getPaddingRight();
            int width = x.this.getWidth();
            x xVar = x.this;
            int i11 = xVar.f1691g;
            if (i11 == -2) {
                int a10 = xVar.a((SpinnerAdapter) this.L, e());
                int i12 = x.this.getContext().getResources().getDisplayMetrics().widthPixels;
                Rect rect2 = x.this.f1692h;
                int i13 = (i12 - rect2.left) - rect2.right;
                if (a10 > i13) {
                    a10 = i13;
                }
                y(Math.max(a10, (width - paddingLeft) - paddingRight));
            } else if (i11 == -1) {
                y((width - paddingLeft) - paddingRight);
            } else {
                y(i11);
            }
            c(y2.b(x.this) ? i10 + (((width - paddingRight) - s()) - M()) : i10 + paddingLeft + M());
        }

        public int M() {
            return this.N;
        }

        public boolean N(View view) {
            return b0.c1.P(view) && view.getGlobalVisibleRect(this.M);
        }

        @Override // androidx.appcompat.widget.x.g
        public CharSequence d() {
            return this.K;
        }

        @Override // androidx.appcompat.widget.x.g
        public void f(CharSequence charSequence) {
            this.K = charSequence;
        }

        @Override // androidx.appcompat.widget.x.g
        public void h(int i10) {
            this.N = i10;
        }

        @Override // androidx.appcompat.widget.x.g
        public void i(int i10, int i11) {
            ViewTreeObserver viewTreeObserver;
            boolean isShowing = isShowing();
            L();
            B(2);
            super.show();
            ListView m10 = m();
            m10.setChoiceMode(1);
            m10.setTextDirection(i10);
            m10.setTextAlignment(i11);
            I(x.this.getSelectedItemPosition());
            if (isShowing || (viewTreeObserver = x.this.getViewTreeObserver()) == null) {
                return;
            }
            b bVar = new b();
            viewTreeObserver.addOnGlobalLayoutListener(bVar);
            D(new c(bVar));
        }

        @Override // androidx.appcompat.widget.y1, androidx.appcompat.widget.x.g
        public void k(ListAdapter listAdapter) {
            super.k(listAdapter);
            this.L = listAdapter;
        }
    }

    public static class f extends View.BaseSavedState {
        public static final Parcelable.Creator<f> CREATOR = new a();

        /* renamed from: a, reason: collision with root package name */
        public boolean f1707a;

        public static class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public f createFromParcel(Parcel parcel) {
                return new f(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public f[] newArray(int i10) {
                return new f[i10];
            }
        }

        public f(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeByte(this.f1707a ? (byte) 1 : (byte) 0);
        }

        public f(Parcel parcel) {
            super(parcel);
            this.f1707a = parcel.readByte() != 0;
        }
    }

    public interface g {
        int a();

        void c(int i10);

        CharSequence d();

        void dismiss();

        Drawable e();

        void f(CharSequence charSequence);

        void g(int i10);

        void h(int i10);

        void i(int i10, int i11);

        boolean isShowing();

        int j();

        void k(ListAdapter listAdapter);

        void setBackgroundDrawable(Drawable drawable);
    }

    public x(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.spinnerStyle);
    }

    public int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i10 = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i11 = 0;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i10) {
                view = null;
                i10 = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i11 = Math.max(i11, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return i11;
        }
        drawable.getPadding(this.f1692h);
        Rect rect = this.f1692h;
        return i11 + rect.left + rect.right;
    }

    public void b() {
        this.f1690f.i(getTextDirection(), getTextAlignment());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        androidx.appcompat.widget.f fVar = this.f1685a;
        if (fVar != null) {
            fVar.b();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        g gVar = this.f1690f;
        return gVar != null ? gVar.a() : super.getDropDownHorizontalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        g gVar = this.f1690f;
        return gVar != null ? gVar.j() : super.getDropDownVerticalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        return this.f1690f != null ? this.f1691g : super.getDropDownWidth();
    }

    public final g getInternalPopup() {
        return this.f1690f;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        g gVar = this.f1690f;
        return gVar != null ? gVar.e() : super.getPopupBackground();
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.f1686b;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        g gVar = this.f1690f;
        return gVar != null ? gVar.d() : super.getPrompt();
    }

    @Override // b0.g0
    public ColorStateList getSupportBackgroundTintList() {
        androidx.appcompat.widget.f fVar = this.f1685a;
        if (fVar != null) {
            return fVar.c();
        }
        return null;
    }

    @Override // b0.g0
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        androidx.appcompat.widget.f fVar = this.f1685a;
        if (fVar != null) {
            return fVar.d();
        }
        return null;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        g gVar = this.f1690f;
        if (gVar == null || !gVar.isShowing()) {
            return;
        }
        this.f1690f.dismiss();
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        if (this.f1690f == null || View.MeasureSpec.getMode(i10) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i10)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        f fVar = (f) parcelable;
        super.onRestoreInstanceState(fVar.getSuperState());
        if (!fVar.f1707a || (viewTreeObserver = getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new b());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public Parcelable onSaveInstanceState() {
        f fVar = new f(super.onSaveInstanceState());
        g gVar = this.f1690f;
        fVar.f1707a = gVar != null && gVar.isShowing();
        return fVar;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        t1 t1Var = this.f1687c;
        if (t1Var == null || !t1Var.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() {
        g gVar = this.f1690f;
        if (gVar == null) {
            return super.performClick();
        }
        if (gVar.isShowing()) {
            return true;
        }
        b();
        return true;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        androidx.appcompat.widget.f fVar = this.f1685a;
        if (fVar != null) {
            fVar.f(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i10) {
        super.setBackgroundResource(i10);
        androidx.appcompat.widget.f fVar = this.f1685a;
        if (fVar != null) {
            fVar.g(i10);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i10) {
        g gVar = this.f1690f;
        if (gVar == null) {
            super.setDropDownHorizontalOffset(i10);
        } else {
            gVar.h(i10);
            this.f1690f.c(i10);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i10) {
        g gVar = this.f1690f;
        if (gVar != null) {
            gVar.g(i10);
        } else {
            super.setDropDownVerticalOffset(i10);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i10) {
        if (this.f1690f != null) {
            this.f1691g = i10;
        } else {
            super.setDropDownWidth(i10);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        g gVar = this.f1690f;
        if (gVar != null) {
            gVar.setBackgroundDrawable(drawable);
        } else {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i10) {
        setPopupBackgroundDrawable(d.b.d(getPopupContext(), i10));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        g gVar = this.f1690f;
        if (gVar != null) {
            gVar.f(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    @Override // b0.g0
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        androidx.appcompat.widget.f fVar = this.f1685a;
        if (fVar != null) {
            fVar.i(colorStateList);
        }
    }

    @Override // b0.g0
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        androidx.appcompat.widget.f fVar = this.f1685a;
        if (fVar != null) {
            fVar.j(mode);
        }
    }

    public x(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, -1);
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f1689e) {
            this.f1688d = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.f1690f != null) {
            Context context = this.f1686b;
            if (context == null) {
                context = getContext();
            }
            this.f1690f.k(new d(spinnerAdapter, context.getTheme()));
        }
    }

    public x(Context context, AttributeSet attributeSet, int i10, int i11) {
        this(context, attributeSet, i10, i11, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0057, code lost:
    
        if (r10 == null) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public x(android.content.Context r6, android.util.AttributeSet r7, int r8, int r9, android.content.res.Resources.Theme r10) {
        /*
            r5 = this;
            r5.<init>(r6, r7, r8)
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r5.f1692h = r0
            int[] r0 = androidx.appcompat.R$styleable.H
            r1 = 0
            androidx.appcompat.widget.r2 r0 = androidx.appcompat.widget.r2.u(r6, r7, r0, r8, r1)
            androidx.appcompat.widget.f r2 = new androidx.appcompat.widget.f
            r2.<init>(r5)
            r5.f1685a = r2
            if (r10 == 0) goto L22
            g.d r2 = new g.d
            r2.<init>(r6, r10)
            r5.f1686b = r2
            goto L34
        L22:
            int r10 = androidx.appcompat.R$styleable.Spinner_popupTheme
            int r10 = r0.n(r10, r1)
            if (r10 == 0) goto L32
            g.d r2 = new g.d
            r2.<init>(r6, r10)
            r5.f1686b = r2
            goto L34
        L32:
            r5.f1686b = r6
        L34:
            r10 = -1
            r2 = 0
            if (r9 != r10) goto L5a
            int[] r10 = androidx.appcompat.widget.x.f1684i     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L56
            android.content.res.TypedArray r10 = r6.obtainStyledAttributes(r7, r10, r8, r1)     // Catch: java.lang.Throwable -> L4f java.lang.Exception -> L56
            boolean r3 = r10.hasValue(r1)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L57
            if (r3 == 0) goto L48
            int r9 = r10.getInt(r1, r1)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L57
        L48:
            r10.recycle()
            goto L5a
        L4c:
            r6 = move-exception
            r2 = r10
            goto L50
        L4f:
            r6 = move-exception
        L50:
            if (r2 == 0) goto L55
            r2.recycle()
        L55:
            throw r6
        L56:
            r10 = r2
        L57:
            if (r10 == 0) goto L5a
            goto L48
        L5a:
            r10 = 1
            if (r9 == 0) goto L97
            if (r9 == r10) goto L60
            goto La7
        L60:
            androidx.appcompat.widget.x$e r9 = new androidx.appcompat.widget.x$e
            android.content.Context r3 = r5.f1686b
            r9.<init>(r3, r7, r8)
            android.content.Context r3 = r5.f1686b
            int[] r4 = androidx.appcompat.R$styleable.H
            androidx.appcompat.widget.r2 r1 = androidx.appcompat.widget.r2.u(r3, r7, r4, r8, r1)
            int r3 = androidx.appcompat.R$styleable.Spinner_android_dropDownWidth
            r4 = -2
            int r3 = r1.m(r3, r4)
            r5.f1691g = r3
            int r3 = androidx.appcompat.R$styleable.Spinner_android_popupBackground
            android.graphics.drawable.Drawable r3 = r1.g(r3)
            r9.setBackgroundDrawable(r3)
            int r3 = androidx.appcompat.R$styleable.Spinner_android_prompt
            java.lang.String r3 = r0.o(r3)
            r9.f(r3)
            r1.v()
            r5.f1690f = r9
            androidx.appcompat.widget.x$a r1 = new androidx.appcompat.widget.x$a
            r1.<init>(r5, r9)
            r5.f1687c = r1
            goto La7
        L97:
            androidx.appcompat.widget.x$c r9 = new androidx.appcompat.widget.x$c
            r9.<init>()
            r5.f1690f = r9
            int r1 = androidx.appcompat.R$styleable.Spinner_android_prompt
            java.lang.String r1 = r0.o(r1)
            r9.f(r1)
        La7:
            int r9 = androidx.appcompat.R$styleable.Spinner_android_entries
            java.lang.CharSequence[] r9 = r0.q(r9)
            if (r9 == 0) goto Lbf
            android.widget.ArrayAdapter r1 = new android.widget.ArrayAdapter
            r3 = 17367048(0x1090008, float:2.5162948E-38)
            r1.<init>(r6, r3, r9)
            int r6 = androidx.appcompat.R$layout.support_simple_spinner_dropdown_item
            r1.setDropDownViewResource(r6)
            r5.setAdapter(r1)
        Lbf:
            r0.v()
            r5.f1689e = r10
            android.widget.SpinnerAdapter r6 = r5.f1688d
            if (r6 == 0) goto Lcd
            r5.setAdapter(r6)
            r5.f1688d = r2
        Lcd:
            androidx.appcompat.widget.f r6 = r5.f1685a
            r6.e(r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.x.<init>(android.content.Context, android.util.AttributeSet, int, int, android.content.res.Resources$Theme):void");
    }
}
