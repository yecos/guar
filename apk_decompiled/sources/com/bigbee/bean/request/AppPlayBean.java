package com.bigbee.bean.request;

import com.hpplay.component.protocol.mirror.AutoStrategy;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.uc.crashsdk.export.LogType;
import java.io.Serializable;
import java.util.HashMap;
import t1.a;
import t9.g;
import t9.i;

/* loaded from: classes.dex */
public final class AppPlayBean implements Serializable {
    private String appVer;
    private String bussType;
    private long catonDuration;
    private long catonNum;
    private String cdnType;
    private long et;
    private long express;
    private String from;
    private long fstScrn;
    private String host;
    private long latency;
    private String mCode;
    private String mode;
    private long p2pErr;
    private String p2pMode;
    private HashMap<String, Object> parametersEnd;
    private HashMap<String, Object> parametersStart;
    private String quality;
    private long recvPeerBytes;
    private long recvbytes;
    private long sendPeerBytes;
    private long st;
    private String sysVer;
    private String title;
    private String titleEx;
    private String transId;
    private String uid;
    private String uname;

    public AppPlayBean(String str, String str2, String str3, String str4, long j10, long j11, String str5, String str6, String str7, long j12, String str8, String str9, String str10, String str11, String str12, long j13, long j14, HashMap<String, Object> hashMap, HashMap<String, Object> hashMap2, String str13, long j15, long j16, long j17, long j18, long j19, String str14, String str15, long j20) {
        i.g(str, "appVer");
        this.appVer = str;
        this.sysVer = str2;
        this.uid = str3;
        this.uname = str4;
        this.st = j10;
        this.et = j11;
        this.mCode = str5;
        this.host = str6;
        this.bussType = str7;
        this.fstScrn = j12;
        this.cdnType = str8;
        this.title = str9;
        this.quality = str10;
        this.from = str11;
        this.titleEx = str12;
        this.catonNum = j13;
        this.catonDuration = j14;
        this.parametersStart = hashMap;
        this.parametersEnd = hashMap2;
        this.transId = str13;
        this.express = j15;
        this.p2pErr = j16;
        this.recvPeerBytes = j17;
        this.sendPeerBytes = j18;
        this.latency = j19;
        this.mode = str14;
        this.p2pMode = str15;
        this.recvbytes = j20;
    }

    public static /* synthetic */ AppPlayBean copy$default(AppPlayBean appPlayBean, String str, String str2, String str3, String str4, long j10, long j11, String str5, String str6, String str7, long j12, String str8, String str9, String str10, String str11, String str12, long j13, long j14, HashMap hashMap, HashMap hashMap2, String str13, long j15, long j16, long j17, long j18, long j19, String str14, String str15, long j20, int i10, Object obj) {
        String str16 = (i10 & 1) != 0 ? appPlayBean.appVer : str;
        String str17 = (i10 & 2) != 0 ? appPlayBean.sysVer : str2;
        String str18 = (i10 & 4) != 0 ? appPlayBean.uid : str3;
        String str19 = (i10 & 8) != 0 ? appPlayBean.uname : str4;
        long j21 = (i10 & 16) != 0 ? appPlayBean.st : j10;
        long j22 = (i10 & 32) != 0 ? appPlayBean.et : j11;
        String str20 = (i10 & 64) != 0 ? appPlayBean.mCode : str5;
        String str21 = (i10 & 128) != 0 ? appPlayBean.host : str6;
        String str22 = (i10 & 256) != 0 ? appPlayBean.bussType : str7;
        long j23 = (i10 & 512) != 0 ? appPlayBean.fstScrn : j12;
        String str23 = (i10 & 1024) != 0 ? appPlayBean.cdnType : str8;
        String str24 = (i10 & 2048) != 0 ? appPlayBean.title : str9;
        String str25 = (i10 & 4096) != 0 ? appPlayBean.quality : str10;
        String str26 = (i10 & 8192) != 0 ? appPlayBean.from : str11;
        String str27 = (i10 & 16384) != 0 ? appPlayBean.titleEx : str12;
        long j24 = j23;
        long j25 = (i10 & 32768) != 0 ? appPlayBean.catonNum : j13;
        long j26 = (i10 & 65536) != 0 ? appPlayBean.catonDuration : j14;
        HashMap hashMap3 = (i10 & 131072) != 0 ? appPlayBean.parametersStart : hashMap;
        return appPlayBean.copy(str16, str17, str18, str19, j21, j22, str20, str21, str22, j24, str23, str24, str25, str26, str27, j25, j26, hashMap3, (262144 & i10) != 0 ? appPlayBean.parametersEnd : hashMap2, (i10 & 524288) != 0 ? appPlayBean.transId : str13, (i10 & LogType.ANR) != 0 ? appPlayBean.express : j15, (i10 & AutoStrategy.BITRATE_LOW4) != 0 ? appPlayBean.p2pErr : j16, (i10 & AutoStrategy.BITRATE_LOW) != 0 ? appPlayBean.recvPeerBytes : j17, (i10 & AutoStrategy.BITRATE_HIGH) != 0 ? appPlayBean.sendPeerBytes : j18, (i10 & 16777216) != 0 ? appPlayBean.latency : j19, (i10 & 33554432) != 0 ? appPlayBean.mode : str14, (67108864 & i10) != 0 ? appPlayBean.p2pMode : str15, (i10 & 134217728) != 0 ? appPlayBean.recvbytes : j20);
    }

