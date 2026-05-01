package y;

import a0.h;
import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;

/* loaded from: classes.dex */
public abstract class f {

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f19693a;

        /* renamed from: b, reason: collision with root package name */
        public final b[] f19694b;

        public a(int i10, b[] bVarArr) {
            this.f19693a = i10;
            this.f19694b = bVarArr;
        }

        public static a a(int i10, b[] bVarArr) {
            return new a(i10, bVarArr);
        }

        public b[] b() {
            return this.f19694b;
        }

        public int c() {
            return this.f19693a;
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final Uri f19695a;

        /* renamed from: b, reason: collision with root package name */
        public final int f19696b;

        /* renamed from: c, reason: collision with root package name */
        public final int f19697c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f19698d;

        /* renamed from: e, reason: collision with root package name */
        public final int f19699e;

        public b(Uri uri, int i10, int i11, boolean z10, int i12) {
            this.f19695a = (Uri) h.d(uri);
            this.f19696b = i10;
            this.f19697c = i11;
            this.f19698d = z10;
            this.f19699e = i12;
        }

        public static b a(Uri uri, int i10, int i11, boolean z10, int i12) {
            return new b(uri, i10, i11, z10, i12);
        }

        public int b() {
            return this.f19699e;
        }

        public int c() {
            return this.f19696b;
        }

        public Uri d() {
            return this.f19695a;
        }

        public int e() {
            return this.f19697c;
        }

        public boolean f() {
            return this.f19698d;
        }
    }

    public static class c {
        public abstract void a(int i10);

        public abstract void b(Typeface typeface);
    }

    public static Typeface a(Context context, d dVar, int i10, boolean z10, int i11, Handler handler, c cVar) {
        y.a aVar = new y.a(cVar, handler);
        return z10 ? e.e(context, dVar, aVar, i10, i11) : e.d(context, dVar, i10, null, aVar);
    }
}
