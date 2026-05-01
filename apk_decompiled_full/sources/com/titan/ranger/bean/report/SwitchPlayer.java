package com.titan.ranger.bean.report;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;

/* loaded from: classes3.dex */
public class SwitchPlayer {
    String app;
    String app_ver;
    String buss;
    long err;
    String format;
    String from;
    String ip;
    String media;
    String model;
    String program;
    String sn;
    String sys_ver;
    String titan_ver;
    String title;
    String to;
    String uid;
    String vcodec;

    public String getApp() {
        return this.app;
    }

    public String getApp_ver() {
        return this.app_ver;
    }

    public String getBuss() {
        return this.buss;
    }

    public long getErr() {
        return this.err;
    }

    public String getFormat() {
        return this.format;
    }

    public String getFrom() {
        return this.from;
    }

    public String getIp() {
        return this.ip;
    }

    public String getMedia() {
        return this.media;
    }

    public String getModel() {
        return this.model;
    }

    public String getProgram() {
        return this.program;
    }

    public String getSn() {
        return this.sn;
    }

    public String getSys_ver() {
        return this.sys_ver;
    }

    public String getTitan_ver() {
        return this.titan_ver;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTo() {
        return this.to;
    }

    public String getUid() {
        return this.uid;
    }

    public String getVcodec() {
        return this.vcodec;
    }

    public void setApp(String str) {
        this.app = str;
    }

    public void setApp_ver(String str) {
        this.app_ver = str;
    }

    public void setBuss(String str) {
        this.buss = str;
    }

    public void setErr(long j10) {
        this.err = j10;
    }

    public void setFormat(String str) {
        this.format = str;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public void setIp(String str) {
        this.ip = str;
    }

    public void setMedia(String str) {
        this.media = str;
    }

    public void setModel(String str) {
        this.model = str;
    }

    public void setProgram(String str) {
        this.program = str;
    }

    public void setSn(String str) {
        this.sn = str;
    }

    public void setSys_ver(String str) {
        this.sys_ver = str;
    }

    public void setTitan_ver(String str) {
        this.titan_ver = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setTo(String str) {
        this.to = str;
    }

    public void setUid(String str) {
        this.uid = str;
    }

    public void setVcodec(String str) {
        this.vcodec = str;
    }

    public String toString() {
        return "SwitchPlayer{app='" + this.app + "', app_ver='" + this.app_ver + "', titan_ver='" + this.titan_ver + "', uid='" + this.uid + "', sn='" + this.sn + "', model='" + this.model + "', sys_ver='" + this.sys_ver + "', ip='" + this.ip + "', program='" + this.program + "', media='" + this.media + "', title='" + this.title + "', buss='" + this.buss + "', from='" + this.from + "', to='" + this.to + "', format='" + this.format + "', vcodec='" + this.vcodec + "', err=" + this.err + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
    }
}
