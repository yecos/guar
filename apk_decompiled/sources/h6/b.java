package h6;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.RecyclerView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.bean.event.CouponQualificationEvent;
import com.mobile.brasiltv.mine.activity.AccountBindAty;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.view.LinearLayoutManagerWrapper;
import com.mobile.brasiltv.view.dialog.CommonAlertDialog;
import com.mobile.brasiltv.view.dialog.ICommonAlertCallback;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;
import h9.g;
import h9.h;
import h9.t;
import j6.a;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import l6.q;
import mobile.com.requestframe.utils.response.CouponCodeList;
import org.greenrobot.eventbus.ThreadMode;
import s9.l;
import t9.i;
import t9.j;
import w6.i;

/* loaded from: classes.dex */
public final class b extends b6.e<q> implements j6.b {

    /* renamed from: i, reason: collision with root package name */
    public q f14194i;

    /* renamed from: l, reason: collision with root package name */
    public g7.f f14197l;

    /* renamed from: n, reason: collision with root package name */
    public Map f14199n = new LinkedHashMap();

    /* renamed from: j, reason: collision with root package name */
    public final g f14195j = h.b(d.f14203a);

    /* renamed from: k, reason: collision with root package name */
    public final g f14196k = h.b(e.f14204a);

    /* renamed from: m, reason: collision with root package name */
    public View.OnClickListener f14198m = new f();

    /* loaded from: classes3.dex */
    public static final class a extends j implements l {
        public a() {
            super(1);
        }

        public final void b(CouponCodeList couponCodeList) {
            i.g(couponCodeList, "it");
            b.this.m3(couponCodeList);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((CouponCodeList) obj);
            return t.f14242a;
        }
    }

    /* renamed from: h6.b$b, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class ViewOnClickListenerC0226b implements View.OnClickListener {
        public ViewOnClickListenerC0226b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.Q0();
        }
    }

    /* loaded from: classes3.dex */
    public static final class c implements ICommonAlertCallback {
        public c() {
        }

        @Override // com.mobile.brasiltv.view.dialog.ICommonAlertCallback
        public void onCancel(Dialog dialog) {
            i.g(dialog, "dialog");
            dialog.dismiss();
        }

        @Override // com.mobile.brasiltv.view.dialog.ICommonAlertCallback
        public void onConfirm(Dialog dialog) {
            i.g(dialog, "dialog");
            Context context = b.this.getContext();
            i.d(context);
            context.startActivity(new Intent(b.this.getContext(), (Class<?>) AccountBindAty.class));
            dialog.dismiss();
        }
    }

    /* loaded from: classes3.dex */
    public static final class d extends j implements s9.a {

        /* renamed from: a, reason: collision with root package name */
        public static final d f14203a = new d();

        public d() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final f6.b invoke() {
            return new f6.b();
        }
    }

    /* loaded from: classes3.dex */
    public static final class e extends j implements s9.a {

        /* renamed from: a, reason: collision with root package name */
        public static final e f14204a = new e();

        public e() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final f6.c invoke() {
            return new f6.c();
        }
    }

