package g5;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.android.gms.cast.MediaError;
import com.hpplay.component.protocol.PlistBuilder;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.mobile.brasiltv.bean.EnterType;
import com.mobile.brasiltv.view.AutoCardView;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.utils.AutoUtils;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.Arrays;
import mobile.com.requestframe.utils.response.ShelveAsset;
import mobile.com.requestframe.utils.response.ShelvePoster;

/* loaded from: classes3.dex */
public final class y1 extends j5.a {

    /* renamed from: a, reason: collision with root package name */
    public final Context f13964a;

    /* renamed from: b, reason: collision with root package name */
    public final int f13965b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f13966c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f13967d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f13968e;

    /* renamed from: f, reason: collision with root package name */
    public final String f13969f;

    public static final class a extends t9.j implements s9.l {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BaseViewHolder f13971b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(BaseViewHolder baseViewHolder) {
            super(1);
            this.f13971b = baseViewHolder;
        }

        public final void b(ShelvePoster shelvePoster) {
            a7.e eVar = a7.e.f288a;
            Context context = ((BaseQuickAdapter) y1.this).mContext;
            t9.i.f(context, "mContext");
            String fileUrl = shelvePoster.getFileUrl();
            View view = this.f13971b.getView(R.id.posterImageView);
            t9.i.f(view, "helper.getView(R.id.posterImageView)");
            eVar.b(context, fileUrl, (ImageView) view, R.drawable.special_cloumn_img_placeholder);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((ShelvePoster) obj);
            return h9.t.f14242a;
        }
    }

    public static final class b extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseViewHolder f13972a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(BaseViewHolder baseViewHolder) {
            super(1);
            this.f13972a = baseViewHolder;
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return h9.t.f14242a;
        }

