package g5;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hpplay.component.protocol.PlistBuilder;
import com.mobile.brasiltv.activity.SpecialAty;
import com.mobile.brasiltv.bean.RootColumnId;
import com.mobile.brasiltv.view.AutoCardView;
import com.msandroid.mobile.R;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import mobile.com.requestframe.utils.response.ChildColumnList;
import mobile.com.requestframe.utils.response.PosterList;

/* loaded from: classes3.dex */
public final class d2 extends j5.a {

    /* renamed from: a, reason: collision with root package name */
    public Context f13671a;

    public static final class a extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseViewHolder f13672a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(BaseViewHolder baseViewHolder) {
            super(1);
            this.f13672a = baseViewHolder;
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Intent invoke(Intent intent) {
            t9.i.g(intent, "intent");
            Intent putExtra = intent.putExtra(SpecialAty.f8174q.a(), this.f13672a.getAdapterPosition());
            t9.i.f(putExtra, "intent.putExtra(SpecialA…, helper.adapterPosition)");
            return putExtra;
        }
    }

    public static final class b extends t9.j implements s9.l {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ImageView f13674b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ImageView imageView) {
            super(1);
            this.f13674b = imageView;
        }

        public final void b(PosterList posterList) {
            a7.e eVar = a7.e.f288a;
            Context h10 = d2.this.h();
            String fileUrl = posterList.getFileUrl();
            ImageView imageView = this.f13674b;
            t9.i.f(imageView, "mIvPoster");
            eVar.b(h10, fileUrl, imageView, R.drawable.bg_special_column_placeholder);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((PosterList) obj);
            return h9.t.f14242a;
        }
    }

    public static final class c extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageView f13675a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ImageView imageView) {
            super(1);
            this.f13675a = imageView;
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return h9.t.f14242a;
        }

        public final void invoke(Throwable th) {
            this.f13675a.setImageResource(R.drawable.bg_special_column_placeholder);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d2(Context context) {
        super(R.layout.adapter_recommend_horizontal_special_item, null, 2, null);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        this.f13671a = context;
    }

    public static final void e(d2 d2Var, BaseViewHolder baseViewHolder, View view) {
        t9.i.g(d2Var, "this$0");
        t9.i.g(baseViewHolder, "$helper");
        if (RootColumnId.specialColumn == null) {
            return;
        }
        Context context = d2Var.f13671a;
        t9.i.e(context, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
        com.mobile.brasiltv.utils.b0.d0((f5.c) context, SpecialAty.class, new a(baseViewHolder));
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
        ((AutoCardView) baseViewHolder.getView(R.id.mLayout)).setRadius(com.mobile.brasiltv.utils.s0.a(this.f13671a, 4.0f));
        ((AutoCardView) baseViewHolder.getView(R.id.mLayout)).setOnClickListener(new View.OnClickListener() { // from class: g5.a2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d2.e(d2.this, baseViewHolder, view);
            }
        });
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.mIvPoster);
        a7.d dVar = a7.d.f279a;
        Observable c10 = dVar.c(childColumnList.getPosterList(), dVar.j());
        final b bVar = new b(imageView);
        Consumer consumer = new Consumer() { // from class: g5.b2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                d2.f(s9.l.this, obj);
            }
        };
        final c cVar = new c(imageView);
        c10.subscribe(consumer, new Consumer() { // from class: g5.c2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                d2.g(s9.l.this, obj);
            }
        });
    }

    public final Context h() {
        return this.f13671a;
    }
}
