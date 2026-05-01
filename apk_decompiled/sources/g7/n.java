package g7;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.mobile.brasiltv.bean.AudioTrackBean;
import com.mobile.brasiltv.bean.NoSubTitleData;
import com.mobile.brasiltv.bean.OffSubTitleData;
import com.mobile.brasiltv.bean.SubTitleData;
import com.mobile.brasiltv.bean.SubtitleStyleBean;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoLinearLayout;
import java.util.ArrayList;
import n6.i;

/* loaded from: classes3.dex */
public final class n extends g7.b {

    /* renamed from: b, reason: collision with root package name */
    public final RecyclerView f14025b;

    /* renamed from: c, reason: collision with root package name */
    public final RecyclerView f14026c;

    /* renamed from: d, reason: collision with root package name */
    public final RecyclerView f14027d;

    /* renamed from: e, reason: collision with root package name */
    public final RecyclerView f14028e;

    /* renamed from: f, reason: collision with root package name */
    public final TextView f14029f;

    /* renamed from: g, reason: collision with root package name */
    public final AutoLinearLayout f14030g;

    /* renamed from: h, reason: collision with root package name */
    public final AutoLinearLayout f14031h;

    /* renamed from: i, reason: collision with root package name */
    public final h9.g f14032i;

    /* renamed from: j, reason: collision with root package name */
    public final h9.g f14033j;

    /* renamed from: k, reason: collision with root package name */
    public final h9.g f14034k;

    /* renamed from: l, reason: collision with root package name */
    public final h9.g f14035l;

    /* renamed from: m, reason: collision with root package name */
    public e f14036m;

    public static final class a implements i.a {
        public a() {
        }

