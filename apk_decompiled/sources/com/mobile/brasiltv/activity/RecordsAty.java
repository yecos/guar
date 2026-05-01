package com.mobile.brasiltv.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.RecordsAty;
import com.mobile.brasiltv.bean.event.UpdateRecordAtyEvent;
import com.mobile.brasiltv.db.Album;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.view.TitleView;
import com.mobile.brasiltv.view.VerticalItemDecoration;
import com.mobile.brasiltv.view.dialog.DeleteConfirmDialog;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;
import com.zhy.autolayout.utils.AutoUtils;
import f5.d;
import g5.r2;
import i6.h0;
import i6.i0;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k6.p2;
import t9.i;
import xa.j;

/* loaded from: classes.dex */
public final class RecordsAty extends d implements i0, DeleteConfirmDialog.ConfirmCallback {

    /* renamed from: l, reason: collision with root package name */
    public boolean f8024l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f8025m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f8026n;

    /* renamed from: p, reason: collision with root package name */
    public p2 f8028p;

    /* renamed from: q, reason: collision with root package name */
    public Map f8029q = new LinkedHashMap();

    /* renamed from: o, reason: collision with root package name */
    public r2 f8027o = new r2(this, new ArrayList());

    /* loaded from: classes3.dex */
    public static final class a extends GridLayoutManager.c {
        public a() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int getSpanSize(int i10) {
            return RecordsAty.this.b3().d().get(i10) instanceof Album ? 1 : 3;
        }
    }

    /* loaded from: classes3.dex */
    public static final class b implements r2.a {
        public b() {
        }

        @Override // g5.r2.a
        public void a(Album album, int i10) {
            i.g(album, "album");
            b0.q(RecordsAty.this, album, "history");
        }

        @Override // g5.r2.a
        public void b(int i10, int i11) {
            if (i10 == i11) {
                RecordsAty.this.l3(true);
                ((ImageView) RecordsAty.this.Z2(R$id.mIvAllCb)).setImageResource(R.drawable.icon_select);
            } else {
                RecordsAty.this.l3(false);
                ((ImageView) RecordsAty.this.Z2(R$id.mIvAllCb)).setImageResource(R.drawable.icon_no_select);
            }
            RecordsAty.this.m3(i10 != 0);
            if (i10 == 0) {
                ((TextView) RecordsAty.this.Z2(R$id.mTvDelete)).setBackgroundColor(b0.y(R.color.color_666666));
            } else {
                ((TextView) RecordsAty.this.Z2(R$id.mTvDelete)).setBackgroundColor(b0.y(R.color.color_important));
            }
        }
    }

    public static final void d3(RecordsAty recordsAty, View view) {
        i.g(recordsAty, "this$0");
        if (recordsAty.f8025m) {
            recordsAty.f8026n = false;
            ((TextView) recordsAty.Z2(R$id.mTvDelete)).setBackgroundColor(b0.y(R.color.color_666666));
            recordsAty.f8027o.g(false);
            ((ImageView) recordsAty.Z2(R$id.mIvAllCb)).setImageResource(R.drawable.icon_no_select);
        } else {
            recordsAty.f8026n = true;
            ((TextView) recordsAty.Z2(R$id.mTvDelete)).setBackgroundColor(b0.y(R.color.color_important));
            recordsAty.f8027o.g(true);
            ((ImageView) recordsAty.Z2(R$id.mIvAllCb)).setImageResource(R.drawable.icon_select);
        }
        recordsAty.f8025m = !recordsAty.f8025m;
    }

    public static final void e3(RecordsAty recordsAty, View view) {
        i.g(recordsAty, "this$0");
        ((ImageView) recordsAty.Z2(R$id.mIvAllCb)).performClick();
    }

    public static final void f3(RecordsAty recordsAty, View view) {
        i.g(recordsAty, "this$0");
        if (recordsAty.f8026n) {
            if (recordsAty.f8025m) {
                new DeleteConfirmDialog(recordsAty, R.string.history_whether_delete_all, recordsAty).show();
            } else {
                recordsAty.S2().p(recordsAty.f8027o.d());
            }
        }
    }

    public static final void i3(RecordsAty recordsAty, View view) {
        i.g(recordsAty, "this$0");
        recordsAty.k3();
    }

    public static final void j3(RecordsAty recordsAty, View view) {
        i.g(recordsAty, "this$0");
        recordsAty.k3();
    }

    @Override // i6.i0
    public void F(List list) {
        i.g(list, "list");
        ((TitleView) Z2(R$id.titleView)).getIvMenuView().setVisibility(0);
        ((AutoLinearLayout) Z2(R$id.mLlEmptyRecord)).setVisibility(8);
        this.f8027o.b(list);
    }

    @Override // f5.d
    public void R2() {
        n3(new p2(this, this));
        h3();
        c3();
        g3();
        S2().x();
    }

    @Override // f5.d
    public int T2() {
        return R.layout.aty_records;
    }

