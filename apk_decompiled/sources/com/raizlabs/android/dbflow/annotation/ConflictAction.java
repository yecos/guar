package com.raizlabs.android.dbflow.annotation;

/* loaded from: classes.dex */
public enum ConflictAction {
    NONE,
    ROLLBACK,
    ABORT,
    FAIL,
    IGNORE,
    REPLACE;

    /* renamed from: com.raizlabs.android.dbflow.annotation.ConflictAction$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$raizlabs$android$dbflow$annotation$ConflictAction;

        static {
            int[] iArr = new int[ConflictAction.values().length];
            $SwitchMap$com$raizlabs$android$dbflow$annotation$ConflictAction = iArr;
            try {
                iArr[ConflictAction.ROLLBACK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$raizlabs$android$dbflow$annotation$ConflictAction[ConflictAction.ABORT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$raizlabs$android$dbflow$annotation$ConflictAction[ConflictAction.FAIL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$raizlabs$android$dbflow$annotation$ConflictAction[ConflictAction.IGNORE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$raizlabs$android$dbflow$annotation$ConflictAction[ConflictAction.REPLACE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static int getSQLiteDatabaseAlgorithmInt(ConflictAction conflictAction) {
        int i10 = AnonymousClass1.$SwitchMap$com$raizlabs$android$dbflow$annotation$ConflictAction[conflictAction.ordinal()];
        int i11 = 1;
        if (i10 != 1) {
            i11 = 2;
            if (i10 != 2) {
                i11 = 3;
                if (i10 != 3) {
                    i11 = 4;
                    if (i10 != 4) {
                        i11 = 5;
                        if (i10 != 5) {
                            return 0;
                        }
                    }
                }
            }
        }
        return i11;
    }
}
