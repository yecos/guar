package com.hpplay.component.protocol;

import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hpplay.component.common.utils.CLog;
import com.hpplay.component.protocol.encrypt.LelinkEncrypt;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Random;

/* loaded from: classes2.dex */
public class ProtocolCore {
    public static final String BROADCAST_IP_NAME = "255.255.255.255";
    private static final int BROWSE_PORT = 25353;
    private static final int DATA_PACKET_LENGTH = 256;
    public static final String ERR_MSG_DETAIL = "sink is not response";
    private static final int RECEIVE_DATA_PACKET_LENGTH = 2048;
    private static final String TAG = "ProtocolCreater";
    private static final int TCP_KEEP_ALIVE_TIMEOUT = 30000;
    private static final int TCP_READ_DATA_TIMEOUT = 10000;
    private static final int TCP_TIMEOUT = 30000;
    public static boolean USE_LOOPBACK_ADDR = false;
    public static boolean USE_ONLY_IPV4_ADDR = true;
    public static boolean USE_ONLY_IPV6_ADDR = false;
    private static String ifAddress = "";
    public DatagramSocket mBrowseBroadCast;
    public DatagramSocket mBrowseServSocket;
    public String mIP;
    public ParcelFileDescriptor.AutoCloseInputStream mLocalAutoCloseInputStream;
    public FileDescriptor mLocalFileDescriptor;
    public FileOutputStream mLocalFileOutputStream;
    public ServerSocket mMirrorEventServer;
    public ParcelFileDescriptor mPfd;
    public int mPort;
    private static byte[] data = new byte[256];
    private static byte[] rcData = new byte[2048];
    public static final Random random = new Random();
    public Socket mSocket = null;
    private DatagramPacket mBrowsePacket = new DatagramPacket(data, 256);
    public DatagramPacket mReceiverPacket = new DatagramPacket(rcData, 2048);
    public String mErrorMsg = "unknow";
    public int mErrorCode = 0;

    private void bindLocal(Socket socket, InetAddress inetAddress) {
        try {
            try {
                socket.bind(new InetSocketAddress(inetAddress, getAvailablePort()));
            } catch (Exception unused) {
                socket.bind(new InetSocketAddress(inetAddress, getAvailablePort()));
            }
        } catch (Exception unused2) {
            socket.bind(new InetSocketAddress(inetAddress, getAvailablePort()));
        }
    }

    public static int getAvailablePort() {
        int i10 = 10090;
        try {
            Random random2 = random;
            i10 = random2.nextInt(1000) + random2.nextInt(10000) + 10000;
            for (int i11 = i10; i11 <= 65535; i11++) {
                try {
                    new ServerSocket(i11).close();
                    CLog.i(TAG, "get availabel port " + i11);
                    return i11;
                } catch (IOException unused) {
                }
            }
        } catch (Exception e10) {
            CLog.w(TAG, e10);
        }
        return i10;
    }

