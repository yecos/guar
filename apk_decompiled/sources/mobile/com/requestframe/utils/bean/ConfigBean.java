package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class ConfigBean {
    private String groupName;
    private String moduleName;

    public ConfigBean(String str, String str2) {
        i.g(str, "moduleName");
        i.g(str2, "groupName");
        this.moduleName = str;
        this.groupName = str2;
    }

    public static /* synthetic */ ConfigBean copy$default(ConfigBean configBean, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = configBean.moduleName;
        }
        if ((i10 & 2) != 0) {
            str2 = configBean.groupName;
        }
        return configBean.copy(str, str2);
    }

    public final String component1() {
        return this.moduleName;
    }

    public final String component2() {
        return this.groupName;
    }

    public final ConfigBean copy(String str, String str2) {
        i.g(str, "moduleName");
        i.g(str2, "groupName");
        return new ConfigBean(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConfigBean)) {
            return false;
        }
        ConfigBean configBean = (ConfigBean) obj;
        return i.b(this.moduleName, configBean.moduleName) && i.b(this.groupName, configBean.groupName);
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
        return "ConfigBean(moduleName=" + this.moduleName + ", groupName=" + this.groupName + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
