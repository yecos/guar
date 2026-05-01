package androidx.mediarouter.app;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.j;
import androidx.mediarouter.R$id;
import androidx.mediarouter.R$layout;
import androidx.mediarouter.R$string;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import n0.s0;
import n0.t0;

/* loaded from: classes.dex */
public class g extends j {

    /* renamed from: a, reason: collision with root package name */
    public final t0 f2846a;

    /* renamed from: b, reason: collision with root package name */
    public final c f2847b;

    /* renamed from: c, reason: collision with root package name */
    public Context f2848c;

    /* renamed from: d, reason: collision with root package name */
    public s0 f2849d;

    /* renamed from: e, reason: collision with root package name */
    public List f2850e;

    /* renamed from: f, reason: collision with root package name */
    public ImageButton f2851f;

    /* renamed from: g, reason: collision with root package name */
    public d f2852g;

    /* renamed from: h, reason: collision with root package name */
    public RecyclerView f2853h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f2854i;

    /* renamed from: j, reason: collision with root package name */
    public t0.i f2855j;

    /* renamed from: k, reason: collision with root package name */
    public long f2856k;

    /* renamed from: l, reason: collision with root package name */
    public long f2857l;

    /* renamed from: m, reason: collision with root package name */
    public final Handler f2858m;

    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            g.this.f((List) message.obj);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.this.dismiss();
        }
    }

    public final class c extends t0.b {
        public c() {
        }

        @Override // n0.t0.b
        public void onRouteAdded(t0 t0Var, t0.i iVar) {
            g.this.c();
        }

        @Override // n0.t0.b
        public void onRouteChanged(t0 t0Var, t0.i iVar) {
            g.this.c();
        }

        @Override // n0.t0.b
        public void onRouteRemoved(t0 t0Var, t0.i iVar) {
            g.this.c();
        }

        @Override // n0.t0.b
        public void onRouteSelected(t0 t0Var, t0.i iVar) {
            g.this.dismiss();
        }
    }

    public final class d extends RecyclerView.g {

        /* renamed from: a, reason: collision with root package name */
        public final ArrayList f2862a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        public final LayoutInflater f2863b;

        /* renamed from: c, reason: collision with root package name */
        public final Drawable f2864c;

        /* renamed from: d, reason: collision with root package name */
        public final Drawable f2865d;

        /* renamed from: e, reason: collision with root package name */
        public final Drawable f2866e;

        /* renamed from: f, reason: collision with root package name */
        public final Drawable f2867f;

        public class a extends RecyclerView.d0 {

            /* renamed from: a, reason: collision with root package name */
            public TextView f2869a;

            public a(View view) {
                super(view);
                this.f2869a = (TextView) view.findViewById(R$id.mr_picker_header_name);
            }

            public void b(b bVar) {
                this.f2869a.setText(bVar.a().toString());
            }
        }

        public class b {

            /* renamed from: a, reason: collision with root package name */
            public final Object f2871a;

            /* renamed from: b, reason: collision with root package name */
            public final int f2872b;

            public b(Object obj) {
                this.f2871a = obj;
                if (obj instanceof String) {
                    this.f2872b = 1;
                } else if (obj instanceof t0.i) {
                    this.f2872b = 2;
                } else {
                    this.f2872b = 0;
                }
            }

            public Object a() {
                return this.f2871a;
            }

            public int b() {
                return this.f2872b;
            }
        }

        public class c extends RecyclerView.d0 {

            /* renamed from: a, reason: collision with root package name */
            public final View f2874a;

            /* renamed from: b, reason: collision with root package name */
            public final ImageView f2875b;

            /* renamed from: c, reason: collision with root package name */
            public final ProgressBar f2876c;

            /* renamed from: d, reason: collision with root package name */
            public final TextView f2877d;

            public class a implements View.OnClickListener {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ t0.i f2879a;

                public a(t0.i iVar) {
                    this.f2879a = iVar;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    g gVar = g.this;
                    t0.i iVar = this.f2879a;
                    gVar.f2855j = iVar;
                    iVar.I();
                    c.this.f2875b.setVisibility(4);
                    c.this.f2876c.setVisibility(0);
                }
            }

            public c(View view) {
                super(view);
                this.f2874a = view;
                this.f2875b = (ImageView) view.findViewById(R$id.mr_picker_route_icon);
                ProgressBar progressBar = (ProgressBar) view.findViewById(R$id.mr_picker_route_progress_bar);
                this.f2876c = progressBar;
                this.f2877d = (TextView) view.findViewById(R$id.mr_picker_route_name);
                i.t(g.this.f2848c, progressBar);
            }

            public void b(b bVar) {
                t0.i iVar = (t0.i) bVar.a();
                this.f2874a.setVisibility(0);
                this.f2876c.setVisibility(4);
                this.f2874a.setOnClickListener(new a(iVar));
                this.f2877d.setText(iVar.m());
                this.f2875b.setImageDrawable(d.this.b(iVar));
            }
        }

        public d() {
            this.f2863b = LayoutInflater.from(g.this.f2848c);
            this.f2864c = i.g(g.this.f2848c);
            this.f2865d = i.q(g.this.f2848c);
            this.f2866e = i.m(g.this.f2848c);
            this.f2867f = i.n(g.this.f2848c);
            d();
        }

        public final Drawable a(t0.i iVar) {
            int f10 = iVar.f();
            return f10 != 1 ? f10 != 2 ? iVar.y() ? this.f2867f : this.f2864c : this.f2866e : this.f2865d;
        }

        public Drawable b(t0.i iVar) {
            Uri j10 = iVar.j();
            if (j10 != null) {
                try {
                    Drawable createFromStream = Drawable.createFromStream(g.this.f2848c.getContentResolver().openInputStream(j10), null);
                    if (createFromStream != null) {
                        return createFromStream;
                    }
                } catch (IOException unused) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Failed to load ");
                    sb.append(j10);
                }
            }
            return a(iVar);
        }

        public b c(int i10) {
            return (b) this.f2862a.get(i10);
        }

        public void d() {
            this.f2862a.clear();
            this.f2862a.add(new b(g.this.f2848c.getString(R$string.mr_chooser_title)));
            Iterator it = g.this.f2850e.iterator();
            while (it.hasNext()) {
                this.f2862a.add(new b((t0.i) it.next()));
            }
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public int getItemCount() {
            return this.f2862a.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public int getItemViewType(int i10) {
            return ((b) this.f2862a.get(i10)).b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public void onBindViewHolder(RecyclerView.d0 d0Var, int i10) {
            int itemViewType = getItemViewType(i10);
            b c10 = c(i10);
            if (itemViewType == 1) {
                ((a) d0Var).b(c10);
            } else {
                if (itemViewType != 2) {
                    return;
                }
                ((c) d0Var).b(c10);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.g
        public RecyclerView.d0 onCreateViewHolder(ViewGroup viewGroup, int i10) {
            if (i10 == 1) {
                return new a(this.f2863b.inflate(R$layout.mr_picker_header_item, viewGroup, false));
            }
            if (i10 != 2) {
                return null;
            }
            return new c(this.f2863b.inflate(R$layout.mr_picker_route_item, viewGroup, false));
        }
    }

    public static final class e implements Comparator {

        /* renamed from: a, reason: collision with root package name */
        public static final e f2881a = new e();

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(t0.i iVar, t0.i iVar2) {
            return iVar.m().compareToIgnoreCase(iVar2.m());
        }
    }

    public g(Context context) {
        this(context, 0);
    }

    public boolean a(t0.i iVar) {
        return !iVar.w() && iVar.x() && iVar.E(this.f2849d);
    }

    public void b(List list) {
        int size = list.size();
        while (true) {
            int i10 = size - 1;
            if (size <= 0) {
                return;
            }
            if (!a((t0.i) list.get(i10))) {
                list.remove(i10);
            }
            size = i10;
        }
    }

    public void c() {
        if (this.f2855j == null && this.f2854i) {
            ArrayList arrayList = new ArrayList(this.f2846a.l());
            b(arrayList);
            Collections.sort(arrayList, e.f2881a);
            if (SystemClock.uptimeMillis() - this.f2857l >= this.f2856k) {
                f(arrayList);
                return;
            }
            this.f2858m.removeMessages(1);
            Handler handler = this.f2858m;
            handler.sendMessageAtTime(handler.obtainMessage(1, arrayList), this.f2857l + this.f2856k);
        }
    }

    public void d(s0 s0Var) {
        if (s0Var == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        if (this.f2849d.equals(s0Var)) {
            return;
        }
        this.f2849d = s0Var;
        if (this.f2854i) {
            this.f2846a.q(this.f2847b);
            this.f2846a.b(s0Var, this.f2847b, 1);
        }
        c();
    }

    public void e() {
        getWindow().setLayout(f.c(this.f2848c), f.a(this.f2848c));
    }

    public void f(List list) {
        this.f2857l = SystemClock.uptimeMillis();
        this.f2850e.clear();
        this.f2850e.addAll(list);
        this.f2852g.d();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2854i = true;
        this.f2846a.b(this.f2849d, this.f2847b, 1);
        c();
    }

    @Override // androidx.appcompat.app.j, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.mr_picker_dialog);
        i.s(this.f2848c, this);
        this.f2850e = new ArrayList();
        ImageButton imageButton = (ImageButton) findViewById(R$id.mr_picker_close_button);
        this.f2851f = imageButton;
        imageButton.setOnClickListener(new b());
        this.f2852g = new d();
        RecyclerView recyclerView = (RecyclerView) findViewById(R$id.mr_picker_list);
        this.f2853h = recyclerView;
        recyclerView.setAdapter(this.f2852g);
        this.f2853h.setLayoutManager(new LinearLayoutManager(this.f2848c));
        e();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f2854i = false;
        this.f2846a.q(this.f2847b);
        this.f2858m.removeMessages(1);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public g(android.content.Context r2, int r3) {
        /*
            r1 = this;
            r0 = 0
            android.content.Context r2 = androidx.mediarouter.app.i.b(r2, r3, r0)
            int r3 = androidx.mediarouter.app.i.c(r2)
            r1.<init>(r2, r3)
            n0.s0 r2 = n0.s0.f17005c
            r1.f2849d = r2
            androidx.mediarouter.app.g$a r2 = new androidx.mediarouter.app.g$a
            r2.<init>()
            r1.f2858m = r2
            android.content.Context r2 = r1.getContext()
            n0.t0 r3 = n0.t0.i(r2)
            r1.f2846a = r3
            androidx.mediarouter.app.g$c r3 = new androidx.mediarouter.app.g$c
            r3.<init>()
            r1.f2847b = r3
            r1.f2848c = r2
            android.content.res.Resources r2 = r2.getResources()
            int r3 = androidx.mediarouter.R$integer.mr_update_routes_delay_ms
            int r2 = r2.getInteger(r3)
            long r2 = (long) r2
            r1.f2856k = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.mediarouter.app.g.<init>(android.content.Context, int):void");
    }
}
