package com.hpplay.sdk.source.mdns.xbill.dns;

/* loaded from: classes3.dex */
public class RelativeNameException extends IllegalArgumentException {
    public RelativeNameException(Name name) {
        super("'" + name + "' is not an absolute name");
    }

    public RelativeNameException(String str) {
        super(str);
    }
}
