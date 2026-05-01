package g5;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hpplay.component.protocol.PlistBuilder;
import com.mobile.brasiltv.bean.EnterType;
import com.mobile.brasiltv.view.AutoCardView;
import com.msandroid.mobile.R;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.Arrays;
import java.util.List;
import mobile.com.requestframe.utils.response.SearchShelveItem;
import mobile.com.requestframe.utils.response.ShelvePoster;

/* loaded from: classes3.dex */
public final class b3 extends j5.a {

    /* renamed from: a, reason: collision with root package name */
    public final f5.c f13644a;

    /* renamed from: b, reason: collision with root package name */
    public String f13645b;

    public static final class a extends t9.j implements s9.l {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BaseViewHolder f13647b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(BaseViewHolder baseViewHolder) {
            super(1);
            this.f13647b = baseViewHolder;
        }

        public final void b(ShelvePoster shelvePoster) {
            a7.e eVar = a7.e.f288a;
            Context context = ((BaseQuickAdapter) b3.this).mContext;
            t9.i.f(context, "mContext");
            String fileUrl = shelvePoster.getFileUrl();
            View view = this.f13647b.getView(R.id.posterImageView);
            t9.i.f(view, "helper.getView(R.id.posterImageView)");
            eVar.b(context, fileUrl, (ImageView) view, R.drawable.column_image_placeholder);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((ShelvePoster) obj);
            return h9.t.f14242a;
        }
    }

    public static final class b extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseViewHolder f13648a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(BaseViewHolder baseViewHolder) {
            super(1);
            this.f13648a = baseViewHolder;
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return h9.t.f14242a;
        }

