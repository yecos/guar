package com.mobile.brasiltv.service;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.hpplay.component.common.ParamsMap;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.p0;
import java.util.Map;
import mobile.com.requestframe.utils.response.BaseResult;
import t9.i;
import w5.m;
import w6.i;

/* loaded from: classes3.dex */
public final class MyFirebaseMessagingService extends FirebaseMessagingService {

    /* renamed from: a, reason: collision with root package name */
    public final String f8585a = MyFirebaseMessagingService.class.getSimpleName();

    public static final class a extends ha.a {
        @Override // ha.a, io.reactivex.Observer
        public void onNext(BaseResult baseResult) {
            i.g(baseResult, "t");
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            i.g(str, "returnCode");
        }
    }

    public final void c(Map map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        b0.U(this, "receive in app message.");
        m.f19178a.Q(map);
    }

    public final void d() {
        i.c cVar = w6.i.f19214g;
        String H = cVar.H();
        if (H == null || H.length() == 0) {
            return;
        }
        String e10 = na.a.e();
        t9.i.f(e10, "getDeviceToken()");
        if (e10.length() == 0) {
            return;
        }
        cVar.b().o2().compose(p0.b()).subscribe(new a());
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onDeletedMessages() {
        super.onDeletedMessages();
        b0.U(this, this.f8585a + ", onDeletedMessages");
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onMessageReceived(RemoteMessage remoteMessage) {
        t9.i.g(remoteMessage, "remoteMessage");
        super.onMessageReceived(remoteMessage);
        b0.U(this, this.f8585a + ", From: " + remoteMessage.getFrom());
        if (remoteMessage.getNotification() == null) {
            Map<String, String> data = remoteMessage.getData();
            t9.i.f(data, "remoteMessage.data");
            c(data);
        }
        RemoteMessage.Notification notification = remoteMessage.getNotification();
        if (notification != null) {
            b0.U(this, this.f8585a + ", Message Notification title: " + notification.getTitle());
            b0.U(this, this.f8585a + ", Message Notification Body: " + notification.getBody());
            b0.U(this, this.f8585a + ", Message Notification data: " + remoteMessage.getData());
        }
    }

    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public void onNewToken(String str) {
        t9.i.g(str, ParamsMap.DeviceParams.KEY_AUTH_TOKEN);
        super.onNewToken(str);
        b0.U(this, this.f8585a + ", Refreshed token: " + str);
        na.a.i(str);
        d();
    }
}
