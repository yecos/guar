package ba;

import java.util.Iterator;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;

/* loaded from: classes3.dex */
public final class h implements g {

    /* renamed from: a, reason: collision with root package name */
    public final Matcher f5232a;

    /* renamed from: b, reason: collision with root package name */
    public final CharSequence f5233b;

    /* renamed from: c, reason: collision with root package name */
    public final f f5234c;

    /* renamed from: d, reason: collision with root package name */
    public List f5235d;

    public static final class a extends i9.b {
        public a() {
        }

        @Override // i9.a
        public int a() {
            return h.this.c().groupCount() + 1;
        }

        public /* bridge */ boolean b(String str) {
            return super.contains(str);
        }

        @Override // i9.b, java.util.List
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public String get(int i10) {
            String group = h.this.c().group(i10);
            return group == null ? "" : group;
        }

        @Override // i9.a, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof String) {
                return b((String) obj);
            }
            return false;
        }

        public /* bridge */ int d(String str) {
            return super.indexOf(str);
        }

        public /* bridge */ int e(String str) {
            return super.lastIndexOf(str);
        }

        @Override // i9.b, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof String) {
                return d((String) obj);
            }
            return -1;
        }

        @Override // i9.b, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof String) {
                return e((String) obj);
            }
            return -1;
        }
    }

    public static final class b extends i9.a implements f {

        public static final class a extends t9.j implements s9.l {
            public a() {
                super(1);
            }

            public final e b(int i10) {
                return b.this.c(i10);
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return b(((Number) obj).intValue());
            }
        }

        public b() {
        }

        @Override // i9.a
        public int a() {
            return h.this.c().groupCount() + 1;
        }

        public /* bridge */ boolean b(e eVar) {
            return super.contains(eVar);
        }

        public e c(int i10) {
            y9.c f10;
            f10 = j.f(h.this.c(), i10);
            if (f10.h().intValue() < 0) {
                return null;
            }
            String group = h.this.c().group(i10);
            t9.i.f(group, "matchResult.group(index)");
            return new e(group, f10);
        }

        @Override // i9.a, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj == null ? true : obj instanceof e) {
                return b((e) obj);
            }
            return false;
        }

        @Override // i9.a, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return aa.g.d(i9.r.o(i9.j.e(this)), new a()).iterator();
        }
    }

    public h(Matcher matcher, CharSequence charSequence) {
        t9.i.g(matcher, "matcher");
        t9.i.g(charSequence, "input");
        this.f5232a = matcher;
        this.f5233b = charSequence;
        this.f5234c = new b();
    }

    @Override // ba.g
    public List a() {
        if (this.f5235d == null) {
            this.f5235d = new a();
        }
        List list = this.f5235d;
        t9.i.d(list);
        return list;
    }

    public final MatchResult c() {
        return this.f5232a;
    }

    @Override // ba.g
    public y9.c getRange() {
        y9.c e10;
        e10 = j.e(c());
        return e10;
    }

    @Override // ba.g
    public g next() {
        g d10;
        int end = c().end() + (c().end() == c().start() ? 1 : 0);
        if (end > this.f5233b.length()) {
            return null;
        }
        Matcher matcher = this.f5232a.pattern().matcher(this.f5233b);
        t9.i.f(matcher, "matcher.pattern().matcher(input)");
        d10 = j.d(matcher, end, this.f5233b);
        return d10;
    }
}
