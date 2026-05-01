package com.hpplay.cybergarage.http;

import com.hpplay.component.common.utils.CLog;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
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
    */
    public HTTPResponse post(String str, int i10, boolean z10) {
        boolean z11;
        OutputStream outputStream;
        InputStream inputStream;
        Socket socket;
        Exception e10;
        OutputStream outputStream2;
        InputStream inputStream2;
        HTTPResponse hTTPResponse = new HTTPResponse();
        setHost(str);
        setConnection(z10 ? "Keep-Alive" : HTTP.CLOSE);
        boolean isHeadRequest = isHeadRequest();
        try {
            try {
                try {
                    Socket socket2 = new Socket();
                    this.postSocket = socket2;
                    socket2.connect(new InetSocketAddress(str, i10), 10000);
                    z11 = true;
                } catch (Throwable th) {
                    th = th;
                    outputStream = null;
                    inputStream = null;
                    if (!z10) {
                    }
                    throw th;
                }
            } catch (Exception e11) {
                try {
                    if (e11.toString().contains(NO_HOST)) {
                        hTTPResponse.setStatusCode(600);
                    } else {
                        hTTPResponse.setStatusCode(HTTPStatus.INTERNAL_SERVER_ERROR);
                    }
                    hTTPResponse.setContent(e11.toString());
                    z11 = false;
                } catch (Exception e12) {
                    e10 = e12;
                    outputStream = null;
                    inputStream = null;
                    try {
                        hTTPResponse.setStatusCode(HTTPStatus.INTERNAL_SERVER_IO_ERROR);
                        hTTPResponse.setContent(e10.toString());
                        CLog.w(TAG, e10);
                        if (!z10) {
                            try {
                                inputStream.close();
                            } catch (Exception unused) {
                            }
                            if (inputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (Exception unused2) {
                                }
                            }
                            if (outputStream != null) {
                                socket = this.postSocket;
                                socket.close();
                            }
                            this.postSocket = null;
                        }
                        return hTTPResponse;
                    } catch (Throwable th2) {
                        th = th2;
                        if (!z10) {
                            try {
                                inputStream.close();
                            } catch (Exception unused3) {
                            }
                            if (inputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (Exception unused4) {
                                }
                            }
                            if (outputStream != null) {
                                try {
                                    this.postSocket.close();
                                } catch (Exception unused5) {
                                }
                            }
                            this.postSocket = null;
                        }
                        throw th;
                    }
                }
            }
            if (z11) {
                outputStream2 = this.postSocket.getOutputStream();
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.append(getHeader());
                    sb.append("\r\n");
                    boolean isChunked = isChunked();
                    String contentString = getContentString();
                    int length = contentString != null ? contentString.length() : 0;
                    if (length > 0) {
                        if (isChunked) {
                            sb.append(Long.toHexString(length));
                            sb.append("\r\n");
                        }
                        sb.append(contentString);
                        if (isChunked) {
                            sb.append("\r\n");
                        }
                    }
                    if (isChunked) {
                        sb.append("0");
                        sb.append("\r\n");
                    }
                    outputStream2.write(sb.toString().getBytes());
                    outputStream2.flush();
                    inputStream2 = this.postSocket.getInputStream();
                    try {
                        hTTPResponse.set(inputStream2, isHeadRequest);
                    } catch (Exception e13) {
                        outputStream = outputStream2;
                        e10 = e13;
                        inputStream = inputStream2;
                        hTTPResponse.setStatusCode(HTTPStatus.INTERNAL_SERVER_IO_ERROR);
                        hTTPResponse.setContent(e10.toString());
                        CLog.w(TAG, e10);
                        if (!z10) {
                        }
                        return hTTPResponse;
                    } catch (Throwable th3) {
                        outputStream = outputStream2;
                        th = th3;
                        inputStream = inputStream2;
                        if (!z10) {
                        }
                        throw th;
                    }
                } catch (Exception e14) {
                    inputStream = null;
                    outputStream = outputStream2;
                    e10 = e14;
                } catch (Throwable th4) {
                    inputStream = null;
                    outputStream = outputStream2;
                    th = th4;
                }
            } else {
                outputStream2 = null;
                inputStream2 = null;
            }
        } catch (Exception unused6) {
        }
        if (!z10) {
            try {
                inputStream2.close();
            } catch (Exception unused7) {
            }
            if (inputStream2 != null) {
                try {
                    outputStream2.close();
                } catch (Exception unused8) {
                }
            }
            if (outputStream2 != null) {
                socket = this.postSocket;
                socket.close();
            }
            this.postSocket = null;
        }
        return hTTPResponse;
    }

    public HTTPRequest(HTTPSocket hTTPSocket) {
        this(hTTPSocket.getInputStream());
        setSocket(hTTPSocket);
    }

    public HTTPResponse post(String str, int i10) {
        return post(str, i10, false);
    }
}
