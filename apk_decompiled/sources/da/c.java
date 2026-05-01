package da;

import android.os.Handler;
import android.os.Looper;
import ca.j1;
import ca.n0;
import java.util.concurrent.CancellationException;
import k9.f;
import t9.g;
import t9.i;

/* loaded from: classes3.dex */
public final class c extends d {
    private volatile c _immediate;

    /* renamed from: c, reason: collision with root package name */
    public final Handler f12751c;

    /* renamed from: d, reason: collision with root package name */
    public final String f12752d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f12753e;

    /* renamed from: f, reason: collision with root package name */
    public final c f12754f;

    public c(Handler handler, String str, boolean z10) {
        super(null);
        this.f12751c = handler;
        this.f12752d = str;
        this.f12753e = z10;
        this._immediate = z10 ? this : null;
        c cVar = this._immediate;
        if (cVar == null) {
            cVar = new c(handler, str, true);
            this._immediate = cVar;
        }
        this.f12754f = cVar;
    }

    @Override // ca.y
    public void L(f fVar, Runnable runnable) {
        if (this.f12751c.post(runnable)) {
            return;
        }
        Q(fVar, runnable);
    }

    @Override // ca.y
    public boolean M(f fVar) {
        return (this.f12753e && i.b(Looper.myLooper(), this.f12751c.getLooper())) ? false : true;
    }

    public final void Q(f fVar, Runnable runnable) {
        j1.c(fVar, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        n0.b().L(fVar, runnable);
    }

    @Override // ca.p1
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public c O() {
        return this.f12754f;
    }

    public boolean equals(Object obj) {
        return (obj instanceof c) && ((c) obj).f12751c == this.f12751c;
    }

    public int hashCode() {
        return System.identityHashCode(this.f12751c);
    }

    @Override // ca.y
    public String toString() {
        String P = P();
        if (P != null) {
            return P;
        }
        String str = this.f12752d;
        if (str == null) {
            str = this.f12751c.toString();
        }
        if (!this.f12753e) {
            return str;
        }
        return str + ".immediate";
    }

    public /* synthetic */ c(Handler handler, String str, int i10, g gVar) {
        this(handler, (i10 & 2) != 0 ? null : str);
    }

    public c(Handler handler, String str) {
        this(handler, str, false);
    }
}
