package com.hpplay.cybergarage.upnp;

import com.hpplay.cybergarage.http.HTTPStatus;

/* loaded from: classes2.dex */
public class UPnPStatus {
    public static final int ACTION_FAILED = 501;
    public static final int INVALID_ACTION = 401;
    public static final int INVALID_ARGS = 402;
    public static final int INVALID_VAR = 404;
    public static final int OUT_OF_SYNC = 403;
    public static final int PRECONDITION_FAILED = 412;
    private int code;
    private String description;

    public UPnPStatus() {
        setCode(0);
        setDescription("");
    }

    public static final String code2String(int i10) {
        if (i10 == 412) {
            return "Precondition Failed";
        }
        if (i10 == 501) {
            return "Action Failed";
        }
        switch (i10) {
            case 401:
                return "Invalid Action";
            case 402:
                return "Invalid Args";
            case OUT_OF_SYNC /* 403 */:
                return "Out of Sync";
            case 404:
                return "Invalid Var";
            default:
                return HTTPStatus.code2String(i10);
        }
    }

    public int getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }

    public void setCode(int i10) {
        this.code = i10;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public UPnPStatus(int i10, String str) {
        setCode(i10);
        setDescription(str);
    }
}
