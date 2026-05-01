package x5;

import android.content.Context;
import com.hpplay.sdk.source.common.global.Constant;
import com.mobile.brasiltv.business.message.inapp.bean.InAppMsg;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.view.dialog.CommonDialog;
import com.mobile.brasiltv.view.dialog.DialogManager;
import h9.t;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class g extends CommonDialog {

    /* renamed from: a, reason: collision with root package name */
    public Context f19462a;

    /* renamed from: b, reason: collision with root package name */
    public InAppMsg f19463b;

    public static final class a extends t9.j implements s9.l {
        public a() {
            super(1);
        }

        public final void b(List list) {
            t9.i.g(list, "it");
            if (b0.I(list)) {
                w5.m.f19178a.W(g.this.getMContext(), (InAppMsg) list.get(0));
            }
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((List) obj);
            return t.f14242a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(Context context, InAppMsg inAppMsg) {
        super(context, 0, 2, null);
        t9.i.g(context, "mContext");
        t9.i.g(inAppMsg, Constant.KEY_MSG);
        this.f19462a = context;
        this.f19463b = inAppMsg;
    }

    public final InAppMsg a() {
        return this.f19463b;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        b0.R(this);
        DialogManager.INSTANCE.clearSaveDialog(DialogManager.DIALOG_INAPP_MSG_COUPON_BENEFITS, DialogManager.DIALOG_INAPP_MSG_SERVICE_EFFECT, DialogManager.DIALOG_INAPP_MSG_ORDER_PAY_FAILURE, DialogManager.DIALOG_INAPP_MSG_GET_CASHBACK, DialogManager.DIALOG_INAPP_MSG_ACTIVITY_REMIND);
        w5.m.f19178a.M(new a());
    }

    public final Context getMContext() {
        return this.f19462a;
    }

    @Override // com.mobile.brasiltv.view.dialog.CommonDialog, android.app.Dialog
    public void show() {
        super.show();
        w5.m.f19178a.r(this.f19463b);
    }
}
