package com.google.android.gms.cast.internal;

import android.os.SystemClock;
import com.google.android.gms.cast.AdBreakStatus;
import com.google.android.gms.cast.CastStatusCodes;
import com.google.android.gms.cast.MediaError;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaLiveSeekableRange;
import com.google.android.gms.cast.MediaLoadRequestData;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.MediaSeekOptions;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.RemoteMediaPlayer;
import com.google.android.gms.cast.SessionState;
import com.google.android.gms.cast.TextTrackStyle;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.android.gms.cast.internal.media.MediaCommon;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hpplay.component.protocol.PlistBuilder;
import com.hpplay.sdk.source.common.global.Constant;
import com.raizlabs.android.dbflow.sql.language.TriggerMethod;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@VisibleForTesting
/* loaded from: classes.dex */
public final class zzap extends zzd {
    public static final String zzb = CastUtils.zzc("com.google.cast.media");
    private int zzA;
    private TaskCompletionSource<SessionState> zzB;

    @VisibleForTesting
    final zzat zzc;

    @VisibleForTesting
    final zzat zzd;

    @VisibleForTesting
    final zzat zze;

    @VisibleForTesting
    final zzat zzf;

    @VisibleForTesting
    final zzat zzg;

    @VisibleForTesting
    final zzat zzh;

    @VisibleForTesting
    final zzat zzi;

    @VisibleForTesting
    final zzat zzj;

    @VisibleForTesting
    final zzat zzk;

    @VisibleForTesting
    final zzat zzl;

    @VisibleForTesting
    final zzat zzm;

    @VisibleForTesting
    final zzat zzn;

    @VisibleForTesting
    final zzat zzo;

    @VisibleForTesting
    final zzat zzp;

    @VisibleForTesting
    final zzat zzq;

    @VisibleForTesting
    final zzat zzr;

    @VisibleForTesting
    final zzat zzs;

    @VisibleForTesting
    final zzat zzt;

    @VisibleForTesting
    final zzat zzu;

    @VisibleForTesting
    final zzat zzv;
    private long zzw;
    private MediaStatus zzx;
    private Long zzy;
    private zzam zzz;

    public zzap(String str) {
        super(zzb, "MediaControlChannel", null);
        this.zzA = -1;
        zzat zzatVar = new zzat(86400000L);
        this.zzc = zzatVar;
        zzat zzatVar2 = new zzat(86400000L);
        this.zzd = zzatVar2;
        zzat zzatVar3 = new zzat(86400000L);
        this.zze = zzatVar3;
        zzat zzatVar4 = new zzat(86400000L);
        this.zzf = zzatVar4;
        zzat zzatVar5 = new zzat(NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS);
        this.zzg = zzatVar5;
        zzat zzatVar6 = new zzat(86400000L);
        this.zzh = zzatVar6;
        zzat zzatVar7 = new zzat(86400000L);
        this.zzi = zzatVar7;
        zzat zzatVar8 = new zzat(86400000L);
        this.zzj = zzatVar8;
        zzat zzatVar9 = new zzat(86400000L);
        this.zzk = zzatVar9;
        zzat zzatVar10 = new zzat(86400000L);
        this.zzl = zzatVar10;
        zzat zzatVar11 = new zzat(86400000L);
        this.zzm = zzatVar11;
        zzat zzatVar12 = new zzat(86400000L);
        this.zzn = zzatVar12;
        zzat zzatVar13 = new zzat(86400000L);
        this.zzo = zzatVar13;
        zzat zzatVar14 = new zzat(86400000L);
        this.zzp = zzatVar14;
        zzat zzatVar15 = new zzat(86400000L);
        this.zzq = zzatVar15;
        zzat zzatVar16 = new zzat(86400000L);
        this.zzs = zzatVar16;
        this.zzr = new zzat(86400000L);
        zzat zzatVar17 = new zzat(86400000L);
        this.zzt = zzatVar17;
        zzat zzatVar18 = new zzat(86400000L);
        this.zzu = zzatVar18;
        zzat zzatVar19 = new zzat(86400000L);
        this.zzv = zzatVar19;
        zzc(zzatVar);
        zzc(zzatVar2);
        zzc(zzatVar3);
        zzc(zzatVar4);
        zzc(zzatVar5);
        zzc(zzatVar6);
        zzc(zzatVar7);
        zzc(zzatVar8);
        zzc(zzatVar9);
        zzc(zzatVar10);
        zzc(zzatVar11);
        zzc(zzatVar12);
        zzc(zzatVar13);
        zzc(zzatVar14);
        zzc(zzatVar15);
        zzc(zzatVar16);
        zzc(zzatVar16);
        zzc(zzatVar17);
        zzc(zzatVar18);
        zzc(zzatVar19);
        zzV();
    }

