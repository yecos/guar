package g5;

import android.content.Context;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hpplay.component.protocol.PlistBuilder;
import com.mobile.brasiltv.bean.LiveTabEntity;
import com.msandroid.mobile.R;

/* loaded from: classes3.dex */
public final class v0 extends BaseQuickAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final Context f13925a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v0(Context context) {
        super(R.layout.adapter_live_tab_frag_recyclerview, null);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        this.f13925a = context;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, LiveTabEntity liveTabEntity) {
        t9.i.g(liveTabEntity, PlistBuilder.KEY_ITEM);
        if (baseViewHolder != null) {
            baseViewHolder.setText(R.id.name, liveTabEntity.getName());
        }
        TextView textView = baseViewHolder != null ? (TextView) baseViewHolder.getView(R.id.name) : null;
        if (liveTabEntity.isSelected()) {
            if (textView == null) {
                return;
            }
            textView.setBackground(this.f13925a.getResources().getDrawable(R.drawable.bg_livetab_recyclerview));
        } else {
            if (textView == null) {
                return;
            }
            textView.setBackground(null);
        }
    }
}
