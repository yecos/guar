package com.google.firebase.inappmessaging.model;

import com.google.firebase.inappmessaging.dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class ProtoMarshallerClient_Factory implements Factory<ProtoMarshallerClient> {

    public static final class InstanceHolder {
        private static final ProtoMarshallerClient_Factory INSTANCE = new ProtoMarshallerClient_Factory();

        private InstanceHolder() {
        }
    }

    public static ProtoMarshallerClient_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static ProtoMarshallerClient newInstance() {
        return new ProtoMarshallerClient();
    }

    @Override // javax.inject.Provider
    public ProtoMarshallerClient get() {
        return newInstance();
    }
}
