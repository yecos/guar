package l6;

import g5.j3;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.ArrayList;
import java.util.List;
import mobile.com.requestframe.utils.bean.ShelveDataRequestBean;
import mobile.com.requestframe.utils.response.ChildColumnList;
import mobile.com.requestframe.utils.response.ColumnContentsBean;
import mobile.com.requestframe.utils.response.GetColumnContentsResult;
import mobile.com.requestframe.utils.response.ShelveDataBean;
import mobile.com.requestframe.utils.response.ShelveListData;
import w6.i;

/* loaded from: classes3.dex */
public final class j2 implements l5.a {

    /* renamed from: a, reason: collision with root package name */
    public final f5.c f16054a;

    /* renamed from: b, reason: collision with root package name */
    public final j6.l f16055b;

    /* renamed from: c, reason: collision with root package name */
    public int f16056c;

    /* renamed from: d, reason: collision with root package name */
    public int f16057d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList f16058e;

    /* renamed from: f, reason: collision with root package name */
    public ArrayList f16059f;

    /* renamed from: g, reason: collision with root package name */
    public List f16060g;

    /* renamed from: h, reason: collision with root package name */
    public int f16061h;

    /* renamed from: i, reason: collision with root package name */
    public final long f16062i;

    /* renamed from: j, reason: collision with root package name */
    public Disposable f16063j;

    public static final class a extends t9.j implements s9.l {
        public a() {
            super(1);
        }

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0031, code lost:
        
            if (com.mobile.brasiltv.utils.b0.I(r0.getChildColumnList()) == false) goto L12;
         */
        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final List invoke(GetColumnContentsResult getColumnContentsResult) {
            Integer totalSize;
            t9.i.g(getColumnContentsResult, "it");
            j2 j2Var = j2.this;
            ColumnContentsBean data = getColumnContentsResult.getData();
            j2Var.f16057d = (data == null || (totalSize = data.getTotalSize()) == null) ? -1 : totalSize.intValue();
            if (getColumnContentsResult.getData() != null) {
                ColumnContentsBean data2 = getColumnContentsResult.getData();
                t9.i.d(data2);
            }
            j2.this.B().b();
            ColumnContentsBean data3 = getColumnContentsResult.getData();
            if (data3 != null) {
                return data3.getChildColumnList();
            }
            return null;
        }
    }

    public static final class b extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final b f16065a = new b();

