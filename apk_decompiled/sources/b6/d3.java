package b6;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.MainAty;
import com.mobile.brasiltv.activity.MsgBoxAty;
import com.mobile.brasiltv.activity.MyFavListActivity;
import com.mobile.brasiltv.activity.RecordsAty;
import com.mobile.brasiltv.activity.SubtitleAty;
import com.mobile.brasiltv.bean.BaseGuideManager;
import com.mobile.brasiltv.bean.event.HasNewUpdateEvent;
import com.mobile.brasiltv.bean.event.UpdateMineViewEvent;
import com.mobile.brasiltv.bean.event.UpdateRestrictEvent;
import com.mobile.brasiltv.db.Album;
import com.mobile.brasiltv.mine.activity.AccountAty;
import com.mobile.brasiltv.mine.activity.AccountBindAty;
import com.mobile.brasiltv.mine.activity.SettingAty;
import com.mobile.brasiltv.view.LoadingDialog;
import com.mobile.brasiltv.view.dialog.BindEmailOrPhoneNotification;
import com.mobile.brasiltv.view.dialog.CommTipsDialog;
import com.mobile.brasiltv.view.dialog.DialogManager;
import com.mobile.brasiltv.view.dialog.GuideDialog;
import com.mobile.brasiltv.view.dialog.RestrictOpenTipsDialog;
import com.mobile.brasiltv.view.dialog.StandardDialog;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;
import g5.z0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.ThreadMode;
import w6.i;

/* loaded from: classes.dex */
public final class d3 extends e<l6.m1> implements j6.i {

    /* renamed from: i, reason: collision with root package name */
    public boolean f4683i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f4684j;

    /* renamed from: k, reason: collision with root package name */
    public l6.m1 f4685k;

    /* renamed from: m, reason: collision with root package name */
    public StandardDialog f4687m;

    /* renamed from: n, reason: collision with root package name */
    public RestrictOpenTipsDialog f4688n;

    /* renamed from: q, reason: collision with root package name */
    public Map f4691q = new LinkedHashMap();

    /* renamed from: l, reason: collision with root package name */
    public final h9.g f4686l = h9.h.b(new a());

    /* renamed from: o, reason: collision with root package name */
    public final h9.g f4689o = h9.h.b(new d());

    /* renamed from: p, reason: collision with root package name */
    public boolean f4690p = true;

    /* loaded from: classes3.dex */
    public static final class a extends t9.j implements s9.a {
        public a() {
            super(0);
        }

        @Override // s9.a
        public final Integer invoke() {
            return Integer.valueOf(n5.a.f17268a.a(d3.this.getActivity()));
        }
    }

    /* loaded from: classes3.dex */
    public static final class b implements z0.a {
        public b() {
        }

        @Override // g5.z0.a
        public void a(Album album, int i10) {
            t9.i.g(album, "album");
            androidx.fragment.app.e activity = d3.this.getActivity();
            t9.i.e(activity, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
            com.mobile.brasiltv.utils.b0.q((f5.c) activity, album, "history");
        }
    }

    /* loaded from: classes3.dex */
    public static final class c extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final c f4694a = new c();

        public c() {
            super(1);
        }

        public final void b(CommTipsDialog commTipsDialog) {
            t9.i.g(commTipsDialog, "it");
            commTipsDialog.dismiss();
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((CommTipsDialog) obj);
            return h9.t.f14242a;
        }
    }

    /* loaded from: classes3.dex */
    public static final class d extends t9.j implements s9.a {
        public d() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final g5.z0 invoke() {
            Context requireContext = d3.this.requireContext();
            t9.i.f(requireContext, "requireContext()");
            return new g5.z0(requireContext, new ArrayList());
        }
    }

    public static final void A3(d3 d3Var, View view) {
        t9.i.g(d3Var, "this$0");
        com.mobile.brasiltv.utils.b0.a0(d3Var, SubtitleAty.class);
    }

    public static final void B3(d3 d3Var, View view) {
        t9.i.g(d3Var, "this$0");
        com.mobile.brasiltv.utils.i1.I(d3Var.getContext(), "personal");
        com.mobile.brasiltv.utils.b0.k0(d3Var, w6.i.f19214g.C() + "/#/shareApp", false, true, false, 8, null);
    }

