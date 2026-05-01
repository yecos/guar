package b6;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.MainAty;
import com.mobile.brasiltv.activity.ResetAty;
import com.mobile.brasiltv.bean.event.BannerAutoPlayEvent;
import com.mobile.brasiltv.bean.event.CheckPwdSuccessEvent;
import com.mobile.brasiltv.bean.event.VodPageRestartEvent;
import com.mobile.brasiltv.mine.activity.EmailAty;
import com.mobile.brasiltv.view.KoocanEmptyView;
import com.mobile.brasiltv.view.LinearLayoutManagerWrapper;
import com.mobile.brasiltv.view.LoadingDialog;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.utils.AutoUtils;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import mobile.com.requestframe.utils.response.ChildColumnList;
import org.greenrobot.eventbus.ThreadMode;
import w6.i;

/* loaded from: classes.dex */
public final class l extends e<l6.i> implements i6.j, SwipeRefreshLayout.j, p {

    /* renamed from: i, reason: collision with root package name */
    public l6.i f4767i;

    /* renamed from: l, reason: collision with root package name */
    public Map f4770l = new LinkedHashMap();

    /* renamed from: j, reason: collision with root package name */
    public final h9.g f4768j = h9.h.b(new a());

    /* renamed from: k, reason: collision with root package name */
    public final h9.g f4769k = h9.h.b(new b());

