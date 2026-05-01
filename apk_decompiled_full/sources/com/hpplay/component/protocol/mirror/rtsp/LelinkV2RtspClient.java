package com.hpplay.component.protocol.mirror.rtsp;

import android.os.Build;
import android.text.TextUtils;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.common.utils.CLog;
import com.hpplay.component.protocol.NLProtocolBuiler;
import com.hpplay.component.protocol.PlistBuilder;
import com.hpplay.component.protocol.ProtocolBuilder;
import com.hpplay.component.protocol.ProtocolSender;
import com.hpplay.component.protocol.ProtocolUtils;
import com.hpplay.component.protocol.encrypt.LelinkEncrypt;
import com.hpplay.component.protocol.encrypt.MirrorFrameEcrypto;
import com.hpplay.component.protocol.mirror.VideoSender;
import com.hpplay.component.protocol.plist.NSArray;
import com.hpplay.component.protocol.plist.NSDictionary;
import com.hpplay.component.protocol.plist.NSNumber;
import com.hpplay.component.protocol.plist.PropertyListParser;

/* loaded from: classes2.dex */
public class LelinkV2RtspClient extends RtspClient {
    private static final int AUDIO_MODEL = 96;
    private static final String TAG = "LelinkV2RtspClient";
    private static final int VIDEO_MODEL = 97;
    public static int mMirrorPort;
    private int mAtv;
    private String mDeviceId;
    private String mDeviceName;
    private boolean mEncrypt;
    private String mIp;
    private LelinkEncrypt mLelinkEncrypt;
    private String mLocalip;
    private String mMac;
    private VideoSender mMirrorDataSender;
    private String mMst;
    private ProtocolSender mProtocolSender;
    private int mRudpPort;
    private String mScreenCode;
    private String mSessionId;
    private String mUid;
    private String mUri;
    private int mlelinkPort;
    private double mRefreshRate = 60.0d;
    private int mUdpServerPort = 0;
    private int cseq = 0;
    private boolean isUseAudio = false;

    public LelinkV2RtspClient(ParamsMap paramsMap) {
        this.mAtv = 0;
        this.mScreenCode = String.valueOf(paramsMap.getParam("screencode", "000000"));
        this.mUri = paramsMap.getStringParam("uri");
        try {
            this.mIDWidth = Integer.parseInt(paramsMap.getStringParam(ParamsMap.MirrorParams.KEY_PHONE_WIDTH));
            this.mIDHeight = Integer.parseInt(paramsMap.getStringParam(ParamsMap.MirrorParams.KEY_PHONE_HEIGHT));
        } catch (Exception unused) {
            this.mIDWidth = 1080;
            this.mIDHeight = 1920;
        }
        this.mMac = (String) paramsMap.getParam(ParamsMap.DeviceParams.KEY_MAC, "000000000000");
        this.mDeviceId = "0x" + this.mMac;
        this.mSessionId = paramsMap.getStringParam(ParamsMap.DeviceParams.KEY_SESSION_ID);
        this.mIp = paramsMap.getStringParam("ip");
        this.mUid = paramsMap.getCuid();
        String atv = paramsMap.getATV();
        if (!TextUtils.isEmpty(atv)) {
            this.mAtv = Integer.valueOf(atv).intValue();
        }
        this.mlelinkPort = Integer.parseInt(paramsMap.getParam(ParamsMap.DeviceParams.KEY_LELINK_PORT, "0").toString());
        this.mDeviceName = Build.MANUFACTURER + " " + Build.MODEL;
        ProtocolSender protocolSender = new ProtocolSender();
        this.mProtocolSender = protocolSender;
        protocolSender.setConnectInfo(this.mIp, this.mlelinkPort);
        this.mLocalip = ProtocolUtils.getLoaclIp();
        this.mMirrorDataSender = new VideoSender();
    }

