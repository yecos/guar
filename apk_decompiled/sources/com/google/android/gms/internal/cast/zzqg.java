package com.google.android.gms.internal.cast;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/* loaded from: classes.dex */
final class zzqg {
    public static String zza(zzqe zzqeVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zzd(zzqeVar, sb, 0);
        return sb.toString();
    }

    public static final void zzb(StringBuilder sb, int i10, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                zzb(sb, i10, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                zzb(sb, i10, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            sb.append(' ');
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"");
            sb.append(zzrb.zza(zzoe.zzl((String) obj)));
            sb.append('\"');
            return;
        }
        if (obj instanceof zzoe) {
            sb.append(": \"");
            sb.append(zzrb.zza((zzoe) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof zzoy) {
            sb.append(" {");
            zzd((zzoy) obj, sb, i10 + 2);
            sb.append("\n");
            while (i11 < i10) {
                sb.append(' ');
                i11++;
            }
            sb.append("}");
            return;
        }
        if (!(obj instanceof Map.Entry)) {
            sb.append(": ");
            sb.append(obj.toString());
            return;
        }
        sb.append(" {");
        Map.Entry entry = (Map.Entry) obj;
        int i13 = i10 + 2;
        zzb(sb, i13, "key", entry.getKey());
        zzb(sb, i13, "value", entry.getValue());
        sb.append("\n");
        while (i11 < i10) {
            sb.append(' ');
            i11++;
        }
        sb.append("}");
    }

    private static final String zzc(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i10 = 0; i10 < str.length(); i10++) {
            char charAt = str.charAt(i10);
            if (Character.isUpperCase(charAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }

    private static void zzd(zzqe zzqeVar, StringBuilder sb, int i10) {
        boolean equals;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TreeSet<String> treeSet = new TreeSet();
        for (Method method : zzqeVar.getClass().getDeclaredMethods()) {
            hashMap2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                hashMap.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        for (String str : treeSet) {
            String substring = str.startsWith("get") ? str.substring(3) : str;
            if (substring.endsWith("List") && !substring.endsWith("OrBuilderList") && !substring.equals("List")) {
                String valueOf = String.valueOf(substring.substring(0, 1).toLowerCase());
                String valueOf2 = String.valueOf(substring.substring(1, substring.length() - 4));
                String concat = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                Method method2 = (Method) hashMap.get(str);
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    zzb(sb, i10, zzc(concat), zzoy.zzy(method2, zzqeVar, new Object[0]));
                }
            }
            if (substring.endsWith("Map") && !substring.equals("Map")) {
                String valueOf3 = String.valueOf(substring.substring(0, 1).toLowerCase());
                String valueOf4 = String.valueOf(substring.substring(1, substring.length() - 3));
                String concat2 = valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3);
                Method method3 = (Method) hashMap.get(str);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    zzb(sb, i10, zzc(concat2), zzoy.zzy(method3, zzqeVar, new Object[0]));
                }
            }
            if (((Method) hashMap2.get(substring.length() != 0 ? "set".concat(substring) : new String("set"))) != null) {
                if (substring.endsWith("Bytes")) {
                    String valueOf5 = String.valueOf(substring.substring(0, substring.length() - 5));
                    if (!hashMap.containsKey(valueOf5.length() != 0 ? "get".concat(valueOf5) : new String("get"))) {
                    }
                }
                String valueOf6 = String.valueOf(substring.substring(0, 1).toLowerCase());
                String valueOf7 = String.valueOf(substring.substring(1));
                String concat3 = valueOf7.length() != 0 ? valueOf6.concat(valueOf7) : new String(valueOf6);
                Method method4 = (Method) hashMap.get(substring.length() != 0 ? "get".concat(substring) : new String("get"));
                Method method5 = (Method) hashMap.get(substring.length() != 0 ? "has".concat(substring) : new String("has"));
                if (method4 != null) {
                    Object zzy = zzoy.zzy(method4, zzqeVar, new Object[0]);
                    if (method5 == null) {
                        if (zzy instanceof Boolean) {
                            if (((Boolean) zzy).booleanValue()) {
                                zzb(sb, i10, zzc(concat3), zzy);
                            }
                        } else if (zzy instanceof Integer) {
                            if (((Integer) zzy).intValue() != 0) {
                                zzb(sb, i10, zzc(concat3), zzy);
                            }
                        } else if (zzy instanceof Float) {
                            if (Float.floatToRawIntBits(((Float) zzy).floatValue()) != 0) {
                                zzb(sb, i10, zzc(concat3), zzy);
                            }
                        } else if (!(zzy instanceof Double)) {
                            if (zzy instanceof String) {
                                equals = zzy.equals("");
                            } else if (zzy instanceof zzoe) {
                                equals = zzy.equals(zzoe.zzb);
                            } else if (!(zzy instanceof zzqe)) {
                                if ((zzy instanceof Enum) && ((Enum) zzy).ordinal() == 0) {
                                }
                                zzb(sb, i10, zzc(concat3), zzy);
                            } else if (zzy != ((zzqe) zzy).zzs()) {
                                zzb(sb, i10, zzc(concat3), zzy);
                            }
                            if (!equals) {
                                zzb(sb, i10, zzc(concat3), zzy);
                            }
                        } else if (Double.doubleToRawLongBits(((Double) zzy).doubleValue()) != 0) {
                            zzb(sb, i10, zzc(concat3), zzy);
                        }
                    } else if (((Boolean) zzoy.zzy(method5, zzqeVar, new Object[0])).booleanValue()) {
                        zzb(sb, i10, zzc(concat3), zzy);
                    }
                }
            }
        }
        if (zzqeVar instanceof zzow) {
            throw null;
        }
        zzre zzreVar = ((zzoy) zzqeVar).zzc;
        if (zzreVar != null) {
            zzreVar.zze(sb, i10);
        }
    }
}
