package com.mobile.brasiltv.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import b6.o;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.google.android.material.tabs.TabLayout;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.ColumnListAty;
import com.mobile.brasiltv.bean.RootColumnId;
import com.mobile.brasiltv.mine.activity.AccountBindAty;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.i1;
import com.mobile.brasiltv.utils.j1;
import com.mobile.brasiltv.view.FixGifStateDrawable;
import com.mobile.brasiltv.view.KoocanEmptyView;
import com.mobile.brasiltv.view.MarqueeTextView;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoRelativeLayout;
import com.zhy.autolayout.utils.AutoUtils;
import g5.x;
import h9.t;
import i6.l;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import k6.w;
import mobile.com.requestframe.utils.response.ChildColumnList;
import t9.i;
import t9.j;

/* loaded from: classes3.dex */
public final class ColumnListAty extends f5.d implements l {

    /* renamed from: w, reason: collision with root package name */
    public static boolean f7856w;

    /* renamed from: x, reason: collision with root package name */
    public static boolean f7857x;

    /* renamed from: m, reason: collision with root package name */
    public boolean f7860m;

    /* renamed from: o, reason: collision with root package name */
    public w f7862o;

    /* renamed from: t, reason: collision with root package name */
    public static final a f7853t = new a(null);

    /* renamed from: u, reason: collision with root package name */
    public static final String f7854u = "columnData";

    /* renamed from: v, reason: collision with root package name */
    public static final String f7855v = "position";

    /* renamed from: y, reason: collision with root package name */
    public static String f7858y = "iscr";

    /* renamed from: s, reason: collision with root package name */
    public Map f7866s = new LinkedHashMap();

    /* renamed from: l, reason: collision with root package name */
    public int f7859l = -1;

    /* renamed from: n, reason: collision with root package name */
    public final h9.g f7861n = h9.h.b(new d());

    /* renamed from: p, reason: collision with root package name */
    public final h9.g f7863p = h9.h.b(new c());

    /* renamed from: q, reason: collision with root package name */
    public final ArrayList f7864q = new ArrayList();

    /* renamed from: r, reason: collision with root package name */
    public final ArrayList f7865r = new ArrayList();

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(t9.g gVar) {
            this();
        }

        public final String a() {
            return ColumnListAty.f7854u;
        }

        public final boolean b() {
            return ColumnListAty.f7857x;
        }

        public final String c() {
            return ColumnListAty.f7858y;
        }

        public final String d() {
            return ColumnListAty.f7855v;
        }

        public final boolean e() {
            return ColumnListAty.f7856w;
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f7867a;

        /* renamed from: b, reason: collision with root package name */
        public final View f7868b;

        /* renamed from: c, reason: collision with root package name */
        public final Drawable f7869c;

        public b(String str, View view, Drawable drawable) {
            i.g(str, ParamsMap.MirrorParams.MIRROR_DOC_MODE);
            i.g(view, "view");
            this.f7867a = str;
            this.f7868b = view;
            this.f7869c = drawable;
        }

        public final Drawable a() {
            return this.f7869c;
        }

        public final String b() {
            return this.f7867a;
        }

        public final View c() {
            return this.f7868b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return i.b(this.f7867a, bVar.f7867a) && i.b(this.f7868b, bVar.f7868b) && i.b(this.f7869c, bVar.f7869c);
        }

        public int hashCode() {
            int hashCode = ((this.f7867a.hashCode() * 31) + this.f7868b.hashCode()) * 31;
            Drawable drawable = this.f7869c;
            return hashCode + (drawable == null ? 0 : drawable.hashCode());
        }

        public String toString() {
            return "TitleWrapperBean(text=" + this.f7867a + ", view=" + this.f7868b + ", stateIcon=" + this.f7869c + ASCIIPropertyListParser.ARRAY_END_TOKEN;
        }
    }

    public static final class c extends j implements s9.a {
        public c() {
            super(0);
        }

        @Override // s9.a
        public final Integer invoke() {
            return Integer.valueOf(n5.a.f17268a.a(ColumnListAty.this));
        }
    }