    public static String getHostAddress(int i10) {
        if (hasAssignedInterface()) {
            return getInterface();
        }
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            int i11 = 0;
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (isUsableAddress(nextElement)) {
                        if (i11 >= i10) {
                            return nextElement.getHostAddress();
                        }
                        i11++;
                    }
                }
            }
            return "";
        } catch (Exception e10) {
            CLog.w(TAG, e10);
            return "";
        }
    }

    public static final String getInterface() {
        return ifAddress;
    }

    public static int getNHostAddresses() {
        if (hasAssignedInterface()) {
            return 1;
        }
        int i10 = 0;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    if (isUsableAddress(inetAddresses.nextElement())) {
                        i10++;
                    }
                }
            }
        } catch (Exception e10) {
            CLog.d(TAG, null, e10);
        }
        return i10;
    }

    private static boolean hasAssignedInterface() {
        return ifAddress.length() > 0;
    }

    private static boolean isUsableAddress(InetAddress inetAddress) {
        if (!USE_LOOPBACK_ADDR && inetAddress.isLoopbackAddress()) {
            return false;
        }
        if (USE_ONLY_IPV4_ADDR && (inetAddress instanceof Inet6Address)) {
            return false;
        }
        return (USE_ONLY_IPV6_ADDR && (inetAddress instanceof Inet4Address)) ? false : true;
    }

    private static String matchLocalIp(String str) {
        int i10;
        String substring;
        int nHostAddresses;
        String str2 = null;
        try {
            substring = str.substring(0, str.lastIndexOf("."));
            nHostAddresses = getNHostAddresses();
        } catch (Exception e10) {
            CLog.w(TAG, e10);
        }
        if (nHostAddresses < 2) {
            return null;
        }
        for (i10 = 0; i10 < nHostAddresses; i10++) {
            String hostAddress = getHostAddress(i10);
            if (hostAddress.contains(substring)) {
                str2 = hostAddress;
            }
            CLog.i(TAG, "check local host ====> " + hostAddress.replace(".", ""));
        }
        return str2;
    }

    public boolean checkEncrypt(LelinkEncrypt lelinkEncrypt, String str) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            long currentTimeMillis2 = System.currentTimeMillis();
            if (!TextUtils.isEmpty(lelinkEncrypt.getSrpPassword())) {
                byte[] interactiveData = interactiveData(lelinkEncrypt.genPlayInfoRequest());
                if (interactiveData == null) {
                    return false;
                }
                CLog.d("dataa2", new String(interactiveData));
                if (!lelinkEncrypt.parsePlayerInfoResponse(interactiveData)) {
                    return false;
                }
            }
            byte[] genSetupRequest = lelinkEncrypt.genSetupRequest();
            long currentTimeMillis3 = System.currentTimeMillis() - currentTimeMillis;
            byte[] interactiveData2 = interactiveData(genSetupRequest);
            CLog.i(str + "utime", "genSetupRequest  " + (System.currentTimeMillis() - currentTimeMillis2));
            if (interactiveData2 == null) {
                return false;
            }
            CLog.d(str + "utime", " start parseSetupResponse ");
            if (!lelinkEncrypt.parseSetupResponse(interactiveData2)) {
                return false;
            }
            CLog.i(str + "utime", "parseSetupResponse  " + (System.currentTimeMillis() - currentTimeMillis2));
            long currentTimeMillis4 = System.currentTimeMillis();
            long currentTimeMillis5 = System.currentTimeMillis();
            byte[] genVerrifyM1Request = lelinkEncrypt.genVerrifyM1Request();
            long currentTimeMillis6 = currentTimeMillis3 + (System.currentTimeMillis() - currentTimeMillis5);
            byte[] interactiveData3 = interactiveData(genVerrifyM1Request);
            if (interactiveData3 == null) {
                return false;
            }
            CLog.i(str + "utime", "genVerrifyM1Request  " + (System.currentTimeMillis() - currentTimeMillis4));
            long currentTimeMillis7 = System.currentTimeMillis();
            long currentTimeMillis8 = System.currentTimeMillis();
            boolean parseVerifyM1Response = lelinkEncrypt.parseVerifyM1Response(interactiveData3);
            long currentTimeMillis9 = currentTimeMillis6 + (System.currentTimeMillis() - currentTimeMillis8);
            if (!parseVerifyM1Response) {
                return false;
            }
            CLog.i(str + "utime", "parseVerifyM1Response  " + (System.currentTimeMillis() - currentTimeMillis7));
            long currentTimeMillis10 = System.currentTimeMillis();
            long currentTimeMillis11 = System.currentTimeMillis();
            byte[] genVerrifyM2Request = lelinkEncrypt.genVerrifyM2Request();
            long currentTimeMillis12 = currentTimeMillis9 + (System.currentTimeMillis() - currentTimeMillis11);
            byte[] interactiveData4 = interactiveData(genVerrifyM2Request);
            if (interactiveData4 == null) {
                return false;
            }
            boolean parseVerifyM2Response = lelinkEncrypt.parseVerifyM2Response(interactiveData4);
            CLog.i(str + "utime", "parseVerifyM2Response   " + (System.currentTimeMillis() - currentTimeMillis10));
            long currentTimeMillis13 = currentTimeMillis12 + (System.currentTimeMillis() - currentTimeMillis);
            CLog.d(str + "utime", "encrypt time -->" + currentTimeMillis13);
            CLog.d(str + "utime", "parseVerifyM2Response  " + (System.currentTimeMillis() - currentTimeMillis10));
            CLog.d(str + "utime", "net time " + ((System.currentTimeMillis() - currentTimeMillis) - currentTimeMillis13));
            return parseVerifyM2Response;
        } catch (Exception e10) {
            CLog.w(str, e10);
            return false;
        }
    }

    public void closeBrowseBroadCast() {
        DatagramSocket datagramSocket = this.mBrowseBroadCast;
        if (datagramSocket != null) {
            datagramSocket.close();
        }
    }

    public boolean connectServer() {
        return connectServer(30000);
    }

    public boolean createBroadCast() {
        try {
            DatagramSocket datagramSocket = new DatagramSocket((SocketAddress) null);
            this.mBrowseBroadCast = datagramSocket;
            datagramSocket.setBroadcast(true);
            return true;
        } catch (SocketException e10) {
            CLog.w(TAG, e10);
            return false;
        }
    }

    public boolean createMirrorEventServer(String str, int i10) {
        try {
            ServerSocket serverSocket = new ServerSocket();
            this.mMirrorEventServer = serverSocket;
            serverSocket.setReuseAddress(true);
            if (TextUtils.isEmpty(str)) {
                this.mMirrorEventServer.bind(new InetSocketAddress(i10));
            } else {
                this.mMirrorEventServer.bind(new InetSocketAddress(str, i10));
            }
            return true;
        } catch (Exception e10) {
            CLog.w(TAG, e10);
            return false;
        }
    }

    public boolean createMirrorSocket(String str, int i10) {
        try {
            String matchLocalIp = matchLocalIp(str);
            this.mSocket = new Socket();
            if (TextUtils.isEmpty(matchLocalIp)) {
                this.mSocket.connect(new InetSocketAddress(str, i10), 30000);
            } else {
                InetAddress byName = InetAddress.getByName(str);
                InetAddress.getByName(matchLocalIp);
                this.mSocket.connect(new InetSocketAddress(byName, i10), 30000);
            }
            this.mSocket.setSoTimeout(30000);
            this.mSocket.setPerformancePreferences(2, 1, 3);
            this.mSocket.setTrafficClass(24);
            this.mSocket.setPerformancePreferences(0, 1, 2);
            this.mSocket.setReuseAddress(true);
            this.mPfd = ParcelFileDescriptor.fromSocket(this.mSocket);
            this.mLocalAutoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(this.mPfd);
            this.mLocalFileDescriptor = this.mPfd.getFileDescriptor();
            this.mLocalFileOutputStream = new FileOutputStream(this.mLocalFileDescriptor);
            return true;
        } catch (Exception e10) {
            CLog.w(TAG, e10);
            return false;
        }
    }

    public boolean createUDPServer() {
        try {
            DatagramSocket datagramSocket = new DatagramSocket((SocketAddress) null);
            this.mBrowseServSocket = datagramSocket;
            datagramSocket.setReuseAddress(true);
            this.mBrowseServSocket.bind(new InetSocketAddress(25353));
            return true;
        } catch (SocketException e10) {
            CLog.w(TAG, e10);
            return false;
        }
    }

    public ParcelFileDescriptor.AutoCloseInputStream getInputStream() {
        return this.mLocalAutoCloseInputStream;
    }

    public byte[] interactiveData(byte[]... bArr) {
        ArrayList arrayList = new ArrayList();
        String str = null;
        if (this.mLocalFileOutputStream == null) {
            return null;
        }
        for (byte[] bArr2 : bArr) {
            this.mLocalFileOutputStream.write(bArr2);
        }
        this.mLocalFileOutputStream.flush();
        long currentTimeMillis = System.currentTimeMillis();
        byte[] bArr3 = new byte[1];
        byte[] bArr4 = null;
        int i10 = 0;
        while (System.currentTimeMillis() - currentTimeMillis < NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS) {
            if (((str != null || this.mLocalAutoCloseInputStream.available() <= 0) ? 0 : this.mLocalAutoCloseInputStream.read(bArr3, 0, 1)) > 0) {
                arrayList.add(Byte.valueOf(bArr3[0]));
                if (ProtocolUtils.getProtocolDivide(arrayList)) {
                    int size = arrayList.size();
                    byte[] bArr5 = new byte[size];
                    for (int i11 = 0; i11 < size; i11++) {
                        bArr5[i11] = ((Byte) arrayList.get(i11)).byteValue();
                    }
                    String str2 = new String(bArr5);
                    int contentLength = ProtocolUtils.getContentLength(str2);
                    byte[] bArr6 = new byte[size + contentLength];
                    System.arraycopy(bArr5, 0, bArr6, 0, size);
                    if (contentLength != 0) {
                        int available = this.mLocalAutoCloseInputStream.available();
                        this.mLocalAutoCloseInputStream.read(bArr6, size, available);
                        if (available != contentLength) {
                            int i12 = size + available;
                            bArr4 = bArr6;
                            i10 = i12;
                            str = str2;
                        }
                    }
                    return bArr6;
                }
                continue;
            } else if (bArr4 != null) {
                int available2 = this.mLocalAutoCloseInputStream.available();
                this.mLocalAutoCloseInputStream.read(bArr4, i10, available2);
                i10 += available2;
                if (i10 == bArr4.length) {
                    return bArr4;
                }
            } else {
                continue;
            }
        }
        return bArr4;
    }

    public byte[] interactiveDataNoHeader(byte[]... bArr) {
        try {
            ArrayList arrayList = new ArrayList();
            if (this.mLocalFileOutputStream != null) {
                for (byte[] bArr2 : bArr) {
                    this.mLocalFileOutputStream.write(bArr2);
                }
                this.mLocalFileOutputStream.flush();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] bArr3 = new byte[1];
                String str = null;
                byte[] bArr4 = null;
                int i10 = 0;
                while (System.currentTimeMillis() - currentTimeMillis < NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS) {
                    if (((str != null || this.mLocalAutoCloseInputStream.available() <= 0) ? 0 : this.mLocalAutoCloseInputStream.read(bArr3, 0, 1)) > 0 && i10 == 0) {
                        arrayList.add(Byte.valueOf(bArr3[0]));
                        if (ProtocolUtils.getProtocolDivide(arrayList)) {
                            int size = arrayList.size();
                            byte[] bArr5 = new byte[size];
                            for (int i11 = 0; i11 < size; i11++) {
                                bArr5[i11] = ((Byte) arrayList.get(i11)).byteValue();
                            }
                            str = new String(bArr5);
                            int contentLength = ProtocolUtils.getContentLength(str);
                            byte[] bArr6 = new byte[contentLength];
                            if (contentLength != 0) {
                                int available = this.mLocalAutoCloseInputStream.available();
                                this.mLocalAutoCloseInputStream.read(bArr6, 0, available);
                                if (available != contentLength) {
                                    i10 += available;
                                    bArr4 = bArr6;
                                }
                            }
                            return bArr6;
                        }
                        continue;
                    } else if (bArr4 != null) {
                        int available2 = this.mLocalAutoCloseInputStream.available();
                        this.mLocalAutoCloseInputStream.read(bArr4, i10, available2);
                        i10 += available2;
                        if (i10 == bArr4.length) {
                            return bArr4;
                        }
                    } else {
                        continue;
                    }
                }
                return bArr4;
            }
        } catch (Exception e10) {
            CLog.w(TAG, e10);
        }
        return null;
    }

    public byte[] interactiveEncryptData(byte[]... bArr) {
        byte[] bArr2 = null;
        if (this.mLocalFileOutputStream != null) {
            for (byte[] bArr3 : bArr) {
                this.mLocalFileOutputStream.write(bArr3);
            }
            this.mLocalFileOutputStream.flush();
            long currentTimeMillis = System.currentTimeMillis();
            byte[] bArr4 = new byte[4];
            int i10 = 0;
            while (true) {
                if (System.currentTimeMillis() - currentTimeMillis >= NotificationOptions.SKIP_STEP_TEN_SECONDS_IN_MS) {
                    break;
                }
                if (i10 != 0 || this.mLocalAutoCloseInputStream.available() <= 4) {
                    if (i10 > 0 && this.mLocalAutoCloseInputStream.available() >= i10) {
                        this.mLocalAutoCloseInputStream.read(bArr2, 4, i10);
                        break;
                    }
                } else if (this.mLocalAutoCloseInputStream.read(bArr4, 0, 4) > 0) {
                    int bytesToInt = ProtocolUtils.bytesToInt(bArr4);
                    if (bytesToInt == 0 || bytesToInt > 2097152) {
                        break;
                    }
                    i10 = bytesToInt + 16;
                    bArr2 = new byte[i10 + 4];
                    System.arraycopy(bArr4, 0, bArr2, 0, 4);
                } else {
                    continue;
                }
            }
        }
        return bArr2;
    }

    public void sendBrowseData() {
        try {
            if (this.mBrowseBroadCast == null) {
                createBroadCast();
            }
            ProtocolBuilder protocolBuilder = new ProtocolBuilder();
            protocolBuilder.setBrowseMgcNum("PTBL");
            protocolBuilder.setBrowseXorkey("0000");
            protocolBuilder.setBrowseInfo(FirebaseAnalytics.Event.SEARCH, String.valueOf(31899), "", "");
            CLog.i(TAG, protocolBuilder.getString(true));
            byte[] protocal = protocolBuilder.getProtocal(true);
            this.mBrowsePacket.setPort(25353);
            this.mBrowsePacket.setData(protocal);
            this.mBrowsePacket.setLength(protocal.length);
            this.mBrowsePacket.setAddress(InetAddress.getByName("255.255.255.255"));
            this.mBrowseBroadCast.send(this.mBrowsePacket);
        } catch (Exception e10) {
            CLog.w(TAG, e10);
        }
    }

    public boolean tcpCheckTvState(String str, int i10) {
        return tcpCheckTvState(str, i10, 30000);
    }

    public boolean connectServer(int i10) {
        CLog.i(TAG, "========>  connect host  " + this.mIP.replace(".", "") + " port " + this.mPort + "  timeout :" + i10);
        String matchLocalIp = matchLocalIp(this.mIP);
        this.mSocket = new Socket();
        if (TextUtils.isEmpty(matchLocalIp)) {
            this.mSocket.connect(new InetSocketAddress(this.mIP, this.mPort), i10);
        } else {
            InetAddress byName = InetAddress.getByName(this.mIP);
            bindLocal(this.mSocket, InetAddress.getByName(matchLocalIp));
            this.mSocket.connect(new InetSocketAddress(byName, this.mPort), i10);
        }
        this.mSocket.setReuseAddress(true);
        this.mSocket.setSoTimeout(i10);
        this.mSocket.setPerformancePreferences(0, 1, 2);
        this.mSocket.setKeepAlive(true);
        this.mPfd = ParcelFileDescriptor.fromSocket(this.mSocket);
        this.mLocalAutoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(this.mPfd);
        this.mLocalFileDescriptor = this.mPfd.getFileDescriptor();
        this.mLocalFileOutputStream = new FileOutputStream(this.mLocalFileDescriptor);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v2, types: [java.net.Socket] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public boolean tcpCheckTvState(String str, int i10, int i11) {
        Socket socket;
        ?? r12 = 0;
        Socket socket2 = null;
        try {
            try {
                socket = new Socket();
                r12 = 1;
                r12 = 1;
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception unused) {
        }
        try {
            socket.setReuseAddress(true);
            socket.setSoTimeout(i11);
            String matchLocalIp = matchLocalIp(str);
            if (TextUtils.isEmpty(matchLocalIp)) {
                socket.connect(new InetSocketAddress(str, i10), i11);
            } else {
                InetAddress byName = InetAddress.getByName(str);
                bindLocal(socket, InetAddress.getByName(matchLocalIp));
                socket.connect(new InetSocketAddress(byName, i10), i11);
            }
            try {
                socket.close();
            } catch (IOException e10) {
                CLog.w(TAG, e10);
            }
        } catch (Exception unused2) {
            socket2 = socket;
            CLog.w(TAG, "local device : " + str.replace(".", "") + " is offline");
            if (socket2 != null) {
                try {
                    socket2.close();
                } catch (IOException e11) {
                    CLog.w(TAG, e11);
                }
            }
            r12 = 0;
            return r12;
        } catch (Throwable th2) {
            th = th2;
            r12 = socket;
            if (r12 != 0) {
                try {
                    r12.close();
                } catch (IOException e12) {
                    CLog.w(TAG, e12);
                }
            }
            throw th;
        }
        return r12;
    }
}
