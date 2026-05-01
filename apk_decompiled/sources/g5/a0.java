package g5;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.hpplay.component.protocol.PlistBuilder;
import com.mobile.brasiltv.bean.FeedBackContacTime;
import com.mobile.brasiltv.bean.FeedBackContactBean;
import com.mobile.brasiltv.bean.FeedBackTitleBean;
import com.msandroid.mobile.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mobile.com.requestframe.utils.response.FeedBackContactData;
import mobile.com.requestframe.utils.response.WorkInfoBean;

/* loaded from: classes3.dex */
public final class a0 extends BaseMultiItemQuickAdapter {

    /* renamed from: a, reason: collision with root package name */
    public static final a f13634a = new a(null);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(t9.g gVar) {
            this();
        }
    }

    public a0() {
        super(new ArrayList());
        addItemType(1, R.layout.item_feedback_service_item_title);
        addItemType(2, R.layout.item_feedback_service_item_contact);
        addItemType(3, R.layout.item_feedback_service_item_time);
    }

    public final void a(Context context, List list) {
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        t9.i.g(list, "feedBackContacts");
        List<T> data = getData();
        t9.i.f(data, "data");
        data.clear();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            FeedBackContactData feedBackContactData = (FeedBackContactData) it.next();
            if (!com.mobile.brasiltv.utils.b0.J(feedBackContactData.getName()) && !com.mobile.brasiltv.utils.b0.J(feedBackContactData.getLogo())) {
                data.add(new FeedBackTitleBean(feedBackContactData));
                int i10 = 0;
                for (Object obj : feedBackContactData.getWorkInfoList()) {
                    int i11 = i10 + 1;
                    if (i10 < 0) {
                        i9.j.j();
                    }
                    WorkInfoBean workInfoBean = (WorkInfoBean) obj;
                    if (feedBackContactData.getWorkInfoList().size() == 1) {
                        data.add(new FeedBackContactBean(workInfoBean.getContact(), context.getString(R.string.customer_service_land) + ": "));
                    } else {
                        data.add(new FeedBackContactBean(workInfoBean.getContact(), context.getString(R.string.customer_service_land) + ' ' + i11 + ": "));
                    }
                    String workingTimeDesc = workInfoBean.getWorkingTimeDesc();
                    List M = workingTimeDesc != null ? ba.t.M(workingTimeDesc, new String[]{","}, false, 0, 6, null) : null;
                    if (M != null) {
                        Iterator it2 = M.iterator();
                        while (it2.hasNext()) {
                            data.add(new FeedBackContacTime((String) it2.next()));
                        }
                    }
                    i10 = i11;
                }
            }
        }
        notifyDataSetChanged();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, MultiItemEntity multiItemEntity) {
        t9.i.g(baseViewHolder, "helper");
        t9.i.g(multiItemEntity, PlistBuilder.KEY_ITEM);
        int itemViewType = baseViewHolder.getItemViewType();
        if (itemViewType != 1) {
            if (itemViewType == 2) {
                FeedBackContactBean feedBackContactBean = (FeedBackContactBean) multiItemEntity;
                baseViewHolder.setText(R.id.tvContactName, feedBackContactBean.getName()).setText(R.id.tvContact, feedBackContactBean.getContact());
                return;
            } else {
                if (itemViewType != 3) {
                    return;
                }
                baseViewHolder.setText(R.id.tvTime, ((FeedBackContacTime) multiItemEntity).getTime());
                return;
            }
        }
        FeedBackTitleBean feedBackTitleBean = (FeedBackTitleBean) multiItemEntity;
        baseViewHolder.getView(R.id.line).setVisibility(baseViewHolder.getAdapterPosition() == 0 ? 8 : 0);
        a7.e eVar = a7.e.f288a;
        Context context = this.mContext;
        t9.i.f(context, "mContext");
        String logo = feedBackTitleBean.getLogo();
        View view = baseViewHolder.getView(R.id.ivIcon);
        t9.i.f(view, "helper.getView(R.id.ivIcon)");
        eVar.b(context, logo, (ImageView) view, R.mipmap.ic_logo);
        baseViewHolder.setText(R.id.tvName, feedBackTitleBean.getName());
    }
}
