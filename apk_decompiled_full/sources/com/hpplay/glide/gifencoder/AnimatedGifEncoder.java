package com.hpplay.glide.gifencoder;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import com.google.common.primitives.UnsignedBytes;
import com.hpplay.sdk.source.mdns.xbill.dns.Type;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public class AnimatedGifEncoder {
    private static final double MIN_TRANSPARENT_PERCENTAGE = 4.0d;
    private static final String TAG = "AnimatedGifEncoder";
    private int colorDepth;
    private byte[] colorTab;
    private boolean hasTransparentPixels;
    private int height;
    private Bitmap image;
    private byte[] indexedPixels;
    private OutputStream out;
    private byte[] pixels;
    private int transIndex;
    private int width;
    private Integer transparent = null;
    private int repeat = -1;
    private int delay = 0;
    private boolean started = false;
    private boolean[] usedEntry = new boolean[256];
    private int palSize = 7;
    private int dispose = -1;
    private boolean closeStream = false;
    private boolean firstFrame = true;
    private boolean sizeSet = false;
    private int sample = 10;

    private void analyzePixels() {
        byte[] bArr = this.pixels;
        int length = bArr.length;
        int i10 = length / 3;
        this.indexedPixels = new byte[i10];
        NeuQuant neuQuant = new NeuQuant(bArr, length, this.sample);
        this.colorTab = neuQuant.process();
        int i11 = 0;
        while (true) {
            byte[] bArr2 = this.colorTab;
            if (i11 >= bArr2.length) {
                break;
            }
            byte b10 = bArr2[i11];
            int i12 = i11 + 2;
            bArr2[i11] = bArr2[i12];
            bArr2[i12] = b10;
            this.usedEntry[i11 / 3] = false;
            i11 += 3;
        }
        int i13 = 0;
        int i14 = 0;
        while (i13 < i10) {
            byte[] bArr3 = this.pixels;
            int i15 = i14 + 1;
            int i16 = i15 + 1;
            int map = neuQuant.map(bArr3[i14] & UnsignedBytes.MAX_VALUE, bArr3[i15] & UnsignedBytes.MAX_VALUE, bArr3[i16] & UnsignedBytes.MAX_VALUE);
            this.usedEntry[map] = true;
            this.indexedPixels[i13] = (byte) map;
            i13++;
            i14 = i16 + 1;
        }
        this.pixels = null;
        this.colorDepth = 8;
        this.palSize = 7;
        Integer num = this.transparent;
        if (num != null) {
            this.transIndex = findClosest(num.intValue());
        } else if (this.hasTransparentPixels) {
            this.transIndex = findClosest(0);
        }
    }

    private int findClosest(int i10) {
        if (this.colorTab == null) {
            return -1;
        }
        int red = Color.red(i10);
        int green = Color.green(i10);
        int blue = Color.blue(i10);
        int length = this.colorTab.length;
        int i11 = 0;
        int i12 = 0;
        int i13 = 16777216;
        while (i11 < length) {
            byte[] bArr = this.colorTab;
            int i14 = i11 + 1;
            int i15 = red - (bArr[i11] & UnsignedBytes.MAX_VALUE);
            int i16 = i14 + 1;
            int i17 = green - (bArr[i14] & UnsignedBytes.MAX_VALUE);
            int i18 = blue - (bArr[i16] & UnsignedBytes.MAX_VALUE);
            int i19 = (i15 * i15) + (i17 * i17) + (i18 * i18);
            int i20 = i16 / 3;
            if (this.usedEntry[i20] && i19 < i13) {
                i13 = i19;
                i12 = i20;
            }
            i11 = i16 + 1;
        }
        return i12;
    }

    private void getImagePixels() {
        int width = this.image.getWidth();
        int height = this.image.getHeight();
        int i10 = this.width;
        if (width != i10 || height != this.height) {
            Bitmap createBitmap = Bitmap.createBitmap(i10, this.height, Bitmap.Config.ARGB_8888);
            new Canvas(createBitmap).drawBitmap(createBitmap, 0.0f, 0.0f, (Paint) null);
            this.image = createBitmap;
        }
        int i11 = width * height;
        int[] iArr = new int[i11];
        this.image.getPixels(iArr, 0, width, 0, 0, width, height);
        this.pixels = new byte[i11 * 3];
        this.hasTransparentPixels = false;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i12 < i11) {
            int i15 = iArr[i12];
            if (i15 == 0) {
                i13++;
            }
            byte[] bArr = this.pixels;
            int i16 = i14 + 1;
            bArr[i14] = (byte) (i15 & 255);
            int i17 = i16 + 1;
            bArr[i16] = (byte) ((i15 >> 8) & 255);
            bArr[i17] = (byte) ((i15 >> 16) & 255);
            i12++;
            i14 = i17 + 1;
        }
        double d10 = i13 * 100;
        double d11 = i11;
        Double.isNaN(d10);
        Double.isNaN(d11);
        double d12 = d10 / d11;
        this.hasTransparentPixels = d12 > MIN_TRANSPARENT_PERCENTAGE;
        if (Log.isLoggable(TAG, 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("got pixels for frame with ");
            sb.append(d12);
            sb.append("% transparent pixels");
        }
    }

    private void writeGraphicCtrlExt() {
        int i10;
        int i11;
        this.out.write(33);
        this.out.write(Type.TKEY);
        this.out.write(4);
        if (this.transparent != null || this.hasTransparentPixels) {
            i10 = 1;
            i11 = 2;
        } else {
            i10 = 0;
            i11 = 0;
        }
        int i12 = this.dispose;
        if (i12 >= 0) {
            i11 = i12 & 7;
        }
        this.out.write(i10 | (i11 << 2) | 0 | 0);
        writeShort(this.delay);
        this.out.write(this.transIndex);
        this.out.write(0);
    }

    private void writeImageDesc() {
        this.out.write(44);
        writeShort(0);
        writeShort(0);
        writeShort(this.width);
        writeShort(this.height);
        if (this.firstFrame) {
            this.out.write(0);
        } else {
            this.out.write(this.palSize | 128);
        }
    }

    private void writeLSD() {
        writeShort(this.width);
        writeShort(this.height);
        this.out.write(this.palSize | 240);
        this.out.write(0);
        this.out.write(0);
    }

    private void writeNetscapeExt() {
        this.out.write(33);
        this.out.write(255);
        this.out.write(11);
        writeString("NETSCAPE2.0");
        this.out.write(3);
        this.out.write(1);
        writeShort(this.repeat);
        this.out.write(0);
    }

    private void writePalette() {
        OutputStream outputStream = this.out;
        byte[] bArr = this.colorTab;
        outputStream.write(bArr, 0, bArr.length);
        int length = 768 - this.colorTab.length;
        for (int i10 = 0; i10 < length; i10++) {
            this.out.write(0);
        }
    }

    private void writePixels() {
        new LZWEncoder(this.width, this.height, this.indexedPixels, this.colorDepth).encode(this.out);
    }

    private void writeShort(int i10) {
        this.out.write(i10 & 255);
        this.out.write((i10 >> 8) & 255);
    }

    private void writeString(String str) {
        for (int i10 = 0; i10 < str.length(); i10++) {
            this.out.write((byte) str.charAt(i10));
        }
    }

    public boolean addFrame(Bitmap bitmap) {
        if (bitmap == null || !this.started) {
            return false;
        }
        try {
            if (!this.sizeSet) {
                setSize(bitmap.getWidth(), bitmap.getHeight());
            }
            this.image = bitmap;
            getImagePixels();
            analyzePixels();
            if (this.firstFrame) {
                writeLSD();
                writePalette();
                if (this.repeat >= 0) {
                    writeNetscapeExt();
                }
            }
            writeGraphicCtrlExt();
            writeImageDesc();
            if (!this.firstFrame) {
                writePalette();
            }
            writePixels();
            this.firstFrame = false;
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public boolean finish() {
        boolean z10;
        if (!this.started) {
            return false;
        }
        this.started = false;
        try {
            this.out.write(59);
            this.out.flush();
            if (this.closeStream) {
                this.out.close();
            }
            z10 = true;
        } catch (IOException unused) {
            z10 = false;
        }
        this.transIndex = 0;
        this.out = null;
        this.image = null;
        this.pixels = null;
        this.indexedPixels = null;
        this.colorTab = null;
        this.closeStream = false;
        this.firstFrame = true;
        return z10;
    }

    public void setDelay(int i10) {
        this.delay = Math.round(i10 / 10.0f);
    }

    public void setDispose(int i10) {
        if (i10 >= 0) {
            this.dispose = i10;
        }
    }

    public void setFrameRate(float f10) {
        if (f10 != 0.0f) {
            this.delay = Math.round(100.0f / f10);
        }
    }

    public void setQuality(int i10) {
        if (i10 < 1) {
            i10 = 1;
        }
        this.sample = i10;
    }

    public void setRepeat(int i10) {
        if (i10 >= 0) {
            this.repeat = i10;
        }
    }

    public void setSize(int i10, int i11) {
        if (!this.started || this.firstFrame) {
            this.width = i10;
            this.height = i11;
            if (i10 < 1) {
                this.width = 320;
            }
            if (i11 < 1) {
                this.height = 240;
            }
            this.sizeSet = true;
        }
    }

    public void setTransparent(int i10) {
        this.transparent = Integer.valueOf(i10);
    }

    public boolean start(OutputStream outputStream) {
        boolean z10 = false;
        if (outputStream == null) {
            return false;
        }
        this.closeStream = false;
        this.out = outputStream;
        try {
            writeString("GIF89a");
            z10 = true;
        } catch (IOException unused) {
        }
        this.started = z10;
        return z10;
    }

    public boolean start(String str) {
        boolean z10;
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str));
            this.out = bufferedOutputStream;
            z10 = start(bufferedOutputStream);
            this.closeStream = true;
        } catch (IOException unused) {
            z10 = false;
        }
        this.started = z10;
        return z10;
    }
}