        @Override // n6.i.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(int i10, AudioTrackBean audioTrackBean) {
            t9.i.g(audioTrackBean, "data");
            e eVar = n.this.f14036m;
            if (eVar != null) {
                eVar.c(i10, audioTrackBean);
            }
        }
    }

    public static final class b implements i.a {
        public b() {
        }

        @Override // n6.i.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(int i10, SubTitleData subTitleData) {
            t9.i.g(subTitleData, "data");
            if (subTitleData instanceof OffSubTitleData) {
                n.this.q(false);
                e eVar = n.this.f14036m;
                if (eVar != null) {
                    eVar.b(false);
                    return;
                }
                return;
            }
            if (subTitleData instanceof NoSubTitleData) {
                return;
            }
            n.this.q(true);
            e eVar2 = n.this.f14036m;
            if (eVar2 != null) {
                eVar2.a(i10, subTitleData);
            }
        }
    }

    public static final class c implements i.a {
        public c() {
        }

        @Override // n6.i.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(int i10, SubtitleStyleBean subtitleStyleBean) {
            t9.i.g(subtitleStyleBean, "data");
            e eVar = n.this.f14036m;
            if (eVar != null) {
                eVar.e(i10);
            }
        }
    }

    public static final class d implements i.a {
        public d() {
        }

        @Override // n6.i.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(int i10, String str) {
            t9.i.g(str, "data");
            e eVar = n.this.f14036m;
            if (eVar != null) {
                eVar.d(i10);
            }
        }
    }

    public interface e {
        void a(int i10, SubTitleData subTitleData);

        void b(boolean z10);

        void c(int i10, AudioTrackBean audioTrackBean);

        void d(int i10);

        void e(int i10);
    }

    public static final class f extends t9.j implements s9.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f14041a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Activity activity) {
            super(0);
            this.f14041a = activity;
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final n6.i invoke() {
            return new n6.i(this.f14041a);
        }
    }

    public static final class g extends t9.j implements s9.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f14042a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(Activity activity) {
            super(0);
            this.f14042a = activity;
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final n6.i invoke() {
            return new n6.i(this.f14042a);
        }
    }

    public static final class h extends t9.j implements s9.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f14043a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(Activity activity) {
            super(0);
            this.f14043a = activity;
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final n6.i invoke() {
            return new n6.i(this.f14043a);
        }
    }

    public static final class i extends t9.j implements s9.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f14044a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(Activity activity) {
            super(0);
            this.f14044a = activity;
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final n6.i invoke() {
            return new n6.i(this.f14044a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(Activity activity) {
        super(activity);
        t9.i.g(activity, "activity");
        this.f14032i = h9.h.b(new f(activity));
        this.f14033j = h9.h.b(new h(activity));
        this.f14034k = h9.h.b(new i(activity));
        this.f14035l = h9.h.b(new g(activity));
        View inflate = LayoutInflater.from(activity).inflate(R.layout.layout_pop_window_subtitle_audio, (ViewGroup) null);
        t9.i.f(inflate, "from(activity).inflate(R…dow_subtitle_audio, null)");
        setContentView(inflate);
        setBackgroundDrawable(new ColorDrawable(0));
        setClippingEnabled(false);
        View findViewById = inflate.findViewById(R.id.mRvAudio);
        t9.i.f(findViewById, "view.findViewById(R.id.mRvAudio)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.f14025b = recyclerView;
        View findViewById2 = inflate.findViewById(R.id.mRvLanguage);
        t9.i.f(findViewById2, "view.findViewById(R.id.mRvLanguage)");
        RecyclerView recyclerView2 = (RecyclerView) findViewById2;
        this.f14026c = recyclerView2;
        View findViewById3 = inflate.findViewById(R.id.mRvColor);
        t9.i.f(findViewById3, "view.findViewById(R.id.mRvColor)");
        RecyclerView recyclerView3 = (RecyclerView) findViewById3;
        this.f14027d = recyclerView3;
        View findViewById4 = inflate.findViewById(R.id.mRvSize);
        t9.i.f(findViewById4, "view.findViewById(R.id.mRvSize)");
        RecyclerView recyclerView4 = (RecyclerView) findViewById4;
        this.f14028e = recyclerView4;
        View findViewById5 = inflate.findViewById(R.id.mTvClose);
        t9.i.f(findViewById5, "view.findViewById(R.id.mTvClose)");
        TextView textView = (TextView) findViewById5;
        this.f14029f = textView;
        View findViewById6 = inflate.findViewById(R.id.mLlLandStyle);
        t9.i.f(findViewById6, "view.findViewById(R.id.mLlLandStyle)");
        this.f14030g = (AutoLinearLayout) findViewById6;
        View findViewById7 = inflate.findViewById(R.id.mLlLandSize);
        t9.i.f(findViewById7, "view.findViewById(R.id.mLlLandSize)");
        this.f14031h = (AutoLinearLayout) findViewById7;
        recyclerView.setLayoutManager(new LinearLayoutManager(activity, 1, false));
        recyclerView.setAdapter(i());
        recyclerView2.setLayoutManager(new LinearLayoutManager(activity, 1, false));
        recyclerView2.setAdapter(k());
        recyclerView3.setLayoutManager(new LinearLayoutManager(activity, 1, false));
        recyclerView3.setAdapter(j());
        recyclerView4.setLayoutManager(new LinearLayoutManager(activity, 1, false));
        recyclerView4.setAdapter(l());
        i().f(new a());
        k().f(new b());
        j().f(new c());
        l().f(new d());
        textView.setOnClickListener(new View.OnClickListener() { // from class: g7.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                n.g(n.this, view);
            }
        });
    }

    public static final void g(n nVar, View view) {
        t9.i.g(nVar, "this$0");
        nVar.dismiss();
    }

    @Override // g7.b
    public boolean e() {
        return true;
    }

    public final n6.i i() {
        return (n6.i) this.f14032i.getValue();
    }

    public final n6.i j() {
        return (n6.i) this.f14035l.getValue();
    }

    public final n6.i k() {
        return (n6.i) this.f14033j.getValue();
    }

    public final n6.i l() {
        return (n6.i) this.f14034k.getValue();
    }

    public final void m(ArrayList arrayList, int i10) {
        t9.i.g(arrayList, "data");
        i().e(arrayList);
        i().g(i10);
    }

    public final void n(ArrayList arrayList, int i10) {
        t9.i.g(arrayList, "data");
        j().e(arrayList);
        j().g(i10);
    }

    public final void o(e eVar) {
        t9.i.g(eVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f14036m = eVar;
    }

    public final void p(ArrayList arrayList, int i10) {
        t9.i.g(arrayList, "data");
        k().e(arrayList);
        k().g(i10);
    }

    public final void q(boolean z10) {
        if (z10) {
            this.f14030g.setVisibility(0);
            this.f14031h.setVisibility(0);
        } else {
            this.f14030g.setVisibility(8);
            this.f14031h.setVisibility(8);
        }
        l().h(z10);
        j().h(z10);
    }

    public final void r(ArrayList arrayList, int i10) {
        t9.i.g(arrayList, "data");
        l().e(arrayList);
        l().g(i10);
    }

    public final void s(int i10, int i11, int i12, int i13, boolean z10) {
        i().g(i10);
        if (i11 == -1) {
            k().g(0);
        } else {
            k().g(i11);
        }
        if (z10) {
            this.f14031h.setVisibility(0);
            this.f14030g.setVisibility(0);
        } else {
            this.f14031h.setVisibility(8);
            this.f14030g.setVisibility(8);
        }
        l().g(i12);
        j().g(i13);
        l().h(z10);
        j().h(z10);
    }
}
