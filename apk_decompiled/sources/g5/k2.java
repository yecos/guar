package g5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.mobile.brasiltv.bean.EnterType;
import com.mobile.brasiltv.view.AutoCardView;
import com.msandroid.mobile.R;
import com.zhy.autolayout.utils.AutoUtils;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.Arrays;
import java.util.List;
import mobile.com.requestframe.utils.response.ShelveAsset;
import mobile.com.requestframe.utils.response.ShelvePoster;

/* loaded from: classes3.dex */
public final class k2 extends RecyclerView.g {

    /* renamed from: a, reason: collision with root package name */
    public final Context f13749a;

    /* renamed from: b, reason: collision with root package name */
    public final int f13750b;

    /* renamed from: c, reason: collision with root package name */
    public List f13751c;

    /* renamed from: d, reason: collision with root package name */
    public final String f13752d;

    public static final class a extends RecyclerView.d0 {

        /* renamed from: a, reason: collision with root package name */
        public AutoCardView f13753a;

        /* renamed from: b, reason: collision with root package name */
        public ImageView f13754b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f13755c;

        /* renamed from: d, reason: collision with root package name */
        public TextView f13756d;

        /* renamed from: e, reason: collision with root package name */
        public ImageView f13757e;

        /* renamed from: f, reason: collision with root package name */
        public ImageView f13758f;

        /* renamed from: g, reason: collision with root package name */
        public ImageView f13759g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            t9.i.g(view, "itemView");
            View findViewById = view.findViewById(R.id.mLayout);
            t9.i.f(findViewById, "itemView.findViewById(R.id.mLayout)");
            this.f13753a = (AutoCardView) findViewById;
            View findViewById2 = view.findViewById(R.id.mIvPoster);
            t9.i.f(findViewById2, "itemView.findViewById(R.id.mIvPoster)");
            this.f13754b = (ImageView) findViewById2;
            View findViewById3 = view.findViewById(R.id.mTvEpisodeInfo);
            t9.i.f(findViewById3, "itemView.findViewById(R.id.mTvEpisodeInfo)");
            this.f13755c = (TextView) findViewById3;
            View findViewById4 = view.findViewById(R.id.mTvProgramName);
            t9.i.f(findViewById4, "itemView.findViewById(R.id.mTvProgramName)");
            this.f13756d = (TextView) findViewById4;
            View findViewById5 = view.findViewById(R.id.mIvCovered);
            t9.i.f(findViewById5, "itemView.findViewById(R.id.mIvCovered)");
            this.f13757e = (ImageView) findViewById5;
            View findViewById6 = view.findViewById(R.id.mIvTs);
            t9.i.f(findViewById6, "itemView.findViewById(R.id.mIvTs)");
            this.f13758f = (ImageView) findViewById6;
            View findViewById7 = view.findViewById(R.id.mIvTop);
            t9.i.f(findViewById7, "itemView.findViewById(R.id.mIvTop)");
            this.f13759g = (ImageView) findViewById7;
            AutoUtils.autoSize(view);
        }

        public final ImageView b() {
            return this.f13757e;
        }

        public final ImageView c() {
            return this.f13754b;
        }

        public final ImageView d() {
            return this.f13759g;
        }

        public final ImageView e() {
            return this.f13758f;
        }

        public final AutoCardView f() {
            return this.f13753a;
        }

        public final TextView g() {
            return this.f13755c;
        }

