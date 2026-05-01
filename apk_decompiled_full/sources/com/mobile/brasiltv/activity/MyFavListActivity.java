package com.mobile.brasiltv.activity;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.MyFavListActivity;
import com.mobile.brasiltv.bean.EnterType;
import com.mobile.brasiltv.bean.event.CheckPwdSuccessEvent;
import com.mobile.brasiltv.mine.activity.EmailAty;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.j1;
import com.mobile.brasiltv.utils.p0;
import com.mobile.brasiltv.utils.x;
import com.mobile.brasiltv.utils.y;
import com.mobile.brasiltv.view.KoocanEmptyView;
import com.mobile.brasiltv.view.LoadingDialog;
import com.mobile.brasiltv.view.TitleView;
import com.mobile.brasiltv.view.VerticalItemDecoration;
import com.mobile.brasiltv.view.dialog.DeleteConfirmDialog;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;
import com.zhy.autolayout.utils.AutoUtils;
import g5.d1;
import h9.t;
import i6.z;
import i9.r;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import k6.g1;
import mobile.com.requestframe.utils.response.DelFavoriteResult;
import mobile.com.requestframe.utils.response.Favorite;
import s9.p;
import w6.i;

/* loaded from: classes.dex */
public final class MyFavListActivity extends f5.d implements z, SwipeRefreshLayout.j, DeleteConfirmDialog.ConfirmCallback {

    /* renamed from: l, reason: collision with root package name */
    public boolean f7944l;

    /* renamed from: m, reason: collision with root package name */
    public g1 f7945m;

    /* renamed from: o, reason: collision with root package name */
    public boolean f7947o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f7948p;

    /* renamed from: q, reason: collision with root package name */
    public int f7949q;

    /* renamed from: r, reason: collision with root package name */
    public Map f7950r = new LinkedHashMap();

    /* renamed from: n, reason: collision with root package name */
    public final h9.g f7946n = h9.h.b(new g());

    /* loaded from: classes3.dex */
    public static final class a extends t9.j implements s9.l {
        public a() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Favorite favorite) {
            t9.i.g(favorite, "it");
            if (MyFavListActivity.this.H3()) {
                return Boolean.valueOf(favorite.getId() != null);
            }
            return Boolean.valueOf(favorite.isSelect());
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final b f7952a = new b();

        public b() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Integer invoke(Favorite favorite) {
            t9.i.g(favorite, "it");
            return favorite.getId();
        }
    }

    /* loaded from: classes3.dex */
    public static final class c extends t9.j implements p {

        /* renamed from: a, reason: collision with root package name */
        public static final c f7953a = new c();

        public c() {
            super(2);
        }

        public final void b(ArrayList arrayList, Integer num) {
            t9.i.d(num);
            arrayList.add(num);
        }

