package com.mobile.brasiltv.bean;

import android.content.Context;
import android.text.TextUtils;
import android.util.LruCache;
import com.msandroid.mobile.R;
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
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String getTranslateString(android.content.Context r20, java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 12036
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mobile.brasiltv.bean.SubtitleManager.getTranslateString(android.content.Context, java.lang.String):java.lang.String");
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
