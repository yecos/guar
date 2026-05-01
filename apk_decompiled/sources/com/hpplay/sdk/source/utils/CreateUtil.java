package com.hpplay.sdk.source.utils;

import android.text.TextUtils;
import com.hpplay.common.utils.EncryptUtil;
import com.hpplay.sdk.source.common.store.Session;
import com.raizlabs.android.dbflow.sql.language.Operator;

/* loaded from: classes3.dex */
public class CreateUtil {
    public static String createEid() {
        return "A_" + Session.getInstance().getUID() + "_" + System.currentTimeMillis();
    }

    public static String createMirrorUri() {
        String str = Session.getInstance().getHID() + Session.getInstance().getUID() + System.currentTimeMillis() + Math.random();
        String md5EncryData = EncryptUtil.md5EncryData(str);
        if (!TextUtils.isEmpty(md5EncryData)) {
            str = md5EncryData;
        }
        return str.toUpperCase();
    }

    public static String createPassMsgID() {
        return EncryptUtil.md5EncryData(Session.getInstance().getUID()) + Operator.Operation.MINUS + String.valueOf(System.currentTimeMillis());
    }

    public static String createPushUri(String str) {
        return EncryptUtil.md5EncryData(str + String.valueOf(System.currentTimeMillis())).toUpperCase();
    }

    public static String createSessionId() {
        return EncryptUtil.md5EncryData((Session.getInstance().getUID() + String.valueOf(System.currentTimeMillis())).toUpperCase()).toUpperCase();
    }

    public static String createYimUserID() {
        return Session.getInstance().appKey + "_" + Session.getInstance().getUID();
    }
}
