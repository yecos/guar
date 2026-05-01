package g5;

import android.content.Context;
import android.view.ViewGroup;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hpplay.component.protocol.PlistBuilder;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.msandroid.mobile.R;
import com.zhy.autolayout.utils.AutoUtils;
import mobile.com.requestframe.utils.response.Program;

/* loaded from: classes3.dex */
public final class k0 extends BaseQuickAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final Context f13746a;

    /* renamed from: b, reason: collision with root package name */
    public final a f13747b;

    /* renamed from: c, reason: collision with root package name */
    public int f13748c;

    public interface a {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k0(Context context, a aVar) {
        super(R.layout.adapter_live_epg_item, null);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        this.f13746a = context;
        this.f13747b = aVar;
        this.f13748c = -1;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, Program program) {
        t9.i.g(baseViewHolder, "helper");
        t9.i.g(program, PlistBuilder.KEY_ITEM);
        if (baseViewHolder.getLayoutPosition() == this.f13748c) {
            b(baseViewHolder);
        } else {
            c(baseViewHolder);
        }
        StringBuilder sb = new StringBuilder();
        String substring = program.getStartTime().substring(11, 16);
        t9.i.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        sb.append(substring);
        sb.append(ASCIIPropertyListParser.DATE_DATE_FIELD_DELIMITER);
        String substring2 = program.getEndTime().substring(11, 16);
        t9.i.f(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
        sb.append(substring2);
        baseViewHolder.setText(R.id.mTextTime, sb.toString());
        baseViewHolder.setText(R.id.mTextEpgProgram, program.getProgramName());
        baseViewHolder.addOnClickListener(R.id.mLayoutEpgItem);
    }

    public final void b(BaseViewHolder baseViewHolder) {
        baseViewHolder.setTextColor(R.id.mTextTime, this.f13746a.getResources().getColor(R.color.color_important));
        baseViewHolder.setTextColor(R.id.mTextEpgProgram, this.f13746a.getResources().getColor(R.color.color_important));
        baseViewHolder.setBackgroundColor(R.id.mLayoutEpgItem, this.f13746a.getResources().getColor(R.color.color_161720));
    }

    public final void c(BaseViewHolder baseViewHolder) {
        baseViewHolder.setTextColor(R.id.mTextTime, this.f13746a.getResources().getColor(R.color.color_ffffff));
        baseViewHolder.setTextColor(R.id.mTextEpgProgram, this.f13746a.getResources().getColor(R.color.color_ffffff));
        baseViewHolder.setBackgroundColor(R.id.mLayoutEpgItem, this.f13746a.getResources().getColor(R.color.color_1f202a));
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
