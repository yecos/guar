package com.google.firebase.inappmessaging.internal;

import com.google.auto.value.AutoValue;
import com.google.firebase.installations.InstallationTokenResult;

@AutoValue
/* loaded from: classes2.dex */
public abstract class InstallationIdResult {
    public static InstallationIdResult create(String str, InstallationTokenResult installationTokenResult) {
        return new AutoValue_InstallationIdResult(str, installationTokenResult);
    }

    public abstract String installationId();

    public abstract InstallationTokenResult installationTokenResult();
}
