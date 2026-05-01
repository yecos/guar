package com.hpplay.component.protocol.mirror;

import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.common.utils.CLog;
import com.hpplay.component.protocol.ProtocolBuilder;
import com.hpplay.component.protocol.encrypt.MirrorFrameEcrypto;
import com.hpplay.component.protocol.plist.BinaryPropertyListWriter;
import com.hpplay.component.protocol.plist.NSArray;
import com.hpplay.component.protocol.plist.NSDictionary;
import com.hpplay.component.protocol.plist.NSObject;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes2.dex */
public class LelinkRtpPacker {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int FRAME_TYPE_INDEX = 127;
    private static final int KEY_H265_I_FRAME = 19;
    private static final int KEY_I_FRAME = 5;
    private static final int KEY_SPS = 32;
    private static final int KEY_SPS_PPS = 7;
    private static final String TAG = "LelinkRtpPacker";
    private String mEncodeType;
    public byte[] mEncyptData;
    private int mWidth = 1920;
    private int mHeight = 1080;
    private boolean isEncrypt = true;
    private byte[] byteBuffer = new byte[AutoStrategy.BITRATE_LOW4];
    private boolean isAdjust = true;

    private NSDictionary createDictEntry(String str) {
        NSDictionary nSDictionary = new NSDictionary();
        nSDictionary.put("name", (Object) str);
        return nSDictionary;
    }

    private NSDictionary createStreamPlist(String str) {
        NSDictionary nSDictionary = new NSDictionary();
        nSDictionary.put("deviceId", (Object) str);
        nSDictionary.put("latencyMs", (Object) 90L);
        nSDictionary.put("sessionID", (Object) 12345678L);
        nSDictionary.put("version", (Object) "150.33");
        nSDictionary.put("fpsInfo", (NSObject) new NSArray(createDictEntry("SubS"), createDictEntry("B4En"), createDictEntry("EnDp"), createDictEntry("IdEn"), createDictEntry("IdDp"), createDictEntry("EQDp"), createDictEntry("QueF"), createDictEntry("Sent")));
        nSDictionary.put("timestampInfo", (NSObject) new NSArray(createDictEntry("SubSu"), createDictEntry("BePxT"), createDictEntry("AfPxT"), createDictEntry("BefEn"), createDictEntry("EmEnc"), createDictEntry("QueFr"), createDictEntry("SndFr")));
        return nSDictionary;
    }

    private ByteBuffer packSpsPpsData(ByteBuffer byteBuffer) {
        byte[] bArr;
        ByteBuffer order = ByteBuffer.allocateDirect(128).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.position(0);
        int remaining = byteBuffer.remaining();
        byteBuffer.get(this.byteBuffer, 0, remaining);
        byte[] bArr2 = new byte[4];
        if (this.mEncodeType.equals(ParamsMap.MirrorParams.ENCODE_TYPE_H264)) {
            int i10 = 0;
            while (true) {
                if (i10 >= remaining) {
                    i10 = 0;
                    break;
                }
                if (i10 > 0) {
                    byte[] bArr3 = this.byteBuffer;
                    if (bArr3[i10] == 0 && bArr3[i10 + 1] == 0 && bArr3[i10 + 2] == 0 && bArr3[i10 + 3] == 1) {
                        break;
                    }
                }
                i10++;
            }
            bArr = new byte[i10];
            int i11 = remaining - i10;
            byte[] bArr4 = new byte[i11];
            System.arraycopy(this.byteBuffer, 0, bArr, 0, i10);
            System.arraycopy(this.byteBuffer, i10, bArr4, 0, i11);
            try {
                int[] sizeFromSps = SpsParser.getSizeFromSps(bArr);
                this.mWidth = sizeFromSps[0];
                int i12 = sizeFromSps[1];
                this.mHeight = i12;
                if (i12 > 1080 && this.isAdjust) {
                    this.mHeight = 1080;
                }
                CLog.i(TAG, "  width " + sizeFromSps[0] + " height " + sizeFromSps[1]);
            } catch (Exception e10) {
                CLog.w(TAG, e10);
            }
            bArr2 = bArr4;
        } else {
            bArr = new byte[remaining];
            System.arraycopy(this.byteBuffer, 0, bArr, 0, remaining);
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.write(1);
            dataOutputStream.write(bArr[5]);
            dataOutputStream.write(bArr[6]);
            dataOutputStream.write(bArr[7]);
            dataOutputStream.write(255);
            dataOutputStream.write(225);
            dataOutputStream.writeShort(bArr.length - 4);
            dataOutputStream.write(bArr, 4, bArr.length - 4);
            dataOutputStream.write(1);
            dataOutputStream.writeShort(bArr2.length - 4);
            dataOutputStream.write(bArr2, 4, bArr2.length - 4);
            dataOutputStream.flush();
            addHeaderBits(order);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            order.position(0);
            order.putInt(byteArray.length);
            order.putShort((short) 1);
            order.putShort((short) 262);
            putTimestamp(order, 0L);
            order.putFloat(this.mWidth);
            order.putFloat(this.mHeight);
            order.position(0);
            order.limit(order.capacity());
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(order.remaining() + byteArray.length);
            allocateDirect.put(order);
            allocateDirect.put(byteArray);
            allocateDirect.position(0);
            return allocateDirect;
        } catch (Exception e11) {
            CLog.w(TAG, e11);
            return null;
        }
    }

