package com.efs.sdk.pa;

/* loaded from: classes.dex */
public final class a implements PAANRListener {

    /* renamed from: a, reason: collision with root package name */
    private PAFactory f6440a;

    /* renamed from: b, reason: collision with root package name */
    private PATraceListener f6441b;

    public a(PAFactory pAFactory) {
        this.f6440a = pAFactory;
        this.f6441b = pAFactory.getTraceListener();
        boolean enableTracer = pAFactory.getConfigManager().enableTracer();
        PATraceListener pATraceListener = this.f6441b;
        if (pATraceListener != null) {
            pATraceListener.onCheck(enableTracer);
        }
    }

    @Override // com.efs.sdk.pa.PAANRListener
    public final void anrStack(String str) {
        if (str == null || str.length() <= 200) {
            return;
        }
        c.a(this.f6440a, "patrace", str);
        PATraceListener pATraceListener = this.f6441b;
        if (pATraceListener != null) {
            pATraceListener.onAnrTrace();
        }
    }

    @Override // com.efs.sdk.pa.PAANRListener
    public final void unexcept(Object obj) {
        PATraceListener pATraceListener = this.f6441b;
        if (pATraceListener != null) {
            pATraceListener.onUnexcept(obj);
        }
    }
}
