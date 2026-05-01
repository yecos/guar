package com.google.zxing.oned.rss.expanded.decoders;

/* loaded from: classes2.dex */
final class DecodedInformation extends DecodedObject {
    private final String newString;
    private final boolean remaining;
    private final int remainingValue;

    public DecodedInformation(int i10, String str) {
        super(i10);
        this.newString = str;
        this.remaining = false;
        this.remainingValue = 0;
    }

    public String getNewString() {
        return this.newString;
    }

    public int getRemainingValue() {
        return this.remainingValue;
    }

    public boolean isRemaining() {
        return this.remaining;
    }

    public DecodedInformation(int i10, String str, int i11) {
        super(i10);
        this.remaining = true;
        this.remainingValue = i11;
        this.newString = str;
    }
}
