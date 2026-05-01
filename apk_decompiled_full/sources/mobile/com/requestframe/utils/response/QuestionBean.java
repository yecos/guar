package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import t9.i;

/* loaded from: classes3.dex */
public final class QuestionBean {
    private String name;
    private int questionId;
    private Integer typeId;

    public QuestionBean(int i10, String str) {
        i.g(str, "name");
        this.questionId = i10;
        this.name = str;
    }

    public static /* synthetic */ QuestionBean copy$default(QuestionBean questionBean, int i10, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = questionBean.questionId;
        }
        if ((i11 & 2) != 0) {
            str = questionBean.name;
        }
        return questionBean.copy(i10, str);
    }

    public final int component1() {
        return this.questionId;
    }

    public final String component2() {
        return this.name;
    }

    public final QuestionBean copy(int i10, String str) {
        i.g(str, "name");
        return new QuestionBean(i10, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QuestionBean)) {
            return false;
        }
        QuestionBean questionBean = (QuestionBean) obj;
        return this.questionId == questionBean.questionId && i.b(this.name, questionBean.name);
    }

    public final String getName() {
        return this.name;
    }

    public final int getQuestionId() {
        return this.questionId;
    }

    public final Integer getTypeId() {
        return this.typeId;
    }

    public int hashCode() {
        return (this.questionId * 31) + this.name.hashCode();
    }

    public final void setName(String str) {
        i.g(str, "<set-?>");
        this.name = str;
    }

    public final void setQuestionId(int i10) {
        this.questionId = i10;
    }

    public final void setTypeId(Integer num) {
        this.typeId = num;
    }

    public String toString() {
        return "QuestionBean(questionId=" + this.questionId + ", name=" + this.name + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
