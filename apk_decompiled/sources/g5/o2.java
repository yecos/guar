package g5;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.io.Serializable;
import java.util.List;
import mobile.com.requestframe.utils.response.ChildColumnList;

/* loaded from: classes3.dex */
public final class o2 extends f1 implements MultiItemEntity, Serializable {
    public o2(ChildColumnList childColumnList, List list, int i10) {
        super(childColumnList, list, i10);
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return a6.d.f249a.d();
    }
}
