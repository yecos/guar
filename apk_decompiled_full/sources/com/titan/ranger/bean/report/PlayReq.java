package com.titan.ranger.bean.report;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;

/* loaded from: classes3.dex */
public class PlayReq {
    String app;
    String app_ver;
    long bandwidth;
    long buffer;
    String cache;
    String cdn_type;
    long content_length;
    String dns;
    long duration;
    String group;
    String host;
    String host_ip;
    String idc;
    String ip;
    String link;
    String media;
    String model;
    String net_type;
    String protocol;
    String sn;
    String sys_ver;
    String titan_ver;
    String uid;

    public String getApp() {
        return this.app;
    }

    public String getApp_ver() {
        return this.app_ver;
    }

    public long getBandwidth() {
        return this.bandwidth;
    }

    public long getBuffer() {
        return this.buffer;
    }

    public String getCache() {
        return this.cache;
    }

    public String getCdn_type() {
        return this.cdn_type;
    }

    public long getContent_length() {
        return this.content_length;
    }

    public String getDns() {
        return this.dns;
    }

    public long getDuration() {
        return this.duration;
    }

    public String getGroup() {
        return this.group;
    }

    public String getHost() {
        return this.host;
    }

    public String getHost_ip() {
        return this.host_ip;
    }

    public String getIdc() {
        return this.idc;
    }

    public String getIp() {
        return this.ip;
    }

    public String getLink() {
        return this.link;
    }

    public String getMedia() {
        return this.media;
    }

    public String getModel() {
        return this.model;
    }

    public String getNet_type() {
        return this.net_type;
    }

    public String getProtocol() {
        return this.protocol;
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

    public String getUid() {
        return this.uid;
    }

    public void setApp(String str) {
        this.app = str;
    }

    public void setApp_ver(String str) {
        this.app_ver = str;
    }

    public void setBandwidth(long j10) {
        this.bandwidth = j10;
    }

    public void setBuffer(long j10) {
        this.buffer = j10;
    }

    public void setCache(String str) {
        this.cache = str;
    }

    public void setCdn_type(String str) {
        this.cdn_type = str;
    }

    public void setContent_length(long j10) {
        this.content_length = j10;
    }

    public void setDns(String str) {
        this.dns = str;
    }

    public void setDuration(long j10) {
        this.duration = j10;
    }

    public void setGroup(String str) {
        this.group = str;
    }

    public void setHost(String str) {
        this.host = str;
    }

    public void setHost_ip(String str) {
        this.host_ip = str;
    }

    public void setIdc(String str) {
        this.idc = str;
    }

    public void setIp(String str) {
        this.ip = str;
    }

    public void setLink(String str) {
        this.link = str;
    }

    public void setMedia(String str) {
        this.media = str;
    }

    public void setModel(String str) {
        this.model = str;
    }

    public void setNet_type(String str) {
        this.net_type = str;
    }

    public void setProtocol(String str) {
        this.protocol = str;
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

    public void setUid(String str) {
        this.uid = str;
    }

    public String toString() {
        return "PlayReq{app='" + this.app + "', app_ver='" + this.app_ver + "', titan_ver='" + this.titan_ver + "', uid='" + this.uid + "', sn='" + this.sn + "', model='" + this.model + "', sys_ver='" + this.sys_ver + "', ip='" + this.ip + "', media='" + this.media + "', link='" + this.link + "', cdn_type='" + this.cdn_type + "', group='" + this.group + "', host='" + this.host + "', idc='" + this.idc + "', dns='" + this.dns + "', host_ip='" + this.host_ip + "', net_type='" + this.net_type + "', protocol='" + this.protocol + "', cache='" + this.cache + "', duration=" + this.duration + ", content_length=" + this.content_length + ", bandwidth=" + this.bandwidth + ", buffer=" + this.buffer + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
    }
}
