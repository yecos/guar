package a3;

import s9.l;

/* loaded from: classes.dex */
public abstract class e {

    public static final class a extends t9.j implements l {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f162a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str) {
            super(1);
            this.f162a = str;
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(ba.g gVar) {
            t9.i.g(gVar, "matchResult");
            return ((String) gVar.a().get(1)) + this.f162a + ((String) gVar.a().get(3));
        }
    }

    public static final String a(String str, String str2) {
        t9.i.g(str2, "domainKey");
        String h10 = t2.a.f18798a.h(str2);
        boolean z10 = true;
        if (!(h10.length() > 0)) {
            return str;
        }
        if (str != null && str.length() != 0) {
            z10 = false;
        }
        return !z10 ? new ba.i("^(https?://)([^/]+)(.*)").d(str, new a(h10)) : str;
    }
}
