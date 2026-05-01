package g5;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hpplay.component.protocol.PlistBuilder;
import com.msandroid.mobile.R;
import com.zhy.autolayout.utils.AutoUtils;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.Arrays;
import mobile.com.requestframe.utils.response.Favorite;
import mobile.com.requestframe.utils.response.ShelvePoster;

/* loaded from: classes3.dex */
public final class d1 extends j5.a {

    /* renamed from: a, reason: collision with root package name */
    public final Context f13666a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f13667b;

    public static final class a extends t9.j implements s9.l {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BaseViewHolder f13669b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(BaseViewHolder baseViewHolder) {
            super(1);
            this.f13669b = baseViewHolder;
        }

        public final void b(ShelvePoster shelvePoster) {
            a7.e eVar = a7.e.f288a;
            Context context = ((BaseQuickAdapter) d1.this).mContext;
            t9.i.f(context, "mContext");
            String fileUrl = shelvePoster.getFileUrl();
            View view = this.f13669b.getView(R.id.mMyFavImage);
            t9.i.f(view, "helper.getView(R.id.mMyFavImage)");
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
        public final /* synthetic */ BaseViewHolder f13670a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(BaseViewHolder baseViewHolder) {
            super(1);
            this.f13670a = baseViewHolder;
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return h9.t.f14242a;
        }

        public final void invoke(Throwable th) {
            ((ImageView) this.f13670a.getView(R.id.mMyFavImage)).setImageResource(R.drawable.column_image_placeholder);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d1(Context context) {
        super(R.layout.adapter_my_fav_item, null, 2, null);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        this.f13666a = context;
    }

    public static final void e(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void f(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, Favorite favorite) {
        t9.i.g(baseViewHolder, "helper");
        t9.i.g(favorite, PlistBuilder.KEY_ITEM);
        if (this.f13667b) {
            ((ImageView) baseViewHolder.getView(R.id.itemCheckbox)).setVisibility(0);
        } else {
            ((ImageView) baseViewHolder.getView(R.id.itemCheckbox)).setVisibility(8);
        }
        ((TextView) baseViewHolder.getView(R.id.mMyFavScore)).setVisibility(0);
        boolean z10 = true;
        if (t9.i.b(favorite.getType(), "0")) {
            t9.z zVar = t9.z.f18964a;
            String string = this.f13666a.getResources().getString(R.string.recommend_episodes);
            t9.i.f(string, "context.resources.getStr…tring.recommend_episodes)");
            String format = String.format(string, Arrays.copyOf(new Object[]{favorite.getUpdateCount()}, 1));
            t9.i.f(format, "format(format, *args)");
            baseViewHolder.setText(R.id.mMyFavEpisode, format);
            baseViewHolder.setTextColor(R.id.mMyFavEpisode, this.f13666a.getResources().getColor(R.color.color_ffffff));
            baseViewHolder.setGone(R.id.mMyFavEpisode, true);
            baseViewHolder.setGone(R.id.mMyFavScore, false);
        } else {
            if (t9.i.a(favorite.getScore(), 0.0f)) {
                ((TextView) baseViewHolder.getView(R.id.mMyFavScore)).setVisibility(8);
            } else {
                ((TextView) baseViewHolder.getView(R.id.mMyFavScore)).setVisibility(0);
            }
            baseViewHolder.setText(R.id.mMyFavScore, String.valueOf(favorite.getScore()));
            baseViewHolder.setGone(R.id.mMyFavScore, true);
            baseViewHolder.setGone(R.id.mMyFavEpisode, false);
        }
        View view = baseViewHolder.getView(R.id.mMyFavName);
        t9.i.f(view, "helper.getView(R.id.mMyFavName)");
        TextView textView = (TextView) view;
        String alias = favorite.getAlias();
        String obj = alias != null ? ba.t.W(alias).toString() : null;
        String name = favorite.getName();
        com.mobile.brasiltv.utils.b0.d(textView, obj, name != null ? ba.t.W(name).toString() : null);
        a7.d dVar = a7.d.f279a;
        Observable l10 = dVar.l(favorite.getPosterList(), dVar.g());
        final a aVar = new a(baseViewHolder);
        Consumer consumer = new Consumer() { // from class: g5.b1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj2) {
                d1.e(s9.l.this, obj2);
            }
        };
        final b bVar = new b(baseViewHolder);
        l10.subscribe(consumer, new Consumer() { // from class: g5.c1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj2) {
                d1.f(s9.l.this, obj2);
            }
        });
        String contentType = favorite.getContentType();
        if ((contentType == null || contentType.length() == 0) || !t9.i.b(favorite.getContentType(), "1")) {
            ((ImageView) baseViewHolder.getView(R.id.mImageTs)).setVisibility(8);
        } else {
            ((ImageView) baseViewHolder.getView(R.id.mImageTs)).setVisibility(0);
        }
        Integer moreSubtitle = favorite.getMoreSubtitle();
        if (moreSubtitle != null && moreSubtitle.intValue() == 1) {
            ((ImageView) baseViewHolder.getView(R.id.mImageCC)).setVisibility(0);
        } else {
            ((ImageView) baseViewHolder.getView(R.id.mImageCC)).setVisibility(8);
        }
        Integer moreSubtitle2 = favorite.getMoreSubtitle();
        if (moreSubtitle2 == null || moreSubtitle2.intValue() != 1) {
            String contentType2 = favorite.getContentType();
            if (contentType2 != null && contentType2.length() != 0) {
                z10 = false;
            }
            if (z10 || !t9.i.b(favorite.getContentType(), "1")) {
                ((ImageView) baseViewHolder.getView(R.id.mImageCovered)).setVisibility(8);
                if (this.f13667b || !favorite.isSelect()) {
                    ((ImageView) baseViewHolder.getView(R.id.itemCheckbox)).setImageResource(R.drawable.icon_no_select);
                } else {
                    ((ImageView) baseViewHolder.getView(R.id.itemCheckbox)).setImageResource(R.drawable.icon_select);
                    return;
                }
            }
        }
        ((ImageView) baseViewHolder.getView(R.id.mImageCovered)).setVisibility(0);
        if (this.f13667b) {
        }
        ((ImageView) baseViewHolder.getView(R.id.itemCheckbox)).setImageResource(R.drawable.icon_no_select);
    }

    public final void g(boolean z10) {
        this.f13667b = z10;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.g
    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        t9.i.g(viewGroup, "parent");
        BaseViewHolder onCreateViewHolder = super.onCreateViewHolder(viewGroup, i10);
        t9.i.f(onCreateViewHolder, "super.onCreateViewHolder(parent, viewType)");
        AutoUtils.autoSize(onCreateViewHolder.convertView);
        return onCreateViewHolder;
    }
}
