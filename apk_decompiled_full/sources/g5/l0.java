package g5;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import b6.r0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hpplay.component.protocol.PlistBuilder;
import com.msandroid.mobile.R;
import com.zhy.autolayout.utils.AutoUtils;
import java.util.Arrays;
import mobile.com.requestframe.utils.response.Channel;
import mobile.com.requestframe.utils.response.EpgResultData;

/* loaded from: classes3.dex */
public final class l0 extends BaseQuickAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final Context f13768a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f13769b;

    /* renamed from: c, reason: collision with root package name */
    public int f13770c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l0(Context context) {
        super(R.layout.adapter_live_info_item, null);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        this.f13768a = context;
        this.f13770c = -1;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, Channel channel) {
        t9.i.g(baseViewHolder, "helper");
        t9.i.g(channel, PlistBuilder.KEY_ITEM);
        int layoutPosition = baseViewHolder.getLayoutPosition();
        t9.z zVar = t9.z.f18964a;
        String format = String.format("%03d", Arrays.copyOf(new Object[]{Integer.valueOf(layoutPosition + 1)}, 1));
        t9.i.f(format, "format(format, *args)");
        if (layoutPosition == this.f13770c) {
            e(baseViewHolder);
        } else {
            f(baseViewHolder);
        }
        baseViewHolder.setText(R.id.mTextChannel, format + (char) 12288 + b(channel));
        a7.e eVar = a7.e.f288a;
        Context context = this.f13768a;
        String posterUrl = channel.getPosterUrl();
        View view = baseViewHolder.getView(R.id.mIvChannelLogo);
        t9.i.f(view, "helper.getView(R.id.mIvChannelLogo)");
        eVar.b(context, posterUrl, (ImageView) view, R.drawable.icon_channel_default_logo);
        if (this.f13769b) {
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
        r0.a aVar = b6.r0.A;
        if (aVar.d().isEmpty()) {
            baseViewHolder.setText(R.id.mTextEpgName, this.f13768a.getResources().getString(R.string.live_get_show));
        } else if (aVar.d().containsKey(channel.getChannelCode())) {
            Object obj = aVar.d().get(channel.getChannelCode());
            t9.i.d(obj);
            baseViewHolder.setText(R.id.mTextEpgName, ((EpgResultData) obj).getTitle());
            baseViewHolder.setGone(R.id.mTextEpgName, true);
        } else {
            baseViewHolder.setText(R.id.mTextEpgName, "");
            baseViewHolder.setGone(R.id.mTextEpgName, false);
        }
        baseViewHolder.addOnClickListener(R.id.mImageEpg);
        baseViewHolder.addOnClickListener(R.id.mFavWrapper);
        baseViewHolder.addOnClickListener(R.id.mLayoutProgram);
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
        this.f13770c = i10;
    }

    public final void d(boolean z10) {
        this.f13769b = z10;
    }

    public final void e(BaseViewHolder baseViewHolder) {
        baseViewHolder.setTextColor(R.id.mTextChannel, this.f13768a.getResources().getColor(R.color.color_important));
        baseViewHolder.setTextColor(R.id.mTextEpgName, this.f13768a.getResources().getColor(R.color.color_important));
        baseViewHolder.setBackgroundColor(R.id.live_info_item_rl, this.f13768a.getResources().getColor(R.color.color_161720));
        ((TextView) baseViewHolder.getView(R.id.mTextChannel)).setSelected(true);
    }

    public final void f(BaseViewHolder baseViewHolder) {
        baseViewHolder.setTextColor(R.id.mTextChannel, this.f13768a.getResources().getColor(R.color.color_ffffff));
        baseViewHolder.setTextColor(R.id.mTextEpgName, this.f13768a.getResources().getColor(R.color.color_ffffff));
        baseViewHolder.setBackgroundColor(R.id.live_info_item_rl, this.f13768a.getResources().getColor(R.color.color_1f202a));
        ((TextView) baseViewHolder.getView(R.id.mTextChannel)).setSelected(false);
    }

    public final void g(String str, int i10) {
        t9.i.g(str, "channelCode");
        if (this.mData.size() <= i10 || !t9.i.b(((Channel) this.mData.get(i10)).getChannelCode(), str)) {
            return;
        }
        notifyItemChanged(i10);
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
