package com.mobile.brasiltv.db;

import java.io.Serializable;
import sa.a;
import sa.e;
import t9.g;
import t9.i;

@e(name = "UmengMessage")
/* loaded from: classes3.dex */
public final class UmengMessage implements Serializable {
    private String contentId;
    private String extArgs;

    @a(column = "id")
    private int id;
    private String loginCity;
    private String loginCountry;
    private String loginIp;
    private String loginTime;
    private String messageTime;
    private String messageType;
    private String msgId;
    private String sn;
    private String status = UN_READ;
    private String text;
    private String ticker;
    private String title;
    private String type;
    private String userId;
    private String userToken;
    public static final Companion Companion = new Companion(null);
    private static String UN_READ = "0";
    private static String ALREADY_READ = "1";
    private static String TYPE_ORDER = "1";
    private static String TYPE_LOGIN = "2";
    private static String TYPE_UPGRADE = "99";

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final String getALREADY_READ() {
            return UmengMessage.ALREADY_READ;
        }

        public final String getTYPE_LOGIN() {
            return UmengMessage.TYPE_LOGIN;
        }

        public final String getTYPE_ORDER() {
            return UmengMessage.TYPE_ORDER;
        }

        public final String getTYPE_UPGRADE() {
            return UmengMessage.TYPE_UPGRADE;
        }

        public final String getUN_READ() {
            return UmengMessage.UN_READ;
        }

        public final void setALREADY_READ(String str) {
            i.g(str, "<set-?>");
            UmengMessage.ALREADY_READ = str;
        }

        public final void setTYPE_LOGIN(String str) {
            i.g(str, "<set-?>");
            UmengMessage.TYPE_LOGIN = str;
        }

        public final void setTYPE_ORDER(String str) {
            i.g(str, "<set-?>");
            UmengMessage.TYPE_ORDER = str;
        }

        public final void setTYPE_UPGRADE(String str) {
            i.g(str, "<set-?>");
            UmengMessage.TYPE_UPGRADE = str;
        }

        public final void setUN_READ(String str) {
            i.g(str, "<set-?>");
            UmengMessage.UN_READ = str;
        }
    }

    public final String getContentId() {
        return this.contentId;
    }

    public final String getExtArgs() {
        return this.extArgs;
    }

    public final int getId() {
        return this.id;
    }

    public final String getLoginCity() {
        return this.loginCity;
    }

    public final String getLoginCountry() {
        return this.loginCountry;
    }

    public final String getLoginIp() {
        return this.loginIp;
    }

    public final String getLoginTime() {
        return this.loginTime;
    }

    public final String getMessageTime() {
        return this.messageTime;
    }

    public final String getMessageType() {
        return this.messageType;
    }

    public final String getMsgId() {
        return this.msgId;
    }

    public final String getSn() {
        return this.sn;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTicker() {
        return this.ticker;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getUserToken() {
        return this.userToken;
    }

    public final void setContentId(String str) {
        this.contentId = str;
    }

    public final void setExtArgs(String str) {
        this.extArgs = str;
    }

    public final void setId(int i10) {
        this.id = i10;
    }

    public final void setLoginCity(String str) {
        this.loginCity = str;
    }

    public final void setLoginCountry(String str) {
        this.loginCountry = str;
    }

    public final void setLoginIp(String str) {
        this.loginIp = str;
    }

    public final void setLoginTime(String str) {
        this.loginTime = str;
    }

    public final void setMessageTime(String str) {
        this.messageTime = str;
    }

    public final void setMessageType(String str) {
        this.messageType = str;
    }

    public final void setMsgId(String str) {
        this.msgId = str;
    }

    public final void setSn(String str) {
        this.sn = str;
    }

    public final void setStatus(String str) {
        i.g(str, "<set-?>");
        this.status = str;
    }

    public final void setText(String str) {
        this.text = str;
    }

    public final void setTicker(String str) {
        this.ticker = str;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final void setType(String str) {
        this.type = str;
    }

    public final void setUserId(String str) {
        this.userId = str;
    }

    public final void setUserToken(String str) {
        this.userToken = str;
    }
}
