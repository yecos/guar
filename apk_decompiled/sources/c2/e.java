package c2;

import android.text.TextUtils;
import com.bigbee.bean.body.CustomizeBodyBean;
import com.bigbee.bean.body.EventBodyBean;
import com.bigbee.bean.body.KeyValueBean;
import com.bigbee.db.EventDbModel;
import com.google.firebase.dynamiclinks.DynamicLink;
import com.google.gson.Gson;
import com.hpplay.component.common.ParamsMap;
import i2.d;
import java.util.HashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f5339a = new e();

    /* renamed from: b, reason: collision with root package name */
    public static final String f5340b = e.class.getSimpleName();

    /* renamed from: c, reason: collision with root package name */
    public static final Gson f5341c = new Gson();

    public static final class a implements d.c {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f5342a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f5343b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f5344c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ HashMap f5345d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ boolean f5346e;

        public a(long j10, long j11, String str, HashMap hashMap, boolean z10) {
            this.f5342a = j10;
            this.f5343b = j11;
            this.f5344c = str;
            this.f5345d = hashMap;
            this.f5346e = z10;
        }

        @Override // i2.d.c
        public void a() {
            i2.h hVar = i2.h.f14287a;
            long a10 = hVar.a();
            long j10 = this.f5342a;
            i2.a aVar = i2.a.f14261a;
            long g10 = a10 + (j10 - aVar.g());
            long a11 = this.f5343b > 0 ? hVar.a() + (this.f5343b - aVar.g()) : g10;
            l lVar = l.f5383a;
            if (!TextUtils.isEmpty(lVar.b().getUserName())) {
                HashMap hashMap = this.f5345d;
                String userName = lVar.b().getUserName();
                if (userName == null) {
                    userName = "";
                }
                hashMap.put("uname", userName);
            }
            i.f5350q.a().w(e.f5339a.c(this.f5344c, this.f5345d, g10, a11, this.f5346e));
        }
    }

    public final synchronized void a(String str, HashMap hashMap, long j10, long j11, boolean z10, boolean z11) {
        t9.i.g(str, "eventId");
        t9.i.g(hashMap, DynamicLink.Builder.KEY_DYNAMIC_LINK_PARAMETERS);
        if (str.length() > 0) {
            i2.d.f14275c.a().f(new a(j10, j11, str, hashMap, z10));
        }
    }

    public final EventDbModel c(String str, HashMap hashMap, long j10, long j11, boolean z10) {
        t9.i.g(hashMap, DynamicLink.Builder.KEY_DYNAMIC_LINK_PARAMETERS);
        CustomizeBodyBean customizeBodyBean = new CustomizeBodyBean();
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        if (!hashMap.isEmpty()) {
            for (String str2 : hashMap.keySet()) {
                if (hashMap.get(str2) != null) {
                    copyOnWriteArrayList.add(new KeyValueBean(str2, hashMap.get(str2)));
                }
            }
        }
        l lVar = l.f5383a;
        if (!TextUtils.isEmpty(lVar.b().getUserId())) {
            copyOnWriteArrayList.add(new KeyValueBean(ParamsMap.DeviceParams.KEY_UID, lVar.b().getUserId()));
        }
        if (!copyOnWriteArrayList.isEmpty()) {
            customizeBodyBean.setParameter(copyOnWriteArrayList);
        }
        EventDbModel eventDbModel = new EventDbModel();
        eventDbModel.notIntactEvent = z10;
        String json = f5341c.toJson(customizeBodyBean);
        t9.i.f(json, "eventGson.toJson(mCustomKeyValueBean)");
        EventDbModel transportEventDbModel = new EventBodyBean(lVar.b().getAppVer(), lVar.b().getSysVer(), j10, str, json, j11, lVar.b().getRangerVer()).transportEventDbModel(eventDbModel);
        t9.i.f(transportEventDbModel, "mEventBodyBean.transportEventDbModel(eventDbModel)");
        return transportEventDbModel;
    }
}
