package g5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.msandroid.mobile.R;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.zhy.autolayout.utils.AutoUtils;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class q0 extends RecyclerView.g {

    /* renamed from: a, reason: collision with root package name */
    public Context f13829a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f13830b;

    /* renamed from: c, reason: collision with root package name */
    public b f13831c;

    /* renamed from: d, reason: collision with root package name */
    public int f13832d;

    public static final class a extends RecyclerView.d0 {

        /* renamed from: a, reason: collision with root package name */
        public TextView f13833a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            t9.i.g(view, "itemView");
            AutoUtils.autoSize(view);
            setIsRecyclable(false);
            View findViewById = view.findViewById(R.id.mTextSortName);
            t9.i.f(findViewById, "itemView.findViewById(R.id.mTextSortName)");
            this.f13833a = (TextView) findViewById;
        }

        public final TextView b() {
            return this.f13833a;
        }
    }

    public interface b {
        void a(String str, int i10);
    }

    public q0(Context context, ArrayList arrayList) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(arrayList, "data");
        this.f13829a = context;
        this.f13830b = arrayList;
    }

    public static final void d(q0 q0Var, int i10, View view) {
        t9.i.g(q0Var, "this$0");
        view.setSelected(true);
        b bVar = q0Var.f13831c;
        if (bVar != null) {
            Object obj = q0Var.f13830b.get(i10);
            t9.i.f(obj, "mData[position]");
            bVar.a((String) obj, i10);
        }
    }

    public final String b() {
        Object obj = this.f13830b.get(this.f13832d);
        t9.i.f(obj, "mData[mClickedPosition]");
        return (String) obj;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a aVar, final int i10) {
        t9.i.g(aVar, "holder");
        aVar.itemView.setSelected(false);
        if (i10 == 0) {
            aVar.b().setText(this.f13829a.getResources().getString(R.string.today));
        } else {
            Object obj = this.f13830b.get(i10);
            t9.i.f(obj, "mData[position]");
            String substring = ((String) obj).substring(5);
            t9.i.f(substring, "this as java.lang.String).substring(startIndex)");
            aVar.b().setText(ba.s.j(substring, Operator.Operation.DIVISION, Operator.Operation.MINUS, false, 4, null));
        }
        if (i10 == this.f13832d) {
            aVar.itemView.setSelected(true);
        }
        aVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: g5.p0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                q0.d(q0.this, i10, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup viewGroup, int i10) {
        t9.i.g(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f13829a).inflate(R.layout.adapter_live_sort_vertical, viewGroup, false);
        t9.i.f(inflate, "view");
        return new a(inflate);
    }

    public final void f(int i10) {
        this.f13832d = i10;
        notifyDataSetChanged();
    }

    public final void g(b bVar) {
        t9.i.g(bVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f13831c = bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.f13830b.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public long getItemId(int i10) {
        return i10;
    }
}
