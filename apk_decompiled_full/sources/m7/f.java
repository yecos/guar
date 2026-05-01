package m7;

import android.app.Notification;
import android.content.Context;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;
import com.umeng.message.UTrack;
import com.umeng.message.UmengMessageHandler;
import com.umeng.message.entity.UMessage;

/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final String f16828a = "f";

    /* renamed from: b, reason: collision with root package name */
    public static Context f16829b;

    /* renamed from: c, reason: collision with root package name */
    public static m7.b f16830c;

    /* renamed from: d, reason: collision with root package name */
    public static e f16831d;

    /* loaded from: classes3.dex */
    public class a extends UmengMessageHandler {
        @Override // com.umeng.message.UmengMessageHandler
        public void dealWithCustomMessage(Context context, UMessage uMessage) {
            UTrack.getInstance(context.getApplicationContext()).trackMsgClick(uMessage);
            f.f16830c.a(f.f16829b, uMessage);
            e eVar = f.f16831d;
            if (eVar != null) {
                eVar.a(context, uMessage);
            }
        }

        @Override // com.umeng.message.UmengMessageHandler
        public void dealWithNotificationMessage(Context context, UMessage uMessage) {
            f.f16830c.b(f.f16829b, uMessage);
            e eVar = f.f16831d;
            if (eVar != null) {
                eVar.b(context, uMessage);
            }
        }

        @Override // com.umeng.message.UmengMessageHandler
        public Notification getNotification(Context context, UMessage uMessage) {
            e eVar = f.f16831d;
            return eVar != null ? eVar.c(context, uMessage) : super.getNotification(context, uMessage);
        }

        @Override // com.umeng.message.UmengMessageHandler, com.umeng.message.api.UPushMessageHandler
        public void handleMessage(Context context, UMessage uMessage) {
            e eVar = f.f16831d;
            if (eVar != null) {
                eVar.d(context, uMessage);
            }
            super.handleMessage(context, uMessage);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends UmengMessageHandler {
    }

    /* loaded from: classes3.dex */
    public class c implements IUmengRegisterCallback {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f16832a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ PushAgent f16833b;

        public c(d dVar, PushAgent pushAgent) {
            this.f16832a = dVar;
            this.f16833b = pushAgent;
        }

        @Override // com.umeng.message.api.UPushRegisterCallback
        public void onFailure(String str, String str2) {
            String unused = f.f16828a;
            StringBuilder sb = new StringBuilder();
            sb.append("register failed: ");
            sb.append(str);
            sb.append(" ");
            sb.append(str2);
            d dVar = this.f16832a;
            if (dVar != null) {
                dVar.c(this.f16833b, str, str2);
            }
        }

        @Override // com.umeng.message.api.UPushRegisterCallback
        public void onSuccess(String str) {
            String unused = f.f16828a;
            StringBuilder sb = new StringBuilder();
            sb.append("device token: ");
            sb.append(str);
            d dVar = this.f16832a;
            if (dVar != null) {
                dVar.a(this.f16833b, str);
            }
        }
    }

    public interface d {
        void a(PushAgent pushAgent, String str);

        void b(PushAgent pushAgent);

        void c(PushAgent pushAgent, String str, String str2);
    }

    public static void b(Context context, String str, String str2, m7.a aVar, String str3, d dVar, String str4) {
        f16829b = context.getApplicationContext();
        f16830c = new m7.b();
        f(f16829b);
        UMConfigure.init(f16829b, str, str2, aVar.b(), str3);
        c(f16829b, dVar, str4);
    }

    public static void c(Context context, d dVar, String str) {
        PushAgent pushAgent = PushAgent.getInstance(context);
        if (str != null) {
            pushAgent.setResourcePackageName(str);
        }
        if (dVar != null) {
            dVar.b(pushAgent);
        }
        pushAgent.setNotificationPlaySound(2);
        pushAgent.setMessageHandler(new a());
        pushAgent.setNotificationClickHandler(new b());
        pushAgent.register(new c(dVar, pushAgent));
    }

    public static void d(Context context) {
        f16829b = context.getApplicationContext();
    }

    public static void e(e eVar) {
        f16831d = eVar;
    }

    public static void f(Context context) {
        int b10 = n7.b.b(context);
        if (n7.a.c(context) != b10) {
            n7.a.a(context);
            n7.a.f(context, b10);
        }
    }
}
