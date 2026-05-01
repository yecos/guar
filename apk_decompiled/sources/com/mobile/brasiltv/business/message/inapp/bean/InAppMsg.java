package com.mobile.brasiltv.business.message.inapp.bean;

import java.io.Serializable;
import sa.a;
import sa.e;
import t9.i;

@e(name = "in_app_msg")
/* loaded from: classes3.dex */
public final class InAppMsg implements Serializable {

    @a(column = "id")
    private int id;
    private String messageType = "";
    private String type = "";
    private String userId = "";
    private String title = "";
    private String text = "";
    private String orderId = "";
    private String url = "";
    private String avaliableCoin = "";
    private String minCoin = "";

    public final String getAvaliableCoin() {
        return this.avaliableCoin;
    }

    public final int getId() {
        return this.id;
    }

    public final String getMessageType() {
        return this.messageType;
    }

    public final String getMinCoin() {
        return this.minCoin;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void setAvaliableCoin(String str) {
        i.g(str, "<set-?>");
        this.avaliableCoin = str;
    }

    public final void setId(int i10) {
        this.id = i10;
    }

    public final void setMessageType(String str) {
        i.g(str, "<set-?>");
        this.messageType = str;
    }

    public final void setMinCoin(String str) {
        i.g(str, "<set-?>");
        this.minCoin = str;
    }

    public final void setOrderId(String str) {
        i.g(str, "<set-?>");
        this.orderId = str;
    }

    public final void setText(String str) {
        i.g(str, "<set-?>");
        this.text = str;
    }

    public final void setTitle(String str) {
        i.g(str, "<set-?>");
        this.title = str;
    }

    public final void setType(String str) {
        i.g(str, "<set-?>");
        this.type = str;
    }

    public final void setUrl(String str) {
        i.g(str, "<set-?>");
        this.url = str;
    }

    public final void setUserId(String str) {
        i.g(str, "<set-?>");
        this.userId = str;
    }

    public String toString() {
        return "InAppMsg(id=" + this.id + ", messageType='" + this.messageType + "', type='" + this.type + "', userId='" + this.userId + "', title='" + this.title + "', text='" + this.text + "', orderId='" + this.orderId + "', url='" + this.url + "', avaliableCoin='" + this.avaliableCoin + "', minCoin='" + this.minCoin + "')";
    }
}