    public static final void C3(d3 d3Var, View view) {
        t9.i.g(d3Var, "this$0");
        com.mobile.brasiltv.utils.b0.a0(d3Var, MyFavListActivity.class);
    }

    public static final void D3(d3 d3Var, View view) {
        t9.i.g(d3Var, "this$0");
        com.mobile.brasiltv.utils.b0.a0(d3Var, RecordsAty.class);
    }

    public static final void E3(d3 d3Var, View view) {
        t9.i.g(d3Var, "this$0");
        com.mobile.brasiltv.utils.b0.a0(d3Var, AccountAty.class);
    }

    public static final void F3(d3 d3Var, View view) {
        t9.i.g(d3Var, "this$0");
        com.mobile.brasiltv.utils.b0.a0(d3Var, AccountAty.class);
    }

    public static final void G3(d3 d3Var, View view) {
        t9.i.g(d3Var, "this$0");
        if (!t9.i.b(w6.i.f19214g.A(), "0")) {
            xa.c.c().m(new UpdateRestrictEvent("0", false, 2, null));
            androidx.fragment.app.e activity = d3Var.getActivity();
            t9.i.d(activity);
            String string = d3Var.getString(R.string.cr_content_blocked);
            t9.i.f(string, "getString(R.string.cr_content_blocked)");
            new CommTipsDialog(activity, string, null, d3Var.getString(R.string.i_see), null, null, c.f4694a, null, false, 180, null).show();
            d3Var.a3().v();
            MainAty.A.o(true);
            return;
        }
        d6.b bVar = d6.b.f12660a;
        if (bVar.a() && (!bVar.c() || bVar.b())) {
            Context context = d3Var.getContext();
            t9.i.d(context);
            new g6.g(context).show();
        } else {
            Context context2 = d3Var.getContext();
            if (context2 != null) {
                new BindEmailOrPhoneNotification(context2).show();
            }
        }
    }

    public static final void H3(d3 d3Var, View view) {
        t9.i.g(d3Var, "this$0");
        i.c cVar = w6.i.f19214g;
        com.mobile.brasiltv.utils.b0.k0(d3Var, com.mobile.brasiltv.utils.b0.x(m7.c.g()) + "/#/app-help?isFree=" + t9.i.b(cVar.e(), "0") + "&appId=" + na.a.g() + "&userId=" + cVar.H() + "&lang=" + com.mobile.brasiltv.utils.f0.a() + "&appVersion=" + na.a.b() + "&timestamp=" + new Date().getTime() + "&portalCode=" + cVar.v(), false, true, false, 8, null);
    }

    public static final void I3(d3 d3Var, View view) {
        t9.i.g(d3Var, "this$0");
        com.mobile.brasiltv.utils.b0.a0(d3Var, SettingAty.class);
    }

    public static final void K3(d3 d3Var) {
        t9.i.g(d3Var, "this$0");
        if (DialogManager.INSTANCE.isDialogShowing()) {
            return;
        }
        Context context = d3Var.getContext();
        ImageView imageView = (ImageView) d3Var.t3(R$id.mIvAdultContent);
        String string = d3Var.getString(R.string.guide_mine_block_des);
        t9.i.f(string, "getString(R.string.guide_mine_block_des)");
        new BaseGuideManager(context, imageView, "keyFirstMineOnCharge", string, GuideDialog.Direction.TOP_RIGHT, null, false, false, null, 480, null).showGuide();
    }

    public static final void N3(d3 d3Var, View view) {
        t9.i.g(d3Var, "this$0");
        StandardDialog standardDialog = d3Var.f4687m;
        if (standardDialog != null) {
            com.mobile.brasiltv.utils.b0.j(standardDialog);
        }
    }

    public static final void O3(d3 d3Var, View view) {
        t9.i.g(d3Var, "this$0");
        StandardDialog standardDialog = d3Var.f4687m;
        if (standardDialog != null) {
            com.mobile.brasiltv.utils.b0.j(standardDialog);
        }
        d3Var.startActivity(new Intent(d3Var.getActivity(), (Class<?>) AccountBindAty.class));
    }

    public static final void y3(d3 d3Var, View view) {
        t9.i.g(d3Var, "this$0");
        com.mobile.brasiltv.utils.b0.a0(d3Var, RecordsAty.class);
    }

