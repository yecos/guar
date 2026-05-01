package com.efs.sdk.pa;

import android.content.Context;
import android.text.TextUtils;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.core.util.secure.EncodeUtil;
import com.efs.sdk.base.custommapping.InnerCustomMappingManager;
import com.efs.sdk.base.protocol.file.EfsTextFile;
import com.efs.sdk.base.protocol.file.section.AbsSection;
import com.efs.sdk.base.protocol.file.section.KVSection;
import com.efs.sdk.base.protocol.file.section.TextSection;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.umcrash.UMCrash;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class c {
    public static synchronized void a(PAFactory pAFactory, String str, String str2) {
        synchronized (c.class) {
            EfsTextFile efsTextFile = new EfsTextFile(str);
            KVSection createAndAddKVSection = efsTextFile.createAndAddKVSection("custom_info");
            createAndAddKVSection.put("bserial", pAFactory.getSerial());
            createAndAddKVSection.put("bsver", pAFactory.getSver());
            HashMap<String, String> extend = pAFactory.getExtend();
            if (extend != null && !extend.isEmpty()) {
                for (Map.Entry<String, String> entry : extend.entrySet()) {
                    createAndAddKVSection.put(entry.getKey(), entry.getValue());
                }
            }
            createAndAddKVSection.put("crver", "2.1.160.umeng");
            String a10 = a(pAFactory.getContext());
            if (!TextUtils.isEmpty(a10)) {
                createAndAddKVSection.put(UMCrash.KEY_CALLBACK_SESSION_ID, a10);
            }
            if (!TextUtils.isEmpty(str2)) {
                try {
                    String onGetCallbackInfo = pAFactory.getPaClient().onGetCallbackInfo("um_user_string");
                    if (pAFactory.getPaClient() != null && !TextUtils.isEmpty(onGetCallbackInfo)) {
                        createAndAddKVSection.put("um_user_string", EncodeUtil.base64EncodeToStr(onGetCallbackInfo.getBytes()));
                    }
                    String onGetCallbackInfo2 = pAFactory.getPaClient().onGetCallbackInfo(UMCrash.KEY_CALLBACK_PAGE_ACTION);
                    if (pAFactory.getPaClient() != null && !TextUtils.isEmpty(onGetCallbackInfo2)) {
                        createAndAddKVSection.put(UMCrash.KEY_CALLBACK_PAGE_ACTION, EncodeUtil.base64EncodeToStr(onGetCallbackInfo2.getBytes()));
                    }
                    String customMappingJsonStr = InnerCustomMappingManager.getCustomMappingJsonStr();
                    if (pAFactory.getPaClient() != null && !TextUtils.isEmpty(customMappingJsonStr)) {
                        createAndAddKVSection.put(UMCrash.KEY_CALLBACK_CUSTOM_MAPPING, EncodeUtil.base64EncodeToStr(customMappingJsonStr.getBytes()));
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                TextSection createAndAddTextSection = efsTextFile.createAndAddTextSection("stack");
                createAndAddTextSection.setBody(str2);
                createAndAddTextSection.setSep(AbsSection.SEP_LINE_BREAK);
            }
            EfsReporter reporter = pAFactory.getReporter();
            if (reporter != null) {
                reporter.send(efsTextFile);
            }
            pAFactory.getConfigManager().increaseUploadSmoothLogCnt();
            "reportPaWpkStats: stack: ".concat(String.valueOf(str2));
        }
    }

    private static String a(Context context) {
        Class<DeviceConfig> cls;
        Method method;
        if (context == null) {
            return null;
        }
        try {
            cls = DeviceConfig.class;
            String str = DeviceConfig.UNKNOW;
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            method = cls.getMethod("getSid", Context.class);
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
