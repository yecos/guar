package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.firebase.analytics.FirebaseAnalytics;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public final class Preconditions {
    private Preconditions() {
    }

    private static String badElementIndex(int i10, int i11, String str) {
        if (i10 < 0) {
            return Strings.lenientFormat("%s (%s) must not be negative", str, Integer.valueOf(i10));
        }
        if (i11 >= 0) {
            return Strings.lenientFormat("%s (%s) must be less than size (%s)", str, Integer.valueOf(i10), Integer.valueOf(i11));
        }
        StringBuilder sb = new StringBuilder(26);
        sb.append("negative size: ");
        sb.append(i11);
        throw new IllegalArgumentException(sb.toString());
    }

    private static String badPositionIndex(int i10, int i11, String str) {
        if (i10 < 0) {
            return Strings.lenientFormat("%s (%s) must not be negative", str, Integer.valueOf(i10));
        }
        if (i11 >= 0) {
            return Strings.lenientFormat("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i10), Integer.valueOf(i11));
        }
        StringBuilder sb = new StringBuilder(26);
        sb.append("negative size: ");
        sb.append(i11);
        throw new IllegalArgumentException(sb.toString());
    }

    private static String badPositionIndexes(int i10, int i11, int i12) {
        return (i10 < 0 || i10 > i12) ? badPositionIndex(i10, i12, "start index") : (i11 < 0 || i11 > i12) ? badPositionIndex(i11, i12, "end index") : Strings.lenientFormat("end index (%s) must not be less than start index (%s)", Integer.valueOf(i11), Integer.valueOf(i10));
    }

    public static void checkArgument(boolean z10) {
        if (!z10) {
            throw new IllegalArgumentException();
        }
    }

    @CanIgnoreReturnValue
    public static int checkElementIndex(int i10, int i11) {
        return checkElementIndex(i10, i11, FirebaseAnalytics.Param.INDEX);
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(@CheckForNull T t10) {
        t10.getClass();
        return t10;
    }

    @CanIgnoreReturnValue
    public static int checkPositionIndex(int i10, int i11) {
        return checkPositionIndex(i10, i11, FirebaseAnalytics.Param.INDEX);
    }

    public static void checkPositionIndexes(int i10, int i11, int i12) {
        if (i10 < 0 || i11 < i10 || i11 > i12) {
            throw new IndexOutOfBoundsException(badPositionIndexes(i10, i11, i12));
        }
    }

    public static void checkState(boolean z10) {
        if (!z10) {
            throw new IllegalStateException();
        }
    }

    public static void checkArgument(boolean z10, @CheckForNull Object obj) {
        if (!z10) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    @CanIgnoreReturnValue
    public static int checkElementIndex(int i10, int i11, String str) {
        if (i10 < 0 || i10 >= i11) {
            throw new IndexOutOfBoundsException(badElementIndex(i10, i11, str));
        }
        return i10;
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(@CheckForNull T t10, @CheckForNull Object obj) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    @CanIgnoreReturnValue
    public static int checkPositionIndex(int i10, int i11, String str) {
        if (i10 < 0 || i10 > i11) {
            throw new IndexOutOfBoundsException(badPositionIndex(i10, i11, str));
        }
        return i10;
    }

    public static void checkState(boolean z10, @CheckForNull Object obj) {
        if (!z10) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void checkArgument(boolean z10, String str, @CheckForNull Object... objArr) {
        if (!z10) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, objArr));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(@CheckForNull T t10, String str, @CheckForNull Object... objArr) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(Strings.lenientFormat(str, objArr));
    }

    public static void checkState(boolean z10, @CheckForNull String str, @CheckForNull Object... objArr) {
        if (!z10) {
            throw new IllegalStateException(Strings.lenientFormat(str, objArr));
        }
    }

    public static void checkArgument(boolean z10, String str, char c10) {
        if (!z10) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Character.valueOf(c10)));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(@CheckForNull T t10, String str, char c10) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Character.valueOf(c10)));
    }

    public static void checkState(boolean z10, String str, char c10) {
        if (!z10) {
            throw new IllegalStateException(Strings.lenientFormat(str, Character.valueOf(c10)));
        }
    }

    public static void checkArgument(boolean z10, String str, int i10) {
        if (!z10) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Integer.valueOf(i10)));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(@CheckForNull T t10, String str, int i10) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Integer.valueOf(i10)));
    }

    public static void checkState(boolean z10, String str, int i10) {
        if (!z10) {
            throw new IllegalStateException(Strings.lenientFormat(str, Integer.valueOf(i10)));
        }
    }

    public static void checkArgument(boolean z10, String str, long j10) {
        if (!z10) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Long.valueOf(j10)));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(@CheckForNull T t10, String str, long j10) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Long.valueOf(j10)));
    }

    public static void checkState(boolean z10, String str, long j10) {
        if (!z10) {
            throw new IllegalStateException(Strings.lenientFormat(str, Long.valueOf(j10)));
        }
    }

    public static void checkArgument(boolean z10, String str, @CheckForNull Object obj) {
        if (!z10) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(@CheckForNull T t10, String str, @CheckForNull Object obj) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj));
    }

    public static void checkState(boolean z10, String str, @CheckForNull Object obj) {
        if (!z10) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj));
        }
    }

    public static void checkArgument(boolean z10, String str, char c10, char c11) {
        if (!z10) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Character.valueOf(c10), Character.valueOf(c11)));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(@CheckForNull T t10, String str, char c10, char c11) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Character.valueOf(c10), Character.valueOf(c11)));
    }

    public static void checkState(boolean z10, String str, char c10, char c11) {
        if (!z10) {
            throw new IllegalStateException(Strings.lenientFormat(str, Character.valueOf(c10), Character.valueOf(c11)));
        }
    }

    public static void checkArgument(boolean z10, String str, char c10, int i10) {
        if (!z10) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Character.valueOf(c10), Integer.valueOf(i10)));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(@CheckForNull T t10, String str, char c10, int i10) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Character.valueOf(c10), Integer.valueOf(i10)));
    }

    public static void checkState(boolean z10, String str, char c10, int i10) {
        if (!z10) {
            throw new IllegalStateException(Strings.lenientFormat(str, Character.valueOf(c10), Integer.valueOf(i10)));
        }
    }

    public static void checkArgument(boolean z10, String str, char c10, long j10) {
        if (!z10) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Character.valueOf(c10), Long.valueOf(j10)));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(@CheckForNull T t10, String str, char c10, long j10) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Character.valueOf(c10), Long.valueOf(j10)));
    }

    public static void checkState(boolean z10, String str, char c10, long j10) {
        if (!z10) {
            throw new IllegalStateException(Strings.lenientFormat(str, Character.valueOf(c10), Long.valueOf(j10)));
        }
    }

    public static void checkArgument(boolean z10, String str, char c10, @CheckForNull Object obj) {
        if (!z10) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Character.valueOf(c10), obj));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(@CheckForNull T t10, String str, char c10, @CheckForNull Object obj) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Character.valueOf(c10), obj));
    }

    public static void checkState(boolean z10, String str, char c10, @CheckForNull Object obj) {
        if (!z10) {
            throw new IllegalStateException(Strings.lenientFormat(str, Character.valueOf(c10), obj));
        }
    }

    public static void checkArgument(boolean z10, String str, int i10, char c10) {
        if (!z10) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Integer.valueOf(i10), Character.valueOf(c10)));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(@CheckForNull T t10, String str, int i10, char c10) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Integer.valueOf(i10), Character.valueOf(c10)));
    }

    public static void checkState(boolean z10, String str, int i10, char c10) {
        if (!z10) {
            throw new IllegalStateException(Strings.lenientFormat(str, Integer.valueOf(i10), Character.valueOf(c10)));
        }
    }

    public static void checkArgument(boolean z10, String str, int i10, int i11) {
        if (!z10) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Integer.valueOf(i10), Integer.valueOf(i11)));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(@CheckForNull T t10, String str, int i10, int i11) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Integer.valueOf(i10), Integer.valueOf(i11)));
    }

    public static void checkState(boolean z10, String str, int i10, int i11) {
        if (!z10) {
            throw new IllegalStateException(Strings.lenientFormat(str, Integer.valueOf(i10), Integer.valueOf(i11)));
        }
    }

    public static void checkArgument(boolean z10, String str, int i10, long j10) {
        if (!z10) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Integer.valueOf(i10), Long.valueOf(j10)));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(@CheckForNull T t10, String str, int i10, long j10) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Integer.valueOf(i10), Long.valueOf(j10)));
    }

    public static void checkState(boolean z10, String str, int i10, long j10) {
        if (!z10) {
            throw new IllegalStateException(Strings.lenientFormat(str, Integer.valueOf(i10), Long.valueOf(j10)));
        }
    }

    public static void checkArgument(boolean z10, String str, int i10, @CheckForNull Object obj) {
        if (!z10) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Integer.valueOf(i10), obj));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(@CheckForNull T t10, String str, int i10, @CheckForNull Object obj) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Integer.valueOf(i10), obj));
    }

    public static void checkState(boolean z10, String str, int i10, @CheckForNull Object obj) {
        if (!z10) {
            throw new IllegalStateException(Strings.lenientFormat(str, Integer.valueOf(i10), obj));
        }
    }

    public static void checkArgument(boolean z10, String str, long j10, char c10) {
        if (!z10) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Long.valueOf(j10), Character.valueOf(c10)));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(@CheckForNull T t10, String str, long j10, char c10) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Long.valueOf(j10), Character.valueOf(c10)));
    }

    public static void checkState(boolean z10, String str, long j10, char c10) {
        if (!z10) {
            throw new IllegalStateException(Strings.lenientFormat(str, Long.valueOf(j10), Character.valueOf(c10)));
        }
    }

    public static void checkArgument(boolean z10, String str, long j10, int i10) {
        if (!z10) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Long.valueOf(j10), Integer.valueOf(i10)));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(@CheckForNull T t10, String str, long j10, int i10) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Long.valueOf(j10), Integer.valueOf(i10)));
    }

    public static void checkState(boolean z10, String str, long j10, int i10) {
        if (!z10) {
            throw new IllegalStateException(Strings.lenientFormat(str, Long.valueOf(j10), Integer.valueOf(i10)));
        }
    }

    public static void checkArgument(boolean z10, String str, long j10, long j11) {
        if (!z10) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Long.valueOf(j10), Long.valueOf(j11)));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(@CheckForNull T t10, String str, long j10, long j11) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Long.valueOf(j10), Long.valueOf(j11)));
    }

    public static void checkState(boolean z10, String str, long j10, long j11) {
        if (!z10) {
            throw new IllegalStateException(Strings.lenientFormat(str, Long.valueOf(j10), Long.valueOf(j11)));
        }
    }

    public static void checkArgument(boolean z10, String str, long j10, @CheckForNull Object obj) {
        if (!z10) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Long.valueOf(j10), obj));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(@CheckForNull T t10, String str, long j10, @CheckForNull Object obj) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Long.valueOf(j10), obj));
    }

    public static void checkState(boolean z10, String str, long j10, @CheckForNull Object obj) {
        if (!z10) {
            throw new IllegalStateException(Strings.lenientFormat(str, Long.valueOf(j10), obj));
        }
    }

    public static void checkArgument(boolean z10, String str, @CheckForNull Object obj, char c10) {
        if (!z10) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj, Character.valueOf(c10)));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(@CheckForNull T t10, String str, @CheckForNull Object obj, char c10) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj, Character.valueOf(c10)));
    }

    public static void checkState(boolean z10, String str, @CheckForNull Object obj, char c10) {
        if (!z10) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj, Character.valueOf(c10)));
        }
    }

    public static void checkArgument(boolean z10, String str, @CheckForNull Object obj, int i10) {
        if (!z10) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj, Integer.valueOf(i10)));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(@CheckForNull T t10, String str, @CheckForNull Object obj, int i10) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj, Integer.valueOf(i10)));
    }

    public static void checkState(boolean z10, String str, @CheckForNull Object obj, int i10) {
        if (!z10) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj, Integer.valueOf(i10)));
        }
    }

    public static void checkArgument(boolean z10, String str, @CheckForNull Object obj, long j10) {
        if (!z10) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj, Long.valueOf(j10)));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(@CheckForNull T t10, String str, @CheckForNull Object obj, long j10) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj, Long.valueOf(j10)));
    }

    public static void checkState(boolean z10, String str, @CheckForNull Object obj, long j10) {
        if (!z10) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj, Long.valueOf(j10)));
        }
    }

    public static void checkArgument(boolean z10, String str, @CheckForNull Object obj, @CheckForNull Object obj2) {
        if (!z10) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj, obj2));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(@CheckForNull T t10, String str, @CheckForNull Object obj, @CheckForNull Object obj2) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj, obj2));
    }

    public static void checkState(boolean z10, String str, @CheckForNull Object obj, @CheckForNull Object obj2) {
        if (!z10) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj, obj2));
        }
    }

    public static void checkArgument(boolean z10, String str, @CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3) {
        if (!z10) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj, obj2, obj3));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(@CheckForNull T t10, String str, @CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj, obj2, obj3));
    }

    public static void checkState(boolean z10, String str, @CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3) {
        if (!z10) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj, obj2, obj3));
        }
    }

    public static void checkArgument(boolean z10, String str, @CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3, @CheckForNull Object obj4) {
        if (!z10) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj, obj2, obj3, obj4));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(@CheckForNull T t10, String str, @CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3, @CheckForNull Object obj4) {
        if (t10 != null) {
            return t10;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj, obj2, obj3, obj4));
    }

    public static void checkState(boolean z10, String str, @CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3, @CheckForNull Object obj4) {
        if (!z10) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj, obj2, obj3, obj4));
        }
    }
}
