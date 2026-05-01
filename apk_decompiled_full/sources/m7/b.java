package m7;

import android.content.Context;
import com.umeng.message.entity.UMessage;
import java.util.Map;

/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f16800a = "UMDomainHandler";

    /* renamed from: b, reason: collision with root package name */
    public boolean f16801b = true;

    public void a(Context context, UMessage uMessage) {
        if (uMessage.extra == null) {
            c("UMDomainHandler", "收到自定义消息: msg.extra = null");
            return;
        }
        c("UMDomainHandler", "收到自定义消息:" + uMessage.extra.toString());
        for (Map.Entry<String, String> entry : uMessage.extra.entrySet()) {
            c("UMDomainHandler", "Key = " + entry.getKey() + ", Value = " + entry.getValue());
            n7.a.e(context, entry.getKey(), entry.getValue());
        }
    }

    public void b(Context context, UMessage uMessage) {
        c("UMDomainHandler", "收到通知消息:" + uMessage.getRaw().toString());
    }

    public void c(String str, String str2) {
    }
}
