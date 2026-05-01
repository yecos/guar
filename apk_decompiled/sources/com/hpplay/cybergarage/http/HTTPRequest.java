package com.hpplay.cybergarage.http;

import com.hpplay.component.common.utils.CLog;
import java.io.InputStream;
import java.net.Socket;
import java.util.StringTokenizer;

/* loaded from: classes2.dex */
public class HTTPRequest extends HTTPPacket {
    public static final int DEFAULT_TIMEOUT = 10000;
    private static final String NO_HOST = "No route to host";
    private static final String TAG = "HTTPRequest";
    private HTTPSocket httpSocket;
    private String method;
    private Socket postSocket;
    private String requestHost;
    private int requestPort;
    private String uri;

    public HTTPRequest() {
        this.method = null;
        this.uri = null;
        this.requestHost = "";
        this.requestPort = -1;
        this.httpSocket = null;
        this.postSocket = null;
        setVersion("1.1");
    }

    public String getFirstLineString() {
        return getMethod() + " " + getURI() + " " + getHTTPVersion() + "\r\n";
    }

    public String getHTTPVersion() {
        if (hasFirstLine()) {
            return getFirstLineToken(2);
        }
        return "HTTP/" + super.getVersion();
    }

    public String getHeader() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(getFirstLineString());
        stringBuffer.append(getHeaderString());
        return stringBuffer.toString();
    }

    public String getLocalAddress() {
        return getSocket().getLocalAddress();
    }

    public int getLocalPort() {
        return getSocket().getLocalPort();
    }

    public String getMethod() {
        String str = this.method;
        return str != null ? str : getFirstLineToken(0);
    }

    public ParameterList getParameterList() {
        ParameterList parameterList = new ParameterList();
        String uri = getURI();
        if (uri == null) {
            return parameterList;
        }
        int indexOf = uri.indexOf(63);
        if (indexOf < 0) {
            return parameterList;
        }
        while (indexOf > 0) {
            int i10 = indexOf + 1;
            int indexOf2 = uri.indexOf(61, i10);
            String substring = uri.substring(i10, indexOf2);
            int i11 = indexOf2 + 1;
            int indexOf3 = uri.indexOf(38, i11);
            parameterList.add(new Parameter(substring, uri.substring(i11, indexOf3 > 0 ? indexOf3 : uri.length())));
            indexOf = indexOf3;
        }
        return parameterList;
    }

    public String getParameterValue(String str) {
        return getParameterList().getValue(str);
    }

    public String getRequestHost() {
        return this.requestHost;
    }

    public int getRequestPort() {
        return this.requestPort;
    }

    public HTTPSocket getSocket() {
        return this.httpSocket;
    }

    public String getURI() {
        String str = this.uri;
        return str != null ? str : getFirstLineToken(1);
    }

    public boolean isGetRequest() {
        return isMethod("GET");
    }

    public boolean isHeadRequest() {
        return isMethod("HEAD");
    }

    public boolean isKeepAlive() {
        if (isCloseConnection()) {
            return false;
        }
        if (isKeepAliveConnection()) {
            return true;
        }
        return !(getHTTPVersion().indexOf("1.0") > 0);
    }

    public boolean isMethod(String str) {
        String method = getMethod();
        if (method == null) {
            return false;
        }
        return method.equalsIgnoreCase(str);
    }

    public boolean isNotifyRequest() {
        return isMethod(HTTP.NOTIFY);
    }

    public boolean isPostRequest() {
        return isMethod("POST");
    }

    public boolean isSOAPAction() {
        return hasHeader(HTTP.SOAP_ACTION);
    }

    public boolean isSubscribeRequest() {
        return isMethod("SUBSCRIBE");
    }

    public boolean isUnsubscribeRequest() {
        return isMethod("UNSUBSCRIBE");
    }

    public boolean parseRequestLine(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, " ");
        if (!stringTokenizer.hasMoreTokens()) {
            return false;
        }
        setMethod(stringTokenizer.nextToken());
        if (!stringTokenizer.hasMoreTokens()) {
            return false;
        }
        setURI(stringTokenizer.nextToken());
        if (!stringTokenizer.hasMoreTokens()) {
            return false;
        }
        setVersion(stringTokenizer.nextToken());
        return true;
    }

    public boolean post(HTTPResponse hTTPResponse) {
        long j10;
        HTTPSocket socket = getSocket();
        long contentLength = hTTPResponse.getContentLength();
        long j11 = 0;
        if (hasContentRange()) {
            long contentRangeFirstPosition = getContentRangeFirstPosition();
            long contentRangeLastPosition = getContentRangeLastPosition();
            if (contentRangeLastPosition <= 0) {
                contentRangeLastPosition = contentLength - 1;
            }
            long j12 = contentRangeLastPosition;
            if (contentRangeFirstPosition > contentLength || j12 > contentLength) {
                return returnResponse(416);
            }
            j11 = contentRangeFirstPosition;
            hTTPResponse.setContentRange(j11, j12, contentLength);
            hTTPResponse.setStatusCode(206);
            j10 = (j12 - contentRangeFirstPosition) + 1;
        } else {
            j10 = contentLength;
        }
        return socket.post(hTTPResponse, j11, j10, isHeadRequest());
    }

    public void print() {
        CLog.d(TAG, toString());
    }

    public boolean read() {
        return super.read(getSocket());
    }

    public boolean returnBadRequest() {
        return returnResponse(400);
    }

    public boolean returnOK() {
        return returnResponse(200);
    }

    public boolean returnResponse(int i10) {
        HTTPResponse hTTPResponse = new HTTPResponse();
        hTTPResponse.setStatusCode(i10);
        hTTPResponse.setContentLength(0L);
        return post(hTTPResponse);
    }

    public void set(HTTPRequest hTTPRequest) {
        set((HTTPPacket) hTTPRequest);
        setSocket(hTTPRequest.getSocket());
    }

    public void setMethod(String str) {
        this.method = str;
    }

    public void setRequestHost(String str) {
        this.requestHost = str;
    }

    public void setRequestPort(int i10) {
        this.requestPort = i10;
    }

    public void setSocket(HTTPSocket hTTPSocket) {
        this.httpSocket = hTTPSocket;
    }

    public void setURI(String str, boolean z10) {
        this.uri = str;
        if (z10) {
            this.uri = HTTP.toRelativeURL(str);
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(getHeader());
        stringBuffer.append("\r\n");
        stringBuffer.append(getContentString());
        return stringBuffer.toString();
    }

    public void setURI(String str) {
        setURI(str, false);
    }

    public HTTPRequest(InputStream inputStream) {
        super(inputStream);
        this.method = null;
        this.uri = null;
        this.requestHost = "";
        this.requestPort = -1;
        this.httpSocket = null;
        this.postSocket = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00f4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x010d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.hpplay.cybergarage.http.HTTPResponse post(java.lang.String r11, int r12, boolean r13) {
        /*
            Method dump skipped, instructions count: 291
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.cybergarage.http.HTTPRequest.post(java.lang.String, int, boolean):com.hpplay.cybergarage.http.HTTPResponse");
    }

    public HTTPRequest(HTTPSocket hTTPSocket) {
        this(hTTPSocket.getInputStream());
        setSocket(hTTPSocket);
    }

    public HTTPResponse post(String str, int i10) {
        return post(str, i10, false);
    }
}