    /* loaded from: classes3.dex */
    public static final class a extends t9.j implements s9.a {
        public a() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ChildColumnList invoke() {
            Bundle arguments = l.this.getArguments();
            Serializable serializable = arguments != null ? arguments.getSerializable("fragment_bound_key") : null;
            t9.i.e(serializable, "null cannot be cast to non-null type mobile.com.requestframe.utils.response.ChildColumnList");
            return (ChildColumnList) serializable;
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends t9.j implements s9.a {
        public b() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final g5.k invoke() {
            return new g5.k(l.this.Z2(), l.this.m3());
        }
    }

    public static final void t3(l lVar, View view) {
        t9.i.g(lVar, "this$0");
        lVar.a3().J(lVar.m3());
        ((KoocanEmptyView) lVar.k3(R$id.mLoadingView)).changeType(KoocanEmptyView.Type.LOADING);
    }

    public static final void u3(l lVar, View view) {
        t9.i.g(lVar, "this$0");
        lVar.a3().J(lVar.m3());
        ((KoocanEmptyView) lVar.k3(R$id.mLoadingView)).changeType(KoocanEmptyView.Type.LOADING);
    }

    public static final void w3(l lVar, View view) {
        t9.i.g(lVar, "this$0");
        Context context = lVar.getContext();
        t9.i.e(context, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
        com.mobile.brasiltv.utils.b0.c0((f5.c) context, EmailAty.class);
    }

    public static final void x3(l lVar, View view) {
        t9.i.g(lVar, "this$0");
        int i10 = R$id.mEditPassword;
        Editable text = ((EditText) lVar.k3(i10)).getText();
        if (text == null || text.length() == 0) {
            return;
        }
        String obj = ba.t.W(((EditText) lVar.k3(i10)).getText().toString()).toString();
        if (com.mobile.brasiltv.utils.j1.f(obj)) {
            lVar.a3().w(obj);
            return;
        }
        int i11 = R$id.mTextErrorNotify;
        ((TextView) lVar.k3(i11)).setVisibility(0);
        TextView textView = (TextView) lVar.k3(i11);
        Context context = lVar.getContext();
        t9.i.d(context);
        textView.setText(context.getResources().getString(R.string.password_format_incorrect));
    }

    public static final void y3(l lVar, View view) {
        t9.i.g(lVar, "this$0");
        i.c cVar = w6.i.f19214g;
        if (t9.i.b(cVar.c(), "1") && !t9.i.b(cVar.h(), "1") && !t9.i.b(cVar.j(), "1")) {
            com.mobile.brasiltv.utils.f1.f8649a.w(R.string.mine_please_bind);
            return;
        }
        Intent intent = new Intent(lVar.getContext(), (Class<?>) ResetAty.class);
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
        Context context = lVar.getContext();
        if (context != null) {
            context.startActivity(intent);
        }
    }

    public final void A3() {
        k3(R$id.mIncludeBindNotication).setVisibility(0);
        k3(R$id.mIncludePassword).setVisibility(8);
        ((ImageView) k3(R$id.mIvClose)).setVisibility(4);
    }

    public final void B3() {
        ((SwipeRefreshLayout) k3(R$id.mRefreshLayout)).setVisibility(0);
        if (!S2() || t9.i.b(w6.i.f19214g.H(), "")) {
            return;
        }
        if (n3().getData().size() == 0) {
            ((KoocanEmptyView) k3(R$id.mLoadingView)).setVisibility(0);
            a3().J(m3());
        } else {
            n3().i(true);
        }
        ((RecyclerView) k3(R$id.mRvCr)).setVisibility(0);
    }

    public final void C3() {
        ((EditText) k3(R$id.mEditPassword)).getText().clear();
        ((TextView) k3(R$id.mTextErrorNotify)).setVisibility(8);
        k3(R$id.mIncludeBindNotication).setVisibility(8);
        k3(R$id.mIncludePassword).setVisibility(0);
        ((ImageView) k3(R$id.mImageClose)).setVisibility(4);
    }

    @Override // i6.j
    public void I() {
        MainAty.A.o(false);
        xa.c.c().j(new CheckPwdSuccessEvent());
    }

    @Override // k5.a
    public void T2() {
        if (getView() == null) {
            return;
        }
        if (MainAty.A.f()) {
            q3();
            s3();
        } else {
            p3();
            r3();
            B3();
        }
    }

    @Override // k5.a
    public void U2() {
        super.U2();
        if (Q2()) {
            n3().i(false);
        }
    }

    @Override // k5.a
    public void V2() {
        g5.k n32;
        super.V2();
        if (((RecyclerView) k3(R$id.mRvCr)) == null || (n32 = n3()) == null) {
            return;
        }
        n32.notifyDataSetChanged();
    }

    @Override // b6.e, b6.f
    public void X2() {
        this.f4770l.clear();
    }

    @Override // b6.e
    public void Y2() {
        int i10 = R$id.mRefreshLayout;
        ((SwipeRefreshLayout) k3(i10)).setColorSchemeResources(R.color.color_important);
        ((SwipeRefreshLayout) k3(i10)).setOnRefreshListener(this);
        ((SwipeRefreshLayout) k3(i10)).setDistanceToTriggerSync(AutoUtils.getPercentHeightSize(500));
        LinearLayoutManagerWrapper linearLayoutManagerWrapper = new LinearLayoutManagerWrapper(getActivity(), 1, false);
        int i11 = R$id.mRvCr;
        ((RecyclerView) k3(i11)).setLayoutManager(linearLayoutManagerWrapper);
        ((RecyclerView) k3(i11)).setHasFixedSize(true);
        ((RecyclerView) k3(i11)).setItemViewCacheSize(1);
        n3().bindToRecyclerView((RecyclerView) k3(i11));
        ((RecyclerView) k3(i11)).setOverScrollMode(2);
        ((RecyclerView) k3(i11)).setAdapter(n3());
        n3().z(getUserVisibleHint());
        v3();
    }

    @Override // i6.j
    public void a() {
        int i10 = R$id.mLoadingView;
        if (((KoocanEmptyView) k3(i10)) == null || ((SwipeRefreshLayout) k3(R$id.mRefreshLayout)).isRefreshing()) {
            return;
        }
        ((KoocanEmptyView) k3(i10)).changeType(KoocanEmptyView.Type.LOADING);
        ((KoocanEmptyView) k3(i10)).setVisibility(0);
    }

    @Override // i6.j
    public void b() {
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) k3(R$id.mRefreshLayout);
        if (swipeRefreshLayout != null && swipeRefreshLayout.isRefreshing()) {
            swipeRefreshLayout.setRefreshing(false);
        }
        if (n3().getData().size() != 0) {
            k();
            return;
        }
        int i10 = R$id.mLoadingView;
        if (((KoocanEmptyView) k3(i10)) != null) {
            ((KoocanEmptyView) k3(i10)).changeType(KoocanEmptyView.Type.NO_CONTENT);
            ((KoocanEmptyView) k3(i10)).setVisibility(0);
            ((KoocanEmptyView) k3(i10)).setOnClickListener(new View.OnClickListener() { // from class: b6.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    l.t3(l.this, view);
                }
            });
        }
    }

    @Override // i6.j
    public void c(String str) {
        t9.i.g(str, "errorCode");
        if (n3().getData().size() != 0) {
            k();
            return;
        }
        int i10 = R$id.mLoadingView;
        if (((KoocanEmptyView) k3(i10)) == null) {
            return;
        }
        ((KoocanEmptyView) k3(i10)).changeType(KoocanEmptyView.Type.NO_CONTENT);
        ((KoocanEmptyView) k3(i10)).setVisibility(0);
        ((AutoLinearLayout) ((KoocanEmptyView) k3(i10))._$_findCachedViewById(R$id.koocanEmptyContent)).setOnClickListener(new View.OnClickListener() { // from class: b6.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                l.u3(l.this, view);
            }
        });
    }

    @Override // b6.e
    public int c3() {
        return R.layout.frag_cr;
    }

