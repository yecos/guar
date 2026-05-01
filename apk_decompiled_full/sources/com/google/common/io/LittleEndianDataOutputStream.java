package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Longs;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FilterOutputStream;
import java.io.OutputStream;

@ElementTypesAreNonnullByDefault
@Beta
@GwtIncompatible
/* loaded from: classes2.dex */
public final class LittleEndianDataOutputStream extends FilterOutputStream implements DataOutput {
    public LittleEndianDataOutputStream(OutputStream outputStream) {
        super(new DataOutputStream((OutputStream) Preconditions.checkNotNull(outputStream)));
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        ((FilterOutputStream) this).out.close();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.DataOutput
    public void write(byte[] bArr, int i10, int i11) {
        ((FilterOutputStream) this).out.write(bArr, i10, i11);
    }

    @Override // java.io.DataOutput
    public void writeBoolean(boolean z10) {
        ((DataOutputStream) ((FilterOutputStream) this).out).writeBoolean(z10);
    }

    @Override // java.io.DataOutput
    public void writeByte(int i10) {
        ((DataOutputStream) ((FilterOutputStream) this).out).writeByte(i10);
    }

    @Override // java.io.DataOutput
    @Deprecated
    public void writeBytes(String str) {
        ((DataOutputStream) ((FilterOutputStream) this).out).writeBytes(str);
    }

    @Override // java.io.DataOutput
    public void writeChar(int i10) {
        writeShort(i10);
    }

    @Override // java.io.DataOutput
    public void writeChars(String str) {
        for (int i10 = 0; i10 < str.length(); i10++) {
            writeChar(str.charAt(i10));
        }
    }

    @Override // java.io.DataOutput
    public void writeDouble(double d10) {
        writeLong(Double.doubleToLongBits(d10));
    }

    @Override // java.io.DataOutput
    public void writeFloat(float f10) {
        writeInt(Float.floatToIntBits(f10));
    }

    @Override // java.io.DataOutput
    public void writeInt(int i10) {
        ((FilterOutputStream) this).out.write(i10 & 255);
        ((FilterOutputStream) this).out.write((i10 >> 8) & 255);
        ((FilterOutputStream) this).out.write((i10 >> 16) & 255);
        ((FilterOutputStream) this).out.write((i10 >> 24) & 255);
    }

    @Override // java.io.DataOutput
    public void writeLong(long j10) {
        byte[] byteArray = Longs.toByteArray(Long.reverseBytes(j10));
        write(byteArray, 0, byteArray.length);
    }

    @Override // java.io.DataOutput
    public void writeShort(int i10) {
        ((FilterOutputStream) this).out.write(i10 & 255);
        ((FilterOutputStream) this).out.write((i10 >> 8) & 255);
    }

    @Override // java.io.DataOutput
    public void writeUTF(String str) {
        ((DataOutputStream) ((FilterOutputStream) this).out).writeUTF(str);
    }
}
