package com.google.android.gms.internal.cast;

import com.google.android.gms.internal.cast.zznq;
import com.google.android.gms.internal.cast.zznr;
import java.io.IOException;

/* loaded from: classes.dex */
public abstract class zznr<MessageType extends zznr<MessageType, BuilderType>, BuilderType extends zznq<MessageType, BuilderType>> implements zzqe {
    protected int zza = 0;

    public int zzn() {
        throw null;
    }

    @Override // com.google.android.gms.internal.cast.zzqe
    public final zzoe zzo() {
        try {
            int zzq = zzq();
            zzoe zzoeVar = zzoe.zzb;
            byte[] bArr = new byte[zzq];
            zzol zzC = zzol.zzC(bArr);
            zzB(zzC);
            zzC.zzD();
            return new zzoc(bArr);
        } catch (IOException e10) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(name.length() + 72);
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ByteString threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e10);
        }
    }

    void zzp(int i10) {
        throw null;
    }
}
