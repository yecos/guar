package g5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.mobile.brasiltv.bean.EnterType;
import com.mobile.brasiltv.view.shortvideo.TikTokView;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoFrameLayout;
import com.zhy.autolayout.AutoLinearLayout;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mobile.com.requestframe.utils.response.ShelvePoster;
import mobile.com.requestframe.utils.response.ShortAssetData;

/* loaded from: classes3.dex */
public final class v3 extends androidx.viewpager.widget.a {

    /* renamed from: a, reason: collision with root package name */
    public List f13929a;

    /* renamed from: b, reason: collision with root package name */
    public final String f13930b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f13931c;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public int f13932a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f13933b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f13934c;

        /* renamed from: d, reason: collision with root package name */
        public ImageView f13935d;

        /* renamed from: e, reason: collision with root package name */
        public TikTokView f13936e;

        /* renamed from: f, reason: collision with root package name */
        public AutoLinearLayout f13937f;

        /* renamed from: g, reason: collision with root package name */
        public AutoFrameLayout f13938g;

        public a(View view) {
            t9.i.g(view, "itemView");
            View findViewById = view.findViewById(R.id.mTiktokView);
            t9.i.f(findViewById, "itemView.findViewById(R.id.mTiktokView)");
            TikTokView tikTokView = (TikTokView) findViewById;
            this.f13936e = tikTokView;
            View findViewById2 = tikTokView.findViewById(R.id.mTvTitle);
            t9.i.f(findViewById2, "mTikTokView.findViewById(R.id.mTvTitle)");
            this.f13933b = (TextView) findViewById2;
            View findViewById3 = this.f13936e.findViewById(R.id.mTvAuthor);
            t9.i.f(findViewById3, "mTikTokView.findViewById(R.id.mTvAuthor)");
            this.f13934c = (TextView) findViewById3;
            View findViewById4 = this.f13936e.findViewById(R.id.mIvThumb);
            t9.i.f(findViewById4, "mTikTokView.findViewById(R.id.mIvThumb)");
            this.f13935d = (ImageView) findViewById4;
            View findViewById5 = view.findViewById(R.id.mLayoutFullVideo);
            t9.i.f(findViewById5, "itemView.findViewById(R.id.mLayoutFullVideo)");
            this.f13937f = (AutoLinearLayout) findViewById5;
            View findViewById6 = view.findViewById(R.id.mContainer);
            t9.i.f(findViewById6, "itemView.findViewById(R.id.mContainer)");
            this.f13938g = (AutoFrameLayout) findViewById6;
            view.setTag(this);
        }

        public final TextView a() {
            return this.f13934c;
        }

        public final AutoLinearLayout b() {
            return this.f13937f;
        }

        public final int c() {
            return this.f13932a;
        }

        public final ImageView d() {
            return this.f13935d;
        }

        public final TextView e() {
            return this.f13933b;
        }

