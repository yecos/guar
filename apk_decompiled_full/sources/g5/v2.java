package g5;

import android.content.Context;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hpplay.component.protocol.PlistBuilder;
import com.msandroid.mobile.R;

/* loaded from: classes3.dex */
public final class v2 extends j5.a {

    /* renamed from: a, reason: collision with root package name */
    public final Context f13928a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v2(Context context) {
        super(R.layout.adapter_search_history_item, null, 2, null);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        this.f13928a = context;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, String str) {
        t9.i.g(baseViewHolder, "helper");
        t9.i.g(str, PlistBuilder.KEY_ITEM);
        baseViewHolder.setText(R.id.tv_history_title, str);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        int itemCount = super.getItemCount();
        if (itemCount > 6) {
            return 6;
        }
        return itemCount;
    }
}
