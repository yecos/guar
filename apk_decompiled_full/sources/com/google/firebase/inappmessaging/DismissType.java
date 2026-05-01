package com.google.firebase.inappmessaging;

import com.google.protobuf.Internal;

/* loaded from: classes2.dex */
public enum DismissType implements Internal.EnumLite {
    UNKNOWN_DISMISS_TYPE(0),
    AUTO(1),
    CLICK(2),
    SWIPE(3);

    public static final int AUTO_VALUE = 1;
    public static final int CLICK_VALUE = 2;
    public static final int SWIPE_VALUE = 3;
    public static final int UNKNOWN_DISMISS_TYPE_VALUE = 0;
    private static final Internal.EnumLiteMap<DismissType> internalValueMap = new Internal.EnumLiteMap<DismissType>() { // from class: com.google.firebase.inappmessaging.DismissType.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public DismissType findValueByNumber(int i10) {
            return DismissType.forNumber(i10);
        }
    };
    private final int value;

    public static final class DismissTypeVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new DismissTypeVerifier();

        private DismissTypeVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i10) {
            return DismissType.forNumber(i10) != null;
        }
    }

    DismissType(int i10) {
        this.value = i10;
    }

    public static DismissType forNumber(int i10) {
        if (i10 == 0) {
            return UNKNOWN_DISMISS_TYPE;
        }
        if (i10 == 1) {
            return AUTO;
        }
        if (i10 == 2) {
            return CLICK;
        }
        if (i10 != 3) {
            return null;
        }
        return SWIPE;
    }

    public static Internal.EnumLiteMap<DismissType> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return DismissTypeVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static DismissType valueOf(int i10) {
        return forNumber(i10);
    }
}
