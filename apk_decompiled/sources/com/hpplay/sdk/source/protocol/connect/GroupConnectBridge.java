package com.hpplay.sdk.source.protocol.connect;

import android.util.SparseArray;
import com.hpplay.component.modulelinker.api.ModuleLinker;
import com.hpplay.sdk.source.api.IConnectListener;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.browse.data.BrowserInfo;
import com.hpplay.sdk.source.log.SourceLog;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class GroupConnectBridge extends ConnectBridge {
    public static final int CONNECT_TIME_OUT = 2000;
    public static final int STATE_CONNECTED = 1;
    public static final int STATE_CONNECT_FAILED = 2;
    public static final int STATE_IDLE = 0;
    public static final String TAG = "ConnectGroupBridge";
    private LelinkServiceInfo mInfo;
    private IConnectListener mOuterListener;
    private int mReconnect;
    private IConnectListener mReconnectListener;
    private ReconnectTask mReconnectTask;
    private ConnectWaitTask mWaitTask;
    private final AtomicInteger mLocalConnectState = new AtomicInteger();
    private final AtomicInteger mCloudConnectState = new AtomicInteger();
    private final Timer mTimer = new Timer();
    private final SparseArray<ConnectBridge> mConnectionBridges = new SparseArray<>();
    private boolean isDisconnected = false;
    private int mCurrentType = 0;
    private final IConnectListener mLocalConnectListener = new IConnectListener() { // from class: com.hpplay.sdk.source.protocol.connect.GroupConnectBridge.1
        @Override // com.hpplay.sdk.source.api.IConnectListener
        public void onConnect(LelinkServiceInfo lelinkServiceInfo, int i10) {
            SourceLog.i(GroupConnectBridge.TAG, " local LocalConnectListener onConnect ");
            GroupConnectBridge.this.mLocalConnectState.set(1);
            GroupConnectBridge groupConnectBridge = GroupConnectBridge.this;
            groupConnectBridge.mConnectProtocol = 1;
            groupConnectBridge.onConnectCallback(lelinkServiceInfo, i10);
        }

        @Override // com.hpplay.sdk.source.api.IConnectListener
        public void onDisconnect(LelinkServiceInfo lelinkServiceInfo, int i10, int i11) {
            SourceLog.i(GroupConnectBridge.TAG, " local LocalConnectListener onDisconnect ");
            if (GroupConnectBridge.this.mCloudConnectState.get() == 1 && GroupConnectBridge.this.mLocalConnectState.get() == 1) {
                GroupConnectBridge.this.mLocalConnectState.set(2);
            } else {
                GroupConnectBridge.this.onDisconnectCallback(lelinkServiceInfo, i10, i11);
            }
        }
    };
    private final IConnectListener mCloudConnectListener = new IConnectListener() { // from class: com.hpplay.sdk.source.protocol.connect.GroupConnectBridge.2
        @Override // com.hpplay.sdk.source.api.IConnectListener
        public void onConnect(LelinkServiceInfo lelinkServiceInfo, int i10) {
            SourceLog.i(GroupConnectBridge.TAG, "cloud CloudConnectListener onConnect ");
            GroupConnectBridge.this.mCloudConnectState.set(1);
            GroupConnectBridge groupConnectBridge = GroupConnectBridge.this;
            groupConnectBridge.mConnectProtocol = 4;
            groupConnectBridge.onConnectCallback(lelinkServiceInfo, i10);
        }

        @Override // com.hpplay.sdk.source.api.IConnectListener
        public void onDisconnect(LelinkServiceInfo lelinkServiceInfo, int i10, int i11) {
            if (i10 == 212012) {
                SourceLog.i(GroupConnectBridge.TAG, " cloud CloudConnectListener WHAT_HARASS_WAITING ");
                if (GroupConnectBridge.this.mOuterListener != null) {
                    GroupConnectBridge.this.mOuterListener.onDisconnect(lelinkServiceInfo, i10, i11);
                    return;
                }
                return;
            }
            SourceLog.i(GroupConnectBridge.TAG, " cloud CloudConnectListener onDisconnect ");
            if (GroupConnectBridge.this.mCloudConnectState.get() == 1 && GroupConnectBridge.this.mLocalConnectState.get() == 1) {
                GroupConnectBridge.this.mCloudConnectState.set(2);
            } else {
                GroupConnectBridge.this.onDisconnectCallback(lelinkServiceInfo, i10, i11);
            }
        }
    };
    private final IConnectListener wifiReconnectConnectListener = new IConnectListener() { // from class: com.hpplay.sdk.source.protocol.connect.GroupConnectBridge.3
        @Override // com.hpplay.sdk.source.api.IConnectListener
        public void onConnect(LelinkServiceInfo lelinkServiceInfo, int i10) {
            if (i10 == 5) {
                GroupConnectBridge groupConnectBridge = GroupConnectBridge.this;
                groupConnectBridge.mConnectProtocol = 1;
                groupConnectBridge.mLocalConnectState.set(1);
            } else {
                GroupConnectBridge groupConnectBridge2 = GroupConnectBridge.this;
                groupConnectBridge2.mConnectProtocol = 4;
                groupConnectBridge2.mCloudConnectState.set(1);
            }
            if (GroupConnectBridge.this.mLocalConnectState.get() == 1 && GroupConnectBridge.this.mCloudConnectState.get() == 1) {
                GroupConnectBridge.this.mConnectProtocol = 6;
            }
            SourceLog.i(GroupConnectBridge.TAG, "=======wifiReconnectConnectListener onConnect =========>>> " + i10 + "  mConnectProtocol: " + GroupConnectBridge.this.mConnectProtocol);
            GroupConnectBridge.this.setLocalWifi();
        }

        @Override // com.hpplay.sdk.source.api.IConnectListener
        public void onDisconnect(LelinkServiceInfo lelinkServiceInfo, int i10, int i11) {
            SourceLog.i(GroupConnectBridge.TAG, "================>>onDisconnect> ");
        }
    };
    public IConnectListener reconnectListener = new IConnectListener() { // from class: com.hpplay.sdk.source.protocol.connect.GroupConnectBridge.4
        @Override // com.hpplay.sdk.source.api.IConnectListener
        public void onConnect(LelinkServiceInfo lelinkServiceInfo, int i10) {
            if (i10 == 5) {
                GroupConnectBridge groupConnectBridge = GroupConnectBridge.this;
                groupConnectBridge.mConnectProtocol = 1;
                groupConnectBridge.mLocalConnectState.set(1);
            } else {
                GroupConnectBridge groupConnectBridge2 = GroupConnectBridge.this;
                groupConnectBridge2.mConnectProtocol = 4;
                groupConnectBridge2.mCloudConnectState.set(1);
                GroupConnectBridge.this.stopWaitReconnectTask();
            }
            if (GroupConnectBridge.this.mLocalConnectState.get() == 1 && GroupConnectBridge.this.mCloudConnectState.get() == 1) {
                GroupConnectBridge.this.mConnectProtocol = 6;
            }
            SourceLog.i(GroupConnectBridge.TAG, " group reconnect successful " + i10 + "  " + GroupConnectBridge.this.mConnectProtocol);
            GroupConnectBridge.this.setLocalWifi();
            if (GroupConnectBridge.this.mReconnectListener != null) {
                GroupConnectBridge.this.mReconnectListener.onConnect(lelinkServiceInfo, i10);
            }
        }

        @Override // com.hpplay.sdk.source.api.IConnectListener
        public void onDisconnect(LelinkServiceInfo lelinkServiceInfo, int i10, int i11) {
            SourceLog.i(GroupConnectBridge.TAG, " group reconnect failed");
            GroupConnectBridge.this.mLocalConnectState.set(2);
            if (GroupConnectBridge.this.mReconnectListener != null) {
                GroupConnectBridge.this.mReconnectListener.onDisconnect(lelinkServiceInfo, i10, i11);
            }
        }
    };

    public class ConnectWaitTask extends TimerTask {
        public ConnectWaitTask() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            SourceLog.i(GroupConnectBridge.TAG, "ConnectWaitTask time out");
            if (GroupConnectBridge.this.isDisconnected) {
                return;
            }
            if (GroupConnectBridge.this.isConnectConnected()) {
                try {
                    GroupConnectBridge.this.chooseConnectBridge();
                    GroupConnectBridge groupConnectBridge = GroupConnectBridge.this;
                    groupConnectBridge.connectedListenerCallback(groupConnectBridge.mInfo, GroupConnectBridge.this.mConnectProtocol);
                    return;
                } catch (Exception e10) {
                    SourceLog.w(GroupConnectBridge.TAG, e10);
                    return;
                }
            }
            if (GroupConnectBridge.this.mReconnect < 1) {
                try {
                    ((CloudConnectBridge) ((ConnectBridge) GroupConnectBridge.this.mConnectionBridges.get(4)).mConnectBridge).reconnectServer();
                } catch (Exception e11) {
                    SourceLog.w(GroupConnectBridge.TAG, e11);
                    GroupConnectBridge groupConnectBridge2 = GroupConnectBridge.this;
                    groupConnectBridge2.disconnectedListenerCallback(groupConnectBridge2.mInfo, 212010, 212011);
                }
            } else {
                GroupConnectBridge groupConnectBridge3 = GroupConnectBridge.this;
                groupConnectBridge3.disconnectedListenerCallback(groupConnectBridge3.mInfo, 212010, 212011);
            }
            GroupConnectBridge.access$1308(GroupConnectBridge.this);
        }
    }

    public class ReconnectTask extends TimerTask {
        public ReconnectTask() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                SourceLog.w(GroupConnectBridge.TAG, "ReconnectTask  restart server ");
                ((CloudConnectBridge) ((ConnectBridge) GroupConnectBridge.this.mConnectionBridges.get(4)).mConnectBridge).reconnectServer();
            } catch (Exception e10) {
                SourceLog.w(GroupConnectBridge.TAG, e10);
            }
        }
    }

    public static /* synthetic */ int access$1308(GroupConnectBridge groupConnectBridge) {
        int i10 = groupConnectBridge.mReconnect;
        groupConnectBridge.mReconnect = i10 + 1;
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void chooseConnectBridge() {
        if (this.mConnectProtocol == 4) {
            this.mConnectBridge = this.mConnectionBridges.get(4).mConnectBridge;
        } else {
            this.mConnectBridge = this.mConnectionBridges.get(1).mConnectBridge;
        }
    }

    private void connectWait(long j10) {
        stopWaitTask();
        ConnectWaitTask connectWaitTask = new ConnectWaitTask();
        this.mWaitTask = connectWaitTask;
        this.mTimer.schedule(connectWaitTask, j10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void connectedListenerCallback(LelinkServiceInfo lelinkServiceInfo, int i10) {
        SourceLog.i(TAG, " connectedListenerCallback ");
        setLocalWifi();
        IConnectListener iConnectListener = this.mOuterListener;
        if (iConnectListener != null) {
            iConnectListener.onConnect(lelinkServiceInfo, i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void disconnectedListenerCallback(LelinkServiceInfo lelinkServiceInfo, int i10, int i11) {
        SourceLog.i(TAG, "disconnectedListenerCallback ");
        IConnectListener iConnectListener = this.mOuterListener;
        if (iConnectListener != null) {
            iConnectListener.onDisconnect(lelinkServiceInfo, i10, i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isConnectConnected() {
        return this.mLocalConnectState.get() == 1 || this.mCloudConnectState.get() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onConnectCallback(LelinkServiceInfo lelinkServiceInfo, int i10) {
        SourceLog.i(TAG, "---------------->> onConnectCallback local:" + this.mLocalConnectState.get() + " cloud:" + this.mCloudConnectState.get());
        if (this.mLocalConnectState.get() == 0 || this.mCloudConnectState.get() == 0) {
            return;
        }
        stopWaitTask();
        if (this.mLocalConnectState.get() == 1 && this.mCloudConnectState.get() == 1) {
            SourceLog.i(TAG, "all connected ...");
            this.mConnectProtocol = 6;
            chooseConnectBridge();
            connectedListenerCallback(lelinkServiceInfo, i10);
            return;
        }
        if (this.mCloudConnectState.get() == 1 || this.mLocalConnectState.get() == 1) {
            this.mConnectProtocol = i10;
            chooseConnectBridge();
            connectedListenerCallback(lelinkServiceInfo, i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onDisconnectCallback(LelinkServiceInfo lelinkServiceInfo, int i10, int i11) {
        SourceLog.i(TAG, "onDisconnectCallback local:" + this.mLocalConnectState.get() + " cloud:" + this.mCloudConnectState.get() + " " + i10 + Operator.Operation.DIVISION + i11);
        if (this.mLocalConnectState.get() == 0 || this.mCloudConnectState.get() == 0) {
            return;
        }
        stopWaitTask();
        if (this.mLocalConnectState.get() == 2 && this.mCloudConnectState.get() == 2) {
            disconnectedListenerCallback(lelinkServiceInfo, i10, i11);
            return;
        }
        if (this.mLocalConnectState.get() == 1) {
            this.mConnectProtocol = 1;
            connectedListenerCallback(lelinkServiceInfo, 1);
        } else if (this.mCloudConnectState.get() == 1) {
            this.mConnectProtocol = 4;
            connectedListenerCallback(lelinkServiceInfo, 4);
        }
    }

    private void reconnectWait(long j10) {
        stopWaitTask();
        ReconnectTask reconnectTask = new ReconnectTask();
        this.mReconnectTask = reconnectTask;
        this.mTimer.schedule(reconnectTask, j10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLocalWifi() {
        try {
            boolean z10 = true;
            BrowserInfo browserInfo = this.mInfo.getBrowserInfos().get(1);
            if (browserInfo != null) {
                if (this.mLocalConnectState.get() != 1) {
                    z10 = false;
                }
                browserInfo.setLocalWifi(z10);
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
    }

    @Override // com.hpplay.sdk.source.protocol.connect.ConnectBridge
    public void connect(LelinkServiceInfo lelinkServiceInfo) {
        SourceLog.i(TAG, "  ConnectGroupBridge connect");
        this.mReconnect = 0;
        this.mLocalConnectState.set(0);
        this.mCloudConnectState.set(0);
        disconnect();
        this.isDisconnected = false;
        this.mConnectBridge = null;
        this.isGroup = true;
        this.mInfo = lelinkServiceInfo;
        ConnectBridge connectBridge = new ConnectBridge(ModuleLinker.getInstance().getContext(), 1);
        connectBridge.setConnectListener(this.mLocalConnectListener);
        connectBridge.setGroupConnect(true);
        connectBridge.connect(lelinkServiceInfo);
        this.mConnectBridge = connectBridge.mConnectBridge;
        this.mConnectionBridges.put(1, connectBridge);
        if (lelinkServiceInfo.getBrowserInfos().get(1) == null) {
            this.mLocalConnectState.set(2);
        }
        ConnectBridge connectBridge2 = new ConnectBridge(ModuleLinker.getInstance().getContext(), 4);
        connectBridge2.setConnectListener(this.mCloudConnectListener);
        connectBridge2.setGroupConnect(true);
        connectBridge2.connect(lelinkServiceInfo);
        connectWait(2000L);
        this.mConnectionBridges.put(4, connectBridge2);
        if (lelinkServiceInfo.getBrowserInfos().get(4) == null) {
            this.mCloudConnectState.set(2);
        }
    }

    public void disconnect() {
        try {
            this.isDisconnected = true;
            SourceLog.i(TAG, this.mConnectionBridges.size() + "  disconnect ");
            for (int i10 = 0; i10 < this.mConnectionBridges.size(); i10++) {
                this.mConnectionBridges.valueAt(i10).setConnectListener(null);
                this.mConnectionBridges.valueAt(i10).disconnect(2);
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
        this.mConnectionBridges.clear();
        this.mConnectProtocol = -1;
    }

    @Override // com.hpplay.sdk.source.protocol.connect.ConnectBridge
    public LelinkServiceInfo getServiceInfo() {
        return this.mInfo;
    }

    public void groupReconnect(int i10, LelinkServiceInfo lelinkServiceInfo, IConnectListener iConnectListener) {
        this.mInfo = lelinkServiceInfo;
        this.mReconnect = 0;
        try {
            this.mLocalConnectState.set(0);
            this.mReconnectListener = iConnectListener;
            for (int i11 = 0; i11 < this.mConnectionBridges.size(); i11++) {
                this.mConnectionBridges.valueAt(i11).setConnectListener(null);
            }
            SourceLog.i(TAG, "==reconnect type ==" + i10);
            ConnectBridge connectBridge = this.mConnectionBridges.get(i10);
            this.mConnectBridge = connectBridge.mConnectBridge;
            connectBridge.setConnectListener(this.reconnectListener);
            connectBridge.connect(lelinkServiceInfo);
            if (i10 == 4) {
                reconnectWait(3000L);
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
            if (iConnectListener != null) {
                iConnectListener.onDisconnect(lelinkServiceInfo, 212000, 212010);
            }
            disconnectedListenerCallback(lelinkServiceInfo, 212000, 212010);
        }
    }

    @Override // com.hpplay.sdk.source.protocol.connect.ConnectBridge
    public boolean isConnected() {
        return this.mLocalConnectState.get() == 1 || this.mCloudConnectState.get() == 1;
    }

    @Override // com.hpplay.sdk.source.protocol.connect.ConnectBridge
    public void release() {
        SourceLog.i(TAG, "release " + this.mConnectionBridges.size());
        for (int i10 = 0; i10 < this.mConnectionBridges.size(); i10++) {
            try {
                this.mConnectionBridges.valueAt(i10).release();
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
            }
        }
        this.mConnectionBridges.clear();
        this.mConnectProtocol = -1;
        this.mOuterListener = null;
    }

    @Override // com.hpplay.sdk.source.protocol.connect.ConnectBridge
    public void setConnectListener(IConnectListener iConnectListener) {
        this.mOuterListener = iConnectListener;
    }

    public void stopWaitReconnectTask() {
        SourceLog.i(TAG, " stopTask ");
        ReconnectTask reconnectTask = this.mReconnectTask;
        if (reconnectTask != null) {
            reconnectTask.cancel();
            this.mTimer.purge();
        }
    }

    public void stopWaitTask() {
        SourceLog.i(TAG, " stopTask ");
        ConnectWaitTask connectWaitTask = this.mWaitTask;
        if (connectWaitTask != null) {
            connectWaitTask.cancel();
            this.mTimer.purge();
        }
    }

    public void switchGroupConnection(int i10) {
        try {
            this.mConnectBridge = this.mConnectionBridges.get(i10).mConnectBridge;
            this.mConnectProtocol = i10;
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
    }

    public void groupReconnect() {
        SourceLog.i(TAG, "=======groupReconnect all " + this.mConnectionBridges.size());
        this.mConnectProtocol = -1;
        this.mLocalConnectState.set(2);
        this.mCloudConnectState.set(2);
        for (int i10 = 0; i10 < this.mConnectionBridges.size(); i10++) {
            this.mConnectionBridges.valueAt(i10).setConnectListener(this.wifiReconnectConnectListener);
            this.mConnectionBridges.valueAt(i10).connect(this.mInfo);
        }
    }
}