    public static final class d extends j implements s9.a {
        public d() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ChildColumnList invoke() {
            Serializable serializableExtra = ColumnListAty.this.getIntent().getSerializableExtra(ColumnListAty.f7853t.a());
            i.e(serializableExtra, "null cannot be cast to non-null type mobile.com.requestframe.utils.response.ChildColumnList");
            return (ChildColumnList) serializableExtra;
        }
    }

    public static final class e implements TabLayout.OnTabSelectedListener {
        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
        }
    }

    public static final class f implements ViewPager.j {
        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageScrollStateChanged(int i10) {
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageScrolled(int i10, float f10, int i11) {
        }

        @Override // androidx.viewpager.widget.ViewPager.j
        public void onPageSelected(int i10) {
        }
    }

    public static final class g implements KoocanEmptyView.ReloadListener {
        public g() {
        }

        @Override // com.mobile.brasiltv.view.KoocanEmptyView.ReloadListener
        public void onClick() {
            ColumnListAty.this.S2().l(ColumnListAty.this.g3());
        }
    }

    public static final class h extends j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f7873a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ColumnListAty f7874b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(List list, ColumnListAty columnListAty) {
            super(1);
            this.f7873a = list;
            this.f7874b = columnListAty;
        }

        public final void b(List list) {
            if (this.f7873a.size() == list.size()) {
                List list2 = this.f7873a;
                ColumnListAty columnListAty = this.f7874b;
                int i10 = 0;
                for (Object obj : list2) {
                    int i11 = i10 + 1;
                    if (i10 < 0) {
                        i9.j.j();
                    }
                    b bVar = (b) list.get(i10);
                    TabLayout.Tab tabAt = ((TabLayout) columnListAty.Z2(R$id.columnListTabLayout)).getTabAt(i10);
                    if (tabAt != null) {
                        tabAt.setText(bVar.b());
                    }
                    if (bVar.a() != null && tabAt != null) {
                        tabAt.setIcon(bVar.a());
                    }
                    if (tabAt != null) {
                        tabAt.setCustomView(bVar.c());
                    }
                    i10 = i11;
                }
            }
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((List) obj);
            return t.f14242a;
        }
    }

    public static final void j3(ColumnListAty columnListAty, View view) {
        i.g(columnListAty, "this$0");
        int currentItem = ((ViewPager) columnListAty.Z2(R$id.columnListViewPager)).getCurrentItem();
        if (columnListAty.f7864q.size() <= 0 || currentItem >= columnListAty.f7864q.size()) {
            return;
        }
        Object obj = columnListAty.f7864q.get(currentItem);
        i.e(obj, "null cannot be cast to non-null type com.mobile.brasiltv.fragment.ColumnListFrag");
        ((o) obj).u3();
    }

    public static final void k3(ColumnListAty columnListAty, View view) {
        i.g(columnListAty, "this$0");
        b0.c0(columnListAty, SearchAty.class);
    }

    public static final void n3(ColumnListAty columnListAty, View view) {
        i.g(columnListAty, "this$0");
        i1.N(columnListAty.Q1());
        b0.c0(columnListAty, AccountBindAty.class);
    }

    public static final List r3(List list, ColumnListAty columnListAty) {
        Drawable drawable;
        Drawable drawable2;
        i.g(list, "$t");
        i.g(columnListAty, "this$0");
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ChildColumnList childColumnList = (ChildColumnList) it.next();
            a7.d dVar = a7.d.f279a;
            String n10 = dVar.n(childColumnList.getPosterList(), dVar.g());
            String n11 = dVar.n(childColumnList.getPosterList(), dVar.h());
            View inflate = columnListAty.getLayoutInflater().inflate(R.layout.item_column_list_title, (ViewGroup) null);
            try {
                RequestManager with = Glide.with((androidx.fragment.app.e) columnListAty);
                boolean isEmpty = TextUtils.isEmpty(n10);
                Object obj = n10;
                if (!isEmpty) {
                    String a10 = a3.e.a(n10, "key_poster");
                    obj = a10 != null ? b0.W(a10) : null;
                } else if (n10 == null) {
                    obj = a3.e.a("", "key_poster");
                }
                drawable = with.load(obj).submit().get();
            } catch (Exception unused) {
                drawable = null;
            }
            try {
                RequestManager with2 = Glide.with((androidx.fragment.app.e) columnListAty);
                boolean isEmpty2 = TextUtils.isEmpty(n11);
                Object obj2 = n11;
                if (!isEmpty2) {
                    String a11 = a3.e.a(n11, "key_poster");
                    obj2 = a11 != null ? b0.W(a11) : null;
                } else if (n11 == null) {
                    obj2 = a3.e.a("", "key_poster");
                }
                drawable2 = with2.load(obj2).submit().get();
            } catch (Exception unused2) {
                drawable2 = null;
            }
            if (drawable == null || drawable2 == null) {
                String c10 = b0.c(childColumnList.getAlias(), childColumnList.getName());
                i.f(inflate, "inflate");
                arrayList.add(new b(c10, inflate, null));
            } else {
                ((ImageView) inflate.findViewById(android.R.id.icon)).getLayoutParams().width = (int) (drawable.getIntrinsicWidth() * (AutoUtils.getPercentHeightSize(40) / drawable.getIntrinsicHeight()));
                FixGifStateDrawable fixGifStateDrawable = new FixGifStateDrawable(drawable2, drawable);
                i.f(inflate, "inflate");
                arrayList.add(new b("", inflate, fixGifStateDrawable));
            }
        }
        return arrayList;
    }

    public static final void s3(s9.l lVar, Object obj) {
        i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    @Override // f5.d
    public void R2() {
        p3(new w(this, this));
        ViewGroup.LayoutParams layoutParams = ((AutoRelativeLayout) Z2(R$id.rl_column_list_title)).getLayoutParams();
        i.e(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ((LinearLayout.LayoutParams) layoutParams).setMargins(0, f3(), 0, 0);
        this.f7859l = getIntent().getIntExtra(f7855v, -1);
        this.f7860m = getIntent().getBooleanExtra(f7858y, false);
        f7856w = i.b(g3().getRestricted(), "1");
        f7857x = g3().getId() == RootColumnId.freeVodId;
        ((TextView) Z2(R$id.tv_title)).setText(b0.e(g3().getAlias(), g3().getName()));
        i3();
        l3();
        m3();
    }

    @Override // f5.d
    public int T2() {
        return R.layout.activity_column_list;
    }

    public View Z2(int i10) {
        Map map = this.f7866s;
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

    @Override // i6.l
    public void a() {
        ((KoocanEmptyView) Z2(R$id.column_loadingView)).setVisibility(0);
    }

    @Override // i6.l
    public void c(String str) {
        i.g(str, "errorCode");
        j1.h(this, str);
        int i10 = R$id.column_loadingView;
        ((KoocanEmptyView) Z2(i10)).setReloadListener(new g());
        ((KoocanEmptyView) Z2(i10)).setVisibility(0);
        ((KoocanEmptyView) Z2(i10)).changeType(KoocanEmptyView.Type.NO_WIFI);
    }

    @Override // i6.l
    public void f(List list) {
        i.g(list, "t");
        int i10 = 0;
        for (Object obj : list) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                i9.j.j();
            }
            ChildColumnList childColumnList = (ChildColumnList) obj;
            int i12 = R$id.columnListTabLayout;
            ((TabLayout) Z2(i12)).addTab(((TabLayout) Z2(i12)).newTab().setText(b0.c(childColumnList.getAlias(), childColumnList.getName())));
            this.f7865r.add(b0.c(childColumnList.getAlias(), childColumnList.getName()));
            o oVar = new o();
            int id = childColumnList.getId();
            StringBuilder sb = new StringBuilder();
            String alias = g3().getAlias();
            String str = "";
            if (alias == null) {
                alias = "";
            }
            sb.append(alias);
            sb.append('/');
            String alias2 = childColumnList.getAlias();
            if (alias2 != null) {
                str = alias2;
            }
            sb.append(str);
            o3(oVar, id, i10, sb.toString());
            this.f7864q.add(oVar);
            i10 = i11;
        }
        int i13 = R$id.columnListViewPager;
        ViewPager viewPager = (ViewPager) Z2(i13);
        ArrayList arrayList = this.f7864q;
        ArrayList arrayList2 = this.f7865r;
        androidx.fragment.app.o supportFragmentManager = getSupportFragmentManager();
        i.f(supportFragmentManager, "supportFragmentManager");
        viewPager.setAdapter(new x(arrayList, arrayList2, supportFragmentManager));
        int i14 = R$id.columnListTabLayout;
        ((TabLayout) Z2(i14)).setupWithViewPager((ViewPager) Z2(i13));
        q3(list);
        if (this.f7859l != -1) {
            TabLayout.Tab tabAt = ((TabLayout) Z2(i14)).getTabAt(this.f7859l);
            i.d(tabAt);
            tabAt.isSelected();
            ((ViewPager) Z2(i13)).setCurrentItem(this.f7859l);
        }
    }

    public final int f3() {
        return ((Number) this.f7863p.getValue()).intValue();
    }

    public ChildColumnList g3() {
        return (ChildColumnList) this.f7861n.getValue();
    }

    @Override // f5.d
    /* renamed from: h3, reason: merged with bridge method [inline-methods] */
    public w S2() {
        w wVar = this.f7862o;
        if (wVar != null) {
            return wVar;
        }
        i.w("mPresenter");
        return null;
    }

    public final void i3() {
        ((ImageView) Z2(R$id.iv_back)).setOnClickListener(this);
        ((AutoRelativeLayout) Z2(R$id.rl_column_list_title)).setOnClickListener(new View.OnClickListener() { // from class: f5.c0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ColumnListAty.j3(ColumnListAty.this, view);
            }
        });
        ((ImageView) Z2(R$id.mVodImageSearch)).setOnClickListener(new View.OnClickListener() { // from class: f5.d0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ColumnListAty.k3(ColumnListAty.this, view);
            }
        });
        ((TabLayout) Z2(R$id.columnListTabLayout)).addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new e());
        ((ViewPager) Z2(R$id.columnListViewPager)).addOnPageChangeListener(new f());
    }

    @Override // i6.l
    public void k() {
        ((KoocanEmptyView) Z2(R$id.column_loadingView)).setVisibility(8);
    }

    @Override // i5.a
    public void k2() {
        n2();
    }

    public final void l3() {
        S2().l(g3());
    }

    public final void m3() {
        if (!d6.b.f12660a.y() || !f7857x) {
            ((MarqueeTextView) Z2(R$id.mTvBindTip)).setVisibility(8);
            return;
        }
        int i10 = R$id.mTvBindTip;
        ((MarqueeTextView) Z2(i10)).setVisibility(0);
        ((MarqueeTextView) Z2(i10)).setOnClickListener(new View.OnClickListener() { // from class: f5.b0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ColumnListAty.n3(ColumnListAty.this, view);
            }
        });
    }

    public final void o3(Fragment fragment, int i10, int i11, String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("columnId", i10);
        bundle.putInt("COLUMN_INDEX", i11);
        bundle.putBoolean("COLUMN_FREE", f7857x);
        bundle.putString("tdc_from", str);
        bundle.putBoolean("iscr", this.f7860m);
        fragment.setArguments(bundle);
    }

    @Override // f5.c, android.view.View.OnClickListener
    public void onClick(View view) {
        i.g(view, "view");
        if (i.b(view, (ImageView) Z2(R$id.iv_back))) {
            finish();
        }
    }

    @Override // f5.c, u8.a, androidx.fragment.app.e, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    public void p3(w wVar) {
        i.g(wVar, "<set-?>");
        this.f7862o = wVar;
    }

    public final void q3(final List list) {
        Observable observeOn = Observable.fromCallable(new Callable() { // from class: f5.e0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                List r32;
                r32 = ColumnListAty.r3(list, this);
                return r32;
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final h hVar = new h(list, this);
        observeOn.subscribe(new Consumer() { // from class: f5.f0
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                ColumnListAty.s3(s9.l.this, obj);
            }
        });
    }
}
