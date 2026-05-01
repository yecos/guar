package l6;

import android.content.Context;
import com.mobile.brasiltv.bean.event.NetworkEvent;
import com.mobile.brasiltv.bean.event.ShortVideoPlayEvent;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import mobile.com.requestframe.utils.response.GetShortVideoResult;
import mobile.com.requestframe.utils.response.ShortAssetDataList;

/* loaded from: classes.dex */
public final class c2 implements l5.a {

    /* renamed from: a, reason: collision with root package name */
    public final b6.f f15955a;

    /* renamed from: b, reason: collision with root package name */
    public final j6.k f15956b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f15957c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f15958d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f15959e;

    /* renamed from: f, reason: collision with root package name */
    public Disposable f15960f;

    /* loaded from: classes3.dex */
    public static final class a extends ha.a {

        /* renamed from: l6.c2$a$a, reason: collision with other inner class name */
        public static final class C0275a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15962a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0275a(String str) {
                super(1);
                this.f15962a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(com.mobile.brasiltv.utils.y.f8771a, this.f15962a, null, null, 6, null));
            }
        }

        public a() {
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(GetShortVideoResult getShortVideoResult) {
            t9.i.g(getShortVideoResult, "t");
            c2.this.f15959e = false;
            ShortAssetDataList data = getShortVideoResult.getData();
            if (com.mobile.brasiltv.utils.b0.I(data != null ? data.getAssetDataList() : null)) {
                ShortAssetDataList data2 = getShortVideoResult.getData();
                t9.i.d(data2);
                c2.this.f15957c.addAll(data2.getAssetDataList());
                c2.this.n().Y1(c2.this.f15957c);
            }
        }

        @Override // ha.a, io.reactivex.Observer
        public void onError(Throwable th) {
            t9.i.g(th, "e");
            super.onError(th);
            c2.this.f15959e = false;
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            c2.this.f15960f = disposable;
            c2.this.f15959e = true;
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            c2.this.n().c(str);
            Context context = c2.this.l().getContext();
            if (context != null) {
                com.mobile.brasiltv.utils.x.f8754a.w(context, new C0275a(str));
            }
        }
    }

    public c2(b6.f fVar, j6.k kVar) {
        t9.i.g(fVar, "frag");
        t9.i.g(kVar, "view");
        this.f15955a = fVar;
        this.f15956b = kVar;
        this.f15957c = new ArrayList();
    }

    @Override // l5.a
    public void e() {
        Context context = this.f15955a.getContext();
        t9.i.d(context);
        k(context);
        if (xa.c.c().h(this)) {
            return;
        }
        xa.c.c().o(this);
    }

    @Override // l5.a
    public void g() {
        if (xa.c.c().h(this)) {
            xa.c.c().r(this);
        }
    }

    public void k(Context context) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        if (!ga.a.a(context) || ga.a.c(context)) {
            return;
        }
        this.f15956b.k1();
    }

    public final b6.f l() {
        return this.f15955a;
    }

    public void m() {
        if (this.f15959e) {
            Disposable disposable = this.f15960f;
            boolean z10 = false;
            if (disposable != null && !disposable.isDisposed()) {
                z10 = true;
            }
            if (z10) {
                return;
            }
        }
        w6.i.f19214g.b().Q1().compose(this.f15955a.O2()).subscribe(new a());
    }

    public final j6.k n() {
        return this.f15956b;
    }

    public boolean o() {
        return this.f15958d;
    }

    @xa.j
    public final void shortVideoPlay(ShortVideoPlayEvent shortVideoPlayEvent) {
        t9.i.g(shortVideoPlayEvent, "event");
        this.f15958d = false;
        this.f15956b.l2(0);
    }

    @xa.j
    public final void showNoNetNotify(NetworkEvent networkEvent) {
        t9.i.g(networkEvent, "event");
        if (NetworkEvent.NetState.MOBILE == networkEvent.getMState()) {
            Context context = this.f15955a.getContext();
            t9.i.d(context);
            k(context);
        }
    }
}
