package com.hpplay.a.a.a.c;

import com.google.android.gms.cast.MediaError;
import com.hpplay.component.protocol.push.IPushHandler;
import com.hpplay.cybergarage.upnp.UPnPStatus;
import com.hpplay.sdk.source.common.global.Constant;
import okhttp3.internal.http.StatusLine;

/* loaded from: classes2.dex */
public enum d implements b {
    SWITCH_PROTOCOL(101, IPushHandler.SP),
    OK(200, "OK"),
    CREATED(201, "Created"),
    ACCEPTED(202, "Accepted"),
    NO_CONTENT(204, "No Content"),
    PARTIAL_CONTENT(206, "Partial Content"),
    MULTI_STATUS(207, "Multi-Status"),
    REDIRECT(301, "Moved Permanently"),
    FOUND(302, "Found"),
    REDIRECT_SEE_OTHER(303, "See Other"),
    NOT_MODIFIED(304, "Not Modified"),
    TEMPORARY_REDIRECT(StatusLine.HTTP_TEMP_REDIRECT, "Temporary Redirect"),
    BAD_REQUEST(400, "Bad Request"),
    UNAUTHORIZED(401, "Unauthorized"),
    FORBIDDEN(UPnPStatus.OUT_OF_SYNC, "Forbidden"),
    NOT_FOUND(404, "Not Found"),
    METHOD_NOT_ALLOWED(405, "Method Not Allowed"),
    NOT_ACCEPTABLE(406, "Not Acceptable"),
    REQUEST_TIMEOUT(408, "Request Timeout"),
    CONFLICT(409, "Conflict"),
    GONE(Constant.TOKEN_EXPIRED, "Gone"),
    LENGTH_REQUIRED(MediaError.DetailedErrorCode.HLS_MANIFEST_MASTER, "Length Required"),
    PRECONDITION_FAILED(412, "Precondition Failed"),
    PAYLOAD_TOO_LARGE(413, "Payload Too Large"),
    UNSUPPORTED_MEDIA_TYPE(415, "Unsupported Media Type"),
    RANGE_NOT_SATISFIABLE(416, "Requested Range Not Satisfiable"),
    EXPECTATION_FAILED(417, "Expectation Failed"),
    TOO_MANY_REQUESTS(429, "Too Many Requests"),
    INTERNAL_ERROR(500, "Internal Server Error"),
    NOT_IMPLEMENTED(UPnPStatus.ACTION_FAILED, "Not Implemented"),
    SERVICE_UNAVAILABLE(503, "Service Unavailable"),
    UNSUPPORTED_HTTP_VERSION(505, "HTTP Version Not Supported");

    private final int G;
    private final String H;

    d(int i10, String str) {
        this.G = i10;
        this.H = str;
    }

    public static d a(int i10) {
        for (d dVar : values()) {
            if (dVar.b() == i10) {
                return dVar;
            }
        }
        return null;
    }

    @Override // com.hpplay.a.a.a.c.b
    public int b() {
        return this.G;
    }

    @Override // com.hpplay.a.a.a.c.b
    public String a() {
        return "" + this.G + " " + this.H;
    }
}
