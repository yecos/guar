package l6;

import android.os.Bundle;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import mobile.com.requestframe.utils.response.ApkQueryCouponResult;
import mobile.com.requestframe.utils.response.ApkReceiveCouponResult;
import mobile.com.requestframe.utils.response.AvailableCouponCodeList;
import mobile.com.requestframe.utils.response.CouponCodeList;
import mobile.com.requestframe.utils.response.QueryCouponData;
import w6.i;

/* loaded from: classes3.dex */
public final class q implements j6.a {

    /* renamed from: a, reason: collision with root package name */
    public final b6.f f16153a;

    /* renamed from: b, reason: collision with root package name */
    public final j6.b f16154b;

    public static final class a extends ha.a {
        public a() {
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(ApkQueryCouponResult apkQueryCouponResult) {
            t9.i.g(apkQueryCouponResult, "t");
            if (apkQueryCouponResult.getData() == null) {
                q.this.o().C();
                return;
            }
            q qVar = q.this;
            QueryCouponData data = apkQueryCouponResult.getData();
            t9.i.d(data);
            qVar.w(data.getCouponCodeList());
            QueryCouponData data2 = apkQueryCouponResult.getData();
            t9.i.d(data2);
            if (com.mobile.brasiltv.utils.b0.I(data2.getReceiveCouponCodeList())) {
                q qVar2 = q.this;
                QueryCouponData data3 = apkQueryCouponResult.getData();
                t9.i.d(data3);
                List<AvailableCouponCodeList> receiveCouponCodeList = data3.getReceiveCouponCodeList();
                t9.i.d(receiveCouponCodeList);
                qVar2.u(receiveCouponCodeList);
            }
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            q.this.o().C();
        }
    }

    public static final class b extends ha.a {
        public b() {
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(ApkReceiveCouponResult apkReceiveCouponResult) {
            t9.i.g(apkReceiveCouponResult, "t");
            q.this.o().t2("success");
            q.this.o().E2();
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            i.c cVar = w6.i.f19214g;
            cVar.r0(cVar.B() + 1);
            q.this.o().t2("failed");
        }
    }

    public static final class c implements Observer {
        public c() {
        }

        @Override // io.reactivex.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(List list) {
            t9.i.g(list, "sortedAvailableList");
            q.this.o().o1(list);
            q.this.o().s1();
            Bundle arguments = q.this.n().getArguments();
            if (t9.i.b(arguments != null ? Boolean.valueOf(arguments.getBoolean("isOpenInHome", false)) : null, Boolean.TRUE)) {
                q.this.o().Q0();
                Bundle arguments2 = q.this.n().getArguments();
                if (arguments2 != null) {
                    arguments2.remove("isOpenInHome");
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            t9.i.g(th, "e");
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
        }
    }

    public static final class d implements Observer {
        public d() {
        }

        @Override // io.reactivex.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(List list) {
            t9.i.g(list, "sortedList");
            q.this.o().K1(list);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            t9.i.g(th, "e");
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
        }
    }

    public q(b6.f fVar, j6.b bVar) {
        t9.i.g(fVar, "frag");
        t9.i.g(bVar, "view");
        this.f16153a = fVar;
        this.f16154b = bVar;
    }

    public static final int r(AvailableCouponCodeList availableCouponCodeList, AvailableCouponCodeList availableCouponCodeList2) {
        Float f10;
        Float f11;
        String couponCurrency = availableCouponCodeList.getCouponCurrency();
        if (couponCurrency == null) {
            couponCurrency = "";
        }
        Map<String, Float> couponAmount = availableCouponCodeList.getCouponAmount();
        float f12 = 0.0f;
        float floatValue = (couponAmount == null || (f11 = couponAmount.get(couponCurrency)) == null) ? 0.0f : f11.floatValue();
        String couponCurrency2 = availableCouponCodeList2.getCouponCurrency();
        String str = couponCurrency2 != null ? couponCurrency2 : "";
        Map<String, Float> couponAmount2 = availableCouponCodeList2.getCouponAmount();
        if (couponAmount2 != null && (f10 = couponAmount2.get(str)) != null) {
            f12 = f10.floatValue();
        }
        return Float.compare(f12, floatValue);
    }