        public b() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(List list) {
            t9.i.g(list, "it");
            return Boolean.valueOf(com.mobile.brasiltv.utils.b0.I(list));
        }
    }

    public static final class c extends ha.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f16067b;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f16068a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f16068a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.y yVar = com.mobile.brasiltv.utils.y.f8771a;
                String p10 = com.mobile.brasiltv.utils.y.p(yVar, this.f16068a, null, null, 6, null);
                if (!t9.i.b(na.d.c(this.f16068a), "no_report_type")) {
                    p10 = com.mobile.brasiltv.utils.y.p(yVar, this.f16068a, null, null, 6, null);
                }
                com.mobile.brasiltv.utils.f1.f8649a.x(p10);
            }
        }

        public c(int i10) {
            this.f16067b = i10;
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(List list) {
            t9.i.g(list, "list");
            j2.this.f16058e.addAll(list);
            j2.this.E(this.f16067b);
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            j2.this.f16060g.add(disposable);
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            j2.this.B().c(str);
            com.mobile.brasiltv.utils.x.f8754a.w(j2.this.y(), new a(str));
        }
    }

    public static final class d extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final d f16069a = new d();

        public d() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final List invoke(ShelveDataBean shelveDataBean) {
            t9.i.g(shelveDataBean, "it");
            ShelveListData data = shelveDataBean.getData();
            if (data != null) {
                return data.getAssetList();
            }
            return null;
        }
    }

    public static final class e extends ha.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ChildColumnList f16071b;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f16072a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f16072a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.y yVar = com.mobile.brasiltv.utils.y.f8771a;
                String p10 = com.mobile.brasiltv.utils.y.p(yVar, this.f16072a, null, null, 6, null);
                if (!t9.i.b(na.d.c(this.f16072a), "no_report_type")) {
                    p10 = com.mobile.brasiltv.utils.y.p(yVar, this.f16072a, null, null, 6, null);
                }
                com.mobile.brasiltv.utils.f1.f8649a.x(p10);
            }
        }

        public e(ChildColumnList childColumnList) {
            this.f16071b = childColumnList;
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(List list) {
            t9.i.g(list, "t");
            j2.this.K(this.f16071b.getId(), list);
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            j2.this.f16060g.add(disposable);
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            j2.this.B().c(str);
            com.mobile.brasiltv.utils.x.f8754a.w(j2.this.y(), new a(str));
        }
    }

    public static final class f extends t9.j implements s9.l {
        public f() {
            super(1);
        }

        public final void b(ChildColumnList childColumnList) {
            ArrayList arrayList = j2.this.f16059f;
            t9.i.f(childColumnList, "it");
            arrayList.add(new j3(childColumnList, i9.j.d()));
            j2.this.z(childColumnList);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((ChildColumnList) obj);
            return h9.t.f14242a;
        }
    }

    public static final class g extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final g f16074a = new g();

        public g() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return h9.t.f14242a;
        }

        public final void invoke(Throwable th) {
            th.printStackTrace();
        }
    }

    public j2(f5.c cVar, j6.l lVar) {
        t9.i.g(cVar, com.umeng.analytics.pro.f.X);
        t9.i.g(lVar, "view");
        this.f16054a = cVar;
        this.f16055b = lVar;
        this.f16056c = -1;
        this.f16057d = -1;
        this.f16058e = new ArrayList();
        this.f16059f = new ArrayList();
        this.f16060g = new ArrayList();
        this.f16061h = 1;
        this.f16062i = 10L;
    }

    public static final List A(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (List) lVar.invoke(obj);
    }

    public static final void F(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void G(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void H(j2 j2Var) {
        t9.i.g(j2Var, "this$0");
        j2Var.I();
    }

    public static final List w(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (List) lVar.invoke(obj);
    }

    public static final boolean x(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    public final j6.l B() {
        return this.f16055b;
    }

    public void C() {
        long j10 = this.f16057d;
        int i10 = this.f16061h;
        if (j10 <= i10 * this.f16062i) {
            this.f16055b.n1();
            return;
        }
        int i11 = i10 + 1;
        this.f16061h = i11;
        D(i11);
    }

    public final void D(int i10) {
        int i11 = this.f16056c;
        if (i11 != -1) {
            v(i11, i10);
        }
    }

    public final void E(int i10) {
        long j10 = (i10 - 1) * this.f16062i;
        if (j10 >= this.f16058e.size()) {
            this.f16055b.n1();
            return;
        }
        Disposable disposable = this.f16063j;
        if ((disposable == null || disposable.isDisposed()) ? false : true) {
            Disposable disposable2 = this.f16063j;
            t9.i.d(disposable2);
            disposable2.dispose();
        }
        Observable compose = Observable.fromIterable(this.f16058e).skip(j10).take(this.f16062i).compose(com.mobile.brasiltv.utils.p0.a());
        final f fVar = new f();
        Consumer consumer = new Consumer() { // from class: l6.f2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                j2.F(s9.l.this, obj);
            }
        };
        final g gVar = g.f16074a;
        this.f16063j = compose.subscribe(consumer, new Consumer() { // from class: l6.g2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                j2.G(s9.l.this, obj);
            }
        }, new Action() { // from class: l6.h2
            @Override // io.reactivex.functions.Action
            public final void run() {
                j2.H(j2.this);
            }
        });
    }

    public final void I() {
        this.f16055b.f(this.f16059f);
        this.f16055b.u0();
    }

    public void J(ChildColumnList childColumnList) {
        t9.i.g(childColumnList, "column");
        this.f16055b.a();
        com.mobile.brasiltv.utils.b0.U(this, "column.code " + childColumnList.getCode());
        u();
        this.f16061h = 1;
        this.f16058e.clear();
        this.f16059f.clear();
        this.f16056c = childColumnList.getId();
        D(this.f16061h);
    }

    public final void K(int i10, List list) {
        if (!this.f16059f.isEmpty()) {
            int i11 = 0;
            for (Object obj : this.f16059f) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    i9.j.j();
                }
                if (((j3) obj).a().getId() == i10) {
                    ((j3) this.f16059f.get(i11)).c(list);
                    this.f16055b.r(i11);
                }
                i11 = i12;
            }
        }
    }

    @Override // l5.a
    public void e() {
    }

    @Override // l5.a
    public void g() {
        Disposable disposable = this.f16063j;
        boolean z10 = false;
        if (disposable != null && !disposable.isDisposed()) {
            z10 = true;
        }
        if (z10) {
            Disposable disposable2 = this.f16063j;
            t9.i.d(disposable2);
            disposable2.dispose();
        }
        u();
    }

    public final void u() {
        for (Disposable disposable : this.f16060g) {
            if (!disposable.isDisposed()) {
                disposable.dispose();
            }
        }
        this.f16060g.clear();
    }

    public final void v(int i10, int i11) {
        Observable h12 = w6.i.f19214g.b().h1(i10, true, i11, (int) this.f16062i);
        final a aVar = new a();
        Observable map = h12.map(new Function() { // from class: l6.d2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List w10;
                w10 = j2.w(s9.l.this, obj);
                return w10;
            }
        });
        final b bVar = b.f16065a;
        map.filter(new Predicate() { // from class: l6.e2
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean x10;
                x10 = j2.x(s9.l.this, obj);
                return x10;
            }
        }).subscribe(new c(i11));
    }

    public final f5.c y() {
        return this.f16054a;
    }

    public final void z(ChildColumnList childColumnList) {
        i.c cVar = w6.i.f19214g;
        Observable P1 = cVar.b().P1(new ShelveDataRequestBean(cVar.J(), cVar.H(), cVar.v(), childColumnList.getId(), "2", 1000, 1, null, null));
        final d dVar = d.f16069a;
        P1.map(new Function() { // from class: l6.i2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List A;
                A = j2.A(s9.l.this, obj);
                return A;
            }
        }).subscribe(new e(childColumnList));
    }
}
