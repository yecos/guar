package v1;

import android.content.Context;
import ba.s;
import com.advertlib.bean.AdInfo;
import com.hpplay.component.protocol.PlistBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import t9.i;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final String f19100a = e.class.getSimpleName();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f19101b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public AdInfo f19102c;

    public final AdInfo a(Context context, String str, List list, String str2, String str3, long j10, boolean z10, String str4) {
        List list2;
        i.g(context, com.umeng.analytics.pro.f.X);
        i.g(str, "adType");
        i.g(list, "adInfos");
        i.g(str3, "userIdentity");
        i.g(str4, "hasPay");
        ArrayList c10 = y1.f.f19726a.c(context, str, list, str3, j10, z10, str4);
        if (c10 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (!(str2 == null || str2.length() == 0)) {
            String str5 = str + str2;
            List list3 = (List) this.f19101b.get(str5);
            if (list3 == null) {
                list3 = new ArrayList();
                this.f19101b.put(str5, list3);
            }
            list2 = list3;
            ArrayList arrayList2 = new ArrayList();
            Iterator it = c10.iterator();
            while (it.hasNext()) {
                AdInfo adInfo = (AdInfo) it.next();
                if (s.f(str2, adInfo.getMedia_type(), true)) {
                    i.f(adInfo, PlistBuilder.KEY_ITEM);
                    arrayList2.add(adInfo);
                    if (!list2.contains(adInfo.getAd_id())) {
                        arrayList.add(adInfo);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.addAll(arrayList2);
                list2.clear();
                if (this.f19102c != null && arrayList.size() > 1) {
                    AdInfo adInfo2 = this.f19102c;
                    i.d(adInfo2);
                    arrayList.remove(adInfo2);
                    AdInfo adInfo3 = this.f19102c;
                    i.d(adInfo3);
                    list2.add(adInfo3.getAd_id());
                }
            }
        } else {
            if (c10.size() == 1) {
                return (AdInfo) c10.get(0);
            }
            list2 = (List) this.f19101b.get(str);
            if (list2 == null) {
                list2 = new ArrayList();
                this.f19101b.put(str, list2);
            }
            Iterator it2 = c10.iterator();
            while (it2.hasNext()) {
                AdInfo adInfo4 = (AdInfo) it2.next();
                if (!list2.contains(adInfo4.getAd_id())) {
                    i.f(adInfo4, PlistBuilder.KEY_ITEM);
                    arrayList.add(adInfo4);
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.addAll(c10);
                list2.clear();
                if (this.f19102c != null && arrayList.size() > 1) {
                    AdInfo adInfo5 = this.f19102c;
                    i.d(adInfo5);
                    arrayList.remove(adInfo5);
                    AdInfo adInfo6 = this.f19102c;
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
        this.f19102c = adInfo7;
        return adInfo7;
    }
}
