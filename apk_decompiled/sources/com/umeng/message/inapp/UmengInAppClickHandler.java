package com.umeng.message.inapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.message.entity.UInAppMessage;

/* loaded from: classes3.dex */
public class UmengInAppClickHandler implements UInAppHandler {

    /* renamed from: a, reason: collision with root package name */
    private static final String f11412a = "com.umeng.message.inapp.UmengInAppClickHandler";

    /* renamed from: b, reason: collision with root package name */
    private String f11413b = null;

    /* renamed from: c, reason: collision with root package name */
    private String f11414c = null;

    /* renamed from: d, reason: collision with root package name */
    private String f11415d = null;

    @Override // com.umeng.message.inapp.UInAppHandler
    public final void handleInAppMessage(Activity activity, UInAppMessage uInAppMessage, int i10) {
        switch (i10) {
            case 16:
                this.f11413b = uInAppMessage.action_type;
                this.f11414c = uInAppMessage.action_activity;
                this.f11415d = uInAppMessage.action_url;
                break;
            case 17:
                this.f11413b = uInAppMessage.bottom_action_type;
                this.f11414c = uInAppMessage.bottom_action_activity;
                this.f11415d = uInAppMessage.bottom_action_url;
                break;
            case 18:
                this.f11413b = uInAppMessage.plainTextActionType;
                this.f11414c = uInAppMessage.plainTextActivity;
                this.f11415d = uInAppMessage.plainTextUrl;
                break;
            case 19:
                this.f11413b = uInAppMessage.customButtonActionType;
                this.f11414c = uInAppMessage.customButtonActivity;
                this.f11415d = uInAppMessage.customButtonUrl;
                break;
        }
        if (TextUtils.isEmpty(this.f11413b)) {
            return;
        }
        if (TextUtils.equals("go_activity", this.f11413b)) {
            openActivity(activity, this.f11414c);
        } else if (TextUtils.equals("go_url", this.f11413b)) {
            openUrl(activity, this.f11415d);
        } else {
            TextUtils.equals("go_app", this.f11413b);
        }
    }

    public void openActivity(Activity activity, String str) {
        if (str != null) {
            try {
                if (TextUtils.isEmpty(str.trim())) {
                    return;
                }
                UMLog.mutlInfo(f11412a, 2, "打开Activity: ".concat(str));
                Intent intent = new Intent();
                intent.setClassName(activity, str);
                intent.setFlags(536870912);
                activity.startActivity(intent);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public void openUrl(Activity activity, String str) {
        if (str != null) {
            try {
                if (TextUtils.isEmpty(str.trim())) {
                    return;
                }
                UMLog.mutlInfo(f11412a, 2, "打开链接: ".concat(str));
                activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }
}
