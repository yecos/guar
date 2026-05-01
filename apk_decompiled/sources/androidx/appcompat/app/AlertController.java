package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.u1;
import androidx.core.widget.NestedScrollView;
import b0.c1;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class AlertController {
    public NestedScrollView A;
    public Drawable C;
    public ImageView D;
    public TextView E;
    public TextView F;
    public View G;
    public ListAdapter H;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public boolean P;
    public Handler R;

    /* renamed from: a, reason: collision with root package name */
    public final Context f829a;

    /* renamed from: b, reason: collision with root package name */
    public final j f830b;

    /* renamed from: c, reason: collision with root package name */
    public final Window f831c;

    /* renamed from: d, reason: collision with root package name */
    public final int f832d;

    /* renamed from: e, reason: collision with root package name */
    public CharSequence f833e;

    /* renamed from: f, reason: collision with root package name */
    public CharSequence f834f;

    /* renamed from: g, reason: collision with root package name */
    public ListView f835g;

    /* renamed from: h, reason: collision with root package name */
    public View f836h;

    /* renamed from: i, reason: collision with root package name */
    public int f837i;

    /* renamed from: j, reason: collision with root package name */
    public int f838j;

    /* renamed from: k, reason: collision with root package name */
    public int f839k;

    /* renamed from: l, reason: collision with root package name */
    public int f840l;

    /* renamed from: m, reason: collision with root package name */
    public int f841m;

    /* renamed from: o, reason: collision with root package name */
    public Button f843o;

    /* renamed from: p, reason: collision with root package name */
    public CharSequence f844p;

    /* renamed from: q, reason: collision with root package name */
    public Message f845q;

    /* renamed from: r, reason: collision with root package name */
    public Drawable f846r;

    /* renamed from: s, reason: collision with root package name */
    public Button f847s;

    /* renamed from: t, reason: collision with root package name */
    public CharSequence f848t;

    /* renamed from: u, reason: collision with root package name */
    public Message f849u;

    /* renamed from: v, reason: collision with root package name */
    public Drawable f850v;

    /* renamed from: w, reason: collision with root package name */
    public Button f851w;

    /* renamed from: x, reason: collision with root package name */
    public CharSequence f852x;

    /* renamed from: y, reason: collision with root package name */
    public Message f853y;

    /* renamed from: z, reason: collision with root package name */
    public Drawable f854z;

    /* renamed from: n, reason: collision with root package name */
    public boolean f842n = false;
    public int B = 0;
    public int I = -1;
    public int Q = 0;
    public final View.OnClickListener S = new a();

    public static class RecycleListView extends ListView {

        /* renamed from: a, reason: collision with root package name */
        public final int f855a;

        /* renamed from: b, reason: collision with root package name */
        public final int f856b;

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.F);
            this.f856b = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.RecycleListView_paddingBottomNoButtons, -1);
            this.f855a = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.RecycleListView_paddingTopNoTitle, -1);
        }

        public void a(boolean z10, boolean z11) {
            if (z11 && z10) {
                return;
            }
            setPadding(getPaddingLeft(), z10 ? getPaddingTop() : this.f855a, getPaddingRight(), z11 ? getPaddingBottom() : this.f856b);
        }
    }

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Message message;
            Message message2;
            Message message3;
            AlertController alertController = AlertController.this;
            Message obtain = (view != alertController.f843o || (message3 = alertController.f845q) == null) ? (view != alertController.f847s || (message2 = alertController.f849u) == null) ? (view != alertController.f851w || (message = alertController.f853y) == null) ? null : Message.obtain(message) : Message.obtain(message2) : Message.obtain(message3);
            if (obtain != null) {
                obtain.sendToTarget();
            }
            AlertController alertController2 = AlertController.this;
            alertController2.R.obtainMessage(1, alertController2.f830b).sendToTarget();
        }
    }

    public class b implements NestedScrollView.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f858a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f859b;

        public b(View view, View view2) {
            this.f858a = view;
            this.f859b = view2;
        }

        @Override // androidx.core.widget.NestedScrollView.b
        public void onScrollChange(NestedScrollView nestedScrollView, int i10, int i11, int i12, int i13) {
            AlertController.g(nestedScrollView, this.f858a, this.f859b);
        }
    }

    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f861a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f862b;

        public c(View view, View view2) {
            this.f861a = view;
            this.f862b = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            AlertController.g(AlertController.this.A, this.f861a, this.f862b);
        }
    }

    public class d implements AbsListView.OnScrollListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f864a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f865b;

        public d(View view, View view2) {
            this.f864a = view;
            this.f865b = view2;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
            AlertController.g(absListView, this.f864a, this.f865b);
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i10) {
        }
    }

    public class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f867a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f868b;

        public e(View view, View view2) {
            this.f867a = view;
            this.f868b = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            AlertController.g(AlertController.this.f835g, this.f867a, this.f868b);
        }
    }

    public static class f {
        public int A;
        public int B;
        public int C;
        public int D;
        public boolean[] F;
        public boolean G;
        public boolean H;
        public DialogInterface.OnMultiChoiceClickListener J;
        public Cursor K;
        public String L;
        public String M;
        public boolean N;
        public AdapterView.OnItemSelectedListener O;

        /* renamed from: a, reason: collision with root package name */
        public final Context f870a;

        /* renamed from: b, reason: collision with root package name */
        public final LayoutInflater f871b;

        /* renamed from: d, reason: collision with root package name */
        public Drawable f873d;

        /* renamed from: f, reason: collision with root package name */
        public CharSequence f875f;

        /* renamed from: g, reason: collision with root package name */
        public View f876g;

        /* renamed from: h, reason: collision with root package name */
        public CharSequence f877h;

        /* renamed from: i, reason: collision with root package name */
        public CharSequence f878i;

        /* renamed from: j, reason: collision with root package name */
        public Drawable f879j;

        /* renamed from: k, reason: collision with root package name */
        public DialogInterface.OnClickListener f880k;

        /* renamed from: l, reason: collision with root package name */
        public CharSequence f881l;

        /* renamed from: m, reason: collision with root package name */
        public Drawable f882m;

        /* renamed from: n, reason: collision with root package name */
        public DialogInterface.OnClickListener f883n;

        /* renamed from: o, reason: collision with root package name */
        public CharSequence f884o;

        /* renamed from: p, reason: collision with root package name */
        public Drawable f885p;

        /* renamed from: q, reason: collision with root package name */
        public DialogInterface.OnClickListener f886q;

        /* renamed from: s, reason: collision with root package name */
        public DialogInterface.OnCancelListener f888s;

        /* renamed from: t, reason: collision with root package name */
        public DialogInterface.OnDismissListener f889t;

        /* renamed from: u, reason: collision with root package name */
        public DialogInterface.OnKeyListener f890u;

        /* renamed from: v, reason: collision with root package name */
        public CharSequence[] f891v;

        /* renamed from: w, reason: collision with root package name */
        public ListAdapter f892w;

        /* renamed from: x, reason: collision with root package name */
        public DialogInterface.OnClickListener f893x;

        /* renamed from: y, reason: collision with root package name */
        public int f894y;

        /* renamed from: z, reason: collision with root package name */
        public View f895z;

        /* renamed from: c, reason: collision with root package name */
        public int f872c = 0;

        /* renamed from: e, reason: collision with root package name */
        public int f874e = 0;
        public boolean E = false;
        public int I = -1;
        public boolean P = true;

        /* renamed from: r, reason: collision with root package name */
        public boolean f887r = true;

        public class a extends ArrayAdapter {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ RecycleListView f896a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Context context, int i10, int i11, CharSequence[] charSequenceArr, RecycleListView recycleListView) {
                super(context, i10, i11, charSequenceArr);
                this.f896a = recycleListView;
            }

            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            public View getView(int i10, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i10, view, viewGroup);
                boolean[] zArr = f.this.F;
                if (zArr != null && zArr[i10]) {
                    this.f896a.setItemChecked(i10, true);
                }
                return view2;
            }
        }

        public class b extends CursorAdapter {

            /* renamed from: a, reason: collision with root package name */
            public final int f898a;

            /* renamed from: b, reason: collision with root package name */
            public final int f899b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ RecycleListView f900c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ AlertController f901d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(Context context, Cursor cursor, boolean z10, RecycleListView recycleListView, AlertController alertController) {
                super(context, cursor, z10);
                this.f900c = recycleListView;
                this.f901d = alertController;
                Cursor cursor2 = getCursor();
                this.f898a = cursor2.getColumnIndexOrThrow(f.this.L);
                this.f899b = cursor2.getColumnIndexOrThrow(f.this.M);
            }

            @Override // android.widget.CursorAdapter
            public void bindView(View view, Context context, Cursor cursor) {
                ((CheckedTextView) view.findViewById(R.id.text1)).setText(cursor.getString(this.f898a));
                this.f900c.setItemChecked(cursor.getPosition(), cursor.getInt(this.f899b) == 1);
            }

            @Override // android.widget.CursorAdapter
            public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                return f.this.f871b.inflate(this.f901d.M, viewGroup, false);
            }
        }

        public class c implements AdapterView.OnItemClickListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AlertController f903a;

            public c(AlertController alertController) {
                this.f903a = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                f.this.f893x.onClick(this.f903a.f830b, i10);
                if (f.this.H) {
                    return;
                }
                this.f903a.f830b.dismiss();
            }
        }

        public class d implements AdapterView.OnItemClickListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ RecycleListView f905a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ AlertController f906b;

            public d(RecycleListView recycleListView, AlertController alertController) {
                this.f905a = recycleListView;
                this.f906b = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                boolean[] zArr = f.this.F;
                if (zArr != null) {
                    zArr[i10] = this.f905a.isItemChecked(i10);
                }
                f.this.J.onClick(this.f906b.f830b, i10, this.f905a.isItemChecked(i10));
            }
        }

        public f(Context context) {
            this.f870a = context;
            this.f871b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public void a(AlertController alertController) {
            View view = this.f876g;
            if (view != null) {
                alertController.n(view);
            } else {
                CharSequence charSequence = this.f875f;
                if (charSequence != null) {
                    alertController.s(charSequence);
                }
                Drawable drawable = this.f873d;
                if (drawable != null) {
                    alertController.p(drawable);
                }
                int i10 = this.f872c;
                if (i10 != 0) {
                    alertController.o(i10);
                }
                int i11 = this.f874e;
                if (i11 != 0) {
                    alertController.o(alertController.d(i11));
                }
            }
            CharSequence charSequence2 = this.f877h;
            if (charSequence2 != null) {
                alertController.q(charSequence2);
            }
            CharSequence charSequence3 = this.f878i;
            if (charSequence3 != null || this.f879j != null) {
                alertController.l(-1, charSequence3, this.f880k, null, this.f879j);
            }
            CharSequence charSequence4 = this.f881l;
            if (charSequence4 != null || this.f882m != null) {
                alertController.l(-2, charSequence4, this.f883n, null, this.f882m);
            }
            CharSequence charSequence5 = this.f884o;
            if (charSequence5 != null || this.f885p != null) {
                alertController.l(-3, charSequence5, this.f886q, null, this.f885p);
            }
            if (this.f891v != null || this.K != null || this.f892w != null) {
                b(alertController);
            }
            View view2 = this.f895z;
            if (view2 != null) {
                if (this.E) {
                    alertController.v(view2, this.A, this.B, this.C, this.D);
                    return;
                } else {
                    alertController.u(view2);
                    return;
                }
            }
            int i12 = this.f894y;
            if (i12 != 0) {
                alertController.t(i12);
            }
        }

        public final void b(AlertController alertController) {
            ListAdapter listAdapter;
            RecycleListView recycleListView = (RecycleListView) this.f871b.inflate(alertController.L, (ViewGroup) null);
            if (this.G) {
                listAdapter = this.K == null ? new a(this.f870a, alertController.M, R.id.text1, this.f891v, recycleListView) : new b(this.f870a, this.K, false, recycleListView, alertController);
            } else {
                int i10 = this.H ? alertController.N : alertController.O;
                if (this.K != null) {
                    listAdapter = new SimpleCursorAdapter(this.f870a, i10, this.K, new String[]{this.L}, new int[]{R.id.text1});
                } else {
                    listAdapter = this.f892w;
                    if (listAdapter == null) {
                        listAdapter = new h(this.f870a, i10, R.id.text1, this.f891v);
                    }
                }
            }
            alertController.H = listAdapter;
            alertController.I = this.I;
            if (this.f893x != null) {
                recycleListView.setOnItemClickListener(new c(alertController));
            } else if (this.J != null) {
                recycleListView.setOnItemClickListener(new d(recycleListView, alertController));
            }
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.O;
            if (onItemSelectedListener != null) {
                recycleListView.setOnItemSelectedListener(onItemSelectedListener);
            }
            if (this.H) {
                recycleListView.setChoiceMode(1);
            } else if (this.G) {
                recycleListView.setChoiceMode(2);
            }
            alertController.f835g = recycleListView;
        }
    }

    public static final class g extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public WeakReference f908a;

        public g(DialogInterface dialogInterface) {
            this.f908a = new WeakReference(dialogInterface);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == -3 || i10 == -2 || i10 == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.f908a.get(), message.what);
            } else {
                if (i10 != 1) {
                    return;
                }
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    public static class h extends ArrayAdapter {
        public h(Context context, int i10, int i11, CharSequence[] charSequenceArr) {
            super(context, i10, i11, charSequenceArr);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i10) {
            return i10;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }
    }

    public AlertController(Context context, j jVar, Window window) {
        this.f829a = context;
        this.f830b = jVar;
        this.f831c = window;
        this.R = new g(jVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, R$styleable.f809g, R$attr.alertDialogStyle, 0);
        this.J = obtainStyledAttributes.getResourceId(R$styleable.AlertDialog_android_layout, 0);
        this.K = obtainStyledAttributes.getResourceId(R$styleable.AlertDialog_buttonPanelSideLayout, 0);
        this.L = obtainStyledAttributes.getResourceId(R$styleable.AlertDialog_listLayout, 0);
        this.M = obtainStyledAttributes.getResourceId(R$styleable.AlertDialog_multiChoiceItemLayout, 0);
        this.N = obtainStyledAttributes.getResourceId(R$styleable.AlertDialog_singleChoiceItemLayout, 0);
        this.O = obtainStyledAttributes.getResourceId(R$styleable.AlertDialog_listItemLayout, 0);
        this.P = obtainStyledAttributes.getBoolean(R$styleable.AlertDialog_showTitle, true);
        this.f832d = obtainStyledAttributes.getDimensionPixelSize(R$styleable.AlertDialog_buttonIconDimen, 0);
        obtainStyledAttributes.recycle();
        jVar.supportRequestWindowFeature(1);
    }

    public static boolean B(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R$attr.alertDialogCenterButtons, typedValue, true);
        return typedValue.data != 0;
    }

    public static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public static void g(View view, View view2, View view3) {
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            view3.setVisibility(view.canScrollVertically(1) ? 0 : 4);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void A() {
        View findViewById;
        ListAdapter listAdapter;
        View findViewById2;
        View findViewById3 = this.f831c.findViewById(R$id.parentPanel);
        int i10 = R$id.topPanel;
        View findViewById4 = findViewById3.findViewById(i10);
        int i11 = R$id.contentPanel;
        View findViewById5 = findViewById3.findViewById(i11);
        int i12 = R$id.buttonPanel;
        View findViewById6 = findViewById3.findViewById(i12);
        ViewGroup viewGroup = (ViewGroup) findViewById3.findViewById(R$id.customPanel);
        y(viewGroup);
        View findViewById7 = viewGroup.findViewById(i10);
        View findViewById8 = viewGroup.findViewById(i11);
        View findViewById9 = viewGroup.findViewById(i12);
        ViewGroup j10 = j(findViewById7, findViewById4);
        ViewGroup j11 = j(findViewById8, findViewById5);
        ViewGroup j12 = j(findViewById9, findViewById6);
        x(j11);
        w(j12);
        z(j10);
        boolean z10 = viewGroup.getVisibility() != 8;
        boolean z11 = (j10 == null || j10.getVisibility() == 8) ? 0 : 1;
        boolean z12 = (j12 == null || j12.getVisibility() == 8) ? false : true;
        if (!z12 && j11 != null && (findViewById2 = j11.findViewById(R$id.textSpacerNoButtons)) != null) {
            findViewById2.setVisibility(0);
        }
        if (z11 != 0) {
            NestedScrollView nestedScrollView = this.A;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            View findViewById10 = (this.f834f == null && this.f835g == null) ? null : j10.findViewById(R$id.titleDividerNoCustom);
            if (findViewById10 != null) {
                findViewById10.setVisibility(0);
            }
        } else if (j11 != null && (findViewById = j11.findViewById(R$id.textSpacerNoTitle)) != null) {
            findViewById.setVisibility(0);
        }
        ListView listView = this.f835g;
        if (listView instanceof RecycleListView) {
            ((RecycleListView) listView).a(z11, z12);
        }
        if (!z10) {
            View view = this.f835g;
            if (view == null) {
                view = this.A;
            }
            if (view != null) {
                r(j11, view, z11 | (z12 ? 2 : 0), 3);
            }
        }
        ListView listView2 = this.f835g;
        if (listView2 == null || (listAdapter = this.H) == null) {
            return;
        }
        listView2.setAdapter(listAdapter);
        int i13 = this.I;
        if (i13 > -1) {
            listView2.setItemChecked(i13, true);
            listView2.setSelection(i13);
        }
    }

    public final void b(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    public Button c(int i10) {
        if (i10 == -3) {
            return this.f851w;
        }
        if (i10 == -2) {
            return this.f847s;
        }
        if (i10 != -1) {
            return null;
        }
        return this.f843o;
    }

    public int d(int i10) {
        TypedValue typedValue = new TypedValue();
        this.f829a.getTheme().resolveAttribute(i10, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView e() {
        return this.f835g;
    }

    public void f() {
        this.f830b.setContentView(k());
        A();
    }

    public boolean h(int i10, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        return nestedScrollView != null && nestedScrollView.executeKeyEvent(keyEvent);
    }

    public boolean i(int i10, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        return nestedScrollView != null && nestedScrollView.executeKeyEvent(keyEvent);
    }

    public final ViewGroup j(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    public final int k() {
        int i10 = this.K;
        return i10 == 0 ? this.J : this.Q == 1 ? i10 : this.J;
    }

    public void l(int i10, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.R.obtainMessage(i10, onClickListener);
        }
        if (i10 == -3) {
            this.f852x = charSequence;
            this.f853y = message;
            this.f854z = drawable;
        } else if (i10 == -2) {
            this.f848t = charSequence;
            this.f849u = message;
            this.f850v = drawable;
        } else {
            if (i10 != -1) {
                throw new IllegalArgumentException("Button does not exist");
            }
            this.f844p = charSequence;
            this.f845q = message;
            this.f846r = drawable;
        }
    }

    public void m(int i10) {
        this.Q = i10;
    }

    public void n(View view) {
        this.G = view;
    }

    public void o(int i10) {
        this.C = null;
        this.B = i10;
        ImageView imageView = this.D;
        if (imageView != null) {
            if (i10 == 0) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.D.setImageResource(this.B);
            }
        }
    }

    public void p(Drawable drawable) {
        this.C = drawable;
        this.B = 0;
        ImageView imageView = this.D;
        if (imageView != null) {
            if (drawable == null) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.D.setImageDrawable(drawable);
            }
        }
    }

    public void q(CharSequence charSequence) {
        this.f834f = charSequence;
        TextView textView = this.F;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public final void r(ViewGroup viewGroup, View view, int i10, int i11) {
        View findViewById = this.f831c.findViewById(R$id.scrollIndicatorUp);
        View findViewById2 = this.f831c.findViewById(R$id.scrollIndicatorDown);
        if (Build.VERSION.SDK_INT >= 23) {
            c1.I0(view, i10, i11);
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 != null) {
                viewGroup.removeView(findViewById2);
                return;
            }
            return;
        }
        if (findViewById != null && (i10 & 1) == 0) {
            viewGroup.removeView(findViewById);
            findViewById = null;
        }
        if (findViewById2 != null && (i10 & 2) == 0) {
            viewGroup.removeView(findViewById2);
            findViewById2 = null;
        }
        if (findViewById == null && findViewById2 == null) {
            return;
        }
        if (this.f834f != null) {
            this.A.setOnScrollChangeListener(new b(findViewById, findViewById2));
            this.A.post(new c(findViewById, findViewById2));
            return;
        }
        ListView listView = this.f835g;
        if (listView != null) {
            listView.setOnScrollListener(new d(findViewById, findViewById2));
            this.f835g.post(new e(findViewById, findViewById2));
            return;
        }
        if (findViewById != null) {
            viewGroup.removeView(findViewById);
        }
        if (findViewById2 != null) {
            viewGroup.removeView(findViewById2);
        }
    }

    public void s(CharSequence charSequence) {
        this.f833e = charSequence;
        TextView textView = this.E;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void t(int i10) {
        this.f836h = null;
        this.f837i = i10;
        this.f842n = false;
    }

    public void u(View view) {
        this.f836h = view;
        this.f837i = 0;
        this.f842n = false;
    }

    public void v(View view, int i10, int i11, int i12, int i13) {
        this.f836h = view;
        this.f837i = 0;
        this.f842n = true;
        this.f838j = i10;
        this.f839k = i11;
        this.f840l = i12;
        this.f841m = i13;
    }

    public final void w(ViewGroup viewGroup) {
        int i10;
        Button button = (Button) viewGroup.findViewById(R.id.button1);
        this.f843o = button;
        button.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.f844p) && this.f846r == null) {
            this.f843o.setVisibility(8);
            i10 = 0;
        } else {
            this.f843o.setText(this.f844p);
            Drawable drawable = this.f846r;
            if (drawable != null) {
                int i11 = this.f832d;
                drawable.setBounds(0, 0, i11, i11);
                this.f843o.setCompoundDrawables(this.f846r, null, null, null);
            }
            this.f843o.setVisibility(0);
            i10 = 1;
        }
        Button button2 = (Button) viewGroup.findViewById(R.id.button2);
        this.f847s = button2;
        button2.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.f848t) && this.f850v == null) {
            this.f847s.setVisibility(8);
        } else {
            this.f847s.setText(this.f848t);
            Drawable drawable2 = this.f850v;
            if (drawable2 != null) {
                int i12 = this.f832d;
                drawable2.setBounds(0, 0, i12, i12);
                this.f847s.setCompoundDrawables(this.f850v, null, null, null);
            }
            this.f847s.setVisibility(0);
            i10 |= 2;
        }
        Button button3 = (Button) viewGroup.findViewById(R.id.button3);
        this.f851w = button3;
        button3.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.f852x) && this.f854z == null) {
            this.f851w.setVisibility(8);
        } else {
            this.f851w.setText(this.f852x);
            Drawable drawable3 = this.f846r;
            if (drawable3 != null) {
                int i13 = this.f832d;
                drawable3.setBounds(0, 0, i13, i13);
                this.f843o.setCompoundDrawables(this.f846r, null, null, null);
            }
            this.f851w.setVisibility(0);
            i10 |= 4;
        }
        if (B(this.f829a)) {
            if (i10 == 1) {
                b(this.f843o);
            } else if (i10 == 2) {
                b(this.f847s);
            } else if (i10 == 4) {
                b(this.f851w);
            }
        }
        if (i10 != 0) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    public final void x(ViewGroup viewGroup) {
        NestedScrollView nestedScrollView = (NestedScrollView) this.f831c.findViewById(R$id.scrollView);
        this.A = nestedScrollView;
        nestedScrollView.setFocusable(false);
        this.A.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroup.findViewById(R.id.message);
        this.F = textView;
        if (textView == null) {
            return;
        }
        CharSequence charSequence = this.f834f;
        if (charSequence != null) {
            textView.setText(charSequence);
            return;
        }
        textView.setVisibility(8);
        this.A.removeView(this.F);
        if (this.f835g == null) {
            viewGroup.setVisibility(8);
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) this.A.getParent();
        int indexOfChild = viewGroup2.indexOfChild(this.A);
        viewGroup2.removeViewAt(indexOfChild);
        viewGroup2.addView(this.f835g, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
    }

    public final void y(ViewGroup viewGroup) {
        View view = this.f836h;
        if (view == null) {
            view = this.f837i != 0 ? LayoutInflater.from(this.f829a).inflate(this.f837i, viewGroup, false) : null;
        }
        boolean z10 = view != null;
        if (!z10 || !a(view)) {
            this.f831c.setFlags(131072, 131072);
        }
        if (!z10) {
            viewGroup.setVisibility(8);
            return;
        }
        FrameLayout frameLayout = (FrameLayout) this.f831c.findViewById(R$id.custom);
        frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
        if (this.f842n) {
            frameLayout.setPadding(this.f838j, this.f839k, this.f840l, this.f841m);
        }
        if (this.f835g != null) {
            ((u1.a) viewGroup.getLayoutParams()).f1655a = 0.0f;
        }
    }

    public final void z(ViewGroup viewGroup) {
        if (this.G != null) {
            viewGroup.addView(this.G, 0, new ViewGroup.LayoutParams(-1, -2));
            this.f831c.findViewById(R$id.title_template).setVisibility(8);
            return;
        }
        this.D = (ImageView) this.f831c.findViewById(R.id.icon);
        if (!(!TextUtils.isEmpty(this.f833e)) || !this.P) {
            this.f831c.findViewById(R$id.title_template).setVisibility(8);
            this.D.setVisibility(8);
            viewGroup.setVisibility(8);
            return;
        }
        TextView textView = (TextView) this.f831c.findViewById(R$id.alertTitle);
        this.E = textView;
        textView.setText(this.f833e);
        int i10 = this.B;
        if (i10 != 0) {
            this.D.setImageResource(i10);
            return;
        }
        Drawable drawable = this.C;
        if (drawable != null) {
            this.D.setImageDrawable(drawable);
        } else {
            this.E.setPadding(this.D.getPaddingLeft(), this.D.getPaddingTop(), this.D.getPaddingRight(), this.D.getPaddingBottom());
            this.D.setVisibility(8);
        }
    }
}
