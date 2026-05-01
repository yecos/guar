package g5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.mobile.brasiltv.bean.SearchBean;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoFrameLayout;
import com.zhy.autolayout.utils.AutoUtils;
import java.util.ArrayList;
import mobile.com.requestframe.utils.response.Channel;

/* loaded from: classes3.dex */
public final class u2 extends RecyclerView.g {

    /* renamed from: a, reason: collision with root package name */
    public final String f13912a;

    /* renamed from: b, reason: collision with root package name */
    public Context f13913b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f13914c;

    /* renamed from: d, reason: collision with root package name */
    public b f13915d;

    /* renamed from: e, reason: collision with root package name */
    public a f13916e;

    public interface a {
        void a(Channel channel, int i10);
    }

    public interface b {
        void a(Channel channel);
    }

    public static final class c extends RecyclerView.d0 {

        /* renamed from: a, reason: collision with root package name */
        public ImageView f13917a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f13918b;

        /* renamed from: c, reason: collision with root package name */
        public AutoFrameLayout f13919c;

        /* renamed from: d, reason: collision with root package name */
        public ImageView f13920d;

        /* renamed from: e, reason: collision with root package name */
        public ProgressBar f13921e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(View view) {
            super(view);
            t9.i.g(view, "itemView");
            AutoUtils.autoSize(view);
            View findViewById = view.findViewById(R.id.mIvChannelLogo);
            t9.i.e(findViewById, "null cannot be cast to non-null type android.widget.ImageView");
            this.f13917a = (ImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.mTextName);
            t9.i.e(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
            this.f13918b = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.mFavWrapper);
            t9.i.e(findViewById3, "null cannot be cast to non-null type com.zhy.autolayout.AutoFrameLayout");
            this.f13919c = (AutoFrameLayout) findViewById3;
            View findViewById4 = view.findViewById(R.id.mIvFav);
            t9.i.e(findViewById4, "null cannot be cast to non-null type android.widget.ImageView");
            this.f13920d = (ImageView) findViewById4;
            View findViewById5 = view.findViewById(R.id.mPbUnfav);
            t9.i.e(findViewById5, "null cannot be cast to non-null type android.widget.ProgressBar");
            this.f13921e = (ProgressBar) findViewById5;
        }

        public final AutoFrameLayout b() {
            return this.f13919c;
        }

        public final ImageView c() {
            return this.f13917a;
        }

        public final ImageView d() {
            return this.f13920d;
        }

        public final ProgressBar e() {
            return this.f13921e;
        }

        public final TextView f() {
            return this.f13918b;
        }
    }

    public u2(Context context, ArrayList arrayList) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(arrayList, "data");
        this.f13912a = "SearchAdapter";
        this.f13913b = context;
        this.f13914c = arrayList;
    }

    public static final void d(u2 u2Var, t9.w wVar, View view) {
        t9.i.g(u2Var, "this$0");
        t9.i.g(wVar, "$channel");
        b bVar = u2Var.f13915d;
        if (bVar != null) {
            bVar.a((Channel) wVar.f18961a);
        }
    }

    public static final void e(u2 u2Var, t9.w wVar, int i10, View view) {
        t9.i.g(u2Var, "this$0");
        t9.i.g(wVar, "$channel");
        a aVar = u2Var.f13916e;
        if (aVar != null) {
            aVar.a((Channel) wVar.f18961a, i10);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0083  */
    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onBindViewHolder(c cVar, final int i10) {
        d6.a aVar;
        t9.i.g(cVar, "holder");
        final t9.w wVar = new t9.w();
        Channel channel = ((SearchBean) this.f13914c.get(i10)).getChannel();
        wVar.f18961a = channel;
        a7.e.f288a.b(this.f13913b, channel.getPosterUrl(), cVar.c(), R.drawable.icon_channel_default_logo);
        if (!com.mobile.brasiltv.utils.f0.b()) {
            String alias = ((Channel) wVar.f18961a).getAlias();
            if (!(alias == null || alias.length() == 0)) {
                cVar.f().setText(((Channel) wVar.f18961a).getAlias());
                cVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: g5.s2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        u2.d(u2.this, wVar, view);
                    }
                });
                aVar = d6.a.f12650a;
                if (aVar.j() == 3) {
                    cVar.b().setVisibility(8);
                    return;
                }
                cVar.b().setVisibility(0);
                if (aVar.g((Channel) wVar.f18961a)) {
                    cVar.d().setImageResource(R.drawable.icon_live_fav);
                } else {
                    cVar.d().setImageResource(R.drawable.icon_live_not_fav);
                }
                if (aVar.l(((Channel) wVar.f18961a).getChannelCode())) {
                    cVar.d().setVisibility(8);
                    cVar.e().setVisibility(0);
                } else {
                    cVar.d().setVisibility(0);
                    cVar.e().setVisibility(8);
                }
                cVar.b().setOnClickListener(new View.OnClickListener() { // from class: g5.t2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        u2.e(u2.this, wVar, i10, view);
                    }
                });
                return;
            }
        }
        cVar.f().setText(((Channel) wVar.f18961a).getName());
        cVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: g5.s2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                u2.d(u2.this, wVar, view);
            }
        });
        aVar = d6.a.f12650a;
        if (aVar.j() == 3) {
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public c onCreateViewHolder(ViewGroup viewGroup, int i10) {
        t9.i.g(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f13913b).inflate(R.layout.adapter_search_item, viewGroup, false);
        t9.i.f(inflate, "view");
        return new c(inflate);
    }

    public final void g(ArrayList arrayList) {
        t9.i.g(arrayList, "data");
        this.f13914c = arrayList;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.f13914c.size();
    }

    public final void h(a aVar) {
        t9.i.g(aVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f13916e = aVar;
    }

    public final void i(b bVar) {
        t9.i.g(bVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f13915d = bVar;
    }

    public final void j(String str, int i10) {
        t9.i.g(str, "channelCode");
        if (this.f13914c.size() <= i10 || !t9.i.b(((SearchBean) this.f13914c.get(i10)).getChannel().getChannelCode(), str)) {
            return;
        }
        notifyItemChanged(i10);
    }

    public final void k(String str) {
        t9.i.g(str, "channelCode");
        int i10 = 0;
        for (Object obj : this.f13914c) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                i9.j.j();
            }
            if (t9.i.b(((SearchBean) obj).getChannel().getChannelCode(), str)) {
                notifyItemChanged(i10);
                return;
            }
            i10 = i11;
        }
    }
}
