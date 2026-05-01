package com.hpplay.glide.gifdecoder;

import android.graphics.Bitmap;
import android.util.Log;
import com.google.common.primitives.UnsignedBytes;
import com.umeng.analytics.pro.q;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class GifDecoder {
    private static final Bitmap.Config BITMAP_CONFIG = Bitmap.Config.ARGB_8888;
    private static final int DISPOSAL_BACKGROUND = 2;
    private static final int DISPOSAL_NONE = 1;
    private static final int DISPOSAL_PREVIOUS = 3;
    private static final int DISPOSAL_UNSPECIFIED = 0;
    private static final int INITIAL_FRAME_POINTER = -1;
    private static final int MAX_STACK_SIZE = 4096;
    private static final int NULL_CODE = -1;
    public static final int STATUS_FORMAT_ERROR = 1;
    public static final int STATUS_OK = 0;
    public static final int STATUS_OPEN_ERROR = 2;
    public static final int STATUS_PARTIAL_DECODE = 3;
    private static final String TAG = "GifDecoder";
    private int[] act;
    private BitmapProvider bitmapProvider;
    private byte[] data;
    private int framePointer;
    private byte[] mainPixels;
    private int[] mainScratch;
    private GifHeaderParser parser;
    private byte[] pixelStack;
    private short[] prefix;
    private Bitmap previousImage;
    private ByteBuffer rawData;
    private boolean savePrevious;
    private int status;
    private byte[] suffix;
    private final byte[] block = new byte[256];
    private GifHeader header = new GifHeader();

    public interface BitmapProvider {
        Bitmap obtain(int i10, int i11, Bitmap.Config config);

        void release(Bitmap bitmap);
    }

    public GifDecoder(BitmapProvider bitmapProvider) {
        this.bitmapProvider = bitmapProvider;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0137 A[LOOP:5: B:62:0x0135->B:63:0x0137, LOOP_END] */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v26, types: [short] */
    /* JADX WARN: Type inference failed for: r1v28 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void decodeBitmapData(GifFrame gifFrame) {
        int i10;
        int i11;
        int i12;
        short s10;
        if (gifFrame != null) {
            this.rawData.position(gifFrame.bufferFrameStart);
        }
        if (gifFrame == null) {
            GifHeader gifHeader = this.header;
            i10 = gifHeader.width;
            i11 = gifHeader.height;
        } else {
            i10 = gifFrame.iw;
            i11 = gifFrame.ih;
        }
        int i13 = i10 * i11;
        byte[] bArr = this.mainPixels;
        if (bArr == null || bArr.length < i13) {
            this.mainPixels = new byte[i13];
        }
        if (this.prefix == null) {
            this.prefix = new short[4096];
        }
        if (this.suffix == null) {
            this.suffix = new byte[4096];
        }
        if (this.pixelStack == null) {
            this.pixelStack = new byte[q.a.f10521a];
        }
        int read = read();
        int i14 = 1;
        int i15 = 1 << read;
        int i16 = i15 + 1;
        int i17 = i15 + 2;
        int i18 = read + 1;
        int i19 = (1 << i18) - 1;
        for (int i20 = 0; i20 < i15; i20++) {
            this.prefix[i20] = 0;
            this.suffix[i20] = (byte) i20;
        }
        int i21 = -1;
        int i22 = i18;
        int i23 = i17;
        int i24 = i19;
        int i25 = 0;
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        int i29 = 0;
        int i30 = 0;
        int i31 = -1;
        int i32 = 0;
        int i33 = 0;
        while (true) {
            if (i25 >= i13) {
                break;
            }
            int i34 = 3;
            if (i26 == 0) {
                i26 = readBlock();
                if (i26 <= 0) {
                    this.status = 3;
                    break;
                }
                i27 = 0;
            }
            i29 += (this.block[i27] & UnsignedBytes.MAX_VALUE) << i28;
            i28 += 8;
            i27 += i14;
            i26 += i21;
            int i35 = i23;
            int i36 = i22;
            int i37 = i31;
            int i38 = i32;
            while (i28 >= i36) {
                int i39 = i29 & i24;
                i29 >>= i36;
                i28 -= i36;
                if (i39 != i15) {
                    if (i39 > i35) {
                        this.status = i34;
                    } else if (i39 != i16) {
                        int i40 = i18;
                        int i41 = i37;
                        if (i41 == -1) {
                            this.pixelStack[i33] = this.suffix[i39];
                            i37 = i39;
                            i38 = i37;
                            i18 = i40;
                            i33++;
                            i34 = 3;
                            i21 = -1;
                        } else {
                            if (i39 >= i35) {
                                i12 = i16;
                                this.pixelStack[i33] = (byte) i38;
                                s10 = i41;
                                i33++;
                            } else {
                                i12 = i16;
                                s10 = i39;
                            }
                            while (s10 >= i15) {
                                this.pixelStack[i33] = this.suffix[s10];
                                s10 = this.prefix[s10];
                                i33++;
                                i15 = i15;
                            }
                            int i42 = i15;
                            byte[] bArr2 = this.suffix;
                            int i43 = bArr2[s10] & UnsignedBytes.MAX_VALUE;
                            int i44 = i33 + 1;
                            int i45 = i17;
                            byte b10 = (byte) i43;
                            this.pixelStack[i33] = b10;
                            if (i35 < 4096) {
                                this.prefix[i35] = (short) i41;
                                bArr2[i35] = b10;
                                i35++;
                                if ((i35 & i24) == 0) {
                                    if (i35 < 4096) {
                                        i36++;
                                        i24 += i35;
                                    }
                                    i33 = i44;
                                    while (i33 > 0) {
                                        i33--;
                                        this.mainPixels[i30] = this.pixelStack[i33];
                                        i25++;
                                        i30++;
                                    }
                                    i37 = i39;
                                    i15 = i42;
                                    i16 = i12;
                                    i17 = i45;
                                    i34 = 3;
                                    i21 = -1;
                                    i38 = i43;
                                    i18 = i40;
                                }
                            }
                            i33 = i44;
                            while (i33 > 0) {
                            }
                            i37 = i39;
                            i15 = i42;
                            i16 = i12;
                            i17 = i45;
                            i34 = 3;
                            i21 = -1;
                            i38 = i43;
                            i18 = i40;
                        }
                    }
                    i23 = i35;
                    i22 = i36;
                    i31 = i37;
                    i32 = i38;
                    i14 = 1;
                    i21 = -1;
                    break;
                }
                i36 = i18;
                i35 = i17;
                i24 = i19;
                i21 = -1;
                i37 = -1;
            }
            i23 = i35;
            i22 = i36;
            i32 = i38;
            i31 = i37;
            i16 = i16;
            i14 = 1;
        }
        for (int i46 = i30; i46 < i13; i46++) {
            this.mainPixels[i46] = 0;
        }
    }

    private GifHeaderParser getHeaderParser() {
        if (this.parser == null) {
            this.parser = new GifHeaderParser();
        }
        return this.parser;
    }

    private Bitmap getNextBitmap() {
        BitmapProvider bitmapProvider = this.bitmapProvider;
        GifHeader gifHeader = this.header;
        int i10 = gifHeader.width;
        int i11 = gifHeader.height;
        Bitmap.Config config = BITMAP_CONFIG;
        Bitmap obtain = bitmapProvider.obtain(i10, i11, config);
        if (obtain == null) {
            GifHeader gifHeader2 = this.header;
            obtain = Bitmap.createBitmap(gifHeader2.width, gifHeader2.height, config);
        }
        setAlpha(obtain);
        return obtain;
    }

    private int readBlock() {
        int read = read();
        int i10 = 0;
        if (read > 0) {
            while (i10 < read) {
                int i11 = read - i10;
                try {
                    this.rawData.get(this.block, i10, i11);
                    i10 += i11;
                } catch (Exception unused) {
                    this.status = 1;
                }
            }
        }
        return i10;
    }

    private static void setAlpha(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x009a A[EDGE_INSN: B:46:0x009a->B:47:0x009a BREAK  A[LOOP:0: B:16:0x0042->B:43:0x0094], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Bitmap setPixels(GifFrame gifFrame, GifFrame gifFrame2) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        Bitmap bitmap;
        GifHeader gifHeader = this.header;
        int i17 = gifHeader.width;
        int i18 = gifHeader.height;
        int[] iArr = this.mainScratch;
        int i19 = 3;
        if (gifFrame2 != null && (i16 = gifFrame2.dispose) > 0) {
            if (i16 == 2) {
                Arrays.fill(iArr, !gifFrame.transparency ? gifHeader.bgColor : 0);
            } else if (i16 == 3 && (bitmap = this.previousImage) != null) {
                i10 = 2;
                bitmap.getPixels(iArr, 0, i17, 0, 0, i17, i18);
                decodeBitmapData(gifFrame);
                int i20 = 8;
                i11 = 0;
                i12 = 0;
                int i21 = 1;
                while (true) {
                    i13 = gifFrame.ih;
                    if (i11 < i13) {
                        break;
                    }
                    if (gifFrame.interlace) {
                        if (i12 >= i13) {
                            i21++;
                            if (i21 == i10) {
                                i12 = 4;
                            } else if (i21 == i19) {
                                i20 = 4;
                                i12 = 2;
                            } else if (i21 == 4) {
                                i20 = 2;
                                i12 = 1;
                            }
                        }
                        i15 = i12 + i20;
                    } else {
                        i15 = i12;
                        i12 = i11;
                    }
                    int i22 = i12 + gifFrame.iy;
                    GifHeader gifHeader2 = this.header;
                    if (i22 < gifHeader2.height) {
                        int i23 = gifHeader2.width;
                        int i24 = i22 * i23;
                        int i25 = gifFrame.ix + i24;
                        int i26 = gifFrame.iw;
                        int i27 = i25 + i26;
                        if (i24 + i23 < i27) {
                            i27 = i24 + i23;
                        }
                        int i28 = i26 * i11;
                        while (i25 < i27) {
                            int i29 = i28 + 1;
                            int i30 = this.act[this.mainPixels[i28] & UnsignedBytes.MAX_VALUE];
                            if (i30 != 0) {
                                iArr[i25] = i30;
                            }
                            i25++;
                            i28 = i29;
                        }
                    }
                    i11++;
                    i12 = i15;
                    i10 = 2;
                    i19 = 3;
                }
                if (this.savePrevious && ((i14 = gifFrame.dispose) == 0 || i14 == 1)) {
                    if (this.previousImage == null) {
                        this.previousImage = getNextBitmap();
                    }
                    this.previousImage.setPixels(iArr, 0, i17, 0, 0, i17, i18);
                }
                Bitmap nextBitmap = getNextBitmap();
                nextBitmap.setPixels(iArr, 0, i17, 0, 0, i17, i18);
                return nextBitmap;
            }
        }
        i10 = 2;
        decodeBitmapData(gifFrame);
        int i202 = 8;
        i11 = 0;
        i12 = 0;
        int i212 = 1;
        while (true) {
            i13 = gifFrame.ih;
            if (i11 < i13) {
            }
            i11++;
            i12 = i15;
            i10 = 2;
            i19 = 3;
        }
        if (this.savePrevious) {
            if (this.previousImage == null) {
            }
            this.previousImage.setPixels(iArr, 0, i17, 0, 0, i17, i18);
        }
        Bitmap nextBitmap2 = getNextBitmap();
        nextBitmap2.setPixels(iArr, 0, i17, 0, 0, i17, i18);
        return nextBitmap2;
    }

    public void advance() {
        this.framePointer = (this.framePointer + 1) % this.header.frameCount;
    }

    public void clear() {
        this.header = null;
        this.data = null;
        this.mainPixels = null;
        this.mainScratch = null;
        Bitmap bitmap = this.previousImage;
        if (bitmap != null) {
            this.bitmapProvider.release(bitmap);
        }
        this.previousImage = null;
        this.rawData = null;
    }

    public int getCurrentFrameIndex() {
        return this.framePointer;
    }

    public byte[] getData() {
        return this.data;
    }

    public int getDelay(int i10) {
        if (i10 >= 0) {
            GifHeader gifHeader = this.header;
            if (i10 < gifHeader.frameCount) {
                return gifHeader.frames.get(i10).delay;
            }
        }
        return -1;
    }

    public int getFrameCount() {
        return this.header.frameCount;
    }

    public int getHeight() {
        return this.header.height;
    }

    public int getLoopCount() {
        return this.header.loopCount;
    }

    public int getNextDelay() {
        int i10;
        if (this.header.frameCount <= 0 || (i10 = this.framePointer) < 0) {
            return -1;
        }
        return getDelay(i10);
    }

    public synchronized Bitmap getNextFrame() {
        if (this.header.frameCount <= 0 || this.framePointer < 0) {
            if (Log.isLoggable(TAG, 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("unable to decode frame, frameCount=");
                sb.append(this.header.frameCount);
                sb.append(" framePointer=");
                sb.append(this.framePointer);
            }
            this.status = 1;
        }
        int i10 = this.status;
        if (i10 != 1 && i10 != 2) {
            int i11 = 0;
            this.status = 0;
            GifFrame gifFrame = this.header.frames.get(this.framePointer);
            int i12 = this.framePointer - 1;
            GifFrame gifFrame2 = i12 >= 0 ? this.header.frames.get(i12) : null;
            int[] iArr = gifFrame.lct;
            if (iArr == null) {
                this.act = this.header.gct;
            } else {
                this.act = iArr;
                GifHeader gifHeader = this.header;
                if (gifHeader.bgIndex == gifFrame.transIndex) {
                    gifHeader.bgColor = 0;
                }
            }
            if (gifFrame.transparency) {
                int[] iArr2 = this.act;
                int i13 = gifFrame.transIndex;
                int i14 = iArr2[i13];
                iArr2[i13] = 0;
                i11 = i14;
            }
            if (this.act == null) {
                Log.isLoggable(TAG, 3);
                this.status = 1;
                return null;
            }
            Bitmap pixels = setPixels(gifFrame, gifFrame2);
            if (gifFrame.transparency) {
                this.act[gifFrame.transIndex] = i11;
            }
            return pixels;
        }
        if (Log.isLoggable(TAG, 3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unable to decode frame, status=");
            sb2.append(this.status);
        }
        return null;
    }

    public int getStatus() {
        return this.status;
    }

    public int getWidth() {
        return this.header.width;
    }

    public int read(InputStream inputStream, int i10) {
        if (inputStream != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i10 > 0 ? i10 + 4096 : 16384);
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = inputStream.read(bArr, 0, 16384);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byteArrayOutputStream.flush();
                read(byteArrayOutputStream.toByteArray());
            } catch (IOException unused) {
            }
        } else {
            this.status = 2;
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused2) {
            }
        }
        return this.status;
    }

    public void resetFrameIndex() {
        this.framePointer = -1;
    }

    public void setData(GifHeader gifHeader, byte[] bArr) {
        this.header = gifHeader;
        this.data = bArr;
        this.status = 0;
        this.framePointer = -1;
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        this.rawData = wrap;
        wrap.rewind();
        this.rawData.order(ByteOrder.LITTLE_ENDIAN);
        this.savePrevious = false;
        Iterator<GifFrame> it = gifHeader.frames.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().dispose == 3) {
                this.savePrevious = true;
                break;
            }
        }
        int i10 = gifHeader.width;
        int i11 = gifHeader.height;
        this.mainPixels = new byte[i10 * i11];
        this.mainScratch = new int[i10 * i11];
    }

    public int read(byte[] bArr) {
        this.data = bArr;
        this.header = getHeaderParser().setData(bArr).parseHeader();
        if (bArr != null) {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            this.rawData = wrap;
            wrap.rewind();
            this.rawData.order(ByteOrder.LITTLE_ENDIAN);
            GifHeader gifHeader = this.header;
            int i10 = gifHeader.width;
            int i11 = gifHeader.height;
            this.mainPixels = new byte[i10 * i11];
            this.mainScratch = new int[i10 * i11];
            this.savePrevious = false;
            Iterator<GifFrame> it = gifHeader.frames.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (it.next().dispose == 3) {
                    this.savePrevious = true;
                    break;
                }
            }
        }
        return this.status;
    }

    private int read() {
        try {
            return this.rawData.get() & UnsignedBytes.MAX_VALUE;
        } catch (Exception unused) {
            this.status = 1;
            return 0;
        }
    }
}
