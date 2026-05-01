package g5;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.msandroid.mobile.R;
import java.util.ArrayList;
import mobile.com.requestframe.utils.response.Channel;

/* loaded from: classes3.dex */
public final class x2 extends RecyclerView.g {

    /* renamed from: a, reason: collision with root package name */
    public Context f13955a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f13956b;

    /* renamed from: c, reason: collision with root package name */
    public a f13957c;

    public interface a {
        void a(Channel channel);
    }

    public static final class b extends RecyclerView.d0 {

        /* renamed from: a, reason: collision with root package name */
        public TextView f13958a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View view) {
            super(view);
            t9.i.g(view, "itemView");
            View findViewById = view.findViewById(R.id.mTextHistory);
            t9.i.e(findViewById, "null cannot be cast to non-null type android.widget.TextView");
            this.f13958a = (TextView) findViewById;
        }

        public final TextView b() {
            return this.f13958a;
        }
    }

    public x2(Context context, ArrayList arrayList) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(arrayList, "data");
        this.f13955a = context;
        this.f13956b = arrayList;
    }

    public static final void c(x2 x2Var, t9.u uVar, View view) {
        t9.i.g(x2Var, "this$0");
        t9.i.g(uVar, "$reverseIndex");
        a aVar = x2Var.f13957c;
        if (aVar == null || aVar == null) {
            return;
        }
        Object obj = x2Var.f13956b.get(uVar.f18959a);
        t9.i.f(obj, "mData[reverseIndex]");
        aVar.a((Channel) obj);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b bVar, int i10) {
        t9.i.g(bVar, "holder");
        final t9.u uVar = new t9.u();
        uVar.f18959a = (this.f13956b.size() - i10) - 1;
        if (com.mobile.brasiltv.utils.f0.b() || TextUtils.isEmpty(((Channel) this.f13956b.get(uVar.f18959a)).getAlias())) {
            bVar.b().setText(((Channel) this.f13956b.get(uVar.f18959a)).getName());
        } else {
            bVar.b().setText(((Channel) this.f13956b.get(uVar.f18959a)).getAlias());
        }
        bVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: g5.w2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                x2.c(x2.this, uVar, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup viewGroup, int i10) {
        t9.i.g(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f13955a).inflate(R.layout.adapter_search_history_live, viewGroup, false);
        t9.i.f(inflate, "view");
        return new b(inflate);
    }

    public final void e(ArrayList arrayList) {
        t9.i.g(arrayList, "data");
        this.f13956b = arrayList;
        notifyDataSetChanged();
    }

    public final void f(a aVar) {
        t9.i.g(aVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f13957c = aVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.f13956b.size();
    }
}
