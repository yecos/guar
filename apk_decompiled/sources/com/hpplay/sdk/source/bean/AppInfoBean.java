package com.hpplay.sdk.source.bean;

@Deprecated
/* loaded from: classes3.dex */
public class AppInfoBean {
    private String appID;
    private int manifestVer;
    private String name;
    private String pkg;
    private String version;

    public String getAppID() {
        return this.appID;
    }

    public int getManifestVer() {
        return this.manifestVer;
    }

    public String getName() {
        return this.name;
    }

    public String getPkg() {
        return this.pkg;
    }

    public String getVersion() {
        return this.version;
    }

    public void setAppID(String str) {
        this.appID = str;
    }

    public void setManifestVer(int i10) {
        this.manifestVer = i10;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPkg(String str) {
        this.pkg = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }
}
