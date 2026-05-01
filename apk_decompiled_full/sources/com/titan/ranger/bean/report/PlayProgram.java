package com.titan.ranger.bean.report;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;

/* loaded from: classes3.dex */
public class PlayProgram {
    String app;
    String app_ver;
    String buss;
    long caton_count;
    long caton_duration;
    String cause;
    long duration;
    String episode;
    String from;
    int instance;
    String ip;
    String mac;
    long media_duration;
    String model;
    long prepare_spent;
    String program;
    String route_mac;
    String session;
    String sn;
    long start;
    long switch_count;
    String sys_ver;
    String titan_ver;
    String title;
    String uid;

    public String getApp() {
        return this.app;
    }

    public String getApp_ver() {
        return this.app_ver;
    }

    public String getBuss() {
        return this.buss;
    }

    public long getCaton_count() {
        return this.caton_count;
    }

    public long getCaton_duration() {
        return this.caton_duration;
    }

    public String getCause() {
        return this.cause;
    }

    public long getDuration() {
        return this.duration;
    }

    public String getEpisode() {
        return this.episode;
    }

    public String getFrom() {
        return this.from;
    }

    public int getInstance() {
        return this.instance;
    }

    public String getIp() {
        return this.ip;
    }

    public String getMac() {
        return this.mac;
    }

    public long getMedia_duration() {
        return this.media_duration;
    }

    public String getModel() {
        return this.model;
    }

    public long getPrepare_spent() {
        return this.prepare_spent;
    }

    public String getProgram() {
        return this.program;
    }

    public String getRoute_mac() {
        return this.route_mac;
    }

    public String getSession() {
        return this.session;
    }

    public String getSn() {
        return this.sn;
    }

    public long getStart() {
        return this.start;
    }

    public long getSwitch_count() {
        return this.switch_count;
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

    public String getUid() {
        return this.uid;
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

    public void setCaton_count(long j10) {
        this.caton_count = j10;
    }

    public void setCaton_duration(long j10) {
        this.caton_duration = j10;
    }

    public void setCause(String str) {
        this.cause = str;
    }

    public void setDuration(long j10) {
        this.duration = j10;
    }

    public void setEpisode(String str) {
        this.episode = str;
    }

    public void setFrom(String str) {
        this.from = str;
    }

    public void setInstance(int i10) {
        this.instance = i10;
    }

    public void setIp(String str) {
        this.ip = str;
    }

    public void setMac(String str) {
        this.mac = str;
    }

    public void setMedia_duration(long j10) {
        this.media_duration = j10;
    }

    public void setModel(String str) {
        this.model = str;
    }

    public void setPrepare_spent(long j10) {
        this.prepare_spent = j10;
    }

    public void setProgram(String str) {
        this.program = str;
    }

    public void setRoute_mac(String str) {
        this.route_mac = str;
    }

    public void setSession(String str) {
        this.session = str;
    }

    public void setSn(String str) {
        this.sn = str;
    }

    public void setStart(long j10) {
        this.start = j10;
    }

    public void setSwitch_count(long j10) {
        this.switch_count = j10;
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

    public void setUid(String str) {
        this.uid = str;
    }

    public String toString() {
        return "PlayProgram{app='" + this.app + "', app_ver='" + this.app_ver + "', titan_ver='" + this.titan_ver + "', uid='" + this.uid + "', sn='" + this.sn + "', model='" + this.model + "', sys_ver='" + this.sys_ver + "', ip='" + this.ip + "', mac='" + this.mac + "', route_mac='" + this.route_mac + "', instance=" + this.instance + ", program='" + this.program + "', title='" + this.title + "', episode='" + this.episode + "', buss='" + this.buss + "', session='" + this.session + "', cause='" + this.cause + "', from='" + this.from + "', duration=" + this.duration + ", start=" + this.start + ", switch_count=" + this.switch_count + ", media_duration=" + this.media_duration + ", prepare_spent=" + this.prepare_spent + ", caton_count=" + this.caton_count + ", caton_duration=" + this.caton_duration + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
    }
}