    public static final int t(CouponCodeList couponCodeList, CouponCodeList couponCodeList2) {
        Float f10;
        Float f11;
        if (com.mobile.brasiltv.utils.b0.T(couponCodeList.getStatus(), "0") && !com.mobile.brasiltv.utils.b0.T(couponCodeList2.getStatus(), "0")) {
            return -1;
        }
        if (!com.mobile.brasiltv.utils.b0.T(couponCodeList.getStatus(), "0") && com.mobile.brasiltv.utils.b0.T(couponCodeList2.getStatus(), "0")) {
            return 1;
        }
        if (!com.mobile.brasiltv.utils.b0.T(couponCodeList.getStatus(), "0") || !com.mobile.brasiltv.utils.b0.T(couponCodeList2.getStatus(), "0")) {
            return couponCodeList2.getInvalidTime().compareTo(couponCodeList.getInvalidTime());
        }
        String couponCurrency = couponCodeList.getCouponCurrency();
        if (couponCurrency == null) {
            couponCurrency = "";
        }
        Map<String, Float> couponAmount = couponCodeList.getCouponAmount();
        float f12 = 0.0f;
        float floatValue = (couponAmount == null || (f11 = couponAmount.get(couponCurrency)) == null) ? 0.0f : f11.floatValue();
        String couponCurrency2 = couponCodeList2.getCouponCurrency();
        String str = couponCurrency2 != null ? couponCurrency2 : "";
        Map<String, Float> couponAmount2 = couponCodeList2.getCouponAmount();
        if (couponAmount2 != null && (f10 = couponAmount2.get(str)) != null) {
            f12 = f10.floatValue();
        }
        return Float.compare(f12, floatValue);
    }

    public static final void v(q qVar, List list, ObservableEmitter observableEmitter) {
        t9.i.g(qVar, "this$0");
        t9.i.g(list, "$receiveCouponCodeList");
        t9.i.g(observableEmitter, "emitter");
        List q10 = qVar.q(list);
        t9.i.d(q10);
        observableEmitter.onNext(q10);
    }

    public static final void x(q qVar, List list, ObservableEmitter observableEmitter) {
        t9.i.g(qVar, "this$0");
        t9.i.g(observableEmitter, "emitter");
        List s10 = qVar.s(list);
        t9.i.d(s10);
        observableEmitter.onNext(s10);
    }

    @Override // l5.a
    public void e() {
    }

    @Override // j6.a
    public void f(String str) {
        this.f16154b.h();
        w6.i.f19214g.b().M0(null, str).compose(this.f16153a.O2()).subscribe(new a());
    }

    @Override // l5.a
    public void g() {
    }

    public final b6.f n() {
        return this.f16153a;
    }

    public final j6.b o() {
        return this.f16154b;
    }

    public void p() {
        w6.i.f19214g.b().N0().compose(this.f16153a.O2()).subscribe(new b());
    }

    public final List q(List list) {
        return (list == null || list.isEmpty()) ? list : i9.r.I(i9.r.C(list, new Comparator() { // from class: l6.o
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int r10;
                r10 = q.r((AvailableCouponCodeList) obj, (AvailableCouponCodeList) obj2);
                return r10;
            }
        }));
    }

    public final List s(List list) {
        return (list == null || list.isEmpty()) ? list : i9.r.I(i9.r.C(list, new Comparator() { // from class: l6.p
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int t10;
                t10 = q.t((CouponCodeList) obj, (CouponCodeList) obj2);
                return t10;
            }
        }));
    }

    public final void u(final List list) {
        Observable.create(new ObservableOnSubscribe() { // from class: l6.n
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                q.v(q.this, list, observableEmitter);
            }
        }).compose(this.f16153a.O2()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c());
    }

    public final void w(final List list) {
        if (list == null || list.isEmpty()) {
            this.f16154b.K1(null);
        } else {
            Observable.create(new ObservableOnSubscribe() { // from class: l6.m
                @Override // io.reactivex.ObservableOnSubscribe
                public final void subscribe(ObservableEmitter observableEmitter) {
                    q.x(q.this, list, observableEmitter);
                }
            }).compose(this.f16153a.O2()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d());
        }
    }
}
