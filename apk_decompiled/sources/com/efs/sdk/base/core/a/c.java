package com.efs.sdk.base.core.a;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.efs.sdk.base.BuildConfig;
import com.efs.sdk.base.EfsConstant;
import com.efs.sdk.base.core.controller.ControllerCenter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.core.util.PackageUtil;
import com.efs.sdk.base.core.util.secure.EncodeUtil;
import com.google.firebase.dynamiclinks.DynamicLink;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.raizlabs.android.dbflow.sql.language.Operator;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    String f6050a;

    /* renamed from: b, reason: collision with root package name */
    String f6051b;

    /* renamed from: c, reason: collision with root package name */
    String f6052c;

    /* renamed from: d, reason: collision with root package name */
    public String f6053d;

    /* renamed from: e, reason: collision with root package name */
    public int f6054e;

    /* renamed from: f, reason: collision with root package name */
    public String f6055f;

    /* renamed from: g, reason: collision with root package name */
    public byte f6056g;

    /* renamed from: h, reason: collision with root package name */
    public String f6057h;

    /* renamed from: i, reason: collision with root package name */
    String f6058i;

    /* renamed from: j, reason: collision with root package name */
    String f6059j;

    /* renamed from: k, reason: collision with root package name */
    String f6060k;

    /* renamed from: l, reason: collision with root package name */
    String f6061l;

    /* renamed from: m, reason: collision with root package name */
    String f6062m = "";

    /* renamed from: n, reason: collision with root package name */
    String f6063n = "";

    /* renamed from: o, reason: collision with root package name */
    public long f6064o = 0;

    public static c a() {
        c cVar = new c();
        cVar.f6050a = ControllerCenter.getGlobalEnvStruct().getAppid();
        cVar.f6051b = ControllerCenter.getGlobalEnvStruct().getSecret();
        cVar.f6061l = ControllerCenter.getGlobalEnvStruct().getUid();
        cVar.f6062m = ControllerCenter.getGlobalEnvStruct().getLogUid();
        cVar.f6063n = ControllerCenter.getGlobalEnvStruct().getLogDid();
        cVar.f6059j = BuildConfig.VERSION_NAME;
        cVar.f6052c = PackageUtil.getAppVersionName(ControllerCenter.getGlobalEnvStruct().mAppContext);
        cVar.f6058i = String.valueOf(com.efs.sdk.base.core.config.remote.b.a().f6151d.mConfigVersion);
        cVar.f6060k = EfsConstant.UM_SDK_VERSION;
        return cVar;
    }

    public final String b() {
        a.a();
        String valueOf = String.valueOf(a.b() / 1000);
        String base64EncodeToStr = EncodeUtil.base64EncodeToStr(com.efs.sdk.base.core.util.secure.a.a(this.f6061l + valueOf, this.f6051b));
        String base64EncodeToStr2 = EncodeUtil.base64EncodeToStr(com.efs.sdk.base.core.util.secure.a.a(EncodeUtil.base64DecodeToStr(this.f6062m.getBytes()) + "_" + valueOf, this.f6051b));
        TreeMap treeMap = new TreeMap();
        treeMap.put("app", this.f6050a);
        treeMap.put(DynamicLink.SocialMetaTagParameters.KEY_SOCIAL_DESCRIPTION, base64EncodeToStr);
        treeMap.put("logud", base64EncodeToStr2);
        String a10 = a(ControllerCenter.getGlobalEnvStruct().mAppContext);
        if (!TextUtils.isEmpty(a10)) {
            String base64EncodeToStr3 = EncodeUtil.base64EncodeToStr(com.efs.sdk.base.core.util.secure.a.a(a10 + "_" + valueOf, this.f6051b));
            treeMap.put("wl_dd", base64EncodeToStr3);
            treeMap.put("logdd", base64EncodeToStr3);
        }
        if (!TextUtils.isEmpty(this.f6053d)) {
            treeMap.put("cp", this.f6053d);
        }
        if (this.f6056g != 0) {
            treeMap.put("de", String.valueOf(this.f6054e));
            treeMap.put("type", this.f6057h);
            String str = this.f6055f;
            if (TextUtils.isEmpty(str)) {
                a.a();
                long b10 = a.b();
                str = String.format(Locale.SIMPLIFIED_CHINESE, "%d%04d", Long.valueOf(b10), Integer.valueOf(new Random(b10).nextInt(10000)));
            }
            treeMap.put("seq", str);
        }
        treeMap.put("cver", this.f6058i);
        treeMap.put("os", "android");
        treeMap.put("sver", this.f6058i);
        treeMap.put("tm", valueOf);
        treeMap.put(BrowserInfo.KEY_VER, this.f6052c);
        treeMap.put("um_sdk_ver", this.f6060k);
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry entry : treeMap.entrySet()) {
            String str2 = ((String) entry.getKey()) + Operator.Operation.EQUALS + ((String) entry.getValue());
            sb2.append(str2);
            sb.append(str2);
            sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        }
        String md5 = EncodeUtil.md5(sb2.toString() + this.f6051b);
        sb.append("sign=");
        sb.append(md5);
        Log.d("efs.config", sb.toString());
        return EncodeUtil.urlEncode(sb.toString());
    }

    private static String a(Context context) {
        Class<UMConfigure> cls;
        Method method;
        if (context == null) {
            return null;
        }
        try {
            cls = UMConfigure.class;
            UMLog uMLog = UMConfigure.umDebugLog;
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            method = cls.getMethod("getUMIDString", Context.class);
        } catch (NoSuchMethodException unused2) {
            method = null;
        }
        if (method == null) {
            return null;
        }
        try {
            Object invoke = method.invoke(null, context);
            if (invoke != null) {
                return invoke.toString();
            }
            return null;
        } catch (IllegalAccessException | InvocationTargetException unused3) {
            return null;
        }
    }
}
