package com.google.android.gms.internal.cast;

import com.google.android.gms.internal.cast.zzov;
import com.google.android.gms.internal.cast.zzoy;

/* loaded from: classes.dex */
public class zzov<MessageType extends zzoy<MessageType, BuilderType>, BuilderType extends zzov<MessageType, BuilderType>> extends zznq<MessageType, BuilderType> {
    protected MessageType zza;
    protected boolean zzb = false;
    private final MessageType zzc;

    public zzov(MessageType messagetype) {
        this.zzc = messagetype;
        this.zza = (MessageType) messagetype.zzb(4, null, null);
    }

    private static final void zza(MessageType messagetype, MessageType messagetype2) {
        zzqm.zza().zzb(messagetype.getClass()).zzd(messagetype, messagetype2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.cast.zznq
    public final /* synthetic */ zznq zzl(zznr zznrVar) {
        zzo((zzoy) zznrVar);
        return this;
    }

    @Override // com.google.android.gms.internal.cast.zznq
    /* renamed from: zzn, reason: merged with bridge method [inline-methods] */
    public final BuilderType clone() {
        BuilderType buildertype = (BuilderType) this.zzc.zzb(5, null, null);
        buildertype.zzo(zzr());
        return buildertype;
    }

    public final BuilderType zzo(MessageType messagetype) {
        if (this.zzb) {
            zzt();
            this.zzb = false;
        }
        zza(this.zza, messagetype);
        return this;
    }

    public final MessageType zzp() {
        MessageType zzr = zzr();
        boolean z10 = true;
        byte byteValue = ((Byte) zzr.zzb(1, null, null)).byteValue();
        if (byteValue != 1) {
            if (byteValue == 0) {
                z10 = false;
            } else {
                boolean zzf = zzqm.zza().zzb(zzr.getClass()).zzf(zzr);
                zzr.zzb(2, true != zzf ? null : zzr, null);
                z10 = zzf;
            }
        }
        if (z10) {
            return zzr;
        }
        throw new zzrc(zzr);
    }

    @Override // com.google.android.gms.internal.cast.zzqd
    /* renamed from: zzq, reason: merged with bridge method [inline-methods] */
    public MessageType zzr() {
        if (this.zzb) {
            return this.zza;
        }
        MessageType messagetype = this.zza;
        zzqm.zza().zzb(messagetype.getClass()).zzc(messagetype);
        this.zzb = true;
        return this.zza;
    }

    @Override // com.google.android.gms.internal.cast.zzqf
    public final /* synthetic */ zzqe zzs() {
        return this.zzc;
    }

    public void zzt() {
        MessageType messagetype = (MessageType) this.zza.zzb(4, null, null);
        zza(messagetype, this.zza);
        this.zza = messagetype;
    }
}
