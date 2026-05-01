package com.hpplay.sdk.source.da;

import android.content.Context;
import com.hpplay.sdk.source.bean.OutParameter;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.log.SourceLog;

/* loaded from: classes3.dex */
public class DaClientImpl implements j {

    /* renamed from: a, reason: collision with root package name */
    private final String f7599a = "DaClientImpl";

    /* renamed from: b, reason: collision with root package name */
    private Context f7600b;

    public DaClientImpl(Context context) {
        this.f7600b = context;
    }

    @Override // com.hpplay.sdk.source.da.j
    public void a(Context context) {
        SourceLog.i("DaClientImpl", "init");
    }

    @Override // com.hpplay.sdk.source.da.j
    public void b() {
        f.a().d();
    }

    @Override // com.hpplay.sdk.source.da.j
    public void c() {
        f.b();
        h.b();
        g.b();
    }

    @Override // com.hpplay.sdk.source.da.j
    public void a() {
        SourceLog.i("DaClientImpl", "requestDaConfig");
        f.a().c();
    }

    @Override // com.hpplay.sdk.source.da.j
    public void a(OutParameter outParameter, m mVar) {
        LelinkServiceInfo lelinkServiceInfo;
        if (outParameter == null || (lelinkServiceInfo = outParameter.serviceInfo) == null) {
            if (mVar != null) {
                mVar.onDaResult(false, null);
                return;
            }
            return;
        }
        int appId = lelinkServiceInfo.getAppId();
        SourceLog.i("DaClientImpl", "loadPatchDa loadPatchDa appId :" + appId);
        boolean a10 = a(appId);
        SourceLog.i("DaClientImpl", "loadPatchDa loadPatchDa :" + a10);
        if (a10) {
            f.a().a(this.f7600b, outParameter, mVar);
        } else if (mVar != null) {
            mVar.onDaResult(false, null);
        }
    }

    private boolean a(int i10) {
        if (d.a() == 0) {
            return false;
        }
        if (i10 == 0) {
            return d.c() != 0;
        }
        String valueOf = String.valueOf(i10);
        String[] b10 = d.b();
        if (b10 != null) {
            for (String str : b10) {
                if (valueOf.equals(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.hpplay.sdk.source.da.k
    public void a(OutParameter outParameter) {
        h.a().a(this.f7600b, outParameter);
    }

    @Override // com.hpplay.sdk.source.da.k
    public void a(OutParameter outParameter, long j10) {
        h.a().a(this.f7600b, outParameter, j10);
    }
}
