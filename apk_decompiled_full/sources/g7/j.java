package g7;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.msandroid.mobile.R;
import com.zhy.autolayout.utils.AutoUtils;
import h9.t;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public final class j extends g7.a {

    /* renamed from: a, reason: collision with root package name */
    public Disposable f14014a;

    public static final class a extends t9.j implements s9.l {
        public a() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Long) obj);
            return t.f14242a;
        }

        public final void invoke(Long l10) {
            j.this.dismiss();
        }
    }

    public static final class b extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final b f14016a = new b();

        public b() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return t.f14242a;
        }

        public final void invoke(Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(Context context, String str, BaseQuickAdapter baseQuickAdapter) {
        super(context);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(str, "popTitle");
        t9.i.g(baseQuickAdapter, "adapter");
        View inflate = LayoutInflater.from(context).inflate(R.layout.pop_landscape_quality, (ViewGroup) null);
        setContentView(inflate);
        TextView textView = (TextView) inflate.findViewById(R.id.mTvTitle);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.mRvQuality);
        textView.setText(str);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(baseQuickAdapter);
        setTouchInterceptor(new View.OnTouchListener() { // from class: g7.g
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean i10;
                i10 = j.i(j.this, view, motionEvent);
                return i10;
            }
        });
        setClippingEnabled(false);
        j();
    }

    public static final boolean i(j jVar, View view, MotionEvent motionEvent) {
        t9.i.g(jVar, "this$0");
        jVar.j();
        return false;
    }

    public static final void k(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void l(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    @Override // g7.a
    public int b() {
        return R.style.RightPopAnimQuality;
    }

    @Override // g7.a
    public int c() {
        return -1;
    }

    @Override // g7.a
    public int d() {
        return AutoUtils.getPercentWidthSize(490);
    }

    @Override // g7.a
    public boolean e() {
        return true;
    }

    public final void j() {
        Disposable disposable = this.f14014a;
        if (disposable != null) {
            disposable.dispose();
        }
        Observable<Long> timer = Observable.timer(5L, TimeUnit.SECONDS, AndroidSchedulers.mainThread());
        final a aVar = new a();
        Consumer<? super Long> consumer = new Consumer() { // from class: g7.h
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                j.k(s9.l.this, obj);
            }
        };
        final b bVar = b.f14016a;
        this.f14014a = timer.subscribe(consumer, new Consumer() { // from class: g7.i
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                j.l(s9.l.this, obj);
            }
        });
    }

    public final void m(Activity activity, int i10) {
        t9.i.g(activity, "activity");
        View findViewById = activity.getWindow().getDecorView().findViewById(android.R.id.content);
        t9.i.e(findViewById, "null cannot be cast to non-null type android.view.ViewGroup");
        showAtLocation((ViewGroup) findViewById, i10, 0, 0);
    }
}
