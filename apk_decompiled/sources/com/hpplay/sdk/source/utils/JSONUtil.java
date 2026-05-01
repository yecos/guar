package com.hpplay.sdk.source.utils;

import android.text.TextUtils;
import com.hpplay.sdk.source.bean.SortJSONObject;
import com.hpplay.sdk.source.log.SourceLog;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class JSONUtil {
    private static final int JSON_INDENT = 4;
    private static final String TAG = "JSONUtil";

    public static JSONObject commonBean2Json(Object obj) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Field field : obj.getClass().getFields()) {
                field.setAccessible(true);
                boolean isStatic = Modifier.isStatic(field.getModifiers());
                boolean isPrivate = Modifier.isPrivate(field.getModifiers());
                if (!isStatic && !isPrivate && !field.isEnumConstant() && !field.isSynthetic()) {
                    String obj2 = field.getGenericType().toString();
                    if (!"int".equals(obj2) && !"long".equals(obj2) && !"double".equals(obj2) && !"boolean".equals(obj2) && !"class java.lang.String".equals(obj2) && !"class java.lang.Object".equals(obj2)) {
                        SourceLog.w(TAG, "can not recognized2 " + field.getName() + " in " + obj);
                    }
                    jSONObject.put(field.getName(), field.get(obj));
                }
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
        return jSONObject;
    }

    public static String formatJSON(String str) {
        String trim;
        if (TextUtils.isEmpty(str)) {
            return "Empty/Null json content";
        }
        try {
            trim = str.trim();
        } catch (JSONException unused) {
        }
        if (trim.startsWith("{")) {
            return new JSONObject(trim).toString(4);
        }
        if (trim.startsWith("[")) {
            return new JSONArray(trim).toString(4);
        }
        return "Invalid json content";
    }

    private static JSONObject getLeboSortJson(JSONObject jSONObject) {
        Iterator<String> keys = jSONObject.keys();
        TreeMap treeMap = new TreeMap();
        while (keys.hasNext()) {
            String next = keys.next();
            treeMap.put(next, jSONObject.optString(next));
        }
        try {
            SortJSONObject sortJSONObject = new SortJSONObject();
            for (String str : treeMap.keySet()) {
                sortJSONObject.put(str, treeMap.get(str));
            }
            return sortJSONObject;
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            return null;
        }
    }

    private static JSONObject getSortJson(JSONObject jSONObject) {
        Iterator<String> keys = jSONObject.keys();
        TreeMap treeMap = new TreeMap();
        while (keys.hasNext()) {
            String next = keys.next();
            treeMap.put(next, jSONObject.optString(next));
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            for (String str : treeMap.keySet()) {
                jSONObject2.put(str, treeMap.get(str));
            }
            return jSONObject2;
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            return null;
        }
    }

    public static JSONArray getSortJsonArray(JSONArray jSONArray, boolean z10) {
        JSONArray jSONArray2 = new JSONArray();
        if (jSONArray == null) {
            return jSONArray2;
        }
        int length = jSONArray.length();
        for (int i10 = 0; i10 < length; i10++) {
            Object opt = jSONArray.opt(i10);
            if (opt instanceof JSONObject) {
                if (z10) {
                    jSONArray2.put(getLeboSortJson((JSONObject) opt));
                } else {
                    jSONArray2.put(getSortJson((JSONObject) opt));
                }
            }
        }
        return jSONArray2;
    }
}
