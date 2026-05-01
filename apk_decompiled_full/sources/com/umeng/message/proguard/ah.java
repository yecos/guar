package com.umeng.message.proguard;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.firebase.messaging.Constants;
import com.hpplay.sdk.source.common.global.Constant;
import com.umeng.message.entity.UInAppMessage;
import com.umeng.message.inapp.IUmengInAppMsgCloseCallback;
import com.umeng.message.inapp.InAppMessageManager;
import com.umeng.message.inapp.UmengCardMessage;
import com.umeng.message.proguard.ag;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Calendar;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class ah implements ae, ag.a {

    /* renamed from: a, reason: collision with root package name */
    public static final String f11471a = "com.umeng.message.proguard.ah";

    /* renamed from: b, reason: collision with root package name */
    public Context f11472b;

    /* renamed from: c, reason: collision with root package name */
    public String f11473c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f11474d;

    /* renamed from: e, reason: collision with root package name */
    private UInAppMessage f11475e;

    /* renamed from: f, reason: collision with root package name */
    private IUmengInAppMsgCloseCallback f11476f;

    public ah(Activity activity, String str, IUmengInAppMsgCloseCallback iUmengInAppMsgCloseCallback) {
        this.f11472b = activity;
        this.f11473c = str;
        this.f11476f = iUmengInAppMsgCloseCallback;
    }

    @Override // com.umeng.message.proguard.ae
    public final void a(UInAppMessage uInAppMessage) {
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0024  */
    @Override // com.umeng.message.proguard.ae
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(UInAppMessage uInAppMessage) {
        UInAppMessage uInAppMessage2;
        String a10 = InAppMessageManager.getInstance(this.f11472b).a(this.f11473c);
        if (!TextUtils.isEmpty(a10)) {
            try {
                uInAppMessage2 = new UInAppMessage(new JSONObject(a10));
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
            if (uInAppMessage == null) {
                if (uInAppMessage2 != null && !uInAppMessage.msg_id.equals(uInAppMessage2.msg_id)) {
                    InAppMessageManager.getInstance(this.f11472b).a(new File(f.a(this.f11472b, uInAppMessage2.msg_id)));
                }
                this.f11475e = uInAppMessage;
            } else if (uInAppMessage2 == null) {
                return;
            } else {
                this.f11475e = uInAppMessage2;
            }
            if (this.f11475e.show_type == 1 && !b(this.f11473c)) {
                InAppMessageManager.getInstance(this.f11472b).a(this.f11475e.msg_id, 0);
            }
            InAppMessageManager.getInstance(this.f11472b);
            if (InAppMessageManager.b(this.f11475e) || !InAppMessageManager.getInstance(this.f11472b).c(this.f11475e)) {
            }
            int i10 = this.f11475e.msg_type;
            if (i10 == 5 || i10 == 6) {
                InAppMessageManager.getInstance(this.f11472b).a(this.f11475e, this.f11473c);
                a();
                return;
            } else {
                ag agVar = new ag(this.f11472b, this.f11475e);
                agVar.f11468a = this;
                agVar.execute(this.f11475e.image_url);
                return;
            }
        }
        uInAppMessage2 = null;
        if (uInAppMessage == null) {
        }
        if (this.f11475e.show_type == 1) {
            InAppMessageManager.getInstance(this.f11472b).a(this.f11475e.msg_id, 0);
        }
        InAppMessageManager.getInstance(this.f11472b);
        if (InAppMessageManager.b(this.f11475e)) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(String str) {
        JSONArray jSONArray;
        if (!d.a(this.f11472b).equals(InAppMessageManager.getInstance(this.f11472b).a("KEY_LAST_VERSION_CODE", ""))) {
            InAppMessageManager.getInstance(this.f11472b).b("KEY_CARD_LABEL_LIST", "");
        }
        InAppMessageManager.getInstance(this.f11472b).b("KEY_LAST_VERSION_CODE", d.a(this.f11472b));
        String a10 = InAppMessageManager.getInstance(this.f11472b).a("KEY_CARD_LABEL_LIST", "");
        if (!TextUtils.isEmpty(a10)) {
            try {
                jSONArray = new JSONArray(a10);
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
            if (jSONArray != null) {
                JSONArray jSONArray2 = new JSONArray();
                jSONArray2.put(str);
                InAppMessageManager.getInstance(this.f11472b).b("KEY_CARD_LABEL_LIST", jSONArray2.toString());
                return true;
            }
            if (a(jSONArray, str)) {
                return true;
            }
            if (jSONArray.length() >= 10) {
                return false;
            }
            jSONArray.put(str);
            InAppMessageManager.getInstance(this.f11472b).b("KEY_CARD_LABEL_LIST", jSONArray.toString());
            return true;
        }
        jSONArray = null;
        if (jSONArray != null) {
        }
    }

    private boolean b(String str) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(InAppMessageManager.getInstance(this.f11472b).c(str));
        Calendar calendar2 = Calendar.getInstance();
        return calendar.get(6) == calendar2.get(6) && calendar.get(1) == calendar2.get(1);
    }

    private static boolean a(JSONArray jSONArray, String str) {
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            try {
                if (jSONArray.getString(i10).equals(str)) {
                    return true;
                }
            } catch (JSONException e10) {
                e10.printStackTrace();
            }
        }
        return false;
    }

    private void a() {
        try {
            UmengCardMessage umengCardMessage = new UmengCardMessage();
            umengCardMessage.f11390a = this.f11476f;
            Bundle bundle = new Bundle();
            bundle.putString(Constants.ScionAnalytics.PARAM_LABEL, this.f11473c);
            bundle.putString(Constant.KEY_MSG, this.f11475e.getRaw().toString());
            umengCardMessage.setArguments(bundle);
            umengCardMessage.show(((Activity) this.f11472b).getFragmentManager(), this.f11473c);
            InAppMessageManager.getInstance(this.f11472b).a(this.f11475e.msg_id, 1);
            InAppMessageManager.getInstance(this.f11472b).b(this.f11473c);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    @Override // com.umeng.message.proguard.ag.a
    public final void a(Bitmap[] bitmapArr) {
        Bitmap bitmap;
        if (!this.f11474d && (bitmap = bitmapArr[0]) != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                UmengCardMessage umengCardMessage = new UmengCardMessage();
                umengCardMessage.f11390a = this.f11476f;
                Bundle bundle = new Bundle();
                bundle.putString(Constants.ScionAnalytics.PARAM_LABEL, this.f11473c);
                bundle.putString(Constant.KEY_MSG, this.f11475e.getRaw().toString());
                bundle.putByteArray("bitmapByte", byteArray);
                umengCardMessage.setArguments(bundle);
                umengCardMessage.show(((Activity) this.f11472b).getFragmentManager(), this.f11473c);
                InAppMessageManager.getInstance(this.f11472b).a(this.f11475e.msg_id, 1);
                InAppMessageManager.getInstance(this.f11472b).b(this.f11473c);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        InAppMessageManager.getInstance(this.f11472b).a(this.f11475e, this.f11473c);
    }
}
