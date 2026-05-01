package com.google.android.gms.internal.cast;

import com.raizlabs.android.dbflow.sql.language.Operator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
public final class zzdl {
    @CheckForNull
    public static String zza(@CheckForNull String str) {
        return zzdi.zza(str);
    }

    public static String zzb(@CheckForNull String str, @CheckForNull Object... objArr) {
        int length;
        int length2;
        int indexOf;
        String sb;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            length = objArr.length;
            if (i11 >= length) {
                break;
            }
            Object obj = objArr[i11];
            if (obj == null) {
                sb = "null";
            } else {
                try {
                    sb = obj.toString();
                } catch (Exception e10) {
                    String name = obj.getClass().getName();
                    String hexString = Integer.toHexString(System.identityHashCode(obj));
                    StringBuilder sb2 = new StringBuilder(name.length() + 1 + String.valueOf(hexString).length());
                    sb2.append(name);
                    sb2.append('@');
                    sb2.append(hexString);
                    String sb3 = sb2.toString();
                    Logger.getLogger("com.google.common.base.Strings").logp(Level.WARNING, "com.google.common.base.Strings", "lenientToString", sb3.length() != 0 ? "Exception during lenientFormat for ".concat(sb3) : new String("Exception during lenientFormat for "), (Throwable) e10);
                    String name2 = e10.getClass().getName();
                    StringBuilder sb4 = new StringBuilder(sb3.length() + 9 + name2.length());
                    sb4.append(Operator.Operation.LESS_THAN);
                    sb4.append(sb3);
                    sb4.append(" threw ");
                    sb4.append(name2);
                    sb4.append(Operator.Operation.GREATER_THAN);
                    sb = sb4.toString();
                }
            }
            objArr[i11] = sb;
            i11++;
        }
        StringBuilder sb5 = new StringBuilder(str.length() + (length * 16));
        int i12 = 0;
        while (true) {
            length2 = objArr.length;
            if (i10 >= length2 || (indexOf = str.indexOf("%s", i12)) == -1) {
                break;
            }
            sb5.append((CharSequence) str, i12, indexOf);
            sb5.append(objArr[i10]);
            i12 = indexOf + 2;
            i10++;
        }
        sb5.append((CharSequence) str, i12, str.length());
        if (i10 < length2) {
            sb5.append(" [");
            sb5.append(objArr[i10]);
            for (int i13 = i10 + 1; i13 < objArr.length; i13++) {
                sb5.append(", ");
                sb5.append(objArr[i13]);
            }
            sb5.append(']');
        }
        return sb5.toString();
    }
}
