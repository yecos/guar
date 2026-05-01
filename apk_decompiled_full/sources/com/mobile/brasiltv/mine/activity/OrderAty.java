package com.mobile.brasiltv.mine.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.mine.activity.OrderAty;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.utils.y;
import com.mobile.brasiltv.view.LoadingDialog;
import com.mobile.brasiltv.view.dialog.PaymentResultDialog;
import com.mobile.brasiltv.view.dialog.PriorityVipDialog;
import com.msandroid.mobile.R;
import com.titans.entity.CdnType;
import com.zhy.autolayout.AutoFrameLayout;
import com.zhy.autolayout.AutoLinearLayout;
import h9.t;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import mobile.com.requestframe.utils.response.CheckGetVipResult;
import mobile.com.requestframe.utils.response.GetExchangeOrderData;
import mobile.com.requestframe.utils.response.GetExchangeOrderInfoResult;
import mobile.com.requestframe.utils.response.GetOrderInfoData;
import mobile.com.requestframe.utils.response.GetOrderInfoResult;
import mobile.com.requestframe.utils.response.GetPriorityVipResult;
import mobile.com.requestframe.utils.response.ResultFlag;
import s9.l;

/* loaded from: classes3.dex */
public final class OrderAty extends f5.c {

    /* renamed from: u, reason: collision with root package name */
    public static final a f8398u = new a(null);

    /* renamed from: m, reason: collision with root package name */
    public int f8401m;

    /* renamed from: t, reason: collision with root package name */
    public Map f8408t = new LinkedHashMap();

    /* renamed from: k, reason: collision with root package name */
    public ArrayList f8399k = new ArrayList();

    /* renamed from: l, reason: collision with root package name */
    public ArrayList f8400l = new ArrayList();

    /* renamed from: n, reason: collision with root package name */
    public final Handler f8402n = new Handler();

    /* renamed from: o, reason: collision with root package name */
    public long f8403o = 60;

    /* renamed from: p, reason: collision with root package name */
    public e f8404p = new e();

    /* renamed from: q, reason: collision with root package name */
    public f f8405q = new f();

    /* renamed from: r, reason: collision with root package name */
    public final h9.g f8406r = h9.h.b(g.f8419a);

