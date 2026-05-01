package com.hpplay.component.dlna;

import android.text.TextUtils;
import com.hpplay.component.common.dlna.IDLNAController;
import com.hpplay.component.common.protocol.ProtocolListener;
import com.hpplay.component.common.utils.CLog;
import com.hpplay.cybergarage.upnp.Device;
import com.hpplay.cybergarage.upnp.UPnP;
import com.hpplay.cybergarage.upnp.event.EventListener;
import com.hpplay.cybergarage.xml.Node;
import com.hpplay.cybergarage.xml.XML;
import com.hpplay.cybergarage.xml.parser.XmlPullParser;
import java.io.ByteArrayInputStream;

/* loaded from: classes2.dex */
public class DLNAControllerImp implements IDLNAController {
    private static final String CMD_TAG = "LLL@BBB";
    public static final String LOADING = "loading";
    public static final String PAUSED = "PAUSED_PLAYBACK";
    public static final String PLAYING = "PLAYING";
    public static final String RESULT_FAILED = "failed";
    public static final String RESULT_SUCCESSFUL = "successful";
    public static final String STOPPED = "STOPPED";
    private static final String TAG = "DLNAControllerImp";
    private static boolean isRetryHttp;
    private int instanceId;
    private boolean isPlaying;
    private Device mCurrentDevce;
    private String mCurrentUrl;
    private int mCurrentVolume;
    private DLNASender mDlnaSender;
    private ProtocolListener mProtocolListener;
    private String mUuid;
    private int mMaxVolume = 100;
    private final EventListener eventListener = new EventListener() { // from class: com.hpplay.component.dlna.DLNAControllerImp.1
        @Override // com.hpplay.cybergarage.upnp.event.EventListener
        public void eventNotifyReceived(String str, long j10, String str2, String str3) {
            CLog.i(DLNAControllerImp.TAG, " ====================>> value:" + str2 + " uuid " + str);
            if (TextUtils.isEmpty(str3)) {
                return;
            }
            if (str3.contains(DLNAControllerImp.PLAYING)) {
                if (DLNAControllerImp.this.mProtocolListener != null && !DLNAControllerImp.this.isPlaying) {
                    DLNAControllerImp.this.isPlaying = true;
                    DLNAControllerImp.this.mProtocolListener.onResult(13, DLNAControllerImp.this.parseUrl(str3), str, String.valueOf(DLNAControllerImp.this.instanceId));
                }
                CLog.i(DLNAControllerImp.TAG, " PLAYING " + DLNAControllerImp.this.instanceId);
            } else if (str3.contains(DLNAControllerImp.PAUSED)) {
                CLog.i(DLNAControllerImp.TAG, " PAUSED ");
                DLNAControllerImp.this.isPlaying = false;
                if (DLNAControllerImp.this.mProtocolListener != null) {
                    DLNAControllerImp.this.mProtocolListener.onResult(15, new String[0]);
                }
            } else if (str3.contains(DLNAControllerImp.STOPPED)) {
                CLog.i(DLNAControllerImp.TAG, " STOPPED " + DLNAControllerImp.this.instanceId);
                DLNAControllerImp.this.isPlaying = false;
                if (DLNAControllerImp.this.mProtocolListener != null) {
                    DLNAControllerImp.this.mProtocolListener.onResult(16, DLNAControllerImp.this.parseUrl(str3), str, String.valueOf(DLNAControllerImp.this.instanceId));
                }
            }
            DLNAControllerImp.this.mUuid = str;
        }
    };

    private Device getDevice(Node node) {
        Node node2;
        if (node == null || (node2 = node.getNode(Device.ELEM_NAME)) == null) {
            return null;
        }
        return new Device(node, node2);
    }

