package anet.channel.request;

import android.text.TextUtils;
import anet.channel.AwcnConfig;
import anet.channel.statist.RequestStatistic;
import anet.channel.strategy.utils.d;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import anet.channel.util.HttpUrl;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes.dex */
public class Request {
    public static final String DEFAULT_CHARSET = "UTF-8";

    /* renamed from: a, reason: collision with root package name */
    public final RequestStatistic f4045a;

    /* renamed from: b, reason: collision with root package name */
    private HttpUrl f4046b;

    /* renamed from: c, reason: collision with root package name */
    private HttpUrl f4047c;

    /* renamed from: d, reason: collision with root package name */
    private HttpUrl f4048d;

    /* renamed from: e, reason: collision with root package name */
    private URL f4049e;

    /* renamed from: f, reason: collision with root package name */
    private String f4050f;

    /* renamed from: g, reason: collision with root package name */
    private Map<String, String> f4051g;

    /* renamed from: h, reason: collision with root package name */
    private Map<String, String> f4052h;

    /* renamed from: i, reason: collision with root package name */
    private String f4053i;

    /* renamed from: j, reason: collision with root package name */
    private BodyEntry f4054j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f4055k;

    /* renamed from: l, reason: collision with root package name */
    private String f4056l;

    /* renamed from: m, reason: collision with root package name */
    private String f4057m;

    /* renamed from: n, reason: collision with root package name */
    private int f4058n;

    /* renamed from: o, reason: collision with root package name */
    private int f4059o;

    /* renamed from: p, reason: collision with root package name */
    private int f4060p;

    /* renamed from: q, reason: collision with root package name */
    private HostnameVerifier f4061q;

    /* renamed from: r, reason: collision with root package name */
    private SSLSocketFactory f4062r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f4063s;

    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private HttpUrl f4064a;

        /* renamed from: b, reason: collision with root package name */
        private HttpUrl f4065b;

        /* renamed from: e, reason: collision with root package name */
        private Map<String, String> f4068e;

        /* renamed from: f, reason: collision with root package name */
        private String f4069f;

        /* renamed from: g, reason: collision with root package name */
        private BodyEntry f4070g;

        /* renamed from: j, reason: collision with root package name */
        private HostnameVerifier f4073j;

        /* renamed from: k, reason: collision with root package name */
        private SSLSocketFactory f4074k;

        /* renamed from: l, reason: collision with root package name */
        private String f4075l;

        /* renamed from: m, reason: collision with root package name */
        private String f4076m;

        /* renamed from: q, reason: collision with root package name */
        private boolean f4080q;

        /* renamed from: c, reason: collision with root package name */
        private String f4066c = "GET";

        /* renamed from: d, reason: collision with root package name */
        private Map<String, String> f4067d = new HashMap();

        /* renamed from: h, reason: collision with root package name */
        private boolean f4071h = true;

        /* renamed from: i, reason: collision with root package name */
        private int f4072i = 0;

        /* renamed from: n, reason: collision with root package name */
        private int f4077n = 10000;

        /* renamed from: o, reason: collision with root package name */
        private int f4078o = 10000;

        /* renamed from: p, reason: collision with root package name */
        private RequestStatistic f4079p = null;

        public Builder addHeader(String str, String str2) {
            this.f4067d.put(str, str2);
            return this;
        }

        public Builder addParam(String str, String str2) {
            if (this.f4068e == null) {
                this.f4068e = new HashMap();
            }
            this.f4068e.put(str, str2);
            this.f4065b = null;
            return this;
        }

        public Request build() {
            if (this.f4070g == null && this.f4068e == null && Method.a(this.f4066c)) {
                ALog.e("awcn.Request", "method " + this.f4066c + " must have a request body", null, new Object[0]);
            }
            if (this.f4070g != null && !Method.b(this.f4066c)) {
                ALog.e("awcn.Request", "method " + this.f4066c + " should not have a request body", null, new Object[0]);
                this.f4070g = null;
            }
            BodyEntry bodyEntry = this.f4070g;
            if (bodyEntry != null && bodyEntry.getContentType() != null) {
                addHeader("Content-Type", this.f4070g.getContentType());
            }
            return new Request(this);
        }

        public Builder setAllowRequestInBg(boolean z10) {
            this.f4080q = z10;
            return this;
        }

        public Builder setBizId(String str) {
            this.f4075l = str;
            return this;
        }

