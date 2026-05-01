package k3;

import b3.j0;
import java.io.Serializable;

/* loaded from: classes.dex */
public class w implements Serializable {

    /* renamed from: h, reason: collision with root package name */
    public static final w f14994h = new w(Boolean.TRUE, null, null, null, null, null, null);

    /* renamed from: i, reason: collision with root package name */
    public static final w f14995i = new w(Boolean.FALSE, null, null, null, null, null, null);

    /* renamed from: j, reason: collision with root package name */
    public static final w f14996j = new w(null, null, null, null, null, null, null);

    /* renamed from: a, reason: collision with root package name */
    public final Boolean f14997a;

    /* renamed from: b, reason: collision with root package name */
    public final String f14998b;

    /* renamed from: c, reason: collision with root package name */
    public final Integer f14999c;

    /* renamed from: d, reason: collision with root package name */
    public final String f15000d;

    /* renamed from: e, reason: collision with root package name */
    public final transient a f15001e;

    /* renamed from: f, reason: collision with root package name */
    public j0 f15002f;

    /* renamed from: g, reason: collision with root package name */
    public j0 f15003g;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final r3.i f15004a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f15005b;

        public a(r3.i iVar, boolean z10) {
            this.f15004a = iVar;
            this.f15005b = z10;
        }

        public static a a(r3.i iVar) {
            return new a(iVar, true);
        }

        public static a b(r3.i iVar) {
            return new a(iVar, false);
        }

        public static a c(r3.i iVar) {
            return new a(iVar, false);
        }
    }

    public w(Boolean bool, String str, Integer num, String str2, a aVar, j0 j0Var, j0 j0Var2) {
        this.f14997a = bool;
        this.f14998b = str;
        this.f14999c = num;
        this.f15000d = (str2 == null || str2.isEmpty()) ? null : str2;
        this.f15001e = aVar;
        this.f15002f = j0Var;
        this.f15003g = j0Var2;
    }

    public static w a(Boolean bool, String str, Integer num, String str2) {
        return (str == null && num == null && str2 == null) ? bool == null ? f14996j : bool.booleanValue() ? f14994h : f14995i : new w(bool, str, num, str2, null, null, null);
    }

    public j0 b() {
        return this.f15003g;
    }

    public Integer c() {
        return this.f14999c;
    }

    public a d() {
        return this.f15001e;
    }

    public j0 e() {
        return this.f15002f;
    }

    public boolean f() {
        return this.f14999c != null;
    }

    public boolean g() {
        Boolean bool = this.f14997a;
        return bool != null && bool.booleanValue();
    }

    public w h(String str) {
        return new w(this.f14997a, str, this.f14999c, this.f15000d, this.f15001e, this.f15002f, this.f15003g);
    }

    public w i(a aVar) {
        return new w(this.f14997a, this.f14998b, this.f14999c, this.f15000d, aVar, this.f15002f, this.f15003g);
    }

    public w j(j0 j0Var, j0 j0Var2) {
        return new w(this.f14997a, this.f14998b, this.f14999c, this.f15000d, this.f15001e, j0Var, j0Var2);
    }
}
