package g5;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hpplay.component.protocol.PlistBuilder;
import com.msandroid.mobile.R;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import mobile.com.requestframe.utils.response.ShelveAsset;
import mobile.com.requestframe.utils.response.ShelvePoster;

/* loaded from: classes3.dex */
public final class g2 extends j5.a {

    /* renamed from: a, reason: collision with root package name */
    public Context f13705a;

    public static final class a extends t9.j implements s9.l {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ImageView f13707b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ImageView imageView) {
            super(1);
            this.f13707b = imageView;
        }

        public final void b(ShelvePoster shelvePoster) {
            a7.e eVar = a7.e.f288a;
            Context f10 = g2.this.f();
            String fileUrl = shelvePoster.getFileUrl();
            ImageView imageView = this.f13707b;
            t9.i.f(imageView, "mIvPoster");
            eVar.b(f10, fileUrl, imageView, R.drawable.bg_special_column_placeholder);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((ShelvePoster) obj);
            return h9.t.f14242a;
        }
    }

    public static final class b extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageView f13708a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ImageView imageView) {
            super(1);
            this.f13708a = imageView;
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return h9.t.f14242a;
        }

        public final void invoke(Throwable th) {
            this.f13708a.setImageResource(R.drawable.bg_special_column_placeholder);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g2(Context context) {
        super(R.layout.adapter_home_horizontal_special_item, null, 2, null);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        this.f13705a = context;
    }

    public static final void d(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void e(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, ShelveAsset shelveAsset) {
        t9.i.g(baseViewHolder, "helper");
        t9.i.g(shelveAsset, PlistBuilder.KEY_ITEM);
        if (com.mobile.brasiltv.utils.f0.b() || TextUtils.isEmpty(shelveAsset.getAlias())) {
            baseViewHolder.setText(R.id.mTvEpisodeInfo, shelveAsset.getName());
        } else {
            baseViewHolder.setText(R.id.mTvEpisodeInfo, shelveAsset.getAlias());
        }
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.mIvPoster);
        a7.d dVar = a7.d.f279a;
        Observable l10 = dVar.l(shelveAsset.getPosterList(), dVar.i());
        final a aVar = new a(imageView);
        Consumer consumer = new Consumer() { // from class: g5.e2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                g2.d(s9.l.this, obj);
            }
        };
        final b bVar = new b(imageView);
        l10.subscribe(consumer, new Consumer() { // from class: g5.f2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                g2.e(s9.l.this, obj);
            }
        });
    }

    public final Context f() {
        return this.f13705a;
    }
}
