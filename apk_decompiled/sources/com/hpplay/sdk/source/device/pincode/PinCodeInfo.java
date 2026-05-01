package com.hpplay.sdk.source.device.pincode;

/* loaded from: classes3.dex */
public class PinCodeInfo {
    public int cout;
    public boolean isFuzzyMatching;
    public int page;
    public String pinCode;

    public PinCodeInfo(String str) {
        this.page = 1;
        this.cout = 10;
        this.pinCode = str;
    }

    public PinCodeInfo(String str, int i10, int i11) {
        this.pinCode = str;
        this.cout = i11;
        this.page = i10;
    }
}
