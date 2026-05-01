package com.hpplay.sdk.source.common.store;

import android.content.Context;
import android.content.SharedPreferences;
import com.hpplay.sdk.source.common.utils.HapplayUtils;
import com.hpplay.sdk.source.log.SourceLog;

/* loaded from: classes3.dex */
public class ConnectCache {
    private static final String TAG = "SMCache";
    private static ConnectCache mPreference;
    private SharedPreferences mPref;

    private ConnectCache(Context context) {
        this.mPref = context.getSharedPreferences(context.getPackageName() + "_sm", 0);
    }

    public static synchronized ConnectCache getInstance() {
        ConnectCache connectCache;
        synchronized (ConnectCache.class) {
            if (mPreference == null) {
                initPreference(HapplayUtils.getApplication());
            }
            connectCache = mPreference;
        }
        return connectCache;
    }

    private static ConnectCache initPreference(Context context) {
        SourceLog.i(TAG, "Preference initPreference");
        if (mPreference == null) {
            mPreference = new ConnectCache(context);
        }
        return mPreference;
    }

    public String get(String str) {
        return this.mPref.getString(str, null);
    }

    public void save(String str, String str2) {
        this.mPref.edit().putString(str, str2).apply();
    }
}
