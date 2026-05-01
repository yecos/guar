package anet.channel.util;

import android.text.TextUtils;
import anet.channel.strategy.StrategyCenter;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.hpplay.cybergarage.soap.SOAP;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.net.MalformedURLException;
import java.net.URL;

/* loaded from: classes.dex */
public class HttpUrl {
    private String host;
    private volatile boolean isSchemeLocked;
    private String path;
    private int port;
    private String scheme;
    private String simpleUrl;
    private String url;

    private HttpUrl() {
        this.isSchemeLocked = false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00af, code lost:
    
        if (r2 <= 65535) goto L116;
     */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static HttpUrl parse(String str) {
        int i10;
        int i11;
        int i12;
        String str2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String trim = str.trim();
        HttpUrl httpUrl = new HttpUrl();
        httpUrl.url = trim;
        int i13 = 0;
        if (trim.startsWith("//")) {
            httpUrl.scheme = null;
            i10 = 0;
        } else {
            if (!trim.regionMatches(true, 0, "https:", 0, 6)) {
                if (trim.regionMatches(true, 0, "http:", 0, 5)) {
                    httpUrl.scheme = HttpConstant.HTTP;
                    i10 = 5;
                }
                return null;
            }
            httpUrl.scheme = "https";
            i10 = 6;
        }
        int length = trim.length();
        int i14 = i10 + 2;
        int i15 = i14;
        boolean z10 = false;
        while (i15 < length) {
            char charAt = trim.charAt(i15);
            if (charAt != '[') {
                if (charAt != ']') {
                    if (charAt == '/' || charAt == '?' || charAt == '#' || (charAt == ':' && !z10)) {
                        httpUrl.host = trim.substring(i14, i15);
                        break;
                    }
                } else {
                    z10 = false;
                }
            } else {
                z10 = true;
            }
            i15++;
        }
        if (i15 == length) {
            httpUrl.host = trim.substring(i14);
        }
        int i16 = 0;
        while (i15 < length) {
            char charAt2 = trim.charAt(i15);
            if (charAt2 == ':' && i16 == 0) {
                i16 = i15 + 1;
            } else if (charAt2 == '/' || charAt2 == '#' || charAt2 == '?') {
                i11 = i15;
                break;
            }
            i15++;
        }
        i11 = length;
        if (i16 != 0) {
            try {
                int parseInt = Integer.parseInt(trim.substring(i16, i11));
                httpUrl.port = parseInt;
                if (parseInt > 0) {
                }
            } catch (NumberFormatException unused) {
            }
            return null;
        }
        while (i15 < length) {
            char charAt3 = trim.charAt(i15);
            if (charAt3 == '/' && i13 == 0) {
                i13 = i15;
            } else if (charAt3 == '?' || charAt3 == '#') {
                if (i13 != 0) {
                    i12 = i15;
                    if (i13 != 0) {
                        httpUrl.path = trim.substring(i13, i12);
                    } else {
                        httpUrl.path = null;
                    }
                    if (httpUrl.scheme == null) {
                        int i17 = httpUrl.port;
                        if (i17 == 80) {
                            httpUrl.scheme = HttpConstant.HTTP;
                        } else if (i17 == 443) {
                            httpUrl.scheme = "https";
                        } else {
                            httpUrl.scheme = StrategyCenter.getInstance().getSchemeByHost(httpUrl.host, null);
                        }
                    }
                    if (!TextUtils.isEmpty(httpUrl.scheme) && !TextUtils.isEmpty(httpUrl.host)) {
                        StringBuilder sb = new StringBuilder(httpUrl.scheme);
                        sb.append(HttpConstant.SCHEME_SPLIT);
                        sb.append(httpUrl.host);
                        if (httpUrl.containsNonDefaultPort()) {
                            sb.append(SOAP.DELIM);
                            sb.append(httpUrl.port);
                        }
                        str2 = httpUrl.path;
                        if (str2 == null) {
                            sb.append(str2);
                        } else if (i15 != length) {
                            sb.append(Operator.Operation.DIVISION);
                        }
                        httpUrl.simpleUrl = sb.toString();
                        sb.append(trim.substring(i15));
                        httpUrl.url = sb.toString();
                        return httpUrl;
                    }
                    return null;
                }
                i12 = length;
                if (i13 != 0) {
                }
                if (httpUrl.scheme == null) {
                }
                if (!TextUtils.isEmpty(httpUrl.scheme)) {
                    StringBuilder sb2 = new StringBuilder(httpUrl.scheme);
                    sb2.append(HttpConstant.SCHEME_SPLIT);
                    sb2.append(httpUrl.host);
                    if (httpUrl.containsNonDefaultPort()) {
                    }
                    str2 = httpUrl.path;
                    if (str2 == null) {
                    }
                    httpUrl.simpleUrl = sb2.toString();
                    sb2.append(trim.substring(i15));
                    httpUrl.url = sb2.toString();
                    return httpUrl;
                }
                return null;
            }
            i15++;
        }
        i12 = length;
        if (i13 != 0) {
        }
        if (httpUrl.scheme == null) {
        }
        if (!TextUtils.isEmpty(httpUrl.scheme)) {
        }
        return null;
    }

    public boolean containsNonDefaultPort() {
        return this.port != 0 && ((HttpConstant.HTTP.equals(this.scheme) && this.port != 80) || ("https".equals(this.scheme) && this.port != 443));
    }

    public void downgradeSchemeAndLock() {
        this.isSchemeLocked = true;
        if (HttpConstant.HTTP.equals(this.scheme)) {
            return;
        }
        this.scheme = HttpConstant.HTTP;
        String str = this.url;
        this.url = StringUtils.concatString(HttpConstant.HTTP, SOAP.DELIM, str.substring(str.indexOf("//")));
    }

    public int getPort() {
        return this.port;
    }

    public String host() {
        return this.host;
    }

    public boolean isSchemeLocked() {
        return this.isSchemeLocked;
    }

    public void lockScheme() {
        this.isSchemeLocked = true;
    }

    public String path() {
        return this.path;
    }

    public void replaceIpAndPort(String str, int i10) {
        if (str != null) {
            int indexOf = this.url.indexOf("//") + 2;
            while (indexOf < this.url.length() && this.url.charAt(indexOf) != '/') {
                indexOf++;
            }
            boolean b10 = anet.channel.strategy.utils.d.b(str);
            StringBuilder sb = new StringBuilder(this.url.length() + str.length());
            sb.append(this.scheme);
            sb.append(HttpConstant.SCHEME_SPLIT);
            if (b10) {
                sb.append('[');
            }
            sb.append(str);
            if (b10) {
                sb.append(']');
            }
            if (i10 != 0) {
                sb.append(ASCIIPropertyListParser.DATE_TIME_FIELD_DELIMITER);
                sb.append(i10);
            } else if (this.port != 0) {
                sb.append(ASCIIPropertyListParser.DATE_TIME_FIELD_DELIMITER);
                sb.append(this.port);
            }
            sb.append(this.url.substring(indexOf));
            this.url = sb.toString();
        }
    }

    public String scheme() {
        return this.scheme;
    }

    public void setScheme(String str) {
        if (this.isSchemeLocked || str.equalsIgnoreCase(this.scheme)) {
            return;
        }
        this.scheme = str;
        String str2 = this.url;
        String concatString = StringUtils.concatString(str, SOAP.DELIM, str2.substring(str2.indexOf("//")));
        this.url = concatString;
        this.simpleUrl = StringUtils.concatString(str, SOAP.DELIM, this.simpleUrl.substring(concatString.indexOf("//")));
    }

    public String simpleUrlString() {
        return this.simpleUrl;
    }

    public String toString() {
        return this.url;
    }

    public URL toURL() {
        try {
            return new URL(this.url);
        } catch (MalformedURLException unused) {
            return null;
        }
    }

    public String urlString() {
        return this.url;
    }

    public HttpUrl(HttpUrl httpUrl) {
        this.isSchemeLocked = false;
        this.scheme = httpUrl.scheme;
        this.host = httpUrl.host;
        this.path = httpUrl.path;
        this.url = httpUrl.url;
        this.simpleUrl = httpUrl.simpleUrl;
        this.isSchemeLocked = httpUrl.isSchemeLocked;
    }
}
