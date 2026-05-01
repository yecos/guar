package com.google.firebase.inappmessaging.internal;

import com.google.firebase.FirebaseApp;
import com.google.firebase.inappmessaging.dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SharedPreferencesUtils_Factory implements Factory<SharedPreferencesUtils> {
    private final Provider<FirebaseApp> firebaseAppProvider;

    public SharedPreferencesUtils_Factory(Provider<FirebaseApp> provider) {
        this.firebaseAppProvider = provider;
    }

    public static SharedPreferencesUtils_Factory create(Provider<FirebaseApp> provider) {
        return new SharedPreferencesUtils_Factory(provider);
    }

    public static SharedPreferencesUtils newInstance(FirebaseApp firebaseApp) {
        return new SharedPreferencesUtils(firebaseApp);
    }

    @Override // javax.inject.Provider
    public SharedPreferencesUtils get() {
        return newInstance(this.firebaseAppProvider.get());
    }
}
