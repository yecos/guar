package com.hpplay.component.protocol.mirror.rtsp;

import android.os.Build;
import android.text.TextUtils;
import com.hpplay.component.common.ParamsMap;
import com.hpplay.component.common.utils.CLog;
import com.hpplay.component.common.utils.DeviceProperties;
import com.hpplay.component.protocol.PlistBuilder;
import com.hpplay.component.protocol.ProtocolBuilder;
import com.hpplay.component.protocol.ProtocolSender;
import com.hpplay.component.protocol.ProtocolUtils;
import com.hpplay.component.protocol.encrypt.MirrorFrameEcrypto;
import com.hpplay.component.protocol.mirror.VideoSender;
import com.hpplay.component.protocol.plist.NSArray;
import com.hpplay.component.protocol.plist.NSDictionary;
import com.hpplay.component.protocol.plist.NSNumber;
import com.hpplay.component.protocol.plist.PropertyListParser;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.android.agoo.message.MessageService;

/* loaded from: classes2.dex */
public class LelinkRtspClient extends RtspClient {
    private static final String HAPPY_CAST = "Happycast/1.0";
    private static final String HAPPY_VALUE = "happyplay";
    private static final String TAG = "LelinkRtspClient";
    private String mDeviceId;
    private String mDeviceName;
    private boolean mEncrypt;
    private String mIp;
    private String mLocalip;
    private int mMirrorPort;
    private ProtocolSender mProtocolSender;
    private int mRepoPort;
    private String mScreenCode;
    private String mSinkName;
    private String mUri;
    private VideoSender mVideoDataSender;
    private String versoinName;
    private double mRefreshRate = 60.0d;
    private int mUdpServerPort = 0;
    int cseq = 0;

    public LelinkRtspClient(ParamsMap paramsMap) {
        this.mMirrorPort = 0;
        this.mScreenCode = paramsMap.getStringParam("screencode");
        this.mRepoPort = Integer.parseInt(TextUtils.isEmpty(paramsMap.getStringParam(ParamsMap.DeviceParams.KEY_RAOP_PORT)) ? "0" : paramsMap.getStringParam(ParamsMap.DeviceParams.KEY_RAOP_PORT));
        this.mUri = paramsMap.getStringParam("uri");
        try {
            this.mIDWidth = Integer.parseInt(paramsMap.getStringParam(ParamsMap.MirrorParams.KEY_PHONE_WIDTH));
            this.mIDHeight = Integer.parseInt(paramsMap.getStringParam(ParamsMap.MirrorParams.KEY_PHONE_HEIGHT));
        } catch (Exception e10) {
            this.mIDWidth = 1080;
            this.mIDHeight = 1920;
            CLog.w(TAG, e10);
        }
        this.versoinName = paramsMap.getStringParam(ParamsMap.DeviceParams.KEY_CHANNEL_VERSION);
        this.mSinkName = paramsMap.getStringParam(ParamsMap.DeviceParams.KEY_SINK_NAME);
        this.mDeviceId = "0x" + paramsMap.getStringParam(ParamsMap.DeviceParams.KEY_MAC);
        this.mIp = paramsMap.getStringParam("ip");
        CLog.d(TAG, " report  " + this.mRepoPort);
        this.mDeviceName = DeviceProperties.getManufacturer() + " " + DeviceProperties.getModel();
        this.mMirrorPort = Integer.parseInt(paramsMap.getParam(ParamsMap.DeviceParams.KEY_MIRROR_PORT, "0").toString());
    }

    private void parseMirrorPort(byte[] bArr) {
        NSArray nSArray;
        NSDictionary nSDictionary;
        if (bArr == null) {
            return;
        }
        CLog.d(TAG, "------->" + new String(bArr));
        try {
            NSDictionary nSDictionary2 = (NSDictionary) PropertyListParser.parse(ProtocolUtils.removeHeader(bArr));
            if (nSDictionary2 != null && (nSArray = (NSArray) nSDictionary2.objectForKey("streams")) != null && (nSDictionary = (NSDictionary) nSArray.objectAtIndex(0)) != null) {
                NSNumber nSNumber = (NSNumber) nSDictionary.objectForKey("dataPort");
                if (nSNumber != null) {
                    this.mMirrorPort = nSNumber.intValue();
                } else {
                    this.mMirrorPort = 7100;
                }
            }
        } catch (Exception e10) {
            CLog.w(TAG, e10);
            this.mMirrorPort = 7100;
        }
    }

