package k6;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.List;
import mobile.com.requestframe.utils.response.ChildColumnList;
import mobile.com.requestframe.utils.response.ColumnContentsBean;
import mobile.com.requestframe.utils.response.GetColumnContentsResult;

/* loaded from: classes3.dex */
public final class w implements l5.a {

    /* renamed from: a, reason: collision with root package name */
    public final f5.c f15608a;

    /* renamed from: b, reason: collision with root package name */
    public final i6.l f15609b;

    public static final class a extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final a f15610a = new a();

        public a() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final List invoke(GetColumnContentsResult getColumnContentsResult) {
            t9.i.g(getColumnContentsResult, "it");
            ColumnContentsBean data = getColumnContentsResult.getData();
            if (data != null) {
                return data.getChildColumnList();
            }
            return null;
        }
    }

    public static final class b extends t9.j implements s9.l {
        public b() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(List list) {
            t9.i.g(list, "it");
            if (list.isEmpty()) {
                w.this.k().k();
            }
            return Boolean.valueOf(com.mobile.brasiltv.utils.b0.I(list));
        }
    }

    public static final class c extends ha.a {

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15613a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f15613a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.y yVar = com.mobile.brasiltv.utils.y.f8771a;
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(yVar, this.f15613a, yVar.b(), null, 4, null));
            }
        }

        public c() {
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(List list) {
            t9.i.g(list, "t");
            w.this.k().f(list);
            w.this.k().k();
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            w.this.k().c(str);
            com.mobile.brasiltv.utils.x.f8754a.w(w.this.j(), new a(str));
        }
    }

    public w(f5.c cVar, i6.l lVar) {
        t9.i.g(cVar, com.umeng.analytics.pro.f.X);
        t9.i.g(lVar, "view");
        this.f15608a = cVar;
        this.f15609b = lVar;
    }

    public static final List m(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (List) lVar.invoke(obj);
    }

    public static final boolean n(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    @Override // l5.a
    public void e() {
    }

    @Override // l5.a
    public void g() {
    }

    public final f5.c j() {
        return this.f15608a;
    }

    public final i6.l k() {
        return this.f15609b;
    }

    public void l(ChildColumnList childColumnList) {
        t9.i.g(childColumnList, "columnData");
        this.f15609b.a();
        Observable compose = w6.i.i1(w6.i.f19214g.b(), childColumnList.getId(), false, 0, 0, 14, null).compose(this.f15608a.O1());
        final a aVar = a.f15610a;
        Observable map = compose.map(new Function() { // from class: k6.u
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List m10;
                m10 = w.m(s9.l.this, obj);
                return m10;
            }
        });
        final b bVar = new b();
        map.filter(new Predicate() { // from class: k6.v
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean n10;
                n10 = w.n(s9.l.this, obj);
                return n10;
            }
        }).subscribe(new c());
    }
}
