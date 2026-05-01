package c7;

import ja.c;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: classes3.dex */
public abstract class a {
    public static String a(String str) {
        try {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            Response execute = builder.readTimeout(5L, timeUnit).connectTimeout(5L, timeUnit).addInterceptor(new la.a(".notice")).dns(new c(".notice")).build().newCall(new Request.Builder().url(str).addHeader("accept", "*/*").addHeader("connection", "Keep-Alive").build()).execute();
            if (execute.body() == null || execute.code() != 200) {
                return null;
            }
            return execute.body().string();
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }
}
