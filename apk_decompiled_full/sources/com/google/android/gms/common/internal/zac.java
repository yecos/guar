package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.g;
import com.google.android.gms.base.R;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.Locale;
import javax.annotation.concurrent.GuardedBy;
import x.d;

/* loaded from: classes.dex */
public final class zac {

    @GuardedBy("sCache")
    private static final g zaa = new g();

    @GuardedBy("sCache")
    private static Locale zab;

    public static String zaa(Context context) {
        String packageName = context.getPackageName();
        try {
            return Wrappers.packageManager(context).getApplicationLabel(packageName).toString();
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            String str = context.getApplicationInfo().name;
            return TextUtils.isEmpty(str) ? packageName : str;
        }
    }

    public static String zab(Context context) {
        return context.getResources().getString(R.string.common_google_play_services_notification_channel_name);
    }

    public static String zac(Context context, int i10) {
        Resources resources = context.getResources();
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? resources.getString(android.R.string.ok) : resources.getString(R.string.common_google_play_services_enable_button) : resources.getString(R.string.common_google_play_services_update_button) : resources.getString(R.string.common_google_play_services_install_button);
    }

    public static String zad(Context context, int i10) {
        Resources resources = context.getResources();
        String zaa2 = zaa(context);
        if (i10 == 1) {
            return resources.getString(R.string.common_google_play_services_install_text, zaa2);
        }
        if (i10 == 2) {
            return DeviceProperties.isWearableWithoutPlayStore(context) ? resources.getString(R.string.common_google_play_services_wear_update_text) : resources.getString(R.string.common_google_play_services_update_text, zaa2);
        }
        if (i10 == 3) {
            return resources.getString(R.string.common_google_play_services_enable_text, zaa2);
        }
        if (i10 == 5) {
            return zah(context, "common_google_play_services_invalid_account_text", zaa2);
        }
        if (i10 == 7) {
            return zah(context, "common_google_play_services_network_error_text", zaa2);
        }
        if (i10 == 9) {
            return resources.getString(R.string.common_google_play_services_unsupported_text, zaa2);
        }
        if (i10 == 20) {
            return zah(context, "common_google_play_services_restricted_profile_text", zaa2);
        }
        switch (i10) {
            case 16:
                return zah(context, "common_google_play_services_api_unavailable_text", zaa2);
            case 17:
                return zah(context, "common_google_play_services_sign_in_failed_text", zaa2);
            case 18:
                return resources.getString(R.string.common_google_play_services_updating_text, zaa2);
            default:
                return resources.getString(com.google.android.gms.common.R.string.common_google_play_services_unknown_issue, zaa2);
        }
    }

    public static String zae(Context context, int i10) {
        return (i10 == 6 || i10 == 19) ? zah(context, "common_google_play_services_resolution_required_text", zaa(context)) : zad(context, i10);
    }

    public static String zaf(Context context, int i10) {
        String zai = i10 == 6 ? zai(context, "common_google_play_services_resolution_required_title") : zag(context, i10);
        return zai == null ? context.getResources().getString(R.string.common_google_play_services_notification_ticker) : zai;
    }

    public static String zag(Context context, int i10) {
        Resources resources = context.getResources();
        switch (i10) {
            case 1:
                return resources.getString(R.string.common_google_play_services_install_title);
            case 2:
                return resources.getString(R.string.common_google_play_services_update_title);
            case 3:
                return resources.getString(R.string.common_google_play_services_enable_title);
            case 4:
            case 6:
            case 18:
                return null;
            case 5:
                Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                return zai(context, "common_google_play_services_invalid_account_title");
            case 7:
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return zai(context, "common_google_play_services_network_error_title");
            case 8:
                Log.e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
                return null;
            case 9:
                Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
                return null;
            case 10:
                Log.e("GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information");
                return null;
            case 11:
                Log.e("GoogleApiAvailability", "The application is not licensed to the user.");
                return null;
            case 12:
            case 13:
            case 14:
            case 15:
            case 19:
            default:
                Log.e("GoogleApiAvailability", "Unexpected error code " + i10);
                return null;
            case 16:
                Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
                return null;
            case 17:
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                return zai(context, "common_google_play_services_sign_in_failed_title");
            case 20:
                Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
                return zai(context, "common_google_play_services_restricted_profile_title");
        }
    }

    private static String zah(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String zai = zai(context, str);
        if (zai == null) {
            zai = resources.getString(com.google.android.gms.common.R.string.common_google_play_services_unknown_issue);
        }
        return String.format(resources.getConfiguration().locale, zai, str2);
    }

    private static String zai(Context context, String str) {
        g gVar = zaa;
        synchronized (gVar) {
            Locale c10 = d.a(context.getResources().getConfiguration()).c(0);
            if (!c10.equals(zab)) {
                gVar.clear();
                zab = c10;
            }
            String str2 = (String) gVar.get(str);
            if (str2 != null) {
                return str2;
            }
            Resources remoteResource = GooglePlayServicesUtil.getRemoteResource(context);
            if (remoteResource == null) {
                return null;
            }
            int identifier = remoteResource.getIdentifier(str, "string", "com.google.android.gms");
            if (identifier == 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("Missing resource: ");
                sb.append(str);
                return null;
            }
            String string = remoteResource.getString(identifier);
            if (!TextUtils.isEmpty(string)) {
                gVar.put(str, string);
                return string;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Got empty resource: ");
            sb2.append(str);
            return null;
        }
    }
}