    private void init(String str) {
        this.mCurrentVolume = this.mDlnaSender.getVoice();
        UPNPSubscriber.getInstance().startSubscribeServ(str);
        UPNPSubscriber.getInstance().setSubscribeEventListener(this.eventListener);
        CLog.i(TAG, " subscribePlayEvent ----------- >  " + UPNPSubscriber.getInstance().subscribePlayEvent(this.mCurrentDevce));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String parseUrl(String str) {
        String str2 = "";
        try {
            Node node = new XmlPullParser().parse(new ByteArrayInputStream(str.getBytes())).getNode("InstanceID").getNode("AVTransportURI");
            if (node == null) {
                return "";
            }
            str2 = node.getAttribute("val").getValue();
            CLog.i(TAG, str2);
            return str2;
        } catch (Exception e10) {
            CLog.w(TAG, e10);
            return str2;
        }
    }

    @Override // com.hpplay.component.common.dlna.IDLNAController
    public String close() {
        CLog.i(TAG, " close " + this.instanceId);
        UPNPSubscriber.getInstance().removeSubscribeEventListener(this.eventListener);
        UPNPSubscriber.getInstance().unSubscribe(this.mCurrentDevce);
        this.isPlaying = false;
        this.mDlnaSender = null;
        this.mCurrentDevce = null;
        return null;
    }

    @Override // com.hpplay.component.common.dlna.IDLNAController
    public boolean connect(String str, String str2, ProtocolListener protocolListener) {
        try {
            this.instanceId = hashCode();
            CLog.i(TAG, "--------------------------- >  connect");
            Device device = getDevice(UPnP.getXMLParser().parseUrl(str));
            this.mCurrentDevce = device;
            if (device == null) {
                return false;
            }
            device.setLocation(str);
            CLog.i(TAG, this.mCurrentDevce.getFriendlyName() + " getManufacture :" + this.mCurrentDevce.getManufacture() + " getManufactureURL: " + this.mCurrentDevce.getManufactureURL());
            DLNASender dLNASender = new DLNASender(this.mCurrentDevce, str2);
            this.mDlnaSender = dLNASender;
            dLNASender.retryHttpSwitch(isRetryHttp);
            this.mProtocolListener = protocolListener;
            init(str2);
            return true;
        } catch (Exception e10) {
            CLog.w(TAG, e10);
            return false;
        }
    }

    public String escapeXMLChars(String str) {
        return XML.escapeXMLChars(str);
    }

    public void retryHttp(boolean z10) {
        isRetryHttp = z10;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0100 A[Catch: Exception -> 0x0201, TRY_ENTER, TryCatch #2 {Exception -> 0x0201, blocks: (B:3:0x002a, B:9:0x00f4, B:12:0x0100, B:17:0x014a, B:19:0x014e, B:20:0x0150, B:22:0x0158, B:23:0x015a, B:24:0x0181, B:26:0x0187, B:27:0x01ac, B:28:0x018a, B:29:0x01b5, B:30:0x01bc, B:31:0x01d0, B:32:0x01d9, B:33:0x01e0, B:34:0x01e6, B:36:0x01ee, B:38:0x01f4, B:42:0x01fe, B:47:0x0108, B:50:0x0112, B:53:0x011a, B:56:0x0124, B:59:0x012e, B:62:0x0138, B:81:0x00b7, B:6:0x00bb, B:8:0x00c3, B:66:0x00d4, B:68:0x00dc), top: B:2:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x014a A[Catch: Exception -> 0x0201, TRY_ENTER, TryCatch #2 {Exception -> 0x0201, blocks: (B:3:0x002a, B:9:0x00f4, B:12:0x0100, B:17:0x014a, B:19:0x014e, B:20:0x0150, B:22:0x0158, B:23:0x015a, B:24:0x0181, B:26:0x0187, B:27:0x01ac, B:28:0x018a, B:29:0x01b5, B:30:0x01bc, B:31:0x01d0, B:32:0x01d9, B:33:0x01e0, B:34:0x01e6, B:36:0x01ee, B:38:0x01f4, B:42:0x01fe, B:47:0x0108, B:50:0x0112, B:53:0x011a, B:56:0x0124, B:59:0x012e, B:62:0x0138, B:81:0x00b7, B:6:0x00bb, B:8:0x00c3, B:66:0x00d4, B:68:0x00dc), top: B:2:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0181 A[Catch: Exception -> 0x0201, TryCatch #2 {Exception -> 0x0201, blocks: (B:3:0x002a, B:9:0x00f4, B:12:0x0100, B:17:0x014a, B:19:0x014e, B:20:0x0150, B:22:0x0158, B:23:0x015a, B:24:0x0181, B:26:0x0187, B:27:0x01ac, B:28:0x018a, B:29:0x01b5, B:30:0x01bc, B:31:0x01d0, B:32:0x01d9, B:33:0x01e0, B:34:0x01e6, B:36:0x01ee, B:38:0x01f4, B:42:0x01fe, B:47:0x0108, B:50:0x0112, B:53:0x011a, B:56:0x0124, B:59:0x012e, B:62:0x0138, B:81:0x00b7, B:6:0x00bb, B:8:0x00c3, B:66:0x00d4, B:68:0x00dc), top: B:2:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x01b5 A[Catch: Exception -> 0x0201, TryCatch #2 {Exception -> 0x0201, blocks: (B:3:0x002a, B:9:0x00f4, B:12:0x0100, B:17:0x014a, B:19:0x014e, B:20:0x0150, B:22:0x0158, B:23:0x015a, B:24:0x0181, B:26:0x0187, B:27:0x01ac, B:28:0x018a, B:29:0x01b5, B:30:0x01bc, B:31:0x01d0, B:32:0x01d9, B:33:0x01e0, B:34:0x01e6, B:36:0x01ee, B:38:0x01f4, B:42:0x01fe, B:47:0x0108, B:50:0x0112, B:53:0x011a, B:56:0x0124, B:59:0x012e, B:62:0x0138, B:81:0x00b7, B:6:0x00bb, B:8:0x00c3, B:66:0x00d4, B:68:0x00dc), top: B:2:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x01bc A[Catch: Exception -> 0x0201, TryCatch #2 {Exception -> 0x0201, blocks: (B:3:0x002a, B:9:0x00f4, B:12:0x0100, B:17:0x014a, B:19:0x014e, B:20:0x0150, B:22:0x0158, B:23:0x015a, B:24:0x0181, B:26:0x0187, B:27:0x01ac, B:28:0x018a, B:29:0x01b5, B:30:0x01bc, B:31:0x01d0, B:32:0x01d9, B:33:0x01e0, B:34:0x01e6, B:36:0x01ee, B:38:0x01f4, B:42:0x01fe, B:47:0x0108, B:50:0x0112, B:53:0x011a, B:56:0x0124, B:59:0x012e, B:62:0x0138, B:81:0x00b7, B:6:0x00bb, B:8:0x00c3, B:66:0x00d4, B:68:0x00dc), top: B:2:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x01d0 A[Catch: Exception -> 0x0201, TryCatch #2 {Exception -> 0x0201, blocks: (B:3:0x002a, B:9:0x00f4, B:12:0x0100, B:17:0x014a, B:19:0x014e, B:20:0x0150, B:22:0x0158, B:23:0x015a, B:24:0x0181, B:26:0x0187, B:27:0x01ac, B:28:0x018a, B:29:0x01b5, B:30:0x01bc, B:31:0x01d0, B:32:0x01d9, B:33:0x01e0, B:34:0x01e6, B:36:0x01ee, B:38:0x01f4, B:42:0x01fe, B:47:0x0108, B:50:0x0112, B:53:0x011a, B:56:0x0124, B:59:0x012e, B:62:0x0138, B:81:0x00b7, B:6:0x00bb, B:8:0x00c3, B:66:0x00d4, B:68:0x00dc), top: B:2:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01d9 A[Catch: Exception -> 0x0201, TryCatch #2 {Exception -> 0x0201, blocks: (B:3:0x002a, B:9:0x00f4, B:12:0x0100, B:17:0x014a, B:19:0x014e, B:20:0x0150, B:22:0x0158, B:23:0x015a, B:24:0x0181, B:26:0x0187, B:27:0x01ac, B:28:0x018a, B:29:0x01b5, B:30:0x01bc, B:31:0x01d0, B:32:0x01d9, B:33:0x01e0, B:34:0x01e6, B:36:0x01ee, B:38:0x01f4, B:42:0x01fe, B:47:0x0108, B:50:0x0112, B:53:0x011a, B:56:0x0124, B:59:0x012e, B:62:0x0138, B:81:0x00b7, B:6:0x00bb, B:8:0x00c3, B:66:0x00d4, B:68:0x00dc), top: B:2:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01e0 A[Catch: Exception -> 0x0201, TryCatch #2 {Exception -> 0x0201, blocks: (B:3:0x002a, B:9:0x00f4, B:12:0x0100, B:17:0x014a, B:19:0x014e, B:20:0x0150, B:22:0x0158, B:23:0x015a, B:24:0x0181, B:26:0x0187, B:27:0x01ac, B:28:0x018a, B:29:0x01b5, B:30:0x01bc, B:31:0x01d0, B:32:0x01d9, B:33:0x01e0, B:34:0x01e6, B:36:0x01ee, B:38:0x01f4, B:42:0x01fe, B:47:0x0108, B:50:0x0112, B:53:0x011a, B:56:0x0124, B:59:0x012e, B:62:0x0138, B:81:0x00b7, B:6:0x00bb, B:8:0x00c3, B:66:0x00d4, B:68:0x00dc), top: B:2:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0108 A[Catch: Exception -> 0x0201, TryCatch #2 {Exception -> 0x0201, blocks: (B:3:0x002a, B:9:0x00f4, B:12:0x0100, B:17:0x014a, B:19:0x014e, B:20:0x0150, B:22:0x0158, B:23:0x015a, B:24:0x0181, B:26:0x0187, B:27:0x01ac, B:28:0x018a, B:29:0x01b5, B:30:0x01bc, B:31:0x01d0, B:32:0x01d9, B:33:0x01e0, B:34:0x01e6, B:36:0x01ee, B:38:0x01f4, B:42:0x01fe, B:47:0x0108, B:50:0x0112, B:53:0x011a, B:56:0x0124, B:59:0x012e, B:62:0x0138, B:81:0x00b7, B:6:0x00bb, B:8:0x00c3, B:66:0x00d4, B:68:0x00dc), top: B:2:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0112 A[Catch: Exception -> 0x0201, TryCatch #2 {Exception -> 0x0201, blocks: (B:3:0x002a, B:9:0x00f4, B:12:0x0100, B:17:0x014a, B:19:0x014e, B:20:0x0150, B:22:0x0158, B:23:0x015a, B:24:0x0181, B:26:0x0187, B:27:0x01ac, B:28:0x018a, B:29:0x01b5, B:30:0x01bc, B:31:0x01d0, B:32:0x01d9, B:33:0x01e0, B:34:0x01e6, B:36:0x01ee, B:38:0x01f4, B:42:0x01fe, B:47:0x0108, B:50:0x0112, B:53:0x011a, B:56:0x0124, B:59:0x012e, B:62:0x0138, B:81:0x00b7, B:6:0x00bb, B:8:0x00c3, B:66:0x00d4, B:68:0x00dc), top: B:2:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x011a A[Catch: Exception -> 0x0201, TryCatch #2 {Exception -> 0x0201, blocks: (B:3:0x002a, B:9:0x00f4, B:12:0x0100, B:17:0x014a, B:19:0x014e, B:20:0x0150, B:22:0x0158, B:23:0x015a, B:24:0x0181, B:26:0x0187, B:27:0x01ac, B:28:0x018a, B:29:0x01b5, B:30:0x01bc, B:31:0x01d0, B:32:0x01d9, B:33:0x01e0, B:34:0x01e6, B:36:0x01ee, B:38:0x01f4, B:42:0x01fe, B:47:0x0108, B:50:0x0112, B:53:0x011a, B:56:0x0124, B:59:0x012e, B:62:0x0138, B:81:0x00b7, B:6:0x00bb, B:8:0x00c3, B:66:0x00d4, B:68:0x00dc), top: B:2:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0124 A[Catch: Exception -> 0x0201, TryCatch #2 {Exception -> 0x0201, blocks: (B:3:0x002a, B:9:0x00f4, B:12:0x0100, B:17:0x014a, B:19:0x014e, B:20:0x0150, B:22:0x0158, B:23:0x015a, B:24:0x0181, B:26:0x0187, B:27:0x01ac, B:28:0x018a, B:29:0x01b5, B:30:0x01bc, B:31:0x01d0, B:32:0x01d9, B:33:0x01e0, B:34:0x01e6, B:36:0x01ee, B:38:0x01f4, B:42:0x01fe, B:47:0x0108, B:50:0x0112, B:53:0x011a, B:56:0x0124, B:59:0x012e, B:62:0x0138, B:81:0x00b7, B:6:0x00bb, B:8:0x00c3, B:66:0x00d4, B:68:0x00dc), top: B:2:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x012e A[Catch: Exception -> 0x0201, TryCatch #2 {Exception -> 0x0201, blocks: (B:3:0x002a, B:9:0x00f4, B:12:0x0100, B:17:0x014a, B:19:0x014e, B:20:0x0150, B:22:0x0158, B:23:0x015a, B:24:0x0181, B:26:0x0187, B:27:0x01ac, B:28:0x018a, B:29:0x01b5, B:30:0x01bc, B:31:0x01d0, B:32:0x01d9, B:33:0x01e0, B:34:0x01e6, B:36:0x01ee, B:38:0x01f4, B:42:0x01fe, B:47:0x0108, B:50:0x0112, B:53:0x011a, B:56:0x0124, B:59:0x012e, B:62:0x0138, B:81:0x00b7, B:6:0x00bb, B:8:0x00c3, B:66:0x00d4, B:68:0x00dc), top: B:2:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0138 A[Catch: Exception -> 0x0201, TRY_LEAVE, TryCatch #2 {Exception -> 0x0201, blocks: (B:3:0x002a, B:9:0x00f4, B:12:0x0100, B:17:0x014a, B:19:0x014e, B:20:0x0150, B:22:0x0158, B:23:0x015a, B:24:0x0181, B:26:0x0187, B:27:0x01ac, B:28:0x018a, B:29:0x01b5, B:30:0x01bc, B:31:0x01d0, B:32:0x01d9, B:33:0x01e0, B:34:0x01e6, B:36:0x01ee, B:38:0x01f4, B:42:0x01fe, B:47:0x0108, B:50:0x0112, B:53:0x011a, B:56:0x0124, B:59:0x012e, B:62:0x0138, B:81:0x00b7, B:6:0x00bb, B:8:0x00c3, B:66:0x00d4, B:68:0x00dc), top: B:2:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0142  */
    @Override // com.hpplay.component.common.dlna.IDLNAController
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String[] sendAction(java.lang.String r17) {
        /*
            Method dump skipped, instructions count: 594
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.component.dlna.DLNAControllerImp.sendAction(java.lang.String):java.lang.String[]");
    }
}
