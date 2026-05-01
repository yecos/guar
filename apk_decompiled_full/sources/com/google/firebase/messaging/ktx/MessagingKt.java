package com.google.firebase.messaging.ktx;

import com.google.firebase.ktx.Firebase;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.RemoteMessage;
import s9.l;
import t9.i;

/* loaded from: classes2.dex */
public final class MessagingKt {
    public static final String LIBRARY_NAME = "fire-fcm-ktx";

    public static final FirebaseMessaging getMessaging(Firebase firebase) {
        i.g(firebase, "<this>");
        FirebaseMessaging firebaseMessaging = FirebaseMessaging.getInstance();
        i.f(firebaseMessaging, "getInstance()");
        return firebaseMessaging;
    }

    public static final RemoteMessage remoteMessage(String str, l lVar) {
        i.g(str, "to");
        i.g(lVar, "init");
        RemoteMessage.Builder builder = new RemoteMessage.Builder(str);
        lVar.invoke(builder);
        RemoteMessage build = builder.build();
        i.f(build, "builder.build()");
        return build;
    }
}
