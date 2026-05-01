package com.efs.sdk.net;

import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.integrationtesting.IntegrationTestingUtil;
import com.efs.sdk.net.a.a.e;
import com.efs.sdk.net.a.a.f;
import com.efs.sdk.net.a.a.g;
import com.efs.sdk.net.a.a.h;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.zip.InflaterOutputStream;
import okhttp3.Connection;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;

/* loaded from: classes.dex */
public class OkHttpInterceptor implements Interceptor {

    /* renamed from: a, reason: collision with root package name */
    private final f f6352a = g.c();

    public static class a extends ResponseBody {

        /* renamed from: a, reason: collision with root package name */
        private final ResponseBody f6353a;

        /* renamed from: b, reason: collision with root package name */
        private final BufferedSource f6354b;

        public a(ResponseBody responseBody, InputStream inputStream) {
            this.f6353a = responseBody;
            this.f6354b = Okio.buffer(Okio.source(inputStream));
        }

        @Override // okhttp3.ResponseBody
        public final long contentLength() {
            return this.f6353a.contentLength();
        }

        @Override // okhttp3.ResponseBody
        public final MediaType contentType() {
            return this.f6353a.contentType();
        }

        @Override // okhttp3.ResponseBody
        public final BufferedSource source() {
            return this.f6354b;
        }
    }

    public static class b implements f.b {

        /* renamed from: a, reason: collision with root package name */
        private final String f6355a;

        /* renamed from: b, reason: collision with root package name */
        private final Request f6356b;

        /* renamed from: c, reason: collision with root package name */
        private h f6357c;

        public b(String str, Request request, h hVar) {
            this.f6355a = str;
            this.f6356b = request;
            this.f6357c = hVar;
        }

        @Override // com.efs.sdk.net.a.a.f.c
        public final String a() {
            return this.f6355a;
        }

        @Override // com.efs.sdk.net.a.a.f.b
        public final String b() {
            return this.f6356b.url().toString();
        }

        @Override // com.efs.sdk.net.a.a.f.b
        public final String c() {
            return this.f6356b.method();
        }

        @Override // com.efs.sdk.net.a.a.f.b
        public final byte[] d() {
            RequestBody body = this.f6356b.body();
            if (body == null) {
                return null;
            }
            h hVar = this.f6357c;
            String header = this.f6356b.header("Content-Encoding");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            com.efs.sdk.net.a.a.a aVar = new com.efs.sdk.net.a.a.a("gzip".equals(header) ? e.a(byteArrayOutputStream) : "deflate".equals(header) ? new InflaterOutputStream(byteArrayOutputStream) : byteArrayOutputStream);
            hVar.f6388c = aVar;
            hVar.f6387b = byteArrayOutputStream;
            BufferedSink buffer = Okio.buffer(Okio.sink(aVar));
            try {
                body.writeTo(buffer);
                buffer.close();
                h hVar2 = this.f6357c;
                hVar2.b();
                return hVar2.f6387b.toByteArray();
            } catch (Throwable th) {
                buffer.close();
                throw th;
            }
        }

        @Override // com.efs.sdk.net.a.a.f.a
        public final int e() {
            return this.f6356b.headers().size();
        }

        @Override // com.efs.sdk.net.a.a.f.a
        public final String a(int i10) {
            return this.f6356b.headers().name(i10);
        }

        @Override // com.efs.sdk.net.a.a.f.a
        public final String b(int i10) {
            return this.f6356b.headers().value(i10);
        }
    }

    public static class c implements f.d {

        /* renamed from: a, reason: collision with root package name */
        private final String f6358a;

        /* renamed from: b, reason: collision with root package name */
        private final Request f6359b;

        /* renamed from: c, reason: collision with root package name */
        private final Response f6360c;

        /* renamed from: d, reason: collision with root package name */
        private final Connection f6361d;

        public c(String str, Request request, Response response, Connection connection) {
            this.f6358a = str;
            this.f6359b = request;
            this.f6360c = response;
            this.f6361d = connection;
        }

        @Override // com.efs.sdk.net.a.a.f.e
        public final String a() {
            return this.f6358a;
        }

        @Override // com.efs.sdk.net.a.a.f.e
        public final int b() {
            return this.f6360c.code();
        }

        @Override // com.efs.sdk.net.a.a.f.a
        public final int e() {
            return this.f6360c.headers().size();
        }

        @Override // com.efs.sdk.net.a.a.f.a
        public final String a(int i10) {
            return this.f6360c.headers().name(i10);
        }

