package c9;

import java.io.Closeable;
import java.util.List;
import okio.Buffer;

/* loaded from: classes3.dex */
public interface c extends Closeable {
    void F(i iVar);

    void K(boolean z10, boolean z11, int i10, int i11, List list);

    void connectionPreface();

    void d(int i10, a aVar);

    void data(boolean z10, int i10, Buffer buffer, int i11);

    void flush();

    void g(i iVar);

    int maxDataLength();

    void o(int i10, a aVar, byte[] bArr);

    void ping(boolean z10, int i10, int i11);

    void windowUpdate(int i10, long j10);
}
