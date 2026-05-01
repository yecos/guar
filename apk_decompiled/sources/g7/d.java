package g7;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.msandroid.mobile.R;

/* loaded from: classes3.dex */
public final class d extends b {

    /* renamed from: b, reason: collision with root package name */
    public final String f14000b;

    /* renamed from: c, reason: collision with root package name */
    public final BaseQuickAdapter f14001c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Activity activity, String str, BaseQuickAdapter baseQuickAdapter) {
        super(activity);
        t9.i.g(activity, "activity");
        t9.i.g(str, "mTitleStr");
        t9.i.g(baseQuickAdapter, "mAdapter");
        this.f14000b = str;
        this.f14001c = baseQuickAdapter;
        View inflate = LayoutInflater.from(activity).inflate(R.layout.pop_bottom, (ViewGroup) null);
        setContentView(inflate);
        setBackgroundDrawable(new ColorDrawable(0));
        TextView textView = (TextView) inflate.findViewById(R.id.tvTitle);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.ivClose);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.rvList);
        textView.setText(str);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: g7.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                d.g(d.this, view);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        recyclerView.setAdapter(baseQuickAdapter);
    }

    public static final void g(d dVar, View view) {
        t9.i.g(dVar, "this$0");
        dVar.dismiss();
    }
}
