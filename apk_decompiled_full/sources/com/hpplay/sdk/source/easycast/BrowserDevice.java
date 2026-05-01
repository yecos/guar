package com.hpplay.sdk.source.easycast;

import android.text.TextUtils;
import com.hpplay.sdk.source.api.IBindSdkListener;
import com.hpplay.sdk.source.api.IConnectListener;
import com.hpplay.sdk.source.api.IRelevantInfoListener;
import com.hpplay.sdk.source.api.LelinkSourceSDK;
import com.hpplay.sdk.source.browse.api.IBrowseListener;
import com.hpplay.sdk.source.browse.api.LelinkServiceInfo;
import com.hpplay.sdk.source.log.SourceLog;
import com.raizlabs.android.dbflow.sql.language.Operator;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes3.dex */
public class BrowserDevice {
    public static String DONGLE_APP_ID = "14255,16963";
    public static final String PACKAGE_NAME_SINK_APP = "com.hpplay.happyplay.aw";
    private static final String TAG = "BrowserDevice";
    private static BrowserDevice sInstance;
    private List<LelinkServiceInfo> mBrowseList;
    private LelinkServiceInfo mSelectInfo;
    private IEasyDeviceListener mDeviceListener = null;
    private boolean isBindSuccess = false;
    private IBindSdkListener mBindSdkListener = new IBindSdkListener() { // from class: com.hpplay.sdk.source.easycast.BrowserDevice.1
        @Override // com.hpplay.sdk.source.api.IBindSdkListener
        public void onBindCallback(boolean z10) {
            SourceLog.i(BrowserDevice.TAG, "onBindCallback " + z10);
            BrowserDevice.this.isBindSuccess = z10;
            BrowserDevice.this.setPassThroughListener();
            if (BrowserDevice.this.isBindSuccess) {
                BrowserManager.getInstance().startBrowse();
            }
        }
    };
    private IBrowseListener mBrowseListener = new IBrowseListener() { // from class: com.hpplay.sdk.source.easycast.BrowserDevice.2
        @Override // com.hpplay.sdk.source.browse.api.IBrowseListener
        public void onBrowse(int i10, List<LelinkServiceInfo> list) {
            if (i10 == -1) {
                SourceLog.e(BrowserDevice.TAG, "授权失败");
                if (BrowserDevice.this.mDeviceListener != null) {
                    BrowserDevice.this.mDeviceListener.onBrowserResult(-1);
                    return;
                }
                return;
            }
            if (i10 == 2) {
                SourceLog.i(BrowserDevice.TAG, "搜索停止");
                if (BrowserDevice.this.mDeviceListener != null) {
                    BrowserDevice.this.mDeviceListener.onBrowserResult(2);
                }
            } else if (i10 == 3) {
                SourceLog.i(BrowserDevice.TAG, "搜索超时");
                if (BrowserDevice.this.mDeviceListener != null) {
                    BrowserDevice.this.mDeviceListener.onBrowserResult(3);
                }
            }
            BrowserDevice.this.mBrowseList = list;
            if (BrowserDevice.this.mDeviceListener != null) {
                BrowserDevice.this.mDeviceListener.onUpdateDevices(BrowserDevice.this.mBrowseList);
            }
        }
    };
    private IConnectListener mConnectListener = new IConnectListener() { // from class: com.hpplay.sdk.source.easycast.BrowserDevice.3
        @Override // com.hpplay.sdk.source.api.IConnectListener
        public void onConnect(LelinkServiceInfo lelinkServiceInfo, int i10) {
            String str;
            SourceLog.i(BrowserDevice.TAG, "onConnect:" + lelinkServiceInfo.getName());
            if (i10 == 1) {
                str = "Lelink";
            } else if (i10 == 3) {
                str = "DLNA";
            } else if (i10 == 4) {
                str = "IM";
            } else {
                str = "协议:" + i10;
            }
            SourceLog.i(BrowserDevice.TAG, str + "  " + lelinkServiceInfo.getName() + "连接成功");
            BrowserDevice.this.setSelectInfo(lelinkServiceInfo);
        }

        @Override // com.hpplay.sdk.source.api.IConnectListener
        public void onDisconnect(LelinkServiceInfo lelinkServiceInfo, int i10, int i11) {
            String str;
            if (lelinkServiceInfo == null) {
                return;
            }
            SourceLog.i(BrowserDevice.TAG, "onDisconnect:" + lelinkServiceInfo.getName() + " disConnectType:" + i10 + " extra:" + i11);
            if (i10 == 212012) {
                str = lelinkServiceInfo.getName() + "等待用户确认";
            } else if (i10 == 212000) {
                switch (i11) {
                    case 212013:
                        str = lelinkServiceInfo.getName() + "连接被拒绝";
                        break;
                    case 212014:
                        str = lelinkServiceInfo.getName() + "防骚扰响应超时";
                        break;
                    case 212015:
                        str = lelinkServiceInfo.getName() + "已被加入投屏黑名单";
                        break;
                    case 212016:
                    case 212017:
                    default:
                        str = lelinkServiceInfo.getName() + "连接断开";
                        break;
                    case 212018:
                        str = lelinkServiceInfo.getName() + "不在线";
                        break;
                }
            } else if (i10 != 212010) {
                str = null;
            } else if (i11 != 212018) {
                str = lelinkServiceInfo.getName() + "连接失败";
            } else {
                str = lelinkServiceInfo.getName() + "不在线";
            }
            if (TextUtils.isEmpty(str)) {
                str = "onDisconnect " + i10 + Operator.Operation.DIVISION + i11;
            }
            SourceLog.i(BrowserDevice.TAG, str);
            if (BrowserDevice.this.mDeviceListener != null) {
                BrowserDevice.this.mDeviceListener.onDisconnect(lelinkServiceInfo, i10, i11);
            }
        }
    };