    @xa.j
    public final void checkPwdSuccess(CheckPwdSuccessEvent checkPwdSuccessEvent) {
        t9.i.g(checkPwdSuccessEvent, "event");
        if (isVisible()) {
            p3();
            r3();
            B3();
        }
    }

    @Override // i6.j
    public void f(List list) {
        t9.i.g(list, "columnContentList");
        n3().setNewData(i9.r.G(list));
        k();
    }

    @Override // b6.p
    public void f1(boolean z10) {
        if (Q2()) {
            n3().A(z10);
        }
    }

    @Override // i6.j
    public void k() {
        int i10 = R$id.mLoadingView;
        if (((KoocanEmptyView) k3(i10)) != null) {
            ((KoocanEmptyView) k3(i10)).setVisibility(8);
        }
        int i11 = R$id.mRefreshLayout;
        if (((SwipeRefreshLayout) k3(i11)) == null || !((SwipeRefreshLayout) k3(i11)).isRefreshing()) {
            return;
        }
        ((SwipeRefreshLayout) k3(i11)).setRefreshing(false);
    }

    public View k3(int i10) {
        View findViewById;
        Map map = this.f4770l;
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

    public final ChildColumnList m3() {
        return (ChildColumnList) this.f4768j.getValue();
    }

    public final g5.k n3() {
        return (g5.k) this.f4769k.getValue();
    }

    @Override // b6.e
    /* renamed from: o3, reason: merged with bridge method [inline-methods] */
    public l6.i a3() {
        l6.i iVar = this.f4767i;
        if (iVar != null) {
            return iVar;
        }
        t9.i.w("mPresenter");
        return null;
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void onBannerAutoPlayEvent(BannerAutoPlayEvent bannerAutoPlayEvent) {
        t9.i.g(bannerAutoPlayEvent, "event");
        if (Q2() && S2()) {
            n3().i(bannerAutoPlayEvent.getAutoPlay());
        }
    }

    @Override // b6.e, u8.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        z3(new l6.i(this, this));
        xa.c.c().o(this);
    }

    @Override // b6.e, u8.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        xa.c.c().r(this);
    }

    @Override // b6.e, b6.f, u8.b, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        X2();
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
    public void onRefresh() {
        a3().J(m3());
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void onRestart(VodPageRestartEvent vodPageRestartEvent) {
        t9.i.g(vodPageRestartEvent, "event");
        if (isVisible()) {
            MainAty.a aVar = MainAty.A;
            if (aVar.f()) {
                q3();
                s3();
            } else {
                if (aVar.f() || ((SwipeRefreshLayout) k3(R$id.mRefreshLayout)).getVisibility() == 0) {
                    return;
                }
                p3();
                r3();
                B3();
            }
        }
    }

    public final void p3() {
        k3(R$id.mIncludeBindNotication).setVisibility(8);
    }

    public final void q3() {
        k();
        ((SwipeRefreshLayout) k3(R$id.mRefreshLayout)).setVisibility(8);
        ((RecyclerView) k3(R$id.mRvCr)).setVisibility(8);
    }

    @Override // i6.j
    public void r(int i10) {
        n3().notifyItemChanged(i10);
    }

    public final void r3() {
        k3(R$id.mIncludePassword).setVisibility(8);
        ((EditText) k3(R$id.mEditPassword)).getText().clear();
        ((TextView) k3(R$id.mTextErrorNotify)).setVisibility(8);
    }

    public final void s3() {
        d6.b bVar = d6.b.f12660a;
        if (bVar.a() && (!bVar.c() || bVar.b() || bVar.d())) {
            C3();
        } else {
            A3();
        }
    }

    @Override // k5.a, androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z10) {
        super.setUserVisibleHint(z10);
        if (Q2()) {
            n3().z(getUserVisibleHint());
        }
        if (getUserVisibleHint()) {
            return;
        }
        LoadingDialog.Companion.hidden();
    }

    public final void v3() {
        ((TextView) k3(R$id.mTvGotoBind)).setOnClickListener(new View.OnClickListener() { // from class: b6.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                l.w3(l.this, view);
            }
        });
        ((TextView) k3(R$id.mTextConfirm)).setOnClickListener(new View.OnClickListener() { // from class: b6.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                l.x3(l.this, view);
            }
        });
        ((TextView) k3(R$id.mTextForgetPassword)).setOnClickListener(new View.OnClickListener() { // from class: b6.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                l.y3(l.this, view);
            }
        });
    }

    @Override // i6.j
    public void y(boolean z10) {
        ((ProgressBar) k3(R$id.mLoadingPb)).setVisibility(z10 ? 0 : 8);
    }

    public void z3(l6.i iVar) {
        t9.i.g(iVar, "<set-?>");
        this.f4767i = iVar;
    }
}
