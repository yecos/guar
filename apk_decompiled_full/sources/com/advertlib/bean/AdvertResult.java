package com.advertlib.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.List;
import t9.i;

/* loaded from: classes.dex */
public final class AdvertResult {
    private List<AdvertPosition> ad_positions;
    private final Integer reporting_interval;
    private Long timestamp;
    private String user_group_id;

    public AdvertResult(String str, Long l10, Integer num, List<AdvertPosition> list) {
        this.user_group_id = str;
        this.timestamp = l10;
        this.reporting_interval = num;
        this.ad_positions = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AdvertResult copy$default(AdvertResult advertResult, String str, Long l10, Integer num, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = advertResult.user_group_id;
        }
        if ((i10 & 2) != 0) {
            l10 = advertResult.timestamp;
        }
        if ((i10 & 4) != 0) {
            num = advertResult.reporting_interval;
        }
        if ((i10 & 8) != 0) {
            list = advertResult.ad_positions;
        }
        return advertResult.copy(str, l10, num, list);
    }

    public final String component1() {
        return this.user_group_id;
    }

    public final Long component2() {
        return this.timestamp;
    }

    public final Integer component3() {
        return this.reporting_interval;
    }

    public final List<AdvertPosition> component4() {
        return this.ad_positions;
    }

    public final AdvertResult copy(String str, Long l10, Integer num, List<AdvertPosition> list) {
        return new AdvertResult(str, l10, num, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdvertResult)) {
            return false;
        }
        AdvertResult advertResult = (AdvertResult) obj;
        return i.b(this.user_group_id, advertResult.user_group_id) && i.b(this.timestamp, advertResult.timestamp) && i.b(this.reporting_interval, advertResult.reporting_interval) && i.b(this.ad_positions, advertResult.ad_positions);
    }

    public final List<AdvertPosition> getAd_positions() {
        return this.ad_positions;
    }

    public final Integer getReporting_interval() {
        return this.reporting_interval;
    }

    public final Long getTimestamp() {
        return this.timestamp;
    }

    public final String getUser_group_id() {
        return this.user_group_id;
    }

    public int hashCode() {
        String str = this.user_group_id;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Long l10 = this.timestamp;
        int hashCode2 = (hashCode + (l10 == null ? 0 : l10.hashCode())) * 31;
        Integer num = this.reporting_interval;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        List<AdvertPosition> list = this.ad_positions;
        return hashCode3 + (list != null ? list.hashCode() : 0);
    }

    public final void setAd_positions(List<AdvertPosition> list) {
        this.ad_positions = list;
    }

    public final void setTimestamp(Long l10) {
        this.timestamp = l10;
    }

    public final void setUser_group_id(String str) {
        this.user_group_id = str;
    }

    public String toString() {
        return "AdvertResult(user_group_id=" + this.user_group_id + ", timestamp=" + this.timestamp + ", reporting_interval=" + this.reporting_interval + ", ad_positions=" + this.ad_positions + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
