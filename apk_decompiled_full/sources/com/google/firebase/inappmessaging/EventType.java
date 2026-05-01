package com.google.firebase.inappmessaging;

import com.google.protobuf.Internal;

/* loaded from: classes2.dex */
public enum EventType implements Internal.EnumLite {
    UNKNOWN_EVENT_TYPE(0),
    IMPRESSION_EVENT_TYPE(1),
    CLICK_EVENT_TYPE(2);

    public static final int CLICK_EVENT_TYPE_VALUE = 2;
    public static final int IMPRESSION_EVENT_TYPE_VALUE = 1;
    public static final int UNKNOWN_EVENT_TYPE_VALUE = 0;
    private static final Internal.EnumLiteMap<EventType> internalValueMap = new Internal.EnumLiteMap<EventType>() { // from class: com.google.firebase.inappmessaging.EventType.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.protobuf.Internal.EnumLiteMap
        public EventType findValueByNumber(int i10) {
            return EventType.forNumber(i10);
        }
    };
    private final int value;

    public static final class EventTypeVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new EventTypeVerifier();

        private EventTypeVerifier() {
        }

        @Override // com.google.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i10) {
            return EventType.forNumber(i10) != null;
        }
    }

    EventType(int i10) {
        this.value = i10;
    }

    public static EventType forNumber(int i10) {
        if (i10 == 0) {
            return UNKNOWN_EVENT_TYPE;
        }
        if (i10 == 1) {
            return IMPRESSION_EVENT_TYPE;
        }
        if (i10 != 2) {
            return null;
        }
        return CLICK_EVENT_TYPE;
    }

    public static Internal.EnumLiteMap<EventType> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return EventTypeVerifier.INSTANCE;
    }

    @Override // com.google.protobuf.Internal.EnumLite
    public final int getNumber() {
        return this.value;
    }

    @Deprecated
    public static EventType valueOf(int i10) {
        return forNumber(i10);
    }
}
