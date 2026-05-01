package e9;

import com.google.common.base.Preconditions;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import java.io.InputStream;
import java.io.OutputStream;
import y8.w0;

/* loaded from: classes3.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static volatile ExtensionRegistryLite f12962a = ExtensionRegistryLite.getEmptyRegistry();

    public static final class a implements w0.c {

        /* renamed from: c, reason: collision with root package name */
        public static final ThreadLocal f12963c = new ThreadLocal();

        /* renamed from: a, reason: collision with root package name */
        public final Parser f12964a;

        /* renamed from: b, reason: collision with root package name */
        public final MessageLite f12965b;

        public a(MessageLite messageLite) {
            this.f12965b = messageLite;
            this.f12964a = messageLite.getParserForType();
        }

        /* JADX WARN: Removed duplicated region for block: B:34:0x0084  */
        @Override // y8.w0.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public com.google.protobuf.MessageLite parse(java.io.InputStream r6) {
            /*
                r5 = this;
                boolean r0 = r6 instanceof e9.a
                if (r0 == 0) goto L17
                r0 = r6
                e9.a r0 = (e9.a) r0
                com.google.protobuf.Parser r0 = r0.c()
                com.google.protobuf.Parser r1 = r5.f12964a
                if (r0 != r1) goto L17
                r0 = r6
                e9.a r0 = (e9.a) r0     // Catch: java.lang.IllegalStateException -> L17
                com.google.protobuf.MessageLite r6 = r0.b()     // Catch: java.lang.IllegalStateException -> L17
                return r6
            L17:
                boolean r0 = r6 instanceof y8.n0     // Catch: java.io.IOException -> La5
                if (r0 == 0) goto L81
                int r0 = r6.available()     // Catch: java.io.IOException -> La5
                if (r0 <= 0) goto L7c
                r1 = 4194304(0x400000, float:5.877472E-39)
                if (r0 > r1) goto L7c
                java.lang.ThreadLocal r1 = e9.b.a.f12963c     // Catch: java.io.IOException -> La5
                java.lang.Object r2 = r1.get()     // Catch: java.io.IOException -> La5
                java.lang.ref.Reference r2 = (java.lang.ref.Reference) r2     // Catch: java.io.IOException -> La5
                if (r2 == 0) goto L3a
                java.lang.Object r2 = r2.get()     // Catch: java.io.IOException -> La5
                byte[] r2 = (byte[]) r2     // Catch: java.io.IOException -> La5
                if (r2 == 0) goto L3a
                int r3 = r2.length     // Catch: java.io.IOException -> La5
                if (r3 >= r0) goto L44
            L3a:
                byte[] r2 = new byte[r0]     // Catch: java.io.IOException -> La5
                java.lang.ref.WeakReference r3 = new java.lang.ref.WeakReference     // Catch: java.io.IOException -> La5
                r3.<init>(r2)     // Catch: java.io.IOException -> La5
                r1.set(r3)     // Catch: java.io.IOException -> La5
            L44:
                r1 = r0
            L45:
                if (r1 <= 0) goto L53
                int r3 = r0 - r1
                int r3 = r6.read(r2, r3, r1)     // Catch: java.io.IOException -> La5
                r4 = -1
                if (r3 != r4) goto L51
                goto L53
            L51:
                int r1 = r1 - r3
                goto L45
            L53:
                if (r1 != 0) goto L5b
                r1 = 0
                com.google.protobuf.CodedInputStream r0 = com.google.protobuf.CodedInputStream.newInstance(r2, r1, r0)     // Catch: java.io.IOException -> La5
                goto L82
            L5b:
                int r6 = r0 - r1
                java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch: java.io.IOException -> La5
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.io.IOException -> La5
                r2.<init>()     // Catch: java.io.IOException -> La5
                java.lang.String r3 = "size inaccurate: "
                r2.append(r3)     // Catch: java.io.IOException -> La5
                r2.append(r0)     // Catch: java.io.IOException -> La5
                java.lang.String r0 = " != "
                r2.append(r0)     // Catch: java.io.IOException -> La5
                r2.append(r6)     // Catch: java.io.IOException -> La5
                java.lang.String r6 = r2.toString()     // Catch: java.io.IOException -> La5
                r1.<init>(r6)     // Catch: java.io.IOException -> La5
                throw r1     // Catch: java.io.IOException -> La5
            L7c:
                if (r0 != 0) goto L81
                com.google.protobuf.MessageLite r6 = r5.f12965b     // Catch: java.io.IOException -> La5
                return r6
            L81:
                r0 = 0
            L82:
                if (r0 != 0) goto L88
                com.google.protobuf.CodedInputStream r0 = com.google.protobuf.CodedInputStream.newInstance(r6)
            L88:
                r6 = 2147483647(0x7fffffff, float:NaN)
                r0.setSizeLimit(r6)
                com.google.protobuf.MessageLite r6 = r5.c(r0)     // Catch: com.google.protobuf.InvalidProtocolBufferException -> L93
                return r6
            L93:
                r6 = move-exception
                y8.k1 r0 = y8.k1.f19903t
                java.lang.String r1 = "Invalid protobuf byte sequence"
                y8.k1 r0 = r0.r(r1)
                y8.k1 r6 = r0.q(r6)
                y8.m1 r6 = r6.d()
                throw r6
            La5:
                r6 = move-exception
                java.lang.RuntimeException r0 = new java.lang.RuntimeException
                r0.<init>(r6)
                goto Lad
            Lac:
                throw r0
            Lad:
                goto Lac
            */
            throw new UnsupportedOperationException("Method not decompiled: e9.b.a.parse(java.io.InputStream):com.google.protobuf.MessageLite");
        }

        public final MessageLite c(CodedInputStream codedInputStream) {
            MessageLite messageLite = (MessageLite) this.f12964a.parseFrom(codedInputStream, b.f12962a);
            try {
                codedInputStream.checkLastTagWas(0);
                return messageLite;
            } catch (InvalidProtocolBufferException e10) {
                e10.setUnfinishedMessage(messageLite);
                throw e10;
            }
        }

        @Override // y8.w0.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public InputStream a(MessageLite messageLite) {
            return new e9.a(messageLite, this.f12964a);
        }
    }

    public static long a(InputStream inputStream, OutputStream outputStream) {
        Preconditions.checkNotNull(inputStream, "inputStream cannot be null!");
        Preconditions.checkNotNull(outputStream, "outputStream cannot be null!");
        byte[] bArr = new byte[8192];
        long j10 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return j10;
            }
            outputStream.write(bArr, 0, read);
            j10 += read;
        }
    }

    public static w0.c b(MessageLite messageLite) {
        return new a(messageLite);
    }
}