        public final void f(int i10) {
            this.f13932a = i10;
        }
    }

    public static final class b extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f13939a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f13940b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Context context, a aVar) {
            super(1);
            this.f13939a = context;
            this.f13940b = aVar;
        }

        public final void b(ShelvePoster shelvePoster) {
            a7.e eVar = a7.e.f288a;
            Context context = this.f13939a;
            t9.i.f(context, com.umeng.analytics.pro.f.X);
            eVar.b(context, shelvePoster.getFileUrl(), this.f13940b.d(), 0);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((ShelvePoster) obj);
            return h9.t.f14242a;
        }
    }

    public static final class c extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f13941a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(a aVar) {
            super(1);
            this.f13941a = aVar;
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return h9.t.f14242a;
        }

        public final void invoke(Throwable th) {
            this.f13941a.d().setImageResource(0);
        }
    }

    public v3(List list) {
        t9.i.g(list, "mVideoBeans");
        this.f13929a = list;
        this.f13930b = v3.class.getClass().getSimpleName();
        this.f13931c = new ArrayList();
    }

    public static final void d(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void e(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void f(Context context, ShortAssetData shortAssetData, View view) {
        t9.i.g(shortAssetData, "$item");
        com.mobile.brasiltv.utils.i1.J(context, shortAssetData.getName());
        a7.d dVar = a7.d.f279a;
        String o10 = dVar.o(shortAssetData.getPosterList(), dVar.g());
        if (o10 == null) {
            o10 = "";
        }
        t9.i.e(context, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
        com.mobile.brasiltv.utils.b0.r((f5.c) context, shortAssetData.getType(), "", shortAssetData.getResourceId(), EnterType.HOME, shortAssetData.getAlias(), (r25 & 32) != 0 ? false : false, (r25 & 64) != 0 ? false : false, (r25 & 128) != 0 ? -1 : 0, (r25 & 256) != 0 ? "" : "short/detail", o10);
    }

    @Override // androidx.viewpager.widget.a
    public void destroyItem(ViewGroup viewGroup, int i10, Object obj) {
        t9.i.g(viewGroup, "container");
        t9.i.g(obj, "object");
        View view = (View) obj;
        viewGroup.removeView(view);
        com.mobile.brasiltv.utils.b0.U(this, "取消预加载...position:" + i10);
        this.f13931c.add(view);
    }

    @Override // androidx.viewpager.widget.a
    public int getCount() {
        return this.f13929a.size();
    }

    @Override // androidx.viewpager.widget.a
    public Object instantiateItem(ViewGroup viewGroup, int i10) {
        View view;
        a aVar;
        t9.i.g(viewGroup, "container");
        final Context context = viewGroup.getContext();
        if (this.f13931c.size() > 0) {
            view = (View) this.f13931c.get(0);
            this.f13931c.remove(0);
        } else {
            view = null;
        }
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_tik_tok, viewGroup, false);
            aVar = new a(view);
        } else {
            Object tag = view.getTag();
            t9.i.e(tag, "null cannot be cast to non-null type com.mobile.brasiltv.adapter.TiktokAdapter.ViewHolder");
            aVar = (a) tag;
        }
        final ShortAssetData shortAssetData = (ShortAssetData) this.f13929a.get(i10);
        com.mobile.brasiltv.utils.b0.U(this, "开始预加载...position:" + i10);
        a7.d dVar = a7.d.f279a;
        Observable l10 = dVar.l(shortAssetData.getPosterList(), dVar.g());
        final b bVar = new b(context, aVar);
        Consumer consumer = new Consumer() { // from class: g5.s3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                v3.d(s9.l.this, obj);
            }
        };
        final c cVar = new c(aVar);
        l10.subscribe(consumer, new Consumer() { // from class: g5.t3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                v3.e(s9.l.this, obj);
            }
        });
        com.mobile.brasiltv.utils.b0.d(aVar.e(), shortAssetData.getAlias(), shortAssetData.getName());
        TextView a10 = aVar.a();
        t9.z zVar = t9.z.f18964a;
        String string = context.getString(R.string.short_video_update_by);
        t9.i.f(string, "context.getString(R.string.short_video_update_by)");
        boolean z10 = true;
        String format = String.format(string, Arrays.copyOf(new Object[]{shortAssetData.getDirector()}, 1));
        t9.i.f(format, "format(format, *args)");
        a10.setText(format);
        AutoLinearLayout b10 = aVar.b();
        String resourceId = shortAssetData.getResourceId();
        if (resourceId != null && resourceId.length() != 0) {
            z10 = false;
        }
        b10.setVisibility(z10 ? 8 : 0);
        aVar.b().setOnClickListener(new View.OnClickListener() { // from class: g5.u3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                v3.f(context, shortAssetData, view2);
            }
        });
        aVar.f(i10);
        viewGroup.addView(view);
        t9.i.d(view);
        return view;
    }

    @Override // androidx.viewpager.widget.a
    public boolean isViewFromObject(View view, Object obj) {
        t9.i.g(view, "view");
        t9.i.g(obj, "any");
        return t9.i.b(view, obj);
    }
}
