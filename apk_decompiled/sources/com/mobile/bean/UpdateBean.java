package com.mobile.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class UpdateBean implements Serializable {
    private int appDownloadCount;
    private int appStar;
    private String defaultDownloadUrl;
    private int forceUpdate;
    private String icon;
    private int id;
    private String img;
    private String md5;
    private int minSdk;
    private String name;
    private String note;
    private String packageName;
    private String spareUrl;
    private String url;
    private int versionCode;
    private String versionName;

    public int getAppDownloadCount() {
        return this.appDownloadCount;
    }

    public int getAppStar() {
        return this.appStar;
    }

    public String getDefaultDownloadUrl() {
        return this.defaultDownloadUrl;
    }

    public int getForceUpdate() {
        return this.forceUpdate;
    }

    public String getIcon() {
        return this.icon;
    }

    public int getId() {
        return this.id;
    }

    public String getImg() {
        return this.img;
    }

    public String getMd5() {
        return this.md5;
    }

    public int getMinSdk() {
        return this.minSdk;
    }

    public String getName() {
        return this.name;
    }

    public String getNote() {
        return this.note;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getSpareUrl() {
        return this.spareUrl;
    }

    public String getUrl() {
        return this.url;
    }

    public int getVersionCode() {
        return this.versionCode;
    }

    public String getVersionName() {
        return this.versionName;
    }

    public void setAppDownloadCount(int i10) {
        this.appDownloadCount = i10;
    }

    public void setAppStar(int i10) {
        this.appStar = i10;
    }

    public void setDefaultDownloadUrl(String str) {
        this.defaultDownloadUrl = str;
    }

    public void setForceUpdate(int i10) {
        this.forceUpdate = i10;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setId(int i10) {
        this.id = i10;
    }

    public void setImg(String str) {
        this.img = str;
    }

    public void setMd5(String str) {
        this.md5 = str;
    }

    public void setMinSdk(int i10) {
        this.minSdk = i10;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNote(String str) {
        this.note = str;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setSpareUrl(String str) {
        this.spareUrl = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setVersionCode(int i10) {
        this.versionCode = i10;
    }

    public void setVersionName(String str) {
        this.versionName = str;
    }

    public String toString() {
        return "UpdateBean{id=" + this.id + ", name='" + this.name + "', appDownloadCount=" + this.appDownloadCount + ", packageName='" + this.packageName + "', icon='" + this.icon + "', versionName='" + this.versionName + "', versionCode=" + this.versionCode + ", minSdk=" + this.minSdk + ", img='" + this.img + "', url='" + this.url + "', spareUrl='" + this.spareUrl + "', appStar=" + this.appStar + ", note='" + this.note + "', forceUpdate=" + this.forceUpdate + ", md5='" + this.md5 + "', defaultDownloadUrl='" + this.defaultDownloadUrl + '\'' + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
    }
}
