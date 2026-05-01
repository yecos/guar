package mobile.com.requestframe.utils.response;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import java.util.List;
import t9.i;

/* loaded from: classes3.dex */
public final class ColumnContentsBean implements Serializable {
    private List<ChildColumnList> childColumnList;
    private Integer totalSize;

    public ColumnContentsBean(Integer num, List<ChildColumnList> list) {
        this.totalSize = num;
        this.childColumnList = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ColumnContentsBean copy$default(ColumnContentsBean columnContentsBean, Integer num, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            num = columnContentsBean.totalSize;
        }
        if ((i10 & 2) != 0) {
            list = columnContentsBean.childColumnList;
        }
        return columnContentsBean.copy(num, list);
    }

    public final Integer component1() {
        return this.totalSize;
    }

    public final List<ChildColumnList> component2() {
        return this.childColumnList;
    }

    public final ColumnContentsBean copy(Integer num, List<ChildColumnList> list) {
        return new ColumnContentsBean(num, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ColumnContentsBean)) {
            return false;
        }
        ColumnContentsBean columnContentsBean = (ColumnContentsBean) obj;
        return i.b(this.totalSize, columnContentsBean.totalSize) && i.b(this.childColumnList, columnContentsBean.childColumnList);
    }

    public final List<ChildColumnList> getChildColumnList() {
        return this.childColumnList;
    }

    public final Integer getTotalSize() {
        return this.totalSize;
    }

    public int hashCode() {
        Integer num = this.totalSize;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        List<ChildColumnList> list = this.childColumnList;
        return hashCode + (list != null ? list.hashCode() : 0);
    }

    public final void setChildColumnList(List<ChildColumnList> list) {
        this.childColumnList = list;
    }

    public final void setTotalSize(Integer num) {
        this.totalSize = num;
    }

    public String toString() {
        return "ColumnContentsBean(totalSize=" + this.totalSize + ", childColumnList=" + this.childColumnList + ASCIIPropertyListParser.ARRAY_END_TOKEN;
    }
}
