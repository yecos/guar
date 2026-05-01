package a5;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class e {
    public static byte[] a(File file, int i10) {
        ByteBuffer byteBuffer;
        Map b10 = b(file);
        if (b10 == null || (byteBuffer = (ByteBuffer) b10.get(Integer.valueOf(i10))) == null) {
            return null;
        }
        return c(byteBuffer);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0043, code lost:
    
        if (r1 == null) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Map b(File file) {
        FileChannel fileChannel;
        RandomAccessFile randomAccessFile;
        Map map = null;
        try {
            try {
                randomAccessFile = new RandomAccessFile(file, "r");
                try {
                    fileChannel = randomAccessFile.getChannel();
                    try {
                        map = a.f((ByteBuffer) a.b(fileChannel).a());
                        if (fileChannel != null) {
                            try {
                                fileChannel.close();
                            } catch (IOException unused) {
                            }
                        }
                    } catch (IOException unused2) {
                        if (fileChannel != null) {
                            try {
                                fileChannel.close();
                            } catch (IOException unused3) {
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (fileChannel != null) {
                            try {
                                fileChannel.close();
                            } catch (IOException unused4) {
                            }
                        }
                        if (randomAccessFile == null) {
                            throw th;
                        }
                        try {
                            randomAccessFile.close();
                            throw th;
                        } catch (IOException unused5) {
                            throw th;
                        }
                    }
                } catch (IOException unused6) {
                    fileChannel = null;
                } catch (Throwable th2) {
                    th = th2;
                    fileChannel = null;
                }
            } catch (f | IOException unused7) {
            }
        } catch (IOException unused8) {
            fileChannel = null;
            randomAccessFile = null;
        } catch (Throwable th3) {
            th = th3;
            fileChannel = null;
            randomAccessFile = null;
        }
        randomAccessFile.close();
        return map;
    }

    public static byte[] c(ByteBuffer byteBuffer) {
        byte[] array = byteBuffer.array();
        int arrayOffset = byteBuffer.arrayOffset();
        return Arrays.copyOfRange(array, byteBuffer.position() + arrayOffset, arrayOffset + byteBuffer.limit());
    }

    public static String d(File file, int i10) {
        byte[] a10 = a(file, i10);
        if (a10 == null) {
            return null;
        }
        try {
            return new String(a10, "UTF-8");
        } catch (UnsupportedEncodingException e10) {
            e10.printStackTrace();
            return null;
        }
    }
}
