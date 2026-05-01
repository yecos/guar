package com.hpplay.sdk.source.process;

import com.hpplay.sdk.source.bean.DebugTimestampBean;
import com.hpplay.sdk.source.bean.DebugTimestampInfoBean;
import com.hpplay.sdk.source.log.SourceLog;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public class DebugTSThread extends Thread {
    private DebugTimestampBean mDebugBean;
    private int status = 0;

    public DebugTSThread(DebugTimestampBean debugTimestampBean) {
        this.mDebugBean = debugTimestampBean;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        int i10;
        super.run();
        int i11 = 0;
        while (true) {
            if (this.status != 1) {
                try {
                    Thread.sleep(500L);
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
            while (this.status == 1) {
                i11++;
                if (i11 >= 5) {
                    try {
                        ConcurrentHashMap<Integer, DebugTimestampInfoBean> audioTSFrames = this.mDebugBean.getAudioTSFrames();
                        ConcurrentHashMap<Integer, DebugTimestampInfoBean> videoTSFrames = this.mDebugBean.getVideoTSFrames();
                        if (audioTSFrames != null && audioTSFrames.size() > 0) {
                            int intValue = this.mDebugBean.audioWriteSerial.intValue();
                            this.mDebugBean.audioReadSerial.set(intValue);
                            for (int intValue2 = this.mDebugBean.audioReadSerial.intValue(); intValue2 < intValue; intValue2++) {
                                if (audioTSFrames.containsKey(Integer.valueOf(intValue2))) {
                                    DebugTimestampInfoBean debugTimestampInfoBean = audioTSFrames.get(Integer.valueOf(intValue2));
                                    audioTSFrames.remove(Integer.valueOf(intValue2), debugTimestampInfoBean);
                                    SourceLog.i("MirrorAudio", String.format("serial: %d, capture: %d, encode time: %d, send time: %d", Integer.valueOf(debugTimestampInfoBean.getSerial()), Long.valueOf(debugTimestampInfoBean.getCaptureTS()), Integer.valueOf((int) debugTimestampInfoBean.getEncodeTime()), Long.valueOf(debugTimestampInfoBean.getSendTime())));
                                }
                            }
                        }
                        if (videoTSFrames != null && videoTSFrames.size() > 0) {
                            int intValue3 = this.mDebugBean.videoWriteSerial.intValue();
                            this.mDebugBean.videoReadSerial.set(intValue3);
                            for (int intValue4 = this.mDebugBean.videoReadSerial.intValue(); intValue4 < intValue3; intValue4++) {
                                if (videoTSFrames.containsKey(Integer.valueOf(intValue4))) {
                                    DebugTimestampInfoBean debugTimestampInfoBean2 = videoTSFrames.get(Integer.valueOf(intValue4));
                                    videoTSFrames.remove(Integer.valueOf(intValue4), debugTimestampInfoBean2);
                                    SourceLog.i("MirrorVideo", String.format("serial: %d, init mediacodec time: %d, send time: %d", Integer.valueOf(debugTimestampInfoBean2.getSerial()), Long.valueOf(debugTimestampInfoBean2.getCaptureTS()), Long.valueOf(debugTimestampInfoBean2.getSendTime())));
                                }
                            }
                        }
                        i11 = 0;
                    } catch (Exception e11) {
                        e = e11;
                        i10 = 0;
                        e.printStackTrace();
                        i11 = i10;
                    }
                }
                try {
                    Thread.sleep(1000L);
                } catch (Exception e12) {
                    i10 = i11;
                    e = e12;
                    e.printStackTrace();
                    i11 = i10;
                }
            }
        }
    }

    public void startThread() {
        this.status = 1;
    }

    public void stopThread() {
        try {
            this.status = 0;
            this.mDebugBean.getAudioTSFrames().clear();
            this.mDebugBean.getVideoTSFrames().clear();
            this.mDebugBean.audioWriteSerial.set(0);
            this.mDebugBean.videoWriteSerial.set(0);
            this.mDebugBean.audioReadSerial.set(1);
            this.mDebugBean.videoReadSerial.set(1);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
