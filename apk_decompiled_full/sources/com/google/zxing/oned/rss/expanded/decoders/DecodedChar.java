package com.google.zxing.oned.rss.expanded.decoders;

/* loaded from: classes2.dex */
final class DecodedChar extends DecodedObject {
    static final char FNC1 = '$';
    private final char value;

    public DecodedChar(int i10, char c10) {
        super(i10);
        this.value = c10;
    }

    public char getValue() {
        return this.value;
    }

    public boolean isFNC1() {
        return this.value == '$';
    }
}
