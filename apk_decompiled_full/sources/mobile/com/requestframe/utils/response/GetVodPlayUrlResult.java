package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.List;
import t9.i;

/* loaded from: classes3.dex */
public final class GetVodPlayUrlResult {
    private List<PlayInfo> play_infos;

    public GetVodPlayUrlResult(List<PlayInfo> list) {
        this.play_infos = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GetVodPlayUrlResult copy$default(GetVodPlayUrlResult getVodPlayUrlResult, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = getVodPlayUrlResult.play_infos;
        }
        return getVodPlayUrlResult.copy(list);
    }

    public final List<PlayInfo> component1() {
        return this.play_infos;
    }

    public final GetVodPlayUrlResult copy(List<PlayInfo> list) {
        return new GetVodPlayUrlResult(list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GetVodPlayUrlResult) && i.b(this.play_infos, ((GetVodPlayUrlResult) obj).play_infos);
    }

    public final List<PlayInfo> getPlay_infos() {
        return this.play_infos;
    }

    public int hashCode() {
        List<PlayInfo> list = this.play_infos;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    public final void setPlay_infos(List<PlayInfo> list) {
        this.play_infos = list;
    }

    public String toString() {
        return "GetVodPlayUrlResult(play_infos=" + this.play_infos + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
