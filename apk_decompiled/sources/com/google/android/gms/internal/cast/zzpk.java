package com.google.android.gms.internal.cast;

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
public final class zzpk {
    public static final zzpk zza;
    public static final zzpk zzb;
    public static final zzpk zzc;
    public static final zzpk zzd;
    public static final zzpk zze;
    public static final zzpk zzf;
    public static final zzpk zzg;
    public static final zzpk zzh;
    public static final zzpk zzi;
    public static final zzpk zzj;
    private static final /* synthetic */ zzpk[] zzk;
    private final Class<?> zzl;
    private final Class<?> zzm;
    private final Object zzn;

    static {
        zzpk zzpkVar = new zzpk("VOID", 0, Void.class, Void.class, null);
        zza = zzpkVar;
        Class cls = Integer.TYPE;
        zzpk zzpkVar2 = new zzpk("INT", 1, cls, Integer.class, 0);
        zzb = zzpkVar2;
        zzpk zzpkVar3 = new zzpk("LONG", 2, Long.TYPE, Long.class, 0L);
        zzc = zzpkVar3;
        zzpk zzpkVar4 = new zzpk("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        zzd = zzpkVar4;
        zzpk zzpkVar5 = new zzpk("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        zze = zzpkVar5;
        zzpk zzpkVar6 = new zzpk("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        zzf = zzpkVar6;
        zzpk zzpkVar7 = new zzpk("STRING", 6, String.class, String.class, "");
        zzg = zzpkVar7;
        zzpk zzpkVar8 = new zzpk("BYTE_STRING", 7, zzoe.class, zzoe.class, zzoe.zzb);
        zzh = zzpkVar8;
        zzpk zzpkVar9 = new zzpk("ENUM", 8, cls, Integer.class, null);
        zzi = zzpkVar9;
        zzpk zzpkVar10 = new zzpk("MESSAGE", 9, Object.class, Object.class, null);
        zzj = zzpkVar10;
        zzk = new zzpk[]{zzpkVar, zzpkVar2, zzpkVar3, zzpkVar4, zzpkVar5, zzpkVar6, zzpkVar7, zzpkVar8, zzpkVar9, zzpkVar10};
    }

    private zzpk(String str, int i10, Class cls, Class cls2, Object obj) {
        this.zzl = cls;
        this.zzm = cls2;
        this.zzn = obj;
    }

    public static zzpk[] values() {
        return (zzpk[]) zzk.clone();
    }

    public final Class<?> zza() {
        return this.zzm;
    }
}
