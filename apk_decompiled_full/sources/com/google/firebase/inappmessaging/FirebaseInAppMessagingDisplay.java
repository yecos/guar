package com.google.firebase.inappmessaging;

import androidx.annotation.Keep;
import com.google.firebase.inappmessaging.model.InAppMessage;

@Keep
/* loaded from: classes2.dex */
public interface FirebaseInAppMessagingDisplay {
    @Keep
    void displayMessage(InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks);
}
