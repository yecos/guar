package com.taobao.agoo;

import android.content.Intent;
import android.text.TextUtils;
import com.taobao.accs.utl.ALog;
import com.taobao.agoo.BaseNotifyClickActivity;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class f implements BaseNotifyClickActivity.INotifyListener {
    @Override // com.taobao.agoo.BaseNotifyClickActivity.INotifyListener
    public String getMsgSource() {
        return "xiaomi";
    }

    @Override // com.taobao.agoo.BaseNotifyClickActivity.INotifyListener
    public String parseMsgFromIntent(Intent intent) {
        String str;
        if (intent == null) {
            return null;
        }
        try {
            str = (String) Class.forName("com.xiaomi.mipush.sdk.PushMessageHelper").getField("KEY_MESSAGE").get(null);
        } catch (Throwable unused) {
            str = null;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                str = "key_message";
            }
            Serializable serializableExtra = intent.getSerializableExtra(str);
            if (serializableExtra == null) {
                return null;
            }
            Class<?> cls = Class.forName("com.xiaomi.mipush.sdk.MiPushMessage");
            return (String) cls.getMethod("getContent", new Class[0]).invoke(cls.cast(serializableExtra), new Object[0]);
        } catch (Throwable th) {
            ALog.e("DefaultXiaoMi", "parseMsgFromIntent", th, new Object[0]);
            return null;
        }
    }
}
