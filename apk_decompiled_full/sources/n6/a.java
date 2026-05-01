package n6;

import android.view.ViewGroup;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhy.autolayout.utils.AutoUtils;
import java.util.Iterator;
import java.util.List;
import mobile.com.requestframe.utils.response.SimpleProgramList;

/* loaded from: classes3.dex */
public abstract class a extends j5.a {

    /* renamed from: a, reason: collision with root package name */
    public int f17273a;

    /* JADX WARN: Multi-variable type inference failed */
    public a(int i10) {
        super(i10, null, 2, 0 == true ? 1 : 0);
        this.f17273a = -1;
    }

    public final int a() {
        return this.f17273a;
    }

    public final void b(int i10) {
        this.f17273a = i10;
    }

    public void c(int i10) {
        this.f17273a = i10;
        List data = getData();
        t9.i.f(data, "data");
        Iterator it = data.iterator();
        while (it.hasNext()) {
            ((SimpleProgramList) it.next()).setPlayed(false);
        }
        notifyDataSetChanged();
        if (this.f17273a != -1) {
            SimpleProgramList simpleProgramList = (SimpleProgramList) getItem(i10);
            if (simpleProgramList != null) {
                simpleProgramList.setPlayed(true);
            }
            notifyItemChanged(i10);
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.g
    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        t9.i.g(viewGroup, "parent");
        BaseViewHolder onCreateViewHolder = super.onCreateViewHolder(viewGroup, i10);
        t9.i.f(onCreateViewHolder, "super.onCreateViewHolder(parent, viewType)");
        AutoUtils.autoSize(onCreateViewHolder.convertView);
        return onCreateViewHolder;
    }
}
