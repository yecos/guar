package com.google.android.gms.internal.cast;

import com.google.android.gms.internal.cast.zzor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
final class zzos<T extends zzor<T>> {
    private static final zzos zzb = new zzos(true);
    final zzqz<T, Object> zza = new zzqs(16);
    private boolean zzc;
    private boolean zzd;

    private zzos() {
    }

    public static <T extends zzor<T>> zzos<T> zza() {
        throw null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void zzd(T r4, java.lang.Object r5) {
        /*
            com.google.android.gms.internal.cast.zzrs r0 = r4.zzb()
            com.google.android.gms.internal.cast.zzph.zze(r5)
            com.google.android.gms.internal.cast.zzrs r1 = com.google.android.gms.internal.cast.zzrs.zza
            com.google.android.gms.internal.cast.zzrt r1 = com.google.android.gms.internal.cast.zzrt.INT
            com.google.android.gms.internal.cast.zzrt r0 = r0.zza()
            int r0 = r0.ordinal()
            switch(r0) {
                case 0: goto L41;
                case 1: goto L3e;
                case 2: goto L3b;
                case 3: goto L38;
                case 4: goto L35;
                case 5: goto L32;
                case 6: goto L29;
                case 7: goto L20;
                case 8: goto L17;
                default: goto L16;
            }
        L16:
            goto L46
        L17:
            boolean r0 = r5 instanceof com.google.android.gms.internal.cast.zzqe
            if (r0 != 0) goto L45
            boolean r0 = r5 instanceof com.google.android.gms.internal.cast.zzpl
            if (r0 == 0) goto L46
            goto L45
        L20:
            boolean r0 = r5 instanceof java.lang.Integer
            if (r0 != 0) goto L45
            boolean r0 = r5 instanceof com.google.android.gms.internal.cast.zzpa
            if (r0 == 0) goto L46
            goto L45
        L29:
            boolean r0 = r5 instanceof com.google.android.gms.internal.cast.zzoe
            if (r0 != 0) goto L45
            boolean r0 = r5 instanceof byte[]
            if (r0 == 0) goto L46
            goto L45
        L32:
            boolean r0 = r5 instanceof java.lang.String
            goto L43
        L35:
            boolean r0 = r5 instanceof java.lang.Boolean
            goto L43
        L38:
            boolean r0 = r5 instanceof java.lang.Double
            goto L43
        L3b:
            boolean r0 = r5 instanceof java.lang.Float
            goto L43
        L3e:
            boolean r0 = r5 instanceof java.lang.Long
            goto L43
        L41:
            boolean r0 = r5 instanceof java.lang.Integer
        L43:
            if (r0 == 0) goto L46
        L45:
            return
        L46:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = 3
            java.lang.Object[] r1 = new java.lang.Object[r1]
            int r2 = r4.zza()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r3 = 0
            r1[r3] = r2
            com.google.android.gms.internal.cast.zzrs r4 = r4.zzb()
            com.google.android.gms.internal.cast.zzrt r4 = r4.zza()
            r2 = 1
            r1[r2] = r4
            java.lang.Class r4 = r5.getClass()
            java.lang.String r4 = r4.getName()
            r5 = 2
            r1[r5] = r4
            java.lang.String r4 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r4 = java.lang.String.format(r4, r1)
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zzos.zzd(com.google.android.gms.internal.cast.zzor, java.lang.Object):void");
    }

    public final /* bridge */ /* synthetic */ Object clone() {
        zzos zzosVar = new zzos();
        for (int i10 = 0; i10 < this.zza.zzb(); i10++) {
            Map.Entry<T, Object> zzg = this.zza.zzg(i10);
            zzosVar.zzc(zzg.getKey(), zzg.getValue());
        }
        for (Map.Entry<T, Object> entry : this.zza.zzc()) {
            zzosVar.zzc(entry.getKey(), entry.getValue());
        }
        zzosVar.zzd = this.zzd;
        return zzosVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzos) {
            return this.zza.equals(((zzos) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zzb() {
        if (this.zzc) {
            return;
        }
        this.zza.zza();
        this.zzc = true;
    }

    public final void zzc(T t10, Object obj) {
        if (!t10.zzc()) {
            zzd(t10, obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                zzd(t10, arrayList.get(i10));
            }
            obj = arrayList;
        }
        if (obj instanceof zzpl) {
            this.zzd = true;
        }
        this.zza.put(t10, obj);
    }

    private zzos(boolean z10) {
        zzb();
        zzb();
    }
}
