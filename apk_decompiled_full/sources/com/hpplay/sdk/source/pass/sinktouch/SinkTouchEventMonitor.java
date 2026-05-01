package com.hpplay.sdk.source.pass.sinktouch;

import android.content.Context;
import com.hpplay.sdk.source.api.LelinkAccessibilityService;
import com.hpplay.sdk.source.bean.SinkTouchEvent;
import com.hpplay.sdk.source.bean.SinkTouchEventArea;
import com.hpplay.sdk.source.business.cloud.SourceDataReport;
import com.hpplay.sdk.source.log.SourceLog;
import com.hpplay.sdk.source.pass.Parser;
import com.hpplay.sdk.source.pass.PassSender;
import com.hpplay.sdk.source.pass.bean.SinkTouchEventInfoBean;

/* loaded from: classes3.dex */
public class SinkTouchEventMonitor {
    private static final String TAG = "SinkTouchEventMonitor";
    private static SinkTouchEventMonitor sInstance;
    private Context mContext = null;
    private float mScaleModulus;
    private SinkTouchEventTcpChannel mTcpChannel;
    private SinkTouchEventArea mTouchEventArea;

    private SinkTouchEventMonitor() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createMonitorChannel(SinkTouchEventInfoBean sinkTouchEventInfoBean) {
        if (sinkTouchEventInfoBean == null) {
            SourceLog.w(TAG, "createMonitorChannel: infoBean is null!");
            return;
        }
        int i10 = sinkTouchEventInfoBean.tcpChannelPort;
        if (i10 != 0) {
            createTcpMonitorChannel(i10, sinkTouchEventInfoBean.ip);
        } else {
            createUdpMonitorChannel(sinkTouchEventInfoBean.udpChannelPort, sinkTouchEventInfoBean.ip);
        }
    }

    private void createTcpMonitorChannel(int i10, String str) {
        stopMonitor();
        SinkTouchEventTcpChannel sinkTouchEventTcpChannel = new SinkTouchEventTcpChannel(str, i10);
        this.mTcpChannel = sinkTouchEventTcpChannel;
        sinkTouchEventTcpChannel.setCallback(new ISinkTouchEventCallback() { // from class: com.hpplay.sdk.source.pass.sinktouch.SinkTouchEventMonitor.2
            @Override // com.hpplay.sdk.source.pass.sinktouch.ISinkTouchEventCallback
            public void onEventReceived(SinkTouchEvent sinkTouchEvent) {
                SourceLog.i(SinkTouchEventMonitor.TAG, "onEventReceived: " + sinkTouchEvent.toString());
                if (LelinkAccessibilityService.isServiceStart(SinkTouchEventMonitor.this.mContext) && !LelinkAccessibilityService.isForeground(SinkTouchEventMonitor.this.mContext)) {
                    GlobalSinkTouchEventTransformer.transformEvent(sinkTouchEvent);
                } else if (SinkTouchEventDispatcher.getInstance().canNotify()) {
                    SinkTouchEventTransformer.transformEvent(sinkTouchEvent);
                }
            }
        });
        this.mTcpChannel.startReceive();
    }

    private void createUdpMonitorChannel(int i10, String str) {
    }

    public static synchronized SinkTouchEventMonitor getInstance() {
        SinkTouchEventMonitor sinkTouchEventMonitor;
        synchronized (SinkTouchEventMonitor.class) {
            if (sInstance == null) {
                synchronized (SinkTouchEventMonitor.class) {
                    if (sInstance == null) {
                        sInstance = new SinkTouchEventMonitor();
                    }
                }
            }
            sinkTouchEventMonitor = sInstance;
        }
        return sinkTouchEventMonitor;
    }

    public void createIMMonitorChannel() {
        SourceLog.i(TAG, "createIMMonitorChannel");
        SinkTouchEventIMChannel.getInstance().setCallback(new ISinkTouchEventCallback() { // from class: com.hpplay.sdk.source.pass.sinktouch.SinkTouchEventMonitor.3
            @Override // com.hpplay.sdk.source.pass.sinktouch.ISinkTouchEventCallback
            public void onEventReceived(SinkTouchEvent sinkTouchEvent) {
                SourceLog.i(SinkTouchEventMonitor.TAG, "onEventReceived: " + sinkTouchEvent.toString());
                if (LelinkAccessibilityService.isServiceStart(SinkTouchEventMonitor.this.mContext) && !LelinkAccessibilityService.isForeground(SinkTouchEventMonitor.this.mContext)) {
                    GlobalSinkTouchEventTransformer.transformEvent(sinkTouchEvent);
                } else if (SinkTouchEventDispatcher.getInstance().canNotify()) {
                    SinkTouchEventTransformer.transformEvent(sinkTouchEvent);
                }
            }
        });
    }

    public SinkTouchEventArea getTouchEventArea() {
        return this.mTouchEventArea;
    }

    public float getTouchScaleModulus() {
        return this.mScaleModulus;
    }

    public void setTouchEventArea(SinkTouchEventArea sinkTouchEventArea) {
        this.mTouchEventArea = sinkTouchEventArea;
    }

    public void setTouchScaleModulus(float f10) {
        this.mScaleModulus = f10;
    }

    public void startMonitor(Context context, String str, final boolean z10) {
        this.mContext = context;
        Parser.getInstance().setOnSinkTouchEventInfoListener(new Parser.OnSinkTouchEventInfoListener() { // from class: com.hpplay.sdk.source.pass.sinktouch.SinkTouchEventMonitor.1
            @Override // com.hpplay.sdk.source.pass.Parser.OnSinkTouchEventInfoListener
            public void onInfo(SinkTouchEventInfoBean sinkTouchEventInfoBean) {
                SourceLog.i(SinkTouchEventMonitor.TAG, "startMonitor: " + sinkTouchEventInfoBean);
                if (sinkTouchEventInfoBean.status == 0) {
                    SinkTouchEventMonitor.this.createMonitorChannel(sinkTouchEventInfoBean);
                    if (z10) {
                        SourceDataReport.getInstance().onSinkTouchBuild(1, "");
                        return;
                    } else {
                        SourceDataReport.getInstance().onSinkTouchCloudBuild(1, "");
                        return;
                    }
                }
                SourceLog.w(SinkTouchEventMonitor.TAG, "startMonitor: sink start reverse controller channel failed!");
                if (z10) {
                    SourceDataReport.getInstance().onSinkTouchBuild(0, "");
                } else {
                    SourceDataReport.getInstance().onSinkTouchCloudBuild(0, "");
                }
            }
        });
        PassSender.getInstance().sendSinkTouchEvent(SinkTouchEventInfoBean.createSendBean().toJson(), str);
    }

    public void stopMonitor() {
        SinkTouchEventTcpChannel sinkTouchEventTcpChannel = this.mTcpChannel;
        if (sinkTouchEventTcpChannel != null) {
            sinkTouchEventTcpChannel.stopReceive();
            this.mTcpChannel = null;
        }
    }
}
