package la;

import android.text.TextUtils;
import anet.channel.request.Request;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;
import ma.i;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;

/* loaded from: classes3.dex */
public abstract class d implements Interceptor {

    /* renamed from: a, reason: collision with root package name */
    public final MediaType f16460a = MediaType.parse("application/json; charset=utf-8");

    public static String b(Request request) {
        RequestBody body = request.body();
        Charset forName = Charset.forName("UTF-8");
        StringBuilder sb = new StringBuilder();
        MediaType contentType = body.contentType();
        if (contentType != null) {
            forName = contentType.charset(Charset.forName("UTF-8"));
        }
        Buffer buffer = new Buffer();
        try {
            body.writeTo(buffer);
        } catch (IOException e10) {
            e10.printStackTrace();
        }
        sb.append(buffer.readString(forName));
        buffer.close();
        return sb.toString();
    }

    public abstract Iterable a();

    public abstract boolean c();

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        String str;
        Request request = chain.request();
        if ((!TextUtils.equals(request.method(), "POST") && !TextUtils.equals(request.method(), Request.Method.PUT)) || !request.body().contentType().toString().contains("application/json;")) {
            return chain.proceed(request);
        }
        try {
            String header = request.header("needEncrypt");
            JsonObject jsonObject = request.body().contentLength() <= 0 ? new JsonObject() : new JsonParser().parse(b(request)).getAsJsonObject();
            JsonElement jsonElement = jsonObject.get("columnId");
            if (jsonElement != null && jsonElement.getAsInt() == -1) {
                chain.call().cancel();
            }
            try {
                String path = request.url().url().getPath();
                if (!path.contains("/sendEmailVerifyCode") && !path.contains("/getAreaCode") && !path.contains("/validateVerifyCode") && !path.contains("/resetPwd") && !path.contains("/qr/token") && !path.contains("v3/getProgram") && !path.contains("/feedback/userFeedBack") && !path.contains("/getVerifiCode") && !path.contains("/checkVerifiCode") && jsonObject.get("userId") != null && jsonObject.get("userId").getAsString().isEmpty()) {
                    chain.call().cancel();
                }
            } catch (Exception unused) {
            }
            for (Map.Entry entry : a()) {
                jsonObject.add((String) entry.getKey(), (JsonElement) entry.getValue());
            }
            if (jsonObject.get("securityKey") != null) {
                str = jsonObject.get("securityKey").getAsString();
                jsonObject.remove("securityKey");
            } else {
                str = null;
            }
            RequestBody create = RequestBody.create(this.f16460a, (!c() || "false".equals(header)) ? jsonObject.toString() : !TextUtils.isEmpty(str) ? i.e(jsonObject.toString(), str) : i.d(jsonObject.toString()));
            request = (TextUtils.equals(request.method(), "POST") ? request.newBuilder().post(create) : request.newBuilder().put(create)).build();
            b(request);
            return chain.proceed(request);
        } catch (Exception unused2) {
            return chain.proceed(request);
        }
    }
}
