package oa;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.X509TrustManager;
import mobile.com.requestframe.utils.bean.ActiveBean;
import mobile.com.requestframe.utils.bean.ApkQueryCouponBean;
import mobile.com.requestframe.utils.bean.ApkReceiveCouponBean;
import mobile.com.requestframe.utils.bean.AreaCodeBean;
import mobile.com.requestframe.utils.bean.BindBean;
import mobile.com.requestframe.utils.bean.BindEmailV2Bean;
import mobile.com.requestframe.utils.bean.BindPhoneBean;
import mobile.com.requestframe.utils.bean.ChangeBindEmailBean;
import mobile.com.requestframe.utils.bean.CheckGetVipBean;
import mobile.com.requestframe.utils.bean.CheckVerificationBean;
import mobile.com.requestframe.utils.bean.CheckVerifyCodeBean;
import mobile.com.requestframe.utils.bean.ConfigBean;
import mobile.com.requestframe.utils.bean.CustomerService;
import mobile.com.requestframe.utils.bean.DeleteMsgParams;
import mobile.com.requestframe.utils.bean.EmailResetPwdBean;
import mobile.com.requestframe.utils.bean.EmailVerifyCodeBean;
import mobile.com.requestframe.utils.bean.ExchangeBean;
import mobile.com.requestframe.utils.bean.ExchangeCodeBean;
import mobile.com.requestframe.utils.bean.ForceBindBean;
import mobile.com.requestframe.utils.bean.FreeTimeBean;
import mobile.com.requestframe.utils.bean.GetAddFavorite;
import mobile.com.requestframe.utils.bean.GetAddSubscribe;
import mobile.com.requestframe.utils.bean.GetAuthInfoBean;
import mobile.com.requestframe.utils.bean.GetBlSearchByContentBean;
import mobile.com.requestframe.utils.bean.GetColumnContentsBean;
import mobile.com.requestframe.utils.bean.GetDelFavorite;
import mobile.com.requestframe.utils.bean.GetDelSubscribe;
import mobile.com.requestframe.utils.bean.GetExchangeOrderBean;
import mobile.com.requestframe.utils.bean.GetFavorite;
import mobile.com.requestframe.utils.bean.GetHomeBean;
import mobile.com.requestframe.utils.bean.GetItemDataBean;
import mobile.com.requestframe.utils.bean.GetLiveDataBean;
import mobile.com.requestframe.utils.bean.GetOrderInfoBean;
import mobile.com.requestframe.utils.bean.GetPriorityVipBean;
import mobile.com.requestframe.utils.bean.GetProgramBean;
import mobile.com.requestframe.utils.bean.GetSearchByContentBean;
import mobile.com.requestframe.utils.bean.GetShortVideoBean;
import mobile.com.requestframe.utils.bean.GetSlbInfoBean;
import mobile.com.requestframe.utils.bean.GiftDaysBean;
import mobile.com.requestframe.utils.bean.HeartBeatBean;
import mobile.com.requestframe.utils.bean.LoginBean;
import mobile.com.requestframe.utils.bean.LoginThirdPartBean;
import mobile.com.requestframe.utils.bean.LogoutBean;
import mobile.com.requestframe.utils.bean.MsgBoxParams;
import mobile.com.requestframe.utils.bean.OrderInfoBean;
import mobile.com.requestframe.utils.bean.PwdCheckBean;
import mobile.com.requestframe.utils.bean.QrGetResultBean;
import mobile.com.requestframe.utils.bean.QueryMsgNumParams;
import mobile.com.requestframe.utils.bean.ReadMsgParams;
import mobile.com.requestframe.utils.bean.ResetPwdEmailBean;
import mobile.com.requestframe.utils.bean.ResultException;
import mobile.com.requestframe.utils.bean.SearchByNameBean;
import mobile.com.requestframe.utils.bean.ShelveDataRequestBean;
import mobile.com.requestframe.utils.bean.SnTokenBean;
import mobile.com.requestframe.utils.bean.StartPlayVODBean;
import mobile.com.requestframe.utils.bean.ThirdPartBean;
import mobile.com.requestframe.utils.bean.TypeQuestionBean;
import mobile.com.requestframe.utils.bean.UnbindBean;
import mobile.com.requestframe.utils.bean.UpdateDeviceTokenBean;
import mobile.com.requestframe.utils.bean.UpdatePwdBean;
import mobile.com.requestframe.utils.bean.UpdateRestrictBean;
import mobile.com.requestframe.utils.bean.UserBindInfo;
import mobile.com.requestframe.utils.bean.UserFeedBean;
import mobile.com.requestframe.utils.bean.VerificationBean;
import mobile.com.requestframe.utils.bean.VodRecommendsRequestBean;
import mobile.com.requestframe.utils.bean.WaitConfirmBean;
import okhttp3.Dispatcher;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/* loaded from: classes3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public qa.b f17679a;

    /* renamed from: b, reason: collision with root package name */
    public qa.b f17680b;

    /* renamed from: c, reason: collision with root package name */
    public qa.b f17681c;

    /* renamed from: d, reason: collision with root package name */
    public qa.b f17682d;

    /* renamed from: e, reason: collision with root package name */
    public Interceptor f17683e;

    /* renamed from: f, reason: collision with root package name */
    public Gson f17684f;

    /* renamed from: g, reason: collision with root package name */
    public int f17685g;

    public class a extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17686b;

        public a(String str) {
            this.f17686b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.l(this.f17686b);
        }
    }

    public class a0 extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17688b;

        public a0(String str) {
            this.f17688b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.h0(this.f17688b);
        }
    }

    public class a1 extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17690b;

        public a1(String str) {
            this.f17690b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.O(this.f17690b);
        }
    }

    public class b extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17692b;

        public b(String str) {
            this.f17692b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.i0(this.f17692b);
        }
    }

    public class b0 extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17694b;

        public b0(String str) {
            this.f17694b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.D(this.f17694b);
        }
    }

    public class b1 extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17696b;

        public b1(String str) {
            this.f17696b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.v0(this.f17696b);
        }
    }

    public class c extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17698b;

        public c(String str) {
            this.f17698b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17682d == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17682d.f0(this.f17698b);
        }
    }

    public class c0 extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17700b;

        public c0(String str) {
            this.f17700b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.n0(this.f17700b);
        }
    }

    public class c1 extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17702b;

        public c1(String str) {
            this.f17702b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.c(this.f17702b);
        }
    }

    /* renamed from: oa.d$d, reason: collision with other inner class name */
    public class C0304d extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17704b;

        public C0304d(String str) {
            this.f17704b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.g0(this.f17704b);
        }
    }

    public class d0 extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17706b;

        public d0(String str) {
            this.f17706b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.m(this.f17706b);
        }
    }

    public class d1 extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17708b;

        public d1(String str) {
            this.f17708b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.K0(this.f17708b);
        }
    }

    public class e extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17710b;

        public e(String str) {
            this.f17710b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.S(this.f17710b);
        }
    }

    public class e0 extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17712b;

        public e0(String str) {
            this.f17712b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.k0(this.f17712b);
        }
    }

    public class e1 extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17714b;

        public e1(String str) {
            this.f17714b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.n(this.f17714b);
        }
    }

    public class f extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17716b;

        public f(String str) {
            this.f17716b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.a0(this.f17716b);
        }
    }

    public class f0 extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17718b;

        public f0(String str) {
            this.f17718b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.s0(this.f17718b);
        }
    }

    public class f1 extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17720b;

        public f1(String str) {
            this.f17720b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.C0(this.f17720b);
        }
    }

    public class g extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17722b;

        public g(String str) {
            this.f17722b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.y0(this.f17722b);
        }
    }

    public class g0 extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17724b;

        public g0(String str) {
            this.f17724b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.j(this.f17724b);
        }
    }

    public class g1 extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17726b;

        public g1(String str) {
            this.f17726b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.z(this.f17726b);
        }
    }

    public class h extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17728b;

        public h(String str) {
            this.f17728b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.K(this.f17728b);
        }
    }

    public class h0 extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17730b;

        public h0(String str) {
            this.f17730b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.o0(this.f17730b);
        }
    }

    public class h1 extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17732b;

        public h1(String str) {
            this.f17732b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.a(this.f17732b);
        }
    }

    public class i extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17734b;

        public i(String str) {
            this.f17734b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.M(this.f17734b);
        }
    }

    public class i0 extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17736b;

        public i0(String str) {
            this.f17736b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.u0(this.f17736b);
        }
    }

    public class i1 extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17738b;

        public i1(String str) {
            this.f17738b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.b(this.f17738b);
        }
    }

    public class j extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17740b;

        public j(String str) {
            this.f17740b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.g(this.f17740b);
        }
    }

    public class j0 extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17742b;

        public j0(String str) {
            this.f17742b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.v(this.f17742b);
        }
    }

    public class j1 extends fa.a {
        public j1() {
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.x("");
        }
    }

    public class k extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17745b;

        public k(String str) {
            this.f17745b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.o(this.f17745b);
        }
    }

    public class k0 extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17747b;

        public k0(String str) {
            this.f17747b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.q0(this.f17747b);
        }
    }

    public class k1 extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17749b;

        public k1(String str) {
            this.f17749b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.s(this.f17749b);
        }
    }

    public class l extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17751b;

        public l(String str) {
            this.f17751b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.i(this.f17751b);
        }
    }

    public class l0 extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17753b;

        public l0(String str) {
            this.f17753b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.d(this.f17753b);
        }
    }

    public class l1 extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17755b;

        public l1(String str) {
            this.f17755b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.d0(this.f17755b);
        }
    }

    public class m extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17757b;

        public m(String str) {
            this.f17757b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.y(this.f17757b);
        }
    }

    public class m0 extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17759b;

        public m0(String str) {
            this.f17759b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.t0(this.f17759b);
        }
    }

    public class m1 extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17761b;

        public m1(String str) {
            this.f17761b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.D0(this.f17761b);
        }
    }

    public class n extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17763b;

        public n(String str) {
            this.f17763b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.L0(this.f17763b);
        }
    }

    public class n0 extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17765b;

        public n0(String str) {
            this.f17765b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.t(this.f17765b);
        }
    }

    public class n1 extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17767b;

        public n1(String str) {
            this.f17767b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.C(this.f17767b);
        }
    }

    public class o extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17769b;

        public o(String str) {
            this.f17769b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.x0(this.f17769b);
        }
    }

    public class o0 extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17771b;

        public o0(String str) {
            this.f17771b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.w0(this.f17771b);
        }
    }

    public class o1 extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17773b;

        public o1(String str) {
            this.f17773b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.T(this.f17773b);
        }
    }

    public class p extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17775b;

        public p(String str) {
            this.f17775b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.x0(this.f17775b);
        }
    }

    public class p0 extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17777b;

        public p0(String str) {
            this.f17777b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.N(this.f17777b);
        }
    }

    public class q extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17779b;

        public q(String str) {
            this.f17779b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.e(this.f17779b);
        }
    }

    public class q0 extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17781b;

        public q0(String str) {
            this.f17781b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.z0(this.f17781b);
        }
    }

    public class r extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17783b;

        public r(String str) {
            this.f17783b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.J0(this.f17783b);
        }
    }

    public class r0 extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17785b;

        public r0(String str) {
            this.f17785b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.B0(this.f17785b);
        }
    }

    public class s extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17787b;

        public s(String str) {
            this.f17787b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.U(this.f17787b);
        }
    }

    public class s0 extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17789b;

        public s0(String str) {
            this.f17789b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.w(this.f17789b);
        }
    }

    public class t extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17791b;

        public t(String str) {
            this.f17791b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.Z(this.f17791b);
        }
    }

    public class t0 extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17793b;

        public t0(String str) {
            this.f17793b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.J(this.f17793b);
        }
    }

    public class u extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17795b;

        public u(String str) {
            this.f17795b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.A(this.f17795b);
        }
    }

    public class u0 extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17797b;

        public u0(String str) {
            this.f17797b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.e0(this.f17797b);
        }
    }

    public class v extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17799b;

        public v(String str) {
            this.f17799b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.I(this.f17799b);
        }
    }

    public class v0 extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17801b;

        public v0(String str) {
            this.f17801b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.q(this.f17801b);
        }
    }

    public class w extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17803b;

        public w(String str) {
            this.f17803b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.I(this.f17803b);
        }
    }

    public class w0 extends fa.a {
        public w0() {
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.p0("");
        }
    }

    public class x extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17806b;

        public x(String str) {
            this.f17806b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.r0(this.f17806b);
        }
    }

    public class x0 extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17808b;

        public x0(String str) {
            this.f17808b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.j0(this.f17808b);
        }
    }

    public class y extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17810b;

        public y(String str) {
            this.f17810b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.B(this.f17810b);
        }
    }

    public class y0 extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17812b;

        public y0(String str) {
            this.f17812b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.R(this.f17812b);
        }
    }

    public class z extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17814b;

        public z(String str) {
            this.f17814b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.V(this.f17814b);
        }
    }

    public class z0 extends fa.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17816b;

        public z0(String str) {
            this.f17816b = str;
        }

        @Override // fa.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Observable a(Throwable th) {
            return (d.this.f17680b == null || (th instanceof ResultException)) ? Observable.error(th) : d.this.f17680b.P(this.f17816b);
        }
    }

    public d() {
        this.f17685g = 15;
        this.f17684f = new GsonBuilder().disableHtmlEscaping().create();
    }

    public Observable A(ConfigBean configBean) {
        String json = this.f17684f.toJson(configBean);
        return this.f17679a.s(json).onErrorResumeNext(new k1(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable B(CustomerService customerService) {
        String json = this.f17684f.toJson(customerService);
        return this.f17679a.a(json).onErrorResumeNext(new h1(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable C(GetDelFavorite getDelFavorite) {
        String json = this.f17684f.toJson(getDelFavorite);
        return this.f17679a.B(json).onErrorResumeNext(new y(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable D() {
        return this.f17679a.p0("").onErrorResumeNext(new w0()).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable E(ExchangeCodeBean exchangeCodeBean) {
        String json = this.f17684f.toJson(exchangeCodeBean);
        return this.f17679a.J(json).onErrorResumeNext(new t0(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable F(GetExchangeOrderBean getExchangeOrderBean) {
        String json = this.f17684f.toJson(getExchangeOrderBean);
        return this.f17679a.A(json).onErrorResumeNext(new u(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable G(GetFavorite getFavorite) {
        String json = this.f17684f.toJson(getFavorite);
        return this.f17679a.V(json).onErrorResumeNext(new z(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable H(FreeTimeBean freeTimeBean) {
        String json = this.f17684f.toJson(freeTimeBean);
        return this.f17679a.D0(json).onErrorResumeNext(new m1(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable I(GetHomeBean getHomeBean) {
        String json = this.f17684f.toJson(getHomeBean);
        return this.f17679a.q(json).onErrorResumeNext(new v0(json)).observeOn(Schedulers.computation());
    }

    public Observable J(GetItemDataBean getItemDataBean) {
        String json = this.f17684f.toJson(getItemDataBean);
        return this.f17679a.K(json).onErrorResumeNext(new h(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable K(GetLiveDataBean getLiveDataBean) {
        String json = this.f17684f.toJson(getLiveDataBean);
        return this.f17679a.i(json).onErrorResumeNext(new l(json)).observeOn(Schedulers.computation());
    }

    public Observable L(GetOrderInfoBean getOrderInfoBean) {
        String json = this.f17684f.toJson(getOrderInfoBean);
        return this.f17679a.I(json).onErrorResumeNext(new v(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable M(OrderInfoBean orderInfoBean) {
        String json = this.f17684f.toJson(orderInfoBean);
        return this.f17679a.I(json).onErrorResumeNext(new w(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable N(GetPriorityVipBean getPriorityVipBean) {
        String json = this.f17684f.toJson(getPriorityVipBean);
        return this.f17679a.C0(json).onErrorResumeNext(new f1(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable O(GetProgramBean getProgramBean) {
        String json = this.f17684f.toJson(getProgramBean);
        return this.f17679a.m(json).onErrorResumeNext(new d0(json)).observeOn(Schedulers.computation());
    }

    public Observable P() {
        return this.f17679a.x("").onErrorResumeNext(new j1()).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable Q(VodRecommendsRequestBean vodRecommendsRequestBean) {
        String json = this.f17684f.toJson(vodRecommendsRequestBean);
        return this.f17679a.M(json).onErrorResumeNext(new i(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable R(ShelveDataRequestBean shelveDataRequestBean) {
        String json = this.f17684f.toJson(shelveDataRequestBean);
        return this.f17679a.y0(json).onErrorResumeNext(new g(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable S(GetShortVideoBean getShortVideoBean) {
        String json = this.f17684f.toJson(getShortVideoBean);
        return this.f17679a.j0(json).onErrorResumeNext(new x0(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable T(GetSlbInfoBean getSlbInfoBean) {
        String json = this.f17684f.toJson(getSlbInfoBean);
        return this.f17679a.y(json).onErrorResumeNext(new m(json)).observeOn(Schedulers.computation());
    }

    public Observable U(ThirdPartBean thirdPartBean) {
        String json = this.f17684f.toJson(thirdPartBean);
        return this.f17679a.j(json).onErrorResumeNext(new g0(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable V(TypeQuestionBean typeQuestionBean) {
        String json = this.f17684f.toJson(typeQuestionBean);
        return this.f17679a.z(json).onErrorResumeNext(new g1(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable W(VerificationBean verificationBean) {
        String json = this.f17684f.toJson(verificationBean);
        return this.f17679a.T(json).onErrorResumeNext(new o1(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable X(HeartBeatBean heartBeatBean) {
        String json = this.f17684f.toJson(heartBeatBean);
        return this.f17679a.i0(json).onErrorResumeNext(new b(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable Y(LoginBean loginBean) {
        String json = this.f17684f.toJson(loginBean);
        return this.f17679a.q0(json).onErrorResumeNext(new k0(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable Z(LoginThirdPartBean loginThirdPartBean) {
        String json = this.f17684f.toJson(loginThirdPartBean);
        return this.f17679a.o0(json).onErrorResumeNext(new h0(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable a0(LogoutBean logoutBean) {
        String json = this.f17684f.toJson(logoutBean);
        return this.f17679a.z0(json).onErrorResumeNext(new q0(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public final qa.b b0(String str, boolean z10) {
        String a10 = ma.t.f16872a.a(str);
        new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        if (a10 == null) {
            throw new NullPointerException("url can't be null!");
        }
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.proxy(Proxy.NO_PROXY);
        Interceptor interceptor = this.f17683e;
        if (interceptor != null) {
            builder.addInterceptor(interceptor);
        }
        long j10 = this.f17685g;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        builder.connectTimeout(j10, timeUnit).readTimeout(this.f17685g, timeUnit).writeTimeout(this.f17685g, timeUnit).dispatcher(new Dispatcher(na.a.f())).addInterceptor(new la.c()).addInterceptor(new la.b()).dns(new ja.c(".portal"));
        X509TrustManager a11 = ma.f.a();
        if (a11 != null) {
            builder.sslSocketFactory(new ma.r(a11), a11);
        }
        return (qa.b) new Retrofit.Builder().client(builder.build()).baseUrl(a10).addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync()).addConverterFactory(ia.a.b(z10)).build().create(qa.b.class);
    }

    public Observable c(ActiveBean activeBean) {
        String json = this.f17684f.toJson(activeBean);
        return this.f17679a.D(json).onErrorResumeNext(new b0(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable c0(PwdCheckBean pwdCheckBean) {
        String json = this.f17684f.toJson(pwdCheckBean);
        return this.f17679a.S(json).onErrorResumeNext(new e(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable d(GetAddSubscribe getAddSubscribe) {
        String json = this.f17684f.toJson(getAddSubscribe);
        return this.f17679a.h0(json).onErrorResumeNext(new a0(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable d0(QrGetResultBean qrGetResultBean) {
        String json = this.f17684f.toJson(qrGetResultBean);
        return this.f17679a.e(json).onErrorResumeNext(new q(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable e(ApkQueryCouponBean apkQueryCouponBean) {
        String json = this.f17684f.toJson(apkQueryCouponBean);
        return this.f17679a.B0(json).onErrorResumeNext(new r0(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable e0(QueryMsgNumParams queryMsgNumParams) {
        String json = this.f17684f.toJson(queryMsgNumParams);
        return this.f17679a.v0(json).onErrorResumeNext(new b1(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable f(ApkReceiveCouponBean apkReceiveCouponBean) {
        String json = this.f17684f.toJson(apkReceiveCouponBean);
        return this.f17679a.w(json).onErrorResumeNext(new s0(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable f0(ReadMsgParams readMsgParams) {
        String json = this.f17684f.toJson(readMsgParams);
        return this.f17679a.O(json).onErrorResumeNext(new a1(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable g(AreaCodeBean areaCodeBean) {
        String json = this.f17684f.toJson(areaCodeBean);
        return this.f17679a.l(json).onErrorResumeNext(new a(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable g0(ResetPwdEmailBean resetPwdEmailBean) {
        String json = this.f17684f.toJson(resetPwdEmailBean);
        return this.f17679a.N(json).onErrorResumeNext(new p0(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable h(GiftDaysBean giftDaysBean) {
        String json = this.f17684f.toJson(giftDaysBean);
        return this.f17679a.g0(json).onErrorResumeNext(new C0304d(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable h0(GetSearchByContentBean getSearchByContentBean) {
        String json = this.f17684f.toJson(getSearchByContentBean);
        return this.f17679a.x0(json).onErrorResumeNext(new o(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable i(BindEmailV2Bean bindEmailV2Bean) {
        String json = this.f17684f.toJson(bindEmailV2Bean);
        return this.f17679a.t(json).onErrorResumeNext(new n0(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable i0(SearchByNameBean searchByNameBean) {
        String json = this.f17684f.toJson(searchByNameBean);
        return this.f17679a.g(json).onErrorResumeNext(new j(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable j(BindPhoneBean bindPhoneBean) {
        String json = this.f17684f.toJson(bindPhoneBean);
        return this.f17679a.d0(json).onErrorResumeNext(new l1(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable j0(EmailVerifyCodeBean emailVerifyCodeBean) {
        String json = this.f17684f.toJson(emailVerifyCodeBean);
        return this.f17679a.d(json).onErrorResumeNext(new l0(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable k(BindBean bindBean) {
        String json = this.f17684f.toJson(bindBean);
        return this.f17679a.u0(json).onErrorResumeNext(new i0(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable k0(SnTokenBean snTokenBean) {
        String json = this.f17684f.toJson(snTokenBean);
        return this.f17679a.o(json).onErrorResumeNext(new k(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable l(GetBlSearchByContentBean getBlSearchByContentBean) {
        String json = this.f17684f.toJson(getBlSearchByContentBean);
        return this.f17679a.X(json).onErrorResumeNext(new p(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable l0(StartPlayVODBean startPlayVODBean) {
        String json = this.f17684f.toJson(startPlayVODBean);
        return this.f17679a.L0(json).onErrorResumeNext(new n(json)).observeOn(Schedulers.computation());
    }

    public Observable m(ChangeBindEmailBean changeBindEmailBean) {
        String json = this.f17684f.toJson(changeBindEmailBean);
        return this.f17679a.w0(json).onErrorResumeNext(new o0(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable m0(UnbindBean unbindBean) {
        String json = this.f17684f.toJson(unbindBean);
        return this.f17679a.v(json).onErrorResumeNext(new j0(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable n(CheckVerifyCodeBean checkVerifyCodeBean) {
        String json = this.f17684f.toJson(checkVerifyCodeBean);
        return this.f17679a.t0(json).onErrorResumeNext(new m0(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable n0(UpdateDeviceTokenBean updateDeviceTokenBean) {
        String json = this.f17684f.toJson(updateDeviceTokenBean);
        return this.f17679a.R(json).onErrorResumeNext(new y0(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable o(ForceBindBean forceBindBean) {
        String json = this.f17684f.toJson(forceBindBean);
        return this.f17679a.n(json).onErrorResumeNext(new e1(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable o0(UpdatePwdBean updatePwdBean) {
        String json = this.f17684f.toJson(updatePwdBean);
        return this.f17679a.J0(json).onErrorResumeNext(new r(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable p(CheckGetVipBean checkGetVipBean) {
        String json = this.f17684f.toJson(checkGetVipBean);
        return this.f17679a.K0(json).onErrorResumeNext(new d1(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable p0(UpdateRestrictBean updateRestrictBean) {
        String json = this.f17684f.toJson(updateRestrictBean);
        return this.f17679a.Z(json).onErrorResumeNext(new t(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable q(CheckVerificationBean checkVerificationBean) {
        String json = this.f17684f.toJson(checkVerificationBean);
        return this.f17679a.C(json).onErrorResumeNext(new n1(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable q0(UserFeedBean userFeedBean) {
        String json = this.f17684f.toJson(userFeedBean);
        return this.f17679a.b(json).onErrorResumeNext(new i1(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable r(GetDelSubscribe getDelSubscribe) {
        String json = this.f17684f.toJson(getDelSubscribe);
        return this.f17679a.n0(json).onErrorResumeNext(new c0(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable r0(WaitConfirmBean waitConfirmBean) {
        String json = this.f17684f.toJson(waitConfirmBean);
        return this.f17679a.k0(json).onErrorResumeNext(new e0(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable s(DeleteMsgParams deleteMsgParams) {
        String json = this.f17684f.toJson(deleteMsgParams);
        return this.f17679a.c(json).onErrorResumeNext(new c1(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable t(EmailResetPwdBean emailResetPwdBean) {
        String json = this.f17684f.toJson(emailResetPwdBean);
        return this.f17679a.U(json).onErrorResumeNext(new s(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable u(ExchangeBean exchangeBean) {
        String json = this.f17684f.toJson(exchangeBean);
        return this.f17679a.s0(json).onErrorResumeNext(new f0(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable v(GetAddFavorite getAddFavorite) {
        String json = this.f17684f.toJson(getAddFavorite);
        return this.f17679a.r0(json).onErrorResumeNext(new x(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable w(GetAuthInfoBean getAuthInfoBean) {
        String json = this.f17684f.toJson(getAuthInfoBean);
        return this.f17681c.f0(json).onErrorResumeNext(new c(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable x(UserBindInfo userBindInfo) {
        String json = this.f17684f.toJson(userBindInfo);
        return this.f17679a.e0(json).onErrorResumeNext(new u0(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable y(MsgBoxParams msgBoxParams) {
        String json = this.f17684f.toJson(msgBoxParams);
        return this.f17679a.P(json).onErrorResumeNext(new z0(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable z(GetColumnContentsBean getColumnContentsBean) {
        String json = this.f17684f.toJson(getColumnContentsBean);
        return this.f17679a.a0(json).onErrorResumeNext(new f(json)).observeOn(AndroidSchedulers.mainThread());
    }

    public d(String str, String str2, Interceptor interceptor) {
        this();
        this.f17683e = interceptor;
        this.f17679a = b0(str, true);
        this.f17680b = b0(str2, true);
        this.f17681c = b0(str, false);
        this.f17682d = b0(str2, false);
    }
}
