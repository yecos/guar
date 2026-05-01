package w5;

import android.content.Context;
import com.google.android.gms.actions.SearchIntents;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.sdk.source.common.global.Constant;
import com.mobile.brasiltv.app.App;
import com.mobile.brasiltv.business.message.db.MessageDao;
import com.mobile.brasiltv.business.message.inapp.bean.InAppMsg;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.view.dialog.DialogManager;
import com.titans.entity.CdnType;
import h9.t;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import ma.q;
import x5.p;

/* loaded from: classes3.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public static final m f19178a = new m();

    /* renamed from: b, reason: collision with root package name */
    public static final String f19179b = "1";

    /* renamed from: c, reason: collision with root package name */
    public static final String f19180c = "2";

    /* renamed from: d, reason: collision with root package name */
    public static final String f19181d = "0";

    /* renamed from: e, reason: collision with root package name */
    public static final String f19182e = "1";

    /* renamed from: f, reason: collision with root package name */
    public static final String f19183f = "2";

    /* renamed from: g, reason: collision with root package name */
    public static final String f19184g = "3";

    /* renamed from: h, reason: collision with root package name */
    public static final String f19185h = "4";

    /* renamed from: i, reason: collision with root package name */
    public static final String f19186i = CdnType.DIGITAL_TYPE_PCDN;

    /* renamed from: j, reason: collision with root package name */
    public static final h9.k f19187j = new h9.k("1", "1");

    /* renamed from: k, reason: collision with root package name */
    public static final h9.k f19188k = new h9.k("1", "2");

    /* renamed from: l, reason: collision with root package name */
    public static final h9.k f19189l = new h9.k("1", "3");

    /* renamed from: m, reason: collision with root package name */
    public static final h9.k f19190m = new h9.k("1", "4");

    /* renamed from: n, reason: collision with root package name */
    public static final h9.k f19191n = new h9.k("1", CdnType.DIGITAL_TYPE_PCDN);

    /* renamed from: o, reason: collision with root package name */
    public static final h9.k f19192o = new h9.k("2", "0");

    /* renamed from: p, reason: collision with root package name */
    public static boolean f19193p;

    /* renamed from: q, reason: collision with root package name */
    public static String f19194q;

    /* renamed from: r, reason: collision with root package name */
    public static List f19195r;

    /* renamed from: s, reason: collision with root package name */
    public static MessageDao f19196s;

    /* renamed from: t, reason: collision with root package name */
    public static n f19197t;

    public static final class a extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final a f19198a = new a();

        public a() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Boolean) obj);
            return t.f14242a;
        }

        public final void invoke(Boolean bool) {
            b0.U(m.f19178a, "delete in-app get cashback message success.");
        }
    }

    public static final class b extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final b f19199a = new b();

        public b() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f14242a;
        }

        public final void invoke(Throwable th) {
            b0.U(m.f19178a, "delete in-app get cashback message failure.");
        }
    }

    public static final class c extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final c f19200a = new c();

        public c() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Boolean) obj);
            return t.f14242a;
        }

        public final void invoke(Boolean bool) {
            b0.U(m.f19178a, "delete in-app message success.");
        }
    }

    public static final class d extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final d f19201a = new d();

        public d() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f14242a;
        }

        public final void invoke(Throwable th) {
            b0.U(m.f19178a, "delete in-app message failure.");
        }
    }

    public static final class e extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ s9.l f19202a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(s9.l lVar) {
            super(1);
            this.f19202a = lVar;
        }

        public final void b(List list) {
            b0.U(m.f19178a, "query in-app message list success and result size is " + list.size() + '.');
            s9.l lVar = this.f19202a;
            t9.i.f(list, "it");
            lVar.invoke(list);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((List) obj);
            return t.f14242a;
        }
    }

    public static final class f extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final f f19203a = new f();

        public f() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f14242a;
        }

        public final void invoke(Throwable th) {
            b0.U(m.f19178a, "query in-app message list failure.");
        }
    }

    public static final class g extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final g f19204a = new g();

        public g() {
            super(1);
        }

        public final void b(InAppMsg inAppMsg) {
            n nVar;
            b0.U(m.f19178a, "save in-app message success.");
            if (inAppMsg == null || (nVar = m.f19197t) == null) {
                return;
            }
            nVar.a(inAppMsg);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((InAppMsg) obj);
            return t.f14242a;
        }
    }

    public static final class h extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final h f19205a = new h();

        public h() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f14242a;
        }

        public final void invoke(Throwable th) {
            b0.U(m.f19178a, "save in-app message failure.");
        }
    }

    public static final void N(List list, String str, ObservableEmitter observableEmitter) {
        List<InAppMsg> queryInAppMsgList;
        t9.i.g(list, "$types");
        t9.i.g(str, "$userId");
        t9.i.g(observableEmitter, "emitter");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            h9.k kVar = (h9.k) it.next();
            String str2 = (String) kVar.c();
            String str3 = f19180c;
            if (t9.i.b(str2, str3)) {
                List<InAppMsg> queryInAppMsgByMsgType = f19178a.C().queryInAppMsgByMsgType(str, str3);
                if (queryInAppMsgByMsgType != null && b0.I(queryInAppMsgByMsgType)) {
                    arrayList.addAll(queryInAppMsgByMsgType);
                }
            } else {
                String str4 = f19179b;
                if (t9.i.b(str2, str4) && (queryInAppMsgList = f19178a.C().queryInAppMsgList(str, str4, (String) kVar.d())) != null && b0.I(queryInAppMsgList)) {
                    arrayList.addAll(queryInAppMsgList);
                }
            }
            if (b0.I(arrayList)) {
                observableEmitter.onNext(arrayList);
                observableEmitter.onComplete();
                return;
            }
        }
        observableEmitter.onNext(arrayList);
        observableEmitter.onComplete();
    }

    public static final void O(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void P(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void T(InAppMsg inAppMsg, ObservableEmitter observableEmitter) {
        t9.i.g(inAppMsg, "$msg");
        t9.i.g(observableEmitter, "it");
        m mVar = f19178a;
        if (mVar.w(inAppMsg)) {
            observableEmitter.onComplete();
            return;
        }
        mVar.C().addInAppMsg(inAppMsg);
        observableEmitter.onNext(inAppMsg);
        observableEmitter.onComplete();
    }

    public static final void U(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void V(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void o(ObservableEmitter observableEmitter) {
        t9.i.g(observableEmitter, "it");
        f19178a.C().deleteInAppMsgByType(f19179b, f19185h);
        observableEmitter.onNext(Boolean.TRUE);
        observableEmitter.onComplete();
    }

    public static final void p(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void q(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void s(InAppMsg inAppMsg, ObservableEmitter observableEmitter) {
        t9.i.g(inAppMsg, "$msg");
        t9.i.g(observableEmitter, "it");
        f19178a.C().deleteInAppMsg(inAppMsg);
        observableEmitter.onNext(Boolean.TRUE);
        observableEmitter.onComplete();
    }

    public static final void t(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void u(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public final h9.k A() {
        return f19189l;
    }

    public final h9.k B() {
        return f19188k;
    }

    public final MessageDao C() {
        if (f19196s == null) {
            f19196s = new MessageDao(App.f8263e.a());
        }
        MessageDao messageDao = f19196s;
        t9.i.d(messageDao);
        return messageDao;
    }

    public final String D() {
        return f19180c;
    }

    public final String E() {
        return f19182e;
    }

    public final String F() {
        return f19185h;
    }

    public final String G() {
        return f19186i;
    }

    public final String H() {
        return f19184g;
    }

    public final String I() {
        return f19183f;
    }

    public final String J() {
        return f19179b;
    }

    public final boolean K(String str, String str2) {
        return (t9.i.b(str, f19179b) && (t9.i.b(str2, f19182e) || t9.i.b(str2, f19183f) || t9.i.b(str2, f19184g) || t9.i.b(str2, f19185h))) || t9.i.b(str, f19180c);
    }

    public final InAppMsg L(Map map) {
        InAppMsg inAppMsg = new InAppMsg();
        String str = (String) map.get("messageType");
        if (str == null) {
            str = "";
        }
        inAppMsg.setMessageType(str);
        String str2 = (String) map.get("type");
        if (str2 == null) {
            str2 = "";
        }
        inAppMsg.setType(str2);
        String str3 = (String) map.get("userId");
        if (str3 == null) {
            str3 = "";
        }
        inAppMsg.setUserId(str3);
        String str4 = (String) map.get("title");
        if (str4 == null) {
            str4 = "";
        }
        inAppMsg.setTitle(str4);
        String str5 = (String) map.get(ParamsMap.MirrorParams.MIRROR_DOC_MODE);
        if (str5 == null) {
            str5 = "";
        }
        inAppMsg.setText(str5);
        String str6 = (String) map.get("orderId");
        if (str6 == null) {
            str6 = "";
        }
        inAppMsg.setOrderId(str6);
        String str7 = (String) map.get("url");
        if (str7 == null) {
            str7 = "";
        }
        inAppMsg.setUrl(str7);
        String str8 = (String) map.get("avaliableCoin");
        if (str8 == null) {
            str8 = "";
        }
        inAppMsg.setAvaliableCoin(str8);
        String str9 = (String) map.get("minCoin");
        inAppMsg.setMinCoin(str9 != null ? str9 : "");
        return inAppMsg;
    }

    public final void M(s9.l lVar) {
        t9.i.g(lVar, SearchIntents.EXTRA_QUERY);
        String str = f19194q;
        if (str == null || str.length() == 0) {
            return;
        }
        List list = f19195r;
        if (list == null || list.isEmpty()) {
            return;
        }
        final String str2 = f19194q;
        t9.i.d(str2);
        final List list2 = f19195r;
        t9.i.d(list2);
        Observable compose = Observable.create(new ObservableOnSubscribe() { // from class: w5.i
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                m.N(list2, str2, observableEmitter);
            }
        }).compose(q.b());
        final e eVar = new e(lVar);
        Consumer consumer = new Consumer() { // from class: w5.j
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                m.O(s9.l.this, obj);
            }
        };
        final f fVar = f.f19203a;
        compose.subscribe(consumer, new Consumer() { // from class: w5.k
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                m.P(s9.l.this, obj);
            }
        });
    }

    public final void Q(Map map) {
        t9.i.g(map, "data");
        InAppMsg L = L(map);
        b0.U(this, "in-app msg that parsed is " + L);
        if (L == null || !K(L.getMessageType(), L.getType()) || b0.J(L.getUserId())) {
            b0.U(this, "find unsupported msg data.");
        } else {
            S(L);
        }
    }

    public final void R(n nVar) {
        t9.i.g(nVar, "callback");
        f19197t = nVar;
    }

    public final void S(final InAppMsg inAppMsg) {
        Observable compose = Observable.create(new ObservableOnSubscribe() { // from class: w5.f
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                m.T(InAppMsg.this, observableEmitter);
            }
        }).compose(q.b());
        final g gVar = g.f19204a;
        Consumer consumer = new Consumer() { // from class: w5.g
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                m.U(s9.l.this, obj);
            }
        };
        final h hVar = h.f19205a;
        compose.subscribe(consumer, new Consumer() { // from class: w5.h
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                m.V(s9.l.this, obj);
            }
        });
    }

    public final void W(Context context, InAppMsg inAppMsg) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(inAppMsg, Constant.KEY_MSG);
        if (!t9.i.b(inAppMsg.getMessageType(), f19179b)) {
            if (t9.i.b(inAppMsg.getMessageType(), f19180c)) {
                b0.S(new x5.c(context, inAppMsg), DialogManager.DIALOG_INAPP_MSG_ACTIVITY_REMIND);
                return;
            }
            return;
        }
        String type = inAppMsg.getType();
        if (t9.i.b(type, f19182e)) {
            b0.S(new x5.f(context, inAppMsg), DialogManager.DIALOG_INAPP_MSG_COUPON_BENEFITS);
            return;
        }
        if (t9.i.b(type, f19183f)) {
            b0.S(new x5.l(context, inAppMsg), DialogManager.DIALOG_INAPP_MSG_SERVICE_EFFECT);
            return;
        }
        if (t9.i.b(type, f19184g)) {
            b0.S(new x5.j(context, inAppMsg), DialogManager.DIALOG_INAPP_MSG_ORDER_PAY_FAILURE);
        } else if (t9.i.b(type, f19185h)) {
            b0.S(new p(context, inAppMsg), DialogManager.DIALOG_INAPP_MSG_GET_CASHBACK);
        } else if (t9.i.b(type, f19186i)) {
            b0.U(this, "Friend invitation pop-up is not supported at the moment.");
        }
    }

    public final void X() {
        f19197t = null;
    }

    public final void Y(boolean z10) {
        f19193p = z10;
    }

    public final void Z(String str, List list) {
        t9.i.g(str, "userId");
        t9.i.g(list, "types");
        f19194q = str;
        f19195r = list;
    }

    public final void n() {
        Observable compose = Observable.create(new ObservableOnSubscribe() { // from class: w5.a
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                m.o(observableEmitter);
            }
        }).compose(q.a());
        final a aVar = a.f19198a;
        Consumer consumer = new Consumer() { // from class: w5.d
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                m.p(s9.l.this, obj);
            }
        };
        final b bVar = b.f19199a;
        compose.subscribe(consumer, new Consumer() { // from class: w5.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                m.q(s9.l.this, obj);
            }
        });
    }

    public final void r(final InAppMsg inAppMsg) {
        t9.i.g(inAppMsg, Constant.KEY_MSG);
        Observable compose = Observable.create(new ObservableOnSubscribe() { // from class: w5.l
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                m.s(InAppMsg.this, observableEmitter);
            }
        }).compose(q.a());
        final c cVar = c.f19200a;
        Consumer consumer = new Consumer() { // from class: w5.b
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                m.t(s9.l.this, obj);
            }
        };
        final d dVar = d.f19201a;
        compose.subscribe(consumer, new Consumer() { // from class: w5.c
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                m.u(s9.l.this, obj);
            }
        });
    }

    public final boolean v(InAppMsg inAppMsg, h9.k kVar) {
        t9.i.g(inAppMsg, Constant.KEY_MSG);
        t9.i.g(kVar, "msgType");
        return t9.i.b(inAppMsg.getMessageType(), kVar.c()) && (t9.i.b(f19181d, kVar.d()) || t9.i.b(inAppMsg.getType(), kVar.d()));
    }

    public final boolean w(InAppMsg inAppMsg) {
        if (!t9.i.b(inAppMsg.getMessageType(), f19179b) || !t9.i.b(inAppMsg.getType(), f19185h)) {
            return false;
        }
        if (b0.X(inAppMsg.getMinCoin()) <= 0.0f) {
            return true;
        }
        if (b0.X(inAppMsg.getAvaliableCoin()) >= b0.X(inAppMsg.getMinCoin())) {
            return f19193p || ((Boolean) u5.a.f19061a.a(App.f8263e.a(), "dont_remind", Boolean.FALSE)).booleanValue();
        }
        u5.a.f19061a.b(App.f8263e.a(), "dont_remind", Boolean.FALSE);
        n();
        return true;
    }

    public final h9.k x() {
        return f19192o;
    }

    public final h9.k y() {
        return f19187j;
    }

    public final h9.k z() {
        return f19190m;
    }
}
