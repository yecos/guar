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
        To view partially-correct add '--show-bad-code' argument
    */
    public void onBindViewHolder(g5.u2.c r7, final int r8) {
        /*
            r6 = this;
            java.lang.String r0 = "holder"
            t9.i.g(r7, r0)
            t9.w r0 = new t9.w
            r0.<init>()
            java.util.ArrayList r1 = r6.f13914c
            java.lang.Object r1 = r1.get(r8)
            com.mobile.brasiltv.bean.SearchBean r1 = (com.mobile.brasiltv.bean.SearchBean) r1
            mobile.com.requestframe.utils.response.Channel r1 = r1.getChannel()
            r0.f18961a = r1
            a7.e r2 = a7.e.f288a
            android.content.Context r3 = r6.f13913b
            java.lang.String r1 = r1.getPosterUrl()
            android.widget.ImageView r4 = r7.c()
            r5 = 2131231382(0x7f080296, float:1.8078843E38)
            r2.b(r3, r1, r4, r5)
            boolean r1 = com.mobile.brasiltv.utils.f0.b()
            r2 = 0
            if (r1 != 0) goto L57
            java.lang.Object r1 = r0.f18961a
            mobile.com.requestframe.utils.response.Channel r1 = (mobile.com.requestframe.utils.response.Channel) r1
            java.lang.String r1 = r1.getAlias()
            if (r1 == 0) goto L44
            int r1 = r1.length()
            if (r1 != 0) goto L42
            goto L44
        L42:
            r1 = 0
            goto L45
        L44:
            r1 = 1
        L45:
            if (r1 != 0) goto L57
            android.widget.TextView r1 = r7.f()
            java.lang.Object r3 = r0.f18961a
            mobile.com.requestframe.utils.response.Channel r3 = (mobile.com.requestframe.utils.response.Channel) r3
            java.lang.String r3 = r3.getAlias()
            r1.setText(r3)
            goto L66
        L57:
            android.widget.TextView r1 = r7.f()
            java.lang.Object r3 = r0.f18961a
            mobile.com.requestframe.utils.response.Channel r3 = (mobile.com.requestframe.utils.response.Channel) r3
            java.lang.String r3 = r3.getName()
            r1.setText(r3)
        L66:
            android.view.View r1 = r7.itemView
            g5.s2 r3 = new g5.s2
            r3.<init>()
            r1.setOnClickListener(r3)
            d6.a r1 = d6.a.f12650a
            int r3 = r1.j()
            r4 = 3
            r5 = 8
            if (r3 == r4) goto L83
            com.zhy.autolayout.AutoFrameLayout r7 = r7.b()
            r7.setVisibility(r5)
            return
        L83:
            com.zhy.autolayout.AutoFrameLayout r3 = r7.b()
            r3.setVisibility(r2)
            java.lang.Object r3 = r0.f18961a
            mobile.com.requestframe.utils.response.Channel r3 = (mobile.com.requestframe.utils.response.Channel) r3
            boolean r3 = r1.g(r3)
            if (r3 == 0) goto L9f
            android.widget.ImageView r3 = r7.d()
            r4 = 2131231406(0x7f0802ae, float:1.8078892E38)
            r3.setImageResource(r4)
            goto La9
        L9f:
            android.widget.ImageView r3 = r7.d()
            r4 = 2131231411(0x7f0802b3, float:1.8078902E38)
            r3.setImageResource(r4)
        La9:
            java.lang.Object r3 = r0.f18961a
            mobile.com.requestframe.utils.response.Channel r3 = (mobile.com.requestframe.utils.response.Channel) r3
            java.lang.String r3 = r3.getChannelCode()
            boolean r1 = r1.l(r3)
            if (r1 == 0) goto Lc6
            android.widget.ImageView r1 = r7.d()
            r1.setVisibility(r5)
            android.widget.ProgressBar r1 = r7.e()
            r1.setVisibility(r2)
            goto Ld4
        Lc6:
            android.widget.ImageView r1 = r7.d()
            r1.setVisibility(r2)
            android.widget.ProgressBar r1 = r7.e()
            r1.setVisibility(r5)
        Ld4:
            com.zhy.autolayout.AutoFrameLayout r7 = r7.b()
            g5.t2 r1 = new g5.t2
            r1.<init>()
            r7.setOnClickListener(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g5.u2.onBindViewHolder(g5.u2$c, int):void");
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
