package com.mobile.brasiltv.db;

import java.io.Serializable;
import sa.a;
import sa.e;
import sa.f;
import t9.g;
import t9.i;

@e(name = "subed_live_program")
/* loaded from: classes3.dex */
public final class LiveSubProgram implements Serializable {
    public static final Companion Companion = new Companion(null);

    @f
    private static final long serialVersionUID = 1;

    @a(column = "_pid")
    private String _pid = "";
    private String channelName = "";
    private String programName = "";
    private String type = "";
    private String startTime = "";
    private String endTime = "";

    @f
    private boolean isSub = true;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    public final String getChannelName() {
        return this.channelName;
    }

    public final String getEndTime() {
        return this.endTime;
    }

    public final String getProgramName() {
        return this.programName;
    }

    public final String getStartTime() {
        return this.startTime;
    }

    public final String getType() {
        return this.type;
    }

    public final String get_pid() {
        return this._pid;
    }

    public final boolean isSub() {
        return this.isSub;
    }

    public final void setChannelName(String str) {
        i.g(str, "<set-?>");
        this.channelName = str;
    }

    public final void setEndTime(String str) {
        i.g(str, "<set-?>");
        this.endTime = str;
    }

    public final void setProgramName(String str) {
        i.g(str, "<set-?>");
        this.programName = str;
    }

    public final void setStartTime(String str) {
        i.g(str, "<set-?>");
        this.startTime = str;
    }

    public final void setSub(boolean z10) {
        this.isSub = z10;
    }

    public final void setType(String str) {
        i.g(str, "<set-?>");
        this.type = str;
    }

    public final void set_pid(String str) {
        i.g(str, "<set-?>");
        this._pid = str;
    }
}