    private String buildHeader(NLProtocolBuiler nLProtocolBuiler, int i10) {
        return nLProtocolBuiler.setPlatfrom().setUserAgent("HappyCast5,0/500.0").setNewLelinkClientId(this.mDeviceId).setNewSessionId(this.mSessionId).setNewClientUid(this.mUid).setContentType(NLProtocolBuiler.CONTENT_TYPE_PLIST).setNewCSEQ(this.cseq + "").setContentLength(i10 + "").getString(true);
    }

    private String getTeardownData(int i10) {
        String potocol = new PlistBuilder().createIPlistArray("streams", 1).addIntagerToArray("streams", 0, "type", i10).addArrayToRoot("streams").getPotocol();
        return buildHeader(new NLProtocolBuiler().getTearDownCmd(this.mLocalip, System.currentTimeMillis() + ""), potocol.length()) + potocol;
    }

    @Override // com.hpplay.component.protocol.mirror.rtsp.RtspClient
    public int exeLelinkRtsp(boolean z10, String... strArr) {
        int i10 = 0;
        try {
            int parseInt = Integer.parseInt(strArr[0]);
            String str = strArr[1];
            try {
                int sendRequestGetMirrorInfo = sendRequestGetMirrorInfo();
                try {
                    CLog.i(TAG, " sendRequestGetMirrorInfo ");
                    if (sendRequestGetMirrorInfo == 0) {
                        return sendRequestGetMirrorInfo;
                    }
                    if (sendRequestGetMirrorInfo == 10) {
                        return 211026;
                    }
                    if (sendRequestGetMirrorInfo == 12) {
                        return 211027;
                    }
                    try {
                        int sendRequestVideoSetup = sendRequestVideoSetup(parseInt, Integer.parseInt(strArr[2]));
                        if (sendRequestVideoSetup == 12) {
                            return ParamsMap.MirrorParams.MIRROR_ERROR_UNSUPPORT_PREEMPT;
                        }
                        if (sendRequestVideoSetup == 0) {
                            return ParamsMap.MirrorParams.MIRROR_ERROR_SETUP;
                        }
                        if (sendRequestVideoSetup == 13) {
                            return ParamsMap.MirrorParams.MIRROR_ERROR_FORBIDDEN;
                        }
                        if (z10) {
                            try {
                                CLog.i(TAG, "AudioSetup" + sendRequestAudioSetup());
                            } catch (Exception e10) {
                                e = e10;
                                i10 = sendRequestVideoSetup;
                                CLog.w(TAG, e);
                                this.mErrorMsg = CLog.getExceptionStr(e);
                                return i10;
                            }
                        }
                        try {
                            boolean sendRequestRecord = sendRequestRecord();
                            setMirrorMode(str);
                            CLog.i(TAG, "tRecord" + sendRequestRecord);
                            if (sendRequestRecord) {
                                return 1;
                            }
                            return ParamsMap.MirrorParams.MIRROR_ERROR_RECORD;
                        } catch (Exception e11) {
                            e = e11;
                            i10 = ParamsMap.MirrorParams.MIRROR_ERROR_RECORD;
                            CLog.w(TAG, e);
                            this.mErrorMsg = CLog.getExceptionStr(e);
                            return i10;
                        }
                    } catch (Exception e12) {
                        e = e12;
                        i10 = ParamsMap.MirrorParams.MIRROR_ERROR_SETUP;
                    }
                } catch (Exception e13) {
                    e = e13;
                    i10 = sendRequestGetMirrorInfo;
                }
            } catch (Exception e14) {
                e = e14;
                i10 = ParamsMap.MirrorParams.MIRROR_ERROR_GET_INFO;
            }
        } catch (Exception e15) {
            e = e15;
        }
    }

    @Override // com.hpplay.component.protocol.mirror.rtsp.RtspClient
    public int getAudioPort() {
        return this.mUdpServerPort;
    }

    @Override // com.hpplay.component.protocol.mirror.rtsp.RtspClient
    public String getAudioServerIp() {
        return this.mIp;
    }

    @Override // com.hpplay.component.protocol.mirror.rtsp.RtspClient
    public int getBitRate() {
        return this.mBitrate;
    }

