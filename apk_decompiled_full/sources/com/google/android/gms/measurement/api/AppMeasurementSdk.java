package com.google.android.gms.measurement.api;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.measurement.zzef;
import com.google.android.gms.measurement.internal.zzgr;
import com.google.android.gms.measurement.internal.zzgs;
import java.util.List;
import java.util.Map;

@ShowFirstParty
@KeepForSdk
/* loaded from: classes.dex */
public class AppMeasurementSdk {
    private final zzef zza;

    @KeepForSdk
    public static final class ConditionalUserProperty {

        @KeepForSdk
        public static final String ACTIVE = "active";

        @KeepForSdk
        public static final String CREATION_TIMESTAMP = "creation_timestamp";

        @KeepForSdk
        public static final String EXPIRED_EVENT_NAME = "expired_event_name";

        @KeepForSdk
        public static final String EXPIRED_EVENT_PARAMS = "expired_event_params";

        @KeepForSdk
        public static final String NAME = "name";

        @KeepForSdk
        public static final String ORIGIN = "origin";

        @KeepForSdk
        public static final String TIMED_OUT_EVENT_NAME = "timed_out_event_name";

        @KeepForSdk
        public static final String TIMED_OUT_EVENT_PARAMS = "timed_out_event_params";

        @KeepForSdk
        public static final String TIME_TO_LIVE = "time_to_live";

        @KeepForSdk
        public static final String TRIGGERED_EVENT_NAME = "triggered_event_name";

        @KeepForSdk
        public static final String TRIGGERED_EVENT_PARAMS = "triggered_event_params";

        @KeepForSdk
        public static final String TRIGGERED_TIMESTAMP = "triggered_timestamp";

        @KeepForSdk
        public static final String TRIGGER_EVENT_NAME = "trigger_event_name";

        @KeepForSdk
        public static final String TRIGGER_TIMEOUT = "trigger_timeout";

        @KeepForSdk
        public static final String VALUE = "value";

        private ConditionalUserProperty() {
        }
    }

    @ShowFirstParty
    @KeepForSdk
    public interface EventInterceptor extends zzgr {
        @Override // com.google.android.gms.measurement.internal.zzgr
        @ShowFirstParty
        @KeepForSdk
        void interceptEvent(String str, String str2, Bundle bundle, long j10);
    }

    @ShowFirstParty
    @KeepForSdk
    public interface OnEventListener extends zzgs {
        @Override // com.google.android.gms.measurement.internal.zzgs
        @ShowFirstParty
        @KeepForSdk
        void onEvent(String str, String str2, Bundle bundle, long j10);
    }

    public AppMeasurementSdk(zzef zzefVar) {
        this.zza = zzefVar;
    }

    @ShowFirstParty
    @KeepForSdk
    public static AppMeasurementSdk getInstance(Context context) {
        return zzef.zzg(context, null, null, null, null).zzd();
    }

    @KeepForSdk
    public void beginAdUnitExposure(String str) {
        this.zza.zzv(str);
    }

    @KeepForSdk
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        this.zza.zzw(str, str2, bundle);
    }

    @KeepForSdk
    public void endAdUnitExposure(String str) {
        this.zza.zzx(str);
    }

    @KeepForSdk
    public long generateEventId() {
        return this.zza.zzb();
    }

    @KeepForSdk
    public String getAppIdOrigin() {
        return this.zza.zzk();
    }

    @KeepForSdk
    public String getAppInstanceId() {
        return this.zza.zzm();
    }

    @KeepForSdk
    public List<Bundle> getConditionalUserProperties(String str, String str2) {
        return this.zza.zzq(str, str2);
    }

    @KeepForSdk
    public String getCurrentScreenClass() {
        return this.zza.zzn();
    }

    @KeepForSdk
    public String getCurrentScreenName() {
        return this.zza.zzo();
    }

    @KeepForSdk
    public String getGmpAppId() {
        return this.zza.zzp();
    }

    @KeepForSdk
    public int getMaxUserProperties(String str) {
        return this.zza.zza(str);
    }

    @KeepForSdk
    public Map<String, Object> getUserProperties(String str, String str2, boolean z10) {
        return this.zza.zzr(str, str2, z10);
    }

    @KeepForSdk
    public void logEvent(String str, String str2, Bundle bundle) {
        this.zza.zzz(str, str2, bundle);
    }

    @KeepForSdk
    public void logEventNoInterceptor(String str, String str2, Bundle bundle, long j10) {
        this.zza.zzA(str, str2, bundle, j10);
    }

    @KeepForSdk
    public void performAction(Bundle bundle) {
        this.zza.zzc(bundle, false);
    }

    @KeepForSdk
    public Bundle performActionWithResponse(Bundle bundle) {
        return this.zza.zzc(bundle, true);
    }

    @ShowFirstParty
    @KeepForSdk
    public void registerOnMeasurementEventListener(OnEventListener onEventListener) {
        this.zza.zzC(onEventListener);
    }

    @KeepForSdk
    public void setConditionalUserProperty(Bundle bundle) {
        this.zza.zzE(bundle);
    }

    @KeepForSdk
    public void setConsent(Bundle bundle) {
        this.zza.zzF(bundle);
    }

    @KeepForSdk
    public void setCurrentScreen(Activity activity, String str, String str2) {
        this.zza.zzH(activity, str, str2);
    }

    @ShowFirstParty
    @KeepForSdk
    public void setEventInterceptor(EventInterceptor eventInterceptor) {
        this.zza.zzK(eventInterceptor);
    }

    @KeepForSdk
    public void setMeasurementEnabled(Boolean bool) {
        this.zza.zzL(bool);
    }

    @KeepForSdk
    public void setUserProperty(String str, String str2, Object obj) {
        this.zza.zzO(str, str2, obj, true);
    }

    @ShowFirstParty
    @KeepForSdk
    public void unregisterOnMeasurementEventListener(OnEventListener onEventListener) {
        this.zza.zzP(onEventListener);
    }

    public final void zza(boolean z10) {
        this.zza.zzI(z10);
    }

    @KeepForSdk
    public void setMeasurementEnabled(boolean z10) {
        this.zza.zzL(Boolean.valueOf(z10));
    }

    @KeepForSdk
    public static AppMeasurementSdk getInstance(Context context, String str, String str2, String str3, Bundle bundle) {
        return zzef.zzg(context, str, str2, str3, bundle).zzd();
    }
}
