package g5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.advertlib.bean.AdInfo;
import com.msandroid.mobile.R;
import com.titans.entity.CdnType;
import com.zhy.autolayout.utils.AutoUtils;
import java.util.List;

/* loaded from: classes3.dex */
public final class d0 extends RecyclerView.g {

    /* renamed from: a, reason: collision with root package name */
    public Context f13662a;

    /* renamed from: b, reason: collision with root package name */
    public List f13663b;

    public static final class a extends RecyclerView.d0 {

        /* renamed from: a, reason: collision with root package name */
        public ImageView f13664a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f13665b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            t9.i.g(view, "itemView");
            this.f13664a = (ImageView) view.findViewById(R.id.mIvGamePoster);
            this.f13665b = (TextView) view.findViewById(R.id.mTvAdFlag);
            AutoUtils.autoSize(view);
        }

        public final ImageView b() {
            return this.f13664a;
        }

        public final TextView c() {
            return this.f13665b;
        }
    }

    public d0(Context context, List list) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(list, "adInfoList");
        this.f13662a = context;
        this.f13663b = list;
    }

    public static final void c(t9.w wVar, d0 d0Var, int i10, View view) {
        t9.i.g(wVar, "$adInfo");
        t9.i.g(d0Var, "this$0");
        if (!t9.i.b(((AdInfo) wVar.f18961a).getAction_type(), "1") || !com.mobile.brasiltv.utils.b0.H(((AdInfo) wVar.f18961a).getAction())) {
            if (t9.i.b(((AdInfo) wVar.f18961a).getAction_type(), CdnType.DIGITAL_TYPE_PCDN)) {
                com.mobile.brasiltv.utils.b0.m(d0Var.f13662a);
                return;
            }
            return;
        }
        com.mobile.brasiltv.utils.b0.v(d0Var.f13662a, ((AdInfo) wVar.f18961a).getAction());
        s1.q.f18727a.m(d0Var.f13662a, a6.a.f228a.e() + '_' + i10, d6.b.f12660a.m(d0Var.f13662a), (AdInfo) wVar.f18961a);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a aVar, final int i10) {
        t9.i.g(aVar, "holder");
        final t9.w wVar = new t9.w();
        wVar.f18961a = this.f13663b.get(i10);
        s1.m mVar = s1.m.f18686a;
        Context context = this.f13662a;
        ImageView b10 = aVar.b();
        t9.i.f(b10, "holder.mIvGamePoster");
        mVar.g0(context, b10, a6.a.f228a.e(), (AdInfo) wVar.f18961a, (r23 & 16) != 0 ? null : null, (r23 & 32) != 0 ? null : null, (r23 & 64) != 0 ? null : null, (r23 & 128) != 0 ? false : false, (r23 & 256) != 0 ? -1 : 0);
        if (((AdInfo) wVar.f18961a).isShowFlag()) {
            aVar.c().setVisibility(0);
        } else {
            aVar.c().setVisibility(8);
        }
        aVar.b().setOnClickListener(new View.OnClickListener() { // from class: g5.c0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d0.c(t9.w.this, this, i10, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup viewGroup, int i10) {
        t9.i.g(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f13662a).inflate(R.layout.adapter_free_game_item, viewGroup, false);
        t9.i.f(inflate, "view");
        return new a(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.f13663b.size();
    }
}
