package com.hpplay.cybergarage.http;

import anet.channel.util.HttpConstant;
import com.hpplay.cybergarage.soap.SOAP;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.net.URL;

/* loaded from: classes2.dex */
public class HTTP {
    public static final String BOOTID_UPNP_ORG = "BOOTID.UPNP.ORG";
    public static final String CACHE_CONTROL = "Cache-Control";
    public static final String CALLBACK = "CALLBACK";
    public static final String CHARSET = "charset";
    public static final String CHUNKED = "Chunked";
    public static final String CLOSE = "close";
    public static final String CONNECTION = "Connection";
    public static final String CONTENT_LANGUAGE = "Content-Language";
    public static final String CONTENT_LENGTH = "Content-Length";
    public static final String CONTENT_RANGE = "Content-Range";
    public static final String CONTENT_RANGE_BYTES = "bytes";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final byte CR = 13;
    public static final String CRLF = "\r\n";
    public static final String DATE = "Date";
    public static final int DEFAULT_CHUNK_SIZE = 524288;
    public static final int DEFAULT_PORT = 80;
    public static final int DEFAULT_TIMEOUT = 30;
    public static final String EXT = "EXT";
    public static final String GET = "GET";
    public static final String HEAD = "HEAD";
    public static final String HEADER_LINE_DELIM = " :";
    public static final String HOST = "HOST";
    public static final String KEEP_ALIVE = "Keep-Alive";
    public static final byte LF = 10;
    public static final String LOCATION = "Location";
    public static final String MAN = "MAN";
    public static final String MAX_AGE = "max-age";
    public static final String MX = "MX";
    public static final String MYNAME = "MYNAME";
    public static final String M_SEARCH = "M-SEARCH";
    public static final String NOTIFY = "NOTIFY";
    public static final String NO_CACHE = "no-cache";
    public static final String NT = "NT";
    public static final String NTS = "NTS";
    public static final String OPT = "Opt";
    public static final String POST = "POST";
    public static final String RANGE = "Range";
    public static final String REQEST_LINE_DELIM = " ";
    public static final String SEQ = "SEQ";
    public static final String SERVER = "Server";
    public static final String SID = "SID";
    public static final String SOAP_ACTION = "SOAPACTION";
    public static final String ST = "ST";
    public static final String STATUS_LINE_DELIM = " ";
    public static final String SUBSCRIBE = "SUBSCRIBE";
    public static final String TAB = "\t";
    public static final String TIMEOUT = "TIMEOUT";
    public static final String TRANSFER_ENCODING = "Transfer-Encoding";
    public static final String UNSUBSCRIBE = "UNSUBSCRIBE";
    public static final String USER_AGENT = "User-Agent";
    public static final String USN = "USN";
    public static final String VERSION = "1.1";
    public static final String VERSION_10 = "1.1";
    public static final String VERSION_11 = "1.1";
    private static int chunkSize = 524288;

    public static final String getAbsoluteURL(String str, String str2) {
        try {
            URL url = new URL(str);
            return url.getProtocol() + HttpConstant.SCHEME_SPLIT + url.getHost() + SOAP.DELIM + url.getPort() + toRelativeURL(str2);
        } catch (Exception unused) {
            return "";
        }
    }

    public static final int getChunkSize() {
        return chunkSize;
    }

    public static final String getHost(String str) {
        try {
            return new URL(str).getHost();
        } catch (Exception unused) {
            return "";
        }
    }

    public static final int getPort(String str) {
        try {
            int port = new URL(str).getPort();
            if (port <= 0) {
                return 80;
            }
            return port;
        } catch (Exception unused) {
            return 80;
        }
    }

    public static final String getRequestHostURL(String str, int i10) {
        return "http://" + str + SOAP.DELIM + i10;
    }

    public static final boolean isAbsoluteURL(String str) {
        try {
            new URL(str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static final void setChunkSize(int i10) {
        chunkSize = i10;
    }

    public static final String toRelativeURL(String str, boolean z10) {
        if (!isAbsoluteURL(str)) {
            if (str.length() <= 0 || str.charAt(0) == '/') {
                return str;
            }
            return Operator.Operation.DIVISION + str;
        }
        try {
            URL url = new URL(str);
            String path = url.getPath();
            if (z10) {
                String query = url.getQuery();
                if (!query.equals("")) {
                    path = path + Operator.Operation.EMPTY_PARAM + query;
                }
            }
            return path.endsWith(Operator.Operation.DIVISION) ? path.substring(0, path.length() - 1) : path;
        } catch (Exception unused) {
            return str;
        }
    }

    public static final String toRelativeURL(String str) {
        return toRelativeURL(str, true);
    }
}
