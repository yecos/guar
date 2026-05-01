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
import mobile.com.requestframe.utils.response.ShelveAsset;
import mobile.com.requestframe.utils.response.ShelvePoster;

/* loaded from: classes3.dex */
public final class w extends j5.a {

    /* renamed from: a, reason: collision with root package name */
    public final Context f13942a;

    public static final class a extends t9.j implements s9.l {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BaseViewHolder f13944b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(BaseViewHolder baseViewHolder) {
            super(1);
            this.f13944b = baseViewHolder;
        }

        public final void b(ShelvePoster shelvePoster) {
            a7.e eVar = a7.e.f288a;
            Context context = ((BaseQuickAdapter) w.this).mContext;
            t9.i.f(context, "mContext");
            String fileUrl = shelvePoster.getFileUrl();
            View view = this.f13944b.getView(R.id.iv_columnImage);
            t9.i.f(view, "helper.getView(R.id.iv_columnImage)");
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
        public final /* synthetic */ BaseViewHolder f13945a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(BaseViewHolder baseViewHolder) {
            super(1);
            this.f13945a = baseViewHolder;
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return h9.t.f14242a;
        }

        public final void invoke(Throwable th) {
            ((ImageView) this.f13945a.getView(R.id.iv_columnImage)).setImageResource(R.drawable.column_image_placeholder);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(Context context) {
        super(R.layout.adapter_column_info_item, null, 2, null);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        this.f13942a = context;
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
    public void convert(BaseViewHolder baseViewHolder, ShelveAsset shelveAsset) {
        String format;
        t9.i.g(baseViewHolder, "helper");
        t9.i.g(shelveAsset, PlistBuilder.KEY_ITEM);
        boolean z10 = true;
        if (t9.i.b(shelveAsset.getType(), "0")) {
            if (shelveAsset.getUpdateCount() == shelveAsset.getVolumnCount()) {
                t9.z zVar = t9.z.f18964a;
                String string = this.f13942a.getResources().getString(R.string.recommend_episodes_all);
                t9.i.f(string, "context.resources.getStr…g.recommend_episodes_all)");
                format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(shelveAsset.getVolumnCount())}, 1));
                t9.i.f(format, "format(format, *args)");
            } else {
                t9.z zVar2 = t9.z.f18964a;
                String string2 = this.f13942a.getResources().getString(R.string.recommend_episodes);
                t9.i.f(string2, "context.resources.getStr…tring.recommend_episodes)");
                format = String.format(string2, Arrays.copyOf(new Object[]{Integer.valueOf(shelveAsset.getUpdateCount())}, 1));
                t9.i.f(format, "format(format, *args)");
            }
            baseViewHolder.setText(R.id.mTvEpisodeInfo, format);
            ((ImageView) baseViewHolder.getView(R.id.mImageCovered)).setVisibility(0);
            ((TextView) baseViewHolder.getView(R.id.mTvEpisodeInfo)).setVisibility(0);
            ((TextView) baseViewHolder.getView(R.id.tv_columnScore)).setVisibility(8);
            ((ImageView) baseViewHolder.getView(R.id.mImageTs)).setVisibility(8);
        } else {
            ((TextView) baseViewHolder.getView(R.id.mTvEpisodeInfo)).setVisibility(8);
            ((ImageView) baseViewHolder.getView(R.id.mImageCovered)).setVisibility(8);
            if (shelveAsset.getScore() == 0.0f) {
                ((TextView) baseViewHolder.getView(R.id.tv_columnScore)).setVisibility(8);
            } else {
                ((TextView) baseViewHolder.getView(R.id.tv_columnScore)).setVisibility(0);
            }
            baseViewHolder.setText(R.id.tv_columnScore, String.valueOf(shelveAsset.getScore()));
            String contentType = shelveAsset.getContentType();
            if (contentType != null && contentType.length() != 0) {
                z10 = false;
            }
            if (z10 || !t9.i.b(shelveAsset.getContentType(), "1")) {
                ((ImageView) baseViewHolder.getView(R.id.mImageTs)).setVisibility(8);
            } else {
                ((ImageView) baseViewHolder.getView(R.id.mImageTs)).setVisibility(0);
            }
        }
        View view = baseViewHolder.getView(R.id.tv_columnName);
        t9.i.f(view, "helper.getView(R.id.tv_columnName)");
        com.mobile.brasiltv.utils.b0.d((TextView) view, ba.t.W(shelveAsset.getAlias()).toString(), ba.t.W(shelveAsset.getName()).toString());
        a7.d dVar = a7.d.f279a;
        Observable l10 = dVar.l(shelveAsset.getPosterList(), dVar.g());
        final a aVar = new a(baseViewHolder);
        Consumer consumer = new Consumer() { // from class: g5.u
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                w.e(s9.l.this, obj);
            }
        };
        final b bVar = new b(baseViewHolder);
        l10.subscribe(consumer, new Consumer() { // from class: g5.v
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                w.f(s9.l.this, obj);
            }
        });
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
