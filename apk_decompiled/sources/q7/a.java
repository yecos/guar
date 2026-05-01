package q7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import o7.b;
import o7.d;
import o7.f;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class a implements d {

    /* renamed from: a, reason: collision with root package name */
    public static final String f18237a = "a";

    @Override // o7.d
    public f[] a(b bVar, com.qiniu.android.dns.a aVar) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(String.format("https://dns.google.com/resolve?name=%1$s", bVar.f17616a)).openConnection();
        httpURLConnection.setConnectTimeout(2000);
        httpURLConnection.setReadTimeout(3000);
        s7.b.a(f18237a, "google dns response code is " + httpURLConnection.getResponseCode());
        if (httpURLConnection.getResponseCode() != 200) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                break;
            }
            sb.append(readLine);
        }
        s7.b.a(f18237a, "google dns resolve domain is " + bVar.f17616a + " and result is " + sb.toString());
        try {
            JSONObject jSONObject = new JSONObject(sb.toString());
            if (jSONObject.optInt("Status", 0) != 0) {
                return null;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("Answer");
            if (optJSONArray.length() <= 0) {
                return null;
            }
            int length = optJSONArray.length();
            f[] fVarArr = new f[length];
            for (int i10 = 0; i10 < length; i10++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i10);
                if (optJSONObject.optInt("type") == 1) {
                    fVarArr[i10] = new f(optJSONObject.optString("data"), 1, optJSONObject.optInt("TTL"), System.currentTimeMillis() / 1000, f.a.Unknown);
                }
            }
            return fVarArr;
        } catch (JSONException e10) {
            e10.printStackTrace();
            return null;
        }
    }
}
