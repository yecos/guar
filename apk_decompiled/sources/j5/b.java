package j5;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import java.util.List;
import t9.i;

/* loaded from: classes3.dex */
public abstract class b extends BaseMultiItemQuickAdapter {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(List list) {
        super(list);
        i.g(list, "datas");
    }
}
