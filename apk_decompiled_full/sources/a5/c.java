package a5;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public abstract class c {
    public static b a(File file) {
        Map b10 = b(file);
        if (b10 == null) {
            return null;
        }
        String str = (String) b10.get("channel");
        b10.remove("channel");
        return new b(str, b10);
    }

    public static Map b(File file) {
        try {
            String c10 = c(file);
            if (c10 == null) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(c10);
            Iterator<String> keys = jSONObject.keys();
            HashMap hashMap = new HashMap();
            while (keys.hasNext()) {
                String obj = keys.next().toString();
                hashMap.put(obj, jSONObject.getString(obj));
            }
            return hashMap;
        } catch (JSONException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static String c(File file) {
        return e.d(file, 1903654775);
    }
}
