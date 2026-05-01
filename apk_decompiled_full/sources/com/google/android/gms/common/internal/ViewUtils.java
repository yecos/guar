package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
/* loaded from: classes.dex */
public class ViewUtils {
    private ViewUtils() {
    }

    @KeepForSdk
    public static String getXmlAttributeString(String str, String str2, Context context, AttributeSet attributeSet, boolean z10, boolean z11, String str3) {
        String attributeValue = attributeSet == null ? null : attributeSet.getAttributeValue(str, str2);
        if (attributeValue != null && attributeValue.startsWith("@string/") && z10) {
            String substring = attributeValue.substring(8);
            String packageName = context.getPackageName();
            TypedValue typedValue = new TypedValue();
            try {
                context.getResources().getValue(packageName + ":string/" + substring, typedValue, true);
            } catch (Resources.NotFoundException unused) {
                StringBuilder sb = new StringBuilder();
                sb.append("Could not find resource for ");
                sb.append(str2);
                sb.append(": ");
                sb.append(attributeValue);
            }
            CharSequence charSequence = typedValue.string;
            if (charSequence != null) {
                attributeValue = charSequence.toString();
            } else {
                String obj = typedValue.toString();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Resource ");
                sb2.append(str2);
                sb2.append(" was not a string: ");
                sb2.append(obj);
            }
        }
        if (z11 && attributeValue == null) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Required XML attribute \"");
            sb3.append(str2);
            sb3.append("\" missing");
        }
        return attributeValue;
    }
}
