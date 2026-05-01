package c9;

import java.io.Closeable;
import java.util.List;
import okio.BufferedSource;
import okio.ByteString;

/* loaded from: classes3.dex */
public interface b extends Closeable {

    public interface a {
        void ackSettings();

        void d(int i10, c9.a aVar);

        void data(boolean z10, int i10, BufferedSource bufferedSource, int i11);

        void e(boolean z10, boolean z11, int i10, int i11, List list, e eVar);

        void f(int i10, c9.a aVar, ByteString byteString);

        void g(boolean z10, i iVar);

        void ping(boolean z10, int i10, int i11);

        void priority(int i10, int i11, int i12, boolean z10);

        void pushPromise(int i10, int i11, List list);

        void windowUpdate(int i10, long j10);
    }

    boolean t(a aVar);
}
