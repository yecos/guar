package com.mobile.brasiltv.db;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import sa.a;
import sa.e;

@e(name = "links")
/* loaded from: classes3.dex */
public final class Links implements Serializable {
    private String contentId;
    private long duration;

    @a(column = "id")
    private int id;
    private int position;
    private long recordTime;
    private String title;

    public final String getContentId() {
        return this.contentId;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final int getId() {
        return this.id;
    }

    public final int getPosition() {
        return this.position;
    }

    public final long getRecordTime() {
        return this.recordTime;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setContentId(String str) {
        this.contentId = str;
    }

    public final void setDuration(long j10) {
        this.duration = j10;
    }

    public final void setId(int i10) {
        this.id = i10;
    }

    public final void setPosition(int i10) {
        this.position = i10;
    }

    public final void setRecordTime(long j10) {
        this.recordTime = j10;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        return "Links(id=" + this.id + ", contentId=" + this.contentId + ", recordTime=" + this.recordTime + ", position=" + this.position + ", title=" + this.title + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
