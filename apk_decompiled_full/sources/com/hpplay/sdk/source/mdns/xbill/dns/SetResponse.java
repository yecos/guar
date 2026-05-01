package com.hpplay.sdk.source.mdns.xbill.dns;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class SetResponse {
    private Object data;
    private int type;
    private static final SetResponse unknown = new SetResponse(0);
    private static final SetResponse nxdomain = new SetResponse(1);
    private static final SetResponse nxrrset = new SetResponse(2);

    private SetResponse() {
    }

    public static SetResponse ofType(int i10) {
        switch (i10) {
            case 0:
                return unknown;
            case 1:
                return nxdomain;
            case 2:
                return nxrrset;
            case 3:
            case 4:
            case 5:
            case 6:
                SetResponse setResponse = new SetResponse();
                setResponse.type = i10;
                setResponse.data = null;
                return setResponse;
            default:
                throw new IllegalArgumentException("invalid type");
        }
    }

    public void addRRset(RRset rRset) {
        if (this.data == null) {
            this.data = new ArrayList();
        }
        ((List) this.data).add(rRset);
    }

    public RRset[] answers() {
        if (this.type != 6) {
            return null;
        }
        List list = (List) this.data;
        return (RRset[]) list.toArray(new RRset[list.size()]);
    }

    public CNAMERecord getCNAME() {
        return (CNAMERecord) ((RRset) this.data).first();
    }

    public DNAMERecord getDNAME() {
        return (DNAMERecord) ((RRset) this.data).first();
    }

    public RRset getNS() {
        return (RRset) this.data;
    }

    public boolean isCNAME() {
        return this.type == 4;
    }

    public boolean isDNAME() {
        return this.type == 5;
    }

    public boolean isDelegation() {
        return this.type == 3;
    }

    public boolean isNXDOMAIN() {
        return this.type == 1;
    }

    public boolean isNXRRSET() {
        return this.type == 2;
    }

    public boolean isSuccessful() {
        return this.type == 6;
    }

    public boolean isUnknown() {
        return this.type == 0;
    }

    public String toString() {
        switch (this.type) {
            case 0:
                return "unknown";
            case 1:
                return "NXDOMAIN";
            case 2:
                return "NXRRSET";
            case 3:
                return "delegation: " + this.data;
            case 4:
                return "CNAME: " + this.data;
            case 5:
                return "DNAME: " + this.data;
            case 6:
                return "successful";
            default:
                throw new IllegalStateException();
        }
    }

    public SetResponse(int i10, RRset rRset) {
        if (i10 < 0 || i10 > 6) {
            throw new IllegalArgumentException("invalid type");
        }
        this.type = i10;
        this.data = rRset;
    }

    public SetResponse(int i10) {
        if (i10 >= 0 && i10 <= 6) {
            this.type = i10;
            this.data = null;
            return;
        }
        throw new IllegalArgumentException("invalid type");
    }
}
