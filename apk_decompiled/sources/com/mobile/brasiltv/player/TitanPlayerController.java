package com.mobile.brasiltv.player;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.Settings;
import android.text.Html;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.LruCache;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import b8.a;
import com.advertlib.bean.AdInfo;
import com.advertlib.bean.AdInfoWrapper;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.android.gms.common.images.WebImage;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;
import com.hpplay.cybergarage.xml.XML;
import com.hpplay.sdk.source.common.global.Constant;
import com.mobile.brasiltv.R$id;
import com.mobile.brasiltv.activity.CastByNativeDeviceAty;
import com.mobile.brasiltv.activity.PlayAty;
import com.mobile.brasiltv.bean.AudioTrackBean;
import com.mobile.brasiltv.bean.BaseGuideManager;
import com.mobile.brasiltv.bean.EnterType;
import com.mobile.brasiltv.bean.GuideNextClickListener;
import com.mobile.brasiltv.bean.NoSubTitleData;
import com.mobile.brasiltv.bean.OffSubTitleData;
import com.mobile.brasiltv.bean.RecordSubtitleInfoBean;
import com.mobile.brasiltv.bean.RootColumnId;
import com.mobile.brasiltv.bean.SubTitleData;
import com.mobile.brasiltv.bean.SubtitleManager;
import com.mobile.brasiltv.bean.SubtitleStyleBean;
import com.mobile.brasiltv.bean.VodGestureGuideManager;
import com.mobile.brasiltv.bean.event.CastPlaySuccessEvent;
import com.mobile.brasiltv.bean.event.CastToCloseFloatViewEvent;
import com.mobile.brasiltv.bean.event.CastToCloseOtherPlayEvent;
import com.mobile.brasiltv.bean.event.CastToPlayEvent;
import com.mobile.brasiltv.bean.event.GoogleCastToPlayEvent;
import com.mobile.brasiltv.bean.event.NetworkEvent;
import com.mobile.brasiltv.bean.event.PlaySetIndexEvent;
import com.mobile.brasiltv.bean.event.ShowVodSharingGuideEvent;
import com.mobile.brasiltv.bean.event.SubTitleDownloadFinishEvent;
import com.mobile.brasiltv.bean.event.UpdateRecordAtyEvent;
import com.mobile.brasiltv.db.AudioSettingBean;
import com.mobile.brasiltv.db.Links;
import com.mobile.brasiltv.db.MobileDao;
import com.mobile.brasiltv.db.SubtitleSettingBean;
import com.mobile.brasiltv.db.VodDao;
import com.mobile.brasiltv.mine.activity.AccountBindAty;
import com.mobile.brasiltv.player.TitanPlayerController;
import com.mobile.brasiltv.utils.f1;
import com.mobile.brasiltv.utils.g;
import com.mobile.brasiltv.utils.i1;
import com.mobile.brasiltv.view.AlphaRelativeLayout;
import com.mobile.brasiltv.view.CurTimeSeekBar;
import com.mobile.brasiltv.view.GridDecoration;
import com.mobile.brasiltv.view.GridLayoutManagerWrapper;
import com.mobile.brasiltv.view.RatioFrameLayout;
import com.mobile.brasiltv.view.adView.BeforeVodAdView;
import com.mobile.brasiltv.view.adView.PauseAdView;
import com.mobile.brasiltv.view.dialog.CommonDialog;
import com.mobile.brasiltv.view.dialog.GuideDialog;
import com.mobile.brasiltv.view.dialog.feedback.CastFeedBackDialog;
import com.mobile.brasiltv.view.dialog.feedback.FeedBackDialog;
import com.msandroid.mobile.R;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.titan.cast.bean.Device;
import com.titan.ranger.Status;
import com.titan.ranger.bean.Media;
import com.titan.ranger.bean.Program;
import com.titans.widget.TitanVODView;
import com.umeng.analytics.pro.q;
import com.zhy.autolayout.AutoFrameLayout;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;
import com.zhy.autolayout.utils.AutoUtils;
import g7.n;
import g7.p;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import mobile.com.requestframe.utils.response.AssetData;
import mobile.com.requestframe.utils.response.Movie;
import mobile.com.requestframe.utils.response.PosterList;
import mobile.com.requestframe.utils.response.SimpleProgramList;
import mobile.com.requestframe.utils.response.TotalMovieList;
import org.greenrobot.eventbus.ThreadMode;
import tv.danmaku.ijk.media.player.misc.IjkMediaFormat;
import w6.i;
import z5.c;

/* loaded from: classes.dex */
public final class TitanPlayerController extends RatioFrameLayout implements g.b, c.e, c.d, p8.a, o8.a {
    public PauseAdView A;
    public CommonDialog A0;
    public String B;
    public Disposable B0;
    public long C;
    public Disposable C0;
    public boolean D;
    public boolean D0;
    public boolean E;
    public Program E0;
    public boolean F;
    public boolean F0;
    public boolean G;
    public String G0;
    public boolean H;
    public Integer H0;
    public boolean I;
    public boolean I0;
    public long J;
    public boolean J0;
    public boolean K;
    public final h9.g K0;
    public b L;
    public int L0;
    public m6.a M;
    public Float M0;
    public z5.c N;
    public Map N0;
    public String O;
    public Disposable Q;
    public boolean S;
    public boolean V;
    public boolean W;

    /* renamed from: a, reason: collision with root package name */
    public final TitanPlayerController f8453a;

    /* renamed from: b, reason: collision with root package name */
    public final h9.g f8454b;

    /* renamed from: c, reason: collision with root package name */
    public q5.j f8455c;

    /* renamed from: d, reason: collision with root package name */
    public b8.b f8456d;

    /* renamed from: e, reason: collision with root package name */
    public VodDao f8457e;

    /* renamed from: f, reason: collision with root package name */
    public AssetData f8458f;

    /* renamed from: f0, reason: collision with root package name */
    public boolean f8459f0;

    /* renamed from: g, reason: collision with root package name */
    public HashMap f8460g;

    /* renamed from: g0, reason: collision with root package name */
    public boolean f8461g0;

    /* renamed from: h, reason: collision with root package name */
    public Movie f8462h;

    /* renamed from: h0, reason: collision with root package name */
    public boolean f8463h0;

    /* renamed from: i, reason: collision with root package name */
    public SimpleProgramList f8464i;

    /* renamed from: i0, reason: collision with root package name */
    public long f8465i0;

    /* renamed from: j, reason: collision with root package name */
    public EnterType f8466j;

    /* renamed from: j0, reason: collision with root package name */
    public int f8467j0;

    /* renamed from: k, reason: collision with root package name */
    public String f8468k;

    /* renamed from: k0, reason: collision with root package name */
    public int f8469k0;

    /* renamed from: l, reason: collision with root package name */
    public boolean f8470l;

    /* renamed from: l0, reason: collision with root package name */
    public int f8471l0;

    /* renamed from: m, reason: collision with root package name */
    public boolean f8472m;

    /* renamed from: m0, reason: collision with root package name */
    public boolean f8473m0;

    /* renamed from: n, reason: collision with root package name */
    public int f8474n;

    /* renamed from: n0, reason: collision with root package name */
    public int f8475n0;

    /* renamed from: o, reason: collision with root package name */
    public int f8476o;

    /* renamed from: o0, reason: collision with root package name */
    public String f8477o0;

    /* renamed from: p, reason: collision with root package name */
    public String f8478p;

    /* renamed from: p0, reason: collision with root package name */
    public boolean f8479p0;

    /* renamed from: q, reason: collision with root package name */
    public String f8480q;

    /* renamed from: q0, reason: collision with root package name */
    public String f8481q0;

    /* renamed from: r, reason: collision with root package name */
    public boolean f8482r;

    /* renamed from: r0, reason: collision with root package name */
    public final h9.g f8483r0;

    /* renamed from: s, reason: collision with root package name */
    public List f8484s;

    /* renamed from: s0, reason: collision with root package name */
    public final h9.g f8485s0;

    /* renamed from: t, reason: collision with root package name */
    public boolean f8486t;

    /* renamed from: t0, reason: collision with root package name */
    public AudioTrackBean f8487t0;

    /* renamed from: u, reason: collision with root package name */
    public final h9.g f8488u;

    /* renamed from: u0, reason: collision with root package name */
    public boolean f8489u0;

    /* renamed from: v, reason: collision with root package name */
    public final h9.g f8490v;

    /* renamed from: v0, reason: collision with root package name */
    public long f8491v0;

    /* renamed from: w, reason: collision with root package name */
    public final h9.g f8492w;

    /* renamed from: w0, reason: collision with root package name */
    public int f8493w0;

    /* renamed from: x, reason: collision with root package name */
    public boolean f8494x;

    /* renamed from: x0, reason: collision with root package name */
    public final NoSubTitleData f8495x0;

    /* renamed from: y, reason: collision with root package name */
    public boolean f8496y;

    /* renamed from: y0, reason: collision with root package name */
    public final OffSubTitleData f8497y0;

    /* renamed from: z, reason: collision with root package name */
    public Links f8498z;

    /* renamed from: z0, reason: collision with root package name */
    public final AudioTrackBean f8499z0;

    /* loaded from: classes3.dex */
    public static final class a extends b8.b {
        public a(f5.c cVar) {
            super(cVar);
        }