    private BrowserDevice() {
    }

    private List<LelinkServiceInfo> filterLelink(List<LelinkServiceInfo> list) {
        try {
            Collections.sort(list, new Comparator<LelinkServiceInfo>() { // from class: com.hpplay.sdk.source.easycast.BrowserDevice.5
                @Override // java.util.Comparator
                public int compare(LelinkServiceInfo lelinkServiceInfo, LelinkServiceInfo lelinkServiceInfo2) {
                    return (lelinkServiceInfo == null || lelinkServiceInfo2 == null || !lelinkServiceInfo.getTypes().equalsIgnoreCase("Lelink") || lelinkServiceInfo2.getTypes().equalsIgnoreCase("Lelink")) ? 0 : -1;
                }
            });
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
        return list;
    }

    private List<LelinkServiceInfo> filterSinkApk(List<LelinkServiceInfo> list) {
        try {
            Collections.sort(list, new Comparator<LelinkServiceInfo>() { // from class: com.hpplay.sdk.source.easycast.BrowserDevice.4
                @Override // java.util.Comparator
                public int compare(LelinkServiceInfo lelinkServiceInfo, LelinkServiceInfo lelinkServiceInfo2) {
                    if (lelinkServiceInfo != null && lelinkServiceInfo2 != null) {
                        if (BrowserDevice.isLeboSinkAPK(lelinkServiceInfo.getPackageName()) && BrowserDevice.isLeboSinkAPK(lelinkServiceInfo2.getPackageName())) {
                            if (BrowserDevice.this.isSelectInfo(lelinkServiceInfo)) {
                                return -1;
                            }
                        } else {
                            if (BrowserDevice.isLeboSinkAPK(lelinkServiceInfo.getPackageName()) && !BrowserDevice.isLeboSinkAPK(lelinkServiceInfo2.getPackageName())) {
                                return -1;
                            }
                            if (!BrowserDevice.isLeboSinkAPK(lelinkServiceInfo.getPackageName()) && !BrowserDevice.isLeboSinkAPK(lelinkServiceInfo2.getPackageName()) && BrowserDevice.this.isSelectInfo(lelinkServiceInfo)) {
                                return -1;
                            }
                        }
                    }
                    return 0;
                }
            });
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
        return list;
    }

    public static synchronized BrowserDevice getInstance() {
        synchronized (BrowserDevice.class) {
            synchronized (BrowserDevice.class) {
                if (sInstance == null) {
                    sInstance = new BrowserDevice();
                }
            }
            return sInstance;
        }
        return sInstance;
    }

    public static boolean isDongle(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (String str2 : DONGLE_APP_ID.split(",")) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isLeboSinkAPK(String str) {
        return !TextUtils.isEmpty(str) && PACKAGE_NAME_SINK_APP.equalsIgnoreCase(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPassThroughListener() {
        LelinkSourceSDK.getInstance().setPassThroughListener(new IRelevantInfoListener() { // from class: com.hpplay.sdk.source.easycast.BrowserDevice.6
            @Override // com.hpplay.sdk.source.api.IRelevantInfoListener
            public void onReverseInfoResult(int i10, String str) {
                SourceLog.i(BrowserDevice.TAG, "onReverseInfoResult option = " + i10 + ", result = " + str);
            }

            @Override // com.hpplay.sdk.source.api.IRelevantInfoListener
            public void onSendRelevantInfoResult(int i10, String str) {
            }
        });
    }

    public void clearBrowseList() {
        try {
            List<LelinkServiceInfo> list = this.mBrowseList;
            if (list != null) {
                list.clear();
            }
        } catch (Exception e10) {
            SourceLog.w(TAG, e10);
        }
    }

    public IBindSdkListener getBindListener() {
        return this.mBindSdkListener;
    }

    public List<LelinkServiceInfo> getBrowseList() {
        return this.mBrowseList;
    }

    public IBrowseListener getBrowseListener() {
        return this.mBrowseListener;
    }

    public IConnectListener getConnectListener() {
        return this.mConnectListener;
    }

    public LelinkServiceInfo getSelectInfo() {
        return this.mSelectInfo;
    }

    public boolean isBindSuccess() {
        return this.isBindSuccess;
    }

    public boolean isSelectInfo(LelinkServiceInfo lelinkServiceInfo) {
        if (lelinkServiceInfo != null && this.mSelectInfo != null) {
            if (TextUtils.equals(lelinkServiceInfo.getIp() + lelinkServiceInfo.getName() + lelinkServiceInfo.getUid(), this.mSelectInfo.getIp() + this.mSelectInfo.getName() + this.mSelectInfo.getUid())) {
                return true;
            }
        }
        return false;
    }

    public List<LelinkServiceInfo> serviceListSort(List<LelinkServiceInfo> list) {
        return (list == null || list.size() <= 1) ? list : filterSinkApk(filterLelink(list));
    }

    public void setDeviceListener(IEasyDeviceListener iEasyDeviceListener) {
        this.mDeviceListener = iEasyDeviceListener;
    }

    public void setSelectInfo(LelinkServiceInfo lelinkServiceInfo) {
        this.mSelectInfo = lelinkServiceInfo;
    }
}