        public Builder setBody(BodyEntry bodyEntry) {
            this.f4070g = bodyEntry;
            return this;
        }

        public Builder setCharset(String str) {
            this.f4069f = str;
            this.f4065b = null;
            return this;
        }

        public Builder setConnectTimeout(int i10) {
            if (i10 > 0) {
                this.f4077n = i10;
            }
            return this;
        }

        public Builder setHeaders(Map<String, String> map) {
            this.f4067d.clear();
            if (map != null) {
                this.f4067d.putAll(map);
            }
            return this;
        }

        public Builder setHostnameVerifier(HostnameVerifier hostnameVerifier) {
            this.f4073j = hostnameVerifier;
            return this;
        }

        public Builder setMethod(String str) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("method is null or empty");
            }
            if ("GET".equalsIgnoreCase(str)) {
                this.f4066c = "GET";
            } else if ("POST".equalsIgnoreCase(str)) {
                this.f4066c = "POST";
            } else if (Method.OPTION.equalsIgnoreCase(str)) {
                this.f4066c = Method.OPTION;
            } else if ("HEAD".equalsIgnoreCase(str)) {
                this.f4066c = "HEAD";
            } else if (Method.PUT.equalsIgnoreCase(str)) {
                this.f4066c = Method.PUT;
            } else if ("DELETE".equalsIgnoreCase(str)) {
                this.f4066c = "DELETE";
            } else {
                this.f4066c = "GET";
            }
            return this;
        }

        public Builder setParams(Map<String, String> map) {
            this.f4068e = map;
            this.f4065b = null;
            return this;
        }

        public Builder setReadTimeout(int i10) {
            if (i10 > 0) {
                this.f4078o = i10;
            }
            return this;
        }

        public Builder setRedirectEnable(boolean z10) {
            this.f4071h = z10;
            return this;
        }

        public Builder setRedirectTimes(int i10) {
            this.f4072i = i10;
            return this;
        }

        public Builder setRequestStatistic(RequestStatistic requestStatistic) {
            this.f4079p = requestStatistic;
            return this;
        }

        public Builder setSeq(String str) {
            this.f4076m = str;
            return this;
        }

        public Builder setSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
            this.f4074k = sSLSocketFactory;
            return this;
        }

        public Builder setUrl(HttpUrl httpUrl) {
            this.f4064a = httpUrl;
            this.f4065b = null;
            return this;
        }

        public Builder setUrl(String str) {
            HttpUrl parse = HttpUrl.parse(str);
            this.f4064a = parse;
            this.f4065b = null;
            if (parse != null) {
                return this;
            }
            throw new IllegalArgumentException("toURL is invalid! toURL = " + str);
        }
    }

    public static final class Method {
        public static final String DELETE = "DELETE";
        public static final String GET = "GET";
        public static final String HEAD = "HEAD";
        public static final String OPTION = "OPTIONS";
        public static final String POST = "POST";
        public static final String PUT = "PUT";

        public static boolean a(String str) {
            return str.equals("POST") || str.equals(PUT);
        }

        public static boolean b(String str) {
            return a(str) || str.equals("DELETE") || str.equals(OPTION);
        }
    }

    private Map<String, String> a() {
        return AwcnConfig.isCookieHeaderRedundantFix() ? new HashMap(this.f4051g) : this.f4051g;
    }

    private void b() {
        String a10 = d.a(this.f4052h, getContentEncoding());
        if (!TextUtils.isEmpty(a10)) {
            if (Method.a(this.f4050f) && this.f4054j == null) {
                try {
                    this.f4054j = new ByteArrayEntry(a10.getBytes(getContentEncoding()));
                    this.f4051g.put("Content-Type", "application/x-www-form-urlencoded; charset=" + getContentEncoding());
                } catch (UnsupportedEncodingException unused) {
                }
            } else {
                String urlString = this.f4046b.urlString();
                StringBuilder sb = new StringBuilder(urlString);
                if (sb.indexOf(Operator.Operation.EMPTY_PARAM) == -1) {
                    sb.append('?');
                } else if (urlString.charAt(urlString.length() - 1) != '&') {
                    sb.append('&');
                }
                sb.append(a10);
                HttpUrl parse = HttpUrl.parse(sb.toString());
                if (parse != null) {
                    this.f4047c = parse;
                }
            }
        }
        if (this.f4047c == null) {
            this.f4047c = this.f4046b;
        }
    }

    public boolean containsBody() {
        return this.f4054j != null;
    }

    public String getBizId() {
        return this.f4056l;
    }

    public byte[] getBodyBytes() {
        if (this.f4054j == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(128);
        try {
            postBody(byteArrayOutputStream);
        } catch (IOException unused) {
        }
        return byteArrayOutputStream.toByteArray();
    }

    public int getConnectTimeout() {
        return this.f4059o;
    }

    public String getContentEncoding() {
        String str = this.f4053i;
        return str != null ? str : "UTF-8";
    }

    public Map<String, String> getHeaders() {
        return Collections.unmodifiableMap(this.f4051g);
    }

    public String getHost() {
        return this.f4047c.host();
    }

    public HostnameVerifier getHostnameVerifier() {
        return this.f4061q;
    }

    public HttpUrl getHttpUrl() {
        return this.f4047c;
    }

    public String getMethod() {
        return this.f4050f;
    }

    public int getReadTimeout() {
        return this.f4060p;
    }

    public int getRedirectTimes() {
        return this.f4058n;
    }

    public String getSeq() {
        return this.f4057m;
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.f4062r;
    }

    public URL getUrl() {
        if (this.f4049e == null) {
            HttpUrl httpUrl = this.f4048d;
            if (httpUrl == null) {
                httpUrl = this.f4047c;
            }
            this.f4049e = httpUrl.toURL();
        }
        return this.f4049e;
    }

    public String getUrlString() {
        return this.f4047c.urlString();
    }

    public boolean isAllowRequestInBg() {
        return this.f4063s;
    }

    public boolean isRedirectEnable() {
        return this.f4055k;
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.f4066c = this.f4050f;
        builder.f4067d = a();
        builder.f4068e = this.f4052h;
        builder.f4070g = this.f4054j;
        builder.f4069f = this.f4053i;
        builder.f4071h = this.f4055k;
        builder.f4072i = this.f4058n;
        builder.f4073j = this.f4061q;
        builder.f4074k = this.f4062r;
        builder.f4064a = this.f4046b;
        builder.f4065b = this.f4047c;
        builder.f4075l = this.f4056l;
        builder.f4076m = this.f4057m;
        builder.f4077n = this.f4059o;
        builder.f4078o = this.f4060p;
        builder.f4079p = this.f4045a;
        builder.f4080q = this.f4063s;
        return builder;
    }

    public int postBody(OutputStream outputStream) {
        BodyEntry bodyEntry = this.f4054j;
        if (bodyEntry != null) {
            return bodyEntry.writeTo(outputStream);
        }
        return 0;
    }

    public void setDnsOptimize(String str, int i10) {
        if (str != null) {
            if (this.f4048d == null) {
                this.f4048d = new HttpUrl(this.f4047c);
            }
            this.f4048d.replaceIpAndPort(str, i10);
        } else {
            this.f4048d = null;
        }
        this.f4049e = null;
        this.f4045a.setIPAndPort(str, i10);
    }

    public void setUrlScheme(boolean z10) {
        if (this.f4048d == null) {
            this.f4048d = new HttpUrl(this.f4047c);
        }
        this.f4048d.setScheme(z10 ? "https" : HttpConstant.HTTP);
        this.f4049e = null;
    }

    private Request(Builder builder) {
        this.f4050f = "GET";
        this.f4055k = true;
        this.f4058n = 0;
        this.f4059o = 10000;
        this.f4060p = 10000;
        this.f4050f = builder.f4066c;
        this.f4051g = builder.f4067d;
        this.f4052h = builder.f4068e;
        this.f4054j = builder.f4070g;
        this.f4053i = builder.f4069f;
        this.f4055k = builder.f4071h;
        this.f4058n = builder.f4072i;
        this.f4061q = builder.f4073j;
        this.f4062r = builder.f4074k;
        this.f4056l = builder.f4075l;
        this.f4057m = builder.f4076m;
        this.f4059o = builder.f4077n;
        this.f4060p = builder.f4078o;
        this.f4046b = builder.f4064a;
        HttpUrl httpUrl = builder.f4065b;
        this.f4047c = httpUrl;
        if (httpUrl == null) {
            b();
        }
        this.f4045a = builder.f4079p != null ? builder.f4079p : new RequestStatistic(getHost(), this.f4056l);
        this.f4063s = builder.f4080q;
    }
}
