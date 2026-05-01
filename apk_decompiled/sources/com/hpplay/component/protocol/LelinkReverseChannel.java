package com.hpplay.component.protocol;

import android.os.ParcelFileDescriptor;
import com.hpplay.component.common.protocol.ProtocolListener;
import com.hpplay.component.common.utils.CLog;
import com.hpplay.component.protocol.encrypt.LelinkEncrypt;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class LelinkReverseChannel extends ProtocolCore implements Runnable {
    public static final String ENCRYPT_FAILED = "encrypt_failed";
    private static final String KEY_HEADER_EVENT = "POST /heart";
    private static final String KEY_HEADER_HARDBET = "POST /event";
    private static final String KEY_HEADER_PHOTO_STATE = "POST /photo";
    private static final String TAG = "LelinkReverseChannel";
    private LelinkEncrypt mLelinkEncrypt;
    private byte[] mProtocol;
    private ProtocolListener mProtocolListener;
    private Thread mReceiveThread;
    private int totalLength = 0;
    private byte[] receveData = null;
    private boolean isStop = false;

    public LelinkReverseChannel() {
    }

    private synchronized void closeSocket() {
        if (this.mLocalAutoCloseInputStream != null) {
            try {
                CLog.d(TAG, "----------->closeSender");
                this.mLocalAutoCloseInputStream.close();
            } catch (IOException e10) {
                CLog.w(TAG, e10);
            }
        }
        FileOutputStream fileOutputStream = this.mLocalFileOutputStream;
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException e11) {
                CLog.w(TAG, e11);
            }
        }
        Socket socket = this.mSocket;
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e12) {
                CLog.w(TAG, e12);
            }
        }
        this.mSocket = null;
        this.mLocalFileOutputStream = null;
        this.mLocalAutoCloseInputStream = null;
    }

    private void sendData() {
        CLog.i(TAG, "----------->> sendData");
        byte[] bArr = new byte[2048];
        try {
            this.mLocalFileOutputStream.write(this.mProtocol);
            this.mLocalFileOutputStream.flush();
            int read = this.mLocalAutoCloseInputStream.read(bArr);
            if (read < 0) {
                return;
            }
            String str = new String(bArr, 0, read);
            ProtocolListener protocolListener = this.mProtocolListener;
            if (protocolListener != null) {
                protocolListener.onResult(protocolListener.cmdType, str);
            }
        } catch (Exception e10) {
            CLog.w(TAG, e10);
        }
    }

    private void sendEncryptData() {
        try {
            this.mLocalFileOutputStream.write(this.mLelinkEncrypt.buildEncryptData(this.mProtocol));
            this.mLocalFileOutputStream.flush();
        } catch (Exception e10) {
            CLog.w(TAG, e10);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0031 A[Catch: Exception -> 0x003b, TRY_LEAVE, TryCatch #0 {Exception -> 0x003b, blocks: (B:3:0x0002, B:5:0x000a, B:7:0x000d, B:10:0x0016, B:13:0x001c, B:14:0x002a, B:16:0x0031, B:21:0x0023), top: B:2:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void parseResponse(byte[] r7) {
        /*
            r6 = this;
            java.lang.String r0 = "LelinkReverseChannel"
            com.hpplay.component.protocol.encrypt.LelinkEncrypt r1 = r6.mLelinkEncrypt     // Catch: java.lang.Exception -> L3b
            byte[] r7 = r1.decryptData(r7)     // Catch: java.lang.Exception -> L3b
            if (r7 == 0) goto L3f
            int r1 = r7.length     // Catch: java.lang.Exception -> L3b
            if (r1 <= 0) goto L3f
            byte[] r1 = com.hpplay.component.protocol.ProtocolUtils.getBody(r7)     // Catch: java.lang.Exception -> L3b
            java.lang.String r2 = "utf-8"
            r3 = 0
            if (r1 == 0) goto L23
            int r4 = r1.length     // Catch: java.lang.Exception -> L3b
            r5 = 10
            if (r4 >= r5) goto L1c
            goto L23
        L1c:
            java.lang.String r7 = new java.lang.String     // Catch: java.lang.Exception -> L3b
            int r4 = r1.length     // Catch: java.lang.Exception -> L3b
            r7.<init>(r1, r3, r4, r2)     // Catch: java.lang.Exception -> L3b
            goto L2a
        L23:
            java.lang.String r1 = new java.lang.String     // Catch: java.lang.Exception -> L3b
            int r4 = r7.length     // Catch: java.lang.Exception -> L3b
            r1.<init>(r7, r3, r4, r2)     // Catch: java.lang.Exception -> L3b
            r7 = r1
        L2a:
            com.hpplay.component.common.utils.CLog.i(r0, r7)     // Catch: java.lang.Exception -> L3b
            com.hpplay.component.common.protocol.ProtocolListener r1 = r6.mProtocolListener     // Catch: java.lang.Exception -> L3b
            if (r1 == 0) goto L3f
            int r2 = r1.cmdType     // Catch: java.lang.Exception -> L3b
            java.lang.String[] r7 = new java.lang.String[]{r7}     // Catch: java.lang.Exception -> L3b
            r1.onResult(r2, r7)     // Catch: java.lang.Exception -> L3b
            goto L3f
        L3b:
            r7 = move-exception
            com.hpplay.component.common.utils.CLog.w(r0, r7)
        L3f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.component.protocol.LelinkReverseChannel.parseResponse(byte[]):void");
    }

    public boolean readEncryptData() {
        try {
            byte[] bArr = new byte[4];
            int available = this.mLocalAutoCloseInputStream.available();
            int i10 = this.totalLength;
            if (i10 == 0) {
                if (this.mLocalAutoCloseInputStream.read(bArr, 0, 4) < 0) {
                    return true;
                }
                int bytesToInt = ProtocolUtils.bytesToInt(bArr);
                if (bytesToInt != 0 && bytesToInt <= 2097152) {
                    this.totalLength = 4;
                    byte[] bArr2 = new byte[bytesToInt + 4 + 16];
                    this.receveData = bArr2;
                    System.arraycopy(bArr, 0, bArr2, 0, 4);
                }
                return false;
            }
            byte[] bArr3 = new byte[available];
            byte[] bArr4 = this.receveData;
            if (available > bArr4.length - i10) {
                available = bArr4.length - i10;
                bArr3 = new byte[available];
            }
            this.mLocalAutoCloseInputStream.read(bArr3, 0, available);
            System.arraycopy(bArr3, 0, this.receveData, this.totalLength, bArr3.length);
            int i11 = this.totalLength + available;
            this.totalLength = i11;
            byte[] bArr5 = this.receveData;
            if (i11 == bArr5.length) {
                parseResponse(bArr5);
                this.totalLength = 0;
                this.receveData = null;
            }
            return false;
        } catch (Exception e10) {
            CLog.w(TAG, e10);
            CLog.d(TAG, " startCapture read " + e10.toString());
            return true;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.mSocket == null) {
            try {
                connectServer();
            } catch (Exception e10) {
                CLog.w(TAG, e10);
            }
        }
        LelinkEncrypt lelinkEncrypt = this.mLelinkEncrypt;
        if (lelinkEncrypt != null) {
            if (!checkEncrypt(lelinkEncrypt, TAG)) {
                ProtocolListener protocolListener = this.mProtocolListener;
                if (protocolListener != null) {
                    protocolListener.onResult(protocolListener.cmdType, "encrypt_failed");
                    return;
                }
                return;
            }
            sendEncryptData();
            this.totalLength = 0;
            this.receveData = null;
            this.isStop = false;
            while (!this.isStop) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.isStop);
                sb.append(" start read ");
                sb.append(this.mProtocolListener == null);
                CLog.d(TAG, sb.toString());
                if (readEncryptData()) {
                    break;
                }
            }
            closeSocket();
            return;
        }
        if (this.mProtocol != null) {
            sendData();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.isStop);
        sb2.append("----------sendReverse---------------");
        sb2.append(this.mLocalAutoCloseInputStream == null);
        CLog.d(TAG, sb2.toString());
        byte[] bArr = new byte[11];
        this.isStop = false;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i10 = 0;
        while (true) {
            boolean z10 = false;
            while (!this.isStop) {
                ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = this.mLocalAutoCloseInputStream;
                if (autoCloseInputStream != null) {
                    try {
                        i10 = autoCloseInputStream.read(bArr);
                    } catch (Exception e11) {
                        CLog.w(TAG, e11);
                    }
                    if (i10 <= 0) {
                        continue;
                    } else if (bArr.length == 1) {
                        arrayList.add(Byte.valueOf(bArr[0]));
                        if (ProtocolUtils.getProtocolDivide(arrayList)) {
                            int size = arrayList.size();
                            byte[] bArr2 = new byte[size];
                            for (int i11 = 0; i11 < size; i11++) {
                                bArr2[i11] = ((Byte) arrayList.get(i11)).byteValue();
                            }
                            String str = new String(bArr2);
                            CLog.d("header", "" + str);
                            if (str.contains(KEY_HEADER_PHOTO_STATE)) {
                                ProtocolListener protocolListener2 = this.mProtocolListener;
                                if (protocolListener2 != null) {
                                    protocolListener2.onResult(protocolListener2.cmdType, str);
                                }
                                bArr = new byte[11];
                            } else {
                                try {
                                    int contentLength = ProtocolUtils.getContentLength(str);
                                    CLog.d(TAG, "contentLength" + contentLength + "");
                                    if (contentLength <= 0 || contentLength >= 2097152) {
                                        bArr = new byte[11];
                                        arrayList.clear();
                                    } else {
                                        bArr = new byte[contentLength];
                                        arrayList.clear();
                                    }
                                } catch (Exception e12) {
                                    CLog.w(TAG, e12);
                                    bArr = new byte[11];
                                }
                            }
                        }
                    } else if (bArr.length != 11 || z10) {
                        arrayList.clear();
                        try {
                        } catch (Exception e13) {
                            CLog.w(TAG, e13);
                            bArr = new byte[11];
                            arrayList2.clear();
                        }
                        if (i10 < bArr.length) {
                            CLog.d(TAG, "---------------------->" + bArr.length + "  ----------------   " + i10);
                            byte[] bArr3 = new byte[i10];
                            System.arraycopy(bArr, 0, bArr3, 0, i10);
                            arrayList2.add(bArr3);
                            int length = bArr.length - i10;
                            byte[] bArr4 = new byte[length];
                            z10 = length == 11;
                            bArr = bArr4;
                        } else {
                            int i12 = i10;
                            for (int i13 = 0; i13 < arrayList2.size(); i13++) {
                                i12 += ((byte[]) arrayList2.get(i13)).length;
                            }
                            byte[] bArr5 = new byte[i12];
                            int i14 = 0;
                            for (int i15 = 0; i15 < arrayList2.size(); i15++) {
                                System.arraycopy(arrayList2.get(i15), 0, bArr5, i14, ((byte[]) arrayList2.get(i15)).length);
                                i14 += ((byte[]) arrayList2.get(i15)).length;
                            }
                            System.arraycopy(bArr, 0, bArr5, i14, i10);
                            String str2 = new String(bArr5, 0, i12);
                            CLog.d(TAG, str2);
                            ProtocolListener protocolListener3 = this.mProtocolListener;
                            if (protocolListener3 != null) {
                                protocolListener3.onResult(protocolListener3.cmdType, str2);
                            }
                            bArr = new byte[11];
                            arrayList2.clear();
                        }
                    } else {
                        try {
                            arrayList.clear();
                            String str3 = new String(bArr, 0, bArr.length);
                            if (str3.equals(KEY_HEADER_EVENT) || str3.equals(KEY_HEADER_HARDBET) || str3.equals(KEY_HEADER_PHOTO_STATE)) {
                                for (byte b10 : bArr) {
                                    arrayList.add(Byte.valueOf(b10));
                                }
                            }
                            CLog.d(TAG, str3);
                        } catch (Exception e14) {
                            CLog.w(TAG, e14);
                        }
                        bArr = new byte[1];
                    }
                }
            }
            closeSocket();
            CLog.d(TAG, "----------exit---------------");
            return;
        }
    }

    public void setRecevelistenerAndProtocol(ProtocolListener protocolListener, byte[] bArr) {
        this.mProtocolListener = protocolListener;
        this.mProtocol = bArr;
    }

    public void startReceive() {
        if (this.mReceiveThread == null) {
            CLog.d(TAG, "---------------------->startReceive");
            Thread thread = new Thread(this);
            this.mReceiveThread = thread;
            thread.setName("ReverseReceiverThread");
            this.mReceiveThread.start();
        }
    }

    public synchronized void stopReceive() {
        this.isStop = true;
        if (this.mReceiveThread != null) {
            CLog.i(TAG, "---------------------->stopReceive");
            this.mReceiveThread.interrupt();
            this.mReceiveThread = null;
        }
        this.mProtocolListener = null;
        closeSocket();
    }

    public LelinkReverseChannel(String str, int i10) {
        this.mIP = str;
        this.mPort = i10;
        CLog.d(TAG, "create reverse");
    }

    public LelinkReverseChannel(String str, int i10, String str2) {
        this.mIP = str;
        this.mPort = i10;
        LelinkEncrypt lelinkEncrypt = new LelinkEncrypt(str2);
        this.mLelinkEncrypt = lelinkEncrypt;
        lelinkEncrypt.setSrpPassword(null);
        CLog.d(TAG, "create reverse");
    }

    public LelinkReverseChannel(String str, int i10, String str2, String str3) {
        this.mIP = str;
        this.mPort = i10;
        LelinkEncrypt lelinkEncrypt = new LelinkEncrypt(str2);
        this.mLelinkEncrypt = lelinkEncrypt;
        lelinkEncrypt.setSrpPassword(str3);
        CLog.d(TAG, "create reverse");
    }
}
