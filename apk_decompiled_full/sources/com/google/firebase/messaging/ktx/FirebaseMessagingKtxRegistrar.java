package com.google.firebase.messaging.ktx;

import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import i9.i;
import java.util.List;

/* loaded from: classes2.dex */
public final class FirebaseMessagingKtxRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    public List<Component<?>> getComponents() {
        return i.b(LibraryVersionComponent.create(MessagingKt.LIBRARY_NAME, "23.1.2"));
    }
}
