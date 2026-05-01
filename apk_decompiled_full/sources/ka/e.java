package ka;

import ma.p;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

/* loaded from: classes3.dex */
public class e extends ResponseBody {

    /* renamed from: c, reason: collision with root package name */
    public ResponseBody f15716c;

    /* renamed from: d, reason: collision with root package name */
    public d f15717d;

    /* renamed from: e, reason: collision with root package name */
    public BufferedSource f15718e;

    public class a extends ForwardingSource {

        /* renamed from: a, reason: collision with root package name */
        public long f15719a;

        public a(Source source) {
            super(source);
            this.f15719a = 0L;
        }

        @Override // okio.ForwardingSource, okio.Source
        public long read(Buffer buffer, long j10) {
            long read = super.read(buffer, j10);
            this.f15719a += read != -1 ? read : 0L;
            p.b("download", "read: " + ((int) ((this.f15719a * 100) / e.this.f15716c.contentLength())));
            if (e.this.f15717d != null && read != -1) {
                e.this.f15717d.b((int) this.f15719a);
                if (this.f15719a == e.this.f15716c.contentLength()) {
                    e.this.f15717d.a();
                }
            }
            return read;
        }
    }

    public e(ResponseBody responseBody, d dVar) {
        this.f15716c = responseBody;
        this.f15717d = dVar;
        dVar.d(responseBody.contentLength());
    }

    public final Source c(Source source) {
        return new a(source);
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.f15716c.contentLength();
    }

    @Override // okhttp3.ResponseBody
    public MediaType contentType() {
        return this.f15716c.contentType();
    }

    @Override // okhttp3.ResponseBody
    public BufferedSource source() {
        if (this.f15718e == null) {
            this.f15718e = Okio.buffer(c(this.f15716c.source()));
        }
        return this.f15718e;
    }
}
