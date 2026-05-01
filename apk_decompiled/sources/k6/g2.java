package k6;

import android.content.Context;
import android.text.TextUtils;
import com.hpplay.cybergarage.xml.XML;
import com.mobile.brasiltv.activity.MainAty;
import com.mobile.brasiltv.activity.PlayAty;
import com.mobile.brasiltv.bean.AudioTrackBean;
import com.mobile.brasiltv.bean.SubTitleData;
import com.mobile.brasiltv.bean.SubtitleManager;
import com.mobile.brasiltv.bean.event.VodFavEvent;
import com.mobile.brasiltv.bean.event.VodSubEvent;
import com.mobile.brasiltv.db.AudioSettingBean;
import com.mobile.brasiltv.db.MobileDao;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.view.MsgNotifyDialog;
import com.msandroid.mobile.R;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.titan.ranger.bean.Media;
import com.titan.ranger.bean.Program;
import com.titans.entity.RangerPlayTag;
import com.umeng.analytics.pro.bd;
import i6.g0;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import mobile.com.requestframe.utils.response.AddFavorite;
import mobile.com.requestframe.utils.response.AddFavoriteResult;
import mobile.com.requestframe.utils.response.AddSubscribeResult;
import mobile.com.requestframe.utils.response.AssetData;
import mobile.com.requestframe.utils.response.DelFavoriteResult;
import mobile.com.requestframe.utils.response.DelSubscribeResult;
import mobile.com.requestframe.utils.response.EpisodeList;
import mobile.com.requestframe.utils.response.GetItemDataResult;
import mobile.com.requestframe.utils.response.GetItemDataResultData;
import mobile.com.requestframe.utils.response.License;
import mobile.com.requestframe.utils.response.Movie;
import mobile.com.requestframe.utils.response.ProgramSeason;
import mobile.com.requestframe.utils.response.SearchByContent;
import mobile.com.requestframe.utils.response.SearchByContentData;
import mobile.com.requestframe.utils.response.StartPlayVODData;
import mobile.com.requestframe.utils.response.StartPlayVODResult;
import mobile.com.requestframe.utils.response.SubData;
import mobile.com.requestframe.utils.response.SubItem;
import mobile.com.requestframe.utils.response.TotalMovieList;
import w6.i;

/* loaded from: classes3.dex */
public final class g2 implements i6.f0 {

    /* renamed from: a, reason: collision with root package name */
    public final f5.c f15190a;

    /* renamed from: b, reason: collision with root package name */
    public final i6.g0 f15191b;

    /* renamed from: c, reason: collision with root package name */
    public AssetData f15192c;

    /* renamed from: d, reason: collision with root package name */
    public Disposable f15193d;

    /* renamed from: e, reason: collision with root package name */
    public Disposable f15194e;

    /* renamed from: f, reason: collision with root package name */
    public Disposable f15195f;

    /* renamed from: g, reason: collision with root package name */
    public final h9.g f15196g;

    /* renamed from: h, reason: collision with root package name */
    public String f15197h;

    /* renamed from: i, reason: collision with root package name */
    public Disposable f15198i;

    /* renamed from: j, reason: collision with root package name */
    public HashMap f15199j;

    /* renamed from: k, reason: collision with root package name */
    public HashMap f15200k;

    /* renamed from: l, reason: collision with root package name */
    public Movie f15201l;

    /* renamed from: m, reason: collision with root package name */
    public String f15202m;

    /* renamed from: n, reason: collision with root package name */
    public List f15203n;

    /* renamed from: o, reason: collision with root package name */
    public HashMap f15204o;

    /* renamed from: p, reason: collision with root package name */
    public AudioTrackBean f15205p;

    public static final class a extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final a f15206a = new a();

