package com.mobile.brasiltv.db;

import java.io.Serializable;
import sa.a;
import sa.e;
import t9.i;

@e(name = "subtitle_setting")
/* loaded from: classes3.dex */
public final class SubtitleSettingBean implements Serializable {

    @a(column = "id")
    private int id;
    private String contentId = "";
    private String subtitleLanguage = "";
    private int subtitleIndex = -1;
    private int subtitleSize = -1;
    private int subtitleStyle = -1;
    private String subtitleSwitch = "";

    public final String getContentId() {
        return this.contentId;
    }

    public final int getId() {
        return this.id;
    }

    public final int getSubtitleIndex() {
        return this.subtitleIndex;
    }

    public final String getSubtitleLanguage() {
        return this.subtitleLanguage;
    }

    public final int getSubtitleSize() {
        return this.subtitleSize;
    }

    public final int getSubtitleStyle() {
        return this.subtitleStyle;
    }

    public final String getSubtitleSwitch() {
        return this.subtitleSwitch;
    }

    public final void setContentId(String str) {
        i.g(str, "<set-?>");
        this.contentId = str;
    }

    public final void setId(int i10) {
        this.id = i10;
    }

    public final void setSubtitleIndex(int i10) {
        this.subtitleIndex = i10;
    }

    public final void setSubtitleLanguage(String str) {
        i.g(str, "<set-?>");
        this.subtitleLanguage = str;
    }

    public final void setSubtitleSize(int i10) {
        this.subtitleSize = i10;
    }

    public final void setSubtitleStyle(int i10) {
        this.subtitleStyle = i10;
    }

    public final void setSubtitleSwitch(String str) {
        i.g(str, "<set-?>");
        this.subtitleSwitch = str;
    }
}
