package com.bigbee.db;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.raizlabs.android.dbflow.structure.BaseModel;

/* loaded from: classes.dex */
public class EventDbModel extends BaseModel {
    public String appVer;
    public String cipherStr;
    public String commonStr;
    public long endTime;
    public String eventId;
    public int id;
    public boolean notIntactEvent;
    public boolean reporting;
    public String reserveA;
    public String reserveB;
    public long startTime;
    public String sysVer;

    public String toString() {
        return "EventDbModel{id=" + this.id + ", appVer='" + this.appVer + "', sysVer='" + this.sysVer + "', startTime=" + this.startTime + ", endTime=" + this.endTime + ", eventId='" + this.eventId + "', reporting=" + this.reporting + ", cipherStr='" + this.cipherStr + "', commonStr='" + this.commonStr + "', notIntactEvent=" + this.notIntactEvent + ", reserveA='" + this.reserveA + "', reserveB='" + this.reserveB + '\'' + ASCIIPropertyListParser.DICTIONARY_END_TOKEN;
    }
}