    public View Z2(int i10) {
        Map map = this.f8029q;
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

    @Override // f5.d
    /* renamed from: a3, reason: merged with bridge method [inline-methods] */
    public p2 S2() {
        p2 p2Var = this.f8028p;
        if (p2Var != null) {
            return p2Var;
        }
        i.w("mPresenter");
        return null;
    }

    public final r2 b3() {
        return this.f8027o;
    }

    public final void c3() {
        ((ImageView) Z2(R$id.mIvAllCb)).setOnClickListener(new View.OnClickListener() { // from class: f5.b3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecordsAty.d3(RecordsAty.this, view);
            }
        });
        ((TextView) Z2(R$id.mTvAllCb)).setOnClickListener(new View.OnClickListener() { // from class: f5.c3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecordsAty.e3(RecordsAty.this, view);
            }
        });
        ((TextView) Z2(R$id.mTvDelete)).setOnClickListener(new View.OnClickListener() { // from class: f5.d3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecordsAty.f3(RecordsAty.this, view);
            }
        });
    }

    public final void g3() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(Q1(), 3);
        gridLayoutManager.setSpanSizeLookup(new a());
        int i10 = R$id.mRecyclerRecord;
        ((RecyclerView) Z2(i10)).setLayoutManager(gridLayoutManager);
        ((RecyclerView) Z2(i10)).addItemDecoration(new VerticalItemDecoration(Q1(), 0, AutoUtils.getPercentHeightSize(24)));
        ((RecyclerView) Z2(i10)).setAdapter(this.f8027o);
        this.f8027o.h(new b());
    }

    public final void h3() {
        int i10 = R$id.titleView;
        ((TitleView) Z2(i10)).setLayoutBackground(R.color.color_191a23);
        ((TitleView) Z2(i10)).getSettingView().setVisibility(8);
        ((TitleView) Z2(i10)).getIvMenuView().setVisibility(8);
        ((TitleView) Z2(i10)).setIvMenuSrc(R.drawable.icon_delete_history);
        ((TitleView) Z2(i10)).setIvMenuClickListener(new View.OnClickListener() { // from class: f5.z2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecordsAty.i3(RecordsAty.this, view);
            }
        });
        ((TitleView) Z2(i10)).getTvMenuView().setVisibility(8);
        ((TitleView) Z2(i10)).setTvMenuText(b0.A(this, R.string.cancel));
        ((TitleView) Z2(i10)).setTvMenuClickListener(new View.OnClickListener() { // from class: f5.a3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RecordsAty.j3(RecordsAty.this, view);
            }
        });
    }

    @Override // i5.a
    public void k2() {
        n2();
    }

    public final void k3() {
        if (this.f8024l) {
            int i10 = R$id.titleView;
            ((TitleView) Z2(i10)).getIvMenuView().setVisibility(0);
            ((TitleView) Z2(i10)).getTvMenuView().setVisibility(8);
            ((AutoRelativeLayout) Z2(R$id.mRlDeletePanel)).setVisibility(8);
        } else {
            int i11 = R$id.titleView;
            ((TitleView) Z2(i11)).getIvMenuView().setVisibility(8);
            ((TitleView) Z2(i11)).getTvMenuView().setVisibility(0);
            ((AutoRelativeLayout) Z2(R$id.mRlDeletePanel)).setVisibility(0);
        }
        this.f8025m = false;
        this.f8026n = false;
        ((ImageView) Z2(R$id.mIvAllCb)).setImageResource(R.drawable.icon_no_select);
        ((TextView) Z2(R$id.mTvDelete)).setBackgroundColor(b0.y(R.color.color_666666));
        boolean z10 = !this.f8024l;
        this.f8024l = z10;
        this.f8027o.i(z10);
    }

    @Override // i6.i0
    public void l() {
        ((TitleView) Z2(R$id.titleView)).getIvMenuView().setVisibility(8);
        ((AutoLinearLayout) Z2(R$id.mLlEmptyRecord)).setVisibility(0);
        this.f8027o.b(new ArrayList());
    }

    public final void l3(boolean z10) {
        this.f8025m = z10;
    }

    public final void m3(boolean z10) {
        this.f8026n = z10;
    }

    public void n3(p2 p2Var) {
        i.g(p2Var, "<set-?>");
        this.f8028p = p2Var;
    }

    @Override // m5.a
    /* renamed from: o3, reason: merged with bridge method [inline-methods] */
    public void Y0(h0 h0Var) {
        i.g(h0Var, "presenter");
    }

    @Override // com.mobile.brasiltv.view.dialog.DeleteConfirmDialog.ConfirmCallback
    public void onConfirm() {
        S2().p(this.f8027o.d());
    }

    @Override // i6.i0
    public void p2() {
    }

    @j(sticky = true)
    public final void updateRecord(UpdateRecordAtyEvent updateRecordAtyEvent) {
        i.g(updateRecordAtyEvent, "event");
        S2().x();
    }

    @Override // i6.i0
    public void z2() {
        this.f8024l = false;
        this.f8025m = false;
        int i10 = R$id.titleView;
        ((TitleView) Z2(i10)).getIvMenuView().setVisibility(0);
        ((TitleView) Z2(i10)).getTvMenuView().setVisibility(8);
        ((ImageView) Z2(R$id.mIvAllCb)).setImageResource(R.drawable.icon_no_select);
        ((AutoRelativeLayout) Z2(R$id.mRlDeletePanel)).setVisibility(8);
    }
}
