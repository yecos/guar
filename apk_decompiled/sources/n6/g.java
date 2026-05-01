package n6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoFrameLayout;
import com.zhy.autolayout.utils.AutoUtils;
import java.util.ArrayList;
import mobile.com.requestframe.utils.response.ProgramSeason;

/* loaded from: classes3.dex */
public final class g extends RecyclerView.g {

    /* renamed from: a, reason: collision with root package name */
    public Context f17280a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f17281b;

    /* renamed from: c, reason: collision with root package name */
    public int f17282c;

    /* renamed from: d, reason: collision with root package name */
    public a f17283d;

    public interface a {
        void a(int i10, ProgramSeason programSeason);
    }

    public final class b extends RecyclerView.d0 {

        /* renamed from: a, reason: collision with root package name */
        public AutoFrameLayout f17284a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f17285b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ g f17286c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(g gVar, View view) {
            super(view);
            t9.i.g(view, "itemView");
            this.f17286c = gVar;
            AutoUtils.autoSize(view);
            View findViewById = view.findViewById(R.id.mLayout);
            t9.i.f(findViewById, "itemView.findViewById(R.id.mLayout)");
            this.f17284a = (AutoFrameLayout) findViewById;
            View findViewById2 = view.findViewById(R.id.mTvSeason);
            t9.i.f(findViewById2, "itemView.findViewById(R.id.mTvSeason)");
            this.f17285b = (TextView) findViewById2;
        }

        public final AutoFrameLayout b() {
            return this.f17284a;
        }

        public final TextView c() {
            return this.f17285b;
        }
    }

    public g(Context context) {
        t9.i.g(context, "mContext");
        this.f17280a = context;
        this.f17281b = new ArrayList();
    }

    public static final void c(g gVar, int i10, View view) {
        t9.i.g(gVar, "this$0");
        gVar.g(i10);
        a aVar = gVar.f17283d;
        if (aVar != null) {
            Object obj = gVar.f17281b.get(i10);
            t9.i.f(obj, "mData[position]");
            aVar.a(i10, (ProgramSeason) obj);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b bVar, final int i10) {
        t9.i.g(bVar, "holder");
        Object obj = this.f17281b.get(i10);
        t9.i.f(obj, "mData[position]");
        bVar.c().setText(this.f17280a.getString(R.string.vod_season, Integer.valueOf(((ProgramSeason) obj).getSeasonNumber())));
        bVar.c().setSelected(this.f17282c == i10);
        bVar.b().setOnClickListener(new View.OnClickListener() { // from class: n6.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g.c(g.this, i10, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup viewGroup, int i10) {
        t9.i.g(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f17280a).inflate(R.layout.item_season_pop_window, viewGroup, false);
        t9.i.f(inflate, "view");
        return new b(this, inflate);
    }

    public final void e(ArrayList arrayList) {
        t9.i.g(arrayList, "data");
        this.f17281b.clear();
        this.f17281b.addAll(arrayList);
    }

    public final void f(a aVar) {
        t9.i.g(aVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f17283d = aVar;
    }

    public final void g(int i10) {
        this.f17282c = i10;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.f17281b.size();
    }
}
