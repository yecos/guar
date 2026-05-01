package com.hpplay.sdk.source.api;

/* loaded from: classes3.dex */
public enum BleState {
    BLE_ADVERTISE_SUPPORTED(0),
    BLE_ADVERTISE_NO_SUPPORT_ANDROID_SDK_LOWER(1),
    BLE_ADVERTISE_NO_SUPPORT_BT_DEVICE(2),
    BLE_ADVERTISE_NO_SUPPORT_BLE_DEVICE(3),
    BLE_ADVERTISE_PERMISSION_DENIED(4),
    BLE_ADVERTISE_BT_TURNED_OFF(5),
    BLE_ADVERTISE_NOT_SET_ENABLE(6),
    BLE_ADVERTISE_PUBLISH_SUCCESS(10),
    BLE_ADVERTISE_FAILED_DATA_TOO_LARGE(11),
    BLE_ADVERTISE_FAILED_TOO_MANY_ADVERTISERS(12),
    BLE_ADVERTISE_FAILED_ALREADY_STARTED(13),
    BLE_ADVERTISE_FAILED_INTERNAL_ERROR(14),
    BLE_ADVERTISE_FAILED_FEATURE_UNSUPPORTED(15),
    BLE_ADVERTISE_UNKNOWN_ERROR(99);

    private int value;

    /* renamed from: com.hpplay.sdk.source.api.BleState$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$hpplay$sdk$source$api$BleState;

        static {
            int[] iArr = new int[BleState.values().length];
            $SwitchMap$com$hpplay$sdk$source$api$BleState = iArr;
            try {
                iArr[BleState.BLE_ADVERTISE_SUPPORTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$hpplay$sdk$source$api$BleState[BleState.BLE_ADVERTISE_NO_SUPPORT_ANDROID_SDK_LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$hpplay$sdk$source$api$BleState[BleState.BLE_ADVERTISE_NO_SUPPORT_BT_DEVICE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$hpplay$sdk$source$api$BleState[BleState.BLE_ADVERTISE_NO_SUPPORT_BLE_DEVICE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$hpplay$sdk$source$api$BleState[BleState.BLE_ADVERTISE_PERMISSION_DENIED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$hpplay$sdk$source$api$BleState[BleState.BLE_ADVERTISE_BT_TURNED_OFF.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$hpplay$sdk$source$api$BleState[BleState.BLE_ADVERTISE_UNKNOWN_ERROR.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$hpplay$sdk$source$api$BleState[BleState.BLE_ADVERTISE_PUBLISH_SUCCESS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$hpplay$sdk$source$api$BleState[BleState.BLE_ADVERTISE_FAILED_DATA_TOO_LARGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$hpplay$sdk$source$api$BleState[BleState.BLE_ADVERTISE_FAILED_TOO_MANY_ADVERTISERS.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$hpplay$sdk$source$api$BleState[BleState.BLE_ADVERTISE_FAILED_ALREADY_STARTED.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$hpplay$sdk$source$api$BleState[BleState.BLE_ADVERTISE_FAILED_INTERNAL_ERROR.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$hpplay$sdk$source$api$BleState[BleState.BLE_ADVERTISE_FAILED_FEATURE_UNSUPPORTED.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$hpplay$sdk$source$api$BleState[BleState.BLE_ADVERTISE_NOT_SET_ENABLE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    BleState(int i10) {
        this.value = i10;
    }

    public static BleState getByValue(int i10) {
        for (BleState bleState : values()) {
            if (bleState.value() == i10) {
                return bleState;
            }
        }
        return null;
    }

    @Override // java.lang.Enum
    public String toString() {
        switch (AnonymousClass1.$SwitchMap$com$hpplay$sdk$source$api$BleState[ordinal()]) {
            case 1:
                return "BLE_ADVERTISE_SUPPORTED";
            case 2:
                return "BLE_ADVERTISE_NO_SUPPORT_ANDROID_SDK_LOWER";
            case 3:
                return "BLE_ADVERTISE_NO_SUPPORT_BT_DEVICE";
            case 4:
                return "BLE_ADVERTISE_NO_SUPPORT_BLE_DEVICE";
            case 5:
                return "BLE_ADVERTISE_PERMISSION_DENIED";
            case 6:
                return "BLE_ADVERTISE_BT_TURNED_OFF";
            case 7:
                return "BLE_ADVERTISE_UNKNOWN_ERROR";
            case 8:
                return "BLE_ADVERTISE_PUBLISH_SUCCESS";
            case 9:
                return "BLE_ADVERTISE_FAILED_DATA_TOO_LARGE";
            case 10:
                return "BLE_ADVERTISE_FAILED_TOO_MANY_ADVERTISERS";
            case 11:
                return "BLE_ADVERTISE_FAILED_ALREADY_STARTED";
            case 12:
                return "BLE_ADVERTISE_FAILED_INTERNAL_ERROR";
            case 13:
                return "BLE_ADVERTISE_FAILED_FEATURE_UNSUPPORTED";
            case 14:
                return "BLE_ADVERTISE_NOT_SET_ENABLE";
            default:
                return "";
        }
    }

    public int value() {
        return this.value;
    }
}
