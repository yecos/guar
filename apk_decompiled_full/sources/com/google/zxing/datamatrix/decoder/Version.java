package com.google.zxing.datamatrix.decoder;

import com.google.zxing.FormatException;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: classes2.dex */
public final class Version {
    private static final Version[] VERSIONS = buildVersions();
    private final int dataRegionSizeColumns;
    private final int dataRegionSizeRows;
    private final ECBlocks ecBlocks;
    private final int symbolSizeColumns;
    private final int symbolSizeRows;
    private final int totalCodewords;
    private final int versionNumber;

    public static final class ECB {
        private final int count;
        private final int dataCodewords;

        public int getCount() {
            return this.count;
        }

        public int getDataCodewords() {
            return this.dataCodewords;
        }

        private ECB(int i10, int i11) {
            this.count = i10;
            this.dataCodewords = i11;
        }
    }

    private Version(int i10, int i11, int i12, int i13, int i14, ECBlocks eCBlocks) {
        this.versionNumber = i10;
        this.symbolSizeRows = i11;
        this.symbolSizeColumns = i12;
        this.dataRegionSizeRows = i13;
        this.dataRegionSizeColumns = i14;
        this.ecBlocks = eCBlocks;
        int eCCodewords = eCBlocks.getECCodewords();
        int i15 = 0;
        for (ECB ecb : eCBlocks.getECBlocks()) {
            i15 += ecb.getCount() * (ecb.getDataCodewords() + eCCodewords);
        }
        this.totalCodewords = i15;
    }

    private static Version[] buildVersions() {
        int i10 = 8;
        int i11 = 1;
        int i12 = 5;
        Version version = new Version(3, 14, 14, 12, 12, new ECBlocks(10, new ECB(i11, i10)));
        int i13 = 2;
        int i14 = 12;
        int i15 = 18;
        Version version2 = new Version(7, 22, 22, 20, 20, new ECBlocks(20, new ECB(i11, 30)));
        int i16 = 6;
        int i17 = 36;
        int i18 = 62;
        int i19 = 56;
        int i20 = 68;
        ECB ecb = new ECB(i11, 5);
        ECB ecb2 = new ECB(i11, 10);
        ECB ecb3 = new ECB(i11, 16);
        return new Version[]{new Version(1, 10, 10, 8, 8, new ECBlocks(i12, new ECB(i11, 3))), new Version(2, 12, 12, 10, 10, new ECBlocks(7, new ECB(i11, i12))), version, new Version(4, 16, 16, 14, 14, new ECBlocks(i14, new ECB(i11, i14))), new Version(5, 18, 18, 16, 16, new ECBlocks(14, new ECB(i11, i15))), new Version(6, 20, 20, 18, 18, new ECBlocks(i15, new ECB(i11, 22))), version2, new Version(8, 24, 24, 22, 22, new ECBlocks(24, new ECB(i11, i17))), new Version(9, 26, 26, 24, 24, new ECBlocks(28, new ECB(i11, 44))), new Version(10, 32, 32, 14, 14, new ECBlocks(i17, new ECB(i11, i18))), new Version(11, 36, 36, 16, 16, new ECBlocks(42, new ECB(i11, 86))), new Version(12, 40, 40, 18, 18, new ECBlocks(48, new ECB(i11, 114))), new Version(13, 44, 44, 20, 20, new ECBlocks(i19, new ECB(i11, IjkMediaMeta.FF_PROFILE_H264_HIGH_444))), new Version(14, 48, 48, 22, 22, new ECBlocks(i20, new ECB(i11, 174))), new Version(15, 52, 52, 24, 24, new ECBlocks(42, new ECB(i13, 102))), new Version(16, 64, 64, 14, 14, new ECBlocks(i19, new ECB(i13, 140))), new Version(17, 72, 72, 16, 16, new ECBlocks(i17, new ECB(4, 92))), new Version(18, 80, 80, 18, 18, new ECBlocks(48, new ECB(4, 114))), new Version(19, 88, 88, 20, 20, new ECBlocks(i19, new ECB(4, IjkMediaMeta.FF_PROFILE_H264_HIGH_444))), new Version(20, 96, 96, 22, 22, new ECBlocks(i20, new ECB(4, 174))), new Version(21, 104, 104, 24, 24, new ECBlocks(i19, new ECB(i16, 136))), new Version(22, 120, 120, 18, 18, new ECBlocks(i20, new ECB(i16, 175))), new Version(23, 132, 132, 20, 20, new ECBlocks(i18, new ECB(i10, 163))), new Version(24, IjkMediaMeta.FF_PROFILE_H264_HIGH_444, IjkMediaMeta.FF_PROFILE_H264_HIGH_444, 22, 22, new ECBlocks(i18, new ECB(i10, 156), new ECB(i13, 155))), new Version(25, 8, 18, 6, 16, new ECBlocks(7, ecb)), new Version(26, 8, 32, 6, 14, new ECBlocks(11, ecb2)), new Version(27, 12, 26, 10, 24, new ECBlocks(14, ecb3)), new Version(28, 12, 36, 10, 16, new ECBlocks(i15, new ECB(i11, 22))), new Version(29, 16, 36, 14, 16, new ECBlocks(24, new ECB(i11, 32))), new Version(30, 16, 48, 14, 22, new ECBlocks(28, new ECB(i11, 49)))};
    }

    public static Version getVersionForDimensions(int i10, int i11) {
        if ((i10 & 1) != 0 || (i11 & 1) != 0) {
            throw FormatException.getFormatInstance();
        }
        for (Version version : VERSIONS) {
            if (version.symbolSizeRows == i10 && version.symbolSizeColumns == i11) {
                return version;
            }
        }
        throw FormatException.getFormatInstance();
    }

    public int getDataRegionSizeColumns() {
        return this.dataRegionSizeColumns;
    }

    public int getDataRegionSizeRows() {
        return this.dataRegionSizeRows;
    }

    public ECBlocks getECBlocks() {
        return this.ecBlocks;
    }

    public int getSymbolSizeColumns() {
        return this.symbolSizeColumns;
    }

    public int getSymbolSizeRows() {
        return this.symbolSizeRows;
    }

    public int getTotalCodewords() {
        return this.totalCodewords;
    }

    public int getVersionNumber() {
        return this.versionNumber;
    }

    public String toString() {
        return String.valueOf(this.versionNumber);
    }

    public static final class ECBlocks {
        private final ECB[] ecBlocks;
        private final int ecCodewords;

        public ECB[] getECBlocks() {
            return this.ecBlocks;
        }

        public int getECCodewords() {
            return this.ecCodewords;
        }

        private ECBlocks(int i10, ECB ecb) {
            this.ecCodewords = i10;
            this.ecBlocks = new ECB[]{ecb};
        }

        private ECBlocks(int i10, ECB ecb, ECB ecb2) {
            this.ecCodewords = i10;
            this.ecBlocks = new ECB[]{ecb, ecb2};
        }
    }
}
