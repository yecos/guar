package v1;

import ba.s;
import com.advertlib.bean.AdInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import t9.i;

/* loaded from: classes.dex */
public final class d implements c {

    /* renamed from: a, reason: collision with root package name */
    public final String f19097a = d.class.getSimpleName();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f19098b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public AdInfo f19099c;

    @Override // v1.c
    public AdInfo a(String str, List list, String str2) {
        List list2;
        i.g(str, "adType");
        i.g(list, "adInfos");
        if (list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (!(str2 == null || str2.length() == 0)) {
            String str3 = str + str2;
            List list3 = (List) this.f19098b.get(str3);
            if (list3 == null) {
                list3 = new ArrayList();
                this.f19098b.put(str3, list3);
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                AdInfo adInfo = (AdInfo) it.next();
                if (s.f(str2, adInfo.getMedia_type(), true)) {
                    arrayList2.add(adInfo);
                    if (!list3.contains(adInfo.getAd_id())) {
                        arrayList.add(adInfo);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.addAll(arrayList2);
                list3.clear();
                if (this.f19099c != null && arrayList.size() > 1) {
                    AdInfo adInfo2 = this.f19099c;
                    i.d(adInfo2);
                    arrayList.remove(adInfo2);
                    AdInfo adInfo3 = this.f19099c;
                    i.d(adInfo3);
                    list3.add(adInfo3.getAd_id());
                }
            }
            list2 = list3;
        } else {
            if (list.size() == 1) {
                return (AdInfo) list.get(0);
            }
            list2 = (List) this.f19098b.get(str);
            if (list2 == null) {
                list2 = new ArrayList();
                this.f19098b.put(str, list2);
            }
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                AdInfo adInfo4 = (AdInfo) it2.next();
                if (!list2.contains(adInfo4.getAd_id())) {
                    arrayList.add(adInfo4);
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.addAll(list);
                list2.clear();
                if (this.f19099c != null && arrayList.size() > 1) {
                    AdInfo adInfo5 = this.f19099c;
                    i.d(adInfo5);
                    arrayList.remove(adInfo5);
                    AdInfo adInfo6 = this.f19099c;
                    i.d(adInfo6);
                    list2.add(adInfo6.getAd_id());
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        AdInfo adInfo7 = (AdInfo) arrayList.get(new Random().nextInt(arrayList.size()));
        list2.add(adInfo7.getAd_id());
        this.f19099c = adInfo7;
        return adInfo7;
    }
}
