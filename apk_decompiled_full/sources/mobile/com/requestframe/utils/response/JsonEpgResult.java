package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import java.util.ArrayList;
import t9.i;

/* loaded from: classes3.dex */
public final class JsonEpgResult implements Serializable {
    private String channelCode;
    private ArrayList<EpgResultData> contents;

    public JsonEpgResult(String str, ArrayList<EpgResultData> arrayList) {
        i.g(str, "channelCode");
        this.channelCode = str;
        this.contents = arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ JsonEpgResult copy$default(JsonEpgResult jsonEpgResult, String str, ArrayList arrayList, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = jsonEpgResult.channelCode;
        }
        if ((i10 & 2) != 0) {
            arrayList = jsonEpgResult.contents;
        }
        return jsonEpgResult.copy(str, arrayList);
    }

    public final String component1() {
        return this.channelCode;
    }

    public final ArrayList<EpgResultData> component2() {
        return this.contents;
    }

    public final JsonEpgResult copy(String str, ArrayList<EpgResultData> arrayList) {
        i.g(str, "channelCode");
        return new JsonEpgResult(str, arrayList);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JsonEpgResult)) {
            return false;
        }
        JsonEpgResult jsonEpgResult = (JsonEpgResult) obj;
        return i.b(this.channelCode, jsonEpgResult.channelCode) && i.b(this.contents, jsonEpgResult.contents);
    }

    public final String getChannelCode() {
        return this.channelCode;
    }

    public final ArrayList<EpgResultData> getContents() {
        return this.contents;
    }

    public int hashCode() {
        int hashCode = this.channelCode.hashCode() * 31;
        ArrayList<EpgResultData> arrayList = this.contents;
        return hashCode + (arrayList == null ? 0 : arrayList.hashCode());
    }

    public final void setChannelCode(String str) {
        i.g(str, "<set-?>");
        this.channelCode = str;
    }

    public final void setContents(ArrayList<EpgResultData> arrayList) {
        this.contents = arrayList;
    }

    public String toString() {
        return "JsonEpgResult(channelCode=" + this.channelCode + ", contents=" + this.contents + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
