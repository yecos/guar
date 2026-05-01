package com.titans.entity;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;

/* loaded from: classes3.dex */
public class PlayInfo {
    int Status;
    String app_ctx;
    long archive_bytes;
    String auth;
    long buffer_bytes;
    long buffer_duration;
    String cache;
    String dashboard;
    long delay;
    String desc;
    long expire_bytes;
    long express;
    String format;
    long gop_duration;
    String group;
    long in_latency;
    String lang;
    String license;
    String live_pcdn_mode;
    String local_ip;
    String media;
    long media_duration;
    String media_encrypt;
    long media_spent;
    String media_url;
    long out_latency;
    long p2p_err;
    String p2p_mode;
    long peer_num;
    long play_duration;
    String play_url;
    String player;
    int priority;
    String program;
    String protocol;
    String quality;
    long recv30s;
    long recv_bytes;
    long recv_duration;
    long recv_peer_bytes;
    long recv_server_bytes;
    long recvx30s;
    long rtt;
    String rule_id_code;
    long schedule_spent;
    long send_peer_bytes;
    long send_player_bytes;
    int serial;
    String server_code;
    String slb_code;
    String snapinfo_url;
    String snapshot_queue;
    String snapshot_url;
    int source_count;
    String source_id_code;
    String source_url;
    int source_weight_in_use;
    String tag;
    long total_recv_peer_bytes;
    long total_recv_server_bytes;
    long total_send_peer_bytes;
    String trans_id;
    String user_id;
    String video_codec;

    public PlayInfo clonePlayInfo() {
        PlayInfo playInfo = new PlayInfo();
        playInfo.program = this.program;
        playInfo.desc = this.desc;
        playInfo.media = this.media;
        playInfo.protocol = this.protocol;
        playInfo.format = this.format;
        playInfo.video_codec = this.video_codec;
        playInfo.player = this.player;
        playInfo.tag = this.tag;
        playInfo.source_url = this.source_url;
        playInfo.quality = this.quality;
        playInfo.lang = this.lang;
        playInfo.trans_id = this.trans_id;
        playInfo.media_url = this.media_url;
        playInfo.snapinfo_url = this.snapinfo_url;
        playInfo.snapshot_url = this.snapshot_url;
        playInfo.snapshot_queue = this.snapshot_queue;
        playInfo.auth = this.auth;
        playInfo.license = this.license;
        playInfo.slb_code = this.slb_code;
        playInfo.live_pcdn_mode = this.live_pcdn_mode;
        playInfo.server_code = this.server_code;
        playInfo.play_url = this.play_url;
        playInfo.app_ctx = this.app_ctx;
        playInfo.dashboard = this.dashboard;
        playInfo.group = this.group;
        playInfo.p2p_mode = this.p2p_mode;
        playInfo.user_id = this.user_id;
        playInfo.local_ip = this.local_ip;
        playInfo.media_encrypt = this.media_encrypt;
        playInfo.gop_duration = this.gop_duration;
        playInfo.source_count = this.source_count;
        playInfo.priority = this.priority;
        playInfo.serial = this.serial;
        playInfo.Status = this.Status;
        playInfo.schedule_spent = this.schedule_spent;
        playInfo.media_spent = this.media_spent;
        playInfo.media_duration = this.media_duration;
        playInfo.play_duration = this.play_duration;
        playInfo.recv_duration = this.recv_duration;
        playInfo.recv_bytes = this.recv_bytes;
        playInfo.archive_bytes = this.archive_bytes;
        playInfo.expire_bytes = this.expire_bytes;
        playInfo.recv30s = this.recv30s;
        playInfo.recvx30s = this.recvx30s;
        playInfo.express = this.express;
        playInfo.p2p_err = this.p2p_err;
        playInfo.recv_peer_bytes = this.recv_peer_bytes;
        playInfo.send_peer_bytes = this.send_peer_bytes;
        playInfo.send_player_bytes = this.send_player_bytes;
        playInfo.total_recv_peer_bytes = this.total_recv_peer_bytes;
        playInfo.total_send_peer_bytes = this.total_send_peer_bytes;
        playInfo.recv_server_bytes = this.recv_server_bytes;
        playInfo.total_recv_server_bytes = this.total_recv_server_bytes;
        playInfo.peer_num = this.peer_num;
        playInfo.buffer_duration = this.buffer_duration;
        playInfo.buffer_bytes = this.buffer_bytes;
        playInfo.in_latency = this.in_latency;
        playInfo.out_latency = this.out_latency;
        playInfo.rtt = this.rtt;
        playInfo.delay = this.delay;
        return playInfo;
    }

