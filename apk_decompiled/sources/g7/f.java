package g7;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.msandroid.mobile.R;

/* loaded from: classes3.dex */
public final class f extends b {

    /* renamed from: b, reason: collision with root package name */
    public final BaseQuickAdapter f14003b;

    /* renamed from: c, reason: collision with root package name */
    public final View f14004c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f14005d;

    /* renamed from: e, reason: collision with root package name */
    public final ImageView f14006e;

    /* renamed from: f, reason: collision with root package name */
    public final RecyclerView f14007f;

    /* renamed from: g, reason: collision with root package name */
    public final TextView f14008g;

    /* renamed from: h, reason: collision with root package name */
    public View.OnClickListener f14009h;

    /* renamed from: i, reason: collision with root package name */
    public final FrameLayout f14010i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Activity activity, String str, BaseQuickAdapter baseQuickAdapter) {
        super(activity);
        t9.i.g(activity, "activity");
        t9.i.g(str, "mTitleStr");
        t9.i.g(baseQuickAdapter, "mAdapter");
        this.f14003b = baseQuickAdapter;
        View inflate = LayoutInflater.from(activity).inflate(R.layout.pop_bottom_coupon, (ViewGroup) null);
        t9.i.f(inflate, "from(activity).inflate(R…t.pop_bottom_coupon,null)");
        this.f14004c = inflate;
        View findViewById = inflate.findViewById(R.id.tvTitle);
        t9.i.f(findViewById, "view.findViewById(R.id.tvTitle)");
        TextView textView = (TextView) findViewById;
        this.f14005d = textView;
        View findViewById2 = inflate.findViewById(R.id.ivClose);
        t9.i.f(findViewById2, "view.findViewById(R.id.ivClose)");
        ImageView imageView = (ImageView) findViewById2;
        this.f14006e = imageView;
        View findViewById3 = inflate.findViewById(R.id.rvList);
        t9.i.f(findViewById3, "view.findViewById(R.id.rvList)");
        RecyclerView recyclerView = (RecyclerView) findViewById3;
        this.f14007f = recyclerView;
        View findViewById4 = inflate.findViewById(R.id.btnTitle);
        t9.i.f(findViewById4, "view.findViewById(R.id.btnTitle)");
        this.f14008g = (TextView) findViewById4;
        View findViewById5 = inflate.findViewById(R.id.retrieveAllLoadingLayout);
        t9.i.f(findViewById5, "view.findViewById(R.id.retrieveAllLoadingLayout)");
        this.f14010i = (FrameLayout) findViewById5;
        setContentView(inflate);
        setBackgroundDrawable(new ColorDrawable(0));
        textView.setText(str);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: g7.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.g(f.this, view);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        recyclerView.setAdapter(baseQuickAdapter);
    }

    public static final void g(f fVar, View view) {
        t9.i.g(fVar, "this$0");
        fVar.dismiss();
    }

    public final void h() {
        this.f14010i.setVisibility(8);
    }

    public final void i(View.OnClickListener onClickListener) {
        this.f14009h = onClickListener;
        this.f14008g.setOnClickListener(onClickListener);
    }

    public final void j() {
        ViewGroup.LayoutParams layoutParams = this.f14005d.getLayoutParams();
        t9.i.e(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.addRule(14);
        this.f14005d.setLayoutParams(layoutParams2);
    }

    public final void k(String str) {
        t9.i.g(str, "btnTitleStr");
        View findViewById = this.f14004c.findViewById(R.id.btnTitleLayout);
        t9.i.f(findViewById, "view.findViewById(R.id.btnTitleLayout)");
        ((RelativeLayout) findViewById).setVisibility(0);
        this.f14008g.setText(str);
    }

    public final void l() {
        View findViewById = this.f14004c.findViewById(R.id.line);
        t9.i.f(findViewById, "view.findViewById(R.id.line)");
        findViewById.setVisibility(0);
    }

    public final void m() {
        View findViewById = this.f14004c.findViewById(R.id.titleLayout);
        t9.i.f(findViewById, "view.findViewById(R.id.titleLayout)");
        ViewGroup.LayoutParams layoutParams = this.f14010i.getLayoutParams();
        layoutParams.height = getContentView().getMeasuredHeight() - ((RelativeLayout) findViewById).getMeasuredHeight();
        this.f14010i.setLayoutParams(layoutParams);
        this.f14010i.setVisibility(0);
    }
}
