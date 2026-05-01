package com.hpplay.sdk.source.device.pincode;

import com.hpplay.sdk.source.browse.api.IServiceInfoParseListener;

/* loaded from: classes3.dex */
public interface CodeParser {
    void parsePinCode(PinCodeInfo pinCodeInfo);

    void release();

    void setCodeCallback(IServiceInfoParseListener iServiceInfoParseListener);

    void setConferenceFuzzyMatchingPinCodeCallback(IConferenceFuzzyMatchingPinCodeListener iConferenceFuzzyMatchingPinCodeListener);
}
