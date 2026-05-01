package g7;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.mobile.brasiltv.view.VerticalItemDecoration;
import com.msandroid.mobile.R;
import com.zhy.autolayout.utils.AutoUtils;
import java.util.ArrayList;
import mobile.com.requestframe.utils.response.ProgramSeason;
import n6.g;

/* loaded from: classes3.dex */
public final class l extends g7.b {

    /* renamed from: b, reason: collision with root package name */
    public final RecyclerView f14018b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f14019c;

    /* renamed from: d, reason: collision with root package name */
    public final h9.g f14020d;

    /* renamed from: e, reason: collision with root package name */
    public b f14021e;

    public static final class a implements g.a {
        public a() {
        }

        @Override // n6.g.a
        public void a(int i10, ProgramSeason programSeason) {
            t9.i.g(programSeason, "data");
            b bVar = l.this.f14021e;
            if (bVar != null) {
                bVar.a(i10, programSeason);
            }
        }
    }

    public interface b {
        void a(int i10, ProgramSeason programSeason);
    }

    public static final class c extends t9.j implements s9.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Activity f14023a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Activity activity) {
            super(0);
            this.f14023a = activity;
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final n6.g invoke() {
            return new n6.g(this.f14023a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(Activity activity) {
        super(activity);
        t9.i.g(activity, "activity");
        this.f14020d = h9.h.b(new c(activity));
        View inflate = LayoutInflater.from(activity).inflate(R.layout.layout_pop_window_season, (ViewGroup) null);
        t9.i.f(inflate, "from(activity).inflate(R…_pop_window_season, null)");
        setContentView(inflate);
        setBackgroundDrawable(new ColorDrawable(0));
        setHeight(activity.getResources().getDisplayMetrics().heightPixels - AutoUtils.getPercentHeightSize(448));
        View findViewById = inflate.findViewById(R.id.mRvSeason);
        t9.i.f(findViewById, "view.findViewById(R.id.mRvSeason)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.f14018b = recyclerView;
        View findViewById2 = inflate.findViewById(R.id.mIvClose);
        t9.i.f(findViewById2, "view.findViewById(R.id.mIvClose)");
        ImageView imageView = (ImageView) findViewById2;
        this.f14019c = imageView;
        recyclerView.setLayoutManager(new LinearLayoutManager(activity, 1, false));
        recyclerView.addItemDecoration(new VerticalItemDecoration(activity, 0, AutoUtils.getPercentHeightSize(70)));
        recyclerView.setAdapter(i());
        i().f(new a());
        imageView.setOnClickListener(new View.OnClickListener() { // from class: g7.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                l.g(l.this, view);
            }
        });
    }

    public static final void g(l lVar, View view) {
        t9.i.g(lVar, "this$0");
        lVar.dismiss();
    }

    public final n6.g i() {
        return (n6.g) this.f14020d.getValue();
    }

    public final void j(b bVar) {
        t9.i.g(bVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f14021e = bVar;
    }

    public final void k(ArrayList arrayList, int i10) {
        t9.i.g(arrayList, "data");
        i().e(arrayList);
        i().g(i10);
        this.f14018b.scrollToPosition(i10);
    }
}
