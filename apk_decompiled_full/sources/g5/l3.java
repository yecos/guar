package g5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoFrameLayout;
import com.zhy.autolayout.utils.AutoUtils;

/* loaded from: classes3.dex */
public final class l3 extends RecyclerView.g {

    /* renamed from: a, reason: collision with root package name */
    public Context f13773a;

    /* renamed from: b, reason: collision with root package name */
    public String[] f13774b;

    /* renamed from: c, reason: collision with root package name */
    public s9.l f13775c;

    /* renamed from: d, reason: collision with root package name */
    public int f13776d;

    public final class a extends RecyclerView.d0 {

        /* renamed from: a, reason: collision with root package name */
        public AutoFrameLayout f13777a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f13778b;

        /* renamed from: c, reason: collision with root package name */
        public ImageView f13779c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ l3 f13780d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(l3 l3Var, View view) {
            super(view);
            t9.i.g(view, "itemView");
            this.f13780d = l3Var;
            AutoUtils.autoSize(view);
            View findViewById = view.findViewById(R.id.mLayout);
            t9.i.f(findViewById, "itemView.findViewById(R.id.mLayout)");
            this.f13777a = (AutoFrameLayout) findViewById;
            View findViewById2 = view.findViewById(R.id.mTvOption);
            t9.i.f(findViewById2, "itemView.findViewById(R.id.mTvOption)");
            this.f13778b = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.mIvSelected);
            t9.i.f(findViewById3, "itemView.findViewById(R.id.mIvSelected)");
            this.f13779c = (ImageView) findViewById3;
        }

        public final ImageView b() {
            return this.f13779c;
        }

        public final AutoFrameLayout c() {
            return this.f13777a;
        }

        public final TextView d() {
            return this.f13778b;
        }
    }

    public l3(Context context, String[] strArr, s9.l lVar) {
        t9.i.g(context, "mContext");
        t9.i.g(strArr, "mOptions");
        t9.i.g(lVar, "mItemClickListener");
        this.f13773a = context;
        this.f13774b = strArr;
        this.f13775c = lVar;
    }

    public static final void c(l3 l3Var, int i10, View view) {
        t9.i.g(l3Var, "this$0");
        l3Var.f13776d = i10;
        l3Var.f13775c.invoke(Integer.valueOf(i10));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a aVar, final int i10) {
        t9.i.g(aVar, "holder");
        aVar.d().setText(this.f13774b[i10]);
        aVar.b().setVisibility(this.f13776d == i10 ? 0 : 8);
        aVar.c().setOnClickListener(new View.OnClickListener() { // from class: g5.k3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                l3.c(l3.this, i10, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup viewGroup, int i10) {
        t9.i.g(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f13773a).inflate(R.layout.item_subtitle_options, viewGroup, false);
        t9.i.f(inflate, "view");
        return new a(this, inflate);
    }

    public final void e(int i10) {
        this.f13776d = i10;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.f13774b.length;
    }
}