    public final String component1() {
        return this.appVer;
    }

    public final long component10() {
        return this.fstScrn;
    }

    public final String component11() {
        return this.cdnType;
    }

    public final String component12() {
        return this.title;
    }

    public final String component13() {
        return this.quality;
    }

    public final String component14() {
        return this.from;
    }

    public final String component15() {
        return this.titleEx;
    }

    public final long component16() {
        return this.catonNum;
    }

    public final long component17() {
        return this.catonDuration;
    }

    public final HashMap<String, Object> component18() {
        return this.parametersStart;
    }

    public final HashMap<String, Object> component19() {
        return this.parametersEnd;
    }

    public final String component2() {
        return this.sysVer;
    }

    public final String component20() {
        return this.transId;
    }

    public final long component21() {
        return this.express;
    }

    public final long component22() {
        return this.p2pErr;
    }

    public final long component23() {
        return this.recvPeerBytes;
    }

    public final long component24() {
        return this.sendPeerBytes;
    }

    public final long component25() {
        return this.latency;
    }

    public final String component26() {
        return this.mode;
    }

    public final String component27() {
        return this.p2pMode;
    }

    public final long component28() {
        return this.recvbytes;
    }

    public final String component3() {
        return this.uid;
    }

    public final String component4() {
        return this.uname;
    }

    public final long component5() {
        return this.st;
    }

    public final long component6() {
        return this.et;
    }

    public final String component7() {
        return this.mCode;
    }

    public final String component8() {
        return this.host;
    }

    public final String component9() {
        return this.bussType;
    }