        @Override // b8.b
        public void f(int i10) {
            if (TitanPlayerController.this._$_findCachedViewById(R$id.mLlVolumeController).getVisibility() == 0) {
                ProgressBar progressBar = (ProgressBar) TitanPlayerController.this._$_findCachedViewById(R$id.mPbVolume);
                int i11 = i10 * 100;
                b8.b bVar = TitanPlayerController.this.f8456d;
                if (bVar == null) {
                    t9.i.w("mVoiceHelper");
                    bVar = null;
                }
                progressBar.setProgress(i11 / bVar.e());
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class a0 extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f8501a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f8502b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ArrayList f8503c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ TitanPlayerController f8504d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a0(List list, ArrayList arrayList, ArrayList arrayList2, TitanPlayerController titanPlayerController) {
            super(1);
            this.f8501a = list;
            this.f8502b = arrayList;
            this.f8503c = arrayList2;
            this.f8504d = titanPlayerController;
        }

        public final void b(SubtitleSettingBean subtitleSettingBean) {
            if (subtitleSettingBean.getSubtitleLanguage().length() > 0) {
                List list = this.f8501a;
                ArrayList arrayList = this.f8503c;
                ArrayList arrayList2 = this.f8502b;
                TitanPlayerController titanPlayerController = this.f8504d;
                int i10 = 0;
                for (Object obj : list) {
                    int i11 = i10 + 1;
                    if (i10 < 0) {
                        i9.j.j();
                    }
                    if (t9.i.b(((SubTitleData) obj).getLanguage(), subtitleSettingBean.getSubtitleLanguage())) {
                        arrayList.add(Integer.valueOf(i10));
                        if (subtitleSettingBean.getSubtitleIndex() == i10) {
                            arrayList2.add(Integer.valueOf(i10));
                            titanPlayerController.f8467j0 = i10;
                        }
                    }
                    i10 = i11;
                }
                if (this.f8502b.isEmpty()) {
                    if (com.mobile.brasiltv.utils.b0.I(this.f8503c)) {
                        TitanPlayerController titanPlayerController2 = this.f8504d;
                        Object obj2 = this.f8503c.get(0);
                        t9.i.f(obj2, "sameLanguage[0]");
                        titanPlayerController2.f8467j0 = ((Number) obj2).intValue();
                    } else {
                        this.f8504d.f8467j0 = 0;
                    }
                }
            } else {
                int mGlobalLanguage = SubtitleManager.INSTANCE.getMGlobalLanguage();
                String str = "pt";
                if (mGlobalLanguage != 0) {
                    if (mGlobalLanguage == 1) {
                        str = XML.DEFAULT_CONTENT_LANGUAGE;
                    } else if (mGlobalLanguage == 2) {
                        str = "es";
                    }
                }
                List list2 = this.f8501a;
                TitanPlayerController titanPlayerController3 = this.f8504d;
                int i12 = 0;
                for (Object obj3 : list2) {
                    int i13 = i12 + 1;
                    if (i12 < 0) {
                        i9.j.j();
                    }
                    if (t9.i.b(((SubTitleData) obj3).getLanguage(), str)) {
                        titanPlayerController3.f8467j0 = i12;
                    }
                    i12 = i13;
                }
            }
            if (this.f8504d.f8467j0 == -1) {
                this.f8504d.f8467j0 = 0;
            }
            SubtitleManager subtitleManager = SubtitleManager.INSTANCE;
            String mDetailDataContentId = this.f8504d.getMDetailDataContentId();
            if (mDetailDataContentId == null) {
                mDetailDataContentId = "";
            }
            subtitleManager.putSelectSubtitle(mDetailDataContentId, this.f8504d.f8467j0, subtitleSettingBean.getSubtitleLanguage());
            LruCache<String, Boolean> mLruCacheSwitch = subtitleManager.getMLruCacheSwitch();
            String mDetailDataContentId2 = this.f8504d.getMDetailDataContentId();
            mLruCacheSwitch.put(mDetailDataContentId2 != null ? mDetailDataContentId2 : "", Boolean.valueOf(!TextUtils.isEmpty(subtitleSettingBean.getSubtitleLanguage())));
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((SubtitleSettingBean) obj);
            return h9.t.f14242a;
        }
    }

    /* loaded from: classes3.dex */
    public enum b {
        NONE,
        VOLUME,
        BRIGHTNESS,
        FF_REW
    }

    /* loaded from: classes3.dex */
    public static final class b0 extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final b0 f8510a = new b0();

        public b0() {
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

    /* loaded from: classes3.dex */
    public /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f8511a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f8512b;

        static {
            int[] iArr = new int[b.values().length];
            try {
                iArr[b.VOLUME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[b.BRIGHTNESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[b.FF_REW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[b.NONE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f8511a = iArr;
            int[] iArr2 = new int[EnterType.values().length];
            try {
                iArr2[EnterType.HOME.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[EnterType.CATEGORY.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[EnterType.RECOMMEND.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[EnterType.BANNER.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[EnterType.TOPIC.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[EnterType.HISTORY.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[EnterType.SEARCH.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            f8512b = iArr2;
        }
    }

    /* loaded from: classes3.dex */
    public static final class c0 extends t9.j implements s9.l {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f8514b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ArrayList f8515c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ArrayList f8516d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c0(List list, ArrayList arrayList, ArrayList arrayList2) {
            super(1);
            this.f8514b = list;
            this.f8515c = arrayList;
            this.f8516d = arrayList2;
        }

        public final void b(SubtitleSettingBean subtitleSettingBean) {
            String str;
            if (subtitleSettingBean.getSubtitleSwitch().length() > 0) {
                TitanPlayerController.this.f8473m0 = subtitleSettingBean.getSubtitleSwitch().equals("true");
            } else {
                TitanPlayerController.this.f8473m0 = SubtitleManager.INSTANCE.getMGlobalSwitch();
            }
            SubtitleManager subtitleManager = SubtitleManager.INSTANCE;
            LruCache<String, Boolean> mLruCacheSwitch = subtitleManager.getMLruCacheSwitch();
            String mDetailDataContentId = TitanPlayerController.this.getMDetailDataContentId();
            if (mDetailDataContentId == null) {
                mDetailDataContentId = "";
            }
            mLruCacheSwitch.put(mDetailDataContentId, Boolean.valueOf(TitanPlayerController.this.f8473m0));
            if (TitanPlayerController.this.f8473m0) {
                HashMap<String, RecordSubtitleInfoBean> mLruCacheLanguages = subtitleManager.getMLruCacheLanguages();
                AssetData data = TitanPlayerController.this.getData();
                if (data == null || (str = data.getContentId()) == null) {
                    str = "";
                }
                RecordSubtitleInfoBean recordSubtitleInfoBean = mLruCacheLanguages.get(str);
                Integer valueOf = recordSubtitleInfoBean != null ? Integer.valueOf(recordSubtitleInfoBean.getSubtitleIndex()) : null;
                if (valueOf == null || valueOf.intValue() >= this.f8514b.size()) {
                    if (subtitleSettingBean.getSubtitleLanguage().length() > 0) {
                        List list = this.f8514b;
                        ArrayList arrayList = this.f8516d;
                        ArrayList arrayList2 = this.f8515c;
                        TitanPlayerController titanPlayerController = TitanPlayerController.this;
                        int i10 = 0;
                        for (Object obj : list) {
                            int i11 = i10 + 1;
                            if (i10 < 0) {
                                i9.j.j();
                            }
                            if (t9.i.b(((SubTitleData) obj).getLanguage(), subtitleSettingBean.getSubtitleLanguage())) {
                                arrayList.add(Integer.valueOf(i10));
                                if (subtitleSettingBean.getSubtitleIndex() == i10) {
                                    arrayList2.add(Integer.valueOf(i10));
                                    titanPlayerController.f8467j0 = i10;
                                }
                            }
                            i10 = i11;
                        }
                        if (this.f8515c.isEmpty()) {
                            if (com.mobile.brasiltv.utils.b0.I(this.f8516d)) {
                                TitanPlayerController titanPlayerController2 = TitanPlayerController.this;
                                Object obj2 = this.f8516d.get(0);
                                t9.i.f(obj2, "sameLanguage[0]");
                                titanPlayerController2.f8467j0 = ((Number) obj2).intValue();
                            } else {
                                TitanPlayerController.this.f8467j0 = 0;
                            }
                        }
                    } else {
                        int mGlobalLanguage = subtitleManager.getMGlobalLanguage();
                        String str2 = "pt";
                        if (mGlobalLanguage != 0) {
                            if (mGlobalLanguage == 1) {
                                str2 = XML.DEFAULT_CONTENT_LANGUAGE;
                            } else if (mGlobalLanguage == 2) {
                                str2 = "es";
                            }
                        }
                        List list2 = this.f8514b;
                        TitanPlayerController titanPlayerController3 = TitanPlayerController.this;
                        int i12 = 0;
                        for (Object obj3 : list2) {
                            int i13 = i12 + 1;
                            if (i12 < 0) {
                                i9.j.j();
                            }
                            if (t9.i.b(((SubTitleData) obj3).getLanguage(), str2)) {
                                titanPlayerController3.f8467j0 = i12;
                            }
                            i12 = i13;
                        }
                    }
                    if (TitanPlayerController.this.f8467j0 == -1) {
                        TitanPlayerController.this.f8467j0 = 0;
                    }
                } else {
                    TitanPlayerController.this.f8467j0 = valueOf.intValue();
                }
            }
            SubtitleManager subtitleManager2 = SubtitleManager.INSTANCE;
            String mDetailDataContentId2 = TitanPlayerController.this.getMDetailDataContentId();
            subtitleManager2.putSelectSubtitle(mDetailDataContentId2 != null ? mDetailDataContentId2 : "", TitanPlayerController.this.f8467j0, subtitleSettingBean.getSubtitleLanguage());
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((SubtitleSettingBean) obj);
            return h9.t.f14242a;
        }
    }

    /* loaded from: classes3.dex */
    public static final class d extends t9.j implements s9.l {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f8518b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f8519c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Context context, long j10) {
            super(1);
            this.f8518b = context;
            this.f8519c = j10;
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return h9.t.f14242a;
        }

        public final void invoke(String str) {
            TitanPlayerController.this.G0 = p6.a.f18068a.a(this.f8518b, (int) this.f8519c);
        }
    }

    /* loaded from: classes3.dex */
    public static final class d0 extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final d0 f8520a = new d0();

        public d0() {
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

    /* loaded from: classes3.dex */
    public static final class e extends t9.j implements s9.l {
        public e() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Long) obj);
            return h9.t.f14242a;
        }

        public final void invoke(Long l10) {
            ((AutoFrameLayout) TitanPlayerController.this._$_findCachedViewById(R$id.mLayoutSetInfo)).setVisibility(8);
        }
    }

    /* loaded from: classes3.dex */
    public static final class e0 extends t9.j implements s9.l {
        public e0() {
            super(1);
        }

        public final void b(SubtitleSettingBean subtitleSettingBean) {
            if (subtitleSettingBean.getSubtitleSize() != -1) {
                TitanPlayerController.this.f8469k0 = subtitleSettingBean.getSubtitleSize();
            } else {
                TitanPlayerController.this.f8469k0 = SubtitleManager.INSTANCE.getMGlobalSize();
            }
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((SubtitleSettingBean) obj);
            return h9.t.f14242a;
        }
    }

    /* loaded from: classes3.dex */
    public static final class f extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final f f8523a = new f();

        public f() {
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

    /* loaded from: classes3.dex */
    public static final class f0 extends GestureDetector.SimpleOnGestureListener {
        public f0() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            t9.i.g(motionEvent, "e");
            if (!TitanPlayerController.this.getMOrientationHelper().n()) {
                ((ImageView) TitanPlayerController.this._$_findCachedViewById(R$id.mImagePlay)).performClick();
            }
            return super.onDoubleTap(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            t9.i.g(motionEvent, "e");
            TitanPlayerController.this.L = b.NONE;
            TitanPlayerController.this.M0 = Float.valueOf(motionEvent.getRawY());
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
            t9.i.g(motionEvent2, "e2");
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            t9.i.g(motionEvent, "e");
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
            t9.i.g(motionEvent2, "e2");
            if (TitanPlayerController.this.getMOrientationHelper().m() || TitanPlayerController.this.getMOrientationHelper().n()) {
                return false;
            }
            return TitanPlayerController.this.v2(motionEvent, motionEvent2, f10, f11);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
            t9.i.g(motionEvent, "e");
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            t9.i.g(motionEvent, "e");
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public static final class g extends t9.j implements s9.a {

        /* renamed from: a, reason: collision with root package name */
        public static final g f8525a = new g();

        public g() {
            super(0);
        }

        /* renamed from: invoke, reason: collision with other method in class */
        public final void m60invoke() {
        }

        @Override // s9.a
        public /* bridge */ /* synthetic */ Object invoke() {
            m60invoke();
            return h9.t.f14242a;
        }
    }

    /* loaded from: classes3.dex */
    public static final class g0 extends t9.j implements s9.a {

        /* renamed from: a, reason: collision with root package name */
        public static final g0 f8526a = new g0();

        public g0() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final n6.e invoke() {
            return new n6.e();
        }
    }

    /* loaded from: classes3.dex */
    public static final class h extends t9.j implements s9.a {

        /* renamed from: a, reason: collision with root package name */
        public static final h f8527a = new h();

        public h() {
            super(0);
        }

        /* renamed from: invoke, reason: collision with other method in class */
        public final void m61invoke() {
        }

        @Override // s9.a
        public /* bridge */ /* synthetic */ Object invoke() {
            m61invoke();
            return h9.t.f14242a;
        }
    }

    /* loaded from: classes3.dex */
    public static final class h0 extends t9.j implements s9.p {
        public h0() {
            super(2);
        }

        public final void b(int i10, int i11) {
            if (i10 == 0 || i11 == 0) {
                TitanPlayerController titanPlayerController = TitanPlayerController.this;
                int i12 = R$id.mPlayPauseIcon;
                ViewGroup.LayoutParams layoutParams = ((ImageView) titanPlayerController._$_findCachedViewById(i12)).getLayoutParams();
                t9.i.e(layoutParams, "null cannot be cast to non-null type com.zhy.autolayout.AutoFrameLayout.LayoutParams");
                AutoFrameLayout.LayoutParams layoutParams2 = (AutoFrameLayout.LayoutParams) layoutParams;
                ((FrameLayout.LayoutParams) layoutParams2).leftMargin = 0;
                ((FrameLayout.LayoutParams) layoutParams2).topMargin = 0;
                ((ImageView) TitanPlayerController.this._$_findCachedViewById(i12)).setLayoutParams(layoutParams2);
                TitanPlayerController.this.D4(true);
                return;
            }
            TitanPlayerController titanPlayerController2 = TitanPlayerController.this;
            int i13 = R$id.mPlayPauseIcon;
            ((ImageView) titanPlayerController2._$_findCachedViewById(i13)).setVisibility(0);
            TitanPlayerController.this.D4(false);
            ViewGroup.LayoutParams layoutParams3 = ((ImageView) TitanPlayerController.this._$_findCachedViewById(i13)).getLayoutParams();
            t9.i.e(layoutParams3, "null cannot be cast to non-null type com.zhy.autolayout.AutoFrameLayout.LayoutParams");
            AutoFrameLayout.LayoutParams layoutParams4 = (AutoFrameLayout.LayoutParams) layoutParams3;
            ((FrameLayout.LayoutParams) layoutParams4).leftMargin = (i10 / 2) + AutoUtils.getPercentWidthSize(70);
            ((FrameLayout.LayoutParams) layoutParams4).topMargin = (i11 / 2) - AutoUtils.getPercentWidthSize(60);
            ((ImageView) TitanPlayerController.this._$_findCachedViewById(i13)).setLayoutParams(layoutParams4);
        }

        @Override // s9.p
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            b(((Number) obj).intValue(), ((Number) obj2).intValue());
            return h9.t.f14242a;
        }
    }

    /* loaded from: classes3.dex */
    public static final class i extends t9.j implements s9.l {
        public i() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Long) obj);
            return h9.t.f14242a;
        }

        public final void invoke(Long l10) {
            if (!na.e.f17341a) {
                ((AlphaRelativeLayout) TitanPlayerController.this._$_findCachedViewById(R$id.mLayoutController)).setVisibility(4);
            }
            ((ImageView) TitanPlayerController.this._$_findCachedViewById(R$id.mImageBack)).setVisibility(0);
        }
    }

    /* loaded from: classes3.dex */
    public static final class i0 extends t9.j implements s9.a {
        public i0() {
            super(0);
        }

        @Override // s9.a
        public /* bridge */ /* synthetic */ Object invoke() {
            m62invoke();
            return h9.t.f14242a;
        }

        /* renamed from: invoke, reason: collision with other method in class */
        public final void m62invoke() {
            TitanPlayerController titanPlayerController = TitanPlayerController.this;
            int i10 = R$id.mPlayPauseIcon;
            ViewGroup.LayoutParams layoutParams = ((ImageView) titanPlayerController._$_findCachedViewById(i10)).getLayoutParams();
            t9.i.e(layoutParams, "null cannot be cast to non-null type com.zhy.autolayout.AutoFrameLayout.LayoutParams");
            AutoFrameLayout.LayoutParams layoutParams2 = (AutoFrameLayout.LayoutParams) layoutParams;
            ((FrameLayout.LayoutParams) layoutParams2).leftMargin = 0;
            ((FrameLayout.LayoutParams) layoutParams2).topMargin = 0;
            ((ImageView) TitanPlayerController.this._$_findCachedViewById(i10)).setLayoutParams(layoutParams2);
            TitanPlayerController.this.D4(true);
        }
    }

    /* loaded from: classes3.dex */
    public static final class j extends t9.j implements s9.l {
        public j() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Long) obj);
            return h9.t.f14242a;
        }

        public final void invoke(Long l10) {
            ((AutoFrameLayout) TitanPlayerController.this._$_findCachedViewById(R$id.mFlLocked)).setVisibility(8);
        }
    }

    /* loaded from: classes3.dex */
    public static final class j0 extends t9.j implements s9.l {
        public j0() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((String) obj);
            return h9.t.f14242a;
        }

        public final void invoke(String str) {
            if (TitanPlayerController.this.S) {
                ((AutoLinearLayout) TitanPlayerController.this._$_findCachedViewById(R$id.mLayoutStage)).setVisibility(8);
                ((ImageView) TitanPlayerController.this._$_findCachedViewById(R$id.mIvStage)).setVisibility(8);
                return;
            }
            a7.e eVar = a7.e.f288a;
            Context context = TitanPlayerController.this.getContext();
            t9.i.f(context, com.umeng.analytics.pro.f.X);
            TitanPlayerController titanPlayerController = TitanPlayerController.this;
            int i10 = R$id.mIvStage;
            ImageView imageView = (ImageView) titanPlayerController._$_findCachedViewById(i10);
            t9.i.f(imageView, "mIvStage");
            eVar.b(context, str, imageView, R.drawable.bg_vod_default_stage);
            ((AutoLinearLayout) TitanPlayerController.this._$_findCachedViewById(R$id.mLayoutStage)).setVisibility(0);
            ((ImageView) TitanPlayerController.this._$_findCachedViewById(i10)).setVisibility(0);
        }
    }

    /* loaded from: classes3.dex */
    public static final class k extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final k f8533a = new k();

        public k() {
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

    /* loaded from: classes3.dex */
    public static final class k0 extends t9.j implements s9.l {
        public k0() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return h9.t.f14242a;
        }

        public final void invoke(Throwable th) {
            if (TitanPlayerController.this.S) {
                AutoLinearLayout autoLinearLayout = (AutoLinearLayout) TitanPlayerController.this._$_findCachedViewById(R$id.mLayoutStage);
                if (autoLinearLayout != null) {
                    autoLinearLayout.setVisibility(8);
                }
                ImageView imageView = (ImageView) TitanPlayerController.this._$_findCachedViewById(R$id.mIvStage);
                if (imageView == null) {
                    return;
                }
                imageView.setVisibility(8);
                return;
            }
            TitanPlayerController titanPlayerController = TitanPlayerController.this;
            int i10 = R$id.mIvStage;
            ImageView imageView2 = (ImageView) titanPlayerController._$_findCachedViewById(i10);
            if (imageView2 != null) {
                imageView2.setImageResource(R.drawable.bg_vod_default_stage);
            }
            AutoLinearLayout autoLinearLayout2 = (AutoLinearLayout) TitanPlayerController.this._$_findCachedViewById(R$id.mLayoutStage);
            if (autoLinearLayout2 != null) {
                autoLinearLayout2.setVisibility(0);
            }
            ImageView imageView3 = (ImageView) TitanPlayerController.this._$_findCachedViewById(i10);
            if (imageView3 == null) {
                return;
            }
            imageView3.setVisibility(0);
        }
    }

    /* loaded from: classes3.dex */
    public static final class l extends t9.j implements s9.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f8535a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(Context context) {
            super(0);
            this.f8535a = context;
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final f5.c invoke() {
            Context context = this.f8535a;
            t9.i.e(context, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
            return (f5.c) context;
        }
    }

    /* loaded from: classes3.dex */
    public static final class l0 implements v1.f {
        public l0() {
        }

        @Override // v1.f
        public void a(AdInfoWrapper adInfoWrapper) {
            com.mobile.brasiltv.utils.b0.U(this, "load before ad result and ad is " + adInfoWrapper);
            TitanPlayerController.this.f8463h0 = true;
            if ((adInfoWrapper != null ? adInfoWrapper.getAdInfo() : null) == null) {
                if (!TitanPlayerController.this.W) {
                    ((ImageView) TitanPlayerController.this._$_findCachedViewById(R$id.mPlayPauseIcon)).setVisibility(8);
                    TitanPlayerController.this.D4(false);
                    ((RelativeLayout) TitanPlayerController.this._$_findCachedViewById(R$id.mBufferView)).setVisibility(0);
                    return;
                } else {
                    TitanPlayerController.this.X2();
                    if (TitanPlayerController.this.D) {
                        ((TitanVODView) TitanPlayerController.this._$_findCachedViewById(R$id.mVideoViewVod)).x(0L);
                        return;
                    } else {
                        ((TitanVODView) TitanPlayerController.this._$_findCachedViewById(R$id.mVideoViewVod)).w();
                        return;
                    }
                }
            }
            TitanPlayerController.this.f8459f0 = false;
            BeforeVodAdView beforeVodAdView = (BeforeVodAdView) TitanPlayerController.this._$_findCachedViewById(R$id.mBvavAd);
            a6.a aVar = a6.a.f228a;
            beforeVodAdView.showBeforeVodAd(adInfoWrapper, aVar.n());
            s1.m mVar = s1.m.f18686a;
            Context context = TitanPlayerController.this.getContext();
            t9.i.f(context, com.umeng.analytics.pro.f.X);
            String n10 = aVar.n();
            AdInfo adInfo = adInfoWrapper.getAdInfo();
            t9.i.d(adInfo);
            mVar.d0(context, n10, adInfo.getAd_id());
        }
    }

    /* loaded from: classes3.dex */
    public static final class m extends t9.j implements s9.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f8537a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(Context context) {
            super(0);
            this.f8537a = context;
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final MobileDao invoke() {
            Context applicationContext = this.f8537a.getApplicationContext();
            t9.i.f(applicationContext, "context.applicationContext");
            return new MobileDao(applicationContext);
        }
    }

    /* loaded from: classes3.dex */
    public static final class m0 implements AlphaRelativeLayout.OnVisibility {
        public m0() {
        }

        @Override // com.mobile.brasiltv.view.AlphaRelativeLayout.OnVisibility
        public void onVisible(int i10) {
            if (i10 == 0) {
                TitanPlayerController titanPlayerController = TitanPlayerController.this;
                int i11 = R$id.mVideoViewVod;
                n8.b titanContext = ((TitanVODView) titanPlayerController._$_findCachedViewById(i11)).getTitanContext();
                if ((titanContext != null ? titanContext.h() : null) == null) {
                    ((ImageView) TitanPlayerController.this._$_findCachedViewById(R$id.mPlayPauseIcon)).setVisibility(8);
                    TitanPlayerController.this.D4(false);
                    return;
                } else if (((TitanVODView) TitanPlayerController.this._$_findCachedViewById(i11)).s()) {
                    TitanPlayerController.this.G4();
                    return;
                } else {
                    TitanPlayerController.this.H4();
                    return;
                }
            }
            if (((ImageView) TitanPlayerController.this._$_findCachedViewById(R$id.mIvStage)).getVisibility() == 8 || !TitanPlayerController.this.G) {
                PauseAdView pauseAdView = TitanPlayerController.this.A;
                if ((pauseAdView != null ? pauseAdView.getParent() : null) != null) {
                    PauseAdView pauseAdView2 = TitanPlayerController.this.A;
                    if (!(pauseAdView2 != null && pauseAdView2.getWidth() == 0)) {
                        return;
                    }
                    PauseAdView pauseAdView3 = TitanPlayerController.this.A;
                    if (!(pauseAdView3 != null && pauseAdView3.getHeight() == 0)) {
                        return;
                    }
                }
                ((ImageView) TitanPlayerController.this._$_findCachedViewById(R$id.mPlayPauseIcon)).setVisibility(8);
                TitanPlayerController.this.D4(false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class n extends ha.a {
        @Override // ha.a
        public void showErrorHint(String str) {
            t9.i.g(str, "returnCode");
        }
    }

    /* loaded from: classes3.dex */
    public static final class n0 implements n.e {
        public n0() {
        }

        @Override // g7.n.e
        public void a(int i10, SubTitleData subTitleData) {
            String str;
            String str2;
            t9.i.g(subTitleData, "subTitleData");
            TitanPlayerController.this.f8467j0 = i10 - 1;
            TitanPlayerController.this.f8473m0 = true;
            TitanPlayerController titanPlayerController = TitanPlayerController.this;
            int i11 = R$id.mVideoViewVod;
            ((TitanVODView) titanPlayerController._$_findCachedViewById(i11)).setSubtitleVisible(TitanPlayerController.this.f8473m0);
            if (t9.i.b(TitanPlayerController.this.B, "0")) {
                SubtitleManager subtitleManager = SubtitleManager.INSTANCE;
                String mDetailDataContentId = TitanPlayerController.this.getMDetailDataContentId();
                if (mDetailDataContentId == null) {
                    mDetailDataContentId = "";
                }
                subtitleManager.putSelectSubtitle(mDetailDataContentId, TitanPlayerController.this.f8467j0, subTitleData.getLanguage());
                if (TitanPlayerController.this.f8482r) {
                    TitanVODView titanVODView = (TitanVODView) TitanPlayerController.this._$_findCachedViewById(i11);
                    String filePath = subTitleData.getFilePath();
                    SimpleProgramList curPlayProgram = TitanPlayerController.this.getCurPlayProgram();
                    if (curPlayProgram == null || (str2 = curPlayProgram.getContentId()) == null) {
                        str2 = "";
                    }
                    titanVODView.J(filePath, str2);
                }
            } else {
                SubtitleManager subtitleManager2 = SubtitleManager.INSTANCE;
                String mDetailDataContentId2 = TitanPlayerController.this.getMDetailDataContentId();
                if (mDetailDataContentId2 == null) {
                    mDetailDataContentId2 = "";
                }
                subtitleManager2.putSelectSubtitle(mDetailDataContentId2, TitanPlayerController.this.f8467j0, subTitleData.getLanguage());
                if (TitanPlayerController.this.f8482r) {
                    TitanVODView titanVODView2 = (TitanVODView) TitanPlayerController.this._$_findCachedViewById(i11);
                    String filePath2 = subTitleData.getFilePath();
                    AssetData data = TitanPlayerController.this.getData();
                    if (data == null || (str = data.getContentId()) == null) {
                        str = "";
                    }
                    titanVODView2.J(filePath2, str);
                }
            }
            String mDetailDataContentId3 = TitanPlayerController.this.getMDetailDataContentId();
            if (mDetailDataContentId3 != null) {
                SubtitleManager.INSTANCE.getMLruCacheSwitch().put(mDetailDataContentId3, Boolean.TRUE);
            }
            SubtitleSettingBean subtitleSettingBean = new SubtitleSettingBean();
            String mDetailDataContentId4 = TitanPlayerController.this.getMDetailDataContentId();
            subtitleSettingBean.setContentId(mDetailDataContentId4 != null ? mDetailDataContentId4 : "");
            subtitleSettingBean.setSubtitleLanguage(subTitleData.getLanguage());
            SubtitleManager subtitleManager3 = SubtitleManager.INSTANCE;
            RecordSubtitleInfoBean recordSubtitleInfoBean = subtitleManager3.getMLruCacheLanguages().get(TitanPlayerController.this.getMDetailDataContentId());
            subtitleSettingBean.setSubtitleIndex(recordSubtitleInfoBean != null ? recordSubtitleInfoBean.getSubtitleIndex() : subtitleManager3.getMGlobalLanguage());
            Integer num = subtitleManager3.getMLruCacheColor().get(TitanPlayerController.this.getMDetailDataContentId());
            subtitleSettingBean.setSubtitleStyle(num == null ? subtitleManager3.getMGlobalColor() : num.intValue());
            Integer num2 = subtitleManager3.getMLruCacheSize().get(TitanPlayerController.this.getMDetailDataContentId());
            subtitleSettingBean.setSubtitleSize(num2 == null ? subtitleManager3.getMGlobalSize() : num2.intValue());
            subtitleSettingBean.setSubtitleSwitch(String.valueOf(TitanPlayerController.this.f8473m0));
            TitanPlayerController.this.l3(subtitleSettingBean);
        }

        @Override // g7.n.e
        public void b(boolean z10) {
            String subTitleLanguage;
            if (TitanPlayerController.this.f8473m0 != z10) {
                Context context = TitanPlayerController.this.getContext();
                String valueOf = String.valueOf(z10);
                AudioTrackBean audioTrackBean = TitanPlayerController.this.f8487t0;
                i1.P(context, valueOf, audioTrackBean != null ? audioTrackBean.getRealAudio() : null);
            }
            TitanPlayerController.this.f8473m0 = z10;
            SubtitleSettingBean subtitleSettingBean = new SubtitleSettingBean();
            String mDetailDataContentId = TitanPlayerController.this.getMDetailDataContentId();
            String str = "";
            if (mDetailDataContentId == null) {
                mDetailDataContentId = "";
            }
            subtitleSettingBean.setContentId(mDetailDataContentId);
            if (TitanPlayerController.this.f8473m0) {
                SubtitleManager subtitleManager = SubtitleManager.INSTANCE;
                RecordSubtitleInfoBean recordSubtitleInfoBean = subtitleManager.getMLruCacheLanguages().get(TitanPlayerController.this.getMDetailDataContentId());
                if (recordSubtitleInfoBean != null && (subTitleLanguage = recordSubtitleInfoBean.getSubTitleLanguage()) != null) {
                    str = subTitleLanguage;
                }
                subtitleSettingBean.setSubtitleLanguage(str);
                Integer num = subtitleManager.getMLruCacheColor().get(TitanPlayerController.this.getMDetailDataContentId());
                subtitleSettingBean.setSubtitleStyle(num == null ? subtitleManager.getMGlobalColor() : num.intValue());
                Integer num2 = subtitleManager.getMLruCacheSize().get(TitanPlayerController.this.getMDetailDataContentId());
                subtitleSettingBean.setSubtitleSize(num2 == null ? subtitleManager.getMGlobalSize() : num2.intValue());
                RecordSubtitleInfoBean recordSubtitleInfoBean2 = subtitleManager.getMLruCacheLanguages().get(TitanPlayerController.this.getMDetailDataContentId());
                subtitleSettingBean.setSubtitleIndex(recordSubtitleInfoBean2 != null ? recordSubtitleInfoBean2.getSubtitleIndex() : -1);
            } else {
                subtitleSettingBean.setSubtitleLanguage("");
                subtitleSettingBean.setSubtitleStyle(-1);
                subtitleSettingBean.setSubtitleSize(-1);
                subtitleSettingBean.setSubtitleIndex(-1);
            }
            subtitleSettingBean.setSubtitleSwitch(String.valueOf(z10));
            TitanPlayerController.this.l3(subtitleSettingBean);
            String mDetailDataContentId2 = TitanPlayerController.this.getMDetailDataContentId();
            if (mDetailDataContentId2 != null) {
                SubtitleManager.INSTANCE.getMLruCacheSwitch().put(mDetailDataContentId2, Boolean.valueOf(z10));
            }
            if (TitanPlayerController.this.f8482r) {
                ((TitanVODView) TitanPlayerController.this._$_findCachedViewById(R$id.mVideoViewVod)).setSubtitleVisible(z10);
            }
            TitanPlayerController.this.getSubtitleAudioLandWindow().q(z10);
            if (z10) {
                return;
            }
            TitanPlayerController.this.f8467j0 = -1;
        }

        @Override // g7.n.e
        public void c(int i10, AudioTrackBean audioTrackBean) {
            t9.i.g(audioTrackBean, "data");
            TitanPlayerController.this.f8475n0 = i10;
            if (t9.i.b(audioTrackBean.getRealAudio(), TitanPlayerController.this.f8499z0.getRealAudio())) {
                return;
            }
            TitanPlayerController.this.R4(audioTrackBean);
            AudioSettingBean audioSettingBean = new AudioSettingBean();
            String mDetailDataContentId = TitanPlayerController.this.getMDetailDataContentId();
            if (mDetailDataContentId == null) {
                mDetailDataContentId = "";
            }
            audioSettingBean.setContentId(mDetailDataContentId);
            audioSettingBean.setAudioLanguage(audioTrackBean.getRealAudio());
            TitanPlayerController.this.f3(audioSettingBean);
            SubtitleManager.INSTANCE.getMLruCacheAudioLanguages().put(TitanPlayerController.this.getMDetailDataContentId(), audioTrackBean.getRealAudio());
        }

        @Override // g7.n.e
        public void d(int i10) {
            String g22;
            TitanPlayerController.this.f8469k0 = i10;
            TitanPlayerController.this.f8473m0 = true;
            String mDetailDataContentId = TitanPlayerController.this.getMDetailDataContentId();
            if (mDetailDataContentId != null) {
                SubtitleManager.INSTANCE.getMLruCacheSize().put(mDetailDataContentId, Integer.valueOf(i10));
            }
            String mDetailDataContentId2 = TitanPlayerController.this.getMDetailDataContentId();
            if (mDetailDataContentId2 != null) {
                SubtitleManager.INSTANCE.getMLruCacheSwitch().put(mDetailDataContentId2, Boolean.TRUE);
            }
            SubtitleSettingBean subtitleSettingBean = new SubtitleSettingBean();
            String mDetailDataContentId3 = TitanPlayerController.this.getMDetailDataContentId();
            if (mDetailDataContentId3 == null) {
                mDetailDataContentId3 = "";
            }
            subtitleSettingBean.setContentId(mDetailDataContentId3);
            SubtitleManager subtitleManager = SubtitleManager.INSTANCE;
            RecordSubtitleInfoBean recordSubtitleInfoBean = subtitleManager.getMLruCacheLanguages().get(TitanPlayerController.this.getMDetailDataContentId());
            subtitleSettingBean.setSubtitleIndex(recordSubtitleInfoBean != null ? recordSubtitleInfoBean.getSubtitleIndex() : subtitleManager.getMGlobalLanguage());
            RecordSubtitleInfoBean recordSubtitleInfoBean2 = subtitleManager.getMLruCacheLanguages().get(TitanPlayerController.this.getMDetailDataContentId());
            if (recordSubtitleInfoBean2 == null || (g22 = recordSubtitleInfoBean2.getSubTitleLanguage()) == null) {
                g22 = TitanPlayerController.this.g2(subtitleManager.getMGlobalLanguage());
            }
            subtitleSettingBean.setSubtitleLanguage(g22);
            Integer num = subtitleManager.getMLruCacheColor().get(TitanPlayerController.this.getMDetailDataContentId());
            subtitleSettingBean.setSubtitleStyle(num == null ? subtitleManager.getMGlobalColor() : num.intValue());
            subtitleSettingBean.setSubtitleSize(TitanPlayerController.this.f8469k0);
            subtitleSettingBean.setSubtitleSwitch(String.valueOf(TitanPlayerController.this.f8473m0));
            TitanPlayerController.this.l3(subtitleSettingBean);
            if (TitanPlayerController.this.f8482r) {
                ((TitanVODView) TitanPlayerController.this._$_findCachedViewById(R$id.mVideoViewVod)).K(subtitleManager.getPortraitSizeValues()[i10].intValue(), subtitleManager.getLandscapeSizeValues()[i10].intValue());
            }
        }

        @Override // g7.n.e
        public void e(int i10) {
            String g22;
            TitanPlayerController.this.f8471l0 = i10;
            TitanPlayerController.this.f8473m0 = true;
            String mDetailDataContentId = TitanPlayerController.this.getMDetailDataContentId();
            if (mDetailDataContentId != null) {
                SubtitleManager.INSTANCE.getMLruCacheColor().put(mDetailDataContentId, Integer.valueOf(i10));
            }
            String mDetailDataContentId2 = TitanPlayerController.this.getMDetailDataContentId();
            if (mDetailDataContentId2 != null) {
                SubtitleManager.INSTANCE.getMLruCacheSwitch().put(mDetailDataContentId2, Boolean.TRUE);
            }
            SubtitleSettingBean subtitleSettingBean = new SubtitleSettingBean();
            String mDetailDataContentId3 = TitanPlayerController.this.getMDetailDataContentId();
            if (mDetailDataContentId3 == null) {
                mDetailDataContentId3 = "";
            }
            subtitleSettingBean.setContentId(mDetailDataContentId3);
            SubtitleManager subtitleManager = SubtitleManager.INSTANCE;
            RecordSubtitleInfoBean recordSubtitleInfoBean = subtitleManager.getMLruCacheLanguages().get(TitanPlayerController.this.getMDetailDataContentId());
            if (recordSubtitleInfoBean == null || (g22 = recordSubtitleInfoBean.getSubTitleLanguage()) == null) {
                g22 = TitanPlayerController.this.g2(subtitleManager.getMGlobalLanguage());
            }
            subtitleSettingBean.setSubtitleLanguage(g22);
            RecordSubtitleInfoBean recordSubtitleInfoBean2 = subtitleManager.getMLruCacheLanguages().get(TitanPlayerController.this.getMDetailDataContentId());
            subtitleSettingBean.setSubtitleIndex(recordSubtitleInfoBean2 != null ? recordSubtitleInfoBean2.getSubtitleIndex() : subtitleManager.getMGlobalLanguage());
            subtitleSettingBean.setSubtitleStyle(TitanPlayerController.this.f8471l0);
            Integer num = subtitleManager.getMLruCacheSize().get(TitanPlayerController.this.getMDetailDataContentId());
            subtitleSettingBean.setSubtitleSize(num == null ? subtitleManager.getMGlobalSize() : num.intValue());
            subtitleSettingBean.setSubtitleSwitch(String.valueOf(TitanPlayerController.this.f8473m0));
            TitanPlayerController.this.l3(subtitleSettingBean);
            if (TitanPlayerController.this.f8482r) {
                if (i10 == 2) {
                    TitanPlayerController titanPlayerController = TitanPlayerController.this;
                    int i11 = R$id.mVideoViewVod;
                    ((TitanVODView) titanPlayerController._$_findCachedViewById(i11)).setSubtitleColor(subtitleManager.getColorValues()[0].intValue());
                    ((TitanVODView) TitanPlayerController.this._$_findCachedViewById(i11)).setSubtitleBg(1);
                    return;
                }
                TitanPlayerController titanPlayerController2 = TitanPlayerController.this;
                int i12 = R$id.mVideoViewVod;
                ((TitanVODView) titanPlayerController2._$_findCachedViewById(i12)).setSubtitleColor(subtitleManager.getColorValues()[i10].intValue());
                ((TitanVODView) TitanPlayerController.this._$_findCachedViewById(i12)).setSubtitleBg(0);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class o extends t9.j implements s9.l {
        public o() {
            super(1);
        }

        public final void b(AudioSettingBean audioSettingBean) {
            com.mobile.brasiltv.utils.b0.U(TitanPlayerController.this, "增加音轨设置成功！");
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((AudioSettingBean) obj);
            return h9.t.f14242a;
        }
    }

    /* loaded from: classes3.dex */
    public static final class o0 implements p.e {
        public o0() {
        }

        @Override // g7.p.e
        public void a(int i10, SubTitleData subTitleData) {
            String str;
            String str2;
            t9.i.g(subTitleData, "subTitleData");
            TitanPlayerController.this.f8467j0 = i10 - 1;
            TitanPlayerController.this.f8473m0 = true;
            TitanPlayerController titanPlayerController = TitanPlayerController.this;
            int i11 = R$id.mVideoViewVod;
            ((TitanVODView) titanPlayerController._$_findCachedViewById(i11)).setSubtitleVisible(TitanPlayerController.this.f8473m0);
            if (t9.i.b(TitanPlayerController.this.B, "0")) {
                SubtitleManager subtitleManager = SubtitleManager.INSTANCE;
                String mDetailDataContentId = TitanPlayerController.this.getMDetailDataContentId();
                if (mDetailDataContentId == null) {
                    mDetailDataContentId = "";
                }
                subtitleManager.putSelectSubtitle(mDetailDataContentId, TitanPlayerController.this.f8467j0, subTitleData.getLanguage());
                if (TitanPlayerController.this.f8482r) {
                    TitanVODView titanVODView = (TitanVODView) TitanPlayerController.this._$_findCachedViewById(i11);
                    String filePath = subTitleData.getFilePath();
                    SimpleProgramList curPlayProgram = TitanPlayerController.this.getCurPlayProgram();
                    if (curPlayProgram == null || (str2 = curPlayProgram.getContentId()) == null) {
                        str2 = "";
                    }
                    titanVODView.J(filePath, str2);
                }
            } else {
                SubtitleManager subtitleManager2 = SubtitleManager.INSTANCE;
                String mDetailDataContentId2 = TitanPlayerController.this.getMDetailDataContentId();
                if (mDetailDataContentId2 == null) {
                    mDetailDataContentId2 = "";
                }
                subtitleManager2.putSelectSubtitle(mDetailDataContentId2, TitanPlayerController.this.f8467j0, subTitleData.getLanguage());
                if (TitanPlayerController.this.f8482r) {
                    TitanVODView titanVODView2 = (TitanVODView) TitanPlayerController.this._$_findCachedViewById(i11);
                    String filePath2 = subTitleData.getFilePath();
                    AssetData data = TitanPlayerController.this.getData();
                    if (data == null || (str = data.getContentId()) == null) {
                        str = "";
                    }
                    titanVODView2.J(filePath2, str);
                }
            }
            String mDetailDataContentId3 = TitanPlayerController.this.getMDetailDataContentId();
            if (mDetailDataContentId3 != null) {
                SubtitleManager.INSTANCE.getMLruCacheSwitch().put(mDetailDataContentId3, Boolean.TRUE);
            }
            SubtitleSettingBean subtitleSettingBean = new SubtitleSettingBean();
            String mDetailDataContentId4 = TitanPlayerController.this.getMDetailDataContentId();
            subtitleSettingBean.setContentId(mDetailDataContentId4 != null ? mDetailDataContentId4 : "");
            subtitleSettingBean.setSubtitleLanguage(subTitleData.getLanguage());
            SubtitleManager subtitleManager3 = SubtitleManager.INSTANCE;
            RecordSubtitleInfoBean recordSubtitleInfoBean = subtitleManager3.getMLruCacheLanguages().get(TitanPlayerController.this.getMDetailDataContentId());
            subtitleSettingBean.setSubtitleIndex(recordSubtitleInfoBean != null ? recordSubtitleInfoBean.getSubtitleIndex() : subtitleManager3.getMGlobalLanguage());
            Integer num = subtitleManager3.getMLruCacheColor().get(TitanPlayerController.this.getMDetailDataContentId());
            subtitleSettingBean.setSubtitleStyle(num == null ? subtitleManager3.getMGlobalColor() : num.intValue());
            Integer num2 = subtitleManager3.getMLruCacheSize().get(TitanPlayerController.this.getMDetailDataContentId());
            subtitleSettingBean.setSubtitleSize(num2 == null ? subtitleManager3.getMGlobalSize() : num2.intValue());
            subtitleSettingBean.setSubtitleSwitch(String.valueOf(TitanPlayerController.this.f8473m0));
            TitanPlayerController.this.l3(subtitleSettingBean);
        }

        @Override // g7.p.e
        public void b(boolean z10) {
            String g22;
            TitanPlayerController.this.f8473m0 = z10;
            SubtitleSettingBean subtitleSettingBean = new SubtitleSettingBean();
            String mDetailDataContentId = TitanPlayerController.this.getMDetailDataContentId();
            if (mDetailDataContentId == null) {
                mDetailDataContentId = "";
            }
            subtitleSettingBean.setContentId(mDetailDataContentId);
            if (TitanPlayerController.this.f8473m0) {
                SubtitleManager subtitleManager = SubtitleManager.INSTANCE;
                RecordSubtitleInfoBean recordSubtitleInfoBean = subtitleManager.getMLruCacheLanguages().get(TitanPlayerController.this.getMDetailDataContentId());
                subtitleSettingBean.setSubtitleIndex(recordSubtitleInfoBean != null ? recordSubtitleInfoBean.getSubtitleIndex() : subtitleManager.getMGlobalLanguage());
                RecordSubtitleInfoBean recordSubtitleInfoBean2 = subtitleManager.getMLruCacheLanguages().get(TitanPlayerController.this.getMDetailDataContentId());
                if (recordSubtitleInfoBean2 == null || (g22 = recordSubtitleInfoBean2.getSubTitleLanguage()) == null) {
                    g22 = TitanPlayerController.this.g2(subtitleManager.getMGlobalLanguage());
                }
                subtitleSettingBean.setSubtitleLanguage(g22);
                Integer num = subtitleManager.getMLruCacheColor().get(TitanPlayerController.this.getMDetailDataContentId());
                subtitleSettingBean.setSubtitleStyle(num == null ? subtitleManager.getMGlobalColor() : num.intValue());
                Integer num2 = subtitleManager.getMLruCacheSize().get(TitanPlayerController.this.getMDetailDataContentId());
                subtitleSettingBean.setSubtitleSize(num2 == null ? subtitleManager.getMGlobalSize() : num2.intValue());
            } else {
                subtitleSettingBean.setSubtitleLanguage("");
                subtitleSettingBean.setSubtitleIndex(-1);
                subtitleSettingBean.setSubtitleStyle(-1);
                subtitleSettingBean.setSubtitleSize(-1);
            }
            subtitleSettingBean.setSubtitleSwitch(String.valueOf(z10));
            TitanPlayerController.this.l3(subtitleSettingBean);
            String mDetailDataContentId2 = TitanPlayerController.this.getMDetailDataContentId();
            if (mDetailDataContentId2 != null) {
                SubtitleManager.INSTANCE.getMLruCacheSwitch().put(mDetailDataContentId2, Boolean.valueOf(z10));
            }
            if (TitanPlayerController.this.f8482r) {
                ((TitanVODView) TitanPlayerController.this._$_findCachedViewById(R$id.mVideoViewVod)).setSubtitleVisible(z10);
            }
            TitanPlayerController.this.getSubtitleAudioPorWindow().q(z10);
            if (z10) {
                return;
            }
            TitanPlayerController.this.f8467j0 = -1;
        }

        @Override // g7.p.e
        public void c(int i10, AudioTrackBean audioTrackBean) {
            t9.i.g(audioTrackBean, "data");
            TitanPlayerController.this.f8475n0 = i10;
            if (t9.i.b(audioTrackBean.getRealAudio(), TitanPlayerController.this.f8499z0.getRealAudio())) {
                return;
            }
            TitanPlayerController.this.R4(audioTrackBean);
            AudioSettingBean audioSettingBean = new AudioSettingBean();
            String mDetailDataContentId = TitanPlayerController.this.getMDetailDataContentId();
            if (mDetailDataContentId == null) {
                mDetailDataContentId = "";
            }
            audioSettingBean.setContentId(mDetailDataContentId);
            audioSettingBean.setAudioLanguage(audioTrackBean.getRealAudio());
            TitanPlayerController.this.f3(audioSettingBean);
            SubtitleManager.INSTANCE.getMLruCacheAudioLanguages().put(TitanPlayerController.this.getMDetailDataContentId(), audioTrackBean.getRealAudio());
        }

        @Override // g7.p.e
        public void d(int i10) {
            String g22;
            TitanPlayerController.this.f8469k0 = i10;
            String mDetailDataContentId = TitanPlayerController.this.getMDetailDataContentId();
            if (mDetailDataContentId != null) {
                SubtitleManager.INSTANCE.getMLruCacheSize().put(mDetailDataContentId, Integer.valueOf(i10));
            }
            String mDetailDataContentId2 = TitanPlayerController.this.getMDetailDataContentId();
            if (mDetailDataContentId2 != null) {
                SubtitleManager.INSTANCE.getMLruCacheSwitch().put(mDetailDataContentId2, Boolean.TRUE);
            }
            SubtitleSettingBean subtitleSettingBean = new SubtitleSettingBean();
            String mDetailDataContentId3 = TitanPlayerController.this.getMDetailDataContentId();
            if (mDetailDataContentId3 == null) {
                mDetailDataContentId3 = "";
            }
            subtitleSettingBean.setContentId(mDetailDataContentId3);
            SubtitleManager subtitleManager = SubtitleManager.INSTANCE;
            RecordSubtitleInfoBean recordSubtitleInfoBean = subtitleManager.getMLruCacheLanguages().get(TitanPlayerController.this.getMDetailDataContentId());
            if (recordSubtitleInfoBean == null || (g22 = recordSubtitleInfoBean.getSubTitleLanguage()) == null) {
                g22 = TitanPlayerController.this.g2(subtitleManager.getMGlobalLanguage());
            }
            subtitleSettingBean.setSubtitleLanguage(g22);
            RecordSubtitleInfoBean recordSubtitleInfoBean2 = subtitleManager.getMLruCacheLanguages().get(TitanPlayerController.this.getMDetailDataContentId());
            subtitleSettingBean.setSubtitleIndex(recordSubtitleInfoBean2 != null ? recordSubtitleInfoBean2.getSubtitleIndex() : subtitleManager.getMGlobalLanguage());
            Integer num = subtitleManager.getMLruCacheColor().get(TitanPlayerController.this.getMDetailDataContentId());
            subtitleSettingBean.setSubtitleStyle(num == null ? subtitleManager.getMGlobalColor() : num.intValue());
            subtitleSettingBean.setSubtitleSize(TitanPlayerController.this.f8469k0);
            subtitleSettingBean.setSubtitleSwitch(String.valueOf(TitanPlayerController.this.f8473m0));
            TitanPlayerController.this.l3(subtitleSettingBean);
            if (TitanPlayerController.this.f8482r) {
                ((TitanVODView) TitanPlayerController.this._$_findCachedViewById(R$id.mVideoViewVod)).K(subtitleManager.getPortraitSizeValues()[i10].intValue(), subtitleManager.getLandscapeSizeValues()[i10].intValue());
            }
        }

        @Override // g7.p.e
        public void e(int i10) {
            String g22;
            TitanPlayerController.this.f8471l0 = i10;
            String mDetailDataContentId = TitanPlayerController.this.getMDetailDataContentId();
            if (mDetailDataContentId != null) {
                SubtitleManager.INSTANCE.getMLruCacheColor().put(mDetailDataContentId, Integer.valueOf(i10));
            }
            String mDetailDataContentId2 = TitanPlayerController.this.getMDetailDataContentId();
            if (mDetailDataContentId2 != null) {
                SubtitleManager.INSTANCE.getMLruCacheSwitch().put(mDetailDataContentId2, Boolean.TRUE);
            }
            SubtitleSettingBean subtitleSettingBean = new SubtitleSettingBean();
            String mDetailDataContentId3 = TitanPlayerController.this.getMDetailDataContentId();
            if (mDetailDataContentId3 == null) {
                mDetailDataContentId3 = "";
            }
            subtitleSettingBean.setContentId(mDetailDataContentId3);
            SubtitleManager subtitleManager = SubtitleManager.INSTANCE;
            RecordSubtitleInfoBean recordSubtitleInfoBean = subtitleManager.getMLruCacheLanguages().get(TitanPlayerController.this.getMDetailDataContentId());
            if (recordSubtitleInfoBean == null || (g22 = recordSubtitleInfoBean.getSubTitleLanguage()) == null) {
                g22 = TitanPlayerController.this.g2(subtitleManager.getMGlobalLanguage());
            }
            subtitleSettingBean.setSubtitleLanguage(g22);
            RecordSubtitleInfoBean recordSubtitleInfoBean2 = subtitleManager.getMLruCacheLanguages().get(TitanPlayerController.this.getMDetailDataContentId());
            subtitleSettingBean.setSubtitleIndex(recordSubtitleInfoBean2 != null ? recordSubtitleInfoBean2.getSubtitleIndex() : subtitleManager.getMGlobalLanguage());
            subtitleSettingBean.setSubtitleStyle(TitanPlayerController.this.f8471l0);
            Integer num = subtitleManager.getMLruCacheSize().get(TitanPlayerController.this.getMDetailDataContentId());
            subtitleSettingBean.setSubtitleSize(num == null ? subtitleManager.getMGlobalSize() : num.intValue());
            subtitleSettingBean.setSubtitleSwitch(String.valueOf(TitanPlayerController.this.f8473m0));
            TitanPlayerController.this.l3(subtitleSettingBean);
            if (TitanPlayerController.this.f8482r) {
                if (i10 == 2) {
                    ((TitanVODView) TitanPlayerController.this._$_findCachedViewById(R$id.mVideoViewVod)).setSubtitleBg(1);
                } else {
                    ((TitanVODView) TitanPlayerController.this._$_findCachedViewById(R$id.mVideoViewVod)).setSubtitleBg(0);
                }
                ((TitanVODView) TitanPlayerController.this._$_findCachedViewById(R$id.mVideoViewVod)).setSubtitleColor(subtitleManager.getColorValues()[i10].intValue());
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class p extends t9.j implements s9.l {
        public p() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return h9.t.f14242a;
        }

        public final void invoke(Throwable th) {
            com.mobile.brasiltv.utils.b0.U(TitanPlayerController.this, "增加音轨设置失败！");
        }
    }

    /* loaded from: classes3.dex */
    public static final class p0 implements SeekBar.OnSeekBarChangeListener {
        public p0() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            t9.i.g(seekBar, "seekBar");
            if (TitanPlayerController.this.W) {
                TitanPlayerController.this.H = true;
                ((TitanVODView) TitanPlayerController.this._$_findCachedViewById(R$id.mVideoViewVod)).x(seekBar.getProgress());
                if (TitanPlayerController.this.V) {
                    ((ImageView) TitanPlayerController.this._$_findCachedViewById(R$id.mPlayPauseIcon)).setVisibility(8);
                    TitanPlayerController.this.D4(false);
                }
                if (seekBar.getProgress() != seekBar.getMax()) {
                    TitanPlayerController.this.D = false;
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class q extends t9.j implements s9.l {
        public q() {
            super(1);
        }

        public final void b(SubtitleSettingBean subtitleSettingBean) {
            com.mobile.brasiltv.utils.b0.U(TitanPlayerController.this, "增加字幕设置成功！");
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((SubtitleSettingBean) obj);
            return h9.t.f14242a;
        }
    }

    /* loaded from: classes3.dex */
    public static final class q0 implements GuideNextClickListener {
        public q0() {
        }

        @Override // com.mobile.brasiltv.bean.GuideNextClickListener
        public void onGuideNextClick(String str, boolean z10) {
            if (z10) {
                TitanPlayerController.this.M4();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class r extends t9.j implements s9.l {
        public r() {
            super(1);
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return h9.t.f14242a;
        }

        public final void invoke(Throwable th) {
            com.mobile.brasiltv.utils.b0.U(TitanPlayerController.this, "增加字幕设置失败！");
        }
    }

    /* loaded from: classes3.dex */
    public static final class r0 implements GuideNextClickListener {
        public r0() {
        }

        @Override // com.mobile.brasiltv.bean.GuideNextClickListener
        public void onGuideNextClick(String str, boolean z10) {
            TitanPlayerController.this.M4();
            ((AlphaRelativeLayout) TitanPlayerController.this._$_findCachedViewById(R$id.mLayoutController)).delayHide();
            xa.c.c().j(new ShowVodSharingGuideEvent());
        }
    }

    /* loaded from: classes3.dex */
    public static final class s extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final s f8548a = new s();

        public s() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Intent invoke(Intent intent) {
            t9.i.g(intent, "intent");
            Intent putExtra = intent.putExtra("from_type", "VOD");
            t9.i.f(putExtra, "intent.putExtra(Constant…, Constant.FROM_TYPE_VOD)");
            return putExtra;
        }
    }

    /* loaded from: classes3.dex */
    public static final class s0 extends t9.j implements s9.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f8549a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s0(Context context) {
            super(0);
            this.f8549a = context;
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ArrayList invoke() {
            return SubtitleManager.INSTANCE.getSizeList(this.f8549a);
        }
    }

    /* loaded from: classes3.dex */
    public static final class t implements SeekBar.OnSeekBarChangeListener {
        public t() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            t9.i.g(seekBar, "seekBar");
            if (((AutoLinearLayout) TitanPlayerController.this._$_findCachedViewById(R$id.llCastContainer)).getVisibility() == 0) {
                com.mobile.brasiltv.utils.h hVar = com.mobile.brasiltv.utils.h.f8694a;
                if (t9.i.b(hVar.a(), hVar.k())) {
                    com.mobile.brasiltv.utils.g.f8651a.s(seekBar.getProgress() * 1000);
                } else if (t9.i.b(hVar.a(), hVar.l())) {
                    TitanPlayerController.this.N.q(seekBar.getProgress() * 1000);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class t0 extends t9.j implements s9.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f8551a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t0(Context context) {
            super(0);
            this.f8551a = context;
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ArrayList invoke() {
            return SubtitleManager.INSTANCE.getStyleList(this.f8551a);
        }
    }

    /* loaded from: classes3.dex */
    public static final class u implements BeforeVodAdView.BeforeVodCallback {
        public u() {
        }

        @Override // com.mobile.brasiltv.view.adView.BeforeVodAdView.BeforeVodCallback
        public void onBack() {
            TitanPlayerController.this.k2(true);
        }

        @Override // com.mobile.brasiltv.view.adView.BeforeVodAdView.BeforeVodCallback
        public void onCountDownFinished() {
            TitanPlayerController.this.f8459f0 = true;
            TitanPlayerController.this.C3();
            TitanPlayerController.this.J4();
        }

        @Override // com.mobile.brasiltv.view.adView.BeforeVodAdView.BeforeVodCallback
        public void onFullScreen() {
            TitanPlayerController.this.getMOrientationHelper().q();
        }
    }

    /* loaded from: classes3.dex */
    public static final class u0 extends t9.j implements s9.a {
        public u0() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final g7.n invoke() {
            return new g7.n(TitanPlayerController.this.getMActivity());
        }
    }

    /* loaded from: classes3.dex */
    public static final class v extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final v f8554a = new v();

        public v() {
            super(1);
        }

        @Override // s9.l
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Intent invoke(Intent intent) {
            t9.i.g(intent, "intent");
            Intent putExtra = intent.putExtra("from_type", "VOD");
            t9.i.f(putExtra, "intent.putExtra(Constant…, Constant.FROM_TYPE_VOD)");
            return putExtra;
        }
    }

    /* loaded from: classes3.dex */
    public static final class v0 extends t9.j implements s9.a {
        public v0() {
            super(0);
        }

        @Override // s9.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final g7.p invoke() {
            return new g7.p(TitanPlayerController.this.getMActivity());
        }
    }

    /* loaded from: classes3.dex */
    public static final class w implements BeforeVodAdView.BeforeVodCallback {
        public w() {
        }

        @Override // com.mobile.brasiltv.view.adView.BeforeVodAdView.BeforeVodCallback
        public void onBack() {
            TitanPlayerController.this.k2(true);
        }

        @Override // com.mobile.brasiltv.view.adView.BeforeVodAdView.BeforeVodCallback
        public void onCountDownFinished() {
            TitanPlayerController.this.f8459f0 = true;
            if (TitanPlayerController.this.W) {
                TitanPlayerController.this.X2();
                ((TitanVODView) TitanPlayerController.this._$_findCachedViewById(R$id.mVideoViewVod)).w();
            } else {
                ((ImageView) TitanPlayerController.this._$_findCachedViewById(R$id.mPlayPauseIcon)).setVisibility(8);
                TitanPlayerController.this.D4(false);
                ((RelativeLayout) TitanPlayerController.this._$_findCachedViewById(R$id.mBufferView)).setVisibility(0);
            }
            TitanPlayerController.this.J4();
        }

        @Override // com.mobile.brasiltv.view.adView.BeforeVodAdView.BeforeVodCallback
        public void onFullScreen() {
            TitanPlayerController.this.getMOrientationHelper().q();
        }
    }

    /* loaded from: classes3.dex */
    public static final class x extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final x f8557a = new x();

        public x() {
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

    /* loaded from: classes3.dex */
    public static final class y extends t9.j implements s9.l {
        public y() {
            super(1);
        }

        public final void b(SubtitleSettingBean subtitleSettingBean) {
            if (subtitleSettingBean.getSubtitleStyle() != -1) {
                TitanPlayerController.this.f8471l0 = subtitleSettingBean.getSubtitleStyle();
            } else {
                TitanPlayerController.this.f8471l0 = SubtitleManager.INSTANCE.getMGlobalColor();
            }
        }

        @Override // s9.l
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            b((SubtitleSettingBean) obj);
            return h9.t.f14242a;
        }
    }

    /* loaded from: classes3.dex */
    public static final class z extends t9.j implements s9.l {

        /* renamed from: a, reason: collision with root package name */
        public static final z f8559a = new z();

        public z() {
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

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TitanPlayerController(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
    }

    public static final void C4(TitanPlayerController titanPlayerController) {
        t9.i.g(titanPlayerController, "this$0");
        TextView textView = (TextView) titanPlayerController._$_findCachedViewById(R$id.tvPlayTips);
        if (textView == null) {
            return;
        }
        textView.setVisibility(8);
    }

    public static final void D3(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void E2(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void E3(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void F2(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void F3(TitanPlayerController titanPlayerController, ObservableEmitter observableEmitter) {
        String str;
        t9.i.g(titanPlayerController, "this$0");
        t9.i.g(observableEmitter, "it");
        MobileDao mSubtitleAndAudioLanguageDao = titanPlayerController.getMSubtitleAndAudioLanguageDao();
        AssetData assetData = titanPlayerController.f8458f;
        if (assetData == null || (str = assetData.getContentId()) == null) {
            str = "";
        }
        SubtitleSettingBean querySubtitleSetting = mSubtitleAndAudioLanguageDao.querySubtitleSetting(str);
        if (querySubtitleSetting != null) {
            observableEmitter.onNext(querySubtitleSetting);
        } else {
            observableEmitter.onNext(new SubtitleSettingBean());
        }
    }

    public static final void G3(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void H3(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void I3(TitanPlayerController titanPlayerController, ObservableEmitter observableEmitter) {
        String str;
        t9.i.g(titanPlayerController, "this$0");
        t9.i.g(observableEmitter, "it");
        MobileDao mSubtitleAndAudioLanguageDao = titanPlayerController.getMSubtitleAndAudioLanguageDao();
        AssetData assetData = titanPlayerController.f8458f;
        if (assetData == null || (str = assetData.getContentId()) == null) {
            str = "";
        }
        SubtitleSettingBean querySubtitleSetting = mSubtitleAndAudioLanguageDao.querySubtitleSetting(str);
        if (querySubtitleSetting != null) {
            observableEmitter.onNext(querySubtitleSetting);
        } else {
            observableEmitter.onNext(new SubtitleSettingBean());
        }
    }

    public static final void J2(TitanPlayerController titanPlayerController) {
        t9.i.g(titanPlayerController, "this$0");
        com.mobile.brasiltv.utils.g gVar = com.mobile.brasiltv.utils.g.f8651a;
        gVar.B(false);
        gVar.C(false);
        gVar.y(true);
        ((ImageView) titanPlayerController._$_findCachedViewById(R$id.mImagePlayCast)).setImageResource(R.drawable.icon_play_white);
        int i10 = R$id.mSeekBarCast;
        ((SeekBar) titanPlayerController._$_findCachedViewById(i10)).setProgress(((SeekBar) titanPlayerController._$_findCachedViewById(i10)).getMax());
        TextView textView = (TextView) titanPlayerController._$_findCachedViewById(R$id.mTextCurTimeCast);
        if (textView != null) {
            textView.setText(y6.a.l(((SeekBar) titanPlayerController._$_findCachedViewById(i10)).getProgress()));
        }
        titanPlayerController.C = 0L;
        Links links = titanPlayerController.f8498z;
        if (links == null) {
            return;
        }
        links.setRecordTime(0L);
    }

    public static final void J3(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void K2(int i10, String str, TitanPlayerController titanPlayerController, String str2) {
        t9.i.g(str, "$extra");
        t9.i.g(titanPlayerController, "this$0");
        if (com.mobile.brasiltv.utils.h.f8694a.t()) {
            com.mobile.brasiltv.utils.g.f8651a.G();
        }
        xa.c.c().j(new CastToCloseFloatViewEvent());
        if (i10 == 501 || i10 == 701) {
            TextView textView = (TextView) titanPlayerController._$_findCachedViewById(R$id.mTvCastRecommendHint);
            if (textView != null) {
                textView.setVisibility(8);
            }
            int i11 = R$id.mTvCastErrorHint;
            TextView textView2 = (TextView) titanPlayerController._$_findCachedViewById(i11);
            if (textView2 != null) {
                textView2.setText(titanPlayerController.getResources().getString(R.string.cast_restart_device));
            }
            TextView textView3 = (TextView) titanPlayerController._$_findCachedViewById(i11);
            if (textView3 != null) {
                textView3.setVisibility(0);
            }
        } else {
            TextView textView4 = (TextView) titanPlayerController._$_findCachedViewById(R$id.mTvCastRecommendHint);
            if (textView4 != null) {
                textView4.setVisibility(0);
            }
            TextView textView5 = (TextView) titanPlayerController._$_findCachedViewById(R$id.mTvCastErrorHint);
            if (textView5 != null) {
                textView5.setVisibility(8);
            }
        }
        int i12 = R$id.mTvCastState;
        TextView textView6 = (TextView) titanPlayerController._$_findCachedViewById(i12);
        if (textView6 != null) {
            textView6.setText(titanPlayerController.getContext().getResources().getString(R.string.cast_status_casting_failed));
        }
        TextView textView7 = (TextView) titanPlayerController._$_findCachedViewById(i12);
        if (textView7 != null) {
            textView7.append(ASCIIPropertyListParser.ARRAY_BEGIN_TOKEN + str2 + ASCIIPropertyListParser.DATE_DATE_FIELD_DELIMITER + i10 + ASCIIPropertyListParser.ARRAY_END_TOKEN);
        }
        TextView textView8 = (TextView) titanPlayerController._$_findCachedViewById(i12);
        if (textView8 != null) {
            textView8.setTextColor(titanPlayerController.getContext().getResources().getColor(R.color.color_f72f2f));
        }
        TextView textView9 = (TextView) titanPlayerController._$_findCachedViewById(R$id.mTvPleaseWait);
        if (textView9 != null) {
            textView9.setVisibility(8);
        }
        ((ImageView) titanPlayerController._$_findCachedViewById(R$id.mImagePlayCast)).setImageResource(R.drawable.icon_play_white);
    }

    public static final void K3(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void K4(TitanPlayerController titanPlayerController, BaseGuideManager baseGuideManager) {
        t9.i.g(titanPlayerController, "this$0");
        t9.i.g(baseGuideManager, "$baseGuideManager");
        if (titanPlayerController.B2()) {
            return;
        }
        baseGuideManager.showGuide();
    }

    public static final void L2(TitanPlayerController titanPlayerController) {
        t9.i.g(titanPlayerController, "this$0");
        com.mobile.brasiltv.utils.g.f8651a.A(true);
        xa.c.c().j(new CastPlaySuccessEvent("VOD"));
        ((TextView) titanPlayerController._$_findCachedViewById(R$id.mTvPleaseWait)).setVisibility(0);
        int i10 = R$id.mTvCastState;
        ((TextView) titanPlayerController._$_findCachedViewById(i10)).setText(titanPlayerController.getContext().getResources().getString(R.string.cast_status_prepare));
        ((TextView) titanPlayerController._$_findCachedViewById(i10)).setTextColor(titanPlayerController.getContext().getResources().getColor(R.color.color_fffefe));
        ((TextView) titanPlayerController._$_findCachedViewById(R$id.mTvCastRecommendHint)).setVisibility(4);
        ((TextView) titanPlayerController._$_findCachedViewById(R$id.mTvCastErrorHint)).setVisibility(8);
        titanPlayerController.q3();
        ((ImageView) titanPlayerController._$_findCachedViewById(R$id.mImagePlayCast)).setImageResource(R.drawable.icon_pause_white);
    }

    public static final void L3(TitanPlayerController titanPlayerController, ObservableEmitter observableEmitter) {
        String str;
        t9.i.g(titanPlayerController, "this$0");
        t9.i.g(observableEmitter, "it");
        MobileDao mSubtitleAndAudioLanguageDao = titanPlayerController.getMSubtitleAndAudioLanguageDao();
        AssetData assetData = titanPlayerController.f8458f;
        if (assetData == null || (str = assetData.getContentId()) == null) {
            str = "";
        }
        SubtitleSettingBean querySubtitleSetting = mSubtitleAndAudioLanguageDao.querySubtitleSetting(str);
        if (querySubtitleSetting != null) {
            observableEmitter.onNext(querySubtitleSetting);
        } else {
            observableEmitter.onNext(new SubtitleSettingBean());
        }
    }

    public static final void M0(TitanPlayerController titanPlayerController, View view) {
        t9.i.g(titanPlayerController, "this$0");
        titanPlayerController.k2(true);
    }

    public static final void M2(TitanPlayerController titanPlayerController) {
        t9.i.g(titanPlayerController, "this$0");
        com.mobile.brasiltv.utils.g gVar = com.mobile.brasiltv.utils.g.f8651a;
        gVar.B(true);
        gVar.C(false);
        ((ImageView) titanPlayerController._$_findCachedViewById(R$id.mImagePlayCast)).setImageResource(R.drawable.icon_play_white);
    }

    public static final void M3(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void N2(TitanPlayerController titanPlayerController) {
        t9.i.g(titanPlayerController, "this$0");
        xa.c.c().j(new CastPlaySuccessEvent("VOD"));
        com.mobile.brasiltv.utils.g gVar = com.mobile.brasiltv.utils.g.f8651a;
        gVar.C(true);
        gVar.z(true);
        int i10 = R$id.mTvCastState;
        ((TextView) titanPlayerController._$_findCachedViewById(i10)).setText(titanPlayerController.getContext().getResources().getString(R.string.cast_status_casting));
        ((TextView) titanPlayerController._$_findCachedViewById(i10)).setTextColor(titanPlayerController.getContext().getResources().getColor(R.color.color_fffefe));
        ((TextView) titanPlayerController._$_findCachedViewById(R$id.mTvPleaseWait)).setVisibility(8);
        ((TextView) titanPlayerController._$_findCachedViewById(R$id.mTvCastRecommendHint)).setVisibility(4);
        ((TextView) titanPlayerController._$_findCachedViewById(R$id.mTvCastErrorHint)).setVisibility(8);
        titanPlayerController.q3();
        ((ImageView) titanPlayerController._$_findCachedViewById(R$id.mImagePlayCast)).setImageResource(R.drawable.icon_pause_white);
    }

    public static final void N3(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void O2(long j10, long j11, TitanPlayerController titanPlayerController) {
        TextView textView;
        SeekBar seekBar;
        t9.i.g(titanPlayerController, "this$0");
        int i10 = R$id.mTvCastState;
        TextView textView2 = (TextView) titanPlayerController._$_findCachedViewById(i10);
        if (textView2 != null) {
            textView2.setText(titanPlayerController.getContext().getResources().getString(R.string.cast_status_casting));
        }
        TextView textView3 = (TextView) titanPlayerController._$_findCachedViewById(i10);
        if (textView3 != null) {
            textView3.setTextColor(titanPlayerController.getContext().getResources().getColor(R.color.color_fffefe));
        }
        TextView textView4 = (TextView) titanPlayerController._$_findCachedViewById(R$id.mTvPleaseWait);
        if (textView4 != null) {
            textView4.setVisibility(8);
        }
        TextView textView5 = (TextView) titanPlayerController._$_findCachedViewById(R$id.mTvCastRecommendHint);
        if (textView5 != null) {
            textView5.setVisibility(4);
        }
        TextView textView6 = (TextView) titanPlayerController._$_findCachedViewById(R$id.mTvCastErrorHint);
        if (textView6 != null) {
            textView6.setVisibility(8);
        }
        int i11 = R$id.mSeekBarCast;
        SeekBar seekBar2 = (SeekBar) titanPlayerController._$_findCachedViewById(i11);
        boolean z10 = false;
        if (seekBar2 != null && seekBar2.getMax() == ((int) j10)) {
            z10 = true;
        }
        if (!z10 && (seekBar = (SeekBar) titanPlayerController._$_findCachedViewById(i11)) != null) {
            seekBar.setMax((int) j10);
        }
        SeekBar seekBar3 = (SeekBar) titanPlayerController._$_findCachedViewById(i11);
        if (seekBar3 != null) {
            seekBar3.setProgress((int) j11);
        }
        String l10 = y6.a.l(j10);
        String l11 = y6.a.l(j11);
        int i12 = R$id.mTextTotalTimeCast;
        TextView textView7 = (TextView) titanPlayerController._$_findCachedViewById(i12);
        if (!t9.i.b(textView7 != null ? textView7.getText() : null, '/' + l10) && (textView = (TextView) titanPlayerController._$_findCachedViewById(i12)) != null) {
            textView.setText('/' + l10);
        }
        TextView textView8 = (TextView) titanPlayerController._$_findCachedViewById(R$id.mTextCurTimeCast);
        if (textView8 != null) {
            textView8.setText(l11);
        }
        titanPlayerController.C = j11 * 1000;
    }

    public static final void O3(TitanPlayerController titanPlayerController, ObservableEmitter observableEmitter) {
        String str;
        t9.i.g(titanPlayerController, "this$0");
        t9.i.g(observableEmitter, "it");
        MobileDao mSubtitleAndAudioLanguageDao = titanPlayerController.getMSubtitleAndAudioLanguageDao();
        AssetData assetData = titanPlayerController.f8458f;
        if (assetData == null || (str = assetData.getContentId()) == null) {
            str = "";
        }
        SubtitleSettingBean querySubtitleSetting = mSubtitleAndAudioLanguageDao.querySubtitleSetting(str);
        if (querySubtitleSetting != null) {
            observableEmitter.onNext(querySubtitleSetting);
        } else {
            observableEmitter.onNext(new SubtitleSettingBean());
        }
    }

    public static final void Q2(TitanPlayerController titanPlayerController) {
        t9.i.g(titanPlayerController, "this$0");
        ((ImageView) titanPlayerController._$_findCachedViewById(R$id.mImagePlayCast)).setImageResource(R.drawable.icon_play_white);
        if (((SeekBar) titanPlayerController._$_findCachedViewById(R$id.mSeekBarCast)).getProgress() > ((SeekBar) titanPlayerController._$_findCachedViewById(r0)).getMax() - 10) {
            titanPlayerController.I2();
        } else {
            titanPlayerController.A4(-2, "");
        }
    }

    public static final void R1(TitanPlayerController titanPlayerController) {
        t9.i.g(titanPlayerController, "this$0");
        com.mobile.brasiltv.utils.h hVar = com.mobile.brasiltv.utils.h.f8694a;
        if (hVar.o()) {
            Program program = titanPlayerController.E0;
            titanPlayerController.C = program != null ? program.getStart() : 0L;
            V1(titanPlayerController, false, false, 2, null);
        }
        if (titanPlayerController.J0 || hVar.o() || (hVar.o() && t9.i.b(titanPlayerController.B, "0") && titanPlayerController.I0)) {
            xa.c.c().j(new CastToPlayEvent("VOD"));
            titanPlayerController.I0 = false;
        }
    }

    public static final boolean R3(TitanPlayerController titanPlayerController, GestureDetector gestureDetector, View view, MotionEvent motionEvent) {
        t9.i.g(titanPlayerController, "this$0");
        t9.i.g(gestureDetector, "$mGestureDetector");
        t9.i.f(view, "v");
        t9.i.f(motionEvent, "event");
        return titanPlayerController.Z4(view, motionEvent, gestureDetector);
    }

    public static final void S1(TitanPlayerController titanPlayerController) {
        t9.i.g(titanPlayerController, "this$0");
        if (com.mobile.brasiltv.utils.b0.K(titanPlayerController.G0) && titanPlayerController.f8494x) {
            String str = titanPlayerController.G0;
            if (str != null) {
                Integer num = titanPlayerController.H0;
                t9.i.d(num);
                titanPlayerController.A4(num.intValue(), str);
            }
            titanPlayerController.F0 = true;
        }
        if (!titanPlayerController.J0) {
            com.mobile.brasiltv.utils.h hVar = com.mobile.brasiltv.utils.h.f8694a;
            if (!hVar.o() && (!hVar.o() || !t9.i.b(titanPlayerController.B, "0") || !titanPlayerController.I0)) {
                return;
            }
        }
        if (titanPlayerController.F0) {
            return;
        }
        xa.c.c().j(new CastToPlayEvent("VOD"));
        titanPlayerController.I0 = false;
    }

    public static final void T1(TitanPlayerController titanPlayerController) {
        t9.i.g(titanPlayerController, "this$0");
        V1(titanPlayerController, false, false, 2, null);
    }

    public static /* synthetic */ void V1(TitanPlayerController titanPlayerController, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z11 = false;
        }
        titanPlayerController.U1(z10, z11);
    }

    public static final void W3(TitanPlayerController titanPlayerController, int i10, ObservableEmitter observableEmitter) {
        List<SimpleProgramList> simpleProgramList;
        SimpleProgramList simpleProgramList2;
        t9.i.g(titanPlayerController, "this$0");
        t9.i.g(observableEmitter, "emitter");
        List<PosterList> list = null;
        if (t9.i.b(titanPlayerController.B, "0")) {
            AssetData assetData = titanPlayerController.f8458f;
            if (assetData != null && (simpleProgramList = assetData.getSimpleProgramList()) != null && (simpleProgramList2 = simpleProgramList.get(i10)) != null) {
                list = simpleProgramList2.getPosterList();
            }
        } else {
            AssetData assetData2 = titanPlayerController.f8458f;
            if (assetData2 != null) {
                list = assetData2.getPosterList();
            }
        }
        if (list != null) {
            for (PosterList posterList : list) {
                if (t9.i.b(posterList.getFileType(), a7.d.f279a.k())) {
                    String fileUrl = posterList.getFileUrl();
                    t9.i.f(fileUrl, "it.fileUrl");
                    if (fileUrl.length() > 0) {
                        observableEmitter.onNext(posterList.getFileUrl());
                        observableEmitter.onComplete();
                        return;
                    }
                }
            }
        }
        observableEmitter.onError(new Throwable());
    }

    public static final void X3(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void Y1(TitanPlayerController titanPlayerController, View view) {
        t9.i.g(titanPlayerController, "this$0");
        titanPlayerController.f8496y = true;
        ((AutoLinearLayout) titanPlayerController._$_findCachedViewById(R$id.mLayoutMobileNotify)).setVisibility(8);
        ((TitanVODView) titanPlayerController._$_findCachedViewById(R$id.mVideoViewVod)).w();
        titanPlayerController.X2();
    }

    public static final void Y3(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void a4(TitanPlayerController titanPlayerController, View view) {
        t9.i.g(titanPlayerController, "this$0");
        if (titanPlayerController.S) {
            ((ImageView) titanPlayerController._$_findCachedViewById(R$id.mPlayPauseIcon)).setVisibility(8);
            titanPlayerController.D4(false);
            int i10 = R$id.mVideoViewVod;
            if (((TitanVODView) titanPlayerController._$_findCachedViewById(i10)).s()) {
                ((TitanVODView) titanPlayerController._$_findCachedViewById(i10)).u();
                titanPlayerController.H4();
                titanPlayerController.F4();
                return;
            } else {
                titanPlayerController.G4();
                if (titanPlayerController.D) {
                    ((TitanVODView) titanPlayerController._$_findCachedViewById(i10)).x(0L);
                } else {
                    ((TitanVODView) titanPlayerController._$_findCachedViewById(i10)).w();
                }
                titanPlayerController.G = false;
                titanPlayerController.w2();
                return;
            }
        }
        titanPlayerController.V = true;
        if (!titanPlayerController.W1() && !titanPlayerController.f8463h0) {
            ((BeforeVodAdView) titanPlayerController._$_findCachedViewById(R$id.mBvavAd)).hideBeforeVodAd();
            s1.m mVar = s1.m.f18686a;
            Context context = titanPlayerController.getContext();
            t9.i.f(context, com.umeng.analytics.pro.f.X);
            String n10 = a6.a.f228a.n();
            l0 l0Var = titanPlayerController.new l0();
            i.c cVar = w6.i.f19214g;
            mVar.B(context, n10, l0Var, cVar.I(), (r14 & 16) != 0 ? false : false, cVar.r());
            return;
        }
        if (!titanPlayerController.W) {
            ((ImageView) titanPlayerController._$_findCachedViewById(R$id.mPlayPauseIcon)).setVisibility(8);
            titanPlayerController.D4(false);
            ((RelativeLayout) titanPlayerController._$_findCachedViewById(R$id.mBufferView)).setVisibility(0);
        } else {
            titanPlayerController.X2();
            if (titanPlayerController.D) {
                ((TitanVODView) titanPlayerController._$_findCachedViewById(R$id.mVideoViewVod)).x(0L);
            } else {
                ((TitanVODView) titanPlayerController._$_findCachedViewById(R$id.mVideoViewVod)).w();
            }
        }
    }

    public static final void b4(TitanPlayerController titanPlayerController, View view) {
        t9.i.g(titanPlayerController, "this$0");
        com.mobile.brasiltv.utils.b0.k(titanPlayerController.getMActivity(), RootColumnId.freeVodColumn, -1, titanPlayerController.f8470l);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final void c4(TitanPlayerController titanPlayerController, View view) {
        t9.i.g(titanPlayerController, "this$0");
        i.c cVar = w6.i.f19214g;
        String I = cVar.I();
        switch (I.hashCode()) {
            case 49:
                if (I.equals("1")) {
                    com.mobile.brasiltv.utils.b0.c0(titanPlayerController.getMActivity(), AccountBindAty.class);
                    break;
                }
                break;
            case 50:
                if (I.equals("2")) {
                    com.mobile.brasiltv.utils.b0.U(titanPlayerController, "beVipUrl:" + cVar.g());
                    if (cVar.g().length() > 0) {
                        Context context = titanPlayerController.getContext();
                        t9.i.f(context, com.umeng.analytics.pro.f.X);
                        com.mobile.brasiltv.utils.b0.j0(context, cVar.g(), false, true, false, false, 24, null);
                        break;
                    }
                }
                break;
            case 51:
                if (I.equals("3") && titanPlayerController.f8470l) {
                    com.mobile.brasiltv.utils.b0.U(titanPlayerController, "beVipUrl:" + cVar.g());
                    if (cVar.g().length() > 0) {
                        Context context2 = titanPlayerController.getContext();
                        t9.i.f(context2, com.umeng.analytics.pro.f.X);
                        com.mobile.brasiltv.utils.b0.j0(context2, cVar.g(), false, true, false, false, 24, null);
                        break;
                    }
                }
                break;
        }
    }

    public static final void d2(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void d4(TitanPlayerController titanPlayerController, View view) {
        t9.i.g(titanPlayerController, "this$0");
        if (((AutoLinearLayout) titanPlayerController._$_findCachedViewById(R$id.mLayoutMobileNotify)).getVisibility() == 0) {
            return;
        }
        ((ImageView) titanPlayerController._$_findCachedViewById(R$id.mPlayPauseIcon)).performClick();
    }

    public static final void e2(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void e4(TitanPlayerController titanPlayerController, View view) {
        t9.i.g(titanPlayerController, "this$0");
        titanPlayerController.f8455c.q();
    }

    public static final void f4(TitanPlayerController titanPlayerController, View view) {
        t9.i.g(titanPlayerController, "this$0");
        AutoFrameLayout autoFrameLayout = (AutoFrameLayout) titanPlayerController._$_findCachedViewById(R$id.mLayoutSetInfo);
        t9.i.f(autoFrameLayout, "mLayoutSetInfo");
        titanPlayerController.L4(autoFrameLayout, AutoUtils.getPercentWidthSize(580));
        titanPlayerController.b2();
    }

    public static final void g3(TitanPlayerController titanPlayerController, AudioSettingBean audioSettingBean, ObservableEmitter observableEmitter) {
        t9.i.g(titanPlayerController, "this$0");
        t9.i.g(audioSettingBean, "$audioSetting");
        t9.i.g(observableEmitter, "it");
        Context applicationContext = titanPlayerController.getContext().getApplicationContext();
        t9.i.f(applicationContext, "context.applicationContext");
        new MobileDao(applicationContext).addAudioSetting(audioSettingBean);
        observableEmitter.onNext(audioSettingBean);
        observableEmitter.onComplete();
    }

    public static final void g4(TitanPlayerController titanPlayerController, View view) {
        t9.i.g(titanPlayerController, "this$0");
        titanPlayerController.getSubtitleAudioLandWindow().setWidth(-1);
        titanPlayerController.getSubtitleAudioLandWindow().setHeight(-1);
        titanPlayerController.getSubtitleAudioLandWindow().d(titanPlayerController, true);
        titanPlayerController.getSubtitleAudioLandWindow().s(titanPlayerController.f8475n0, titanPlayerController.f8467j0 + 1, titanPlayerController.f8469k0, titanPlayerController.f8471l0, titanPlayerController.f8473m0);
    }

    private final MobileDao getMSubtitleAndAudioLanguageDao() {
        return (MobileDao) this.K0.getValue();
    }

    private final MediaMetadata getMediaMetadata() {
        MediaMetadata mediaMetadata = new MediaMetadata(1);
        AssetData assetData = this.f8458f;
        t9.i.d(assetData);
        String alias = assetData.getAlias();
        AssetData assetData2 = this.f8458f;
        t9.i.d(assetData2);
        mediaMetadata.putString(MediaMetadata.KEY_TITLE, com.mobile.brasiltv.utils.b0.e(alias, assetData2.getName()));
        mediaMetadata.putString(MediaMetadata.KEY_SUBTITLE, "");
        t9.i.d(this.f8458f);
        if (!r2.getPosterList().isEmpty()) {
            AssetData assetData3 = this.f8458f;
            t9.i.d(assetData3);
            mediaMetadata.addImage(new WebImage(Uri.parse(assetData3.getPosterList().get(0).getFileUrl())));
        }
        AssetData assetData4 = this.f8458f;
        t9.i.d(assetData4);
        if (assetData4.getPosterList().size() > 1) {
            AssetData assetData5 = this.f8458f;
            t9.i.d(assetData5);
            mediaMetadata.addImage(new WebImage(Uri.parse(assetData5.getPosterList().get(1).getFileUrl())));
        }
        return mediaMetadata;
    }

    private final float getRealCurBrightness() {
        int i10 = 0;
        if (!(getMActivity().getWindow().getAttributes().screenBrightness == -1.0f)) {
            return getMActivity().getWindow().getAttributes().screenBrightness;
        }
        try {
            i10 = Settings.System.getInt(getMActivity().getContentResolver(), "screen_brightness");
        } catch (Settings.SettingNotFoundException e10) {
            e10.printStackTrace();
        }
        Resources system = Resources.getSystem();
        return i10 / system.getInteger(system.getIdentifier("config_screenBrightnessSettingMaximum", "integer", "android"));
    }

    private final n6.a getSetInfoAdapter() {
        return (n6.a) this.f8488u.getValue();
    }

    private final ArrayList<String> getSizeList() {
        return (ArrayList) this.f8483r0.getValue();
    }

    private final ArrayList<SubtitleStyleBean> getStyleList() {
        return (ArrayList) this.f8485s0.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final g7.n getSubtitleAudioLandWindow() {
        return (g7.n) this.f8490v.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final g7.p getSubtitleAudioPorWindow() {
        return (g7.p) this.f8492w.getValue();
    }

    public static final void h3(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void h4(TitanPlayerController titanPlayerController, View view) {
        t9.i.g(titanPlayerController, "this$0");
        titanPlayerController.f8455c.t();
        ((AutoFrameLayout) titanPlayerController._$_findCachedViewById(R$id.mFlLocked)).setVisibility(0);
        titanPlayerController.D2();
        ((AlphaRelativeLayout) titanPlayerController._$_findCachedViewById(R$id.mLayoutController)).setVisibility(8);
    }

    public static final void i2(TitanPlayerController titanPlayerController) {
        t9.i.g(titanPlayerController, "this$0");
        int i10 = R$id.mVideoViewVod;
        if (((TitanVODView) titanPlayerController._$_findCachedViewById(i10)).s()) {
            return;
        }
        titanPlayerController.j3(titanPlayerController.C);
        ((TitanVODView) titanPlayerController._$_findCachedViewById(i10)).w();
    }

    public static final void i3(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void i4(TitanPlayerController titanPlayerController, View view) {
        t9.i.g(titanPlayerController, "this$0");
        titanPlayerController.f8455c.x();
        ((AutoFrameLayout) titanPlayerController._$_findCachedViewById(R$id.mFlLocked)).setVisibility(8);
        Disposable disposable = titanPlayerController.B0;
        if (disposable != null) {
            disposable.dispose();
        }
        ((AlphaRelativeLayout) titanPlayerController._$_findCachedViewById(R$id.mLayoutController)).setVisibility(0);
        titanPlayerController.z3();
        titanPlayerController.B3();
    }

    public static final void j2(TitanPlayerController titanPlayerController) {
        t9.i.g(titanPlayerController, "this$0");
        int i10 = R$id.mVideoViewVod;
        if (((TitanVODView) titanPlayerController._$_findCachedViewById(i10)).s()) {
            return;
        }
        titanPlayerController.j3(titanPlayerController.C);
        ((TitanVODView) titanPlayerController._$_findCachedViewById(i10)).w();
    }

    public static final void j4(TitanPlayerController titanPlayerController, View view) {
        t9.i.g(titanPlayerController, "this$0");
        m6.a aVar = titanPlayerController.M;
        if (aVar != null) {
            ImageView imageView = (ImageView) titanPlayerController._$_findCachedViewById(R$id.mImageQuality);
            t9.i.f(imageView, "mImageQuality");
            aVar.t0(imageView, titanPlayerController.B2(), false);
        }
    }

    public static /* synthetic */ void k3(TitanPlayerController titanPlayerController, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = 0;
        }
        titanPlayerController.j3(j10);
    }

    public static final void k4(TitanPlayerController titanPlayerController, View view) {
        t9.i.g(titanPlayerController, "this$0");
        titanPlayerController.f2(-titanPlayerController.f8493w0);
    }

    public static /* synthetic */ void l2(TitanPlayerController titanPlayerController, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        titanPlayerController.k2(z10);
    }

    public static final void l4(TitanPlayerController titanPlayerController, View view) {
        t9.i.g(titanPlayerController, "this$0");
        titanPlayerController.f2(titanPlayerController.f8493w0);
    }

    public static final void m3(TitanPlayerController titanPlayerController, SubtitleSettingBean subtitleSettingBean, ObservableEmitter observableEmitter) {
        t9.i.g(titanPlayerController, "this$0");
        t9.i.g(subtitleSettingBean, "$subtitleSetting");
        t9.i.g(observableEmitter, "it");
        Context applicationContext = titanPlayerController.getContext().getApplicationContext();
        t9.i.f(applicationContext, "context.applicationContext");
        new MobileDao(applicationContext).addSubtitleSetting(subtitleSettingBean);
        observableEmitter.onNext(subtitleSettingBean);
        observableEmitter.onComplete();
    }

    public static final void m4(TitanPlayerController titanPlayerController, View view) {
        t9.i.g(titanPlayerController, "this$0");
        titanPlayerController.Y4();
    }

    public static final void n3(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void n4(TitanPlayerController titanPlayerController, BaseQuickAdapter baseQuickAdapter, View view, int i10) {
        t9.i.g(titanPlayerController, "this$0");
        if (i10 != titanPlayerController.f8476o) {
            titanPlayerController.I0 = true;
            titanPlayerController.p3(i10);
            Disposable disposable = titanPlayerController.C0;
            if (disposable != null) {
                disposable.dispose();
            }
            AutoFrameLayout autoFrameLayout = (AutoFrameLayout) titanPlayerController._$_findCachedViewById(R$id.mLayoutSetInfo);
            t9.i.f(autoFrameLayout, "mLayoutSetInfo");
            titanPlayerController.N4(autoFrameLayout, AutoUtils.getPercentWidthSize(580));
            titanPlayerController.E = false;
            titanPlayerController.f8463h0 = false;
            ((BeforeVodAdView) titanPlayerController._$_findCachedViewById(R$id.mBvavAd)).hideBeforeVodAd();
        }
    }

    public static final void o3(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void o4(final TitanPlayerController titanPlayerController, View view) {
        String e10;
        t9.i.g(titanPlayerController, "this$0");
        if (t9.i.b(titanPlayerController.B, "0")) {
            StringBuilder sb = new StringBuilder();
            AssetData assetData = titanPlayerController.f8458f;
            sb.append(assetData != null ? assetData.getAlias() : null);
            sb.append('_');
            SimpleProgramList simpleProgramList = titanPlayerController.f8464i;
            sb.append(simpleProgramList != null ? Integer.valueOf(simpleProgramList.getSeriesNumber()) : null);
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            AssetData assetData2 = titanPlayerController.f8458f;
            sb3.append(assetData2 != null ? assetData2.getName() : null);
            sb3.append('_');
            SimpleProgramList simpleProgramList2 = titanPlayerController.f8464i;
            sb3.append(simpleProgramList2 != null ? Integer.valueOf(simpleProgramList2.getSeriesNumber()) : null);
            e10 = com.mobile.brasiltv.utils.b0.e(sb2, sb3.toString());
        } else {
            AssetData assetData3 = titanPlayerController.f8458f;
            String valueOf = String.valueOf(assetData3 != null ? assetData3.getAlias() : null);
            AssetData assetData4 = titanPlayerController.f8458f;
            e10 = com.mobile.brasiltv.utils.b0.e(valueOf, String.valueOf(assetData4 != null ? assetData4.getName() : null));
        }
        CommonDialog feedBackDialog = FeedBackDialog.Companion.getFeedBackDialog(titanPlayerController.getMActivity(), titanPlayerController.f8455c.l(), 1, e10);
        titanPlayerController.A0 = feedBackDialog;
        if (feedBackDialog != null) {
            feedBackDialog.show();
        }
        CommonDialog commonDialog = titanPlayerController.A0;
        if (commonDialog != null) {
            commonDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: m6.g1
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    TitanPlayerController.p4(TitanPlayerController.this, dialogInterface);
                }
            });
        }
    }

    public static final void p4(TitanPlayerController titanPlayerController, DialogInterface dialogInterface) {
        t9.i.g(titanPlayerController, "this$0");
        titanPlayerController.A0 = null;
    }

    public static final void q4(TitanPlayerController titanPlayerController, View view) {
        t9.i.g(titanPlayerController, "this$0");
        i1.I(titanPlayerController.getContext(), "vodFullScreen");
        com.mobile.brasiltv.utils.b0.j0(titanPlayerController.getMActivity(), w6.i.f19214g.C() + "/#/shareApp", false, true, false, false, 24, null);
    }

    public static final void r2(s9.l lVar, Object obj) {
        t9.i.g(lVar, "$tmp0");
        lVar.invoke(obj);
    }

    public static final void r4(TitanPlayerController titanPlayerController, View view) {
        t9.i.g(titanPlayerController, "this$0");
    }

    public static final void s3(TitanPlayerController titanPlayerController, View view) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String buss;
        String lang;
        List<Media> medias;
        t9.i.g(titanPlayerController, "this$0");
        com.mobile.brasiltv.utils.h hVar = com.mobile.brasiltv.utils.h.f8694a;
        if (!t9.i.b(hVar.a(), hVar.k())) {
            if (t9.i.b(hVar.a(), hVar.l())) {
                titanPlayerController.N.k();
                return;
            }
            return;
        }
        com.mobile.brasiltv.utils.g gVar = com.mobile.brasiltv.utils.g.f8651a;
        if (gVar.m()) {
            gVar.p();
            return;
        }
        if (gVar.l()) {
            gVar.r();
            return;
        }
        if (gVar.j()) {
            Program program = titanPlayerController.E0;
            Media media = (program == null || (medias = program.getMedias()) == null) ? null : medias.get(0);
            titanPlayerController.Q4();
            String T4 = titanPlayerController.f8479p0 ? titanPlayerController.T4(hVar.e(), "dlna") : hVar.e();
            Program program2 = titanPlayerController.E0;
            if (program2 == null || (str = program2.getMedia()) == null) {
                str = "";
            }
            Program program3 = titanPlayerController.E0;
            if (program3 == null || (str2 = program3.getName()) == null) {
                str2 = "";
            }
            Program program4 = titanPlayerController.E0;
            if (program4 == null || (str3 = program4.getTitle()) == null) {
                str3 = "";
            }
            Program program5 = titanPlayerController.E0;
            if (program5 == null || (str4 = program5.getEpisode()) == null) {
                str4 = "";
            }
            Program program6 = titanPlayerController.E0;
            if (program6 == null || (str5 = program6.getBuss()) == null) {
                str5 = "";
            }
            if (media == null || (str6 = media.getFormat()) == null) {
                str6 = "";
            }
            if (media == null || (str7 = media.getVcodec()) == null) {
                str7 = "";
            }
            if (media == null || (str8 = media.getQuality()) == null) {
                str8 = "";
            }
            String str9 = (media == null || (lang = media.getLang()) == null) ? "" : lang;
            Program program7 = titanPlayerController.E0;
            String str10 = (program7 == null || (buss = program7.getBuss()) == null) ? "" : buss;
            String str11 = titanPlayerController.f8481q0;
            gVar.E(T4, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, 0L, str11 == null ? "" : str11, titanPlayerController.f8479p0);
        }
    }

    public static final void s4(TitanPlayerController titanPlayerController, View view) {
        t9.i.g(titanPlayerController, "this$0");
        m6.a aVar = titanPlayerController.M;
        if (aVar != null) {
            ImageView imageView = (ImageView) titanPlayerController._$_findCachedViewById(R$id.mImageQuality);
            t9.i.f(imageView, "mImageQuality");
            aVar.t0(imageView, titanPlayerController.B2(), false);
        }
    }

    private final void setClickAdOnBeforePlaySeries(String str) {
        ((BeforeVodAdView) _$_findCachedViewById(R$id.mBvavAd)).setBeforeVodCallback(new u());
    }

    private final void setDefaultSubtitleOption(List<SubTitleData> list) {
        String str;
        String contentId;
        String str2;
        String str3;
        String str4;
        this.f8467j0 = -1;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        StringBuilder sb = new StringBuilder();
        sb.append("list:");
        sb.append(list);
        String str5 = "";
        if (com.mobile.brasiltv.utils.b0.I(list)) {
            SubtitleManager subtitleManager = SubtitleManager.INSTANCE;
            LruCache<String, Boolean> mLruCacheSwitch = subtitleManager.getMLruCacheSwitch();
            AssetData assetData = this.f8458f;
            if (assetData == null || (str2 = assetData.getContentId()) == null) {
                str2 = "";
            }
            Boolean bool = mLruCacheSwitch.get(str2);
            if (bool != null) {
                boolean booleanValue = bool.booleanValue();
                this.f8473m0 = booleanValue;
                if (booleanValue) {
                    HashMap<String, RecordSubtitleInfoBean> mLruCacheLanguages = subtitleManager.getMLruCacheLanguages();
                    AssetData assetData2 = this.f8458f;
                    if (assetData2 == null || (str3 = assetData2.getContentId()) == null) {
                        str3 = "";
                    }
                    RecordSubtitleInfoBean recordSubtitleInfoBean = mLruCacheLanguages.get(str3);
                    Integer valueOf = recordSubtitleInfoBean != null ? Integer.valueOf(recordSubtitleInfoBean.getSubtitleIndex()) : null;
                    HashMap<String, RecordSubtitleInfoBean> mLruCacheLanguages2 = subtitleManager.getMLruCacheLanguages();
                    AssetData assetData3 = this.f8458f;
                    if (assetData3 == null || (str4 = assetData3.getContentId()) == null) {
                        str4 = "";
                    }
                    RecordSubtitleInfoBean recordSubtitleInfoBean2 = mLruCacheLanguages2.get(str4);
                    String subTitleLanguage = recordSubtitleInfoBean2 != null ? recordSubtitleInfoBean2.getSubTitleLanguage() : null;
                    if (valueOf == null || valueOf.intValue() >= list.size()) {
                        Observable observeOn = Observable.create(new ObservableOnSubscribe() { // from class: m6.t0
                            @Override // io.reactivex.ObservableOnSubscribe
                            public final void subscribe(ObservableEmitter observableEmitter) {
                                TitanPlayerController.I3(TitanPlayerController.this, observableEmitter);
                            }
                        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
                        final a0 a0Var = new a0(list, arrayList, arrayList2, this);
                        Consumer consumer = new Consumer() { // from class: m6.t1
                            @Override // io.reactivex.functions.Consumer
                            public final void accept(Object obj) {
                                TitanPlayerController.J3(s9.l.this, obj);
                            }
                        };
                        final b0 b0Var = b0.f8510a;
                        observeOn.subscribe(consumer, new Consumer() { // from class: m6.u1
                            @Override // io.reactivex.functions.Consumer
                            public final void accept(Object obj) {
                                TitanPlayerController.K3(s9.l.this, obj);
                            }
                        });
                    } else {
                        SubTitleData subTitleData = (SubTitleData) i9.r.u(list, valueOf.intValue());
                        if (t9.i.b(subTitleData != null ? subTitleData.getLanguage() : null, subTitleLanguage)) {
                            this.f8467j0 = valueOf.intValue();
                        } else {
                            k7.f.c("字幕信息有变化 cacheLanguage : " + subTitleLanguage, new Object[0]);
                            int i10 = 0;
                            for (Object obj : list) {
                                int i11 = i10 + 1;
                                if (i10 < 0) {
                                    i9.j.j();
                                }
                                if (((SubTitleData) obj).getLanguage().equals(subTitleLanguage)) {
                                    arrayList2.add(Integer.valueOf(i10));
                                    if (i10 == valueOf.intValue()) {
                                        arrayList.add(Integer.valueOf(i10));
                                    }
                                }
                                i10 = i11;
                            }
                            if (arrayList.isEmpty()) {
                                if (com.mobile.brasiltv.utils.b0.I(arrayList2)) {
                                    Object obj2 = arrayList2.get(0);
                                    t9.i.f(obj2, "sameLanguage[0]");
                                    this.f8467j0 = ((Number) obj2).intValue();
                                } else {
                                    this.f8467j0 = 0;
                                }
                            }
                        }
                    }
                }
            } else {
                Observable observeOn2 = Observable.create(new ObservableOnSubscribe() { // from class: m6.v1
                    @Override // io.reactivex.ObservableOnSubscribe
                    public final void subscribe(ObservableEmitter observableEmitter) {
                        TitanPlayerController.L3(TitanPlayerController.this, observableEmitter);
                    }
                }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
                final c0 c0Var = new c0(list, arrayList, arrayList2);
                Consumer consumer2 = new Consumer() { // from class: m6.c
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj3) {
                        TitanPlayerController.M3(s9.l.this, obj3);
                    }
                };
                final d0 d0Var = d0.f8520a;
                observeOn2.subscribe(consumer2, new Consumer() { // from class: m6.d
                    @Override // io.reactivex.functions.Consumer
                    public final void accept(Object obj3) {
                        TitanPlayerController.N3(s9.l.this, obj3);
                    }
                });
            }
        } else {
            this.f8467j0 = -1;
            this.f8473m0 = false;
        }
        SubtitleManager subtitleManager2 = SubtitleManager.INSTANCE;
        LruCache<String, Integer> mLruCacheSize = subtitleManager2.getMLruCacheSize();
        AssetData assetData4 = this.f8458f;
        if (assetData4 == null || (str = assetData4.getContentId()) == null) {
            str = "";
        }
        Integer num = mLruCacheSize.get(str);
        if (num == null || num.intValue() >= getSizeList().size()) {
            Observable observeOn3 = Observable.create(new ObservableOnSubscribe() { // from class: m6.e
                @Override // io.reactivex.ObservableOnSubscribe
                public final void subscribe(ObservableEmitter observableEmitter) {
                    TitanPlayerController.O3(TitanPlayerController.this, observableEmitter);
                }
            }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            final e0 e0Var = new e0();
            Consumer consumer3 = new Consumer() { // from class: m6.f
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj3) {
                    TitanPlayerController.D3(s9.l.this, obj3);
                }
            };
            final x xVar = x.f8557a;
            observeOn3.subscribe(consumer3, new Consumer() { // from class: m6.g
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj3) {
                    TitanPlayerController.E3(s9.l.this, obj3);
                }
            });
        } else {
            this.f8469k0 = num.intValue();
        }
        LruCache<String, Integer> mLruCacheColor = subtitleManager2.getMLruCacheColor();
        AssetData assetData5 = this.f8458f;
        if (assetData5 != null && (contentId = assetData5.getContentId()) != null) {
            str5 = contentId;
        }
        Integer num2 = mLruCacheColor.get(str5);
        if (num2 != null && num2.intValue() < getStyleList().size()) {
            this.f8471l0 = num2.intValue();
            return;
        }
        Observable observeOn4 = Observable.create(new ObservableOnSubscribe() { // from class: m6.h
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                TitanPlayerController.F3(TitanPlayerController.this, observableEmitter);
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
        final y yVar = new y();
        Consumer consumer4 = new Consumer() { // from class: m6.e1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj3) {
                TitanPlayerController.G3(s9.l.this, obj3);
            }
        };
        final z zVar = z.f8559a;
        observeOn4.subscribe(consumer4, new Consumer() { // from class: m6.p1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj3) {
                TitanPlayerController.H3(s9.l.this, obj3);
            }
        });
    }

    private final void setFullScreenAttr(boolean z10) {
        WindowManager.LayoutParams attributes;
        if (z10) {
            Window window = getMActivity().getWindow();
            attributes = window != null ? window.getAttributes() : null;
            if (attributes != null) {
                attributes.flags |= 1024;
                Window window2 = getMActivity().getWindow();
                if (window2 == null) {
                    return;
                }
                window2.setAttributes(attributes);
                return;
            }
            return;
        }
        Window window3 = getMActivity().getWindow();
        attributes = window3 != null ? window3.getAttributes() : null;
        if (attributes != null) {
            attributes.flags &= -1025;
            Window window4 = getMActivity().getWindow();
            if (window4 == null) {
                return;
            }
            window4.setAttributes(attributes);
        }
    }

    private final void setSeekBarClickable(boolean z10) {
        if (z10) {
            int i10 = R$id.mSeekBar;
            ((CurTimeSeekBar) _$_findCachedViewById(i10)).setClickable(true);
            ((CurTimeSeekBar) _$_findCachedViewById(i10)).setEnabled(true);
            ((CurTimeSeekBar) _$_findCachedViewById(i10)).setFocusable(true);
            return;
        }
        int i11 = R$id.mSeekBar;
        ((CurTimeSeekBar) _$_findCachedViewById(i11)).setClickable(false);
        ((CurTimeSeekBar) _$_findCachedViewById(i11)).setEnabled(false);
        ((CurTimeSeekBar) _$_findCachedViewById(i11)).setFocusable(false);
    }

    private final void setStage(final int i10) {
        Disposable disposable = this.Q;
        if (disposable != null) {
            disposable.dispose();
        }
        Observable compose = Observable.create(new ObservableOnSubscribe() { // from class: m6.b
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                TitanPlayerController.W3(TitanPlayerController.this, i10, observableEmitter);
            }
        }).compose(com.mobile.brasiltv.utils.p0.a());
        final j0 j0Var = new j0();
        Consumer consumer = new Consumer() { // from class: m6.m
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TitanPlayerController.X3(s9.l.this, obj);
            }
        };
        final k0 k0Var = new k0();
        this.Q = compose.subscribe(consumer, new Consumer() { // from class: m6.x
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TitanPlayerController.Y3(s9.l.this, obj);
            }
        });
    }

    public static final void t3(TitanPlayerController titanPlayerController, View view) {
        t9.i.g(titanPlayerController, "this$0");
        m6.a aVar = titanPlayerController.M;
        if (aVar != null) {
            t9.i.f(view, "it");
            aVar.t0(view, titanPlayerController.B2(), true);
        }
    }

    public static final void t4(TitanPlayerController titanPlayerController, View view) {
        String str;
        TitanVODView titanVODView;
        t9.i.g(titanPlayerController, "this$0");
        titanPlayerController.w2();
        k3(titanPlayerController, 0L, 1, null);
        int i10 = R$id.mVideoViewVod;
        n8.b titanContext = ((TitanVODView) titanPlayerController._$_findCachedViewById(i10)).getTitanContext();
        titanPlayerController.E0 = titanContext != null ? titanContext.h() : null;
        n8.b titanContext2 = ((TitanVODView) titanPlayerController._$_findCachedViewById(i10)).getTitanContext();
        if ((titanContext2 != null ? titanContext2.h() : null) != null) {
            ((TitanVODView) titanPlayerController._$_findCachedViewById(i10)).D();
            titanPlayerController.W = false;
        }
        n8.b titanContext3 = ((TitanVODView) titanPlayerController._$_findCachedViewById(i10)).getTitanContext();
        if ((titanContext3 != null ? titanContext3.a() : null) != null && (titanVODView = (TitanVODView) titanPlayerController._$_findCachedViewById(i10)) != null) {
            titanVODView.C();
        }
        Program program = titanPlayerController.E0;
        if (program != null) {
            titanPlayerController.c3();
            TitanVODView titanVODView2 = (TitanVODView) titanPlayerController._$_findCachedViewById(i10);
            Program program2 = titanPlayerController.E0;
            if (program2 == null || (str = program2.getBuss()) == null) {
                str = "";
            }
            titanVODView2.v(program, str);
        }
        com.mobile.brasiltv.utils.h.f8694a.K(false);
        m6.a aVar = titanPlayerController.M;
        if (aVar != null) {
            ImageView imageView = (ImageView) titanPlayerController._$_findCachedViewById(R$id.mImageQuality);
            t9.i.f(imageView, "mImageQuality");
            aVar.z(imageView, titanPlayerController.B2(), titanPlayerController.f8462h);
        }
    }

    public static final void u3(TitanPlayerController titanPlayerController, View view) {
        m6.a aVar;
        t9.i.g(titanPlayerController, "this$0");
        com.mobile.brasiltv.utils.h hVar = com.mobile.brasiltv.utils.h.f8694a;
        if (t9.i.b(hVar.a(), hVar.k())) {
            if (hVar.t()) {
                com.mobile.brasiltv.utils.g.f8651a.G();
                hVar.v(false);
            }
        } else if (t9.i.b(hVar.a(), hVar.l())) {
            titanPlayerController.N.r();
            titanPlayerController.N.s();
        }
        int i10 = R$id.mVideoViewVod;
        n8.b titanContext = ((TitanVODView) titanPlayerController._$_findCachedViewById(i10)).getTitanContext();
        if ((titanContext != null ? titanContext.a() : null) != null) {
            ((TitanVODView) titanPlayerController._$_findCachedViewById(i10)).C();
        }
        titanPlayerController.j3(titanPlayerController.W2() * 1000);
        xa.c.c().j(new CastToCloseFloatViewEvent());
        V1(titanPlayerController, true, false, 2, null);
        n8.b titanContext2 = ((TitanVODView) titanPlayerController._$_findCachedViewById(i10)).getTitanContext();
        if ((titanContext2 != null ? titanContext2.h() : null) != null || (aVar = titanPlayerController.M) == null) {
            return;
        }
        aVar.m();
    }

    public static final void u4(TitanPlayerController titanPlayerController, View view) {
        t9.i.g(titanPlayerController, "this$0");
        Context context = titanPlayerController.getContext();
        if (context != null) {
            com.mobile.brasiltv.utils.b0.l(context);
        }
    }

    public static final void v3(TitanPlayerController titanPlayerController, View view) {
        t9.i.g(titanPlayerController, "this$0");
        xa.c.c().j(new CastToCloseOtherPlayEvent("VOD", false, 2, null));
        Context context = titanPlayerController.getContext();
        t9.i.e(context, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
        com.mobile.brasiltv.utils.b0.d0((f5.c) context, CastByNativeDeviceAty.class, s.f8548a);
    }

    public static final void v4(TitanPlayerController titanPlayerController, View view) {
        t9.i.g(titanPlayerController, "this$0");
        titanPlayerController.getSubtitleAudioPorWindow().setWidth(-1);
        titanPlayerController.getSubtitleAudioPorWindow().setHeight(-2);
        titanPlayerController.getSubtitleAudioPorWindow().c(true);
        titanPlayerController.getSubtitleAudioPorWindow().s(titanPlayerController.f8475n0, titanPlayerController.f8467j0 + 1, titanPlayerController.f8469k0, titanPlayerController.f8471l0, titanPlayerController.f8473m0);
    }

    public static final void w3(TitanPlayerController titanPlayerController, View view) {
        t9.i.g(titanPlayerController, "this$0");
        Context context = titanPlayerController.getContext();
        t9.i.f(context, com.umeng.analytics.pro.f.X);
        new CastFeedBackDialog(context).show();
    }

    public static final boolean w4(TitanPlayerController titanPlayerController, View view, MotionEvent motionEvent) {
        t9.i.g(titanPlayerController, "this$0");
        titanPlayerController.b2();
        return false;
    }

    public static final void x4(TitanPlayerController titanPlayerController, View view) {
        t9.i.g(titanPlayerController, "this$0");
        AutoFrameLayout autoFrameLayout = (AutoFrameLayout) titanPlayerController._$_findCachedViewById(R$id.mLayoutSetInfo);
        t9.i.f(autoFrameLayout, "mLayoutSetInfo");
        titanPlayerController.N4(autoFrameLayout, AutoUtils.getPercentWidthSize(580));
    }

    public static final void y3(TitanPlayerController titanPlayerController, View view) {
        String str;
        TitanVODView titanVODView;
        t9.i.g(titanPlayerController, "this$0");
        com.mobile.brasiltv.utils.h hVar = com.mobile.brasiltv.utils.h.f8694a;
        hVar.K(false);
        int i10 = R$id.mVideoViewVod;
        n8.b titanContext = ((TitanVODView) titanPlayerController._$_findCachedViewById(i10)).getTitanContext();
        if ((titanContext != null ? titanContext.a() : null) != null && (titanVODView = (TitanVODView) titanPlayerController._$_findCachedViewById(i10)) != null) {
            titanVODView.C();
        }
        Program program = titanPlayerController.E0;
        if (program != null) {
            TitanVODView titanVODView2 = (TitanVODView) titanPlayerController._$_findCachedViewById(i10);
            Program program2 = titanPlayerController.E0;
            if (program2 == null || (str = program2.getBuss()) == null) {
                str = "";
            }
            titanVODView2.v(program, str);
        }
        if (hVar.e() != null) {
            xa.c.c().j(new CastToCloseOtherPlayEvent("VOD", false));
            Context context = titanPlayerController.getContext();
            t9.i.e(context, "null cannot be cast to non-null type com.mobile.brasiltv.activity.BaseActivity");
            com.mobile.brasiltv.utils.b0.d0((f5.c) context, CastByNativeDeviceAty.class, v.f8554a);
        }
    }

    public final void A2(boolean z10) {
        this.F = z10;
        this.G = true;
        this.f8464i = null;
        int i10 = R$id.mLayoutController;
        ((AlphaRelativeLayout) _$_findCachedViewById(i10)).setVisibilitySwitch(true);
        ((AlphaRelativeLayout) _$_findCachedViewById(i10)).setVisibility(8);
        ((AlphaRelativeLayout) _$_findCachedViewById(i10)).enableProxyVisibility(false);
        ((RelativeLayout) _$_findCachedViewById(R$id.mBufferView)).setVisibility(8);
        ((AutoRelativeLayout) _$_findCachedViewById(R$id.mMemberTipsLayout)).setVisibility(8);
        ((TextView) _$_findCachedViewById(R$id.mTvCastRecommendHint)).setText(Html.fromHtml(getResources().getString(R.string.cast_recommend_hint)));
        _$_findCachedViewById(R$id.mLlBrightnessController).setVisibility(8);
        _$_findCachedViewById(R$id.mLlVolumeController).setVisibility(8);
    }

    public final void A3() {
        if (s6.a.f18777a.a().s()) {
            setVodQualityVisibility(0);
        }
        Context context = getContext();
        t9.i.e(context, "null cannot be cast to non-null type com.mobile.brasiltv.activity.PlayAty");
        o6.b j32 = ((PlayAty) context).j3();
        if (t9.i.b(j32, o6.c.c())) {
            y4(R.drawable.ic_quality_480p, R.drawable.ic_quality_480p_portrait);
            PlayAty.G.d("1");
        } else if (t9.i.b(j32, o6.c.b())) {
            y4(R.drawable.ic_quality_720p, R.drawable.ic_quality_720p_portrait);
            PlayAty.G.d("2");
        } else if (!t9.i.b(j32, o6.c.a())) {
            y4(0, 0);
        } else {
            y4(R.drawable.ic_quality_1080p, R.drawable.ic_quality_1080p_portrait);
            PlayAty.G.d("3");
        }
    }

    public final void A4(int i10, String str) {
        t9.i.g(str, "extra");
        xa.c.c().j(new CastToCloseFloatViewEvent());
        if (com.mobile.brasiltv.utils.b0.K(str)) {
            ((TextView) _$_findCachedViewById(R$id.mTvCastRecommendHint)).setVisibility(4);
            int i11 = R$id.mTvCastErrorHint;
            ((TextView) _$_findCachedViewById(i11)).setText(str);
            ((TextView) _$_findCachedViewById(i11)).setVisibility(0);
        } else {
            ((TextView) _$_findCachedViewById(R$id.mTvCastRecommendHint)).setVisibility(0);
            ((TextView) _$_findCachedViewById(R$id.mTvCastErrorHint)).setVisibility(8);
        }
        int i12 = R$id.mTvCastState;
        ((TextView) _$_findCachedViewById(i12)).setText(getContext().getResources().getString(R.string.cast_status_casting_failed));
        TextView textView = (TextView) _$_findCachedViewById(i12);
        StringBuilder sb = new StringBuilder();
        sb.append(ASCIIPropertyListParser.ARRAY_BEGIN_TOKEN);
        sb.append(i10);
        sb.append(ASCIIPropertyListParser.ARRAY_END_TOKEN);
        textView.append(sb.toString());
        ((TextView) _$_findCachedViewById(i12)).setTextColor(getContext().getResources().getColor(R.color.color_f72f2f));
        ((TextView) _$_findCachedViewById(R$id.mTvPleaseWait)).setVisibility(8);
        ((ImageView) _$_findCachedViewById(R$id.mImagePlayCast)).setImageResource(R.drawable.icon_play_white);
    }

    public final boolean B2() {
        return this.f8455c.l() || getMActivity().getResources().getConfiguration().orientation == 2;
    }

    public final void B3() {
        ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(R$id.mPbVolume);
        b8.b bVar = this.f8456d;
        b8.b bVar2 = null;
        if (bVar == null) {
            t9.i.w("mVoiceHelper");
            bVar = null;
        }
        int d10 = 100 * bVar.d();
        b8.b bVar3 = this.f8456d;
        if (bVar3 == null) {
            t9.i.w("mVoiceHelper");
        } else {
            bVar2 = bVar3;
        }
        progressBar.setProgress(d10 / bVar2.e());
    }

    public final void B4(String str) {
        t9.i.g(str, "errorMessage");
        int i10 = R$id.tvPlayTips;
        ((TextView) _$_findCachedViewById(i10)).setVisibility(0);
        ((TextView) _$_findCachedViewById(i10)).setText(str);
        ((TextView) _$_findCachedViewById(i10)).postDelayed(new Runnable() { // from class: m6.j1
            @Override // java.lang.Runnable
            public final void run() {
                TitanPlayerController.C4(TitanPlayerController.this);
            }
        }, 4000L);
    }

    @Override // o8.a
    public void C1() {
        int i10 = R$id.mVideoViewVod;
        if (((TitanVODView) _$_findCachedViewById(i10)).s() || !this.V) {
            return;
        }
        ((TitanVODView) _$_findCachedViewById(i10)).w();
    }

    public final boolean C2(String str, String str2) {
        return t9.i.b(str, IjkMediaFormat.CODEC_NAME_H264) && t9.i.b(str2, "mp4");
    }

    public final void C3() {
        ((BeforeVodAdView) _$_findCachedViewById(R$id.mBvavAd)).setBeforeVodCallback(new w());
    }

    public final void D2() {
        Disposable disposable = this.B0;
        if (disposable != null) {
            disposable.dispose();
        }
        Observable<Long> observeOn = Observable.timer(5L, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread());
        final j jVar = new j();
        Consumer<? super Long> consumer = new Consumer() { // from class: m6.h1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TitanPlayerController.E2(s9.l.this, obj);
            }
        };
        final k kVar = k.f8533a;
        this.B0 = observeOn.subscribe(consumer, new Consumer() { // from class: m6.i1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TitanPlayerController.F2(s9.l.this, obj);
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0031, code lost:
    
        if ((r3 != null && r3.getHeight() == 0) != false) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void D4(boolean r3) {
        /*
            r2 = this;
            if (r3 == 0) goto L4a
            boolean r3 = r2.B2()
            if (r3 == 0) goto L4a
            com.mobile.brasiltv.view.adView.PauseAdView r3 = r2.A
            if (r3 == 0) goto L11
            android.view.ViewParent r3 = r3.getParent()
            goto L12
        L11:
            r3 = 0
        L12:
            r0 = 0
            if (r3 == 0) goto L33
            com.mobile.brasiltv.view.adView.PauseAdView r3 = r2.A
            r1 = 1
            if (r3 == 0) goto L22
            int r3 = r3.getWidth()
            if (r3 != 0) goto L22
            r3 = 1
            goto L23
        L22:
            r3 = 0
        L23:
            if (r3 == 0) goto L4a
            com.mobile.brasiltv.view.adView.PauseAdView r3 = r2.A
            if (r3 == 0) goto L30
            int r3 = r3.getHeight()
            if (r3 != 0) goto L30
            goto L31
        L30:
            r1 = 0
        L31:
            if (r1 == 0) goto L4a
        L33:
            int r3 = com.mobile.brasiltv.R$id.mIvFastForward
            android.view.View r3 = r2._$_findCachedViewById(r3)
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            r3.setVisibility(r0)
            int r3 = com.mobile.brasiltv.R$id.mIvFastRewind
            android.view.View r3 = r2._$_findCachedViewById(r3)
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            r3.setVisibility(r0)
            goto L62
        L4a:
            int r3 = com.mobile.brasiltv.R$id.mIvFastForward
            android.view.View r3 = r2._$_findCachedViewById(r3)
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            r0 = 8
            r3.setVisibility(r0)
            int r3 = com.mobile.brasiltv.R$id.mIvFastRewind
            android.view.View r3 = r2._$_findCachedViewById(r3)
            android.widget.ImageView r3 = (android.widget.ImageView) r3
            r3.setVisibility(r0)
        L62:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.player.TitanPlayerController.D4(boolean):void");
    }

    public final void E4() {
        VodGestureGuideManager vodGestureGuideManager = new VodGestureGuideManager(getContext());
        if (vodGestureGuideManager.isShow()) {
            P4(true);
            vodGestureGuideManager.setGuideNextClickListener(new q0());
            vodGestureGuideManager.showGuide();
        }
    }

    @Override // o8.a
    public void F1() {
    }

    public final void F4() {
        PauseAdView pauseAdView = this.A;
        if (pauseAdView != null) {
            if ((pauseAdView != null ? pauseAdView.getParent() : null) == null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 17;
                addView(this.A, layoutParams);
            }
        }
    }

    @Override // o8.a
    public void G0(long j10) {
        U3();
        int i10 = R$id.mSeekBar;
        ((CurTimeSeekBar) _$_findCachedViewById(i10)).setProgress((int) j10);
        ((CurTimeSeekBar) _$_findCachedViewById(i10)).setMax((int) ((TitanVODView) _$_findCachedViewById(R$id.mVideoViewVod)).getDuration());
        if (((CurTimeSeekBar) _$_findCachedViewById(i10)).getMax() > 0) {
            setSeekBarClickable(true);
        }
        if (((CurTimeSeekBar) _$_findCachedViewById(i10)).getProgress() != ((CurTimeSeekBar) _$_findCachedViewById(i10)).getMax()) {
            this.D = false;
        }
        if (j10 == 0 || this.D) {
            return;
        }
        this.C = j10;
    }

    public final void G2(float f10) {
        int i10 = R$id.mLayoutController;
        if (((AlphaRelativeLayout) _$_findCachedViewById(i10)).getVisibility() == 8) {
            ((AlphaRelativeLayout) _$_findCachedViewById(i10)).setVisibility(0);
            z3();
            B3();
        }
        ((AlphaRelativeLayout) _$_findCachedViewById(i10)).setTag(Boolean.TRUE);
        ((AlphaRelativeLayout) _$_findCachedViewById(i10)).delayHide();
        WindowManager.LayoutParams attributes = getMActivity().getWindow().getAttributes();
        float realCurBrightness = getRealCurBrightness() + f10;
        if (realCurBrightness > 1.0f) {
            realCurBrightness = 1.0f;
        } else if (realCurBrightness < 0.0f) {
            realCurBrightness = 0.0f;
        }
        attributes.screenBrightness = realCurBrightness;
        getMActivity().getWindow().setAttributes(attributes);
        ((ProgressBar) _$_findCachedViewById(R$id.mPbBrightness)).setProgress((int) (realCurBrightness * 100));
    }

    public final void G4() {
        int i10 = R$id.mPlayPauseIcon;
        ((ImageView) _$_findCachedViewById(i10)).setVisibility(0);
        ((ImageView) _$_findCachedViewById(i10)).setImageResource(R.drawable.ic_vod_to_pause);
        D4(true);
    }

    @Override // o8.a
    public void H1() {
    }

    @Override // o8.a
    public void H2() {
    }

    public final void H4() {
        int i10 = R$id.mPlayPauseIcon;
        ((ImageView) _$_findCachedViewById(i10)).setVisibility(0);
        ((ImageView) _$_findCachedViewById(i10)).setImageResource(R.drawable.ic_vod_to_play);
        D4(true);
    }

    @Override // o8.a
    public void I1(Bitmap bitmap) {
        t9.i.g(bitmap, "bitmap");
    }

    public final void I2() {
        post(new Runnable() { // from class: m6.f0
            @Override // java.lang.Runnable
            public final void run() {
                TitanPlayerController.J2(TitanPlayerController.this);
            }
        });
    }

    public final void I4() {
        int i10 = R$id.mPlayPauseIcon;
        ((ImageView) _$_findCachedViewById(i10)).setVisibility(0);
        ((ImageView) _$_findCachedViewById(i10)).setImageResource(R.drawable.ic_vod_to_play);
        D4(true);
    }

    public final void J4() {
        if (B2()) {
            return;
        }
        int i10 = R$id.mIvSubtitleAudio;
        if (((ImageView) _$_findCachedViewById(i10)).getVisibility() != 0 || ((BeforeVodAdView) _$_findCachedViewById(R$id.mBvavAd)).getVisibility() == 0) {
            return;
        }
        Context context = getContext();
        ImageView imageView = (ImageView) _$_findCachedViewById(i10);
        String string = getContext().getString(R.string.guide_vod_subtitle);
        t9.i.f(string, "context.getString(R.string.guide_vod_subtitle)");
        final BaseGuideManager baseGuideManager = new BaseGuideManager(context, imageView, "keyFirstEnterVodDetail", string, GuideDialog.Direction.TOP_RIGHT, getContext().getString(R.string.next_step), false, false, null, 448, null);
        if (!baseGuideManager.isShow()) {
            xa.c.c().j(new ShowVodSharingGuideEvent());
            return;
        }
        int i11 = R$id.mLayoutController;
        ((AlphaRelativeLayout) _$_findCachedViewById(i11)).setVisibility(0);
        ((AlphaRelativeLayout) _$_findCachedViewById(i11)).cancelDalayHide();
        P4(false);
        baseGuideManager.setGuideNextClickListener(new r0());
        ((ImageView) _$_findCachedViewById(i10)).postDelayed(new Runnable() { // from class: m6.q
            @Override // java.lang.Runnable
            public final void run() {
                TitanPlayerController.K4(TitanPlayerController.this, baseGuideManager);
            }
        }, 50L);
    }

    @Override // o8.a
    public void K0() {
    }

    @Override // z5.c.d
    public void L0() {
    }

    @Override // z5.c.d
    public void L1(int i10) {
        ((ImageView) _$_findCachedViewById(R$id.mImagePlayCast)).setImageResource(R.drawable.icon_play_white);
        h2(i10);
    }

    public final void L4(View view, int i10) {
        x6.a.a(view, i10);
    }

    public final void M4() {
        this.f8455c.d();
    }

    @Override // z5.c.e
    public void N1(long j10, long j11) {
        TextView textView;
        long j12 = 1000;
        long j13 = j11 / j12;
        long j14 = j10 / j12;
        int i10 = R$id.mSeekBarCast;
        int i11 = (int) j13;
        if (((SeekBar) _$_findCachedViewById(i10)).getMax() != i11) {
            ((SeekBar) _$_findCachedViewById(i10)).setMax(i11);
        }
        ((SeekBar) _$_findCachedViewById(i10)).setProgress((int) j14);
        String l10 = y6.a.l(j13);
        String l11 = y6.a.l(j14);
        int i12 = R$id.mTextTotalTimeCast;
        TextView textView2 = (TextView) _$_findCachedViewById(i12);
        if (!t9.i.b(textView2 != null ? textView2.getText() : null, '/' + l10) && (textView = (TextView) _$_findCachedViewById(i12)) != null) {
            textView.setText('/' + l10);
        }
        TextView textView3 = (TextView) _$_findCachedViewById(R$id.mTextCurTimeCast);
        if (textView3 != null) {
            textView3.setText(l11);
        }
        this.C = j14 * j12;
    }

    public final void N4(View view, int i10) {
        x6.a.b(view, i10);
    }

    @Override // o8.a
    public void O1() {
    }

    public final void O4() {
        if (this.O.length() > 0) {
            com.mobile.brasiltv.utils.h hVar = com.mobile.brasiltv.utils.h.f8694a;
            if (!(hVar.a().length() > 0) || t9.i.b(this.O, hVar.a())) {
                return;
            }
            if (t9.i.b(this.O, hVar.k())) {
                com.mobile.brasiltv.utils.g gVar = com.mobile.brasiltv.utils.g.f8651a;
                gVar.w(null);
                if (hVar.t()) {
                    gVar.G();
                    return;
                }
                return;
            }
            if (t9.i.b(this.O, hVar.l())) {
                this.N.s();
                this.N.o();
                this.N.r();
            }
        }
    }

    public final void P1() {
        ((AlphaRelativeLayout) _$_findCachedViewById(R$id.mLayoutController)).setVisibilitySwitch(false);
    }

    public final void P2(float f10) {
        if (this.D) {
            this.D = false;
        }
        int i10 = R$id.mVideoViewVod;
        int duration = (int) (((TitanVODView) _$_findCachedViewById(i10)).getDuration() * f10);
        if (f10 > 0.0f) {
            ((ImageView) _$_findCachedViewById(R$id.mImgGesture)).setImageResource(R.drawable.bg_video_speed);
        } else {
            ((ImageView) _$_findCachedViewById(R$id.mImgGesture)).setImageResource(R.drawable.bg_video_foward);
        }
        ((FrameLayout) _$_findCachedViewById(R$id.mLayoutGesture)).setVisibility(0);
        int i11 = R$id.mTextGesture;
        ((TextView) _$_findCachedViewById(i11)).setVisibility(0);
        this.f8472m = true;
        int currentProgress = duration + ((int) ((TitanVODView) _$_findCachedViewById(i10)).getCurrentProgress());
        this.f8474n = currentProgress;
        if (currentProgress <= 0) {
            ((TextView) _$_findCachedViewById(i11)).setText("00:00/" + ((Object) ((TextView) _$_findCachedViewById(R$id.mTextTotalTime)).getText()));
        } else if (currentProgress > ((TitanVODView) _$_findCachedViewById(i10)).getDuration()) {
            TextView textView = (TextView) _$_findCachedViewById(i11);
            StringBuilder sb = new StringBuilder();
            int i12 = R$id.mTextTotalTime;
            sb.append((Object) ((TextView) _$_findCachedViewById(i12)).getText());
            sb.append('/');
            sb.append((Object) ((TextView) _$_findCachedViewById(i12)).getText());
            textView.setText(sb.toString());
        } else {
            ((TextView) _$_findCachedViewById(i11)).setText(y6.a.k(this.f8474n) + '/' + ((Object) ((TextView) _$_findCachedViewById(R$id.mTextTotalTime)).getText()));
        }
        int i13 = R$id.mImgPercent;
        ViewGroup.LayoutParams layoutParams = ((ImageView) _$_findCachedViewById(i13)).getLayoutParams();
        int duration2 = (int) (((ImageView) _$_findCachedViewById(R$id.mImgfull)).getLayoutParams().width * (this.f8474n / ((TitanVODView) _$_findCachedViewById(i10)).getDuration()));
        layoutParams.width = duration2;
        if (duration2 < 0) {
            layoutParams.width = 0;
        }
        ((ImageView) _$_findCachedViewById(i13)).setLayoutParams(layoutParams);
    }

    public final void P3() {
        String d10 = y6.a.d("MM-dd HH:mm");
        if (d10.compareTo("10-28 00:00:00") > 0 && d10.compareTo("11-04 00:00:00") < 0) {
            ((CurTimeSeekBar) _$_findCachedViewById(R$id.mSeekBar)).setThumb(getContext().getResources().getDrawable(R.drawable.icon_thumb_halloween));
            return;
        }
        if (d10.compareTo("12-22 00:00:00") > 0 && d10.compareTo("12-29 00:00:00") < 0) {
            ((CurTimeSeekBar) _$_findCachedViewById(R$id.mSeekBar)).setThumb(getContext().getResources().getDrawable(R.drawable.icon_thumb_christmas));
        } else if (d10.compareTo("12-29 00:00:00") > 0 || d10.compareTo("01-05 00:00:00") < 0) {
            ((CurTimeSeekBar) _$_findCachedViewById(R$id.mSeekBar)).setThumb(getContext().getResources().getDrawable(R.drawable.icon_thumb_new_years));
        } else {
            ((CurTimeSeekBar) _$_findCachedViewById(R$id.mSeekBar)).setThumb(getContext().getResources().getDrawable(R.drawable.shape_vod_seekbar_thumb));
        }
    }

    public final void P4(boolean z10) {
        if (z10) {
            this.f8455c.s();
        } else {
            this.f8455c.u();
        }
        this.f8455c.a();
    }

    public final void Q1(Configuration configuration) {
        t9.i.g(configuration, "newConfig");
        if (this.f8455c.l() || configuration.orientation == 2) {
            d3(true);
            setFullScreenAttr(true);
            x2();
        } else {
            d3(false);
            setFullScreenAttr(false);
            z4();
            J4();
        }
    }

    public final void Q3() {
        final GestureDetector gestureDetector = new GestureDetector(getMActivity(), new f0());
        setOnTouchListener(new View.OnTouchListener() { // from class: m6.w
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean R3;
                R3 = TitanPlayerController.R3(TitanPlayerController.this, gestureDetector, view, motionEvent);
                return R3;
            }
        });
    }

    public final void Q4() {
        ((TitanVODView) _$_findCachedViewById(R$id.mVideoViewVod)).D();
    }

    public final void R2(MotionEvent motionEvent) {
        int i10 = R$id.mLayoutController;
        int i11 = 0;
        if (((AlphaRelativeLayout) _$_findCachedViewById(i10)).getVisibility() == 8) {
            ((AlphaRelativeLayout) _$_findCachedViewById(i10)).setVisibility(0);
            z3();
            B3();
        }
        ((AlphaRelativeLayout) _$_findCachedViewById(i10)).setTag(Boolean.TRUE);
        ((AlphaRelativeLayout) _$_findCachedViewById(i10)).delayHide();
        Float f10 = this.M0;
        if (f10 == null) {
            this.M0 = Float.valueOf(motionEvent.getRawY());
            return;
        }
        t9.i.d(f10);
        float floatValue = f10.floatValue() - motionEvent.getRawY();
        int percentHeightSize = AutoUtils.getPercentHeightSize(280);
        b8.b bVar = this.f8456d;
        b8.b bVar2 = null;
        if (bVar == null) {
            t9.i.w("mVoiceHelper");
            bVar = null;
        }
        float e10 = bVar.e() * (floatValue / percentHeightSize);
        b8.b bVar3 = this.f8456d;
        if (bVar3 == null) {
            t9.i.w("mVoiceHelper");
            bVar3 = null;
        }
        float d10 = bVar3.d() + e10;
        b8.b bVar4 = this.f8456d;
        if (bVar4 == null) {
            t9.i.w("mVoiceHelper");
            bVar4 = null;
        }
        int d11 = bVar4.d() + ((int) e10);
        b8.b bVar5 = this.f8456d;
        if (bVar5 == null) {
            t9.i.w("mVoiceHelper");
            bVar5 = null;
        }
        if (d11 > bVar5.e()) {
            b8.b bVar6 = this.f8456d;
            if (bVar6 == null) {
                t9.i.w("mVoiceHelper");
                bVar6 = null;
            }
            i11 = bVar6.e();
        } else if (d11 >= 0) {
            i11 = d11;
        }
        b8.b bVar7 = this.f8456d;
        if (bVar7 == null) {
            t9.i.w("mVoiceHelper");
            bVar7 = null;
        }
        if (d10 > bVar7.e()) {
            b8.b bVar8 = this.f8456d;
            if (bVar8 == null) {
                t9.i.w("mVoiceHelper");
                bVar8 = null;
            }
            d10 = bVar8.e();
        } else if (d10 < 0.0f) {
            d10 = 0.0f;
        }
        if (Math.abs(e10) >= 1.0f) {
            this.M0 = Float.valueOf(motionEvent.getRawY());
            b8.b bVar9 = this.f8456d;
            if (bVar9 == null) {
                t9.i.w("mVoiceHelper");
                bVar9 = null;
            }
            bVar9.g(i11);
        }
        ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(R$id.mPbVolume);
        float f11 = 100 * d10;
        b8.b bVar10 = this.f8456d;
        if (bVar10 == null) {
            t9.i.w("mVoiceHelper");
        } else {
            bVar2 = bVar10;
        }
        progressBar.setProgress((int) (f11 / bVar2.e()));
    }

    public final void R4(AudioTrackBean audioTrackBean) {
        this.f8487t0 = audioTrackBean;
        String contentId = audioTrackBean.getContentId();
        Movie movie = this.f8462h;
        if (t9.i.b(contentId, movie != null ? movie.getContentId() : null)) {
            this.f8489u0 = !((TitanVODView) _$_findCachedViewById(R$id.mVideoViewVod)).y(audioTrackBean.getRealAudio(), audioTrackBean.getPosition());
            return;
        }
        this.f8489u0 = true;
        this.f8461g0 = true;
        ((TitanVODView) _$_findCachedViewById(R$id.mVideoViewVod)).setMedia(audioTrackBean.getContentId());
        V4(audioTrackBean.getContentId());
    }

    public final void S2() {
        this.H = false;
        if (this.f8464i != null) {
            int i10 = this.f8476o + 1;
            AssetData assetData = this.f8458f;
            t9.i.d(assetData);
            if (i10 < assetData.getSimpleProgramList().size()) {
                p3(this.f8476o + 1);
                return;
            }
            this.f8455c.u();
            ((TitanVODView) _$_findCachedViewById(R$id.mVideoViewVod)).u();
            int i11 = R$id.mPlayPauseIcon;
            if (((ImageView) _$_findCachedViewById(i11)).getVisibility() != 0) {
                ((ImageView) _$_findCachedViewById(i11)).setVisibility(0);
                D4(true);
            }
        }
    }

    public final void S3(ArrayList arrayList, AudioTrackBean audioTrackBean) {
        if (arrayList != null) {
            int i10 = 0;
            int i11 = 0;
            for (Object obj : arrayList) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    i9.j.j();
                }
                if (((AudioTrackBean) obj).isSelected()) {
                    i10 = i11;
                }
                i11 = i12;
            }
            this.f8475n0 = i10;
            getSubtitleAudioPorWindow().m(arrayList, i10);
            getSubtitleAudioLandWindow().m(arrayList, i10);
            this.f8487t0 = audioTrackBean;
        }
    }

    public final void S4() {
        String contentId;
        String buss;
        String lang;
        String quality;
        String vcodec;
        String format;
        String buss2;
        String episode;
        String title;
        String name;
        String media;
        List<Media> medias;
        com.mobile.brasiltv.utils.h hVar = com.mobile.brasiltv.utils.h.f8694a;
        String e10 = hVar.e();
        if (e10 != null) {
            O4();
            xa.c.c().j(new CastToCloseOtherPlayEvent("VOD", false));
            String T4 = this.f8479p0 ? T4(e10, "dlna") : e10;
            if (!t9.i.b(hVar.a(), hVar.k())) {
                if (t9.i.b(hVar.a(), hVar.l())) {
                    Q4();
                    this.N.j(T4(e10, "google_cast"), W2(), ((TitanVODView) _$_findCachedViewById(R$id.mVideoViewVod)).getDuration(), getMediaMetadata());
                    this.N.s();
                    z5.c cVar = this.N;
                    AssetData assetData = this.f8458f;
                    cVar.l(this, (assetData == null || (contentId = assetData.getContentId()) == null) ? "" : contentId, PlayAty.G.a(), this.f8478p, com.mobile.brasiltv.utils.y.f8771a.n(), this.f8480q, na.e.f17343c, "");
                    V1(this, false, false, 2, null);
                    return;
                }
                return;
            }
            Program program = this.E0;
            Media media2 = (program == null || (medias = program.getMedias()) == null) ? null : medias.get(0);
            com.mobile.brasiltv.utils.g gVar = com.mobile.brasiltv.utils.g.f8651a;
            Program program2 = this.E0;
            String str = (program2 == null || (media = program2.getMedia()) == null) ? "" : media;
            Program program3 = this.E0;
            String str2 = (program3 == null || (name = program3.getName()) == null) ? "" : name;
            Program program4 = this.E0;
            String str3 = (program4 == null || (title = program4.getTitle()) == null) ? "" : title;
            Program program5 = this.E0;
            String str4 = (program5 == null || (episode = program5.getEpisode()) == null) ? "" : episode;
            Program program6 = this.E0;
            String str5 = (program6 == null || (buss2 = program6.getBuss()) == null) ? "" : buss2;
            String str6 = (media2 == null || (format = media2.getFormat()) == null) ? "" : format;
            String str7 = (media2 == null || (vcodec = media2.getVcodec()) == null) ? "" : vcodec;
            String str8 = (media2 == null || (quality = media2.getQuality()) == null) ? "" : quality;
            String str9 = (media2 == null || (lang = media2.getLang()) == null) ? "" : lang;
            Program program7 = this.E0;
            String str10 = (program7 == null || (buss = program7.getBuss()) == null) ? "" : buss;
            long W2 = W2() * 1000;
            String str11 = this.f8481q0;
            gVar.E(T4, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, W2, str11 == null ? "" : str11, this.f8479p0);
            V1(this, false, false, 2, null);
        }
    }

    public final void T2(Movie movie) {
        String str;
        Program h10;
        String media;
        t9.i.g(movie, "movie");
        A3();
        this.f8486t = true;
        this.f8461g0 = false;
        V1(this, true, false, 2, null);
        setVodSubtitleAudioVisibility(0);
        e3();
        this.H = false;
        int i10 = R$id.mVideoViewVod;
        TitanVODView titanVODView = (TitanVODView) _$_findCachedViewById(i10);
        AudioTrackBean audioTrackBean = this.f8487t0;
        String str2 = "";
        if (audioTrackBean == null || (str = audioTrackBean.getRealAudio()) == null) {
            str = "";
        }
        AudioTrackBean audioTrackBean2 = this.f8487t0;
        this.f8489u0 = true ^ titanVODView.y(str, audioTrackBean2 != null ? audioTrackBean2.getPosition() : 0);
        J4();
        n8.b titanContext = ((TitanVODView) _$_findCachedViewById(i10)).getTitanContext();
        if (titanContext != null && (h10 = titanContext.h()) != null && (media = h10.getMedia()) != null) {
            str2 = media;
        }
        this.f8478p = str2;
        this.f8462h = movie;
    }

    public final void T3() {
        Context context = getContext();
        t9.i.f(context, com.umeng.analytics.pro.f.X);
        PauseAdView pauseAdView = new PauseAdView(context, this.f8470l);
        this.A = pauseAdView;
        pauseAdView.setLayoutAdCallback(new h0());
        PauseAdView pauseAdView2 = this.A;
        if (pauseAdView2 != null) {
            pauseAdView2.setDetachAdCallback(new i0());
        }
    }

    public final String T4(String str, String str2) {
        if (ba.t.o(str, Operator.Operation.EMPTY_PARAM, false, 2, null)) {
            return str + "&cast=" + str2;
        }
        return str + "?cast=" + str2;
    }

    @Override // z5.c.d
    public void U() {
        ((ImageView) _$_findCachedViewById(R$id.mImagePlayCast)).setImageResource(R.drawable.icon_play_white);
    }

    public final void U1(boolean z10, boolean z11) {
        String str;
        String videoFormat;
        com.mobile.brasiltv.utils.h hVar = com.mobile.brasiltv.utils.h.f8694a;
        boolean b10 = t9.i.b(hVar.a(), hVar.k());
        if (z11) {
            ((AutoLinearLayout) _$_findCachedViewById(R$id.llCastContainer)).setVisibility(8);
            this.f8455c.c();
            ((AlphaRelativeLayout) _$_findCachedViewById(R$id.mLayoutController)).setVisibility(8);
            ((TextView) _$_findCachedViewById(R$id.mTvCastErrorHint)).setVisibility(8);
            this.O = hVar.a();
            if (!b10) {
                Movie movie = this.f8462h;
                String str2 = "";
                if (movie == null || (str = movie.getEncodeFormat()) == null) {
                    str = "";
                }
                Movie movie2 = this.f8462h;
                if (movie2 != null && (videoFormat = movie2.getVideoFormat()) != null) {
                    str2 = videoFormat;
                }
                if (!C2(str, str2)) {
                    ((AutoLinearLayout) _$_findCachedViewById(R$id.llSwitchContainer)).setVisibility(0);
                    return;
                }
            }
            S4();
            return;
        }
        if (z10) {
            ((AutoLinearLayout) _$_findCachedViewById(R$id.llSwitchContainer)).setVisibility(8);
            ((AutoLinearLayout) _$_findCachedViewById(R$id.llCastContainer)).setVisibility(8);
            ((AlphaRelativeLayout) _$_findCachedViewById(R$id.mLayoutController)).setVisibility(0);
            ((TextView) _$_findCachedViewById(R$id.mTvCastErrorHint)).setVisibility(8);
            z3();
            B3();
            this.f8455c.f();
            ((SeekBar) _$_findCachedViewById(R$id.mSeekBarCast)).setProgress(0);
            if (b10) {
                com.mobile.brasiltv.utils.g.f8651a.w(null);
                return;
            } else {
                this.N.o();
                return;
            }
        }
        ((AutoLinearLayout) _$_findCachedViewById(R$id.mLayoutStage)).setVisibility(8);
        ((ImageView) _$_findCachedViewById(R$id.mIvStage)).setVisibility(8);
        ((AutoLinearLayout) _$_findCachedViewById(R$id.llSwitchContainer)).setVisibility(8);
        ((AutoLinearLayout) _$_findCachedViewById(R$id.llCastContainer)).setVisibility(0);
        ((AlphaRelativeLayout) _$_findCachedViewById(R$id.mLayoutController)).setVisibility(8);
        ((TextView) _$_findCachedViewById(R$id.mTvCastErrorHint)).setVisibility(8);
        this.f8455c.c();
        int i10 = R$id.mTvCastState;
        ((TextView) _$_findCachedViewById(i10)).setText(getContext().getResources().getString(R.string.cast_status_prepare));
        ((TextView) _$_findCachedViewById(i10)).setTextColor(getContext().getResources().getColor(R.color.color_fffefe));
        int i11 = R$id.mTvPleaseWait;
        ((TextView) _$_findCachedViewById(i11)).setVisibility(0);
        ((TextView) _$_findCachedViewById(R$id.mTvCastRecommendHint)).setVisibility(4);
        q3();
        int i12 = R$id.mImagePlayCast;
        ((ImageView) _$_findCachedViewById(i12)).setImageResource(R.drawable.icon_pause_white);
        if (getContext() instanceof PlayAty) {
            Context context = getContext();
            t9.i.e(context, "null cannot be cast to non-null type com.mobile.brasiltv.activity.PlayAty");
            if (t9.i.b(((PlayAty) context).j3().c(), o6.c.c().c())) {
                ((ImageView) _$_findCachedViewById(R$id.mIvCastQuality)).setImageResource(R.mipmap.icon_cast_definition_480);
            } else {
                Context context2 = getContext();
                t9.i.e(context2, "null cannot be cast to non-null type com.mobile.brasiltv.activity.PlayAty");
                if (t9.i.b(((PlayAty) context2).j3().c(), o6.c.b().c())) {
                    ((ImageView) _$_findCachedViewById(R$id.mIvCastQuality)).setImageResource(R.mipmap.icon_cast_definition_720);
                } else {
                    Context context3 = getContext();
                    t9.i.e(context3, "null cannot be cast to non-null type com.mobile.brasiltv.activity.PlayAty");
                    if (t9.i.b(((PlayAty) context3).j3().c(), o6.c.a().c())) {
                        ((ImageView) _$_findCachedViewById(R$id.mIvCastQuality)).setImageResource(R.mipmap.icon_cast_definition_1080);
                    }
                }
            }
        }
        int i13 = R$id.mSeekBarCast;
        ((SeekBar) _$_findCachedViewById(i13)).setProgress(0);
        com.mobile.brasiltv.utils.g gVar = com.mobile.brasiltv.utils.g.f8651a;
        if (gVar.j()) {
            ((TextView) _$_findCachedViewById(i11)).setVisibility(8);
            ((ImageView) _$_findCachedViewById(i12)).setImageResource(R.drawable.icon_play_white);
            ((SeekBar) _$_findCachedViewById(i13)).setProgress(((SeekBar) _$_findCachedViewById(i13)).getMax());
            TextView textView = (TextView) _$_findCachedViewById(R$id.mTextCurTimeCast);
            if (textView != null) {
                textView.setText(y6.a.l(0L));
            }
            this.C = 0L;
            Links links = this.f8498z;
            if (links != null) {
                links.setRecordTime(0L);
            }
        }
        if (b10) {
            gVar.w(this);
        } else {
            this.N.e(this);
        }
    }

    public final boolean U2() {
        return ((AutoLinearLayout) _$_findCachedViewById(R$id.mLlQuality)).getVisibility() == 0 || ((ImageView) _$_findCachedViewById(R$id.mImageQuality)).getVisibility() == 0;
    }

    public final void U3() {
        int i10 = R$id.mVideoViewVod;
        String k10 = y6.a.k(((TitanVODView) _$_findCachedViewById(i10)).getDuration());
        y6.a.k(((TitanVODView) _$_findCachedViewById(i10)).getCurrentProgress());
        ((TextView) _$_findCachedViewById(R$id.mTextTotalTime)).setText(k10);
        ((TextView) _$_findCachedViewById(R$id.mFullTotalTime)).setText(k10);
    }

    public final void U4() {
        List<Movie> movieList;
        d8.c playStatus = ((TitanVODView) _$_findCachedViewById(R$id.mVideoViewVod)).getPlayStatus();
        String d10 = playStatus != null ? playStatus.d() : null;
        HashMap hashMap = this.f8460g;
        Context context = getContext();
        t9.i.e(context, "null cannot be cast to non-null type com.mobile.brasiltv.activity.PlayAty");
        TotalMovieList totalMovieList = (TotalMovieList) hashMap.get(((PlayAty) context).j3().c());
        if (d10 == null || totalMovieList == null || (movieList = totalMovieList.getMovieList()) == null) {
            return;
        }
        for (Movie movie : movieList) {
            if (com.mobile.brasiltv.utils.b0.I(movie.getLicenseList()) && t9.i.b(d10, movie.getContentId())) {
                this.f8462h = movie;
            }
        }
    }

    public final long V2() {
        Links links;
        AssetData assetData = this.f8458f;
        if (assetData != null) {
            VodDao vodDao = this.f8457e;
            if (vodDao != null) {
                t9.i.d(assetData);
                links = vodDao.queryRecordByContentId(assetData.getContentId(), this.f8476o);
            } else {
                links = null;
            }
            this.f8498z = links;
            if (links != null && links.getRecordTime() > links.getDuration() - 10000) {
                links.setRecordTime(0L);
            }
        }
        Links links2 = this.f8498z;
        if ((links2 != null ? links2.getRecordTime() : 0L) <= 0) {
            return 0L;
        }
        Links links3 = this.f8498z;
        t9.i.d(links3);
        return links3.getRecordTime();
    }

    public final void V3(int i10, VodDao vodDao, SimpleProgramList simpleProgramList, String str) {
        t9.i.g(vodDao, "mVodDao");
        t9.i.g(simpleProgramList, "curPlayProgram");
        t9.i.g(str, "type");
        this.f8476o = i10;
        this.f8457e = vodDao;
        this.f8464i = simpleProgramList;
        this.B = str;
        int i11 = R$id.mIvStage;
        ((ImageView) _$_findCachedViewById(i11)).setImageResource(R.drawable.bg_vod_default_stage);
        ((AutoLinearLayout) _$_findCachedViewById(R$id.mLayoutStage)).setVisibility(0);
        ((ImageView) _$_findCachedViewById(i11)).setVisibility(0);
    }

    public final void V4(String str) {
        List<Movie> movieList;
        HashMap hashMap = this.f8460g;
        Context context = getContext();
        t9.i.e(context, "null cannot be cast to non-null type com.mobile.brasiltv.activity.PlayAty");
        TotalMovieList totalMovieList = (TotalMovieList) hashMap.get(((PlayAty) context).j3().c());
        if (totalMovieList == null || (movieList = totalMovieList.getMovieList()) == null) {
            return;
        }
        for (Movie movie : movieList) {
            if (com.mobile.brasiltv.utils.b0.I(movie.getLicenseList()) && t9.i.b(str, movie.getContentId())) {
                this.f8462h = movie;
            }
        }
    }

    public final boolean W1() {
        return false;
    }

    public final int W2() {
        long j10 = this.C;
        if (j10 != 0) {
            int i10 = ((int) j10) / 1000;
            this.C = 0L;
            return i10;
        }
        Links links = this.f8498z;
        if (links != null) {
            t9.i.d(links);
            if (links.getRecordTime() > 0) {
                Links links2 = this.f8498z;
                t9.i.d(links2);
                return ((int) links2.getRecordTime()) / 1000;
            }
        }
        return 0;
    }

    public final void W4(String str) {
        t9.i.g(str, "contentId");
        SimpleProgramList simpleProgramList = this.f8464i;
        if (simpleProgramList == null) {
            return;
        }
        simpleProgramList.setContentId(str);
    }

    public final boolean X1() {
        if (!this.f8496y) {
            a.C0074a c0074a = b8.a.f5079a;
            Context context = getContext();
            t9.i.f(context, com.umeng.analytics.pro.f.X);
            if (!c0074a.c(context)) {
                int i10 = R$id.mLayoutMobileNotify;
                ((AutoLinearLayout) _$_findCachedViewById(i10)).setVisibility(0);
                ((AutoLinearLayout) _$_findCachedViewById(i10)).setOnClickListener(new View.OnClickListener() { // from class: m6.y
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        TitanPlayerController.Y1(TitanPlayerController.this, view);
                    }
                });
                return false;
            }
        }
        ((AutoLinearLayout) _$_findCachedViewById(R$id.mLayoutMobileNotify)).setVisibility(8);
        return true;
    }

    public final void X2() {
        ((ImageView) _$_findCachedViewById(R$id.mPlayPauseIcon)).setVisibility(8);
        D4(false);
        ((AutoLinearLayout) _$_findCachedViewById(R$id.mLayoutStage)).setVisibility(8);
        ((ImageView) _$_findCachedViewById(R$id.mIvStage)).setVisibility(8);
        ((RelativeLayout) _$_findCachedViewById(R$id.mBufferView)).setVisibility(8);
        this.G = false;
        ((ImageView) _$_findCachedViewById(R$id.mImagePlay)).setImageResource(R.drawable.ic_vod_pause);
        int i10 = R$id.mLayoutController;
        ((AlphaRelativeLayout) _$_findCachedViewById(i10)).setVisibility(4);
        ((AlphaRelativeLayout) _$_findCachedViewById(i10)).enableProxyVisibility(true);
        this.S = true;
    }

    public final void X4(HashMap hashMap) {
        t9.i.g(hashMap, "totalMovieListMap");
        this.f8460g.clear();
        this.f8460g.putAll(hashMap);
    }

    public final void Y2() {
        if (xa.c.c().h(this)) {
            return;
        }
        xa.c.c().o(this);
    }

    public final void Y4() {
        if (this.f8455c.m()) {
            int i10 = R$id.mFlLocked;
            if (((AutoFrameLayout) _$_findCachedViewById(i10)).getVisibility() != 0) {
                D2();
                ((AutoFrameLayout) _$_findCachedViewById(i10)).setVisibility(0);
                return;
            } else {
                Disposable disposable = this.B0;
                if (disposable != null) {
                    disposable.dispose();
                }
                ((AutoFrameLayout) _$_findCachedViewById(i10)).setVisibility(8);
                return;
            }
        }
        int i11 = R$id.mLayoutSetInfo;
        if (((AutoFrameLayout) _$_findCachedViewById(i11)).getVisibility() == 0) {
            Disposable disposable2 = this.C0;
            if (disposable2 != null) {
                disposable2.dispose();
            }
            AutoFrameLayout autoFrameLayout = (AutoFrameLayout) _$_findCachedViewById(i11);
            t9.i.f(autoFrameLayout, "mLayoutSetInfo");
            N4(autoFrameLayout, AutoUtils.getPercentWidthSize(580));
            return;
        }
        int i12 = R$id.mMemberTipsLayout;
        if (((AutoRelativeLayout) _$_findCachedViewById(i12)).getVisibility() == 0) {
            return;
        }
        if (((ImageView) _$_findCachedViewById(R$id.mPlayPauseIcon)).getVisibility() == 0 || ((AutoRelativeLayout) _$_findCachedViewById(i12)).getVisibility() == 0) {
            ((ImageView) _$_findCachedViewById(R$id.mImageBack)).setVisibility(0);
        }
        int i13 = R$id.mLayoutController;
        if (t9.i.b(((AlphaRelativeLayout) _$_findCachedViewById(i13)).getTag(), Boolean.TRUE)) {
            ((AlphaRelativeLayout) _$_findCachedViewById(i13)).setTag(Boolean.FALSE);
            ((AlphaRelativeLayout) _$_findCachedViewById(i13)).delayHide();
        } else {
            if (((AlphaRelativeLayout) _$_findCachedViewById(i13)).getVisibility() == 0) {
                ((AlphaRelativeLayout) _$_findCachedViewById(i13)).setVisibility(8);
                return;
            }
            ((AlphaRelativeLayout) _$_findCachedViewById(i13)).setVisibility(0);
            z3();
            B3();
        }
    }

    @Override // o8.a
    public void Z() {
    }

    public final void Z1() {
        ((BeforeVodAdView) _$_findCachedViewById(R$id.mBvavAd)).hideBeforeVodAd();
    }

    public final void Z2() {
        String str;
        w6.i b10 = w6.i.f19214g.b();
        AssetData assetData = this.f8458f;
        if (assetData == null || (str = assetData.getName()) == null) {
            str = "";
        }
        String obj = ((TextView) _$_findCachedViewById(R$id.mTvCastDevice)).getText().toString();
        String a10 = com.mobile.brasiltv.utils.h.f8694a.a();
        Context context = getContext();
        t9.i.e(context, "null cannot be cast to non-null type com.mobile.brasiltv.activity.PlayAty");
        b10.s2(str, obj, a10, ((PlayAty) context).j3().c()).subscribe(new n());
    }

    public final void Z3() {
        C3();
        ((ImageView) _$_findCachedViewById(R$id.mPlayPauseIcon)).setOnClickListener(new View.OnClickListener() { // from class: m6.g0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TitanPlayerController.a4(TitanPlayerController.this, view);
            }
        });
        ((TextView) _$_findCachedViewById(R$id.mMemberWatchFree)).setOnClickListener(new View.OnClickListener() { // from class: m6.s0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TitanPlayerController.b4(TitanPlayerController.this, view);
            }
        });
        ((TextView) _$_findCachedViewById(R$id.mMemberTips2)).setOnClickListener(new View.OnClickListener() { // from class: m6.x0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TitanPlayerController.c4(TitanPlayerController.this, view);
            }
        });
        ((CurTimeSeekBar) _$_findCachedViewById(R$id.mSeekBar)).setOnSeekBarChangeListener(new p0());
        ((ImageView) _$_findCachedViewById(R$id.mImagePlay)).setOnClickListener(new View.OnClickListener() { // from class: m6.y0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TitanPlayerController.d4(TitanPlayerController.this, view);
            }
        });
        ((ImageView) _$_findCachedViewById(R$id.mImageFullScreen)).setOnClickListener(new View.OnClickListener() { // from class: m6.z0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TitanPlayerController.e4(TitanPlayerController.this, view);
            }
        });
        ((AutoLinearLayout) _$_findCachedViewById(R$id.mLlEpisodes)).setOnClickListener(new View.OnClickListener() { // from class: m6.a1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TitanPlayerController.f4(TitanPlayerController.this, view);
            }
        });
        ((AutoLinearLayout) _$_findCachedViewById(R$id.mLlAudioLanguage)).setOnClickListener(new View.OnClickListener() { // from class: m6.b1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TitanPlayerController.g4(TitanPlayerController.this, view);
            }
        });
        ((AutoLinearLayout) _$_findCachedViewById(R$id.mLlLock)).setOnClickListener(new View.OnClickListener() { // from class: m6.c1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TitanPlayerController.h4(TitanPlayerController.this, view);
            }
        });
        ((AutoFrameLayout) _$_findCachedViewById(R$id.mFlLocked)).setOnClickListener(new View.OnClickListener() { // from class: m6.d1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TitanPlayerController.i4(TitanPlayerController.this, view);
            }
        });
        ((AutoLinearLayout) _$_findCachedViewById(R$id.mLlQuality)).setOnClickListener(new View.OnClickListener() { // from class: m6.f1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TitanPlayerController.j4(TitanPlayerController.this, view);
            }
        });
        ((ImageView) _$_findCachedViewById(R$id.mIvFastRewind)).setOnClickListener(new View.OnClickListener() { // from class: m6.h0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TitanPlayerController.k4(TitanPlayerController.this, view);
            }
        });
        ((ImageView) _$_findCachedViewById(R$id.mIvFastForward)).setOnClickListener(new View.OnClickListener() { // from class: m6.j0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TitanPlayerController.l4(TitanPlayerController.this, view);
            }
        });
        ((AlphaRelativeLayout) _$_findCachedViewById(R$id.mLayoutController)).setVisibilityListener(new m0());
        setOnClickListener(new View.OnClickListener() { // from class: m6.k0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TitanPlayerController.m4(TitanPlayerController.this, view);
            }
        });
        getSetInfoAdapter().setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() { // from class: m6.l0
            @Override // com.chad.library.adapter.base.BaseQuickAdapter.OnItemClickListener
            public final void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i10) {
                TitanPlayerController.n4(TitanPlayerController.this, baseQuickAdapter, view, i10);
            }
        });
        ((ImageView) _$_findCachedViewById(R$id.mImageFeedback)).setOnClickListener(new View.OnClickListener() { // from class: m6.m0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TitanPlayerController.o4(TitanPlayerController.this, view);
            }
        });
        ((ImageView) _$_findCachedViewById(R$id.mIvShare)).setOnClickListener(new View.OnClickListener() { // from class: m6.n0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TitanPlayerController.q4(TitanPlayerController.this, view);
            }
        });
        ((ImageView) _$_findCachedViewById(R$id.mDebugSwitch)).setOnClickListener(new View.OnClickListener() { // from class: m6.o0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TitanPlayerController.r4(TitanPlayerController.this, view);
            }
        });
        ((ImageView) _$_findCachedViewById(R$id.mImageQuality)).setOnClickListener(new View.OnClickListener() { // from class: m6.p0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TitanPlayerController.s4(TitanPlayerController.this, view);
            }
        });
        ImageView imageView = (ImageView) _$_findCachedViewById(R$id.mImageCast);
        t9.i.f(imageView, "mImageCast");
        com.mobile.brasiltv.utils.b0.P(imageView, new View.OnClickListener() { // from class: m6.q0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TitanPlayerController.t4(TitanPlayerController.this, view);
            }
        });
        ((TextView) _$_findCachedViewById(R$id.mTvCastRecommendHint)).setOnClickListener(new View.OnClickListener() { // from class: m6.r0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TitanPlayerController.u4(TitanPlayerController.this, view);
            }
        });
        ((ImageView) _$_findCachedViewById(R$id.mIvSubtitleAudio)).setOnClickListener(new View.OnClickListener() { // from class: m6.u0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TitanPlayerController.v4(TitanPlayerController.this, view);
            }
        });
        getSubtitleAudioLandWindow().o(new n0());
        getSubtitleAudioPorWindow().o(new o0());
        ((RecyclerView) _$_findCachedViewById(R$id.recyclerSetInfo)).setOnTouchListener(new View.OnTouchListener() { // from class: m6.v0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean w42;
                w42 = TitanPlayerController.w4(TitanPlayerController.this, view, motionEvent);
                return w42;
            }
        });
        ((AutoFrameLayout) _$_findCachedViewById(R$id.mLayoutSetInfo)).setOnClickListener(new View.OnClickListener() { // from class: m6.w0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TitanPlayerController.x4(TitanPlayerController.this, view);
            }
        });
    }

    public final boolean Z4(View view, MotionEvent motionEvent, GestureDetector gestureDetector) {
        if (this.f8455c.m() || !this.W) {
            return false;
        }
        if (motionEvent.getAction() == 1) {
            ((FrameLayout) _$_findCachedViewById(R$id.mLayoutGesture)).setVisibility(8);
            if (this.f8472m) {
                this.H = true;
                int i10 = this.f8474n;
                if (i10 < 0) {
                    ((TitanVODView) _$_findCachedViewById(R$id.mVideoViewVod)).x(0L);
                } else {
                    long j10 = i10;
                    int i11 = R$id.mVideoViewVod;
                    if (j10 > ((TitanVODView) _$_findCachedViewById(i11)).getDuration()) {
                        ((TitanVODView) _$_findCachedViewById(i11)).x(((TitanVODView) _$_findCachedViewById(i11)).getDuration() - 3000);
                    } else {
                        ((TitanVODView) _$_findCachedViewById(i11)).x(this.f8474n);
                    }
                }
                this.f8472m = false;
                if (this.V) {
                    ((ImageView) _$_findCachedViewById(R$id.mPlayPauseIcon)).setVisibility(8);
                    D4(false);
                }
                return true;
            }
        }
        return gestureDetector.onTouchEvent(motionEvent);
    }

    public View _$_findCachedViewById(int i10) {
        Map map = this.N0;
        View view = (View) map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    @Override // com.mobile.brasiltv.utils.g.b
    public void a() {
        post(new Runnable() { // from class: m6.n
            @Override // java.lang.Runnable
            public final void run() {
                TitanPlayerController.M2(TitanPlayerController.this);
            }
        });
    }

    public final void a2() {
        ((AlphaRelativeLayout) _$_findCachedViewById(R$id.mLayoutController)).setVisibilitySwitch(true);
    }

    public final void a3() {
        EnterType enterType;
        if (this.f8465i0 == 0 || (enterType = this.f8466j) == null) {
            return;
        }
        int i10 = enterType == null ? -1 : c.f8512b[enterType.ordinal()];
        if (i10 == 1) {
            Context context = getContext();
            String str = this.f8468k;
            SimpleProgramList simpleProgramList = this.f8464i;
            String contentId = simpleProgramList != null ? simpleProgramList.getContentId() : null;
            AssetData assetData = this.f8458f;
            i1.y(context, str, contentId, assetData != null ? assetData.getName() : null, this.f8465i0);
        } else if (i10 == 2) {
            Context context2 = getContext();
            AssetData assetData2 = this.f8458f;
            String programType = assetData2 != null ? assetData2.getProgramType() : null;
            SimpleProgramList simpleProgramList2 = this.f8464i;
            String contentId2 = simpleProgramList2 != null ? simpleProgramList2.getContentId() : null;
            AssetData assetData3 = this.f8458f;
            i1.k(context2, programType, contentId2, assetData3 != null ? assetData3.getName() : null, this.f8465i0);
        } else if (i10 == 3) {
            Context context3 = getContext();
            SimpleProgramList simpleProgramList3 = this.f8464i;
            String contentId3 = simpleProgramList3 != null ? simpleProgramList3.getContentId() : null;
            AssetData assetData4 = this.f8458f;
            String name = assetData4 != null ? assetData4.getName() : null;
            AssetData assetData5 = this.f8458f;
            i1.E(context3, contentId3, name, assetData5 != null ? assetData5.getProgramType() : null, this.f8465i0);
        } else if (i10 == 4) {
            Context context4 = getContext();
            SimpleProgramList simpleProgramList4 = this.f8464i;
            String contentId4 = simpleProgramList4 != null ? simpleProgramList4.getContentId() : null;
            AssetData assetData6 = this.f8458f;
            i1.E(context4, contentId4, assetData6 != null ? assetData6.getName() : null, "banner", this.f8465i0);
        } else if (i10 == 5) {
            Context context5 = getContext();
            String str2 = this.f8468k;
            SimpleProgramList simpleProgramList5 = this.f8464i;
            String contentId5 = simpleProgramList5 != null ? simpleProgramList5.getContentId() : null;
            AssetData assetData7 = this.f8458f;
            i1.L(context5, str2, contentId5, assetData7 != null ? assetData7.getName() : null, this.f8465i0);
        }
        Context context6 = getContext();
        SimpleProgramList simpleProgramList6 = this.f8464i;
        String contentId6 = simpleProgramList6 != null ? simpleProgramList6.getContentId() : null;
        AssetData assetData8 = this.f8458f;
        i1.O(context6, contentId6, assetData8 != null ? assetData8.getName() : null, this.f8465i0);
    }

    @Override // com.mobile.brasiltv.utils.g.b
    public void b(final int i10, final String str, final String str2) {
        t9.i.g(str, "extra");
        post(new Runnable() { // from class: m6.o
            @Override // java.lang.Runnable
            public final void run() {
                TitanPlayerController.K2(i10, str, this, str2);
            }
        });
    }

    @Override // z5.c.d
    public void b0() {
    }

    @Override // o8.a
    public void b1() {
    }

    public final void b2() {
        Disposable disposable = this.C0;
        if (disposable != null) {
            disposable.dispose();
        }
        Observable<Long> observeOn = Observable.timer(5L, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread());
        final e eVar = new e();
        Consumer<? super Long> consumer = new Consumer() { // from class: m6.k1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TitanPlayerController.d2(s9.l.this, obj);
            }
        };
        final f fVar = f.f8523a;
        this.C0 = observeOn.subscribe(consumer, new Consumer() { // from class: m6.l1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TitanPlayerController.e2(s9.l.this, obj);
            }
        });
    }

    public final void b3() {
        this.S = false;
        this.W = false;
    }

    @Override // p8.a
    public void c(int i10) {
        if (i10 != 2) {
            if (i10 != 3) {
                return;
            }
            ((ImageView) _$_findCachedViewById(R$id.mImagePlay)).setImageResource(R.drawable.ic_vod_play);
            ((ImageView) _$_findCachedViewById(R$id.mPlayPauseIcon)).setImageResource(R.drawable.ic_vod_to_play);
            return;
        }
        a.C0074a c0074a = b8.a.f5079a;
        Context context = getContext();
        t9.i.f(context, com.umeng.analytics.pro.f.X);
        if (c0074a.c(context)) {
            int i11 = R$id.mLayoutMobileNotify;
            if (((AutoLinearLayout) _$_findCachedViewById(i11)).getVisibility() == 0) {
                ((AutoLinearLayout) _$_findCachedViewById(i11)).setVisibility(8);
            }
        }
        this.H = false;
        w2();
        ((ImageView) _$_findCachedViewById(R$id.mImagePlay)).setImageResource(R.drawable.ic_vod_pause);
        ((ImageView) _$_findCachedViewById(R$id.mPlayPauseIcon)).setImageResource(R.drawable.ic_vod_to_pause);
        this.D = false;
    }

    @Override // z5.c.d
    public void c2() {
        xa.c.c().j(new CastPlaySuccessEvent("VOD"));
        int i10 = R$id.mTvCastState;
        ((TextView) _$_findCachedViewById(i10)).setText(getContext().getResources().getString(R.string.cast_status_casting));
        ((TextView) _$_findCachedViewById(i10)).setTextColor(getContext().getResources().getColor(R.color.color_fffefe));
        ((TextView) _$_findCachedViewById(R$id.mTvPleaseWait)).setVisibility(8);
        ((TextView) _$_findCachedViewById(R$id.mTvCastRecommendHint)).setVisibility(4);
        q3();
        ((ImageView) _$_findCachedViewById(R$id.mImagePlayCast)).setImageResource(R.drawable.icon_pause_white);
    }

    public final void c3() {
        this.S = false;
        this.V = false;
        this.W = false;
        this.L0 = 0;
        setSeekBarClickable(false);
    }

    @xa.j
    public final void castToPlay(CastToPlayEvent castToPlayEvent) {
        String buss;
        String lang;
        String quality;
        String vcodec;
        String format;
        String buss2;
        String episode;
        String title;
        String name;
        String media;
        List<Media> medias;
        String str;
        f5.c mActivity;
        t9.i.g(castToPlayEvent, "event");
        if (t9.i.b(castToPlayEvent.getFromType(), "VOD") && (mActivity = getMActivity()) != null) {
            mActivity.runOnUiThread(new Runnable() { // from class: m6.t
                @Override // java.lang.Runnable
                public final void run() {
                    TitanPlayerController.T1(TitanPlayerController.this);
                }
            });
        }
        com.mobile.brasiltv.utils.h hVar = com.mobile.brasiltv.utils.h.f8694a;
        if (hVar.u() && !this.F0 && com.mobile.brasiltv.utils.b0.K(this.G0) && (str = this.G0) != null) {
            Integer num = this.H0;
            t9.i.d(num);
            A4(num.intValue(), str);
        }
        Program program = this.E0;
        Media media2 = (program == null || (medias = program.getMedias()) == null) ? null : medias.get(0);
        if (t9.i.b(castToPlayEvent.getFromType(), "VOD")) {
            if ((hVar.e().length() > 0) && hVar.u()) {
                this.J0 = false;
                O4();
                Q4();
                com.mobile.brasiltv.utils.g gVar = com.mobile.brasiltv.utils.g.f8651a;
                gVar.x(castToPlayEvent.getFromType());
                String T4 = this.f8479p0 ? T4(hVar.e(), "dlna") : hVar.e();
                Program program2 = this.E0;
                String str2 = (program2 == null || (media = program2.getMedia()) == null) ? "" : media;
                Program program3 = this.E0;
                String str3 = (program3 == null || (name = program3.getName()) == null) ? "" : name;
                Program program4 = this.E0;
                String str4 = (program4 == null || (title = program4.getTitle()) == null) ? "" : title;
                Program program5 = this.E0;
                String str5 = (program5 == null || (episode = program5.getEpisode()) == null) ? "" : episode;
                Program program6 = this.E0;
                String str6 = (program6 == null || (buss2 = program6.getBuss()) == null) ? "" : buss2;
                String str7 = (media2 == null || (format = media2.getFormat()) == null) ? "" : format;
                String str8 = (media2 == null || (vcodec = media2.getVcodec()) == null) ? "" : vcodec;
                String str9 = (media2 == null || (quality = media2.getQuality()) == null) ? "" : quality;
                String str10 = (media2 == null || (lang = media2.getLang()) == null) ? "" : lang;
                Program program7 = this.E0;
                String str11 = (program7 == null || (buss = program7.getBuss()) == null) ? "" : buss;
                long W2 = 1000 * W2();
                String str12 = this.f8481q0;
                gVar.E(T4, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, W2, str12 == null ? "" : str12, this.f8479p0);
                this.O = hVar.k();
                return;
            }
        }
        if (hVar.u()) {
            return;
        }
        this.J0 = true;
    }

    @Override // com.mobile.brasiltv.utils.g.b
    public void d() {
        post(new Runnable() { // from class: m6.s
            @Override // java.lang.Runnable
            public final void run() {
                TitanPlayerController.N2(TitanPlayerController.this);
            }
        });
    }

    @Override // o8.a
    public void d1(long j10) {
        com.mobile.brasiltv.utils.h hVar = com.mobile.brasiltv.utils.h.f8694a;
        if (hVar.o() && hVar.t()) {
            com.mobile.brasiltv.utils.g.f8651a.G();
        }
        hVar.E("");
        hVar.v(false);
        hVar.K(true);
        com.mobile.brasiltv.utils.g.f8651a.y(false);
        ((TitanVODView) _$_findCachedViewById(R$id.mVideoViewVod)).C();
        Context context = getContext();
        if (context != null) {
            com.mobile.brasiltv.utils.x.f8754a.w(context, new d(context, j10));
        }
        this.H0 = Integer.valueOf((int) j10);
        f5.c mActivity = getMActivity();
        if (mActivity != null) {
            mActivity.runOnUiThread(new Runnable() { // from class: m6.v
                @Override // java.lang.Runnable
                public final void run() {
                    TitanPlayerController.S1(TitanPlayerController.this);
                }
            });
        }
    }

    public final void d3(boolean z10) {
        if (z10) {
            E4();
            ((ImageView) _$_findCachedViewById(R$id.mIvShare)).setVisibility(0);
            ((AutoLinearLayout) _$_findCachedViewById(R$id.mLlFunction)).setVisibility(0);
            _$_findCachedViewById(R$id.mLlBrightnessController).setVisibility(0);
            _$_findCachedViewById(R$id.mLlVolumeController).setVisibility(0);
            ((ImageView) _$_findCachedViewById(R$id.mImagePlay)).setVisibility(8);
            ((ImageView) _$_findCachedViewById(R$id.mImageFullScreen)).setVisibility(8);
            ((TextView) _$_findCachedViewById(R$id.mTextTotalTime)).setVisibility(8);
            ((TextView) _$_findCachedViewById(R$id.mFullTotalTime)).setVisibility(0);
            setVodSubtitleAudioVisibility(0);
            ((ImageView) _$_findCachedViewById(R$id.mImageBack)).setVisibility(0);
            getSubtitleAudioPorWindow().dismiss();
            ((TextView) _$_findCachedViewById(R$id.mTextTitle)).setVisibility(0);
            if (this.f8458f != null) {
                if (t9.i.b(this.B, "1")) {
                    ((AutoLinearLayout) _$_findCachedViewById(R$id.mLlEpisodes)).setVisibility(8);
                } else {
                    ((AutoLinearLayout) _$_findCachedViewById(R$id.mLlEpisodes)).setVisibility(0);
                }
            }
            if (U2()) {
                ((AutoLinearLayout) _$_findCachedViewById(R$id.mLlQuality)).setVisibility(0);
                ((ImageView) _$_findCachedViewById(R$id.mImageQuality)).setVisibility(8);
            }
        } else {
            ((ImageView) _$_findCachedViewById(R$id.mImageGesture)).setVisibility(8);
            ((AutoLinearLayout) _$_findCachedViewById(R$id.mLlFunction)).setVisibility(8);
            _$_findCachedViewById(R$id.mLlBrightnessController).setVisibility(8);
            _$_findCachedViewById(R$id.mLlVolumeController).setVisibility(8);
            ((ImageView) _$_findCachedViewById(R$id.mImagePlay)).setVisibility(0);
            ((ImageView) _$_findCachedViewById(R$id.mImageFullScreen)).setVisibility(0);
            ((TextView) _$_findCachedViewById(R$id.mTextTotalTime)).setVisibility(0);
            ((TextView) _$_findCachedViewById(R$id.mFullTotalTime)).setVisibility(8);
            setVodSubtitleAudioVisibility(0);
            ((ImageView) _$_findCachedViewById(R$id.mImageBack)).setVisibility(8);
            ((ImageView) _$_findCachedViewById(R$id.mIvShare)).setVisibility(8);
            ((TextView) _$_findCachedViewById(R$id.mTextTitle)).setVisibility(8);
            ((AutoFrameLayout) _$_findCachedViewById(R$id.mLayoutSetInfo)).setVisibility(8);
            Disposable disposable = this.C0;
            if (disposable != null) {
                disposable.dispose();
            }
            D4(false);
            if (U2()) {
                ((AutoLinearLayout) _$_findCachedViewById(R$id.mLlQuality)).setVisibility(8);
                ((ImageView) _$_findCachedViewById(R$id.mImageQuality)).setVisibility(0);
            }
            getSubtitleAudioLandWindow().dismiss();
            getSubtitleAudioPorWindow().dismiss();
            ((AutoFrameLayout) _$_findCachedViewById(R$id.mFlLocked)).setVisibility(8);
            Disposable disposable2 = this.B0;
            if (disposable2 != null) {
                disposable2.dispose();
            }
        }
        CommonDialog commonDialog = this.A0;
        if (commonDialog != null) {
            commonDialog.dismiss();
        }
        U3();
    }

    @Override // z5.c.d
    public void e0() {
    }

    public final void e3() {
        this.J = 0L;
        this.K = false;
        int i10 = R$id.mSeekBar;
        ((CurTimeSeekBar) _$_findCachedViewById(i10)).setProgress(0);
        ((CurTimeSeekBar) _$_findCachedViewById(i10)).setSecondaryProgress(0);
        ((TextView) _$_findCachedViewById(R$id.mTextTotalTime)).setText("00:00");
        ((TextView) _$_findCachedViewById(R$id.mFullTotalTime)).setText("00:00");
        ((ImageView) _$_findCachedViewById(R$id.mImagePlay)).setImageResource(R.drawable.ic_vod_pause);
        a3();
        this.f8465i0 = 0L;
        this.E = false;
        this.f8463h0 = false;
    }

    public final void f2(int i10) {
        this.H = true;
        int i11 = R$id.mSeekBar;
        int progress = ((CurTimeSeekBar) _$_findCachedViewById(i11)).getProgress() + i10;
        if (progress > ((CurTimeSeekBar) _$_findCachedViewById(i11)).getMax()) {
            progress = ((CurTimeSeekBar) _$_findCachedViewById(i11)).getMax();
        } else if (progress < 0) {
            progress = 0;
        }
        ((CurTimeSeekBar) _$_findCachedViewById(i11)).setProgress(progress);
        ((TitanVODView) _$_findCachedViewById(R$id.mVideoViewVod)).x(((CurTimeSeekBar) _$_findCachedViewById(i11)).getProgress());
        if (((CurTimeSeekBar) _$_findCachedViewById(i11)).getProgress() != ((CurTimeSeekBar) _$_findCachedViewById(i11)).getMax()) {
            this.D = false;
        }
    }

    public final void f3(final AudioSettingBean audioSettingBean) {
        Observable compose = Observable.create(new ObservableOnSubscribe() { // from class: m6.q1
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                TitanPlayerController.g3(TitanPlayerController.this, audioSettingBean, observableEmitter);
            }
        }).compose(ma.q.b());
        final o oVar = new o();
        Consumer consumer = new Consumer() { // from class: m6.r1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TitanPlayerController.h3(s9.l.this, obj);
            }
        };
        final p pVar = new p();
        compose.subscribe(consumer, new Consumer() { // from class: m6.s1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TitanPlayerController.i3(s9.l.this, obj);
            }
        });
    }

    @Override // o8.a
    public d8.d g1(List list) {
        t9.i.g(list, "audioTrackList");
        if (!this.f8489u0 || this.f8487t0 == null) {
            return null;
        }
        this.f8489u0 = false;
        TitanVODView titanVODView = (TitanVODView) _$_findCachedViewById(R$id.mVideoViewVod);
        AudioTrackBean audioTrackBean = this.f8487t0;
        t9.i.d(audioTrackBean);
        String realAudio = audioTrackBean.getRealAudio();
        AudioTrackBean audioTrackBean2 = this.f8487t0;
        t9.i.d(audioTrackBean2);
        return titanVODView.q(realAudio, audioTrackBean2.getPosition());
    }

    public final String g2(int i10) {
        SubTitleData subTitleData;
        String language;
        List list = this.f8484s;
        Integer valueOf = list != null ? Integer.valueOf(list.size()) : null;
        t9.i.d(valueOf);
        if (i10 >= valueOf.intValue()) {
            return i10 != 0 ? i10 != 1 ? "es" : XML.DEFAULT_CONTENT_LANGUAGE : "pt";
        }
        List list2 = this.f8484s;
        return (list2 == null || (subTitleData = (SubTitleData) list2.get(i10 - 1)) == null || (language = subTitleData.getLanguage()) == null) ? "es" : language;
    }

    public final String getCastStatusHost() {
        return this.f8481q0;
    }

    public final SimpleProgramList getCurPlayProgram() {
        return this.f8464i;
    }

    public final AssetData getData() {
        return this.f8458f;
    }

    public final boolean getEnableNoWifiPlay() {
        return this.f8496y;
    }

    public final EnterType getEnterType() {
        return this.f8466j;
    }

    public final f5.c getMActivity() {
        return (f5.c) this.f8454b.getValue();
    }

    public final String getMDetailDataContentId() {
        return this.f8477o0;
    }

    public final Movie getMMovie() {
        return this.f8462h;
    }

    public final q5.j getMOrientationHelper() {
        return this.f8455c;
    }

    public final TitanPlayerController getMView() {
        return this.f8453a;
    }

    public final VodDao getMVodDao() {
        return this.f8457e;
    }

    public final Links getProgramBookMark() {
        return this.f8498z;
    }

    public final String getTopicName() {
        return this.f8468k;
    }

    @xa.j
    public final void googleCastToPlay(GoogleCastToPlayEvent googleCastToPlayEvent) {
        t9.i.g(googleCastToPlayEvent, "event");
    }

    public final void h2(int i10) {
        if (i10 == 1) {
            ((ImageView) _$_findCachedViewById(R$id.mImagePlayCast)).setImageResource(R.drawable.icon_play_white);
            this.C = 0L;
            Links links = this.f8498z;
            if (links == null) {
                return;
            }
            links.setRecordTime(0L);
            return;
        }
        if (i10 == 3) {
            int i11 = R$id.mTvCastState;
            ((TextView) _$_findCachedViewById(i11)).setText(getContext().getResources().getString(R.string.cast_status_casting));
            ((TextView) _$_findCachedViewById(i11)).setTextColor(getContext().getResources().getColor(R.color.color_fffefe));
            ((TextView) _$_findCachedViewById(R$id.mTvPleaseWait)).setVisibility(8);
            ((TextView) _$_findCachedViewById(R$id.mTvCastRecommendHint)).setVisibility(4);
            q3();
            ((ImageView) _$_findCachedViewById(R$id.mImagePlayCast)).setImageResource(R.drawable.icon_pause_white);
            return;
        }
        if (i10 != 4) {
            return;
        }
        int i12 = R$id.mTvCastState;
        ((TextView) _$_findCachedViewById(i12)).setText(getContext().getResources().getString(R.string.cast_status_casting_failed));
        ((TextView) _$_findCachedViewById(i12)).append("(4)");
        ((TextView) _$_findCachedViewById(i12)).setTextColor(getContext().getResources().getColor(R.color.color_f72f2f));
        ((TextView) _$_findCachedViewById(R$id.mTvPleaseWait)).setVisibility(8);
        ((TextView) _$_findCachedViewById(R$id.mTvCastRecommendHint)).setVisibility(0);
        ((ImageView) _$_findCachedViewById(R$id.mImagePlayCast)).setImageResource(R.drawable.icon_play_white);
        Z2();
    }

    @xa.j
    public final void handleNetChange(NetworkEvent networkEvent) {
        t9.i.g(networkEvent, "event");
        NetworkEvent.NetState netState = NetworkEvent.NetState.NO_NET;
        if (netState == networkEvent.getMState() && ((TitanVODView) _$_findCachedViewById(R$id.mVideoViewVod)).s()) {
            f1.f8649a.t(R.string.net_remind_net_break);
        } else if (NetworkEvent.NetState.WIFI == networkEvent.getMState() && this.f8494x) {
            post(new Runnable() { // from class: m6.i
                @Override // java.lang.Runnable
                public final void run() {
                    TitanPlayerController.i2(TitanPlayerController.this);
                }
            });
        } else if (NetworkEvent.NetState.MOBILE == networkEvent.getMState() && this.f8494x && this.f8496y) {
            post(new Runnable() { // from class: m6.j
                @Override // java.lang.Runnable
                public final void run() {
                    TitanPlayerController.j2(TitanPlayerController.this);
                }
            });
        }
        if (com.mobile.brasiltv.utils.h.f8694a.o() && netState == networkEvent.getMState()) {
            f1.f8649a.t(R.string.net_remind_net_break);
        }
    }

    @xa.j
    public final void handlePlaySetIndexEvent(PlaySetIndexEvent playSetIndexEvent) {
        t9.i.g(playSetIndexEvent, "event");
        if (playSetIndexEvent.isVideoStop()) {
            setStage(this.f8476o);
            int i10 = R$id.mTextTitle;
            TextView textView = (TextView) _$_findCachedViewById(i10);
            if (textView != null) {
                AssetData assetData = this.f8458f;
                String alias = assetData != null ? assetData.getAlias() : null;
                AssetData assetData2 = this.f8458f;
                textView.setText(com.mobile.brasiltv.utils.b0.c(alias, assetData2 != null ? assetData2.getName() : null));
            }
            BeforeVodAdView beforeVodAdView = (BeforeVodAdView) _$_findCachedViewById(R$id.mBvavAd);
            if (beforeVodAdView != null) {
                AssetData assetData3 = this.f8458f;
                String alias2 = assetData3 != null ? assetData3.getAlias() : null;
                AssetData assetData4 = this.f8458f;
                beforeVodAdView.setTitle(com.mobile.brasiltv.utils.b0.c(alias2, assetData4 != null ? assetData4.getName() : null));
            }
            AssetData assetData5 = this.f8458f;
            t9.i.d(assetData5);
            if (t9.i.b("movie", assetData5.getProgramType())) {
                return;
            }
            ((TextView) _$_findCachedViewById(i10)).append(" ");
            TextView textView2 = (TextView) _$_findCachedViewById(i10);
            SimpleProgramList simpleProgramList = this.f8464i;
            t9.i.d(simpleProgramList);
            textView2.append(String.valueOf(simpleProgramList.getSeriesNumber()));
            return;
        }
        c3();
        this.I0 = true;
        if (this.f8494x) {
            w2();
            int i11 = R$id.mVideoViewVod;
            if (((TitanVODView) _$_findCachedViewById(i11)).s() || com.mobile.brasiltv.utils.h.f8694a.o()) {
                k3(this, 0L, 1, null);
            }
            if (!playSetIndexEvent.isVideoStop()) {
                ((TitanVODView) _$_findCachedViewById(i11)).D();
            }
            this.f8476o = playSetIndexEvent.getPlaySetIndex();
            this.C = 0L;
            int i12 = R$id.mBvavAd;
            ((BeforeVodAdView) _$_findCachedViewById(i12)).hideBeforeVodAd();
            if (playSetIndexEvent.isCast()) {
                ((AutoLinearLayout) _$_findCachedViewById(R$id.mLayoutStage)).setVisibility(8);
                ((ImageView) _$_findCachedViewById(R$id.mIvStage)).setVisibility(8);
                V1(this, false, false, 2, null);
            } else {
                setStage(this.f8476o);
                if (this.f8464i == null) {
                    if (!playSetIndexEvent.isVideoStop()) {
                        H4();
                    }
                } else if (!this.G) {
                    this.V = true;
                    this.I = true;
                    ((ImageView) _$_findCachedViewById(R$id.mPlayPauseIcon)).setVisibility(8);
                    D4(false);
                    ((RelativeLayout) _$_findCachedViewById(R$id.mBufferView)).setVisibility(0);
                } else if (!playSetIndexEvent.isVideoStop()) {
                    H4();
                }
            }
            AssetData assetData6 = this.f8458f;
            t9.i.d(assetData6);
            this.f8464i = assetData6.getSimpleProgramList().get(this.f8476o);
            getSetInfoAdapter().c(this.f8476o);
            int i13 = R$id.mTextTitle;
            TextView textView3 = (TextView) _$_findCachedViewById(i13);
            AssetData assetData7 = this.f8458f;
            t9.i.d(assetData7);
            String alias3 = assetData7.getAlias();
            AssetData assetData8 = this.f8458f;
            t9.i.d(assetData8);
            textView3.setText(com.mobile.brasiltv.utils.b0.c(alias3, assetData8.getName()));
            BeforeVodAdView beforeVodAdView2 = (BeforeVodAdView) _$_findCachedViewById(i12);
            AssetData assetData9 = this.f8458f;
            t9.i.d(assetData9);
            String alias4 = assetData9.getAlias();
            AssetData assetData10 = this.f8458f;
            t9.i.d(assetData10);
            beforeVodAdView2.setTitle(com.mobile.brasiltv.utils.b0.c(alias4, assetData10.getName()));
            AssetData assetData11 = this.f8458f;
            t9.i.d(assetData11);
            if (t9.i.b("movie", assetData11.getProgramType())) {
                return;
            }
            ((TextView) _$_findCachedViewById(i13)).append(" ");
            TextView textView4 = (TextView) _$_findCachedViewById(i13);
            SimpleProgramList simpleProgramList2 = this.f8464i;
            t9.i.d(simpleProgramList2);
            textView4.append(String.valueOf(simpleProgramList2.getSeriesNumber()));
        }
    }

    @xa.j(threadMode = ThreadMode.MAIN)
    public final void handleSubDownloadFinish(SubTitleDownloadFinishEvent subTitleDownloadFinishEvent) {
        t9.i.g(subTitleDownloadFinishEvent, "event");
        com.mobile.brasiltv.utils.b0.U(this, "字幕文件下载完成");
        this.f8482r = true;
        if (com.mobile.brasiltv.utils.b0.I(this.f8484s)) {
            List list = this.f8484s;
            t9.i.d(list);
            if (list.size() > this.f8467j0) {
                if (this.f8469k0 == -1) {
                    this.f8469k0 = 0;
                }
                if (this.f8471l0 == -1) {
                    this.f8471l0 = 0;
                }
                int i10 = R$id.mVideoViewVod;
                TitanVODView titanVODView = (TitanVODView) _$_findCachedViewById(i10);
                SubtitleManager subtitleManager = SubtitleManager.INSTANCE;
                titanVODView.K(subtitleManager.getPortraitSizeValues()[this.f8469k0].intValue(), subtitleManager.getLandscapeSizeValues()[this.f8469k0].intValue());
                if (this.f8471l0 == 2) {
                    ((TitanVODView) _$_findCachedViewById(i10)).setSubtitleColor(subtitleManager.getColorValues()[0].intValue());
                    ((TitanVODView) _$_findCachedViewById(i10)).setSubtitleBg(1);
                } else {
                    ((TitanVODView) _$_findCachedViewById(i10)).setSubtitleColor(subtitleManager.getColorValues()[this.f8471l0].intValue());
                    ((TitanVODView) _$_findCachedViewById(i10)).setSubtitleBg(0);
                }
                ((TitanVODView) _$_findCachedViewById(i10)).setSubtitleVisible(this.f8473m0);
                TitanVODView titanVODView2 = (TitanVODView) _$_findCachedViewById(i10);
                List list2 = this.f8484s;
                t9.i.d(list2);
                titanVODView2.J(((SubTitleData) list2.get(this.f8467j0)).getFilePath(), subTitleDownloadFinishEvent.getContentId());
            }
        }
    }

    public final void j3(long j10) {
        long j11;
        long j12;
        VodDao vodDao;
        long max = ((CurTimeSeekBar) _$_findCachedViewById(R$id.mSeekBar)).getMax();
        AutoLinearLayout autoLinearLayout = (AutoLinearLayout) _$_findCachedViewById(R$id.llCastContainer);
        boolean z10 = false;
        if (autoLinearLayout != null && autoLinearLayout.getVisibility() == 0) {
            z10 = true;
        }
        if (z10) {
            int i10 = R$id.mSeekBarCast;
            j12 = ((SeekBar) _$_findCachedViewById(i10)).getMax() * 1000;
            j11 = ((SeekBar) _$_findCachedViewById(i10)).getProgress() * 1000;
        } else {
            if (j10 == 0) {
                j10 = this.C;
            }
            j11 = j10;
            j12 = max;
        }
        if ((this.f8470l || j11 < 1 || j11 < 1) && !((TitanPlayerController) _$_findCachedViewById(R$id.mVodPlayer)).I) {
            return;
        }
        int i11 = this.L0;
        if ((i11 == 0 || Math.abs(i11 - j11) >= NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS) && (vodDao = this.f8457e) != null) {
            vodDao.addRecord(this.f8458f, this.f8464i, j11, this.f8476o, this.B, j12);
        }
    }

    public final void k2(boolean z10) {
        if (z10) {
            this.f8455c.p(g.f8525a);
            return;
        }
        int i10 = R$id.mLayoutSetInfo;
        if (((AutoFrameLayout) _$_findCachedViewById(i10)).getVisibility() != 0) {
            this.f8455c.p(h.f8527a);
            return;
        }
        Disposable disposable = this.C0;
        if (disposable != null) {
            disposable.dispose();
        }
        AutoFrameLayout autoFrameLayout = (AutoFrameLayout) _$_findCachedViewById(i10);
        t9.i.f(autoFrameLayout, "mLayoutSetInfo");
        N4(autoFrameLayout, AutoUtils.getPercentWidthSize(580));
    }

    @Override // o8.a
    public void l0() {
    }

    public final void l3(final SubtitleSettingBean subtitleSettingBean) {
        Observable compose = Observable.create(new ObservableOnSubscribe() { // from class: m6.m1
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                TitanPlayerController.m3(TitanPlayerController.this, subtitleSettingBean, observableEmitter);
            }
        }).compose(ma.q.b());
        final q qVar = new q();
        Consumer consumer = new Consumer() { // from class: m6.n1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TitanPlayerController.n3(s9.l.this, obj);
            }
        };
        final r rVar = new r();
        compose.subscribe(consumer, new Consumer() { // from class: m6.o1
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                TitanPlayerController.o3(s9.l.this, obj);
            }
        });
    }

    @Override // o8.a
    public void m(String str, String str2, long j10) {
        t9.i.g(str, "adName");
        t9.i.g(str2, "path");
    }

    @Override // o8.a
    public void m2() {
        if (((ImageView) _$_findCachedViewById(R$id.mIvStage)).getVisibility() != 0 && this.f8464i != null) {
            ((RelativeLayout) _$_findCachedViewById(R$id.mBufferView)).setVisibility(8);
        }
        this.H = false;
    }

    @Override // o8.a
    public void n2() {
        if (this.f8464i != null && ((ImageView) _$_findCachedViewById(R$id.mIvStage)).getVisibility() == 8 && ((ImageView) _$_findCachedViewById(R$id.mPlayPauseIcon)).getVisibility() == 8) {
            ((RelativeLayout) _$_findCachedViewById(R$id.mBufferView)).setVisibility(0);
        }
    }

    public final void o2() {
        this.H = false;
        y2();
        int i10 = R$id.mVideoViewVod;
        ((TitanVODView) _$_findCachedViewById(i10)).D();
        TitanVODView titanVODView = (TitanVODView) _$_findCachedViewById(i10);
        if (titanVODView != null) {
            titanVODView.C();
        }
        b8.b bVar = this.f8456d;
        if (bVar != null) {
            if (bVar == null) {
                t9.i.w("mVoiceHelper");
                bVar = null;
            }
            b8.b.b(bVar, false, 1, null);
        }
        removeView((TitanVODView) _$_findCachedViewById(i10));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Y2();
        setSeekBarClickable(false);
        setKeepScreenOn(true);
        ((TitanVODView) _$_findCachedViewById(R$id.mVideoViewVod)).setAspectRatio(0);
        P3();
    }

    @Override // o8.a
    public void onCompletion() {
        this.C = 0L;
        Links links = this.f8498z;
        if (links != null) {
            links.setRecordTime(0L);
        }
        this.D = true;
        this.f8463h0 = false;
        ((BeforeVodAdView) _$_findCachedViewById(R$id.mBvavAd)).hideBeforeVodAd();
        int i10 = R$id.mSeekBar;
        if (((CurTimeSeekBar) _$_findCachedViewById(i10)).getProgress() < ((CurTimeSeekBar) _$_findCachedViewById(i10)).getMax() - 10000) {
            this.L0 = ((CurTimeSeekBar) _$_findCachedViewById(i10)).getProgress();
            ((CurTimeSeekBar) _$_findCachedViewById(i10)).setProgress(((CurTimeSeekBar) _$_findCachedViewById(i10)).getMax());
            j3(1L);
        } else {
            j3(0L);
        }
        S2();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f8455c.a();
        if (xa.c.c().h(this)) {
            xa.c.c().r(this);
        }
        setKeepScreenOn(false);
        a3();
        int i10 = R$id.mVideoViewVod;
        ((TitanVODView) _$_findCachedViewById(i10)).D();
        TitanVODView titanVODView = (TitanVODView) _$_findCachedViewById(i10);
        if (titanVODView != null) {
            titanVODView.C();
        }
        if (this.f8466j == EnterType.HISTORY) {
            xa.c.c().m(new UpdateRecordAtyEvent());
        }
    }

    @Override // com.mobile.brasiltv.utils.g.b
    public void onLoading() {
        post(new Runnable() { // from class: m6.l
            @Override // java.lang.Runnable
            public final void run() {
                TitanPlayerController.L2(TitanPlayerController.this);
            }
        });
    }

    @Override // com.mobile.brasiltv.utils.g.b
    public void onPositionUpdate(final long j10, final long j11) {
        post(new Runnable() { // from class: m6.i0
            @Override // java.lang.Runnable
            public final void run() {
                TitanPlayerController.O2(j10, j11, this);
            }
        });
    }

    @Override // com.mobile.brasiltv.utils.g.b
    public void onStop() {
        post(new Runnable() { // from class: m6.p
            @Override // java.lang.Runnable
            public final void run() {
                TitanPlayerController.Q2(TitanPlayerController.this);
            }
        });
    }

    @Override // o8.a
    public void p1() {
    }

    public final void p2() {
        ((TitanVODView) _$_findCachedViewById(R$id.mVideoViewVod)).u();
        this.f8494x = false;
    }

    public final void p3(int i10) {
        if (i10 != -1) {
            xa.c.c().j(new PlaySetIndexEvent(i10, false, false, 6, null));
        }
    }

    @Override // o8.a
    public void q0(Status status) {
        t9.i.g(status, Constant.KEY_STATUS);
        com.mobile.brasiltv.utils.h hVar = com.mobile.brasiltv.utils.h.f8694a;
        hVar.K(true);
        com.mobile.brasiltv.utils.g.f8651a.y(false);
        String play_url = status.getPlay_url();
        t9.i.f(play_url, "status.play_url");
        hVar.E(play_url);
        this.f8479p0 = status.isUrl_modified();
        this.f8481q0 = status.getHost();
        int i10 = R$id.mVideoViewVod;
        n8.b titanContext = ((TitanVODView) _$_findCachedViewById(i10)).getTitanContext();
        this.E0 = titanContext != null ? titanContext.a() : null;
        ((TitanVODView) _$_findCachedViewById(i10)).C();
        f5.c mActivity = getMActivity();
        if (mActivity != null) {
            mActivity.runOnUiThread(new Runnable() { // from class: m6.z
                @Override // java.lang.Runnable
                public final void run() {
                    TitanPlayerController.R1(TitanPlayerController.this);
                }
            });
        }
    }

    public final void q2() {
        this.f8494x = true;
        ((ImageView) _$_findCachedViewById(R$id.mImageBack)).setVisibility(0);
        if (this.f8455c.l() || getResources().getConfiguration().orientation == 2) {
            x2();
        }
        if (((AutoRelativeLayout) _$_findCachedViewById(R$id.mMemberTipsLayout)).getVisibility() != 0) {
            ((AlphaRelativeLayout) _$_findCachedViewById(R$id.mLayoutController)).setVisibility(0);
            z3();
            B3();
            Observable<Long> timer = Observable.timer(6L, TimeUnit.SECONDS, AndroidSchedulers.mainThread());
            Context context = getContext();
            t9.i.e(context, "null cannot be cast to non-null type com.mobile.brasiltv.activity.PlayAty");
            Observable<R> compose = timer.compose(((PlayAty) context).O1());
            final i iVar = new i();
            compose.subscribe((Consumer<? super R>) new Consumer() { // from class: m6.k
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    TitanPlayerController.r2(s9.l.this, obj);
                }
            });
        }
        if (this.f8476o == -1 || this.f8458f == null || this.f8464i == null || this.G || !this.S || ((AutoLinearLayout) _$_findCachedViewById(R$id.llCastContainer)).getVisibility() == 0) {
            return;
        }
        PauseAdView pauseAdView = this.A;
        if ((pauseAdView != null ? pauseAdView.getParent() : null) == null) {
            if (this.D) {
                ((TitanVODView) _$_findCachedViewById(R$id.mVideoViewVod)).x(0L);
            } else {
                ((TitanVODView) _$_findCachedViewById(R$id.mVideoViewVod)).w();
            }
        }
    }

    public final void q3() {
        CastDevice castDevice;
        String friendlyName;
        String friendly_name;
        com.mobile.brasiltv.utils.h hVar = com.mobile.brasiltv.utils.h.f8694a;
        String str = "";
        if (t9.i.b(hVar.a(), hVar.k())) {
            int i10 = R$id.mTvCastDevice;
            TextView textView = (TextView) _$_findCachedViewById(i10);
            Device g10 = com.mobile.brasiltv.utils.g.f8651a.g();
            if (g10 != null && (friendly_name = g10.getFriendly_name()) != null) {
                str = friendly_name;
            }
            textView.setText(str);
            ((TextView) _$_findCachedViewById(i10)).append("-DLNA");
            return;
        }
        int i11 = R$id.mTvCastDevice;
        TextView textView2 = (TextView) _$_findCachedViewById(i11);
        CastSession i12 = this.N.i();
        if (i12 != null && (castDevice = i12.getCastDevice()) != null && (friendlyName = castDevice.getFriendlyName()) != null) {
            str = friendlyName;
        }
        textView2.setText(str);
        ((TextView) _$_findCachedViewById(i11)).append("-ChromeCast");
    }

    @Override // o8.a
    public void r1(long j10) {
        this.f8491v0 = j10;
        ((CurTimeSeekBar) _$_findCachedViewById(R$id.mSeekBar)).setSecondaryProgress((int) this.f8491v0);
    }

    public final void r3() {
        ((ImageView) _$_findCachedViewById(R$id.mImagePlayCast)).setOnClickListener(new View.OnClickListener() { // from class: m6.a0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TitanPlayerController.s3(TitanPlayerController.this, view);
            }
        });
        ((ImageView) _$_findCachedViewById(R$id.mIvCastQuality)).setOnClickListener(new View.OnClickListener() { // from class: m6.b0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TitanPlayerController.t3(TitanPlayerController.this, view);
            }
        });
        ((ImageView) _$_findCachedViewById(R$id.mIvCastClose)).setOnClickListener(new View.OnClickListener() { // from class: m6.c0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TitanPlayerController.u3(TitanPlayerController.this, view);
            }
        });
        ((ImageView) _$_findCachedViewById(R$id.mIvCastSwitchDevice)).setOnClickListener(new View.OnClickListener() { // from class: m6.d0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TitanPlayerController.v3(TitanPlayerController.this, view);
            }
        });
        ((ImageView) _$_findCachedViewById(R$id.mIvCastFeedback)).setOnClickListener(new View.OnClickListener() { // from class: m6.e0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TitanPlayerController.w3(TitanPlayerController.this, view);
            }
        });
        ((SeekBar) _$_findCachedViewById(R$id.mSeekBarCast)).setOnSeekBarChangeListener(new t());
    }

    public final void s2(VodDao vodDao, AssetData assetData, String str, EnterType enterType, String str2, boolean z10, boolean z11) {
        t9.i.g(vodDao, "vodDao");
        t9.i.g(assetData, "program");
        t9.i.g(str, "vodType");
        this.D0 = true;
        this.f8457e = vodDao;
        this.f8458f = assetData;
        this.f8477o0 = assetData.getContentId();
        this.B = str;
        this.f8466j = enterType;
        this.f8468k = str2;
        this.f8470l = z10;
        ((BeforeVodAdView) _$_findCachedViewById(R$id.mBvavAd)).setCr(z10);
        int i10 = R$id.recyclerSetInfo;
        ((RecyclerView) _$_findCachedViewById(i10)).setItemAnimator(null);
        GridLayoutManagerWrapper gridLayoutManagerWrapper = new GridLayoutManagerWrapper(getContext(), 5);
        if (((RecyclerView) _$_findCachedViewById(i10)).getItemDecorationCount() != 0) {
            ((RecyclerView) _$_findCachedViewById(i10)).removeItemDecorationAt(0);
        }
        ((RecyclerView) _$_findCachedViewById(i10)).addItemDecoration(new GridDecoration(AutoUtils.getPercentHeightSize(36), 5));
        ((RecyclerView) _$_findCachedViewById(i10)).setLayoutManager(gridLayoutManagerWrapper);
        ((RecyclerView) _$_findCachedViewById(i10)).setAdapter(getSetInfoAdapter());
        n6.a setInfoAdapter = getSetInfoAdapter();
        AssetData assetData2 = this.f8458f;
        t9.i.d(assetData2);
        setInfoAdapter.setNewData(assetData2.getSimpleProgramList());
        if (z11) {
            z2();
        }
        Z3();
        r3();
        x3();
        Q3();
    }

    public final void setCastStatusHost(String str) {
        this.f8481q0 = str;
    }

    public final void setCr(boolean z10) {
        this.f8470l = z10;
    }

    public final void setCurPlayProgram(SimpleProgramList simpleProgramList) {
        this.f8464i = simpleProgramList;
    }

    public final void setData(AssetData assetData) {
        this.f8458f = assetData;
    }

    public final void setEnableNoWifiPlay(boolean z10) {
        this.f8496y = z10;
    }

    public final void setEnterType(EnterType enterType) {
        this.f8466j = enterType;
    }

    public final void setMDetailDataContentId(String str) {
        this.f8477o0 = str;
    }

    public final void setMMovie(Movie movie) {
        this.f8462h = movie;
    }

    public final void setMOrientationHelper(q5.j jVar) {
        t9.i.g(jVar, "<set-?>");
        this.f8455c = jVar;
    }

    public final void setMVodDao(VodDao vodDao) {
        this.f8457e = vodDao;
    }

    public final void setPlayNextSeries(boolean z10) {
        this.I = z10;
    }

    public final void setProgramBookMark(Links links) {
        this.f8498z = links;
    }

    public final void setProgramLoad(boolean z10) {
        this.D0 = z10;
    }

    public final void setResumed(boolean z10) {
        this.f8494x = z10;
    }

    public final void setSubData(List<SubTitleData> list) {
        t9.i.g(list, "list");
        this.f8484s = list;
        setDefaultSubtitleOption(list);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        arrayList.add(0, this.f8497y0);
        getSubtitleAudioLandWindow().p(arrayList, this.f8467j0 + 1);
        getSubtitleAudioLandWindow().r(getSizeList(), this.f8469k0);
        getSubtitleAudioLandWindow().n(getStyleList(), this.f8471l0);
        getSubtitleAudioLandWindow().q(this.f8473m0);
        getSubtitleAudioPorWindow().p(arrayList, this.f8467j0 + 1);
        getSubtitleAudioPorWindow().r(getSizeList(), this.f8469k0);
        getSubtitleAudioPorWindow().n(getStyleList(), this.f8471l0);
        getSubtitleAudioPorWindow().q(this.f8473m0);
    }

    public final void setSupportUrlModified(boolean z10) {
        this.f8479p0 = z10;
    }

    public final void setTopicName(String str) {
        this.f8468k = str;
    }

    public final void setVodFuncCallback(m6.a aVar) {
        t9.i.g(aVar, "callback");
        this.M = aVar;
    }

    public final void setVodQualityVisibility(int i10) {
        if (i10 == 8) {
            ((AutoLinearLayout) _$_findCachedViewById(R$id.mLlQuality)).setVisibility(8);
            ((ImageView) _$_findCachedViewById(R$id.mImageQuality)).setVisibility(8);
        } else if (B2()) {
            ((AutoLinearLayout) _$_findCachedViewById(R$id.mLlQuality)).setVisibility(i10);
        } else {
            ((ImageView) _$_findCachedViewById(R$id.mImageQuality)).setVisibility(i10);
        }
    }

    public final void setVodSubtitleAudioVisibility(int i10) {
        if (i10 != 0 || !this.f8486t) {
            ((ImageView) _$_findCachedViewById(R$id.mIvSubtitleAudio)).setVisibility(8);
            ((AutoLinearLayout) _$_findCachedViewById(R$id.mLlAudioLanguage)).setVisibility(8);
        } else {
            if (B2()) {
                ((ImageView) _$_findCachedViewById(R$id.mIvSubtitleAudio)).setVisibility(8);
            } else {
                ((ImageView) _$_findCachedViewById(R$id.mIvSubtitleAudio)).setVisibility(0);
            }
            ((AutoLinearLayout) _$_findCachedViewById(R$id.mLlAudioLanguage)).setVisibility(0);
        }
    }

    public final void setWaitingCastUrl(boolean z10) {
        this.J0 = z10;
    }

    @Override // o8.a
    public void t0() {
    }

    public final void t2(AssetData assetData) {
        t9.i.g(assetData, "program");
        this.f8458f = assetData;
        if (this.D0) {
            return;
        }
        z2();
        Z3();
        r3();
        x3();
        Q3();
    }

    @Override // o8.a
    public void u(int i10) {
        p6.b bVar = p6.b.f18069a;
        Context context = getContext();
        t9.i.f(context, com.umeng.analytics.pro.f.X);
        String a10 = bVar.a(context, i10);
        if ((a10 == null || a10.length() == 0) || !this.f8494x) {
            return;
        }
        f1.f8649a.u(a10 + ' ' + w6.i.f19214g.H());
    }

    public final boolean v2(MotionEvent motionEvent, MotionEvent motionEvent2, float f10, float f11) {
        float f12;
        if (motionEvent == null || motionEvent2 == null) {
            return true;
        }
        float rawX = motionEvent.getRawX();
        float rawX2 = motionEvent2.getRawX();
        float rawY = motionEvent.getRawY();
        float rawY2 = motionEvent2.getRawY();
        int width = getWidth();
        if (this.L == b.NONE) {
            com.mobile.brasiltv.utils.b0.U(this, "NONE");
            float f13 = rawY - rawY2;
            if (Math.abs(rawX - rawX2) < Math.abs(f13)) {
                double d10 = rawX;
                f12 = rawX;
                double d11 = width;
                Double.isNaN(d11);
                if (d10 <= (d11 * 1.0d) / 2.0d) {
                    this.L = b.BRIGHTNESS;
                } else if (Math.abs(f11) > 3.0f) {
                    this.L = b.VOLUME;
                }
            } else {
                f12 = rawX;
                if (Math.abs(rawX2 - f12) > Math.abs(f13) + 30) {
                    this.L = b.FF_REW;
                }
            }
        } else {
            f12 = rawX;
        }
        int i10 = c.f8511a[this.L.ordinal()];
        if (i10 == 1) {
            com.mobile.brasiltv.utils.b0.U(this, "VOLUME");
            double d12 = f12;
            double d13 = width;
            Double.isNaN(d13);
            if (d12 <= (d13 * 1.0d) / 2.0d) {
                return true;
            }
            R2(motionEvent2);
            return true;
        }
        if (i10 != 2) {
            if (i10 != 3) {
                return true;
            }
            com.mobile.brasiltv.utils.b0.U(this, "FF_REW");
            float f14 = rawX2 - f12;
            if (Math.abs(f14) <= Math.abs(rawY - rawY2) + 30) {
                return true;
            }
            P2((f14 / width) / 3);
            return true;
        }
        com.mobile.brasiltv.utils.b0.U(this, "BRIGHTNESS");
        double d14 = f12;
        double d15 = width;
        Double.isNaN(d15);
        if (d14 > (d15 * 1.0d) / 2.0d) {
            return true;
        }
        G2(f11 / AutoUtils.getPercentHeightSize(280));
        return true;
    }

    @Override // o8.a
    public boolean w1() {
        return false;
    }

    public final void w2() {
        PauseAdView pauseAdView = this.A;
        if (pauseAdView != null) {
            if ((pauseAdView != null ? pauseAdView.getParent() : null) != null) {
                removeView(this.A);
            }
        }
    }

    public final void x2() {
        Window window = getMActivity().getWindow();
        View decorView = window != null ? window.getDecorView() : null;
        if (decorView == null) {
            return;
        }
        decorView.setSystemUiVisibility(q.a.f10527g);
    }

    public final void x3() {
        ((TextView) _$_findCachedViewById(R$id.tvConfirm)).setOnClickListener(new View.OnClickListener() { // from class: m6.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TitanPlayerController.y3(TitanPlayerController.this, view);
            }
        });
    }

    public final void y2() {
    }

    public final void y4(int i10, int i11) {
        ((ImageView) _$_findCachedViewById(R$id.mImageQuality)).setImageResource(i11);
        ((ImageView) _$_findCachedViewById(R$id.mIvLandQuality)).setImageResource(i10);
    }

    @Override // o8.a
    public void z() {
        this.W = true;
        if (s6.a.f18777a.a().o()) {
            ((ImageView) _$_findCachedViewById(R$id.mImageCast)).setVisibility(0);
        } else {
            ((ImageView) _$_findCachedViewById(R$id.mImageCast)).setVisibility(8);
        }
        U3();
        U4();
        this.f8465i0 = System.currentTimeMillis();
        this.H = false;
        if (!this.V || !X1() || !this.f8459f0) {
            ((TitanVODView) _$_findCachedViewById(R$id.mVideoViewVod)).u();
            return;
        }
        X2();
        int i10 = R$id.mVideoViewVod;
        if (!((TitanVODView) _$_findCachedViewById(i10)).s()) {
            ((TitanVODView) _$_findCachedViewById(i10)).w();
        }
        if (this.f8461g0) {
            ((TitanVODView) _$_findCachedViewById(i10)).x(this.C);
            this.f8461g0 = false;
        }
        if (this.f8494x) {
            return;
        }
        ((TitanVODView) _$_findCachedViewById(i10)).u();
    }

    public final void z2() {
        this.f8486t = false;
        setVodSubtitleAudioVisibility(8);
        this.f8475n0 = 0;
        this.f8467j0 = -1;
        this.f8469k0 = -1;
        this.f8471l0 = -1;
        this.f8473m0 = false;
        getSubtitleAudioLandWindow().m(i9.j.c(this.f8499z0), this.f8475n0);
        getSubtitleAudioLandWindow().p(i9.j.c(this.f8495x0), this.f8467j0 + 1);
        getSubtitleAudioLandWindow().r(getSizeList(), this.f8469k0);
        getSubtitleAudioLandWindow().n(getStyleList(), this.f8471l0);
        getSubtitleAudioLandWindow().q(this.f8473m0);
        getSubtitleAudioPorWindow().m(i9.j.c(this.f8499z0), this.f8475n0);
        getSubtitleAudioPorWindow().p(i9.j.c(this.f8495x0), this.f8467j0 + 1);
        getSubtitleAudioPorWindow().r(getSizeList(), this.f8469k0);
        getSubtitleAudioPorWindow().n(getStyleList(), this.f8471l0);
        getSubtitleAudioPorWindow().q(this.f8473m0);
    }

    public final void z3() {
        ((ProgressBar) _$_findCachedViewById(R$id.mPbBrightness)).setProgress((int) (getRealCurBrightness() * 100));
    }

    public final void z4() {
        Window window = getMActivity().getWindow();
        View decorView = window != null ? window.getDecorView() : null;
        if (decorView != null) {
            decorView.setSystemUiVisibility(0);
        }
        n5.a.f17268a.h(getMActivity());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TitanPlayerController(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        t9.i.g(context, com.umeng.analytics.pro.f.X);
        this.N0 = new LinkedHashMap();
        this.f8453a = this;
        this.f8454b = h9.h.b(new l(context));
        this.f8460g = new HashMap();
        this.f8466j = EnterType.CATEGORY;
        this.f8476o = -1;
        this.f8478p = "";
        this.f8480q = "";
        this.f8488u = h9.h.b(g0.f8526a);
        this.f8490v = h9.h.b(new u0());
        this.f8492w = h9.h.b(new v0());
        this.B = "0";
        this.G = true;
        this.L = b.NONE;
        this.N = new z5.c();
        this.O = "";
        this.f8459f0 = true;
        this.f8467j0 = -1;
        this.f8469k0 = -1;
        this.f8471l0 = -1;
        this.f8483r0 = h9.h.b(new s0(context));
        this.f8485s0 = h9.h.b(new t0(context));
        this.f8491v0 = -1L;
        this.f8493w0 = 10000;
        this.f8495x0 = new NoSubTitleData();
        this.f8497y0 = new OffSubTitleData();
        this.f8499z0 = new AudioTrackBean("", "", "no", 0, true);
        this.K0 = h9.h.b(new m(context));
        Y2();
        LayoutInflater.from(context).inflate(R.layout.layout_titan_vod_controller, (ViewGroup) this, true);
        q5.j jVar = new q5.j(getMActivity(), null, 2, null);
        this.f8455c = jVar;
        jVar.d();
        a aVar = new a(getMActivity());
        this.f8456d = aVar;
        aVar.c();
        int a10 = n5.a.f17268a.a(context);
        int percentHeightSize = AutoUtils.getPercentHeightSize(88);
        AutoRelativeLayout.LayoutParams layoutParams = new AutoRelativeLayout.LayoutParams(percentHeightSize, percentHeightSize);
        layoutParams.setMargins(0, a10, 0, 0);
        int i11 = R$id.mImageBack;
        ((ImageView) _$_findCachedViewById(i11)).setLayoutParams(layoutParams);
        AutoRelativeLayout.LayoutParams layoutParams2 = new AutoRelativeLayout.LayoutParams(-2, percentHeightSize);
        layoutParams2.setMargins(percentHeightSize, a10, 0, 0);
        ((TextView) _$_findCachedViewById(R$id.mTextTitle)).setLayoutParams(layoutParams2);
        AutoRelativeLayout.LayoutParams layoutParams3 = new AutoRelativeLayout.LayoutParams(-2, percentHeightSize);
        layoutParams3.addRule(11);
        layoutParams3.setMargins(((RelativeLayout.LayoutParams) layoutParams3).leftMargin, a10, ((RelativeLayout.LayoutParams) layoutParams3).rightMargin, ((RelativeLayout.LayoutParams) layoutParams3).bottomMargin);
        ((AutoLinearLayout) _$_findCachedViewById(R$id.llMenu)).setLayoutParams(layoutParams3);
        ((ImageView) _$_findCachedViewById(i11)).setOnClickListener(new View.OnClickListener() { // from class: m6.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TitanPlayerController.M0(TitanPlayerController.this, view);
            }
        });
        setBackgroundColor(getResources().getColor(R.color.color_000000));
        int i12 = R$id.mVideoViewVod;
        ((TitanVODView) _$_findCachedViewById(i12)).setPlayerListener(this);
        ((TitanVODView) _$_findCachedViewById(i12)).setPlayerStateChangeListener(this);
    }

    public /* synthetic */ TitanPlayerController(Context context, AttributeSet attributeSet, int i10, int i11, t9.g gVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
