package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.ArrayList;
import t9.i;

/* loaded from: classes3.dex */
public final class MatchStatData {
    private ArrayList<HistoryStat> historyList;
    private MatchStat statistics;

    public MatchStatData(MatchStat matchStat, ArrayList<HistoryStat> arrayList) {
        this.statistics = matchStat;
        this.historyList = arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MatchStatData copy$default(MatchStatData matchStatData, MatchStat matchStat, ArrayList arrayList, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            matchStat = matchStatData.statistics;
        }
        if ((i10 & 2) != 0) {
            arrayList = matchStatData.historyList;
        }
        return matchStatData.copy(matchStat, arrayList);
    }

    public final MatchStat component1() {
        return this.statistics;
    }

    public final ArrayList<HistoryStat> component2() {
        return this.historyList;
    }

    public final MatchStatData copy(MatchStat matchStat, ArrayList<HistoryStat> arrayList) {
        return new MatchStatData(matchStat, arrayList);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MatchStatData)) {
            return false;
        }
        MatchStatData matchStatData = (MatchStatData) obj;
        return i.b(this.statistics, matchStatData.statistics) && i.b(this.historyList, matchStatData.historyList);
    }

    public final ArrayList<HistoryStat> getHistoryList() {
        return this.historyList;
    }

    public final MatchStat getStatistics() {
        return this.statistics;
    }

    public int hashCode() {
        MatchStat matchStat = this.statistics;
        int hashCode = (matchStat == null ? 0 : matchStat.hashCode()) * 31;
        ArrayList<HistoryStat> arrayList = this.historyList;
        return hashCode + (arrayList != null ? arrayList.hashCode() : 0);
    }

    public final void setHistoryList(ArrayList<HistoryStat> arrayList) {
        this.historyList = arrayList;
    }

    public final void setStatistics(MatchStat matchStat) {
        this.statistics = matchStat;
    }

    public String toString() {
        return "MatchStatData(statistics=" + this.statistics + ", historyList=" + this.historyList + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
