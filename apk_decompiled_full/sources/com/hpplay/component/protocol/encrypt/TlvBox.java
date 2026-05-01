package com.hpplay.component.protocol.encrypt;

import com.hpplay.component.common.utils.CLog;
import com.hpplay.component.protocol.mirror.AutoStrategy;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class TlvBox {
    private static final ByteOrder DEFAULT_BYTE_ORDER = ByteOrder.LITTLE_ENDIAN;
    private static int MAX_SIZE = AutoStrategy.BITRATE_LOW4;
    private int mTotalBytes = 0;
    private HashMap<Integer, byte[]> mObjects = new HashMap<>();

    public static TlvBox parse(byte[] bArr, int i10, int i11, int i12) {
        TlvBox tlvBox = new TlvBox();
        int i13 = 0;
        while (i13 < i11) {
            CLog.d("tlvp", "src  len --> " + i11 + "  parsed : " + i13 + "  tag " + i12);
            ByteBuffer wrap = ByteBuffer.wrap(bArr, i10 + i13, 4);
            ByteOrder byteOrder = DEFAULT_BYTE_ORDER;
            int i14 = wrap.order(byteOrder).getInt();
            int i15 = i13 + 4;
            int i16 = ByteBuffer.wrap(bArr, i10 + i15, 4).order(byteOrder).getInt();
            int i17 = i15 + 4;
            if (i16 > MAX_SIZE) {
                CLog.d("tlvp", "dst size  --> " + i16 + "  parsed : " + i17 + " type  : " + i14 + "  tag " + i12);
                return tlvBox;
            }
            byte[] bArr2 = new byte[i16];
            System.arraycopy(bArr, i10 + i17, bArr2, 0, i16);
            tlvBox.putBytesValue(i14, bArr2);
            i13 = i17 + i16;
        }
        return tlvBox;
    }

    public Byte getByteValue(int i10) {
        byte[] bArr = this.mObjects.get(Integer.valueOf(i10));
        if (bArr == null) {
            return null;
        }
        return Byte.valueOf(bArr[0]);
    }

    public byte[] getBytesValue(int i10) {
        return this.mObjects.get(Integer.valueOf(i10));
    }

    public Double getDoubleValue(int i10) {
        byte[] bArr = this.mObjects.get(Integer.valueOf(i10));
        if (bArr == null) {
            return null;
        }
        return Double.valueOf(ByteBuffer.wrap(bArr).order(DEFAULT_BYTE_ORDER).getDouble());
    }

    public Float getFloatValue(int i10) {
        byte[] bArr = this.mObjects.get(Integer.valueOf(i10));
        if (bArr == null) {
            return null;
        }
        return Float.valueOf(ByteBuffer.wrap(bArr).order(DEFAULT_BYTE_ORDER).getFloat());
    }

    public Integer getIntValue(int i10) {
        byte[] bArr = this.mObjects.get(Integer.valueOf(i10));
        if (bArr == null) {
            return null;
        }
        return Integer.valueOf(ByteBuffer.wrap(bArr).order(DEFAULT_BYTE_ORDER).getInt());
    }

    public Long getLongValue(int i10) {
        byte[] bArr = this.mObjects.get(Integer.valueOf(i10));
        if (bArr == null) {
            return null;
        }
        return Long.valueOf(ByteBuffer.wrap(bArr).order(DEFAULT_BYTE_ORDER).getLong());
    }

    public TlvBox getObjectValue(int i10) {
        byte[] bArr = this.mObjects.get(Integer.valueOf(i10));
        if (bArr == null) {
            return null;
        }
        return parse(bArr, 0, bArr.length, 1);
    }

    public Short getShortValue(int i10) {
        byte[] bArr = this.mObjects.get(Integer.valueOf(i10));
        if (bArr == null) {
            return null;
        }
        return Short.valueOf(ByteBuffer.wrap(bArr).order(DEFAULT_BYTE_ORDER).getShort());
    }

    public String getStringValue(int i10) {
        byte[] bArr = this.mObjects.get(Integer.valueOf(i10));
        if (bArr == null) {
            return null;
        }
        return new String(bArr).trim();
    }

    public void putByteValue(int i10, byte b10) {
        putBytesValue(i10, new byte[]{b10});
    }

    public void putBytesValue(int i10, byte[] bArr) {
        this.mObjects.put(Integer.valueOf(i10), bArr);
        this.mTotalBytes += bArr.length + 8;
    }

    public void putDoubleValue(int i10, double d10) {
        putBytesValue(i10, ByteBuffer.allocate(8).order(DEFAULT_BYTE_ORDER).putDouble(d10).array());
    }

    public void putFloatValue(int i10, float f10) {
        putBytesValue(i10, ByteBuffer.allocate(4).order(DEFAULT_BYTE_ORDER).putFloat(f10).array());
    }

    public void putIntValue(int i10, int i11) {
        putBytesValue(i10, ByteBuffer.allocate(4).order(DEFAULT_BYTE_ORDER).putInt(i11).array());
    }

    public void putLongValue(int i10, long j10) {
        putBytesValue(i10, ByteBuffer.allocate(8).order(DEFAULT_BYTE_ORDER).putLong(j10).array());
    }

    public void putObjectValue(int i10, TlvBox tlvBox) {
        putBytesValue(i10, tlvBox.serialize());
    }

    public void putShortValue(int i10, short s10) {
        putBytesValue(i10, ByteBuffer.allocate(2).order(DEFAULT_BYTE_ORDER).putShort(s10).array());
    }

    public void putStringValue(int i10, String str) {
        putBytesValue(i10, str.getBytes());
    }

    public byte[] serialize() {
        byte[] bArr = new byte[this.mTotalBytes];
        ArrayList<Integer> arrayList = new ArrayList(this.mObjects.keySet());
        Collections.reverse(arrayList);
        int i10 = 0;
        for (Integer num : arrayList) {
            byte[] bArr2 = this.mObjects.get(num);
            ByteBuffer allocate = ByteBuffer.allocate(4);
            ByteOrder byteOrder = DEFAULT_BYTE_ORDER;
            byte[] array = allocate.order(byteOrder).putInt(num.intValue()).array();
            byte[] array2 = ByteBuffer.allocate(4).order(byteOrder).putInt(bArr2.length).array();
            System.arraycopy(array, 0, bArr, i10, array.length);
            int i11 = i10 + 4;
            System.arraycopy(array2, 0, bArr, i11, array2.length);
            int i12 = i11 + 4;
            System.arraycopy(bArr2, 0, bArr, i12, bArr2.length);
            i10 = i12 + bArr2.length;
        }
        return bArr;
    }
}
