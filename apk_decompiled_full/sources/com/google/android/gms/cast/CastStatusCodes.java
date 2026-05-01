package com.google.android.gms.cast;

import androidx.annotation.RecentlyNonNull;
import anet.channel.util.HttpConstant;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.hpplay.cybergarage.http.HTTP;
import java.util.Locale;

/* loaded from: classes.dex */
public final class CastStatusCodes extends CommonStatusCodes {
    public static final int APPLICATION_NOT_FOUND = 2004;
    public static final int APPLICATION_NOT_RUNNING = 2005;
    public static final int AUTHENTICATION_FAILED = 2000;
    public static final int CANCELED = 2002;
    public static final int DEVICE_CONNECTION_SUSPENDED = 2016;

    @ShowFirstParty
    @KeepForSdk
    public static final int ERROR_CAST_PLATFORM_INCOMPATIBLE = 2110;

    @ShowFirstParty
    @KeepForSdk
    public static final int ERROR_CAST_PLATFORM_NOT_CONNECTED = 2113;

    @ShowFirstParty
    @KeepForSdk
    public static final int ERROR_DEVICE_ID_FLAGS_NOT_SET = 2115;

    @ShowFirstParty
    @KeepForSdk
    public static final int ERROR_HOST_NOT_ALLOWED = 2112;

    @ShowFirstParty
    @KeepForSdk
    public static final int ERROR_NO_CAST_CONFIGURATION = 2114;
    public static final int ERROR_SERVICE_CREATION_FAILED = 2200;
    public static final int ERROR_SERVICE_DISCONNECTED = 2201;
    public static final int ERROR_STOPPING_SERVICE_FAILED = 2202;

    @ShowFirstParty
    @KeepForSdk
    public static final int ERROR_URL_INSEURE = 2111;
    public static final int FAILED = 2100;
    public static final int INTERNAL_ERROR = 8;
    public static final int INTERRUPTED = 14;
    public static final int INVALID_REQUEST = 2001;
    public static final int MEDIA_ERROR = 2104;
    public static final int MESSAGE_SEND_BUFFER_TOO_FULL = 2007;
    public static final int MESSAGE_TOO_LARGE = 2006;
    public static final int NETWORK_ERROR = 7;
    public static final int NOT_ALLOWED = 2003;
    public static final int REPLACED = 2103;
    public static final int SUCCESS = 0;
    public static final int TIMEOUT = 15;
    public static final int UNKNOWN_ERROR = 13;

    private CastStatusCodes() {
    }

    @RecentlyNonNull
    public static String getStatusCodeString(int i10) {
        if (i10 >= -999 && i10 <= 999) {
            return i10 != 0 ? i10 != 7 ? i10 != 14 ? i10 != 15 ? CommonStatusCodes.getStatusCodeString(i10) : HTTP.TIMEOUT : "INTERRUPTED" : "NETWORK_ERROR" : HttpConstant.SUCCESS;
        }
        if (i10 < 2000 || i10 > 2099) {
            return (i10 < 2100 || i10 > 2109) ? (i10 < 2105 || i10 > 2169) ? (i10 < 2200 || i10 > 2219) ? (i10 < 2250 || i10 > 2289) ? (i10 < 2300 || i10 > 2309) ? (i10 < 2310 || i10 > 2319) ? (i10 < 2350 || i10 > 2359) ? (i10 < 2400 || i10 > 2419) ? (i10 < 2450 || i10 > 2469) ? (i10 < 2470 || i10 > 2479) ? (i10 < 2490 || i10 > 2499) ? String.format(Locale.ROOT, "Unknown cast status code %d", Integer.valueOf(i10)) : String.format(Locale.ROOT, "%s %d", "Cast media loading status code", Integer.valueOf(i10)) : String.format(Locale.ROOT, "%s %d", "Cast application status code", Integer.valueOf(i10)) : String.format(Locale.ROOT, "%s %d", "Cast nearby casting status code", Integer.valueOf(i10)) : String.format(Locale.ROOT, "%s %d", "Cast relay casting status code", Integer.valueOf(i10)) : String.format(Locale.ROOT, "%s %d", "Cast multizone device status code", Integer.valueOf(i10)) : String.format(Locale.ROOT, "%s %d", "Endpoint switch status code", Integer.valueOf(i10)) : String.format(Locale.ROOT, "%s %d", "Cast service status code", Integer.valueOf(i10)) : String.format(Locale.ROOT, "%s %d", "Cast socket status code", Integer.valueOf(i10)) : String.format(Locale.ROOT, "%s %d", "Cast remote display status code", Integer.valueOf(i10)) : String.format(Locale.ROOT, "%s %d", "Cast session status code", Integer.valueOf(i10)) : String.format(Locale.ROOT, "%s %d", "Media control channel status code", Integer.valueOf(i10));
        }
        if (i10 == 2015) {
            return "TCP_PROBER_FAIL_TO_VERIFY_DEVICE";
        }
        switch (i10) {
            case 2000:
                return "AUTHENTICATION_FAILED";
            case INVALID_REQUEST /* 2001 */:
                return "INVALID_REQUEST";
            case CANCELED /* 2002 */:
                return "CANCELED";
            case NOT_ALLOWED /* 2003 */:
                return "NOT_ALLOWED";
            case APPLICATION_NOT_FOUND /* 2004 */:
                return "APPLICATION_NOT_FOUND";
            case APPLICATION_NOT_RUNNING /* 2005 */:
                return "APPLICATION_NOT_RUNNING";
            case MESSAGE_TOO_LARGE /* 2006 */:
                return "MESSAGE_TOO_LARGE";
            case MESSAGE_SEND_BUFFER_TOO_FULL /* 2007 */:
                return "MESSAGE_SEND_BUFFER_TOO_FULL";
            default:
                return String.format(Locale.ROOT, "%s %d", "Common cast status code", Integer.valueOf(i10));
        }
    }
}
