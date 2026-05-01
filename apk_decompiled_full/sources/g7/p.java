package g7;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.mobile.brasiltv.bean.AudioTrackBean;
import com.mobile.brasiltv.bean.NoSubTitleData;
import com.mobile.brasiltv.bean.OffSubTitleData;
import com.mobile.brasiltv.bean.SubTitleData;
import com.mobile.brasiltv.bean.SubtitleStyleBean;
import com.mobile.brasiltv.view.HorizontalDecoration;
import com.msandroid.mobile.R;
import com.zhy.autolayout.utils.AutoUtils;
import java.util.ArrayList;
import n6.k;

/* loaded from: classes3.dex */
public final class p extends g7.b {

    /* renamed from: b, reason: collision with root package name */
    public final RecyclerView f14046b;

    /* renamed from: c, reason: collision with root package name */
    public final RecyclerView f14047c;

    /* renamed from: d, reason: collision with root package name */
    public final RecyclerView f14048d;

    /* renamed from: e, reason: collision with root package name */
    public final RecyclerView f14049e;

    /* renamed from: f, reason: collision with root package name */
    public final ImageView f14050f;

    /* renamed from: g, reason: collision with root package name */
    public final TextView f14051g;

    /* renamed from: h, reason: collision with root package name */
    public final TextView f14052h;

    /* renamed from: i, reason: collision with root package name */
    public final h9.g f14053i;

    /* renamed from: j, reason: collision with root package name */
    public final h9.g f14054j;

    /* renamed from: k, reason: collision with root package name */
    public final h9.g f14055k;

    /* renamed from: l, reason: collision with root package name */
    public final h9.g f14056l;

    /* renamed from: m, reason: collision with root package name */
    public e f14057m;

    public static final class a implements k.a {
        public a() {
        }

