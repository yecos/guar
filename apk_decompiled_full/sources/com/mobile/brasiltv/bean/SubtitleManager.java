package com.mobile.brasiltv.bean;

import android.content.Context;
import android.text.TextUtils;
import android.util.LruCache;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.google.firebase.dynamiclinks.DynamicLink;
import com.hpplay.component.protocol.PlistBuilder;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.msandroid.mobile.R;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.f;
import i9.j;
import java.util.ArrayList;
import java.util.HashMap;
import t9.i;

/* loaded from: classes3.dex */
public final class SubtitleManager {
    public static final String GLOBAL_AUDIO_LANGUAGE = "global_audio_language";
    public static final String GLOBAL_SUBTITLE_COLOR = "global_subtitle_color";
    public static final String GLOBAL_SUBTITLE_LANGUAGE = "global_subtitle_language";
    public static final String GLOBAL_SUBTITLE_SIZE = "global_subtitle_size";
    public static final String GLOBAL_SUBTITLE_SWITCH = "global_subtitle_switch";
    public static final int SUBTITLE_COLOR_WHITE = 0;
    public static final int SUBTITLE_COLOR_WHITE_BLACK = 2;
    public static final int SUBTITLE_COLOR_YELLOW = 1;
    public static final int SUBTITLE_LANGUAGE_EN = 1;
    public static final int SUBTITLE_LANGUAGE_ES = 2;
    public static final int SUBTITLE_LANGUAGE_PT = 0;
    public static final int SUBTITLE_SIZE_BIG = 2;
    public static final int SUBTITLE_SIZE_NORMAL = 0;
    public static final int SUBTITLE_SIZE_SMALL = 1;
    private static final Integer[] colorValues;
    private static int mGlobalAudioLanguage;
    private static int mGlobalColor;
    private static int mGlobalLanguage;
    private static int mGlobalSize;
    private static LruCache<String, String> mLruCacheAudioLanguages;
    private static LruCache<String, Integer> mLruCacheColor;
    private static HashMap<String, RecordSubtitleInfoBean> mLruCacheLanguages;
    private static LruCache<String, Integer> mLruCacheSize;
    private static LruCache<String, Boolean> mLruCacheSwitch;
    public static final SubtitleManager INSTANCE = new SubtitleManager();
    private static boolean mGlobalSwitch = true;
    private static final Integer[] portraitSizeValues = {11, 8, 14};
    private static final Integer[] landscapeSizeValues = {14, 11, 17};

    static {
        Integer valueOf = Integer.valueOf(R.color.color_important_white);
        colorValues = new Integer[]{valueOf, Integer.valueOf(R.color.color_ffff00), valueOf};
        mLruCacheAudioLanguages = new LruCache<>(100);
        mLruCacheLanguages = new HashMap<>();
        mLruCacheSize = new LruCache<>(100);
        mLruCacheColor = new LruCache<>(100);
        mLruCacheSwitch = new LruCache<>(100);
    }

    private SubtitleManager() {
    }

    public final void clearLruCacheSwitch() {
        mLruCacheSwitch.evictAll();
    }

    public final void clearSelectSubtitle() {
        mLruCacheLanguages.clear();
    }

    public final ArrayList<String> getColorList(Context context) {
        i.g(context, f.X);
        String string = context.getResources().getString(R.string.subtitle_color_white);
        i.f(string, "context.resources.getStr…ing.subtitle_color_white)");
        String string2 = context.getResources().getString(R.string.subtitle_color_yellow);
        i.f(string2, "context.resources.getStr…ng.subtitle_color_yellow)");
        return j.c(string, string2);
    }

    public final Integer[] getColorValues() {
        return colorValues;
    }

    public final Integer[] getLandscapeSizeValues() {
        return landscapeSizeValues;
    }

    public final int getMGlobalAudioLanguage() {
        return mGlobalAudioLanguage;
    }

    public final int getMGlobalColor() {
        return mGlobalColor;
    }

    public final int getMGlobalLanguage() {
        return mGlobalLanguage;
    }

    public final int getMGlobalSize() {
        return mGlobalSize;
    }

    public final boolean getMGlobalSwitch() {
        return mGlobalSwitch;
    }

    public final LruCache<String, String> getMLruCacheAudioLanguages() {
        return mLruCacheAudioLanguages;
    }

    public final LruCache<String, Integer> getMLruCacheColor() {
        return mLruCacheColor;
    }

    public final HashMap<String, RecordSubtitleInfoBean> getMLruCacheLanguages() {
        return mLruCacheLanguages;
    }

    public final LruCache<String, Integer> getMLruCacheSize() {
        return mLruCacheSize;
    }

    public final LruCache<String, Boolean> getMLruCacheSwitch() {
        return mLruCacheSwitch;
    }

    public final Integer[] getPortraitSizeValues() {
        return portraitSizeValues;
    }

    public final ArrayList<String> getSizeList(Context context) {
        i.g(context, f.X);
        String string = context.getResources().getString(R.string.subtitle_size_normal);
        i.f(string, "context.resources.getStr…ing.subtitle_size_normal)");
        String string2 = context.getResources().getString(R.string.subtitle_size_small);
        i.f(string2, "context.resources.getStr…ring.subtitle_size_small)");
        String string3 = context.getResources().getString(R.string.subtitle_size_big);
        i.f(string3, "context.resources.getStr…string.subtitle_size_big)");
        return j.c(string, string2, string3);
    }

