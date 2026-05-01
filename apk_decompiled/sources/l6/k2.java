package l6;

import android.content.Context;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import mobile.com.requestframe.utils.response.BaseResult;
import mobile.com.requestframe.utils.response.Msg;
import mobile.com.requestframe.utils.response.MsgBoxResult;
import mobile.com.requestframe.utils.response.MsgData;

/* loaded from: classes3.dex */
public final class k2 implements l5.a {

    /* renamed from: a, reason: collision with root package name */
    public final b6.f f16078a;

    /* renamed from: b, reason: collision with root package name */
    public final i6.z0 f16079b;

    /* renamed from: c, reason: collision with root package name */
    public final int f16080c;

    /* renamed from: d, reason: collision with root package name */
    public int f16081d;

    /* renamed from: e, reason: collision with root package name */
    public Disposable f16082e;

    public static final class a extends ha.a {

        /* renamed from: l6.k2$a$a, reason: collision with other inner class name */
        public static final class C0279a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f16084a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0279a(String str) {
                super(1);
                this.f16084a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(com.mobile.brasiltv.utils.y.f8771a, this.f16084a, null, null, 6, null));
            }
        }

        public a() {
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(MsgBoxResult msgBoxResult) {
            t9.i.g(msgBoxResult, "t");
            MsgData data = msgBoxResult.getData();
            ArrayList<Msg> msgList = data != null ? data.getMsgList() : null;
            if (msgList == null || msgList.isEmpty()) {
                k2.this.n().D();
                return;
            }
            k2.this.f16081d = 2;
            i6.z0 n10 = k2.this.n();
            MsgData data2 = msgBoxResult.getData();
            ArrayList<Msg> msgList2 = data2 != null ? data2.getMsgList() : null;
            t9.i.d(msgList2);
            n10.A(msgList2, true);
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            k2.this.f16082e = disposable;
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            k2.this.n().D();
            Context context = k2.this.m().getContext();
            if (context != null) {
                com.mobile.brasiltv.utils.x.f8754a.w(context, new C0279a(str));
            }
        }
    }

    public static final class b extends ha.a {

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f16086a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f16086a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(com.mobile.brasiltv.utils.y.f8771a, this.f16086a, null, null, 6, null));
            }
        }

        public b() {
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(MsgBoxResult msgBoxResult) {
            t9.i.g(msgBoxResult, "t");
            MsgData data = msgBoxResult.getData();
            ArrayList<Msg> msgList = data != null ? data.getMsgList() : null;
            if (msgList == null || msgList.isEmpty()) {
                k2.this.n().w();
                return;
            }
            k2.this.f16081d++;
            i6.z0 n10 = k2.this.n();
            MsgData data2 = msgBoxResult.getData();
            ArrayList<Msg> msgList2 = data2 != null ? data2.getMsgList() : null;
            t9.i.d(msgList2);
            n10.A(msgList2, false);
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            k2.this.f16082e = disposable;
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            k2.this.n().E();
            Context context = k2.this.m().getContext();
            if (context != null) {
                com.mobile.brasiltv.utils.x.f8754a.w(context, new a(str));
            }
        }
    }

    public static final class c extends ha.a {

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f16088a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f16088a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(com.mobile.brasiltv.utils.y.f8771a, this.f16088a, null, null, 6, null));
            }
        }

        public c() {
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            Context context = k2.this.m().getContext();
            if (context != null) {
                com.mobile.brasiltv.utils.x.f8754a.w(context, new a(str));
            }
        }

        @Override // ha.a, io.reactivex.Observer
        public void onNext(BaseResult baseResult) {
            t9.i.g(baseResult, "t");
            super.onNext((Object) baseResult);
            v5.g.f19112a.w(0);
        }
    }

    public k2(b6.f fVar, i6.z0 z0Var) {
        t9.i.g(fVar, "frag");
        t9.i.g(z0Var, "view");
        this.f16078a = fVar;
        this.f16079b = z0Var;
        this.f16080c = 10;
        this.f16081d = 1;
    }

    @Override // l5.a
    public void e() {
    }

    @Override // l5.a
    public void g() {
        k();
    }

    public void k() {
        Disposable disposable = this.f16082e;
        boolean z10 = false;
        if (disposable != null && disposable.isDisposed()) {
            z10 = true;
        }
        if (z10) {
            return;
        }
        Disposable disposable2 = this.f16082e;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        this.f16082e = null;
    }

    public void l() {
        k();
        w6.i.f19214g.b().g1(this.f16080c, 1, w5.m.f19178a.J()).compose(this.f16078a.O2()).subscribe(new a());
    }

    public final b6.f m() {
        return this.f16078a;
    }

    public final i6.z0 n() {
        return this.f16079b;
    }

    public void o() {
        k();
        w6.i.f19214g.b().g1(this.f16080c, this.f16081d, w5.m.f19178a.J()).compose(this.f16078a.O2()).subscribe(new b());
    }

    public void p() {
        w6.i.f19214g.b().g2("", w5.m.f19178a.J()).compose(this.f16078a.O2()).subscribe(new c());
    }
}
