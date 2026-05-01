package com.hpplay.component.protocol.server;

import android.text.TextUtils;
import com.google.android.gms.cast.MediaError;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.common.protocol.IMirrorStateListener;
import com.hpplay.component.common.utils.CLog;
import com.hpplay.component.protocol.ProtocolUtils;
import com.hpplay.component.protocol.plist.NSDictionary;
import com.hpplay.component.protocol.plist.PropertyListParser;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class RequestHandler implements IRequestHandler, Runnable {
    private static final String ERROR = "error";
    private static final String FORCE_STOPED = "force_stopped";
    private static final String KEY_HEADER_EVENT = "POST /heart";
    private static final String KEY_HEADER_HARDBET = "POST /event";
    private static final String KEY_HEADER_PHOTO_STATE = "POST /photo";
    private static final String MIRROR_MODE = "mirrormode";
    private static final String PREEMPT_STOPED = "preempt_stopped";
    private static final String REASON = "reason";
    private static final String SERVER_STOPED = "server_force_stopped";
    private static final String STATE = "state";
    private static final String STOPPED = "stopped";
    private static final String USER_STOPED = "user_stopped";
    private String TAG = "RequestHandler";
    private final Socket mAcceptSocket;
    private String mDeviceIp;
    private final InputStream mInputStream;
    private IMirrorStateListener mLelinkMirrorListener;
    private IRequstManager mRequstManager;

    public RequestHandler(IRequstManager iRequstManager, IMirrorStateListener iMirrorStateListener, InputStream inputStream, Socket socket) {
        this.mInputStream = inputStream;
        this.mAcceptSocket = socket;
        this.mLelinkMirrorListener = iMirrorStateListener;
        this.mRequstManager = iRequstManager;
        this.mDeviceIp = socket.getInetAddress().getHostAddress();
    }

    private void parseMirrorEvent(String str) {
        CLog.i(this.TAG, "------>" + str);
        if (this.mLelinkMirrorListener != null) {
            try {
                NSDictionary nSDictionary = (NSDictionary) PropertyListParser.parse(str.getBytes());
                if (nSDictionary != null) {
                    if (!nSDictionary.containsKey("state")) {
                        if (nSDictionary.containsKey(MIRROR_MODE)) {
                            String obj = nSDictionary.objectForKey(MIRROR_MODE).toString();
                            IMirrorStateListener iMirrorStateListener = this.mLelinkMirrorListener;
                            if (iMirrorStateListener != null) {
                                iMirrorStateListener.onMirrorModeCallback(obj);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    String obj2 = nSDictionary.objectForKey("state").toString();
                    obj2.hashCode();
                    if (!obj2.equals("stopped")) {
                        if (obj2.equals("error")) {
                            CLog.d(this.TAG, MediaError.ERROR_TYPE_ERROR);
                        }
                    } else if (nSDictionary.containsKey("reason")) {
                        String obj3 = nSDictionary.objectForKey("reason").toString();
                        if (TextUtils.equals(obj3, FORCE_STOPED)) {
                            this.mLelinkMirrorListener.onSinkStop(this.mDeviceIp, ParamsMap.MirrorParams.MIRROR_ERROR_FORCE_STOP);
                        } else if (TextUtils.equals(obj3, "preempt_stopped")) {
                            this.mLelinkMirrorListener.onSinkStop(this.mDeviceIp, ParamsMap.MirrorParams.MIRROR_ERROR_PREEMPT_STOP);
                        } else if (TextUtils.equals(obj3, SERVER_STOPED)) {
                            this.mLelinkMirrorListener.onSinkStop(this.mDeviceIp, ParamsMap.MirrorParams.MIRROR_ERROR_SERVER_STOP);
                        }
                    }
                }
            } catch (Exception e10) {
                CLog.w(this.TAG, e10);
            }
        }
    }

    @Override // com.hpplay.component.protocol.server.IRequestHandler
    public void close() {
        InputStream inputStream = this.mInputStream;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e10) {
                CLog.w(this.TAG, e10);
            }
        }
        Socket socket = this.mAcceptSocket;
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e11) {
                CLog.w(this.TAG, e11);
            }
        }
        IRequstManager iRequstManager = this.mRequstManager;
        if (iRequstManager != null) {
            iRequstManager.closed(this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x0132, code lost:
    
        r9 = r7;
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0138, code lost:
    
        if (r8 >= r5.size()) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x013a, code lost:
    
        r9 = r9 + ((byte[]) r5.get(r8)).length;
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0145, code lost:
    
        r8 = new byte[r9];
        r10 = 0;
        r11 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x014d, code lost:
    
        if (r10 >= r5.size()) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x014f, code lost:
    
        java.lang.System.arraycopy(r5.get(r10), 0, r8, r11, ((byte[]) r5.get(r10)).length);
        r11 = r11 + ((byte[]) r5.get(r10)).length;
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0168, code lost:
    
        java.lang.System.arraycopy(r3, 0, r8, r11, r7);
        r3 = new java.lang.String(r8, 0, r9);
        com.hpplay.component.common.utils.CLog.i(r14.TAG, r3);
        parseMirrorEvent(r3);
        r1.write(com.hpplay.component.protocol.NLProtocolBuiler.RESPONSE_OK.getBytes());
        r1.close();
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        try {
            try {
                OutputStream outputStream = this.mAcceptSocket.getOutputStream();
                byte[] bArr = new byte[11];
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                int i10 = 0;
                loop0: while (true) {
                    boolean z10 = false;
                    while (true) {
                        if (this.mAcceptSocket.isClosed()) {
                            break loop0;
                        }
                        try {
                            i10 = this.mInputStream.read(bArr);
                        } catch (Exception e10) {
                            CLog.w(this.TAG, e10);
                        }
                        if (i10 > 0) {
                            boolean z11 = true;
                            if (bArr.length == 1) {
                                arrayList.add(Byte.valueOf(bArr[0]));
                                if (ProtocolUtils.getProtocolDivide(arrayList)) {
                                    int size = arrayList.size();
                                    byte[] bArr2 = new byte[size];
                                    for (int i11 = 0; i11 < size; i11++) {
                                        bArr2[i11] = ((Byte) arrayList.get(i11)).byteValue();
                                    }
                                    String str = new String(bArr2);
                                    CLog.d("header", "" + str);
                                    try {
                                        int contentLength = ProtocolUtils.getContentLength(str);
                                        CLog.d(this.TAG, "contentLength" + contentLength + "");
                                        if (contentLength <= 0 || contentLength >= 2097152) {
                                            bArr = new byte[11];
                                            arrayList.clear();
                                        } else {
                                            bArr = new byte[contentLength];
                                            arrayList.clear();
                                        }
                                    } catch (Exception e11) {
                                        CLog.w(this.TAG, e11);
                                        bArr = new byte[11];
                                    }
                                }
                            } else if (bArr.length != 11 || z10) {
                                arrayList.clear();
                                try {
                                    if (i10 >= bArr.length) {
                                        break;
                                    }
                                    CLog.d(this.TAG, "---------------------->" + bArr.length + "  ----------------   " + i10);
                                    byte[] bArr3 = new byte[i10];
                                    System.arraycopy(bArr, 0, bArr3, 0, i10);
                                    arrayList2.add(bArr3);
                                    int length = bArr.length - i10;
                                    byte[] bArr4 = new byte[length];
                                    if (length != 11) {
                                        z11 = false;
                                    }
                                    bArr = bArr4;
                                    z10 = z11;
                                } catch (Exception e12) {
                                    CLog.w(this.TAG, e12);
                                    bArr = new byte[11];
                                    arrayList2.clear();
                                }
                            } else {
                                try {
                                    arrayList.clear();
                                    String str2 = new String(bArr, 0, bArr.length);
                                    if (str2.equals(KEY_HEADER_EVENT) || str2.equals(KEY_HEADER_HARDBET) || str2.equals(KEY_HEADER_PHOTO_STATE)) {
                                        for (byte b10 : bArr) {
                                            arrayList.add(Byte.valueOf(b10));
                                        }
                                    }
                                    CLog.d(this.TAG, str2);
                                } catch (Exception e13) {
                                    CLog.w(this.TAG, e13);
                                }
                                bArr = new byte[1];
                            }
                        }
                    }
                }
            } finally {
                close();
            }
        } catch (Exception e14) {
            CLog.w(this.TAG, e14);
        }
    }
}
