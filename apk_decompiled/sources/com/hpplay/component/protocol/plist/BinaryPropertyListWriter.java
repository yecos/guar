package com.hpplay.component.protocol.plist;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: classes2.dex */
public final class BinaryPropertyListWriter {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int VERSION_00 = 0;
    private static final int VERSION_10 = 10;
    private static final int VERSION_15 = 15;
    private static final int VERSION_20 = 20;
    private long count;
    private final Map<NSObject, Integer> idMap;
    private int idSizeInBytes;
    private final OutputStream out;
    private int version;

    public BinaryPropertyListWriter(OutputStream outputStream) {
        this.version = 0;
        this.idMap = new LinkedHashMap();
        this.out = new BufferedOutputStream(outputStream);
    }

    private static int computeIdSizeInBytes(int i10) {
        if (i10 < 256) {
            return 1;
        }
        return i10 < 65536 ? 2 : 4;
    }

    private int computeOffsetSizeInBytes(long j10) {
        if (j10 < 256) {
            return 1;
        }
        if (j10 < 65536) {
            return 2;
        }
        return j10 < IjkMediaMeta.AV_CH_WIDE_RIGHT ? 4 : 8;
    }

    private static int getMinimumRequiredVersion(NSObject nSObject) {
        int i10 = 10;
        int i11 = 0;
        int i12 = nSObject == null ? 10 : 0;
        if (nSObject instanceof NSDictionary) {
            Iterator<NSObject> it = ((NSDictionary) nSObject).getHashMap().values().iterator();
            while (it.hasNext()) {
                int minimumRequiredVersion = getMinimumRequiredVersion(it.next());
                if (minimumRequiredVersion > i12) {
                    i12 = minimumRequiredVersion;
                }
            }
            return i12;
        }
        if (nSObject instanceof NSArray) {
            NSObject[] array = ((NSArray) nSObject).getArray();
            int length = array.length;
            while (i11 < length) {
                int minimumRequiredVersion2 = getMinimumRequiredVersion(array[i11]);
                if (minimumRequiredVersion2 > i12) {
                    i12 = minimumRequiredVersion2;
                }
                i11++;
            }
            return i12;
        }
        if (!(nSObject instanceof NSSet)) {
            return i12;
        }
        NSObject[] allObjects = ((NSSet) nSObject).allObjects();
        int length2 = allObjects.length;
        while (i11 < length2) {
            int minimumRequiredVersion3 = getMinimumRequiredVersion(allObjects[i11]);
            if (minimumRequiredVersion3 > i10) {
                i10 = minimumRequiredVersion3;
            }
            i11++;
        }
        return i10;
    }

    public static void write(File file, NSObject nSObject) {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            write(fileOutputStream, nSObject);
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public static byte[] writeToArray(NSObject nSObject) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        write(byteArrayOutputStream, nSObject);
        return byteArrayOutputStream.toByteArray();
    }

    public void assignID(NSObject nSObject) {
        if (this.idMap.containsKey(nSObject)) {
            return;
        }
        Map<NSObject, Integer> map = this.idMap;
        map.put(nSObject, Integer.valueOf(map.size()));
    }

    public int getID(NSObject nSObject) {
        return this.idMap.get(nSObject).intValue();
    }

    public void writeBytes(long j10, int i10) {
        for (int i11 = i10 - 1; i11 >= 0; i11--) {
            write((int) (j10 >> (i11 * 8)));
        }
    }

    public void writeDouble(double d10) {
        writeLong(Double.doubleToRawLongBits(d10));
    }

    public void writeID(int i10) {
        writeBytes(i10, this.idSizeInBytes);
    }

    public void writeIntHeader(int i10, int i11) {
        if (i11 < 15) {
            write((i10 << 4) + i11);
            return;
        }
        if (i11 < 256) {
            write((i10 << 4) + 15);
            write(16);
            writeBytes(i11, 1);
        } else if (i11 < 65536) {
            write((i10 << 4) + 15);
            write(17);
            writeBytes(i11, 2);
        } else {
            write((i10 << 4) + 15);
            write(18);
            writeBytes(i11, 4);
        }
    }

    public void writeLong(long j10) {
        writeBytes(j10, 8);
    }

    public BinaryPropertyListWriter(OutputStream outputStream, int i10) {
        this.version = 0;
        this.idMap = new LinkedHashMap();
        this.version = i10;
        this.out = new BufferedOutputStream(outputStream);
    }

    public static void write(OutputStream outputStream, NSObject nSObject) {
        int minimumRequiredVersion = getMinimumRequiredVersion(nSObject);
        if (minimumRequiredVersion > 0) {
            throw new IOException("The given property list structure cannot be saved. The required version of the binary format (" + (minimumRequiredVersion != 10 ? minimumRequiredVersion != 15 ? minimumRequiredVersion == 20 ? "v2.0" : "v0.0" : "v1.5" : "v1.0") + ") is not yet supported.");
        }
        new BinaryPropertyListWriter(outputStream, minimumRequiredVersion).write(nSObject);
    }

    public void write(NSObject nSObject) {
        int i10;
        write(new byte[]{98, 112, 108, 105, 115, 116});
        int i11 = this.version;
        if (i11 == 0) {
            write(new byte[]{48, 48});
        } else if (i11 == 10) {
            write(new byte[]{49, 48});
        } else if (i11 == 15) {
            write(new byte[]{49, 53});
        } else if (i11 == 20) {
            write(new byte[]{50, 48});
        }
        nSObject.assignIDs(this);
        this.idSizeInBytes = computeIdSizeInBytes(this.idMap.size());
        int size = this.idMap.size();
        long[] jArr = new long[size];
        Iterator<Map.Entry<NSObject, Integer>> it = this.idMap.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<NSObject, Integer> next = it.next();
            NSObject key = next.getKey();
            jArr[next.getValue().intValue()] = this.count;
            if (key == null) {
                write(0);
            } else {
                key.toBinary(this);
            }
        }
        long j10 = this.count;
        int computeOffsetSizeInBytes = computeOffsetSizeInBytes(j10);
        for (i10 = 0; i10 < size; i10++) {
            writeBytes(jArr[i10], computeOffsetSizeInBytes);
        }
        if (this.version != 15) {
            write(new byte[6]);
            write(computeOffsetSizeInBytes);
            write(this.idSizeInBytes);
            writeLong(this.idMap.size());
            writeLong(this.idMap.get(nSObject).intValue());
            writeLong(j10);
        }
        this.out.flush();
    }

    public void write(int i10) {
        this.out.write(i10);
        this.count++;
    }

    public void write(byte[] bArr) {
        this.out.write(bArr);
        this.count += bArr.length;
    }
}
