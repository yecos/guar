package a1;

import android.net.Uri;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final Set f99a = new HashSet();

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final Uri f100a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f101b;

        public a(Uri uri, boolean z10) {
            this.f100a = uri;
            this.f101b = z10;
        }

        public Uri a() {
            return this.f100a;
        }

        public boolean b() {
            return this.f101b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f101b == aVar.f101b && this.f100a.equals(aVar.f100a);
        }

        public int hashCode() {
            return (this.f100a.hashCode() * 31) + (this.f101b ? 1 : 0);
        }
    }

    public void a(Uri uri, boolean z10) {
        this.f99a.add(new a(uri, z10));
    }

    public Set b() {
        return this.f99a;
    }

    public int c() {
        return this.f99a.size();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        return this.f99a.equals(((c) obj).f99a);
    }

    public int hashCode() {
        return this.f99a.hashCode();
    }
}
