package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class DataCollectResult {
    private String code_desc;
    private int return_code;

    public DataCollectResult(int i10, String str) {
        i.g(str, "code_desc");
        this.return_code = i10;
        this.code_desc = str;
    }

    public static /* synthetic */ DataCollectResult copy$default(DataCollectResult dataCollectResult, int i10, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = dataCollectResult.return_code;
        }
        if ((i11 & 2) != 0) {
            str = dataCollectResult.code_desc;
        }
        return dataCollectResult.copy(i10, str);
    }

    public final int component1() {
        return this.return_code;
    }

    public final String component2() {
        return this.code_desc;
    }

    public final DataCollectResult copy(int i10, String str) {
        i.g(str, "code_desc");
        return new DataCollectResult(i10, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DataCollectResult)) {
            return false;
        }
        DataCollectResult dataCollectResult = (DataCollectResult) obj;
        return this.return_code == dataCollectResult.return_code && i.b(this.code_desc, dataCollectResult.code_desc);
    }

    public final String getCode_desc() {
        return this.code_desc;
    }

    public final int getReturn_code() {
        return this.return_code;
    }

    public int hashCode() {
        return (this.return_code * 31) + this.code_desc.hashCode();
    }

    public final void setCode_desc(String str) {
        i.g(str, "<set-?>");
        this.code_desc = str;
    }

    public final void setReturn_code(int i10) {
        this.return_code = i10;
    }

    public String toString() {
        return "DataCollectResult(return_code=" + this.return_code + ", code_desc=" + this.code_desc + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
