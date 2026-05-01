package com.mobile.brasiltv.utils;

import android.content.Context;
import android.content.SharedPreferences;
import anet.channel.strategy.dispatch.DispatchConstants;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public abstract class q0 {
    public static void a(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("search_history", 0).edit();
        edit.clear();
        edit.apply();
    }

    public static ArrayList b(Context context) {
        ArrayList arrayList = new ArrayList();
        if (c(context) != null && c(context).length() != 0) {
            k7.f.e(c(context), new Object[0]);
            for (String str : c(context).split(DispatchConstants.SIGN_SPLIT_SYMBOL)) {
                if (!"".equals(str)) {
                    arrayList.add(str);
                }
            }
        }
        return arrayList;
    }

    public static String c(Context context) {
        return context.getSharedPreferences("search_history", 0).getString("search_key", "");
    }

    public static void d(Context context, String str) {
        ArrayList b10 = b(context);
        if (b10 != null && b10.contains(str)) {
            b10.remove(str);
        }
        if (b10 == null || b10.size() >= 10) {
            b10.remove(9);
        } else if (b10.contains(str)) {
            b10.remove(str);
        }
        f(context, str, b10);
    }

    public static void e(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("search_history", 0).edit();
        edit.putString("search_key", str);
        edit.apply();
    }

    public static void f(Context context, String str, ArrayList arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            stringBuffer.append(DispatchConstants.SIGN_SPLIT_SYMBOL + ((String) it.next()));
        }
        a(context);
        e(context, DispatchConstants.SIGN_SPLIT_SYMBOL + str + stringBuffer.toString());
    }
}
