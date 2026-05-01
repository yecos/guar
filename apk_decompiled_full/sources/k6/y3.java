package k6;

import com.mobile.bean.UpdateBean;
import com.mobile.brasiltv.bean.event.HasNewUpdateEvent;
import com.mobile.brasiltv.view.MineUpgradeDialog;
import com.mobile.brasiltv.view.dialog.SimpleDialog;
import com.msandroid.mobile.R;
import w6.i;

/* loaded from: classes.dex */
public final class y3 implements l5.a {

    /* renamed from: a, reason: collision with root package name */
    public final f5.c f15668a;

    /* renamed from: b, reason: collision with root package name */
    public final i6.v0 f15669b;

    /* renamed from: c, reason: collision with root package name */
    public final h9.g f15670c;

    /* loaded from: classes3.dex */
    public static final class a implements h7.a {
        public a() {
        }

        @Override // h7.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onOver(UpdateBean updateBean) {
            t9.i.g(updateBean, "result");
            y3.this.l().showLoading(false);
            new MineUpgradeDialog(y3.this.j(), updateBean).show();
            y3.this.l().R0(true);
        }

        @Override // h7.a
        public void onCompleted() {
        }

        @Override // h7.a
        public void onError(Throwable th) {
            y3.this.l().showLoading(false);
            if (th instanceof NullPointerException) {
                String message = ((NullPointerException) th).getMessage();
                t9.i.d(message);
                if (ba.t.o(message, "Null is not a valid element", false, 2, null)) {
                    SimpleDialog simpleDialog = new SimpleDialog(y3.this.j());
                    simpleDialog.setMessage(R.string.no_update);
                    simpleDialog.show();
                    y3.this.l().R0(false);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends t9.j implements s9.a {

        /* renamed from: a, reason: collision with root package name */
        public static final b f15672a = new b();

        public b() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final c5.a invoke() {
            return new c5.a(new ja.c(".update"), new la.a(".update"));
        }
    }

    public y3(f5.c cVar, i6.v0 v0Var) {
        t9.i.g(cVar, com.umeng.analytics.pro.f.X);
        t9.i.g(v0Var, "view");
        this.f15668a = cVar;
        this.f15669b = v0Var;
        this.f15670c = h9.h.b(b.f15672a);
    }

    @Override // l5.a
    public void e() {
        this.f15669b.J('V' + com.mobile.brasiltv.utils.e.b(this.f15668a));
        xa.c.c().o(this);
    }

    @Override // l5.a
    public void g() {
        k().f();
        xa.c.c().r(this);
    }

    public void h() {
        String string = q5.i.f18197a.j(this.f15668a) ? this.f15668a.getString(R.string.msg_notify_on) : this.f15668a.getString(R.string.msg_notify_off);
        t9.i.f(string, "if (NotificationHelper.i…msg_notify_off)\n        }");
        this.f15669b.m0(string);
    }

    public void i() {
        this.f15669b.showLoading(true);
        k().f();
        c5.a k10 = k();
        f5.c cVar = this.f15668a;
        i.c cVar2 = w6.i.f19214g;
        k10.g(cVar, cVar2.E(), cVar2.l(), new a());
    }

    public final f5.c j() {
        return this.f15668a;
    }

    public final c5.a k() {
        return (c5.a) this.f15670c.getValue();
    }

    public final i6.v0 l() {
        return this.f15669b;
    }

    @xa.j(sticky = true)
    public final void showUpdateNew(HasNewUpdateEvent hasNewUpdateEvent) {
        t9.i.g(hasNewUpdateEvent, "event");
        this.f15669b.R0(hasNewUpdateEvent.getHas());
    }
}
