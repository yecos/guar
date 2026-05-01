package g5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.msandroid.mobile.R;
import com.zhy.autolayout.utils.AutoUtils;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public final class c extends RecyclerView.g {

    /* renamed from: a, reason: collision with root package name */
    public final Context f13649a;

    /* renamed from: b, reason: collision with root package name */
    public a f13650b;

    /* renamed from: c, reason: collision with root package name */
    public String f13651c = "";

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f13652d = new ArrayList();

    public interface a {
        void onClick(String str);
    }

    public static final class b extends RecyclerView.d0 {

        /* renamed from: a, reason: collision with root package name */
        public TextView f13653a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View view) {
            super(view);
            t9.i.g(view, "itemView");
            View findViewById = view.findViewById(R.id.mEmailInfo);
            t9.i.f(findViewById, "itemView.findViewById(R.id.mEmailInfo)");
            this.f13653a = (TextView) findViewById;
            AutoUtils.autoSize(view);
        }

        public final TextView b() {
            return this.f13653a;
        }
    }

    public c(Context context) {
        this.f13649a = context;
    }

    public static final void c(c cVar, b bVar, View view) {
        t9.i.g(cVar, "this$0");
        t9.i.g(bVar, "$holder");
        a aVar = cVar.f13650b;
        if (aVar != null) {
            aVar.onClick(bVar.b().getText().toString());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(final b bVar, int i10) {
        t9.i.g(bVar, "holder");
        if (this.f13649a == null) {
            return;
        }
        bVar.b().setText(this.f13651c + ((String) this.f13652d.get(i10)));
        bVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: g5.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c.c(c.this, bVar, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup viewGroup, int i10) {
        t9.i.g(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f13649a).inflate(R.layout.item_email, viewGroup, false);
        t9.i.f(inflate, "view");
        return new b(inflate);
    }

    public final void e(ArrayList arrayList) {
        t9.i.g(arrayList, "emailSuffixs");
        this.f13652d.clear();
        this.f13652d.addAll(arrayList);
        notifyDataSetChanged();
    }

    public final void f(a aVar) {
        t9.i.g(aVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f13650b = aVar;
    }

    public final void g(String str) {
        t9.i.g(str, "prefix");
        this.f13651c = str;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.f13652d.size();
    }
}
