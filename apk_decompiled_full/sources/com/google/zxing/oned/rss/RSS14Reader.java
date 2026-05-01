package com.google.zxing.oned.rss;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.oned.OneDReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class RSS14Reader extends AbstractRSSReader {
    private final List<Pair> possibleLeftPairs = new ArrayList();
    private final List<Pair> possibleRightPairs = new ArrayList();
    private static final int[] OUTSIDE_EVEN_TOTAL_SUBSET = {1, 10, 34, 70, 126};
    private static final int[] INSIDE_ODD_TOTAL_SUBSET = {4, 20, 48, 81};
    private static final int[] OUTSIDE_GSUM = {0, 161, 961, 2015, 2715};
    private static final int[] INSIDE_GSUM = {0, 336, 1036, 1516};
    private static final int[] OUTSIDE_ODD_WIDEST = {8, 6, 4, 3, 1};
    private static final int[] INSIDE_ODD_WIDEST = {2, 4, 6, 8};
    private static final int[][] FINDER_PATTERNS = {new int[]{3, 8, 2, 1}, new int[]{3, 5, 5, 1}, new int[]{3, 3, 7, 1}, new int[]{3, 1, 9, 1}, new int[]{2, 7, 4, 1}, new int[]{2, 5, 6, 1}, new int[]{2, 3, 8, 1}, new int[]{1, 5, 7, 1}, new int[]{1, 3, 9, 1}};

    private static void addOrTally(Collection<Pair> collection, Pair pair) {
        boolean z10;
        if (pair == null) {
            return;
        }
        Iterator<Pair> it = collection.iterator();
        while (true) {
            if (!it.hasNext()) {
                z10 = false;
                break;
            }
            Pair next = it.next();
            if (next.getValue() == pair.getValue()) {
                next.incrementCount();
                z10 = true;
                break;
            }
        }
        if (z10) {
            return;
        }
        collection.add(pair);
    }

    /* JADX WARN: Code restructure failed: missing block: B:69:0x003f, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0025, code lost:
    
        if (r1 < 4) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x003d, code lost:
    
        if (r1 < 4) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0041, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0042, code lost:
    
        r5 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void adjustOddEvenCounts(boolean z10, int i10) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        int sum = MathUtils.sum(getOddCounts());
        int sum2 = MathUtils.sum(getEvenCounts());
        boolean z15 = true;
        if (z10) {
            if (sum > 12) {
                z11 = false;
                z12 = true;
            } else {
                z11 = sum < 4;
                z12 = false;
            }
            if (sum2 <= 12) {
            }
            z13 = false;
            z14 = true;
        } else {
            if (sum > 11) {
                z11 = false;
                z12 = true;
            } else {
                z11 = sum < 5;
                z12 = false;
            }
            if (sum2 <= 10) {
            }
            z13 = false;
            z14 = true;
        }
        int i11 = (sum + sum2) - i10;
        boolean z16 = (sum & 1) == z10;
        boolean z17 = (sum2 & 1) == 1;
        if (i11 == 1) {
            if (z16) {
                if (z17) {
                    throw NotFoundException.getNotFoundInstance();
                }
                z15 = z11;
                z12 = true;
            } else {
                if (!z17) {
                    throw NotFoundException.getNotFoundInstance();
                }
                z15 = z11;
                z14 = true;
            }
        } else if (i11 == -1) {
            if (z16) {
                if (z17) {
                    throw NotFoundException.getNotFoundInstance();
                }
            } else {
                if (!z17) {
                    throw NotFoundException.getNotFoundInstance();
                }
                z15 = z11;
                z13 = true;
            }
        } else {
            if (i11 != 0) {
                throw NotFoundException.getNotFoundInstance();
            }
            if (z16) {
                if (!z17) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (sum >= sum2) {
                    z15 = z11;
                    z13 = true;
                    z12 = true;
                }
                z14 = true;
            } else {
                if (z17) {
                    throw NotFoundException.getNotFoundInstance();
                }
                z15 = z11;
            }
        }
        if (z15) {
            if (z12) {
                throw NotFoundException.getNotFoundInstance();
            }
            AbstractRSSReader.increment(getOddCounts(), getOddRoundingErrors());
        }
        if (z12) {
            AbstractRSSReader.decrement(getOddCounts(), getOddRoundingErrors());
        }
        if (z13) {
            if (z14) {
                throw NotFoundException.getNotFoundInstance();
            }
            AbstractRSSReader.increment(getEvenCounts(), getOddRoundingErrors());
        }
        if (z14) {
            AbstractRSSReader.decrement(getEvenCounts(), getEvenRoundingErrors());
        }
    }

    private static boolean checkChecksum(Pair pair, Pair pair2) {
        int checksumPortion = (pair.getChecksumPortion() + (pair2.getChecksumPortion() * 16)) % 79;
        int value = (pair.getFinderPattern().getValue() * 9) + pair2.getFinderPattern().getValue();
        if (value > 72) {
            value--;
        }
        if (value > 8) {
            value--;
        }
        return checksumPortion == value;
    }

    private static Result constructResult(Pair pair, Pair pair2) {
        String valueOf = String.valueOf((pair.getValue() * 4537077) + pair2.getValue());
        StringBuilder sb = new StringBuilder(14);
        for (int length = 13 - valueOf.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(valueOf);
        int i10 = 0;
        for (int i11 = 0; i11 < 13; i11++) {
            int charAt = sb.charAt(i11) - '0';
            if ((i11 & 1) == 0) {
                charAt *= 3;
            }
            i10 += charAt;
        }
        int i12 = 10 - (i10 % 10);
        if (i12 == 10) {
            i12 = 0;
        }
        sb.append(i12);
        ResultPoint[] resultPoints = pair.getFinderPattern().getResultPoints();
        ResultPoint[] resultPoints2 = pair2.getFinderPattern().getResultPoints();
        return new Result(String.valueOf(sb.toString()), null, new ResultPoint[]{resultPoints[0], resultPoints[1], resultPoints2[0], resultPoints2[1]}, BarcodeFormat.RSS_14);
    }

    private DataCharacter decodeDataCharacter(BitArray bitArray, FinderPattern finderPattern, boolean z10) {
        int[] dataCharacterCounters = getDataCharacterCounters();
        dataCharacterCounters[0] = 0;
        dataCharacterCounters[1] = 0;
        dataCharacterCounters[2] = 0;
        dataCharacterCounters[3] = 0;
        dataCharacterCounters[4] = 0;
        dataCharacterCounters[5] = 0;
        dataCharacterCounters[6] = 0;
        dataCharacterCounters[7] = 0;
        if (z10) {
            OneDReader.recordPatternInReverse(bitArray, finderPattern.getStartEnd()[0], dataCharacterCounters);
        } else {
            OneDReader.recordPattern(bitArray, finderPattern.getStartEnd()[1] + 1, dataCharacterCounters);
            int i10 = 0;
            for (int length = dataCharacterCounters.length - 1; i10 < length; length--) {
                int i11 = dataCharacterCounters[i10];
                dataCharacterCounters[i10] = dataCharacterCounters[length];
                dataCharacterCounters[length] = i11;
                i10++;
            }
        }
        int i12 = z10 ? 16 : 15;
        float sum = MathUtils.sum(dataCharacterCounters) / i12;
        int[] oddCounts = getOddCounts();
        int[] evenCounts = getEvenCounts();
        float[] oddRoundingErrors = getOddRoundingErrors();
        float[] evenRoundingErrors = getEvenRoundingErrors();
        for (int i13 = 0; i13 < dataCharacterCounters.length; i13++) {
            float f10 = dataCharacterCounters[i13] / sum;
            int i14 = (int) (0.5f + f10);
            if (i14 <= 0) {
                i14 = 1;
            } else if (i14 > 8) {
                i14 = 8;
            }
            int i15 = i13 / 2;
            if ((i13 & 1) == 0) {
                oddCounts[i15] = i14;
                oddRoundingErrors[i15] = f10 - i14;
            } else {
                evenCounts[i15] = i14;
                evenRoundingErrors[i15] = f10 - i14;
            }
        }
        adjustOddEvenCounts(z10, i12);
        int i16 = 0;
        int i17 = 0;
        for (int length2 = oddCounts.length - 1; length2 >= 0; length2--) {
            int i18 = oddCounts[length2];
            i16 = (i16 * 9) + i18;
            i17 += i18;
        }
        int i19 = 0;
        int i20 = 0;
        for (int length3 = evenCounts.length - 1; length3 >= 0; length3--) {
            int i21 = evenCounts[length3];
            i19 = (i19 * 9) + i21;
            i20 += i21;
        }
        int i22 = i16 + (i19 * 3);
        if (!z10) {
            if ((i20 & 1) != 0 || i20 > 10 || i20 < 4) {
                throw NotFoundException.getNotFoundInstance();
            }
            int i23 = (10 - i20) / 2;
            int i24 = INSIDE_ODD_WIDEST[i23];
            return new DataCharacter((RSSUtils.getRSSvalue(evenCounts, 9 - i24, false) * INSIDE_ODD_TOTAL_SUBSET[i23]) + RSSUtils.getRSSvalue(oddCounts, i24, true) + INSIDE_GSUM[i23], i22);
        }
        if ((i17 & 1) != 0 || i17 > 12 || i17 < 4) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i25 = (12 - i17) / 2;
        int i26 = OUTSIDE_ODD_WIDEST[i25];
        return new DataCharacter((RSSUtils.getRSSvalue(oddCounts, i26, false) * OUTSIDE_EVEN_TOTAL_SUBSET[i25]) + RSSUtils.getRSSvalue(evenCounts, 9 - i26, true) + OUTSIDE_GSUM[i25], i22);
    }

    private Pair decodePair(BitArray bitArray, boolean z10, int i10, Map<DecodeHintType, ?> map) {
        try {
            FinderPattern parseFoundFinderPattern = parseFoundFinderPattern(bitArray, i10, z10, findFinderPattern(bitArray, 0, z10));
            ResultPointCallback resultPointCallback = map == null ? null : (ResultPointCallback) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
            if (resultPointCallback != null) {
                float f10 = (r2[0] + r2[1]) / 2.0f;
                if (z10) {
                    f10 = (bitArray.getSize() - 1) - f10;
                }
                resultPointCallback.foundPossibleResultPoint(new ResultPoint(f10, i10));
            }
            DataCharacter decodeDataCharacter = decodeDataCharacter(bitArray, parseFoundFinderPattern, true);
            DataCharacter decodeDataCharacter2 = decodeDataCharacter(bitArray, parseFoundFinderPattern, false);
            return new Pair((decodeDataCharacter.getValue() * 1597) + decodeDataCharacter2.getValue(), decodeDataCharacter.getChecksumPortion() + (decodeDataCharacter2.getChecksumPortion() * 4), parseFoundFinderPattern);
        } catch (NotFoundException unused) {
            return null;
        }
    }

    private int[] findFinderPattern(BitArray bitArray, int i10, boolean z10) {
        int[] decodeFinderCounters = getDecodeFinderCounters();
        decodeFinderCounters[0] = 0;
        decodeFinderCounters[1] = 0;
        decodeFinderCounters[2] = 0;
        decodeFinderCounters[3] = 0;
        int size = bitArray.getSize();
        boolean z11 = false;
        while (i10 < size) {
            z11 = !bitArray.get(i10);
            if (z10 == z11) {
                break;
            }
            i10++;
        }
        int i11 = i10;
        int i12 = 0;
        while (i10 < size) {
            if (bitArray.get(i10) ^ z11) {
                decodeFinderCounters[i12] = decodeFinderCounters[i12] + 1;
            } else {
                if (i12 != 3) {
                    i12++;
                } else {
                    if (AbstractRSSReader.isFinderPattern(decodeFinderCounters)) {
                        return new int[]{i11, i10};
                    }
                    i11 += decodeFinderCounters[0] + decodeFinderCounters[1];
                    decodeFinderCounters[0] = decodeFinderCounters[2];
                    decodeFinderCounters[1] = decodeFinderCounters[3];
                    decodeFinderCounters[2] = 0;
                    decodeFinderCounters[3] = 0;
                    i12--;
                }
                decodeFinderCounters[i12] = 1;
                z11 = !z11;
            }
            i10++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private FinderPattern parseFoundFinderPattern(BitArray bitArray, int i10, boolean z10, int[] iArr) {
        int i11;
        int i12;
        boolean z11 = bitArray.get(iArr[0]);
        int i13 = iArr[0] - 1;
        while (i13 >= 0 && (bitArray.get(i13) ^ z11)) {
            i13--;
        }
        int i14 = i13 + 1;
        int i15 = iArr[0] - i14;
        int[] decodeFinderCounters = getDecodeFinderCounters();
        System.arraycopy(decodeFinderCounters, 0, decodeFinderCounters, 1, decodeFinderCounters.length - 1);
        decodeFinderCounters[0] = i15;
        int parseFinderValue = AbstractRSSReader.parseFinderValue(decodeFinderCounters, FINDER_PATTERNS);
        int i16 = iArr[1];
        if (z10) {
            int size = (bitArray.getSize() - 1) - i14;
            i11 = (bitArray.getSize() - 1) - i16;
            i12 = size;
        } else {
            i11 = i16;
            i12 = i14;
        }
        return new FinderPattern(parseFinderValue, new int[]{i14, iArr[1]}, i12, i11, i10);
    }

    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int i10, BitArray bitArray, Map<DecodeHintType, ?> map) {
        addOrTally(this.possibleLeftPairs, decodePair(bitArray, false, i10, map));
        bitArray.reverse();
        addOrTally(this.possibleRightPairs, decodePair(bitArray, true, i10, map));
        bitArray.reverse();
        for (Pair pair : this.possibleLeftPairs) {
            if (pair.getCount() > 1) {
                for (Pair pair2 : this.possibleRightPairs) {
                    if (pair2.getCount() > 1 && checkChecksum(pair, pair2)) {
                        return constructResult(pair, pair2);
                    }
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // com.google.zxing.oned.OneDReader, com.google.zxing.Reader
    public void reset() {
        this.possibleLeftPairs.clear();
        this.possibleRightPairs.clear();
    }
}