        public final void invoke(Throwable th) {
            ((ImageView) this.f13648a.getView(R.id.posterImageView)).setImageResource(R.drawable.column_image_placeholder);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b3(f5.c cVar, List list) {
        super(R.layout.adapter_search_result_item, list);
        t9.i.g(cVar, com.umeng.analytics.pro.f.X);
        t9.i.g(list, "datas");
        this.f13644a = cVar;
        this.f13645b = "";
    }

    public static final void f(SearchShelveItem searchShelveItem, b3 b3Var, BaseViewHolder baseViewHolder, View view) {
        t9.i.g(searchShelveItem, "$item");
        t9.i.g(b3Var, "this$0");
        t9.i.g(baseViewHolder, "$helper");
        a7.d dVar = a7.d.f279a;
        String o10 = dVar.o(searchShelveItem.getPosterList(), dVar.g());
        if (o10 == null) {
            o10 = "";
        }
        String str = o10;
        Context context = b3Var.mContext;
        t9.i.e(context, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
        f5.c cVar = (f5.c) context;
        String type = searchShelveItem.getType();
        String programType = searchShelveItem.getProgramType();
        String contentId = searchShelveItem.getContentId();
        EnterType enterType = EnterType.SEARCH;
        String alias = searchShelveItem.getAlias();
        String obj = alias != null ? ba.t.W(alias).toString() : null;
        String name = searchShelveItem.getName();
        com.mobile.brasiltv.utils.b0.r(cVar, type, programType, contentId, enterType, com.mobile.brasiltv.utils.b0.c(obj, name != null ? ba.t.W(name).toString() : null), (r25 & 32) != 0 ? false : false, (r25 & 64) != 0 ? false : false, (r25 & 128) != 0 ? -1 : 0, (r25 & 256) != 0 ? "" : FirebaseAnalytics.Event.SEARCH, str);
        com.mobile.brasiltv.utils.i1.s(b3Var.mContext, b3Var.f13645b, ((TextView) baseViewHolder.getView(R.id.mPosterName)).getText().toString());
        com.mobile.brasiltv.utils.f.f8648a.a(b3Var.f13645b, ((TextView) baseViewHolder.getView(R.id.mPosterName)).getText().toString(), baseViewHolder.getPosition() + 1);
    }

    public static final void g(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void h(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void convert(final BaseViewHolder baseViewHolder, final SearchShelveItem searchShelveItem) {
        t9.i.g(baseViewHolder, "helper");
        t9.i.g(searchShelveItem, PlistBuilder.KEY_ITEM);
        ((TextView) baseViewHolder.getView(R.id.mPosterName)).setText(com.mobile.brasiltv.utils.b0.e(searchShelveItem.getAlias(), searchShelveItem.getName()));
        ((AutoCardView) baseViewHolder.getView(R.id.mLayout)).setOnClickListener(new View.OnClickListener() { // from class: g5.y2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b3.f(SearchShelveItem.this, this, baseViewHolder, view);
            }
        });
        if (t9.i.b(searchShelveItem.getType(), "0")) {
            k(baseViewHolder, searchShelveItem);
        } else {
            j(baseViewHolder, searchShelveItem);
        }
        a7.d dVar = a7.d.f279a;
        Observable l10 = dVar.l(searchShelveItem.getPosterList(), dVar.g());
        final a aVar = new a(baseViewHolder);
        Consumer consumer = new Consumer() { // from class: g5.z2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                b3.g(s9.l.this, obj);
            }
        };
        final b bVar = new b(baseViewHolder);
        l10.subscribe(consumer, new Consumer() { // from class: g5.a3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                b3.h(s9.l.this, obj);
            }
        });
    }

    public final void i(List list, String str) {
        t9.i.g(list, "data");
        t9.i.g(str, "searchKey");
        this.f13645b = str;
        super.setNewData(list);
    }

    public final void j(BaseViewHolder baseViewHolder, SearchShelveItem searchShelveItem) {
        ((TextView) baseViewHolder.getView(R.id.mSetInfo)).setVisibility(8);
        ((ImageView) baseViewHolder.getView(R.id.mImageCovered)).setVisibility(8);
        if (searchShelveItem.getScore() == 0.0f) {
            ((AutoCardView) baseViewHolder.getView(R.id.mAcvScoreWrapper)).setVisibility(8);
        } else {
            ((AutoCardView) baseViewHolder.getView(R.id.mAcvScoreWrapper)).setVisibility(0);
            baseViewHolder.setText(R.id.mScoreTv, String.valueOf(searchShelveItem.getScore()));
        }
    }

    public final void k(BaseViewHolder baseViewHolder, SearchShelveItem searchShelveItem) {
        String format;
        ((AutoCardView) baseViewHolder.getView(R.id.mAcvScoreWrapper)).setVisibility(8);
        if (searchShelveItem.getUpdateCount() == 0 && searchShelveItem.getVolumnCount() == 0) {
            ((TextView) baseViewHolder.getView(R.id.mSetInfo)).setVisibility(8);
            ((ImageView) baseViewHolder.getView(R.id.mImageCovered)).setVisibility(8);
            return;
        }
        if (searchShelveItem.getUpdateCount() == searchShelveItem.getVolumnCount()) {
            t9.z zVar = t9.z.f18964a;
            String string = this.f13644a.getResources().getString(R.string.recommend_episodes_all);
            t9.i.f(string, "context.resources.getStr…g.recommend_episodes_all)");
            format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(searchShelveItem.getVolumnCount())}, 1));
            t9.i.f(format, "format(format, *args)");
        } else {
            t9.z zVar2 = t9.z.f18964a;
            String string2 = this.f13644a.getResources().getString(R.string.recommend_episodes);
            t9.i.f(string2, "context.resources.getStr…tring.recommend_episodes)");
            format = String.format(string2, Arrays.copyOf(new Object[]{Integer.valueOf(searchShelveItem.getUpdateCount())}, 1));
            t9.i.f(format, "format(format, *args)");
        }
        ((TextView) baseViewHolder.getView(R.id.mSetInfo)).setVisibility(0);
        baseViewHolder.setText(R.id.mSetInfo, format);
        ((ImageView) baseViewHolder.getView(R.id.mImageCovered)).setVisibility(0);
    }
}