    public void addHeaderBits(ByteBuffer byteBuffer) {
        byteBuffer.position(0);
        byteBuffer.putInt(0);
        byteBuffer.putShort((short) 0);
        byteBuffer.putShort((short) 4);
        byteBuffer.putLong(0L);
        byteBuffer.putLong(0L);
        byteBuffer.putInt(0);
        byteBuffer.putInt(0);
        byteBuffer.putInt(0);
        byteBuffer.putInt(0);
        byteBuffer.putFloat(this.mWidth);
        byteBuffer.putFloat(this.mHeight);
        byteBuffer.putFloat(0.0f);
        byteBuffer.putFloat(0.0f);
        byteBuffer.putFloat(this.mWidth);
        byteBuffer.putFloat(this.mHeight);
        byteBuffer.putInt(0);
        byteBuffer.putInt(0);
    }

    public ByteBuffer getHeartbeatData() {
        ByteBuffer order = ByteBuffer.allocateDirect(128).order(ByteOrder.LITTLE_ENDIAN);
        order.position(0);
        order.putInt(0);
        order.put((byte) 5);
        order.put((byte) 0);
        order.putShort((short) 262);
        putTimestamp(order, System.nanoTime() / 1000);
        order.putFloat(this.mWidth);
        order.putFloat(this.mHeight);
        order.rewind();
        return order;
    }

    public ByteBuffer packetOldLelinkFrameInfoData(String str) {
        byte[] writeToArray = BinaryPropertyListWriter.writeToArray(createStreamPlist(str));
        String string = new ProtocolBuilder().getStreamPortCmd().setContentType("application/octet-stream").setAplleDevid(str).setUserAgent("AirPlay/150.33").setContentLength(writeToArray.length + "").getString(true);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(string.length() + writeToArray.length);
        allocateDirect.put(string.getBytes());
        allocateDirect.put(writeToArray);
        allocateDirect.position(0);
        CLog.i(TAG, "sarrayOfByte1=" + new String(writeToArray, 0, writeToArray.length));
        return allocateDirect;
    }

    public void putTimestamp(ByteBuffer byteBuffer, long j10) {
        long j11 = (j10 / 1000) / 1000;
        double d10 = j10 % 1000000;
        Double.isNaN(d10);
        byteBuffer.putInt((int) ((((long) (d10 * 4294.967296d)) & (-1)) | (j11 << 32)));
        byteBuffer.putInt((int) j11);
    }

    public void setAdjustResolution(boolean z10) {
        this.isAdjust = z10;
    }

    public void setEncodeType(String str) {
        this.mEncodeType = str;
    }

    public void setEncrypt() {
        this.isEncrypt = true;
    }

    public ByteBuffer videoDataPacked(ByteBuffer byteBuffer, MirrorFrameEcrypto mirrorFrameEcrypto, int i10, long j10) {
        if (i10 == 7 || i10 == 32) {
            CLog.i(TAG, "frameFlag ====> " + i10);
            return packSpsPpsData(byteBuffer);
        }
        int remaining = byteBuffer.remaining();
        ByteBuffer order = ByteBuffer.allocateDirect(128).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.position(4);
        int i11 = remaining - 4;
        byte[] bArr = new byte[i11];
        byteBuffer.get(bArr, 0, i11);
        ByteBuffer order2 = ByteBuffer.allocateDirect(remaining + 128).order(ByteOrder.BIG_ENDIAN);
        order.position(0);
        order.putInt(remaining);
        order.putShort((short) 0);
        order.putShort((short) 262);
        putTimestamp(order, j10);
        order.putFloat(this.mWidth);
        order.putFloat(this.mHeight);
        order.put(FRAME_TYPE_INDEX, (byte) ((i10 == 5 || i10 == 19) ? 1 : 0));
        order.position(0);
        order.limit(order.capacity());
        order2.put(order);
        order2.putInt(i11);
        order.clear();
        if ((i10 == 5 || i10 == 19) && this.isEncrypt) {
            if (this.mEncyptData == null) {
                this.mEncyptData = new byte[AutoStrategy.BITRATE_LOW4];
            }
            System.arraycopy(bArr, 0, this.mEncyptData, 0, i11);
            byte[] bArr2 = this.mEncyptData;
            mirrorFrameEcrypto.frameEncrypt(bArr2, 1, ((remaining - 5) / 32) * 16, bArr2, 1);
            order2.put(this.mEncyptData, 0, i11);
            order2.flip();
        } else {
            order2.put(bArr);
            order2.position(0);
        }
        return order2;
    }
}
