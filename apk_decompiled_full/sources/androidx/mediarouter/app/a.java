package androidx.mediarouter.app;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.j;
import androidx.mediarouter.R$attr;
import androidx.mediarouter.R$id;
import androidx.mediarouter.R$layout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import n0.s0;
import n0.t0;

/* loaded from: classes.dex */
public class a extends j {

    /* renamed from: a, reason: collision with root package name */
    public final t0 f2745a;

    /* renamed from: b, reason: collision with root package name */
    public final b f2746b;

    /* renamed from: c, reason: collision with root package name */
    public TextView f2747c;

    /* renamed from: d, reason: collision with root package name */
    public s0 f2748d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList f2749e;

    /* renamed from: f, reason: collision with root package name */
    public c f2750f;

    /* renamed from: g, reason: collision with root package name */
    public ListView f2751g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f2752h;

    /* renamed from: i, reason: collision with root package name */
    public long f2753i;

    /* renamed from: j, reason: collision with root package name */
    public final Handler f2754j;

    /* renamed from: androidx.mediarouter.app.a$a, reason: collision with other inner class name */
    public class HandlerC0039a extends Handler {
        public HandlerC0039a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            a.this.f((List) message.obj);
        }
    }

    public final class b extends t0.b {
        public b() {
        }

        @Override // n0.t0.b
        public void onRouteAdded(t0 t0Var, t0.i iVar) {
            a.this.c();
        }

        @Override // n0.t0.b
        public void onRouteChanged(t0 t0Var, t0.i iVar) {
            a.this.c();
        }

        @Override // n0.t0.b
        public void onRouteRemoved(t0 t0Var, t0.i iVar) {
            a.this.c();
        }

        @Override // n0.t0.b
        public void onRouteSelected(t0 t0Var, t0.i iVar) {
            a.this.dismiss();
        }
    }

    public static final class c extends ArrayAdapter implements AdapterView.OnItemClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final LayoutInflater f2757a;

        /* renamed from: b, reason: collision with root package name */
        public final Drawable f2758b;

        /* renamed from: c, reason: collision with root package name */
        public final Drawable f2759c;

        /* renamed from: d, reason: collision with root package name */
        public final Drawable f2760d;

        /* renamed from: e, reason: collision with root package name */
        public final Drawable f2761e;

        public c(Context context, List list) {
            super(context, 0, list);
            this.f2757a = LayoutInflater.from(context);
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{R$attr.mediaRouteDefaultIconDrawable, R$attr.mediaRouteTvIconDrawable, R$attr.mediaRouteSpeakerIconDrawable, R$attr.mediaRouteSpeakerGroupIconDrawable});
            this.f2758b = obtainStyledAttributes.getDrawable(0);
            this.f2759c = obtainStyledAttributes.getDrawable(1);
            this.f2760d = obtainStyledAttributes.getDrawable(2);
            this.f2761e = obtainStyledAttributes.getDrawable(3);
            obtainStyledAttributes.recycle();
        }

        public final Drawable a(t0.i iVar) {
            int f10 = iVar.f();
            return f10 != 1 ? f10 != 2 ? iVar.y() ? this.f2761e : this.f2758b : this.f2760d : this.f2759c;
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            return false;
        }

        public final Drawable b(t0.i iVar) {
            Uri j10 = iVar.j();
            if (j10 != null) {
                try {
                    Drawable createFromStream = Drawable.createFromStream(getContext().getContentResolver().openInputStream(j10), null);
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

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i10, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = this.f2757a.inflate(R$layout.mr_chooser_list_item, viewGroup, false);
            }
            t0.i iVar = (t0.i) getItem(i10);
            TextView textView = (TextView) view.findViewById(R$id.mr_chooser_route_name);
            TextView textView2 = (TextView) view.findViewById(R$id.mr_chooser_route_desc);
            textView.setText(iVar.m());
            String d10 = iVar.d();
            boolean z10 = true;
            if (iVar.c() != 2 && iVar.c() != 1) {
                z10 = false;
            }
            if (!z10 || TextUtils.isEmpty(d10)) {
                textView.setGravity(16);
                textView2.setVisibility(8);
                textView2.setText("");
            } else {
                textView.setGravity(80);
                textView2.setVisibility(0);
                textView2.setText(d10);
            }
            view.setEnabled(iVar.x());
            ImageView imageView = (ImageView) view.findViewById(R$id.mr_chooser_route_icon);
            if (imageView != null) {
                imageView.setImageDrawable(b(iVar));
            }
            return view;
        }

        @Override // android.widget.BaseAdapter, android.widget.ListAdapter
        public boolean isEnabled(int i10) {
            return ((t0.i) getItem(i10)).x();
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
            t0.i iVar = (t0.i) getItem(i10);
            if (iVar.x()) {
                ImageView imageView = (ImageView) view.findViewById(R$id.mr_chooser_route_icon);
                ProgressBar progressBar = (ProgressBar) view.findViewById(R$id.mr_chooser_route_progress_bar);
                imageView.setVisibility(8);
                progressBar.setVisibility(0);
                iVar.I();
            }
        }
    }

    public static final class d implements Comparator {

        /* renamed from: a, reason: collision with root package name */
        public static final d f2762a = new d();

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(t0.i iVar, t0.i iVar2) {
            return iVar.m().compareToIgnoreCase(iVar2.m());
        }
    }

    public a(Context context) {
        this(context, 0);
    }

    public boolean a(t0.i iVar) {
        return !iVar.w() && iVar.x() && iVar.E(this.f2748d);
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
        if (this.f2752h) {
            ArrayList arrayList = new ArrayList(this.f2745a.l());
            b(arrayList);
            Collections.sort(arrayList, d.f2762a);
            if (SystemClock.uptimeMillis() - this.f2753i >= 300) {
                f(arrayList);
                return;
            }
            this.f2754j.removeMessages(1);
            Handler handler = this.f2754j;
            handler.sendMessageAtTime(handler.obtainMessage(1, arrayList), this.f2753i + 300);
        }
    }

    public void d(s0 s0Var) {
        if (s0Var == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        if (this.f2748d.equals(s0Var)) {
            return;
        }
        this.f2748d = s0Var;
        if (this.f2752h) {
            this.f2745a.q(this.f2746b);
            this.f2745a.b(s0Var, this.f2746b, 1);
        }
        c();
    }

    public void e() {
        getWindow().setLayout(f.b(getContext()), -2);
    }

    public void f(List list) {
        this.f2753i = SystemClock.uptimeMillis();
        this.f2749e.clear();
        this.f2749e.addAll(list);
        this.f2750f.notifyDataSetChanged();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f2752h = true;
        this.f2745a.b(this.f2748d, this.f2746b, 1);
        c();
    }

    @Override // androidx.appcompat.app.j, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R$layout.mr_chooser_dialog);
        this.f2749e = new ArrayList();
        this.f2750f = new c(getContext(), this.f2749e);
        ListView listView = (ListView) findViewById(R$id.mr_chooser_list);
        this.f2751g = listView;
        listView.setAdapter((ListAdapter) this.f2750f);
        this.f2751g.setOnItemClickListener(this.f2750f);
        this.f2751g.setEmptyView(findViewById(R.id.empty));
        this.f2747c = (TextView) findViewById(R$id.mr_chooser_title);
        e();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.f2752h = false;
        this.f2745a.q(this.f2746b);
        this.f2754j.removeMessages(1);
        super.onDetachedFromWindow();
    }

    @Override // androidx.appcompat.app.j, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        this.f2747c.setText(charSequence);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public a(Context context, int i10) {
        super(r2, i.c(r2));
        Context b10 = i.b(context, i10, false);
        this.f2748d = s0.f17005c;
        this.f2754j = new HandlerC0039a();
        this.f2745a = t0.i(getContext());
        this.f2746b = new b();
    }

    @Override // androidx.appcompat.app.j, android.app.Dialog
    public void setTitle(int i10) {
        this.f2747c.setText(i10);
    }
}