    /* renamed from: s, reason: collision with root package name */
    public final h9.g f8407s = h9.h.b(h.f8420a);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(t9.g gVar) {
            this();
        }
    }

    public static final class b extends ha.a {

        public static final class a extends t9.j implements l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ OrderAty f8410a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(OrderAty orderAty) {
                super(1);
                this.f8410a = orderAty;
            }

            public final void b(PriorityVipDialog priorityVipDialog) {
                t9.i.g(priorityVipDialog, "it");
                this.f8410a.o3(priorityVipDialog);
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                b((PriorityVipDialog) obj);
                return t.f14242a;
            }
        }

        public b() {
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(CheckGetVipResult checkGetVipResult) {
            t9.i.g(checkGetVipResult, "t");
            StringBuilder sb = new StringBuilder();
            sb.append("checkGetVip result: ");
            ResultFlag data = checkGetVipResult.getData();
            sb.append(data != null ? data.getResultFlag() : null);
            b0.U(this, sb.toString());
            ResultFlag data2 = checkGetVipResult.getData();
            if (t9.i.b(data2 != null ? data2.getResultFlag() : null, "yes")) {
                OrderAty orderAty = OrderAty.this;
                PriorityVipDialog.Type type = PriorityVipDialog.Type.QUALIFICATIONS;
                ResultFlag data3 = checkGetVipResult.getData();
                new PriorityVipDialog(orderAty, type, data3 != null ? data3.getAuthDays() : 0, new a(OrderAty.this)).show();
            }
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
        }
    }

    public static final class c extends ha.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f8412b;

        public static final class a extends t9.j implements l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f8413a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f8413a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f14242a;
            }

            public final void invoke(String str) {
                f1.f8649a.x(y.p(y.f8771a, this.f8413a, null, null, 6, null));
            }
        }

        public c(String str) {
            this.f8412b = str;
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(GetOrderInfoResult getOrderInfoResult) {
            String string;
            t9.i.g(getOrderInfoResult, "t");
            b0.U(this, "query order record by order id success");
            OrderAty.this.O2(false);
            if (b0.I(getOrderInfoResult.getData())) {
                List<GetOrderInfoData> data = getOrderInfoResult.getData();
                t9.i.d(data);
                GetOrderInfoData getOrderInfoData = data.get(0);
                String d10 = y6.b.d(getOrderInfoData.getInvalidDate(), "yyyy-MM-dd HH:mm:ss");
                if (t9.i.b(getOrderInfoData.getState(), "1") || t9.i.b(getOrderInfoData.getState(), "2")) {
                    string = OrderAty.this.getResources().getString(R.string.order_dialog_finished);
                    t9.i.f(string, "resources.getString(R.st…ng.order_dialog_finished)");
                } else if (!t9.i.b(getOrderInfoData.getPaymentPlatform(), "Pagsmile") || y6.b.a(d10, "yyyy-MM-dd HH:mm:ss") < 0) {
                    string = "";
                } else if (getOrderInfoData.isProcessing() == 0) {
                    string = OrderAty.this.getResources().getString(R.string.order_dialog_expired);
                    t9.i.f(string, "resources.getString(R.string.order_dialog_expired)");
                } else {
                    string = OrderAty.this.getResources().getString(R.string.order_dialog_processed);
                    t9.i.f(string, "resources.getString(R.st…g.order_dialog_processed)");
                }
                if (!b0.J(string)) {
                    new PaymentResultDialog(OrderAty.this, string).show();
                    return;
                }
                String json = new Gson().toJson(getOrderInfoData);
                OrderAty orderAty = OrderAty.this;
                String str = this.f8412b;
                t9.i.f(json, "orderJson");
                b0.p(orderAty, str, json, getOrderInfoData.getPaymentType());
            }
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            OrderAty.this.O2(true);
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            OrderAty.this.O2(false);
            b0.U(this, "fetch order record fail");
            x.f8754a.w(OrderAty.this.Q1(), new a(str));
        }
    }

    public static final class d extends ha.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PriorityVipDialog f8415b;

        public static final class a extends t9.j implements l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f8416a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f8416a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f14242a;
            }

            public final void invoke(String str) {
                f1.f8649a.x(y.p(y.f8771a, this.f8416a, null, null, 6, null));
            }
        }

        public d(PriorityVipDialog priorityVipDialog) {
            this.f8415b = priorityVipDialog;
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(GetPriorityVipResult getPriorityVipResult) {
            t9.i.g(getPriorityVipResult, "t");
            OrderAty.this.showLoading(false);
            if (!t9.i.b(getPriorityVipResult.getReturnCode(), "0")) {
                if (t9.i.b(getPriorityVipResult.getReturnCode(), "aaa60001")) {
                    b0.U(this, "getPriorityVip disqualified");
                    this.f8415b.dismiss();
                    return;
                }
                return;
            }
            b0.U(this, "getPriorityVip success");
            this.f8415b.dismiss();
            OrderAty orderAty = OrderAty.this;
            PriorityVipDialog.Type type = PriorityVipDialog.Type.RECEIVE;
            ResultFlag data = getPriorityVipResult.getData();
            new PriorityVipDialog(orderAty, type, data != null ? data.getAuthDays() : 0, null, 8, null).show();
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            OrderAty.this.showLoading(true);
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            OrderAty.this.showLoading(false);
            b0.U(this, "getPriorityVip failed");
            x.f8754a.w(OrderAty.this.Q1(), new a(str));
        }
    }

    public static final class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            OrderAty.this.h3();
        }
    }

    public static final class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            OrderAty.this.p3();
        }
    }

    public static final class g extends t9.j implements s9.a {

        /* renamed from: a, reason: collision with root package name */
        public static final g f8419a = new g();

        public g() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final f6.j invoke() {
            return new f6.j();
        }
    }

    public static final class h extends t9.j implements s9.a {

        /* renamed from: a, reason: collision with root package name */
        public static final h f8420a = new h();

        public h() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final f6.k invoke() {
            return new f6.k();
        }
    }

    public static final class i extends t9.j implements l {
        public i() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return t.f14242a;
        }

        public final void invoke(String str) {
            t9.i.g(str, "it");
            OrderAty.this.i3(str);
        }
    }

    public static final class j extends ha.a {

        public static final class a extends t9.j implements l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f8423a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f8423a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f14242a;
            }

            public final void invoke(String str) {
                f1.f8649a.x(y.p(y.f8771a, this.f8423a, null, null, 6, null));
            }
        }

        public j() {
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(GetExchangeOrderInfoResult getExchangeOrderInfoResult) {
            t9.i.g(getExchangeOrderInfoResult, "t");
            b0.U(this, "query exchange record success");
            OrderAty.this.showLoading(false);
            if (b0.I(getExchangeOrderInfoResult.getData()) && OrderAty.this.k3() == 1) {
                OrderAty orderAty = OrderAty.this;
                List<GetExchangeOrderData> data = getExchangeOrderInfoResult.getData();
                t9.i.e(data, "null cannot be cast to non-null type java.util.ArrayList<mobile.com.requestframe.utils.response.GetExchangeOrderData>");
                orderAty.x3((ArrayList) data);
                OrderAty.this.m3().setNewData(OrderAty.this.n3());
            }
            OrderAty.this.f3();
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            OrderAty.this.showLoading(true);
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            OrderAty.this.showLoading(false);
            OrderAty.this.z3();
            b0.U(this, "fetch redemption record fail");
            x.f8754a.w(OrderAty.this.Q1(), new a(str));
        }
    }

    public static final class k extends ha.a {

        public static final class a extends t9.j implements l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f8425a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f8425a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f14242a;
            }

            public final void invoke(String str) {
                f1.f8649a.x(y.p(y.f8771a, this.f8425a, null, null, 6, null));
            }
        }

        public k() {
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(GetOrderInfoResult getOrderInfoResult) {
            t9.i.g(getOrderInfoResult, "t");
            b0.U(this, "query order record success");
            OrderAty.this.showLoading(false);
            if (b0.I(getOrderInfoResult.getData()) && OrderAty.this.k3() == 0) {
                OrderAty orderAty = OrderAty.this;
                List<GetOrderInfoData> data = getOrderInfoResult.getData();
                t9.i.e(data, "null cannot be cast to non-null type java.util.ArrayList<mobile.com.requestframe.utils.response.GetOrderInfoData>");
                orderAty.w3((ArrayList) data);
                OrderAty.this.l3().setNewData(OrderAty.this.j3());
                OrderAty.this.C3();
            }
            OrderAty.this.f3();
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            OrderAty.this.showLoading(true);
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            OrderAty.this.showLoading(false);
            if (t9.i.b(str, CdnType.DIGITAL_TYPE_PCDN)) {
                OrderAty.this.f3();
                return;
            }
            OrderAty.this.A3();
            b0.U(this, "fetch order record fail");
            x.f8754a.w(OrderAty.this.Q1(), new a(str));
        }
    }

    public static final void q3(OrderAty orderAty, View view) {
        t9.i.g(orderAty, "this$0");
        orderAty.f8401m = 0;
        ((AutoFrameLayout) orderAty.V2(R$id.mAflRefresh)).setVisibility(0);
        int i10 = R$id.mTextOrder;
        ((TextView) orderAty.V2(i10)).setTextColor(orderAty.getResources().getColor(R.color.color_important));
        int i11 = R$id.mTextRedemption;
        ((TextView) orderAty.V2(i11)).setTextColor(orderAty.getResources().getColor(R.color.color_cccccc));
        ((TextView) orderAty.V2(i10)).setTypeface(Typeface.DEFAULT_BOLD);
        ((TextView) orderAty.V2(i11)).setTypeface(Typeface.DEFAULT);
        orderAty.l3().bindToRecyclerView((RecyclerView) orderAty.V2(R$id.mRecyclerOrder));
        orderAty.l3().setNewData(orderAty.f8399k);
        ((AutoFrameLayout) orderAty.V2(R$id.mAflOrder)).setVisibility(0);
        orderAty.V2(R$id.mOrderStatus).setVisibility(8);
        if (orderAty.f8399k.isEmpty()) {
            orderAty.v3();
        }
    }

    public static final void r3(OrderAty orderAty, View view) {
        t9.i.g(orderAty, "this$0");
        orderAty.f8401m = 1;
        ((AutoFrameLayout) orderAty.V2(R$id.mAflRefresh)).setVisibility(8);
        int i10 = R$id.mTextOrder;
        ((TextView) orderAty.V2(i10)).setTextColor(orderAty.getResources().getColor(R.color.color_cccccc));
        int i11 = R$id.mTextRedemption;
        ((TextView) orderAty.V2(i11)).setTextColor(orderAty.getResources().getColor(R.color.color_important));
        ((TextView) orderAty.V2(i10)).setTypeface(Typeface.DEFAULT);
        ((TextView) orderAty.V2(i11)).setTypeface(Typeface.DEFAULT_BOLD);
        orderAty.m3().bindToRecyclerView((RecyclerView) orderAty.V2(R$id.mRecyclerOrder));
        orderAty.m3().setNewData(orderAty.f8400l);
        ((AutoFrameLayout) orderAty.V2(R$id.mAflOrder)).setVisibility(0);
        orderAty.V2(R$id.mOrderStatus).setVisibility(8);
        if (orderAty.f8400l.isEmpty()) {
            orderAty.u3();
        }
    }

    public static final void s3(OrderAty orderAty, View view) {
        t9.i.g(orderAty, "this$0");
        orderAty.v3();
        orderAty.f8403o = 60L;
        orderAty.y3(false);
        orderAty.f8402n.post(orderAty.f8404p);
    }

    public static final void t3(OrderAty orderAty, View view) {
        t9.i.g(orderAty, "this$0");
        b0.M(orderAty);
    }

    public final void A3() {
        int i10 = R$id.mTvOrderHint;
        ((TextView) V2(i10)).setVisibility(0);
        ((TextView) V2(i10)).setText(getResources().getString(R.string.order_system_busy));
        ((TextView) V2(i10)).setTextColor(getResources().getColor(R.color.color_f23232));
        this.f8402n.postDelayed(this.f8405q, 5000L);
    }

    public final void B3(boolean z10) {
        if (z10) {
            V2(R$id.mLayoutNoLogin).setVisibility(8);
            ((AutoLinearLayout) V2(R$id.mLayoutTab)).setVisibility(0);
            ((AutoFrameLayout) V2(R$id.mAflOrder)).setVisibility(0);
            V2(R$id.mOrderStatus).setVisibility(8);
            ((AutoFrameLayout) V2(R$id.mAflRefresh)).setVisibility(0);
            return;
        }
        int i10 = R$id.mLayoutNoLogin;
        V2(i10).setVisibility(0);
        ((TextView) V2(i10).findViewById(R$id.mTvStatusInfo)).setText(getResources().getString(R.string.vod_please_bind));
        ((ImageView) V2(i10).findViewById(R$id.mImageNoLogin)).setVisibility(0);
        ((AutoLinearLayout) V2(R$id.mLayoutTab)).setVisibility(8);
        ((AutoFrameLayout) V2(R$id.mAflOrder)).setVisibility(8);
        V2(R$id.mOrderStatus).setVisibility(8);
        ((AutoFrameLayout) V2(R$id.mAflRefresh)).setVisibility(8);
    }

    public final void C3() {
        int i10 = R$id.mTvOrderHint;
        ((TextView) V2(i10)).setVisibility(0);
        ((TextView) V2(i10)).setText(getResources().getString(R.string.order_record_update));
        ((TextView) V2(i10)).setTextColor(getResources().getColor(R.color.color_important));
        this.f8402n.postDelayed(this.f8405q, 5000L);
    }

    public View V2(int i10) {
        Map map = this.f8408t;
        View view = (View) map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public final void f3() {
        if (!(this.f8401m == 0 ? this.f8399k : this.f8400l).isEmpty()) {
            ((AutoFrameLayout) V2(R$id.mAflOrder)).setVisibility(0);
            V2(R$id.mOrderStatus).setVisibility(8);
            return;
        }
        ((AutoFrameLayout) V2(R$id.mAflOrder)).setVisibility(8);
        int i10 = R$id.mOrderStatus;
        V2(i10).setVisibility(0);
        ((TextView) V2(i10).findViewById(R$id.mTvStatusInfo)).setText(b0.A(this, R.string.no_order_record));
        ((ImageView) V2(i10).findViewById(R$id.mImageNoLogin)).setVisibility(8);
    }

    public final void g3() {
        w6.i.f19214g.b().V0().compose(O1()).subscribe(new b());
    }

    public final void h3() {
        if (this.f8403o == 0) {
            ((TextView) V2(R$id.mTvRefresh)).setText(getResources().getString(R.string.order_refresh));
            y3(true);
            return;
        }
        TextView textView = (TextView) V2(R$id.mTvRefresh);
        StringBuilder sb = new StringBuilder();
        sb.append(this.f8403o);
        sb.append('s');
        textView.setText(sb.toString());
        this.f8403o--;
        this.f8402n.postDelayed(this.f8404p, 1000L);
    }

    public final void i3(String str) {
        w6.i.f19214g.b().D1(str).compose(O1()).subscribe(new c(str));
    }

    public final ArrayList j3() {
        return this.f8399k;
    }

    @Override // i5.a
    public void k2() {
        n2();
    }

    public final int k3() {
        return this.f8401m;
    }

    public final f6.j l3() {
        return (f6.j) this.f8406r.getValue();
    }

    public final f6.k m3() {
        return (f6.k) this.f8407s.getValue();
    }

    public final ArrayList n3() {
        return this.f8400l;
    }

    public final void o3(PriorityVipDialog priorityVipDialog) {
        w6.i.f19214g.b().E1().compose(O1()).subscribe(new d(priorityVipDialog));
    }

    @Override // f5.c, i5.a, u8.a, androidx.appcompat.app.d, androidx.fragment.app.e, androidx.activity.ComponentActivity, o.p, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.aty_order);
        if (t9.i.b(w6.i.f19214g.I(), "1")) {
            B3(false);
            return;
        }
        B3(true);
        int i10 = R$id.mTvHelp;
        ((TextView) V2(i10)).getPaint().setFlags(8);
        ((TextView) V2(i10)).getPaint().setAntiAlias(true);
        int i11 = R$id.mRecyclerOrder;
        ((RecyclerView) V2(i11)).setLayoutManager(new LinearLayoutManager(Q1()));
        l3().k(new i());
        l3().bindToRecyclerView((RecyclerView) V2(i11));
        v3();
        g3();
        ((TextView) V2(R$id.mTextOrder)).setOnClickListener(new View.OnClickListener() { // from class: e6.r0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OrderAty.q3(OrderAty.this, view);
            }
        });
        ((TextView) V2(R$id.mTextRedemption)).setOnClickListener(new View.OnClickListener() { // from class: e6.s0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OrderAty.r3(OrderAty.this, view);
            }
        });
        ((TextView) V2(R$id.mTvRefresh)).setOnClickListener(new View.OnClickListener() { // from class: e6.t0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OrderAty.s3(OrderAty.this, view);
            }
        });
        ((TextView) V2(i10)).setOnClickListener(new View.OnClickListener() { // from class: e6.u0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                OrderAty.t3(OrderAty.this, view);
            }
        });
    }

    public final void p3() {
        ((TextView) V2(R$id.mTvOrderHint)).setVisibility(8);
    }

    public final void showLoading(boolean z10) {
        if (z10) {
            LoadingDialog.Companion.show(getFragmentManager());
        } else {
            LoadingDialog.Companion.hidden();
        }
    }

    public final void u3() {
        w6.i.f19214g.b().t1().compose(O1()).subscribe(new j());
    }

    public final void v3() {
        w6.i.f19214g.b().C1().compose(O1()).subscribe(new k());
    }

    public final void w3(ArrayList arrayList) {
        t9.i.g(arrayList, "<set-?>");
        this.f8399k = arrayList;
    }

    public final void x3(ArrayList arrayList) {
        t9.i.g(arrayList, "<set-?>");
        this.f8400l = arrayList;
    }

    public final void y3(boolean z10) {
        if (z10) {
            int i10 = R$id.mTvRefresh;
            ((TextView) V2(i10)).setEnabled(true);
            ((TextView) V2(i10)).setTextColor(getResources().getColor(R.color.color_important));
        } else {
            int i11 = R$id.mTvRefresh;
            ((TextView) V2(i11)).setEnabled(false);
            ((TextView) V2(i11)).setTextColor(getResources().getColor(R.color.color_999999));
        }
    }

    public final void z3() {
        ((AutoFrameLayout) V2(R$id.mAflOrder)).setVisibility(8);
        int i10 = R$id.mOrderStatus;
        V2(i10).setVisibility(0);
        ((TextView) V2(i10).findViewById(R$id.mTvStatusInfo)).setText(b0.A(this, R.string.order_record_get_failed));
        ((ImageView) V2(i10).findViewById(R$id.mImageNoLogin)).setVisibility(8);
    }
}
