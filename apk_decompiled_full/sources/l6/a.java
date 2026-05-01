package l6;

import android.content.Context;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import mobile.com.requestframe.utils.response.BaseResult;
import mobile.com.requestframe.utils.response.Msg;
import mobile.com.requestframe.utils.response.MsgBoxResult;
import mobile.com.requestframe.utils.response.MsgData;

/* loaded from: classes3.dex */
public final class a implements l5.a {

    /* renamed from: a, reason: collision with root package name */
    public final b6.f f15933a;

    /* renamed from: b, reason: collision with root package name */
    public final i6.h f15934b;

    /* renamed from: c, reason: collision with root package name */
    public final int f15935c;

    /* renamed from: d, reason: collision with root package name */
    public int f15936d;

    /* renamed from: e, reason: collision with root package name */
    public Disposable f15937e;

    /* renamed from: l6.a$a, reason: collision with other inner class name */
    public static final class C0271a extends ha.a {

        /* renamed from: l6.a$a$a, reason: collision with other inner class name */
        public static final class C0272a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15939a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0272a(String str) {
                super(1);
                this.f15939a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(com.mobile.brasiltv.utils.y.f8771a, this.f15939a, null, null, 6, null));
            }
        }

        public C0271a() {
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(MsgBoxResult msgBoxResult) {
            t9.i.g(msgBoxResult, "t");
            MsgData data = msgBoxResult.getData();
            ArrayList<Msg> msgList = data != null ? data.getMsgList() : null;
            if (msgList == null || msgList.isEmpty()) {
                a.this.n().D();
                return;
            }
            a.this.f15936d = 2;
            i6.h n10 = a.this.n();
            MsgData data2 = msgBoxResult.getData();
            ArrayList<Msg> msgList2 = data2 != null ? data2.getMsgList() : null;
            t9.i.d(msgList2);
            n10.A(msgList2, true);
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            a.this.f15937e = disposable;
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            a.this.n().D();
            Context context = a.this.m().getContext();
            if (context != null) {
                com.mobile.brasiltv.utils.x.f8754a.w(context, new C0272a(str));
            }
        }
    }

    public static final class b extends ha.a {

        /* renamed from: l6.a$b$a, reason: collision with other inner class name */
        public static final class C0273a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15941a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0273a(String str) {
                super(1);
                this.f15941a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(com.mobile.brasiltv.utils.y.f8771a, this.f15941a, null, null, 6, null));
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
                a.this.n().w();
                return;
            }
            a.this.f15936d++;
            i6.h n10 = a.this.n();
            MsgData data2 = msgBoxResult.getData();
            ArrayList<Msg> msgList2 = data2 != null ? data2.getMsgList() : null;
            t9.i.d(msgList2);
            n10.A(msgList2, false);
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            a.this.f15937e = disposable;
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            a.this.n().E();
            Context context = a.this.m().getContext();
            if (context != null) {
                com.mobile.brasiltv.utils.x.f8754a.w(context, new C0273a(str));
            }
        }
    }

    public static final class c extends ha.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Msg f15943b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f15944c;

        /* renamed from: l6.a$c$a, reason: collision with other inner class name */
        public static final class C0274a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15945a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0274a(String str) {
                super(1);
                this.f15945a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(com.mobile.brasiltv.utils.y.f8771a, this.f15945a, null, null, 6, null));
            }
        }

        public c(Msg msg, int i10) {
            this.f15943b = msg;
            this.f15944c = i10;
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            Context context = a.this.m().getContext();
            if (context != null) {
                com.mobile.brasiltv.utils.x.f8754a.w(context, new C0274a(str));
            }
        }

        @Override // ha.a, io.reactivex.Observer
        public void onNext(BaseResult baseResult) {
            t9.i.g(baseResult, "t");
            super.onNext((Object) baseResult);
            Msg msg = this.f15943b;
            if (msg != null) {
                msg.setStatus(2);
            }
            v5.g.f19112a.q(r2.k() - 1);
            a.this.n().n0(this.f15944c);
        }
    }

    public a(b6.f fVar, i6.h hVar) {
        t9.i.g(fVar, "frag");
        t9.i.g(hVar, "view");
        this.f15933a = fVar;
        this.f15934b = hVar;
        this.f15935c = 10;
    }

    @Override // l5.a
    public void e() {
    }

    @Override // l5.a
    public void g() {
        k();
    }

    public void k() {
        Disposable disposable = this.f15937e;
        boolean z10 = false;
        if (disposable != null && disposable.isDisposed()) {
            z10 = true;
        }
        if (z10) {
            return;
        }
        Disposable disposable2 = this.f15937e;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        this.f15937e = null;
    }

    public void l() {
        k();
        w6.i.f19214g.b().g1(this.f15935c, 1, w5.m.f19178a.D()).compose(this.f15933a.O2()).subscribe(new C0271a());
    }

    public final b6.f m() {
        return this.f15933a;
    }

    public final i6.h n() {
        return this.f15934b;
    }

    public void o() {
        k();
        w6.i.f19214g.b().g1(this.f15935c, this.f15936d, w5.m.f19178a.D()).compose(this.f15933a.O2()).subscribe(new b());
    }

    public void p(int i10, Msg msg) {
        String str;
        w6.i b10 = w6.i.f19214g.b();
        if (msg == null || (str = msg.getMessageId()) == null) {
            str = "";
        }
        b10.g2(str, w5.m.f19178a.D()).subscribe(new c(msg, i10));
    }
}
