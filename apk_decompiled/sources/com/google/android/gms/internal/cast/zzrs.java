package com.google.android.gms.internal.cast;

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
public final class zzrs {
    public static final zzrs zza;
    public static final zzrs zzb;
    public static final zzrs zzc;
    public static final zzrs zzd;
    public static final zzrs zze;
    public static final zzrs zzf;
    public static final zzrs zzg;
    public static final zzrs zzh;
    public static final zzrs zzi;
    public static final zzrs zzj;
    public static final zzrs zzk;
    public static final zzrs zzl;
    public static final zzrs zzm;
    public static final zzrs zzn;
    public static final zzrs zzo;
    public static final zzrs zzp;
    public static final zzrs zzq;
    public static final zzrs zzr;
    private static final /* synthetic */ zzrs[] zzs;
    private final zzrt zzt;

    static {
        zzrs zzrsVar = new zzrs("DOUBLE", 0, zzrt.DOUBLE, 1);
        zza = zzrsVar;
        zzrs zzrsVar2 = new zzrs("FLOAT", 1, zzrt.FLOAT, 5);
        zzb = zzrsVar2;
        zzrt zzrtVar = zzrt.LONG;
        zzrs zzrsVar3 = new zzrs("INT64", 2, zzrtVar, 0);
        zzc = zzrsVar3;
        zzrs zzrsVar4 = new zzrs("UINT64", 3, zzrtVar, 0);
        zzd = zzrsVar4;
        zzrt zzrtVar2 = zzrt.INT;
        zzrs zzrsVar5 = new zzrs("INT32", 4, zzrtVar2, 0);
        zze = zzrsVar5;
        zzrs zzrsVar6 = new zzrs("FIXED64", 5, zzrtVar, 1);
        zzf = zzrsVar6;
        zzrs zzrsVar7 = new zzrs("FIXED32", 6, zzrtVar2, 5);
        zzg = zzrsVar7;
        zzrs zzrsVar8 = new zzrs("BOOL", 7, zzrt.BOOLEAN, 0);
        zzh = zzrsVar8;
        zzrs zzrsVar9 = new zzrs("STRING", 8, zzrt.STRING, 2);
        zzi = zzrsVar9;
        zzrt zzrtVar3 = zzrt.MESSAGE;
        zzrs zzrsVar10 = new zzrs("GROUP", 9, zzrtVar3, 3);
        zzj = zzrsVar10;
        zzrs zzrsVar11 = new zzrs("MESSAGE", 10, zzrtVar3, 2);
        zzk = zzrsVar11;
        zzrs zzrsVar12 = new zzrs("BYTES", 11, zzrt.BYTE_STRING, 2);
        zzl = zzrsVar12;
        zzrs zzrsVar13 = new zzrs("UINT32", 12, zzrtVar2, 0);
        zzm = zzrsVar13;
        zzrs zzrsVar14 = new zzrs("ENUM", 13, zzrt.ENUM, 0);
        zzn = zzrsVar14;
        zzrs zzrsVar15 = new zzrs("SFIXED32", 14, zzrtVar2, 5);
        zzo = zzrsVar15;
        zzrs zzrsVar16 = new zzrs("SFIXED64", 15, zzrtVar, 1);
        zzp = zzrsVar16;
        zzrs zzrsVar17 = new zzrs("SINT32", 16, zzrtVar2, 0);
        zzq = zzrsVar17;
        zzrs zzrsVar18 = new zzrs("SINT64", 17, zzrtVar, 0);
        zzr = zzrsVar18;
        zzs = new zzrs[]{zzrsVar, zzrsVar2, zzrsVar3, zzrsVar4, zzrsVar5, zzrsVar6, zzrsVar7, zzrsVar8, zzrsVar9, zzrsVar10, zzrsVar11, zzrsVar12, zzrsVar13, zzrsVar14, zzrsVar15, zzrsVar16, zzrsVar17, zzrsVar18};
    }

    private zzrs(String str, int i10, zzrt zzrtVar, int i11) {
        this.zzt = zzrtVar;
    }

    public static zzrs[] values() {
        return (zzrs[]) zzs.clone();
    }

    public final zzrt zza() {
        return this.zzt;
    }
}