    public static final void z3(d3 d3Var, View view) {
        t9.i.g(d3Var, "this$0");
        com.mobile.brasiltv.utils.b0.a0(d3Var, MsgBoxAty.class);
    }

    @Override // j6.i
    public void A2(int i10) {
        int i11 = R$id.mTvMsgCount;
        ((TextView) t3(i11)).setVisibility(0);
        ((TextView) t3(i11)).setText(i10 >= 100 ? "99+" : String.valueOf(i10));
    }

    @Override // j6.i
    public void F(List list) {
        t9.i.g(list, "list");
        ((RecyclerView) t3(R$id.mRvContent)).setVisibility(0);
        ((AutoRelativeLayout) t3(R$id.mRlHistoryList)).setVisibility(0);
        u3().b(list);
    }

    public final void J3() {
        L3();
        x3();
    }

    public final void L3() {
        R3();
        i.c cVar = w6.i.f19214g;
        if (TextUtils.isEmpty(cVar.q())) {
            ((ImageView) t3(R$id.mImageAvatar)).setImageResource(R.drawable.icon_mine_avatar_new);
        } else {
            a7.e eVar = a7.e.f288a;
            Context context = getContext();
            t9.i.d(context);
            String q10 = cVar.q();
            ImageView imageView = (ImageView) t3(R$id.mImageAvatar);
            t9.i.f(imageView, "mImageAvatar");
            eVar.b(context, q10, imageView, R.drawable.icon_mine_avatar_new);
        }
        if (!this.f4683i) {
            S3();
        }
        W3();
        P3();
        ((ImageView) t3(R$id.mIvAdultContent)).setSelected(!t9.i.b(cVar.A(), "0"));
        V3();
        int i10 = R$id.mRvContent;
        ((RecyclerView) t3(i10)).setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        ((RecyclerView) t3(i10)).setAdapter(u3());
    }

    public void M3(l6.m1 m1Var) {
        t9.i.g(m1Var, "<set-?>");
        this.f4685k = m1Var;
    }

    public final void P3() {
        i.c cVar = w6.i.f19214g;
        if (t9.i.b(cVar.I(), "1")) {
            return;
        }
        t9.i.b(cVar.D(), "0");
    }

