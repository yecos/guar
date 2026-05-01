package com.taobao.accs.net;

import android.text.TextUtils;
import anet.channel.IAuth;
import anet.channel.RequestCb;
import anet.channel.bytes.ByteArray;
import anet.channel.statist.RequestStatistic;
import com.taobao.accs.net.k;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.UtilityImpl;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
class u implements RequestCb {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IAuth.AuthCallback f9227a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ k.a f9228b;

    public u(k.a aVar, IAuth.AuthCallback authCallback) {
        this.f9228b = aVar;
        this.f9227a = authCallback;
    }

    @Override // anet.channel.RequestCb
    public void onDataReceive(ByteArray byteArray, boolean z10) {
    }

    @Override // anet.channel.RequestCb
    public void onFinish(int i10, String str, RequestStatistic requestStatistic) {
        String str2;
        if (i10 < 0) {
            str2 = this.f9228b.f9205c;
            ALog.e(str2, "auth onFinish", "statusCode", Integer.valueOf(i10));
            this.f9227a.onAuthFail(i10, "onFinish auth fail");
        }
    }

    @Override // anet.channel.RequestCb
    public void onResponseCode(int i10, Map<String, List<String>> map) {
        String str;
        String str2;
        a aVar;
        a aVar2;
        a aVar3;
        str = this.f9228b.f9205c;
        ALog.e(str, BaseMonitor.ALARM_POINT_AUTH, "httpStatusCode", Integer.valueOf(i10));
        if (i10 == 200) {
            this.f9227a.onAuthSuccess();
            aVar2 = this.f9228b.f9206d;
            if (aVar2 instanceof k) {
                aVar3 = this.f9228b.f9206d;
                ((k) aVar3).o();
            }
        } else {
            this.f9227a.onAuthFail(i10, "auth fail");
        }
        Map<String, String> a10 = UtilityImpl.a(map);
        str2 = this.f9228b.f9205c;
        ALog.d(str2, BaseMonitor.ALARM_POINT_AUTH, "header", a10);
        String str3 = a10.get("x-at");
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        aVar = this.f9228b.f9206d;
        aVar.f9167k = str3;
    }
}