    @Override // com.hpplay.component.protocol.mirror.rtsp.RtspClient
    public int exeLelinkRtsp(boolean z10, String... strArr) {
        int parseInt;
        boolean sendRequestRecord;
        int i10 = 0;
        try {
            parseInt = Integer.parseInt(strArr[0]);
            CLog.i(TAG, "start  running");
            try {
            } catch (Exception e10) {
                e = e10;
                i10 = ParamsMap.MirrorParams.MIRROR_ERROR_GET_PORT;
            }
        } catch (Exception e11) {
            e = e11;
        }
        if (!sendRequestGetMirrorPort()) {
            return ParamsMap.MirrorParams.MIRROR_ERROR_GET_PORT;
        }
        CLog.i(TAG, "start  get mirror info");
        try {
        } catch (Exception e12) {
            e = e12;
            i10 = ParamsMap.MirrorParams.MIRROR_ERROR_GET_INFO;
        }
        if (sendRequestGetMirrorInfo() == 10) {
            return 211026;
        }
        try {
            boolean sendRequestAnnounce = sendRequestAnnounce();
            CLog.i(TAG, "Announce" + sendRequestAnnounce);
            sendRequestVideoSetup(parseInt, 0);
            CLog.i(TAG, "Video Setup" + sendRequestAnnounce);
            if (z10) {
                boolean sendRequestAudioSetup = sendRequestAudioSetup();
                CLog.i(TAG, "AudioSetup" + sendRequestAudioSetup);
                if (!sendRequestAudioSetup) {
                    return ParamsMap.MirrorParams.MIRROR_ERROR_SETUP;
                }
            }
            i10 = ParamsMap.MirrorParams.MIRROR_ERROR_RECORD;
            sendRequestRecord = sendRequestRecord();
            CLog.i(TAG, "tRecord" + sendRequestRecord);
        } catch (Exception e13) {
            e = e13;
            i10 = ParamsMap.MirrorParams.MIRROR_ERROR_SETUP;
            CLog.w(TAG, e);
            this.mErrorMsg = CLog.getExceptionStr(e);
            return i10;
        }
        if (!sendRequestRecord) {
            return ParamsMap.MirrorParams.MIRROR_ERROR_RECORD;
        }
        boolean sendRequestGetParamter = sendRequestGetParamter();
        CLog.i(TAG, "GetParameter" + sendRequestGetParamter);
        if (!sendRequestGetParamter) {
            return ParamsMap.MirrorParams.MIRROR_ERROR_RECORD;
        }
        boolean sendRequestSetParamter = sendRequestSetParamter();
        CLog.i(TAG, "SetParameter start " + sendRequestSetParamter);
        if (sendRequestSetParamter) {
            return 1;
        }
        return i10;
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
        return this.mVideoDataSender;
    }

    @Override // com.hpplay.component.protocol.mirror.rtsp.RtspClient
    public boolean isEncrypt() {
        return this.mEncrypt;
    }

