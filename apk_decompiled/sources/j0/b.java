package j0;

import android.os.Bundle;
import android.os.Looper;
import androidx.collection.h;
import androidx.lifecycle.g;
import androidx.lifecycle.l;
import androidx.lifecycle.m;
import androidx.lifecycle.v;
import androidx.lifecycle.w;
import androidx.lifecycle.x;
import androidx.loader.content.b;
import j0.a;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

/* loaded from: classes.dex */
public class b extends j0.a {

    /* renamed from: c, reason: collision with root package name */
    public static boolean f14537c = false;

    /* renamed from: a, reason: collision with root package name */
    public final g f14538a;

    /* renamed from: b, reason: collision with root package name */
    public final c f14539b;

    public static class a extends l implements b.InterfaceC0036b {

        /* renamed from: l, reason: collision with root package name */
        public final int f14540l;

        /* renamed from: m, reason: collision with root package name */
        public final Bundle f14541m;

        /* renamed from: n, reason: collision with root package name */
        public final androidx.loader.content.b f14542n;

        /* renamed from: o, reason: collision with root package name */
        public g f14543o;

        /* renamed from: p, reason: collision with root package name */
        public C0238b f14544p;

        /* renamed from: q, reason: collision with root package name */
        public androidx.loader.content.b f14545q;

        public a(int i10, Bundle bundle, androidx.loader.content.b bVar, androidx.loader.content.b bVar2) {
            this.f14540l = i10;
            this.f14541m = bundle;
            this.f14542n = bVar;
            this.f14545q = bVar2;
            bVar.registerListener(i10, this);
        }

        @Override // androidx.loader.content.b.InterfaceC0036b
        public void a(androidx.loader.content.b bVar, Object obj) {
            if (b.f14537c) {
                StringBuilder sb = new StringBuilder();
                sb.append("onLoadComplete: ");
                sb.append(this);
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                n(obj);
            } else {
                boolean z10 = b.f14537c;
                l(obj);
            }
        }

        @Override // androidx.lifecycle.LiveData
        public void j() {
            if (b.f14537c) {
                StringBuilder sb = new StringBuilder();
                sb.append("  Starting: ");
                sb.append(this);
            }
            this.f14542n.startLoading();
        }

        @Override // androidx.lifecycle.LiveData
        public void k() {
            if (b.f14537c) {
                StringBuilder sb = new StringBuilder();
                sb.append("  Stopping: ");
                sb.append(this);
            }
            this.f14542n.stopLoading();
        }

        @Override // androidx.lifecycle.LiveData
        public void m(m mVar) {
            super.m(mVar);
            this.f14543o = null;
            this.f14544p = null;
        }

        @Override // androidx.lifecycle.l, androidx.lifecycle.LiveData
        public void n(Object obj) {
            super.n(obj);
            androidx.loader.content.b bVar = this.f14545q;
            if (bVar != null) {
                bVar.reset();
                this.f14545q = null;
            }
        }

        public androidx.loader.content.b o(boolean z10) {
            if (b.f14537c) {
                StringBuilder sb = new StringBuilder();
                sb.append("  Destroying: ");
                sb.append(this);
            }
            this.f14542n.cancelLoad();
            this.f14542n.abandon();
            C0238b c0238b = this.f14544p;
            if (c0238b != null) {
                m(c0238b);
                if (z10) {
                    c0238b.d();
                }
            }
            this.f14542n.unregisterListener(this);
            if ((c0238b == null || c0238b.c()) && !z10) {
                return this.f14542n;
            }
            this.f14542n.reset();
            return this.f14545q;
        }

