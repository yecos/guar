package com.google.android.gms.internal.measurement;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'zzc' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public final class zzne {
    public static final zzne zza;
    public static final zzne zzb;
    public static final zzne zzc;
    public static final zzne zzd;
    public static final zzne zze;
    public static final zzne zzf;
    public static final zzne zzg;
    public static final zzne zzh;
    public static final zzne zzi;
    public static final zzne zzj;
    public static final zzne zzk;
    public static final zzne zzl;
    public static final zzne zzm;
    public static final zzne zzn;
    public static final zzne zzo;
    public static final zzne zzp;
    public static final zzne zzq;
    public static final zzne zzr;
    private static final /* synthetic */ zzne[] zzs;
    private final zznf zzt;

    static {
        zzne zzneVar = new zzne("DOUBLE", 0, zznf.DOUBLE, 1);
        zza = zzneVar;
        zzne zzneVar2 = new zzne("FLOAT", 1, zznf.FLOAT, 5);
        zzb = zzneVar2;
        zznf zznfVar = zznf.LONG;
        zzne zzneVar3 = new zzne("INT64", 2, zznfVar, 0);
        zzc = zzneVar3;
        zzne zzneVar4 = new zzne("UINT64", 3, zznfVar, 0);
        zzd = zzneVar4;
        zznf zznfVar2 = zznf.INT;
        zzne zzneVar5 = new zzne("INT32", 4, zznfVar2, 0);
        zze = zzneVar5;
        zzne zzneVar6 = new zzne("FIXED64", 5, zznfVar, 1);
        zzf = zzneVar6;
        zzne zzneVar7 = new zzne("FIXED32", 6, zznfVar2, 5);
        zzg = zzneVar7;
        zzne zzneVar8 = new zzne("BOOL", 7, zznf.BOOLEAN, 0);
        zzh = zzneVar8;
        zzne zzneVar9 = new zzne("STRING", 8, zznf.STRING, 2);
        zzi = zzneVar9;
        zznf zznfVar3 = zznf.MESSAGE;
        zzne zzneVar10 = new zzne("GROUP", 9, zznfVar3, 3);
        zzj = zzneVar10;
        zzne zzneVar11 = new zzne("MESSAGE", 10, zznfVar3, 2);
        zzk = zzneVar11;
        zzne zzneVar12 = new zzne("BYTES", 11, zznf.BYTE_STRING, 2);
        zzl = zzneVar12;
        zzne zzneVar13 = new zzne("UINT32", 12, zznfVar2, 0);
        zzm = zzneVar13;
        zzne zzneVar14 = new zzne("ENUM", 13, zznf.ENUM, 0);
        zzn = zzneVar14;
        zzne zzneVar15 = new zzne("SFIXED32", 14, zznfVar2, 5);
        zzo = zzneVar15;
        zzne zzneVar16 = new zzne("SFIXED64", 15, zznfVar, 1);
        zzp = zzneVar16;
        zzne zzneVar17 = new zzne("SINT32", 16, zznfVar2, 0);
        zzq = zzneVar17;
        zzne zzneVar18 = new zzne("SINT64", 17, zznfVar, 0);
        zzr = zzneVar18;
        zzs = new zzne[]{zzneVar, zzneVar2, zzneVar3, zzneVar4, zzneVar5, zzneVar6, zzneVar7, zzneVar8, zzneVar9, zzneVar10, zzneVar11, zzneVar12, zzneVar13, zzneVar14, zzneVar15, zzneVar16, zzneVar17, zzneVar18};
    }

    private zzne(String str, int i10, zznf zznfVar, int i11) {
        this.zzt = zznfVar;
    }

    public static zzne[] values() {
        return (zzne[]) zzs.clone();
    }

    public final zznf zza() {
        return this.zzt;
    }
}
