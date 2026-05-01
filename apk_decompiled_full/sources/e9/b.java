package e9;

import com.google.common.base.Preconditions;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import y8.k1;
import y8.n0;
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
        */
        public MessageLite parse(InputStream inputStream) {
            CodedInputStream codedInputStream;
            byte[] bArr;
            if ((inputStream instanceof e9.a) && ((e9.a) inputStream).c() == this.f12964a) {
                try {
                    return ((e9.a) inputStream).b();
                } catch (IllegalStateException unused) {
                }
            }
            try {
                try {
                    if (inputStream instanceof n0) {
                        int available = inputStream.available();
                        if (available > 0 && available <= 4194304) {
                            ThreadLocal threadLocal = f12963c;
                            Reference reference = (Reference) threadLocal.get();
                            if (reference == null || (bArr = (byte[]) reference.get()) == null || bArr.length < available) {
                                bArr = new byte[available];
                                threadLocal.set(new WeakReference(bArr));
                            }
                            int i10 = available;
                            while (i10 > 0) {
                                int read = inputStream.read(bArr, available - i10, i10);
                                if (read == -1) {
                                    break;
                                }
                                i10 -= read;
                            }
                            if (i10 == 0) {
                                codedInputStream = CodedInputStream.newInstance(bArr, 0, available);
                                if (codedInputStream == null) {
                                    codedInputStream = CodedInputStream.newInstance(inputStream);
                                }
                                codedInputStream.setSizeLimit(Integer.MAX_VALUE);
                                return c(codedInputStream);
                            }
                            throw new RuntimeException("size inaccurate: " + available + " != " + (available - i10));
                        }
                        if (available == 0) {
                            return this.f12965b;
                        }
                    }
                    return c(codedInputStream);
                } catch (InvalidProtocolBufferException e10) {
                    throw k1.f19903t.r("Invalid protobuf byte sequence").q(e10).d();
                }
                codedInputStream = null;
                if (codedInputStream == null) {
                }
                codedInputStream.setSizeLimit(Integer.MAX_VALUE);
            } catch (IOException e11) {
                throw new RuntimeException(e11);
            }
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
