package c8;

import android.app.Activity;
import android.os.Build;
import android.text.TextUtils;
import androidx.fragment.app.o;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.functions.Function;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    public static final String f5629b = "b";

    /* renamed from: c, reason: collision with root package name */
    public static final Object f5630c = new Object();

    /* renamed from: a, reason: collision with root package name */
    public e f5631a;

    public class a implements e {

        /* renamed from: a, reason: collision with root package name */
        public c8.e f5632a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ o f5633b;

        public a(o oVar) {
            this.f5633b = oVar;
        }

        @Override // c8.b.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public synchronized c8.e get() {
            if (this.f5632a == null) {
                this.f5632a = b.this.h(this.f5633b);
            }
            return this.f5632a;
        }
    }

    /* renamed from: c8.b$b, reason: collision with other inner class name */
    public class C0083b implements ObservableTransformer {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String[] f5635a;

        /* renamed from: c8.b$b$a */
        public class a implements Function {
            public a() {
            }

            @Override // io.reactivex.functions.Function
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public ObservableSource apply(List list) {
                if (list.isEmpty()) {
                    return Observable.empty();
                }
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (!((c8.a) it.next()).f5627b) {
                        return Observable.just(Boolean.FALSE);
                    }
                }
                return Observable.just(Boolean.TRUE);
            }
        }

        public C0083b(String[] strArr) {
            this.f5635a = strArr;
        }

        @Override // io.reactivex.ObservableTransformer
        public ObservableSource apply(Observable observable) {
            return b.this.n(observable, this.f5635a).buffer(this.f5635a.length).flatMap(new a());
        }
    }

    public class c implements ObservableTransformer {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String[] f5638a;

        public c(String[] strArr) {
            this.f5638a = strArr;
        }

        @Override // io.reactivex.ObservableTransformer
        public ObservableSource apply(Observable observable) {
            return b.this.n(observable, this.f5638a);
        }
    }

    public class d implements Function {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String[] f5640a;

        public d(String[] strArr) {
            this.f5640a = strArr;
        }

        @Override // io.reactivex.functions.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Observable apply(Object obj) {
            return b.this.q(this.f5640a);
        }
    }

    public interface e {
        Object get();
    }

    public b(androidx.fragment.app.e eVar) {
        this.f5631a = g(eVar.getSupportFragmentManager());
    }

    public ObservableTransformer d(String... strArr) {
        return new C0083b(strArr);
    }

    public ObservableTransformer e(String... strArr) {
        return new c(strArr);
    }

    public final c8.e f(o oVar) {
        return (c8.e) oVar.h0(f5629b);
    }

    public final e g(o oVar) {
        return new a(oVar);
    }

    public final c8.e h(o oVar) {
        c8.e f10 = f(oVar);
        if (!(f10 == null)) {
            return f10;
        }
        c8.e eVar = new c8.e();
        oVar.m().e(eVar, f5629b).k();
        return eVar;
    }

    public boolean i(String str) {
        return !j() || ((c8.e) this.f5631a.get()).Q2(str);
    }

    public boolean j() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public boolean k(String str) {
        return j() && ((c8.e) this.f5631a.get()).R2(str);
    }

    public final Observable l(Observable observable, Observable observable2) {
        return observable == null ? Observable.just(f5630c) : Observable.merge(observable, observable2);
    }

    public final Observable m(String... strArr) {
        for (String str : strArr) {
            if (!((c8.e) this.f5631a.get()).O2(str)) {
                return Observable.empty();
            }
        }
        return Observable.just(f5630c);
    }

    public final Observable n(Observable observable, String... strArr) {
        if (strArr == null || strArr.length == 0) {
            throw new IllegalArgumentException("RxPermissions.request/requestEach requires at least one input permission");
        }
        return l(observable, m(strArr)).flatMap(new d(strArr));
    }

    public Observable o(String... strArr) {
        return Observable.just(f5630c).compose(d(strArr));
    }

    public Observable p(String... strArr) {
        return Observable.just(f5630c).compose(e(strArr));
    }

    public final Observable q(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        ArrayList arrayList2 = new ArrayList();
        for (String str : strArr) {
            ((c8.e) this.f5631a.get()).S2("Requesting permission " + str);
            if (i(str)) {
                arrayList.add(Observable.just(new c8.a(str, true, false)));
            } else if (k(str)) {
                arrayList.add(Observable.just(new c8.a(str, false, false)));
            } else {
                PublishSubject P2 = ((c8.e) this.f5631a.get()).P2(str);
                if (P2 == null) {
                    arrayList2.add(str);
                    P2 = PublishSubject.create();
                    ((c8.e) this.f5631a.get()).V2(str, P2);
                }
                arrayList.add(P2);
            }
        }
        if (!arrayList2.isEmpty()) {
            r((String[]) arrayList2.toArray(new String[arrayList2.size()]));
        }
        return Observable.concat(Observable.fromIterable(arrayList));
    }

    public void r(String[] strArr) {
        ((c8.e) this.f5631a.get()).S2("requestPermissionsFromFragment " + TextUtils.join(", ", strArr));
        ((c8.e) this.f5631a.get()).U2(strArr);
    }

    public Observable s(Activity activity, String... strArr) {
        return !j() ? Observable.just(Boolean.FALSE) : Observable.just(Boolean.valueOf(t(activity, strArr)));
    }

    public final boolean t(Activity activity, String... strArr) {
        boolean shouldShowRequestPermissionRationale;
        for (String str : strArr) {
            if (!i(str)) {
                shouldShowRequestPermissionRationale = activity.shouldShowRequestPermissionRationale(str);
                if (!shouldShowRequestPermissionRationale) {
                    return false;
                }
            }
        }
        return true;
    }
}
