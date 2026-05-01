package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import java.util.List;
import t9.i;

/* loaded from: classes3.dex */
public final class StartPlayVODData implements Serializable {
    private Integer episode0Count;
    private List<EpisodeList> episodeList;
    private String name;
    private String seriesFlag;
    private Integer vodFreeCount;
    private String vodFreeFlag;

    public StartPlayVODData(List<EpisodeList> list, Integer num, String str, String str2, String str3, Integer num2) {
        this.episodeList = list;
        this.vodFreeCount = num;
        this.vodFreeFlag = str;
        this.seriesFlag = str2;
        this.name = str3;
        this.episode0Count = num2;
    }

    public static /* synthetic */ StartPlayVODData copy$default(StartPlayVODData startPlayVODData, List list, Integer num, String str, String str2, String str3, Integer num2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = startPlayVODData.episodeList;
        }
        if ((i10 & 2) != 0) {
            num = startPlayVODData.vodFreeCount;
        }
        Integer num3 = num;
        if ((i10 & 4) != 0) {
            str = startPlayVODData.vodFreeFlag;
        }
        String str4 = str;
        if ((i10 & 8) != 0) {
            str2 = startPlayVODData.seriesFlag;
        }
        String str5 = str2;
        if ((i10 & 16) != 0) {
            str3 = startPlayVODData.name;
        }
        String str6 = str3;
        if ((i10 & 32) != 0) {
            num2 = startPlayVODData.episode0Count;
        }
        return startPlayVODData.copy(list, num3, str4, str5, str6, num2);
    }

    public final List<EpisodeList> component1() {
        return this.episodeList;
    }

    public final Integer component2() {
        return this.vodFreeCount;
    }

    public final String component3() {
        return this.vodFreeFlag;
    }

    public final String component4() {
        return this.seriesFlag;
    }

    public final String component5() {
        return this.name;
    }

    public final Integer component6() {
        return this.episode0Count;
    }

    public final StartPlayVODData copy(List<EpisodeList> list, Integer num, String str, String str2, String str3, Integer num2) {
        return new StartPlayVODData(list, num, str, str2, str3, num2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StartPlayVODData)) {
            return false;
        }
        StartPlayVODData startPlayVODData = (StartPlayVODData) obj;
        return i.b(this.episodeList, startPlayVODData.episodeList) && i.b(this.vodFreeCount, startPlayVODData.vodFreeCount) && i.b(this.vodFreeFlag, startPlayVODData.vodFreeFlag) && i.b(this.seriesFlag, startPlayVODData.seriesFlag) && i.b(this.name, startPlayVODData.name) && i.b(this.episode0Count, startPlayVODData.episode0Count);
    }

    public final Integer getEpisode0Count() {
        return this.episode0Count;
    }

    public final List<EpisodeList> getEpisodeList() {
        return this.episodeList;
    }

    public final String getName() {
        return this.name;
    }

    public final String getSeriesFlag() {
        return this.seriesFlag;
    }

    public final Integer getVodFreeCount() {
        return this.vodFreeCount;
    }

    public final String getVodFreeFlag() {
        return this.vodFreeFlag;
    }

    public int hashCode() {
        List<EpisodeList> list = this.episodeList;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        Integer num = this.vodFreeCount;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.vodFreeFlag;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.seriesFlag;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.name;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num2 = this.episode0Count;
        return hashCode5 + (num2 != null ? num2.hashCode() : 0);
    }

    public final void setEpisode0Count(Integer num) {
        this.episode0Count = num;
    }

    public final void setEpisodeList(List<EpisodeList> list) {
        this.episodeList = list;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setSeriesFlag(String str) {
        this.seriesFlag = str;
    }

    public final void setVodFreeCount(Integer num) {
        this.vodFreeCount = num;
    }

    public final void setVodFreeFlag(String str) {
        this.vodFreeFlag = str;
    }

    public String toString() {
        return "StartPlayVODData(episodeList=" + this.episodeList + ", vodFreeCount=" + this.vodFreeCount + ", vodFreeFlag=" + this.vodFreeFlag + ", seriesFlag=" + this.seriesFlag + ", name=" + this.name + ", episode0Count=" + this.episode0Count + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