        public final TextView h() {
            return this.f13756d;
        }
    }

    public static final class b extends t9.j implements s9.l {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f13761b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar) {
            super(1);
            this.f13761b = aVar;
        }

        public final void b(ShelvePoster shelvePoster) {
            a7.e.f288a.b(k2.this.f13749a, shelvePoster.getFileUrl(), this.f13761b.c(), R.drawable.special_cloumn_img_placeholder);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((ShelvePoster) obj);
            return h9.t.f14242a;
        }
    }

    public static final class c extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f13762a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(a aVar) {
            super(1);
            this.f13762a = aVar;
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return h9.t.f14242a;
        }

        public final void invoke(Throwable th) {
            this.f13762a.c().setImageResource(R.drawable.special_cloumn_img_placeholder);
        }
    }

    public k2(Context context, int i10, List list, String str) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(list, "homeAssetList");
        t9.i.g(str, "tdcFrom");
        this.f13749a = context;
        this.f13750b = i10;
        this.f13751c = list;
        this.f13752d = str;
    }

    public static final void f(t9.w wVar, k2 k2Var, View view) {
        t9.i.g(wVar, "$item");
        t9.i.g(k2Var, "this$0");
        a7.d dVar = a7.d.f279a;
        ShelveAsset shelveAsset = (ShelveAsset) wVar.f18961a;
        String o10 = dVar.o(shelveAsset != null ? shelveAsset.getPosterList() : null, dVar.g());
        if (o10 == null) {
            o10 = "";
        }
        String str = o10;
        Context context = k2Var.f13749a;
        t9.i.e(context, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
        f5.c cVar = (f5.c) context;
        String type = ((ShelveAsset) wVar.f18961a).getType();
        String programType = ((ShelveAsset) wVar.f18961a).getProgramType();
        String contentId = ((ShelveAsset) wVar.f18961a).getContentId();
        EnterType enterType = EnterType.HOME;
        String alias = ((ShelveAsset) wVar.f18961a).getAlias();
        com.mobile.brasiltv.utils.b0.r(cVar, type, programType, contentId, enterType, alias == null ? ((ShelveAsset) wVar.f18961a).getName() : alias, false, false, k2Var.f13750b, k2Var.f13752d, str);
    }

    public static final void g(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void h(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a aVar, int i10) {
        String format;
        t9.i.g(aVar, "holder");
        final t9.w wVar = new t9.w();
        wVar.f18961a = this.f13751c.get(i10);
        aVar.f().setOnClickListener(new View.OnClickListener() { // from class: g5.h2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                k2.f(t9.w.this, this, view);
            }
        });
        boolean z10 = true;
        if (t9.i.b(((ShelveAsset) wVar.f18961a).getType(), "0")) {
            if (((ShelveAsset) wVar.f18961a).getUpdateCount() == ((ShelveAsset) wVar.f18961a).getVolumnCount()) {
                t9.z zVar = t9.z.f18964a;
                String string = this.f13749a.getResources().getString(R.string.recommend_episodes_all);
                t9.i.f(string, "context.resources.getStr…g.recommend_episodes_all)");
                format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(((ShelveAsset) wVar.f18961a).getVolumnCount())}, 1));
                t9.i.f(format, "format(format, *args)");
            } else {
                t9.z zVar2 = t9.z.f18964a;
                String string2 = this.f13749a.getResources().getString(R.string.recommend_episodes);
                t9.i.f(string2, "context.resources.getStr…tring.recommend_episodes)");
                format = String.format(string2, Arrays.copyOf(new Object[]{Integer.valueOf(((ShelveAsset) wVar.f18961a).getUpdateCount())}, 1));
                t9.i.f(format, "format(format, *args)");
            }
            aVar.g().setText(format);
            aVar.g().setVisibility(0);
            aVar.b().setVisibility(0);
        } else {
            aVar.g().setVisibility(8);
            aVar.b().setVisibility(8);
        }
        TextView h10 = aVar.h();
        String alias = ((ShelveAsset) wVar.f18961a).getAlias();
        com.mobile.brasiltv.utils.b0.d(h10, alias != null ? ba.t.W(alias).toString() : null, ba.t.W(((ShelveAsset) wVar.f18961a).getName()).toString());
        String contentType = ((ShelveAsset) wVar.f18961a).getContentType();
        if (contentType != null && contentType.length() != 0) {
            z10 = false;
        }
        if (z10 || !t9.i.b(((ShelveAsset) wVar.f18961a).getContentType(), "1")) {
            aVar.e().setVisibility(8);
        } else {
            aVar.e().setVisibility(0);
        }
        switch (i10) {
            case 0:
                aVar.d().setImageResource(R.drawable.icon_top_1);
                break;
            case 1:
                aVar.d().setImageResource(R.drawable.icon_top_2);
                break;
            case 2:
                aVar.d().setImageResource(R.drawable.icon_top_3);
                break;
            case 3:
                aVar.d().setImageResource(R.drawable.icon_top_4);
                break;
            case 4:
                aVar.d().setImageResource(R.drawable.icon_top_5);
                break;
            case 5:
                aVar.d().setImageResource(R.drawable.icon_top_6);
                break;
            case 6:
                aVar.d().setImageResource(R.drawable.icon_top_7);
                break;
            case 7:
                aVar.d().setImageResource(R.drawable.icon_top_8);
                break;
            case 8:
                aVar.d().setImageResource(R.drawable.icon_top_9);
                break;
            case 9:
                aVar.d().setImageResource(R.drawable.icon_top_10);
                break;
        }
        a7.d dVar = a7.d.f279a;
        Observable l10 = dVar.l(((ShelveAsset) wVar.f18961a).getPosterList(), dVar.g());
        final b bVar = new b(aVar);
        Consumer consumer = new Consumer() { // from class: g5.i2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                k2.g(s9.l.this, obj);
            }
        };
        final c cVar = new c(aVar);
        l10.subscribe(consumer, new Consumer() { // from class: g5.j2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                k2.h(s9.l.this, obj);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        if (this.f13751c.size() > 10) {
            return 10;
        }
        return this.f13751c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup viewGroup, int i10) {
        t9.i.g(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f13749a).inflate(R.layout.adapter_home_top_new_item, viewGroup, false);
        AutoUtils.autoSize(inflate);
        t9.i.f(inflate, "view");
        return new a(inflate);
    }
}
