package com.bigbee.bean.request;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;

/* loaded from: classes.dex */
public class ProtocolExchange {
    long bit_rate;
    String buss;
    long cache;
    long cdp_band;
    long cdp_len;
    long data_already;
    String format;
    long interval;
    int loss_rate;
    String media;
    String net_type;
    String protocol;
    String quality;
    long rtt;
    long rtt_jitter;
    long server_sendbuf_len;
    long server_upband;
    long start_moment;
    long tcp_band;
    long tcp_len;

    public long getBit_rate() {
        return this.bit_rate;
    }

    public String getBuss() {
        return this.buss;
    }

    public long getCache() {
        return this.cache;
    }

    public long getCdp_band() {
        return this.cdp_band;
    }

    public long getCdp_len() {
        return this.cdp_len;
    }

    public long getData_already() {
        return this.data_already;
    }

    public String getFormat() {
        return this.format;
    }

    public long getInterval() {
        return this.interval;
    }

    public int getLoss_rate() {
        return this.loss_rate;
    }

    public String getMedia() {
        return this.media;
    }

    public String getNet_type() {
        return this.net_type;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public String getQuality() {
        return this.quality;
    }

    public long getRtt() {
        return this.rtt;
    }

    public long getRtt_jitter() {
        return this.rtt_jitter;
    }

    public long getServer_sendbuf_len() {
        return this.server_sendbuf_len;
    }

    public long getServer_upband() {
        return this.server_upband;
    }

    public long getStart_moment() {
        return this.start_moment;
    }

    public long getTcp_band() {
        return this.tcp_band;
    }

    public long getTcp_len() {
        return this.tcp_len;
    }

    public void setBit_rate(long j10) {
        this.bit_rate = j10;
    }

    public void setBuss(String str) {
        this.buss = str;
    }

    public void setCache(long j10) {
        this.cache = j10;
    }

    public void setCdp_band(long j10) {
        this.cdp_band = j10;
    }

    public void setCdp_len(long j10) {
        this.cdp_len = j10;
    }

    public void setData_already(long j10) {
        this.data_already = j10;
    }

    public void setFormat(String str) {
        this.format = str;
    }

    public void setInterval(long j10) {
        this.interval = j10;
    }

    public void setLoss_rate(int i10) {
        this.loss_rate = i10;
    }

    public void setMedia(String str) {
        this.media = str;
    }

    public void setNet_type(String str) {
        this.net_type = str;
    }

    public void setProtocol(String str) {
        this.protocol = str;
    }

    public void setQuality(String str) {
        this.quality = str;
    }

    public void setRtt(long j10) {
        this.rtt = j10;
    }

    public void setRtt_jitter(int i10) {
        this.rtt_jitter = i10;
    }

    public void setServer_sendbuf_len(long j10) {
        this.server_sendbuf_len = j10;
    }

    public void setServer_upband(long j10) {
        this.server_upband = j10;
    }

    public void setStart_moment(long j10) {
        this.start_moment = j10;
    }

    public void setTcp_band(long j10) {
        this.tcp_band = j10;
    }

    public void setTcp_len(long j10) {
        this.tcp_len = j10;
    }

    public String toString() {
        return "ProtocolExchange{start_moment=" + this.start_moment + ", buss='" + this.buss + "', media='" + this.media + "', quality='" + this.quality + "', format='" + this.format + "', bit_rate=" + this.bit_rate + ", cache=" + this.cache + ", net_type='" + this.net_type + "', interval=" + this.interval + ", protocol='" + this.protocol + "', tcp_band=" + this.tcp_band + ", cdp_band=" + this.cdp_band + ", rtt=" + this.rtt + ", rtt_jitter=" + this.rtt_jitter + ", loss_rate=" + this.loss_rate + ", server_upband=" + this.server_upband + ", server_sendbuf_len=" + this.server_sendbuf_len + ",data_already=" + this.data_already + ",tcp_len=" + this.tcp_len + ",cdp_len=" + this.cdp_len + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
    }
}
