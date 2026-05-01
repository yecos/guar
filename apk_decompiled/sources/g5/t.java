package g5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.msandroid.mobile.R;
import com.titan.cast.bean.Device;
import com.zhy.autolayout.AutoRelativeLayout;
import com.zhy.autolayout.utils.AutoUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public final class t extends RecyclerView.g {

    /* renamed from: a, reason: collision with root package name */
    public final Context f13895a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f13896b;

    /* renamed from: c, reason: collision with root package name */
    public a f13897c;

    public interface a {
        void a(Device device, int i10);
    }

    public static final class b extends RecyclerView.d0 {

        /* renamed from: a, reason: collision with root package name */
        public AutoRelativeLayout f13898a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f13899b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f13900c;

        /* renamed from: d, reason: collision with root package name */
        public ImageView f13901d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View view) {
            super(view);
            t9.i.g(view, "itemView");
            View findViewById = view.findViewById(R.id.mLayoutDevice);
            t9.i.f(findViewById, "itemView.findViewById(R.id.mLayoutDevice)");
            this.f13898a = (AutoRelativeLayout) findViewById;
            View findViewById2 = view.findViewById(R.id.mTvDeviceName);
            t9.i.f(findViewById2, "itemView.findViewById(R.id.mTvDeviceName)");
            this.f13899b = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.mTvLastTime);
            t9.i.f(findViewById3, "itemView.findViewById(R.id.mTvLastTime)");
            this.f13900c = (TextView) findViewById3;
            View findViewById4 = view.findViewById(R.id.mIvConnectLoad);
            t9.i.f(findViewById4, "itemView.findViewById(R.id.mIvConnectLoad)");
            this.f13901d = (ImageView) findViewById4;
            AutoUtils.autoSize(view);
        }

        public final TextView b() {
            return this.f13899b;
        }

        public final TextView c() {
            return this.f13900c;
        }
    }

    public t(Context context, ArrayList arrayList) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(arrayList, "serviceInfoList");
        this.f13895a = context;
        this.f13896b = arrayList;
    }

    public static final void d(t tVar, t9.w wVar, int i10, View view) {
        t9.i.g(tVar, "this$0");
        t9.i.g(wVar, "$serviceInfo");
        a aVar = tVar.f13897c;
        if (aVar != null) {
            aVar.a((Device) wVar.f18961a, i10);
        }
    }

    public final void b(List list) {
        t9.i.g(list, "serviceInfoList");
        this.f13896b.clear();
        this.f13896b.addAll(list);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(b bVar, final int i10) {
        t9.i.g(bVar, "holder");
        final t9.w wVar = new t9.w();
        Object obj = this.f13896b.get(i10);
        t9.i.f(obj, "serviceInfoList[position]");
        wVar.f18961a = obj;
        com.mobile.brasiltv.utils.b0.U(this, "CastDevice serviceInfo: " + wVar.f18961a);
        bVar.b().setText(((Device) wVar.f18961a).getFriendly_name());
        if (com.mobile.brasiltv.utils.g.f8651a.k((Device) wVar.f18961a)) {
            bVar.c().setVisibility(0);
        } else {
            bVar.c().setVisibility(8);
        }
        bVar.b().setOnClickListener(new View.OnClickListener() { // from class: g5.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                t.d(t.this, wVar, i10, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(ViewGroup viewGroup, int i10) {
        t9.i.g(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f13895a).inflate(R.layout.adapter_cast_device_item, viewGroup, false);
        t9.i.f(inflate, "view");
        return new b(inflate);
    }

    public final void f(a aVar) {
        t9.i.g(aVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f13897c = aVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.f13896b.size();
    }
}
