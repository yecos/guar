package com.hpplay.sdk.source.bean;

import com.hpplay.common.utils.FieldUtil;
import com.hpplay.sdk.source.utils.JSONUtil;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DataBean {

    /* renamed from: a, reason: collision with root package name */
    public String f7433a;
    public String agent_port;
    public String airplay_port;
    public String extendStr;
    public String hostname;
    public String ip;
    public String link_port;

    /* renamed from: m, reason: collision with root package name */
    public String f7434m;
    public String mirror_port;
    public String name;
    public String port;
    public String pt;
    public String raop_port;
    public String remote_port;
    public String tmp;
    public String uid;
    public String version;

    public JSONObject toJson() {
        JSONObject commonBean2Json = JSONUtil.commonBean2Json(this);
        try {
            commonBean2Json.remove("m");
            commonBean2Json.put(FieldUtil.getString(FieldUtil.f7332m), this.f7434m);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return commonBean2Json;
    }
}
