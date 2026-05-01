package g5;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.msandroid.mobile.R;
import java.util.Arrays;
import mobile.com.requestframe.utils.response.Channel;

/* loaded from: classes3.dex */
public final class j0 extends BaseQuickAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final Context f13725a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f13726b;

    /* renamed from: c, reason: collision with root package name */
    public int f13727c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j0(Context context) {
        super(R.layout.adapter_live_channel_item);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        this.f13725a = context;
        this.f13727c = -1;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, Channel channel) {
        t9.i.g(baseViewHolder, "helper");
        t9.i.g(channel, "bean");
        int layoutPosition = baseViewHolder.getLayoutPosition();
        t9.z zVar = t9.z.f18964a;
        String format = String.format("%03d", Arrays.copyOf(new Object[]{Integer.valueOf(layoutPosition + 1)}, 1));
        t9.i.f(format, "format(format, *args)");
        baseViewHolder.setText(R.id.mTextChannel, format + (char) 12288 + b(channel));
        a7.e eVar = a7.e.f288a;
        Context context = this.f13725a;
        String posterUrl = channel.getPosterUrl();
        View view = baseViewHolder.getView(R.id.mIvChannelLogo);
        t9.i.f(view, "helper.getView(R.id.mIvChannelLogo)");
        eVar.b(context, posterUrl, (ImageView) view, R.drawable.icon_channel_default_logo);
        if (this.f13726b) {
            baseViewHolder.setVisible(R.id.mFavWrapper, true);
            if (d6.a.f12650a.l(channel.getChannelCode())) {
                baseViewHolder.setGone(R.id.mIvFav, false);
                baseViewHolder.setGone(R.id.mPbUnfav, true);
            } else {
                baseViewHolder.setGone(R.id.mIvFav, true);
                baseViewHolder.setGone(R.id.mPbUnfav, false);
            }
        } else {
            baseViewHolder.setGone(R.id.mFavWrapper, false);
        }
        if (this.f13727c == baseViewHolder.getLayoutPosition()) {
            baseViewHolder.setTextColor(R.id.mTextChannel, this.mContext.getResources().getColor(R.color.color_important));
            baseViewHolder.setBackgroundColor(R.id.mLayout, this.mContext.getResources().getColor(R.color.color_80000000));
            ((TextView) baseViewHolder.getView(R.id.mTextChannel)).setSelected(true);
        } else {
            baseViewHolder.setTextColor(R.id.mTextChannel, -1);
            baseViewHolder.setBackgroundColor(R.id.mLayout, this.mContext.getResources().getColor(R.color.color_33000000));
            ((TextView) baseViewHolder.getView(R.id.mTextChannel)).setSelected(false);
        }
        baseViewHolder.addOnClickListener(R.id.mFavWrapper);
    }

    public final String b(Channel channel) {
        if (com.mobile.brasiltv.utils.f0.b() || TextUtils.isEmpty(channel.getAlias())) {
            return channel.getName();
        }
        String alias = channel.getAlias();
        t9.i.d(alias);
        return alias;
    }

    public final void c(int i10) {
        this.f13727c = i10;
        notifyDataSetChanged();
    }

    public final void d(boolean z10) {
        this.f13726b = z10;
    }

    public final void e(String str, int i10) {
        t9.i.g(str, "channelCode");
        if (this.mData.size() <= i10 || !t9.i.b(((Channel) this.mData.get(i10)).getChannelCode(), str)) {
            return;
        }
        notifyItemChanged(i10);
    }
}