    public int parseMirrorInfo(String str) {
        String str2 = str.split("\r\n")[0];
        if (!TextUtils.isEmpty(str2) && str2.contains(ProtocolBuilder.LELINK_STATE_SUCCESS)) {
            if (str.contains("happycast")) {
                this.mEncrypt = true;
            }
            try {
                NSDictionary nSDictionary = (NSDictionary) PropertyListParser.parse(ProtocolUtils.removeHeader(str.getBytes()));
                if (nSDictionary != null) {
                    this.mTvWidth = ((NSNumber) nSDictionary.objectForKey("width")).intValue();
                    this.mTvHeight = ((NSNumber) nSDictionary.objectForKey("height")).intValue();
                    adjustScreenSize();
                    try {
                        double doubleValue = ((NSNumber) nSDictionary.objectForKey("refreshRate")).doubleValue();
                        if (doubleValue < 1.0d) {
                            doubleValue = 1.0d / doubleValue;
                        }
                        this.mRefreshRate = doubleValue;
                    } catch (Exception e10) {
                        CLog.w(TAG, e10);
                    }
                    CLog.i(TAG, "" + this.mTvWidth + "x" + this.mTvHeight + "@" + this.mRefreshRate);
                    return 1;
                }
            } catch (Exception e11) {
                CLog.w(TAG, e11);
            }
        } else if (!TextUtils.isEmpty(str2) && str2.contains(ProtocolBuilder.LELINK_STATE_SCREENCODE)) {
            String[] split = str.split("\r\n");
            if (split == null || split.length <= 0) {
                return 10;
            }
            String str3 = split[split.length - 1];
            if (TextUtils.isEmpty(str3)) {
                return 10;
            }
            int indexOf = str3.indexOf(Operator.Operation.EQUALS);
            int indexOf2 = str3.indexOf(",");
            String replace = str3.substring(indexOf + 1, indexOf2 - 1).replace("\"", "");
            String substring = str3.substring(indexOf2 + 1);
            String replace2 = substring.substring(substring.indexOf(Operator.Operation.EQUALS) + 1).replace("\"", "");
            ProtocolBuilder.mRealm = replace;
            ProtocolBuilder.mNonce = replace2;
            CLog.d(TAG, "author  :  " + str3);
            return 10;
        }
        return 0;
    }

    @Override // com.hpplay.component.protocol.mirror.rtsp.RtspClient
    public void release() {
        VideoSender videoSender = this.mVideoDataSender;
        if (videoSender != null) {
            videoSender.release();
        }
        ProtocolSender protocolSender = this.mProtocolSender;
        if (protocolSender != null) {
            protocolSender.release();
        }
    }

    @Override // com.hpplay.component.protocol.mirror.rtsp.RtspClient
    public boolean sendRequestAnnounce() {
        this.mLocalip = ProtocolUtils.getLoaclIp();
        this.cseq = 0;
        String sdp = new ProtocolBuilder().getSdp(this.mLocalip, this.mDeviceName);
        StringBuilder sb = new StringBuilder();
        sb.append(new ProtocolBuilder().getAunounce(this.mLocalip).setLelinkClientName(this.mDeviceName).setRtspSeq(this.cseq + "").setLelinkDeviceId(this.mDeviceId).setRtspDacp(ProtocolBuilder.VALUE_DACP).setRtsActiveRemote(ProtocolBuilder.VALUE_ACTIVE_REMOTE).setContentType(ProtocolBuilder.VALUE_SDP_TYPE).setContentLength(sdp.length() + "").setUserAgent("AirPlay/150.33").getString(true));
        sb.append(sdp);
        String sb2 = sb.toString();
        CLog.d(TAG, "------announce ---" + sb2);
        this.cseq = this.cseq + 1;
        byte[] bArr = new byte[0];
        try {
            bArr = this.mProtocolSender.interactiveData(sb2.getBytes());
        } catch (Exception e10) {
            CLog.w(TAG, e10);
        }
        if (bArr != null) {
            return true;
        }
        this.mProtocolSender.release();
        return false;
    }

    @Override // com.hpplay.component.protocol.mirror.rtsp.RtspClient
    public boolean sendRequestAudioSetup() {
        ProtocolBuilder transport = new ProtocolBuilder().getAudioSetUpCmd(this.mLocalip).setTransport(ProtocolBuilder.VALUE_AUDIO_TRANSPORT);
        StringBuilder sb = new StringBuilder();
        sb.append(this.cseq);
        String str = "";
        sb.append("");
        byte[] protocal = transport.setRtspSeq(sb.toString()).setLelinkDeviceId(this.mDeviceId).setRtspDacp(ProtocolBuilder.VALUE_DACP).setContentLength("0").setRtsActiveRemote(ProtocolBuilder.VALUE_ACTIVE_REMOTE).setUserAgent("AirPlay/150.33").getProtocal(true);
        CLog.i(TAG, "1 --- > \n\n " + new String(protocal) + "   \n\n " + protocal.length);
        byte[] interactiveData = this.mProtocolSender.interactiveData(protocal);
        if (interactiveData != null) {
            str = new String(interactiveData, 0, interactiveData.length);
            CLog.i(TAG, "SETUP audio = \r\n" + str);
        }
        CLog.i(TAG, "SETUP call back" + str);
        String substring = str.substring(0, str.indexOf("\r\n\r\n"));
        RTSPPacket rTSPPacket = new RTSPPacket();
        rTSPPacket.parseRTSPPacket(substring, null, substring.length());
        rTSPPacket.valueOfHeader("Transport");
        Pattern.compile(";control_port=(\\d+)").matcher(substring);
        Pattern.compile(";timing_port=(\\d+)").matcher(substring);
        Matcher matcher = Pattern.compile(";server_port=(\\d+)").matcher(substring);
        if (matcher.find()) {
            try {
                this.mUdpServerPort = Integer.valueOf(matcher.group(1)).intValue();
            } catch (Exception e10) {
                CLog.w(TAG, e10);
            }
        }
        Pattern.compile(";mode=(\\w+)").matcher(substring);
        return true;
    }

