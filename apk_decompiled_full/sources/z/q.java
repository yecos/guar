package z;

import java.util.Locale;

/* loaded from: classes.dex */
public abstract class q {

    /* renamed from: a, reason: collision with root package name */
    public static final p f20133a = new e(null, false);

    /* renamed from: b, reason: collision with root package name */
    public static final p f20134b = new e(null, true);

    /* renamed from: c, reason: collision with root package name */
    public static final p f20135c;

    /* renamed from: d, reason: collision with root package name */
    public static final p f20136d;

    /* renamed from: e, reason: collision with root package name */
    public static final p f20137e;

    /* renamed from: f, reason: collision with root package name */
    public static final p f20138f;

    public static class a implements c {

        /* renamed from: b, reason: collision with root package name */
        public static final a f20139b = new a(true);

        /* renamed from: a, reason: collision with root package name */
        public final boolean f20140a;

        public a(boolean z10) {
            this.f20140a = z10;
        }

        @Override // z.q.c
        public int a(CharSequence charSequence, int i10, int i11) {
            int i12 = i11 + i10;
            boolean z10 = false;
            while (i10 < i12) {
                int a10 = q.a(Character.getDirectionality(charSequence.charAt(i10)));
                if (a10 != 0) {
                    if (a10 != 1) {
                        continue;
                        i10++;
                    } else if (!this.f20140a) {
                        return 1;
                    }
                } else if (this.f20140a) {
                    return 0;
                }
                z10 = true;
                i10++;
            }
            if (z10) {
                return this.f20140a ? 1 : 0;
            }
            return 2;
        }
    }

    public static class b implements c {

        /* renamed from: a, reason: collision with root package name */
        public static final b f20141a = new b();

        @Override // z.q.c
        public int a(CharSequence charSequence, int i10, int i11) {
            int i12 = i11 + i10;
            int i13 = 2;
            while (i10 < i12 && i13 == 2) {
                i13 = q.b(Character.getDirectionality(charSequence.charAt(i10)));
                i10++;
            }
            return i13;
        }
    }

    public interface c {
        int a(CharSequence charSequence, int i10, int i11);
    }

    public static abstract class d implements p {

        /* renamed from: a, reason: collision with root package name */
        public final c f20142a;

        public d(c cVar) {
            this.f20142a = cVar;
        }

        @Override // z.p
        public boolean a(CharSequence charSequence, int i10, int i11) {
            if (charSequence == null || i10 < 0 || i11 < 0 || charSequence.length() - i11 < i10) {
                throw new IllegalArgumentException();
            }
            return this.f20142a == null ? b() : c(charSequence, i10, i11);
        }

        public abstract boolean b();

        public final boolean c(CharSequence charSequence, int i10, int i11) {
            int a10 = this.f20142a.a(charSequence, i10, i11);
            if (a10 == 0) {
                return true;
            }
            if (a10 != 1) {
                return b();
            }
            return false;
        }
    }

    public static class e extends d {

        /* renamed from: b, reason: collision with root package name */
        public final boolean f20143b;

        public e(c cVar, boolean z10) {
            super(cVar);
            this.f20143b = z10;
        }

        @Override // z.q.d
        public boolean b() {
            return this.f20143b;
        }
    }

    public static class f extends d {

        /* renamed from: b, reason: collision with root package name */
        public static final f f20144b = new f();

        public f() {
            super(null);
        }

        @Override // z.q.d
        public boolean b() {
            return r.a(Locale.getDefault()) == 1;
        }
    }

    static {
        b bVar = b.f20141a;
        f20135c = new e(bVar, false);
        f20136d = new e(bVar, true);
        f20137e = new e(a.f20139b, false);
        f20138f = f.f20144b;
    }

    public static int a(int i10) {
        if (i10 != 0) {
            return (i10 == 1 || i10 == 2) ? 0 : 2;
        }
        return 1;
    }

    public static int b(int i10) {
        if (i10 != 0) {
            if (i10 == 1 || i10 == 2) {
                return 0;
            }
            switch (i10) {
                case 14:
                case 15:
                    break;
                case 16:
                case 17:
                    return 0;
                default:
                    return 2;
            }
        }
        return 1;
    }
}
