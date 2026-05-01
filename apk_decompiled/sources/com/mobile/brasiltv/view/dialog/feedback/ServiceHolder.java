package com.mobile.brasiltv.view.dialog.feedback;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.view.LinearLayoutManagerWrapper;
import g5.a0;
import java.util.ArrayList;
import java.util.List;
import mobile.com.requestframe.utils.response.FeedBackContactData;
import mobile.com.requestframe.utils.response.FeedBackContactResult;
import mobile.com.requestframe.utils.response.WorkInfoBean;
import t9.i;
import w6.i;

/* loaded from: classes3.dex */
public final class ServiceHolder extends BaseFeedbackHodler {
    private a0 mAdapter;
    private boolean mIsRequesting;
    private boolean mIsShow;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServiceHolder(RecyclerView recyclerView, IFeedbackView iFeedbackView) {
        super(recyclerView, iFeedbackView);
        i.g(recyclerView, "recyclerView");
        i.g(iFeedbackView, "dialog");
        this.mAdapter = new a0();
        recyclerView.setLayoutManager(new LinearLayoutManagerWrapper(getHost().getContext()));
        recyclerView.setAdapter(this.mAdapter);
    }

    private final void getCustomerService() {
        getHost().showLoading(true);
        w6.i.f19214g.b().k1().subscribe(new ha.a() { // from class: com.mobile.brasiltv.view.dialog.feedback.ServiceHolder$getCustomerService$1
            @Override // ha.a
            public void showErrorHint(String str) {
                boolean z10;
                i.g(str, "returnCode");
                ServiceHolder.this.mIsRequesting = false;
                z10 = ServiceHolder.this.mIsShow;
                if (z10) {
                    ServiceHolder.this.getHost().showLoading(false);
                    f1.f8649a.u(str);
                }
            }

            @Override // ha.a, io.reactivex.Observer
            public void onNext(FeedBackContactResult feedBackContactResult) {
                a0 a0Var;
                i.g(feedBackContactResult, "t");
                ServiceHolder.this.mIsRequesting = false;
                ServiceHolder.this.getHost().showLoading(false);
                Context context = ServiceHolder.this.getHost().getContext();
                if (context != null) {
                    a0Var = ServiceHolder.this.mAdapter;
                    a0Var.a(context, w6.i.f19214g.o());
                }
            }
        });
    }

    private final List<FeedBackContactData> getTestData() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new WorkInfoBean("Mon to Fri: 8:00 - 15:30 ,Sunday: 18:00 -23:00", "1151555115"));
        arrayList2.add(new WorkInfoBean("Mon to Fri: 8:00 - 15:30", "1151555115"));
        arrayList.add(new FeedBackContactData("WhatsApp", arrayList2, ""));
        ArrayList arrayList3 = new ArrayList();
        arrayList3.add(new WorkInfoBean("Mon to Fri: 8:00 - 15:30 ,Sunday: 18:00 -23:00", "1151555115"));
        arrayList.add(new FeedBackContactData("Facebook", arrayList3, ""));
        ArrayList arrayList4 = new ArrayList();
        arrayList4.add(new WorkInfoBean("Mon to Fri: 8:00 - 15:30 ,Sunday: 18:00 -23:00", "1151555115"));
        arrayList4.add(new WorkInfoBean("Mon to Fri: 8:00 - 15:30 ,Sunday: 18:00 -23:00", "1151555115"));
        arrayList4.add(new WorkInfoBean("Mon to Fri: 8:00 - 15:30 ,Sunday: 18:00 -23:00", "1151555115"));
        arrayList.add(new FeedBackContactData("Facebook", arrayList4, ""));
        return arrayList;
    }

    @Override // com.mobile.brasiltv.view.dialog.feedback.BaseFeedbackHodler
    public void clickSubmit() {
    }

    @Override // com.mobile.brasiltv.view.dialog.feedback.BaseFeedbackHodler
    public void dialogCancel() {
        this.mIsShow = false;
    }

    @Override // com.mobile.brasiltv.view.dialog.feedback.BaseFeedbackHodler
    public void show(boolean z10) {
        this.mIsShow = z10;
        super.show(z10);
        if (this.mIsShow && this.mAdapter.getData().size() == 0) {
            i.c cVar = w6.i.f19214g;
            if (!cVar.o().isEmpty()) {
                Context context = getHost().getContext();
                if (context != null) {
                    this.mAdapter.a(context, cVar.o());
                    return;
                }
                return;
            }
            if (this.mIsRequesting) {
                getHost().showLoading(true);
            } else {
                this.mIsRequesting = true;
                getCustomerService();
            }
        }
    }
}
