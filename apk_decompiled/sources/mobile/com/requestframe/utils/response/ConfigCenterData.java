package mobile.com.requestframe.utils.response;

import android.text.TextUtils;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import s2.b;
import t9.i;

/* loaded from: classes3.dex */
public final class ConfigCenterData implements Serializable {
    private String config;
    private ConfigBean configDetail;
    private String groupName;
    private Integer id;
    private String moduleName;

    public ConfigCenterData(Integer num, String str, String str2, String str3) {
        this.id = num;
        this.moduleName = str;
        this.groupName = str2;
        this.config = str3;
    }

    public static /* synthetic */ ConfigCenterData copy$default(ConfigCenterData configCenterData, Integer num, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = configCenterData.id;
        }
        if ((i10 & 2) != 0) {
            str = configCenterData.moduleName;
        }
        if ((i10 & 4) != 0) {
            str2 = configCenterData.groupName;
        }
        if ((i10 & 8) != 0) {
            str3 = configCenterData.config;
        }
        return configCenterData.copy(num, str, str2, str3);
    }

    public final Integer component1() {
        return this.id;
    }

    public final String component2() {
        return this.moduleName;
    }

    public final String component3() {
        return this.groupName;
    }

    public final String component4() {
        return this.config;
    }

    public final ConfigCenterData copy(Integer num, String str, String str2, String str3) {
        return new ConfigCenterData(num, str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConfigCenterData)) {
            return false;
        }
        ConfigCenterData configCenterData = (ConfigCenterData) obj;
        return i.b(this.id, configCenterData.id) && i.b(this.moduleName, configCenterData.moduleName) && i.b(this.groupName, configCenterData.groupName) && i.b(this.config, configCenterData.config);
    }

    public final String getConfig() {
        return this.config;
    }

    public final String getGroupName() {
        return this.groupName;
    }

    public final Integer getId() {
        return this.id;
    }

    public final String getModuleName() {
        return this.moduleName;
    }

    public int hashCode() {
        Integer num = this.id;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.moduleName;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.groupName;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.config;
        return hashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public final void setConfig(String str) {
        this.config = str;
    }

    public final void setGroupName(String str) {
        this.groupName = str;
    }

    public final void setId(Integer num) {
        this.id = num;
    }

    public final void setModuleName(String str) {
        this.moduleName = str;
    }

    public String toString() {
        return "ConfigCenterData(id=" + this.id + ", moduleName=" + this.moduleName + ", groupName=" + this.groupName + ", config=" + this.config + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }

    /* renamed from: getConfig, reason: collision with other method in class */
    public final ConfigBean m93getConfig() {
        if (!TextUtils.isEmpty(this.config)) {
            try {
                this.configDetail = (ConfigBean) b.a().fromJson(this.config, ConfigBean.class);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        return this.configDetail;
    }
}
