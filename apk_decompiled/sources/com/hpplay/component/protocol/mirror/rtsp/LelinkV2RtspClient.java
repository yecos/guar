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
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized boolean sendRequestSetTeardown() {
        /*
            r9 = this;
            monitor-enter(r9)
            r0 = 0
            int r1 = r9.cseq     // Catch: java.lang.Throwable -> La9 java.lang.Exception -> Lab
            r2 = 1
            int r1 = r1 + r2
            r9.cseq = r1     // Catch: java.lang.Throwable -> La9 java.lang.Exception -> Lab
            r1 = 97
            java.lang.String r1 = r9.getTeardownData(r1)     // Catch: java.lang.Throwable -> La9 java.lang.Exception -> Lab
            java.lang.String r3 = "LelinkV2RtspClient"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La9 java.lang.Exception -> Lab
            r4.<init>()     // Catch: java.lang.Throwable -> La9 java.lang.Exception -> Lab
            java.lang.String r5 = "start  send teardown \n"
            r4.append(r5)     // Catch: java.lang.Throwable -> La9 java.lang.Exception -> Lab
            r4.append(r1)     // Catch: java.lang.Throwable -> La9 java.lang.Exception -> Lab
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> La9 java.lang.Exception -> Lab
            com.hpplay.component.common.utils.CLog.i(r3, r4)     // Catch: java.lang.Throwable -> La9 java.lang.Exception -> Lab
            com.hpplay.component.protocol.ProtocolSender r3 = r9.mProtocolSender     // Catch: java.lang.Throwable -> La9 java.lang.Exception -> Lab
            if (r3 == 0) goto La0
            com.hpplay.component.protocol.encrypt.LelinkEncrypt r4 = r9.mLelinkEncrypt     // Catch: java.lang.Throwable -> La9 java.lang.Exception -> Lab
            if (r4 == 0) goto La0
            byte[][] r5 = new byte[r2][]     // Catch: java.lang.Throwable -> La9 java.lang.Exception -> Lab
            byte[][] r6 = new byte[r2][]     // Catch: java.lang.Throwable -> La9 java.lang.Exception -> Lab
            byte[] r1 = r1.getBytes()     // Catch: java.lang.Throwable -> La9 java.lang.Exception -> Lab
            r6[r0] = r1     // Catch: java.lang.Throwable -> La9 java.lang.Exception -> Lab
            byte[] r1 = r4.buildEncryptData(r6)     // Catch: java.lang.Throwable -> La9 java.lang.Exception -> Lab
            r5[r0] = r1     // Catch: java.lang.Throwable -> La9 java.lang.Exception -> Lab
            byte[] r1 = r3.interactiveEncryptData(r5)     // Catch: java.lang.Throwable -> La9 java.lang.Exception -> Lab
            if (r1 == 0) goto L6b
            int r3 = r1.length     // Catch: java.lang.Throwable -> La9 java.lang.Exception -> Lab
            if (r3 <= 0) goto L6b
            java.lang.String r3 = "LelinkV2RtspClient"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L68 java.lang.Throwable -> La9
            r4.<init>()     // Catch: java.lang.Exception -> L68 java.lang.Throwable -> La9
            java.lang.String r5 = "start  send teardown  resutlt : \n"
            r4.append(r5)     // Catch: java.lang.Exception -> L68 java.lang.Throwable -> La9
            java.lang.String r5 = new java.lang.String     // Catch: java.lang.Exception -> L68 java.lang.Throwable -> La9
            com.hpplay.component.protocol.encrypt.LelinkEncrypt r6 = r9.mLelinkEncrypt     // Catch: java.lang.Exception -> L68 java.lang.Throwable -> La9
            byte[] r1 = r6.decryptData(r1)     // Catch: java.lang.Exception -> L68 java.lang.Throwable -> La9
            r5.<init>(r1)     // Catch: java.lang.Exception -> L68 java.lang.Throwable -> La9
            r4.append(r5)     // Catch: java.lang.Exception -> L68 java.lang.Throwable -> La9
            java.lang.String r1 = r4.toString()     // Catch: java.lang.Exception -> L68 java.lang.Throwable -> La9
            com.hpplay.component.common.utils.CLog.i(r3, r1)     // Catch: java.lang.Exception -> L68 java.lang.Throwable -> La9
            r1 = 1
            goto L6c
        L68:
            r0 = move-exception
            r1 = 1
            goto Lae
        L6b:
            r1 = 0
        L6c:
            boolean r3 = r9.isUseAudio     // Catch: java.lang.Exception -> L9e java.lang.Throwable -> La9
            if (r3 == 0) goto L95
            r3 = 96
            java.lang.String r3 = r9.getTeardownData(r3)     // Catch: java.lang.Exception -> L9e java.lang.Throwable -> La9
            com.hpplay.component.protocol.ProtocolSender r4 = r9.mProtocolSender     // Catch: java.lang.Exception -> L9e java.lang.Throwable -> La9
            byte[][] r5 = new byte[r2][]     // Catch: java.lang.Exception -> L9e java.lang.Throwable -> La9
            com.hpplay.component.protocol.encrypt.LelinkEncrypt r6 = r9.mLelinkEncrypt     // Catch: java.lang.Exception -> L9e java.lang.Throwable -> La9
            byte[][] r7 = new byte[r2][]     // Catch: java.lang.Exception -> L9e java.lang.Throwable -> La9
            byte[] r3 = r3.getBytes()     // Catch: java.lang.Exception -> L9e java.lang.Throwable -> La9
            r7[r0] = r3     // Catch: java.lang.Exception -> L9e java.lang.Throwable -> La9
            byte[] r3 = r6.buildEncryptData(r7)     // Catch: java.lang.Exception -> L9e java.lang.Throwable -> La9
            r5[r0] = r3     // Catch: java.lang.Exception -> L9e java.lang.Throwable -> La9
            byte[] r0 = r4.interactiveEncryptData(r5)     // Catch: java.lang.Exception -> L9e java.lang.Throwable -> La9
            if (r0 == 0) goto L95
            int r0 = r0.length     // Catch: java.lang.Exception -> L9e java.lang.Throwable -> La9
            if (r0 <= 0) goto L95
            r0 = 1
            goto L96
        L95:
            r0 = r1
        L96:
            java.lang.String r1 = "LelinkV2RtspClient"
            java.lang.String r2 = "start stopTask"
            com.hpplay.component.common.utils.CLog.d(r1, r2)     // Catch: java.lang.Exception -> La4 java.lang.Throwable -> La9
            goto La0
        L9e:
            r0 = move-exception
            goto Lae
        La0:
            r9.release()     // Catch: java.lang.Exception -> La4 java.lang.Throwable -> La9
            goto Lb4
        La4:
            r1 = move-exception
            r8 = r1
            r1 = r0
            r0 = r8
            goto Lae
        La9:
            r0 = move-exception
            goto Lb6
        Lab:
            r1 = move-exception
            r0 = r1
            r1 = 0
        Lae:
            java.lang.String r2 = "LelinkV2RtspClient"
            com.hpplay.component.common.utils.CLog.w(r2, r0)     // Catch: java.lang.Throwable -> La9
            r0 = r1
        Lb4:
            monitor-exit(r9)
            return r0
        Lb6:
            monitor-exit(r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hpplay.component.protocol.mirror.rtsp.LelinkV2RtspClient.sendRequestSetTeardown():boolean");
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
