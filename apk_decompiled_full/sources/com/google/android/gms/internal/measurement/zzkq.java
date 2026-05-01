package com.google.android.gms.internal.measurement;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zzb' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public final class zzkq {
    public static final zzkq zza;
    public static final zzkq zzb;
    public static final zzkq zzc;
    public static final zzkq zzd;
    public static final zzkq zze;
    public static final zzkq zzf;
    public static final zzkq zzg;
    public static final zzkq zzh;
    public static final zzkq zzi;
    public static final zzkq zzj;
    private static final /* synthetic */ zzkq[] zzk;
    private final Class zzl;
    private final Class zzm;
    private final Object zzn;

    static {
        zzkq zzkqVar = new zzkq("VOID", 0, Void.class, Void.class, null);
        zza = zzkqVar;
        Class cls = Integer.TYPE;
        zzkq zzkqVar2 = new zzkq("INT", 1, cls, Integer.class, 0);
        zzb = zzkqVar2;
        zzkq zzkqVar3 = new zzkq("LONG", 2, Long.TYPE, Long.class, 0L);
        zzc = zzkqVar3;
        zzkq zzkqVar4 = new zzkq("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        zzd = zzkqVar4;
        zzkq zzkqVar5 = new zzkq("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        zze = zzkqVar5;
        zzkq zzkqVar6 = new zzkq("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        zzf = zzkqVar6;
        zzkq zzkqVar7 = new zzkq("STRING", 6, String.class, String.class, "");
        zzg = zzkqVar7;
        zzkq zzkqVar8 = new zzkq("BYTE_STRING", 7, zzje.class, zzje.class, zzje.zzb);
        zzh = zzkqVar8;
        zzkq zzkqVar9 = new zzkq("ENUM", 8, cls, Integer.class, null);
        zzi = zzkqVar9;
        zzkq zzkqVar10 = new zzkq("MESSAGE", 9, Object.class, Object.class, null);
        zzj = zzkqVar10;
        zzk = new zzkq[]{zzkqVar, zzkqVar2, zzkqVar3, zzkqVar4, zzkqVar5, zzkqVar6, zzkqVar7, zzkqVar8, zzkqVar9, zzkqVar10};
    }

    private zzkq(String str, int i10, Class cls, Class cls2, Object obj) {
        this.zzl = cls;
        this.zzm = cls2;
        this.zzn = obj;
    }

    public static zzkq[] values() {
        return (zzkq[]) zzk.clone();
    }

    public final Class zza() {
        return this.zzm;
    }
}
