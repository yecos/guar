package com.hpplay.cybergarage.upnp.xml;

import com.hpplay.cybergarage.upnp.control.QueryListener;
import com.hpplay.cybergarage.upnp.control.QueryResponse;

/* loaded from: classes2.dex */
public class StateVariableData extends NodeData {
    private String value = "";
    private QueryListener queryListener = null;
    private QueryResponse queryRes = null;

    public QueryListener getQueryListener() {
        return this.queryListener;
    }

    public QueryResponse getQueryResponse() {
        return this.queryRes;
    }

    public String getValue() {
        return this.value;
    }

    public void setQueryListener(QueryListener queryListener) {
        this.queryListener = queryListener;
    }

    public void setQueryResponse(QueryResponse queryResponse) {
        this.queryRes = queryResponse;
    }

    public void setValue(String str) {
        this.value = str;
    }
}
