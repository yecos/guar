package q6;

import android.content.Context;
import com.google.firebase.dynamiclinks.DynamicLink;
import com.mobile.brasiltv.utils.b0;
import com.mobile.brasiltv.utils.d0;
import com.mobile.brasiltv.utils.j1;
import com.titan.ranger.bean.Entry;
import com.titan.ranger.bean.Env;
import com.umeng.analytics.pro.f;
import d6.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import l8.h;
import mobile.com.requestframe.utils.response.CdnListBeanResult;
import mobile.com.requestframe.utils.response.CdnUrl;
import mobile.com.requestframe.utils.response.GetSlbInfoBeanResultData;
import r5.i;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f18234a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final String f18235b = "TitanHelper";

    /* renamed from: c, reason: collision with root package name */
    public static Env f18236c;

    public final void a() {
        CdnUrl cdnUrl;
        CdnUrl cdnUrl2;
        GetSlbInfoBeanResultData A = i.f18523a.A();
        List<CdnListBeanResult> cdn_list = A != null ? A.getCdn_list() : null;
        int i10 = 0;
        if (cdn_list == null || cdn_list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = cdn_list.iterator();
        while (it.hasNext()) {
            CdnListBeanResult cdnListBeanResult = (CdnListBeanResult) it.next();
            ArrayList arrayList2 = new ArrayList();
            List<CdnUrl> url_list = cdnListBeanResult.getUrl_list();
            if (url_list != null) {
                Iterator<T> it2 = url_list.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(((CdnUrl) it2.next()).getUrl());
                }
            }
            String cdn_id_mark = cdnListBeanResult.getCdn_id_mark();
            String str = cdn_id_mark == null ? "" : cdn_id_mark;
            String tag = cdnListBeanResult.getTag();
            String rule_id_mark = cdnListBeanResult.getRule_id_mark();
            String str2 = rule_id_mark == null ? "" : rule_id_mark;
            String main_addr = cdnListBeanResult.getMain_addr();
            String str3 = main_addr == null ? "" : main_addr;
            String main_addr_mark = cdnListBeanResult.getMain_addr_mark();
            String str4 = main_addr_mark == null ? "" : main_addr_mark;
            String spared_addr = cdnListBeanResult.getSpared_addr();
            String str5 = spared_addr == null ? "" : spared_addr;
            String spared_addr_mark = cdnListBeanResult.getSpared_addr_mark();
            String str6 = spared_addr_mark == null ? "" : spared_addr_mark;
            String str7 = t9.i.b(cdnListBeanResult.getCdn_type(), "1") ? "slb" : "";
            List<CdnUrl> url_list2 = cdnListBeanResult.getUrl_list();
            String a10 = d0.a((url_list2 == null || (cdnUrl2 = url_list2.get(i10)) == null) ? null : cdnUrl2.getUrl(), DynamicLink.Builder.KEY_LINK);
            t9.i.f(a10, "getFieldAddress(it.url_list?.get(0)?.url, \"link\")");
            List<CdnUrl> url_list3 = cdnListBeanResult.getUrl_list();
            Iterator it3 = it;
            String a11 = d0.a((url_list3 == null || (cdnUrl = url_list3.get(0)) == null) ? null : cdnUrl.getUrl(), "sign_type");
            t9.i.f(a11, "getFieldAddress(it.url_l…get(0)?.url, \"sign_type\")");
            int size = cdn_list.size() - cdnListBeanResult.getSerial_number();
            String gslb_params = cdnListBeanResult.getGslb_params();
            arrayList.add(new Entry(str, tag, str2, str3, str4, str5, str6, str7, a10, a11, size, 1, arrayList2, gslb_params == null ? "" : gslb_params));
            it = it3;
            i10 = 0;
        }
        if (b0.I(arrayList)) {
            h.f16357m.a().C(arrayList);
        }
    }

    public final void b(Context context, String str) {
        t9.i.g(context, f.X);
        String l10 = b.f12660a.l();
        String E = w6.i.f19214g.E();
        String str2 = v7.b.f19124a;
        t9.i.f(str2, "KEY");
        if (str == null) {
            str = "";
        }
        String b10 = j1.b(context);
        t9.i.f(b10, "getAndroidId(context)");
        Env env = new Env("com.msandroid.mobile", "60201", l10, E, str2, str, b10, -1);
        if (t9.i.b(f18236c, env)) {
            return;
        }
        f18236c = env;
        h a10 = h.f16357m.a();
        Env env2 = f18236c;
        t9.i.d(env2);
        a10.D(env2);
    }
}