    private final long zzT(double d10, long j10, long j11) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.zzw;
        if (elapsedRealtime < 0) {
            elapsedRealtime = 0;
        }
        if (elapsedRealtime == 0) {
            return j10;
        }
        double d11 = elapsedRealtime;
        Double.isNaN(d11);
        long j12 = j10 + ((long) (d11 * d10));
        if (j11 > 0 && j12 > j11) {
            return j11;
        }
        if (j12 >= 0) {
            return j12;
        }
        return 0L;
    }

    private static zzao zzU(JSONObject jSONObject) {
        MediaError zza = MediaError.zza(jSONObject);
        zzao zzaoVar = new zzao();
        zzaoVar.zza = CastUtils.zzg(jSONObject, "customData");
        zzaoVar.zzb = zza;
        return zzaoVar;
    }

    private final void zzV() {
        this.zzw = 0L;
        this.zzx = null;
        Iterator<zzat> it = zza().iterator();
        while (it.hasNext()) {
            it.next().zzc(CastStatusCodes.CANCELED);
        }
    }

    private final void zzW(JSONObject jSONObject, String str) {
        if (jSONObject.has("sequenceNumber")) {
            this.zzA = jSONObject.optInt("sequenceNumber", -1);
        } else {
            this.zza.w(str.concat(" message is missing a sequence number."), new Object[0]);
        }
    }

    private final void zzX() {
        zzam zzamVar = this.zzz;
        if (zzamVar != null) {
            zzamVar.zzc();
        }
    }

    private final void zzY() {
        zzam zzamVar = this.zzz;
        if (zzamVar != null) {
            zzamVar.zzd();
        }
    }

    private final void zzZ() {
        zzam zzamVar = this.zzz;
        if (zzamVar != null) {
            zzamVar.zzk();
        }
    }

    private final void zzaa() {
        zzam zzamVar = this.zzz;
        if (zzamVar != null) {
            zzamVar.zzm();
        }
    }

    private final boolean zzab() {
        return this.zzA != -1;
    }

    private static int[] zzac(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        int[] iArr = new int[jSONArray.length()];
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            iArr[i10] = jSONArray.getInt(i10);
        }
        return iArr;
    }

    public final long zzA(zzar zzarVar, int i10, long j10, MediaQueueItem[] mediaQueueItemArr, int i11, boolean z10, Integer num, JSONObject jSONObject) {
        if (j10 != -1 && j10 < 0) {
            StringBuilder sb = new StringBuilder(53);
            sb.append("playPosition cannot be negative: ");
            sb.append(j10);
            throw new IllegalArgumentException(sb.toString());
        }
        JSONObject jSONObject2 = new JSONObject();
        long zzd = zzd();
        try {
            jSONObject2.put("requestId", zzd);
            jSONObject2.put("type", "QUEUE_UPDATE");
            jSONObject2.put("mediaSessionId", zzn());
            if (i10 != 0) {
                jSONObject2.put("currentItemId", i10);
            }
            if (i11 != 0) {
                jSONObject2.put("jump", i11);
            }
            if (mediaQueueItemArr != null && mediaQueueItemArr.length > 0) {
                JSONArray jSONArray = new JSONArray();
                for (int i12 = 0; i12 < mediaQueueItemArr.length; i12++) {
                    jSONArray.put(i12, mediaQueueItemArr[i12].toJson());
                }
                jSONObject2.put("items", jSONArray);
            }
            if (z10) {
                jSONObject2.put("shuffle", true);
            }
            String zza = MediaCommon.zza(num);
            if (zza != null) {
                jSONObject2.put("repeatMode", zza);
            }
            if (j10 != -1) {
                jSONObject2.put("currentTime", CastUtils.millisecToSec(j10));
            }
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
            if (zzab()) {
                jSONObject2.put("sequenceNumber", this.zzA);
            }
        } catch (JSONException unused) {
        }
        zzg(jSONObject2.toString(), zzd, null);
        this.zzn.zzb(zzd, new zzal(this, zzarVar));
        return zzd;
    }

    public final long zzB(zzar zzarVar) {
        JSONObject jSONObject = new JSONObject();
        long zzd = zzd();
        try {
            jSONObject.put("requestId", zzd);
            jSONObject.put("type", "GET_STATUS");
            MediaStatus mediaStatus = this.zzx;
            if (mediaStatus != null) {
                jSONObject.put("mediaSessionId", mediaStatus.zzb());
            }
        } catch (JSONException unused) {
        }
        zzg(jSONObject.toString(), zzd, null);
        this.zzj.zzb(zzd, zzarVar);
        return zzd;
    }

    public final long zzC(zzar zzarVar, MediaSeekOptions mediaSeekOptions) {
        JSONObject jSONObject = new JSONObject();
        long zzd = zzd();
        long position = mediaSeekOptions.isSeekToInfinite() ? 4294967296000L : mediaSeekOptions.getPosition();
        try {
            jSONObject.put("requestId", zzd);
            jSONObject.put("type", "SEEK");
            jSONObject.put("mediaSessionId", zzn());
            jSONObject.put("currentTime", CastUtils.millisecToSec(position));
            if (mediaSeekOptions.getResumeState() == 1) {
                jSONObject.put("resumeState", "PLAYBACK_START");
            } else if (mediaSeekOptions.getResumeState() == 2) {
                jSONObject.put("resumeState", "PLAYBACK_PAUSE");
            }
            if (mediaSeekOptions.getCustomData() != null) {
                jSONObject.put("customData", mediaSeekOptions.getCustomData());
            }
        } catch (JSONException unused) {
        }
        zzg(jSONObject.toString(), zzd, null);
        this.zzy = Long.valueOf(position);
        this.zzg.zzb(zzd, new zzaj(this, zzarVar));
        return zzd;
    }

    public final long zzD(zzar zzarVar, long[] jArr) {
        if (jArr == null) {
            throw new IllegalArgumentException("trackIds cannot be null");
        }
        JSONObject jSONObject = new JSONObject();
        long zzd = zzd();
        try {
            jSONObject.put("requestId", zzd);
            jSONObject.put("type", "EDIT_TRACKS_INFO");
            jSONObject.put("mediaSessionId", zzn());
            JSONArray jSONArray = new JSONArray();
            for (int i10 = 0; i10 < jArr.length; i10++) {
                jSONArray.put(i10, jArr[i10]);
            }
            jSONObject.put("activeTrackIds", jSONArray);
        } catch (JSONException unused) {
        }
        zzg(jSONObject.toString(), zzd, null);
        this.zzk.zzb(zzd, zzarVar);
        return zzd;
    }

    public final long zzE(zzar zzarVar, double d10, JSONObject jSONObject) {
        if (this.zzx == null) {
            throw new zzan();
        }
        JSONObject jSONObject2 = new JSONObject();
        long zzd = zzd();
        try {
            jSONObject2.put("requestId", zzd);
            jSONObject2.put("type", "SET_PLAYBACK_RATE");
            jSONObject2.put("playbackRate", d10);
            Preconditions.checkNotNull(this.zzx, "mediaStatus should not be null");
            jSONObject2.put("mediaSessionId", this.zzx.zzb());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException unused) {
        }
        zzg(jSONObject2.toString(), zzd, null);
        this.zzt.zzb(zzd, zzarVar);
        return zzd;
    }

    public final long zzF(zzar zzarVar, boolean z10, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        long zzd = zzd();
        try {
            jSONObject2.put("requestId", zzd);
            jSONObject2.put("type", "SET_VOLUME");
            jSONObject2.put("mediaSessionId", zzn());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("muted", z10);
            jSONObject2.put(PlistBuilder.VALUE_TYPE_VOLUME, jSONObject3);
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException unused) {
        }
        zzg(jSONObject2.toString(), zzd, null);
        this.zzi.zzb(zzd, zzarVar);
        return zzd;
    }

    public final long zzG(zzar zzarVar, double d10, JSONObject jSONObject) {
        if (Double.isInfinite(d10) || Double.isNaN(d10)) {
            StringBuilder sb = new StringBuilder(41);
            sb.append("Volume cannot be ");
            sb.append(d10);
            throw new IllegalArgumentException(sb.toString());
        }
        JSONObject jSONObject2 = new JSONObject();
        long zzd = zzd();
        try {
            jSONObject2.put("requestId", zzd);
            jSONObject2.put("type", "SET_VOLUME");
            jSONObject2.put("mediaSessionId", zzn());
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(FirebaseAnalytics.Param.LEVEL, d10);
            jSONObject2.put(PlistBuilder.VALUE_TYPE_VOLUME, jSONObject3);
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException unused) {
        }
        zzg(jSONObject2.toString(), zzd, null);
        this.zzh.zzb(zzd, zzarVar);
        return zzd;
    }

    public final long zzH(zzar zzarVar, TextTrackStyle textTrackStyle) {
        if (textTrackStyle == null) {
            throw new IllegalArgumentException("trackStyle cannot be null");
        }
        JSONObject jSONObject = new JSONObject();
        long zzd = zzd();
        try {
            jSONObject.put("requestId", zzd);
            jSONObject.put("type", "EDIT_TRACKS_INFO");
            jSONObject.put("textTrackStyle", textTrackStyle.zza());
            jSONObject.put("mediaSessionId", zzn());
        } catch (JSONException unused) {
        }
        zzg(jSONObject.toString(), zzd, null);
        this.zzl.zzb(zzd, zzarVar);
        return zzd;
    }

    public final long zzI(zzar zzarVar) {
        JSONObject jSONObject = new JSONObject();
        long zzd = zzd();
        try {
            jSONObject.put("requestId", zzd);
            jSONObject.put("type", "SKIP_AD");
            jSONObject.put("mediaSessionId", zzn());
        } catch (JSONException e10) {
            this.zza.w(String.format(Locale.ROOT, "Error creating SkipAd message: %s", e10.getMessage()), new Object[0]);
        }
        zzg(jSONObject.toString(), zzd, null);
        this.zzu.zzb(zzd, zzarVar);
        return zzd;
    }

    public final long zzJ(zzar zzarVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        long zzd = zzd();
        try {
            jSONObject2.put("requestId", zzd);
            jSONObject2.put("type", "STOP");
            jSONObject2.put("mediaSessionId", zzn());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException unused) {
        }
        zzg(jSONObject2.toString(), zzd, null);
        this.zzf.zzb(zzd, zzarVar);
        return zzd;
    }

    public final MediaInfo zzK() {
        MediaStatus mediaStatus = this.zzx;
        if (mediaStatus == null) {
            return null;
        }
        return mediaStatus.getMediaInfo();
    }

    public final MediaStatus zzL() {
        return this.zzx;
    }

    public final Task<SessionState> zzN(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        long zzd = zzd();
        try {
            jSONObject2.put("requestId", zzd);
            jSONObject2.put("type", "STORE_SESSION");
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("assistant_supported", true);
            jSONObject3.put("display_supported", true);
            jSONObject3.put("is_group", false);
            jSONObject2.put("targetDeviceCapabilities", jSONObject3);
        } catch (JSONException e10) {
            this.zza.w(e10, "store session failed to create JSON message", new Object[0]);
        }
        try {
            zzg(jSONObject2.toString(), zzd, null);
            this.zzv.zzb(zzd, new zzak(this));
            TaskCompletionSource<SessionState> taskCompletionSource = new TaskCompletionSource<>();
            this.zzB = taskCompletionSource;
            return taskCompletionSource.getTask();
        } catch (IllegalStateException e11) {
            return Tasks.forException(e11);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0283 A[Catch: JSONException -> 0x031e, TryCatch #0 {JSONException -> 0x031e, blocks: (B:3:0x0014, B:11:0x00a0, B:13:0x00a9, B:15:0x00b1, B:20:0x00bb, B:22:0x00c7, B:23:0x00d4, B:25:0x00da, B:27:0x00ec, B:30:0x00f2, B:32:0x00fe, B:34:0x0112, B:43:0x014d, B:45:0x0162, B:47:0x017e, B:50:0x0184, B:52:0x018a, B:54:0x0190, B:68:0x0196, B:70:0x01a2, B:72:0x01ac, B:76:0x01b2, B:77:0x01ba, B:79:0x01c0, B:81:0x01d0, B:85:0x01d6, B:87:0x01e0, B:88:0x01f1, B:90:0x01f7, B:93:0x0207, B:95:0x0213, B:97:0x021f, B:98:0x0230, B:100:0x0236, B:103:0x0246, B:105:0x0252, B:107:0x0264, B:112:0x0283, B:115:0x0288, B:116:0x029c, B:118:0x02a0, B:119:0x02ac, B:121:0x02b0, B:122:0x02b9, B:124:0x02bd, B:125:0x02c3, B:127:0x02c7, B:128:0x02ca, B:130:0x02ce, B:131:0x02d1, B:133:0x02d5, B:134:0x02d8, B:136:0x02dc, B:138:0x02e6, B:139:0x02e9, B:141:0x02ed, B:142:0x0305, B:143:0x030d, B:145:0x0313, B:148:0x028d, B:149:0x026f, B:151:0x0277, B:155:0x02f7), top: B:2:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02a0 A[Catch: JSONException -> 0x031e, TryCatch #0 {JSONException -> 0x031e, blocks: (B:3:0x0014, B:11:0x00a0, B:13:0x00a9, B:15:0x00b1, B:20:0x00bb, B:22:0x00c7, B:23:0x00d4, B:25:0x00da, B:27:0x00ec, B:30:0x00f2, B:32:0x00fe, B:34:0x0112, B:43:0x014d, B:45:0x0162, B:47:0x017e, B:50:0x0184, B:52:0x018a, B:54:0x0190, B:68:0x0196, B:70:0x01a2, B:72:0x01ac, B:76:0x01b2, B:77:0x01ba, B:79:0x01c0, B:81:0x01d0, B:85:0x01d6, B:87:0x01e0, B:88:0x01f1, B:90:0x01f7, B:93:0x0207, B:95:0x0213, B:97:0x021f, B:98:0x0230, B:100:0x0236, B:103:0x0246, B:105:0x0252, B:107:0x0264, B:112:0x0283, B:115:0x0288, B:116:0x029c, B:118:0x02a0, B:119:0x02ac, B:121:0x02b0, B:122:0x02b9, B:124:0x02bd, B:125:0x02c3, B:127:0x02c7, B:128:0x02ca, B:130:0x02ce, B:131:0x02d1, B:133:0x02d5, B:134:0x02d8, B:136:0x02dc, B:138:0x02e6, B:139:0x02e9, B:141:0x02ed, B:142:0x0305, B:143:0x030d, B:145:0x0313, B:148:0x028d, B:149:0x026f, B:151:0x0277, B:155:0x02f7), top: B:2:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02b0 A[Catch: JSONException -> 0x031e, TryCatch #0 {JSONException -> 0x031e, blocks: (B:3:0x0014, B:11:0x00a0, B:13:0x00a9, B:15:0x00b1, B:20:0x00bb, B:22:0x00c7, B:23:0x00d4, B:25:0x00da, B:27:0x00ec, B:30:0x00f2, B:32:0x00fe, B:34:0x0112, B:43:0x014d, B:45:0x0162, B:47:0x017e, B:50:0x0184, B:52:0x018a, B:54:0x0190, B:68:0x0196, B:70:0x01a2, B:72:0x01ac, B:76:0x01b2, B:77:0x01ba, B:79:0x01c0, B:81:0x01d0, B:85:0x01d6, B:87:0x01e0, B:88:0x01f1, B:90:0x01f7, B:93:0x0207, B:95:0x0213, B:97:0x021f, B:98:0x0230, B:100:0x0236, B:103:0x0246, B:105:0x0252, B:107:0x0264, B:112:0x0283, B:115:0x0288, B:116:0x029c, B:118:0x02a0, B:119:0x02ac, B:121:0x02b0, B:122:0x02b9, B:124:0x02bd, B:125:0x02c3, B:127:0x02c7, B:128:0x02ca, B:130:0x02ce, B:131:0x02d1, B:133:0x02d5, B:134:0x02d8, B:136:0x02dc, B:138:0x02e6, B:139:0x02e9, B:141:0x02ed, B:142:0x0305, B:143:0x030d, B:145:0x0313, B:148:0x028d, B:149:0x026f, B:151:0x0277, B:155:0x02f7), top: B:2:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02bd A[Catch: JSONException -> 0x031e, TryCatch #0 {JSONException -> 0x031e, blocks: (B:3:0x0014, B:11:0x00a0, B:13:0x00a9, B:15:0x00b1, B:20:0x00bb, B:22:0x00c7, B:23:0x00d4, B:25:0x00da, B:27:0x00ec, B:30:0x00f2, B:32:0x00fe, B:34:0x0112, B:43:0x014d, B:45:0x0162, B:47:0x017e, B:50:0x0184, B:52:0x018a, B:54:0x0190, B:68:0x0196, B:70:0x01a2, B:72:0x01ac, B:76:0x01b2, B:77:0x01ba, B:79:0x01c0, B:81:0x01d0, B:85:0x01d6, B:87:0x01e0, B:88:0x01f1, B:90:0x01f7, B:93:0x0207, B:95:0x0213, B:97:0x021f, B:98:0x0230, B:100:0x0236, B:103:0x0246, B:105:0x0252, B:107:0x0264, B:112:0x0283, B:115:0x0288, B:116:0x029c, B:118:0x02a0, B:119:0x02ac, B:121:0x02b0, B:122:0x02b9, B:124:0x02bd, B:125:0x02c3, B:127:0x02c7, B:128:0x02ca, B:130:0x02ce, B:131:0x02d1, B:133:0x02d5, B:134:0x02d8, B:136:0x02dc, B:138:0x02e6, B:139:0x02e9, B:141:0x02ed, B:142:0x0305, B:143:0x030d, B:145:0x0313, B:148:0x028d, B:149:0x026f, B:151:0x0277, B:155:0x02f7), top: B:2:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x02c7 A[Catch: JSONException -> 0x031e, TryCatch #0 {JSONException -> 0x031e, blocks: (B:3:0x0014, B:11:0x00a0, B:13:0x00a9, B:15:0x00b1, B:20:0x00bb, B:22:0x00c7, B:23:0x00d4, B:25:0x00da, B:27:0x00ec, B:30:0x00f2, B:32:0x00fe, B:34:0x0112, B:43:0x014d, B:45:0x0162, B:47:0x017e, B:50:0x0184, B:52:0x018a, B:54:0x0190, B:68:0x0196, B:70:0x01a2, B:72:0x01ac, B:76:0x01b2, B:77:0x01ba, B:79:0x01c0, B:81:0x01d0, B:85:0x01d6, B:87:0x01e0, B:88:0x01f1, B:90:0x01f7, B:93:0x0207, B:95:0x0213, B:97:0x021f, B:98:0x0230, B:100:0x0236, B:103:0x0246, B:105:0x0252, B:107:0x0264, B:112:0x0283, B:115:0x0288, B:116:0x029c, B:118:0x02a0, B:119:0x02ac, B:121:0x02b0, B:122:0x02b9, B:124:0x02bd, B:125:0x02c3, B:127:0x02c7, B:128:0x02ca, B:130:0x02ce, B:131:0x02d1, B:133:0x02d5, B:134:0x02d8, B:136:0x02dc, B:138:0x02e6, B:139:0x02e9, B:141:0x02ed, B:142:0x0305, B:143:0x030d, B:145:0x0313, B:148:0x028d, B:149:0x026f, B:151:0x0277, B:155:0x02f7), top: B:2:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02ce A[Catch: JSONException -> 0x031e, TryCatch #0 {JSONException -> 0x031e, blocks: (B:3:0x0014, B:11:0x00a0, B:13:0x00a9, B:15:0x00b1, B:20:0x00bb, B:22:0x00c7, B:23:0x00d4, B:25:0x00da, B:27:0x00ec, B:30:0x00f2, B:32:0x00fe, B:34:0x0112, B:43:0x014d, B:45:0x0162, B:47:0x017e, B:50:0x0184, B:52:0x018a, B:54:0x0190, B:68:0x0196, B:70:0x01a2, B:72:0x01ac, B:76:0x01b2, B:77:0x01ba, B:79:0x01c0, B:81:0x01d0, B:85:0x01d6, B:87:0x01e0, B:88:0x01f1, B:90:0x01f7, B:93:0x0207, B:95:0x0213, B:97:0x021f, B:98:0x0230, B:100:0x0236, B:103:0x0246, B:105:0x0252, B:107:0x0264, B:112:0x0283, B:115:0x0288, B:116:0x029c, B:118:0x02a0, B:119:0x02ac, B:121:0x02b0, B:122:0x02b9, B:124:0x02bd, B:125:0x02c3, B:127:0x02c7, B:128:0x02ca, B:130:0x02ce, B:131:0x02d1, B:133:0x02d5, B:134:0x02d8, B:136:0x02dc, B:138:0x02e6, B:139:0x02e9, B:141:0x02ed, B:142:0x0305, B:143:0x030d, B:145:0x0313, B:148:0x028d, B:149:0x026f, B:151:0x0277, B:155:0x02f7), top: B:2:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02d5 A[Catch: JSONException -> 0x031e, TryCatch #0 {JSONException -> 0x031e, blocks: (B:3:0x0014, B:11:0x00a0, B:13:0x00a9, B:15:0x00b1, B:20:0x00bb, B:22:0x00c7, B:23:0x00d4, B:25:0x00da, B:27:0x00ec, B:30:0x00f2, B:32:0x00fe, B:34:0x0112, B:43:0x014d, B:45:0x0162, B:47:0x017e, B:50:0x0184, B:52:0x018a, B:54:0x0190, B:68:0x0196, B:70:0x01a2, B:72:0x01ac, B:76:0x01b2, B:77:0x01ba, B:79:0x01c0, B:81:0x01d0, B:85:0x01d6, B:87:0x01e0, B:88:0x01f1, B:90:0x01f7, B:93:0x0207, B:95:0x0213, B:97:0x021f, B:98:0x0230, B:100:0x0236, B:103:0x0246, B:105:0x0252, B:107:0x0264, B:112:0x0283, B:115:0x0288, B:116:0x029c, B:118:0x02a0, B:119:0x02ac, B:121:0x02b0, B:122:0x02b9, B:124:0x02bd, B:125:0x02c3, B:127:0x02c7, B:128:0x02ca, B:130:0x02ce, B:131:0x02d1, B:133:0x02d5, B:134:0x02d8, B:136:0x02dc, B:138:0x02e6, B:139:0x02e9, B:141:0x02ed, B:142:0x0305, B:143:0x030d, B:145:0x0313, B:148:0x028d, B:149:0x026f, B:151:0x0277, B:155:0x02f7), top: B:2:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02dc A[Catch: JSONException -> 0x031e, TryCatch #0 {JSONException -> 0x031e, blocks: (B:3:0x0014, B:11:0x00a0, B:13:0x00a9, B:15:0x00b1, B:20:0x00bb, B:22:0x00c7, B:23:0x00d4, B:25:0x00da, B:27:0x00ec, B:30:0x00f2, B:32:0x00fe, B:34:0x0112, B:43:0x014d, B:45:0x0162, B:47:0x017e, B:50:0x0184, B:52:0x018a, B:54:0x0190, B:68:0x0196, B:70:0x01a2, B:72:0x01ac, B:76:0x01b2, B:77:0x01ba, B:79:0x01c0, B:81:0x01d0, B:85:0x01d6, B:87:0x01e0, B:88:0x01f1, B:90:0x01f7, B:93:0x0207, B:95:0x0213, B:97:0x021f, B:98:0x0230, B:100:0x0236, B:103:0x0246, B:105:0x0252, B:107:0x0264, B:112:0x0283, B:115:0x0288, B:116:0x029c, B:118:0x02a0, B:119:0x02ac, B:121:0x02b0, B:122:0x02b9, B:124:0x02bd, B:125:0x02c3, B:127:0x02c7, B:128:0x02ca, B:130:0x02ce, B:131:0x02d1, B:133:0x02d5, B:134:0x02d8, B:136:0x02dc, B:138:0x02e6, B:139:0x02e9, B:141:0x02ed, B:142:0x0305, B:143:0x030d, B:145:0x0313, B:148:0x028d, B:149:0x026f, B:151:0x0277, B:155:0x02f7), top: B:2:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02ed A[Catch: JSONException -> 0x031e, TryCatch #0 {JSONException -> 0x031e, blocks: (B:3:0x0014, B:11:0x00a0, B:13:0x00a9, B:15:0x00b1, B:20:0x00bb, B:22:0x00c7, B:23:0x00d4, B:25:0x00da, B:27:0x00ec, B:30:0x00f2, B:32:0x00fe, B:34:0x0112, B:43:0x014d, B:45:0x0162, B:47:0x017e, B:50:0x0184, B:52:0x018a, B:54:0x0190, B:68:0x0196, B:70:0x01a2, B:72:0x01ac, B:76:0x01b2, B:77:0x01ba, B:79:0x01c0, B:81:0x01d0, B:85:0x01d6, B:87:0x01e0, B:88:0x01f1, B:90:0x01f7, B:93:0x0207, B:95:0x0213, B:97:0x021f, B:98:0x0230, B:100:0x0236, B:103:0x0246, B:105:0x0252, B:107:0x0264, B:112:0x0283, B:115:0x0288, B:116:0x029c, B:118:0x02a0, B:119:0x02ac, B:121:0x02b0, B:122:0x02b9, B:124:0x02bd, B:125:0x02c3, B:127:0x02c7, B:128:0x02ca, B:130:0x02ce, B:131:0x02d1, B:133:0x02d5, B:134:0x02d8, B:136:0x02dc, B:138:0x02e6, B:139:0x02e9, B:141:0x02ed, B:142:0x0305, B:143:0x030d, B:145:0x0313, B:148:0x028d, B:149:0x026f, B:151:0x0277, B:155:0x02f7), top: B:2:0x0014 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzQ(String str) {
        char c10;
        int i10;
        int i11;
        MediaStatus mediaStatus;
        int[] zzac;
        char c11;
        JSONObject zzg;
        this.zza.d("message received: %s", str);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("type");
            long optLong = jSONObject.optLong("requestId", -1L);
            switch (string.hashCode()) {
                case -1830647528:
                    if (string.equals(MediaError.ERROR_TYPE_LOAD_CANCELLED)) {
                        c10 = 3;
                        break;
                    }
                    c10 = 65535;
                    break;
                case -1790231854:
                    if (string.equals("QUEUE_ITEMS")) {
                        c10 = '\b';
                        break;
                    }
                    c10 = 65535;
                    break;
                case -1125000185:
                    if (string.equals("INVALID_REQUEST")) {
                        c10 = 4;
                        break;
                    }
                    c10 = 65535;
                    break;
                case -262628938:
                    if (string.equals(MediaError.ERROR_TYPE_LOAD_FAILED)) {
                        c10 = 2;
                        break;
                    }
                    c10 = 65535;
                    break;
                case -61993624:
                    if (string.equals("SESSION_STATE")) {
                        c10 = '\t';
                        break;
                    }
                    c10 = 65535;
                    break;
                case 66247144:
                    if (string.equals(MediaError.ERROR_TYPE_ERROR)) {
                        c10 = 5;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 154411710:
                    if (string.equals("QUEUE_CHANGE")) {
                        c10 = 7;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 431600379:
                    if (string.equals(MediaError.ERROR_TYPE_INVALID_PLAYER_STATE)) {
                        c10 = 1;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 823510221:
                    if (string.equals("MEDIA_STATUS")) {
                        c10 = 0;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 2107149050:
                    if (string.equals("QUEUE_ITEM_IDS")) {
                        c10 = 6;
                        break;
                    }
                    c10 = 65535;
                    break;
                default:
                    c10 = 65535;
                    break;
            }
            switch (c10) {
                case 0:
                    JSONArray jSONArray = jSONObject.getJSONArray(Constant.KEY_STATUS);
                    if (jSONArray.length() > 0) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(0);
                        boolean zzf = this.zzc.zzf(optLong);
                        if (this.zzh.zze()) {
                            if (this.zzh.zzf(optLong)) {
                            }
                            i10 = 1;
                            if (!zzf && (mediaStatus = this.zzx) != null) {
                                i11 = mediaStatus.zza(jSONObject2, i10);
                                if ((i11 & 1) != 0) {
                                    this.zzw = SystemClock.elapsedRealtime();
                                    this.zzA = -1;
                                    zzaa();
                                }
                                if ((i11 & 2) != 0) {
                                    this.zzw = SystemClock.elapsedRealtime();
                                    zzaa();
                                }
                                if ((i11 & 128) != 0) {
                                    this.zzw = SystemClock.elapsedRealtime();
                                }
                                if ((i11 & 4) != 0) {
                                    zzX();
                                }
                                if ((i11 & 8) != 0) {
                                    zzZ();
                                }
                                if ((i11 & 16) != 0) {
                                    zzY();
                                }
                                if ((i11 & 32) != 0) {
                                    this.zzw = SystemClock.elapsedRealtime();
                                    zzam zzamVar = this.zzz;
                                    if (zzamVar != null) {
                                        zzamVar.zza();
                                    }
                                }
                                if ((i11 & 64) != 0) {
                                    this.zzw = SystemClock.elapsedRealtime();
                                    zzaa();
                                }
                            }
                            this.zzx = new MediaStatus(jSONObject2);
                            this.zzw = SystemClock.elapsedRealtime();
                            i11 = 127;
                            if ((i11 & 1) != 0) {
                            }
                            if ((i11 & 2) != 0) {
                            }
                            if ((i11 & 128) != 0) {
                            }
                            if ((i11 & 4) != 0) {
                            }
                            if ((i11 & 8) != 0) {
                            }
                            if ((i11 & 16) != 0) {
                            }
                            if ((i11 & 32) != 0) {
                            }
                            if ((i11 & 64) != 0) {
                            }
                        }
                        if (!this.zzi.zze() || this.zzi.zzf(optLong)) {
                            i10 = 0;
                            if (!zzf) {
                                i11 = mediaStatus.zza(jSONObject2, i10);
                                if ((i11 & 1) != 0) {
                                }
                                if ((i11 & 2) != 0) {
                                }
                                if ((i11 & 128) != 0) {
                                }
                                if ((i11 & 4) != 0) {
                                }
                                if ((i11 & 8) != 0) {
                                }
                                if ((i11 & 16) != 0) {
                                }
                                if ((i11 & 32) != 0) {
                                }
                                if ((i11 & 64) != 0) {
                                }
                            }
                            this.zzx = new MediaStatus(jSONObject2);
                            this.zzw = SystemClock.elapsedRealtime();
                            i11 = 127;
                            if ((i11 & 1) != 0) {
                            }
                            if ((i11 & 2) != 0) {
                            }
                            if ((i11 & 128) != 0) {
                            }
                            if ((i11 & 4) != 0) {
                            }
                            if ((i11 & 8) != 0) {
                            }
                            if ((i11 & 16) != 0) {
                            }
                            if ((i11 & 32) != 0) {
                            }
                            if ((i11 & 64) != 0) {
                            }
                        } else {
                            i10 = 1;
                            if (!zzf) {
                            }
                            this.zzx = new MediaStatus(jSONObject2);
                            this.zzw = SystemClock.elapsedRealtime();
                            i11 = 127;
                            if ((i11 & 1) != 0) {
                            }
                            if ((i11 & 2) != 0) {
                            }
                            if ((i11 & 128) != 0) {
                            }
                            if ((i11 & 4) != 0) {
                            }
                            if ((i11 & 8) != 0) {
                            }
                            if ((i11 & 16) != 0) {
                            }
                            if ((i11 & 32) != 0) {
                            }
                            if ((i11 & 64) != 0) {
                            }
                        }
                    } else {
                        this.zzx = null;
                        zzaa();
                        zzX();
                        zzZ();
                        zzY();
                    }
                    Iterator<zzat> it = zza().iterator();
                    while (it.hasNext()) {
                        it.next().zzd(optLong, 0, null);
                    }
                    break;
                case 1:
                    this.zza.w("received unexpected error: Invalid Player State.", new Object[0]);
                    Iterator<zzat> it2 = zza().iterator();
                    while (it2.hasNext()) {
                        it2.next().zzd(optLong, 2100, zzU(jSONObject));
                    }
                    break;
                case 2:
                    this.zzc.zzd(optLong, 2100, zzU(jSONObject));
                    break;
                case 3:
                    this.zzc.zzd(optLong, RemoteMediaPlayer.STATUS_CANCELED, zzU(jSONObject));
                    break;
                case 4:
                    this.zza.w("received unexpected error: Invalid Request.", new Object[0]);
                    Iterator<zzat> it3 = zza().iterator();
                    while (it3.hasNext()) {
                        it3.next().zzd(optLong, CastStatusCodes.INVALID_REQUEST, zzU(jSONObject));
                    }
                    break;
                case 5:
                    Iterator<zzat> it4 = zza().iterator();
                    while (it4.hasNext()) {
                        it4.next().zzd(optLong, 2100, zzU(jSONObject));
                    }
                    if (this.zzz == null) {
                        break;
                    } else {
                        this.zzz.zzb(MediaError.zza(jSONObject));
                        break;
                    }
                case 6:
                    this.zzq.zzd(optLong, 0, null);
                    zzW(jSONObject, "QUEUE_ITEM_IDS");
                    if (this.zzz != null && (zzac = zzac(jSONObject.getJSONArray("itemIds"))) != null) {
                        this.zzz.zze(zzac);
                        break;
                    }
                    break;
                case 7:
                    this.zzs.zzd(optLong, 0, null);
                    zzW(jSONObject, "QUEUE_CHANGE");
                    if (this.zzz != null) {
                        String string2 = jSONObject.getString("changeType");
                        int[] zzac2 = zzac(jSONObject.getJSONArray("itemIds"));
                        int optInt = jSONObject.optInt("insertBefore", 0);
                        if (zzac2 != null) {
                            switch (string2.hashCode()) {
                                case -2130463047:
                                    if (string2.equals(TriggerMethod.INSERT)) {
                                        c11 = 0;
                                        break;
                                    }
                                    c11 = 65535;
                                    break;
                                case -1881281404:
                                    if (string2.equals("REMOVE")) {
                                        c11 = 2;
                                        break;
                                    }
                                    c11 = 65535;
                                    break;
                                case -1785516855:
                                    if (string2.equals(TriggerMethod.UPDATE)) {
                                        c11 = 3;
                                        break;
                                    }
                                    c11 = 65535;
                                    break;
                                case 1122976047:
                                    if (string2.equals("ITEMS_CHANGE")) {
                                        c11 = 1;
                                        break;
                                    }
                                    c11 = 65535;
                                    break;
                                default:
                                    c11 = 65535;
                                    break;
                            }
                            if (c11 == 0) {
                                this.zzz.zzf(zzac2, optInt);
                                break;
                            } else if (c11 == 1) {
                                this.zzz.zzj(zzac2);
                                break;
                            } else if (c11 == 2) {
                                this.zzz.zzh(zzac2);
                                break;
                            } else if (c11 == 3) {
                                int[] zzac3 = zzac(jSONObject.getJSONArray("itemIds"));
                                Preconditions.checkNotNull(zzac3, "A list of item IDs is expected in a QUEUE UPDATE message.");
                                JSONArray optJSONArray = jSONObject.optJSONArray("reorderItemIds");
                                if (optJSONArray != null) {
                                    this.zzz.zzi(CastUtils.zzf(zzac3), CastUtils.zzf((int[]) Preconditions.checkNotNull(zzac(optJSONArray))), jSONObject.optInt("insertBefore", 0));
                                    break;
                                } else {
                                    this.zzz.zze(zzac3);
                                    break;
                                }
                            }
                        }
                    }
                    break;
                case '\b':
                    this.zzr.zzd(optLong, 0, null);
                    zzW(jSONObject, "QUEUE_ITEMS");
                    if (this.zzz != null) {
                        JSONArray jSONArray2 = jSONObject.getJSONArray("items");
                        MediaQueueItem[] mediaQueueItemArr = new MediaQueueItem[jSONArray2.length()];
                        for (int i12 = 0; i12 < jSONArray2.length(); i12++) {
                            mediaQueueItemArr[i12] = new MediaQueueItem.Builder(jSONArray2.getJSONObject(i12)).build();
                        }
                        this.zzz.zzg(mediaQueueItemArr);
                        break;
                    }
                    break;
                case '\t':
                    this.zzv.zzd(optLong, 0, null);
                    if (this.zzB != null && (zzg = CastUtils.zzg(jSONObject, "sessionState")) != null) {
                        this.zzB.setResult(SessionState.fromJson(zzg));
                        break;
                    }
                    break;
            }
        } catch (JSONException e10) {
            this.zza.w("Message is malformed (%s); ignoring: %s", e10.getMessage(), str);
        }
    }

    public final void zzR(long j10, int i10) {
        Iterator<zzat> it = zza().iterator();
        while (it.hasNext()) {
            it.next().zzd(j10, i10, null);
        }
    }

    public final void zzS(zzam zzamVar) {
        this.zzz = zzamVar;
    }

    @Override // com.google.android.gms.cast.internal.zzp
    public final void zzf() {
        zzb();
        zzV();
    }

    public final long zzj() {
        MediaStatus mediaStatus;
        AdBreakStatus adBreakStatus;
        if (this.zzw == 0 || (mediaStatus = this.zzx) == null || (adBreakStatus = mediaStatus.getAdBreakStatus()) == null) {
            return 0L;
        }
        double playbackRate = this.zzx.getPlaybackRate();
        if (playbackRate == 0.0d) {
            playbackRate = 1.0d;
        }
        return zzT(this.zzx.getPlayerState() != 2 ? 0.0d : playbackRate, adBreakStatus.getCurrentBreakClipTimeInMs(), 0L);
    }

    public final long zzk() {
        MediaLiveSeekableRange liveSeekableRange;
        MediaStatus mediaStatus = this.zzx;
        if (mediaStatus == null || (liveSeekableRange = mediaStatus.getLiveSeekableRange()) == null) {
            return 0L;
        }
        long endTime = liveSeekableRange.getEndTime();
        return !liveSeekableRange.isLiveDone() ? zzT(1.0d, endTime, -1L) : endTime;
    }

    public final long zzl() {
        MediaLiveSeekableRange liveSeekableRange;
        MediaStatus mediaStatus = this.zzx;
        if (mediaStatus == null || (liveSeekableRange = mediaStatus.getLiveSeekableRange()) == null) {
            return 0L;
        }
        long startTime = liveSeekableRange.getStartTime();
        if (liveSeekableRange.isMovingWindow()) {
            startTime = zzT(1.0d, startTime, -1L);
        }
        return liveSeekableRange.isLiveDone() ? Math.min(startTime, liveSeekableRange.getEndTime()) : startTime;
    }

    public final long zzm() {
        MediaStatus mediaStatus;
        MediaInfo zzK = zzK();
        if (zzK == null || (mediaStatus = this.zzx) == null) {
            return 0L;
        }
        Long l10 = this.zzy;
        if (l10 == null) {
            if (this.zzw == 0) {
                return 0L;
            }
            double playbackRate = mediaStatus.getPlaybackRate();
            long streamPosition = this.zzx.getStreamPosition();
            return (playbackRate == 0.0d || this.zzx.getPlayerState() != 2) ? streamPosition : zzT(playbackRate, streamPosition, zzK.getStreamDuration());
        }
        if (l10.equals(4294967296000L)) {
            if (this.zzx.getLiveSeekableRange() != null) {
                return Math.min(l10.longValue(), zzk());
            }
            if (zzo() >= 0) {
                return Math.min(l10.longValue(), zzo());
            }
        }
        return l10.longValue();
    }

    public final long zzn() {
        MediaStatus mediaStatus = this.zzx;
        if (mediaStatus != null) {
            return mediaStatus.zzb();
        }
        throw new zzan();
    }

    public final long zzo() {
        MediaInfo zzK = zzK();
        if (zzK != null) {
            return zzK.getStreamDuration();
        }
        return 0L;
    }

    public final long zzp(zzar zzarVar, MediaLoadRequestData mediaLoadRequestData) {
        if (mediaLoadRequestData.getMediaInfo() == null && mediaLoadRequestData.getQueueData() == null) {
            throw new IllegalArgumentException("MediaInfo and MediaQueueData should not be both null");
        }
        JSONObject json = mediaLoadRequestData.toJson();
        if (json == null) {
            throw new IllegalArgumentException("Failed to jsonify the load request due to malformed request");
        }
        long zzd = zzd();
        try {
            json.put("requestId", zzd);
            json.put("type", "LOAD");
        } catch (JSONException unused) {
        }
        zzg(json.toString(), zzd, null);
        this.zzc.zzb(zzd, zzarVar);
        return zzd;
    }

    public final long zzq(zzar zzarVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        long zzd = zzd();
        try {
            jSONObject2.put("requestId", zzd);
            jSONObject2.put("type", "PAUSE");
            jSONObject2.put("mediaSessionId", zzn());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException unused) {
        }
        zzg(jSONObject2.toString(), zzd, null);
        this.zzd.zzb(zzd, zzarVar);
        return zzd;
    }

    public final long zzr(zzar zzarVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        long zzd = zzd();
        try {
            jSONObject2.put("requestId", zzd);
            jSONObject2.put("type", "PLAY");
            jSONObject2.put("mediaSessionId", zzn());
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
        } catch (JSONException unused) {
        }
        zzg(jSONObject2.toString(), zzd, null);
        this.zze.zzb(zzd, zzarVar);
        return zzd;
    }

    public final long zzs(String str, List list) {
        long zzd = zzd();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("requestId", zzd);
            jSONObject.put("type", "PRECACHE");
            jSONObject.put("precacheData", str);
        } catch (JSONException unused) {
        }
        zzg(jSONObject.toString(), zzd, null);
        return zzd;
    }

    public final long zzt(zzar zzarVar, int i10, int i11, int i12) {
        if (i11 > 0 && i12 == 0) {
            i12 = 0;
        } else if (i11 != 0 || i12 <= 0) {
            throw new IllegalArgumentException("Exactly one of nextCount and prevCount must be positive and the other must be zero");
        }
        JSONObject jSONObject = new JSONObject();
        long zzd = zzd();
        try {
            jSONObject.put("requestId", zzd);
            jSONObject.put("type", "QUEUE_GET_ITEM_RANGE");
            jSONObject.put("mediaSessionId", zzn());
            jSONObject.put("itemId", i10);
            if (i11 > 0) {
                jSONObject.put("nextCount", i11);
            }
            if (i12 > 0) {
                jSONObject.put("prevCount", i12);
            }
        } catch (JSONException unused) {
        }
        zzg(jSONObject.toString(), zzd, null);
        this.zzs.zzb(zzd, zzarVar);
        return zzd;
    }

    public final long zzu(zzar zzarVar) {
        JSONObject jSONObject = new JSONObject();
        long zzd = zzd();
        try {
            jSONObject.put("requestId", zzd);
            jSONObject.put("type", "QUEUE_GET_ITEM_IDS");
            jSONObject.put("mediaSessionId", zzn());
        } catch (JSONException unused) {
        }
        zzg(jSONObject.toString(), zzd, null);
        this.zzq.zzb(zzd, zzarVar);
        return zzd;
    }

    public final long zzv(zzar zzarVar, int[] iArr) {
        JSONObject jSONObject = new JSONObject();
        long zzd = zzd();
        try {
            jSONObject.put("requestId", zzd);
            jSONObject.put("type", "QUEUE_GET_ITEMS");
            jSONObject.put("mediaSessionId", zzn());
            JSONArray jSONArray = new JSONArray();
            for (int i10 : iArr) {
                jSONArray.put(i10);
            }
            jSONObject.put("itemIds", jSONArray);
        } catch (JSONException unused) {
        }
        zzg(jSONObject.toString(), zzd, null);
        this.zzr.zzb(zzd, zzarVar);
        return zzd;
    }

    public final long zzw(zzar zzarVar, MediaQueueItem[] mediaQueueItemArr, int i10, int i11, int i12, long j10, JSONObject jSONObject) {
        if (mediaQueueItemArr == null || mediaQueueItemArr.length == 0) {
            throw new IllegalArgumentException("itemsToInsert must not be null or empty.");
        }
        if (j10 != -1 && j10 < 0) {
            StringBuilder sb = new StringBuilder(54);
            sb.append("playPosition can not be negative: ");
            sb.append(j10);
            throw new IllegalArgumentException(sb.toString());
        }
        JSONObject jSONObject2 = new JSONObject();
        long zzd = zzd();
        try {
            jSONObject2.put("requestId", zzd);
            jSONObject2.put("type", "QUEUE_INSERT");
            jSONObject2.put("mediaSessionId", zzn());
            JSONArray jSONArray = new JSONArray();
            for (int i13 = 0; i13 < mediaQueueItemArr.length; i13++) {
                jSONArray.put(i13, mediaQueueItemArr[i13].toJson());
            }
            jSONObject2.put("items", jSONArray);
            if (i10 != 0) {
                jSONObject2.put("insertBefore", i10);
            }
            if (i12 != -1) {
                jSONObject2.put("currentItemIndex", 0);
            }
            if (j10 != -1) {
                jSONObject2.put("currentTime", CastUtils.millisecToSec(j10));
            }
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
            if (zzab()) {
                jSONObject2.put("sequenceNumber", this.zzA);
            }
        } catch (JSONException unused) {
        }
        zzg(jSONObject2.toString(), zzd, null);
        this.zzm.zzb(zzd, new zzal(this, zzarVar));
        return zzd;
    }

    public final long zzx(zzar zzarVar, MediaQueueItem[] mediaQueueItemArr, int i10, int i11, long j10, JSONObject jSONObject) {
        int length;
        String zza;
        if (mediaQueueItemArr == null || (length = mediaQueueItemArr.length) == 0) {
            throw new IllegalArgumentException("items must not be null or empty.");
        }
        if (i10 < 0 || i10 >= length) {
            StringBuilder sb = new StringBuilder(31);
            sb.append("Invalid startIndex: ");
            sb.append(i10);
            throw new IllegalArgumentException(sb.toString());
        }
        if (j10 != -1 && j10 < 0) {
            StringBuilder sb2 = new StringBuilder(54);
            sb2.append("playPosition can not be negative: ");
            sb2.append(j10);
            throw new IllegalArgumentException(sb2.toString());
        }
        JSONObject jSONObject2 = new JSONObject();
        long zzd = zzd();
        this.zzc.zzb(zzd, zzarVar);
        try {
            jSONObject2.put("requestId", zzd);
            jSONObject2.put("type", "QUEUE_LOAD");
            JSONArray jSONArray = new JSONArray();
            for (int i12 = 0; i12 < mediaQueueItemArr.length; i12++) {
                jSONArray.put(i12, mediaQueueItemArr[i12].toJson());
            }
            jSONObject2.put("items", jSONArray);
            zza = MediaCommon.zza(Integer.valueOf(i11));
        } catch (JSONException unused) {
        }
        if (zza == null) {
            StringBuilder sb3 = new StringBuilder(32);
            sb3.append("Invalid repeat mode: ");
            sb3.append(i11);
            throw new IllegalArgumentException(sb3.toString());
        }
        jSONObject2.put("repeatMode", zza);
        jSONObject2.put("startIndex", i10);
        if (j10 != -1) {
            jSONObject2.put("currentTime", CastUtils.millisecToSec(j10));
        }
        if (jSONObject != null) {
            jSONObject2.put("customData", jSONObject);
        }
        if (zzab()) {
            jSONObject2.put("sequenceNumber", this.zzA);
        }
        zzg(jSONObject2.toString(), zzd, null);
        return zzd;
    }

    public final long zzy(zzar zzarVar, int[] iArr, JSONObject jSONObject) {
        if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException("itemIdsToRemove must not be null or empty.");
        }
        JSONObject jSONObject2 = new JSONObject();
        long zzd = zzd();
        try {
            jSONObject2.put("requestId", zzd);
            jSONObject2.put("type", "QUEUE_REMOVE");
            jSONObject2.put("mediaSessionId", zzn());
            JSONArray jSONArray = new JSONArray();
            for (int i10 = 0; i10 < iArr.length; i10++) {
                jSONArray.put(i10, iArr[i10]);
            }
            jSONObject2.put("itemIds", jSONArray);
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
            if (zzab()) {
                jSONObject2.put("sequenceNumber", this.zzA);
            }
        } catch (JSONException unused) {
        }
        zzg(jSONObject2.toString(), zzd, null);
        this.zzo.zzb(zzd, new zzal(this, zzarVar));
        return zzd;
    }

    public final long zzz(zzar zzarVar, int[] iArr, int i10, JSONObject jSONObject) {
        if (iArr == null || iArr.length == 0) {
            throw new IllegalArgumentException("itemIdsToReorder must not be null or empty.");
        }
        JSONObject jSONObject2 = new JSONObject();
        long zzd = zzd();
        try {
            jSONObject2.put("requestId", zzd);
            jSONObject2.put("type", "QUEUE_REORDER");
            jSONObject2.put("mediaSessionId", zzn());
            JSONArray jSONArray = new JSONArray();
            for (int i11 = 0; i11 < iArr.length; i11++) {
                jSONArray.put(i11, iArr[i11]);
            }
            jSONObject2.put("itemIds", jSONArray);
            if (i10 != 0) {
                jSONObject2.put("insertBefore", i10);
            }
            if (jSONObject != null) {
                jSONObject2.put("customData", jSONObject);
            }
            if (zzab()) {
                jSONObject2.put("sequenceNumber", this.zzA);
            }
        } catch (JSONException unused) {
        }
        zzg(jSONObject2.toString(), zzd, null);
        this.zzp.zzb(zzd, new zzal(this, zzarVar));
        return zzd;
    }
}
