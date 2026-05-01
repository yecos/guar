package h6;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import androidx.recyclerview.widget.RecyclerView;
import b6.e;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.view.LinearLayoutManagerWrapper;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoLinearLayout;
import h9.g;
import h9.h;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import l6.s;
import t9.i;
import t9.j;

/* loaded from: classes3.dex */
public final class c extends e<s> implements j6.c {

    /* renamed from: i, reason: collision with root package name */
    public s f14206i;

    /* renamed from: k, reason: collision with root package name */
    public Map f14208k = new LinkedHashMap();

    /* renamed from: j, reason: collision with root package name */
    public final g f14207j = h.b(a.f14209a);

    public static final class a extends j implements s9.a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f14209a = new a();

        public a() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final f6.e invoke() {
            return new f6.e();
        }
    }

    @Override // j6.c
    public void C() {
        ((ProgressBar) f3(R$id.mLoadingView)).setVisibility(8);
        ((RecyclerView) f3(R$id.mList)).setVisibility(8);
        ((AutoLinearLayout) f3(R$id.mLLEmpty)).setVisibility(0);
    }

    @Override // k5.a
    public void T2() {
    }

    @Override // b6.e, b6.f
    public void X2() {
        this.f14208k.clear();
    }

    @Override // b6.e
    public void Y2() {
        int i10 = R$id.mList;
        ((RecyclerView) f3(i10)).setLayoutManager(new LinearLayoutManagerWrapper(getActivity()));
        g3().bindToRecyclerView((RecyclerView) f3(i10));
    }

    @Override // b6.e
    public int c3() {
        return R.layout.frag_exchange_record;
    }

    public View f3(int i10) {
        View findViewById;
        Map map = this.f14208k;
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

    public final f6.e g3() {
        return (f6.e) this.f14207j.getValue();
    }

    @Override // j6.c
    public void h() {
        ((ProgressBar) f3(R$id.mLoadingView)).setVisibility(0);
        ((RecyclerView) f3(R$id.mList)).setVisibility(8);
        ((AutoLinearLayout) f3(R$id.mLLEmpty)).setVisibility(8);
    }

    @Override // j6.c
    public void h2(List list) {
        if ((list != null ? list.size() : 0) <= 0) {
            C();
            return;
        }
        ((ProgressBar) f3(R$id.mLoadingView)).setVisibility(8);
        ((RecyclerView) f3(R$id.mList)).setVisibility(0);
        ((AutoLinearLayout) f3(R$id.mLLEmpty)).setVisibility(8);
        g3().setNewData(list);
    }

    @Override // b6.e
    /* renamed from: h3, reason: merged with bridge method [inline-methods] */
    public s a3() {
        s sVar = this.f14206i;
        if (sVar != null) {
            return sVar;
        }
        i.w("mPresenter");
        return null;
    }

    public void i3(s sVar) {
        i.g(sVar, "<set-?>");
        this.f14206i = sVar;
    }

    @Override // b6.e, u8.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        i3(new s(this, this));
    }

    @Override // b6.e, b6.f, u8.b, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        X2();
    }
}
