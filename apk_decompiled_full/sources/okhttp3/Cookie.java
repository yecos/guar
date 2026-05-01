package okhttp3;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.hpplay.cybergarage.http.HTTP;
import com.hpplay.cybergarage.upnp.ssdp.SSDP;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpDate;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;

/* loaded from: classes3.dex */
public final class Cookie {
    private final String domain;
    private final long expiresAt;
    private final boolean hostOnly;
    private final boolean httpOnly;
    private final String name;
    private final String path;
    private final boolean persistent;
    private final boolean secure;
    private final String value;
    private static final Pattern YEAR_PATTERN = Pattern.compile("(\\d{2,4})[^\\d]*");
    private static final Pattern MONTH_PATTERN = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final Pattern DAY_OF_MONTH_PATTERN = Pattern.compile("(\\d{1,2})[^\\d]*");
    private static final Pattern TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    public static final class Builder {

        @Nullable
        String domain;
        boolean hostOnly;
        boolean httpOnly;

        @Nullable
        String name;
        boolean persistent;
        boolean secure;

        @Nullable
        String value;
        long expiresAt = HttpDate.MAX_DATE;
        String path = Operator.Operation.DIVISION;

        public Cookie build() {
            return new Cookie(this);
        }

        public Builder domain(String str) {
            return domain(str, false);
        }

        public Builder expiresAt(long j10) {
            if (j10 <= 0) {
                j10 = Long.MIN_VALUE;
            }
            if (j10 > HttpDate.MAX_DATE) {
                j10 = 253402300799999L;
            }
            this.expiresAt = j10;
            this.persistent = true;
            return this;
        }

        public Builder hostOnlyDomain(String str) {
            return domain(str, true);
        }

        public Builder httpOnly() {
            this.httpOnly = true;
            return this;
        }

        public Builder name(String str) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            if (!str.trim().equals(str)) {
                throw new IllegalArgumentException("name is not trimmed");
            }
            this.name = str;
            return this;
        }

        public Builder path(String str) {
            if (!str.startsWith(Operator.Operation.DIVISION)) {
                throw new IllegalArgumentException("path must start with '/'");
            }
            this.path = str;
            return this;
        }

        public Builder secure() {
            this.secure = true;
            return this;
        }

        public Builder value(String str) {
            if (str == null) {
                throw new NullPointerException("value == null");
            }
            if (!str.trim().equals(str)) {
                throw new IllegalArgumentException("value is not trimmed");
            }
            this.value = str;
            return this;
        }

