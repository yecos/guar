package com.hpplay.component.dlna;

import android.text.TextUtils;
import com.hpplay.component.common.ParamsMap;
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
import org.json.JSONObject;

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
    */
    public String[] sendAction(String str) {
        boolean z10;
        String[] split;
        char c10;
        CLog.i(TAG, "play url " + this.mCurrentUrl + "  mateData =========> " + str);
        String[] strArr = new String[1];
        try {
            if (str.startsWith(IDLNAController.PLAY)) {
                try {
                    split = str.split(CMD_TAG);
                    String str2 = split[1];
                    this.mCurrentUrl = str2;
                    z10 = this.mDlnaSender.play(str2, split[2]);
                } catch (Exception e10) {
                    e = e10;
                    z10 = false;
                }
                try {
                    if (!z10) {
                        String desc = this.mDlnaSender.getDesc();
                        String errMsg = this.mDlnaSender.getErrMsg();
                        String location = this.mDlnaSender.getLocation();
                        int errCode = this.mDlnaSender.getErrCode();
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("errMsg", ParamsMap.PushParams.KEY_LOCATION_URI + "\r\n" + location + "\r\ndesc\r\n" + desc + "\r\n" + errMsg);
                        jSONObject.put("errCode", errCode);
                        return new String[]{"failed", jSONObject.toString()};
                    }
                    if (split.length > 3) {
                        this.mDlnaSender.setStartPosition(Integer.parseInt(split[3]));
                    }
                } catch (Exception e11) {
                    e = e11;
                    CLog.w(TAG, e);
                    switch (str.hashCode()) {
                        case -1850559411:
                            break;
                        case -1218595054:
                            break;
                        case 2587682:
                            break;
                        case 76887510:
                            break;
                        case 663224269:
                            break;
                        case 726000028:
                            break;
                        case 871896033:
                            break;
                    }
                    switch (c10) {
                    }
                    if (!str.contains(IDLNAController.GET_MEDIA_INFO)) {
                        strArr[0] = z10 ? "successful" : "failed";
                    }
                    CLog.i(TAG + Thread.currentThread().getName(), strArr[0]);
                    return strArr;
                }
            } else {
                z10 = str.startsWith(IDLNAController.SET_VOLUME) ? this.mDlnaSender.setVoice(Integer.parseInt(str.split(CMD_TAG)[1])) : str.startsWith(IDLNAController.SEEK) ? this.mDlnaSender.seek(String.valueOf(Integer.parseInt(str.split(CMD_TAG)[1]) * 1000)) : false;
            }
            switch (str.hashCode()) {
                case -1850559411:
                    if (str.equals(IDLNAController.RESUME)) {
                        c10 = 1;
                        break;
                    }
                    c10 = 65535;
                    break;
                case -1218595054:
                    if (str.equals(IDLNAController.INC_VOLUME)) {
                        c10 = 5;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 2587682:
                    if (str.equals(IDLNAController.STOP)) {
                        c10 = 4;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 76887510:
                    if (str.equals(IDLNAController.PAUSE)) {
                        c10 = 0;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 663224269:
                    if (str.equals(IDLNAController.GET_POSITION_INFO)) {
                        c10 = 2;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 726000028:
                    if (str.equals(IDLNAController.DEC_VOLUME)) {
                        c10 = 6;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 871896033:
                    if (str.equals(IDLNAController.GET_TRANSPORT_INFO)) {
                        c10 = 3;
                        break;
                    }
                    c10 = 65535;
                    break;
                default:
                    c10 = 65535;
                    break;
            }
            switch (c10) {
                case 0:
                    z10 = this.mDlnaSender.pause();
                    break;
                case 1:
                    z10 = this.mDlnaSender.resume();
                    break;
                case 2:
                    strArr[0] = this.mDlnaSender.getPositionInfo();
                    break;
                case 3:
                    strArr = new String[]{this.mDlnaSender.getTransportState(), this.mCurrentUrl, this.mUuid};
                    break;
                case 4:
                    z10 = this.mDlnaSender.stop();
                    break;
                case 5:
                    int i10 = this.mCurrentVolume;
                    int i11 = this.mMaxVolume;
                    if (i10 >= i11) {
                        this.mCurrentVolume = i11;
                    } else {
                        this.mCurrentVolume = i10 + 10;
                        CLog.i(TAG, "add volume " + this.mMaxVolume + " " + this.mCurrentVolume);
                    }
                    z10 = this.mDlnaSender.setVoice(this.mCurrentVolume);
                    break;
                case 6:
                    if (this.mCurrentVolume <= 0) {
                        this.mCurrentVolume = 0;
                    }
                    int i12 = this.mCurrentVolume - 10;
                    this.mCurrentVolume = i12;
                    if (i12 < 0) {
                        this.mCurrentVolume = 0;
                    }
                    CLog.i(TAG, " remain volume " + this.mMaxVolume + " " + this.mCurrentVolume);
                    z10 = this.mDlnaSender.setVoice(this.mCurrentVolume);
                    break;
            }
            if (!str.contains(IDLNAController.GET_MEDIA_INFO) && !str.contains(IDLNAController.GET_POSITION_INFO) && !str.contains(IDLNAController.GET_TRANSPORT_INFO)) {
                strArr[0] = z10 ? "successful" : "failed";
            }
        } catch (Exception e12) {
            CLog.w(TAG, e12);
        }
        CLog.i(TAG + Thread.currentThread().getName(), strArr[0]);
        return strArr;
    }
}
