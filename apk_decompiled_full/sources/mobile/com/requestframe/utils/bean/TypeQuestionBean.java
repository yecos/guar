package mobile.com.requestframe.utils.bean;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class TypeQuestionBean {
    private final String appId;
    private final String lang;
    private final String type;

    public TypeQuestionBean(String str, String str2, String str3) {
        i.g(str, "appId");
        i.g(str2, "lang");
        i.g(str3, "type");
        this.appId = str;
        this.lang = str2;
        this.type = str3;
    }

    public static /* synthetic */ TypeQuestionBean copy$default(TypeQuestionBean typeQuestionBean, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = typeQuestionBean.appId;
        }
        if ((i10 & 2) != 0) {
            str2 = typeQuestionBean.lang;
        }
        if ((i10 & 4) != 0) {
            str3 = typeQuestionBean.type;
        }
        return typeQuestionBean.copy(str, str2, str3);
    }

    public final String component1() {
        return this.appId;
    }

    public final String component2() {
        return this.lang;
    }

    public final String component3() {
        return this.type;
    }

    public final TypeQuestionBean copy(String str, String str2, String str3) {
        i.g(str, "appId");
        i.g(str2, "lang");
        i.g(str3, "type");
        return new TypeQuestionBean(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TypeQuestionBean)) {
            return false;
        }
        TypeQuestionBean typeQuestionBean = (TypeQuestionBean) obj;
        return i.b(this.appId, typeQuestionBean.appId) && i.b(this.lang, typeQuestionBean.lang) && i.b(this.type, typeQuestionBean.type);
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getLang() {
        return this.lang;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        return (((this.appId.hashCode() * 31) + this.lang.hashCode()) * 31) + this.type.hashCode();
    }

    public String toString() {
        return "TypeQuestionBean(appId=" + this.appId + ", lang=" + this.lang + ", type=" + this.type + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
