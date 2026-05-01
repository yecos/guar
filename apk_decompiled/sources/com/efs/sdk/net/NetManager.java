package com.efs.sdk.net;

import android.content.Context;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.core.util.Log;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.util.Map;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/* loaded from: classes.dex */
public class NetManager {
    private static final String TAG = "OkHttpManager";
    private static NetConfigManager mNetConfigManager;
    private static EfsReporter mReporter;

    public static void get(String str, Callback callback) {
        new OkHttpClient.Builder().eventListenerFactory(OkHttpListener.get()).addNetworkInterceptor(new OkHttpInterceptor()).build().newCall(new Request.Builder().url(str).build()).enqueue(callback);
    }

    public static NetConfigManager getNetConfigManager() {
        return mNetConfigManager;
    }

    public static EfsReporter getReporter() {
        return mReporter;
    }

    public static void init(Context context, EfsReporter efsReporter) {
        if (context == null || efsReporter == null) {
            Log.e(TAG, "init net manager error! parameter is null!");
        } else {
            mReporter = efsReporter;
            mNetConfigManager = new NetConfigManager(context, efsReporter);
        }
    }

    public static void post(String str, Map<String, Object> map, Callback callback) {
        StringBuilder sb = new StringBuilder();
        for (String str2 : map.keySet()) {
            sb.append(str2);
            sb.append(Operator.Operation.EQUALS);
            sb.append(map.get(str2));
            sb.append(DispatchConstants.SIGN_SPLIT_SYMBOL);
        }
        new OkHttpClient.Builder().eventListenerFactory(OkHttpListener.get()).addNetworkInterceptor(new OkHttpInterceptor()).build().newCall(new Request.Builder().url(str).post(RequestBody.create(MediaType.parse("application/x-www-form-urlencoded"), sb.toString())).build()).enqueue(callback);
    }

    public static void postJson(String str, String str2, Callback callback) {
        new OkHttpClient.Builder().eventListenerFactory(OkHttpListener.get()).addNetworkInterceptor(new OkHttpInterceptor()).build().newCall(new Request.Builder().url(str).post(RequestBody.create(str2, MediaType.parse("application/json;charset=utf-8"))).build()).enqueue(callback);
    }

    public static void postJsonWithUrlUpdate(String str, final String str2, String str3, Callback callback) {
        new OkHttpClient.Builder().eventListenerFactory(OkHttpListener.get()).addNetworkInterceptor(new OkHttpInterceptor()).addInterceptor(new Interceptor() { // from class: com.efs.sdk.net.NetManager.1
            @Override // okhttp3.Interceptor
            public final Response intercept(Interceptor.Chain chain) {
                return chain.proceed(chain.request().newBuilder().url(str2).build());
            }
        }).build().newCall(new Request.Builder().url(str).post(RequestBody.create(str3, MediaType.parse("application/json;charset=utf-8"))).build()).enqueue(callback);
    }
}