    public String getApp_ctx() {
        return this.app_ctx;
    }

    public long getArchive_bytes() {
        return this.archive_bytes;
    }

    public String getAuth() {
        return this.auth;
    }

    public long getBuffer_bytes() {
        return this.buffer_bytes;
    }

    public long getBuffer_duration() {
        return this.buffer_duration;
    }

    public String getCache() {
        return this.cache;
    }

    public String getDashboard() {
        return this.dashboard;
    }

    public long getDelay() {
        return this.delay;
    }

    public String getDesc() {
        return this.desc;
    }

    public long getExpire_bytes() {
        return this.expire_bytes;
    }

    public long getExpress() {
        return this.express;
    }

    public String getFormat() {
        return this.format;
    }

    public long getGop_duration() {
        return this.gop_duration;
    }

    public String getGroup() {
        return this.group;
    }

    public long getIn_latency() {
        return this.in_latency;
    }

    public String getLang() {
        return this.lang;
    }

    public String getLicense() {
        return this.license;
    }

    public String getLive_pcdn_mode() {
        return this.live_pcdn_mode;
    }

    public String getLocal_ip() {
        return this.local_ip;
    }

    public String getMedia() {
        return this.media;
    }

    public long getMedia_duration() {
        return this.media_duration;
    }

    public String getMedia_encrypt() {
        return this.media_encrypt;
    }

    public long getMedia_spent() {
        return this.media_spent;
    }

    public String getMedia_url() {
        return this.media_url;
    }

    public long getOut_latency() {
        return this.out_latency;
    }

    public long getP2p_err() {
        return this.p2p_err;
    }

    public String getP2p_mode() {
        return this.p2p_mode;
    }

    public long getPeer_num() {
        return this.peer_num;
    }

    public long getPlay_duration() {
        return this.play_duration;
    }

    public String getPlay_url() {
        return this.play_url;
    }

    public String getPlayer() {
        return this.player;
    }

    public int getPriority() {
        return this.priority;
    }

