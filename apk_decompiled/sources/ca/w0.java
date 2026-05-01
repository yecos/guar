package ca;

import java.io.Closeable;
import k9.f;

/* loaded from: classes3.dex */
public abstract class w0 extends y implements Closeable {

    /* renamed from: c, reason: collision with root package name */
    public static final a f5807c = new a(null);

    public static final class a extends k9.b {

        /* renamed from: ca.w0$a$a, reason: collision with other inner class name */
        public static final class C0084a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public static final C0084a f5808a = new C0084a();

            public C0084a() {
                super(1);
            }

            @Override // s9.l
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final w0 invoke(f.b bVar) {
                if (bVar instanceof w0) {
                    return (w0) bVar;
                }
                return null;
            }
        }

        public /* synthetic */ a(t9.g gVar) {
            this();
        }

        public a() {
            super(y.f5817b, C0084a.f5808a);
        }
    }
}
