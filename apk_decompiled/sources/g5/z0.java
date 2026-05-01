package g5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.db.Album;
import com.msandroid.mobile.R;
import com.zhy.autolayout.utils.AutoUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public final class z0 extends RecyclerView.g {

    /* renamed from: a, reason: collision with root package name */
    public final Context f13978a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f13979b;

    /* renamed from: c, reason: collision with root package name */
    public a f13980c;

    public interface a {
        void a(Album album, int i10);
    }

    public static final class b extends RecyclerView.d0 {

        /* renamed from: a, reason: collision with root package name */
        public ImageView f13981a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f13982b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View view) {
            super(view);
            t9.i.g(view, "itemView");
            View findViewById = view.findViewById(R.id.mIvPoster);
            t9.i.e(findViewById, "null cannot be cast to non-null type android.widget.ImageView");
            this.f13981a = (ImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.mTvProgramName);
            t9.i.e(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
            this.f13982b = (TextView) findViewById2;
            AutoUtils.autoSize(view);
        }
    }

    public z0(Context context, ArrayList arrayList) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(arrayList, "mData");
        this.f13978a = context;
        this.f13979b = arrayList;
    }

    public static final void c(z0 z0Var, Album album, int i10, View view) {
        t9.i.g(z0Var, "this$0");
        t9.i.g(album, "$album");
        a aVar = z0Var.f13980c;
        if (aVar != null) {
            aVar.a(album, i10);
        }
    }

    public final void b(List list) {
        t9.i.g(list, "data");
        this.f13979b.clear();
        this.f13979b.addAll(list);
        notifyDataSetChanged();
    }

    public final void d(a aVar) {
        t9.i.g(aVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f13980c = aVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        int size = this.f13979b.size();
        if (size > 10) {
            return 10;
        }
        return size;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void onBindViewHolder(RecyclerView.d0 d0Var, final int i10) {
        t9.i.g(d0Var, "holder");
        Object obj = this.f13979b.get(i10);
        t9.i.f(obj, "mData[position]");
        final Album album = (Album) obj;
        a7.e eVar = a7.e.f288a;
        Context context = this.f13978a;
        String posterUrl = album.getPosterUrl();
        ImageView imageView = (ImageView) d0Var.itemView.findViewById(R$id.mIvPoster);
        t9.i.f(imageView, "holder.itemView.mIvPoster");
        eVar.b(context, posterUrl, imageView, R.drawable.special_cloumn_img_placeholder);
        ((TextView) d0Var.itemView.findViewById(R$id.mTvProgramName)).setText(com.mobile.brasiltv.utils.b0.e(album.getAlias(), album.getName()));
        d0Var.itemView.setOnClickListener(new View.OnClickListener() { // from class: g5.y0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                z0.c(z0.this, album, i10, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.d0 onCreateViewHolder(ViewGroup viewGroup, int i10) {
        t9.i.g(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f13978a).inflate(R.layout.adapter_mine_home_record_item, viewGroup, false);
        t9.i.f(inflate, "view");
        return new b(inflate);
    }
}
