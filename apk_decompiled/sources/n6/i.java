package n6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.hpplay.cybergarage.xml.XML;
import com.mobile.brasiltv.bean.AudioTrackBean;
import com.mobile.brasiltv.bean.NoSubTitleData;
import com.mobile.brasiltv.bean.OffSubTitleData;
import com.mobile.brasiltv.bean.SubTitleData;
import com.mobile.brasiltv.bean.SubtitleManager;
import com.mobile.brasiltv.bean.SubtitleStyleBean;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoFrameLayout;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.utils.AutoUtils;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class i extends RecyclerView.g {

    /* renamed from: a, reason: collision with root package name */
    public Context f17289a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f17290b;

    /* renamed from: c, reason: collision with root package name */
    public int f17291c;

    /* renamed from: d, reason: collision with root package name */
    public a f17292d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f17293e;

    public interface a {
        void a(int i10, Object obj);
    }

    public final class b extends RecyclerView.d0 {

        /* renamed from: a, reason: collision with root package name */
        public AutoFrameLayout f17294a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f17295b;

        /* renamed from: c, reason: collision with root package name */
        public AutoLinearLayout f17296c;

        /* renamed from: d, reason: collision with root package name */
        public ImageView f17297d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ i f17298e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(i iVar, View view) {
            super(view);
            t9.i.g(view, "itemView");
            this.f17298e = iVar;
            AutoUtils.autoSize(view);
            View findViewById = view.findViewById(R.id.mLayout);
            t9.i.f(findViewById, "itemView.findViewById(R.id.mLayout)");
            this.f17294a = (AutoFrameLayout) findViewById;
            View findViewById2 = view.findViewById(R.id.mTvOption);
            t9.i.f(findViewById2, "itemView.findViewById(R.id.mTvOption)");
            this.f17295b = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.mLlName);
            t9.i.f(findViewById3, "itemView.findViewById(R.id.mLlName)");
            this.f17296c = (AutoLinearLayout) findViewById3;
            View findViewById4 = view.findViewById(R.id.mIvSelected);
            t9.i.f(findViewById4, "itemView.findViewById(R.id.mIvSelected)");
            this.f17297d = (ImageView) findViewById4;
        }

        public final ImageView b() {
            return this.f17297d;
        }

        public final AutoFrameLayout c() {
            return this.f17294a;
        }

        public final AutoLinearLayout d() {
            return this.f17296c;
        }

        public final TextView e() {
            return this.f17295b;
        }
    }

    public i(Context context) {
        t9.i.g(context, "mContext");
        this.f17289a = context;
        this.f17290b = new ArrayList();
        this.f17293e = true;
    }

    public static final void c(i iVar, int i10, View view) {
        t9.i.g(iVar, "this$0");
        if (iVar.f17291c == i10) {
            return;
        }
        iVar.g(i10);
        a aVar = iVar.f17292d;
        if (aVar != null) {
            aVar.a(i10, iVar.f17290b.get(i10));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b bVar, final int i10) {
        String string;
        t9.i.g(bVar, "holder");
        if (this.f17290b.get(i10) instanceof String) {
            bVar.e().setText(String.valueOf(this.f17290b.get(i10)));
            bVar.c().setEnabled(this.f17293e);
            bVar.e().setEnabled(this.f17293e);
        } else if (this.f17290b.get(i10) instanceof SubtitleStyleBean) {
            Object obj = this.f17290b.get(i10);
            t9.i.e(obj, "null cannot be cast to non-null type com.mobile.brasiltv.bean.SubtitleStyleBean");
            SubtitleStyleBean subtitleStyleBean = (SubtitleStyleBean) obj;
            bVar.e().setText(this.f17289a.getString(R.string.Aa));
            bVar.d().setBackgroundColor(this.f17289a.getResources().getColor(R.color.color_424242));
            bVar.e().setBackgroundColor(subtitleStyleBean.getBackgrounrd());
            bVar.e().setTextColor(subtitleStyleBean.getColor());
            bVar.c().setEnabled(this.f17293e);
            bVar.e().setEnabled(this.f17293e);
            bVar.b().setEnabled(this.f17293e);
        } else if (this.f17290b.get(i10) instanceof SubTitleData) {
            Object obj2 = this.f17290b.get(i10);
            t9.i.e(obj2, "null cannot be cast to non-null type com.mobile.brasiltv.bean.SubTitleData");
            SubTitleData subTitleData = (SubTitleData) obj2;
            if (subTitleData instanceof NoSubTitleData) {
                bVar.e().setText(this.f17289a.getResources().getString(R.string.vod_no_subtitle));
            } else if (subTitleData instanceof OffSubTitleData) {
                bVar.e().setText(this.f17289a.getResources().getString(R.string.vod_disable_subtitle));
            } else {
                TextView e10 = bVar.e();
                String language = subTitleData.getLanguage();
                int hashCode = language.hashCode();
                if (hashCode == 3241) {
                    if (language.equals(XML.DEFAULT_CONTENT_LANGUAGE)) {
                        string = this.f17289a.getResources().getString(R.string.subtitle_language_en);
                        e10.setText(string);
                    }
                    string = subTitleData.getLanguage();
                    e10.setText(string);
                } else if (hashCode != 3246) {
                    if (hashCode == 3588 && language.equals("pt")) {
                        string = this.f17289a.getResources().getString(R.string.subtitle_language_pt);
                        e10.setText(string);
                    }
                    string = subTitleData.getLanguage();
                    e10.setText(string);
                } else {
                    if (language.equals("es")) {
                        string = this.f17289a.getResources().getString(R.string.subtitle_language_es);
                        e10.setText(string);
                    }
                    string = subTitleData.getLanguage();
                    e10.setText(string);
                }
            }
        } else if (this.f17290b.get(i10) instanceof AudioTrackBean) {
            Object obj3 = this.f17290b.get(i10);
            t9.i.e(obj3, "null cannot be cast to non-null type com.mobile.brasiltv.bean.AudioTrackBean");
            String realAudio = ((AudioTrackBean) obj3).getRealAudio();
            if ((realAudio.length() == 0) || t9.i.b(realAudio, "und")) {
                if (i10 == 0) {
                    realAudio = this.f17289a.getResources().getString(R.string.def);
                    t9.i.f(realAudio, "{\n                    mC…ng.def)\n                }");
                } else {
                    realAudio = this.f17289a.getResources().getString(R.string.def) + i10;
                }
            }
            bVar.e().setText(SubtitleManager.INSTANCE.getTranslateString(this.f17289a, realAudio));
        }
        if (this.f17291c == i10) {
            bVar.b().setVisibility(0);
            bVar.e().setSelected(true);
        } else {
            bVar.b().setVisibility(8);
            bVar.e().setSelected(false);
        }
        bVar.c().setOnClickListener(new View.OnClickListener() { // from class: n6.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i.c(i.this, i10, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup viewGroup, int i10) {
        t9.i.g(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f17289a).inflate(R.layout.item_vod_subtitle_audio_land, viewGroup, false);
        t9.i.f(inflate, "view");
        return new b(this, inflate);
    }

    public final void e(ArrayList arrayList) {
        t9.i.g(arrayList, "data");
        this.f17290b.clear();
        this.f17290b.addAll(arrayList);
    }

    public final void f(a aVar) {
        t9.i.g(aVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f17292d = aVar;
    }

    public final void g(int i10) {
        this.f17291c = i10;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.f17290b.size();
    }

    public final void h(boolean z10) {
        if ((this.f17290b.get(0) instanceof String) && this.f17293e != z10) {
            this.f17293e = z10;
            notifyDataSetChanged();
        }
        if (!(this.f17290b.get(0) instanceof SubtitleStyleBean) || this.f17293e == z10) {
            return;
        }
        this.f17293e = z10;
        notifyDataSetChanged();
    }
}