    public final ArrayList<SubtitleStyleBean> getStyleList(Context context) {
        i.g(context, f.X);
        ArrayList<SubtitleStyleBean> arrayList = new ArrayList<>();
        arrayList.add(0, new SubtitleStyleBean(context.getResources().getColor(R.color.color_important_white), context.getResources().getColor(R.color.color_pop_translucence)));
        arrayList.add(1, new SubtitleStyleBean(context.getResources().getColor(R.color.color_ffaa00), context.getResources().getColor(R.color.color_pop_translucence)));
        arrayList.add(2, new SubtitleStyleBean(context.getResources().getColor(R.color.color_important_white), context.getResources().getColor(R.color.color_191919)));
        return arrayList;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:1048:0x10d5, code lost:
    
        if (r21.equals("ger") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1049:0x21b3, code lost:
    
        r3 = r20.getString(com.msandroid.mobile.R.string.audio_ger);
        t9.i.f(r3, "mContext.getString(R.string.audio_ger)");
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x01cd, code lost:
    
        if (r21.equals("wel (b)") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1050:?, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1082:0x1163, code lost:
    
        if (r21.equals("fre") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1083:0x2275, code lost:
    
        r3 = r20.getString(com.msandroid.mobile.R.string.language_fr);
        t9.i.f(r3, "mContext.getString(R.string.language_fr)");
     */
    /* JADX WARN: Code restructure failed: missing block: B:1084:?, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x01e5, code lost:
    
        if (r21.equals("hrv (t)") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1113:0x11db, code lost:
    
        if (r21.equals("eus") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1115:?, code lost:
    
        return "Basque";
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:?, code lost:
    
        return "Croatian";
     */
    /* JADX WARN: Code restructure failed: missing block: B:1126:0x1207, code lost:
    
        if (r21.equals("eng") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1127:0x1f99, code lost:
    
        r3 = r20.getString(com.msandroid.mobile.R.string.language_en);
        t9.i.f(r3, "mContext.getString(R.string.language_en)");
     */
    /* JADX WARN: Code restructure failed: missing block: B:1128:?, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0219, code lost:
    
        if (r21.equals("mkd (t)") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1233:0x13d7, code lost:
    
        if (r21.equals("chi") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1234:0x1773, code lost:
    
        r3 = r20.getString(com.msandroid.mobile.R.string.audio_zh);
        t9.i.f(r3, "mContext.getString(R.string.audio_zh)");
     */
    /* JADX WARN: Code restructure failed: missing block: B:1235:?, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:?, code lost:
    
        return "Macedonian";
     */
    /* JADX WARN: Code restructure failed: missing block: B:1282:0x149b, code lost:
    
        if (r21.equals("bod") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0231, code lost:
    
        if (r21.equals("scr (b)(d)") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1325:0x1551, code lost:
    
        if (r21.equals("baq") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1393:0x1657, code lost:
    
        if (r21.equals("ara") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1394:0x2139, code lost:
    
        r3 = r20.getString(com.msandroid.mobile.R.string.audio_ara);
        t9.i.f(r3, "mContext.getString(R.string.audio_ara)");
     */
    /* JADX WARN: Code restructure failed: missing block: B:1395:?, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1418:0x16bf, code lost:
    
        if (r21.equals("alb") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1420:?, code lost:
    
        return "Albanian";
     */
    /* JADX WARN: Code restructure failed: missing block: B:1460:0x176f, code lost:
    
        if (r21.equals("zh") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1526:0x1947, code lost:
    
        if (r21.equals("sr") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1528:0x1951, code lost:
    
        if (r21.equals("sq") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x0299, code lost:
    
        if (r21.equals("mao (b)") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1538:0x1993, code lost:
    
        if (r21.equals("sk") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1540:?, code lost:
    
        return "Slovak";
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x02a3, code lost:
    
        if (r21.equals("mac (b)") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1558:0x1a0d, code lost:
    
        if (r21.equals("ro") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1566:0x1a44, code lost:
    
        if (r21.equals("pt") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x02ad, code lost:
    
        if (r21.equals("ces (t)") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1596:0x1b20, code lost:
    
        if (r21.equals("nl") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1608:0x1b73, code lost:
    
        if (r21.equals("my") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x02c5, code lost:
    
        if (r21.equals("scc (b)(d)") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1624:0x1bde, code lost:
    
        if (r21.equals("mk") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1626:0x1beb, code lost:
    
        if (r21.equals("mi") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:?, code lost:
    
        return "Serbian";
     */
    /* JADX WARN: Code restructure failed: missing block: B:1683:0x1d6e, code lost:
    
        if (r21.equals("ja") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1687:0x1d94, code lost:
    
        if (r21.equals("it") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1713:0x1e50, code lost:
    
        if (r21.equals("hr") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1717:0x1e6b, code lost:
    
        if (r21.equals("hi") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1719:0x1e83, code lost:
    
        if (r21.equals("he") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x02eb, code lost:
    
        if (r21.equals("gre (b)") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1737:0x1f0b, code lost:
    
        if (r21.equals("fr") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:?, code lost:
    
        return "Modern Greek";
     */
    /* JADX WARN: Code restructure failed: missing block: B:1747:0x1f4d, code lost:
    
        if (r21.equals("fa") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1749:?, code lost:
    
        return "Persian";
     */
    /* JADX WARN: Code restructure failed: missing block: B:1751:0x1f57, code lost:
    
        if (r21.equals("eu") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1755:0x1f6f, code lost:
    
        if (r21.equals("es") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1759:0x1f95, code lost:
    
        if (r21.equals(com.hpplay.cybergarage.xml.XML.DEFAULT_CONTENT_LANGUAGE) == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x02f5, code lost:
    
        if (r21.equals("bur (b)") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1761:0x1fad, code lost:
    
        if (r21.equals("el") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1773:0x1ffd, code lost:
    
        if (r21.equals("cy") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1779:0x2026, code lost:
    
        if (r21.equals("cs") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1795:0x2095, code lost:
    
        if (r21.equals("bo") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1819:0x2135, code lost:
    
        if (r21.equals("ar") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1835:0x21af, code lost:
    
        if (r21.equals("ger (b)") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1854:0x2225, code lost:
    
        if (r21.equals("baq (b)") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1866:0x2267, code lost:
    
        if (r21.equals("fre (b)") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1868:0x2271, code lost:
    
        if (r21.equals("fra (t)") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1872:0x2297, code lost:
    
        if (r21.equals("per (b)") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x0333, code lost:
    
        if (r21.equals("bod (t)") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:?, code lost:
    
        return "Tibetan";
     */
    /* JADX WARN: Code restructure failed: missing block: B:1903:0x233b, code lost:
    
        if (r21.equals("fas (t)") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1908:0x2356, code lost:
    
        if (r21.equals("tib (b)") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1910:0x2363, code lost:
    
        if (r21.equals("eus (t)") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1915:0x237e, code lost:
    
        if (r21.equals("ell (t)") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1920:0x2399, code lost:
    
        if (r21.equals("srp (t)") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1922:0x23a5, code lost:
    
        if (r21.equals("sqi (t)") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1933:0x23d5, code lost:
    
        if (r21.equals("slo (b)") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1935:0x23de, code lost:
    
        if (r21.equals("slk (t)") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x008d, code lost:
    
        if (r21.equals("nld (t)") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:?, code lost:
    
        return "Dutch";
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0097, code lost:
    
        if (r21.equals("dut (b)") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:410:0x06b3, code lost:
    
        if (r21.equals("spa") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:411:0x1f73, code lost:
    
        r3 = r20.getString(com.msandroid.mobile.R.string.language_es);
        t9.i.f(r3, "mContext.getString(R.string.language_es)");
     */
    /* JADX WARN: Code restructure failed: missing block: B:412:?, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:528:0x0895, code lost:
    
        if (r21.equals("por") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:529:0x1a48, code lost:
    
        r3 = r20.getString(com.msandroid.mobile.R.string.language_pt);
        t9.i.f(r3, "mContext.getString(R.string.language_pt)");
     */
    /* JADX WARN: Code restructure failed: missing block: B:530:?, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0141, code lost:
    
        if (r21.equals("rum (b)") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:?, code lost:
    
        return "Romanian";
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0159, code lost:
    
        if (r21.equals("mya (t)") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:?, code lost:
    
        return "Burmese";
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x017f, code lost:
    
        if (r21.equals("ron (t)") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01a1, code lost:
    
        if (r21.equals("mri (t)") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:904:0x0ea7, code lost:
    
        if (r21.equals("jpn") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:905:0x1d72, code lost:
    
        r3 = r20.getString(com.msandroid.mobile.R.string.audio_jpn);
        t9.i.f(r3, "mContext.getString(R.string.audio_jpn)");
     */
    /* JADX WARN: Code restructure failed: missing block: B:906:?, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:914:0x0ec9, code lost:
    
        if (r21.equals("ita") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:915:0x1d98, code lost:
    
        r3 = r20.getString(com.msandroid.mobile.R.string.audio_ita);
        t9.i.f(r3, "mContext.getString(R.string.audio_ita)");
     */
    /* JADX WARN: Code restructure failed: missing block: B:916:?, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:?, code lost:
    
        return "Maori";
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01ab, code lost:
    
        if (r21.equals("cze (b)") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:?, code lost:
    
        return "Czech";
     */
    /* JADX WARN: Code restructure failed: missing block: B:971:0x0fa3, code lost:
    
        if (r21.equals("hin") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:972:0x1e6f, code lost:
    
        r3 = r20.getString(com.msandroid.mobile.R.string.language_hi);
        t9.i.f(r3, "mContext.getString(R.string.language_hi)");
     */
    /* JADX WARN: Code restructure failed: missing block: B:973:?, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01b5, code lost:
    
        if (r21.equals("cym (t)") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:981:0x0fc5, code lost:
    
        if (r21.equals("heb") == false) goto L2618;
     */
    /* JADX WARN: Code restructure failed: missing block: B:982:0x1e87, code lost:
    
        r3 = r20.getString(com.msandroid.mobile.R.string.audio_heb);
        t9.i.f(r3, "mContext.getString(R.string.audio_heb)");
     */
    /* JADX WARN: Code restructure failed: missing block: B:983:?, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:?, code lost:
    
        return "Welsh";
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:31)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:60)
     */
    /* JADX WARN: Removed duplicated region for block: B:1001:0x1ebb A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1007:0x1ec9 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1031:0x1ead A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1034:0x1ed7 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1037:0x1ef3 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1040:0x1ee5 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1065:0x1f43 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1068:0x1f01 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1090:0x1f35 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1096:0x1f27 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1102:0x1f19 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1111:0x1fbb A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1118:0x1f65 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1121:0x1f8b A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1143:0x1fc9 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1165:0x1fd7 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1183:0x1ff3 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1195:0x2037 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1198:0x2045 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1201:0x1ca4 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1210:0x200e A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1213:0x201c A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1241:0x2061 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1247:0x2053 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1253:0x206f A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1265:0x20d7 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1274:0x208b A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1280:0x207d A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1290:0x20bf A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1299:0x21e3 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x1db0 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1305:0x21ff A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1308:0x20a3 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1314:0x20e5 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1320:0x221b A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1331:0x20b1 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1337:0x20f3 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1340:0x2233 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1343:0x2241 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1346:0x2101 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1349:0x210f A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1355:0x2189 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1358:0x211d A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1361:0x228d A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1364:0x22a5 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1370:0x212b A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1376:0x22b3 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1385:0x22c1 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1388:0x2151 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1407:0x215f A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1426:0x216d A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1432:0x217b A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1453:0x2197 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1456:0x21a5 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1679:0x22f9 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:192:0x14a9 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:1939:0x23f0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:201:0x1765 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:204:0x178b A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:216:0x1799 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:219:0x17a7 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:228:0x17b5 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:234:0x17c3 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:237:0x17d1 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:252:0x17df A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:255:0x17ed A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:258:0x17fb A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:264:0x1809 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:267:0x1817 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:276:0x1825 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:279:0x1833 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:291:0x184f A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:297:0x1879 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:303:0x18b1 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:306:0x186b A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:309:0x1895 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:318:0x1887 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:339:0x18bf A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:345:0x18cd A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:348:0x18a3 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:351:0x18db A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:363:0x18e9 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:366:0x185d A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:369:0x18f7 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:372:0x1841 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:381:0x1913 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:384:0x1905 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:393:0x1921 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:399:0x193d A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:408:0x19d9 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:415:0x192f A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:418:0x195f A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:427:0x19cb A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:430:0x196d A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:436:0x197b A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:445:0x19bd A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:451:0x1989 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:454:0x19a1 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:481:0x19e7 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:490:0x19af A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:496:0x1a03 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:502:0x1a1e A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:508:0x1a2c A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:520:0x1a3a A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:523:0x1a60 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:536:0x1a6e A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:539:0x1a7c A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:554:0x1a8a A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:569:0x1a98 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:575:0x1ab4 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:578:0x1aa6 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:581:0x1ac2 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:584:0x1ad0 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:599:0x1ade A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:611:0x1b08 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:620:0x1b5b A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:623:0x1b16 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x1fe5 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:635:0x1b3f A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:641:0x1b31 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:644:0x1b4d A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:647:0x1afa A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:650:0x1aec A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:653:0x1b69 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:677:0x1bc6 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:680:0x1bb8 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:692:0x1b84 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:695:0x1c0a A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:722:0x1baa A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:728:0x1bd4 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:737:0x1bfc A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:758:0x1c6c A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:761:0x1c26 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:767:0x1c7a A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:776:0x1c34 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:779:0x1c50 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:782:0x1c5e A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:788:0x1c18 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:791:0x1c88 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:794:0x1c42 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:809:0x1cc0 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:815:0x1d30 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:833:0x1cea A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:836:0x1d4c A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:839:0x1cb2 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:848:0x1c96 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:851:0x19f5 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:854:0x1d3e A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:860:0x1d06 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:869:0x1d22 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:875:0x1cdc A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:878:0x1cce A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:881:0x1cf8 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:887:0x1d14 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:912:0x1d64 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:921:0x1dcc A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:927:0x1e04 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:930:0x1e12 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:936:0x1df6 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:939:0x1d8a A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:942:0x1dda A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:945:0x1dbe A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:948:0x1de8 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:957:0x1e38 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:963:0x1e61 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:979:0x1e20 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:989:0x1e9f A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:992:0x1e46 A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String getTranslateString(Context context, String str) {
        i.g(context, f.X);
        i.g(str, "language");
        switch (str.hashCode()) {
            case -2128733913:
                return !str.equals("sla (r)") ? str : "Slavic (Other)";
            case -2119498641:
                break;
            case -2115805115:
                break;
            case -2092716594:
                if (str.equals("smi (r)")) {
                    return "Sami languages (Other)";
                }
                break;
            case -2030841152:
                if (str.equals("son (c)")) {
                    return "Songhai languages";
                }
                break;
            case -2012699483:
                if (str.equals("nub (g)")) {
                    return "Nubian languages";
                }
                break;
            case -1978199928:
                break;
            case -1943106130:
                break;
            case -1928329856:
                if (str.equals("ssa (r)")) {
                    return "Nilo-Saharan (Other)";
                }
                break;
            case -1658724766:
                break;
            case -1548762725:
                if (str.equals("tai (r)")) {
                    return "Tai (Other)";
                }
                break;
            case -1394597760:
                break;
            case -1326194660:
                break;
            case -1141819180:
                if (str.equals("oto (g)")) {
                    return "Otomian languages";
                }
                break;
            case -1079677099:
                break;
            case -974927650:
                if (str.equals("ypk (g)")) {
                    return "Yupik languages";
                }
                break;
            case -969715399:
                if (str.equals("tup (g)")) {
                    return "Tupi languages";
                }
                break;
            case -966020974:
                if (str.equals("tut (r)")) {
                    return "Altaic (Other)";
                }
                break;
            case -938050038:
                if (str.equals("kar (c)")) {
                    return "Karen languages";
                }
                break;
            case -936202469:
                if (str.equals("kat (t)")) {
                    return "Georgian";
                }
                break;
            case -848796911:
                if (str.equals("fiu (r)")) {
                    return "Finno-Ugrian";
                }
                break;
            case -811198321:
                if (str.equals("paa (r)")) {
                    return "Papuan (Other)";
                }
                break;
            case -745957205:
                if (str.equals("khi (r)")) {
                    return "Khoisan (Other)";
                }
                break;
            case -741074325:
                if (str.equals("arm (b)")) {
                    return "Armenian";
                }
                break;
            case -734609182:
                if (str.equals("art (r)")) {
                    return "Artificial";
                }
                break;
            case -688433473:
                if (str.equals("ath (g)")) {
                    return "Athapascan languages";
                }
                break;
            case -680982356:
                break;
            case -649645591:
                if (str.equals("aus (g)")) {
                    return "Australian languages";
                }
                break;
            case -609604910:
                break;
            case -605911384:
                break;
            case -603406096:
                if (str.equals("phi (r)")) {
                    return "Philippine (Other)";
                }
                break;
            case -454125034:
                if (str.equals("kro (c)")) {
                    return "Kru languages";
                }
                break;
            case -348577869:
                if (str.equals("bad (c)")) {
                    return "Banda languages";
                }
                break;
            case -343960140:
                if (str.equals("bai (g)")) {
                    return "Bamileke languages";
                }
                break;
            case -336572127:
                break;
            case -333801068:
                if (str.equals("bat (r)")) {
                    return "Baltic";
                }
                break;
            case -324503095:
                if (str.equals("pra (g)")) {
                    return "Prakrit languages";
                }
                break;
            case -221131506:
                if (str.equals("ber (r)")) {
                    return "Berber";
                }
                break;
            case -151147042:
                if (str.equals("znd (c)")) {
                    return "Zande languages";
                }
                break;
            case -115850577:
                if (str.equals("bih (c)")) {
                    return "Bihari";
                }
                break;
            case -83198002:
                if (str.equals("gem (r)")) {
                    return "Germanic";
                }
                break;
            case -81351456:
                if (!str.equals("geo (b)")) {
                }
                break;
            case -78580893:
                break;
            case 3104:
                if (str.equals("aa")) {
                    return "Afar";
                }
                break;
            case 3105:
                if (str.equals("ab")) {
                    return "Abkhazian";
                }
                break;
            case 3108:
                if (str.equals("ae")) {
                    return "Avestan";
                }
                break;
            case 3109:
                if (str.equals("af")) {
                    return "Afrikaans";
                }
                break;
            case 3114:
                if (str.equals("ak")) {
                    return "Akan";
                }
                break;
            case 3116:
                if (str.equals("am")) {
                    return "Amharic";
                }
                break;
            case 3117:
                if (str.equals("an")) {
                    return "Aragonese";
                }
                break;
            case 3121:
                break;
            case 3122:
                if (str.equals("as")) {
                    return "Assamese";
                }
                break;
            case 3125:
                if (str.equals("av")) {
                    return "Avaric";
                }
                break;
            case 3128:
                if (str.equals("ay")) {
                    return "Aymara";
                }
                break;
            case 3129:
                if (str.equals("az")) {
                    return "Azerbaijani";
                }
                break;
            case 3135:
                if (str.equals("ba")) {
                    return "Bashkir";
                }
                break;
            case 3139:
                if (str.equals("be")) {
                    return "Belarusian";
                }
                break;
            case 3141:
                if (str.equals("bg")) {
                    return "Bulgarian";
                }
                break;
            case 3142:
                if (!str.equals("bh")) {
                }
                break;
            case 3143:
                if (str.equals("bi")) {
                    return "Bislama";
                }
                break;
            case 3147:
                if (str.equals("bm")) {
                    return "Bambara";
                }
                break;
            case 3148:
                if (str.equals("bn")) {
                    return "Bengali";
                }
                break;
            case 3149:
                break;
            case 3152:
                if (str.equals("br")) {
                    return "Breton";
                }
                break;
            case 3153:
                if (str.equals("bs")) {
                    return "Bosnian";
                }
                break;
            case 3166:
                if (str.equals("ca")) {
                    return "Catalan";
                }
                break;
            case 3170:
                if (str.equals("ce")) {
                    return "Chechen";
                }
                break;
            case 3173:
                if (str.equals("ch")) {
                    return "Chamorro";
                }
                break;
            case 3180:
                if (str.equals("co")) {
                    return "Corsican";
                }
                break;
            case 3183:
                if (str.equals("cr")) {
                    return "Cree";
                }
                break;
            case 3184:
                break;
            case 3186:
                if (str.equals("cu")) {
                    return "Church Slavic";
                }
                break;
            case 3187:
                if (str.equals(DispatchConstants.CONFIG_VERSION)) {
                    return "Chuvash";
                }
                break;
            case 3190:
                break;
            case 3197:
                if (str.equals("da")) {
                    return "Danish";
                }
                break;
            case 3201:
                if (str.equals("de")) {
                    return "German";
                }
                break;
            case 3218:
                if (str.equals("dv")) {
                    return "Dhivehi";
                }
                break;
            case 3222:
                if (str.equals("dz")) {
                    return "Dzongkha";
                }
                break;
            case 3232:
                if (str.equals("ee")) {
                    return "Ewe";
                }
                break;
            case 3239:
                break;
            case 3241:
                break;
            case 3242:
                if (str.equals("eo")) {
                    return "Esperanto";
                }
                break;
            case 3246:
                break;
            case 3247:
                if (str.equals("et")) {
                    return "Estonian";
                }
                break;
            case 3248:
                break;
            case 3259:
                break;
            case 3264:
                if (str.equals("ff")) {
                    return "Fulah";
                }
                break;
            case 3267:
                if (str.equals("fi")) {
                    return "Finnish";
                }
                break;
            case 3268:
                if (str.equals("fj")) {
                    return "Fijian";
                }
                break;
            case 3273:
                if (str.equals("fo")) {
                    return "Faroese";
                }
                break;
            case 3276:
                break;
            case 3283:
                if (str.equals("fy")) {
                    return "Western Frisian";
                }
                break;
            case 3290:
                if (str.equals("ga")) {
                    return "Irish";
                }
                break;
            case 3293:
                if (str.equals("gd")) {
                    return "Scottish Gaelic";
                }
                break;
            case 3301:
                if (str.equals("gl")) {
                    return "Galician";
                }
                break;
            case 3303:
                if (str.equals("gn")) {
                    return "Guarani";
                }
                break;
            case 3310:
                if (str.equals("gu")) {
                    return "Gujarati";
                }
                break;
            case 3311:
                if (str.equals("gv")) {
                    return "Manx";
                }
                break;
            case 3321:
                if (str.equals("ha")) {
                    return "Hausa";
                }
                break;
            case 3325:
                break;
            case 3329:
                break;
            case 3335:
                if (str.equals("ho")) {
                    return "Hiri Motu";
                }
                break;
            case 3338:
                break;
            case 3340:
                if (str.equals("ht")) {
                    return "Haitian";
                }
                break;
            case 3341:
                if (str.equals("hu")) {
                    return "Hungarian";
                }
                break;
            case 3345:
                if (!str.equals("hy")) {
                }
                break;
            case 3346:
                if (str.equals("hz")) {
                    return "Herero";
                }
                break;
            case 3352:
                if (str.equals("ia")) {
                    return "Interlingua ";
                }
                break;
            case 3355:
                if (str.equals("id")) {
                    return "Indonesian";
                }
                break;
            case 3356:
                if (str.equals("ie")) {
                    return "Interlingue";
                }
                break;
            case 3358:
                if (str.equals("ig")) {
                    return "Igbo";
                }
                break;
            case 3360:
                if (str.equals("ii")) {
                    return "Sichuan Yi";
                }
                break;
            case 3362:
                if (str.equals("ik")) {
                    return "Inupiaq";
                }
                break;
            case 3366:
                if (str.equals("io")) {
                    return "Ido";
                }
                break;
            case 3370:
                if (str.equals(bt.ae)) {
                    return "Icelandic";
                }
                break;
            case 3371:
                break;
            case 3372:
                if (str.equals("iu")) {
                    return "Inuktitut";
                }
                break;
            case 3383:
                break;
            case 3404:
                if (str.equals("jv")) {
                    return "Javanese";
                }
                break;
            case 3414:
                if (!str.equals("ka")) {
                }
                break;
            case 3420:
                if (str.equals("kg")) {
                    return "Kongo";
                }
                break;
            case 3422:
                if (str.equals("ki")) {
                    return "Kikuyu";
                }
                break;
            case 3423:
                if (str.equals("kj")) {
                    return "Kuanyama";
                }
                break;
            case 3424:
                if (str.equals("kk")) {
                    return "Kazakh";
                }
                break;
            case 3425:
                if (str.equals("kl")) {
                    return "Kalaallisut";
                }
                break;
            case 3426:
                if (str.equals("km")) {
                    return "Central Khmer";
                }
                break;
            case 3427:
                if (str.equals("kn")) {
                    return "Kannada";
                }
                break;
            case 3428:
                if (str.equals("ko")) {
                    return "Korean";
                }
                break;
            case 3431:
                if (str.equals("kr")) {
                    return "Kanuri";
                }
                break;
            case 3432:
                if (str.equals("ks")) {
                    return "Kashmiri";
                }
                break;
            case 3434:
                if (str.equals("ku")) {
                    return "Kurdish";
                }
                break;
            case 3435:
                if (str.equals("kv")) {
                    return "Komi";
                }
                break;
            case 3436:
                if (str.equals("kw")) {
                    return "Cornish";
                }
                break;
            case 3438:
                if (str.equals("ky")) {
                    return "Kirghiz";
                }
                break;
            case 3445:
                if (str.equals("la")) {
                    return "Latin";
                }
                break;
            case 3446:
                if (str.equals("lb")) {
                    return "Luxembourgish";
                }
                break;
            case 3451:
                if (str.equals("lg")) {
                    return "Ganda";
                }
                break;
            case 3453:
                if (str.equals("li")) {
                    return "Limburgan";
                }
                break;
            case 3458:
                if (str.equals("ln")) {
                    return "Lingala";
                }
                break;
            case 3459:
                if (str.equals("lo")) {
                    return "Lao";
                }
                break;
            case 3464:
                if (str.equals("lt")) {
                    return "Lithuanian";
                }
                break;
            case 3465:
                if (str.equals("lu")) {
                    return "Luba-Katanga";
                }
                break;
            case 3466:
                if (str.equals("lv")) {
                    return "Latvian";
                }
                break;
            case 3482:
                if (str.equals("mg")) {
                    return "Malagasy";
                }
                break;
            case 3483:
                if (str.equals("mh")) {
                    return "Marshallese";
                }
                break;
            case 3484:
                break;
            case 3486:
                break;
            case 3487:
                if (str.equals("ml")) {
                    return "Malayalam";
                }
                break;
            case 3489:
                if (str.equals("mn")) {
                    return "Mongolian";
                }
                break;
            case 3490:
                if (str.equals("mo")) {
                    return "Moldavian";
                }
                break;
            case 3493:
                if (str.equals("mr")) {
                    return "Marathi";
                }
                break;
            case 3494:
                if (str.equals("ms")) {
                    String string = context.getString(R.string.language_ms);
                    i.f(string, "mContext.getString(R.string.language_ms)");
                    return string;
                }
            case 3495:
                if (str.equals("mt")) {
                    return "Maltese";
                }
                break;
            case 3500:
                break;
            case 3507:
                if (str.equals("na")) {
                    return "Nauru";
                }
                break;
            case 3508:
                if (str.equals("nb")) {
                    return "Norwegian Bokmål";
                }
                break;
            case 3510:
                if (str.equals("nd")) {
                    return "North Ndebele";
                }
                break;
            case 3511:
                if (str.equals("ne")) {
                    return "Nepali";
                }
                break;
            case 3513:
                if (str.equals("ng")) {
                    return "Ndonga";
                }
                break;
            case 3518:
                break;
            case 3520:
                if (str.equals("nn")) {
                    return "Norwegian Nynorsk";
                }
                break;
            case 3521:
                if (str.equals("no")) {
                    return "Norwegian";
                }
                break;
            case 3524:
                if (str.equals("nr")) {
                    return "South Ndebele";
                }
                break;
            case 3528:
                if (str.equals("nv")) {
                    return "Navajo";
                }
                break;
            case 3531:
                if (str.equals("ny")) {
                    return "Nyanja";
                }
                break;
            case 3540:
                if (str.equals("oc")) {
                    return "Occitan ";
                }
                break;
            case 3547:
                if (str.equals("oj")) {
                    return "Ojibwa";
                }
                break;
            case 3550:
                if (str.equals("om")) {
                    return "Oromo";
                }
                break;
            case 3555:
                if (str.equals("or")) {
                    return "Oriya";
                }
                break;
            case 3556:
                if (str.equals("os")) {
                    return "Ossetian";
                }
                break;
            case 3569:
                if (str.equals("pa")) {
                    return "Panjabi";
                }
                break;
            case 3577:
                if (str.equals("pi")) {
                    return "Pali";
                }
                break;
            case 3580:
                if (str.equals(bt.aF)) {
                    return "Polish";
                }
                break;
            case 3587:
                if (str.equals("ps")) {
                    return "Pushto";
                }
                break;
            case 3588:
                break;
            case 3620:
                if (str.equals("qu")) {
                    return "Quechua";
                }
                break;
            case 3643:
                if (str.equals("rm")) {
                    return "Romansh";
                }
                break;
            case 3644:
                if (str.equals("rn")) {
                    return "Rundi";
                }
                break;
            case 3645:
                break;
            case 3651:
                if (str.equals("ru")) {
                    return "Russian";
                }
                break;
            case 3653:
                if (str.equals("rw")) {
                    return "Kinyarwanda";
                }
                break;
            case 3662:
                if (str.equals("sa")) {
                    return "Sanskrit";
                }
                break;
            case 3664:
                if (str.equals("sc")) {
                    return "Sardinian";
                }
                break;
            case 3665:
                if (str.equals(DynamicLink.SocialMetaTagParameters.KEY_SOCIAL_DESCRIPTION)) {
                    return "Sindhi";
                }
                break;
            case 3666:
                if (str.equals("se")) {
                    return "Northern Sami";
                }
                break;
            case 3668:
                if (str.equals("sg")) {
                    return "Sango";
                }
                break;
            case 3670:
                if (str.equals(DynamicLink.SocialMetaTagParameters.KEY_SOCIAL_IMAGE_LINK)) {
                    return "Sinhala";
                }
                break;
            case 3672:
                break;
            case 3673:
                if (str.equals("sl")) {
                    return "Slovenian";
                }
                break;
            case 3674:
                if (str.equals("sm")) {
                    return "Samoan";
                }
                break;
            case 3675:
                if (str.equals("sn")) {
                    return "Shona";
                }
                break;
            case 3676:
                if (str.equals("so")) {
                    return "Somali";
                }
                break;
            case 3678:
                break;
            case 3679:
                break;
            case 3680:
                if (str.equals("ss")) {
                    return "Swati";
                }
                break;
            case 3681:
                if (str.equals("st")) {
                    return "Southern Sotho";
                }
                break;
            case 3682:
                if (str.equals("su")) {
                    return "Sundanese";
                }
                break;
            case 3683:
                if (str.equals("sv")) {
                    return "Swedish";
                }
                break;
            case 3684:
                if (str.equals("sw")) {
                    return "Swahili (macrolanguage)";
                }
                break;
            case 3693:
                if (str.equals("ta")) {
                    return "Tamil";
                }
                break;
            case 3697:
                if (str.equals("te")) {
                    return "Telugu";
                }
                break;
            case 3699:
                if (str.equals("tg")) {
                    return "Tajik";
                }
                break;
            case 3700:
                if (str.equals("th")) {
                    return "Thai";
                }
                break;
            case 3701:
                if (str.equals("ti")) {
                    return "Tigrinya";
                }
                break;
            case 3703:
                if (str.equals("tk")) {
                    return "Turkmen";
                }
                break;
            case 3704:
                if (str.equals("tl")) {
                    return "Tagalog";
                }
                break;
            case 3706:
                if (str.equals("tn")) {
                    return "Tswana";
                }
                break;
            case 3707:
                if (str.equals("to")) {
                    return "Tonga (Tonga Islands)";
                }
                break;
            case 3710:
                if (str.equals("tr")) {
                    return "Turkish";
                }
                break;
            case 3711:
                if (str.equals("ts")) {
                    return "Tsonga";
                }
                break;
            case 3712:
                if (str.equals("tt")) {
                    return "Tatar";
                }
                break;
            case 3715:
                if (str.equals("tw")) {
                    return "Twi";
                }
                break;
            case 3717:
                if (str.equals("ty")) {
                    return "Tahitian";
                }
                break;
            case 3730:
                if (str.equals("ug")) {
                    return "Uighur";
                }
                break;
            case 3734:
                if (str.equals("uk")) {
                    return "Ukrainian";
                }
                break;
            case 3741:
                if (str.equals("ur")) {
                    return "Urdu";
                }
                break;
            case 3749:
                if (str.equals("uz")) {
                    return "Uzbek";
                }
                break;
            case 3759:
                if (str.equals("ve")) {
                    return "Venda";
                }
                break;
            case 3763:
                if (str.equals("vi")) {
                    return "Vietnamese";
                }
                break;
            case 3769:
                if (str.equals("vo")) {
                    return "Volapük";
                }
                break;
            case 3786:
                if (str.equals("wa")) {
                    return "Walloon";
                }
                break;
            case 3800:
                if (str.equals("wo")) {
                    return "Wolof";
                }
                break;
            case 3824:
                if (str.equals("xh")) {
                    return "Xhosa";
                }
                break;
            case 3856:
                if (str.equals("yi")) {
                    return "Yiddish";
                }
                break;
            case 3862:
                if (str.equals("yo")) {
                    return "Yoruba";
                }
                break;
            case 3879:
                if (str.equals("za")) {
                    return "Zhuang";
                }
                break;
            case 3886:
                break;
            case 3899:
                if (str.equals("zu")) {
                    return "Zulu";
                }
                break;
            case 96338:
                if (!str.equals("aar")) {
                }
                break;
            case 96362:
                if (!str.equals("abk")) {
                }
                break;
            case 96387:
                if (str.equals("ace")) {
                    return "Achinese";
                }
                break;
            case 96390:
                if (str.equals("ach")) {
                    return "Acoli";
                }
                break;
            case 96414:
                if (str.equals("ada")) {
                    return "Adangme";
                }
                break;
            case 96438:
                if (str.equals("ady")) {
                    return "Adyghe";
                }
                break;
            case 96476:
                if (str.equals("afa")) {
                    return "Afro-Asiatic";
                }
                break;
            case 96483:
                if (str.equals("afh")) {
                    return "Afrihili";
                }
                break;
            case 96493:
                if (!str.equals("afr")) {
                }
                break;
            case 96582:
                if (str.equals("ain")) {
                    return "Ainu";
                }
                break;
            case 96631:
                if (!str.equals("aka")) {
                }
                break;
            case 96641:
                if (str.equals("akk")) {
                    return "Akkadian";
                }
                break;
            case 96663:
                break;
            case 96666:
                if (str.equals("ale")) {
                    return "Aleut";
                }
                break;
            case 96668:
                if (str.equals("alg")) {
                    return "Algonquian languages";
                }
                break;
            case 96681:
                if (str.equals("alt")) {
                    return "Southern Altai";
                }
                break;
            case 96700:
                if (!str.equals("amh")) {
                }
                break;
            case 96730:
                if (str.equals("ang")) {
                    return "Old English";
                }
                break;
            case 96739:
                if (str.equals("anp")) {
                    return "Angika";
                }
                break;
            case 96786:
                if (str.equals("apa")) {
                    return "Apache languages";
                }
                break;
            case 96848:
                break;
            case 96850:
                if (str.equals("arc")) {
                    return "Official Aramaic";
                }
                break;
            case 96854:
                if (!str.equals("arg")) {
                }
                break;
            case 96860:
                if (!str.equals("arm")) {
                }
                break;
            case 96861:
                if (str.equals("arn")) {
                    return "Mapudungun";
                }
                break;
            case 96863:
                if (str.equals("arp")) {
                    return "Arapaho";
                }
                break;
            case 96867:
                if (!str.equals("art")) {
                }
                break;
            case 96870:
                if (str.equals("arw")) {
                    return "Arawak";
                }
                break;
            case 96891:
                if (!str.equals("asm")) {
                }
                break;
            case 96898:
                if (str.equals(PlistBuilder.KEY_AUDIO_SOCKET_TYPE)) {
                    return "Asturian";
                }
                break;
            case 96917:
                if (!str.equals("ath")) {
                }
                break;
            case 96959:
                if (!str.equals("aus")) {
                }
                break;
            case 96972:
                if (!str.equals("ava")) {
                }
                break;
            case 96976:
                if (!str.equals("ave")) {
                }
                break;
            case 97003:
                if (str.equals("awa")) {
                    return "Awadhi";
                }
                break;
            case 97077:
                if (!str.equals("aym")) {
                }
                break;
            case 97100:
                if (!str.equals("aze")) {
                }
                break;
            case 97285:
                if (!str.equals("bad")) {
                }
                break;
            case 97290:
                if (!str.equals("bai")) {
                }
                break;
            case 97292:
                if (!str.equals("bak")) {
                }
                break;
            case 97293:
                if (str.equals("bal")) {
                    return "Baluchi";
                }
                break;
            case 97294:
                if (!str.equals("bam")) {
                }
                break;
            case 97295:
                if (str.equals("ban")) {
                    return "Balinese";
                }
                break;
            case 97298:
                break;
            case 97300:
                if (str.equals("bas")) {
                    return "Basa (Cameroon)";
                }
                break;
            case 97301:
                if (!str.equals("bat")) {
                }
                break;
            case 97415:
                if (str.equals("bej")) {
                    return "Beja";
                }
                break;
            case 97417:
                if (!str.equals("bel")) {
                }
                break;
            case 97418:
                if (str.equals("bem")) {
                    return "Bemba";
                }
                break;
            case 97419:
                if (!str.equals("ben")) {
                }
                break;
            case 97423:
                if (!str.equals("ber")) {
                }
                break;
            case 97513:
                if (str.equals("bho")) {
                    return "Bhojpuri";
                }
                break;
            case 97537:
                if (!str.equals("bih")) {
                }
                break;
            case 97540:
                if (str.equals("bik")) {
                    return "Bikol";
                }
                break;
            case 97543:
                if (str.equals("bin")) {
                    return "Bini";
                }
                break;
            case 97548:
                if (!str.equals("bis")) {
                }
                break;
            case 97623:
                if (str.equals("bla")) {
                    return "Siksika";
                }
                break;
            case 97704:
                if (str.equals("bnt")) {
                    return "Bantu";
                }
                break;
            case 97719:
                break;
            case 97734:
                if (!str.equals("bos")) {
                }
                break;
            case 97809:
                if (str.equals("bra")) {
                    return "Braj";
                }
                break;
            case 97813:
                if (!str.equals("bre")) {
                }
                break;
            case 97902:
                if (str.equals("bua")) {
                    return "Buriat";
                }
                break;
            case 97908:
                if (str.equals("bug")) {
                    return "Buginese";
                }
                break;
            case 97913:
                if (!str.equals("bul")) {
                }
                break;
            case 98039:
                if (str.equals("byn")) {
                    return "Bilin";
                }
                break;
            case 98246:
                if (str.equals("cad")) {
                    return "Caddo";
                }
                break;
            case 98260:
                if (str.equals("car")) {
                    return "Galibi Carib";
                }
                break;
            case 98262:
                if (!str.equals("cat")) {
                }
                break;
            case 98368:
                if (str.equals("ceb")) {
                    return "Cebuano";
                }
                break;
            case 98460:
                if (!str.equals("cha")) {
                }
                break;
            case 98461:
                if (str.equals("chb")) {
                    return "Chibcha";
                }
                break;
            case 98464:
                if (!str.equals("che")) {
                }
                break;
            case 98466:
                if (str.equals("chg")) {
                    return "Chagatai";
                }
                break;
            case 98468:
                break;
            case 98470:
                if (str.equals("chk")) {
                    return "Chuukese";
                }
                break;
            case 98472:
                if (str.equals("chm")) {
                    return "Mari";
                }
                break;
            case 98473:
                if (str.equals("chn")) {
                    return "Chinook jargon";
                }
                break;
            case 98474:
                if (str.equals("cho")) {
                    return "Choctaw";
                }
                break;
            case 98475:
                if (str.equals("chp")) {
                    return "Chipewyan";
                }
                break;
            case 98477:
                if (str.equals("chr")) {
                    return "Cherokee";
                }
                break;
            case 98480:
                if (!str.equals("chu")) {
                }
                break;
            case 98481:
                if (!str.equals("chv")) {
                }
                break;
            case 98484:
                if (str.equals("chy")) {
                    return "Cheyenne";
                }
                break;
            case 98692:
                if (str.equals("cop")) {
                    return "Coptic";
                }
                break;
            case 98694:
                if (!str.equals("cor")) {
                }
                break;
            case 98695:
                if (!str.equals("cos")) {
                }
                break;
            case 98774:
                if (!str.equals("cre")) {
                }
                break;
            case 98777:
                if (str.equals("crh")) {
                    return "Crimean Tatar";
                }
                break;
            case 98802:
                if (str.equals("csb")) {
                    return "Kashubian";
                }
                break;
            case 99214:
                if (str.equals("dak")) {
                    return "Dakota";
                }
                break;
            case 99217:
                if (!str.equals("dan")) {
                }
                break;
            case 99221:
                if (str.equals("dar")) {
                    return "Dargwa";
                }
                break;
            case 99339:
                if (str.equals("del")) {
                    return "Delaware";
                }
                break;
            case 99341:
                if (str.equals("den")) {
                    return "Slave";
                }
                break;
            case 99407:
                if (str.equals("dgr")) {
                    return "Dogrib";
                }
                break;
            case 99465:
                if (str.equals("din")) {
                    return "Dinka";
                }
                break;
            case 99473:
                if (!str.equals("div")) {
                }
                break;
            case 99646:
                if (str.equals("doi")) {
                    return "Dogri (macrolanguage)";
                }
                break;
            case 99763:
                if (str.equals("dsb")) {
                    return "Lower Sorbian";
                }
                break;
            case 99824:
                if (str.equals("dua")) {
                    return "Duala";
                }
                break;
            case 99836:
                if (str.equals("dum")) {
                    return "Middle Dutch";
                }
                break;
            case 99843:
                if (str.equals("dut")) {
                    String string2 = context.getString(R.string.audio_dut);
                    i.f(string2, "mContext.getString(R.string.audio_dut)");
                    return string2;
                }
            case 99968:
                if (str.equals("dyu")) {
                    return "Dyula";
                }
                break;
            case 99993:
                if (!str.equals("dzo")) {
                }
                break;
            case 100328:
                if (str.equals("efi")) {
                    return "Efik";
                }
                break;
            case 100375:
                if (str.equals("egy")) {
                    return "Egyptian";
                }
                break;
            case 100475:
                if (str.equals("eka")) {
                    return "Ekajuk";
                }
                break;
            case 100529:
                if (str.equals("elx")) {
                    return "Elamite";
                }
                break;
            case 100574:
                break;
            case 100580:
                if (str.equals("enm")) {
                    return "Middle English ";
                }
                break;
            case 100644:
                if (!str.equals("epo")) {
                }
                break;
            case 100742:
                if (!str.equals("est")) {
                }
                break;
            case 100803:
                break;
            case 100851:
                if (!str.equals("ewe")) {
                }
                break;
            case 100861:
                if (str.equals("ewo")) {
                    return "Ewondo";
                }
                break;
            case 101139:
                if (str.equals("fan")) {
                    return "Fang";
                }
                break;
            case 101140:
                if (!str.equals("fao")) {
                }
                break;
            case 101145:
                if (str.equals("fat")) {
                    return "Fanti";
                }
                break;
            case 101383:
                if (!str.equals("fij")) {
                }
                break;
            case 101385:
                if (str.equals("fil")) {
                    return "Filipino";
                }
                break;
            case 101387:
                if (!str.equals("fin")) {
                }
                break;
            case 101573:
                if (str.equals("fon")) {
                    return "Fon";
                }
                break;
            case 101657:
                break;
            case 101665:
                if (str.equals("frm")) {
                    return "Middle French";
                }
                break;
            case 101667:
                if (str.equals("fro")) {
                    return "Old French";
                }
                break;
            case 101670:
                if (str.equals("frr")) {
                    return "Northern Frisian";
                }
                break;
            case 101671:
                if (str.equals("frs")) {
                    return "Eastern Frisian";
                }
                break;
            case 101677:
                if (!str.equals("fry")) {
                }
                break;
            case 101757:
                if (!str.equals("ful")) {
                }
                break;
            case 101763:
                if (str.equals("fur")) {
                    return "Friulian";
                }
                break;
            case 102087:
                if (str.equals("gaa")) {
                    return "Ga";
                }
                break;
            case 102111:
                if (str.equals("gay")) {
                    return "Gayo";
                }
                break;
            case 102118:
                if (str.equals("gba")) {
                    return "Gbaya";
                }
                break;
            case 102228:
                break;
            case 102236:
                if (str.equals("gez")) {
                    return "Geez";
                }
                break;
            case 102346:
                if (str.equals("gil")) {
                    return "Gilbertese";
                }
                break;
            case 102428:
                if (!str.equals("gla")) {
                }
                break;
            case 102432:
                if (!str.equals("gle")) {
                }
                break;
            case 102434:
                if (!str.equals("glg")) {
                }
                break;
            case 102449:
                if (!str.equals("glv")) {
                }
                break;
            case 102466:
                if (str.equals("gmh")) {
                    return "Middle High German";
                }
                break;
            case 102528:
                if (str.equals("goh")) {
                    return "Old High German ";
                }
                break;
            case 102534:
                if (str.equals("gon")) {
                    return "Gondi";
                }
                break;
            case 102538:
                if (str.equals("gor")) {
                    return "Gorontalo";
                }
                break;
            case 102540:
                if (str.equals("got")) {
                    return "Gothic";
                }
                break;
            case 102615:
                if (str.equals("grb")) {
                    return "Grebo";
                }
                break;
            case 102616:
                if (str.equals("grc")) {
                    return "Ancient Greek (to 1453)";
                }
                break;
            case 102627:
                if (!str.equals("grn")) {
                }
                break;
            case 102667:
                if (str.equals("gsw")) {
                    return "Swiss German";
                }
                break;
            case 102716:
                if (!str.equals("guj")) {
                }
                break;
            case 102777:
                if (str.equals("gwi")) {
                    return "Gwichʼin";
                }
                break;
            case 103056:
                if (str.equals("hai")) {
                    return "Haida";
                }
                break;
            case 103067:
                if (!str.equals("hat")) {
                }
                break;
            case 103068:
                if (!str.equals("hau")) {
                }
                break;
            case 103070:
                if (str.equals("haw")) {
                    return "Hawaiian";
                }
                break;
            case 103173:
                break;
            case 103189:
                if (!str.equals("her")) {
                }
                break;
            case 103307:
                if (str.equals("hil")) {
                    return "Hiligaynon";
                }
                break;
            case 103309:
                break;
            case 103315:
                if (str.equals("hit")) {
                    return "Hittite";
                }
                break;
            case 103433:
                if (str.equals("hmn")) {
                    return "Hmong";
                }
                break;
            case 103434:
                if (!str.equals("hmo")) {
                }
                break;
            case 103607:
                if (str.equals("hsb")) {
                    return "Upper Sorbian";
                }
                break;
            case 103681:
                if (!str.equals("hun")) {
                }
                break;
            case 103683:
                if (str.equals("hup")) {
                    return "Hupa";
                }
                break;
            case 104040:
                if (str.equals("iba")) {
                    return "Iban";
                }
                break;
            case 104054:
                if (!str.equals("ibo")) {
                }
                break;
            case 104116:
                if (!str.equals("ido")) {
                }
                break;
            case 104265:
                if (!str.equals("iii")) {
                }
                break;
            case 104339:
                if (!str.equals("iku")) {
                }
                break;
            case 104354:
                if (!str.equals("ile")) {
                }
                break;
            case 104364:
                if (str.equals("ilo")) {
                    return "Iloko";
                }
                break;
            case 104412:
                if (!str.equals("ina")) {
                }
                break;
            case 104415:
                if (!str.equals("ind")) {
                }
                break;
            case 104419:
                if (str.equals("inh")) {
                    return "Ingush";
                }
                break;
            case 104484:
                if (!str.equals("ipk")) {
                }
                break;
            case 104578:
                if (!str.equals("isl")) {
                }
                break;
            case 104598:
                break;
            case 104991:
                if (!str.equals("jav")) {
                }
                break;
            case 105015:
                if (str.equals("jbo")) {
                    return "Lojban";
                }
                break;
            case 105448:
                break;
            case 105452:
                if (str.equals("jpr")) {
                    return "Judeo-Persian";
                }
                break;
            case 105498:
                if (str.equals("jrb")) {
                    return "Judeo-Arabic";
                }
                break;
            case 105931:
                if (str.equals("kaa")) {
                    return "Kara-Kalpak";
                }
                break;
            case 105932:
                if (str.equals("kab")) {
                    return "Kabyle";
                }
                break;
            case 105933:
                if (str.equals("kac")) {
                    return "Kachin";
                }
                break;
            case 105942:
                if (!str.equals("kal")) {
                }
                break;
            case 105943:
                if (str.equals("kam")) {
                    return "Kamba (Kenya)";
                }
                break;
            case 105944:
                if (!str.equals("kan")) {
                }
                break;
            case 105949:
                if (!str.equals("kas")) {
                }
                break;
            case 105951:
                if (!str.equals("kau")) {
                }
                break;
            case 105953:
                if (str.equals("kaw")) {
                    return "Kawi";
                }
                break;
            case 105956:
                if (!str.equals("kaz")) {
                }
                break;
            case 105965:
                if (str.equals("kbd")) {
                    return "Kabardian";
                }
                break;
            case 106148:
                if (str.equals("kha")) {
                    return "Khasi";
                }
                break;
            case 106160:
                if (!str.equals("khm")) {
                }
                break;
            case 106162:
                if (str.equals("kho")) {
                    return "Khotanese";
                }
                break;
            case 106189:
                if (!str.equals("kik")) {
                }
                break;
            case 106192:
                if (!str.equals("kin")) {
                }
                break;
            case 106196:
                if (!str.equals("kir")) {
                }
                break;
            case 106304:
                if (str.equals("kmb")) {
                    return "Kimbundu";
                }
                break;
            case 106375:
                if (str.equals("kok")) {
                    return "Konkani (macrolanguage)";
                }
                break;
            case 106377:
                if (!str.equals("kom")) {
                }
                break;
            case 106378:
                if (!str.equals("kon")) {
                }
                break;
            case 106382:
                if (!str.equals("kor")) {
                }
                break;
            case 106383:
                if (str.equals("kos")) {
                    return "Kosraean";
                }
                break;
            case 106400:
                if (str.equals("kpe")) {
                    return "Kpelle";
                }
                break;
            case 106460:
                if (str.equals("krc")) {
                    return "Karachay-Balkar";
                }
                break;
            case 106469:
                if (str.equals("krl")) {
                    return "Karelian";
                }
                break;
            case 106478:
                if (str.equals("kru")) {
                    return "Kurukh";
                }
                break;
            case 106551:
                if (!str.equals("kua")) {
                }
                break;
            case 106563:
                if (str.equals("kum")) {
                    return "Kumyk";
                }
                break;
            case 106568:
                if (!str.equals("kur")) {
                }
                break;
            case 106570:
                if (str.equals("kut")) {
                    return "Kutenai";
                }
                break;
            case 106895:
                if (str.equals("lad")) {
                    return "Ladino";
                }
                break;
            case 106899:
                if (str.equals("lah")) {
                    return "Lahnda";
                }
                break;
            case 106904:
                if (str.equals("lam")) {
                    return "Lamba";
                }
                break;
            case 106906:
                if (!str.equals("lao")) {
                }
                break;
            case 106911:
                if (!str.equals("lat")) {
                }
                break;
            case 106913:
                if (!str.equals("lav")) {
                }
                break;
            case 107041:
                if (str.equals("lez")) {
                    return "Lezghian";
                }
                break;
            case 107152:
                if (!str.equals("lim")) {
                }
                break;
            case 107153:
                if (!str.equals("lin")) {
                }
                break;
            case 107159:
                if (!str.equals("lit")) {
                }
                break;
            case 107337:
                if (str.equals("lol")) {
                    return "Mongo";
                }
                break;
            case 107351:
                if (str.equals("loz")) {
                    return "Lozi";
                }
                break;
            case 107506:
                if (!str.equals("ltz")) {
                }
                break;
            case 107512:
                if (str.equals("lua")) {
                    return "Luba-Lulua";
                }
                break;
            case 107513:
                if (!str.equals("lub")) {
                }
                break;
            case 107518:
                if (!str.equals("lug")) {
                }
                break;
            case 107520:
                if (str.equals("lui")) {
                    return "Luiseno";
                }
                break;
            case 107525:
                if (str.equals("lun")) {
                    return "Lunda";
                }
                break;
            case 107526:
                if (str.equals("luo")) {
                    return "Luo (Kenya and Tanzania)";
                }
                break;
            case 107530:
                if (str.equals("lus")) {
                    return "Lushai";
                }
                break;
            case 107856:
                if (str.equals("mad")) {
                    return "Madurese";
                }
                break;
            case 107859:
                if (str.equals("mag")) {
                    return "Magahi";
                }
                break;
            case 107860:
                if (!str.equals("mah")) {
                }
                break;
            case 107861:
                if (str.equals("mai")) {
                    return "Maithili";
                }
                break;
            case 107863:
                if (str.equals("mak")) {
                    return "Makasar";
                }
                break;
            case 107864:
                if (!str.equals("mal")) {
                }
                break;
            case 107866:
                if (str.equals("man")) {
                    return "Mandingo";
                }
                break;
            case 107870:
                if (!str.equals("mar")) {
                }
                break;
            case 107871:
                if (str.equals("mas")) {
                    return "Masai";
                }
                break;
            case 107951:
                if (str.equals("mdf")) {
                    return "Moksha";
                }
                break;
            case 107963:
                if (str.equals("mdr")) {
                    return "Mandar";
                }
                break;
            case 107990:
                if (str.equals("men")) {
                    return "Mende (Sierra Leone)";
                }
                break;
            case 108039:
                if (str.equals("mga")) {
                    return "Middle Irish (900-1200)";
                }
                break;
            case 108103:
                if (str.equals("mic")) {
                    return "Mi'kmaq";
                }
                break;
            case 108114:
                if (str.equals("min")) {
                    return "Minangkabau";
                }
                break;
            case 108119:
                if (str.equals("mis")) {
                    return "Uncoded languages";
                }
                break;
            case 108200:
                if (!str.equals("mlg")) {
                }
                break;
            case 108213:
                if (!str.equals("mlt")) {
                }
                break;
            case 108258:
                if (str.equals(DispatchConstants.MNC)) {
                    return "Manchu";
                }
                break;
            case 108264:
                if (str.equals("mni")) {
                    return "Manipuri";
                }
                break;
            case 108294:
                if (str.equals("moh")) {
                    return "Mohawk";
                }
                break;
            case 108298:
                if (!str.equals("mol")) {
                }
                break;
            case 108300:
                if (!str.equals("mon")) {
                }
                break;
            case 108305:
                if (str.equals("mos")) {
                    return "Mossi";
                }
                break;
            case 108484:
                if (str.equals("mul")) {
                    return "Multiple languages";
                }
                break;
            case 108491:
                if (str.equals("mus")) {
                    return "Creek";
                }
                break;
            case 108546:
                if (str.equals("mwl")) {
                    return "Mirandese";
                }
                break;
            case 108552:
                if (str.equals("mwr")) {
                    return "Marwari";
                }
                break;
            case 108618:
                if (str.equals("myv")) {
                    return "Erzya";
                }
                break;
            case 108829:
                if (str.equals("nap")) {
                    return "Neapolitan";
                }
                break;
            case 108834:
                if (!str.equals("nau")) {
                }
                break;
            case 108835:
                if (!str.equals("nav")) {
                }
                break;
            case 108856:
                if (!str.equals("nbl")) {
                }
                break;
            case 108911:
                if (!str.equals("nde")) {
                }
                break;
            case 108921:
                if (!str.equals("ndo")) {
                }
                break;
            case 108925:
                if (str.equals("nds")) {
                    return "Low German";
                }
                break;
            case 108953:
                if (!str.equals("nep")) {
                }
                break;
            case 108960:
                if (str.equals("new")) {
                    return "Newari";
                }
                break;
            case 109062:
                if (str.equals("nia")) {
                    return "Nias";
                }
                break;
            case 109082:
                if (str.equals("niu")) {
                    return "Niuean";
                }
                break;
            case 109231:
                if (!str.equals("nno")) {
                }
                break;
            case 109249:
                if (!str.equals("nob")) {
                }
                break;
            case 109254:
                if (str.equals("nog")) {
                    return "Nogai";
                }
                break;
            case 109261:
                if (str.equals("non")) {
                    return "Old Norse";
                }
                break;
            case 109265:
                if (!str.equals("nor")) {
                }
                break;
            case 109324:
                if (str.equals("nqo")) {
                    return "N'Ko";
                }
                break;
            case 109386:
                if (str.equals("nso")) {
                    return "Pedi";
                }
                break;
            case 109498:
                if (str.equals("nwc")) {
                    return "Classical Newari";
                }
                break;
            case 109558:
                if (!str.equals("nya")) {
                }
                break;
            case 109570:
                if (str.equals("nym")) {
                    return "Nyamwezi";
                }
                break;
            case 109571:
                if (str.equals("nyn")) {
                    return "Nyankole";
                }
                break;
            case 109572:
                if (str.equals("nyo")) {
                    return "Nyoro";
                }
                break;
            case 109597:
                if (str.equals("nzi")) {
                    return "Nzima";
                }
                break;
            case 109845:
                if (!str.equals("oci")) {
                }
                break;
            case 110062:
                if (!str.equals("oji")) {
                }
                break;
            case 110310:
                if (!str.equals("ori")) {
                }
                break;
            case 110314:
                if (!str.equals("orm")) {
                }
                break;
            case 110333:
                if (str.equals("osa")) {
                    return "Osage";
                }
                break;
            case 110351:
                if (!str.equals("oss")) {
                }
                break;
            case 110364:
                if (str.equals("ota")) {
                    return "Ottoman Turkish (1500-1928)";
                }
                break;
            case 110742:
                if (str.equals("pag")) {
                    return "Pangasinan";
                }
                break;
            case 110747:
                if (str.equals("pal")) {
                    return "Pahlavi";
                }
                break;
            case 110748:
                if (str.equals("pam")) {
                    return "Pampanga";
                }
                break;
            case 110749:
                if (!str.equals("pan")) {
                }
                break;
            case 110751:
                if (str.equals("pap")) {
                    return "Papiamento";
                }
                break;
            case 110756:
                if (str.equals("pau")) {
                    return "Palauan";
                }
                break;
            case 110874:
                if (str.equals("peo")) {
                    return "Old Persian (ca. 600-400 B.C.)";
                }
                break;
            case 110966:
                if (str.equals("phn")) {
                    return "Phoenician";
                }
                break;
            case 111085:
                if (!str.equals("pli")) {
                }
                break;
            case 111181:
                if (!str.equals(BrowserInfo.KEY_POL)) {
                }
                break;
            case 111183:
                if (str.equals("pon")) {
                    return "Pohnpeian";
                }
                break;
            case 111187:
                break;
            case 111277:
                if (str.equals("pro")) {
                    return "Old Provençal (to 1500)";
                }
                break;
            case 111374:
                if (!str.equals("pus")) {
                }
                break;
            case 112321:
                if (!str.equals("que")) {
                }
                break;
            case 112667:
                if (str.equals("raj")) {
                    return "Rajasthani";
                }
                break;
            case 112673:
                if (str.equals("rap")) {
                    return "Rapanui";
                }
                break;
            case 112675:
                if (str.equals("rar")) {
                    return "Rarotongan";
                }
                break;
            case 113099:
                if (!str.equals("roh")) {
                }
                break;
            case 113104:
                if (str.equals("rom")) {
                    return "Romany";
                }
                break;
            case 113291:
                if (!str.equals("run")) {
                }
                break;
            case 113293:
                if (str.equals("rup")) {
                    return "Macedo Romanian";
                }
                break;
            case 113296:
                if (!str.equals("rus")) {
                }
                break;
            case 113622:
                if (str.equals("sad")) {
                    return "Sandawe";
                }
                break;
            case 113625:
                if (!str.equals("sag")) {
                }
                break;
            case 113626:
                if (str.equals("sah")) {
                    return "Yakut";
                }
                break;
            case 113631:
                if (str.equals("sam")) {
                    return "Samaritan Aramaic";
                }
                break;
            case 113632:
                if (!str.equals("san")) {
                }
                break;
            case 113637:
                if (str.equals("sas")) {
                    return "Sasak";
                }
                break;
            case 113638:
                if (str.equals("sat")) {
                    return "Santali";
                }
                break;
            case 113694:
                if (str.equals("scn")) {
                    return "Sicilian";
                }
                break;
            case 113695:
                if (str.equals("sco")) {
                    return "Scots";
                }
                break;
            case 113754:
                if (str.equals("sel")) {
                    return "Selkup";
                }
                break;
            case 113805:
                if (str.equals("sga")) {
                    return "Old Irish (to 900)";
                }
                break;
            case 113849:
                if (str.equals("shn")) {
                    return "Shan";
                }
                break;
            case 113870:
                if (str.equals("sid")) {
                    return "Sidamo";
                }
                break;
            case 113880:
                if (!str.equals("sin")) {
                }
                break;
            case 113981:
                if (!str.equals("slv")) {
                }
                break;
            case 113991:
                if (str.equals("sma")) {
                    return "Southern Sami";
                }
                break;
            case 113995:
                if (!str.equals("sme")) {
                }
                break;
            case 114000:
                if (str.equals("smj")) {
                    return "Lule Sami";
                }
                break;
            case 114004:
                if (str.equals("smn")) {
                    return "Inari Sami";
                }
                break;
            case 114005:
                if (!str.equals("smo")) {
                }
                break;
            case 114009:
                if (str.equals("sms")) {
                    return "Skolt Sami";
                }
                break;
            case 114022:
                if (!str.equals("sna")) {
                }
                break;
            case 114025:
                if (!str.equals("snd")) {
                }
                break;
            case 114032:
                if (str.equals("snk")) {
                    return "Soninke";
                }
                break;
            case 114059:
                if (str.equals("sog")) {
                    return "Sogdian";
                }
                break;
            case 114065:
                if (!str.equals("som")) {
                }
                break;
            case 114072:
                if (!str.equals("sot")) {
                }
                break;
            case 114084:
                break;
            case 114149:
                if (!str.equals("srd")) {
                }
                break;
            case 114159:
                if (str.equals("srn")) {
                    return "Sranan Tongo";
                }
                break;
            case 114163:
                if (str.equals("srr")) {
                    return "Serer";
                }
                break;
            case 114199:
                if (!str.equals("ssw")) {
                }
                break;
            case 114249:
                if (str.equals("suk")) {
                    return "Sukuma";
                }
                break;
            case 114252:
                if (!str.equals("sun")) {
                }
                break;
            case 114257:
                if (str.equals("sus")) {
                    return "Susu";
                }
                break;
            case 114262:
                if (str.equals("sux")) {
                    return "Sumerian";
                }
                break;
            case 114301:
                if (!str.equals("swa")) {
                }
                break;
            case 114305:
                if (!str.equals("swe")) {
                }
                break;
            case 114365:
                if (str.equals("syc")) {
                    return "Classical Syriac";
                }
                break;
            case 114380:
                if (str.equals("syr")) {
                    return "Syriac";
                }
                break;
            case 114587:
                if (!str.equals("tah")) {
                }
                break;
            case 114592:
                if (!str.equals("tam")) {
                }
                break;
            case 114599:
                if (!str.equals("tat")) {
                }
                break;
            case 114715:
                if (!str.equals("tel")) {
                }
                break;
            case 114716:
                if (str.equals("tem")) {
                    return "Timne";
                }
                break;
            case 114721:
                if (str.equals("ter")) {
                    return "Tereno";
                }
                break;
            case 114723:
                if (str.equals("tet")) {
                    return "Tetum";
                }
                break;
            case 114776:
                if (!str.equals("tgk")) {
                }
                break;
            case 114777:
                if (!str.equals("tgl")) {
                }
                break;
            case 114797:
                if (!str.equals("tha")) {
                }
                break;
            case 114834:
                if (str.equals("tig")) {
                    return "Tigre";
                }
                break;
            case 114845:
                if (!str.equals("tir")) {
                }
                break;
            case 114849:
                if (str.equals("tiv")) {
                    return "Tiv";
                }
                break;
            case 114901:
                if (str.equals("tkl")) {
                    return "Tokelau";
                }
                break;
            case 114928:
                if (str.equals("tlh")) {
                    return "Klingon";
                }
                break;
            case 114929:
                if (str.equals("tli")) {
                    return "Tlingit";
                }
                break;
            case 114959:
                if (str.equals("tmh")) {
                    return "Tamashek";
                }
                break;
            case 115020:
                if (str.equals("tog")) {
                    return "Tonga (Nyasa)";
                }
                break;
            case 115027:
                if (!str.equals("ton")) {
                }
                break;
            case 115053:
                if (str.equals("tpi")) {
                    return "Tok Pisin";
                }
                break;
            case 115146:
                if (str.equals("tsi")) {
                    return "Tsimshian";
                }
                break;
            case 115151:
                if (!str.equals("tsn")) {
                }
                break;
            case 115152:
                if (!str.equals("tso")) {
                }
                break;
            case 115210:
                if (!str.equals("tuk")) {
                }
                break;
            case 115212:
                if (str.equals("tum")) {
                    return "Tumbuka";
                }
                break;
            case 115217:
                if (!str.equals("tur")) {
                }
                break;
            case 115242:
                if (str.equals("tvl")) {
                    return "Tuvalu";
                }
                break;
            case 115270:
                if (!str.equals("twi")) {
                }
                break;
            case 115345:
                if (str.equals("tyv")) {
                    return "Tuvinian";
                }
                break;
            case 115646:
                if (str.equals("udm")) {
                    return "Udmurt";
                }
                break;
            case 115727:
                if (str.equals("uga")) {
                    return "Ugaritic";
                }
                break;
            case 115795:
                if (!str.equals("uig")) {
                }
                break;
            case 115868:
                if (!str.equals("ukr")) {
                }
                break;
            case 115914:
                if (str.equals("umb")) {
                    return "Umbundu";
                }
                break;
            case 115947:
                if (str.equals("und")) {
                    return "Undetermined";
                }
                break;
            case 116071:
                if (!str.equals("urd")) {
                }
                break;
            case 116317:
                if (!str.equals("uzb")) {
                }
                break;
            case 116510:
                if (str.equals("vai")) {
                    return "Vai";
                }
                break;
            case 116639:
                if (!str.equals("ven")) {
                }
                break;
            case 116754:
                if (!str.equals("vie")) {
                }
                break;
            case 116947:
                if (!str.equals("vol")) {
                }
                break;
            case 116955:
                if (str.equals("vot")) {
                    return "Votic";
                }
                break;
            case 117474:
                if (str.equals("wal")) {
                    return "Wolaytta";
                }
                break;
            case 117480:
                if (str.equals("war")) {
                    return "Waray (Philippines)";
                }
                break;
            case 117481:
                if (str.equals("was")) {
                    return "Washo";
                }
                break;
            case 117817:
                if (!str.equals("wln")) {
                }
                break;
            case 117908:
                if (!str.equals("wol")) {
                }
                break;
            case 118435:
                if (str.equals("xal")) {
                    return "Kalmyk";
                }
                break;
            case 118655:
                if (!str.equals("xho")) {
                }
                break;
            case 119399:
                if (str.equals("yao")) {
                    return "Yao";
                }
                break;
            case 119400:
                if (str.equals("yap")) {
                    return "Yapese";
                }
                break;
            case 119636:
                if (!str.equals("yid")) {
                }
                break;
            case 119836:
                if (!str.equals("yor")) {
                }
                break;
            case 120361:
                if (str.equals("zap")) {
                    return "Zapotec";
                }
                break;
            case 120388:
                if (str.equals("zbl")) {
                    return "Blissymbols";
                }
                break;
            case 120483:
                if (str.equals("zen")) {
                    return "Zenaga";
                }
                break;
            case 120563:
                if (!str.equals("zha")) {
                }
                break;
            case 120977:
                if (!str.equals("zul")) {
                }
                break;
            case 120979:
                if (str.equals("zun")) {
                    return "Zuni";
                }
                break;
            case 121082:
                if (str.equals("zxx")) {
                    return "No linguistic content";
                }
                break;
            case 38377895:
                if (!str.equals("bnt (r)")) {
                }
                break;
            case 52230772:
                break;
            case 76762939:
                if (str.equals("qaa-qtz")) {
                    return "Reserved for local use";
                }
                break;
            case 115861428:
                if (str.equals("zh_HK")) {
                    String string3 = context.getString(R.string.language_zh_HK);
                    i.f(string3, "mContext.getString(R.string.language_zh_HK)");
                    return string3;
                }
            case 201840647:
                if (str.equals("btk (c)")) {
                    return "Batak languages";
                }
                break;
            case 236934414:
                break;
            case 281592297:
                break;
            case 543543882:
                if (str.equals("cai (r)")) {
                    return "Central American Indian";
                }
                break;
            case 554626134:
                if (str.equals("cau (r)")) {
                    return "Caucasian";
                }
                break;
            case 638230155:
                break;
            case 660831049:
                if (str.equals("cel (r)")) {
                    return "Celtic";
                }
                break;
            case 667295758:
                break;
            case 823104478:
                break;
            case 834186730:
                break;
            case 835110747:
                if (str.equals("map (r)")) {
                    return "Austronesian (Other)";
                }
                break;
            case 843421940:
                if (str.equals("may (b)")) {
                    return "Malay (macrolanguage)";
                }
                break;
            case 881552227:
                if (str.equals("cmc (g)")) {
                    return "Chamic languages";
                }
                break;
            case 918821818:
                if (str.equals("him (c)")) {
                    return "Himachali";
                }
                break;
            case 969287063:
                if (str.equals("cpe (r)")) {
                    return "Creoles and pidgins, English based";
                }
                break;
            case 970210584:
                if (str.equals("cpf (r)")) {
                    return "Creoles and pidgins, French-based";
                }
                break;
            case 979445794:
                if (str.equals("cpp (r)")) {
                    return "Creoles and pidgins, Portuguese-based";
                }
                break;
            case 1010581404:
                break;
            case 1036704096:
                if (str.equals("crp (r)")) {
                    return "Creoles and pidgins";
                }
                break;
            case 1110320067:
                break;
            case 1114014089:
                if (str.equals("mkh (r)")) {
                    return "Mon-Khmer (Other)";
                }
                break;
            case 1115595019:
                if (str.equals("wak (g)")) {
                    return "Wakashan languages";
                }
                break;
            case 1125362112:
                if (str.equals("cus (r)")) {
                    return "Cushitic (Other)";
                }
                break;
            case 1184796393:
                break;
            case 1206365848:
                if (str.equals("mno (g)")) {
                    return "Manobo languages";
                }
                break;
            case 1231034989:
                break;
            case 1232882186:
                if (str.equals("wen (g)")) {
                    return "Sorbian languages";
                }
                break;
            case 1234337652:
                break;
            case 1255578077:
                break;
            case 1315341729:
                break;
            case 1336582712:
                if (str.equals("msa (t)")) {
                    return "Malay (macrolanguage)";
                }
                break;
            case 1364617155:
                if (str.equals("roa (r)")) {
                    return "Romance (Other)";
                }
                break;
            case 1376622990:
                break;
            case 1405846384:
                if (str.equals("mun (g)")) {
                    return "Munda languages";
                }
                break;
            case 1445823434:
                if (str.equals("day (c)")) {
                    return "Land Dayak languages";
                }
                break;
            case 1508357618:
                break;
            case 1520362988:
                if (str.equals("myn (g)")) {
                    return "Mayan languages";
                }
                break;
            case 1547473817:
                break;
            case 1556646481:
                if (!str.equals("deu (t)")) {
                }
                break;
            case 1627162394:
                if (!str.equals("ice (b)")) {
                }
                break;
            case 1715225795:
                if (str.equals("nah (c)")) {
                    return "Nahuatl languages";
                }
                break;
            case 1716149781:
                if (str.equals("nai (r)")) {
                    return "North American Indian";
                }
                break;
            case 1836801692:
                if (str.equals("ijo (c)")) {
                    return "Ijo languages";
                }
                break;
            case 1858700890:
                if (str.equals("sai (r)")) {
                    return "South American Indian (Other)";
                }
                break;
            case 1861471112:
                if (str.equals("sal (g)")) {
                    return "Salishan languages";
                }
                break;
            case 1910354962:
                if (str.equals("dra (r)")) {
                    return "Dravidian";
                }
                break;
            case 1939641863:
                if (str.equals("nic (r)")) {
                    return "Niger-Kordofanian";
                }
                break;
            case 1940236509:
                if (str.equals("inc (r)")) {
                    return "Indic ";
                }
                break;
            case 1942083551:
                if (str.equals("ine (r)")) {
                    return "Indo-European";
                }
                break;
            case 1976911578:
                if (str.equals("sem (r)")) {
                    return "Semitic (Other)";
                }
                break;
            case 2013788818:
                break;
            case 2026452899:
                break;
            case 2035093060:
                if (str.equals("sgn (g)")) {
                    return "Sign Languages";
                }
                break;
            case 2052906071:
                if (str.equals("ira (r)")) {
                    return "Iranian (Other)";
                }
                break;
            case 2065835024:
                if (str.equals("iro (g)")) {
                    return "Iroquoian languages";
                }
                break;
            case 2091694015:
                if (!str.equals("isl (t)")) {
                }
                break;
            case 2093274883:
                if (str.equals("sio (g)")) {
                    return "Siouan languages";
                }
                break;
            case 2097892829:
                if (str.equals("sit (r)")) {
                    return "Sino-Tibetan (Other)";
                }
                break;
        }
    }

    public final void putSelectSubtitle(String str, int i10, String str2) {
        i.g(str, "key");
        i.g(str2, "subTitleLanguage");
        if (TextUtils.isEmpty(str) || i10 < -1) {
            return;
        }
        RecordSubtitleInfoBean recordSubtitleInfoBean = mLruCacheLanguages.get(str);
        if (recordSubtitleInfoBean == null) {
            mLruCacheLanguages.put(str, new RecordSubtitleInfoBean(i10, str2));
        } else {
            recordSubtitleInfoBean.setSubtitleIndex(i10);
            recordSubtitleInfoBean.setSubTitleLanguage(str2);
        }
    }

    public final void setMGlobalAudioLanguage(int i10) {
        mGlobalAudioLanguage = i10;
    }

    public final void setMGlobalColor(int i10) {
        mGlobalColor = i10;
    }

    public final void setMGlobalLanguage(int i10) {
        mGlobalLanguage = i10;
    }

    public final void setMGlobalSize(int i10) {
        mGlobalSize = i10;
    }

    public final void setMGlobalSwitch(boolean z10) {
        mGlobalSwitch = z10;
    }

    public final void setMLruCacheAudioLanguages(LruCache<String, String> lruCache) {
        i.g(lruCache, "<set-?>");
        mLruCacheAudioLanguages = lruCache;
    }

    public final void setMLruCacheColor(LruCache<String, Integer> lruCache) {
        i.g(lruCache, "<set-?>");
        mLruCacheColor = lruCache;
    }

    public final void setMLruCacheLanguages(HashMap<String, RecordSubtitleInfoBean> hashMap) {
        i.g(hashMap, "<set-?>");
        mLruCacheLanguages = hashMap;
    }

    public final void setMLruCacheSize(LruCache<String, Integer> lruCache) {
        i.g(lruCache, "<set-?>");
        mLruCacheSize = lruCache;
    }

    public final void setMLruCacheSwitch(LruCache<String, Boolean> lruCache) {
        i.g(lruCache, "<set-?>");
        mLruCacheSwitch = lruCache;
    }
}