        private Builder domain(String str, boolean z10) {
            if (str == null) {
                throw new NullPointerException("domain == null");
            }
            String canonicalizeHost = Util.canonicalizeHost(str);
            if (canonicalizeHost != null) {
                this.domain = canonicalizeHost;
                this.hostOnly = z10;
                return this;
            }
            throw new IllegalArgumentException("unexpected domain: " + str);
        }
    }

    private Cookie(String str, String str2, long j10, String str3, String str4, boolean z10, boolean z11, boolean z12, boolean z13) {
        this.name = str;
        this.value = str2;
        this.expiresAt = j10;
        this.domain = str3;
        this.path = str4;
        this.secure = z10;
        this.httpOnly = z11;
        this.hostOnly = z12;
        this.persistent = z13;
    }

    private static int dateCharacterOffset(String str, int i10, int i11, boolean z10) {
        while (i10 < i11) {
            char charAt = str.charAt(i10);
            if (((charAt < ' ' && charAt != '\t') || charAt >= 127 || (charAt >= '0' && charAt <= '9') || ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || charAt == ':'))) == (!z10)) {
                return i10;
            }
            i10++;
        }
        return i11;
    }

    private static boolean domainMatch(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        return str.endsWith(str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !Util.verifyAsIpAddress(str);
    }

    @Nullable
    public static Cookie parse(HttpUrl httpUrl, String str) {
        return parse(System.currentTimeMillis(), httpUrl, str);
    }

    public static List<Cookie> parseAll(HttpUrl httpUrl, Headers headers) {
        List<String> values = headers.values("Set-Cookie");
        int size = values.size();
        ArrayList arrayList = null;
        for (int i10 = 0; i10 < size; i10++) {
            Cookie parse = parse(httpUrl, values.get(i10));
            if (parse != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(parse);
            }
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.emptyList();
    }

    private static String parseDomain(String str) {
        if (str.endsWith(".")) {
            throw new IllegalArgumentException();
        }
        if (str.startsWith(".")) {
            str = str.substring(1);
        }
        String canonicalizeHost = Util.canonicalizeHost(str);
        if (canonicalizeHost != null) {
            return canonicalizeHost;
        }
        throw new IllegalArgumentException();
    }

    private static long parseExpires(String str, int i10, int i11) {
        int dateCharacterOffset = dateCharacterOffset(str, i10, i11, false);
        Matcher matcher = TIME_PATTERN.matcher(str);
        int i12 = -1;
        int i13 = -1;
        int i14 = -1;
        int i15 = -1;
        int i16 = -1;
        int i17 = -1;
        while (dateCharacterOffset < i11) {
            int dateCharacterOffset2 = dateCharacterOffset(str, dateCharacterOffset + 1, i11, true);
            matcher.region(dateCharacterOffset, dateCharacterOffset2);
            if (i13 == -1 && matcher.usePattern(TIME_PATTERN).matches()) {
                i13 = Integer.parseInt(matcher.group(1));
                i16 = Integer.parseInt(matcher.group(2));
                i17 = Integer.parseInt(matcher.group(3));
            } else if (i14 == -1 && matcher.usePattern(DAY_OF_MONTH_PATTERN).matches()) {
                i14 = Integer.parseInt(matcher.group(1));
            } else {
                if (i15 == -1) {
                    Pattern pattern = MONTH_PATTERN;
                    if (matcher.usePattern(pattern).matches()) {
                        i15 = pattern.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
                    }
                }
                if (i12 == -1 && matcher.usePattern(YEAR_PATTERN).matches()) {
                    i12 = Integer.parseInt(matcher.group(1));
                }
            }
            dateCharacterOffset = dateCharacterOffset(str, dateCharacterOffset2 + 1, i11, false);
        }
        if (i12 >= 70 && i12 <= 99) {
            i12 += SSDP.PORT;
        }
        if (i12 >= 0 && i12 <= 69) {
            i12 += 2000;
        }
        if (i12 < 1601) {
            throw new IllegalArgumentException();
        }
        if (i15 == -1) {
            throw new IllegalArgumentException();
        }
        if (i14 < 1 || i14 > 31) {
            throw new IllegalArgumentException();
        }
        if (i13 < 0 || i13 > 23) {
            throw new IllegalArgumentException();
        }
        if (i16 < 0 || i16 > 59) {
            throw new IllegalArgumentException();
        }
        if (i17 < 0 || i17 > 59) {
            throw new IllegalArgumentException();
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar(Util.UTC);
        gregorianCalendar.setLenient(false);
        gregorianCalendar.set(1, i12);
        gregorianCalendar.set(2, i15 - 1);
        gregorianCalendar.set(5, i14);
        gregorianCalendar.set(11, i13);
        gregorianCalendar.set(12, i16);
        gregorianCalendar.set(13, i17);
        gregorianCalendar.set(14, 0);
        return gregorianCalendar.getTimeInMillis();
    }

    private static long parseMaxAge(String str) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong <= 0) {
                return Long.MIN_VALUE;
            }
            return parseLong;
        } catch (NumberFormatException e10) {
            if (str.matches("-?\\d+")) {
                return str.startsWith(Operator.Operation.MINUS) ? Long.MIN_VALUE : Long.MAX_VALUE;
            }
            throw e10;
        }
    }

    private static boolean pathMatch(HttpUrl httpUrl, String str) {
        String encodedPath = httpUrl.encodedPath();
        if (encodedPath.equals(str)) {
            return true;
        }
        if (encodedPath.startsWith(str)) {
            return str.endsWith(Operator.Operation.DIVISION) || encodedPath.charAt(str.length()) == '/';
        }
        return false;
    }

    public String domain() {
        return this.domain;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Cookie)) {
            return false;
        }
        Cookie cookie = (Cookie) obj;
        return cookie.name.equals(this.name) && cookie.value.equals(this.value) && cookie.domain.equals(this.domain) && cookie.path.equals(this.path) && cookie.expiresAt == this.expiresAt && cookie.secure == this.secure && cookie.httpOnly == this.httpOnly && cookie.persistent == this.persistent && cookie.hostOnly == this.hostOnly;
    }

    public long expiresAt() {
        return this.expiresAt;
    }

    public int hashCode() {
        int hashCode = (((((((527 + this.name.hashCode()) * 31) + this.value.hashCode()) * 31) + this.domain.hashCode()) * 31) + this.path.hashCode()) * 31;
        long j10 = this.expiresAt;
        return ((((((((hashCode + ((int) (j10 ^ (j10 >>> 32)))) * 31) + (!this.secure ? 1 : 0)) * 31) + (!this.httpOnly ? 1 : 0)) * 31) + (!this.persistent ? 1 : 0)) * 31) + (!this.hostOnly ? 1 : 0);
    }

    public boolean hostOnly() {
        return this.hostOnly;
    }

    public boolean httpOnly() {
        return this.httpOnly;
    }

    public boolean matches(HttpUrl httpUrl) {
        if ((this.hostOnly ? httpUrl.host().equals(this.domain) : domainMatch(httpUrl.host(), this.domain)) && pathMatch(httpUrl, this.path)) {
            return !this.secure || httpUrl.isHttps();
        }
        return false;
    }

    public String name() {
        return this.name;
    }

    public String path() {
        return this.path;
    }

    public boolean persistent() {
        return this.persistent;
    }

    public boolean secure() {
        return this.secure;
    }

    public String toString() {
        return toString(false);
    }

    public String value() {
        return this.value;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00f0  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Cookie parse(long j10, HttpUrl httpUrl, String str) {
        long j11;
        String host;
        Cookie cookie;
        String str2;
        String str3;
        int lastIndexOf;
        String str4;
        int length = str.length();
        char c10 = ASCIIPropertyListParser.DICTIONARY_ITEM_DELIMITER_TOKEN;
        int delimiterOffset = Util.delimiterOffset(str, 0, length, ASCIIPropertyListParser.DICTIONARY_ITEM_DELIMITER_TOKEN);
        char c11 = ASCIIPropertyListParser.DICTIONARY_ASSIGN_TOKEN;
        int delimiterOffset2 = Util.delimiterOffset(str, 0, delimiterOffset, ASCIIPropertyListParser.DICTIONARY_ASSIGN_TOKEN);
        if (delimiterOffset2 == delimiterOffset) {
            return null;
        }
        String trimSubstring = Util.trimSubstring(str, 0, delimiterOffset2);
        if (trimSubstring.isEmpty() || Util.indexOfControlOrNonAscii(trimSubstring) != -1) {
            return null;
        }
        String trimSubstring2 = Util.trimSubstring(str, delimiterOffset2 + 1, delimiterOffset);
        if (Util.indexOfControlOrNonAscii(trimSubstring2) != -1) {
            return null;
        }
        int i10 = delimiterOffset + 1;
        String str5 = null;
        String str6 = null;
        long j12 = -1;
        long j13 = 253402300799999L;
        boolean z10 = false;
        boolean z11 = false;
        boolean z12 = true;
        boolean z13 = false;
        while (i10 < length) {
            int delimiterOffset3 = Util.delimiterOffset(str, i10, length, c10);
            int delimiterOffset4 = Util.delimiterOffset(str, i10, delimiterOffset3, c11);
            String trimSubstring3 = Util.trimSubstring(str, i10, delimiterOffset4);
            String trimSubstring4 = delimiterOffset4 < delimiterOffset3 ? Util.trimSubstring(str, delimiterOffset4 + 1, delimiterOffset3) : "";
            if (trimSubstring3.equalsIgnoreCase("expires")) {
                try {
                    j13 = parseExpires(trimSubstring4, 0, trimSubstring4.length());
                } catch (NumberFormatException | IllegalArgumentException unused) {
                }
            } else if (trimSubstring3.equalsIgnoreCase(HTTP.MAX_AGE)) {
                j12 = parseMaxAge(trimSubstring4);
            } else {
                if (trimSubstring3.equalsIgnoreCase("domain")) {
                    str6 = parseDomain(trimSubstring4);
                    z12 = false;
                } else if (trimSubstring3.equalsIgnoreCase("path")) {
                    str5 = trimSubstring4;
                } else if (trimSubstring3.equalsIgnoreCase("secure")) {
                    z10 = true;
                } else if (trimSubstring3.equalsIgnoreCase("httponly")) {
                    z11 = true;
                }
                i10 = delimiterOffset3 + 1;
                c10 = ASCIIPropertyListParser.DICTIONARY_ITEM_DELIMITER_TOKEN;
                c11 = ASCIIPropertyListParser.DICTIONARY_ASSIGN_TOKEN;
            }
            z13 = true;
            i10 = delimiterOffset3 + 1;
            c10 = ASCIIPropertyListParser.DICTIONARY_ITEM_DELIMITER_TOKEN;
            c11 = ASCIIPropertyListParser.DICTIONARY_ASSIGN_TOKEN;
        }
        long j14 = Long.MIN_VALUE;
        if (j12 != Long.MIN_VALUE) {
            if (j12 != -1) {
                j14 = j10 + (j12 <= 9223372036854775L ? j12 * 1000 : Long.MAX_VALUE);
                if (j14 < j10 || j14 > HttpDate.MAX_DATE) {
                    j11 = 253402300799999L;
                }
            } else {
                j11 = j13;
            }
            host = httpUrl.host();
            if (str6 != null) {
                str2 = host;
                cookie = null;
            } else {
                if (!domainMatch(host, str6)) {
                    return null;
                }
                cookie = null;
                str2 = str6;
            }
            if (host.length() == str2.length() && PublicSuffixDatabase.get().getEffectiveTldPlusOne(str2) == null) {
                return cookie;
            }
            str3 = Operator.Operation.DIVISION;
            if (str5 == null && str5.startsWith(Operator.Operation.DIVISION)) {
                str4 = str5;
            } else {
                String encodedPath = httpUrl.encodedPath();
                lastIndexOf = encodedPath.lastIndexOf(47);
                if (lastIndexOf != 0) {
                    str3 = encodedPath.substring(0, lastIndexOf);
                }
                str4 = str3;
            }
            return new Cookie(trimSubstring, trimSubstring2, j11, str2, str4, z10, z11, z12, z13);
        }
        j11 = j14;
        host = httpUrl.host();
        if (str6 != null) {
        }
        if (host.length() == str2.length()) {
        }
        str3 = Operator.Operation.DIVISION;
        if (str5 == null) {
        }
        String encodedPath2 = httpUrl.encodedPath();
        lastIndexOf = encodedPath2.lastIndexOf(47);
        if (lastIndexOf != 0) {
        }
        str4 = str3;
        return new Cookie(trimSubstring, trimSubstring2, j11, str2, str4, z10, z11, z12, z13);
    }

    public String toString(boolean z10) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append(ASCIIPropertyListParser.DICTIONARY_ASSIGN_TOKEN);
        sb.append(this.value);
        if (this.persistent) {
            if (this.expiresAt == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(HttpDate.format(new Date(this.expiresAt)));
            }
        }
        if (!this.hostOnly) {
            sb.append("; domain=");
            if (z10) {
                sb.append(".");
            }
            sb.append(this.domain);
        }
        sb.append("; path=");
        sb.append(this.path);
        if (this.secure) {
            sb.append("; secure");
        }
        if (this.httpOnly) {
            sb.append("; httponly");
        }
        return sb.toString();
    }

    public Cookie(Builder builder) {
        String str = builder.name;
        if (str != null) {
            String str2 = builder.value;
            if (str2 != null) {
                String str3 = builder.domain;
                if (str3 != null) {
                    this.name = str;
                    this.value = str2;
                    this.expiresAt = builder.expiresAt;
                    this.domain = str3;
                    this.path = builder.path;
                    this.secure = builder.secure;
                    this.httpOnly = builder.httpOnly;
                    this.persistent = builder.persistent;
                    this.hostOnly = builder.hostOnly;
                    return;
                }
                throw new NullPointerException("builder.domain == null");
            }
            throw new NullPointerException("builder.value == null");
        }
        throw new NullPointerException("builder.name == null");
    }
}
