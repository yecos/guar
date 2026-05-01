package g5;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hpplay.component.protocol.PlistBuilder;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.mobile.brasiltv.db.LiveSubProgram;
import com.msandroid.mobile.R;
import com.zhy.autolayout.utils.AutoUtils;

/* loaded from: classes3.dex */
public final class s0 extends BaseQuickAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final Context f13887a;

    /* renamed from: b, reason: collision with root package name */
    public final a f13888b;

    public interface a {
        void T(int i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s0(Context context, a aVar) {
        super(R.layout.adapter_live_sub_list_item, null);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        this.f13887a = context;
        this.f13888b = aVar;
    }

    public static final void c(s0 s0Var, BaseViewHolder baseViewHolder, View view) {
        t9.i.g(s0Var, "this$0");
        t9.i.g(baseViewHolder, "$helper");
        a aVar = s0Var.f13888b;
        if (aVar != null) {
            aVar.T(baseViewHolder.getAdapterPosition());
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void convert(final BaseViewHolder baseViewHolder, LiveSubProgram liveSubProgram) {
        t9.i.g(baseViewHolder, "helper");
        t9.i.g(liveSubProgram, PlistBuilder.KEY_ITEM);
        ((ImageView) baseViewHolder.getView(R.id.iv_live_sub)).setOnClickListener(new View.OnClickListener() { // from class: g5.r0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                s0.c(s0.this, baseViewHolder, view);
            }
        });
        baseViewHolder.setText(R.id.mTvEPG, liveSubProgram.getChannelName());
        if (TextUtils.isEmpty(liveSubProgram.getProgramName())) {
            baseViewHolder.setText(R.id.mEpgInfo, this.f13887a.getResources().getString(R.string.live_get_show));
        } else {
            StringBuilder sb = new StringBuilder();
            String substring = liveSubProgram.getStartTime().substring(11);
            t9.i.f(substring, "this as java.lang.String).substring(startIndex)");
            sb.append(substring);
            sb.append(ASCIIPropertyListParser.DATE_DATE_FIELD_DELIMITER);
            String substring2 = liveSubProgram.getEndTime().substring(11);
            t9.i.f(substring2, "this as java.lang.String).substring(startIndex)");
            sb.append(substring2);
            sb.append(' ');
            sb.append(liveSubProgram.getProgramName());
            baseViewHolder.setText(R.id.mEpgInfo, sb.toString());
        }
        baseViewHolder.addOnClickListener(R.id.mLayoutSubItem);
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
