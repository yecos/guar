package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;
import com.hpplay.component.protocol.plist.ASCIIPropertyListParser;

/* loaded from: classes2.dex */
final class AI013x0x1xDecoder extends AI01weightDecoder {
    private static final int DATE_SIZE = 16;
    private static final int HEADER_SIZE = 8;
    private static final int WEIGHT_SIZE = 20;
    private final String dateCode;
    private final String firstAIdigits;

    public AI013x0x1xDecoder(BitArray bitArray, String str, String str2) {
        super(bitArray);
        this.dateCode = str2;
        this.firstAIdigits = str;
    }

    private void encodeCompressedDate(StringBuilder sb, int i10) {
        int extractNumericValueFromBitArray = getGeneralDecoder().extractNumericValueFromBitArray(i10, 16);
        if (extractNumericValueFromBitArray == 38400) {
            return;
        }
        sb.append(ASCIIPropertyListParser.ARRAY_BEGIN_TOKEN);
        sb.append(this.dateCode);
        sb.append(ASCIIPropertyListParser.ARRAY_END_TOKEN);
        int i11 = extractNumericValueFromBitArray % 32;
        int i12 = extractNumericValueFromBitArray / 32;
        int i13 = (i12 % 12) + 1;
        int i14 = i12 / 12;
        if (i14 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i14);
        if (i13 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i13);
        if (i11 / 10 == 0) {
            sb.append('0');
        }
        sb.append(i11);
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.AI01weightDecoder
    public void addWeightCode(StringBuilder sb, int i10) {
        sb.append(ASCIIPropertyListParser.ARRAY_BEGIN_TOKEN);
        sb.append(this.firstAIdigits);
        sb.append(i10 / 100000);
        sb.append(ASCIIPropertyListParser.ARRAY_END_TOKEN);
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.AI01weightDecoder
    public int checkWeight(int i10) {
        return i10 % 100000;
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.AbstractExpandedDecoder
    public String parseInformation() {
        if (getInformation().getSize() != 84) {
            throw NotFoundException.getNotFoundInstance();
        }
        StringBuilder sb = new StringBuilder();
        encodeCompressedGtin(sb, 8);
        encodeCompressedWeight(sb, 48, 20);
        encodeCompressedDate(sb, 68);
        return sb.toString();
    }
}
