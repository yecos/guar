package com.google.zxing.oned.rss.expanded.decoders;

/* loaded from: classes2.dex */
final class BlockParsedResult {
    private final DecodedInformation decodedInformation;
    private final boolean finished;

    public BlockParsedResult(boolean z10) {
        this(null, z10);
    }

    public DecodedInformation getDecodedInformation() {
        return this.decodedInformation;
    }

    public boolean isFinished() {
        return this.finished;
    }

    public BlockParsedResult(DecodedInformation decodedInformation, boolean z10) {
        this.finished = z10;
        this.decodedInformation = decodedInformation;
    }
}
