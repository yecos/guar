package com.hpplay.sdk.source.c;

import android.text.TextUtils;
import com.hpplay.sdk.source.business.cloud.AuthSDK;
import com.hpplay.sdk.source.common.store.Session;

/* loaded from: classes3.dex */
public class a {
    public static String a() {
        String token = Session.getInstance().getToken();
        if (TextUtils.isEmpty(token)) {
            AuthSDK.getInstance().authSDKByInvalidToken();
        }
        return token;
    }
}
