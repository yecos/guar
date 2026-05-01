package com.hpplay.cybergarage.http;

import com.hpplay.component.common.utils.CLog;
import java.util.StringTokenizer;

/* loaded from: classes2.dex */
public class HTTPStatus {
    public static final int BAD_REQUEST = 400;
    public static final int CONTINUE = 100;
    public static final int INTERNAL_SERVER_ERROR = 510;
    public static final int INTERNAL_SERVER_ERROR2 = 600;
    public static final int INTERNAL_SERVER_IO_ERROR = 7000;
    public static final int INVALID_RANGE = 416;
    public static final int NOT_FOUND = 404;
    public static final int OK = 200;
    public static final int PARTIAL_CONTENT = 206;
    public static final int PRECONDITION_FAILED = 412;
    private static final String TAG = "Lelink-HTTPStatus";
    private String version = "";
    private int statusCode = 0;
    private String reasonPhrase = "";

    public HTTPStatus() {
        setVersion("");
        setStatusCode(0);
        setReasonPhrase("");
    }

    public static String code2String(int i10) {
        return i10 != 100 ? i10 != 200 ? i10 != 206 ? i10 != 400 ? i10 != 404 ? i10 != 412 ? i10 != 416 ? i10 != 510 ? i10 != 600 ? i10 != 7000 ? "" : "io write error" : "No route to host" : "Internal Server Error" : "Invalid Range" : "Precondition Failed" : "Not Found" : "Bad Request" : "Partial Content" : "OK" : "Continue";
    }

    public static final boolean isSuccessful(int i10) {
        return 200 <= i10 && i10 < 300;
    }

    public String getReasonPhrase() {
        return this.reasonPhrase;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getVersion() {
        return this.version;
    }

    public void set(String str) {
        int i10;
        if (str == null) {
            setVersion("1.1");
            setStatusCode(INTERNAL_SERVER_ERROR);
            setReasonPhrase(code2String(INTERNAL_SERVER_ERROR));
            return;
        }
        try {
            StringTokenizer stringTokenizer = new StringTokenizer(str, " ");
            if (stringTokenizer.hasMoreTokens()) {
                setVersion(stringTokenizer.nextToken().trim());
                if (stringTokenizer.hasMoreTokens()) {
                    try {
                        i10 = Integer.parseInt(stringTokenizer.nextToken());
                    } catch (Exception unused) {
                        i10 = 0;
                    }
                    setStatusCode(i10);
                    String str2 = "";
                    while (stringTokenizer.hasMoreTokens()) {
                        if (str2.length() >= 0) {
                            str2 = str2 + " ";
                        }
                        str2 = str2 + stringTokenizer.nextToken();
                    }
                    setReasonPhrase(str2.trim());
                }
            }
        } catch (Exception e10) {
            CLog.d(TAG, null, e10);
        }
    }

    public void setReasonPhrase(String str) {
        this.reasonPhrase = str;
    }

    public void setStatusCode(int i10) {
        this.statusCode = i10;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public boolean isSuccessful() {
        return isSuccessful(getStatusCode());
    }

    public HTTPStatus(String str, int i10, String str2) {
        setVersion(str);
        setStatusCode(i10);
        setReasonPhrase(str2);
    }

    public HTTPStatus(String str) {
        set(str);
    }
}
