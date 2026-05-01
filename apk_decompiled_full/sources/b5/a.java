package b5;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import h7.c;
import h7.h;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import j7.d;
import j7.f;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import r4.b;
import y4.a;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    public static a f4646c;

    /* renamed from: a, reason: collision with root package name */
    public final List f4647a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public y4.a f4648b;

    /* renamed from: b5.a$a, reason: collision with other inner class name */
    public class C0070a extends s4.a {

        /* renamed from: b5.a$a$a, reason: collision with other inner class name */
        public class C0071a implements Observer {
            public C0071a() {
            }

            @Override // io.reactivex.Observer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onNext(d5.b bVar) {
                a.this.l((String) bVar.a(), (String) bVar.b());
                Iterator it = new ArrayList(a.this.f4647a).iterator();
                while (it.hasNext()) {
                    ((c) it.next()).onSuccess();
                }
                a.this.f4648b = null;
            }

            @Override // io.reactivex.Observer
            public void onComplete() {
            }

            @Override // io.reactivex.Observer
            public void onError(Throwable th) {
            }

            @Override // io.reactivex.Observer
            public void onSubscribe(Disposable disposable) {
            }
        }

        /* renamed from: b5.a$a$b */
        public class b implements Callable {
            public b() {
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public d5.b call() {
                String b10 = d.b(new File(a.this.f4648b.h()));
                if (b10 == null || b10.isEmpty()) {
                    b10 = "apkMd5 is empty";
                }
                String h10 = a.this.f4648b.h();
                if (h10 == null || h10.trim().isEmpty()) {
                    h10 = "pathMd5 is empty";
                }
                return new d5.b(b10, h10);
            }
        }

        public C0070a() {
        }

        @Override // s4.a, s4.b
        public void b() {
            super.b();
            Observable.fromCallable(new b()).compose(f.a()).subscribe(new C0071a());
        }

        @Override // s4.a, s4.b
        public void d(long j10, long j11) {
            super.d(j10, j11);
            Iterator it = a.this.f4647a.iterator();
            while (it.hasNext()) {
                ((c) it.next()).A(j10, j11);
            }
        }

        @Override // s4.a, s4.b
        public void e(z4.a aVar) {
            super.e(aVar);
            a.this.k(aVar);
            Iterator it = new ArrayList(a.this.f4647a).iterator();
            while (it.hasNext()) {
                ((c) it.next()).onFailure(aVar);
            }
            a.this.f4648b = null;
        }

        @Override // s4.a, s4.b
        public void onStart() {
            super.onStart();
            Iterator it = a.this.f4647a.iterator();
            while (it.hasNext()) {
                ((c) it.next()).z();
            }
        }
    }

    public static a g() {
        if (f4646c == null) {
            f4646c = new a();
        }
        return f4646c;
    }

    public final y4.a f(Context context, d5.c cVar, y4.a aVar) {
        if (cVar == null) {
            return null;
        }
        String i10 = cVar.i();
        if (TextUtils.isEmpty(i10)) {
            return null;
        }
        s4.c a10 = b.a(context);
        y4.a d10 = a10.d(i10);
        if (d10 != null) {
            d10.F(cVar.k());
            d10.r(cVar.j());
            Log.e("getDownloadInfo", "数据库存在安装包数据");
            File file = new File(cVar.g());
            if (aVar != null && aVar.o()) {
                return d10;
            }
            if (!file.exists()) {
                Log.e("getDownloadInfo", "安装包未下载");
                a10.c(d10);
                return null;
            }
            Log.e("getDownloadInfo", "安装包已下载到本地");
            if (!d.b(file).equals(i10)) {
                Log.e("getDownloadInfo", "安装包和数据库的md5对不上");
                a10.c(d10);
                return null;
            }
        }
        return d10;
    }

    public List h() {
        return this.f4647a;
    }

    public final boolean i(String str) {
        return str.startsWith(Environment.getExternalStorageDirectory().getAbsolutePath());
    }

    public void j(c cVar) {
        this.f4647a.add(cVar);
    }

    public final void k(Throwable th) {
        y4.a aVar = this.f4648b;
        if (aVar == null) {
            return;
        }
        String m10 = aVar.m();
        if (TextUtils.isEmpty(m10)) {
            return;
        }
        h.b(Uri.parse(m10).getHost(), th);
    }

    public final void l(String str, String str2) {
        y4.a aVar = this.f4648b;
        if (aVar == null) {
            return;
        }
        String m10 = aVar.m();
        if (TextUtils.isEmpty(m10)) {
            return;
        }
        h.c(Uri.parse(m10).getHost(), (System.currentTimeMillis() - this.f4648b.c()) / 1000, this.f4648b.b(), (i(this.f4648b.h()) ? "externalStorage_" : "internalStorage_") + str2, this.f4648b.j(), str);
    }

    public void m(Context context, d5.c cVar) {
        y4.a f10 = f(context, cVar, this.f4648b);
        if (f10 == null) {
            String i10 = cVar.i();
            String k10 = cVar.k();
            String j10 = cVar.j();
            String g10 = cVar.g();
            if (TextUtils.isEmpty(i10) || TextUtils.isEmpty(k10) || TextUtils.isEmpty(g10)) {
                return;
            } else {
                f10 = new a.C0342a().c(i10).e(k10).b(j10).d(g10).a();
            }
        }
        y4.a aVar = this.f4648b;
        if (aVar == null || aVar == f10) {
            this.f4648b = f10;
            if (!f10.n()) {
                this.f4648b.u(new C0070a());
                b.a(context).b(this.f4648b);
            } else {
                Iterator it = new ArrayList(this.f4647a).iterator();
                while (it.hasNext()) {
                    ((c) it.next()).onSuccess();
                }
                this.f4648b = null;
            }
        }
    }

    public void n(c cVar) {
        this.f4647a.remove(cVar);
    }
}
