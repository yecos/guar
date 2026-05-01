package com.titan.ranger;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.List;

/* loaded from: classes3.dex */
public class Status {
    long buffer;
    String buss;
    String format;
    String host;
    long latency;
    List<String> links;
    String media;
    long media_buffer;
    String play_url;
    String program;
    String snapinfo_url;
    String snapshot_url;
    String title;
    boolean url_modified;

    public long getBuffer() {
        return this.buffer;
    }

    public String getBuss() {
        return this.buss;
    }

    public String getFormat() {
        return this.format;
    }

    public String getHost() {
        return this.host;
    }

    public long getLatency() {
        return this.latency;
    }

    public List<String> getLinks() {
        return this.links;
    }

    public String getMedia() {
        return this.media;
    }

    public long getMedia_buffer() {
        return this.media_buffer;
    }

    public String getPlay_url() {
        return this.play_url;
    }

    public String getProgram() {
        return this.program;
    }

    public String getSnapinfo_url() {
        return this.snapinfo_url;
    }

    public String getSnapshot_url() {
        return this.snapshot_url;
    }

    public String getTitle() {
        return this.title;
    }

    public boolean isUrl_modified() {
        return this.url_modified;
    }

    public void setBuffer(long j10) {
        this.buffer = j10;
    }

    public void setBuss(String str) {
        this.buss = str;
    }

    public void setFormat(String str) {
        this.format = str;
    }

    public void setHost(String str) {
        this.host = str;
    }

    public void setLatency(int i10) {
        this.latency = i10;
    }

    public void setLinks(List<String> list) {
        this.links = list;
    }

    public void setMedia(String str) {
        this.media = str;
    }

    public void setMedia_buffer(long j10) {
        this.media_buffer = j10;
    }

    public void setPlay_url(String str) {
        this.play_url = str;
    }

    public void setProgram(String str) {
        this.program = str;
    }

    public void setSnapinfo_url(String str) {
        this.snapinfo_url = str;
    }

    public void setSnapshot_url(String str) {
        this.snapshot_url = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUrl_modified(boolean z10) {
        this.url_modified = z10;
    }

    public String toString() {
        return "Status{program='" + this.program + "', buss='" + this.buss + "', title='" + this.title + "', media='" + this.media + "', links=" + this.links + ", latency=" + this.latency + ", buffer=" + this.buffer + ", play_url='" + this.play_url + "', snapshot_url='" + this.snapshot_url + "', snapinfo_url='" + this.snapinfo_url + "', host='" + this.host + "', url_modified=" + this.url_modified + ", format='" + this.format + "', media_buffer=" + this.media_buffer + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
    }
}
