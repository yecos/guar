package com.hpplay.sdk.source.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

/* loaded from: classes3.dex */
public class SortJSONObject extends JSONObject {
    private LinkedHashMap<Object, Object> mHashMap = new LinkedHashMap<>();

    public static void testValidity(Object obj) {
        if (obj != null) {
            if (obj instanceof Double) {
                Double d10 = (Double) obj;
                if (d10.isInfinite() || d10.isNaN()) {
                    throw new JSONException("JSON does not allow non-finite numbers.");
                }
                return;
            }
            if (obj instanceof Float) {
                Float f10 = (Float) obj;
                if (f10.isInfinite() || f10.isNaN()) {
                    throw new JSONException("JSON does not allow non-finite numbers.");
                }
            }
        }
    }

    public static String valueToString(Object obj) {
        if (obj == null) {
            return "null";
        }
        if (!(obj instanceof JSONStringer)) {
            return obj instanceof Number ? JSONObject.numberToString((Number) obj) : ((obj instanceof Boolean) || (obj instanceof JSONObject) || (obj instanceof JSONArray)) ? obj.toString() : obj instanceof Map ? new JSONObject((Map) obj).toString() : obj instanceof Collection ? new JSONArray((Collection) obj).toString() : JSONObject.quote(obj.toString());
        }
        try {
            String jSONStringer = ((JSONStringer) obj).toString();
            if (jSONStringer instanceof String) {
                return jSONStringer;
            }
            throw new JSONException("Bad value from toJSONString: " + ((Object) jSONStringer));
        } catch (Exception e10) {
            throw new JSONException(e10.getMessage());
        }
    }

    @Override // org.json.JSONObject
    public JSONObject put(String str, boolean z10) {
        return put(str, z10);
    }

    @Override // org.json.JSONObject
    public Object remove(String str) {
        return this.mHashMap.remove(str);
    }

    @Override // org.json.JSONObject
    public String toString() {
        try {
            StringBuffer stringBuffer = new StringBuffer("{");
            for (Object obj : this.mHashMap.keySet()) {
                if (stringBuffer.length() > 1) {
                    stringBuffer.append(ASCIIPropertyListParser.ARRAY_ITEM_DELIMITER_TOKEN);
                }
                stringBuffer.append(JSONObject.quote(obj.toString()));
                stringBuffer.append(ASCIIPropertyListParser.DATE_TIME_FIELD_DELIMITER);
                stringBuffer.append(valueToString(this.mHashMap.get(obj)));
            }
            stringBuffer.append(ASCIIPropertyListParser.DICTIONARY_END_TOKEN);
            return stringBuffer.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // org.json.JSONObject
    public JSONObject put(String str, double d10) {
        return put(str, d10);
    }

    @Override // org.json.JSONObject
    public JSONObject put(String str, int i10) {
        return put(str, i10);
    }

    @Override // org.json.JSONObject
    public JSONObject put(String str, long j10) {
        return put(str, j10);
    }

    @Override // org.json.JSONObject
    public JSONObject put(String str, Object obj) {
        if (str == null) {
            throw new JSONException("Null key.");
        }
        if (obj != null) {
            testValidity(obj);
            this.mHashMap.put(str, obj);
        } else {
            remove(str);
        }
        return this;
    }
}
