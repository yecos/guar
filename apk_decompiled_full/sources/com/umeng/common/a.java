package com.umeng.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.analytics.pro.bd;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.utils.UMUtils;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static String f10721a = null;

    /* renamed from: b, reason: collision with root package name */
    private static final String f10722b = "umeng+";

    /* renamed from: c, reason: collision with root package name */
    private static final String f10723c = "ek__id";

    /* renamed from: d, reason: collision with root package name */
    private static final String f10724d = "ek_key";

    /* renamed from: e, reason: collision with root package name */
    private static String f10725e = "";

    /* renamed from: f, reason: collision with root package name */
    private static final String f10726f = bd.b().b(bd.f9987n);

    /* renamed from: g, reason: collision with root package name */
    private static String f10727g = "";

    /* renamed from: h, reason: collision with root package name */
    private static a f10728h;

    private a() {
    }

    public static a a() {
        if (f10728h == null) {
            synchronized (a.class) {
                if (f10728h == null) {
                    f10728h = new a();
                }
            }
        }
        return f10728h;
    }

    private String c(String str) {
        String str2 = "";
        try {
            String substring = str.substring(1, 9);
            StringBuilder sb = new StringBuilder();
            for (int i10 = 0; i10 < substring.length(); i10++) {
                char charAt = substring.charAt(i10);
                if (!Character.isDigit(charAt)) {
                    sb.append(charAt);
                } else if (Integer.parseInt(Character.toString(charAt)) == 0) {
                    sb.append(0);
                } else {
                    sb.append(10 - Integer.parseInt(Character.toString(charAt)));
                }
            }
            str2 = sb.toString();
            return str2 + new StringBuilder(str2).reverse().toString();
        } catch (Throwable unused) {
            return str2;
        }
    }

    public String b(String str) {
        String str2;
        String str3;
        try {
            return TextUtils.isEmpty(f10721a) ? str : new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), f10721a.getBytes()));
        } catch (Exception unused) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败!");
            String str4 = null;
            if (TextUtils.isEmpty(f10725e)) {
                return null;
            }
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，换老秘钥重试");
            try {
                str3 = new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), f10725e.getBytes()));
            } catch (Exception unused2) {
            }
            try {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，换老秘钥重试成功。");
                return str3;
            } catch (Exception unused3) {
                str4 = str3;
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，换老秘钥重试失败。换子进程备份key重试。");
                try {
                    String str5 = new String(DataHelper.decrypt(Base64.decode(str.getBytes(), 0), f10727g.getBytes()));
                    try {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，子进程备份key重试成功。");
                        return str5;
                    } catch (Throwable unused4) {
                        str2 = str5;
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程事件数据解密失败，子进程备份key重试失败。");
                        return str2;
                    }
                } catch (Throwable unused5) {
                    str2 = str4;
                }
            }
        }
    }

    public void a(Context context) {
        try {
            if (TextUtils.isEmpty(f10721a)) {
                String multiProcessSP = UMUtils.getMultiProcessSP(context, f10723c);
                if (!TextUtils.isEmpty(multiProcessSP)) {
                    f10725e = c(multiProcessSP);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>> primaryKey: " + f10725e);
                }
                SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(f10726f, 0);
                if (sharedPreferences != null) {
                    f10727g = sharedPreferences.getString(f10723c, null);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 子进程备份秘钥：主进程key: " + f10727g);
                }
                f10721a = c(UMUtils.genId());
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>> 正式秘钥：key: " + f10721a);
            }
        } catch (Throwable unused) {
        }
    }

    public String a(String str) {
        try {
            return TextUtils.isEmpty(f10721a) ? str : Base64.encodeToString(DataHelper.encrypt(str.getBytes(), f10721a.getBytes()), 0);
        } catch (Exception unused) {
            return null;
        }
    }
}