        @Override // com.efs.sdk.net.a.a.f.a
        public final String b(int i10) {
            return this.f6360c.headers().value(i10);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(18:0|1|2|3|(1:5)|(3:55|56|(1:58)(6:59|15|(3:38|39|(1:41)(1:42))|(1:20)|21|(6:23|(1:25)(1:35)|26|(1:28)|29|(2:31|32)(1:34))(2:36|37)))|(1:9)(1:54)|10|11|12|13|14|15|(0)|(2:18|20)|21|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0087, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0088, code lost:
    
        r8 = r3;
        r3 = r0;
        r0 = r5;
        r5 = r4;
        r4 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x008e, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x008f, code lost:
    
        r5 = r4;
        r4 = r3;
        r3 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00ae A[Catch: all -> 0x00aa, TryCatch #2 {all -> 0x00aa, blocks: (B:39:0x00a3, B:18:0x00ae, B:20:0x00b4, B:21:0x00c1, B:23:0x00c7, B:25:0x00d7, B:26:0x00e2, B:28:0x00e6, B:29:0x00ea, B:31:0x00fd, B:36:0x0110, B:37:0x0117), top: B:38:0x00a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c7 A[Catch: all -> 0x00aa, TryCatch #2 {all -> 0x00aa, blocks: (B:39:0x00a3, B:18:0x00ae, B:20:0x00b4, B:21:0x00c1, B:23:0x00c7, B:25:0x00d7, B:26:0x00e2, B:28:0x00e6, B:29:0x00ea, B:31:0x00fd, B:36:0x0110, B:37:0x0117), top: B:38:0x00a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0110 A[Catch: all -> 0x00aa, TryCatch #2 {all -> 0x00aa, blocks: (B:39:0x00a3, B:18:0x00ae, B:20:0x00b4, B:21:0x00c1, B:23:0x00c7, B:25:0x00d7, B:26:0x00e2, B:28:0x00e6, B:29:0x00ea, B:31:0x00fd, B:36:0x0110, B:37:0x0117), top: B:38:0x00a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // okhttp3.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Response intercept(Interceptor.Chain chain) {
        h hVar;
        String str;
        boolean z10;
        h hVar2;
        boolean z11;
        String str2;
        Connection connection;
        MediaType mediaType;
        InputStream inputStream;
        Request request = chain.request();
        try {
            Log.d("NetTrace-Interceptor", "begin intercept");
            z11 = NetManager.getNetConfigManager() != null ? NetManager.getNetConfigManager().enableTracer() : false;
        } catch (Throwable th) {
            th = th;
            hVar = null;
            str = null;
            z10 = false;
        }
        if (!z11) {
            try {
            } catch (Throwable th2) {
                th = th2;
                str = null;
                z10 = z11;
                hVar = null;
                th.printStackTrace();
                hVar2 = hVar;
                z11 = z10;
                str2 = str;
                Response proceed = chain.proceed(request);
                if (!z11) {
                }
                if (hVar2 != null) {
                }
                connection = chain.connection();
                if (connection != null) {
                }
            }
            if (!IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Interceptor", "net enable is false~");
                hVar2 = null;
                str2 = null;
                Response proceed2 = chain.proceed(request);
                if (!z11) {
                    try {
                        if (!IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                            return proceed2;
                        }
                    } catch (Throwable th3) {
                        th3.printStackTrace();
                        return proceed2;
                    }
                }
                if (hVar2 != null && hVar2.a()) {
                    hVar2.b();
                    f fVar = hVar2.f6386a;
                    hVar2.f6387b.size();
                    fVar.a();
                }
                connection = chain.connection();
                if (connection != null) {
                    throw new IllegalStateException("No connection associated with this request; did you use addInterceptor instead of addNetworkInterceptor?");
                }
                this.f6352a.a(new c(str2, request, proceed2, connection));
                ResponseBody body = proceed2.body();
                if (body != null) {
                    mediaType = body.contentType();
                    inputStream = body.byteStream();
                } else {
                    mediaType = null;
                    inputStream = null;
                }
                f fVar2 = this.f6352a;
                String mediaType2 = mediaType != null ? mediaType.toString() : null;
                String header = proceed2.header("Content-Encoding");
                new com.efs.sdk.net.a.a.c(this.f6352a, str2);
                InputStream a10 = fVar2.a(str2, mediaType2, header, inputStream);
                return a10 != null ? proceed2.newBuilder().body(new a(body, a10)).build() : proceed2;
            }
        }
        if (request != null) {
            Log.d("NetTrace-Interceptor", "intercept request is " + request.toString());
        } else {
            Log.d("NetTrace-Interceptor", "intercept request is null~");
        }
        str2 = this.f6352a.b();
        Log.d("NetTrace-Interceptor", "intercept request id is ".concat(String.valueOf(str2)));
        com.efs.sdk.net.a.a.a().a(str2).f6396c = request.url().toString();
        hVar2 = new h(this.f6352a, str2);
        this.f6352a.a(new b(str2, request, hVar2));
        Response proceed22 = chain.proceed(request);
        if (!z11) {
        }
        if (hVar2 != null) {
            hVar2.b();
            f fVar3 = hVar2.f6386a;
            hVar2.f6387b.size();
            fVar3.a();
        }
        connection = chain.connection();
        if (connection != null) {
        }
    }
}
