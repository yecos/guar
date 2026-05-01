package g5;

import android.app.Activity;
import android.widget.ImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.android.gms.cast.MediaError;
import com.mobile.brasiltv.view.HorizontalItemDecoration;
import com.msandroid.mobile.R;
import com.zhy.autolayout.utils.AutoUtils;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import mobile.com.requestframe.utils.response.PosterList;

/* loaded from: classes3.dex */
public final class i3 extends j5.a {

    /* renamed from: a, reason: collision with root package name */
    public final Activity f13720a;

    public static final class a extends t9.j implements s9.l {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ImageView f13722b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ImageView imageView) {
            super(1);
            this.f13722b = imageView;
        }

        public final void b(PosterList posterList) {
            a7.e eVar = a7.e.f288a;
            Activity f10 = i3.this.f();
            String fileUrl = posterList.getFileUrl();
            ImageView imageView = this.f13722b;
            t9.i.f(imageView, "mSpecialBgIv");
            eVar.b(f10, fileUrl, imageView, R.drawable.column_image_placeholder);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((PosterList) obj);
            return h9.t.f14242a;
        }
    }

    public static final class b extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageView f13723a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ImageView imageView) {
            super(1);
            this.f13723a = imageView;
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return h9.t.f14242a;
        }

        public final void invoke(Throwable th) {
            this.f13723a.setImageResource(R.drawable.column_image_placeholder);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i3(Activity activity) {
        super(R.layout.adapter_special_item, null, 2, null);
        t9.i.g(activity, com.umeng.analytics.pro.f.X);
        this.f13720a = activity;
    }

    public static final void d(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void e(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, j3 j3Var) {
        t9.i.g(baseViewHolder, "helper");
        t9.i.g(j3Var, "specialItem");
        baseViewHolder.setText(R.id.mSpecialTypeName, com.mobile.brasiltv.utils.b0.c(j3Var.a().getName(), j3Var.a().getAlias()));
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.mSpecialBgIv);
        a7.d dVar = a7.d.f279a;
        Observable c10 = dVar.c(j3Var.a().getPosterList(), dVar.e());
        final a aVar = new a(imageView);
        Consumer consumer = new Consumer() { // from class: g5.g3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                i3.d(s9.l.this, obj);
            }
        };
        final b bVar = new b(imageView);
        c10.subscribe(consumer, new Consumer() { // from class: g5.h3
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                i3.e(s9.l.this, obj);
            }
        });
        RecyclerView recyclerView = (RecyclerView) baseViewHolder.getView(R.id.mSpecialColumnRV);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.f13720a, 0, false));
        if (recyclerView.getAdapter() == null) {
            recyclerView.addItemDecoration(new HorizontalItemDecoration(this.f13720a, AutoUtils.getPercentWidthSize(MediaError.DetailedErrorCode.DASH_NO_INIT)));
        }
        if (j3Var.b().isEmpty()) {
            baseViewHolder.setText(R.id.mSpecialVideoNum, "");
            ArrayList arrayList = new ArrayList(1);
            arrayList.add("");
            z1 z1Var = new z1(true);
            recyclerView.setAdapter(z1Var);
            z1Var.setNewData(arrayList);
            return;
        }
        baseViewHolder.setText(R.id.mSpecialVideoNum, j3Var.b().size() + ' ' + this.f13720a.getResources().getString(R.string.videos));
        y1 y1Var = new y1(this.f13720a, j3Var.a().getId(), true, false, false, "special", 16, null);
        recyclerView.setAdapter(y1Var);
        y1Var.setNewData(j3Var.b());
    }

    public final Activity f() {
        return this.f13720a;
    }
}
