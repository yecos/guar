package p7;

import android.text.TextUtils;
import com.umeng.umcrash.UMCrash;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.Map;
import o7.c;
import o7.f;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class a implements c {

    /* renamed from: a, reason: collision with root package name */
    public static final String f18070a = "a";

    /* renamed from: b, reason: collision with root package name */
    public static String f18071b;

    public a(String str) {
        f18071b = str;
    }

    @Override // o7.c
    public boolean a(s7.c cVar) {
        String b10 = b(cVar);
        if (TextUtils.isEmpty(b10)) {
            return false;
        }
        File file = new File(f18071b + File.separator + "dns.cache");
        if (!file.exists()) {
            file.getParentFile().mkdirs();
        }
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(b10);
        fileWriter.flush();
        fileWriter.close();
        return false;
    }

    public final String b(s7.c cVar) {
        JSONArray jSONArray = new JSONArray();
        try {
            Iterator it = cVar.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                Object obj = (String) entry.getKey();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("domain", obj);
                JSONArray jSONArray2 = new JSONArray();
                f[] fVarArr = (f[]) entry.getValue();
                if (fVarArr != null && fVarArr.length != 0) {
                    for (f fVar : fVarArr) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("data", fVar.f17620a);
                        jSONObject2.put("type", fVar.f17621b);
                        jSONObject2.put("ttl", fVar.f17622c);
                        jSONObject2.put(UMCrash.SP_KEY_TIMESTAMP, fVar.f17623d);
                        jSONObject2.put("source", fVar.f17624e.ordinal());
                        jSONArray2.put(jSONObject2);
                    }
                }
                jSONObject.put("records", jSONArray2);
                jSONArray.put(jSONObject);
            }
            return jSONArray.toString();
        } catch (JSONException e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public final s7.c c(String str) {
        s7.b.b(f18070a, "local dns cache is " + str);
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            if (length == 0) {
                return null;
            }
            s7.c cVar = new s7.c();
            for (int i10 = 0; i10 < length; i10++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i10);
                String optString = optJSONObject.optString("domain");
                JSONArray optJSONArray = optJSONObject.optJSONArray("records");
                int length2 = optJSONArray.length();
                f[] fVarArr = new f[length2];
                for (int i11 = 0; i11 < length2; i11++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i11);
                    fVarArr[i11] = new f(optJSONObject2.optString("data"), optJSONObject2.optInt("type"), optJSONObject2.optInt("ttl"), optJSONObject2.optLong(UMCrash.SP_KEY_TIMESTAMP), f.a.Unknown);
                }
                cVar.put(optString, fVarArr);
            }
            return cVar;
        } catch (JSONException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    @Override // o7.c
    public s7.c load() {
        File file = new File(f18071b + File.separator + "dns.cache");
        if (!file.exists()) {
            return null;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[4096];
        StringBuilder sb = new StringBuilder();
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read == -1) {
                break;
            }
            sb.append(new String(bArr, 0, read));
        }
        String sb2 = sb.toString();
        if (TextUtils.isEmpty(sb2)) {
            return null;
        }
        return c(sb2);
    }
}
