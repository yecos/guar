package g5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.mobile.brasiltv.bean.SubtitleStyleBean;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoFrameLayout;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.utils.AutoUtils;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class n3 extends RecyclerView.g {

    /* renamed from: a, reason: collision with root package name */
    public Context f13804a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f13805b;

    /* renamed from: c, reason: collision with root package name */
    public s9.l f13806c;

    /* renamed from: d, reason: collision with root package name */
    public int f13807d;

    public final class a extends RecyclerView.d0 {

        /* renamed from: a, reason: collision with root package name */
        public AutoFrameLayout f13808a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f13809b;

        /* renamed from: c, reason: collision with root package name */
        public AutoLinearLayout f13810c;

        /* renamed from: d, reason: collision with root package name */
        public ImageView f13811d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ n3 f13812e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(n3 n3Var, View view) {
            super(view);
            t9.i.g(view, "itemView");
            this.f13812e = n3Var;
            AutoUtils.autoSize(view);
            View findViewById = view.findViewById(R.id.mLayout);
            t9.i.f(findViewById, "itemView.findViewById(R.id.mLayout)");
            this.f13808a = (AutoFrameLayout) findViewById;
            View findViewById2 = view.findViewById(R.id.mTvOption);
            t9.i.f(findViewById2, "itemView.findViewById(R.id.mTvOption)");
            this.f13809b = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.mLlBg);
            t9.i.f(findViewById3, "itemView.findViewById(R.id.mLlBg)");
            this.f13810c = (AutoLinearLayout) findViewById3;
            View findViewById4 = view.findViewById(R.id.mIvSelected);
            t9.i.f(findViewById4, "itemView.findViewById(R.id.mIvSelected)");
            this.f13811d = (ImageView) findViewById4;
        }

        public final ImageView b() {
            return this.f13811d;
        }

        public final AutoFrameLayout c() {
            return this.f13808a;
        }

        public final AutoLinearLayout d() {
            return this.f13810c;
        }

        public final TextView e() {
            return this.f13809b;
        }
    }

    public n3(Context context, ArrayList arrayList, s9.l lVar) {
        t9.i.g(context, "mContext");
        t9.i.g(arrayList, "mOptions");
        t9.i.g(lVar, "mItemClickListener");
        this.f13804a = context;
        this.f13805b = arrayList;
        this.f13806c = lVar;
    }

    public static final void c(n3 n3Var, int i10, View view) {
        t9.i.g(n3Var, "this$0");
        n3Var.f13807d = i10;
        n3Var.f13806c.invoke(Integer.valueOf(i10));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a aVar, final int i10) {
        t9.i.g(aVar, "holder");
        Object obj = this.f13805b.get(i10);
        t9.i.e(obj, "null cannot be cast to non-null type com.mobile.brasiltv.bean.SubtitleStyleBean");
        SubtitleStyleBean subtitleStyleBean = (SubtitleStyleBean) obj;
        aVar.e().setText(this.f13804a.getString(R.string.Aa));
        aVar.e().setTextColor(subtitleStyleBean.getColor());
        aVar.d().setBackgroundColor(subtitleStyleBean.getBackgrounrd());
        aVar.b().setVisibility(this.f13807d == i10 ? 0 : 8);
        aVar.c().setOnClickListener(new View.OnClickListener() { // from class: g5.m3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                n3.c(n3.this, i10, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup viewGroup, int i10) {
        t9.i.g(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f13804a).inflate(R.layout.item_subtitle_style_options, viewGroup, false);
        t9.i.f(inflate, "view");
        return new a(this, inflate);
    }

    public final void e(int i10) {
        this.f13807d = i10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.f13805b.size();
    }
}
