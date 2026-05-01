package l6;

import android.content.Context;
import com.mobile.brasiltv.db.Album;
import com.mobile.brasiltv.db.VodDao;
import com.mobile.brasiltv.mine.activity.LoginAty;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import mobile.com.requestframe.utils.response.FreeProduct;
import mobile.com.requestframe.utils.response.GetAuthInfoData;
import mobile.com.requestframe.utils.response.GetAuthInfoResult;
import mobile.com.requestframe.utils.response.GiftDaysData;
import mobile.com.requestframe.utils.response.GiftDaysResult;
import mobile.com.requestframe.utils.response.MsgNumData;
import mobile.com.requestframe.utils.response.MsgNumResult;
import mobile.com.requestframe.utils.response.PropertiesInfoData;
import mobile.com.requestframe.utils.response.PropertiesInfoResult;
import mobile.com.requestframe.utils.response.UpdateRestrictResult;
import w6.i;

/* loaded from: classes3.dex */
public final class m1 implements l5.a {

    /* renamed from: a, reason: collision with root package name */
    public final b6.f f16103a;

    /* renamed from: b, reason: collision with root package name */
    public final j6.i f16104b;

    /* renamed from: c, reason: collision with root package name */
    public VodDao f16105c;

    public static final class a extends ha.a {

