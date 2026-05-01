package com.efs.sdk.base.newsharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class SharedPreferencesUtils {
    private static final HashMap<String, SharedPreferencesWrapper> sSpCache = new HashMap<>();

    public static class SharedPreferencesWrapper {
        private volatile SharedPreferences mSharedPreferences;

        private SharedPreferencesWrapper() {
        }
    }

    private static SharedPreferences getNewSharedPreferences(Context context, String str, boolean z10) {
        return getNewSharedPreferences(context, str, z10, false);
    }

    public static File getNewSharedPrefsFile(Context context, String str) {
        return new File(context.getApplicationInfo().dataDir, "shared_prefs" + File.separatorChar + str + ".sp");
    }

    public static SharedPreferences getSharedPreferences(Context context, String str) {
        return getSharedPreferences(context, str, false);
    }

    private static synchronized void handleReplace(Context context, String str, boolean z10) {
        synchronized (SharedPreferencesUtils.class) {
            if (context == null) {
                return;
            }
            SharedPreferences newSharedPreferences = getNewSharedPreferences(context, "sp_replace_flag", z10, true);
            if (!newSharedPreferences.contains(str)) {
                SharedPreferences newSharedPreferences2 = getNewSharedPreferences(context, str, z10, true);
                SharedPreferences.Editor edit = newSharedPreferences2.edit();
                if (((SharedPreferencesNewImpl) newSharedPreferences2).getModifyID() <= 1) {
                    Map<String, ?> all = context.getSharedPreferences(str, 0).getAll();
                    Log.e("caisq", "replace " + str + "   " + all.size() + "   " + newSharedPreferences2.hashCode());
                    if (all.size() > 0) {
                        for (Map.Entry<String, ?> entry : all.entrySet()) {
                            String key = entry.getKey();
                            Object value = entry.getValue();
                            if (key != null && key.trim().length() > 0 && value != null) {
                                if (value instanceof String) {
                                    edit.putString(key, (String) value);
                                } else if (value instanceof Long) {
                                    edit.putLong(key, ((Long) value).longValue());
                                } else if (value instanceof Integer) {
                                    edit.putInt(key, ((Integer) value).intValue());
                                } else if (value instanceof Float) {
                                    edit.putFloat(key, ((Float) value).floatValue());
                                } else if (value instanceof Boolean) {
                                    edit.putBoolean(key, ((Boolean) value).booleanValue());
                                }
                            }
                        }
                        edit.apply();
                    }
                }
                newSharedPreferences.edit().putBoolean(str, true).apply();
            }
        }
    }

    private static Object invokeObjectMethod(Object obj, String str, Class[] clsArr, Object[] objArr) {
        try {
            Method method = obj.getClass().getMethod(str, clsArr);
            method.setAccessible(true);
            return method.invoke(obj, objArr);
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static void onDestroy() {
        HashMap<String, SharedPreferencesWrapper> hashMap = sSpCache;
        synchronized (hashMap) {
            if (hashMap.size() > 0) {
                Iterator<SharedPreferencesWrapper> it = hashMap.values().iterator();
                while (it.hasNext()) {
                    SharedPreferences sharedPreferences = it.next().mSharedPreferences;
                    if (sharedPreferences != null) {
                        ((SharedPreferencesNewImpl) sharedPreferences).onDestroy();
                    }
                }
            }
        }
    }

    private static SharedPreferences getNewSharedPreferences(Context context, String str, boolean z10, boolean z11) {
        SharedPreferencesWrapper sharedPreferencesWrapper;
        HashMap<String, SharedPreferencesWrapper> hashMap = sSpCache;
        synchronized (hashMap) {
            sharedPreferencesWrapper = hashMap.get(str);
            if (sharedPreferencesWrapper == null) {
                sharedPreferencesWrapper = new SharedPreferencesWrapper();
                hashMap.put(str, sharedPreferencesWrapper);
            }
        }
        if (sharedPreferencesWrapper.mSharedPreferences == null) {
            synchronized (sharedPreferencesWrapper) {
                if (sharedPreferencesWrapper.mSharedPreferences == null && sharedPreferencesWrapper.mSharedPreferences == null) {
                    sharedPreferencesWrapper.mSharedPreferences = new SharedPreferencesNewImpl(getNewSharedPrefsFile(context, str), z10);
                }
            }
        }
        return sharedPreferencesWrapper.mSharedPreferences;
    }

    public static SharedPreferences getSharedPreferences(Context context, String str, boolean z10) {
        return getNewSharedPreferences(context, str, z10);
    }
}