        @Override // s9.p
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            b((ArrayList) obj, (Integer) obj2);
            return t.f14242a;
        }
    }

    /* loaded from: classes3.dex */
    public static final class d extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final d f7954a = new d();

        public d() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(ArrayList arrayList) {
            t9.i.g(arrayList, "it");
            if (arrayList.isEmpty()) {
                throw new NullPointerException("delList is empty");
            }
            return Boolean.TRUE;
        }
    }

    /* loaded from: classes3.dex */
    public static final class e extends t9.j implements s9.l {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f7956b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(ArrayList arrayList) {
            super(1);
            this.f7956b = arrayList;
        }

        public final void b(DelFavoriteResult delFavoriteResult) {
            List data = MyFavListActivity.this.F3().getData();
            t9.i.f(data, "mMyFavListAdapter.data");
            int size = data.size();
            while (true) {
                size--;
                if (-1 >= size) {
                    break;
                }
                ArrayList arrayList = this.f7956b;
                t9.i.f(arrayList, "filterArray");
                if (r.p(arrayList, ((Favorite) data.get(size)).getId())) {
                    data.remove(size);
                }
            }
            MyFavListActivity.this.c4();
            MyFavListActivity.this.F3().notifyDataSetChanged();
            if (data.size() == 0) {
                MyFavListActivity myFavListActivity = MyFavListActivity.this;
                myFavListActivity.a0(myFavListActivity.f7944l);
            }
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((DelFavoriteResult) obj);
            return t.f14242a;
        }
    }

    /* loaded from: classes3.dex */
    public static final class f extends ha.a {

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f7958a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f7958a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return t.f14242a;
            }

            public final void invoke(String str) {
                f1.f8649a.x(y.p(y.f8771a, this.f7958a, null, null, 6, null));
            }
        }

        public f() {
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(DelFavoriteResult delFavoriteResult) {
            t9.i.g(delFavoriteResult, "t");
            b0.U(this, "delFavSuccess,favoriteId:" + delFavoriteResult.getReturnCode());
            LoadingDialog.Companion.hidden();
            ((ImageView) MyFavListActivity.this.t3(R$id.itemAllCheckbox)).setImageResource(R.drawable.icon_no_select);
            MyFavListActivity.this.k4(0);
        }

        @Override // ha.a, io.reactivex.Observer
        public void onComplete() {
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            LoadingDialog.Companion.show(MyFavListActivity.this.getFragmentManager());
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            LoadingDialog.Companion.hidden();
            x.f8754a.w(MyFavListActivity.this.Q1(), new a(str));
        }
    }

    /* loaded from: classes3.dex */
    public static final class g extends t9.j implements s9.a {
        public g() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final d1 invoke() {
            return new d1(MyFavListActivity.this);
        }
    }

    /* loaded from: classes3.dex */
    public static final class h extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final h f7960a = new h();

        public h() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Favorite favorite) {
            t9.i.g(favorite, "it");
            return Boolean.valueOf(favorite.isSelect());
        }
    }

    /* loaded from: classes3.dex */
    public static final class i extends t9.j implements p {

        /* renamed from: a, reason: collision with root package name */
        public static final i f7961a = new i();

        public i() {
            super(2);
        }

        public final void b(ArrayList arrayList, Favorite favorite) {
            t9.i.d(favorite);
            arrayList.add(favorite);
        }

        @Override // s9.p
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            b((ArrayList) obj, (Favorite) obj2);
            return t.f14242a;
        }
    }

    /* loaded from: classes3.dex */
    public static final class j extends t9.j implements s9.l {
        public j() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((ArrayList) obj);
            return t.f14242a;
        }

        public final void invoke(ArrayList arrayList) {
            if (MyFavListActivity.this.H3() || !arrayList.isEmpty()) {
                MyFavListActivity myFavListActivity = MyFavListActivity.this;
                int i10 = R$id.btnDelete;
                ((Button) myFavListActivity.t3(i10)).setBackgroundColor(MyFavListActivity.this.getResources().getColor(R.color.color_important));
                ((Button) MyFavListActivity.this.t3(i10)).setClickable(true);
                return;
            }
            MyFavListActivity myFavListActivity2 = MyFavListActivity.this;
            int i11 = R$id.btnDelete;
            ((Button) myFavListActivity2.t3(i11)).setBackgroundColor(MyFavListActivity.this.getResources().getColor(R.color.color_666666));
            ((Button) MyFavListActivity.this.t3(i11)).setClickable(false);
        }
    }

    /* loaded from: classes3.dex */
    public static final class k extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final k f7963a = new k();

        public k() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f14242a;
        }

        public final void invoke(Throwable th) {
            th.printStackTrace();
        }
    }

    /* loaded from: classes3.dex */
    public static final class l extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final l f7964a = new l();

        public l() {
            super(1);
        }

        public final void b(Favorite favorite) {
            t9.i.g(favorite, "it");
            favorite.setSelect(false);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((Favorite) obj);
            return t.f14242a;
        }
    }

    /* loaded from: classes3.dex */
    public static final class m extends t9.j implements s9.l {
        public m() {
            super(1);
        }

        public final void b(t tVar) {
            MyFavListActivity.this.F3().notifyDataSetChanged();
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((t) obj);
            return t.f14242a;
        }
    }

    public static final ArrayList A3() {
        return new ArrayList();
    }

    public static final void B3(p pVar, Object obj, Object obj2) {
        t9.i.g(pVar, "$tmp0");
        pVar.invoke(obj, obj2);
    }

    public static final boolean C3(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    public static final ObservableSource D3(MyFavListActivity myFavListActivity, ArrayList arrayList) {
        t9.i.g(myFavListActivity, "this$0");
        t9.i.g(arrayList, "filterArray");
        b0.U(myFavListActivity, "MyFavListActivity 删除 " + arrayList);
        Observable o12 = w6.i.f19214g.b().o1(r.F(arrayList));
        final e eVar = myFavListActivity.new e(arrayList);
        return o12.doOnNext(new Consumer() { // from class: f5.b2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MyFavListActivity.E3(s9.l.this, obj);
            }
        });
    }

    public static final void E3(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void M3(MyFavListActivity myFavListActivity, View view) {
        t9.i.g(myFavListActivity, "this$0");
        Context Q1 = myFavListActivity.Q1();
        t9.i.e(Q1, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
        b0.c0((f5.c) Q1, EmailAty.class);
    }

    public static final void N3(MyFavListActivity myFavListActivity, View view) {
        t9.i.g(myFavListActivity, "this$0");
        int i10 = R$id.mEditPassword;
        Editable text = ((EditText) myFavListActivity.t3(i10)).getText();
        if (text == null || text.length() == 0) {
            return;
        }
        String obj = ba.t.W(((EditText) myFavListActivity.t3(i10)).getText().toString()).toString();
        if (j1.f(obj)) {
            myFavListActivity.S2().k(obj);
            return;
        }
        int i11 = R$id.mTextErrorNotify;
        ((TextView) myFavListActivity.t3(i11)).setVisibility(0);
        TextView textView = (TextView) myFavListActivity.t3(i11);
        Context Q1 = myFavListActivity.Q1();
        t9.i.d(Q1);
        textView.setText(Q1.getResources().getString(R.string.password_format_incorrect));
    }

    public static final void O3(MyFavListActivity myFavListActivity, View view) {
        t9.i.g(myFavListActivity, "this$0");
        i.c cVar = w6.i.f19214g;
        if (t9.i.b(cVar.c(), "1") && !t9.i.b(cVar.h(), "1") && !t9.i.b(cVar.j(), "1")) {
            f1.f8649a.w(R.string.mine_please_bind);
            return;
        }
        Intent intent = new Intent(myFavListActivity.Q1(), (Class<?>) ResetAty.class);
        if (t9.i.b(cVar.h(), "1")) {
            intent.putExtra("need_x_button", false);
            intent.putExtra("bind_from", 2);
            intent.putExtra("bind_Type", "3");
            intent.putExtra("is_edit_editable", false);
        } else if (t9.i.b(cVar.j(), "1")) {
            intent.putExtra("need_x_button", false);
            intent.putExtra("bind_from", 1);
            intent.putExtra("bind_Type", "3");
            intent.putExtra("is_edit_editable", false);
        } else {
            intent.putExtra("need_x_button", false);
            intent.putExtra("bind_from", 2);
            intent.putExtra("bind_Type", "3");
            intent.putExtra("is_edit_editable", true);
        }
        myFavListActivity.startActivity(intent);
    }

    public static final void Q3(MyFavListActivity myFavListActivity, View view) {
        t9.i.g(myFavListActivity, "this$0");
        myFavListActivity.c4();
    }

    public static final void R3(MyFavListActivity myFavListActivity, View view) {
        t9.i.g(myFavListActivity, "this$0");
        myFavListActivity.c4();
    }

    public static final void S3(MyFavListActivity myFavListActivity, View view) {
        t9.i.g(myFavListActivity, "this$0");
        if (b0.I(myFavListActivity.F3().getData())) {
            boolean z10 = !myFavListActivity.f7948p;
            myFavListActivity.f7948p = z10;
            if (z10) {
                myFavListActivity.f7949q = myFavListActivity.F3().getData().size();
                ((ImageView) myFavListActivity.t3(R$id.itemAllCheckbox)).setImageResource(R.drawable.icon_select);
                int i10 = R$id.btnDelete;
                ((Button) myFavListActivity.t3(i10)).setBackgroundColor(myFavListActivity.getResources().getColor(R.color.color_important));
                ((Button) myFavListActivity.t3(i10)).setClickable(true);
            } else {
                int i11 = R$id.btnDelete;
                ((Button) myFavListActivity.t3(i11)).setBackgroundColor(myFavListActivity.getResources().getColor(R.color.color_666666));
                ((Button) myFavListActivity.t3(i11)).setClickable(false);
                ((ImageView) myFavListActivity.t3(R$id.itemAllCheckbox)).setImageResource(R.drawable.icon_no_select);
                myFavListActivity.f7949q = 0;
            }
            Iterator it = myFavListActivity.F3().getData().iterator();
            while (it.hasNext()) {
                ((Favorite) it.next()).setSelect(myFavListActivity.f7948p);
            }
            myFavListActivity.F3().notifyDataSetChanged();
        }
    }

    public static final void T3(MyFavListActivity myFavListActivity, View view) {
        t9.i.g(myFavListActivity, "this$0");
        if (myFavListActivity.f7948p) {
            new DeleteConfirmDialog(myFavListActivity, R.string.my_fav_whether_delete_all, myFavListActivity).show();
        } else {
            myFavListActivity.x3();
        }
    }

    public static final void U3(MyFavListActivity myFavListActivity, BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        t9.i.g(myFavListActivity, "this$0");
        View viewByPosition = baseQuickAdapter.getViewByPosition((RecyclerView) myFavListActivity.t3(R$id.mRecyclerFav), i10, R.id.itemCheckbox);
        t9.i.e(viewByPosition, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView imageView = (ImageView) viewByPosition;
        if (myFavListActivity.f7947o) {
            if (((Favorite) myFavListActivity.F3().getData().get(i10)).isSelect()) {
                ((Favorite) myFavListActivity.F3().getData().get(i10)).setSelect(false);
                imageView.setImageResource(R.drawable.icon_no_select);
                myFavListActivity.f7949q--;
            } else {
                myFavListActivity.f7949q++;
                ((Favorite) myFavListActivity.F3().getData().get(i10)).setSelect(true);
                imageView.setImageResource(R.drawable.icon_select);
            }
            if (myFavListActivity.f7949q == myFavListActivity.F3().getData().size()) {
                myFavListActivity.f7948p = true;
                ((ImageView) myFavListActivity.t3(R$id.itemAllCheckbox)).setImageResource(R.drawable.icon_select);
            } else {
                ((ImageView) myFavListActivity.t3(R$id.itemAllCheckbox)).setImageResource(R.drawable.icon_no_select);
                myFavListActivity.f7948p = false;
            }
            if (myFavListActivity.f7949q == 0) {
                int i11 = R$id.btnDelete;
                ((Button) myFavListActivity.t3(i11)).setBackgroundColor(myFavListActivity.getResources().getColor(R.color.color_666666));
                ((Button) myFavListActivity.t3(i11)).setClickable(false);
            } else {
                int i12 = R$id.btnDelete;
                ((Button) myFavListActivity.t3(i12)).setBackgroundColor(myFavListActivity.getResources().getColor(R.color.color_important));
                ((Button) myFavListActivity.t3(i12)).setClickable(true);
            }
        } else {
            a7.d dVar = a7.d.f279a;
            String o10 = dVar.o(((Favorite) myFavListActivity.F3().getData().get(i10)).getPosterList(), dVar.g());
            if (o10 == null) {
                o10 = "";
            }
            String str = o10;
            String type = ((Favorite) myFavListActivity.F3().getData().get(i10)).getType();
            String contentId = ((Favorite) myFavListActivity.F3().getData().get(i10)).getContentId();
            EnterType enterType = EnterType.CATEGORY;
            String alias = ((Favorite) myFavListActivity.F3().getData().get(i10)).getAlias();
            String obj = alias != null ? ba.t.W(alias).toString() : null;
            String name = ((Favorite) myFavListActivity.F3().getData().get(i10)).getName();
            b0.r(myFavListActivity, type, "", contentId, enterType, b0.c(obj, name != null ? ba.t.W(name).toString() : null), (r25 & 32) != 0 ? false : false, (r25 & 64) != 0 ? false : false, (r25 & 128) != 0 ? -1 : 0, (r25 & 256) != 0 ? "" : "fav", str);
        }
        myFavListActivity.F3().notifyDataSetChanged();
    }

    public static final void V3(MyFavListActivity myFavListActivity, View view) {
        t9.i.g(myFavListActivity, "this$0");
        myFavListActivity.p4(false);
    }

    public static final void W3(MyFavListActivity myFavListActivity, View view) {
        t9.i.g(myFavListActivity, "this$0");
        myFavListActivity.p4(true);
    }

    public static final void X3(MyFavListActivity myFavListActivity, View view) {
        t9.i.g(myFavListActivity, "this$0");
        myFavListActivity.finish();
    }

    public static final boolean d4(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    public static final ArrayList e4() {
        return new ArrayList();
    }

    public static final void f4(p pVar, Object obj, Object obj2) {
        t9.i.g(pVar, "$tmp0");
        pVar.invoke(obj, obj2);
    }

    public static final void g4(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void h4(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final t i4(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (t) lVar.invoke(obj);
    }

    public static final void j4(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final boolean y3(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    public static final Integer z3(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (Integer) lVar.invoke(obj);
    }

    public final d1 F3() {
        return (d1) this.f7946n.getValue();
    }

    @Override // f5.d
    /* renamed from: G3, reason: merged with bridge method [inline-methods] */
    public g1 S2() {
        g1 g1Var = this.f7945m;
        if (g1Var != null) {
            return g1Var;
        }
        t9.i.w("mPresenter");
        return null;
    }

    @Override // i6.z
    public void H0(List list, boolean z10) {
        t9.i.g(list, "favoriteList");
        if (this.f7944l != z10) {
            return;
        }
        LoadingDialog.Companion.hidden();
        ((SwipeRefreshLayout) t3(R$id.mMyFavRefreshLayout)).setVisibility(0);
        F3().setNewData(list);
        K3();
        if (this.f7947o) {
            ((TitleView) t3(R$id.myFavTitleView)).getTvMenuView().setVisibility(0);
        } else {
            ((TitleView) t3(R$id.myFavTitleView)).getIvMenuView().setVisibility(0);
        }
        if (this.f7948p) {
            int i10 = R$id.btnDelete;
            ((Button) t3(i10)).setBackgroundColor(getResources().getColor(R.color.color_666666));
            ((Button) t3(i10)).setClickable(false);
            ((ImageView) t3(R$id.itemAllCheckbox)).setImageResource(R.drawable.icon_no_select);
            this.f7949q = 0;
        }
    }

    public final boolean H3() {
        return this.f7948p;
    }

    @Override // i6.z
    public void I() {
        MainAty.A.o(false);
        xa.c.c().j(new CheckPwdSuccessEvent());
    }

    public final void I3() {
        t3(R$id.mIncludeBindNotification).setVisibility(8);
    }

    public final void J3() {
        t3(R$id.mIncludePassword).setVisibility(8);
        ((EditText) t3(R$id.mEditPassword)).getText().clear();
        ((TextView) t3(R$id.mTextErrorNotify)).setVisibility(8);
    }

    public final void K3() {
        ((KoocanEmptyView) t3(R$id.mMyFavLoadingView)).setVisibility(8);
        int i10 = R$id.mMyFavRefreshLayout;
        if (((SwipeRefreshLayout) t3(i10)) == null || !((SwipeRefreshLayout) t3(i10)).isRefreshing()) {
            return;
        }
        ((SwipeRefreshLayout) t3(i10)).setRefreshing(false);
    }

    public final void L3() {
        ((TextView) t3(R$id.mTvGotoBind)).setOnClickListener(new View.OnClickListener() { // from class: f5.q1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyFavListActivity.M3(MyFavListActivity.this, view);
            }
        });
        ((TextView) t3(R$id.mTextConfirm)).setOnClickListener(new View.OnClickListener() { // from class: f5.r1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyFavListActivity.N3(MyFavListActivity.this, view);
            }
        });
        ((TextView) t3(R$id.mTextForgetPassword)).setOnClickListener(new View.OnClickListener() { // from class: f5.s1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyFavListActivity.O3(MyFavListActivity.this, view);
            }
        });
    }

    public final void P3() {
        ((TextView) t3(R$id.mTvTabNormal)).setOnClickListener(new View.OnClickListener() { // from class: f5.g2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyFavListActivity.V3(MyFavListActivity.this, view);
            }
        });
        ((TextView) t3(R$id.mTvTabCR)).setOnClickListener(new View.OnClickListener() { // from class: f5.h2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyFavListActivity.W3(MyFavListActivity.this, view);
            }
        });
        ((SwipeRefreshLayout) t3(R$id.mMyFavRefreshLayout)).setOnRefreshListener(this);
        int i10 = R$id.myFavTitleView;
        ((TitleView) t3(i10)).setOnBackClickListener(new View.OnClickListener() { // from class: f5.i2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyFavListActivity.X3(MyFavListActivity.this, view);
            }
        });
        ((TitleView) t3(i10)).setIvMenuClickListener(new View.OnClickListener() { // from class: f5.j2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyFavListActivity.Q3(MyFavListActivity.this, view);
            }
        });
        ((TitleView) t3(i10)).setTvMenuClickListener(new View.OnClickListener() { // from class: f5.m1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyFavListActivity.R3(MyFavListActivity.this, view);
            }
        });
        ((AutoLinearLayout) t3(R$id.selectAllLayout)).setOnClickListener(new View.OnClickListener() { // from class: f5.n1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyFavListActivity.S3(MyFavListActivity.this, view);
            }
        });
        ((Button) t3(R$id.btnDelete)).setOnClickListener(new View.OnClickListener() { // from class: f5.o1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyFavListActivity.T3(MyFavListActivity.this, view);
            }
        });
        F3().setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: f5.p1
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                MyFavListActivity.U3(MyFavListActivity.this, baseQuickAdapter, view, i11);
            }
        });
    }

    @Override // f5.d
    public void R2() {
        l4(new g1(this, this));
        a4();
        Z3();
        ((SwipeRefreshLayout) t3(R$id.mMyFavRefreshLayout)).setColorSchemeResources(R.color.color_important);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        int i10 = R$id.mRecyclerFav;
        ((RecyclerView) t3(i10)).setLayoutManager(gridLayoutManager);
        ((RecyclerView) t3(i10)).addItemDecoration(new VerticalItemDecoration(Q1(), 0, AutoUtils.getPercentHeightSize(24)));
        ((RecyclerView) t3(i10)).setAdapter(F3());
        P3();
        L3();
        Y3();
    }

    @Override // f5.d
    public int T2() {
        return R.layout.activity_my_fav_list;
    }

    public final void Y3() {
        ((KoocanEmptyView) t3(R$id.mMyFavLoadingView)).setTextImageMarginTop(AutoUtils.getPercentHeightSize(186));
    }

    public final void Z3() {
        if (!t9.i.b(w6.i.f19214g.A(), "1")) {
            ((AutoLinearLayout) t3(R$id.mLlTab)).setVisibility(8);
        } else {
            ((AutoLinearLayout) t3(R$id.mLlTab)).setVisibility(0);
            ((TextView) t3(R$id.mTvTabNormal)).setSelected(true);
        }
    }

    @Override // i6.z
    public void a0(boolean z10) {
        if (this.f7944l != z10) {
            return;
        }
        LoadingDialog.Companion.hidden();
        int i10 = R$id.mMyFavRefreshLayout;
        ((SwipeRefreshLayout) t3(i10)).setVisibility(0);
        ((TitleView) t3(R$id.myFavTitleView)).getIvMenuView().setVisibility(8);
        int i11 = R$id.mMyFavLoadingView;
        ((KoocanEmptyView) t3(i11)).setVisibility(0);
        if (((SwipeRefreshLayout) t3(i10)) != null && ((SwipeRefreshLayout) t3(i10)).isRefreshing()) {
            ((SwipeRefreshLayout) t3(i10)).setRefreshing(false);
        }
        ((KoocanEmptyView) t3(i11)).changeType(KoocanEmptyView.Type.NO_CONTENT);
        KoocanEmptyView koocanEmptyView = (KoocanEmptyView) t3(i11);
        String string = getResources().getString(R.string.no_collect_favorite);
        t9.i.f(string, "resources.getString(R.string.no_collect_favorite)");
        koocanEmptyView.setTip(string);
        ((KoocanEmptyView) t3(i11)).setBackgroundDrawable(R.drawable.my_fave_empty);
    }

    public final void a4() {
        int i10 = R$id.myFavTitleView;
        ((TitleView) t3(i10)).getSettingView().setVisibility(8);
        ((TitleView) t3(i10)).getIvMenuView().setVisibility(8);
        ((TitleView) t3(i10)).setIvMenuSrc(R.drawable.icon_delete_history);
        ((TitleView) t3(i10)).getTvMenuView().setVisibility(8);
        ((TitleView) t3(i10)).setTvMenuText(b0.A(this, R.string.cancel));
    }

    public final void b4() {
        d6.b bVar = d6.b.f12660a;
        if (bVar.a() && (!bVar.c() || bVar.b() || bVar.d())) {
            o4();
        } else {
            m4();
        }
    }

    public final void c4() {
        this.f7947o = !this.f7947o;
        Observable fromIterable = Observable.fromIterable(F3().getData());
        final h hVar = h.f7960a;
        Observable filter = fromIterable.filter(new Predicate() { // from class: f5.t1
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean d42;
                d42 = MyFavListActivity.d4(s9.l.this, obj);
                return d42;
            }
        });
        Callable callable = new Callable() { // from class: f5.u1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                ArrayList e42;
                e42 = MyFavListActivity.e4();
                return e42;
            }
        };
        final i iVar = i.f7961a;
        Single compose = filter.collect(callable, new BiConsumer() { // from class: f5.v1
            @Override // io.reactivex.functions.BiConsumer
            public final void accept(Object obj, Object obj2) {
                MyFavListActivity.f4(s9.p.this, obj, obj2);
            }
        }).compose(O1());
        final j jVar = new j();
        Consumer consumer = new Consumer() { // from class: f5.x1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MyFavListActivity.g4(s9.l.this, obj);
            }
        };
        final k kVar = k.f7963a;
        compose.subscribe(consumer, new Consumer() { // from class: f5.y1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                MyFavListActivity.h4(s9.l.this, obj);
            }
        });
        if (!this.f7947o || F3().getData().size() == 0) {
            int i10 = R$id.myFavTitleView;
            ((TitleView) t3(i10)).getIvMenuView().setVisibility(0);
            ((TitleView) t3(i10)).getTvMenuView().setVisibility(8);
            ((AutoRelativeLayout) t3(R$id.mMyFavBottomLayout)).setVisibility(8);
            ((ImageView) t3(R$id.itemAllCheckbox)).setImageResource(R.drawable.icon_no_select);
            this.f7949q = 0;
            this.f7948p = false;
            Observable fromIterable2 = Observable.fromIterable(F3().getData());
            final l lVar = l.f7964a;
            Observable compose2 = fromIterable2.map(new Function() { // from class: f5.z1
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    h9.t i42;
                    i42 = MyFavListActivity.i4(s9.l.this, obj);
                    return i42;
                }
            }).compose(O1()).compose(p0.a());
            final m mVar = new m();
            compose2.subscribe(new Consumer() { // from class: f5.a2
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    MyFavListActivity.j4(s9.l.this, obj);
                }
            });
        } else {
            int i11 = R$id.myFavTitleView;
            ((TitleView) t3(i11)).getIvMenuView().setVisibility(8);
            ((TitleView) t3(i11)).getTvMenuView().setVisibility(0);
            ((AutoRelativeLayout) t3(R$id.mMyFavBottomLayout)).setVisibility(0);
        }
        F3().g(this.f7947o);
        F3().notifyDataSetChanged();
    }

    @xa.j
    public final void checkPwdSuccess(CheckPwdSuccessEvent checkPwdSuccessEvent) {
        t9.i.g(checkPwdSuccessEvent, "event");
        if (this.f7944l) {
            n4(true);
        }
    }

    @Override // i6.z
    public void e1(String str, boolean z10) {
        t9.i.g(str, "returnCode");
        if (this.f7944l != z10) {
            return;
        }
        LoadingDialog.Companion.hidden();
        ((SwipeRefreshLayout) t3(R$id.mMyFavRefreshLayout)).setVisibility(0);
        ((TitleView) t3(R$id.myFavTitleView)).getIvMenuView().setVisibility(8);
        int i10 = R$id.mMyFavLoadingView;
        ((KoocanEmptyView) t3(i10)).changeType(KoocanEmptyView.Type.NO_DISCUSS);
        ((KoocanEmptyView) t3(i10)).setVisibility(0);
        KoocanEmptyView koocanEmptyView = (KoocanEmptyView) t3(i10);
        String string = getResources().getString(R.string.fav_record_failde);
        t9.i.f(string, "resources.getString(R.string.fav_record_failde)");
        koocanEmptyView.setTip(string);
    }

    @Override // i5.a
    public void k2() {
        n2();
    }

    public final void k4(int i10) {
        this.f7949q = i10;
    }

    public void l4(g1 g1Var) {
        t9.i.g(g1Var, "<set-?>");
        this.f7945m = g1Var;
    }

    public final void m4() {
        t3(R$id.mIncludeBindNotification).setVisibility(0);
        t3(R$id.mIncludePassword).setVisibility(8);
        ((ImageView) t3(R$id.mIvClose)).setVisibility(4);
    }

    public final void n4(boolean z10) {
        LoadingDialog.Companion.show(getFragmentManager());
        ((SwipeRefreshLayout) t3(R$id.mMyFavRefreshLayout)).setVisibility(8);
        K3();
        I3();
        J3();
        List m10 = z10 ? S2().m() : S2().n();
        if (m10 == null) {
            S2().d(z10);
        } else if (m10.isEmpty()) {
            a0(z10);
        } else {
            H0(m10, z10);
        }
    }

    public final void o4() {
        ((EditText) t3(R$id.mEditPassword)).getText().clear();
        ((TextView) t3(R$id.mTextErrorNotify)).setVisibility(8);
        t3(R$id.mIncludeBindNotification).setVisibility(8);
        t3(R$id.mIncludePassword).setVisibility(0);
        ((ImageView) t3(R$id.mImageClose)).setVisibility(4);
    }

    @Override // com.mobile.brasiltv.view.dialog.DeleteConfirmDialog.ConfirmCallback
    public void onConfirm() {
        x3();
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
    public void onRefresh() {
        S2().d(this.f7944l);
    }

    public final void p4(boolean z10) {
        if (this.f7947o) {
            return;
        }
        if (z10) {
            int i10 = R$id.mTvTabCR;
            if (((TextView) t3(i10)).isSelected()) {
                return;
            }
            ((TextView) t3(i10)).setSelected(true);
            ((TextView) t3(R$id.mTvTabNormal)).setSelected(false);
            this.f7944l = true;
            if (MainAty.A.f()) {
                ((SwipeRefreshLayout) t3(R$id.mMyFavRefreshLayout)).setVisibility(8);
                K3();
                ((TitleView) t3(R$id.myFavTitleView)).getIvMenuView().setVisibility(8);
                b4();
                return;
            }
        } else {
            int i11 = R$id.mTvTabNormal;
            if (((TextView) t3(i11)).isSelected()) {
                return;
            }
            ((TextView) t3(i11)).setSelected(true);
            ((TextView) t3(R$id.mTvTabCR)).setSelected(false);
            this.f7944l = false;
        }
        n4(z10);
    }

    public View t3(int i10) {
        Map map = this.f7950r;
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

    public final void x3() {
        Observable fromIterable = Observable.fromIterable(F3().getData());
        final a aVar = new a();
        Observable filter = fromIterable.filter(new Predicate() { // from class: f5.l1
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean y32;
                y32 = MyFavListActivity.y3(s9.l.this, obj);
                return y32;
            }
        });
        final b bVar = b.f7952a;
        Observable map = filter.map(new Function() { // from class: f5.w1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                Integer z32;
                z32 = MyFavListActivity.z3(s9.l.this, obj);
                return z32;
            }
        });
        Callable callable = new Callable() { // from class: f5.c2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                ArrayList A3;
                A3 = MyFavListActivity.A3();
                return A3;
            }
        };
        final c cVar = c.f7953a;
        Single collect = map.collect(callable, new BiConsumer() { // from class: f5.d2
            @Override // io.reactivex.functions.BiConsumer
            public final void accept(Object obj, Object obj2) {
                MyFavListActivity.B3(s9.p.this, obj, obj2);
            }
        });
        final d dVar = d.f7954a;
        collect.filter(new Predicate() { // from class: f5.e2
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean C3;
                C3 = MyFavListActivity.C3(s9.l.this, obj);
                return C3;
            }
        }).flatMapObservable(new Function() { // from class: f5.f2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                ObservableSource D3;
                D3 = MyFavListActivity.D3(MyFavListActivity.this, (ArrayList) obj);
                return D3;
            }
        }).compose(O1()).subscribe(new f());
    }

    @Override // i6.z
    public void y(boolean z10) {
        if (z10) {
            LoadingDialog.Companion.show(getFragmentManager());
        } else {
            LoadingDialog.Companion.hidden();
        }
    }
}
