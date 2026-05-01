package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import t9.i;

/* loaded from: classes3.dex */
public final class GiftDaysResult implements Serializable {
    private GiftDaysData data;
    private String errorMessage;
    private String returnCode;

    public GiftDaysResult(String str, String str2, GiftDaysData giftDaysData) {
        this.returnCode = str;
        this.errorMessage = str2;
        this.data = giftDaysData;
    }

    public static /* synthetic */ GiftDaysResult copy$default(GiftDaysResult giftDaysResult, String str, String str2, GiftDaysData giftDaysData, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = giftDaysResult.returnCode;
        }
        if ((i10 & 2) != 0) {
            str2 = giftDaysResult.errorMessage;
        }
        if ((i10 & 4) != 0) {
            giftDaysData = giftDaysResult.data;
        }
        return giftDaysResult.copy(str, str2, giftDaysData);
    }

    public final String component1() {
        return this.returnCode;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final GiftDaysData component3() {
        return this.data;
    }

    public final GiftDaysResult copy(String str, String str2, GiftDaysData giftDaysData) {
        return new GiftDaysResult(str, str2, giftDaysData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GiftDaysResult)) {
            return false;
        }
        GiftDaysResult giftDaysResult = (GiftDaysResult) obj;
        return i.b(this.returnCode, giftDaysResult.returnCode) && i.b(this.errorMessage, giftDaysResult.errorMessage) && i.b(this.data, giftDaysResult.data);
    }

    public final GiftDaysData getData() {
        return this.data;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final String getReturnCode() {
        return this.returnCode;
    }

    public int hashCode() {
        String str = this.returnCode;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.errorMessage;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        GiftDaysData giftDaysData = this.data;
        return hashCode2 + (giftDaysData != null ? giftDaysData.hashCode() : 0);
    }

    public final void setData(GiftDaysData giftDaysData) {
        this.data = giftDaysData;
    }

    public final void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public final void setReturnCode(String str) {
        this.returnCode = str;
    }

    public String toString() {
        return "GiftDaysResult(returnCode=" + this.returnCode + ", errorMessage=" + this.errorMessage + ", data=" + this.data + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
