package com.google.firebase.crashlytics.internal.settings;

/* loaded from: classes2.dex */
public class Settings {
    public final int cacheDuration;
    public final long expiresAtMillis;
    public final FeatureFlagData featureFlagData;
    public final double onDemandBackoffBase;
    public final int onDemandBackoffStepDurationSeconds;
    public final double onDemandUploadRatePerMinute;
    public final SessionData sessionData;
    public final int settingsVersion;

    public static class FeatureFlagData {
        public final boolean collectAnrs;
        public final boolean collectBuildIds;
        public final boolean collectReports;

        public FeatureFlagData(boolean z10, boolean z11, boolean z12) {
            this.collectReports = z10;
            this.collectAnrs = z11;
            this.collectBuildIds = z12;
        }
    }

    public static class SessionData {
        public final int maxCompleteSessionsCount;
        public final int maxCustomExceptionEvents;

        public SessionData(int i10, int i11) {
            this.maxCustomExceptionEvents = i10;
            this.maxCompleteSessionsCount = i11;
        }
    }

    public Settings(long j10, SessionData sessionData, FeatureFlagData featureFlagData, int i10, int i11, double d10, double d11, int i12) {
        this.expiresAtMillis = j10;
        this.sessionData = sessionData;
        this.featureFlagData = featureFlagData;
        this.settingsVersion = i10;
        this.cacheDuration = i11;
        this.onDemandUploadRatePerMinute = d10;
        this.onDemandBackoffBase = d11;
        this.onDemandBackoffStepDurationSeconds = i12;
    }

    public boolean isExpired(long j10) {
        return this.expiresAtMillis < j10;
    }
}
