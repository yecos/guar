package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes2.dex */
final class State {
    static final State INITIAL_STATE = new State(Token.EMPTY, 0, 0, 0);
    private final int binaryShiftByteCount;
    private final int bitCount;
    private final int mode;
    private final Token token;

    private State(Token token, int i10, int i11, int i12) {
        this.token = token;
        this.mode = i10;
        this.binaryShiftByteCount = i11;
        this.bitCount = i12;
    }

    public State addBinaryShiftChar(int i10) {
        Token token = this.token;
        int i11 = this.mode;
        int i12 = this.bitCount;
        if (i11 == 4 || i11 == 2) {
            int i13 = HighLevelEncoder.LATCH_TABLE[i11][0];
            int i14 = 65535 & i13;
            int i15 = i13 >> 16;
            token = token.add(i14, i15);
            i12 += i15;
            i11 = 0;
        }
        int i16 = this.binaryShiftByteCount;
        State state = new State(token, i11, i16 + 1, i12 + ((i16 == 0 || i16 == 31) ? 18 : i16 == 62 ? 9 : 8));
        return state.binaryShiftByteCount == 2078 ? state.endBinaryShift(i10 + 1) : state;
    }

    public State endBinaryShift(int i10) {
        int i11 = this.binaryShiftByteCount;
        return i11 == 0 ? this : new State(this.token.addBinaryShift(i10 - i11, i11), this.mode, 0, this.bitCount);
    }

    public int getBinaryShiftByteCount() {
        return this.binaryShiftByteCount;
    }

    public int getBitCount() {
        return this.bitCount;
    }

    public int getMode() {
        return this.mode;
    }

    public Token getToken() {
        return this.token;
    }

    public boolean isBetterThanOrEqualTo(State state) {
        int i10;
        int i11 = this.bitCount + (HighLevelEncoder.LATCH_TABLE[this.mode][state.mode] >> 16);
        int i12 = state.binaryShiftByteCount;
        if (i12 > 0 && ((i10 = this.binaryShiftByteCount) == 0 || i10 > i12)) {
            i11 += 10;
        }
        return i11 <= state.bitCount;
    }

    public State latchAndAppend(int i10, int i11) {
        int i12 = this.bitCount;
        Token token = this.token;
        int i13 = this.mode;
        if (i10 != i13) {
            int i14 = HighLevelEncoder.LATCH_TABLE[i13][i10];
            int i15 = 65535 & i14;
            int i16 = i14 >> 16;
            token = token.add(i15, i16);
            i12 += i16;
        }
        int i17 = i10 == 2 ? 4 : 5;
        return new State(token.add(i11, i17), i10, 0, i12 + i17);
    }

    public State shiftAndAppend(int i10, int i11) {
        Token token = this.token;
        int i12 = this.mode;
        int i13 = i12 == 2 ? 4 : 5;
        return new State(token.add(HighLevelEncoder.SHIFT_TABLE[i12][i10], i13).add(i11, 5), this.mode, 0, this.bitCount + i13 + 5);
    }

    public BitArray toBitArray(byte[] bArr) {
        LinkedList linkedList = new LinkedList();
        for (Token token = endBinaryShift(bArr.length).token; token != null; token = token.getPrevious()) {
            linkedList.addFirst(token);
        }
        BitArray bitArray = new BitArray();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ((Token) it.next()).appendTo(bitArray, bArr);
        }
        return bitArray;
    }

    public String toString() {
        return String.format("%s bits=%d bytes=%d", HighLevelEncoder.MODE_NAMES[this.mode], Integer.valueOf(this.bitCount), Integer.valueOf(this.binaryShiftByteCount));
    }
}