        @Override // n6.k.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(int i10, AudioTrackBean audioTrackBean) {
            t9.i.g(audioTrackBean, "data");
            e eVar = p.this.f14057m;
            if (eVar != null) {
                eVar.c(i10, audioTrackBean);
            }
        }
    }

    public static final class b implements k.a {
        public b() {
        }

        @Override // n6.k.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(int i10, SubTitleData subTitleData) {
            t9.i.g(subTitleData, "data");
            if (subTitleData instanceof OffSubTitleData) {
                p.this.q(false);
                e eVar = p.this.f14057m;
                if (eVar != null) {
                    eVar.b(false);
                    return;
                }
                return;
            }
            if (subTitleData instanceof NoSubTitleData) {
                return;
            }
            p.this.q(true);
            e eVar2 = p.this.f14057m;
            if (eVar2 != null) {
                eVar2.a(i10, subTitleData);
            }
        }
    }

    public static final class c implements k.a {
        public c() {
        }

        @Override // n6.k.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(int i10, SubtitleStyleBean subtitleStyleBean) {
            t9.i.g(subtitleStyleBean, "data");
            e eVar = p.this.f14057m;
            if (eVar != null) {
                eVar.e(i10);
            }
        }
    }

    public static final class d implements k.a {
        public d() {
        }

        @Override // n6.k.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(int i10, String str) {
            t9.i.g(str, "data");
            e eVar = p.this.f14057m;
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
        public final /* synthetic */ Activity f14062a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Activity activity) {
            super(0);
            this.f14062a = activity;
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final n6.k invoke() {
            return new n6.k(this.f14062a);
        }
    }

    public static final class g extends t9.j implements s9.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f14063a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(Activity activity) {
            super(0);
            this.f14063a = activity;
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final n6.k invoke() {
            return new n6.k(this.f14063a);
        }
    }

    public static final class h extends t9.j implements s9.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f14064a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(Activity activity) {
            super(0);
            this.f14064a = activity;
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final n6.k invoke() {
            return new n6.k(this.f14064a);
        }
    }

    public static final class i extends t9.j implements s9.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f14065a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(Activity activity) {
            super(0);
            this.f14065a = activity;
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final n6.k invoke() {
            return new n6.k(this.f14065a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(Activity activity) {
        super(activity);
        t9.i.g(activity, "activity");
        this.f14053i = h9.h.b(new f(activity));
        this.f14054j = h9.h.b(new h(activity));
        this.f14055k = h9.h.b(new i(activity));
        this.f14056l = h9.h.b(new g(activity));
        View inflate = LayoutInflater.from(activity).inflate(R.layout.layout_pop_window_subtitle, (ViewGroup) null);
        t9.i.f(inflate, "from(activity).inflate(R…op_window_subtitle, null)");
        setContentView(inflate);
        setBackgroundDrawable(new ColorDrawable(0));
        View findViewById = inflate.findViewById(R.id.mRvAudio);
        t9.i.f(findViewById, "view.findViewById(R.id.mRvAudio)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.f14046b = recyclerView;
        View findViewById2 = inflate.findViewById(R.id.mRvLanguage);
        t9.i.f(findViewById2, "view.findViewById(R.id.mRvLanguage)");
        RecyclerView recyclerView2 = (RecyclerView) findViewById2;
        this.f14047c = recyclerView2;
        View findViewById3 = inflate.findViewById(R.id.mRvColor);
        t9.i.f(findViewById3, "view.findViewById(R.id.mRvColor)");
        RecyclerView recyclerView3 = (RecyclerView) findViewById3;
        this.f14048d = recyclerView3;
        View findViewById4 = inflate.findViewById(R.id.mRvSize);
        t9.i.f(findViewById4, "view.findViewById(R.id.mRvSize)");
        RecyclerView recyclerView4 = (RecyclerView) findViewById4;
        this.f14049e = recyclerView4;
        View findViewById5 = inflate.findViewById(R.id.mIvClose);
        t9.i.f(findViewById5, "view.findViewById(R.id.mIvClose)");
        ImageView imageView = (ImageView) findViewById5;
        this.f14050f = imageView;
        View findViewById6 = inflate.findViewById(R.id.mTvStyleTitle);
        t9.i.f(findViewById6, "view.findViewById(R.id.mTvStyleTitle)");
        this.f14051g = (TextView) findViewById6;
        View findViewById7 = inflate.findViewById(R.id.mTvSizeTitle);
        t9.i.f(findViewById7, "view.findViewById(R.id.mTvSizeTitle)");
        this.f14052h = (TextView) findViewById7;
        recyclerView.setLayoutManager(new LinearLayoutManager(activity, 0, false));
        recyclerView.addItemDecoration(new HorizontalDecoration(AutoUtils.getPercentWidthSize(10)));
        recyclerView.setAdapter(i());
        recyclerView2.setLayoutManager(new LinearLayoutManager(activity, 0, false));
        recyclerView2.addItemDecoration(new HorizontalDecoration(AutoUtils.getPercentWidthSize(10)));
        recyclerView2.setAdapter(k());
        recyclerView3.setLayoutManager(new LinearLayoutManager(activity, 0, false));
        recyclerView3.addItemDecoration(new HorizontalDecoration(AutoUtils.getPercentWidthSize(10)));
        recyclerView3.setAdapter(j());
        recyclerView4.setLayoutManager(new LinearLayoutManager(activity, 0, false));
        recyclerView4.addItemDecoration(new HorizontalDecoration(AutoUtils.getPercentWidthSize(10)));
        recyclerView4.setAdapter(l());
        i().f(new a());
        k().f(new b());
        j().f(new c());
        l().f(new d());
        imageView.setOnClickListener(new View.OnClickListener() { // from class: g7.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                p.g(p.this, view);
            }
        });
    }

    public static final void g(p pVar, View view) {
        t9.i.g(pVar, "this$0");
        pVar.dismiss();
    }

    public final n6.k i() {
        return (n6.k) this.f14053i.getValue();
    }

    public final n6.k j() {
        return (n6.k) this.f14056l.getValue();
    }

    public final n6.k k() {
        return (n6.k) this.f14054j.getValue();
    }

    public final n6.k l() {
        return (n6.k) this.f14055k.getValue();
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
        this.f14057m = eVar;
    }

    public final void p(ArrayList arrayList, int i10) {
        t9.i.g(arrayList, "data");
        k().e(arrayList);
        k().g(i10);
    }

    public final void q(boolean z10) {
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
        l().g(i12);
        j().g(i13);
        l().h(z10);
        j().h(z10);
    }
}
