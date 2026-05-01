package n6;

import com.chad.library.adapter.base.BaseViewHolder;
import com.hpplay.component.protocol.PlistBuilder;
import com.msandroid.mobile.R;
import mobile.com.requestframe.utils.response.SimpleProgramList;

/* loaded from: classes3.dex */
public final class d extends a {
    public d() {
        super(R.layout.adapter_select_tv_program);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, SimpleProgramList simpleProgramList) {
        t9.i.g(baseViewHolder, "helper");
        t9.i.g(simpleProgramList, PlistBuilder.KEY_ITEM);
        baseViewHolder.setText(R.id.text_set, String.valueOf(simpleProgramList.getSeriesNumber()));
        if (simpleProgramList.isPlayed()) {
            baseViewHolder.setVisible(R.id.text_set, false);
            baseViewHolder.setVisible(R.id.img_play, true);
            baseViewHolder.convertView.setSelected(true);
        } else {
            baseViewHolder.setVisible(R.id.text_set, true);
            baseViewHolder.setVisible(R.id.img_play, false);
            baseViewHolder.convertView.setSelected(false);
        }
    }
}
