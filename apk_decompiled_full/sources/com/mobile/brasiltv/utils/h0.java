package com.mobile.brasiltv.utils;

import android.content.Context;
import android.text.TextUtils;
import com.mobile.brasiltv.bean.NationBean;
import com.msandroid.mobile.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class h0 {
    public static String a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] stringArray = context.getResources().getStringArray(R.array.nation);
        String[] stringArray2 = context.getResources().getStringArray(R.array.code);
        int i10 = 0;
        while (true) {
            if (i10 >= stringArray2.length) {
                i10 = -1;
                break;
            }
            if (TextUtils.equals(stringArray2[i10], str)) {
                break;
            }
            i10++;
        }
        return (i10 == -1 || i10 >= stringArray.length) ? "" : stringArray[i10];
    }

    public static String b(String str) {
        return !TextUtils.isEmpty(str) ? str.substring(0, 1).toUpperCase() : "#";
    }

    public static ArrayList c(List list, Map map) {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < list.size(); i10++) {
            if (list.get(i10) != null) {
                ((NationBean) list.get(i10)).setSzm(b(((NationBean) list.get(i10)).getCountry()));
                arrayList.add((NationBean) list.get(i10));
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i11 = 65; i11 < 91; i11++) {
            String str = ((char) i11) + "";
            Iterator it = list.iterator();
            while (it.hasNext()) {
                NationBean nationBean = (NationBean) it.next();
                if (str.equals(nationBean.getSzm())) {
                    arrayList2.add(nationBean);
                }
            }
        }
        for (int i12 = 0; i12 < arrayList2.size(); i12++) {
            if (!map.containsKey(((NationBean) arrayList2.get(i12)).getSzm())) {
                map.put(((NationBean) arrayList2.get(i12)).getSzm(), Integer.valueOf(i12));
                ((NationBean) arrayList2.get(i12)).setFirstSZM(true);
            }
        }
        return arrayList2;
    }
}