        public a() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final List invoke(SearchByContentData searchByContentData) {
            t9.i.g(searchByContentData, "it");
            SearchByContent data = searchByContentData.getData();
            if (data != null) {
                return data.getAssetList();
            }
            return null;
        }
    }

    public static final class a0 extends ha.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ VodSubEvent f15208b;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15209a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f15209a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(com.mobile.brasiltv.utils.y.f8771a, this.f15209a, null, null, 6, null));
            }
        }

        public a0(VodSubEvent vodSubEvent) {
            this.f15208b = vodSubEvent;
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(AddSubscribeResult addSubscribeResult) {
            t9.i.g(addSubscribeResult, "t");
            this.f15208b.getData().setSubscribeId(addSubscribeResult.getData().getSubscribeId());
            this.f15208b.getData().setHasSubscribe("1");
            g2.this.f0().f0(this.f15208b.getData());
            g2.this.f0().i0();
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            if (TextUtils.equals("portal100062", str)) {
                f1.a.j(com.mobile.brasiltv.utils.f1.f8649a, g2.this.S(), R.string.vod_sub_limit, 0, 4, null);
            } else {
                com.mobile.brasiltv.utils.x.f8754a.w(g2.this.S(), new a(str));
            }
        }
    }

    public static final class b extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final b f15210a = new b();

        public b() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(List list) {
            t9.i.g(list, "it");
            return Boolean.valueOf(com.mobile.brasiltv.utils.b0.I(list));
        }
    }

    public static final class b0 extends ha.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ VodSubEvent f15212b;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15213a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f15213a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(com.mobile.brasiltv.utils.y.f8771a, this.f15213a, null, null, 6, null));
            }
        }

        public b0(VodSubEvent vodSubEvent) {
            this.f15212b = vodSubEvent;
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(DelSubscribeResult delSubscribeResult) {
            t9.i.g(delSubscribeResult, "t");
            this.f15212b.getData().setHasSubscribe("0");
            g2.this.f0().f0(this.f15212b.getData());
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            com.mobile.brasiltv.utils.x.f8754a.w(g2.this.S(), new a(str));
        }
    }

    public static final class c extends ha.a {
        public c() {
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(List list) {
            t9.i.g(list, "t");
            g2.this.f0().G1(list);
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
        }
    }

    public static final class d extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final d f15215a = new d();

        public d() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final List invoke(SearchByContentData searchByContentData) {
            t9.i.g(searchByContentData, "it");
            SearchByContent data = searchByContentData.getData();
            if (data != null) {
                return data.getAssetList();
            }
            return null;
        }
    }

    public static final class e extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final e f15216a = new e();

        public e() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(List list) {
            t9.i.g(list, "it");
            return Boolean.valueOf(com.mobile.brasiltv.utils.b0.I(list));
        }
    }

    public static final class f extends ha.a {
        public f() {
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(List list) {
            t9.i.g(list, "t");
            g2.this.f0().G1(list);
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
        }
    }

    public static final class g extends t9.j implements s9.l {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f15219b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(String str) {
            super(1);
            this.f15219b = str;
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final List invoke(List list) {
            int i10;
            String str;
            String str2;
            t9.i.g(list, "data");
            ArrayList arrayList = new ArrayList();
            g2 g2Var = g2.this;
            String str3 = this.f15219b;
            Iterator it = list.iterator();
            Object obj = null;
            SubTitleData subTitleData = null;
            while (it.hasNext()) {
                SubData subData = (SubData) it.next();
                List<SubItem> component1 = subData.component1();
                String component2 = subData.component2();
                SubTitleData subTitleData2 = new SubTitleData();
                t9.i.d(component2);
                subTitleData2.setLanguage(component2);
                t9.i.d(component1);
                ArrayList<SubItem> arrayList2 = new ArrayList();
                for (Object obj2 : component1) {
                    if (t9.i.b("srt", ((SubItem) obj2).getFileType())) {
                        arrayList2.add(obj2);
                    }
                }
                for (SubItem subItem : arrayList2) {
                    String url = subItem.getUrl();
                    t9.i.d(url);
                    String a10 = a3.e.a(url, "key_subtitle");
                    String str4 = "";
                    if (a10 == null) {
                        a10 = "";
                    }
                    subTitleData2.setSubUrl(a10);
                    String md5 = subItem.getMd5();
                    if (md5 == null) {
                        md5 = "";
                    }
                    subTitleData2.setMd5(md5);
                    String url2 = subItem.getUrl();
                    if (url2 != null && ba.t.o(url2, "srt", false, 2, obj)) {
                        if (url2 != null) {
                            i10 = 2;
                            str2 = url2.substring(ba.t.D(url2, Operator.Operation.DIVISION, 0, false, 6, null) + 1);
                            t9.i.f(str2, "this as java.lang.String).substring(startIndex)");
                        } else {
                            i10 = 2;
                            str2 = null;
                        }
                        if (str2 != null && str2.length() >= 4) {
                            str4 = str2.substring(0, str2.length() - 4);
                            t9.i.f(str4, "this as java.lang.String…ing(startIndex, endIndex)");
                        }
                    } else {
                        i10 = 2;
                        if (url2 != null) {
                            str = url2.substring(ba.t.D(url2, "preview/", 0, false, 6, null) + 8);
                            t9.i.f(str, "this as java.lang.String).substring(startIndex)");
                        } else {
                            str = null;
                        }
                        if (str != null && ba.t.o(str, Operator.Operation.EMPTY_PARAM, false, 2, null)) {
                            str4 = ba.t.V(str, Operator.Operation.EMPTY_PARAM, null, 2, null);
                        }
                    }
                    subTitleData2.setFilePath(a6.e.a(g2Var.S(), str3, str4, component2));
                    arrayList.add(subTitleData2);
                    int mGlobalLanguage = SubtitleManager.INSTANCE.getMGlobalLanguage();
                    String str5 = "pt";
                    if (mGlobalLanguage != 0) {
                        if (mGlobalLanguage == 1) {
                            str5 = XML.DEFAULT_CONTENT_LANGUAGE;
                        } else if (mGlobalLanguage == i10) {
                            str5 = "es";
                        }
                    }
                    obj = null;
                    if (ba.t.o(component2, str5, false, i10, null)) {
                        subTitleData = subTitleData2;
                    }
                }
            }
            if (subTitleData != null) {
                t9.i.d(subTitleData);
                arrayList.remove(subTitleData);
                arrayList.add(0, subTitleData);
            }
            return arrayList;
        }
    }

    public static final class h extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final h f15220a = new h();

        public h() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(List list) {
            t9.i.g(list, "it");
            if (list.isEmpty()) {
                k7.f.f("no have srt sub", new Object[0]);
            }
            return Boolean.valueOf(!list.isEmpty());
        }
    }

    public static final class i extends t9.j implements s9.l {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f15222b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(String str) {
            super(1);
            this.f15222b = str;
        }

        public final void b(List list) {
            com.mobile.brasiltv.utils.b0.U(g2.this, "subtitle成功 " + list);
            ((SubTitleData) list.get(0)).setSelected(true);
            i6.g0 f02 = g2.this.f0();
            t9.i.f(list, "it");
            f02.I0(list);
            g2.this.I0(this.f15222b, list);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((List) obj);
            return h9.t.f14242a;
        }
    }

    public static final class j extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final j f15223a = new j();

        public j() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return h9.t.f14242a;
        }

        public final void invoke(Throwable th) {
            th.printStackTrace();
        }
    }

    public static final class k extends ha.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ VodFavEvent f15225b;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15226a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f15226a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.y yVar = com.mobile.brasiltv.utils.y.f8771a;
                String p10 = com.mobile.brasiltv.utils.y.p(yVar, this.f15226a, null, null, 6, null);
                yVar.c(this.f15226a);
                com.mobile.brasiltv.utils.f1.f8649a.x(p10);
            }
        }

        public k(VodFavEvent vodFavEvent) {
            this.f15225b = vodFavEvent;
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(DelFavoriteResult delFavoriteResult) {
            t9.i.g(delFavoriteResult, "t");
            this.f15225b.getData().setHasFavorite("0");
            g2.this.f0().W0(this.f15225b.getData());
            g2.this.D0(this.f15225b.getData().getContentId());
        }

        @Override // ha.a, io.reactivex.Observer
        public void onError(Throwable th) {
            t9.i.g(th, "e");
            super.onError(th);
            g2.this.D0(this.f15225b.getData().getContentId());
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            com.mobile.brasiltv.utils.x.f8754a.w(g2.this.S(), new a(str));
        }
    }

    public static final class l extends ha.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ VodFavEvent f15228b;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15229a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f15229a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(com.mobile.brasiltv.utils.y.f8771a, this.f15229a, null, null, 6, null));
            }
        }

        public l(VodFavEvent vodFavEvent) {
            this.f15228b = vodFavEvent;
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(AddFavoriteResult addFavoriteResult) {
            t9.i.g(addFavoriteResult, "t");
            AssetData data = this.f15228b.getData();
            List<AddFavorite> favoriteList = addFavoriteResult.getData().getFavoriteList();
            t9.i.d(favoriteList);
            Integer favoriteId = favoriteList.get(0).getFavoriteId();
            t9.i.d(favoriteId);
            data.setFavoriteId(favoriteId.intValue());
            this.f15228b.getData().setHasFavorite("1");
            g2.this.f0().W0(this.f15228b.getData());
            g2.this.D0(this.f15228b.getData().getContentId());
        }

        @Override // ha.a, io.reactivex.Observer
        public void onError(Throwable th) {
            t9.i.g(th, "e");
            super.onError(th);
            g2.this.D0(this.f15228b.getData().getContentId());
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            if (TextUtils.equals("portal100061", str)) {
                f1.a.j(com.mobile.brasiltv.utils.f1.f8649a, g2.this.S(), R.string.vod_fav_limit, 0, 4, null);
            } else {
                com.mobile.brasiltv.utils.x.f8754a.w(g2.this.S(), new a(str));
            }
        }
    }

    public static final class m extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final m f15230a = new m();

        public static final class a implements Comparator {
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return j9.a.a(Integer.valueOf(((ProgramSeason) obj).getSeasonNumber()), Integer.valueOf(((ProgramSeason) obj2).getSeasonNumber()));
            }
        }

        public m() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final AssetData invoke(GetItemDataResult getItemDataResult) {
            AssetData assetData;
            t9.i.g(getItemDataResult, "it");
            GetItemDataResultData data = getItemDataResult.getData();
            List<ProgramSeason> sameSeasonSeriesList = (data == null || (assetData = data.getAssetData()) == null) ? null : assetData.getSameSeasonSeriesList();
            GetItemDataResultData data2 = getItemDataResult.getData();
            AssetData assetData2 = data2 != null ? data2.getAssetData() : null;
            if (assetData2 != null) {
                assetData2.setSameSeasonSeriesList(sameSeasonSeriesList != null ? i9.r.C(sameSeasonSeriesList, new a()) : null);
            }
            GetItemDataResultData data3 = getItemDataResult.getData();
            if (data3 != null) {
                return data3.getAssetData();
            }
            return null;
        }
    }

    public static final class n extends ha.a {

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15232a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f15232a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(com.mobile.brasiltv.utils.y.f8771a, this.f15232a, null, null, 6, null));
            }
        }

        public n() {
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(AssetData assetData) {
            t9.i.g(assetData, "t");
            com.mobile.brasiltv.utils.b0.U(this, "加载节目数据 " + assetData);
            if (assetData.getSimpleProgramList().isEmpty()) {
                g0.b.b(g2.this.f0(), null, 1, null);
            } else {
                g2.this.f15192c = assetData;
                g2.this.f0().N0(assetData);
            }
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            g2.this.f0().y0(str);
            com.mobile.brasiltv.utils.x.f8754a.w(g2.this.S(), new a(str));
        }
    }

    public static final class o extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final o f15233a = new o();

        public static final class a implements Comparator {
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return j9.a.a(Integer.valueOf(((ProgramSeason) obj).getSeasonNumber()), Integer.valueOf(((ProgramSeason) obj2).getSeasonNumber()));
            }
        }

        public o() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final GetItemDataResult invoke(GetItemDataResult getItemDataResult) {
            AssetData assetData;
            t9.i.g(getItemDataResult, "it");
            GetItemDataResultData data = getItemDataResult.getData();
            List<ProgramSeason> sameSeasonSeriesList = (data == null || (assetData = data.getAssetData()) == null) ? null : assetData.getSameSeasonSeriesList();
            GetItemDataResultData data2 = getItemDataResult.getData();
            AssetData assetData2 = data2 != null ? data2.getAssetData() : null;
            if (assetData2 != null) {
                assetData2.setSameSeasonSeriesList(sameSeasonSeriesList != null ? i9.r.C(sameSeasonSeriesList, new a()) : null);
            }
            return getItemDataResult;
        }
    }

    public static final class p extends ha.a {

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15235a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f15235a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(com.mobile.brasiltv.utils.y.f8771a, this.f15235a, null, null, 6, null));
            }
        }

        public p() {
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(GetItemDataResult getItemDataResult) {
            t9.i.g(getItemDataResult, "t");
            g2.this.f0().g0(false);
            GetItemDataResultData data = getItemDataResult.getData();
            AssetData assetData = data != null ? data.getAssetData() : null;
            com.mobile.brasiltv.utils.b0.U(this, "load season program: " + assetData);
            if (assetData != null) {
                g2.this.f0().d0(assetData);
            }
        }

        @Override // ha.a, io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            super.onSubscribe(disposable);
            g2.this.f15193d = disposable;
            g2.this.f0().g0(true);
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            g2.this.f0().g0(false);
            com.mobile.brasiltv.utils.x.f8754a.w(g2.this.S(), new a(str));
        }
    }

    public static final class q extends t9.j implements s9.a {
        public q() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final MobileDao invoke() {
            Context applicationContext = g2.this.S().getApplicationContext();
            t9.i.f(applicationContext, "context.applicationContext");
            return new MobileDao(applicationContext);
        }
    }

    public static final class r extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t9.w f15237a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g2 f15238b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f15239c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ List f15240d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public r(t9.w wVar, g2 g2Var, String str, List list) {
            super(1);
            this.f15237a = wVar;
            this.f15238b = g2Var;
            this.f15239c = str;
            this.f15240d = list;
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Boolean) obj);
            return h9.t.f14242a;
        }

        public final void invoke(Boolean bool) {
            t9.i.f(bool, "it");
            if (bool.booleanValue()) {
                this.f15238b.f0().D2(this.f15238b.V(), this.f15238b.U());
                i6.g0 f02 = this.f15238b.f0();
                String str = this.f15239c;
                Object obj = this.f15237a.f18961a;
                t9.i.d(obj);
                f02.T1(str, (Program) obj);
                this.f15238b.n0();
                this.f15238b.g0(this.f15240d, this.f15239c);
            }
        }
    }

    public static final class s extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final s f15241a = new s();

        public s() {
            super(1);
        }

        public final void invoke(Throwable th) {
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return h9.t.f14242a;
        }
    }

    public static final class t extends t9.j implements s9.l {
        public t() {
            super(1);
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x0048, code lost:
        
            if ((r0 == null || r0.isEmpty()) != false) goto L29;
         */
        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Boolean invoke(mobile.com.requestframe.utils.response.StartPlayVODResult r5) {
            /*
                r4 = this;
                java.lang.String r0 = "it"
                t9.i.g(r5, r0)
                mobile.com.requestframe.utils.response.StartPlayVODData r0 = r5.getData()
                r1 = 0
                if (r0 == 0) goto L11
                java.util.List r0 = r0.getEpisodeList()
                goto L12
            L11:
                r0 = r1
            L12:
                r2 = 0
                r3 = 1
                if (r0 == 0) goto L1f
                boolean r0 = r0.isEmpty()
                if (r0 == 0) goto L1d
                goto L1f
            L1d:
                r0 = 0
                goto L20
            L1f:
                r0 = 1
            L20:
                if (r0 != 0) goto L4a
                mobile.com.requestframe.utils.response.StartPlayVODData r0 = r5.getData()
                if (r0 == 0) goto L3b
                java.util.List r0 = r0.getEpisodeList()
                if (r0 == 0) goto L3b
                java.lang.Object r0 = r0.get(r2)
                mobile.com.requestframe.utils.response.EpisodeList r0 = (mobile.com.requestframe.utils.response.EpisodeList) r0
                if (r0 == 0) goto L3b
                java.util.List r0 = r0.getTotalMovieList()
                goto L3c
            L3b:
                r0 = r1
            L3c:
                if (r0 == 0) goto L47
                boolean r0 = r0.isEmpty()
                if (r0 == 0) goto L45
                goto L47
            L45:
                r0 = 0
                goto L48
            L47:
                r0 = 1
            L48:
                if (r0 == 0) goto L53
            L4a:
                k6.g2 r0 = k6.g2.this
                i6.g0 r0 = r0.f0()
                i6.g0.b.a(r0, r1, r3, r3, r1)
            L53:
                mobile.com.requestframe.utils.response.StartPlayVODData r5 = r5.getData()
                if (r5 == 0) goto L6b
                java.util.List r5 = r5.getEpisodeList()
                if (r5 == 0) goto L6b
                java.lang.Object r5 = r5.get(r2)
                mobile.com.requestframe.utils.response.EpisodeList r5 = (mobile.com.requestframe.utils.response.EpisodeList) r5
                if (r5 == 0) goto L6b
                java.util.List r1 = r5.getTotalMovieList()
            L6b:
                boolean r5 = com.mobile.brasiltv.utils.b0.I(r1)
                java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: k6.g2.t.invoke(mobile.com.requestframe.utils.response.StartPlayVODResult):java.lang.Boolean");
        }
    }

    public static final class u extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t9.w f15243a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ t9.w f15244b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ t9.u f15245c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ g2 f15246d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public u(t9.w wVar, t9.w wVar2, t9.u uVar, g2 g2Var) {
            super(1);
            this.f15243a = wVar;
            this.f15244b = wVar2;
            this.f15245c = uVar;
            this.f15246d = g2Var;
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final HashMap invoke(StartPlayVODResult startPlayVODResult) {
            t9.i.g(startPlayVODResult, "it");
            t9.w wVar = this.f15243a;
            StartPlayVODData data = startPlayVODResult.getData();
            t9.i.d(data);
            List<EpisodeList> episodeList = data.getEpisodeList();
            t9.i.d(episodeList);
            wVar.f18961a = episodeList.get(0).getSubtitleList();
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            t9.w wVar2 = this.f15244b;
            StartPlayVODData data2 = startPlayVODResult.getData();
            t9.i.d(data2);
            List<EpisodeList> episodeList2 = data2.getEpisodeList();
            t9.i.d(episodeList2);
            String programContentId = episodeList2.get(0).getProgramContentId();
            if (programContentId == null) {
                programContentId = "";
            }
            wVar2.f18961a = programContentId;
            t9.u uVar = this.f15245c;
            StartPlayVODData data3 = startPlayVODResult.getData();
            t9.i.d(data3);
            List<EpisodeList> episodeList3 = data3.getEpisodeList();
            t9.i.d(episodeList3);
            Integer episodeNumber = episodeList3.get(0).getEpisodeNumber();
            uVar.f18959a = episodeNumber != null ? episodeNumber.intValue() : -1;
            StartPlayVODData data4 = startPlayVODResult.getData();
            t9.i.d(data4);
            List<EpisodeList> episodeList4 = data4.getEpisodeList();
            t9.i.d(episodeList4);
            List<TotalMovieList> totalMovieList = episodeList4.get(0).getTotalMovieList();
            t9.i.d(totalMovieList);
            for (TotalMovieList totalMovieList2 : totalMovieList) {
                hashMap2.put(totalMovieList2.getQuality(), totalMovieList2);
                if (com.mobile.brasiltv.utils.b0.I(totalMovieList2.getMovieList())) {
                    String quality = totalMovieList2.getQuality();
                    int hashCode = quality.hashCode();
                    if (hashCode != 1604548) {
                        if (hashCode != 1688155) {
                            if (hashCode == 46737913 && quality.equals("1080p")) {
                                hashMap.put("1080p", totalMovieList2);
                            }
                        } else if (quality.equals("720p")) {
                            hashMap.put("720p", totalMovieList2);
                        }
                    } else if (quality.equals("480p")) {
                        hashMap.put("480p", totalMovieList2);
                    }
                }
            }
            this.f15246d.N0(hashMap2);
            this.f15246d.H0(hashMap2);
            return hashMap;
        }
    }

    public static final class v extends t9.j implements s9.l {
        public v() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(HashMap hashMap) {
            t9.i.g(hashMap, "map");
            if (hashMap.isEmpty()) {
                g0.b.a(g2.this.f0(), null, true, 1, null);
            } else {
                g2.this.N(hashMap);
            }
            return Boolean.valueOf(hashMap.size() > 0);
        }
    }

    public static final class w extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f15248a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g2 f15249b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public w(String str, g2 g2Var) {
            super(1);
            this.f15248a = str;
            this.f15249b = g2Var;
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(HashMap hashMap) {
            t9.i.g(hashMap, "it");
            return !t9.i.b(this.f15248a, this.f15249b.f15197h) ? Boolean.FALSE : Boolean.TRUE;
        }
    }

    public static final class x extends ha.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f15251b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ t9.w f15252c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f15253d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ t9.u f15254e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ t9.w f15255f;

        public static final class a extends t9.j implements s9.l {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String f15256a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str) {
                super(1);
                this.f15256a = str;
            }

            @Override // s9.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return h9.t.f14242a;
            }

            public final void invoke(String str) {
                com.mobile.brasiltv.utils.y yVar = com.mobile.brasiltv.utils.y.f8771a;
                com.mobile.brasiltv.utils.f1.f8649a.x(com.mobile.brasiltv.utils.y.p(yVar, this.f15256a, yVar.m(), null, 4, null));
            }
        }

        public x(boolean z10, t9.w wVar, String str, t9.u uVar, t9.w wVar2) {
            this.f15251b = z10;
            this.f15252c = wVar;
            this.f15253d = str;
            this.f15254e = uVar;
            this.f15255f = wVar2;
        }

        @Override // ha.a, io.reactivex.Observer
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onNext(HashMap hashMap) {
            t9.i.g(hashMap, "map");
            com.mobile.brasiltv.utils.b0.U(this, "点播鉴权成功 " + hashMap);
            g2.this.f0().u1(this.f15251b);
            g2.this.O0(hashMap);
            g2.this.s0(hashMap, (String) this.f15252c.f18961a, this.f15253d, this.f15254e.f18959a, (List) this.f15255f.f18961a);
        }

        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
            com.mobile.brasiltv.utils.b0.U(this, "点播鉴权失败 " + str);
            g0.b.a(g2.this.f0(), str, false, 2, null);
            com.mobile.brasiltv.utils.x.f8754a.w(g2.this.S(), new a(str));
        }
    }

    public static final class y extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final y f15257a = new y();

        public y() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Long l10) {
            t9.i.g(l10, "it");
            return Boolean.valueOf(r5.i.f18523a.I());
        }
    }

    public static final class z implements Observer {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ HashMap f15259b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f15260c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f15261d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f15262e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ List f15263f;

        public z(HashMap hashMap, String str, String str2, int i10, List list) {
            this.f15259b = hashMap;
            this.f15260c = str;
            this.f15261d = str2;
            this.f15262e = i10;
            this.f15263f = list;
        }

        public void a(long j10) {
            Disposable disposable = g2.this.f15198i;
            if (disposable != null) {
                disposable.dispose();
            }
            g2.this.s0(this.f15259b, this.f15260c, this.f15261d, this.f15262e, this.f15263f);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            r5.i iVar = r5.i.f18523a;
            iVar.K(true);
            iVar.L("32600");
            g2.this.s0(this.f15259b, this.f15260c, this.f15261d, this.f15262e, this.f15263f);
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            t9.i.g(th, "e");
        }

        @Override // io.reactivex.Observer
        public /* bridge */ /* synthetic */ void onNext(Object obj) {
            a(((Number) obj).longValue());
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            t9.i.g(disposable, "d");
            g2.this.f15198i = disposable;
        }
    }

    public g2(f5.c cVar, i6.g0 g0Var) {
        t9.i.g(cVar, com.umeng.analytics.pro.f.X);
        t9.i.g(g0Var, "view");
        this.f15190a = cVar;
        this.f15191b = g0Var;
        this.f15196g = h9.h.b(new q());
        this.f15197h = "";
        g0Var.Y0(this);
        this.f15199j = new HashMap();
        this.f15200k = new HashMap();
        this.f15202m = "";
        this.f15203n = new ArrayList();
        this.f15204o = new HashMap();
    }

    public static final HashMap A0(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (HashMap) lVar.invoke(obj);
    }

    public static final boolean B0(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    public static final boolean C0(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    public static final boolean K0(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    public static final List Q(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (List) lVar.invoke(obj);
    }

    public static final boolean R(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    public static final List d0(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (List) lVar.invoke(obj);
    }

    public static final boolean e0(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    public static final List h0(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (List) lVar.invoke(obj);
    }

    public static final boolean i0(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    public static final void j0(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void k0(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final AssetData p0(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (AssetData) lVar.invoke(obj);
    }

    public static final GetItemDataResult r0(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return (GetItemDataResult) lVar.invoke(obj);
    }

    public static /* synthetic */ void t0(g2 g2Var, HashMap hashMap, String str, String str2, int i10, List list, int i11, Object obj) {
        int i12 = (i11 & 8) != 0 ? -1 : i10;
        if ((i11 & 16) != 0) {
            list = null;
        }
        g2Var.s0(hashMap, str, str2, i12, list);
    }

    public static final void u0(HashMap hashMap, g2 g2Var, String str, String str2, t9.w wVar, int i10, List list, ObservableEmitter observableEmitter) {
        List list2;
        String str3;
        Iterator it;
        ArrayList arrayList;
        License license;
        License license2;
        String license3;
        List<Movie> movieList;
        t9.i.g(hashMap, "$map");
        t9.i.g(g2Var, "this$0");
        String str4 = str;
        t9.i.g(str4, "$seriesContentId");
        t9.i.g(str2, "$contentId");
        t9.i.g(wVar, "$program");
        t9.i.g(observableEmitter, "it");
        if (hashMap.isEmpty()) {
            observableEmitter.onNext(Boolean.FALSE);
            return;
        }
        f5.c cVar = g2Var.f15190a;
        t9.i.e(cVar, "null cannot be cast to non-null type com.mobile.brasiltv.activity.PlayAty");
        TotalMovieList totalMovieList = (TotalMovieList) hashMap.get(((PlayAty) cVar).j3().c());
        int i11 = 0;
        g2Var.G0((totalMovieList == null || (movieList = totalMovieList.getMovieList()) == null) ? null : movieList.get(0));
        g2Var.F0(null);
        ArrayList arrayList2 = new ArrayList();
        int mGlobalAudioLanguage = SubtitleManager.INSTANCE.getMGlobalAudioLanguage();
        String str5 = "por";
        boolean z10 = true;
        if (mGlobalAudioLanguage != 0) {
            if (mGlobalAudioLanguage == 1) {
                str5 = "eng";
            } else if (mGlobalAudioLanguage == 2) {
                str5 = "spa";
            }
        }
        if (TextUtils.isEmpty(str)) {
            str4 = str2;
        }
        AudioSettingBean queryAudioSetting = g2Var.W().queryAudioSetting(str4);
        Iterator it2 = hashMap.entrySet().iterator();
        boolean z11 = false;
        while (it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it2.next();
            String str6 = (String) entry.getKey();
            TotalMovieList totalMovieList2 = (TotalMovieList) entry.getValue();
            ArrayList arrayList3 = new ArrayList();
            List<Movie> movieList2 = totalMovieList2.getMovieList();
            t9.i.d(movieList2);
            for (Movie movie : movieList2) {
                List<License> licenseList = movie.getLicenseList();
                if (!(licenseList == null || licenseList.isEmpty())) {
                    List<License> licenseList2 = movie.getLicenseList();
                    String str7 = (licenseList2 == null || (license2 = licenseList2.get(i11)) == null || (license3 = license2.getLicense()) == null) ? "" : license3;
                    List<License> licenseList3 = movie.getLicenseList();
                    if (licenseList3 == null || (license = licenseList3.get(i11)) == null || (str3 = license.getTag()) == null) {
                        list2 = list;
                        str3 = "";
                    } else {
                        list2 = list;
                    }
                    if (list2.contains(str3)) {
                        String contentId = movie.getContentId();
                        if (contentId == null) {
                            contentId = "";
                        }
                        String audioInfo = movie.getAudioInfo();
                        if (audioInfo == null) {
                            audioInfo = "";
                        }
                        String encodeFormat = movie.getEncodeFormat();
                        String str8 = encodeFormat == null ? "" : encodeFormat;
                        String videoFormat = movie.getVideoFormat();
                        it = it2;
                        arrayList = arrayList3;
                        arrayList2.add(new Media(contentId, str7, audioInfo, str6, str8, videoFormat == null ? "" : videoFormat));
                        String audioInfo2 = movie.getAudioInfo();
                        int i12 = 0;
                        for (Object obj : ba.t.M(audioInfo2 == null ? "" : audioInfo2, new String[]{","}, false, 0, 6, null)) {
                            int i13 = i12 + 1;
                            if (i12 < 0) {
                                i9.j.j();
                            }
                            String str9 = (String) obj;
                            String contentId2 = movie.getContentId();
                            String str10 = contentId2 == null ? "" : contentId2;
                            String audioInfo3 = movie.getAudioInfo();
                            AudioTrackBean audioTrackBean = new AudioTrackBean(str10, audioInfo3 == null ? "" : audioInfo3, str9, i12, false, 16, null);
                            boolean z12 = z11;
                            f5.c cVar2 = g2Var.f15190a;
                            t9.i.e(cVar2, "null cannot be cast to non-null type com.mobile.brasiltv.activity.PlayAty");
                            if (t9.i.b(((PlayAty) cVar2).j3().c(), str6) && g2Var.U() == null) {
                                if (str9.equals((queryAudioSetting != null ? queryAudioSetting.getAudioLanguage() : null) != null ? queryAudioSetting != null ? queryAudioSetting.getAudioLanguage() : null : str5)) {
                                    audioTrackBean.setSelected(true);
                                    g2Var.F0(audioTrackBean);
                                    g2Var.G0(movie);
                                    z11 = true;
                                    arrayList.add(audioTrackBean);
                                    i12 = i13;
                                }
                            }
                            z11 = z12;
                            arrayList.add(audioTrackBean);
                            i12 = i13;
                        }
                        arrayList3 = arrayList;
                        i11 = 0;
                        it2 = it;
                    }
                }
                it = it2;
                arrayList = arrayList3;
                arrayList3 = arrayList;
                i11 = 0;
                it2 = it;
            }
            Iterator it3 = it2;
            ArrayList arrayList4 = arrayList3;
            f5.c cVar3 = g2Var.f15190a;
            t9.i.e(cVar3, "null cannot be cast to non-null type com.mobile.brasiltv.activity.PlayAty");
            if (t9.i.b(((PlayAty) cVar3).j3().c(), str6) && g2Var.U() == null && (!arrayList4.isEmpty()) && !z11) {
                ((AudioTrackBean) arrayList4.get(0)).setSelected(true);
                g2Var.F0((AudioTrackBean) arrayList4.get(0));
                List<Movie> movieList3 = totalMovieList2.getMovieList();
                g2Var.G0(movieList3 != null ? movieList3.get(0) : null);
            }
            Collection collection = (Collection) g2Var.V().get(str6);
            if (collection == null || collection.isEmpty()) {
                z10 = true;
                if (!arrayList4.isEmpty()) {
                    g2Var.V().put(str6, arrayList4);
                }
            } else {
                z10 = true;
            }
            it2 = it3;
            i11 = 0;
        }
        if (!(arrayList2.isEmpty() ^ z10) || g2Var.X() == null) {
            observableEmitter.onNext(Boolean.FALSE);
            return;
        }
        wVar.f18961a = g2Var.M(str2, arrayList2, i10);
        long z13 = g2Var.f15191b.z1();
        Object obj2 = wVar.f18961a;
        t9.i.d(obj2);
        ((Program) obj2).setStart(z13);
        observableEmitter.onNext(Boolean.TRUE);
    }

    public static final void v0(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void w0(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final boolean z0(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        return ((Boolean) lVar.invoke(obj)).booleanValue();
    }

    public final void D0(String str) {
        PlayAty.a aVar = PlayAty.G;
        if (aVar.b().contains(str)) {
            aVar.b().remove(str);
        }
    }

    public void E0(String str, AssetData assetData) {
        t9.i.g(str, "contentId");
        t9.i.g(assetData, "program");
        this.f15192c = assetData;
    }

    public void F0(AudioTrackBean audioTrackBean) {
        this.f15205p = audioTrackBean;
    }

    public void G0(Movie movie) {
        this.f15201l = movie;
    }

    public final void H0(HashMap hashMap) {
        ArrayList arrayList = new ArrayList();
        if (hashMap.containsKey("1080p")) {
            Object obj = hashMap.get("1080p");
            t9.i.d(obj);
            if (com.mobile.brasiltv.utils.b0.I(((TotalMovieList) obj).getMovieList())) {
                arrayList.add(new o6.d("1080P", "1080p", true, true));
            } else {
                arrayList.add(new o6.d("1080P", "1080p", true, false));
            }
        }
        if (hashMap.containsKey("720p")) {
            Object obj2 = hashMap.get("720p");
            t9.i.d(obj2);
            if (com.mobile.brasiltv.utils.b0.I(((TotalMovieList) obj2).getMovieList())) {
                arrayList.add(new o6.d("720P", "720p", true, true));
            } else {
                arrayList.add(new o6.d("720P", "720p", true, false));
            }
        }
        if (hashMap.containsKey("480p")) {
            Object obj3 = hashMap.get("480p");
            t9.i.d(obj3);
            if (com.mobile.brasiltv.utils.b0.I(((TotalMovieList) obj3).getMovieList())) {
                arrayList.add(new o6.d("480P", "480p", false, true));
            } else {
                arrayList.add(new o6.d("480P", "480p", false, false));
            }
        }
        Y().clear();
        Y().addAll(arrayList);
    }

    public final void I0(String str, List list) {
        new com.mobile.brasiltv.utils.a1().d(str, list);
    }

    public final void J0(HashMap hashMap, String str, String str2, int i10, List list) {
        Disposable disposable;
        Disposable disposable2 = this.f15198i;
        if (disposable2 != null) {
            t9.i.d(disposable2);
            if (!disposable2.isDisposed() && (disposable = this.f15198i) != null) {
                disposable.dispose();
            }
        }
        Observable<Long> intervalRange = Observable.intervalRange(0L, 45L, 0L, 2L, TimeUnit.SECONDS);
        final y yVar = y.f15257a;
        intervalRange.filter(new Predicate() { // from class: k6.u1
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean K0;
                K0 = g2.K0(s9.l.this, obj);
                return K0;
            }
        }).compose(com.mobile.brasiltv.utils.p0.a()).subscribe(new z(hashMap, str, str2, i10, list));
    }

    public final void L0(String str, VodSubEvent vodSubEvent) {
        w6.i.f19214g.b().L0(str, vodSubEvent.getData().getName(), vodSubEvent.getData().getContentId()).compose(this.f15190a.O1()).subscribe(new a0(vodSubEvent));
    }

    public final Program M(String str, List list, int i10) {
        String contentId;
        String name;
        String value = RangerPlayTag.VOD.getValue();
        AssetData assetData = this.f15192c;
        String str2 = (assetData == null || (name = assetData.getName()) == null) ? "" : name;
        String valueOf = String.valueOf(i10);
        String c10 = PlayAty.G.c();
        Movie X = X();
        return new Program(str, value, str2, valueOf, c10, bd.f9986m, list, (X == null || (contentId = X.getContentId()) == null) ? "" : contentId, 0L);
    }

    public final void M0(VodSubEvent vodSubEvent) {
        w6.i.f19214g.b().X0(new int[]{vodSubEvent.getData().getSubscribeId()}).compose(this.f15190a.O1()).subscribe(new b0(vodSubEvent));
    }

    public final void N(HashMap hashMap) {
        f5.c cVar = this.f15190a;
        t9.i.e(cVar, "null cannot be cast to non-null type com.mobile.brasiltv.activity.PlayAty");
        if (hashMap.containsKey(((PlayAty) cVar).j3().c())) {
            return;
        }
        f5.c cVar2 = this.f15190a;
        t9.i.e(cVar2, "null cannot be cast to non-null type com.mobile.brasiltv.activity.PlayAty");
        if (t9.i.b(((PlayAty) cVar2).j3().c(), "480p")) {
            if (hashMap.containsKey("720p")) {
                f5.c cVar3 = this.f15190a;
                t9.i.e(cVar3, "null cannot be cast to non-null type com.mobile.brasiltv.activity.PlayAty");
                ((PlayAty) cVar3).A3(o6.c.b());
            } else if (hashMap.containsKey("1080p")) {
                f5.c cVar4 = this.f15190a;
                t9.i.e(cVar4, "null cannot be cast to non-null type com.mobile.brasiltv.activity.PlayAty");
                ((PlayAty) cVar4).A3(o6.c.a());
            }
        }
        f5.c cVar5 = this.f15190a;
        t9.i.e(cVar5, "null cannot be cast to non-null type com.mobile.brasiltv.activity.PlayAty");
        if (t9.i.b(((PlayAty) cVar5).j3().c(), "720p")) {
            if (hashMap.containsKey("480p")) {
                f5.c cVar6 = this.f15190a;
                t9.i.e(cVar6, "null cannot be cast to non-null type com.mobile.brasiltv.activity.PlayAty");
                ((PlayAty) cVar6).A3(o6.c.c());
            } else if (hashMap.containsKey("1080p")) {
                f5.c cVar7 = this.f15190a;
                t9.i.e(cVar7, "null cannot be cast to non-null type com.mobile.brasiltv.activity.PlayAty");
                ((PlayAty) cVar7).A3(o6.c.a());
            }
        }
        f5.c cVar8 = this.f15190a;
        t9.i.e(cVar8, "null cannot be cast to non-null type com.mobile.brasiltv.activity.PlayAty");
        if (t9.i.b(((PlayAty) cVar8).j3().c(), "1080p")) {
            if (hashMap.containsKey("720p")) {
                f5.c cVar9 = this.f15190a;
                t9.i.e(cVar9, "null cannot be cast to non-null type com.mobile.brasiltv.activity.PlayAty");
                ((PlayAty) cVar9).A3(o6.c.b());
            } else if (hashMap.containsKey("480p")) {
                f5.c cVar10 = this.f15190a;
                t9.i.e(cVar10, "null cannot be cast to non-null type com.mobile.brasiltv.activity.PlayAty");
                ((PlayAty) cVar10).A3(o6.c.c());
            }
        }
        MainAty.a aVar = MainAty.A;
        f5.c cVar11 = this.f15190a;
        t9.i.e(cVar11, "null cannot be cast to non-null type com.mobile.brasiltv.activity.PlayAty");
        aVar.n(((PlayAty) cVar11).j3().b());
    }

    public final void N0(HashMap hashMap) {
        Z().clear();
        Z().putAll(hashMap);
    }

    public void O() {
        Disposable disposable = this.f15193d;
        boolean z10 = false;
        if (disposable != null && !disposable.isDisposed()) {
            z10 = true;
        }
        if (z10) {
            Disposable disposable2 = this.f15193d;
            if (disposable2 != null) {
                disposable2.dispose();
            }
            this.f15193d = null;
        }
    }

    public final void O0(HashMap hashMap) {
        a0().clear();
        a0().putAll(hashMap);
    }

    public final void P(String str) {
        t9.i.g(str, "contentId");
        Observable compose = w6.i.f19214g.b().f1(str).compose(this.f15190a.O1());
        final a aVar = a.f15206a;
        Observable map = compose.map(new Function() { // from class: k6.v1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List Q;
                Q = g2.Q(s9.l.this, obj);
                return Q;
            }
        });
        final b bVar = b.f15210a;
        map.filter(new Predicate() { // from class: k6.w1
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean R;
                R = g2.R(s9.l.this, obj);
                return R;
            }
        }).subscribe(new c());
    }

    public final f5.c S() {
        return this.f15190a;
    }

    public final String T() {
        return t9.i.b(Locale.getDefault().getLanguage(), "zh") ? "zh" : XML.DEFAULT_CONTENT_LANGUAGE;
    }

    public AudioTrackBean U() {
        return this.f15205p;
    }

    public HashMap V() {
        return this.f15204o;
    }

    public final MobileDao W() {
        return (MobileDao) this.f15196g.getValue();
    }

    public Movie X() {
        return this.f15201l;
    }

    public List Y() {
        return this.f15203n;
    }

    public HashMap Z() {
        return this.f15200k;
    }

    @Override // i6.f0
    public void a(String str, String str2, int i10, String str3, String str4, boolean z10, boolean z11, boolean z12, String str5, int[] iArr, boolean z13) {
        t9.i.g(str, "programId");
        t9.i.g(str2, "contentId");
        t9.i.g(str3, "type");
        t9.i.g(str4, "vodQuality");
        this.f15197h = str2;
        x0(str, str2, i10, str3, str4, z10, z11, z12, str5, iArr, z13);
    }

    public HashMap a0() {
        return this.f15199j;
    }

    public AssetData b0() {
        return this.f15192c;
    }

    public final void c0(String str, String str2) {
        t9.i.g(str, "contentId");
        t9.i.g(str2, "type");
        Observable compose = w6.i.f19214g.b().O1(str, str2).compose(this.f15190a.O1());
        final d dVar = d.f15215a;
        Observable map = compose.map(new Function() { // from class: k6.f2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List d02;
                d02 = g2.d0(s9.l.this, obj);
                return d02;
            }
        });
        final e eVar = e.f15216a;
        map.filter(new Predicate() { // from class: k6.p1
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean e02;
                e02 = g2.e0(s9.l.this, obj);
                return e02;
            }
        }).subscribe(new f());
    }

    @Override // l5.a
    public void e() {
    }

    public final i6.g0 f0() {
        return this.f15191b;
    }

    @Override // l5.a
    public void g() {
    }

    public final void g0(List list, String str) {
        Disposable disposable = this.f15195f;
        if (disposable != null) {
            disposable.dispose();
        }
        if (list == null || list.isEmpty()) {
            this.f15191b.I0(new ArrayList());
            k7.f.f("no have sub", new Object[0]);
            return;
        }
        Observable compose = Observable.just(list).subscribeOn(Schedulers.io()).compose(this.f15190a.O1());
        final g gVar = new g(str);
        Observable map = compose.map(new Function() { // from class: k6.q1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                List h02;
                h02 = g2.h0(s9.l.this, obj);
                return h02;
            }
        });
        final h hVar = h.f15220a;
        Observable observeOn = map.filter(new Predicate() { // from class: k6.r1
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean i02;
                i02 = g2.i0(s9.l.this, obj);
                return i02;
            }
        }).observeOn(AndroidSchedulers.mainThread());
        final i iVar = new i(str);
        Consumer consumer = new Consumer() { // from class: k6.s1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                g2.j0(s9.l.this, obj);
            }
        };
        final j jVar = j.f15223a;
        this.f15195f = observeOn.subscribe(consumer, new Consumer() { // from class: k6.t1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                g2.k0(s9.l.this, obj);
            }
        });
    }

    public void l0(String str, VodFavEvent vodFavEvent, boolean z10) {
        t9.i.g(str, "type");
        t9.i.g(vodFavEvent, "event");
        String hasFavorite = vodFavEvent.getData().getHasFavorite();
        if (t9.i.b(hasFavorite, "1")) {
            w6.i.f19214g.b().o1(new int[]{vodFavEvent.getData().getFavoriteId()}).subscribe(new k(vodFavEvent));
        } else if (t9.i.b(hasFavorite, "0")) {
            w6.i.f19214g.b().b1(str, i9.i.b(vodFavEvent.getData().getContentId()), z10).subscribe(new l(vodFavEvent));
        }
    }

    public void m0(String str, VodSubEvent vodSubEvent) {
        t9.i.g(str, "type");
        t9.i.g(vodSubEvent, "event");
        String hasSubscribe = vodSubEvent.getData().getHasSubscribe();
        if (!t9.i.b(hasSubscribe, "0")) {
            if (t9.i.b(hasSubscribe, "1")) {
                M0(vodSubEvent);
            }
        } else if (q5.i.f18197a.j(this.f15190a)) {
            L0(str, vodSubEvent);
        } else {
            new MsgNotifyDialog(this.f15190a, 2).show();
        }
    }

    public final void n0() {
        this.f15191b.w2();
    }

    public void o0(String str, String str2, String str3, boolean z10) {
        t9.i.g(str, "contentId");
        t9.i.g(str2, "type");
        t9.i.g(str3, "programType");
        this.f15191b.G2();
        String T = T();
        com.mobile.brasiltv.utils.b0.U(this, "cur language environment: " + T);
        Observable y12 = w6.i.f19214g.b().y1(str, str2, "0", T);
        final m mVar = m.f15230a;
        y12.map(new Function() { // from class: k6.e2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                AssetData p02;
                p02 = g2.p0(s9.l.this, obj);
                return p02;
            }
        }).compose(this.f15190a.O1()).subscribe(new n());
    }

    public void q0(ProgramSeason programSeason, String str) {
        t9.i.g(programSeason, "programSeason");
        t9.i.g(str, "vodType");
        Observable y12 = w6.i.f19214g.b().y1(programSeason.getContentId(), str, "0", T());
        final o oVar = o.f15233a;
        y12.map(new Function() { // from class: k6.a2
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                GetItemDataResult r02;
                r02 = g2.r0(s9.l.this, obj);
                return r02;
            }
        }).compose(this.f15190a.O1()).subscribe(new p());
    }

    public final void s0(final HashMap hashMap, final String str, final String str2, final int i10, List list) {
        t9.i.g(hashMap, "map");
        t9.i.g(str, "contentId");
        t9.i.g(str2, "seriesContentId");
        r5.i iVar = r5.i.f18523a;
        final List x10 = iVar.x(r5.k.VOD);
        if (x10 == null || x10.isEmpty()) {
            if (!iVar.I()) {
                J0(hashMap, str, str2, i10, list);
                return;
            } else {
                com.mobile.brasiltv.utils.b0.U(this, "slb获取失败....");
                this.f15191b.d2();
                return;
            }
        }
        final t9.w wVar = new t9.w();
        V().clear();
        Disposable disposable = this.f15194e;
        if (disposable != null) {
            disposable.dispose();
        }
        Observable compose = Observable.create(new ObservableOnSubscribe() { // from class: k6.b2
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                g2.u0(hashMap, this, str2, str, wVar, i10, x10, observableEmitter);
            }
        }).compose(this.f15190a.O1()).compose(com.mobile.brasiltv.utils.p0.a());
        final r rVar = new r(wVar, this, str, list);
        Consumer consumer = new Consumer() { // from class: k6.c2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                g2.v0(s9.l.this, obj);
            }
        };
        final s sVar = s.f15241a;
        this.f15194e = compose.subscribe(consumer, new Consumer() { // from class: k6.d2
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                g2.w0(s9.l.this, obj);
            }
        });
    }

    public final void x0(String str, String str2, int i10, String str3, String str4, boolean z10, boolean z11, boolean z12, String str5, int[] iArr, boolean z13) {
        y0(str, str2, i10, str3, str4, z10, z11, z12, str5, iArr, z13);
    }

    public final void y0(String str, String str2, int i10, String str3, String str4, boolean z10, boolean z11, boolean z12, String str5, int[] iArr, boolean z13) {
        Integer valueOf;
        String str6;
        StringBuilder sb = new StringBuilder();
        sb.append("点播鉴权成功 = ");
        sb.append(z10);
        sb.append(" and isFree: ");
        sb.append(z11);
        sb.append(" and userIdentity = ");
        i.c cVar = w6.i.f19214g;
        sb.append(cVar.I());
        com.mobile.brasiltv.utils.b0.U(this, sb.toString());
        com.mobile.brasiltv.utils.b0.U(this, "auth program: contentId: " + str2 + " parentColumnId: " + i10 + " type: " + str3 + " vodQuality: " + str4);
        if (z12) {
            com.mobile.brasiltv.utils.h hVar = com.mobile.brasiltv.utils.h.f8694a;
            if (!hVar.h().isEmpty()) {
                H0(hVar.g());
                this.f15191b.u1(z13);
                O0(hVar.h());
                this.f15191b.D1();
                return;
            }
        }
        if (i10 == -1) {
            str6 = "1";
            valueOf = null;
        } else {
            valueOf = Integer.valueOf(i10);
            str6 = "0";
        }
        String str7 = t9.i.b(str3, "0") ? str : "";
        t9.w wVar = new t9.w();
        wVar.f18961a = "";
        t9.u uVar = new t9.u();
        uVar.f18959a = -1;
        t9.w wVar2 = new t9.w();
        Observable compose = cVar.b().m2(str6, valueOf, str2, str7, str5, iArr).compose(this.f15190a.O1());
        final t tVar = new t();
        Observable filter = compose.filter(new Predicate() { // from class: k6.o1
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean z02;
                z02 = g2.z0(s9.l.this, obj);
                return z02;
            }
        });
        final u uVar2 = new u(wVar2, wVar, uVar, this);
        Observable map = filter.map(new Function() { // from class: k6.x1
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                HashMap A0;
                A0 = g2.A0(s9.l.this, obj);
                return A0;
            }
        });
        final v vVar = new v();
        Observable filter2 = map.filter(new Predicate() { // from class: k6.y1
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean B0;
                B0 = g2.B0(s9.l.this, obj);
                return B0;
            }
        });
        final w wVar3 = new w(str2, this);
        filter2.filter(new Predicate() { // from class: k6.z1
            @Override // io.reactivex.functions.Predicate
            public final boolean test(Object obj) {
                boolean C0;
                C0 = g2.C0(s9.l.this, obj);
                return C0;
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribe(new x(z13, wVar, str7, uVar, wVar2));
    }
}
