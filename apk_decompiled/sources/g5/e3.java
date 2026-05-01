package g5;

import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hpplay.component.protocol.PlistBuilder;
import com.mobile.brasiltv.bean.NationBean;
import com.mobile.brasiltv.view.LinearLayoutManagerWrapper;
import com.mobile.brasiltv.view.SideBar;
import com.msandroid.mobile.R;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes3.dex */
public final class e3 extends BaseQuickAdapter implements SideBar.OnTouchingLetterChangedListener {

    /* renamed from: a, reason: collision with root package name */
    public LinearLayoutManagerWrapper f13683a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f13684b;

    /* renamed from: c, reason: collision with root package name */
    public c f13685c;

    public static final class a extends t9.j implements s9.l {
        public a() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ArrayList invoke(List list) {
            t9.i.g(list, "nationBeen");
            return com.mobile.brasiltv.utils.h0.c(list, e3.this.f13684b);
        }
    }

    public static final class b implements Observer {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f13688b;

        public b(ArrayList arrayList) {
            this.f13688b = arrayList;
        }

        @Override // io.reactivex.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(ArrayList arrayList) {
            t9.i.g(arrayList, "resultList");
            this.f13688b.addAll(arrayList);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            e3.this.setNewData(this.f13688b);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            t9.i.g(th, "e");
            com.mobile.brasiltv.utils.b0.U(this, "onError");
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
        }
    }

    public interface c {
        void a(int i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e3(ArrayList arrayList) {
        super(R.layout.adapter_select_nation_item);
        t9.i.g(arrayList, "datas");
        this.f13684b = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(arrayList.subList(0, 6));
        Observable just = Observable.just(arrayList.subList(6, arrayList.size()));
        final a aVar = new a();
        just.map(new Function() { // from class: g5.c3
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ArrayList c10;
                c10 = e3.c(s9.l.this, obj);
                return c10;
            }
        }).compose(com.mobile.brasiltv.utils.p0.a()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(arrayList2));
    }

    public static final ArrayList c(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (ArrayList) lVar.invoke(obj);
    }

    public static final void f(e3 e3Var, BaseViewHolder baseViewHolder, View view) {
        t9.i.g(e3Var, "this$0");
        t9.i.g(baseViewHolder, "$helper");
        c cVar = e3Var.f13685c;
        if (cVar != null) {
            cVar.a(baseViewHolder.getAdapterPosition());
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void convert(final BaseViewHolder baseViewHolder, NationBean nationBean) {
        t9.i.g(baseViewHolder, "helper");
        t9.i.g(nationBean, PlistBuilder.KEY_ITEM);
        baseViewHolder.getView(R.id.select_nation_rl).setOnClickListener(new View.OnClickListener() { // from class: g5.d3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e3.f(e3.this, baseViewHolder, view);
            }
        });
        if (baseViewHolder.getAdapterPosition() == 0) {
            baseViewHolder.setVisible(R.id.index_tv, true).setText(R.id.index_tv, com.mobile.brasiltv.utils.b0.z(R.string.register_nation_most_usr));
        } else if (nationBean.isFirstSZM()) {
            baseViewHolder.setVisible(R.id.index_tv, true).setText(R.id.index_tv, nationBean.getSzm());
        } else {
            baseViewHolder.setGone(R.id.index_tv, false);
        }
        baseViewHolder.setText(R.id.nation_tv, nationBean.getCountry()).setText(R.id.code_tv, '+' + nationBean.getCode());
    }

    public final String g(String str) {
        if (this.f13684b.get(str) != null || t9.i.b("A", str)) {
            return str;
        }
        return g("" + ((char) (str.charAt(0) - 1)));
    }

    public final void h(LinearLayoutManagerWrapper linearLayoutManagerWrapper) {
        this.f13683a = linearLayoutManagerWrapper;
    }

    public final void i(c cVar) {
        this.f13685c = cVar;
    }

    public final void j(SideBar sideBar) {
        t9.i.g(sideBar, "sideBar");
        sideBar.setOnTouchingLetterChangedListener(this);
    }

    @Override // com.mobile.brasiltv.view.SideBar.OnTouchingLetterChangedListener
    public void onTouchingLetterChanged(String str) {
        t9.i.g(str, "s");
        com.mobile.brasiltv.utils.b0.U(this, "onTouchingLetterChanged:" + str + "  position:" + this.f13684b.get(str));
        String g10 = g(str);
        LinearLayoutManagerWrapper linearLayoutManagerWrapper = this.f13683a;
        if (linearLayoutManagerWrapper != null) {
            Integer num = (Integer) this.f13684b.get(g10);
            if (num == null) {
                num = 0;
            }
            linearLayoutManagerWrapper.scrollToPositionWithOffset(num.intValue(), 0);
        }
    }
}
