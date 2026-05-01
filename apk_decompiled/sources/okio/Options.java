package okio;

import com.google.common.primitives.UnsignedBytes;
import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public final class Options extends AbstractList<ByteString> implements RandomAccess {
    final ByteString[] byteStrings;
    final int[] trie;

    private Options(ByteString[] byteStringArr, int[] iArr) {
        this.byteStrings = byteStringArr;
        this.trie = iArr;
    }

    private static void buildTrieRecursive(long j10, Buffer buffer, int i10, List<ByteString> list, int i11, int i12, List<Integer> list2) {
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        Buffer buffer2;
        if (i11 >= i12) {
            throw new AssertionError();
        }
        for (int i18 = i11; i18 < i12; i18++) {
            if (list.get(i18).size() < i10) {
                throw new AssertionError();
            }
        }
        ByteString byteString = list.get(i11);
        ByteString byteString2 = list.get(i12 - 1);
        if (i10 == byteString.size()) {
            int i19 = i11 + 1;
            i14 = i19;
            i13 = list2.get(i11).intValue();
            byteString = list.get(i19);
        } else {
            i13 = -1;
            i14 = i11;
        }
        if (byteString.getByte(i10) == byteString2.getByte(i10)) {
            int min = Math.min(byteString.size(), byteString2.size());
            int i20 = 0;
            for (int i21 = i10; i21 < min && byteString.getByte(i21) == byteString2.getByte(i21); i21++) {
                i20++;
            }
            long intCount = 1 + j10 + intCount(buffer) + 2 + i20;
            buffer.writeInt(-i20);
            buffer.writeInt(i13);
            int i22 = i10;
            while (true) {
                i15 = i10 + i20;
                if (i22 >= i15) {
                    break;
                }
                buffer.writeInt(byteString.getByte(i22) & UnsignedBytes.MAX_VALUE);
                i22++;
            }
            if (i14 + 1 == i12) {
                if (i15 != list.get(i14).size()) {
                    throw new AssertionError();
                }
                buffer.writeInt(list2.get(i14).intValue());
                return;
            } else {
                Buffer buffer3 = new Buffer();
                buffer.writeInt((int) ((intCount(buffer3) + intCount) * (-1)));
                buildTrieRecursive(intCount, buffer3, i15, list, i14, i12, list2);
                buffer.write(buffer3, buffer3.size());
                return;
            }
        }
        int i23 = 1;
        for (int i24 = i14 + 1; i24 < i12; i24++) {
            if (list.get(i24 - 1).getByte(i10) != list.get(i24).getByte(i10)) {
                i23++;
            }
        }
        long intCount2 = j10 + intCount(buffer) + 2 + (i23 * 2);
        buffer.writeInt(i23);
        buffer.writeInt(i13);
        for (int i25 = i14; i25 < i12; i25++) {
            byte b10 = list.get(i25).getByte(i10);
            if (i25 == i14 || b10 != list.get(i25 - 1).getByte(i10)) {
                buffer.writeInt(b10 & UnsignedBytes.MAX_VALUE);
            }
        }
        Buffer buffer4 = new Buffer();
        int i26 = i14;
        while (i26 < i12) {
            byte b11 = list.get(i26).getByte(i10);
            int i27 = i26 + 1;
            int i28 = i27;
            while (true) {
                if (i28 >= i12) {
                    i16 = i12;
                    break;
                } else {
                    if (b11 != list.get(i28).getByte(i10)) {
                        i16 = i28;
                        break;
                    }
                    i28++;
                }
            }
            if (i27 == i16 && i10 + 1 == list.get(i26).size()) {
                buffer.writeInt(list2.get(i26).intValue());
                i17 = i16;
                buffer2 = buffer4;
            } else {
                buffer.writeInt((int) ((intCount(buffer4) + intCount2) * (-1)));
                i17 = i16;
                buffer2 = buffer4;
                buildTrieRecursive(intCount2, buffer4, i10 + 1, list, i26, i16, list2);
            }
            buffer4 = buffer2;
            i26 = i17;
        }
        Buffer buffer5 = buffer4;
        buffer.write(buffer5, buffer5.size());
    }

    private static int intCount(Buffer buffer) {
        return (int) (buffer.size() / 4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00ba, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static okio.Options of(okio.ByteString... r11) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Options.of(okio.ByteString[]):okio.Options");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.byteStrings.length;
    }

    @Override // java.util.AbstractList, java.util.List
    public ByteString get(int i10) {
        return this.byteStrings[i10];
    }
}
