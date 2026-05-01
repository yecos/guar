package com.google.firebase.inappmessaging.display.internal;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.google.firebase.inappmessaging.FirebaseInAppMessagingDisplayCallbacks;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.FirebaseAppScope;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.hpplay.cybergarage.soap.SOAP;
import javax.inject.Inject;

@FirebaseAppScope
/* loaded from: classes2.dex */
public class GlideErrorListener implements RequestListener<Object> {
    private FirebaseInAppMessagingDisplayCallbacks displayCallbacks;
    private InAppMessage inAppMessage;

    @Inject
    public GlideErrorListener() {
    }

    @Override // com.bumptech.glide.request.RequestListener
    public boolean onLoadFailed(GlideException glideException, Object obj, Target<Object> target, boolean z10) {
        Logging.logd("Image Downloading  Error : " + glideException.getMessage() + SOAP.DELIM + glideException.getCause());
        if (this.inAppMessage == null || this.displayCallbacks == null) {
            return false;
        }
        if (glideException.getLocalizedMessage().contains("Failed to decode")) {
            this.displayCallbacks.displayErrorEncountered(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason.IMAGE_UNSUPPORTED_FORMAT);
            return false;
        }
        this.displayCallbacks.displayErrorEncountered(FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason.UNSPECIFIED_RENDER_ERROR);
        return false;
    }

    @Override // com.bumptech.glide.request.RequestListener
    public boolean onResourceReady(Object obj, Object obj2, Target<Object> target, DataSource dataSource, boolean z10) {
        Logging.logd("Image Downloading  Success : " + obj);
        return false;
    }

    public void setInAppMessage(InAppMessage inAppMessage, FirebaseInAppMessagingDisplayCallbacks firebaseInAppMessagingDisplayCallbacks) {
        this.inAppMessage = inAppMessage;
        this.displayCallbacks = firebaseInAppMessagingDisplayCallbacks;
    }
}
