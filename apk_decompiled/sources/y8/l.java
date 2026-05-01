package y8;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes3.dex */
public interface l extends n, u {

    public static final class a implements l {
        @Override // y8.n, y8.u
        public String a() {
            return "gzip";
        }

        @Override // y8.n
        public OutputStream compress(OutputStream outputStream) {
            return new GZIPOutputStream(outputStream);
        }

        @Override // y8.u
        public InputStream decompress(InputStream inputStream) {
            return new GZIPInputStream(inputStream);
        }
    }

    public static final class b implements l {

        /* renamed from: a, reason: collision with root package name */
        public static final l f19933a = new b();

        @Override // y8.n, y8.u
        public String a() {
            return "identity";
        }

        @Override // y8.n
        public OutputStream compress(OutputStream outputStream) {
            return outputStream;
        }

        @Override // y8.u
        public InputStream decompress(InputStream inputStream) {
            return inputStream;
        }
    }
}
