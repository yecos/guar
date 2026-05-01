package w6;

import android.text.TextUtils;
import ba.t;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mobile.brasiltv.app.App;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.i1;
import java.io.IOException;
import java.nio.charset.Charset;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;

/* loaded from: classes3.dex */
public final class l implements Interceptor {

    /* renamed from: a, reason: collision with root package name */
    public static final a f19260a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public static final int f19261b = 4;

    /* renamed from: c, reason: collision with root package name */
    public static final int f19262c = 2;

    /* renamed from: d, reason: collision with root package name */
    public static final int f19263d = 1;

    /* renamed from: e, reason: collision with root package name */
    public static int f19264e;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(t9.g gVar) {
            this();
        }

        public final int a() {
            return l.f19263d;
        }

        public final int b() {
            return l.f19262c;
        }

        public final int c() {
            return l.f19261b;
        }

        public final int d() {
            return l.f19264e;
        }

        public final void e(int i10) {
            l.f19264e = i10;
        }
    }

    public final String f(Request request) {
        t9.i.g(request, "request");
        RequestBody body = request.body();
        Charset forName = Charset.forName("UTF-8");
        StringBuilder sb = new StringBuilder();
        t9.i.d(body);
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
        String sb2 = sb.toString();
        t9.i.f(sb2, "sb.toString()");
        return sb2;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        JsonObject asJsonObject;
        MediaType contentType;
        String mediaType;
        t9.i.g(chain, "chain");
        Request request = chain.request();
        if (TextUtils.equals(request.method(), "POST")) {
            RequestBody body = request.body();
            boolean z10 = false;
            if (body != null && (contentType = body.contentType()) != null && (mediaType = contentType.toString()) != null) {
                z10 = t.o(mediaType, "application/json;", false, 2, null);
            }
            if (z10) {
                RequestBody body2 = request.body();
                t9.i.d(body2);
                if (body2.contentLength() <= 0) {
                    asJsonObject = new JsonObject();
                } else {
                    JsonParser jsonParser = new JsonParser();
                    t9.i.f(request, "request");
                    asJsonObject = jsonParser.parse(f(request)).getAsJsonObject();
                    t9.i.f(asJsonObject, "JsonParser().parse(key(request)).getAsJsonObject()");
                }
                try {
                    JsonElement jsonElement = asJsonObject.get("userToken");
                    String asString = jsonElement != null ? jsonElement.getAsString() : null;
                    String str = "";
                    if (asString == null) {
                        asString = "";
                    }
                    JsonElement jsonElement2 = asJsonObject.get("userId");
                    String asString2 = jsonElement2 != null ? jsonElement2.getAsString() : null;
                    if (asString2 != null) {
                        str = asString2;
                    }
                    if (b0.J(asString) || b0.J(str)) {
                        i1.r(App.f8263e.a().getApplicationContext(), request.url().url().getPath(), f19264e, b0.J(asString), b0.J(str));
                    }
                } catch (Exception unused) {
                }
                Response proceed = chain.proceed(request);
                t9.i.f(proceed, "chain.proceed(request)");
                return proceed;
            }
        }
        Response proceed2 = chain.proceed(request);
        t9.i.f(proceed2, "chain.proceed(request)");
        return proceed2;
    }
}