        public final void invoke(Throwable th) {
            ((ImageView) this.f13972a.getView(R.id.posterImageView)).setImageResource(R.drawable.special_cloumn_img_placeholder);
        }
    }

    public /* synthetic */ y1(Context context, int i10, boolean z10, boolean z11, boolean z12, String str, int i11, t9.g gVar) {
        this(context, i10, (i11 & 4) != 0 ? false : z10, (i11 & 8) != 0 ? false : z11, (i11 & 16) != 0 ? false : z12, (i11 & 32) != 0 ? "" : str);
    }

    public static final void f(ShelveAsset shelveAsset, y1 y1Var, View view) {
        t9.i.g(shelveAsset, "$item");
        t9.i.g(y1Var, "this$0");
        a7.d dVar = a7.d.f279a;
        String o10 = dVar.o(shelveAsset.getPosterList(), dVar.g());
        if (o10 == null) {
            o10 = "";
        }
        String str = o10;
        StringBuilder sb = new StringBuilder();
        sb.append(shelveAsset.getType());
        sb.append(ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN);
        sb.append(shelveAsset.getProgramType());
        sb.append(ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN);
        sb.append(shelveAsset.getContentId());
        sb.append(ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN);
        EnterType enterType = EnterType.CATEGORY;
        sb.append(enterType);
        sb.append(ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN);
        sb.append(ba.t.W(shelveAsset.getAlias()).toString());
        sb.append(ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN);
        sb.append(ba.t.W(shelveAsset.getName()).toString());
        Context context = y1Var.mContext;
        t9.i.e(context, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
        com.mobile.brasiltv.utils.b0.r((f5.c) context, shelveAsset.getType(), shelveAsset.getProgramType(), shelveAsset.getContentId(), enterType, com.mobile.brasiltv.utils.b0.c(ba.t.W(shelveAsset.getAlias()).toString(), ba.t.W(shelveAsset.getName()).toString()), y1Var.f13968e, false, y1Var.f13965b, y1Var.f13969f, str);
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
    public void convert(BaseViewHolder baseViewHolder, final ShelveAsset shelveAsset) {
        String i10;
        String format;
        t9.i.g(baseViewHolder, "helper");
        t9.i.g(shelveAsset, PlistBuilder.KEY_ITEM);
        ((AutoCardView) baseViewHolder.getView(R.id.mLayout)).setOnClickListener(new View.OnClickListener() { // from class: g5.v1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                y1.f(ShelveAsset.this, this, view);
            }
        });
        boolean z10 = true;
        if (!t9.i.b(shelveAsset.getType(), "0") || this.f13966c) {
            ((ImageView) baseViewHolder.getView(R.id.mImageCovered)).setVisibility(8);
            ((TextView) baseViewHolder.getView(R.id.mTvEpisodeInfo)).setVisibility(8);
        } else {
            if (shelveAsset.getUpdateCount() == shelveAsset.getVolumnCount()) {
                t9.z zVar = t9.z.f18964a;
                String string = this.f13964a.getResources().getString(R.string.recommend_episodes_all);
                t9.i.f(string, "context.resources.getStr…g.recommend_episodes_all)");
                format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(shelveAsset.getVolumnCount())}, 1));
                t9.i.f(format, "format(format, *args)");
            } else {
                t9.z zVar2 = t9.z.f18964a;
                String string2 = this.f13964a.getResources().getString(R.string.recommend_episodes);
                t9.i.f(string2, "context.resources.getStr…tring.recommend_episodes)");
                format = String.format(string2, Arrays.copyOf(new Object[]{Integer.valueOf(shelveAsset.getUpdateCount())}, 1));
                t9.i.f(format, "format(format, *args)");
            }
            baseViewHolder.setText(R.id.mTvEpisodeInfo, format);
            baseViewHolder.setTextColor(R.id.mTvEpisodeInfo, this.f13964a.getResources().getColor(R.color.color_ffffff));
            ((TextView) baseViewHolder.getView(R.id.mTvEpisodeInfo)).setVisibility(0);
            ((ImageView) baseViewHolder.getView(R.id.mImageCovered)).setVisibility(0);
        }
        String contentType = shelveAsset.getContentType();
        if (contentType != null && contentType.length() != 0) {
            z10 = false;
        }
        if (z10 || !t9.i.b(shelveAsset.getContentType(), "1")) {
            ((ImageView) baseViewHolder.getView(R.id.mImageTs)).setVisibility(8);
        } else {
            ((ImageView) baseViewHolder.getView(R.id.mImageTs)).setVisibility(0);
        }
        View view = baseViewHolder.getView(R.id.mPosterName);
        t9.i.f(view, "helper.getView<TextView>(R.id.mPosterName)");
        com.mobile.brasiltv.utils.b0.d((TextView) view, ba.t.W(shelveAsset.getAlias()).toString(), ba.t.W(shelveAsset.getName()).toString());
        View view2 = baseViewHolder.getView(R.id.mPosterNameSpecial);
        t9.i.f(view2, "helper.getView<TextView>(R.id.mPosterNameSpecial)");
        com.mobile.brasiltv.utils.b0.d((TextView) view2, ba.t.W(shelveAsset.getAlias()).toString(), ba.t.W(shelveAsset.getName()).toString());
        a7.d dVar = a7.d.f279a;
        dVar.i();
        if (this.f13966c) {
            i10 = dVar.g();
            ((AutoLinearLayout) baseViewHolder.getView(R.id.mLinearLayout)).setPadding(7, 7, 7, 0);
            ((AutoLinearLayout) baseViewHolder.getView(R.id.mLinearLayout)).setBackgroundResource(R.drawable.bg_radius_white);
            ((AutoCardView) baseViewHolder.getView(R.id.mLayout)).setLayoutParams(new LinearLayout.LayoutParams(AutoUtils.getPercentWidthSize(210), AutoUtils.getPercentWidthSize(MediaError.DetailedErrorCode.HLS_NETWORK_INVALID_SEGMENT)));
            ((TextView) baseViewHolder.getView(R.id.mPosterNameSpecial)).setVisibility(0);
            ((TextView) baseViewHolder.getView(R.id.mPosterName)).setVisibility(8);
        } else {
            i10 = !this.f13967d ? dVar.i() : dVar.g();
            ((AutoLinearLayout) baseViewHolder.getView(R.id.mLinearLayout)).setBackgroundResource(0);
            ((TextView) baseViewHolder.getView(R.id.mPosterName)).setVisibility(0);
            ((TextView) baseViewHolder.getView(R.id.mPosterNameSpecial)).setVisibility(8);
        }
        Observable l10 = dVar.l(shelveAsset.getPosterList(), i10);
        final a aVar = new a(baseViewHolder);
        Consumer consumer = new Consumer() { // from class: g5.w1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                y1.g(s9.l.this, obj);
            }
        };
        final b bVar = new b(baseViewHolder);
        l10.subscribe(consumer, new Consumer() { // from class: g5.x1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                y1.h(s9.l.this, obj);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y1(Context context, int i10, boolean z10, boolean z11, boolean z12, String str) {
        super(R.layout.adapter_recommend_horizontal_item, null, 2, null);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(str, "tdcFrom");
        this.f13964a = context;
        this.f13965b = i10;
        this.f13966c = z10;
        this.f13967d = z11;
        this.f13968e = z12;
        this.f13969f = str;
    }
}
