package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class ConfigResult {
    private int code;
    private ConfigData data;
    private String msg;

    public ConfigResult(int i10, String str, ConfigData configData) {
        this.code = i10;
        this.msg = str;
        this.data = configData;
    }

    public static /* synthetic */ ConfigResult copy$default(ConfigResult configResult, int i10, String str, ConfigData configData, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = configResult.code;
        }
        if ((i11 & 2) != 0) {
            str = configResult.msg;
        }
        if ((i11 & 4) != 0) {
            configData = configResult.data;
        }
        return configResult.copy(i10, str, configData);
    }

    public final int component1() {
        return this.code;
    }

    public final String component2() {
        return this.msg;
    }

    public final ConfigData component3() {
        return this.data;
    }

    public final ConfigResult copy(int i10, String str, ConfigData configData) {
        return new ConfigResult(i10, str, configData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConfigResult)) {
            return false;
        }
        ConfigResult configResult = (ConfigResult) obj;
        return this.code == configResult.code && i.b(this.msg, configResult.msg) && i.b(this.data, configResult.data);
    }

    public final int getCode() {
        return this.code;
    }

    public final ConfigData getData() {
        return this.data;
    }

    public final String getMsg() {
        return this.msg;
    }

    public int hashCode() {
        int i10 = this.code * 31;
        String str = this.msg;
        int hashCode = (i10 + (str == null ? 0 : str.hashCode())) * 31;
        ConfigData configData = this.data;
        return hashCode + (configData != null ? configData.hashCode() : 0);
    }

    public final void setCode(int i10) {
        this.code = i10;
    }

    public final void setData(ConfigData configData) {
        this.data = configData;
    }

    public final void setMsg(String str) {
        this.msg = str;
    }

    public String toString() {
        return "ConfigResult(code=" + this.code + ", msg=" + this.msg + ", data=" + this.data + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