        /* renamed from: l6.m1$a$a, reason: collision with other inner class name */
        public static final class C0280a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f16107a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0280a(String str) {
                super(1);
                this.f16107a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(com.mobile.brasiltv.utils.y.f8771a, this.f16107a, null, null, 6, null));
            }
        }

        public a() {
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(MsgNumResult msgNumResult) {
            t9.i.g(msgNumResult, "t");
            v5.g gVar = v5.g.f19112a;
            MsgNumData data = msgNumResult.getData();
            gVar.w(data != null ? data.getSysNum() : 0);
            MsgNumData data2 = msgNumResult.getData();
            gVar.q(data2 != null ? data2.getActNum() : 0);
            int m10 = gVar.m();
            if (m10 <= 0) {
                m1.this.o().x2();
            } else {
                m1.this.o().A2(m10);
            }
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            Context context = m1.this.l().getContext();
            if (context != null) {
                com.mobile.brasiltv.utils.x.f8754a.w(context, new C0280a(str));
            }
        }
    }

    public static final class b extends ha.a {

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f16109a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f16109a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(com.mobile.brasiltv.utils.y.f8771a, this.f16109a, null, null, 6, null));
            }
        }

        public b() {
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(GiftDaysResult giftDaysResult) {
            t9.i.g(giftDaysResult, "t");
            if (giftDaysResult.getData() != null) {
                GiftDaysData data = giftDaysResult.getData();
                t9.i.d(data);
                List<FreeProduct> freeProductList = data.getFreeProductList();
                m1 m1Var = m1.this;
                for (FreeProduct freeProduct : freeProductList) {
                    String productCode = freeProduct.getProductCode();
                    GiftDaysData data2 = giftDaysResult.getData();
                    t9.i.d(data2);
                    if (t9.i.b(productCode, data2.getProductCode())) {
                        k7.f.e("绑定邮箱赠送时长请求成功，" + freeProduct.getPreAuthDays(), new Object[0]);
                        w6.i.f19214g.m0(freeProduct.getPreAuthDays());
                        m1Var.o().x1();
                        if (na.f.c(m1Var.l().getContext(), "keyShowGiftDaysDialog", true)) {
                            m1Var.o().s0();
                        }
                    }
                }
            }
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            Context context = m1.this.l().getContext();
            if (context != null) {
                com.mobile.brasiltv.utils.x.f8754a.w(context, new a(str));
            }
        }
    }

    public static final class c extends ha.a {

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f16111a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f16111a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(com.mobile.brasiltv.utils.y.f8771a, this.f16111a, null, null, 6, null));
            }
        }

        public c() {
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(PropertiesInfoResult propertiesInfoResult) {
            t9.i.g(propertiesInfoResult, "t");
            PropertiesInfoData data = propertiesInfoResult.getData();
            if (data != null) {
                i.c cVar = w6.i.f19214g;
                String customerEmail = data.getCustomerEmail();
                if (customerEmail == null) {
                    customerEmail = "";
                }
                cVar.Z(customerEmail);
                String shareLinkUrl = data.getShareLinkUrl();
                cVar.s0(shareLinkUrl != null ? shareLinkUrl : "");
            }
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            Context context = m1.this.l().getContext();
            if (context != null) {
                com.mobile.brasiltv.utils.x.f8754a.w(context, new a(str));
            }
        }
    }

    public static final class d extends t9.j implements s9.l {
        public d() {
            super(1);
        }

        public final void b(List list) {
            t9.i.f(list, "it");
            if (!list.isEmpty()) {
                m1.this.o().F(list);
            } else {
                k7.f.c("无历史记录，不展示", new Object[0]);
                m1.this.o().l();
            }
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((List) obj);
            return h9.t.f14242a;
        }
    }

    public static final class e extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final e f16113a = new e();

        public e() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return h9.t.f14242a;
        }

        public final void invoke(Throwable th) {
            k7.f.d("查询历史数据失败!", new Object[0]);
            th.printStackTrace();
        }
    }

    public static final class f implements Comparator {
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return j9.a.a(((Album) obj2).getSaveTime(), ((Album) obj).getSaveTime());
        }
    }

    public static final class g extends ha.a {

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ GetAuthInfoResult f16115a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(GetAuthInfoResult getAuthInfoResult) {
                super(1);
                this.f16115a = getAuthInfoResult;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.y yVar = com.mobile.brasiltv.utils.y.f8771a;
                String returnCode = this.f16115a.getReturnCode();
                t9.i.d(returnCode);
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(yVar, returnCode, null, null, 6, null));
            }
        }

        public static final class b extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f16116a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(String str) {
                super(1);
                this.f16116a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(com.mobile.brasiltv.utils.y.f8771a, this.f16116a, null, null, 6, null));
            }
        }

        public g() {
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(GetAuthInfoResult getAuthInfoResult) {
            t9.i.g(getAuthInfoResult, "t");
            com.mobile.brasiltv.utils.b0.U(this, "获取授权信息成功，result: " + getAuthInfoResult);
            if (t9.i.b(getAuthInfoResult.getReturnCode(), "aaa100028")) {
                k7.f.f("授权信息接口，needToReLogin", new Object[0]);
                com.mobile.brasiltv.utils.b0.a0(m1.this.l(), LoginAty.class);
                return;
            }
            if (com.mobile.brasiltv.utils.b0.T(getAuthInfoResult.getReturnCode(), "aaa100027")) {
                Context context = m1.this.l().getContext();
                if (context != null) {
                    com.mobile.brasiltv.utils.x.f8754a.w(context, new a(getAuthInfoResult));
                    return;
                }
                return;
            }
            if (getAuthInfoResult.getData() != null) {
                i.c cVar = w6.i.f19214g;
                GetAuthInfoData data = getAuthInfoResult.getData();
                t9.i.d(data);
                cVar.t0(data.getShowFlag());
                GetAuthInfoData data2 = getAuthInfoResult.getData();
                t9.i.d(data2);
                cVar.T(data2.getBindMail());
                GetAuthInfoData data3 = getAuthInfoResult.getData();
                t9.i.d(data3);
                cVar.g0(data3.getHasPay());
                GetAuthInfoData data4 = getAuthInfoResult.getData();
                t9.i.d(data4);
                cVar.h0(data4.getHasPwd());
                GetAuthInfoData data5 = getAuthInfoResult.getData();
                t9.i.d(data5);
                cVar.y0(data5.getUserIdentity());
                GetAuthInfoData data6 = getAuthInfoResult.getData();
                t9.i.d(data6);
                String childLockPwd = data6.getChildLockPwd();
                if (childLockPwd == null) {
                    childLockPwd = "";
                }
                cVar.W(childLockPwd);
                GetAuthInfoData data7 = getAuthInfoResult.getData();
                t9.i.d(data7);
                Integer remainingDays = data7.getRemainingDays();
                cVar.p0(remainingDays != null ? remainingDays.intValue() : 0);
                GetAuthInfoData data8 = getAuthInfoResult.getData();
                t9.i.d(data8);
                Integer expRemainingDays = data8.getExpRemainingDays();
                cVar.c0(expRemainingDays != null ? expRemainingDays.intValue() : 0);
                GetAuthInfoData data9 = getAuthInfoResult.getData();
                t9.i.d(data9);
                String qrcodeMessage = data9.getQrcodeMessage();
                if (qrcodeMessage == null) {
                    qrcodeMessage = "";
                }
                cVar.o0(qrcodeMessage);
                GetAuthInfoData data10 = getAuthInfoResult.getData();
                t9.i.d(data10);
                String playlistUrl = data10.getPlaylistUrl();
                cVar.k0(playlistUrl != null ? playlistUrl : "");
            }
            d6.b bVar = d6.b.f12660a;
            GetAuthInfoData data11 = getAuthInfoResult.getData();
            bVar.B(data11 != null ? data11.getAuthInfoList() : null);
            m1.this.o().l1();
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            Context context = m1.this.l().getContext();
            if (context != null) {
                com.mobile.brasiltv.utils.x.f8754a.w(context, new b(str));
            }
        }
    }

    public static final class h extends ha.a {

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f16118a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f16118a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(com.mobile.brasiltv.utils.y.f8771a, this.f16118a, null, null, 6, null));
            }
        }

        public h() {
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(UpdateRestrictResult updateRestrictResult) {
            t9.i.g(updateRestrictResult, "t");
            k7.f.e("更新限制级状态成功，关闭", new Object[0]);
            m1.this.o().showLoading(false);
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            m1.this.o().showLoading(true);
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            m1.this.o().showLoading(false);
            Context context = m1.this.l().getContext();
            if (context != null) {
                com.mobile.brasiltv.utils.x.f8754a.w(context, new a(str));
            }
        }
    }

    public m1(b6.f fVar, j6.i iVar) {
        t9.i.g(fVar, "frag");
        t9.i.g(iVar, "view");
        this.f16103a = fVar;
        this.f16104b = iVar;
        Context requireContext = fVar.requireContext();
        t9.i.f(requireContext, "frag.requireContext()");
        this.f16105c = new VodDao(requireContext);
    }

    public static final void r(m1 m1Var, ObservableEmitter observableEmitter) {
        t9.i.g(m1Var, "this$0");
        t9.i.g(observableEmitter, "it");
        List<Album> queryAllRecord = m1Var.f16105c.queryAllRecord();
        if (!queryAllRecord.isEmpty()) {
            List C = i9.r.C(queryAllRecord, new f());
            if (!C.isEmpty()) {
                queryAllRecord = new ArrayList<>(C);
            }
        }
        observableEmitter.onNext(queryAllRecord);
    }

    public static final void s(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void t(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    @Override // l5.a
    public void e() {
        m();
        n();
    }

    @Override // l5.a
    public void g() {
        this.f16104b.showLoading(false);
    }

    public void k() {
        String l10 = d6.b.f12660a.l();
        if (l10 == null || l10.length() == 0) {
            return;
        }
        w6.i.f19214g.b().f2().compose(this.f16103a.O2()).subscribe(new a());
    }

    public final b6.f l() {
        return this.f16103a;
    }

    public final void m() {
        i.c cVar = w6.i.f19214g;
        if (t9.i.b(cVar.I(), "1") && t9.i.b(cVar.e(), "1")) {
            cVar.b().P0().compose(this.f16103a.O2()).subscribe(new b());
        }
    }

    public final void n() {
        w6.i.f19214g.b().G1().compose(this.f16103a.O2()).subscribe(new c());
    }

    public final j6.i o() {
        return this.f16104b;
    }

    public void p() {
        String l10 = d6.b.f12660a.l();
        if (l10 == null || l10.length() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("coupon num is ");
        v5.g gVar = v5.g.f19112a;
        sb.append(gVar.l());
        com.mobile.brasiltv.utils.b0.U(this, sb.toString());
        this.f16104b.t1(gVar.l() != 0);
    }

    public void q() {
        Observable observeOn = Observable.create(new ObservableOnSubscribe() { // from class: l6.j1
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                m1.r(m1.this, observableEmitter);
            }
        }).compose(this.f16103a.O2()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final d dVar = new d();
        Consumer consumer = new Consumer() { // from class: l6.k1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                m1.s(s9.l.this, obj);
            }
        };
        final e eVar = e.f16113a;
        observeOn.subscribe(consumer, new Consumer() { // from class: l6.l1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                m1.t(s9.l.this, obj);
            }
        });
    }

    public void u() {
        String l10 = d6.b.f12660a.l();
        if (l10 == null || l10.length() == 0) {
            return;
        }
        w6.i.f19214g.b().d1().compose(this.f16103a.O2()).subscribe(new g());
    }

    public void v() {
        w6.i.f19214g.b().q2(null, "0").subscribe(new h());
    }
}
