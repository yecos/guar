package com.google.zxing.aztec.encoder;

import com.google.common.primitives.UnsignedBytes;
import com.google.zxing.common.BitArray;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes2.dex */
public final class HighLevelEncoder {
    private static final int[][] CHAR_MAP;
    static final int MODE_DIGIT = 2;
    static final int MODE_LOWER = 1;
    static final int MODE_MIXED = 3;
    static final int MODE_PUNCT = 4;
    static final int MODE_UPPER = 0;
    static final int[][] SHIFT_TABLE;
    private final byte[] text;
    static final String[] MODE_NAMES = {"UPPER", "LOWER", "DIGIT", "MIXED", "PUNCT"};
    static final int[][] LATCH_TABLE = {new int[]{0, 327708, 327710, 327709, 656318}, new int[]{590318, 0, 327710, 327709, 656318}, new int[]{262158, 590300, 0, 590301, 932798}, new int[]{327709, 327708, 656318, 0, 327710}, new int[]{327711, 656380, 656382, 656381, 0}};

    static {
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 5, 256);
        CHAR_MAP = iArr;
        iArr[0][32] = 1;
        for (int i10 = 65; i10 <= 90; i10++) {
            CHAR_MAP[0][i10] = (i10 - 65) + 2;
        }
        CHAR_MAP[1][32] = 1;
        for (int i11 = 97; i11 <= 122; i11++) {
            CHAR_MAP[1][i11] = (i11 - 97) + 2;
        }
        CHAR_MAP[2][32] = 1;
        for (int i12 = 48; i12 <= 57; i12++) {
            CHAR_MAP[2][i12] = (i12 - 48) + 2;
        }
        int[] iArr2 = CHAR_MAP[2];
        iArr2[44] = 12;
        iArr2[46] = 13;
        int[] iArr3 = {0, 32, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 27, 28, 29, 30, 31, 64, 92, 94, 95, 96, 124, 126, 127};
        for (int i13 = 0; i13 < 28; i13++) {
            CHAR_MAP[3][iArr3[i13]] = i13;
        }
        int[] iArr4 = {0, 13, 0, 0, 0, 0, 33, 39, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 58, 59, 60, 61, 62, 63, 91, 93, 123, 125};
        for (int i14 = 0; i14 < 31; i14++) {
            int i15 = iArr4[i14];
            if (i15 > 0) {
                CHAR_MAP[4][i15] = i14;
            }
        }
        int[][] iArr5 = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 6, 6);
        SHIFT_TABLE = iArr5;
        for (int[] iArr6 : iArr5) {
            Arrays.fill(iArr6, -1);
        }
        int[][] iArr7 = SHIFT_TABLE;
        iArr7[0][4] = 0;
        int[] iArr8 = iArr7[1];
        iArr8[4] = 0;
        iArr8[0] = 28;
        iArr7[3][4] = 0;
        int[] iArr9 = iArr7[2];
        iArr9[4] = 0;
        iArr9[0] = 15;
    }

    public HighLevelEncoder(byte[] bArr) {
        this.text = bArr;
    }

    private static Collection<State> simplifyStates(Iterable<State> iterable) {
        boolean z10;
        LinkedList linkedList = new LinkedList();
        for (State state : iterable) {
            Iterator it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z10 = true;
                    break;
                }
                State state2 = (State) it.next();
                if (state2.isBetterThanOrEqualTo(state)) {
                    z10 = false;
                    break;
                }
                if (state.isBetterThanOrEqualTo(state2)) {
                    it.remove();
                }
            }
            if (z10) {
                linkedList.add(state);
            }
        }
        return linkedList;
    }

    private void updateStateForChar(State state, int i10, Collection<State> collection) {
        char c10 = (char) (this.text[i10] & UnsignedBytes.MAX_VALUE);
        boolean z10 = CHAR_MAP[state.getMode()][c10] > 0;
        State state2 = null;
        for (int i11 = 0; i11 <= 4; i11++) {
            int i12 = CHAR_MAP[i11][c10];
            if (i12 > 0) {
                if (state2 == null) {
                    state2 = state.endBinaryShift(i10);
                }
                if (!z10 || i11 == state.getMode() || i11 == 2) {
                    collection.add(state2.latchAndAppend(i11, i12));
                }
                if (!z10 && SHIFT_TABLE[state.getMode()][i11] >= 0) {
                    collection.add(state2.shiftAndAppend(i11, i12));
                }
            }
        }
        if (state.getBinaryShiftByteCount() > 0 || CHAR_MAP[state.getMode()][c10] == 0) {
            collection.add(state.addBinaryShiftChar(i10));
        }
    }

    private static void updateStateForPair(State state, int i10, int i11, Collection<State> collection) {
        State endBinaryShift = state.endBinaryShift(i10);
        collection.add(endBinaryShift.latchAndAppend(4, i11));
        if (state.getMode() != 4) {
            collection.add(endBinaryShift.shiftAndAppend(4, i11));
        }
        if (i11 == 3 || i11 == 4) {
            collection.add(endBinaryShift.latchAndAppend(2, 16 - i11).latchAndAppend(2, 1));
        }
        if (state.getBinaryShiftByteCount() > 0) {
            collection.add(state.addBinaryShiftChar(i10).addBinaryShiftChar(i10 + 1));
        }
    }

    private Collection<State> updateStateListForChar(Iterable<State> iterable, int i10) {
        LinkedList linkedList = new LinkedList();
        Iterator<State> it = iterable.iterator();
        while (it.hasNext()) {
            updateStateForChar(it.next(), i10, linkedList);
        }
        return simplifyStates(linkedList);
    }

    private static Collection<State> updateStateListForPair(Iterable<State> iterable, int i10, int i11) {
        LinkedList linkedList = new LinkedList();
        Iterator<State> it = iterable.iterator();
        while (it.hasNext()) {
            updateStateForPair(it.next(), i10, i11, linkedList);
        }
        return simplifyStates(linkedList);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BitArray encode() {
        int i10;
        Collection<State> singletonList = Collections.singletonList(State.INITIAL_STATE);
        int i11 = 0;
        while (true) {
            byte[] bArr = this.text;
            if (i11 >= bArr.length) {
                return ((State) Collections.min(singletonList, new Comparator<State>() { // from class: com.google.zxing.aztec.encoder.HighLevelEncoder.1
                    @Override // java.util.Comparator
                    public int compare(State state, State state2) {
                        return state.getBitCount() - state2.getBitCount();
                    }
                })).toBitArray(this.text);
            }
            int i12 = i11 + 1;
            byte b10 = i12 < bArr.length ? bArr[i12] : (byte) 0;
            byte b11 = bArr[i11];
            if (b11 == 13) {
                if (b10 == 10) {
                    i10 = 2;
                    if (i10 <= 0) {
                    }
                    i11++;
                }
                i10 = 0;
                if (i10 <= 0) {
                }
                i11++;
            } else if (b11 == 44) {
                if (b10 == 32) {
                    i10 = 4;
                    if (i10 <= 0) {
                    }
                    i11++;
                }
                i10 = 0;
                if (i10 <= 0) {
                }
                i11++;
            } else if (b11 != 46) {
                if (b11 == 58 && b10 == 32) {
                    i10 = 5;
                    if (i10 <= 0) {
                        singletonList = updateStateListForPair(singletonList, i11, i10);
                        i11 = i12;
                    } else {
                        singletonList = updateStateListForChar(singletonList, i11);
                    }
                    i11++;
                }
                i10 = 0;
                if (i10 <= 0) {
                }
                i11++;
            } else {
                if (b10 == 32) {
                    i10 = 3;
                    if (i10 <= 0) {
                    }
                    i11++;
                }
                i10 = 0;
                if (i10 <= 0) {
                }
                i11++;
            }
        }
    }
}
