package anet.channel.bytes;

import java.util.Arrays;
import java.util.Random;
import java.util.TreeSet;

/* loaded from: classes.dex */
public class a {
    public static final int MAX_POOL_SIZE = 524288;
    public static final String TAG = "awcn.ByteArrayPool";

    /* renamed from: a, reason: collision with root package name */
    private final TreeSet<ByteArray> f3890a = new TreeSet<>();

    /* renamed from: b, reason: collision with root package name */
    private final ByteArray f3891b = ByteArray.create(0);

    /* renamed from: c, reason: collision with root package name */
    private final Random f3892c = new Random();

    /* renamed from: d, reason: collision with root package name */
    private long f3893d = 0;

    /* renamed from: anet.channel.bytes.a$a, reason: collision with other inner class name */
    public static class C0063a {

        /* renamed from: a, reason: collision with root package name */
        public static a f3894a = new a();
    }

    public synchronized void a(ByteArray byteArray) {
        if (byteArray != null) {
            int i10 = byteArray.bufferLength;
            if (i10 < 524288) {
                this.f3893d += i10;
                this.f3890a.add(byteArray);
                while (this.f3893d > 524288) {
                    this.f3893d -= (this.f3892c.nextBoolean() ? this.f3890a.pollFirst() : this.f3890a.pollLast()).bufferLength;
                }
            }
        }
    }

    public synchronized ByteArray a(int i10) {
        if (i10 >= 524288) {
            return ByteArray.create(i10);
        }
        ByteArray byteArray = this.f3891b;
        byteArray.bufferLength = i10;
        ByteArray ceiling = this.f3890a.ceiling(byteArray);
        if (ceiling == null) {
            ceiling = ByteArray.create(i10);
        } else {
            Arrays.fill(ceiling.buffer, (byte) 0);
            ceiling.dataLength = 0;
            this.f3890a.remove(ceiling);
            this.f3893d -= ceiling.bufferLength;
        }
        return ceiling;
    }

    public ByteArray a(byte[] bArr, int i10) {
        ByteArray a10 = a(i10);
        System.arraycopy(bArr, 0, a10.buffer, 0, i10);
        a10.dataLength = i10;
        return a10;
    }
}
