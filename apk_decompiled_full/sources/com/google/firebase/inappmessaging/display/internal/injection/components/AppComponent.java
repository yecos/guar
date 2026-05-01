package com.google.firebase.inappmessaging.display.internal.injection.components;

import com.google.firebase.inappmessaging.display.FirebaseInAppMessagingDisplay;
import com.google.firebase.inappmessaging.display.dagger.Component;
import com.google.firebase.inappmessaging.display.internal.FiamImageLoader;
import com.google.firebase.inappmessaging.display.internal.GlideErrorListener;
import com.google.firebase.inappmessaging.display.internal.injection.modules.GlideModule;
import com.google.firebase.inappmessaging.display.internal.injection.modules.HeadlessInAppMessagingModule;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.FirebaseAppScope;

@Component(dependencies = {UniversalComponent.class}, modules = {HeadlessInAppMessagingModule.class, GlideModule.class})
@FirebaseAppScope
/* loaded from: classes2.dex */
public interface AppComponent {
    FiamImageLoader fiamImageLoader();

    GlideErrorListener glideErrorListener();

    @FirebaseAppScope
    FirebaseInAppMessagingDisplay providesFirebaseInAppMessagingUI();
}