    @Override // com.hpplay.component.protocol.mirror.rtsp.RtspClient
    public int sendRequestGetMirrorInfo() {
        if (this.mVideoDataSender == null) {
            VideoSender videoSender = new VideoSender();
            this.mVideoDataSender = videoSender;
            if (!videoSender.connect(this.mIp, this.mMirrorPort, 2)) {
                return 0;
            }
            String dateTime = Build.VERSION.SDK_INT >= 24 ? ProtocolUtils.getDateTime(System.currentTimeMillis()) : "20180319000900";
            this.mMirrorFrameEcrypto = new MirrorFrameEcrypto(ProtocolUtils.Encrypt(HAPPY_CAST), ProtocolUtils.Encrypt(dateTime));
            if (TextUtils.isEmpty(this.mScreenCode)) {
                this.mScreenCode = null;
            } else {
                this.mScreenCode = ProtocolBuilder.makeAuthorization(this.mScreenCode);
            }
            byte[] interactiveData = this.mVideoDataSender.interactiveData(this.versoinName.contains("5.3.2.9") ? new ProtocolBuilder().getMirrorInfoCmd().setLelinkDeviceId(this.mDeviceId).setLelinkDevNameCmd(this.mDeviceName).setLelinkprotocolVersion("0").setLelinkClientName(this.mSinkName).setStreamTime(dateTime).setUserAgent(HAPPY_CAST).setContentLength("0").setAutorization(this.mScreenCode).setHapplay(HAPPY_VALUE).getProtocal(true) : new ProtocolBuilder().getMirrorInfoCmd().setAplleDevid(this.mDeviceId).setAppleDevName(this.mDeviceName).setApplePrcVs("0").setAppleClientName(this.mSinkName).setStreamTime(dateTime).setUserAgent(HAPPY_CAST).setContentLength("0").setAutorization(this.mScreenCode).setHapplay(HAPPY_VALUE).getProtocal(true));
            if (interactiveData != null) {
                return parseMirrorInfo(new String(interactiveData));
            }
            return 0;
        }
        ProtocolSender protocolSender = new ProtocolSender();
        this.mProtocolSender = protocolSender;
        protocolSender.setConnectInfo(this.mIp, this.mRepoPort);
        boolean connectServer = this.mProtocolSender.connectServer();
        CLog.d(TAG, "create socket " + connectServer);
        if (connectServer) {
            byte[] bArr = new byte[0];
            try {
                bArr = this.mProtocolSender.interactiveData(new ProtocolBuilder().getMirrorPortCmd().setAplleDevid(this.mDeviceId).setAppleDevName(this.mDeviceName).setApplePrcVs("0").setAppleClientName(this.mSinkName).setContentLength("0").setHapplay(HAPPY_VALUE).getProtocal(true));
            } catch (Exception e10) {
                CLog.w(TAG, e10);
            }
            if (bArr != null) {
                parseMirrorPort(bArr);
            }
        }
        return !connectServer ? 0 : 1;
    }

