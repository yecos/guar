package g5;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
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
public final class n2 extends j5.a {

    /* renamed from: a, reason: collision with root package name */
    public final Context f13800a;

    public static final class a extends t9.j implements s9.l {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ t9.w f13802b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(t9.w wVar) {
            super(1);
            this.f13802b = wVar;
        }

        public final void b(ShelvePoster shelvePoster) {
            a7.e eVar = a7.e.f288a;
            Context context = n2.this.f13800a;
            String fileUrl = shelvePoster.getFileUrl();
            Object obj = this.f13802b.f18961a;
            t9.i.f(obj, "mIvPoster");
            eVar.b(context, fileUrl, (ImageView) obj, R.drawable.special_cloumn_img_placeholder);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((ShelvePoster) obj);
            return h9.t.f14242a;
        }
    }

    public static final class b extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t9.w f13803a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(t9.w wVar) {
            super(1);
            this.f13803a = wVar;
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return h9.t.f14242a;
        }

        public final void invoke(Throwable th) {
            ((ImageView) this.f13803a.f18961a).setImageResource(R.drawable.special_cloumn_img_placeholder);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n2(Context context) {
        super(R.layout.adapter_top_ten_new_item, null, 2, null);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        this.f13800a = context;
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
        t9.i.g(baseViewHolder, "holder");
        t9.i.g(shelveAsset, PlistBuilder.KEY_ITEM);
        TextView textView = (TextView) baseViewHolder.getView(R.id.mTvEpisodeInfo);
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.mIvCovered);
        TextView textView2 = (TextView) baseViewHolder.getView(R.id.mTvProgramName);
        ImageView imageView2 = (ImageView) baseViewHolder.getView(R.id.mIvTs);
        ImageView imageView3 = (ImageView) baseViewHolder.getView(R.id.mIvTop);
        t9.w wVar = new t9.w();
        wVar.f18961a = baseViewHolder.getView(R.id.mIvPoster);
        boolean z10 = true;
        if (t9.i.b(shelveAsset.getType(), "0")) {
            if (shelveAsset.getUpdateCount() == shelveAsset.getVolumnCount()) {
                t9.z zVar = t9.z.f18964a;
                String string = this.f13800a.getResources().getString(R.string.recommend_episodes_all);
                t9.i.f(string, "context.resources.getStr…g.recommend_episodes_all)");
                format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(shelveAsset.getVolumnCount())}, 1));
                t9.i.f(format, "format(format, *args)");
            } else {
                t9.z zVar2 = t9.z.f18964a;
                String string2 = this.f13800a.getResources().getString(R.string.recommend_episodes);
                t9.i.f(string2, "context.resources.getStr…tring.recommend_episodes)");
                format = String.format(string2, Arrays.copyOf(new Object[]{Integer.valueOf(shelveAsset.getUpdateCount())}, 1));
                t9.i.f(format, "format(format, *args)");
            }
            textView.setText(format);
            textView.setVisibility(0);
            imageView.setVisibility(0);
        } else {
            textView.setVisibility(8);
            imageView.setVisibility(8);
        }
        t9.i.f(textView2, "mTvProgramName");
        String alias = shelveAsset.getAlias();
        com.mobile.brasiltv.utils.b0.d(textView2, alias != null ? ba.t.W(alias).toString() : null, ba.t.W(shelveAsset.getName()).toString());
        String contentType = shelveAsset.getContentType();
        if (contentType != null && contentType.length() != 0) {
            z10 = false;
        }
        if (z10 || !t9.i.b(shelveAsset.getContentType(), "1")) {
            imageView2.setVisibility(8);
        } else {
            imageView2.setVisibility(0);
        }
        switch (baseViewHolder.getAdapterPosition()) {
            case 0:
                imageView3.setImageResource(R.drawable.icon_top_1);
                break;
            case 1:
                imageView3.setImageResource(R.drawable.icon_top_2);
                break;
            case 2:
                imageView3.setImageResource(R.drawable.icon_top_3);
                break;
            case 3:
                imageView3.setImageResource(R.drawable.icon_top_4);
                break;
            case 4:
                imageView3.setImageResource(R.drawable.icon_top_5);
                break;
            case 5:
                imageView3.setImageResource(R.drawable.icon_top_6);
                break;
            case 6:
                imageView3.setImageResource(R.drawable.icon_top_7);
                break;
            case 7:
                imageView3.setImageResource(R.drawable.icon_top_8);
                break;
            case 8:
                imageView3.setImageResource(R.drawable.icon_top_9);
                break;
            case 9:
                imageView3.setImageResource(R.drawable.icon_top_10);
                break;
        }
        a7.d dVar = a7.d.f279a;
        Observable l10 = dVar.l(shelveAsset.getPosterList(), dVar.g());
        final a aVar = new a(wVar);
        Consumer consumer = new Consumer() { // from class: g5.l2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                n2.e(s9.l.this, obj);
            }
        };
        final b bVar = new b(wVar);
        l10.subscribe(consumer, new Consumer() { // from class: g5.m2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                n2.f(s9.l.this, obj);
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
