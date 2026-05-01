package com.google.android.gms.internal.cast;

import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: classes.dex */
public abstract class zzdv<K, V> implements Map<K, V>, Serializable {

    @CheckForNull
    private transient zzdw<Map.Entry<K, V>> zza;

    @CheckForNull
    private transient zzdw<K> zzb;

    @CheckForNull
    private transient zzdq<V> zzc;

    public static <K, V> zzdv<K, V> zzc() {
        return (zzdv<K, V>) zzec.zza;
    }

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final boolean containsKey(@CheckForNull Object obj) {
        return false;
    }

    @Override // java.util.Map
    public final boolean containsValue(@CheckForNull Object obj) {
        return values().contains(obj);
    }

    @Override // java.util.Map
    public final boolean equals(@CheckForNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    @Override // java.util.Map
    @CheckForNull
    public final V getOrDefault(@CheckForNull Object obj, @CheckForNull V v10) {
        return v10;
    }

    @Override // java.util.Map
    public final int hashCode() {
        return zzed.zza(entrySet());
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return true;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Set keySet() {
        zzdw<K> zzdwVar = this.zzb;
        if (zzdwVar != null) {
            return zzdwVar;
        }
        zzdw<K> zze = zze();
        this.zzb = zze;
        return zze;
    }

    @Override // java.util.Map
    @CheckForNull
    @Deprecated
    public final V put(K k10, V v10) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @CheckForNull
    @Deprecated
    public final V remove(@CheckForNull Object obj) {
        throw new UnsupportedOperationException();
    }

    public final String toString() {
        int size = size();
        if (size < 0) {
            StringBuilder sb = new StringBuilder(44);
            sb.append("size cannot be negative but was: ");
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder((int) Math.min(size * 8, IjkMediaMeta.AV_CH_STEREO_RIGHT));
        sb2.append(ASCIIPropertyListParser.DICTIONARY_BEGIN_TOKEN);
        boolean z10 = true;
        for (Map.Entry<K, V> entry : entrySet()) {
            if (!z10) {
                sb2.append(", ");
            }
            sb2.append(entry.getKey());
            sb2.append(ASCIIPropertyListParser.DICTIONARY_ASSIGN_TOKEN);
            sb2.append(entry.getValue());
            z10 = false;
        }
        sb2.append(ASCIIPropertyListParser.DICTIONARY_END_TOKEN);
        return sb2.toString();
    }

    public abstract zzdq<V> zza();

    @Override // java.util.Map
    /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzdq<V> values() {
        zzdq<V> zzdqVar = this.zzc;
        if (zzdqVar != null) {
            return zzdqVar;
        }
        zzdq<V> zza = zza();
        this.zzc = zza;
        return zza;
    }

    public abstract zzdw<Map.Entry<K, V>> zzd();

    public abstract zzdw<K> zze();

    @Override // java.util.Map
    /* renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public final zzdw<Map.Entry<K, V>> entrySet() {
        zzdw<Map.Entry<K, V>> zzdwVar = this.zza;
        if (zzdwVar != null) {
            return zzdwVar;
        }
        zzdw<Map.Entry<K, V>> zzd = zzd();
        this.zza = zzd;
        return zzd;
    }
}
