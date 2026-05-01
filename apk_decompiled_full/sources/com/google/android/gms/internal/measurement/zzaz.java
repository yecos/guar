package com.google.android.gms.internal.measurement;

import com.hpplay.cybergarage.upnp.control.Control;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class zzaz extends zzaw {
    public zzaz() {
        this.zza.add(zzbl.APPLY);
        this.zza.add(zzbl.BLOCK);
        this.zza.add(zzbl.BREAK);
        this.zza.add(zzbl.CASE);
        this.zza.add(zzbl.DEFAULT);
        this.zza.add(zzbl.CONTINUE);
        this.zza.add(zzbl.DEFINE_FUNCTION);
        this.zza.add(zzbl.FN);
        this.zza.add(zzbl.IF);
        this.zza.add(zzbl.QUOTE);
        this.zza.add(zzbl.RETURN);
        this.zza.add(zzbl.SWITCH);
        this.zza.add(zzbl.TERNARY);
    }

    private static zzap zzc(zzg zzgVar, List list) {
        zzh.zzi(zzbl.FN.name(), 2, list);
        zzap zzb = zzgVar.zzb((zzap) list.get(0));
        zzap zzb2 = zzgVar.zzb((zzap) list.get(1));
        if (!(zzb2 instanceof zzae)) {
            throw new IllegalArgumentException(String.format("FN requires an ArrayValue of parameter names found %s", zzb2.getClass().getCanonicalName()));
        }
        List zzm = ((zzae) zzb2).zzm();
        List arrayList = new ArrayList();
        if (list.size() > 2) {
            arrayList = list.subList(2, list.size());
        }
        return new zzao(zzb.zzi(), zzm, arrayList, zzgVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x0129, code lost:
    
        if (r8.equals("continue") == false) goto L64;
     */
    @Override // com.google.android.gms.internal.measurement.zzaw
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzap zza(String str, zzg zzgVar, List list) {
        zzap zzb;
        zzbl zzblVar = zzbl.ADD;
        int ordinal = zzh.zze(str).ordinal();
        if (ordinal == 2) {
            zzh.zzh(zzbl.APPLY.name(), 3, list);
            zzap zzb2 = zzgVar.zzb((zzap) list.get(0));
            String zzi = zzgVar.zzb((zzap) list.get(1)).zzi();
            zzap zzb3 = zzgVar.zzb((zzap) list.get(2));
            if (!(zzb3 instanceof zzae)) {
                throw new IllegalArgumentException(String.format("Function arguments for Apply are not a list found %s", zzb3.getClass().getCanonicalName()));
            }
            if (zzi.isEmpty()) {
                throw new IllegalArgumentException("Function name for apply is undefined");
            }
            return zzb2.zzbR(zzi, zzgVar, ((zzae) zzb3).zzm());
        }
        if (ordinal == 15) {
            zzh.zzh(zzbl.BREAK.name(), 0, list);
            return zzap.zzh;
        }
        if (ordinal == 25) {
            return zzc(zzgVar, list);
        }
        if (ordinal == 41) {
            zzh.zzi(zzbl.IF.name(), 2, list);
            zzap zzb4 = zzgVar.zzb((zzap) list.get(0));
            zzap zzb5 = zzgVar.zzb((zzap) list.get(1));
            zzap zzb6 = list.size() > 2 ? zzgVar.zzb((zzap) list.get(2)) : null;
            zzap zzapVar = zzap.zzf;
            zzap zzc = zzb4.zzg().booleanValue() ? zzgVar.zzc((zzae) zzb5) : zzb6 != null ? zzgVar.zzc((zzae) zzb6) : zzapVar;
            return zzc instanceof zzag ? zzc : zzapVar;
        }
        if (ordinal == 54) {
            return new zzae(list);
        }
        if (ordinal == 57) {
            if (list.isEmpty()) {
                return zzap.zzj;
            }
            zzh.zzh(zzbl.RETURN.name(), 1, list);
            return new zzag(Control.RETURN, zzgVar.zzb((zzap) list.get(0)));
        }
        if (ordinal != 19) {
            if (ordinal == 20) {
                zzh.zzi(zzbl.DEFINE_FUNCTION.name(), 2, list);
                zzap zzc2 = zzc(zzgVar, list);
                zzai zzaiVar = (zzai) zzc2;
                if (zzaiVar.zzc() == null) {
                    zzgVar.zzg("", zzc2);
                } else {
                    zzgVar.zzg(zzaiVar.zzc(), zzc2);
                }
                return zzc2;
            }
            if (ordinal == 60) {
                zzh.zzh(zzbl.SWITCH.name(), 3, list);
                zzap zzb7 = zzgVar.zzb((zzap) list.get(0));
                zzap zzb8 = zzgVar.zzb((zzap) list.get(1));
                zzap zzb9 = zzgVar.zzb((zzap) list.get(2));
                if (!(zzb8 instanceof zzae)) {
                    throw new IllegalArgumentException("Malformed SWITCH statement, cases are not a list");
                }
                if (!(zzb9 instanceof zzae)) {
                    throw new IllegalArgumentException("Malformed SWITCH statement, case statements are not a list");
                }
                zzae zzaeVar = (zzae) zzb8;
                zzae zzaeVar2 = (zzae) zzb9;
                int i10 = 0;
                boolean z10 = false;
                while (true) {
                    if (i10 >= zzaeVar.zzc()) {
                        if (zzaeVar.zzc() + 1 == zzaeVar2.zzc()) {
                            zzb = zzgVar.zzb(zzaeVar2.zze(zzaeVar.zzc()));
                            if (zzb instanceof zzag) {
                                String zzc3 = ((zzag) zzb).zzc();
                                if (!zzc3.equals(Control.RETURN)) {
                                }
                            }
                        }
                        return zzap.zzf;
                    }
                    if (z10 || zzb7.equals(zzgVar.zzb(zzaeVar.zze(i10)))) {
                        zzb = zzgVar.zzb(zzaeVar2.zze(i10));
                        if (!(zzb instanceof zzag)) {
                            z10 = true;
                        } else if (((zzag) zzb).zzc().equals("break")) {
                            return zzap.zzf;
                        }
                    } else {
                        z10 = false;
                    }
                    i10++;
                }
                return zzb;
            }
            if (ordinal == 61) {
                zzh.zzh(zzbl.TERNARY.name(), 3, list);
                return zzgVar.zzb((zzap) list.get(0)).zzg().booleanValue() ? zzgVar.zzb((zzap) list.get(1)) : zzgVar.zzb((zzap) list.get(2));
            }
            switch (ordinal) {
                case 11:
                    return zzgVar.zza().zzc(new zzae(list));
                case 12:
                    zzh.zzh(zzbl.BREAK.name(), 0, list);
                    return zzap.zzi;
                case 13:
                    break;
                default:
                    return super.zzb(str);
            }
        }
        if (list.isEmpty()) {
            return zzap.zzf;
        }
        zzap zzb10 = zzgVar.zzb((zzap) list.get(0));
        return zzb10 instanceof zzae ? zzgVar.zzc((zzae) zzb10) : zzap.zzf;
    }
}
