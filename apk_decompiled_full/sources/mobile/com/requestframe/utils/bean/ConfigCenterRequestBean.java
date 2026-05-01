package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import t9.i;

/* loaded from: classes3.dex */
public final class ConfigCenterRequestBean implements Serializable {
    private String groupName;
    private String moduleName;

    public ConfigCenterRequestBean(String str, String str2) {
        i.g(str, "moduleName");
        i.g(str2, "groupName");
        this.moduleName = str;
        this.groupName = str2;
    }

    public static /* synthetic */ ConfigCenterRequestBean copy$default(ConfigCenterRequestBean configCenterRequestBean, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = configCenterRequestBean.moduleName;
        }
        if ((i10 & 2) != 0) {
            str2 = configCenterRequestBean.groupName;
        }
        return configCenterRequestBean.copy(str, str2);
    }

    public final String component1() {
        return this.moduleName;
    }

    public final String component2() {
        return this.groupName;
    }

    public final ConfigCenterRequestBean copy(String str, String str2) {
        i.g(str, "moduleName");
        i.g(str2, "groupName");
        return new ConfigCenterRequestBean(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConfigCenterRequestBean)) {
            return false;
        }
        ConfigCenterRequestBean configCenterRequestBean = (ConfigCenterRequestBean) obj;
        return i.b(this.moduleName, configCenterRequestBean.moduleName) && i.b(this.groupName, configCenterRequestBean.groupName);
    }

    public final String getGroupName() {
        return this.groupName;
    }

    public final String getModuleName() {
        return this.moduleName;
    }

    public int hashCode() {
        return (this.moduleName.hashCode() * 31) + this.groupName.hashCode();
    }

    public final void setGroupName(String str) {
        i.g(str, "<set-?>");
        this.groupName = str;
    }

    public final void setModuleName(String str) {
        i.g(str, "<set-?>");
        this.moduleName = str;
    }

    public String toString() {
        return "ConfigCenterRequestBean(moduleName=" + this.moduleName + ", groupName=" + this.groupName + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
