package com.google.android.gms.internal.cast;

import com.google.android.gms.internal.cast.zznq;
import com.google.android.gms.internal.cast.zznr;

/* loaded from: classes.dex */
public abstract class zznq<MessageType extends zznr<MessageType, BuilderType>, BuilderType extends zznq<MessageType, BuilderType>> implements zzqd {
    @Override // 
    /* renamed from: zzk, reason: merged with bridge method [inline-methods] */
    public abstract BuilderType clone();

    public abstract BuilderType zzl(MessageType messagetype);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.cast.zzqd
    public final /* bridge */ /* synthetic */ zzqd zzm(zzqe zzqeVar) {
        if (zzs().getClass().isInstance(zzqeVar)) {
            return zzl((zznr) zzqeVar);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
