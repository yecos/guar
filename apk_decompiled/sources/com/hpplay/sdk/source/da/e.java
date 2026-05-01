package com.hpplay.sdk.source.da;

import android.content.Context;
import com.hpplay.sdk.source.bean.OutParameter;
import com.hpplay.sdk.source.business.BusinessEntity;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.utils.CreateUtil;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class e implements j {

    /* renamed from: a, reason: collision with root package name */
    private static final String f7635a = "DaManager";

    /* renamed from: b, reason: collision with root package name */
    private static e f7636b;

    /* renamed from: c, reason: collision with root package name */
    private OutParameter f7637c;

    /* renamed from: d, reason: collision with root package name */
    private j f7638d;

    /* renamed from: e, reason: collision with root package name */
    private Map<String, String> f7639e = new HashMap();

    private e() {
    }

    public static synchronized e d() {
        e eVar;
        synchronized (e.class) {
            synchronized (e.class) {
                if (f7636b == null) {
                    f7636b = new e();
                }
                eVar = f7636b;
            }
            return eVar;
        }
        return eVar;
    }

    @Override // com.hpplay.sdk.source.da.j
    public void a(Context context) {
        j a10 = b.a(context);
        this.f7638d = a10;
        if (a10 == null) {
            SourceLog.w(f7635a, "init error");
        } else {
            a10.a(context);
        }
    }

    public void b(Context context) {
        OutParameter outParameter = this.f7637c;
        if (outParameter != null) {
            outParameter.pushType = 2;
            BusinessEntity.getInstance().dispatchPlay(context, this.f7637c);
            this.f7637c = null;
        }
    }

    @Override // com.hpplay.sdk.source.da.j
    public void c() {
        f7636b = null;
        this.f7639e.clear();
        j jVar = this.f7638d;
        if (jVar != null) {
            jVar.c();
        }
    }

    @Override // com.hpplay.sdk.source.da.j
    public void a() {
        j jVar = this.f7638d;
        if (jVar != null) {
            jVar.a();
        }
    }

    @Override // com.hpplay.sdk.source.da.j
    public void b() {
        j jVar = this.f7638d;
        if (jVar != null) {
            jVar.b();
        }
    }

    @Override // com.hpplay.sdk.source.da.j
    public void a(OutParameter outParameter, m mVar) {
        b();
        j jVar = this.f7638d;
        if (jVar != null) {
            jVar.a(outParameter, mVar);
        } else if (mVar != null) {
            mVar.onDaResult(false, null);
        }
    }

    public void a(Context context, OutParameter outParameter, String str) {
        this.f7637c = outParameter;
        OutParameter m45clone = outParameter.m45clone();
        m45clone.setUrl(str);
        String createPushUri = CreateUtil.createPushUri(m45clone.getPlayUrl());
        m45clone.urlID = createPushUri;
        m45clone.pushType = 1;
        this.f7639e.put(outParameter.session, createPushUri);
        BusinessEntity.getInstance().dispatchPlay(context, m45clone);
    }

    public String a(String str) {
        return this.f7639e.get(str);
    }

    @Override // com.hpplay.sdk.source.da.k
    public void a(OutParameter outParameter) {
        j jVar = this.f7638d;
        if (jVar != null) {
            jVar.a(outParameter);
        }
    }

    @Override // com.hpplay.sdk.source.da.k
    public void a(OutParameter outParameter, long j10) {
        j jVar = this.f7638d;
        if (jVar != null) {
            jVar.a(outParameter, j10);
        }
    }
}
