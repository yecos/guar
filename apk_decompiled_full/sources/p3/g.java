package p3;

import c3.k;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class g extends f {

    /* renamed from: e, reason: collision with root package name */
    public final Class f18057e;

    /* renamed from: f, reason: collision with root package name */
    public final String f18058f;

    /* renamed from: g, reason: collision with root package name */
    public final Collection f18059g;

    /* renamed from: h, reason: collision with root package name */
    public transient String f18060h;

    public g(k kVar, String str, c3.i iVar, Class cls, String str2, Collection collection) {
        super(kVar, str, iVar);
        this.f18057e = cls;
        this.f18058f = str2;
        this.f18059g = collection;
    }

    @Override // c3.l
    public String b() {
        String str = this.f18060h;
        if (str != null || this.f18059g == null) {
            return str;
        }
        StringBuilder sb = new StringBuilder(100);
        int size = this.f18059g.size();
        if (size != 1) {
            sb.append(" (");
            sb.append(size);
            sb.append(" known properties: ");
            Iterator it = this.f18059g.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                sb.append('\"');
                sb.append(String.valueOf(it.next()));
                sb.append('\"');
                if (sb.length() > 1000) {
                    sb.append(" [truncated]");
                    break;
                }
                if (it.hasNext()) {
                    sb.append(", ");
                }
            }
        } else {
            sb.append(" (one known property: \"");
            sb.append(String.valueOf(this.f18059g.iterator().next()));
            sb.append('\"');
        }
        sb.append("])");
        String sb2 = sb.toString();
        this.f18060h = sb2;
        return sb2;
    }
}
