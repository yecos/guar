package com.google.android.gms.internal.cast;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class zzpn extends zzns<String> implements RandomAccess, zzpo {
    public static final zzpo zza;
    private static final zzpn zzb;
    private final List<Object> zzc;

    static {
        zzpn zzpnVar = new zzpn(10);
        zzb = zzpnVar;
        zzpnVar.zzb();
        zza = zzpnVar;
    }

    public zzpn() {
        this(10);
    }

    private static String zzi(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof zzoe ? ((zzoe) obj).zzm(zzph.zzb) : zzph.zzh((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.cast.zzns, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ void add(int i10, Object obj) {
        zza();
        this.zzc.add(i10, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.cast.zzns, java.util.AbstractList, java.util.List
    public final boolean addAll(int i10, Collection<? extends String> collection) {
        zza();
        if (collection instanceof zzpo) {
            collection = ((zzpo) collection).zzh();
        }
        boolean addAll = this.zzc.addAll(i10, collection);
        ((AbstractList) this).modCount++;
        return addAll;
    }

    @Override // com.google.android.gms.internal.cast.zzns, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        zza();
        this.zzc.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.cast.zzns, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i10) {
        zza();
        Object remove = this.zzc.remove(i10);
        ((AbstractList) this).modCount++;
        return zzi(remove);
    }

    @Override // com.google.android.gms.internal.cast.zzns, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i10, Object obj) {
        zza();
        return zzi(this.zzc.set(i10, (String) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc.size();
    }

    @Override // com.google.android.gms.internal.cast.zzpo
    public final zzpo zzd() {
        return zzc() ? new zzri(this) : this;
    }

    @Override // com.google.android.gms.internal.cast.zzpo
    public final Object zze(int i10) {
        return this.zzc.get(i10);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public final String get(int i10) {
        Object obj = this.zzc.get(i10);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzoe) {
            zzoe zzoeVar = (zzoe) obj;
            String zzm = zzoeVar.zzm(zzph.zzb);
            if (zzoeVar.zzi()) {
                this.zzc.set(i10, zzm);
            }
            return zzm;
        }
        byte[] bArr = (byte[]) obj;
        String zzh = zzph.zzh(bArr);
        if (zzph.zzi(bArr)) {
            this.zzc.set(i10, zzh);
        }
        return zzh;
    }

    @Override // com.google.android.gms.internal.cast.zzpg
    public final /* bridge */ /* synthetic */ zzpg zzg(int i10) {
        if (i10 < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i10);
        arrayList.addAll(this.zzc);
        return new zzpn((ArrayList<Object>) arrayList);
    }

    @Override // com.google.android.gms.internal.cast.zzpo
    public final List<?> zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    public zzpn(int i10) {
        this.zzc = new ArrayList(i10);
    }

    private zzpn(ArrayList<Object> arrayList) {
        this.zzc = arrayList;
    }

    @Override // com.google.android.gms.internal.cast.zzns, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }
}
