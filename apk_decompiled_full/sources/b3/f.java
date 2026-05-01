package b3;

import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Member;
import java.lang.reflect.Modifier;

@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface f {

    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f4489a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f4490b;

        static {
            int[] iArr = new int[q0.values().length];
            f4490b = iArr;
            try {
                iArr[q0.CREATOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4490b[q0.FIELD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4490b[q0.GETTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4490b[q0.IS_GETTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4490b[q0.NONE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4490b[q0.SETTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f4490b[q0.ALL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr2 = new int[c.values().length];
            f4489a = iArr2;
            try {
                iArr2[c.ANY.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f4489a[c.NONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f4489a[c.NON_PRIVATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f4489a[c.PROTECTED_AND_PUBLIC.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f4489a[c.PUBLIC_ONLY.ordinal()] = 5;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public static class b implements Serializable {
    }

    public enum c {
        ANY,
        NON_PRIVATE,
        PROTECTED_AND_PUBLIC,
        PUBLIC_ONLY,
        NONE,
        DEFAULT;

        public boolean a(Member member) {
            int i10 = a.f4489a[ordinal()];
            if (i10 == 1) {
                return true;
            }
            if (i10 == 3) {
                return !Modifier.isPrivate(member.getModifiers());
            }
            if (i10 != 4) {
                if (i10 != 5) {
                    return false;
                }
            } else if (Modifier.isProtected(member.getModifiers())) {
                return true;
            }
            return Modifier.isPublic(member.getModifiers());
        }
    }

    c creatorVisibility() default c.DEFAULT;

    c fieldVisibility() default c.DEFAULT;

    c getterVisibility() default c.DEFAULT;

    c isGetterVisibility() default c.DEFAULT;

    c setterVisibility() default c.DEFAULT;
}
