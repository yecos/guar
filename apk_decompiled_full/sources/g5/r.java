package g5;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hpplay.component.protocol.PlistBuilder;
import com.mobile.brasiltv.view.AutoCardView;
import com.msandroid.mobile.R;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import mobile.com.requestframe.utils.response.ChildColumnList;
import mobile.com.requestframe.utils.response.PosterList;

/* loaded from: classes3.dex */
public final class r extends j5.a {

    /* renamed from: a, reason: collision with root package name */
    public Context f13850a;

    /* renamed from: b, reason: collision with root package name */
    public ChildColumnList f13851b;

    public static final class a extends t9.j implements s9.l {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ImageView f13853b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ImageView imageView) {
            super(1);
            this.f13853b = imageView;
        }

        public final void b(PosterList posterList) {
            a7.e eVar = a7.e.f288a;
            Context h10 = r.this.h();
            String fileUrl = posterList.getFileUrl();
            ImageView imageView = this.f13853b;
            t9.i.f(imageView, "mIvPoster");
            eVar.b(h10, fileUrl, imageView, R.drawable.bg_cr_column_placeholder);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((PosterList) obj);
            return h9.t.f14242a;
        }
    }

    public static final class b extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageView f13854a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ImageView imageView) {
            super(1);
            this.f13854a = imageView;
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return h9.t.f14242a;
        }

        public final void invoke(Throwable th) {
            this.f13854a.setImageResource(R.drawable.bg_cr_column_placeholder);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(Context context, ChildColumnList childColumnList) {
        super(R.layout.adapter_cr_column_item, null, 2, null);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(childColumnList, "parentColumn");
        this.f13850a = context;
        this.f13851b = childColumnList;
    }

    public static final void e(r rVar, BaseViewHolder baseViewHolder, View view) {
        t9.i.g(rVar, "this$0");
        t9.i.g(baseViewHolder, "$helper");
        Context context = rVar.f13850a;
        t9.i.e(context, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
        com.mobile.brasiltv.utils.b0.k((f5.c) context, rVar.f13851b, baseViewHolder.getAdapterPosition(), true);
    }

    public static final void f(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void g(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void convert(final BaseViewHolder baseViewHolder, ChildColumnList childColumnList) {
        t9.i.g(baseViewHolder, "helper");
        t9.i.g(childColumnList, PlistBuilder.KEY_ITEM);
        TextView textView = (TextView) baseViewHolder.getView(R.id.mTvColumnName);
        textView.setText(com.mobile.brasiltv.utils.b0.e(childColumnList.getAlias(), childColumnList.getName()));
        textView.setVisibility(0);
        ((AutoCardView) baseViewHolder.getView(R.id.mLayout)).setOnClickListener(new View.OnClickListener() { // from class: g5.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r.e(r.this, baseViewHolder, view);
            }
        });
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.mIvPoster);
        a7.d dVar = a7.d.f279a;
        Observable c10 = dVar.c(childColumnList.getPosterList(), dVar.i());
        final a aVar = new a(imageView);
        Consumer consumer = new Consumer() { // from class: g5.p
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                r.f(s9.l.this, obj);
            }
        };
        final b bVar = new b(imageView);
        c10.subscribe(consumer, new Consumer() { // from class: g5.q
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                r.g(s9.l.this, obj);
            }
        });
    }

    public final Context h() {
        return this.f13850a;
    }
}
