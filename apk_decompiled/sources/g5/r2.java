package g5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.mobile.brasiltv.db.Album;
import com.msandroid.mobile.R;
import com.zhy.autolayout.utils.AutoUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class r2 extends RecyclerView.g {

    /* renamed from: a, reason: collision with root package name */
    public final int f13873a;

    /* renamed from: b, reason: collision with root package name */
    public final int f13874b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f13875c;

    /* renamed from: d, reason: collision with root package name */
    public Context f13876d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList f13877e;

    /* renamed from: f, reason: collision with root package name */
    public a f13878f;

    public interface a {
        void a(Album album, int i10);

        void b(int i10, int i11);
    }

    public static final class b extends RecyclerView.d0 {

        /* renamed from: a, reason: collision with root package name */
        public TextView f13879a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(View view) {
            super(view);
            t9.i.g(view, "itemView");
            View findViewById = view.findViewById(R.id.mTvTimeLabel);
            t9.i.f(findViewById, "itemView.findViewById(R.id.mTvTimeLabel)");
            this.f13879a = (TextView) findViewById;
            AutoUtils.autoSize(view);
        }

        public final TextView b() {
            return this.f13879a;
        }
    }

    public static final class c extends RecyclerView.d0 {

        /* renamed from: a, reason: collision with root package name */
        public ImageView f13880a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f13881b;

        /* renamed from: c, reason: collision with root package name */
        public TextView f13882c;

        /* renamed from: d, reason: collision with root package name */
        public ImageView f13883d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(View view) {
            super(view);
            t9.i.g(view, "itemView");
            View findViewById = view.findViewById(R.id.mImagePoster);
            t9.i.e(findViewById, "null cannot be cast to non-null type android.widget.ImageView");
            this.f13880a = (ImageView) findViewById;
            View findViewById2 = view.findViewById(R.id.mTextTime);
            t9.i.e(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
            this.f13881b = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.mTextProgramName);
            t9.i.e(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
            this.f13882c = (TextView) findViewById3;
            View findViewById4 = view.findViewById(R.id.mIvSingleCb);
            t9.i.f(findViewById4, "itemView.findViewById(R.id.mIvSingleCb)");
            this.f13883d = (ImageView) findViewById4;
            AutoUtils.autoSize(view);
        }

        public final ImageView b() {
            return this.f13880a;
        }

        public final ImageView c() {
            return this.f13883d;
        }

        public final TextView d() {
            return this.f13882c;
        }

        public final TextView e() {
            return this.f13881b;
        }
    }

    public r2(Context context, ArrayList arrayList) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(arrayList, "data");
        this.f13874b = 1;
        this.f13876d = context;
        this.f13877e = arrayList;
    }

    public static final void f(r2 r2Var, Album album, c cVar, int i10, View view) {
        t9.i.g(r2Var, "this$0");
        t9.i.g(album, "$album");
        t9.i.g(cVar, "$holder");
        if (!r2Var.f13875c) {
            a aVar = r2Var.f13878f;
            if (aVar != null) {
                aVar.a(album, i10);
                return;
            }
            return;
        }
        if (album.isSelect()) {
            cVar.c().setImageResource(R.drawable.icon_no_select);
        } else {
            cVar.c().setImageResource(R.drawable.icon_select);
        }
        album.setSelect(!album.isSelect());
        r2Var.c();
    }

    public final void b(List list) {
        t9.i.g(list, "data");
        this.f13877e = e((ArrayList) list);
        this.f13875c = false;
        notifyDataSetChanged();
    }

    public final void c() {
        Iterator it = this.f13877e.iterator();
        int i10 = 0;
        int i11 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof Album) {
                i11++;
                if (((Album) next).isSelect()) {
                    i10++;
                }
            }
        }
        a aVar = this.f13878f;
        if (aVar != null) {
            aVar.b(i10, i11);
        }
    }

    public final ArrayList d() {
        return this.f13877e;
    }

    public final ArrayList e(ArrayList arrayList) {
        String f10 = y6.a.f(7);
        String f11 = y6.a.f(90);
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        boolean z10 = false;
        boolean z11 = false;
        while (it.hasNext()) {
            Album album = (Album) it.next();
            if (!z10) {
                String saveTime = album.getSaveTime();
                if (f10.compareTo(saveTime != null ? saveTime : "") <= 0) {
                    String string = this.f13876d.getResources().getString(R.string.history_last_week);
                    t9.i.e(string, "null cannot be cast to non-null type java.lang.Object");
                    arrayList2.add(string);
                    z10 = true;
                }
            } else if (!z11) {
                String saveTime2 = album.getSaveTime();
                if (saveTime2 == null) {
                    saveTime2 = "";
                }
                if (f10.compareTo(saveTime2) > 0) {
                    String saveTime3 = album.getSaveTime();
                    if (f11.compareTo(saveTime3 != null ? saveTime3 : "") <= 0) {
                        String string2 = this.f13876d.getResources().getString(R.string.history_last_three_months);
                        t9.i.e(string2, "null cannot be cast to non-null type java.lang.Object");
                        arrayList2.add(string2);
                        z11 = true;
                    }
                }
            }
            t9.i.e(album, "null cannot be cast to non-null type java.lang.Object");
            arrayList2.add(album);
            if (z11) {
                break;
            }
        }
        return arrayList2;
    }

    public final void g(boolean z10) {
        Iterator it = this.f13877e.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof Album) {
                ((Album) next).setSelect(z10);
            }
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.f13877e.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemViewType(int i10) {
        return this.f13877e.get(i10) instanceof Album ? this.f13874b : this.f13873a;
    }

    public final void h(a aVar) {
        t9.i.g(aVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f13878f = aVar;
    }

    public final void i(boolean z10) {
        this.f13875c = z10;
        if (z10) {
            notifyDataSetChanged();
        } else {
            g(false);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void onBindViewHolder(RecyclerView.d0 d0Var, final int i10) {
        t9.i.g(d0Var, "viewHolder");
        if (!(this.f13877e.get(i10) instanceof Album)) {
            Object obj = this.f13877e.get(i10);
            t9.i.e(obj, "null cannot be cast to non-null type kotlin.String");
            ((b) d0Var).b().setText((String) obj);
            return;
        }
        Object obj2 = this.f13877e.get(i10);
        t9.i.e(obj2, "null cannot be cast to non-null type com.mobile.brasiltv.db.Album");
        final Album album = (Album) obj2;
        final c cVar = (c) d0Var;
        a7.e.f288a.b(this.f13876d, album.getPosterUrl(), cVar.b(), R.drawable.special_cloumn_img_placeholder);
        cVar.d().setText(com.mobile.brasiltv.utils.b0.e(album.getAlias(), album.getName()));
        if (t9.i.b(album.getType(), "0")) {
            TextView e10 = cVar.e();
            t9.z zVar = t9.z.f18964a;
            String format = String.format(com.mobile.brasiltv.utils.b0.A(this.f13876d, R.string.watched_episodes), Arrays.copyOf(new Object[]{Integer.valueOf(album.getSeriesNumber())}, 1));
            t9.i.f(format, "format(format, *args)");
            e10.setText(format);
            cVar.e().setVisibility(0);
        } else if (t9.i.b(album.getType(), "1")) {
            long j10 = 1000;
            long j11 = 60;
            if ((album.getPlayTime() / j10) / j11 < 1) {
                cVar.e().setText(com.mobile.brasiltv.utils.b0.A(this.f13876d, R.string.less_than_minutes));
            } else {
                TextView e11 = cVar.e();
                t9.z zVar2 = t9.z.f18964a;
                String format2 = String.format(com.mobile.brasiltv.utils.b0.A(this.f13876d, R.string.watched_minutes), Arrays.copyOf(new Object[]{Long.valueOf((album.getPlayTime() / j10) / j11)}, 1));
                t9.i.f(format2, "format(format, *args)");
                e11.setText(format2);
            }
            cVar.e().setVisibility(0);
        }
        if (this.f13875c) {
            cVar.c().setVisibility(0);
            if (album.isSelect()) {
                cVar.c().setImageResource(R.drawable.icon_select);
            } else {
                cVar.c().setImageResource(R.drawable.icon_no_select);
            }
        } else {
            cVar.c().setVisibility(8);
        }
        cVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: g5.q2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r2.f(r2.this, album, cVar, i10, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.d0 onCreateViewHolder(ViewGroup viewGroup, int i10) {
        t9.i.g(viewGroup, "parent");
        LayoutInflater from = LayoutInflater.from(this.f13876d);
        if (i10 == this.f13873a) {
            View inflate = from.inflate(R.layout.adapter_record_label_item, viewGroup, false);
            AutoUtils.autoSize(inflate);
            t9.i.f(inflate, "view");
            return new b(inflate);
        }
        View inflate2 = from.inflate(R.layout.adapter_record_item, viewGroup, false);
        AutoUtils.autoSize(inflate2);
        t9.i.f(inflate2, "view");
        return new c(inflate2);
    }
}
