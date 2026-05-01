package com.google.firebase.inappmessaging.display.internal;

import com.google.firebase.inappmessaging.display.dagger.internal.Factory;

/* loaded from: classes2.dex */
public final class FiamAnimator_Factory implements Factory<FiamAnimator> {

    public static final class InstanceHolder {
        private static final FiamAnimator_Factory INSTANCE = new FiamAnimator_Factory();

        private InstanceHolder() {
        }
    }

    public static FiamAnimator_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static FiamAnimator newInstance() {
        return new FiamAnimator();
    }

    @Override // javax.inject.Provider
    public FiamAnimator get() {
        return newInstance();
    }
}
