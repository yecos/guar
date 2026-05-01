package f6;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hpplay.component.protocol.PlistBuilder;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.view.dialog.PaymentTipDialog;
import com.mobile.brasiltv.view.dialog.UploadVoucherDialog;
import com.msandroid.mobile.R;
import com.titans.entity.CdnType;
import com.zhy.autolayout.utils.AutoUtils;
import h9.t;
import mobile.com.requestframe.utils.response.GetOrderInfoData;
import org.android.agoo.message.MessageService;
import s9.l;

/* loaded from: classes3.dex */
public final class j extends BaseQuickAdapter {

    /* renamed from: b, reason: collision with root package name */
    public static final a f13315b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public l f13316a;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(t9.g gVar) {
            this();
        }
    }

    public static final class b extends t9.j implements l {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ GetOrderInfoData f13318b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(GetOrderInfoData getOrderInfoData) {
            super(1);
            this.f13318b = getOrderInfoData;
        }

        public final void b(PaymentTipDialog paymentTipDialog) {
            t9.i.g(paymentTipDialog, "it");
            l lVar = j.this.f13316a;
            if (lVar != null) {
                lVar.invoke(this.f13318b.getOrderId());
            }
            paymentTipDialog.dismiss();
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((PaymentTipDialog) obj);
            return t.f14242a;
        }
    }

    public j() {
        super(R.layout.adapter_order);
    }

    public static final void g(j jVar, GetOrderInfoData getOrderInfoData, View view) {
        t9.i.g(jVar, "this$0");
        t9.i.g(getOrderInfoData, "$item");
        Context context = jVar.mContext;
        t9.i.f(context, "mContext");
        new PaymentTipDialog(context, jVar.new b(getOrderInfoData)).show();
    }

    public static final void h(j jVar, GetOrderInfoData getOrderInfoData, View view) {
        t9.i.g(jVar, "this$0");
        t9.i.g(getOrderInfoData, "$item");
        Context context = jVar.mContext;
        t9.i.f(context, "mContext");
        String uploadUrl = getOrderInfoData.getUploadUrl();
        t9.i.d(uploadUrl);
        new UploadVoucherDialog(context, uploadUrl).show();
    }

    public static final void i(j jVar, GetOrderInfoData getOrderInfoData, View view) {
        t9.i.g(jVar, "this$0");
        t9.i.g(getOrderInfoData, "$item");
        Context context = jVar.mContext;
        t9.i.f(context, "mContext");
        b0.o(context, getOrderInfoData.getOrderId(), getOrderInfoData.getPaymentType(), getOrderInfoData.getPaymentPlatform());
    }

    public static final void j(j jVar, GetOrderInfoData getOrderInfoData, View view) {
        t9.i.g(jVar, "this$0");
        t9.i.g(getOrderInfoData, "$item");
        b0.U(jVar, ">>> enterOrderProgressPage state: " + getOrderInfoData.getState());
        Context context = jVar.mContext;
        t9.i.f(context, "mContext");
        b0.n(context, getOrderInfoData.getOrderId());
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void bindToRecyclerView(RecyclerView recyclerView) {
        if (getRecyclerView() != null) {
            getRecyclerView().setAdapter(this);
        } else {
            super.bindToRecyclerView(recyclerView);
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void convert(BaseViewHolder baseViewHolder, final GetOrderInfoData getOrderInfoData) {
        String substring;
        t9.i.g(baseViewHolder, "helper");
        t9.i.g(getOrderInfoData, PlistBuilder.KEY_ITEM);
        if (getOrderInfoData.getPackageType() == 1) {
            baseViewHolder.setText(R.id.mTextType, this.mContext.getResources().getString(R.string.mobile_vip));
        } else {
            baseViewHolder.setText(R.id.mTextType, this.mContext.getResources().getString(R.string.tv_vip));
        }
        l(baseViewHolder, getOrderInfoData);
        baseViewHolder.setText(R.id.mTextOrderName, this.mContext.getString(R.string.order_record_name, getOrderInfoData.getPackagePlanName(), String.valueOf(getOrderInfoData.getAuthorizedDays())));
        baseViewHolder.setText(R.id.mTvMoney, getOrderInfoData.getPaymentAmount());
        String paymentCurrency = getOrderInfoData.getPaymentCurrency();
        baseViewHolder.setText(R.id.mTvMoneyFlag, t9.i.b(paymentCurrency, "BRL") ? "R$" : t9.i.b(paymentCurrency, "USD") ? "$" : getOrderInfoData.getPaymentCurrency());
        baseViewHolder.setText(R.id.mTextOrderId, this.mContext.getResources().getString(R.string.order_number, getOrderInfoData.getOrderId()));
        if (TextUtils.isEmpty(getOrderInfoData.getCreateTime()) || getOrderInfoData.getCreateTime().length() < 16) {
            String c10 = y6.b.c();
            t9.i.f(c10, "getLocalUTCTime()");
            substring = c10.substring(0, 16);
            t9.i.f(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        } else {
            substring = y6.b.e(getOrderInfoData.getCreateTime(), "yyyy-MM-dd HH:mm:SS", "dd-MM-yyyy HH:mm");
        }
        baseViewHolder.setText(R.id.mTextOrderTime, this.mContext.getResources().getString(R.string.purchase_time, substring));
        baseViewHolder.setText(R.id.mTvPayMethod, this.mContext.getResources().getString(R.string.order_pay_method, getOrderInfoData.getPaymentType()));
        String paymentInfo = getOrderInfoData.getPaymentInfo();
        if (paymentInfo == null || paymentInfo.length() == 0) {
            baseViewHolder.setVisible(R.id.mTvPay, false);
        } else {
            baseViewHolder.setVisible(R.id.mTvPay, true);
        }
        String uploadUrl = getOrderInfoData.getUploadUrl();
        if (uploadUrl == null || uploadUrl.length() == 0) {
            baseViewHolder.setGone(R.id.mLayoutUploadVoucher, false);
        } else {
            baseViewHolder.setGone(R.id.mLayoutUploadVoucher, true);
        }
        baseViewHolder.setOnClickListener(R.id.mTvPay, new View.OnClickListener() { // from class: f6.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                j.g(j.this, getOrderInfoData, view);
            }
        });
        baseViewHolder.setOnClickListener(R.id.mTvUploadVoucher, new View.OnClickListener() { // from class: f6.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                j.h(j.this, getOrderInfoData, view);
            }
        });
        baseViewHolder.setOnClickListener(R.id.mTvFeedback, new View.OnClickListener() { // from class: f6.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                j.i(j.this, getOrderInfoData, view);
            }
        });
        baseViewHolder.setOnClickListener(R.id.mTvOrderProcess, new View.OnClickListener() { // from class: f6.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                j.j(j.this, getOrderInfoData, view);
            }
        });
    }

    public final void k(l lVar) {
        t9.i.g(lVar, "callback");
        this.f13316a = lVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0093, code lost:
    
        if (r2.equals(com.titans.entity.CdnType.DIGITAL_TYPE_PCDN) == false) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00c0, code lost:
    
        r11.setText(com.msandroid.mobile.R.id.mTextState, r10.mContext.getResources().getString(com.msandroid.mobile.R.string.transaction_failed));
        r11.setGone(com.msandroid.mobile.R.id.mTvNote, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00bc, code lost:
    
        if (r2.equals("3") == false) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00d8, code lost:
    
        if (r2.equals("2") == false) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00e6, code lost:
    
        r11.setText(com.msandroid.mobile.R.id.mTextState, r10.mContext.getResources().getString(com.msandroid.mobile.R.string.order_payment_complete));
        r11.setGone(com.msandroid.mobile.R.id.mTvNote, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00e2, code lost:
    
        if (r2.equals("1") == false) goto L89;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void l(BaseViewHolder baseViewHolder, GetOrderInfoData getOrderInfoData) {
        baseViewHolder.setGone(R.id.mTvReason, false);
        String state = getOrderInfoData.getState();
        String str = "";
        switch (state.hashCode()) {
            case 48:
                if (state.equals("0")) {
                    if (getOrderInfoData.isProcessing() != 1) {
                        baseViewHolder.setText(R.id.mTextState, this.mContext.getResources().getString(R.string.order_waiting_for_payment));
                        if (!TextUtils.equals(getOrderInfoData.getPaymentType(), "Boleto")) {
                            baseViewHolder.setVisible(R.id.mTvNote, true);
                            String paymentType = getOrderInfoData.getPaymentType();
                            switch (paymentType.hashCode()) {
                                case -1911368973:
                                    if (paymentType.equals("PayPal")) {
                                        str = this.mContext.getString(R.string.order_note_paypal);
                                        break;
                                    }
                                    break;
                                case -1650650849:
                                    if (paymentType.equals("Payment by Card")) {
                                        str = this.mContext.getString(R.string.order_note_payment_by_card);
                                        break;
                                    }
                                    break;
                                case -185857904:
                                    if (paymentType.equals("Santander")) {
                                        str = this.mContext.getString(R.string.order_note_santander);
                                        break;
                                    }
                                    break;
                                case -34572147:
                                    if (paymentType.equals("bradesco")) {
                                        str = this.mContext.getString(R.string.order_note_bradesco);
                                        break;
                                    }
                                    break;
                                case 3242655:
                                    if (paymentType.equals("itau")) {
                                        str = this.mContext.getString(R.string.order_note_itau);
                                        break;
                                    }
                                    break;
                                case 94423028:
                                    if (paymentType.equals("caixa")) {
                                        str = this.mContext.getString(R.string.order_note_caixa);
                                        break;
                                    }
                                    break;
                                case 642271019:
                                    if (paymentType.equals("bancodobrasil")) {
                                        str = this.mContext.getString(R.string.order_note_banco_do_brasil);
                                        break;
                                    }
                                    break;
                                case 1037568729:
                                    if (paymentType.equals("Bank deposits")) {
                                        str = this.mContext.getString(R.string.order_note_bank_deposits);
                                        break;
                                    }
                                    break;
                                case 1456686223:
                                    if (paymentType.equals("Card virtual Caixa")) {
                                        str = this.mContext.getString(R.string.order_note_virtual);
                                        break;
                                    }
                                    break;
                                case 1543015526:
                                    if (paymentType.equals("Payment in lotteries")) {
                                        str = this.mContext.getString(R.string.order_note_payment_in_lotteries);
                                        break;
                                    }
                                    break;
                            }
                            t9.i.f(str, "when (item.paymentType) … \"\"\n                    }");
                            baseViewHolder.setText(R.id.mTvNote, str);
                            break;
                        } else {
                            baseViewHolder.setGone(R.id.mTvNote, false);
                            break;
                        }
                    } else {
                        baseViewHolder.setText(R.id.mTextState, this.mContext.getResources().getString(R.string.order_processing_payment));
                        baseViewHolder.setGone(R.id.mTvNote, false);
                        break;
                    }
                }
                baseViewHolder.setText(R.id.mTextState, "");
                break;
            case 49:
                break;
            case 50:
                break;
            case 51:
                break;
            case 52:
                if (state.equals("4")) {
                    baseViewHolder.setText(R.id.mTextState, this.mContext.getResources().getString(R.string.order_refund_successful));
                    baseViewHolder.setGone(R.id.mTvNote, false);
                    break;
                }
                baseViewHolder.setText(R.id.mTextState, "");
                break;
            case 53:
                break;
            case 54:
                if (state.equals(CdnType.DIGITAL_TYPE_PEERSTAR)) {
                    baseViewHolder.setText(R.id.mTextState, this.mContext.getResources().getString(R.string.order_processing_payment));
                    baseViewHolder.setGone(R.id.mTvNote, false);
                    break;
                }
                baseViewHolder.setText(R.id.mTextState, "");
                break;
            case 55:
                if (state.equals("7")) {
                    baseViewHolder.setText(R.id.mTextState, this.mContext.getResources().getString(R.string.transaction_failed));
                    baseViewHolder.setText(R.id.mTvReason, this.mContext.getResources().getString(R.string.order_credit_card_declined));
                    baseViewHolder.setGone(R.id.mTvReason, true);
                    baseViewHolder.setGone(R.id.mTvNote, false);
                    break;
                }
                baseViewHolder.setText(R.id.mTextState, "");
                break;
            case 56:
                if (state.equals(MessageService.MSG_ACCS_NOTIFY_CLICK)) {
                    baseViewHolder.setText(R.id.mTextState, this.mContext.getResources().getString(R.string.order_transaction_closed));
                    baseViewHolder.setGone(R.id.mTvNote, false);
                    break;
                }
                baseViewHolder.setText(R.id.mTextState, "");
                break;
            default:
                baseViewHolder.setText(R.id.mTextState, "");
                break;
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.g
    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i10) {
        t9.i.g(viewGroup, "parent");
        BaseViewHolder onCreateViewHolder = super.onCreateViewHolder(viewGroup, i10);
        t9.i.f(onCreateViewHolder, "super.onCreateViewHolder(parent, viewType)");
        AutoUtils.autoSize(onCreateViewHolder.itemView);
        return onCreateViewHolder;
    }
}
