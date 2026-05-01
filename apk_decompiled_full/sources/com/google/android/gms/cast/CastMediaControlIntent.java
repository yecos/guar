package com.google.android.gms.cast;

import android.text.TextUtils;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.cast.internal.CastUtils;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.util.Collection;
import java.util.Locale;

/* loaded from: classes.dex */
public final class CastMediaControlIntent {

    @RecentlyNonNull
    public static final String ACTION_SYNC_STATUS = "com.google.android.gms.cast.ACTION_SYNC_STATUS";

    @RecentlyNonNull
    public static final String DEFAULT_MEDIA_RECEIVER_APPLICATION_ID = "CC1AD845";
    public static final int ERROR_CODE_REQUEST_FAILED = 1;
    public static final int ERROR_CODE_SESSION_START_FAILED = 2;
    public static final int ERROR_CODE_TEMPORARILY_DISCONNECTED = 3;

    @RecentlyNonNull
    public static final String EXTRA_CAST_APPLICATION_ID = "com.google.android.gms.cast.EXTRA_CAST_APPLICATION_ID";

    @RecentlyNonNull
    public static final String EXTRA_CAST_LANGUAGE_CODE = "com.google.android.gms.cast.EXTRA_CAST_LANGUAGE_CODE";

    @RecentlyNonNull
    public static final String EXTRA_CAST_RELAUNCH_APPLICATION = "com.google.android.gms.cast.EXTRA_CAST_RELAUNCH_APPLICATION";

    @RecentlyNonNull
    public static final String EXTRA_CAST_STOP_APPLICATION_WHEN_SESSION_ENDS = "com.google.android.gms.cast.EXTRA_CAST_STOP_APPLICATION_WHEN_SESSION_ENDS";

    @RecentlyNonNull
    public static final String EXTRA_CUSTOM_DATA = "com.google.android.gms.cast.EXTRA_CUSTOM_DATA";

    @RecentlyNonNull
    public static final String EXTRA_DEBUG_LOGGING_ENABLED = "com.google.android.gms.cast.EXTRA_DEBUG_LOGGING_ENABLED";

    @RecentlyNonNull
    public static final String EXTRA_ERROR_CODE = "com.google.android.gms.cast.EXTRA_ERROR_CODE";

    private CastMediaControlIntent() {
    }

    @RecentlyNonNull
    public static String categoryForCast(@RecentlyNonNull String str) {
        if (str != null) {
            return zza("com.google.android.gms.cast.CATEGORY_CAST", str, null, false, true);
        }
        throw new IllegalArgumentException("applicationId cannot be null");
    }

    @RecentlyNonNull
    public static String categoryForRemotePlayback() {
        return zza("com.google.android.gms.cast.CATEGORY_CAST_REMOTE_PLAYBACK", null, null, false, true);
    }

    @RecentlyNonNull
    public static String languageTagForLocale(@RecentlyNonNull Locale locale) {
        return CastUtils.zzd(locale);
    }

    private static String zza(String str, String str2, Collection<String> collection, boolean z10, boolean z11) {
        StringBuilder sb = new StringBuilder(str);
        if (str2 != null) {
            String upperCase = str2.toUpperCase();
            if (!upperCase.matches("[A-F0-9]+")) {
                throw new IllegalArgumentException(str2.length() != 0 ? "Invalid application ID: ".concat(str2) : new String("Invalid application ID: "));
            }
            sb.append(Operator.Operation.DIVISION);
            sb.append(upperCase);
        }
        if (collection != null) {
            if (collection.isEmpty()) {
                throw new IllegalArgumentException("Must specify at least one namespace");
            }
            if (str2 == null) {
                sb.append(Operator.Operation.DIVISION);
            }
            sb.append(Operator.Operation.DIVISION);
            boolean z12 = true;
            for (String str3 : collection) {
                CastUtils.throwIfInvalidNamespace(str3);
                if (!z12) {
                    sb.append(",");
                }
                sb.append(CastUtils.zze(str3));
                z12 = false;
            }
        }
        if (str2 == null && collection == null) {
            sb.append(Operator.Operation.DIVISION);
        }
        if (collection == null) {
            sb.append(Operator.Operation.DIVISION);
        }
        sb.append("//ALLOW_IPV6");
        return sb.toString();
    }

    @RecentlyNonNull
    public static String categoryForRemotePlayback(@RecentlyNonNull String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("applicationId cannot be null or empty");
        }
        return zza("com.google.android.gms.cast.CATEGORY_CAST_REMOTE_PLAYBACK", str, null, false, true);
    }

    @RecentlyNonNull
    public static String categoryForCast(@RecentlyNonNull String str, @RecentlyNonNull Collection<String> collection) {
        if (str == null) {
            throw new IllegalArgumentException("applicationId cannot be null");
        }
        if (collection != null) {
            return zza("com.google.android.gms.cast.CATEGORY_CAST", str, collection, false, true);
        }
        throw new IllegalArgumentException("namespaces cannot be null");
    }

    @RecentlyNonNull
    public static String categoryForCast(@RecentlyNonNull Collection<String> collection) {
        if (collection != null) {
            return zza("com.google.android.gms.cast.CATEGORY_CAST", null, collection, false, true);
        }
        throw new IllegalArgumentException("namespaces cannot be null");
    }
}