    @Override // com.hpplay.component.protocol.mirror.rtsp.RtspClient
    public boolean sendRequestGetMirrorPort() {
        boolean connect;
        if (this.mMirrorPort == 0) {
            ProtocolSender protocolSender = new ProtocolSender();
            this.mProtocolSender = protocolSender;
            protocolSender.setConnectInfo(this.mIp, this.mRepoPort);
            connect = this.mProtocolSender.connectServer();
            CLog.d(TAG, "create socket " + connect);
            if (connect) {
                byte[] interactiveData = this.mProtocolSender.interactiveData(new ProtocolBuilder().getMirrorPortCmd().setAplleDevid(this.mDeviceId).setAppleDevName(this.mDeviceName).setApplePrcVs("0").setAppleClientName(this.mDeviceName).setContentLength("0").setHapplay(HAPPY_VALUE).getProtocal(true));
                if (interactiveData == null) {
                    return false;
                }
                parseMirrorPort(interactiveData);
                return true;
            }
        } else {
            VideoSender videoSender = new VideoSender();
            this.mVideoDataSender = videoSender;
            connect = videoSender.connect(this.mIp, this.mMirrorPort, 2);
            String dateTime = Build.VERSION.SDK_INT >= 24 ? ProtocolUtils.getDateTime(System.currentTimeMillis()) : "20180319000900";
            this.mMirrorFrameEcrypto = new MirrorFrameEcrypto(ProtocolUtils.Encrypt(HAPPY_CAST), ProtocolUtils.Encrypt(dateTime));
            byte[] interactiveData2 = this.mVideoDataSender.interactiveData(this.versoinName.contains("5.3.2.9") ? new ProtocolBuilder().getMirrorInfoCmd().setLelinkDeviceId(this.mDeviceId).setLelinkDevNameCmd(this.mDeviceName).setLelinkprotocolVersion("0").setLelinkClientName(this.mSinkName).setStreamTime(dateTime).setUserAgent(HAPPY_CAST).setContentLength("0").setAutorization(this.mScreenCode).setHapplay(HAPPY_VALUE).getProtocal(true) : new ProtocolBuilder().getMirrorInfoCmd().setAplleDevid(this.mDeviceId).setAppleDevName(this.mDeviceName).setApplePrcVs("0").setAppleClientName(this.mSinkName).setStreamTime(dateTime).setUserAgent(HAPPY_CAST).setContentLength("0").setAutorization(this.mScreenCode).setHapplay(HAPPY_VALUE).getProtocal(true));
            if (interactiveData2 == null || parseMirrorInfo(new String(interactiveData2)) != 1) {
                return false;
            }
        }
        return connect;
    }

    @Override // com.hpplay.component.protocol.mirror.rtsp.RtspClient
    public boolean sendRequestGetParamter() {
        this.cseq++;
        byte[] bArr = new byte[0];
        try {
            bArr = this.mProtocolSender.interactiveData((new ProtocolBuilder().getParameterCmd(this.mLocalip).setRtspSeq(this.cseq + "").setLelinkDeviceId(this.mDeviceId).setRtspDacp(ProtocolBuilder.VALUE_DACP).setRtsActiveRemote(ProtocolBuilder.VALUE_ACTIVE_REMOTE).setContentLength(MessageService.MSG_ACCS_NOTIFY_CLICK).setUserAgent("AirPlay/150.33").getString(true) + PlistBuilder.VALUE_TYPE_VOLUME + "\r\n").getBytes());
        } catch (Exception e10) {
            CLog.w(TAG, e10);
        }
        if (bArr == null) {
            this.mProtocolSender.release();
            return false;
        }
        CLog.i(TAG, "GET_PARAMETER call back ----->" + new String(bArr));
        return true;
    }

    @Override // com.hpplay.component.protocol.mirror.rtsp.RtspClient
    public boolean sendRequestRecord() {
        this.cseq++;
        byte[] interactiveData = this.mProtocolSender.interactiveData(new ProtocolBuilder().getRecordCmd(this.mLocalip).setRange(ProtocolBuilder.VALUE_NTP).setRtpinfo(ProtocolBuilder.VALUE_RTPINFO).setRtspSeq(this.cseq + "").setLelinkDeviceId(this.mDeviceId).setRtspDacp(ProtocolBuilder.VALUE_DACP).setRtsActiveRemote(ProtocolBuilder.VALUE_ACTIVE_REMOTE).setUserAgent("AirPlay/150.33").getProtocal(true));
        if (interactiveData == null) {
            this.mProtocolSender.release();
            return false;
        }
        CLog.i(TAG, " RECORD call back  ----->" + new String(interactiveData));
        return true;
    }

