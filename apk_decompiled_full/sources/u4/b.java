package u4;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class b implements u4.a {

    /* renamed from: a, reason: collision with root package name */
    public final Handler f19049a = new a(Looper.getMainLooper());

    /* renamed from: b, reason: collision with root package name */
    public final x4.b f19050b;

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            y4.a aVar = (y4.a) message.obj;
            switch (aVar.k()) {
                case 1:
                    if (aVar.d() != null) {
                        aVar.d().onStart();
                        break;
                    }
                    break;
                case 2:
                    if (aVar.d() != null) {
                        aVar.d().d(aVar.i(), aVar.j());
                        break;
                    }
                    break;
                case 3:
                    if (aVar.d() != null) {
                        aVar.d().c();
                        break;
                    }
                    break;
                case 4:
                    if (aVar.d() != null) {
                        aVar.d().a();
                        break;
                    }
                    break;
                case 5:
                    if (aVar.d() != null) {
                        aVar.d().b();
                        break;
                    }
                    break;
                case 6:
                    if (aVar.d() != null) {
                        aVar.d().e(aVar.f());
                        break;
                    }
                    break;
                case 7:
                    if (aVar.d() != null) {
                        aVar.d().f();
                        break;
                    }
                    break;
            }
        }
    }

    public b(x4.b bVar) {
        this.f19050b = bVar;
    }

    @Override // u4.a
    public void a(y4.a aVar) {
        if (aVar.k() != 7) {
            this.f19050b.e(aVar);
            if (aVar.e() != null) {
                Iterator it = aVar.e().iterator();
                while (it.hasNext()) {
                    this.f19050b.f((y4.b) it.next());
                }
            }
        }
        Message obtainMessage = this.f19049a.obtainMessage(aVar.g().hashCode());
        obtainMessage.obj = aVar;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            this.f19049a.handleMessage(obtainMessage);
        } else {
            obtainMessage.sendToTarget();
        }
    }

    @Override // u4.a
    public void b(y4.a aVar, z4.a aVar2) {
        if (aVar2.a() == 7) {
            return;
        }
        aVar.C(6);
        aVar.x(aVar2);
        a(aVar);
    }
}
