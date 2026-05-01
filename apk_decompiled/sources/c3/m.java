package c3;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.hpplay.cybergarage.upnp.RootDescription;
import com.raizlabs.android.dbflow.sql.language.Operator;

/* loaded from: classes.dex */
public abstract class m {

    /* renamed from: a, reason: collision with root package name */
    public int f5483a;

    /* renamed from: b, reason: collision with root package name */
    public int f5484b;

    public m() {
    }

    public m(m mVar) {
        this.f5483a = mVar.f5483a;
        this.f5484b = mVar.f5484b;
    }

    public final int a() {
        int i10 = this.f5484b;
        if (i10 < 0) {
            return 0;
        }
        return i10;
    }

    public abstract String b();

    public abstract Object c();

    public final int d() {
        return this.f5484b + 1;
    }

    public abstract m e();

    public final boolean f() {
        return this.f5483a == 1;
    }

    public final boolean g() {
        return this.f5483a == 2;
    }

    public final boolean h() {
        return this.f5483a == 0;
    }

    public abstract void i(Object obj);

    public String j() {
        int i10 = this.f5483a;
        return i10 != 0 ? i10 != 1 ? i10 != 2 ? Operator.Operation.EMPTY_PARAM : "Object" : "Array" : RootDescription.ROOT_ELEMENT;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        int i10 = this.f5483a;
        if (i10 == 0) {
            sb.append(Operator.Operation.DIVISION);
        } else if (i10 != 1) {
            sb.append(ASCIIPropertyListParser.DICTIONARY_BEGIN_TOKEN);
            String b10 = b();
            if (b10 != null) {
                sb.append('\"');
                f3.a.a(sb, b10);
                sb.append('\"');
            } else {
                sb.append('?');
            }
            sb.append(ASCIIPropertyListParser.DICTIONARY_END_TOKEN);
        } else {
            sb.append('[');
            sb.append(a());
            sb.append(']');
        }
        return sb.toString();
    }

    public m(int i10, int i11) {
        this.f5483a = i10;
        this.f5484b = i11;
    }
}
