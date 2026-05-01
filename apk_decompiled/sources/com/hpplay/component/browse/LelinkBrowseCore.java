package com.hpplay.component.browse;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.hpplay.component.common.utils.CLog;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class LelinkBrowseCore {
    public static final String BROADCAST_IP_NAME = "255.255.255.255";
    public static final String CRLF = "\r\n";
    private static final int DATA_PACKET_LENGTH = 256;
    private static final int RECEIVE_DATA_PACKET_LENGTH = 2048;
    private static final String TAG = "LelinkBrowseCore";
    public DatagramSocket mBrowseBroadCast;
    public DatagramSocket mBrowseServSocket;
    private static byte[] data = new byte[256];
    public static final int BROWSE_PORT = 25353;
    private static final int[] BROWSE_PORTS = {15353, BROWSE_PORT, 35353, 45353, 55353};
    private static byte[] rcData = new byte[2048];
    private DatagramPacket mBrowsePacket = new DatagramPacket(data, 256);
    public DatagramPacket mReceiverPacket = new DatagramPacket(rcData, 2048);
    private String BROWSE_MAGIC_NUM_KEY = "magic-number:";
    private String BROWSE_XOR_KEY = "xor-key:";
    public String mBrowseProtocol = "";

    public void closeBrowseBroadCast() {
        DatagramSocket datagramSocket = this.mBrowseBroadCast;
        if (datagramSocket != null) {
            datagramSocket.close();
        }
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

    public boolean createUDPServer() {
        try {
            DatagramSocket datagramSocket = new DatagramSocket((SocketAddress) null);
            this.mBrowseServSocket = datagramSocket;
            datagramSocket.setReuseAddress(true);
            this.mBrowseServSocket.bind(new InetSocketAddress(BROWSE_PORT));
            return true;
        } catch (SocketException e10) {
            CLog.w(TAG, e10);
            return false;
        }
    }

    public void sendBrowseData(int i10) {
        try {
            if (this.mBrowseBroadCast == null) {
                createBroadCast();
            }
            this.mBrowseProtocol = "";
            setBrowseMgcNum("PTBL");
            setBrowseXorkey("0000");
            setBrowseInfo(FirebaseAnalytics.Event.SEARCH, String.valueOf(31899), "", "");
            CLog.i(TAG, this.mBrowseProtocol);
            byte[] bytes = this.mBrowseProtocol.getBytes();
            this.mBrowsePacket.setPort(i10);
            this.mBrowsePacket.setAddress(InetAddress.getByName("255.255.255.255"));
            this.mBrowsePacket.setData(bytes);
            this.mBrowsePacket.setLength(bytes.length);
            this.mBrowseBroadCast.send(this.mBrowsePacket);
        } catch (Exception e10) {
            CLog.w(TAG, e10);
        }
    }

    public void setBrowseInfo(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", str);
            jSONObject.put(BrowserInfo.KEY_VER, str2);
            jSONObject.put("sign", str3);
            jSONObject.put("md5", str4);
            this.mBrowseProtocol += jSONObject.toString();
        } catch (JSONException e10) {
            CLog.w("setBrowseInfo", e10);
        }
    }

    public void setBrowseMgcNum(String str) {
        this.mBrowseProtocol += this.BROWSE_MAGIC_NUM_KEY + str + "\r\n";
    }

    public void setBrowseXorkey(String str) {
        this.mBrowseProtocol += this.BROWSE_XOR_KEY + str + "\r\n";
    }
}