    @Override // com.hpplay.component.protocol.mirror.rtsp.RtspClient
    public String getEncodeType() {
        return this.mEncodeType;
    }

    @Override // com.hpplay.component.protocol.mirror.rtsp.RtspClient
    public double getRefreshRate() {
        return this.mRefreshRate;
    }

    @Override // com.hpplay.component.protocol.mirror.rtsp.RtspClient
    public int getSinkHeight() {
        return this.mHeight;
    }

    @Override // com.hpplay.component.protocol.mirror.rtsp.RtspClient
    public int getSinkWidth() {
        return this.mWidth;
    }

    @Override // com.hpplay.component.protocol.mirror.rtsp.RtspClient
    public int getTvHeight() {
        return this.mTvHeight;
    }

    @Override // com.hpplay.component.protocol.mirror.rtsp.RtspClient
    public int getTvWidth() {
        return this.mTvWidth;
    }

    @Override // com.hpplay.component.protocol.mirror.rtsp.RtspClient
    public VideoSender getVideoDataSender() {
        return this.mMirrorDataSender;
    }

    @Override // com.hpplay.component.protocol.mirror.rtsp.RtspClient
    public boolean isEncrypt() {
        return this.mEncrypt;
    }

    public boolean parseMirrorInfo(String str) {
        String str2 = str.split("\r\n")[0];
        if (!TextUtils.isEmpty(str2) && str2.contains(ProtocolBuilder.LELINK_STATE_SUCCESS)) {
            this.mEncrypt = true;
            byte[] removeHeader = ProtocolUtils.removeHeader(str.getBytes());
            try {
                CLog.i(TAG, "parseMirrorInfo --->" + new String(removeHeader));
                NSDictionary nSDictionary = (NSDictionary) PropertyListParser.parse(removeHeader);
                if (nSDictionary != null) {
                    if (nSDictionary.containsKey(PlistBuilder.KEY_MIRROR_SOCKET_TYPE)) {
                        this.mMst = nSDictionary.get((Object) PlistBuilder.KEY_MIRROR_SOCKET_TYPE).toString();
                    }
                    if (nSDictionary.containsKey(PlistBuilder.KEY_AUDIO_SOCKET_TYPE)) {
                        this.mAst = nSDictionary.get((Object) PlistBuilder.KEY_AUDIO_SOCKET_TYPE).toString();
                        CLog.i(TAG, "mAst++++++" + this.mAst);
                    }
                    if (nSDictionary.containsKey(PlistBuilder.KEY_DISPLAYS)) {
                        NSArray nSArray = (NSArray) nSDictionary.get((Object) PlistBuilder.KEY_DISPLAYS);
                        if (nSArray != null) {
                            for (int i10 = 0; i10 < nSArray.getArray().length; i10++) {
                                NSDictionary nSDictionary2 = (NSDictionary) nSArray.getArray()[i10];
                                for (int i11 = 0; i11 < nSDictionary2.allKeys().length; i11++) {
                                    if (TextUtils.equals(nSDictionary2.allKeys()[i11], "width")) {
                                        this.mTvWidth = Integer.valueOf(nSDictionary2.get((Object) "width").toString()).intValue();
                                    } else if (TextUtils.equals(nSDictionary2.allKeys()[i11], "height")) {
                                        this.mTvHeight = Integer.valueOf(nSDictionary2.get((Object) "height").toString()).intValue();
                                    } else if (TextUtils.equals(nSDictionary2.allKeys()[i11], PlistBuilder.KEY_REFRESH_RATE)) {
                                        try {
                                            double floatValue = Float.valueOf(nSDictionary2.get((Object) PlistBuilder.KEY_REFRESH_RATE).toString()).floatValue();
                                            if (floatValue < 1.0d) {
                                                Double.isNaN(floatValue);
                                                floatValue = 1.0d / floatValue;
                                            }
                                            this.mRefreshRate = floatValue;
                                        } catch (Exception e10) {
                                            CLog.w(TAG, e10);
                                        }
                                    }
                                }
                            }
                        }
                        CLog.i(TAG, "" + this.mTvWidth + "x" + this.mTvHeight + "@" + this.mRefreshRate);
                        adjustScreenSize();
                        return true;
                    }
                }
            } catch (Exception e11) {
                CLog.w(TAG, e11);
            }
        }
        return false;
    }

