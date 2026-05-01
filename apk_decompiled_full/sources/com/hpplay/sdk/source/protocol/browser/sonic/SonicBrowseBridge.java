package com.hpplay.sdk.source.protocol.browser.sonic;

import android.content.Context;
import android.text.TextUtils;
import com.hpplay.component.common.browse.IBrowseResultListener;
import com.hpplay.component.common.sonic.ISonicController;
import com.hpplay.component.common.utils.ModuleIds;
import com.hpplay.component.modulelinker.api.ModuleLinker;
import com.hpplay.sdk.source.browse.api.IServiceInfoParseListener;
import com.hpplay.sdk.source.config.LelinkConfig;
import com.hpplay.sdk.source.device.Device;
import com.hpplay.sdk.source.device.ServiceUpdater;
import com.hpplay.sdk.source.log.SourceLog;

/* loaded from: classes3.dex */
public class SonicBrowseBridge {
    private static final String TAG = "SonicBrowseBridge";
    private static SonicBrowseBridge sInstance;
    private ModuleLinker mModuleLinker;
    private IServiceInfoParseListener mServiceInfoParseListener;
    private ISonicController mSonicController;
    private boolean isStop = true;
    private boolean isBrowserSuccess = false;
    private final IBrowseResultListener mSonicPinBrowseListener = new IBrowseResultListener() { // from class: com.hpplay.sdk.source.protocol.browser.sonic.SonicBrowseBridge.1
        @Override // com.hpplay.component.common.browse.IBrowseResultListener
        public void onBrowseResultCallback(int i10, Object obj) {
            if (!SonicBrowseBridge.this.isStop && i10 == 3) {
                String str = (String) obj;
                if (TextUtils.isEmpty(str)) {
                    SourceLog.w(SonicBrowseBridge.TAG, "onBrowseResultCallback: sonicPin is empty");
                } else {
                    Device.addDeviceCodeServiceInfo(str, 9, SonicBrowseBridge.this.mServiceInfoParseListener);
                }
            }
        }
    };

    private SonicBrowseBridge() {
        if (LelinkConfig.isSupportSonic()) {
            try {
                ModuleLinker newInstance = ModuleLinker.getNewInstance();
                this.mModuleLinker = newInstance;
                this.mSonicController = (ISonicController) newInstance.loadModule(ModuleIds.CLAZZ_ID741_SONICCONTROLIMP);
            } catch (Exception e10) {
                SourceLog.w(TAG, e10);
            }
        }
    }

    public static synchronized SonicBrowseBridge getInstance() {
        SonicBrowseBridge sonicBrowseBridge;
        synchronized (SonicBrowseBridge.class) {
            if (sInstance == null) {
                synchronized (SonicBrowseBridge.class) {
                    if (sInstance == null) {
                        sInstance = new SonicBrowseBridge();
                    }
                }
            }
            sonicBrowseBridge = sInstance;
        }
        return sonicBrowseBridge;
    }

    public boolean isBrowserSuccess() {
        return this.isBrowserSuccess;
    }

    public void release() {
        ModuleLinker moduleLinker = this.mModuleLinker;
        if (moduleLinker != null) {
            moduleLinker.removeObjOfMemory(ModuleIds.CLAZZ_ID1088_PUSHCONTROLLERIMPL);
            this.mModuleLinker = null;
        }
    }

    public void setServiceInfoParseListener(IServiceInfoParseListener iServiceInfoParseListener) {
        this.mServiceInfoParseListener = iServiceInfoParseListener;
    }

    public boolean startBrowse(Context context) {
        if (this.mSonicController == null) {
            SourceLog.i(TAG, "startBrowse ignore");
            return false;
        }
        SourceLog.i(TAG, "startBrowse");
        this.isStop = false;
        this.mSonicController.startSonicBrowse(this.mSonicPinBrowseListener, new int[0]);
        this.isBrowserSuccess = true;
        ServiceUpdater.getInstance().updateServiceInfo(context);
        return this.isBrowserSuccess;
    }

    public void stopBrowse(Context context) {
        if (this.mSonicController == null) {
            SourceLog.i(TAG, "stopBrowse ignore");
            return;
        }
        if (this.isStop) {
            return;
        }
        SourceLog.i(TAG, "stopBrowse");
        this.isStop = true;
        this.isBrowserSuccess = false;
        this.mSonicController.stop();
        ServiceUpdater.getInstance().updateServiceInfo(context);
    }
}
