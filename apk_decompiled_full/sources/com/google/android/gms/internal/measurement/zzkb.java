package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkb;
import com.google.android.gms.internal.measurement.zzkf;
import java.io.IOException;

/* loaded from: classes.dex */
public class zzkb<MessageType extends zzkf<MessageType, BuilderType>, BuilderType extends zzkb<MessageType, BuilderType>> extends zzin<MessageType, BuilderType> {
    protected zzkf zza;
    private final zzkf zzb;

    public zzkb(MessageType messagetype) {
        this.zzb = messagetype;
        if (messagetype.zzbO()) {
            throw new IllegalArgumentException("Default instance must be immutable.");
        }
        this.zza = messagetype.zzbA();
    }

    private static void zza(Object obj, Object obj2) {
        zzlu.zza().zzb(obj.getClass()).zzg(obj, obj2);
    }

    public final zzkb zzaA(zzkf zzkfVar) {
        if (!this.zzb.equals(zzkfVar)) {
            if (!this.zza.zzbO()) {
                zzaH();
            }
            zza(this.zza, zzkfVar);
        }
        return this;
    }

    public final zzkb zzaB(byte[] bArr, int i10, int i11, zzjr zzjrVar) {
        if (!this.zza.zzbO()) {
            zzaH();
        }
        try {
            zzlu.zza().zzb(this.zza.getClass()).zzh(this.zza, bArr, 0, i11, new zzir(zzjrVar));
            return this;
        } catch (zzkp e10) {
            throw e10;
        } catch (IOException e11) {
            throw new RuntimeException("Reading from byte array should not throw IOException.", e11);
        } catch (IndexOutOfBoundsException unused) {
            throw zzkp.zzf();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002e, code lost:
    
        if (r3 != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final MessageType zzaC() {
        MessageType zzaE = zzaE();
        byte byteValue = ((Byte) zzaE.zzl(1, null, null)).byteValue();
        if (byteValue != 1) {
            if (byteValue != 0) {
                boolean zzk = zzlu.zza().zzb(zzaE.getClass()).zzk(zzaE);
                zzaE.zzl(2, true != zzk ? null : zzaE, null);
            }
            throw new zzmn(zzaE);
        }
        return zzaE;
    }

    @Override // com.google.android.gms.internal.measurement.zzll
    /* renamed from: zzaD, reason: merged with bridge method [inline-methods] */
    public MessageType zzaE() {
        if (!this.zza.zzbO()) {
            return (MessageType) this.zza;
        }
        this.zza.zzbJ();
        return (MessageType) this.zza;
    }

    public final void zzaG() {
        if (this.zza.zzbO()) {
            return;
        }
        zzaH();
    }

    public void zzaH() {
        zzkf zzbA = this.zzb.zzbA();
        zza(zzbA, this.zza);
        this.zza = zzbA;
    }

    @Override // com.google.android.gms.internal.measurement.zzin
    public final /* bridge */ /* synthetic */ zzin zzav(byte[] bArr, int i10, int i11) {
        zzaB(bArr, 0, i11, zzjr.zza);
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.zzin
    public final /* bridge */ /* synthetic */ zzin zzaw(byte[] bArr, int i10, int i11, zzjr zzjrVar) {
        zzaB(bArr, 0, i11, zzjrVar);
        return this;
    }

    @Override // com.google.android.gms.internal.measurement.zzin
    /* renamed from: zzaz, reason: merged with bridge method [inline-methods] */
    public final zzkb clone() {
        zzkb zzkbVar = (zzkb) this.zzb.zzl(5, null, null);
        zzkbVar.zza = zzaE();
        return zzkbVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzln
    public final /* bridge */ /* synthetic */ zzlm zzbS() {
        throw null;
    }
}
