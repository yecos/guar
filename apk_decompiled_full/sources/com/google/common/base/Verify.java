package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public final class Verify {
    private Verify() {
    }

    public static void verify(boolean z10) {
        if (!z10) {
            throw new VerifyException();
        }
    }

    @CanIgnoreReturnValue
    public static <T> T verifyNotNull(@CheckForNull T t10) {
        return (T) verifyNotNull(t10, "expected a non-null reference", new Object[0]);
    }

    public static void verify(boolean z10, String str, @CheckForNull Object... objArr) {
        if (!z10) {
            throw new VerifyException(Strings.lenientFormat(str, objArr));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T verifyNotNull(@CheckForNull T t10, String str, @CheckForNull Object... objArr) {
        if (t10 != null) {
            return t10;
        }
        throw new VerifyException(Strings.lenientFormat(str, objArr));
    }

    public static void verify(boolean z10, String str, char c10) {
        if (!z10) {
            throw new VerifyException(Strings.lenientFormat(str, Character.valueOf(c10)));
        }
    }

    public static void verify(boolean z10, String str, int i10) {
        if (!z10) {
            throw new VerifyException(Strings.lenientFormat(str, Integer.valueOf(i10)));
        }
    }

    public static void verify(boolean z10, String str, long j10) {
        if (!z10) {
            throw new VerifyException(Strings.lenientFormat(str, Long.valueOf(j10)));
        }
    }

    public static void verify(boolean z10, String str, @CheckForNull Object obj) {
        if (!z10) {
            throw new VerifyException(Strings.lenientFormat(str, obj));
        }
    }

    public static void verify(boolean z10, String str, char c10, char c11) {
        if (!z10) {
            throw new VerifyException(Strings.lenientFormat(str, Character.valueOf(c10), Character.valueOf(c11)));
        }
    }

    public static void verify(boolean z10, String str, int i10, char c10) {
        if (!z10) {
            throw new VerifyException(Strings.lenientFormat(str, Integer.valueOf(i10), Character.valueOf(c10)));
        }
    }

    public static void verify(boolean z10, String str, long j10, char c10) {
        if (!z10) {
            throw new VerifyException(Strings.lenientFormat(str, Long.valueOf(j10), Character.valueOf(c10)));
        }
    }

    public static void verify(boolean z10, String str, @CheckForNull Object obj, char c10) {
        if (!z10) {
            throw new VerifyException(Strings.lenientFormat(str, obj, Character.valueOf(c10)));
        }
    }

    public static void verify(boolean z10, String str, char c10, int i10) {
        if (!z10) {
            throw new VerifyException(Strings.lenientFormat(str, Character.valueOf(c10), Integer.valueOf(i10)));
        }
    }

    public static void verify(boolean z10, String str, int i10, int i11) {
        if (!z10) {
            throw new VerifyException(Strings.lenientFormat(str, Integer.valueOf(i10), Integer.valueOf(i11)));
        }
    }

    public static void verify(boolean z10, String str, long j10, int i10) {
        if (!z10) {
            throw new VerifyException(Strings.lenientFormat(str, Long.valueOf(j10), Integer.valueOf(i10)));
        }
    }

    public static void verify(boolean z10, String str, @CheckForNull Object obj, int i10) {
        if (!z10) {
            throw new VerifyException(Strings.lenientFormat(str, obj, Integer.valueOf(i10)));
        }
    }

    public static void verify(boolean z10, String str, char c10, long j10) {
        if (!z10) {
            throw new VerifyException(Strings.lenientFormat(str, Character.valueOf(c10), Long.valueOf(j10)));
        }
    }

    public static void verify(boolean z10, String str, int i10, long j10) {
        if (!z10) {
            throw new VerifyException(Strings.lenientFormat(str, Integer.valueOf(i10), Long.valueOf(j10)));
        }
    }

    public static void verify(boolean z10, String str, long j10, long j11) {
        if (!z10) {
            throw new VerifyException(Strings.lenientFormat(str, Long.valueOf(j10), Long.valueOf(j11)));
        }
    }

    public static void verify(boolean z10, String str, @CheckForNull Object obj, long j10) {
        if (!z10) {
            throw new VerifyException(Strings.lenientFormat(str, obj, Long.valueOf(j10)));
        }
    }

    public static void verify(boolean z10, String str, char c10, @CheckForNull Object obj) {
        if (!z10) {
            throw new VerifyException(Strings.lenientFormat(str, Character.valueOf(c10), obj));
        }
    }

    public static void verify(boolean z10, String str, int i10, @CheckForNull Object obj) {
        if (!z10) {
            throw new VerifyException(Strings.lenientFormat(str, Integer.valueOf(i10), obj));
        }
    }

    public static void verify(boolean z10, String str, long j10, @CheckForNull Object obj) {
        if (!z10) {
            throw new VerifyException(Strings.lenientFormat(str, Long.valueOf(j10), obj));
        }
    }

    public static void verify(boolean z10, String str, @CheckForNull Object obj, @CheckForNull Object obj2) {
        if (!z10) {
            throw new VerifyException(Strings.lenientFormat(str, obj, obj2));
        }
    }

    public static void verify(boolean z10, String str, @CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3) {
        if (!z10) {
            throw new VerifyException(Strings.lenientFormat(str, obj, obj2, obj3));
        }
    }

    public static void verify(boolean z10, String str, @CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3, @CheckForNull Object obj4) {
        if (!z10) {
            throw new VerifyException(Strings.lenientFormat(str, obj, obj2, obj3, obj4));
        }
    }
}
