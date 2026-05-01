package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.util.List;
import t9.i;

/* loaded from: classes3.dex */
public final class TypeQuestionData {
    private List<QuestionBean> questionList;
    private Integer type;
    private int typeId;
    private String typeName;

    public TypeQuestionData(Integer num, int i10, String str, List<QuestionBean> list) {
        this.type = num;
        this.typeId = i10;
        this.typeName = str;
        this.questionList = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TypeQuestionData copy$default(TypeQuestionData typeQuestionData, Integer num, int i10, String str, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = typeQuestionData.type;
        }
        if ((i11 & 2) != 0) {
            i10 = typeQuestionData.typeId;
        }
        if ((i11 & 4) != 0) {
            str = typeQuestionData.typeName;
        }
        if ((i11 & 8) != 0) {
            list = typeQuestionData.questionList;
        }
        return typeQuestionData.copy(num, i10, str, list);
    }

    public final Integer component1() {
        return this.type;
    }

    public final int component2() {
        return this.typeId;
    }

    public final String component3() {
        return this.typeName;
    }

    public final List<QuestionBean> component4() {
        return this.questionList;
    }

    public final TypeQuestionData copy(Integer num, int i10, String str, List<QuestionBean> list) {
        return new TypeQuestionData(num, i10, str, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TypeQuestionData)) {
            return false;
        }
        TypeQuestionData typeQuestionData = (TypeQuestionData) obj;
        return i.b(this.type, typeQuestionData.type) && this.typeId == typeQuestionData.typeId && i.b(this.typeName, typeQuestionData.typeName) && i.b(this.questionList, typeQuestionData.questionList);
    }

    public final List<QuestionBean> getQuestionList() {
        return this.questionList;
    }

    public final Integer getType() {
        return this.type;
    }

    public final int getTypeId() {
        return this.typeId;
    }

    public final String getTypeName() {
        return this.typeName;
    }

    public int hashCode() {
        Integer num = this.type;
        int hashCode = (((num == null ? 0 : num.hashCode()) * 31) + this.typeId) * 31;
        String str = this.typeName;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        List<QuestionBean> list = this.questionList;
        return hashCode2 + (list != null ? list.hashCode() : 0);
    }

    public final void setQuestionList(List<QuestionBean> list) {
        this.questionList = list;
    }

    public final void setType(Integer num) {
        this.type = num;
    }

    public final void setTypeId(int i10) {
        this.typeId = i10;
    }

    public final void setTypeName(String str) {
        this.typeName = str;
    }

    public String toString() {
        return "TypeQuestionData(type=" + this.type + ", typeId=" + this.typeId + ", typeName=" + this.typeName + ", questionList=" + this.questionList + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