    @Override // com.hpplay.component.protocol.mirror.rtsp.RtspClient
    public void release() {
        CLog.d(TAG, " New LelinkRtspClient stopTask ");
        if (this.mProtocolSender != null) {
            CLog.d(TAG, "close mProtocalSender");
            this.mProtocolSender.release();
            this.mProtocolSender = null;
        }
        if (this.mMirrorDataSender != null) {
            CLog.d(TAG, "close mMirrorDataSender");
            this.mMirrorDataSender.release();
        }
        LelinkEncrypt lelinkEncrypt = this.mLelinkEncrypt;
        if (lelinkEncrypt != null) {
            lelinkEncrypt.release();
            this.mLelinkEncrypt = null;
        }
    }

    @Override // com.hpplay.component.protocol.mirror.rtsp.RtspClient
    public boolean sendRequestAnnounce() {
        return true;
    }

    @Override // com.hpplay.component.protocol.mirror.rtsp.RtspClient
    public boolean sendRequestAudioSetup() {
        NSArray nSArray;
        this.cseq++;
        this.isUseAudio = true;
        String potocol = new PlistBuilder().addIntagerToRoot(PlistBuilder.KEY_TIMING_PORT, 0).addIntagerToRoot(PlistBuilder.KEY_AUDIO_SOCKET_TYPE, !TextUtils.isEmpty(this.mAst) ? Integer.parseInt(this.mAst) : 0).createIPlistArray("streams", 1).addStringToRoot("uuid", this.mUri).addIntagerToArray("streams", 0, "type", 96).addBlooeanToArray("streams", 0, PlistBuilder.KEY_PLAYMODE, true).addIntagerToArray("streams", 0, PlistBuilder.KEY_SF, 212).addIntagerToArray("streams", 0, PlistBuilder.KEY_SR, 44100).addIntagerToArray("streams", 0, PlistBuilder.KEY_CONTROL_PORT, 0).addIntagerToArray("streams", 0, PlistBuilder.KEY_LATENCYMAX, 3750).addIntagerToArray("streams", 0, PlistBuilder.KEY_LATENCYMIN, 3750).addArrayToRoot("streams").getPotocol();
        byte[] decryptData = this.mLelinkEncrypt.decryptData(this.mProtocolSender.interactiveEncryptData(this.mLelinkEncrypt.buildEncryptData((buildHeader(new NLProtocolBuiler().getAudioSetUpCmd(this.mLocalip, System.currentTimeMillis() + ""), potocol.length()) + potocol).getBytes())));
        if (decryptData != null && decryptData.length > 0) {
            CLog.i(TAG, "sendRequestAudioSetup----->" + new String(decryptData));
            NSDictionary nSDictionary = (NSDictionary) PropertyListParser.parse(ProtocolUtils.removeHeader(decryptData));
            if (nSDictionary.containsKey("streams") && (nSArray = (NSArray) nSDictionary.get((Object) "streams")) != null) {
                for (int i10 = 0; i10 < nSArray.getArray().length; i10++) {
                    NSDictionary nSDictionary2 = (NSDictionary) nSArray.getArray()[i10];
                    if (nSDictionary2 != null && nSDictionary2.get((Object) PlistBuilder.KEY_DATAPORT) != null) {
                        this.mUdpServerPort = Integer.parseInt(nSDictionary2.get((Object) PlistBuilder.KEY_DATAPORT).toString());
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // com.hpplay.component.protocol.mirror.rtsp.RtspClient
    public int sendRequestGetMirrorInfo() {
        try {
            if (this.mProtocolSender == null) {
                ProtocolSender protocolSender = new ProtocolSender();
                this.mProtocolSender = protocolSender;
                protocolSender.setConnectInfo(this.mIp, this.mlelinkPort);
            }
            if (!this.mProtocolSender.connectServer()) {
                return 0;
            }
            LelinkEncrypt lelinkEncrypt = new LelinkEncrypt(this.mSessionId);
            this.mLelinkEncrypt = lelinkEncrypt;
            lelinkEncrypt.setSrpPassword(this.mScreenCode);
            if (!this.mProtocolSender.checkEncrypt(this.mLelinkEncrypt, TAG)) {
                if (this.mLelinkEncrypt.getEncryptState().equals(ProtocolBuilder.LELINK_AUTH_ERROR)) {
                    return 10;
                }
                return this.mLelinkEncrypt.getEncryptState().equals(ProtocolBuilder.LELINK_UNSUPPORT_PREEMPT) ? 12 : 0;
            }
            this.cseq = 0 + 1;
            byte[] decryptData = this.mLelinkEncrypt.decryptData(this.mProtocolSender.interactiveEncryptData(this.mLelinkEncrypt.buildEncryptData(new NLProtocolBuiler().getActionInfoCmd().setPlatfrom().setUserAgent("HappyCast5,0/500.0").setNewClientDid(this.mDeviceId).setNewSessionId(this.mSessionId).setNewClientName(this.mDeviceName).setNewClientAppid(this.mMac).setNewClientVersion("5.5").setNewClientDid("0x" + this.mMac).setNewClientCU(this.mUid).setNewCSEQ(this.cseq + "").setContentLength("0").getProtocal(true))));
            return (decryptData == null || decryptData.length <= 0 || !parseMirrorInfo(new String(decryptData))) ? 0 : 1;
        } catch (Exception e10) {
            CLog.w(TAG, e10);
            throw e10;
        }
    }

    @Override // com.hpplay.component.protocol.mirror.rtsp.RtspClient
    public boolean sendRequestGetMirrorPort() {
        return true;
    }

    @Override // com.hpplay.component.protocol.mirror.rtsp.RtspClient
    public boolean sendRequestGetParamter() {
        return true;
    }

    @Override // com.hpplay.component.protocol.mirror.rtsp.RtspClient
    public boolean sendRequestRecord() {
        this.cseq++;
        byte[] interactiveEncryptData = this.mProtocolSender.interactiveEncryptData(this.mLelinkEncrypt.buildEncryptData(buildHeader(new NLProtocolBuiler().getRecordCmd(this.mLocalip, System.currentTimeMillis() + ""), 0).getBytes()));
        if (interactiveEncryptData == null) {
            this.mProtocolSender.release();
            return false;
        }
        CLog.i(TAG, "RECORD call back  ----->" + new String(this.mLelinkEncrypt.decryptData(interactiveEncryptData)));
        return true;
    }

    @Override // com.hpplay.component.protocol.mirror.rtsp.RtspClient
    public boolean sendRequestSetOptions() {
        try {
            this.cseq++;
            byte[] decryptData = this.mLelinkEncrypt.decryptData(this.mProtocolSender.interactiveEncryptData(this.mLelinkEncrypt.buildEncryptData(buildHeader(new NLProtocolBuiler().getRtspFeedbackCmd(), 0).getBytes())));
            if (decryptData != null) {
                if (decryptData.length > 0) {
                    return true;
                }
            }
        } catch (Exception e10) {
            CLog.w(TAG, e10);
        }
        return false;
    }

    @Override // com.hpplay.component.protocol.mirror.rtsp.RtspClient
    public boolean sendRequestSetParamter() {
        return true;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:8|(3:(2:10|(9:12|13|14|15|16|(2:18|(2:20|(3:22|23|24)))|33|23|24))|23|24)|40|15|16|(0)|33) */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x009e, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0070 A[Catch: Exception -> 0x009e, all -> 0x00a9, TryCatch #0 {Exception -> 0x009e, blocks: (B:16:0x006c, B:18:0x0070, B:20:0x0090), top: B:15:0x006c }] */
    @Override // com.hpplay.component.protocol.mirror.rtsp.RtspClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean sendRequestSetTeardown() {
        boolean z10;
        Exception e10;
        boolean z11;
        LelinkEncrypt lelinkEncrypt;
        z10 = false;
        try {
            this.cseq++;
            String teardownData = getTeardownData(97);
            CLog.i(TAG, "start  send teardown \n" + teardownData);
            ProtocolSender protocolSender = this.mProtocolSender;
            if (protocolSender != null && (lelinkEncrypt = this.mLelinkEncrypt) != null) {
                byte[] interactiveEncryptData = protocolSender.interactiveEncryptData(lelinkEncrypt.buildEncryptData(teardownData.getBytes()));
                try {
                    if (interactiveEncryptData != null) {
                        if (interactiveEncryptData.length > 0) {
                            try {
                                CLog.i(TAG, "start  send teardown  resutlt : \n" + new String(this.mLelinkEncrypt.decryptData(interactiveEncryptData)));
                                z11 = true;
                                if (this.isUseAudio) {
                                    byte[] interactiveEncryptData2 = this.mProtocolSender.interactiveEncryptData(this.mLelinkEncrypt.buildEncryptData(getTeardownData(96).getBytes()));
                                    if (interactiveEncryptData2 != null) {
                                        if (interactiveEncryptData2.length > 0) {
                                            z10 = true;
                                            CLog.d(TAG, "start stopTask");
                                        }
                                    }
                                }
                                z10 = z11;
                                CLog.d(TAG, "start stopTask");
                            } catch (Exception e11) {
                                e10 = e11;
                                z11 = true;
                                CLog.w(TAG, e10);
                                z10 = z11;
                                return z10;
                            }
                        }
                    }
                    CLog.d(TAG, "start stopTask");
                } catch (Exception e12) {
                    z11 = z10;
                    e10 = e12;
                    CLog.w(TAG, e10);
                    z10 = z11;
                    return z10;
                }
                z11 = false;
                if (this.isUseAudio) {
                }
                z10 = z11;
            }
            release();
        } catch (Exception e13) {
            e10 = e13;
            z11 = false;
        }
        return z10;
    }

    @Override // com.hpplay.component.protocol.mirror.rtsp.RtspClient
    public int sendRequestVideoSetup(int i10, int i11) {
        NSArray nSArray;
        NSNumber nSNumber;
        this.cseq++;
        String dateTime = Build.VERSION.SDK_INT >= 24 ? ProtocolUtils.getDateTime(System.currentTimeMillis()) : "20180319000900";
        this.mMirrorFrameEcrypto = new MirrorFrameEcrypto(ProtocolUtils.Encrypt("HappyCast5,0/500.0"), ProtocolUtils.Encrypt(dateTime));
        String potocol = new PlistBuilder().addIntagerToRoot(PlistBuilder.KEY_EVENT_PORT, i10).addIntagerToRoot(PlistBuilder.KEY_TIMING_PORT, 0).addStringToRoot("uuid", this.mUri).addIntagerToRoot(PlistBuilder.KEY_MIRROR_SOCKET_TYPE, i11).addStringToRoot(PlistBuilder.KEY_STREAM_TIME, dateTime).createIPlistArray("streams", 1).addIntagerToArray("streams", 0, "type", 97).addArrayToRoot("streams").getPotocol();
        CLog.i(TAG, "=============>> " + potocol + "   " + i10 + "  " + i11);
        NLProtocolBuiler nLProtocolBuiler = new NLProtocolBuiler();
        String str = this.mLocalip;
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
        sb.append("");
        byte[] decryptData = this.mLelinkEncrypt.decryptData(this.mProtocolSender.interactiveEncryptData(this.mLelinkEncrypt.buildEncryptData((buildHeader(nLProtocolBuiler.getVideoSetUpCmd(str, sb.toString()), potocol.length()) + potocol).getBytes())));
        if (decryptData != null && decryptData.length > 0) {
            CLog.i(TAG, "=======================================----->\r\n" + new String(decryptData));
            String header = ProtocolUtils.getHeader(decryptData);
            if (!TextUtils.isEmpty(header)) {
                String str2 = header.split("\r\n")[0];
                CLog.i(TAG, "the header first line ----->" + str2);
                if (str2.contains(ProtocolBuilder.LELINK_UNSUPPORT_PREEMPT)) {
                    return 12;
                }
                if (str2.contains(ProtocolBuilder.LELINK_UNSUPPORT_FORBIDDEN)) {
                    return 13;
                }
            }
            NSDictionary nSDictionary = (NSDictionary) PropertyListParser.parse(ProtocolUtils.removeHeader(decryptData));
            if (nSDictionary.containsKey(PlistBuilder.KEY_TIMING_PORT) && (nSNumber = (NSNumber) nSDictionary.get((Object) PlistBuilder.KEY_TIMING_PORT)) != null) {
                nSNumber.intValue();
            }
            if (nSDictionary.containsKey("streams") && (nSArray = (NSArray) nSDictionary.get((Object) "streams")) != null) {
                boolean z10 = false;
                for (int i12 = 0; i12 < nSArray.count(); i12++) {
                    NSDictionary nSDictionary2 = (NSDictionary) nSArray.getArray()[i12];
                    if (nSDictionary2 != null && nSDictionary2.get((Object) PlistBuilder.KEY_DATAPORT) != null) {
                        mMirrorPort = Integer.parseInt(nSDictionary2.get((Object) PlistBuilder.KEY_DATAPORT).toString());
                    }
                    if (nSDictionary2 != null && nSDictionary2.get((Object) PlistBuilder.KEY_UDP_DATAPORT) != null) {
                        this.mRudpPort = Integer.parseInt(nSDictionary2.get((Object) PlistBuilder.KEY_UDP_DATAPORT).toString());
                    }
                    int i13 = this.mRudpPort;
                    if (i13 > 0) {
                        z10 = this.mMirrorDataSender.connect(this.mIp, i13, 1);
                        this.mBitrate = this.mMirrorDataSender.getInitBitrate();
                    }
                }
                if (!z10) {
                    z10 = this.mMirrorDataSender.connect(this.mIp, mMirrorPort, 2);
                }
                if (z10) {
                    return 1;
                }
            }
        }
        return 0;
    }

    @Override // com.hpplay.component.protocol.mirror.rtsp.RtspClient
    public boolean setMirrorMode(String str) {
        try {
            if (this.mProtocolSender != null && !TextUtils.isEmpty(str)) {
                byte[] interactiveEncryptData = this.mProtocolSender.interactiveEncryptData(this.mLelinkEncrypt.buildEncryptData(new NLProtocolBuiler().getMirrorModeCmd().setPlatfrom().setUserAgent("HappyCast5,0/500.0").setNewClientDid(this.mDeviceId).setNewSessionId(this.mSessionId).setMirrorMode(str).setNewCSEQ(this.cseq + "").setContentLength("0").getProtocal(true)));
                StringBuilder sb = new StringBuilder();
                sb.append("   send mirror mode ");
                sb.append(interactiveEncryptData != null);
                CLog.i(TAG, sb.toString());
                if (interactiveEncryptData != null) {
                    CLog.d(TAG, new String(this.mLelinkEncrypt.decryptData(interactiveEncryptData)));
                }
                return true;
            }
        } catch (Exception e10) {
            CLog.w(TAG, e10);
        }
        return false;
    }

    @Override // com.hpplay.component.protocol.mirror.rtsp.RtspClient
    public void setSinkHeight(int i10) {
        this.mHeight = i10;
    }

    @Override // com.hpplay.component.protocol.mirror.rtsp.RtspClient
    public void setSinkWidth(int i10) {
        this.mWidth = i10;
    }
}
