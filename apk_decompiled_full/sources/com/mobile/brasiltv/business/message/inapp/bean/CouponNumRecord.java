package com.mobile.brasiltv.business.message.inapp.bean;

import java.io.Serializable;
import sa.a;
import sa.e;
import t9.i;

@e(name = "coupon_num_record")
/* loaded from: classes3.dex */
public final class CouponNumRecord implements Serializable {

    @a(column = "id")
    private int id;
    private int num;
    private String userId = "";

    public final int getId() {
        return this.id;
    }

    public final int getNum() {
        return this.num;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void setId(int i10) {
        this.id = i10;
    }

    public final void setNum(int i10) {
        this.num = i10;
    }

    public final void setUserId(String str) {
        i.g(str, "<set-?>");
        this.userId = str;
    }
}
