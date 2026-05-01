package a2;

import android.text.TextUtils;
import c2.l;
import com.bigbee.bean.CommonParamBean;
import com.bigbee.bean.body.CustomizeBodyBean;
import com.bigbee.bean.body.KeyValueBean;
import com.bigbee.bean.request.BBEventRequestBean;
import com.bigbee.bean.request.CustomizeEventBean;
import com.bigbee.bean.request.EventNameValueBean;
import com.bigbee.db.DbOperations;
import com.bigbee.db.EventDbModel;
import com.google.gson.Gson;
import h9.g;
import h9.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import t9.i;
import t9.j;

/* loaded from: classes.dex */
public final class a implements b {

    /* renamed from: a, reason: collision with root package name */
    public final String f146a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f147b;

    /* renamed from: c, reason: collision with root package name */
    public String f148c;

    /* renamed from: d, reason: collision with root package name */
    public String f149d;

    /* renamed from: e, reason: collision with root package name */
    public String f150e;

    /* renamed from: f, reason: collision with root package name */
    public String f151f;

    /* renamed from: g, reason: collision with root package name */
    public String f152g;

    /* renamed from: h, reason: collision with root package name */
    public String f153h;

    /* renamed from: i, reason: collision with root package name */
    public String f154i;

    /* renamed from: j, reason: collision with root package name */
    public String f155j;

    /* renamed from: k, reason: collision with root package name */
    public final g f156k;

    /* renamed from: l, reason: collision with root package name */
    public Gson f157l;

    /* renamed from: a2.a$a, reason: collision with other inner class name */
    public static final class C0004a extends j implements s9.a {

        /* renamed from: a, reason: collision with root package name */
        public static final C0004a f158a = new C0004a();

        public C0004a() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final DbOperations invoke() {
            return new DbOperations();
        }
    }

    public a() {
        String simpleName = a.class.getSimpleName();
        i.f(simpleName, "javaClass.simpleName");
        this.f146a = simpleName;
        this.f147b = true;
        this.f148c = "";
        this.f149d = "";
        this.f150e = "";
        this.f151f = "";
        this.f152g = "";
        this.f153h = "";
        this.f154i = "";
        this.f155j = "";
        this.f156k = h.b(C0004a.f158a);
        this.f157l = new Gson();
    }

    @Override // a2.b
    public BBEventRequestBean a(List list) {
        List<KeyValueBean> parameter;
        i.g(list, "collectInfos");
        CommonParamBean b10 = l.f5383a.b();
        if (TextUtils.isEmpty(b10.getAppId())) {
            return null;
        }
        BBEventRequestBean bBEventRequestBean = new BBEventRequestBean(b10.getSn(), b10.getAppId(), b10.getModel(), b10.getMacAddr(), b10.getReserve1(), new ArrayList());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            EventDbModel eventDbModel = (EventDbModel) it.next();
            if (!TextUtils.isEmpty(eventDbModel.eventId)) {
                long j10 = eventDbModel.startTime;
                if (j10 > 0) {
                    long j11 = eventDbModel.endTime;
                    if (j11 == 0 || j11 >= j10) {
                        String str = eventDbModel.eventId;
                        i.f(str, "it.eventId");
                        String str2 = eventDbModel.appVer;
                        i.f(str2, "it.appVer");
                        CustomizeEventBean customizeEventBean = new CustomizeEventBean(str, str2, eventDbModel.sysVer, eventDbModel.startTime, eventDbModel.endTime, new ArrayList());
                        if (!TextUtils.isEmpty(eventDbModel.reserveA)) {
                            try {
                                CustomizeBodyBean customizeBodyBean = (CustomizeBodyBean) this.f157l.fromJson(eventDbModel.reserveA, CustomizeBodyBean.class);
                                if (customizeBodyBean != null && (parameter = customizeBodyBean.getParameter()) != null) {
                                    i.f(parameter, "parameter");
                                    for (KeyValueBean keyValueBean : parameter) {
                                        ArrayList<EventNameValueBean> parameter2 = customizeEventBean.getParameter();
                                        if (parameter2 != null) {
                                            String name = keyValueBean.getName();
                                            i.f(name, "listParameter.name");
                                            Object value = keyValueBean.getValue();
                                            i.f(value, "listParameter.value");
                                            parameter2.add(new EventNameValueBean(name, value));
                                        }
                                    }
                                }
                            } catch (Exception e10) {
                                e10.printStackTrace();
                            }
                        }
                        ArrayList<CustomizeEventBean> event = bBEventRequestBean.getEvent();
                        if (event != null) {
                            event.add(customizeEventBean);
                        }
                    }
                }
            }
        }
        return bBEventRequestBean;
    }

    @Override // a2.b
    public void b(List list) {
        i.g(list, "t");
        h().deleteListEvent(list);
    }

    @Override // a2.b
    public void c() {
        h().deleteNum();
    }

    @Override // a2.b
    public void d(Object obj) {
        DbOperations h10 = h();
        i.e(obj, "null cannot be cast to non-null type com.bigbee.db.EventDbModel");
        h10.saveEvent((EventDbModel) obj);
    }

    @Override // a2.b
    public void e(Object obj) {
        DbOperations h10 = h();
        i.e(obj, "null cannot be cast to non-null type com.bigbee.db.EventDbModel");
        h10.updateEvent((EventDbModel) obj);
    }

    @Override // a2.b
    public void f(List list, boolean z10) {
        i.g(list, "collectInfos");
        h().updateReportingStatus(list, z10);
    }

    @Override // a2.b
    public List g() {
        List<EventDbModel> queryLimitNum;
        if (this.f147b) {
            h().updateAllReportingStatus(false);
            this.f147b = false;
        }
        i2.a aVar = i2.a.f14261a;
        if (aVar.a()) {
            aVar.h(false);
            queryLimitNum = h().queryAllList(false);
        } else {
            queryLimitNum = h().queryLimitNum(false);
        }
        i.f(queryLimitNum, "collectInfos");
        f(queryLimitNum, true);
        return queryLimitNum;
    }

    public final DbOperations h() {
        return (DbOperations) this.f156k.getValue();
    }
}
