package com.bigbee.bean.request;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;

/* loaded from: classes.dex */
public class PlayFile {
    String app;
    String app_ver;
    String buss;
    long caton_count;
    long caton_duration;
    long duration;
    long err;
    String from;
    String ip;
    String media;
    String model;
    String net_type;
    String player;
    long player_repeat_req_count;
    long player_reset_count;
    long prepare_spent;
    String program;
    long read_cache_bytes;
    long recv_cache_bytes;
    long recv_origin_cdp_bytes;
    long recv_origin_tcp_bytes;
    long recv_peer_bytes;
    long send_peer_bytes;
    String sn;
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

    public long getDuration() {
        return this.duration;
    }

    public long getErr() {
        return this.err;
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

    public String getNet_type() {
        return this.net_type;
    }

    public String getPlayer() {
        return this.player;
    }

    public long getPlayer_repeat_req_count() {
        return this.player_repeat_req_count;
    }

    public long getPlayer_reset_count() {
        return this.player_reset_count;
    }

    public long getPrepare_spent() {
        return this.prepare_spent;
    }

    public String getProgram() {
        return this.program;
    }

    public long getRead_cache_bytes() {
        return this.read_cache_bytes;
    }

    public long getRecv_cache_bytes() {
        return this.recv_cache_bytes;
    }

    public long getRecv_origin_cdp_bytes() {
        return this.recv_origin_cdp_bytes;
    }

    public long getRecv_origin_tcp_bytes() {
        return this.recv_origin_tcp_bytes;
    }

    public long getRecv_peer_bytes() {
        return this.recv_peer_bytes;
    }

    public long getSend_peer_bytes() {
        return this.send_peer_bytes;
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

    public void setDuration(long j10) {
        this.duration = j10;
    }

    public void setErr(long j10) {
        this.err = j10;
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

    public void setNet_type(String str) {
        this.net_type = str;
    }

    public void setPlayer(String str) {
        this.player = str;
    }

    public void setPlayer_repeat_req_count(long j10) {
        this.player_repeat_req_count = j10;
    }

    public void setPlayer_reset_count(long j10) {
        this.player_reset_count = j10;
    }

    public void setPrepare_spent(long j10) {
        this.prepare_spent = j10;
    }

    public void setProgram(String str) {
        this.program = str;
    }

    public void setRead_cache_bytes(long j10) {
        this.read_cache_bytes = j10;
    }

    public void setRecv_cache_bytes(long j10) {
        this.recv_cache_bytes = j10;
    }

    public void setRecv_origin_cdp_bytes(long j10) {
        this.recv_origin_cdp_bytes = j10;
    }

    public void setRecv_origin_tcp_bytes(long j10) {
        this.recv_origin_tcp_bytes = j10;
    }

    public void setRecv_peer_bytes(long j10) {
        this.recv_peer_bytes = j10;
    }

    public void setSend_peer_bytes(long j10) {
        this.send_peer_bytes = j10;
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

    public void setUid(String str) {
        this.uid = str;
    }

    public String toString() {
        return "PlayFile{app='" + this.app + "', app_ver='" + this.app_ver + "', titan_ver='" + this.titan_ver + "', uid='" + this.uid + "', sn='" + this.sn + "', model='" + this.model + "', sys_ver='" + this.sys_ver + "', ip='" + this.ip + "', program='" + this.program + "', media='" + this.media + "', title='" + this.title + "', buss='" + this.buss + "', from='" + this.from + "', duration=" + this.duration + ", player='" + this.player + "', prepare_spent=" + this.prepare_spent + ", caton_count=" + this.caton_count + ", caton_duration=" + this.caton_duration + ", net_type='" + this.net_type + "', err=" + this.err + ", player_reset_count=" + this.player_reset_count + ", recv_cache_bytes=" + this.recv_cache_bytes + ", recv_peer_bytes=" + this.recv_peer_bytes + ", recv_origin_tcp_bytes=" + this.recv_origin_tcp_bytes + ", recv_origin_cdp_bytes=" + this.recv_origin_cdp_bytes + ", read_cache_bytes=" + this.read_cache_bytes + ", send_peer_bytes=" + this.send_peer_bytes + ", player_repeat_req_count=" + this.player_repeat_req_count + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
    }
}