    public final void Q3() {
        a3().k();
        a3().p();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00b3, code lost:
    
        if (r1.equals(com.titans.entity.CdnType.DIGITAL_TYPE_PCDN) == false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00d3, code lost:
    
        if (r5.t().length() != 0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00d6, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00d7, code lost:
    
        if (r3 == false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00da, code lost:
    
        r1 = r5.t().length() - 3;
        ((android.widget.TextView) t3(com.mobile.brasiltv.R$id.mTvUserNameNew)).setText(ba.t.I(r5.t(), r1 - 3, r1, "***").toString());
        ((android.widget.TextView) t3(r0)).setVisibility(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00bd, code lost:
    
        if (r1.equals("4") == false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00c7, code lost:
    
        if (r1.equals("3") == false) goto L47;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void R3() {
        /*
            Method dump skipped, instructions count: 412
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b6.d3.R3():void");
    }

    public final void S3() {
        this.f4683i = false;
        d6.b.f12660a.y();
    }

    @Override // k5.a
    public void T2() {
        ((ImageView) t3(R$id.mIvAdultContent)).post(new Runnable() { // from class: b6.v2
            @Override // java.lang.Runnable
            public final void run() {
                d3.K3(d3.this);
            }
        });
    }

    public final void T3() {
    }

    public final void U3() {
    }

    @xa.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void UpdateMineView(UpdateMineViewEvent updateMineViewEvent) {
        t9.i.g(updateMineViewEvent, "event");
        k7.f.e("更新个人中心页面: " + Q2(), new Object[0]);
        if (Q2()) {
            L3();
        }
    }

    @xa.j(sticky = true, threadMode = ThreadMode.MAIN)
    public final void UpdateRestrict(UpdateRestrictEvent updateRestrictEvent) {
        RestrictOpenTipsDialog restrictOpenTipsDialog;
        t9.i.g(updateRestrictEvent, "event");
        i.c cVar = w6.i.f19214g;
        cVar.q0(updateRestrictEvent.getStatus());
        boolean z10 = false;
        if (t9.i.b(cVar.A(), "0")) {
            ((ImageView) t3(R$id.mIvAdultContent)).setSelected(false);
            return;
        }
        ((ImageView) t3(R$id.mIvAdultContent)).setSelected(true);
        if (updateRestrictEvent.isSwitchOpen()) {
            RestrictOpenTipsDialog restrictOpenTipsDialog2 = this.f4688n;
            if (restrictOpenTipsDialog2 != null && restrictOpenTipsDialog2.isShowing()) {
                z10 = true;
            }
            if (z10 && (restrictOpenTipsDialog = this.f4688n) != null) {
                restrictOpenTipsDialog.dismiss();
            }
            Context context = getContext();
            t9.i.d(context);
            RestrictOpenTipsDialog restrictOpenTipsDialog3 = new RestrictOpenTipsDialog(context);
            this.f4688n = restrictOpenTipsDialog3;
            restrictOpenTipsDialog3.show();
        }
    }

    @Override // k5.a
    public void V2() {
        super.V2();
        if (Q2()) {
            a3().u();
        }
    }

    public final void V3() {
        if (this.f4684j) {
            t3(R$id.viewUpgradeDot).setVisibility(0);
        } else {
            t3(R$id.viewUpgradeDot).setVisibility(8);
        }
    }

    public final void W3() {
        d6.b bVar = d6.b.f12660a;
        if (bVar.y()) {
            Y3();
            return;
        }
        if (bVar.p()) {
            T3();
        } else if (bVar.q()) {
            U3();
        } else if (bVar.x()) {
            X3();
        }
    }

    @Override // b6.e, b6.f
    public void X2() {
        this.f4691q.clear();
    }

    public final void X3() {
    }

    @Override // b6.e
    public void Y2() {
        J3();
    }

    public final void Y3() {
    }

    @Override // b6.e
    public int c3() {
        return R.layout.frag_mine1;
    }

    @Override // j6.i
    public void l() {
        ((RecyclerView) t3(R$id.mRvContent)).setVisibility(8);
        ((AutoRelativeLayout) t3(R$id.mRlHistoryList)).setVisibility(8);
        u3().b(new ArrayList());
    }

    @Override // j6.i
    public void l1() {
        L3();
    }

    @Override // b6.e, u8.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        M3(new l6.m1(this, this));
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
    public void onStart() {
        super.onStart();
        a3().q();
        boolean z10 = this.f4690p;
        if (z10) {
            this.f4690p = !z10;
        } else if (S2()) {
            a3().u();
        }
    }

    @Override // j6.i
    public void s0() {
        if (getActivity() != null) {
            androidx.fragment.app.e activity = getActivity();
            t9.i.d(activity);
            if (activity.isFinishing()) {
                return;
            }
            androidx.fragment.app.e activity2 = getActivity();
            t9.i.d(activity2);
            StandardDialog standardDialog = new StandardDialog(activity2);
            this.f4687m = standardDialog;
            String string = getResources().getString(R.string.tips);
            t9.i.f(string, "resources.getString(R.string.tips)");
            t9.z zVar = t9.z.f18964a;
            String string2 = getResources().getString(R.string.bind_get_gift_days);
            t9.i.f(string2, "resources.getString(R.string.bind_get_gift_days)");
            String format = String.format(string2, Arrays.copyOf(new Object[]{w6.i.f19214g.x()}, 1));
            t9.i.f(format, "format(format, *args)");
            String string3 = getResources().getString(R.string.cancel);
            String string4 = getResources().getString(R.string.binding_now);
            t9.i.f(string4, "resources.getString(R.string.binding_now)");
            standardDialog.setDialogConfig(string, format, string3, string4, new View.OnClickListener() { // from class: b6.p2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    d3.N3(d3.this, view);
                }
            }, new View.OnClickListener() { // from class: b6.u2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    d3.O3(d3.this, view);
                }
            });
            StandardDialog standardDialog2 = this.f4687m;
            if (standardDialog2 != null) {
                com.mobile.brasiltv.utils.b0.S(standardDialog2, DialogManager.DIALOG_NEW_BIND);
            }
        }
    }

    @Override // j6.i
    public void showLoading(boolean z10) {
        if (!z10) {
            LoadingDialog.Companion.hidden();
            return;
        }
        LoadingDialog.Companion companion = LoadingDialog.Companion;
        androidx.fragment.app.e activity = getActivity();
        companion.show(activity != null ? activity.getFragmentManager() : null);
    }

    @xa.j(sticky = true)
    public final void showUpdateNew(HasNewUpdateEvent hasNewUpdateEvent) {
        t9.i.g(hasNewUpdateEvent, "event");
        this.f4684j = hasNewUpdateEvent.getHas();
        if (Q2()) {
            V3();
        }
    }

    @Override // j6.i
    public void t1(boolean z10) {
    }

    public View t3(int i10) {
        View findViewById;
        Map map = this.f4691q;
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

    public final g5.z0 u3() {
        return (g5.z0) this.f4689o.getValue();
    }

    @Override // b6.e
    /* renamed from: v3, reason: merged with bridge method [inline-methods] */
    public l6.m1 a3() {
        l6.m1 m1Var = this.f4685k;
        if (m1Var != null) {
            return m1Var;
        }
        t9.i.w("mPresenter");
        return null;
    }

    public final void w3() {
        StandardDialog standardDialog;
        StandardDialog standardDialog2 = this.f4687m;
        boolean z10 = false;
        if (standardDialog2 != null && standardDialog2.isShowing()) {
            z10 = true;
        }
        if (!z10 || (standardDialog = this.f4687m) == null) {
            return;
        }
        com.mobile.brasiltv.utils.b0.j(standardDialog);
    }

    @Override // j6.i
    public void x1() {
        if (d6.b.f12660a.y()) {
            t9.i.b(w6.i.f19214g.e(), "1");
        }
    }

    @Override // j6.i
    public void x2() {
        ((TextView) t3(R$id.mTvMsgCount)).setVisibility(8);
    }

    public final void x3() {
        u3().d(new b());
        ((AutoRelativeLayout) t3(R$id.mRlHistoryList)).setOnClickListener(new View.OnClickListener() { // from class: b6.w2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d3.y3(d3.this, view);
            }
        });
        ((ImageView) t3(R$id.ivMessage)).setOnClickListener(new View.OnClickListener() { // from class: b6.y2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d3.z3(d3.this, view);
            }
        });
        ((AutoLinearLayout) t3(R$id.mLayoutFav)).setOnClickListener(new View.OnClickListener() { // from class: b6.z2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d3.C3(d3.this, view);
            }
        });
        ((AutoLinearLayout) t3(R$id.mLayoutHistory)).setOnClickListener(new View.OnClickListener() { // from class: b6.a3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d3.D3(d3.this, view);
            }
        });
        ((AutoLinearLayout) t3(R$id.mLlAccount)).setOnClickListener(new View.OnClickListener() { // from class: b6.b3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d3.E3(d3.this, view);
            }
        });
        ((ImageView) t3(R$id.mCollapsingToolbarNew).findViewById(R$id.mImageAvatar)).setOnClickListener(new View.OnClickListener() { // from class: b6.c3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d3.F3(d3.this, view);
            }
        });
        ImageView imageView = (ImageView) t3(R$id.mIvAdultContent);
        t9.i.f(imageView, "mIvAdultContent");
        com.mobile.brasiltv.utils.b0.P(imageView, new View.OnClickListener() { // from class: b6.q2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d3.G3(d3.this, view);
            }
        });
        ((AutoLinearLayout) t3(R$id.mLlHelp)).setOnClickListener(new View.OnClickListener() { // from class: b6.r2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d3.H3(d3.this, view);
            }
        });
        ((AutoLinearLayout) t3(R$id.mRlSetting)).setOnClickListener(new View.OnClickListener() { // from class: b6.s2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d3.I3(d3.this, view);
            }
        });
        ((AutoLinearLayout) t3(R$id.mLlSubtitle)).setOnClickListener(new View.OnClickListener() { // from class: b6.t2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d3.A3(d3.this, view);
            }
        });
        ((AutoLinearLayout) t3(R$id.mLayoutShare)).setOnClickListener(new View.OnClickListener() { // from class: b6.x2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d3.B3(d3.this, view);
            }
        });
    }
}
