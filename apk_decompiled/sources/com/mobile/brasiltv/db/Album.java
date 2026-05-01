package com.mobile.brasiltv.db;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import sa.a;
import sa.e;
import sa.f;
import t9.g;

@e(name = "albums")
/* loaded from: classes3.dex */
public class Album implements Serializable {

    @f
    private static final int DB_FAV_VIDEO = 0;
    private String alias;
    private String contentId;
    private String description;
    private String director;

    @a(column = "id")
    private int id;

    @f
    private boolean isSelect;
    private String name;
    private String playContentId;
    private int playIndex;
    private String playName;
    private long playTime;
    private String posterUrl;
    private String programType;
    private String releaseTime;
    private String saveTime;
    private float score;
    private int seriesNumber;
    private String tags;
    private String trySee;
    private String type;
    private int typeId;
    private int updateCount;
    private String updateTime;
    private int volumnCount;
    public static final Companion Companion = new Companion(null);

    @f
    private static final int DB_FAV_TOPIC = 1;

    @f
    private static final int DB_RECORD_TYPE = 2;

    @f
    private final long serialVersionUID = 7234796519009099506L;
    private String size = "";

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final int getDB_FAV_TOPIC() {
            return Album.DB_FAV_TOPIC;
        }

        public final int getDB_FAV_VIDEO() {
            return Album.DB_FAV_VIDEO;
        }

        public final int getDB_RECORD_TYPE() {
            return Album.DB_RECORD_TYPE;
        }
    }

    public final String getAlias() {
        return this.alias;
    }

    public final String getContentId() {
        return this.contentId;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getDirector() {
        return this.director;
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPlayContentId() {
        return this.playContentId;
    }

    public final int getPlayIndex() {
        return this.playIndex;
    }

    public final String getPlayName() {
        return this.playName;
    }

    public final long getPlayTime() {
        return this.playTime;
    }

    public final String getPosterUrl() {
        return this.posterUrl;
    }

    public final String getProgramType() {
        return this.programType;
    }

    public final String getReleaseTime() {
        return this.releaseTime;
    }

    public final String getSaveTime() {
        return this.saveTime;
    }

    public final float getScore() {
        return this.score;
    }

    public final long getSerialVersionUID() {
        return this.serialVersionUID;
    }

    public final int getSeriesNumber() {
        return this.seriesNumber;
    }

    public final String getSize() {
        return this.size;
    }

    public final String getTags() {
        return this.tags;
    }

    public final String getTrySee() {
        return this.trySee;
    }

    public final String getType() {
        return this.type;
    }

    public final int getTypeId() {
        return this.typeId;
    }

    public final int getUpdateCount() {
        return this.updateCount;
    }

    public final String getUpdateTime() {
        return this.updateTime;
    }

    public final int getVolumnCount() {
        return this.volumnCount;
    }

    public final boolean isSelect() {
        return this.isSelect;
    }

    public final void setAlias(String str) {
        this.alias = str;
    }

    public final void setContentId(String str) {
        this.contentId = str;
    }

    public final void setDescription(String str) {
        this.description = str;
    }

    public final void setDirector(String str) {
        this.director = str;
    }

    public final void setId(int i10) {
        this.id = i10;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setPlayContentId(String str) {
        this.playContentId = str;
    }

    public final void setPlayIndex(int i10) {
        this.playIndex = i10;
    }

    public final void setPlayName(String str) {
        this.playName = str;
    }

    public final void setPlayTime(long j10) {
        this.playTime = j10;
    }

    public final void setPosterUrl(String str) {
        this.posterUrl = str;
    }

    public final void setProgramType(String str) {
        this.programType = str;
    }

    public final void setReleaseTime(String str) {
        this.releaseTime = str;
    }

    public final void setSaveTime(String str) {
        this.saveTime = str;
    }

    public final void setScore(float f10) {
        this.score = f10;
    }

    public final void setSelect(boolean z10) {
        this.isSelect = z10;
    }

    public final void setSeriesNumber(int i10) {
        this.seriesNumber = i10;
    }

    public final void setSize(String str) {
        this.size = str;
    }

    public final void setTags(String str) {
        this.tags = str;
    }

    public final void setTrySee(String str) {
        this.trySee = str;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final void setTypeId(int i10) {
        this.typeId = i10;
    }

    public final void setUpdateCount(int i10) {
        this.updateCount = i10;
    }

    public final void setUpdateTime(String str) {
        this.updateTime = str;
    }

    public final void setVolumnCount(int i10) {
        this.volumnCount = i10;
    }

    public String toString() {
        return "Album(id=" + this.id + ", contentId=" + this.contentId + ", name=" + this.name + ", typeId=" + this.typeId + ", programType=" + this.programType + ", type=" + this.type + ", volumnCount=" + this.volumnCount + ", updateCount=" + this.updateCount + ", alias=" + this.alias + ", director=" + this.director + ", score=" + this.score + ", tags=" + this.tags + ", description=" + this.description + ", posterUrl=" + this.posterUrl + ", updateTime=" + this.updateTime + ", releaseTime=" + this.releaseTime + ", playIndex=" + this.playIndex + ", playTime=" + this.playTime + ", saveTime=" + this.saveTime + ", trySee=" + this.trySee + ", seriesNumber=" + this.seriesNumber + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
