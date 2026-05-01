package xa;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.lang.reflect.Method;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    public final Method f19641a;

    /* renamed from: b, reason: collision with root package name */
    public final ThreadMode f19642b;

    /* renamed from: c, reason: collision with root package name */
    public final Class f19643c;

    /* renamed from: d, reason: collision with root package name */
    public final int f19644d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f19645e;

    /* renamed from: f, reason: collision with root package name */
    public String f19646f;

    public l(Method method, Class cls, ThreadMode threadMode, int i10, boolean z10) {
        this.f19641a = method;
        this.f19642b = threadMode;
        this.f19643c = cls;
        this.f19644d = i10;
        this.f19645e = z10;
    }

    public final synchronized void a() {
        if (this.f19646f == null) {
            StringBuilder sb = new StringBuilder(64);
            sb.append(this.f19641a.getDeclaringClass().getName());
            sb.append('#');
            sb.append(this.f19641a.getName());
            sb.append(ASCIIPropertyListParser.ARRAY_BEGIN_TOKEN);
            sb.append(this.f19643c.getName());
            this.f19646f = sb.toString();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        a();
        l lVar = (l) obj;
        lVar.a();
        return this.f19646f.equals(lVar.f19646f);
    }

    public int hashCode() {
        return this.f19641a.hashCode();
    }
}
