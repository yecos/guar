package z8;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Verify;
import com.google.common.base.VerifyException;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hpplay.cybergarage.upnp.Service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import y8.k1;
import y8.y0;
import z8.x1;

/* loaded from: classes3.dex */
public abstract class c2 {

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f20409a;

        /* renamed from: b, reason: collision with root package name */
        public final Map f20410b;

        public a(String str, Map map) {
            this.f20409a = (String) Preconditions.checkNotNull(str, "policyName");
            this.f20410b = (Map) Preconditions.checkNotNull(map, "rawConfigValue");
        }

        public String a() {
            return this.f20409a;
        }

        public Map b() {
            return this.f20410b;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f20409a.equals(aVar.f20409a) && this.f20410b.equals(aVar.f20410b);
        }

        public int hashCode() {
            return Objects.hashCode(this.f20409a, this.f20410b);
        }

        public String toString() {
            return MoreObjects.toStringHelper(this).add("policyName", this.f20409a).add("rawConfigValue", this.f20410b).toString();
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final y8.p0 f20411a;

        /* renamed from: b, reason: collision with root package name */
        public final Object f20412b;

        public b(y8.p0 p0Var, Object obj) {
            this.f20411a = (y8.p0) Preconditions.checkNotNull(p0Var, com.umeng.analytics.pro.f.M);
            this.f20412b = obj;
        }

        public Object a() {
            return this.f20412b;
        }

        public y8.p0 b() {
            return this.f20411a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return Objects.equal(this.f20411a, bVar.f20411a) && Objects.equal(this.f20412b, bVar.f20412b);
        }

        public int hashCode() {
            return Objects.hashCode(this.f20411a, this.f20412b);
        }

        public String toString() {
            return MoreObjects.toStringHelper(this).add(com.umeng.analytics.pro.f.M, this.f20411a).add("config", this.f20412b).toString();
        }
    }

    public static List A(List list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(z((Map) it.next()));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static Double a(Map map) {
        return a1.h(map, "backoffMultiplier");
    }

    public static Map b(Map map) {
        if (map == null) {
            return null;
        }
        return a1.j(map, "healthCheckConfig");
    }

    public static Long c(Map map) {
        return a1.l(map, "hedgingDelay");
    }

    public static Map d(Map map) {
        return a1.j(map, "hedgingPolicy");
    }

    public static Long e(Map map) {
        return a1.l(map, "initialBackoff");
    }

    public static Set f(Map map, String str) {
        List e10 = a1.e(map, str);
        if (e10 == null) {
            return null;
        }
        return u(e10);
    }

    public static List g(Map map) {
        String k10;
        ArrayList arrayList = new ArrayList();
        if (map.containsKey("loadBalancingConfig")) {
            arrayList.addAll(a1.f(map, "loadBalancingConfig"));
        }
        if (arrayList.isEmpty() && (k10 = a1.k(map, "loadBalancingPolicy")) != null) {
            arrayList.add(Collections.singletonMap(k10.toLowerCase(Locale.ROOT), Collections.emptyMap()));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static Integer h(Map map) {
        return a1.i(map, "maxAttempts");
    }

    public static Integer i(Map map) {
        return a1.i(map, "maxAttempts");
    }

    public static Long j(Map map) {
        return a1.l(map, "maxBackoff");
    }

    public static Integer k(Map map) {
        return a1.i(map, "maxRequestMessageBytes");
    }

    public static Integer l(Map map) {
        return a1.i(map, "maxResponseMessageBytes");
    }

    public static List m(Map map) {
        return a1.f(map, "methodConfig");
    }

    public static String n(Map map) {
        return a1.k(map, FirebaseAnalytics.Param.METHOD);
    }

    public static List o(Map map) {
        return a1.f(map, "name");
    }

    public static Set p(Map map) {
        Set f10 = f(map, "nonFatalStatusCodes");
        if (f10 == null) {
            return Collections.unmodifiableSet(EnumSet.noneOf(k1.b.class));
        }
        Verify.verify(!f10.contains(k1.b.OK), "%s must not contain OK", "nonFatalStatusCodes");
        return f10;
    }

    public static Long q(Map map) {
        return a1.l(map, "perAttemptRecvTimeout");
    }

    public static Map r(Map map) {
        return a1.j(map, "retryPolicy");
    }

    public static Set s(Map map) {
        Set f10 = f(map, "retryableStatusCodes");
        Verify.verify(f10 != null, "%s is required in retry policy", "retryableStatusCodes");
        Verify.verify(true ^ f10.contains(k1.b.OK), "%s must not contain OK", "retryableStatusCodes");
        return f10;
    }

    public static String t(Map map) {
        return a1.k(map, Service.ELEM_NAME);
    }

    public static Set u(List list) {
        k1.b valueOf;
        EnumSet noneOf = EnumSet.noneOf(k1.b.class);
        for (Object obj : list) {
            if (obj instanceof Double) {
                Double d10 = (Double) obj;
                int intValue = d10.intValue();
                Verify.verify(((double) intValue) == d10.doubleValue(), "Status code %s is not integral", obj);
                valueOf = y8.k1.i(intValue).n();
                Verify.verify(valueOf.c() == d10.intValue(), "Status code %s is not valid", obj);
            } else {
                if (!(obj instanceof String)) {
                    throw new VerifyException("Can not convert status code " + obj + " to Status.Code, because its type is " + obj.getClass());
                }
                try {
                    valueOf = k1.b.valueOf((String) obj);
                } catch (IllegalArgumentException e10) {
                    throw new VerifyException("Status code " + obj + " is not valid", e10);
                }
            }
            noneOf.add(valueOf);
        }
        return Collections.unmodifiableSet(noneOf);
    }

    public static x1.c0 v(Map map) {
        Map j10;
        if (map == null || (j10 = a1.j(map, "retryThrottling")) == null) {
            return null;
        }
        float floatValue = a1.h(j10, "maxTokens").floatValue();
        float floatValue2 = a1.h(j10, "tokenRatio").floatValue();
        Preconditions.checkState(floatValue > 0.0f, "maxToken should be greater than zero");
        Preconditions.checkState(floatValue2 > 0.0f, "tokenRatio should be greater than zero");
        return new x1.c0(floatValue, floatValue2);
    }

    public static Long w(Map map) {
        return a1.l(map, "timeout");
    }

    public static Boolean x(Map map) {
        return a1.d(map, "waitForReady");
    }

    public static y0.b y(List list, y8.q0 q0Var) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            String a10 = aVar.a();
            y8.p0 d10 = q0Var.d(a10);
            if (d10 != null) {
                if (!arrayList.isEmpty()) {
                    Logger.getLogger(c2.class.getName()).log(Level.FINEST, "{0} specified by Service Config are not available", arrayList);
                }
                y0.b e10 = d10.e(aVar.b());
                return e10.d() != null ? e10 : y0.b.a(new b(d10, e10.c()));
            }
            arrayList.add(a10);
        }
        return y0.b.b(y8.k1.f19891h.r("None of " + arrayList + " specified by Service Config are available."));
    }

    public static a z(Map map) {
        if (map.size() == 1) {
            String str = (String) ((Map.Entry) map.entrySet().iterator().next()).getKey();
            return new a(str, a1.j(map, str));
        }
        throw new RuntimeException("There are " + map.size() + " fields in a LoadBalancingConfig object. Exactly one is expected. Config=" + map);
    }
}
