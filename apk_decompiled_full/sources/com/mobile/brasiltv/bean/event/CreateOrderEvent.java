package com.mobile.brasiltv.bean.event;

import t9.i;

/* loaded from: classes3.dex */
public final class CreateOrderEvent {
    private String paymentType;

    public CreateOrderEvent(String str) {
        i.g(str, "paymentType");
        this.paymentType = str;
    }

    public final String getPaymentType() {
        return this.paymentType;
    }

    public final void setPaymentType(String str) {
        i.g(str, "<set-?>");
        this.paymentType = str;
    }
}
