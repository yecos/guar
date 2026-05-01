package com.google.common.hash;

import com.google.common.annotations.GwtIncompatible;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Random;
import javax.annotation.CheckForNull;
import sun.misc.Unsafe;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
abstract class Striped64 extends Number {
    private static final Unsafe UNSAFE;
    private static final long baseOffset;
    private static final long busyOffset;
    volatile transient long base;
    volatile transient int busy;

    @CheckForNull
    volatile transient Cell[] cells;
    static final ThreadLocal<int[]> threadHashCode = new ThreadLocal<>();
    static final Random rng = new Random();
    static final int NCPU = Runtime.getRuntime().availableProcessors();

    public static final class Cell {
        private static final Unsafe UNSAFE;
        private static final long valueOffset;

        /* renamed from: p0, reason: collision with root package name */
        volatile long f6896p0;

        /* renamed from: p1, reason: collision with root package name */
        volatile long f6897p1;

        /* renamed from: p2, reason: collision with root package name */
        volatile long f6898p2;

        /* renamed from: p3, reason: collision with root package name */
        volatile long f6899p3;

        /* renamed from: p4, reason: collision with root package name */
        volatile long f6900p4;

        /* renamed from: p5, reason: collision with root package name */
        volatile long f6901p5;

        /* renamed from: p6, reason: collision with root package name */
        volatile long f6902p6;

        /* renamed from: q0, reason: collision with root package name */
        volatile long f6903q0;

        /* renamed from: q1, reason: collision with root package name */
        volatile long f6904q1;

        /* renamed from: q2, reason: collision with root package name */
        volatile long f6905q2;

        /* renamed from: q3, reason: collision with root package name */
        volatile long f6906q3;

        /* renamed from: q4, reason: collision with root package name */
        volatile long f6907q4;

        /* renamed from: q5, reason: collision with root package name */
        volatile long f6908q5;

        /* renamed from: q6, reason: collision with root package name */
        volatile long f6909q6;
        volatile long value;

        static {
            try {
                Unsafe unsafe = Striped64.getUnsafe();
                UNSAFE = unsafe;
                valueOffset = unsafe.objectFieldOffset(Cell.class.getDeclaredField("value"));
            } catch (Exception e10) {
                throw new Error(e10);
            }
        }

        public Cell(long j10) {
            this.value = j10;
        }

        public final boolean cas(long j10, long j11) {
            return UNSAFE.compareAndSwapLong(this, valueOffset, j10, j11);
        }
    }

    static {
        try {
            Unsafe unsafe = getUnsafe();
            UNSAFE = unsafe;
            baseOffset = unsafe.objectFieldOffset(Striped64.class.getDeclaredField("base"));
            busyOffset = unsafe.objectFieldOffset(Striped64.class.getDeclaredField("busy"));
        } catch (Exception e10) {
            throw new Error(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Unsafe getUnsafe() {
        try {
            try {
                return Unsafe.getUnsafe();
            } catch (PrivilegedActionException e10) {
                throw new RuntimeException("Could not initialize intrinsics", e10.getCause());
            }
        } catch (SecurityException unused) {
            return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: com.google.common.hash.Striped64.1
                @Override // java.security.PrivilegedExceptionAction
                public Unsafe run() {
                    for (Field field : Unsafe.class.getDeclaredFields()) {
                        field.setAccessible(true);
                        Object obj = field.get(null);
                        if (Unsafe.class.isInstance(obj)) {
                            return (Unsafe) Unsafe.class.cast(obj);
                        }
                    }
                    throw new NoSuchFieldError("the Unsafe");
                }
            });
        }
    }

    final boolean casBase(long j10, long j11) {
        return UNSAFE.compareAndSwapLong(this, baseOffset, j10, j11);
    }

    final boolean casBusy() {
        return UNSAFE.compareAndSwapInt(this, busyOffset, 0, 1);
    }

    abstract long fn(long j10, long j11);

    final void internalReset(long j10) {
        Cell[] cellArr = this.cells;
        this.base = j10;
        if (cellArr != null) {
            for (Cell cell : cellArr) {
                if (cell != null) {
                    cell.value = j10;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x00ee A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0023 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final void retryUpdate(long j10, @CheckForNull int[] iArr, boolean z10) {
        int i10;
        int[] iArr2;
        boolean z11;
        int length;
        boolean z12;
        int length2;
        if (iArr == null) {
            iArr2 = new int[1];
            threadHashCode.set(iArr2);
            i10 = rng.nextInt();
            if (i10 == 0) {
                i10 = 1;
            }
            iArr2[0] = i10;
        } else {
            i10 = iArr[0];
            iArr2 = iArr;
        }
        int i11 = i10;
        boolean z13 = false;
        boolean z14 = z10;
        while (true) {
            Cell[] cellArr = this.cells;
            if (cellArr != null && (length = cellArr.length) > 0) {
                Cell cell = cellArr[(length - 1) & i11];
                if (cell == null) {
                    if (this.busy == 0) {
                        Cell cell2 = new Cell(j10);
                        if (this.busy == 0 && casBusy()) {
                            try {
                                Cell[] cellArr2 = this.cells;
                                if (cellArr2 != null && (length2 = cellArr2.length) > 0) {
                                    int i12 = (length2 - 1) & i11;
                                    if (cellArr2[i12] == null) {
                                        cellArr2[i12] = cell2;
                                        z12 = true;
                                        if (!z12) {
                                            return;
                                        }
                                    }
                                }
                                z12 = false;
                                if (!z12) {
                                }
                            } finally {
                            }
                        }
                    }
                    z13 = false;
                } else if (z14) {
                    long j11 = cell.value;
                    if (cell.cas(j11, fn(j11, j10))) {
                        return;
                    }
                    if (length < NCPU && this.cells == cellArr) {
                        if (!z13) {
                            z13 = true;
                        } else if (this.busy == 0 && casBusy()) {
                            try {
                                if (this.cells == cellArr) {
                                    Cell[] cellArr3 = new Cell[length << 1];
                                    for (int i13 = 0; i13 < length; i13++) {
                                        cellArr3[i13] = cellArr[i13];
                                    }
                                    this.cells = cellArr3;
                                }
                                this.busy = 0;
                                z13 = false;
                            } finally {
                            }
                        }
                    }
                    z13 = false;
                } else {
                    z14 = true;
                }
                int i14 = i11 ^ (i11 << 13);
                int i15 = i14 ^ (i14 >>> 17);
                i11 = i15 ^ (i15 << 5);
                iArr2[0] = i11;
            } else if (this.busy == 0 && this.cells == cellArr && casBusy()) {
                try {
                    if (this.cells == cellArr) {
                        Cell[] cellArr4 = new Cell[2];
                        cellArr4[i11 & 1] = new Cell(j10);
                        this.cells = cellArr4;
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (z11) {
                        return;
                    }
                } finally {
                }
            } else {
                long j12 = this.base;
                if (casBase(j12, fn(j12, j10))) {
                    return;
                }
            }
        }
    }
}
