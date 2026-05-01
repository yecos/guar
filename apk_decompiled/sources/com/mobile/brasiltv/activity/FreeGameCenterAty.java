package com.mobile.brasiltv.activity;

import a6.a;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.utils.f;
import com.mobile.brasiltv.view.BottomDecoration;
import com.msandroid.mobile.R;
import com.zhy.autolayout.utils.AutoUtils;
import d6.b;
import f5.c;
import g5.d0;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import s1.m;
import s1.q;
import t9.i;

/* loaded from: classes3.dex */
public final class FreeGameCenterAty extends c {

    /* renamed from: k, reason: collision with root package name */
    public d0 f7893k;

    /* renamed from: l, reason: collision with root package name */
    public long f7894l;

    /* renamed from: m, reason: collision with root package name */
    public Map f7895m = new LinkedHashMap();

    public View R2(int i10) {
        Map map = this.f7895m;
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

    @Override // i5.a
    public void k2() {
        n2();
    }

    @Override // f5.c, i5.a, u8.a, androidx.appcompat.app.d, androidx.fragment.app.e, androidx.activity.ComponentActivity, o.p, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.aty_free_game_center);
        this.f7894l = SystemClock.elapsedRealtime();
        int i10 = R$id.mRvGame;
        ((RecyclerView) R2(i10)).setLayoutManager(new LinearLayoutManager(Q1(), 1, false));
        ((RecyclerView) R2(i10)).addItemDecoration(new BottomDecoration(AutoUtils.getPercentHeightSize(10)));
        List z10 = m.f18686a.z(a.f228a.e());
        if (z10 != null) {
            this.f7893k = new d0(this, z10);
            f.f8648a.c();
        }
        ((RecyclerView) R2(i10)).setAdapter(this.f7893k);
        d0 d0Var = this.f7893k;
        if (d0Var != null) {
            d0Var.notifyDataSetChanged();
        }
    }

    @Override // f5.c, u8.a, androidx.appcompat.app.d, androidx.fragment.app.e, android.app.Activity
    public void onDestroy() {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.f7894l;
        long j10 = elapsedRealtime < 1000 ? 1L : elapsedRealtime / 1000;
        q qVar = q.f18727a;
        Context applicationContext = getApplicationContext();
        i.f(applicationContext, "applicationContext");
        String e10 = a.f228a.e();
        b bVar = b.f12660a;
        Context applicationContext2 = getApplicationContext();
        i.f(applicationContext2, "applicationContext");
        qVar.i(applicationContext, e10, bVar.m(applicationContext2), j10);
        super.onDestroy();
    }
}
