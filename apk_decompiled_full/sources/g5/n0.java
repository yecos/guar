package g5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.msandroid.mobile.R;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.zhy.autolayout.utils.AutoUtils;
import java.util.ArrayList;
import mobile.com.requestframe.utils.response.ChildColumnList;

/* loaded from: classes3.dex */
public final class n0 extends RecyclerView.g {

    /* renamed from: a, reason: collision with root package name */
    public Context f13793a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f13794b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList f13795c;

    /* renamed from: d, reason: collision with root package name */
    public int f13796d;

    public static final class a extends RecyclerView.d0 {

        /* renamed from: a, reason: collision with root package name */
        public TextView f13797a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            t9.i.g(view, "itemView");
            AutoUtils.autoSize(view);
            setIsRecyclable(false);
            View findViewById = view.findViewById(R.id.mTextSortName);
            t9.i.f(findViewById, "itemView.findViewById(R.id.mTextSortName)");
            this.f13797a = (TextView) findViewById;
        }

        public final TextView b() {
            return this.f13797a;
        }
    }

    public n0(Context context, ArrayList arrayList, ArrayList arrayList2) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(arrayList, "data");
        this.f13793a = context;
        this.f13794b = arrayList;
        this.f13795c = arrayList2;
    }

    public static final void e(n0 n0Var, int i10, View view) {
        t9.i.g(n0Var, "this$0");
        view.setSelected(true);
        n0Var.getClass();
    }

    public final ChildColumnList b() {
        ArrayList arrayList = this.f13795c;
        if (arrayList != null) {
            return (ChildColumnList) arrayList.get(this.f13796d);
        }
        return null;
    }

    public final void c(int i10, String str) {
        t9.i.g(str, "sort");
        if (this.f13794b.contains(str)) {
            return;
        }
        if (this.f13794b.size() >= i10) {
            this.f13794b.add(i10, str);
        } else {
            this.f13794b.add(str);
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a aVar, final int i10) {
        t9.i.g(aVar, "holder");
        aVar.itemView.setSelected(false);
        Object obj = this.f13794b.get(i10);
        t9.i.f(obj, "mData[position]");
        if (!ba.t.o((CharSequence) obj, Operator.Operation.DIVISION, false, 2, null)) {
            aVar.b().setText((CharSequence) this.f13794b.get(i10));
            if (!com.mobile.brasiltv.utils.b0.G(this.f13795c)) {
                ArrayList arrayList = this.f13795c;
                t9.i.d(arrayList);
                if (t9.i.b(((ChildColumnList) arrayList.get(i10)).getFree(), "1")) {
                    aVar.b().setTextColor(this.f13793a.getResources().getColor(R.color.color_ffbf00));
                }
            }
            aVar.b().setTextColor(this.f13793a.getResources().getColor(R.color.color_ffffff));
        } else if (i10 == 0) {
            aVar.b().setText(this.f13793a.getResources().getString(R.string.today));
        } else {
            Object obj2 = this.f13794b.get(i10);
            t9.i.f(obj2, "mData[position]");
            String substring = ((String) obj2).substring(5);
            t9.i.f(substring, "this as java.lang.String).substring(startIndex)");
            aVar.b().setText(ba.s.j(substring, Operator.Operation.DIVISION, Operator.Operation.MINUS, false, 4, null));
        }
        if (i10 == this.f13796d) {
            aVar.itemView.setSelected(true);
        }
        aVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: g5.m0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                n0.e(n0.this, i10, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup viewGroup, int i10) {
        t9.i.g(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f13793a).inflate(R.layout.adapter_live_sort_vertical, viewGroup, false);
        t9.i.f(inflate, "view");
        return new a(inflate);
    }

    public final void g(String str) {
        t9.i.g(str, "sort");
        if (this.f13794b.contains(str)) {
            this.f13794b.remove(str);
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.f13794b.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public long getItemId(int i10) {
        return i10;
    }

    public final void h(int i10) {
        this.f13796d = i10;
        notifyDataSetChanged();
    }
}