    /* loaded from: classes3.dex */
    public static final class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g7.f fVar = b.this.f14197l;
            if (fVar != null) {
                fVar.m();
            }
            b.this.a3().p();
        }
    }

    public static final void p3(b bVar) {
        i.g(bVar, "this$0");
        g7.f fVar = bVar.f14197l;
        if (!(fVar instanceof g7.b)) {
            fVar = null;
        }
        if (fVar != null) {
            fVar.a(1.0f);
        }
        bVar.f14197l = null;
    }

    @Override // j6.b
    public void C() {
        ((ProgressBar) g3(R$id.mLoadingView)).setVisibility(8);
        ((AutoLinearLayout) g3(R$id.mLLEmpty)).setVisibility(0);
        ((RecyclerView) g3(R$id.mList)).setVisibility(8);
    }

    @Override // j6.b
    public void E2() {
        g7.f fVar = this.f14197l;
        if (fVar != null) {
            fVar.dismiss();
        }
        a.C0239a.a(a3(), null, 1, null);
        i.c cVar = w6.i.f19214g;
        cVar.i0(false);
        cVar.r0(0);
        cVar.a(getContext());
    }

    @Override // j6.b
    public void K1(List list) {
        if ((list != null ? list.size() : 0) <= 0) {
            C();
        } else {
            n3();
            j3().setNewData(list);
        }
    }

    @Override // j6.b
    public void Q0() {
        if (w6.i.f19214g.M()) {
            String string = getResources().getString(R.string.coupons_available_pop_title);
            t9.i.f(string, "resources.getString(R.st…pons_available_pop_title)");
            g7.f fVar = new g7.f(Z2(), string, k3());
            fVar.j();
            fVar.l();
            String string2 = getResources().getString(R.string.coupons_available_pop_btn_title);
            t9.i.f(string2, "resources.getString(R.st…_available_pop_btn_title)");
            fVar.k(string2);
            fVar.i(this.f14198m);
            Z2().getWindow().addFlags(2);
            fVar.c(true);
            this.f14197l = fVar;
            fVar.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: h6.a
                @Override // android.widget.PopupWindow.OnDismissListener
                public final void onDismiss() {
                    b.p3(b.this);
                }
            });
        }
    }

    @Override // k5.a
    public void T2() {
    }

    @Override // b6.e, b6.f
    public void X2() {
        this.f14199n.clear();
    }

    @Override // b6.e
    public void Y2() {
        int i10 = R$id.mList;
        ((RecyclerView) g3(i10)).setLayoutManager(new LinearLayoutManagerWrapper(getActivity()));
        j3().bindToRecyclerView((RecyclerView) g3(i10));
        j3().e(new a());
        ((AutoRelativeLayout) g3(R$id.mCouponAvailableLayout)).setOnClickListener(new ViewOnClickListenerC0226b());
    }

    @Override // b6.e
    public int c3() {
        return R.layout.frag_coupons;
    }

    public View g3(int i10) {
        View findViewById;
        Map map = this.f14199n;
        View view = (View) map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null || (findViewById = view2.findViewById(i10)) == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    @Override // j6.b
    public void h() {
        ((ProgressBar) g3(R$id.mLoadingView)).setVisibility(0);
        ((AutoLinearLayout) g3(R$id.mLLEmpty)).setVisibility(8);
        ((RecyclerView) g3(R$id.mList)).setVisibility(8);
    }

    public final f6.b j3() {
        return (f6.b) this.f14195j.getValue();
    }

    public final f6.c k3() {
        return (f6.c) this.f14196k.getValue();
    }

    @Override // b6.e
    /* renamed from: l3, reason: merged with bridge method [inline-methods] */
    public q a3() {
        q qVar = this.f14194i;
        if (qVar != null) {
            return qVar;
        }
        t9.i.w("mPresenter");
        return null;
    }

    public final void m3(CouponCodeList couponCodeList) {
        if (!d6.b.f12660a.y()) {
            i.c cVar = w6.i.f19214g;
            if (cVar.g().length() > 0) {
                b0.k0(this, cVar.g() + "&packageCode=" + couponCodeList.getPackageCode() + "&couponId=" + couponCodeList.getId(), false, true, false, 8, null);
                return;
            }
            return;
        }
        if (getActivity() != null) {
            androidx.fragment.app.e activity = getActivity();
            t9.i.d(activity);
            String string = getResources().getString(R.string.bind_account_use_coupons);
            t9.i.f(string, "resources.getString(R.st…ind_account_use_coupons )");
            String string2 = getResources().getString(R.string.cancel);
            t9.i.f(string2, "resources.getString(R.string.cancel)");
            String string3 = getResources().getString(R.string.now_bind);
            t9.i.f(string3, "resources.getString(R.string.now_bind)");
            new CommonAlertDialog(activity, string, string2, string3).setCommonAlertCallback(new c()).show();
        }
    }

    public final void n3() {
        ((ProgressBar) g3(R$id.mLoadingView)).setVisibility(8);
        ((AutoLinearLayout) g3(R$id.mLLEmpty)).setVisibility(8);
        ((RecyclerView) g3(R$id.mList)).setVisibility(0);
    }

    @Override // j6.b
    public void o1(List list) {
        k3().setNewData(list);
    }

    public void o3(q qVar) {
        t9.i.g(qVar, "<set-?>");
        this.f14194i = qVar;
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void onCouponQualificationEvent(CouponQualificationEvent couponQualificationEvent) {
        t9.i.g(couponQualificationEvent, "event");
        s1();
    }

    @Override // b6.e, u8.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        o3(new q(this, this));
        xa.c.c().o(this);
    }

    @Override // b6.e, u8.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        xa.c.c().r(this);
        super.onDestroy();
    }

    @Override // b6.e, b6.f, u8.b, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        X2();
    }

    @Override // u8.b, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (w6.i.f19214g.M()) {
            a3().f("1");
        } else {
            a.C0239a.a(a3(), null, 1, null);
        }
    }

    @Override // j6.b
    public void s1() {
        if (w6.i.f19214g.M()) {
            ((AutoRelativeLayout) g3(R$id.mCouponAvailableLayout)).setVisibility(0);
        } else {
            ((AutoRelativeLayout) g3(R$id.mCouponAvailableLayout)).setVisibility(8);
        }
    }

    @Override // j6.b
    public void t2(String str) {
        t9.i.g(str, "errorCode");
        if (t9.i.b(str, "success")) {
            String string = getResources().getString(R.string.coupons_retrieve_success);
            t9.i.f(string, "resources.getString(R.st…coupons_retrieve_success)");
            f1.f8649a.k(getContext(), string, 1);
        } else if (t9.i.b(str, "failed")) {
            if (w6.i.f19214g.B() > 2) {
                String string2 = getResources().getString(R.string.coupons_retrieve_failed_again);
                t9.i.f(string2, "resources.getString(R.st…ns_retrieve_failed_again)");
                f1.f8649a.k(getContext(), string2, 1);
            } else {
                String string3 = getResources().getString(R.string.coupons_retrieve_failed);
                t9.i.f(string3, "resources.getString(R.st….coupons_retrieve_failed)");
                f1.f8649a.k(getContext(), string3, 1);
            }
            g7.f fVar = this.f14197l;
            if (fVar != null) {
                fVar.h();
            }
        }
    }
}