    @Override // com.hpplay.component.protocol.mirror.rtsp.RtspClient
    public boolean sendRequestSetOptions() {
        this.cseq++;
        byte[] protocal = new ProtocolBuilder().getOptionsCmd().setRtspSeq(this.cseq + "").setLelinkDeviceId(this.mDeviceId).setRtspDacp(ProtocolBuilder.VALUE_DACP).setRtsActiveRemote(ProtocolBuilder.VALUE_ACTIVE_REMOTE).setContentLength("0").setUserAgent("AirPlay/150.33").getProtocal(true);
        ProtocolSender protocolSender = this.mProtocolSender;
        if (protocolSender == null) {
            return false;
        }
        byte[] bArr = new byte[0];
        try {
            bArr = protocolSender.interactiveData(protocal);
        } catch (Exception e10) {
            CLog.w(TAG, e10);
        }
        if (bArr == null) {
            CLog.i(TAG, "Session End");
        } else {
            try {
                CLog.i(TAG, "startCapture in options exe keep-alive-->" + new String(bArr));
            } catch (Exception e11) {
                CLog.w(TAG, e11);
            }
        }
        return true;
    }

    @Override // com.hpplay.component.protocol.mirror.rtsp.RtspClient
    public boolean sendRequestSetParamter() {
        this.cseq++;
        String str = new ProtocolBuilder().getSetParameterCmd(this.mLocalip).setRtspSeq(this.cseq + "").setLelinkDeviceId(this.mDeviceId).setRtspDacp(ProtocolBuilder.VALUE_DACP).setRtsActiveRemote(ProtocolBuilder.VALUE_ACTIVE_REMOTE).setContentLength("19").setUserAgent("AirPlay/150.33").getString(true) + "volume: -3.000000\r\n";
        CLog.i(TAG, "SET_PARAMETER call back ----->" + new String(str));
        byte[] bArr = new byte[0];
        try {
            bArr = this.mProtocolSender.interactiveData(str.getBytes());
        } catch (Exception e10) {
            CLog.w(TAG, e10);
        }
        if (bArr != null) {
            return true;
        }
        this.mProtocolSender.release();
        return false;
    }

    @Override // com.hpplay.component.protocol.mirror.rtsp.RtspClient
    public boolean sendRequestSetTeardown() {
        if (this.mProtocolSender != null) {
            this.cseq++;
            byte[] bArr = new byte[0];
            try {
                bArr = this.mProtocolSender.interactiveData(new ProtocolBuilder().getTearDown(this.mLocalip).setRtspSeq(this.cseq + "").setLelinkDeviceId(this.mDeviceId).setUserAgent("AirPlay/150.33").getProtocal(true));
            } catch (Exception e10) {
                CLog.w(TAG, e10);
            }
            if (bArr != null) {
                CLog.i(TAG, "sendRequestSetTeardown result -->" + new String(bArr));
            }
            release();
        }
        return true;
    }

    @Override // com.hpplay.component.protocol.mirror.rtsp.RtspClient
    public int sendRequestVideoSetup(int i10, int i11) {
        this.cseq++;
        byte[] interactiveData = this.mProtocolSender.interactiveData(new ProtocolBuilder().getVideoSetUpCmd(this.mLocalip).setTransport(ProtocolBuilder.VALUE_VIDEO_TRANSPORT).setRtspSeq(this.cseq + "").setLelinkDeviceId(this.mDeviceId).setRtspDacp(ProtocolBuilder.VALUE_DACP).setContentLength("0").setRtsActiveRemote(ProtocolBuilder.VALUE_ACTIVE_REMOTE).setUserAgent("AirPlay/150.33").getProtocal(true));
        if (interactiveData == null) {
            this.mProtocolSender.release();
            return 0;
        }
        CLog.i(TAG, "SETUP call back agin ----->" + new String(interactiveData));
        return 1;
    }

    @Override // com.hpplay.component.protocol.mirror.rtsp.RtspClient
    public boolean setMirrorMode(String str) {
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