    public String getProgram() {
        return this.program;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public String getQuality() {
        return this.quality;
    }

    public long getRecv30s() {
        return this.recv30s;
    }

    public long getRecv_bytes() {
        return this.recv_bytes;
    }

    public long getRecv_duration() {
        return this.recv_duration;
    }

    public long getRecv_peer_bytes() {
        return this.recv_peer_bytes;
    }

    public long getRecv_server_bytes() {
        return this.recv_server_bytes;
    }

    public long getRecvx30s() {
        return this.recvx30s;
    }

    public long getRtt() {
        return this.rtt;
    }

    public String getRule_id_code() {
        return this.rule_id_code;
    }

    public long getSchedule_spent() {
        return this.schedule_spent;
    }

    public long getSend_peer_bytes() {
        return this.send_peer_bytes;
    }

    public long getSend_player_bytes() {
        return this.send_player_bytes;
    }

    public int getSerial() {
        return this.serial + 1;
    }

    public String getServer_code() {
        return this.server_code;
    }

    public String getSlb_code() {
        return this.slb_code;
    }

    public String getSnapinfo_url() {
        return this.snapinfo_url;
    }

    public String getSnapshot_queue() {
        return this.snapshot_queue;
    }

    public String getSnapshot_url() {
        return this.snapshot_url;
    }

    public int getSource_count() {
        return this.source_count;
    }

    public String getSource_id_code() {
        return this.source_id_code;
    }

    public String getSource_url() {
        return this.source_url;
    }

    public int getSource_weight_in_use() {
        return this.source_weight_in_use;
    }

    public int getStatus() {
        return this.Status;
    }

    public String getTag() {
        return this.tag;
    }

    public long getTotal_recv_peer_bytes() {
        return this.total_recv_peer_bytes;
    }

    public long getTotal_recv_server_bytes() {
        return this.total_recv_server_bytes;
    }

    public long getTotal_send_peer_bytes() {
        return this.total_send_peer_bytes;
    }

    public String getTrans_id() {
        return this.trans_id;
    }

    public String getUser_id() {
        return this.user_id;
    }

    public String getVideo_codec() {
        return this.video_codec;
    }

    public void setApp_ctx(String str) {
        this.app_ctx = str;
    }

    public void setArchive_bytes(long j10) {
        this.archive_bytes = j10;
    }

    public void setAuth(String str) {
        this.auth = str;
    }

    public void setBuffer_bytes(long j10) {
        this.buffer_bytes = j10;
    }

    public void setBuffer_duration(long j10) {
        this.buffer_duration = j10;
    }

    public void setCache(String str) {
        this.cache = str;
    }

    public void setDashboard(String str) {
        this.dashboard = str;
    }

    public void setDelay(long j10) {
        this.delay = j10;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setExpire_bytes(long j10) {
        this.expire_bytes = j10;
    }

    public void setExpress(int i10) {
        this.express = i10;
    }

    public void setFormat(String str) {
        this.format = str;
    }

    public void setGop_duration(long j10) {
        this.gop_duration = j10;
    }

    public void setGroup(String str) {
        this.group = str;
    }

    public void setIn_latency(long j10) {
        this.in_latency = j10;
    }

    public void setLang(String str) {
        this.lang = str;
    }

    public void setLicense(String str) {
        this.license = str;
    }

    public void setLive_pcdn_mode(String str) {
        this.live_pcdn_mode = str;
    }

    public void setLocal_ip(String str) {
        this.local_ip = str;
    }

    public void setMedia(String str) {
        this.media = str;
    }

    public void setMedia_duration(long j10) {
        this.media_duration = j10;
    }

    public void setMedia_encrypt(String str) {
        this.media_encrypt = str;
    }

    public void setMedia_spent(long j10) {
        this.media_spent = j10;
    }

    public void setMedia_url(String str) {
        this.media_url = str;
    }

    public void setOut_latency(long j10) {
        this.out_latency = j10;
    }

    public void setP2p_err(long j10) {
        this.p2p_err = j10;
    }

    public void setP2p_mode(String str) {
        this.p2p_mode = str;
    }

    public void setPeer_num(long j10) {
        this.peer_num = j10;
    }

    public void setPlay_duration(long j10) {
        this.play_duration = j10;
    }

    public void setPlay_url(String str) {
        this.play_url = str;
    }

    public void setPlayer(String str) {
        this.player = str;
    }

    public void setPriority(int i10) {
        this.priority = i10;
    }

    public void setProgram(String str) {
        this.program = str;
    }

    public void setProtocol(String str) {
        this.protocol = str;
    }

    public void setQuality(String str) {
        this.quality = str;
    }

    public void setRecv30s(long j10) {
        this.recv30s = j10;
    }

    public void setRecv_bytes(long j10) {
        this.recv_bytes = j10;
    }

    public void setRecv_duration(long j10) {
        this.recv_duration = j10;
    }

    public void setRecv_peer_bytes(long j10) {
        this.recv_peer_bytes = j10;
    }

    public void setRecv_server_bytes(long j10) {
        this.recv_server_bytes = j10;
    }

    public void setRecvx30s(long j10) {
        this.recvx30s = j10;
    }

    public void setRtt(long j10) {
        this.rtt = j10;
    }

    public void setRule_id_code(String str) {
        this.rule_id_code = str;
    }

    public void setSchedule_spent(long j10) {
        this.schedule_spent = j10;
    }

    public void setSend_peer_bytes(long j10) {
        this.send_peer_bytes = j10;
    }

    public void setSend_player_bytes(long j10) {
        this.send_player_bytes = j10;
    }

    public void setSerial(int i10) {
        this.serial = i10;
    }

    public void setServer_code(String str) {
        this.server_code = str;
    }

    public void setSlb_code(String str) {
        this.slb_code = str;
    }

    public void setSnapinfo_url(String str) {
        this.snapinfo_url = str;
    }

    public void setSnapshot_queue(String str) {
        this.snapshot_queue = str;
    }

    public void setSnapshot_url(String str) {
        this.snapshot_url = str;
    }

    public void setSource_count(int i10) {
        this.source_count = i10;
    }

    public void setSource_id_code(String str) {
        this.source_id_code = str;
    }

    public void setSource_url(String str) {
        this.source_url = str;
    }

    public void setSource_weights_in_use(int i10) {
        this.source_weight_in_use = i10;
    }

    public void setStatus(int i10) {
        this.Status = i10;
    }

    public void setTag(String str) {
        this.tag = str;
    }

    public void setTotal_recv_peer_bytes(long j10) {
        this.total_recv_peer_bytes = j10;
    }

    public void setTotal_recv_server_bytes(long j10) {
        this.total_recv_server_bytes = j10;
    }

    public void setTotal_send_peer_bytes(long j10) {
        this.total_send_peer_bytes = j10;
    }

    public void setTrans_id(String str) {
        this.trans_id = str;
    }

    public void setUser_id(String str) {
        this.user_id = str;
    }

    public void setVideo_codec(String str) {
        this.video_codec = str;
    }

    public String toString() {
        return "PlayInfo{program='" + this.program + "', desc='" + this.desc + "', media='" + this.media + "', protocol='" + this.protocol + "', format='" + this.format + "', video_codec='" + this.video_codec + "', player='" + this.player + "', tag='" + this.tag + "', source_url='" + this.source_url + "', quality='" + this.quality + "', lang='" + this.lang + "', trans_id='" + this.trans_id + "', media_url='" + this.media_url + "', snapinfo_url='" + this.snapinfo_url + "', snapshot_url='" + this.snapshot_url + "', snapshot_queue='" + this.snapshot_queue + "', auth='" + this.auth + "', license='" + this.license + "', slb_code='" + this.slb_code + "', live_pcdn_mode='" + this.live_pcdn_mode + "', server_code='" + this.server_code + "', play_url='" + this.play_url + "', app_ctx='" + this.app_ctx + "', dashboard='" + this.dashboard + "', group='" + this.group + "', p2p_mode='" + this.p2p_mode + "', user_id='" + this.user_id + "', local_ip='" + this.local_ip + "', media_encrypt='" + this.media_encrypt + "', gop_duration=" + this.gop_duration + ", source_count=" + this.source_count + ", priority=" + this.priority + ", serial=" + this.serial + ", Status=" + this.Status + ", schedule_spent=" + this.schedule_spent + ", media_spent=" + this.media_spent + ", media_duration=" + this.media_duration + ", play_duration=" + this.play_duration + ", recv_duration=" + this.recv_duration + ", recv_bytes=" + this.recv_bytes + ", archive_bytes=" + this.archive_bytes + ", expire_bytes=" + this.expire_bytes + ", recv30s=" + this.recv30s + ", recvx30s=" + this.recvx30s + ", express=" + this.express + ", p2p_err=" + this.p2p_err + ", recv_peer_bytes=" + this.recv_peer_bytes + ", send_peer_bytes=" + this.send_peer_bytes + ", send_player_bytes=" + this.send_player_bytes + ", total_recv_peer_bytes=" + this.total_recv_peer_bytes + ", total_send_peer_bytes=" + this.total_send_peer_bytes + ", recv_server_bytes=" + this.recv_server_bytes + ", total_recv_server_bytes=" + this.total_recv_server_bytes + ", peer_num=" + this.peer_num + ", buffer_duration=" + this.buffer_duration + ", buffer_bytes=" + this.buffer_bytes + ", in_latency=" + this.in_latency + ", out_latency=" + this.out_latency + ", rtt=" + this.rtt + ", cache=" + this.cache + ", source_id_code=" + this.source_id_code + ", rule_id_code=" + this.rule_id_code + ", source_weights_in_use=" + this.source_weight_in_use + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
    }

    public void setExpress(long j10) {
        this.express = j10;
    }
}