    public final AppPlayBean copy(String str, String str2, String str3, String str4, long j10, long j11, String str5, String str6, String str7, long j12, String str8, String str9, String str10, String str11, String str12, long j13, long j14, HashMap<String, Object> hashMap, HashMap<String, Object> hashMap2, String str13, long j15, long j16, long j17, long j18, long j19, String str14, String str15, long j20) {
        i.g(str, "appVer");
        return new AppPlayBean(str, str2, str3, str4, j10, j11, str5, str6, str7, j12, str8, str9, str10, str11, str12, j13, j14, hashMap, hashMap2, str13, j15, j16, j17, j18, j19, str14, str15, j20);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppPlayBean)) {
            return false;
        }
        AppPlayBean appPlayBean = (AppPlayBean) obj;
        return i.b(this.appVer, appPlayBean.appVer) && i.b(this.sysVer, appPlayBean.sysVer) && i.b(this.uid, appPlayBean.uid) && i.b(this.uname, appPlayBean.uname) && this.st == appPlayBean.st && this.et == appPlayBean.et && i.b(this.mCode, appPlayBean.mCode) && i.b(this.host, appPlayBean.host) && i.b(this.bussType, appPlayBean.bussType) && this.fstScrn == appPlayBean.fstScrn && i.b(this.cdnType, appPlayBean.cdnType) && i.b(this.title, appPlayBean.title) && i.b(this.quality, appPlayBean.quality) && i.b(this.from, appPlayBean.from) && i.b(this.titleEx, appPlayBean.titleEx) && this.catonNum == appPlayBean.catonNum && this.catonDuration == appPlayBean.catonDuration && i.b(this.parametersStart, appPlayBean.parametersStart) && i.b(this.parametersEnd, appPlayBean.parametersEnd) && i.b(this.transId, appPlayBean.transId) && this.express == appPlayBean.express && this.p2pErr == appPlayBean.p2pErr && this.recvPeerBytes == appPlayBean.recvPeerBytes && this.sendPeerBytes == appPlayBean.sendPeerBytes && this.latency == appPlayBean.latency && i.b(this.mode, appPlayBean.mode) && i.b(this.p2pMode, appPlayBean.p2pMode) && this.recvbytes == appPlayBean.recvbytes;
    }

    public final String getAppVer() {
        return this.appVer;
    }

    public final String getBussType() {
        return this.bussType;
    }

    public final long getCatonDuration() {
        return this.catonDuration;
    }

    public final long getCatonNum() {
        return this.catonNum;
    }

    public final String getCdnType() {
        return this.cdnType;
    }

    public final long getEt() {
        return this.et;
    }

    public final long getExpress() {
        return this.express;
    }

    public final String getFrom() {
        return this.from;
    }

    public final long getFstScrn() {
        return this.fstScrn;
    }

    public final String getHost() {
        return this.host;
    }

    public final long getLatency() {
        return this.latency;
    }

    public final String getMCode() {
        return this.mCode;
    }

    public final String getMode() {
        return this.mode;
    }

    public final long getP2pErr() {
        return this.p2pErr;
    }

    public final String getP2pMode() {
        return this.p2pMode;
    }

    public final HashMap<String, Object> getParametersEnd() {
        return this.parametersEnd;
    }

    public final HashMap<String, Object> getParametersStart() {
        return this.parametersStart;
    }

    public final String getQuality() {
        return this.quality;
    }

    public final long getRecvPeerBytes() {
        return this.recvPeerBytes;
    }

    public final long getRecvbytes() {
        return this.recvbytes;
    }

    public final long getSendPeerBytes() {
        return this.sendPeerBytes;
    }

    public final long getSt() {
        return this.st;
    }

    public final String getSysVer() {
        return this.sysVer;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getTitleEx() {
        return this.titleEx;
    }

    public final String getTransId() {
        return this.transId;
    }

    public final String getUid() {
        return this.uid;
    }

    public final String getUname() {
        return this.uname;
    }

    public int hashCode() {
        int hashCode = this.appVer.hashCode() * 31;
        String str = this.sysVer;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.uid;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.uname;
        int hashCode4 = (((((hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31) + a.a(this.st)) * 31) + a.a(this.et)) * 31;
        String str4 = this.mCode;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.host;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.bussType;
        int hashCode7 = (((hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31) + a.a(this.fstScrn)) * 31;
        String str7 = this.cdnType;
        int hashCode8 = (hashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.title;
        int hashCode9 = (hashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.quality;
        int hashCode10 = (hashCode9 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.from;
        int hashCode11 = (hashCode10 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.titleEx;
        int hashCode12 = (((((hashCode11 + (str11 == null ? 0 : str11.hashCode())) * 31) + a.a(this.catonNum)) * 31) + a.a(this.catonDuration)) * 31;
        HashMap<String, Object> hashMap = this.parametersStart;
        int hashCode13 = (hashCode12 + (hashMap == null ? 0 : hashMap.hashCode())) * 31;
        HashMap<String, Object> hashMap2 = this.parametersEnd;
        int hashCode14 = (hashCode13 + (hashMap2 == null ? 0 : hashMap2.hashCode())) * 31;
        String str12 = this.transId;
        int hashCode15 = (((((((((((hashCode14 + (str12 == null ? 0 : str12.hashCode())) * 31) + a.a(this.express)) * 31) + a.a(this.p2pErr)) * 31) + a.a(this.recvPeerBytes)) * 31) + a.a(this.sendPeerBytes)) * 31) + a.a(this.latency)) * 31;
        String str13 = this.mode;
        int hashCode16 = (hashCode15 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.p2pMode;
        return ((hashCode16 + (str14 != null ? str14.hashCode() : 0)) * 31) + a.a(this.recvbytes);
    }

    public final void setAppVer(String str) {
        i.g(str, "<set-?>");
        this.appVer = str;
    }

    public final void setBussType(String str) {
        this.bussType = str;
    }

    public final void setCatonDuration(long j10) {
        this.catonDuration = j10;
    }

    public final void setCatonNum(long j10) {
        this.catonNum = j10;
    }

    public final void setCdnType(String str) {
        this.cdnType = str;
    }

    public final void setEt(long j10) {
        this.et = j10;
    }

    public final void setExpress(long j10) {
        this.express = j10;
    }

    public final void setFrom(String str) {
        this.from = str;
    }

    public final void setFstScrn(long j10) {
        this.fstScrn = j10;
    }

    public final void setHost(String str) {
        this.host = str;
    }

    public final void setLatency(long j10) {
        this.latency = j10;
    }

    public final void setMCode(String str) {
        this.mCode = str;
    }

    public final void setMode(String str) {
        this.mode = str;
    }

    public final void setP2pErr(long j10) {
        this.p2pErr = j10;
    }

    public final void setP2pMode(String str) {
        this.p2pMode = str;
    }

    public final void setParametersEnd(HashMap<String, Object> hashMap) {
        this.parametersEnd = hashMap;
    }

    public final void setParametersStart(HashMap<String, Object> hashMap) {
        this.parametersStart = hashMap;
    }

    public final void setQuality(String str) {
        this.quality = str;
    }

    public final void setRecvPeerBytes(long j10) {
        this.recvPeerBytes = j10;
    }

    public final void setRecvbytes(long j10) {
        this.recvbytes = j10;
    }

    public final void setSendPeerBytes(long j10) {
        this.sendPeerBytes = j10;
    }

    public final void setSt(long j10) {
        this.st = j10;
    }

    public final void setSysVer(String str) {
        this.sysVer = str;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final void setTitleEx(String str) {
        this.titleEx = str;
    }

    public final void setTransId(String str) {
        this.transId = str;
    }

    public final void setUid(String str) {
        this.uid = str;
    }

    public final void setUname(String str) {
        this.uname = str;
    }

    public String toString() {
        return "AppPlayBean(appVer=" + this.appVer + ", sysVer=" + this.sysVer + ", uid=" + this.uid + ", uname=" + this.uname + ", st=" + this.st + ", et=" + this.et + ", mCode=" + this.mCode + ", host=" + this.host + ", bussType=" + this.bussType + ", fstScrn=" + this.fstScrn + ", cdnType=" + this.cdnType + ", title=" + this.title + ", quality=" + this.quality + ", from=" + this.from + ", titleEx=" + this.titleEx + ", catonNum=" + this.catonNum + ", catonDuration=" + this.catonDuration + ", parametersStart=" + this.parametersStart + ", parametersEnd=" + this.parametersEnd + ", transId=" + this.transId + ", express=" + this.express + ", p2pErr=" + this.p2pErr + ", recvPeerBytes=" + this.recvPeerBytes + ", sendPeerBytes=" + this.sendPeerBytes + ", latency=" + this.latency + ", mode=" + this.mode + ", p2pMode=" + this.p2pMode + ", recvbytes=" + this.recvbytes + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }

    public /* synthetic */ AppPlayBean(String str, String str2, String str3, String str4, long j10, long j11, String str5, String str6, String str7, long j12, String str8, String str9, String str10, String str11, String str12, long j13, long j14, HashMap hashMap, HashMap hashMap2, String str13, long j15, long j16, long j17, long j18, long j19, String str14, String str15, long j20, int i10, g gVar) {
        this(str, str2, str3, str4, j10, j11, str5, str6, str7, j12, str8, str9, str10, str11, str12, j13, j14, (i10 & 131072) != 0 ? null : hashMap, (i10 & 262144) != 0 ? null : hashMap2, str13, j15, j16, j17, j18, j19, str14, str15, j20);
    }
}