        public void p(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f14540l);
            printWriter.print(" mArgs=");
            printWriter.println(this.f14541m);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.f14542n);
            this.f14542n.dump(str + "  ", fileDescriptor, printWriter, strArr);
            if (this.f14544p != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.f14544p);
                this.f14544p.b(str + "  ", printWriter);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(q().dataToString(f()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(g());
        }

        public androidx.loader.content.b q() {
            return this.f14542n;
        }

        public void r() {
            g gVar = this.f14543o;
            C0238b c0238b = this.f14544p;
            if (gVar == null || c0238b == null) {
                return;
            }
            super.m(c0238b);
            h(gVar, c0238b);
        }

        public androidx.loader.content.b s(g gVar, a.InterfaceC0237a interfaceC0237a) {
            C0238b c0238b = new C0238b(this.f14542n, interfaceC0237a);
            h(gVar, c0238b);
            m mVar = this.f14544p;
            if (mVar != null) {
                m(mVar);
            }
            this.f14543o = gVar;
            this.f14544p = c0238b;
            return this.f14542n;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.f14540l);
            sb.append(" : ");
            a0.b.a(this.f14542n, sb);
            sb.append("}}");
            return sb.toString();
        }
    }

    /* renamed from: j0.b$b, reason: collision with other inner class name */
    public static class C0238b implements m {

        /* renamed from: a, reason: collision with root package name */
        public final androidx.loader.content.b f14546a;

        /* renamed from: b, reason: collision with root package name */
        public final a.InterfaceC0237a f14547b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f14548c = false;

        public C0238b(androidx.loader.content.b bVar, a.InterfaceC0237a interfaceC0237a) {
            this.f14546a = bVar;
            this.f14547b = interfaceC0237a;
        }

        @Override // androidx.lifecycle.m
        public void a(Object obj) {
            if (b.f14537c) {
                StringBuilder sb = new StringBuilder();
                sb.append("  onLoadFinished in ");
                sb.append(this.f14546a);
                sb.append(": ");
                sb.append(this.f14546a.dataToString(obj));
            }
            this.f14547b.onLoadFinished(this.f14546a, obj);
            this.f14548c = true;
        }

        public void b(String str, PrintWriter printWriter) {
            printWriter.print(str);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.f14548c);
        }

        public boolean c() {
            return this.f14548c;
        }

        public void d() {
            if (this.f14548c) {
                if (b.f14537c) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("  Resetting: ");
                    sb.append(this.f14546a);
                }
                this.f14547b.onLoaderReset(this.f14546a);
            }
        }

        public String toString() {
            return this.f14547b.toString();
        }
    }

    public static class c extends v {

        /* renamed from: e, reason: collision with root package name */
        public static final w.b f14549e = new a();

        /* renamed from: c, reason: collision with root package name */
        public h f14550c = new h();

        /* renamed from: d, reason: collision with root package name */
        public boolean f14551d = false;

        public static class a implements w.b {
            @Override // androidx.lifecycle.w.b
            public v a(Class cls) {
                return new c();
            }
        }

        public static c h(x xVar) {
            return (c) new w(xVar, f14549e).a(c.class);
        }

        @Override // androidx.lifecycle.v
        public void d() {
            super.d();
            int j10 = this.f14550c.j();
            for (int i10 = 0; i10 < j10; i10++) {
                ((a) this.f14550c.k(i10)).o(true);
            }
            this.f14550c.b();
        }

        public void f(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f14550c.j() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i10 = 0; i10 < this.f14550c.j(); i10++) {
                    a aVar = (a) this.f14550c.k(i10);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f14550c.h(i10));
                    printWriter.print(": ");
                    printWriter.println(aVar.toString());
                    aVar.p(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }

        public void g() {
            this.f14551d = false;
        }

        public a i(int i10) {
            return (a) this.f14550c.e(i10);
        }

        public boolean j() {
            return this.f14551d;
        }

        public void k() {
            int j10 = this.f14550c.j();
            for (int i10 = 0; i10 < j10; i10++) {
                ((a) this.f14550c.k(i10)).r();
            }
        }

        public void l(int i10, a aVar) {
            this.f14550c.i(i10, aVar);
        }

        public void m() {
            this.f14551d = true;
        }
    }

    public b(g gVar, x xVar) {
        this.f14538a = gVar;
        this.f14539b = c.h(xVar);
    }

    @Override // j0.a
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f14539b.f(str, fileDescriptor, printWriter, strArr);
    }

    @Override // j0.a
    public androidx.loader.content.b c(int i10, Bundle bundle, a.InterfaceC0237a interfaceC0237a) {
        if (this.f14539b.j()) {
            throw new IllegalStateException("Called while creating a loader");
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("initLoader must be called on the main thread");
        }
        a i11 = this.f14539b.i(i10);
        if (f14537c) {
            StringBuilder sb = new StringBuilder();
            sb.append("initLoader in ");
            sb.append(this);
            sb.append(": args=");
            sb.append(bundle);
        }
        if (i11 == null) {
            return e(i10, bundle, interfaceC0237a, null);
        }
        if (f14537c) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("  Re-using existing loader ");
            sb2.append(i11);
        }
        return i11.s(this.f14538a, interfaceC0237a);
    }

    @Override // j0.a
    public void d() {
        this.f14539b.k();
    }

    public final androidx.loader.content.b e(int i10, Bundle bundle, a.InterfaceC0237a interfaceC0237a, androidx.loader.content.b bVar) {
        try {
            this.f14539b.m();
            androidx.loader.content.b onCreateLoader = interfaceC0237a.onCreateLoader(i10, bundle);
            if (onCreateLoader == null) {
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
            }
            if (onCreateLoader.getClass().isMemberClass() && !Modifier.isStatic(onCreateLoader.getClass().getModifiers())) {
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + onCreateLoader);
            }
            a aVar = new a(i10, bundle, onCreateLoader, bVar);
            if (f14537c) {
                StringBuilder sb = new StringBuilder();
                sb.append("  Created new loader ");
                sb.append(aVar);
            }
            this.f14539b.l(i10, aVar);
            this.f14539b.g();
            return aVar.s(this.f14538a, interfaceC0237a);
        } catch (Throwable th) {
            this.f14539b.g();
            throw th;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        a0.b.a(this.f14538a, sb);
        sb.append("}}");
        return sb.toString();
    }
}
