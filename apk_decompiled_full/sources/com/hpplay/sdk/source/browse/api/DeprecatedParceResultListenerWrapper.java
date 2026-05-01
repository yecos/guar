package com.hpplay.sdk.source.browse.api;

/* loaded from: classes3.dex */
public class DeprecatedParceResultListenerWrapper implements IServiceInfoParseListener {
    private final IParceResultListener mParceResultListener;

    public DeprecatedParceResultListenerWrapper(IParceResultListener iParceResultListener) {
        this.mParceResultListener = iParceResultListener;
    }

    @Override // com.hpplay.sdk.source.browse.api.IServiceInfoParseListener
    public void onParseResult(int i10, LelinkServiceInfo lelinkServiceInfo) {
        IParceResultListener iParceResultListener = this.mParceResultListener;
        if (iParceResultListener != null) {
            iParceResultListener.onParceResult(i10, lelinkServiceInfo);
        }
    }
}
