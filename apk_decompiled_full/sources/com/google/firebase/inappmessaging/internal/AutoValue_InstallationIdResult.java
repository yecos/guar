package com.google.firebase.inappmessaging.internal;

import com.google.firebase.installations.InstallationTokenResult;

/* loaded from: classes2.dex */
final class AutoValue_InstallationIdResult extends InstallationIdResult {
    private final String installationId;
    private final InstallationTokenResult installationTokenResult;

    public AutoValue_InstallationIdResult(String str, InstallationTokenResult installationTokenResult) {
        if (str == null) {
            throw new NullPointerException("Null installationId");
        }
        this.installationId = str;
        if (installationTokenResult == null) {
            throw new NullPointerException("Null installationTokenResult");
        }
        this.installationTokenResult = installationTokenResult;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof InstallationIdResult)) {
            return false;
        }
        InstallationIdResult installationIdResult = (InstallationIdResult) obj;
        return this.installationId.equals(installationIdResult.installationId()) && this.installationTokenResult.equals(installationIdResult.installationTokenResult());
    }

    public int hashCode() {
        return ((this.installationId.hashCode() ^ 1000003) * 1000003) ^ this.installationTokenResult.hashCode();
    }

    @Override // com.google.firebase.inappmessaging.internal.InstallationIdResult
    public String installationId() {
        return this.installationId;
    }

    @Override // com.google.firebase.inappmessaging.internal.InstallationIdResult
    public InstallationTokenResult installationTokenResult() {
        return this.installationTokenResult;
    }

    public String toString() {
        return "InstallationIdResult{installationId=" + this.installationId + ", installationTokenResult=" + this.installationTokenResult + "}";
    }
}
