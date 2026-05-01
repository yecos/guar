package g5;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.android.gms.cast.MediaError;
import com.hpplay.component.protocol.PlistBuilder;
import com.mobile.brasiltv.view.AutoCardView;
import com.msandroid.mobile.R;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.utils.AutoUtils;

/* loaded from: classes3.dex */
public final class z1 extends j5.a {

    /* renamed from: a, reason: collision with root package name */
    public boolean f13983a;

    public z1(boolean z10) {
        super(R.layout.adapter_recommend_horizontal_default_item, null, 2, null);
        this.f13983a = z10;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, String str) {
        t9.i.g(baseViewHolder, "helper");
        t9.i.g(str, PlistBuilder.KEY_ITEM);
        if (!this.f13983a) {
            ((TextView) baseViewHolder.getView(R.id.mPosterName)).setVisibility(0);
            ((TextView) baseViewHolder.getView(R.id.mPosterNameSpecial)).setVisibility(8);
            return;
        }
        ((AutoLinearLayout) baseViewHolder.getView(R.id.mLinearLayout)).setPadding(7, 7, 7, 0);
        ((AutoLinearLayout) baseViewHolder.getView(R.id.mLinearLayout)).setBackgroundResource(R.drawable.bg_radius_white);
        ((AutoCardView) baseViewHolder.getView(R.id.mLayout)).setLayoutParams(new LinearLayout.LayoutParams(AutoUtils.getPercentWidthSize(210), AutoUtils.getPercentWidthSize(MediaError.DetailedErrorCode.HLS_NETWORK_INVALID_SEGMENT)));
        ((TextView) baseViewHolder.getView(R.id.mPosterNameSpecial)).setVisibility(0);
        ((TextView) baseViewHolder.getView(R.id.mPosterName)).setVisibility(8);
    }

    public /* synthetic */ z1(boolean z10, int i10, t9.g gVar) {
        this((i10 & 1) != 0 ? false : z10);
    }
}
